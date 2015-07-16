/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import com.googlecode.javacpp.annotation.Platform;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ public class Loader
/*     */ {
/*     */   private static final String platformName;
/*  57 */   private static java.util.Properties platformProperties = null;
/*     */   static File tempDir;
/*     */   static boolean loadLibraries;
/*     */   static Map<String, String> loadedLibraries;
/* 786 */   static WeakHashMap<Class<? extends Pointer>, HashMap<String, Integer>> memberOffsets = new WeakHashMap();
/*     */ 
/*     */   public static String getPlatformName()
/*     */   {
/*  94 */     return System.getProperty("com.googlecode.javacpp.platform.name", platformName);
/*     */   }
/*     */ 
/*     */   public static java.util.Properties loadProperties()
/*     */   {
/* 103 */     String name = getPlatformName();
/* 104 */     if ((platformProperties != null) && (name.equals(platformProperties.getProperty("platform.name")))) {
/* 105 */       return platformProperties;
/*     */     }
/* 107 */     return Loader.platformProperties = loadProperties(name);
/*     */   }
/*     */ 
/*     */   public static java.util.Properties loadProperties(String name)
/*     */   {
/* 116 */     java.util.Properties p = new java.util.Properties();
/* 117 */     p.put("platform.name", name);
/* 118 */     p.put("path.separator", File.pathSeparator);
/* 119 */     String s = System.mapLibraryName("/");
/* 120 */     int i = s.indexOf('/');
/* 121 */     p.put("library.prefix", s.substring(0, i));
/* 122 */     p.put("library.suffix", s.substring(i + 1));
/* 123 */     name = "properties/" + name + ".properties";
/* 124 */     InputStream is = Loader.class.getResourceAsStream(name);
/*     */     try {
/*     */       try {
/* 127 */         p.load(new InputStreamReader(is));
/*     */       } catch (NoSuchMethodError e) {
/* 129 */         p.load(is);
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       name = "properties/generic.properties";
/* 133 */       is = Loader.class.getResourceAsStream(name);
/*     */       try {
/*     */         try {
/* 136 */           p.load(new InputStreamReader(is));
/*     */         } catch (NoSuchMethodError e2) {
/* 138 */           p.load(is);
/*     */         }
/*     */       }
/*     */       catch (Exception e2) {
/*     */       }
/*     */     }
/* 144 */     return p;
/*     */   }
/*     */ 
/*     */   public static Class getEnclosingClass(Class cls)
/*     */   {
/* 158 */     Class c = cls;
/*     */ 
/* 160 */     while ((c.getDeclaringClass() != null) && 
/* 161 */       (!c.isAnnotationPresent(com.googlecode.javacpp.annotation.Properties.class)))
/*     */     {
/* 164 */       if (c.isAnnotationPresent(Platform.class)) {
/* 165 */         Platform p = (Platform)c.getAnnotation(Platform.class);
/* 166 */         if ((p.define().length > 0) || (p.include().length > 0) || (p.cinclude().length > 0) || (p.includepath().length > 0) || (p.options().length > 0) || (p.linkpath().length > 0) || (p.link().length > 0) || (p.framework().length > 0) || (p.preloadpath().length > 0) || (p.preload().length > 0) || (p.library().length() > 0))
/*     */         {
/*     */           break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 173 */       c = c.getDeclaringClass();
/*     */     }
/* 175 */     return c;
/*     */   }
/*     */ 
/*     */   public static ClassProperties loadProperties(Class[] cls, java.util.Properties properties, boolean inherit)
/*     */   {
/* 372 */     ClassProperties cp = new ClassProperties(properties);
/* 373 */     for (Class c : cls) {
/* 374 */       cp.load(c, inherit);
/*     */     }
/* 376 */     return cp;
/*     */   }
/*     */ 
/*     */   public static ClassProperties loadProperties(Class cls, java.util.Properties properties, boolean inherit)
/*     */   {
/* 391 */     ClassProperties cp = new ClassProperties(properties);
/* 392 */     cp.load(cls, inherit);
/* 393 */     return cp;
/*     */   }
/*     */ 
/*     */   public static Class getCallerClass(int i)
/*     */   {
/* 403 */     Class[] classContext = new SecurityManager() {
/*     */       public Class[] getClassContext() {
/* 405 */         return super.getClassContext();
/*     */       }
/*     */     }
/* 403 */     .getClassContext();
/*     */ 
/* 408 */     if (classContext != null) {
/* 409 */       for (int j = 0; j < classContext.length; j++) {
/* 410 */         if (classContext[j] == Loader.class)
/* 411 */           return classContext[(i + j)];
/*     */       }
/*     */     }
/*     */     else
/*     */       try
/*     */       {
/* 417 */         StackTraceElement[] classNames = Thread.currentThread().getStackTrace();
/* 418 */         for (int j = 0; j < classNames.length; j++)
/* 419 */           if (Class.forName(classNames[j].getClassName()) == Loader.class)
/* 420 */             return Class.forName(classNames[(i + j)].getClassName());
/*     */       }
/*     */       catch (ClassNotFoundException e)
/*     */       {
/*     */       }
/* 425 */     return null;
/*     */   }
/*     */ 
/*     */   public static File extractResource(String name, File directory, String prefix, String suffix)
/*     */     throws IOException
/*     */   {
/* 436 */     Class cls = getCallerClass(2);
/* 437 */     return extractResource(cls, name, directory, prefix, suffix);
/*     */   }
/*     */ 
/*     */   public static File extractResource(Class cls, String name, File directory, String prefix, String suffix)
/*     */     throws IOException
/*     */   {
/* 448 */     return extractResource(cls.getResource(name), directory, prefix, suffix);
/*     */   }
/*     */ 
/*     */   public static File extractResource(URL resourceURL, File directory, String prefix, String suffix)
/*     */     throws IOException
/*     */   {
/* 464 */     InputStream is = resourceURL != null ? resourceURL.openStream() : null;
/* 465 */     if (is == null) {
/* 466 */       return null;
/*     */     }
/* 468 */     File file = null;
/* 469 */     boolean fileExisted = false;
/*     */     try {
/* 471 */       if ((prefix == null) && (suffix == null)) {
/* 472 */         if (directory == null) {
/* 473 */           directory = new File(System.getProperty("java.io.tmpdir"));
/*     */         }
/* 475 */         file = new File(directory, new File(resourceURL.getPath()).getName());
/* 476 */         fileExisted = file.exists();
/*     */       } else {
/* 478 */         file = File.createTempFile(prefix, suffix, directory);
/*     */       }
/* 480 */       FileOutputStream os = new FileOutputStream(file);
/* 481 */       byte[] buffer = new byte[1024];
/*     */       int length;
/* 483 */       while ((length = is.read(buffer)) != -1) {
/* 484 */         os.write(buffer, 0, length);
/*     */       }
/* 486 */       is.close();
/* 487 */       os.close();
/*     */     } catch (IOException e) {
/* 489 */       if ((file != null) && (!fileExisted)) {
/* 490 */         file.delete();
/*     */       }
/* 492 */       throw e;
/*     */     }
/* 494 */     return file;
/*     */   }
/*     */ 
/*     */   public static File getTempDir()
/*     */   {
/* 512 */     if (tempDir == null) {
/* 513 */       File tmpdir = new File(System.getProperty("java.io.tmpdir"));
/* 514 */       File f = null;
/* 515 */       for (int i = 0; i < 1000; i++) {
/* 516 */         f = new File(tmpdir, "javacpp" + System.nanoTime());
/* 517 */         if (f.mkdir()) {
/* 518 */           tempDir = f;
/* 519 */           tempDir.deleteOnExit();
/* 520 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 524 */     return tempDir;
/*     */   }
/*     */ 
/*     */   public static boolean isLoadLibraries()
/*     */   {
/* 529 */     return loadLibraries;
/*     */   }
/*     */ 
/*     */   public static String load()
/*     */   {
/* 539 */     Class cls = getCallerClass(2);
/* 540 */     return load(cls);
/*     */   }
/*     */ 
/*     */   public static String load(Class cls)
/*     */   {
/* 552 */     if ((!loadLibraries) || (cls == null)) {
/* 553 */       return null;
/*     */     }
/*     */ 
/* 557 */     cls = getEnclosingClass(cls);
/*     */     try
/*     */     {
/* 561 */       cls = Class.forName(cls.getName(), true, cls.getClassLoader());
/*     */     } catch (ClassNotFoundException ex) {
/* 563 */       Error e = new NoClassDefFoundError(ex.toString());
/* 564 */       e.initCause(ex);
/* 565 */       throw e;
/*     */     }
/*     */ 
/* 569 */     ClassProperties p = loadProperties(cls, loadProperties(), true);
/* 570 */     LinkedList preloads = new LinkedList();
/* 571 */     preloads.addAll(p.get("loader.preload"));
/* 572 */     preloads.addAll(p.get("compiler.link"));
/* 573 */     UnsatisfiedLinkError preloadError = null;
/* 574 */     for (String preload : preloads) {
/*     */       try {
/* 576 */         URL[] urls = findLibrary(cls, p, preload);
/* 577 */         loadLibrary(urls, preload);
/*     */       } catch (UnsatisfiedLinkError e) {
/* 579 */         preloadError = e;
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 584 */       String library = p.getProperty("loader.library");
/* 585 */       URL[] urls = findLibrary(cls, p, library);
/* 586 */       return loadLibrary(urls, library);
/*     */     } catch (UnsatisfiedLinkError e) {
/* 588 */       if ((preloadError != null) && (e.getCause() == null)) {
/* 589 */         e.initCause(preloadError);
/*     */       }
/* 591 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static URL[] findLibrary(Class cls, ClassProperties properties, String libnameversion)
/*     */   {
/* 606 */     String[] s = libnameversion.split("@");
/* 607 */     String libname = s[0];
/* 608 */     String version = s.length > 1 ? s[(s.length - 1)] : "";
/*     */ 
/* 611 */     String filename = (String)loadedLibraries.get(libnameversion);
/* 612 */     if (filename != null) {
/*     */       try {
/* 614 */         return new URL[] { new File(filename).toURI().toURL() };
/*     */       } catch (IOException ex) {
/* 616 */         return new URL[0];
/*     */       }
/*     */     }
/*     */ 
/* 620 */     String subdir = properties.getProperty("platform.name") + '/';
/* 621 */     String prefix = properties.getProperty("library.prefix", "") + libname;
/* 622 */     String suffix = properties.getProperty("library.suffix", "");
/* 623 */     String[] styles = { prefix + suffix + version, prefix + version + suffix, prefix + suffix };
/*     */ 
/* 629 */     int k = 0;
/* 630 */     LinkedList paths = new LinkedList();
/* 631 */     paths.addAll(properties.get("loader.preloadpath"));
/* 632 */     paths.addAll(properties.get("compiler.linkpath"));
/* 633 */     URL[] urls = new URL[styles.length * (1 + paths.size())];
/* 634 */     for (int i = 0; (cls != null) && (i < styles.length); i++)
/*     */     {
/* 636 */       URL u = cls.getResource(subdir + styles[i]);
/* 637 */       if (u != null) {
/* 638 */         urls[(k++)] = u;
/*     */       }
/*     */     }
/*     */ 
/* 642 */     for (int i = 0; (paths.size() > 0) && (i < styles.length); i++) {
/* 643 */       for (String path : paths) {
/* 644 */         File file = new File(path, styles[i]);
/* 645 */         if (file.exists()) {
/*     */           try {
/* 647 */             urls[(k++)] = file.toURI().toURL();
/*     */           } catch (IOException ex) {
/* 649 */             throw new RuntimeException(ex);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 654 */     URL[] newurls = new URL[k];
/* 655 */     System.arraycopy(urls, 0, newurls, 0, k);
/* 656 */     return newurls;
/*     */   }
/*     */ 
/*     */   public static String loadLibrary(URL[] urls, String libnameversion)
/*     */   {
/* 670 */     if (!loadLibraries) {
/* 671 */       return null;
/*     */     }
/*     */ 
/* 675 */     String filename = (String)loadedLibraries.get(libnameversion);
/* 676 */     if (filename != null) {
/* 677 */       return filename;
/*     */     }
/*     */ 
/* 680 */     File tempFile = null;
/* 681 */     UnsatisfiedLinkError loadError = null;
/*     */     try {
/* 683 */       for (URL url : urls)
/*     */       {
/*     */         File file;
/*     */         try {
/* 687 */           file = new File(url.toURI());
/*     */         } catch (Exception e) {
/* 689 */           if ((tempFile != null) && (tempFile.exists())) {
/* 690 */             tempFile.deleteOnExit();
/*     */           }
/*     */ 
/* 693 */           file = tempFile = extractResource(url, getTempDir(), null, null);
/*     */         }
/* 695 */         if ((file != null) && (file.exists())) {
/* 696 */           filename = file.getAbsolutePath();
/*     */           try
/*     */           {
/* 699 */             loadedLibraries.put(libnameversion, filename);
/* 700 */             System.load(filename);
/* 701 */             e = filename;
/*     */ 
/* 728 */             if ((tempFile != null) && (tempFile.exists()))
/* 729 */               tempFile.deleteOnExit(); return e;
/*     */           }
/*     */           catch (UnsatisfiedLinkError e)
/*     */           {
/* 703 */             loadError = e;
/* 704 */             loadedLibraries.remove(libnameversion);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 709 */       String libname = libnameversion.split("@")[0];
/* 710 */       loadedLibraries.put(libnameversion, libname);
/* 711 */       System.loadLibrary(libname);
/* 712 */       return libname;
/*     */     } catch (UnsatisfiedLinkError e) {
/* 714 */       loadedLibraries.remove(libnameversion);
/* 715 */       if ((loadError != null) && (e.getCause() == null)) {
/* 716 */         e.initCause(loadError);
/*     */       }
/* 718 */       throw e;
/*     */     } catch (IOException ex) {
/* 720 */       loadedLibraries.remove(libnameversion);
/* 721 */       if ((loadError != null) && (ex.getCause() == null)) {
/* 722 */         ex.initCause(loadError);
/*     */       }
/* 724 */       Error e = new UnsatisfiedLinkError(ex.toString());
/* 725 */       e.initCause(ex);
/* 726 */       throw e;
/*     */     } finally {
/* 728 */       if ((tempFile != null) && (tempFile.exists()))
/* 729 */         tempFile.deleteOnExit();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 762 */     File tmpdir = new File(System.getProperty("java.io.tmpdir"));
/* 763 */     File tempDir = new File(args[0]);
/* 764 */     if ((!tmpdir.equals(tempDir.getParentFile())) || (!tempDir.getName().startsWith("javacpp")))
/*     */     {
/* 767 */       return;
/*     */     }
/* 769 */     for (File file : tempDir.listFiles())
/* 770 */       while ((file.exists()) && (!file.delete()))
/*     */         try {
/* 772 */           Thread.sleep(100L);
/*     */         }
/*     */         catch (InterruptedException e) {
/*     */         }
/* 776 */     tempDir.delete();
/*     */   }
/*     */ 
/*     */   static void putMemberOffset(String typeName, String member, int offset)
/*     */     throws ClassNotFoundException
/*     */   {
/* 799 */     Class c = Class.forName(typeName.replace('/', '.'), false, Loader.class.getClassLoader());
/* 800 */     putMemberOffset(c.asSubclass(Pointer.class), member, offset);
/*     */   }
/*     */ 
/*     */   static synchronized void putMemberOffset(Class<? extends Pointer> type, String member, int offset)
/*     */   {
/* 810 */     HashMap offsets = (HashMap)memberOffsets.get(type);
/* 811 */     if (offsets == null) {
/* 812 */       memberOffsets.put(type, offsets = new HashMap());
/*     */     }
/* 814 */     offsets.put(member, Integer.valueOf(offset));
/*     */   }
/*     */ 
/*     */   public static int offsetof(Class<? extends Pointer> type, String member)
/*     */   {
/* 826 */     return ((Integer)((HashMap)memberOffsets.get(type)).get(member)).intValue();
/*     */   }
/*     */ 
/*     */   public static int sizeof(Class<? extends Pointer> type)
/*     */   {
/* 837 */     return ((Integer)((HashMap)memberOffsets.get(type)).get("sizeof")).intValue();
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  60 */     String jvmName = System.getProperty("java.vm.name").toLowerCase();
/*  61 */     String osName = System.getProperty("os.name").toLowerCase();
/*  62 */     String osArch = System.getProperty("os.arch").toLowerCase();
/*  63 */     if ((jvmName.startsWith("dalvik")) && (osName.startsWith("linux"))) {
/*  64 */       osName = "android";
/*  65 */     } else if ((jvmName.startsWith("robovm")) && (osName.startsWith("darwin"))) {
/*  66 */       osName = "ios";
/*  67 */       osArch = "arm";
/*  68 */     } else if (osName.startsWith("mac os x")) {
/*  69 */       osName = "macosx";
/*     */     } else {
/*  71 */       int spaceIndex = osName.indexOf(' ');
/*  72 */       if (spaceIndex > 0) {
/*  73 */         osName = osName.substring(0, spaceIndex);
/*     */       }
/*     */     }
/*  76 */     if ((osArch.equals("i386")) || (osArch.equals("i486")) || (osArch.equals("i586")) || (osArch.equals("i686")))
/*  77 */       osArch = "x86";
/*  78 */     else if ((osArch.equals("amd64")) || (osArch.equals("x86-64")) || (osArch.equals("x64")))
/*  79 */       osArch = "x86_64";
/*  80 */     else if (osArch.startsWith("arm")) {
/*  81 */       osArch = "arm";
/*     */     }
/*  83 */     platformName = osName + "-" + osArch;
/*     */ 
/* 499 */     tempDir = null;
/*     */ 
/* 501 */     loadLibraries = true;
/*     */ 
/* 503 */     loadedLibraries = Collections.synchronizedMap(new HashMap());
/*     */ 
/* 737 */     if (getPlatformName().startsWith("windows"))
/* 738 */       Runtime.getRuntime().addShutdownHook(new Thread() {
/*     */         public void run() {
/* 740 */           if (Loader.tempDir == null) {
/* 741 */             return;
/*     */           }
/*     */           try
/*     */           {
/* 745 */             LinkedList command = new LinkedList();
/* 746 */             command.add(System.getProperty("java.home") + "/bin/java");
/* 747 */             command.add("-classpath");
/* 748 */             command.add(System.getProperty("java.class.path"));
/* 749 */             command.add(Loader.class.getName());
/* 750 */             command.add(Loader.tempDir.getAbsolutePath());
/* 751 */             new ProcessBuilder(command).start();
/*     */           } catch (IOException e) {
/* 753 */             throw new RuntimeException(e);
/*     */           }
/*     */         }
/*     */       });
/*     */   }
/*     */ 
/*     */   public static class ClassProperties extends HashMap<String, LinkedList<String>>
/*     */   {
/*     */     String platformName;
/*     */     String platformRoot;
/*     */     String pathSeparator;
/*     */ 
/*     */     public ClassProperties()
/*     */     {
/*     */     }
/*     */ 
/*     */     public ClassProperties(java.util.Properties properties)
/*     */     {
/* 189 */       this.platformName = properties.getProperty("platform.name");
/* 190 */       this.platformRoot = properties.getProperty("platform.root");
/* 191 */       this.pathSeparator = properties.getProperty("path.separator");
/* 192 */       if ((this.platformRoot == null) || (this.platformRoot.length() == 0)) {
/* 193 */         this.platformRoot = ".";
/*     */       }
/* 195 */       if (!this.platformRoot.endsWith(File.separator)) {
/* 196 */         this.platformRoot += File.separator;
/*     */       }
/* 198 */       for (Map.Entry e : properties.entrySet()) {
/* 199 */         String k = (String)e.getKey(); String v = (String)e.getValue();
/* 200 */         if ((v != null) && (v.length() != 0))
/*     */         {
/* 203 */           if ((k.equals("compiler.includepath")) || (k.equals("compiler.include")) || (k.equals("compiler.linkpath")) || (k.equals("compiler.link")) || (k.equals("compiler.framework")))
/*     */           {
/* 206 */             addAll(k, v.split(this.pathSeparator));
/*     */           }
/* 208 */           else setProperty(k, v);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     public LinkedList<String> get(String key)
/*     */     {
/* 216 */       LinkedList list = (LinkedList)super.get(key);
/* 217 */       if (list == null) {
/* 218 */         put(key, list = new LinkedList());
/*     */       }
/* 220 */       return list;
/*     */     }
/*     */ 
/*     */     public void addAll(String key, String[] values) {
/* 224 */       if (values != null)
/* 225 */         addAll(key, Arrays.asList(values));
/*     */     }
/*     */ 
/*     */     public void addAll(String key, Collection<String> values)
/*     */     {
/*     */       String root;
/*     */       LinkedList values2;
/* 229 */       if (values != null) {
/* 230 */         root = null;
/* 231 */         if ((key.equals("compiler.path")) || (key.equals("compiler.sysroot")) || (key.equals("compiler.includepath")) || (key.equals("compiler.linkpath")))
/*     */         {
/* 233 */           root = this.platformRoot;
/*     */         }
/*     */ 
/* 236 */         values2 = get(key);
/* 237 */         for (String value : values)
/* 238 */           if ((value != null) && (!values2.contains(value))) {
/* 239 */             if ((root != null) && (!new File(value).isAbsolute()) && (new File(root + value).exists()))
/*     */             {
/* 241 */               value = root + value;
/*     */             }
/* 243 */             values2.add(value);
/*     */           }
/*     */       }
/*     */     }
/*     */ 
/*     */     public String getProperty(String key)
/*     */     {
/* 250 */       return getProperty(key, null);
/*     */     }
/*     */     public String getProperty(String key, String defaultValue) {
/* 253 */       LinkedList values = get(key);
/* 254 */       return values.isEmpty() ? defaultValue : (String)values.get(0);
/*     */     }
/*     */     public String setProperty(String key, String value) {
/* 257 */       LinkedList values = get(key);
/* 258 */       String oldValue = values.isEmpty() ? null : (String)values.get(0);
/* 259 */       values.clear();
/* 260 */       addAll(key, new String[] { value });
/* 261 */       return oldValue;
/*     */     }
/*     */ 
/*     */     public void load(Class cls, boolean inherit) {
/* 265 */       Class c = Loader.getEnclosingClass(cls);
/*     */ 
/* 267 */       while ((!c.isAnnotationPresent(com.googlecode.javacpp.annotation.Properties.class)) && (!c.isAnnotationPresent(Platform.class)) && (c.getSuperclass() != Object.class)) {
/* 268 */         c = c.getSuperclass();
/*     */       }
/* 270 */       com.googlecode.javacpp.annotation.Properties classProperties = (com.googlecode.javacpp.annotation.Properties)c.getAnnotation(com.googlecode.javacpp.annotation.Properties.class);
/*     */ 
/* 272 */       Platform[] platforms = null;
/* 273 */       if (classProperties == null) {
/* 274 */         Platform platform = (Platform)c.getAnnotation(Platform.class);
/* 275 */         if (platform != null)
/* 276 */           platforms = new Platform[] { platform };
/*     */       }
/*     */       else {
/* 279 */         Class[] classes = classProperties.inherit();
/* 280 */         if ((inherit) && (classes != null)) {
/* 281 */           for (Class c2 : classes) {
/* 282 */             load(c2, inherit);
/*     */           }
/*     */         }
/* 285 */         String target = classProperties.target();
/* 286 */         if (target.length() > 0) {
/* 287 */           addAll("parser.target", new String[] { target });
/*     */         }
/* 289 */         platforms = classProperties.value();
/*     */       }
/*     */ 
/* 292 */       String[] define = new String[0]; String[] include = new String[0]; String[] cinclude = new String[0]; String[] includepath = new String[0]; String[] options = new String[0];
/* 293 */       String[] linkpath = new String[0]; String[] link = new String[0]; String[] framework = new String[0]; String[] preloadpath = new String[0]; String[] preload = new String[0];
/* 294 */       String library = "jni" + c.getSimpleName();
/* 295 */       for (Platform p : platforms != null ? platforms : new Platform[0]) {
/* 296 */         String[][] names = { p.value(), p.not() };
/* 297 */         boolean[] matches = { false, false };
/* 298 */         for (int i = 0; i < names.length; i++) {
/* 299 */           for (String s : names[i]) {
/* 300 */             if (this.platformName.startsWith(s)) {
/* 301 */               matches[i] = true;
/* 302 */               break;
/*     */             }
/*     */           }
/*     */         }
/* 306 */         if (((names[0].length == 0) || (matches[0] != 0)) && ((names[1].length == 0) || (matches[1] == 0))) {
/* 307 */           if (p.define().length > 0) define = p.define();
/* 308 */           if (p.include().length > 0) include = p.include();
/* 309 */           if (p.cinclude().length > 0) cinclude = p.cinclude();
/* 310 */           if (p.includepath().length > 0) includepath = p.includepath();
/* 311 */           if (p.options().length > 0) options = p.options();
/* 312 */           if (p.linkpath().length > 0) linkpath = p.linkpath();
/* 313 */           if (p.link().length > 0) link = p.link();
/* 314 */           if (p.framework().length > 0) framework = p.framework();
/* 315 */           if (p.preloadpath().length > 0) preloadpath = p.preloadpath();
/* 316 */           if (p.preload().length > 0) preload = p.preload();
/* 317 */           if (p.library().length() > 0) library = p.library();
/*     */         }
/*     */       }
/* 320 */       addAll("generator.define", define);
/* 321 */       addAll("generator.include", include);
/* 322 */       addAll("generator.cinclude", cinclude);
/* 323 */       addAll("compiler.includepath", includepath);
/* 324 */       addAll("compiler.options", options);
/* 325 */       addAll("compiler.linkpath", linkpath);
/* 326 */       addAll("compiler.link", link);
/* 327 */       addAll("compiler.framework", framework);
/* 328 */       addAll("loader.preloadpath", preloadpath);
/* 329 */       addAll("loader.preload", preload);
/* 330 */       setProperty("loader.library", library);
/*     */     }
/*     */ 
/*     */     LinkedList<File> getHeaderFiles() throws FileNotFoundException {
/* 334 */       LinkedList paths = get("compiler.includepath");
/* 335 */       LinkedList includes = new LinkedList();
/* 336 */       includes.addAll(get("generator.include"));
/* 337 */       includes.addAll(get("generator.cinclude"));
/* 338 */       LinkedList files = new LinkedList();
/* 339 */       for (String include : includes) {
/* 340 */         boolean found = false;
/* 341 */         if ((include.startsWith("<")) && (include.endsWith(">"))) {
/* 342 */           include = include.substring(1, include.length() - 1);
/*     */         } else {
/* 344 */           File f = new File(include);
/* 345 */           if (f.exists()) {
/* 346 */             found = true;
/* 347 */             files.add(f);
/* 348 */             continue;
/*     */           }
/*     */         }
/* 351 */         for (String path : paths) {
/* 352 */           File f = new File(path, include);
/* 353 */           if (f.exists()) {
/* 354 */             found = true;
/* 355 */             files.add(f);
/* 356 */             break;
/*     */           }
/*     */         }
/* 359 */         if (!found) {
/* 360 */           throw new FileNotFoundException("Could not find header file: " + include);
/*     */         }
/*     */       }
/* 363 */       return files;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.Loader
 * JD-Core Version:    0.6.2
 */