/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Properties;
/*     */ import java.util.jar.JarInputStream;
/*     */ import java.util.jar.JarOutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ 
/*     */ public class Builder
/*     */ {
/* 611 */   File outputDirectory = null;
/*     */ 
/* 614 */   String outputName = null;
/*     */ 
/* 616 */   String jarPrefix = null;
/*     */ 
/* 618 */   boolean compile = true;
/*     */ 
/* 620 */   boolean header = false;
/*     */ 
/* 622 */   boolean copyLibs = false;
/*     */ 
/* 624 */   Properties properties = null;
/*     */ 
/* 626 */   ClassScanner classScanner = null;
/*     */ 
/* 628 */   Map<String, String> environmentVariables = null;
/*     */ 
/* 630 */   Collection<String> compilerOptions = null;
/*     */ 
/*     */   public File parse(Class cls)
/*     */     throws IOException, Parser.Exception
/*     */   {
/*  66 */     Parser.InfoMap infoMap = new Parser.InfoMap();
/*     */     try {
/*  68 */       Object obj = cls.newInstance();
/*  69 */       if ((obj instanceof Parser.InfoMapper))
/*  70 */         ((Parser.InfoMapper)obj).map(infoMap);
/*     */     }
/*     */     catch (InstantiationException e) {
/*     */     }
/*     */     catch (IllegalAccessException e) {
/*     */     }
/*  76 */     return new Parser(this.properties, infoMap).parse(this.outputDirectory, cls);
/*     */   }
/*     */ 
/*     */   public static void includeJavaPaths(Loader.ClassProperties properties, boolean header)
/*     */   {
/*  87 */     String platformName = Loader.getPlatformName();
/*  88 */     final String jvmlink = properties.getProperty("compiler.link.prefix", "") + "jvm" + properties.getProperty("compiler.link.suffix", "");
/*     */ 
/*  90 */     final String jvmlib = properties.getProperty("library.prefix", "") + "jvm" + properties.getProperty("library.suffix", "");
/*     */ 
/*  92 */     String[] jnipath = new String[2];
/*  93 */     final String[] jvmpath = new String[2];
/*  94 */     FilenameFilter filter = new FilenameFilter() {
/*     */       public boolean accept(File dir, String name) {
/*  96 */         if (new File(dir, "jni.h").exists()) {
/*  97 */           this.val$jnipath[0] = dir.getAbsolutePath();
/*     */         }
/*  99 */         if (new File(dir, "jni_md.h").exists()) {
/* 100 */           this.val$jnipath[1] = dir.getAbsolutePath();
/*     */         }
/* 102 */         if (new File(dir, jvmlink).exists()) {
/* 103 */           jvmpath[0] = dir.getAbsolutePath();
/*     */         }
/* 105 */         if (new File(dir, jvmlib).exists()) {
/* 106 */           jvmpath[1] = dir.getAbsolutePath();
/*     */         }
/* 108 */         return new File(dir, name).isDirectory();
/*     */       }
/*     */     };
/* 111 */     File javaHome = new File(System.getProperty("java.home")).getParentFile();
/*     */     try {
/* 113 */       javaHome = javaHome.getCanonicalFile(); } catch (IOException e) {
/*     */     }
/* 115 */     LinkedList dirs = new LinkedList(Arrays.asList(javaHome.listFiles(filter)));
/* 116 */     while (!dirs.isEmpty()) {
/* 117 */       File d = (File)dirs.pop();
/* 118 */       String dpath = d.getPath();
/* 119 */       for (File f : d.listFiles(filter)) {
/*     */         try {
/* 121 */           f = f.getCanonicalFile(); } catch (IOException e) {
/*     */         }
/* 123 */         if (!dpath.startsWith(f.getPath())) {
/* 124 */           dirs.add(f);
/*     */         }
/*     */       }
/*     */     }
/* 128 */     if ((jnipath[0] != null) && (jnipath[0].equals(jnipath[1]))) {
/* 129 */       jnipath[1] = null;
/* 130 */     } else if (jnipath[0] == null) {
/* 131 */       String macpath = "/System/Library/Frameworks/JavaVM.framework/Headers/";
/* 132 */       if (new File(macpath).isDirectory()) {
/* 133 */         jnipath[0] = macpath;
/*     */       }
/*     */     }
/* 136 */     if ((jvmpath[0] != null) && (jvmpath[0].equals(jvmpath[1]))) {
/* 137 */       jvmpath[1] = null;
/*     */     }
/* 139 */     properties.addAll("compiler.includepath", jnipath);
/* 140 */     if (platformName.equals(properties.getProperty("platform.name", platformName))) {
/* 141 */       if (header)
/*     */       {
/* 143 */         properties.get("compiler.link").add(0, "jvm");
/* 144 */         properties.addAll("compiler.linkpath", jvmpath);
/*     */       }
/* 146 */       if (platformName.startsWith("macosx"))
/* 147 */         properties.addAll("compiler.framework", new String[] { "JavaVM" });
/*     */     }
/*     */   }
/*     */ 
/*     */   public int compile(String sourceFilename, String outputFilename, Loader.ClassProperties properties)
/*     */     throws IOException, InterruptedException
/*     */   {
/* 191 */     LinkedList command = new LinkedList();
/*     */ 
/* 193 */     includeJavaPaths(properties, this.header);
/*     */ 
/* 195 */     String platformName = Loader.getPlatformName();
/* 196 */     String compilerPath = properties.getProperty("compiler.path");
/* 197 */     command.add(compilerPath);
/*     */ 
/* 200 */     String p = properties.getProperty("compiler.sysroot.prefix", "");
/* 201 */     for (String s : properties.get("compiler.sysroot")) {
/* 202 */       if (new File(s).isDirectory()) {
/* 203 */         if (p.endsWith(" ")) {
/* 204 */           command.add(p.trim()); command.add(s);
/*     */         } else {
/* 206 */           command.add(p + s);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 213 */     String p = properties.getProperty("compiler.includepath.prefix", "");
/* 214 */     for (String s : properties.get("compiler.includepath")) {
/* 215 */       if (new File(s).isDirectory()) {
/* 216 */         if (p.endsWith(" ")) {
/* 217 */           command.add(p.trim()); command.add(s);
/*     */         } else {
/* 219 */           command.add(p + s);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 225 */     command.add(sourceFilename);
/*     */ 
/* 227 */     Collection allOptions = properties.get("compiler.options");
/* 228 */     if (allOptions.isEmpty()) {
/* 229 */       allOptions.add("default");
/*     */     }
/* 231 */     for (String s : allOptions) {
/* 232 */       if ((s != null) && (s.length() != 0))
/*     */       {
/* 235 */         String p = "compiler.options." + s;
/* 236 */         String options = properties.getProperty(p);
/* 237 */         if ((options != null) && (options.length() > 0))
/* 238 */           command.addAll(Arrays.asList(options.split(" ")));
/* 239 */         else if (!"default".equals(s)) {
/* 240 */           System.err.println("Warning: Could not get the property named \"" + p + "\"");
/*     */         }
/*     */       }
/*     */     }
/* 244 */     command.addAll(this.compilerOptions);
/*     */ 
/* 246 */     String outputPrefix = properties.getProperty("compiler.output.prefix");
/* 247 */     if ((outputPrefix != null) && (outputPrefix.length() > 0)) {
/* 248 */       command.addAll(Arrays.asList(outputPrefix.split(" ")));
/*     */     }
/*     */ 
/* 251 */     if ((outputPrefix == null) || (outputPrefix.length() == 0) || (outputPrefix.endsWith(" ")))
/* 252 */       command.add(outputFilename);
/*     */     else {
/* 254 */       command.add((String)command.removeLast() + outputFilename);
/*     */     }
/*     */ 
/* 258 */     String p = properties.getProperty("compiler.linkpath.prefix", "");
/* 259 */     String p2 = properties.getProperty("compiler.linkpath.prefix2");
/* 260 */     for (String s : properties.get("compiler.linkpath")) {
/* 261 */       if (new File(s).isDirectory()) {
/* 262 */         if (p.endsWith(" ")) {
/* 263 */           command.add(p.trim()); command.add(s);
/*     */         } else {
/* 265 */           command.add(p + s);
/*     */         }
/* 267 */         if (p2 != null) {
/* 268 */           if (p2.endsWith(" ")) {
/* 269 */             command.add(p2.trim()); command.add(s);
/*     */           } else {
/* 271 */             command.add(p2 + s);
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 279 */     String p = properties.getProperty("compiler.link.prefix", "");
/* 280 */     String x = properties.getProperty("compiler.link.suffix", "");
/* 281 */     int i = command.size();
/* 282 */     for (String s : properties.get("compiler.link")) {
/* 283 */       String[] libnameversion = s.split("@");
/* 284 */       if ((libnameversion.length == 3) && (libnameversion[1].length() == 0))
/*     */       {
/* 286 */         s = libnameversion[0] + libnameversion[2];
/*     */       }
/* 288 */       else s = libnameversion[0];
/*     */ 
/* 290 */       if ((p.endsWith(" ")) && (x.startsWith(" "))) {
/* 291 */         command.add(i, p.trim()); command.add(i + 1, s); command.add(i + 2, x.trim());
/* 292 */       } else if (p.endsWith(" ")) {
/* 293 */         command.add(i, p.trim()); command.add(i + 1, s + x);
/* 294 */       } else if (x.startsWith(" ")) {
/* 295 */         command.add(i, p + s); command.add(i + 1, x.trim());
/*     */       } else {
/* 297 */         command.add(i, p + s + x);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 303 */     String p = properties.getProperty("compiler.framework.prefix", "");
/* 304 */     String x = properties.getProperty("compiler.framework.suffix", "");
/* 305 */     for (String s : properties.get("compiler.framework")) {
/* 306 */       if ((p.endsWith(" ")) && (x.startsWith(" "))) {
/* 307 */         command.add(p.trim()); command.add(s); command.add(x.trim());
/* 308 */       } else if (p.endsWith(" ")) {
/* 309 */         command.add(p.trim()); command.add(s + x);
/* 310 */       } else if (x.startsWith(" ")) {
/* 311 */         command.add(p + s); command.add(x.trim());
/*     */       } else {
/* 313 */         command.add(p + s + x);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 318 */     boolean windows = platformName.startsWith("windows");
/* 319 */     for (String s : command) {
/* 320 */       boolean hasSpaces = s.indexOf(" ") > 0;
/* 321 */       if (hasSpaces) {
/* 322 */         System.out.print(windows ? "\"" : "'");
/*     */       }
/* 324 */       System.out.print(s);
/* 325 */       if (hasSpaces) {
/* 326 */         System.out.print(windows ? "\"" : "'");
/*     */       }
/* 328 */       System.out.print(" ");
/*     */     }
/* 330 */     System.out.println();
/*     */ 
/* 332 */     ProcessBuilder pb = new ProcessBuilder(command);
/* 333 */     if (this.environmentVariables != null) {
/* 334 */       pb.environment().putAll(this.environmentVariables);
/*     */     }
/* 336 */     Process p = pb.start();
/* 337 */     new Piper(p.getErrorStream(), System.err).start();
/* 338 */     new Piper(p.getInputStream(), System.out).start();
/* 339 */     return p.waitFor();
/*     */   }
/*     */ 
/*     */   public File generateAndCompile(Class[] classes, String outputName)
/*     */     throws IOException, InterruptedException
/*     */   {
/* 353 */     File outputFile = null;
/* 354 */     Loader.ClassProperties p = Loader.loadProperties(classes, this.properties, true);
/* 355 */     String platformName = p.getProperty("platform.name");
/* 356 */     String sourceSuffix = p.getProperty("source.suffix", ".cpp");
/* 357 */     String libraryName = p.getProperty("library.prefix", "") + outputName + p.getProperty("library.suffix", "");
/*     */     File outputPath;
/*     */     String sourcePrefix;
/* 359 */     if (this.outputDirectory == null) {
/*     */       try {
/* 361 */         URL resourceURL = classes[0].getResource('/' + classes[0].getName().replace('.', '/') + ".class");
/* 362 */         File packageDir = new File(resourceURL.toURI()).getParentFile();
/* 363 */         outputPath = new File(packageDir, platformName);
/* 364 */         sourcePrefix = packageDir.getPath() + File.separator + outputName;
/*     */       } catch (URISyntaxException e) {
/* 366 */         throw new RuntimeException(e);
/*     */       }
/*     */     } else {
/* 369 */       outputPath = this.outputDirectory;
/* 370 */       sourcePrefix = outputPath.getPath() + File.separator + outputName;
/*     */     }
/* 372 */     if (!outputPath.exists()) {
/* 373 */       outputPath.mkdirs();
/*     */     }
/* 375 */     Generator generator = new Generator(p);
/* 376 */     String sourceFilename = sourcePrefix + sourceSuffix;
/* 377 */     String headerFilename = this.header ? sourcePrefix + ".h" : null;
/* 378 */     String classPath = System.getProperty("java.class.path");
/* 379 */     for (String s : this.classScanner.getClassLoader().getPaths()) {
/* 380 */       classPath = classPath + File.pathSeparator + s;
/*     */     }
/* 382 */     System.out.println("Generating source file: " + sourceFilename);
/* 383 */     if (generator.generate(sourceFilename, headerFilename, classPath, classes)) {
/* 384 */       generator.close();
/* 385 */       if (this.compile) {
/* 386 */         String libraryFilename = outputPath.getPath() + File.separator + libraryName;
/* 387 */         System.out.println("Compiling library file: " + libraryFilename);
/* 388 */         int exitValue = compile(sourceFilename, libraryFilename, p);
/* 389 */         if (exitValue == 0) {
/* 390 */           new File(sourceFilename).delete();
/* 391 */           outputFile = new File(libraryFilename);
/*     */         } else {
/* 393 */           System.exit(exitValue);
/*     */         }
/*     */       } else {
/* 396 */         outputFile = new File(sourceFilename);
/*     */       }
/*     */     } else {
/* 399 */       System.out.println("Source file not generated: " + sourceFilename);
/*     */     }
/* 401 */     return outputFile;
/*     */   }
/*     */ 
/*     */   public static void createJar(File jarFile, String[] classpath, File[] files)
/*     */     throws IOException
/*     */   {
/* 414 */     System.out.println("Creating JAR file: " + jarFile);
/* 415 */     JarOutputStream jos = new JarOutputStream(new FileOutputStream(jarFile));
/* 416 */     for (File f : files) {
/* 417 */       String name = f.getPath();
/* 418 */       if (classpath != null)
/*     */       {
/* 422 */         String[] names = new String[classpath.length];
/* 423 */         for (int i = 0; i < classpath.length; i++) {
/* 424 */           String path = new File(classpath[i]).getCanonicalPath();
/* 425 */           if (name.startsWith(path)) {
/* 426 */             names[i] = name.substring(path.length() + 1);
/*     */           }
/*     */         }
/*     */ 
/* 430 */         for (int i = 0; i < names.length; i++) {
/* 431 */           if ((names[i] != null) && (names[i].length() < name.length())) {
/* 432 */             name = names[i];
/*     */           }
/*     */         }
/*     */       }
/* 436 */       ZipEntry e = new ZipEntry(name.replace(File.separatorChar, '/'));
/* 437 */       e.setTime(f.lastModified());
/* 438 */       jos.putNextEntry(e);
/* 439 */       FileInputStream fis = new FileInputStream(f);
/* 440 */       byte[] buffer = new byte[1024];
/*     */       int length;
/* 442 */       while ((length = fis.read(buffer)) != -1) {
/* 443 */         jos.write(buffer, 0, length);
/*     */       }
/* 445 */       fis.close();
/* 446 */       jos.closeEntry();
/*     */     }
/*     */ 
/* 450 */     jos.close();
/*     */   }
/*     */ 
/*     */   public Builder()
/*     */   {
/* 602 */     Loader.loadLibraries = false;
/* 603 */     this.properties = Loader.loadProperties();
/* 604 */     this.classScanner = new ClassScanner(new LinkedList(), new UserClassLoader(Thread.currentThread().getContextClassLoader()));
/*     */ 
/* 606 */     this.compilerOptions = new LinkedList();
/*     */   }
/*     */ 
/*     */   public Builder classPaths(String classPaths)
/*     */   {
/* 634 */     classPaths(classPaths == null ? null : classPaths.split(File.pathSeparator));
/* 635 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder classPaths(String[] classPaths) {
/* 639 */     this.classScanner.getClassLoader().addPaths(classPaths);
/* 640 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder outputDirectory(String outputDirectory) {
/* 644 */     outputDirectory(outputDirectory == null ? null : new File(outputDirectory));
/* 645 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder outputDirectory(File outputDirectory) {
/* 649 */     this.outputDirectory = outputDirectory;
/* 650 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder compile(boolean compile) {
/* 654 */     this.compile = compile;
/* 655 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder header(boolean header) {
/* 659 */     this.header = header;
/* 660 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder copyLibs(boolean copyLibs) {
/* 664 */     this.copyLibs = copyLibs;
/* 665 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder outputName(String outputName) {
/* 669 */     this.outputName = outputName;
/* 670 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder jarPrefix(String jarPrefix) {
/* 674 */     this.jarPrefix = jarPrefix;
/* 675 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder properties(String platformName) {
/* 679 */     if (platformName != null) {
/* 680 */       this.properties = Loader.loadProperties(platformName);
/*     */     }
/* 682 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder properties(Properties properties) {
/* 686 */     if (properties != null) {
/* 687 */       for (Map.Entry e : properties.entrySet()) {
/* 688 */         property((String)e.getKey(), (String)e.getValue());
/*     */       }
/*     */     }
/* 691 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder propertyFile(String filename) throws IOException {
/* 695 */     propertyFile(filename == null ? null : new File(filename));
/* 696 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder propertyFile(File propertyFile) throws IOException {
/* 700 */     if (propertyFile == null) {
/* 701 */       return this;
/*     */     }
/* 703 */     FileInputStream fis = new FileInputStream(propertyFile);
/* 704 */     this.properties = new Properties();
/*     */     try {
/* 706 */       this.properties.load(new InputStreamReader(fis));
/*     */     } catch (NoSuchMethodError e) {
/* 708 */       this.properties.load(fis);
/*     */     }
/* 710 */     fis.close();
/* 711 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder property(String keyValue) {
/* 715 */     int equalIndex = keyValue.indexOf('=');
/* 716 */     if (equalIndex < 0) {
/* 717 */       equalIndex = keyValue.indexOf(':');
/*     */     }
/* 719 */     property(keyValue.substring(2, equalIndex), keyValue.substring(equalIndex + 1));
/*     */ 
/* 721 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder property(String key, String value) {
/* 725 */     if ((key.length() > 0) && (value.length() > 0)) {
/* 726 */       this.properties.put(key, value);
/*     */     }
/* 728 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder classesOrPackages(String[] classesOrPackages) throws IOException
/*     */   {
/* 733 */     if (classesOrPackages == null)
/* 734 */       this.classScanner.addPackage(null, true);
/* 735 */     else for (String s : classesOrPackages) {
/* 736 */         this.classScanner.addClassOrPackage(s);
/*     */       }
/* 738 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder environmentVariables(Map<String, String> environmentVariables) {
/* 742 */     this.environmentVariables = environmentVariables;
/* 743 */     return this;
/*     */   }
/*     */ 
/*     */   public Builder compilerOptions(String[] options) {
/* 747 */     if (options != null) {
/* 748 */       this.compilerOptions.addAll(Arrays.asList(options));
/*     */     }
/* 750 */     return this;
/*     */   }
/*     */ 
/*     */   public File[] build()
/*     */     throws IOException, InterruptedException, Parser.Exception
/*     */   {
/* 761 */     if (this.classScanner.getClasses().isEmpty()) {
/* 762 */       return null;
/*     */     }
/*     */ 
/* 765 */     LinkedList outputFiles = new LinkedList();
/* 766 */     Map map = new LinkedHashMap();
/* 767 */     for (Class c : this.classScanner.getClasses())
/* 768 */       if (Loader.getEnclosingClass(c) == c)
/*     */       {
/* 771 */         Loader.ClassProperties p = Loader.loadProperties(c, this.properties, false);
/* 772 */         String target = p.getProperty("parser.target");
/* 773 */         if ((target != null) && (!c.getName().equals(target))) {
/* 774 */           File f = parse(c);
/* 775 */           if (f != null)
/* 776 */             outputFiles.add(f);
/*     */         }
/*     */         else
/*     */         {
/* 780 */           String libraryName = this.outputName != null ? this.outputName : p.getProperty("loader.library", "");
/* 781 */           if (libraryName.length() != 0)
/*     */           {
/* 784 */             LinkedList classList = (LinkedList)map.get(libraryName);
/* 785 */             if (classList == null) {
/* 786 */               map.put(libraryName, classList = new LinkedList());
/*     */             }
/* 788 */             classList.add(c);
/*     */           }
/*     */         }
/*     */       }
/* 790 */     for (String libraryName : map.keySet()) {
/* 791 */       LinkedList classList = (LinkedList)map.get(libraryName);
/* 792 */       Class[] classArray = (Class[])classList.toArray(new Class[classList.size()]);
/* 793 */       File f = generateAndCompile(classArray, libraryName);
/* 794 */       if (f != null) {
/* 795 */         outputFiles.add(f);
/* 796 */         if (this.copyLibs)
/*     */         {
/* 798 */           p = Loader.loadProperties(classArray, this.properties, false);
/* 799 */           LinkedList preloads = new LinkedList();
/* 800 */           preloads.addAll(p.get("loader.preload"));
/* 801 */           preloads.addAll(p.get("compiler.link"));
/*     */ 
/* 803 */           p = Loader.loadProperties(classArray, this.properties, true);
/*     */ 
/* 805 */           directory = f.getParentFile();
/* 806 */           for (String s : preloads) { URL[] urls = Loader.findLibrary(null, p, s);
/*     */             File fi;
/*     */             try {
/* 810 */               fi = new File(urls[0].toURI()); } catch (Exception e) {
/*     */             }
/* 812 */             continue;
/*     */ 
/* 814 */             File fo = new File(directory, fi.getName());
/* 815 */             if ((fi.exists()) && (!outputFiles.contains(fo))) {
/* 816 */               System.out.println("Copying library file: " + fi);
/* 817 */               FileInputStream fis = new FileInputStream(fi);
/* 818 */               FileOutputStream fos = new FileOutputStream(fo);
/* 819 */               byte[] buffer = new byte[1024];
/*     */               int length;
/* 821 */               while ((length = fis.read(buffer)) != -1) {
/* 822 */                 fos.write(buffer, 0, length);
/*     */               }
/* 824 */               fos.close();
/* 825 */               fis.close();
/* 826 */               outputFiles.add(fo);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     Loader.ClassProperties p;
/*     */     File directory;
/* 833 */     File[] files = (File[])outputFiles.toArray(new File[outputFiles.size()]);
/* 834 */     if ((this.jarPrefix != null) && (files.length > 0)) {
/* 835 */       File jarFile = new File(this.jarPrefix + "-" + this.properties.get("platform.name") + ".jar");
/* 836 */       File d = jarFile.getParentFile();
/* 837 */       if ((d != null) && (!d.exists())) {
/* 838 */         d.mkdir();
/*     */       }
/* 840 */       createJar(jarFile, this.outputDirectory == null ? this.classScanner.getClassLoader().getPaths() : null, files);
/*     */     }
/* 842 */     return files;
/*     */   }
/*     */ 
/*     */   public static void printHelp()
/*     */   {
/* 849 */     String version = Builder.class.getPackage().getImplementationVersion();
/* 850 */     if (version == null) {
/* 851 */       version = "unknown";
/*     */     }
/* 853 */     System.out.println("JavaCPP version " + version + "\n" + "Copyright (C) 2011-2013 Samuel Audet <samuel.audet@gmail.com>\n" + "Project site: http://code.google.com/p/javacpp/\n\n" + "Licensed under the GNU General Public License version 2 (GPLv2) with Classpath exception.\n" + "Please refer to LICENSE.txt or http://www.gnu.org/licenses/ for details.");
/*     */ 
/* 860 */     System.out.println();
/* 861 */     System.out.println("Usage: java -jar javacpp.jar [options] [class or package (suffixed with .* or .**)]");
/* 862 */     System.out.println();
/* 863 */     System.out.println("where options include:");
/* 864 */     System.out.println();
/* 865 */     System.out.println("    -classpath <path>      Load user classes from path");
/* 866 */     System.out.println("    -d <directory>         Output all generated files to directory");
/* 867 */     System.out.println("    -o <name>              Output everything in a file named after given name");
/* 868 */     System.out.println("    -nocompile             Do not compile or delete the generated source files");
/* 869 */     System.out.println("    -header                Generate header file with declarations of callbacks functions");
/* 870 */     System.out.println("    -copylibs              Copy to output directory dependent libraries (link and preload)");
/* 871 */     System.out.println("    -jarprefix <prefix>    Also create a JAR file named \"<prefix>-<platform.name>.jar\"");
/* 872 */     System.out.println("    -properties <resource> Load all properties from resource");
/* 873 */     System.out.println("    -propertyfile <file>   Load all properties from file");
/* 874 */     System.out.println("    -D<property>=<value>   Set property to value");
/* 875 */     System.out.println("    -Xcompiler <option>    Pass option directly to compiler");
/* 876 */     System.out.println();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 886 */     boolean addedClasses = false;
/* 887 */     Builder builder = new Builder();
/* 888 */     for (int i = 0; i < args.length; i++) {
/* 889 */       if (("-help".equals(args[i])) || ("--help".equals(args[i]))) {
/* 890 */         printHelp();
/* 891 */         System.exit(0);
/* 892 */       } else if (("-classpath".equals(args[i])) || ("-cp".equals(args[i])) || ("-lib".equals(args[i]))) {
/* 893 */         builder.classPaths(args[(++i)]);
/* 894 */       } else if ("-d".equals(args[i])) {
/* 895 */         builder.outputDirectory(args[(++i)]);
/* 896 */       } else if ("-o".equals(args[i])) {
/* 897 */         builder.outputName(args[(++i)]);
/* 898 */       } else if (("-cpp".equals(args[i])) || ("-nocompile".equals(args[i]))) {
/* 899 */         builder.compile(false);
/* 900 */       } else if ("-header".equals(args[i])) {
/* 901 */         builder.header(true);
/* 902 */       } else if ("-copylibs".equals(args[i])) {
/* 903 */         builder.copyLibs(true);
/* 904 */       } else if ("-jarprefix".equals(args[i])) {
/* 905 */         builder.jarPrefix(args[(++i)]);
/* 906 */       } else if ("-properties".equals(args[i])) {
/* 907 */         builder.properties(args[(++i)]);
/* 908 */       } else if ("-propertyfile".equals(args[i])) {
/* 909 */         builder.propertyFile(args[(++i)]);
/* 910 */       } else if (args[i].startsWith("-D")) {
/* 911 */         builder.property(args[i]);
/* 912 */       } else if ("-Xcompiler".equals(args[i])) {
/* 913 */         builder.compilerOptions(new String[] { args[(++i)] });
/* 914 */       } else if (args[i].startsWith("-")) {
/* 915 */         System.err.println("Error: Invalid option \"" + args[i] + "\"");
/* 916 */         printHelp();
/* 917 */         System.exit(1);
/*     */       } else {
/* 919 */         builder.classesOrPackages(new String[] { args[i] });
/* 920 */         addedClasses = true;
/*     */       }
/*     */     }
/* 923 */     if (!addedClasses) {
/* 924 */       builder.classesOrPackages((String[])null);
/*     */     }
/* 926 */     builder.build();
/*     */   }
/*     */ 
/*     */   public static class ClassScanner
/*     */   {
/*     */     private Collection<Class> classes;
/*     */     private Builder.UserClassLoader loader;
/*     */ 
/*     */     public ClassScanner(Collection<Class> classes, Builder.UserClassLoader loader)
/*     */     {
/* 503 */       this.classes = classes;
/* 504 */       this.loader = loader;
/*     */     }
/*     */ 
/*     */     public Collection<Class> getClasses()
/*     */     {
/* 511 */       return this.classes;
/*     */     }
/*     */     public Builder.UserClassLoader getClassLoader() {
/* 514 */       return this.loader;
/*     */     }
/*     */ 
/*     */     public void addClass(String className) {
/* 518 */       if (className == null)
/* 519 */         return;
/* 520 */       if (className.endsWith(".class"))
/* 521 */         className = className.substring(0, className.length() - 6);
/*     */       try
/*     */       {
/* 524 */         Class c = Class.forName(className, false, this.loader);
/* 525 */         if (!this.classes.contains(c))
/* 526 */           this.classes.add(c);
/*     */       }
/*     */       catch (ClassNotFoundException e) {
/* 529 */         System.err.println("Warning: Could not find class " + className + ": " + e);
/*     */       } catch (NoClassDefFoundError e) {
/* 531 */         System.err.println("Warning: Could not load class " + className + ": " + e);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void addMatchingFile(String filename, String packagePath, boolean recursive) {
/* 536 */       if ((filename != null) && (filename.endsWith(".class")) && ((packagePath == null) || ((recursive) && (filename.startsWith(packagePath))) || (filename.regionMatches(0, packagePath, 0, Math.max(filename.lastIndexOf('/'), packagePath.lastIndexOf('/'))))))
/*     */       {
/* 539 */         addClass(filename.replace('/', '.'));
/*     */       }
/*     */     }
/*     */ 
/*     */     public void addMatchingDir(String parentName, File dir, String packagePath, boolean recursive) {
/* 544 */       File[] files = dir.listFiles();
/* 545 */       Arrays.sort(files);
/* 546 */       for (File f : files) {
/* 547 */         String pathName = parentName + f.getName();
/* 548 */         if (f.isDirectory())
/* 549 */           addMatchingDir(pathName + "/", f, packagePath, recursive);
/*     */         else
/* 551 */           addMatchingFile(pathName, packagePath, recursive);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void addPackage(String packageName, boolean recursive) throws IOException
/*     */     {
/* 557 */       String[] paths = this.loader.getPaths();
/* 558 */       String packagePath = packageName.replace('.', '/') + "/";
/* 559 */       int prevSize = this.classes.size();
/* 560 */       for (String p : paths) {
/* 561 */         File file = new File(p);
/* 562 */         if (file.isDirectory()) {
/* 563 */           addMatchingDir(null, file, packagePath, recursive);
/*     */         } else {
/* 565 */           JarInputStream jis = new JarInputStream(new FileInputStream(file));
/* 566 */           ZipEntry e = jis.getNextEntry();
/* 567 */           while (e != null) {
/* 568 */             addMatchingFile(e.getName(), packagePath, recursive);
/* 569 */             jis.closeEntry();
/* 570 */             e = jis.getNextEntry();
/*     */           }
/* 572 */           jis.close();
/*     */         }
/*     */       }
/* 575 */       if ((this.classes.size() == 0) && (packageName == null)) {
/* 576 */         System.err.println("Warning: No classes found in the unnamed package");
/* 577 */         Builder.printHelp();
/* 578 */       } else if ((prevSize == this.classes.size()) && (packageName != null)) {
/* 579 */         System.err.println("Warning: No classes found in package " + packageName);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void addClassOrPackage(String name) throws IOException {
/* 584 */       if (name == null) {
/* 585 */         return;
/*     */       }
/* 587 */       name = name.replace('/', '.');
/* 588 */       if (name.endsWith(".**"))
/* 589 */         addPackage(name.substring(0, name.length() - 3), true);
/* 590 */       else if (name.endsWith(".*"))
/* 591 */         addPackage(name.substring(0, name.length() - 2), false);
/*     */       else
/* 593 */         addClass(name);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class UserClassLoader extends URLClassLoader
/*     */   {
/* 458 */     private LinkedList<String> paths = new LinkedList();
/*     */ 
/* 460 */     public UserClassLoader() { super(); }
/*     */ 
/*     */     public UserClassLoader(ClassLoader parent) {
/* 463 */       super(parent);
/*     */     }
/*     */     public void addPaths(String[] paths) {
/* 466 */       if (paths == null) {
/* 467 */         return;
/*     */       }
/* 469 */       for (String path : paths) {
/* 470 */         File f = new File(path);
/* 471 */         if (f.exists())
/*     */         {
/* 474 */           this.paths.add(path);
/*     */           try {
/* 476 */             addURL(f.toURI().toURL());
/*     */           } catch (MalformedURLException e) {
/* 478 */             throw new RuntimeException(e); } 
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 483 */     public String[] getPaths() { if (this.paths.isEmpty()) {
/* 484 */         addPaths(new String[] { System.getProperty("user.dir") });
/*     */       }
/* 486 */       return (String[])this.paths.toArray(new String[this.paths.size()]); }
/*     */ 
/*     */     protected Class<?> findClass(String name) throws ClassNotFoundException
/*     */     {
/* 490 */       if (this.paths.isEmpty()) {
/* 491 */         addPaths(new String[] { System.getProperty("user.dir") });
/*     */       }
/* 493 */       return super.findClass(name);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Piper extends Thread
/*     */   {
/*     */     InputStream is;
/*     */     OutputStream os;
/*     */ 
/*     */     public Piper(InputStream is, OutputStream os)
/*     */     {
/* 159 */       this.is = is;
/* 160 */       this.os = os;
/*     */     }
/*     */ 
/*     */     public void run()
/*     */     {
/*     */       try
/*     */       {
/* 168 */         byte[] buffer = new byte[1024];
/*     */         int length;
/* 170 */         while ((length = this.is.read(buffer)) != -1)
/* 171 */           this.os.write(buffer, 0, length);
/*     */       }
/*     */       catch (IOException e) {
/* 174 */         System.err.println("Could not pipe from the InputStream to the OutputStream: " + e.getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.Builder
 * JD-Core Version:    0.6.2
 */