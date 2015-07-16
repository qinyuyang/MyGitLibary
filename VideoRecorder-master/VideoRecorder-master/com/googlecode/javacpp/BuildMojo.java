/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.apache.maven.plugin.AbstractMojo;
/*     */ import org.apache.maven.plugin.MojoExecutionException;
/*     */ import org.apache.maven.plugin.logging.Log;
/*     */ 
/*     */ public class BuildMojo extends AbstractMojo
/*     */ {
/*  45 */   private String classPath = null;
/*     */ 
/*  51 */   private String[] classPaths = null;
/*     */ 
/*  57 */   private File outputDirectory = null;
/*     */ 
/*  63 */   private String outputName = null;
/*     */ 
/*  69 */   private boolean compile = true;
/*     */ 
/*  75 */   private boolean header = false;
/*     */ 
/*  81 */   private boolean copyLibs = false;
/*     */ 
/*  87 */   private String jarPrefix = null;
/*     */ 
/*  93 */   private String properties = null;
/*     */ 
/*  99 */   private File propertyFile = null;
/*     */ 
/* 105 */   private Properties propertyKeysAndValues = null;
/*     */ 
/* 111 */   private String classOrPackageName = null;
/*     */ 
/* 117 */   private String[] classOrPackageNames = null;
/*     */ 
/* 123 */   private Map<String, String> environmentVariables = null;
/*     */ 
/* 129 */   private String[] compilerOptions = null;
/*     */ 
/* 135 */   private boolean skip = false;
/*     */ 
/*     */   public void execute() throws MojoExecutionException {
/*     */     try {
/* 139 */       getLog().info("Executing JavaCPP Builder");
/* 140 */       if (getLog().isDebugEnabled()) {
/* 141 */         getLog().debug("classPath: " + this.classPath);
/* 142 */         getLog().debug("classPaths: " + Arrays.deepToString(this.classPaths));
/* 143 */         getLog().debug("outputDirectory: " + this.outputDirectory);
/* 144 */         getLog().debug("outputName: " + this.outputName);
/* 145 */         getLog().debug("compile: " + this.compile);
/* 146 */         getLog().debug("header: " + this.header);
/* 147 */         getLog().debug("copyLibs: " + this.copyLibs);
/* 148 */         getLog().debug("jarPrefix: " + this.jarPrefix);
/* 149 */         getLog().debug("properties: " + this.properties);
/* 150 */         getLog().debug("propertyFile: " + this.propertyFile);
/* 151 */         getLog().debug("propertyKeysAndValues: " + this.propertyKeysAndValues);
/* 152 */         getLog().debug("classOrPackageName: " + this.classOrPackageName);
/* 153 */         getLog().debug("classOrPackageNames: " + Arrays.deepToString(this.classOrPackageNames));
/* 154 */         getLog().debug("environmentVariables: " + this.environmentVariables);
/* 155 */         getLog().debug("compilerOptions: " + Arrays.deepToString(this.compilerOptions));
/* 156 */         getLog().debug("skip: " + this.skip);
/*     */       }
/*     */ 
/* 159 */       if (this.skip) {
/* 160 */         getLog().info("Skipped execution of JavaCPP Builder");
/* 161 */         return;
/*     */       }
/*     */ 
/* 164 */       if ((this.classPaths != null) && (this.classPath != null)) {
/* 165 */         this.classPaths = ((String[])Arrays.copyOf(this.classPaths, this.classPaths.length + 1));
/* 166 */         this.classPaths[(this.classPaths.length - 1)] = this.classPath;
/* 167 */       } else if (this.classPath != null) {
/* 168 */         this.classPaths = new String[] { this.classPath };
/*     */       }
/*     */ 
/* 171 */       if ((this.classOrPackageNames != null) && (this.classOrPackageName != null)) {
/* 172 */         this.classOrPackageNames = ((String[])Arrays.copyOf(this.classOrPackageNames, this.classOrPackageNames.length + 1));
/* 173 */         this.classOrPackageNames[(this.classOrPackageNames.length - 1)] = this.classOrPackageName;
/* 174 */       } else if (this.classOrPackageName != null) {
/* 175 */         this.classOrPackageNames = new String[] { this.classOrPackageName };
/*     */       }
/*     */ 
/* 178 */       File[] outputFiles = new Builder().classPaths(this.classPaths).outputDirectory(this.outputDirectory).outputName(this.outputName).compile(this.compile).header(this.header).copyLibs(this.copyLibs).jarPrefix(this.jarPrefix).properties(this.properties).propertyFile(this.propertyFile).properties(this.propertyKeysAndValues).classesOrPackages(this.classOrPackageNames).environmentVariables(this.environmentVariables).compilerOptions(this.compilerOptions).build();
/*     */ 
/* 192 */       getLog().info("Successfully executed JavaCPP Builder");
/* 193 */       if (getLog().isDebugEnabled())
/* 194 */         getLog().debug("outputFiles: " + Arrays.deepToString(outputFiles));
/*     */     }
/*     */     catch (Exception e) {
/* 197 */       getLog().error("Failed to execute JavaCPP Builder: " + e.getMessage());
/* 198 */       throw new MojoExecutionException("Failed to execute JavaCPP Builder", e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.BuildMojo
 * JD-Core Version:    0.6.2
 */