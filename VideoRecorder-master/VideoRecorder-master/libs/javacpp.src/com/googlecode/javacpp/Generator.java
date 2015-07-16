/*      */ package com.googlecode.javacpp;
/*      */ 
/*      */ import com.googlecode.javacpp.annotation.Adapter;
/*      */ import com.googlecode.javacpp.annotation.Allocator;
/*      */ import com.googlecode.javacpp.annotation.ArrayAllocator;
/*      */ import com.googlecode.javacpp.annotation.ByPtr;
/*      */ import com.googlecode.javacpp.annotation.ByPtrPtr;
/*      */ import com.googlecode.javacpp.annotation.ByPtrRef;
/*      */ import com.googlecode.javacpp.annotation.ByRef;
/*      */ import com.googlecode.javacpp.annotation.ByVal;
/*      */ import com.googlecode.javacpp.annotation.Cast;
/*      */ import com.googlecode.javacpp.annotation.Const;
/*      */ import com.googlecode.javacpp.annotation.Convention;
/*      */ import com.googlecode.javacpp.annotation.Function;
/*      */ import com.googlecode.javacpp.annotation.Index;
/*      */ import com.googlecode.javacpp.annotation.MemberGetter;
/*      */ import com.googlecode.javacpp.annotation.MemberSetter;
/*      */ import com.googlecode.javacpp.annotation.Name;
/*      */ import com.googlecode.javacpp.annotation.Namespace;
/*      */ import com.googlecode.javacpp.annotation.NoDeallocator;
/*      */ import com.googlecode.javacpp.annotation.NoException;
/*      */ import com.googlecode.javacpp.annotation.NoOffset;
/*      */ import com.googlecode.javacpp.annotation.Opaque;
/*      */ import com.googlecode.javacpp.annotation.Platform;
/*      */ import com.googlecode.javacpp.annotation.Properties;
/*      */ import com.googlecode.javacpp.annotation.Raw;
/*      */ import com.googlecode.javacpp.annotation.ValueGetter;
/*      */ import com.googlecode.javacpp.annotation.ValueSetter;
/*      */ import java.io.Closeable;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.Writer;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.CharBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ public class Generator
/*      */   implements Closeable
/*      */ {
/*      */   public static final String JNI_VERSION = "JNI_VERSION_1_4";
/*  132 */   private static final Logger logger = Logger.getLogger(Generator.class.getName());
/*      */ 
/*  134 */   private static final List<Class> baseClasses = Arrays.asList(new Class[] { Pointer.class, BytePointer.class, ShortPointer.class, IntPointer.class, LongPointer.class, FloatPointer.class, DoublePointer.class, CharPointer.class, PointerPointer.class, BoolPointer.class, CLongPointer.class, SizeTPointer.class });
/*      */   private Loader.ClassProperties properties;
/*      */   private PrintWriter out;
/*      */   private PrintWriter out2;
/*      */   private LinkedListRegister<String> callbacks;
/*      */   private LinkedListRegister<Class> functions;
/*      */   private LinkedListRegister<Class> deallocators;
/*      */   private LinkedListRegister<Class> arrayDeallocators;
/*      */   private LinkedListRegister<Class> jclasses;
/*      */   private LinkedListRegister<Class> jclassesInit;
/*      */   private HashMap<Class, LinkedList<String>> members;
/*      */   private boolean mayThrowExceptions;
/*      */   private boolean usesAdapters;
/*      */ 
/*      */   public Generator(Loader.ClassProperties properties)
/*      */   {
/*  116 */     this.properties = properties;
/*      */   }
/*      */ 
/*      */   public boolean generate(String sourceFilename, String headerFilename, String classPath, Class<?>[] classes)
/*      */     throws FileNotFoundException
/*      */   {
/*  159 */     this.out = new PrintWriter(new Writer()
/*      */     {
/*      */       public void write(char[] cbuf, int off, int len)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void flush()
/*      */       {
/*      */       }
/*      */ 
/*      */       public void close()
/*      */       {
/*      */       }
/*      */     });
/*  164 */     this.out2 = null;
/*  165 */     this.callbacks = new LinkedListRegister();
/*  166 */     this.functions = new LinkedListRegister();
/*  167 */     this.deallocators = new LinkedListRegister();
/*  168 */     this.arrayDeallocators = new LinkedListRegister();
/*  169 */     this.jclasses = new LinkedListRegister();
/*  170 */     this.jclassesInit = new LinkedListRegister();
/*  171 */     this.members = new HashMap();
/*  172 */     this.mayThrowExceptions = false;
/*  173 */     this.usesAdapters = false;
/*  174 */     if (doClasses(true, true, classPath, classes))
/*      */     {
/*  176 */       this.out = new PrintWriter(sourceFilename);
/*  177 */       if (headerFilename != null) {
/*  178 */         this.out2 = new PrintWriter(headerFilename);
/*      */       }
/*  180 */       return doClasses(this.mayThrowExceptions, this.usesAdapters, classPath, classes);
/*      */     }
/*  182 */     return false;
/*      */   }
/*      */ 
/*      */   public void close()
/*      */   {
/*  187 */     if (this.out != null) {
/*  188 */       this.out.close();
/*      */     }
/*  190 */     if (this.out2 != null)
/*  191 */       this.out2.close();
/*      */   }
/*      */ 
/*      */   private boolean doClasses(boolean handleExceptions, boolean defineAdapters, String classPath, Class<?>[] classes)
/*      */   {
/*  196 */     this.out.println("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */");
/*  197 */     this.out.println();
/*  198 */     if (this.out2 != null) {
/*  199 */       this.out2.println("/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */");
/*  200 */       this.out2.println();
/*      */     }
/*  202 */     for (String s : this.properties.get("generator.define")) {
/*  203 */       this.out.println("#define " + s);
/*      */     }
/*  205 */     this.out.println();
/*  206 */     this.out.println("#ifdef __APPLE__");
/*  207 */     this.out.println("    #define _JAVASOFT_JNI_MD_H_");
/*  208 */     this.out.println();
/*  209 */     this.out.println("    #define JNIEXPORT __attribute__((visibility(\"default\")))");
/*  210 */     this.out.println("    #define JNIIMPORT");
/*  211 */     this.out.println("    #define JNICALL");
/*  212 */     this.out.println();
/*  213 */     this.out.println("    typedef int jint;");
/*  214 */     this.out.println("    typedef long long jlong;");
/*  215 */     this.out.println("    typedef signed char jbyte;");
/*  216 */     this.out.println("#endif");
/*  217 */     this.out.println("#ifdef _WIN32");
/*  218 */     this.out.println("    #define _JAVASOFT_JNI_MD_H_");
/*  219 */     this.out.println();
/*  220 */     this.out.println("    #define JNIEXPORT __declspec(dllexport)");
/*  221 */     this.out.println("    #define JNIIMPORT __declspec(dllimport)");
/*  222 */     this.out.println("    #define JNICALL __stdcall");
/*  223 */     this.out.println();
/*  224 */     this.out.println("    typedef int jint;");
/*  225 */     this.out.println("    typedef long long jlong;");
/*  226 */     this.out.println("    typedef signed char jbyte;");
/*  227 */     this.out.println("#endif");
/*  228 */     this.out.println("#include <jni.h>");
/*  229 */     if (this.out2 != null) {
/*  230 */       this.out2.println("#include <jni.h>");
/*      */     }
/*  232 */     this.out.println("#ifdef ANDROID");
/*  233 */     this.out.println("    #include <android/log.h>");
/*  234 */     this.out.println("#elif defined(__APPLE__) && defined(__OBJC__)");
/*  235 */     this.out.println("    #include <TargetConditionals.h>");
/*  236 */     this.out.println("    #include <Foundation/Foundation.h>");
/*  237 */     this.out.println("#endif");
/*  238 */     this.out.println("#if defined(ANDROID) || TARGET_OS_IPHONE");
/*  239 */     this.out.println("    #define NewWeakGlobalRef(obj) NewGlobalRef(obj)");
/*  240 */     this.out.println("    #define DeleteWeakGlobalRef(obj) DeleteGlobalRef(obj)");
/*  241 */     this.out.println("#endif");
/*  242 */     this.out.println();
/*  243 */     this.out.println("#include <stddef.h>");
/*  244 */     this.out.println("#ifndef _WIN32");
/*  245 */     this.out.println("    #include <stdint.h>");
/*  246 */     this.out.println("#endif");
/*  247 */     this.out.println("#include <stdio.h>");
/*  248 */     this.out.println("#include <stdlib.h>");
/*  249 */     this.out.println("#include <string.h>");
/*  250 */     this.out.println("#include <exception>");
/*  251 */     this.out.println("#include <new>");
/*  252 */     this.out.println();
/*  253 */     this.out.println("#define jlong_to_ptr(a) ((void*)(uintptr_t)(a))");
/*  254 */     this.out.println("#define ptr_to_jlong(a) ((jlong)(uintptr_t)(a))");
/*  255 */     this.out.println();
/*  256 */     this.out.println("#if defined(_MSC_VER)");
/*  257 */     this.out.println("    #define JavaCPP_noinline __declspec(noinline)");
/*  258 */     this.out.println("    #define JavaCPP_hidden /* hidden by default */");
/*  259 */     this.out.println("#elif defined(__GNUC__)");
/*  260 */     this.out.println("    #define JavaCPP_noinline __attribute__((noinline))");
/*  261 */     this.out.println("    #define JavaCPP_hidden   __attribute__((visibility(\"hidden\")))");
/*  262 */     this.out.println("#else");
/*  263 */     this.out.println("    #define JavaCPP_noinline");
/*  264 */     this.out.println("    #define JavaCPP_hidden");
/*  265 */     this.out.println("#endif");
/*  266 */     this.out.println();
/*  267 */     List[] include = { this.properties.get("generator.include"), this.properties.get("generator.cinclude") };
/*      */ 
/*  269 */     for (int i = 0; i < include.length; i++) {
/*  270 */       if ((include[i] != null) && (include[i].size() > 0)) {
/*  271 */         if (i == 1) {
/*  272 */           this.out.println("extern \"C\" {");
/*  273 */           if (this.out2 != null) {
/*  274 */             this.out2.println("#ifdef __cplusplus");
/*  275 */             this.out2.println("extern \"C\" {");
/*  276 */             this.out2.println("#endif");
/*      */           }
/*      */         }
/*  279 */         for (String s : include[i]) {
/*  280 */           String line = "#include ";
/*  281 */           if ((!s.startsWith("<")) && (!s.startsWith("\""))) {
/*  282 */             line = line + '"';
/*      */           }
/*  284 */           line = line + s;
/*  285 */           if ((!s.endsWith(">")) && (!s.endsWith("\""))) {
/*  286 */             line = line + '"';
/*      */           }
/*  288 */           this.out.println(line);
/*  289 */           if (this.out2 != null) {
/*  290 */             this.out2.println(line);
/*      */           }
/*      */         }
/*  293 */         if (i == 1) {
/*  294 */           this.out.println("}");
/*  295 */           if (this.out2 != null) {
/*  296 */             this.out2.println("#ifdef __cplusplus");
/*  297 */             this.out2.println("}");
/*  298 */             this.out2.println("#endif");
/*      */           }
/*      */         }
/*  301 */         this.out.println();
/*      */       }
/*      */     }
/*  304 */     this.out.println("static JavaVM* JavaCPP_vm = NULL;");
/*  305 */     this.out.println("static const char* JavaCPP_classNames[" + this.jclasses.size() + "] = {");
/*  306 */     Iterator classIterator = this.jclasses.iterator();
/*  307 */     int maxMemberSize = 0;
/*  308 */     while (classIterator.hasNext()) {
/*  309 */       Class c = (Class)classIterator.next();
/*  310 */       this.out.print("        \"" + c.getName().replace('.', '/') + "\"");
/*  311 */       if (classIterator.hasNext()) {
/*  312 */         this.out.println(",");
/*      */       }
/*  314 */       LinkedList m = (LinkedList)this.members.get(c);
/*  315 */       if ((m != null) && (m.size() > maxMemberSize)) {
/*  316 */         maxMemberSize = m.size();
/*      */       }
/*      */     }
/*  319 */     this.out.println(" };");
/*  320 */     this.out.println("static jclass JavaCPP_classes[" + this.jclasses.size() + "] = { NULL };");
/*  321 */     this.out.println("static jmethodID JavaCPP_initMID = NULL;");
/*  322 */     this.out.println("static jfieldID JavaCPP_addressFID = NULL;");
/*  323 */     this.out.println("static jfieldID JavaCPP_positionFID = NULL;");
/*  324 */     this.out.println("static jfieldID JavaCPP_limitFID = NULL;");
/*  325 */     this.out.println("static jfieldID JavaCPP_capacityFID = NULL;");
/*  326 */     this.out.println();
/*  327 */     this.out.println("static inline void JavaCPP_log(const char* fmt, ...) {");
/*  328 */     this.out.println("    va_list ap;");
/*  329 */     this.out.println("    va_start(ap, fmt);");
/*  330 */     this.out.println("#ifdef ANDROID");
/*  331 */     this.out.println("    __android_log_vprint(ANDROID_LOG_ERROR, \"javacpp\", fmt, ap);");
/*  332 */     this.out.println("#elif defined(__APPLE__) && defined(__OBJC__)");
/*  333 */     this.out.println("    NSLogv([NSString stringWithUTF8String:fmt], ap);");
/*  334 */     this.out.println("#else");
/*  335 */     this.out.println("    vfprintf(stderr, fmt, ap);");
/*  336 */     this.out.println("    fprintf(stderr, \"\\n\");");
/*  337 */     this.out.println("#endif");
/*  338 */     this.out.println("    va_end(ap);");
/*  339 */     this.out.println("}");
/*  340 */     this.out.println();
/*  341 */     this.out.println("static JavaCPP_noinline jclass JavaCPP_getClass(JNIEnv* env, int i) {");
/*  342 */     this.out.println("    if (JavaCPP_classes[i] == NULL && env->PushLocalFrame(1) == 0) {");
/*  343 */     this.out.println("        jclass cls = env->FindClass(JavaCPP_classNames[i]);");
/*  344 */     this.out.println("        if (cls == NULL || env->ExceptionCheck()) {");
/*  345 */     this.out.println("            JavaCPP_log(\"Error loading class %s.\", JavaCPP_classNames[i]);");
/*  346 */     this.out.println("            return NULL;");
/*  347 */     this.out.println("        }");
/*  348 */     this.out.println("        JavaCPP_classes[i] = (jclass)env->NewWeakGlobalRef(cls);");
/*  349 */     this.out.println("        if (JavaCPP_classes[i] == NULL || env->ExceptionCheck()) {");
/*  350 */     this.out.println("            JavaCPP_log(\"Error creating global reference of class %s.\", JavaCPP_classNames[i]);");
/*  351 */     this.out.println("            return NULL;");
/*  352 */     this.out.println("        }");
/*  353 */     this.out.println("        env->PopLocalFrame(NULL);");
/*  354 */     this.out.println("    }");
/*  355 */     this.out.println("    return JavaCPP_classes[i];");
/*  356 */     this.out.println("}");
/*  357 */     this.out.println();
/*  358 */     this.out.println("class JavaCPP_hidden JavaCPP_exception : public std::exception {");
/*  359 */     this.out.println("public:");
/*  360 */     this.out.println("    JavaCPP_exception(const char* str) throw() {");
/*  361 */     this.out.println("        if (str == NULL) {");
/*  362 */     this.out.println("            strcpy(msg, \"Unknown exception.\");");
/*  363 */     this.out.println("        } else {");
/*  364 */     this.out.println("            strncpy(msg, str, sizeof(msg));");
/*  365 */     this.out.println("            msg[sizeof(msg) - 1] = 0;");
/*  366 */     this.out.println("        }");
/*  367 */     this.out.println("    }");
/*  368 */     this.out.println("    virtual const char* what() const throw() { return msg; }");
/*  369 */     this.out.println("    char msg[1024];");
/*  370 */     this.out.println("};");
/*  371 */     this.out.println();
/*  372 */     if (handleExceptions) {
/*  373 */       this.out.println("static JavaCPP_noinline jthrowable JavaCPP_handleException(JNIEnv* env, int i) {");
/*  374 */       this.out.println("    jstring str = NULL;");
/*  375 */       this.out.println("    try {");
/*  376 */       this.out.println("        throw;");
/*  377 */       this.out.println("    } catch (std::exception& e) {");
/*  378 */       this.out.println("        str = env->NewStringUTF(e.what());");
/*  379 */       this.out.println("    } catch (...) {");
/*  380 */       this.out.println("        str = env->NewStringUTF(\"Unknown exception.\");");
/*  381 */       this.out.println("    }");
/*  382 */       this.out.println("    jclass cls = JavaCPP_getClass(env, i);");
/*  383 */       this.out.println("    jmethodID mid = env->GetMethodID(cls, \"<init>\", \"(Ljava/lang/String;)V\");");
/*  384 */       this.out.println("    if (mid == NULL || env->ExceptionCheck()) {");
/*  385 */       this.out.println("        JavaCPP_log(\"Error getting constructor ID of %s.\", JavaCPP_classNames[i]);");
/*  386 */       this.out.println("        return NULL;");
/*  387 */       this.out.println("    } else {");
/*  388 */       this.out.println("        return (jthrowable)env->NewObject(cls, mid, str);");
/*  389 */       this.out.println("    }");
/*  390 */       this.out.println("}");
/*  391 */       this.out.println();
/*      */     }
/*  393 */     if (defineAdapters) {
/*  394 */       this.out.println("#include <vector>");
/*  395 */       this.out.println("template<typename P, typename T = P> class JavaCPP_hidden VectorAdapter {");
/*  396 */       this.out.println("public:");
/*  397 */       this.out.println("    VectorAdapter(const P* ptr, typename std::vector<T>::size_type size) : ptr((P*)ptr), size(size),");
/*  398 */       this.out.println("        vec2(ptr ? std::vector<T>((P*)ptr, (P*)ptr + size) : std::vector<T>()), vec(vec2) { }");
/*  399 */       this.out.println("    VectorAdapter(const std::vector<T>& vec) : ptr(0), size(0), vec2(vec), vec(vec2) { }");
/*  400 */       this.out.println("    VectorAdapter(      std::vector<T>& vec) : ptr(0), size(0), vec(vec) { }");
/*  401 */       this.out.println("    void assign(P* ptr, typename std::vector<T>::size_type size) {");
/*  402 */       this.out.println("        this->ptr = ptr;");
/*  403 */       this.out.println("        this->size = size;");
/*  404 */       this.out.println("        vec.assign(ptr, ptr + size);");
/*  405 */       this.out.println("    }");
/*  406 */       this.out.println("    static void deallocate(P* ptr) { delete[] ptr; }");
/*  407 */       this.out.println("    operator P*() {");
/*  408 */       this.out.println("        if (vec.size() > size) {");
/*  409 */       this.out.println("            ptr = new (std::nothrow) P[vec.size()];");
/*  410 */       this.out.println("        }");
/*  411 */       this.out.println("        if (ptr) {");
/*  412 */       this.out.println("            std::copy(vec.begin(), vec.end(), ptr);");
/*  413 */       this.out.println("        }");
/*  414 */       this.out.println("        size = vec.size();");
/*  415 */       this.out.println("        return ptr;");
/*  416 */       this.out.println("    }");
/*  417 */       this.out.println("    operator const P*()        { return &vec[0]; }");
/*  418 */       this.out.println("    operator std::vector<T>&() { return vec; }");
/*  419 */       this.out.println("    operator std::vector<T>*() { return ptr ? &vec : 0; }");
/*  420 */       this.out.println("    P* ptr;");
/*  421 */       this.out.println("    typename std::vector<T>::size_type size;");
/*  422 */       this.out.println("    std::vector<T> vec2;");
/*  423 */       this.out.println("    std::vector<T>& vec;");
/*  424 */       this.out.println("};");
/*  425 */       this.out.println();
/*  426 */       this.out.println("#include <string>");
/*  427 */       this.out.println("class JavaCPP_hidden StringAdapter {");
/*  428 */       this.out.println("public:");
/*  429 */       this.out.println("    StringAdapter(const          char* ptr, size_t size) : ptr((char*)ptr), size(size),");
/*  430 */       this.out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
/*  431 */       this.out.println("    StringAdapter(const signed   char* ptr, size_t size) : ptr((char*)ptr), size(size),");
/*  432 */       this.out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
/*  433 */       this.out.println("    StringAdapter(const unsigned char* ptr, size_t size) : ptr((char*)ptr), size(size),");
/*  434 */       this.out.println("        str2(ptr ? (char*)ptr : \"\"), str(str2) { }");
/*  435 */       this.out.println("    StringAdapter(const std::string& str) : ptr(0), size(0), str2(str), str(str2) { }");
/*  436 */       this.out.println("    StringAdapter(      std::string& str) : ptr(0), size(0), str(str) { }");
/*  437 */       this.out.println("    void assign(char* ptr, size_t size) {");
/*  438 */       this.out.println("        this->ptr = ptr;");
/*  439 */       this.out.println("        this->size = size;");
/*  440 */       this.out.println("        str.assign(ptr ? ptr : \"\");");
/*  441 */       this.out.println("    }");
/*  442 */       this.out.println("    static void deallocate(char* ptr) { free(ptr); }");
/*  443 */       this.out.println("    operator char*() {");
/*  444 */       this.out.println("        const char* c_str = str.c_str();");
/*  445 */       this.out.println("        if (ptr == NULL || strcmp(c_str, ptr) != 0) {");
/*  446 */       this.out.println("            ptr = strdup(c_str);");
/*  447 */       this.out.println("        }");
/*  448 */       this.out.println("        size = strlen(c_str) + 1;");
/*  449 */       this.out.println("        return ptr;");
/*  450 */       this.out.println("    }");
/*  451 */       this.out.println("    operator       signed   char*() { return (signed   char*)(operator char*)(); }");
/*  452 */       this.out.println("    operator       unsigned char*() { return (unsigned char*)(operator char*)(); }");
/*  453 */       this.out.println("    operator const          char*() { return                 str.c_str(); }");
/*  454 */       this.out.println("    operator const signed   char*() { return (signed   char*)str.c_str(); }");
/*  455 */       this.out.println("    operator const unsigned char*() { return (unsigned char*)str.c_str(); }");
/*  456 */       this.out.println("    operator         std::string&() { return str; }");
/*  457 */       this.out.println("    operator         std::string*() { return ptr ? &str : 0; }");
/*  458 */       this.out.println("    char* ptr;");
/*  459 */       this.out.println("    size_t size;");
/*  460 */       this.out.println("    std::string str2;");
/*  461 */       this.out.println("    std::string& str;");
/*  462 */       this.out.println("};");
/*  463 */       this.out.println();
/*      */     }
/*  465 */     if (!this.functions.isEmpty()) {
/*  466 */       this.out.println("static JavaCPP_noinline void JavaCPP_detach(int detach) {");
/*  467 */       this.out.println("    if (detach > 0 && JavaCPP_vm->DetachCurrentThread() != 0) {");
/*  468 */       this.out.println("        JavaCPP_log(\"Could not detach the JavaVM from the current thread.\");");
/*  469 */       this.out.println("    }");
/*  470 */       this.out.println("}");
/*  471 */       this.out.println();
/*  472 */       this.out.println("static JavaCPP_noinline int JavaCPP_getEnv(JNIEnv** env) {");
/*  473 */       this.out.println("    int attached = 0;");
/*  474 */       this.out.println("    struct {");
/*  475 */       this.out.println("        JNIEnv **env;");
/*  476 */       this.out.println("        operator JNIEnv**() { return env; } // Android JNI");
/*  477 */       this.out.println("        operator void**() { return (void**)env; } // standard JNI");
/*  478 */       this.out.println("    } env2 = { env };");
/*  479 */       this.out.println("    JavaVM *vm = JavaCPP_vm;");
/*  480 */       this.out.println("    if (vm == NULL) {");
/*  481 */       if (this.out2 != null) {
/*  482 */         this.out.println("#if !defined(ANDROID) && !TARGET_OS_IPHONE");
/*  483 */         this.out.println("        int size = 1;");
/*  484 */         this.out.println("        if (JNI_GetCreatedJavaVMs(&vm, 1, &size) != 0 || size == 0) {");
/*  485 */         this.out.println("#endif");
/*      */       }
/*  487 */       this.out.println("            JavaCPP_log(\"Could not get any created JavaVM.\");");
/*  488 */       this.out.println("            return -1;");
/*  489 */       if (this.out2 != null) {
/*  490 */         this.out.println("#if !defined(ANDROID) && !TARGET_OS_IPHONE");
/*  491 */         this.out.println("        }");
/*  492 */         this.out.println("#endif");
/*      */       }
/*  494 */       this.out.println("    }");
/*  495 */       this.out.println("    if (vm->GetEnv((void**)env, JNI_VERSION_1_4) != JNI_OK) {");
/*  496 */       this.out.println("        if (vm->AttachCurrentThread(env2, NULL) != 0) {");
/*  497 */       this.out.println("            JavaCPP_log(\"Could not attach the JavaVM to the current thread.\");");
/*  498 */       this.out.println("            return -1;");
/*  499 */       this.out.println("        }");
/*  500 */       this.out.println("        attached = 1;");
/*  501 */       this.out.println("    }");
/*  502 */       this.out.println("    if (JavaCPP_vm == NULL) {");
/*  503 */       this.out.println("        if (JNI_OnLoad(vm, NULL) < 0) {");
/*  504 */       this.out.println("            JavaCPP_detach(attached);");
/*  505 */       this.out.println("            return -1;");
/*  506 */       this.out.println("        }");
/*  507 */       this.out.println("    }");
/*  508 */       this.out.println("    return attached;");
/*  509 */       this.out.println("}");
/*  510 */       this.out.println();
/*      */     }
/*  512 */     for (Class c : this.functions) {
/*  513 */       String[] typeName = getCPPTypeName(c);
/*  514 */       String[] returnConvention = typeName[0].split("\\(");
/*  515 */       returnConvention[1] = getConstValueTypeName(new String[] { returnConvention[1] });
/*  516 */       String parameterDeclaration = typeName[1].substring(1);
/*  517 */       String instanceTypeName = getFunctionClassName(c);
/*  518 */       this.out.println("struct JavaCPP_hidden " + instanceTypeName + " {\n" + "    " + instanceTypeName + "() : ptr(NULL), obj(NULL) { }\n" + "    " + returnConvention[0] + "operator()" + parameterDeclaration + ";\n" + "    " + typeName[0] + "ptr" + typeName[1] + ";\n" + "    jobject obj; static jmethodID mid;\n" + "};\n" + "jmethodID " + instanceTypeName + "::mid = NULL;");
/*      */     }
/*      */ 
/*  526 */     this.out.println();
/*  527 */     for (String s : this.callbacks) {
/*  528 */       this.out.println(s);
/*      */     }
/*  530 */     this.out.println();
/*  531 */     for (Class c : this.deallocators) {
/*  532 */       String name = "JavaCPP_" + mangle(c.getName());
/*  533 */       this.out.print("static void " + name + "_deallocate(");
/*  534 */       if (FunctionPointer.class.isAssignableFrom(c)) {
/*  535 */         String typeName = getFunctionClassName(c);
/*  536 */         this.out.println(typeName + "* p) { JNIEnv *e; int a = JavaCPP_getEnv(&e); if (a >= 0) e->DeleteWeakGlobalRef(p->obj); delete p; JavaCPP_detach(a); }");
/*      */       } else {
/*  538 */         String[] typeName = getCPPTypeName(c);
/*  539 */         this.out.println(typeName[0] + " p" + typeName[1] + ") { delete p; }");
/*      */       }
/*      */     }
/*  542 */     for (Class c : this.arrayDeallocators) {
/*  543 */       String name = "JavaCPP_" + mangle(c.getName());
/*  544 */       String[] typeName = getCPPTypeName(c);
/*  545 */       this.out.println("static void " + name + "_deallocateArray(" + typeName[0] + " p" + typeName[1] + ") { delete[] p; }");
/*      */     }
/*  547 */     this.out.println();
/*  548 */     this.out.println("extern \"C\" {");
/*  549 */     if (this.out2 != null) {
/*  550 */       this.out2.println();
/*  551 */       this.out2.println("#ifdef __cplusplus");
/*  552 */       this.out2.println("extern \"C\" {");
/*  553 */       this.out2.println("#endif");
/*  554 */       this.out2.println("JNIIMPORT int JavaCPP_init(int argc, const char *argv[]);");
/*  555 */       this.out.println();
/*  556 */       this.out.println("JNIEXPORT int JavaCPP_init(int argc, const char *argv[]) {");
/*  557 */       this.out.println("#if defined(ANDROID) || TARGET_OS_IPHONE");
/*  558 */       this.out.println("    return JNI_OK;");
/*  559 */       this.out.println("#else");
/*  560 */       this.out.println("    JavaVM *vm;");
/*  561 */       this.out.println("    JNIEnv *env;");
/*  562 */       this.out.println("    int nOptions = 1 + (argc > 255 ? 255 : argc);");
/*  563 */       this.out.println("    JavaVMOption options[256] = { { NULL } };");
/*  564 */       this.out.println("    options[0].optionString = (char*)\"-Djava.class.path=" + classPath.replace('\\', '/') + "\";");
/*  565 */       this.out.println("    for (int i = 1; i < nOptions && argv != NULL; i++) {");
/*  566 */       this.out.println("        options[i].optionString = (char*)argv[i - 1];");
/*  567 */       this.out.println("    }");
/*  568 */       this.out.println("    JavaVMInitArgs vm_args = { JNI_VERSION_1_4, nOptions, options };");
/*  569 */       this.out.println("    return JNI_CreateJavaVM(&vm, (void **)&env, &vm_args);");
/*  570 */       this.out.println("#endif");
/*  571 */       this.out.println("}");
/*      */     }
/*  573 */     this.out.println();
/*  574 */     this.out.println("JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {");
/*  575 */     this.out.println("    JNIEnv* env;");
/*  576 */     this.out.println("    if (vm->GetEnv((void**)&env, JNI_VERSION_1_4) != JNI_OK) {");
/*  577 */     this.out.println("        JavaCPP_log(\"Could not get JNIEnv for JNI_VERSION_1_4 inside JNI_OnLoad().\");");
/*  578 */     this.out.println("        return JNI_ERR;");
/*  579 */     this.out.println("    }");
/*  580 */     this.out.println("    if (JavaCPP_vm == vm) {");
/*  581 */     this.out.println("        return env->GetVersion();");
/*  582 */     this.out.println("    }");
/*  583 */     this.out.println("    JavaCPP_vm = vm;");
/*  584 */     this.out.println("    const char* members[" + this.jclasses.size() + "][" + maxMemberSize + "] = {");
/*  585 */     classIterator = this.jclasses.iterator();
/*  586 */     while (classIterator.hasNext()) {
/*  587 */       this.out.print("            { ");
/*  588 */       LinkedList m = (LinkedList)this.members.get(classIterator.next());
/*  589 */       Iterator memberIterator = m == null ? null : m.iterator();
/*  590 */       while ((memberIterator != null) && (memberIterator.hasNext())) {
/*  591 */         this.out.print("\"" + (String)memberIterator.next() + "\"");
/*  592 */         if (memberIterator.hasNext()) {
/*  593 */           this.out.print(", ");
/*      */         }
/*      */       }
/*  596 */       this.out.print(" }");
/*  597 */       if (classIterator.hasNext()) {
/*  598 */         this.out.println(",");
/*      */       }
/*      */     }
/*  601 */     this.out.println(" };");
/*  602 */     this.out.println("    int offsets[" + this.jclasses.size() + "][" + maxMemberSize + "] = {");
/*  603 */     classIterator = this.jclasses.iterator();
/*  604 */     while (classIterator.hasNext()) {
/*  605 */       this.out.print("            { ");
/*  606 */       Class c = (Class)classIterator.next();
/*  607 */       LinkedList m = (LinkedList)this.members.get(c);
/*  608 */       Iterator memberIterator = m == null ? null : m.iterator();
/*  609 */       while ((memberIterator != null) && (memberIterator.hasNext())) {
/*  610 */         String[] typeName = getCPPTypeName(c);
/*  611 */         String valueTypeName = getValueTypeName(typeName);
/*  612 */         String memberName = (String)memberIterator.next();
/*  613 */         if ("sizeof".equals(memberName)) {
/*  614 */           if ("void".equals(valueTypeName)) {
/*  615 */             valueTypeName = "void*";
/*      */           }
/*  617 */           this.out.print("sizeof(" + valueTypeName + ")");
/*      */         } else {
/*  619 */           this.out.print("offsetof(" + valueTypeName + "," + memberName + ")");
/*      */         }
/*  621 */         if (memberIterator.hasNext()) {
/*  622 */           this.out.print(", ");
/*      */         }
/*      */       }
/*  625 */       this.out.print(" }");
/*  626 */       if (classIterator.hasNext()) {
/*  627 */         this.out.println(",");
/*      */       }
/*      */     }
/*  630 */     this.out.println(" };");
/*  631 */     this.out.print("    int memberOffsetSizes[" + this.jclasses.size() + "] = { ");
/*  632 */     classIterator = this.jclasses.iterator();
/*  633 */     while (classIterator.hasNext()) {
/*  634 */       LinkedList m = (LinkedList)this.members.get(classIterator.next());
/*  635 */       this.out.print(m == null ? 0 : m.size());
/*  636 */       if (classIterator.hasNext()) {
/*  637 */         this.out.print(", ");
/*      */       }
/*      */     }
/*  640 */     this.out.println(" };");
/*  641 */     this.out.println("    jmethodID putMemberOffsetMID = env->GetStaticMethodID(JavaCPP_getClass(env, " + this.jclasses.register(Loader.class) + "), \"putMemberOffset\", \"(Ljava/lang/String;Ljava/lang/String;I)V\");");
/*      */ 
/*  643 */     this.out.println("    if (putMemberOffsetMID == NULL || env->ExceptionCheck()) {");
/*  644 */     this.out.println("        JavaCPP_log(\"Error getting method ID of Loader.putMemberOffset().\");");
/*  645 */     this.out.println("        return JNI_ERR;");
/*  646 */     this.out.println("    }");
/*  647 */     this.out.println("    for (int i = 0; i < " + this.jclasses.size() + " && !env->ExceptionCheck(); i++) {");
/*  648 */     this.out.println("        for (int j = 0; j < memberOffsetSizes[i] && !env->ExceptionCheck(); j++) {");
/*  649 */     this.out.println("            if (env->PushLocalFrame(2) == 0) {");
/*  650 */     this.out.println("                jvalue args[3];");
/*  651 */     this.out.println("                args[0].l = env->NewStringUTF(JavaCPP_classNames[i]);");
/*  652 */     this.out.println("                args[1].l = env->NewStringUTF(members[i][j]);");
/*  653 */     this.out.println("                args[2].i = offsets[i][j];");
/*  654 */     this.out.println("                env->CallStaticVoidMethodA(JavaCPP_getClass(env, " + this.jclasses.register(Loader.class) + "), putMemberOffsetMID, args);");
/*      */ 
/*  656 */     this.out.println("                env->PopLocalFrame(NULL);");
/*  657 */     this.out.println("            }");
/*  658 */     this.out.println("        }");
/*  659 */     this.out.println("    }");
/*  660 */     this.out.println("    JavaCPP_initMID = env->GetMethodID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"init\", \"(JIJ)V\");");
/*      */ 
/*  662 */     this.out.println("    if (JavaCPP_initMID == NULL || env->ExceptionCheck()) {");
/*  663 */     this.out.println("        JavaCPP_log(\"Error getting method ID of Pointer.init().\");");
/*  664 */     this.out.println("        return JNI_ERR;");
/*  665 */     this.out.println("    }");
/*  666 */     this.out.println("    JavaCPP_addressFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"address\", \"J\");");
/*      */ 
/*  668 */     this.out.println("    if (JavaCPP_addressFID == NULL || env->ExceptionCheck()) {");
/*  669 */     this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.address.\");");
/*  670 */     this.out.println("        return JNI_ERR;");
/*  671 */     this.out.println("    }");
/*  672 */     this.out.println("    JavaCPP_positionFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"position\", \"I\");");
/*      */ 
/*  674 */     this.out.println("    if (JavaCPP_positionFID == NULL || env->ExceptionCheck()) {");
/*  675 */     this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.position.\");");
/*  676 */     this.out.println("        return JNI_ERR;");
/*  677 */     this.out.println("    }");
/*  678 */     this.out.println("    JavaCPP_limitFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"limit\", \"I\");");
/*      */ 
/*  680 */     this.out.println("    if (JavaCPP_limitFID == NULL || env->ExceptionCheck()) {");
/*  681 */     this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.limit.\");");
/*  682 */     this.out.println("        return JNI_ERR;");
/*  683 */     this.out.println("    }");
/*  684 */     this.out.println("    JavaCPP_capacityFID = env->GetFieldID(JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), \"capacity\", \"I\");");
/*      */ 
/*  686 */     this.out.println("    if (JavaCPP_capacityFID == NULL || env->ExceptionCheck()) {");
/*  687 */     this.out.println("        JavaCPP_log(\"Error getting field ID of Pointer.capacity.\");");
/*  688 */     this.out.println("        return JNI_ERR;");
/*  689 */     this.out.println("    }");
/*  690 */     classIterator = this.jclassesInit.iterator();
/*  691 */     while (classIterator.hasNext()) {
/*  692 */       Class c = (Class)classIterator.next();
/*  693 */       if (c != Pointer.class)
/*      */       {
/*  696 */         this.out.println("    if (JavaCPP_getClass(env, " + this.jclasses.indexOf(c) + ") == NULL) {");
/*  697 */         this.out.println("        return JNI_ERR;");
/*  698 */         this.out.println("    }");
/*      */       }
/*      */     }
/*  700 */     this.out.println("    return env->GetVersion();");
/*  701 */     this.out.println("}");
/*  702 */     this.out.println();
/*  703 */     if (this.out2 != null) {
/*  704 */       this.out2.println("JNIIMPORT int JavaCPP_uninit();");
/*  705 */       this.out2.println();
/*  706 */       this.out.println("JNIEXPORT int JavaCPP_uninit() {");
/*  707 */       this.out.println("#if defined(ANDROID) || TARGET_OS_IPHONE");
/*  708 */       this.out.println("    return JNI_OK;");
/*  709 */       this.out.println("#else");
/*  710 */       this.out.println("    JavaVM *vm = JavaCPP_vm;");
/*  711 */       this.out.println("    JNI_OnUnload(JavaCPP_vm, NULL);");
/*  712 */       this.out.println("    return vm->DestroyJavaVM();");
/*  713 */       this.out.println("#endif");
/*  714 */       this.out.println("}");
/*      */     }
/*  716 */     this.out.println();
/*  717 */     this.out.println("JNIEXPORT void JNICALL JNI_OnUnload(JavaVM* vm, void* reserved) {");
/*  718 */     this.out.println("    JNIEnv* env;");
/*  719 */     this.out.println("    if (vm->GetEnv((void**)&env, JNI_VERSION_1_4) != JNI_OK) {");
/*  720 */     this.out.println("        JavaCPP_log(\"Could not get JNIEnv for JNI_VERSION_1_4 inside JNI_OnUnLoad().\");");
/*  721 */     this.out.println("        return;");
/*  722 */     this.out.println("    }");
/*  723 */     this.out.println("    for (int i = 0; i < " + this.jclasses.size() + "; i++) {");
/*  724 */     this.out.println("        env->DeleteWeakGlobalRef(JavaCPP_classes[i]);");
/*  725 */     this.out.println("        JavaCPP_classes[i] = NULL;");
/*  726 */     this.out.println("    }");
/*  727 */     this.out.println("    JavaCPP_vm = NULL;");
/*  728 */     this.out.println("}");
/*  729 */     this.out.println();
/*      */ 
/*  731 */     for (Class cls : baseClasses) {
/*  732 */       doMethods(cls);
/*      */     }
/*      */ 
/*  735 */     boolean didSomethingUseful = false;
/*  736 */     for (Class cls : classes) {
/*      */       try {
/*  738 */         didSomethingUseful |= doMethods(cls);
/*      */       } catch (NoClassDefFoundError e) {
/*  740 */         logger.log(Level.WARNING, "Could not generate code for class " + cls.getCanonicalName() + ": " + e);
/*      */       }
/*      */     }
/*      */ 
/*  744 */     this.out.println("}");
/*  745 */     this.out.println();
/*  746 */     if (this.out2 != null) {
/*  747 */       this.out2.println("#ifdef __cplusplus");
/*  748 */       this.out2.println("}");
/*  749 */       this.out2.println("#endif");
/*      */     }
/*      */ 
/*  752 */     return didSomethingUseful;
/*      */   }
/*      */ 
/*      */   private boolean doMethods(Class<?> cls) {
/*  756 */     if (!checkPlatform(cls)) {
/*  757 */       return false;
/*      */     }
/*      */ 
/*  760 */     LinkedList memberList = (LinkedList)this.members.get(cls);
/*  761 */     if ((!cls.isAnnotationPresent(Opaque.class)) && (!FunctionPointer.class.isAssignableFrom(cls)))
/*      */     {
/*  763 */       if (memberList == null) {
/*  764 */         this.members.put(cls, memberList = new LinkedList());
/*      */       }
/*  766 */       if (!memberList.contains("sizeof")) {
/*  767 */         memberList.add("sizeof");
/*      */       }
/*      */     }
/*      */ 
/*  771 */     boolean didSomething = false;
/*  772 */     Class[] classes = cls.getDeclaredClasses();
/*  773 */     for (int i = 0; i < classes.length; i++) {
/*  774 */       if ((Pointer.class.isAssignableFrom(classes[i])) || (Pointer.Deallocator.class.isAssignableFrom(classes[i])))
/*      */       {
/*  776 */         didSomething |= doMethods(classes[i]);
/*      */       }
/*      */     }
/*      */ 
/*  780 */     Method[] methods = cls.getDeclaredMethods();
/*  781 */     boolean[] callbackAllocators = new boolean[methods.length];
/*  782 */     Method functionMethod = getFunctionMethod(cls, callbackAllocators);
/*  783 */     boolean firstCallback = true;
/*  784 */     for (int i = 0; i < methods.length; i++) {
/*  785 */       String nativeName = mangle(cls.getName()) + "_" + mangle(methods[i].getName());
/*  786 */       if (checkPlatform((Platform)methods[i].getAnnotation(Platform.class)))
/*      */       {
/*  789 */         MethodInformation methodInfo = getMethodInformation(methods[i]);
/*      */ 
/*  791 */         String callbackName = "JavaCPP_" + nativeName + "_callback";
/*  792 */         if ((callbackAllocators[i] != 0) && (functionMethod == null)) {
/*  793 */           logger.log(Level.WARNING, "No callback method call() or apply() has been not declared in \"" + cls.getCanonicalName() + "\". No code will be generated for callback allocator.");
/*      */         }
/*      */         else {
/*  796 */           if ((callbackAllocators[i] != 0) || ((methods[i].equals(functionMethod)) && (methodInfo == null))) {
/*  797 */             Name name = (Name)methods[i].getAnnotation(Name.class);
/*  798 */             if ((name != null) && (name.value().length > 0) && (name.value()[0].length() > 0)) {
/*  799 */               callbackName = name.value()[0];
/*      */             }
/*  801 */             doCallback(cls, functionMethod, callbackName, firstCallback);
/*  802 */             firstCallback = false;
/*  803 */             didSomething = true;
/*      */           }
/*      */ 
/*  806 */           if (methodInfo != null)
/*      */           {
/*  810 */             if (((methodInfo.memberGetter) || (methodInfo.memberSetter)) && (!methodInfo.noOffset) && (memberList != null) && (!Modifier.isStatic(methodInfo.modifiers)))
/*      */             {
/*  812 */               if (!memberList.contains(methodInfo.memberName[0])) {
/*  813 */                 memberList.add(methodInfo.memberName[0]);
/*      */               }
/*      */             }
/*      */ 
/*  817 */             didSomething = true;
/*  818 */             this.out.print("JNIEXPORT " + getJNITypeName(methodInfo.returnType) + " JNICALL Java_" + nativeName);
/*  819 */             if (methodInfo.overloaded) {
/*  820 */               this.out.print("__" + mangle(getSignature(methodInfo.parameterTypes)));
/*      */             }
/*  822 */             if (Modifier.isStatic(methodInfo.modifiers))
/*  823 */               this.out.print("(JNIEnv* env, jclass cls");
/*      */             else {
/*  825 */               this.out.print("(JNIEnv* env, jobject obj");
/*      */             }
/*  827 */             for (int j = 0; j < methodInfo.parameterTypes.length; j++) {
/*  828 */               this.out.print(", " + getJNITypeName(methodInfo.parameterTypes[j]) + " arg" + j);
/*      */             }
/*  830 */             this.out.println(") {");
/*      */ 
/*  832 */             if (callbackAllocators[i] != 0) {
/*  833 */               doCallbackAllocator(cls, callbackName);
/*      */             } else {
/*  835 */               if ((!Modifier.isStatic(methodInfo.modifiers)) && (!methodInfo.allocator) && (!methodInfo.arrayAllocator) && (!methodInfo.deallocator))
/*      */               {
/*  838 */                 String[] typeName = getCPPTypeName(cls);
/*  839 */                 if ("void*".equals(typeName[0])) {
/*  840 */                   typeName[0] = "char*";
/*  841 */                 } else if (FunctionPointer.class.isAssignableFrom(cls)) {
/*  842 */                   this.functions.register(cls);
/*  843 */                   typeName[0] = (getFunctionClassName(cls) + "*");
/*  844 */                   typeName[1] = "";
/*      */                 }
/*  846 */                 this.out.println("    " + typeName[0] + " ptr" + typeName[1] + " = (" + typeName[0] + typeName[1] + ")jlong_to_ptr(env->GetLongField(obj, JavaCPP_addressFID));");
/*      */ 
/*  848 */                 this.out.println("    if (ptr == NULL) {");
/*  849 */                 this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"This pointer address is NULL.\");");
/*      */ 
/*  851 */                 this.out.println("        return" + (methodInfo.returnType == Void.TYPE ? ";" : " 0;"));
/*  852 */                 this.out.println("    }");
/*  853 */                 if (FunctionPointer.class.isAssignableFrom(cls)) {
/*  854 */                   this.out.println("    if (ptr->ptr == NULL) {");
/*  855 */                   this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"This function pointer address is NULL.\");");
/*      */ 
/*  857 */                   this.out.println("        return" + (methodInfo.returnType == Void.TYPE ? ";" : " 0;"));
/*  858 */                   this.out.println("    }");
/*      */                 }
/*  860 */                 if (!cls.isAnnotationPresent(Opaque.class)) {
/*  861 */                   this.out.println("    jint position = env->GetIntField(obj, JavaCPP_positionFID);");
/*  862 */                   this.out.println("    ptr += position;");
/*  863 */                   if (methodInfo.bufferGetter) {
/*  864 */                     this.out.println("    jint size = env->GetIntField(obj, JavaCPP_limitFID);");
/*  865 */                     this.out.println("    size -= position;");
/*      */                   }
/*      */                 }
/*      */               }
/*      */ 
/*  870 */               doParametersBefore(methodInfo);
/*  871 */               String returnPrefix = doReturnBefore(methodInfo);
/*  872 */               doCall(methodInfo, returnPrefix);
/*  873 */               doReturnAfter(methodInfo);
/*  874 */               doParametersAfter(methodInfo);
/*  875 */               if (methodInfo.throwsException != null) {
/*  876 */                 this.out.println("    if (exc != NULL) {");
/*  877 */                 this.out.println("        env->Throw(exc);");
/*  878 */                 this.out.println("    }");
/*      */               }
/*  880 */               if (methodInfo.returnType != Void.TYPE) {
/*  881 */                 this.out.println("    return rarg;");
/*      */               }
/*  883 */               this.out.println("}");
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  885 */     this.out.println();
/*  886 */     return didSomething;
/*      */   }
/*      */ 
/*      */   private void doParametersBefore(MethodInformation methodInfo) {
/*  890 */     String adapterLine = "";
/*  891 */     AdapterInformation prevAdapterInfo = null;
/*  892 */     for (int j = 0; j < methodInfo.parameterTypes.length; j++)
/*  893 */       if (!methodInfo.parameterTypes[j].isPrimitive()) {
/*  894 */         Annotation passBy = getParameterBy(methodInfo, j);
/*  895 */         String cast = getParameterCast(methodInfo, j);
/*  896 */         String[] typeName = getCPPTypeName(methodInfo.parameterTypes[j]);
/*  897 */         AdapterInformation adapterInfo = getParameterAdapterInformation(false, methodInfo, j);
/*      */ 
/*  899 */         if (FunctionPointer.class.isAssignableFrom(methodInfo.parameterTypes[j])) {
/*  900 */           this.functions.register(methodInfo.parameterTypes[j]);
/*  901 */           if (methodInfo.parameterTypes[j] == FunctionPointer.class) {
/*  902 */             logger.log(Level.WARNING, "Method \"" + methodInfo.method + "\" has an abstract FunctionPointer parameter, " + "but a concrete subclass is required. Compilation will most likely fail.");
/*      */           }
/*      */ 
/*  905 */           typeName[0] = (getFunctionClassName(methodInfo.parameterTypes[j]) + "*");
/*  906 */           typeName[1] = "";
/*      */         }
/*      */ 
/*  909 */         if ((typeName[0].length() == 0) || (methodInfo.parameterRaw[j] != 0)) {
/*  910 */           methodInfo.parameterRaw[j] = true;
/*  911 */           typeName[0] = getJNITypeName(methodInfo.parameterTypes[j]);
/*  912 */           this.out.println("    " + typeName[0] + " ptr" + j + " = arg" + j + ";");
/*      */         }
/*      */         else
/*      */         {
/*  916 */           if ("void*".equals(typeName[0])) {
/*  917 */             typeName[0] = "char*";
/*      */           }
/*  919 */           this.out.print("    " + typeName[0] + " ptr" + j + typeName[1] + " = ");
/*  920 */           if (Pointer.class.isAssignableFrom(methodInfo.parameterTypes[j])) {
/*  921 */             this.out.println("arg" + j + " == NULL ? NULL : (" + typeName[0] + typeName[1] + ")jlong_to_ptr(env->GetLongField(arg" + j + ", JavaCPP_addressFID));");
/*      */ 
/*  923 */             if (((j == 0) && (FunctionPointer.class.isAssignableFrom(methodInfo.cls)) && (methodInfo.cls.isAnnotationPresent(Namespace.class))) || ((passBy instanceof ByVal)) || ((passBy instanceof ByRef)))
/*      */             {
/*  927 */               this.out.println("    if (ptr" + j + " == NULL) {");
/*  928 */               this.out.println("        env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"Pointer address of argument " + j + " is NULL.\");");
/*      */ 
/*  930 */               this.out.println("        return" + (methodInfo.returnType == Void.TYPE ? ";" : " 0;"));
/*  931 */               this.out.println("    }");
/*      */             }
/*  933 */             if ((adapterInfo != null) || (prevAdapterInfo != null)) {
/*  934 */               this.out.println("    jint size" + j + " = arg" + j + " == NULL ? 0 : env->GetIntField(arg" + j + ", JavaCPP_limitFID);");
/*      */             }
/*      */ 
/*  937 */             if (!methodInfo.parameterTypes[j].isAnnotationPresent(Opaque.class)) {
/*  938 */               this.out.println("    jint position" + j + " = arg" + j + " == NULL ? 0 : env->GetIntField(arg" + j + ", JavaCPP_positionFID);");
/*      */ 
/*  940 */               this.out.println("    ptr" + j + " += position" + j + ";");
/*  941 */               if ((adapterInfo != null) || (prevAdapterInfo != null))
/*  942 */                 this.out.println("    size" + j + " -= position" + j + ";");
/*      */             }
/*      */           }
/*  945 */           else if (methodInfo.parameterTypes[j] == String.class) {
/*  946 */             this.out.println("arg" + j + " == NULL ? NULL : env->GetStringUTFChars(arg" + j + ", NULL);");
/*  947 */             if ((adapterInfo != null) || (prevAdapterInfo != null))
/*  948 */               this.out.println("    jint size" + j + " = 0;");
/*      */           }
/*  950 */           else if ((methodInfo.parameterTypes[j].isArray()) && (methodInfo.parameterTypes[j].getComponentType().isPrimitive()))
/*      */           {
/*  952 */             this.out.print("arg" + j + " == NULL ? NULL : ");
/*  953 */             String s = methodInfo.parameterTypes[j].getComponentType().getName();
/*  954 */             if ((methodInfo.valueGetter) || (methodInfo.valueSetter) || (methodInfo.memberGetter) || (methodInfo.memberSetter))
/*      */             {
/*  956 */               this.out.println("(j" + s + "*)env->GetPrimitiveArrayCritical(arg" + j + ", NULL);");
/*      */             } else {
/*  958 */               s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
/*  959 */               this.out.println("env->Get" + s + "ArrayElements(arg" + j + ", NULL);");
/*      */             }
/*  961 */             if ((adapterInfo != null) || (prevAdapterInfo != null)) {
/*  962 */               this.out.println("    jint size" + j + " = arg" + j + " == NULL ? 0 : env->GetArrayLength(arg" + j + ");");
/*      */             }
/*      */           }
/*  965 */           else if (Buffer.class.isAssignableFrom(methodInfo.parameterTypes[j])) {
/*  966 */             this.out.println("arg" + j + " == NULL ? NULL : (" + typeName[0] + typeName[1] + ")env->GetDirectBufferAddress(arg" + j + ");");
/*  967 */             if ((adapterInfo != null) || (prevAdapterInfo != null))
/*  968 */               this.out.println("    jint size" + j + " = arg" + j + " == NULL ? 0 : env->GetDirectBufferCapacity(arg" + j + ");");
/*      */           }
/*      */           else
/*      */           {
/*  972 */             this.out.println("arg" + j + ";");
/*  973 */             logger.log(Level.WARNING, "Method \"" + methodInfo.method + "\" has an unsupported parameter of type \"" + methodInfo.parameterTypes[j].getCanonicalName() + "\". Compilation will most likely fail.");
/*      */           }
/*      */ 
/*  977 */           if (adapterInfo != null) {
/*  978 */             this.usesAdapters = true;
/*  979 */             adapterLine = "    " + adapterInfo.name + " adapter" + j + "(";
/*  980 */             prevAdapterInfo = adapterInfo;
/*      */           }
/*  982 */           if (prevAdapterInfo != null) {
/*  983 */             if (!FunctionPointer.class.isAssignableFrom(methodInfo.cls))
/*      */             {
/*  985 */               adapterLine = adapterLine + cast;
/*      */             }
/*  987 */             adapterLine = adapterLine + "ptr" + j + ", size" + j;
/*  988 */             if (--prevAdapterInfo.argc > 0) {
/*  989 */               adapterLine = adapterLine + ", ";
/*      */             }
/*      */           }
/*  992 */           if ((prevAdapterInfo != null) && (prevAdapterInfo.argc <= 0)) {
/*  993 */             this.out.println(adapterLine + ");");
/*  994 */             prevAdapterInfo = null;
/*      */           }
/*      */         }
/*      */       }
/*      */   }
/*      */ 
/*      */   private String doReturnBefore(MethodInformation methodInfo) {
/* 1001 */     String returnPrefix = "";
/* 1002 */     if (methodInfo.returnType == Void.TYPE) {
/* 1003 */       if ((methodInfo.allocator) || (methodInfo.arrayAllocator)) {
/* 1004 */         if (methodInfo.cls != Pointer.class) {
/* 1005 */           this.out.println("    if (!env->IsSameObject(env->GetObjectClass(obj), JavaCPP_getClass(env, " + this.jclasses.register(methodInfo.cls) + "))) {");
/*      */ 
/* 1007 */           this.out.println("        return;");
/* 1008 */           this.out.println("    }");
/*      */         }
/* 1010 */         String[] typeName = getCPPTypeName(methodInfo.cls);
/* 1011 */         returnPrefix = typeName[0] + " rptr" + typeName[1] + " = ";
/*      */       }
/*      */     } else {
/* 1014 */       String cast = getCast(methodInfo.annotations, methodInfo.returnType);
/* 1015 */       String[] typeName = getCastedCPPTypeName(methodInfo.annotations, methodInfo.returnType);
/* 1016 */       if ((methodInfo.valueSetter) || (methodInfo.memberSetter) || (methodInfo.noReturnGetter)) {
/* 1017 */         this.out.println("    jobject rarg = obj;");
/* 1018 */       } else if (methodInfo.returnType.isPrimitive()) {
/* 1019 */         this.out.println("    " + getJNITypeName(methodInfo.returnType) + " rarg = 0;");
/* 1020 */         returnPrefix = typeName[0] + " rvalue" + typeName[1] + " = " + cast;
/*      */       } else {
/* 1022 */         Annotation returnBy = getBy(methodInfo.annotations);
/* 1023 */         String valueTypeName = getValueTypeName(typeName);
/*      */ 
/* 1025 */         returnPrefix = "rptr = " + cast;
/* 1026 */         if ((typeName[0].length() == 0) || (methodInfo.returnRaw)) {
/* 1027 */           methodInfo.returnRaw = true;
/* 1028 */           typeName[0] = getJNITypeName(methodInfo.returnType);
/* 1029 */           this.out.println("    " + typeName[0] + " rarg = NULL;");
/* 1030 */           this.out.println("    " + typeName[0] + " rptr;");
/* 1031 */         } else if ((Pointer.class.isAssignableFrom(methodInfo.returnType)) || (Buffer.class.isAssignableFrom(methodInfo.returnType)) || ((methodInfo.returnType.isArray()) && (methodInfo.returnType.getComponentType().isPrimitive())))
/*      */         {
/* 1035 */           if (FunctionPointer.class.isAssignableFrom(methodInfo.returnType)) {
/* 1036 */             this.functions.register(methodInfo.returnType);
/* 1037 */             typeName[0] = (getFunctionClassName(methodInfo.returnType) + "*");
/* 1038 */             typeName[1] = "";
/* 1039 */             valueTypeName = getValueTypeName(typeName);
/* 1040 */             returnPrefix = "if (rptr != NULL) rptr->ptr = ";
/*      */           }
/* 1042 */           if ((returnBy instanceof ByVal)) {
/* 1043 */             returnPrefix = returnPrefix + (getNoException(methodInfo.returnType, methodInfo.method) ? "new (std::nothrow) " : "new ") + valueTypeName + typeName[1] + "(";
/*      */           }
/* 1045 */           else if ((returnBy instanceof ByRef)) {
/* 1046 */             returnPrefix = returnPrefix + "&";
/* 1047 */           } else if ((returnBy instanceof ByPtrPtr)) {
/* 1048 */             if (cast.length() > 0) {
/* 1049 */               typeName[0] = typeName[0].substring(0, typeName[0].length() - 1);
/*      */             }
/* 1051 */             returnPrefix = "rptr = NULL; " + typeName[0] + "* rptrptr" + typeName[1] + " = " + cast;
/*      */           }
/* 1053 */           if (methodInfo.bufferGetter) {
/* 1054 */             this.out.println("    jobject rarg = NULL;");
/* 1055 */             this.out.println("    char* rptr;");
/*      */           } else {
/* 1057 */             this.out.println("    " + getJNITypeName(methodInfo.returnType) + " rarg = NULL;");
/* 1058 */             this.out.println("    " + typeName[0] + " rptr" + typeName[1] + ";");
/*      */           }
/* 1060 */           if (FunctionPointer.class.isAssignableFrom(methodInfo.returnType))
/* 1061 */             this.out.println("    rptr = new (std::nothrow) " + valueTypeName + ";");
/*      */         }
/* 1063 */         else if (methodInfo.returnType == String.class) {
/* 1064 */           this.out.println("    jstring rarg = NULL;");
/* 1065 */           this.out.println("    const char* rptr;");
/* 1066 */           if ((returnBy instanceof ByRef))
/* 1067 */             returnPrefix = "std::string rstr(";
/*      */           else
/* 1069 */             returnPrefix = returnPrefix + "(const char*)";
/*      */         }
/*      */         else {
/* 1072 */           logger.log(Level.WARNING, "Method \"" + methodInfo.method + "\" has unsupported return type \"" + methodInfo.returnType.getCanonicalName() + "\". Compilation will most likely fail.");
/*      */         }
/*      */ 
/* 1076 */         AdapterInformation adapterInfo = getAdapterInformation(false, valueTypeName, methodInfo.annotations);
/* 1077 */         if (adapterInfo != null) {
/* 1078 */           this.usesAdapters = true;
/* 1079 */           returnPrefix = adapterInfo.name + " radapter(";
/*      */         }
/*      */       }
/*      */     }
/* 1083 */     if (methodInfo.throwsException != null) {
/* 1084 */       this.out.println("    jthrowable exc = NULL;");
/* 1085 */       this.out.println("    try {");
/*      */     }
/* 1087 */     return returnPrefix;
/*      */   }
/*      */ 
/*      */   private void doCall(MethodInformation methodInfo, String returnPrefix) {
/* 1091 */     String indent = methodInfo.throwsException != null ? "        " : "    ";
/* 1092 */     String prefix = "(";
/* 1093 */     String suffix = ")";
/* 1094 */     int skipParameters = 0;
/* 1095 */     boolean index = (methodInfo.method.isAnnotationPresent(Index.class)) || ((methodInfo.pairedMethod != null) && (methodInfo.pairedMethod.isAnnotationPresent(Index.class)));
/*      */ 
/* 1098 */     if (methodInfo.deallocator) {
/* 1099 */       this.out.println(indent + "void* allocatedAddress = jlong_to_ptr(arg0);");
/* 1100 */       this.out.println(indent + "void (*deallocatorAddress)(void*) = (void(*)(void*))jlong_to_ptr(arg1);");
/* 1101 */       this.out.println(indent + "if (deallocatorAddress != NULL && allocatedAddress != NULL) {");
/* 1102 */       this.out.println(indent + "    (*deallocatorAddress)(allocatedAddress);");
/* 1103 */       this.out.println(indent + "}");
/* 1104 */       return;
/* 1105 */     }if ((methodInfo.valueGetter) || (methodInfo.valueSetter) || (methodInfo.memberGetter) || (methodInfo.memberSetter))
/*      */     {
/* 1107 */       boolean wantsPointer = false;
/* 1108 */       int k = methodInfo.parameterTypes.length - 1;
/* 1109 */       if (((methodInfo.valueSetter) || (methodInfo.memberSetter)) && (!(getParameterBy(methodInfo, k) instanceof ByRef)) && (getParameterAdapterInformation(false, methodInfo, k) == null) && (methodInfo.parameterTypes[k] == String.class))
/*      */       {
/* 1114 */         this.out.print(indent + "strcpy((char*)");
/* 1115 */         wantsPointer = true;
/* 1116 */         prefix = ", ";
/* 1117 */       } else if ((k >= 1) && (methodInfo.parameterTypes[0].isArray()) && (methodInfo.parameterTypes[0].getComponentType().isPrimitive()) && ((methodInfo.parameterTypes[1] == Integer.TYPE) || (methodInfo.parameterTypes[1] == Long.TYPE)))
/*      */       {
/* 1122 */         this.out.print(indent + "memcpy(");
/* 1123 */         wantsPointer = true;
/* 1124 */         prefix = ", ";
/* 1125 */         if ((methodInfo.memberGetter) || (methodInfo.valueGetter))
/* 1126 */           this.out.print("ptr0 + arg1, ");
/*      */         else {
/* 1128 */           prefix = prefix + "ptr0 + arg1, ";
/*      */         }
/* 1130 */         skipParameters = 2;
/* 1131 */         suffix = " * sizeof(*ptr0)" + suffix;
/*      */       } else {
/* 1133 */         this.out.print(indent + returnPrefix);
/* 1134 */         prefix = (methodInfo.valueGetter) || (methodInfo.memberGetter) ? "" : " = ";
/* 1135 */         suffix = "";
/*      */       }
/* 1137 */       if (Modifier.isStatic(methodInfo.modifiers))
/* 1138 */         this.out.print(getCPPScopeName(methodInfo));
/* 1139 */       else if ((methodInfo.memberGetter) || (methodInfo.memberSetter)) {
/* 1140 */         if (index) {
/* 1141 */           this.out.print("(*ptr)");
/* 1142 */           prefix = "." + methodInfo.memberName[0] + prefix;
/*      */         } else {
/* 1144 */           this.out.print("ptr->" + methodInfo.memberName[0]);
/*      */         }
/*      */       }
/* 1147 */       else this.out.print((methodInfo.dim > 0) || (wantsPointer) ? "ptr" : index ? "(*ptr)" : "*ptr");
/*      */     }
/* 1149 */     else if (methodInfo.bufferGetter) {
/* 1150 */       this.out.print(indent + returnPrefix + "ptr");
/* 1151 */       prefix = "";
/* 1152 */       suffix = "";
/*      */     } else {
/* 1154 */       this.out.print(indent + returnPrefix);
/* 1155 */       if (FunctionPointer.class.isAssignableFrom(methodInfo.cls)) {
/* 1156 */         if (methodInfo.cls.isAnnotationPresent(Namespace.class)) {
/* 1157 */           this.out.print("(ptr0->*(ptr->ptr))");
/* 1158 */           skipParameters = 1;
/*      */         } else {
/* 1160 */           this.out.print("(*ptr->ptr)");
/*      */         }
/* 1162 */       } else if (methodInfo.allocator) {
/* 1163 */         String[] typeName = getCPPTypeName(methodInfo.cls);
/* 1164 */         String valueTypeName = getValueTypeName(typeName);
/* 1165 */         if (methodInfo.cls == Pointer.class)
/*      */         {
/* 1167 */           prefix = "";
/* 1168 */           suffix = "";
/*      */         } else {
/* 1170 */           this.out.print((getNoException(methodInfo.cls, methodInfo.method) ? "new (std::nothrow) " : "new ") + valueTypeName + typeName[1]);
/*      */ 
/* 1172 */           if (methodInfo.arrayAllocator) {
/* 1173 */             prefix = "[";
/* 1174 */             suffix = "]";
/*      */           }
/*      */         }
/* 1177 */       } else if (Modifier.isStatic(methodInfo.modifiers)) {
/* 1178 */         this.out.print(getCPPScopeName(methodInfo));
/*      */       }
/* 1180 */       else if (index) {
/* 1181 */         this.out.print("(*ptr)");
/* 1182 */         prefix = "." + methodInfo.memberName[0] + prefix;
/*      */       } else {
/* 1184 */         this.out.print("ptr->" + methodInfo.memberName[0]);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1189 */     for (int j = skipParameters; j < methodInfo.dim; j++)
/*      */     {
/* 1192 */       String cast = getParameterCast(methodInfo, j);
/* 1193 */       this.out.print("[" + cast + (methodInfo.parameterTypes[j].isPrimitive() ? "arg" : "ptr") + j + "]");
/*      */     }
/* 1195 */     if (methodInfo.memberName.length > 1) {
/* 1196 */       this.out.print(methodInfo.memberName[1]);
/*      */     }
/* 1198 */     this.out.print(prefix);
/* 1199 */     if (methodInfo.withEnv) {
/* 1200 */       this.out.print(Modifier.isStatic(methodInfo.modifiers) ? "env, cls" : "env, obj");
/* 1201 */       if (methodInfo.parameterTypes.length - skipParameters - methodInfo.dim > 0) {
/* 1202 */         this.out.print(", ");
/*      */       }
/*      */     }
/* 1205 */     for (int j = skipParameters + methodInfo.dim; j < methodInfo.parameterTypes.length; j++) {
/* 1206 */       Annotation passBy = getParameterBy(methodInfo, j);
/* 1207 */       String cast = getParameterCast(methodInfo, j);
/* 1208 */       AdapterInformation adapterInfo = getParameterAdapterInformation(false, methodInfo, j);
/*      */ 
/* 1210 */       if ((("(void*)".equals(cast)) || ("(void *)".equals(cast))) && (methodInfo.parameterTypes[j] == Long.TYPE))
/*      */       {
/* 1212 */         this.out.print("jlong_to_ptr(arg" + j + ")");
/* 1213 */       } else if (methodInfo.parameterTypes[j].isPrimitive()) {
/* 1214 */         this.out.print(cast + "arg" + j);
/* 1215 */       } else if (adapterInfo != null) {
/* 1216 */         cast = adapterInfo.cast.trim();
/* 1217 */         if ((cast.length() > 0) && (!cast.startsWith("(")) && (!cast.endsWith(")"))) {
/* 1218 */           cast = "(" + cast + ")";
/*      */         }
/* 1220 */         this.out.print(cast + "adapter" + j);
/* 1221 */         j += adapterInfo.argc - 1;
/* 1222 */       } else if ((FunctionPointer.class.isAssignableFrom(methodInfo.parameterTypes[j])) && (passBy == null)) {
/* 1223 */         this.out.print(cast + "(ptr" + j + " == NULL ? NULL : ptr" + j + "->ptr)");
/* 1224 */       } else if (((passBy instanceof ByVal)) || (((passBy instanceof ByRef)) && (methodInfo.parameterTypes[j] != String.class)))
/*      */       {
/* 1226 */         this.out.print("*" + cast + "ptr" + j);
/* 1227 */       } else if ((passBy instanceof ByPtrPtr)) {
/* 1228 */         this.out.print(cast + "(arg" + j + " == NULL ? NULL : &ptr" + j + ")");
/*      */       } else {
/* 1230 */         this.out.print(cast + "ptr" + j);
/*      */       }
/*      */ 
/* 1233 */       if (j < methodInfo.parameterTypes.length - 1) {
/* 1234 */         this.out.print(", ");
/*      */       }
/*      */     }
/* 1237 */     this.out.print(suffix);
/* 1238 */     if (methodInfo.memberName.length > 2) {
/* 1239 */       this.out.print(methodInfo.memberName[2]);
/*      */     }
/* 1241 */     if (((getBy(methodInfo.annotations) instanceof ByRef)) && (methodInfo.returnType == String.class))
/*      */     {
/* 1244 */       this.out.print(");\n" + indent + "rptr = rstr.c_str()");
/*      */     }
/*      */   }
/*      */ 
/*      */   private void doReturnAfter(MethodInformation methodInfo) {
/* 1249 */     String indent = methodInfo.throwsException != null ? "        " : "    ";
/* 1250 */     String[] typeName = getCastedCPPTypeName(methodInfo.annotations, methodInfo.returnType);
/* 1251 */     Annotation returnBy = getBy(methodInfo.annotations);
/* 1252 */     String valueTypeName = getValueTypeName(typeName);
/* 1253 */     AdapterInformation adapterInfo = getAdapterInformation(false, valueTypeName, methodInfo.annotations);
/* 1254 */     String suffix = methodInfo.deallocator ? "" : ";";
/* 1255 */     if ((!methodInfo.returnType.isPrimitive()) && (adapterInfo != null)) {
/* 1256 */       suffix = ")" + suffix;
/*      */     }
/* 1258 */     if ((Pointer.class.isAssignableFrom(methodInfo.returnType)) || ((methodInfo.returnType.isArray()) && (methodInfo.returnType.getComponentType().isPrimitive())))
/*      */     {
/* 1261 */       if ((returnBy instanceof ByVal)) {
/* 1262 */         suffix = ")" + suffix;
/* 1263 */       } else if ((returnBy instanceof ByPtrPtr)) {
/* 1264 */         this.out.println(suffix);
/* 1265 */         suffix = "";
/* 1266 */         this.out.println(indent + "if (rptrptr == NULL) {");
/* 1267 */         this.out.println(indent + "    env->ThrowNew(JavaCPP_getClass(env, " + this.jclasses.register(NullPointerException.class) + "), \"Return pointer address is NULL.\");");
/*      */ 
/* 1269 */         this.out.println(indent + "} else {");
/* 1270 */         this.out.println(indent + "    rptr = *rptrptr;");
/* 1271 */         this.out.println(indent + "}");
/*      */       }
/*      */     }
/* 1274 */     this.out.println(suffix);
/*      */ 
/* 1276 */     if (methodInfo.returnType == Void.TYPE) {
/* 1277 */       if ((methodInfo.allocator) || (methodInfo.arrayAllocator)) {
/* 1278 */         this.out.println(indent + "jint rcapacity = " + (methodInfo.arrayAllocator ? "arg0;" : "1;"));
/* 1279 */         boolean noDeallocator = (methodInfo.cls == Pointer.class) || (methodInfo.cls.isAnnotationPresent(NoDeallocator.class));
/*      */ 
/* 1281 */         for (Annotation a : methodInfo.annotations) {
/* 1282 */           if ((a instanceof NoDeallocator)) {
/* 1283 */             noDeallocator = true;
/* 1284 */             break;
/*      */           }
/*      */         }
/* 1287 */         if (!noDeallocator) {
/* 1288 */           this.out.println(indent + "jvalue args[3];");
/* 1289 */           this.out.println(indent + "args[0].j = ptr_to_jlong(rptr);");
/* 1290 */           this.out.println(indent + "args[1].i = rcapacity;");
/* 1291 */           this.out.print(indent + "args[2].j = ptr_to_jlong(&JavaCPP_" + mangle(methodInfo.cls.getName()));
/* 1292 */           if (methodInfo.arrayAllocator) {
/* 1293 */             this.out.println("_deallocateArray);");
/* 1294 */             this.arrayDeallocators.register(methodInfo.cls);
/*      */           } else {
/* 1296 */             this.out.println("_deallocate);");
/* 1297 */             this.deallocators.register(methodInfo.cls);
/*      */           }
/* 1299 */           this.out.println(indent + "env->CallNonvirtualVoidMethodA(obj, JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
/*      */         }
/*      */         else {
/* 1302 */           this.out.println(indent + "env->SetLongField(obj, JavaCPP_addressFID, ptr_to_jlong(rptr));");
/* 1303 */           this.out.println(indent + "env->SetIntField(obj, JavaCPP_limitFID, rcapacity);");
/* 1304 */           this.out.println(indent + "env->SetIntField(obj, JavaCPP_capacityFID, rcapacity);");
/*      */         }
/*      */       }
/*      */     }
/* 1308 */     else if ((!methodInfo.valueSetter) && (!methodInfo.memberSetter) && (!methodInfo.noReturnGetter))
/*      */     {
/* 1310 */       if (methodInfo.returnType.isPrimitive()) {
/* 1311 */         this.out.println(indent + "rarg = (" + getJNITypeName(methodInfo.returnType) + ")rvalue;");
/* 1312 */       } else if (methodInfo.returnRaw) {
/* 1313 */         this.out.println(indent + "rarg = rptr;");
/*      */       } else {
/* 1315 */         boolean needInit = false;
/* 1316 */         if (adapterInfo != null) {
/* 1317 */           this.out.println(indent + "rptr = radapter;");
/* 1318 */           if (methodInfo.returnType != String.class) {
/* 1319 */             this.out.println(indent + "jint rcapacity = (jint)radapter.size;");
/* 1320 */             this.out.println(indent + "jlong deallocator = " + (adapterInfo.constant ? "0;" : new StringBuilder().append("ptr_to_jlong(&(").append(adapterInfo.name).append("::deallocate));").toString()));
/*      */           }
/*      */ 
/* 1323 */           needInit = true;
/* 1324 */         } else if (((returnBy instanceof ByVal)) || (FunctionPointer.class.isAssignableFrom(methodInfo.returnType)))
/*      */         {
/* 1326 */           this.out.println(indent + "jint rcapacity = 1;");
/* 1327 */           this.out.println(indent + "jlong deallocator = ptr_to_jlong(&JavaCPP_" + mangle(methodInfo.returnType.getName()) + "_deallocate);");
/*      */ 
/* 1329 */           this.deallocators.register(methodInfo.returnType);
/* 1330 */           needInit = true;
/*      */         }
/*      */ 
/* 1333 */         if (Pointer.class.isAssignableFrom(methodInfo.returnType)) {
/* 1334 */           this.out.print(indent);
/* 1335 */           if (!(returnBy instanceof ByVal))
/*      */           {
/* 1337 */             if ((Modifier.isStatic(methodInfo.modifiers)) && (methodInfo.parameterTypes.length > 0)) {
/* 1338 */               for (int i = 0; i < methodInfo.parameterTypes.length; i++) {
/* 1339 */                 String cast = getParameterCast(methodInfo, i);
/* 1340 */                 if (methodInfo.parameterTypes[i] == methodInfo.returnType) {
/* 1341 */                   this.out.println("if (rptr == " + cast + "ptr" + i + ") {");
/* 1342 */                   this.out.println(indent + "    rarg = arg" + i + ";");
/* 1343 */                   this.out.print(indent + "} else ");
/*      */                 }
/*      */               }
/* 1346 */             } else if ((!Modifier.isStatic(methodInfo.modifiers)) && (methodInfo.cls == methodInfo.returnType)) {
/* 1347 */               this.out.println("if (rptr == ptr) {");
/* 1348 */               this.out.println(indent + "    rarg = obj;");
/* 1349 */               this.out.print(indent + "} else ");
/*      */             }
/*      */           }
/* 1352 */           this.out.println("if (rptr != NULL) {");
/* 1353 */           this.out.println(indent + "    rarg = env->AllocObject(JavaCPP_getClass(env, " + this.jclasses.register(methodInfo.returnType) + "));");
/*      */ 
/* 1355 */           if (needInit) {
/* 1356 */             this.out.println(indent + "    if (deallocator != 0) {");
/* 1357 */             this.out.println(indent + "        jvalue args[3];");
/* 1358 */             this.out.println(indent + "        args[0].j = ptr_to_jlong(rptr);");
/* 1359 */             this.out.println(indent + "        args[1].i = rcapacity;");
/* 1360 */             this.out.println(indent + "        args[2].j = deallocator;");
/* 1361 */             this.out.println(indent + "        env->CallNonvirtualVoidMethodA(rarg, JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
/*      */ 
/* 1363 */             this.out.println(indent + "    } else {");
/* 1364 */             this.out.println(indent + "        env->SetLongField(rarg, JavaCPP_addressFID, ptr_to_jlong(rptr));");
/* 1365 */             this.out.println(indent + "        env->SetIntField(rarg, JavaCPP_limitFID, rcapacity);");
/* 1366 */             this.out.println(indent + "        env->SetIntField(rarg, JavaCPP_capacityFID, rcapacity);");
/* 1367 */             this.out.println(indent + "    }");
/*      */           } else {
/* 1369 */             this.out.println(indent + "    env->SetLongField(rarg, JavaCPP_addressFID, ptr_to_jlong(rptr));");
/*      */           }
/* 1371 */           this.out.println(indent + "}");
/* 1372 */         } else if (methodInfo.returnType == String.class) {
/* 1373 */           this.out.println(indent + "if (rptr != NULL) {");
/* 1374 */           this.out.println(indent + "    rarg = env->NewStringUTF(rptr);");
/* 1375 */           this.out.println(indent + "}");
/* 1376 */         } else if ((methodInfo.returnType.isArray()) && (methodInfo.returnType.getComponentType().isPrimitive()))
/*      */         {
/* 1378 */           if (adapterInfo == null) {
/* 1379 */             this.out.println(indent + "jint rcapacity = rptr != NULL ? 1 : 0;");
/*      */           }
/* 1381 */           String s = methodInfo.returnType.getComponentType().getName();
/* 1382 */           String S = Character.toUpperCase(s.charAt(0)) + s.substring(1);
/* 1383 */           this.out.println(indent + "if (rptr != NULL) {");
/* 1384 */           this.out.println(indent + "    rarg = env->New" + S + "Array(rcapacity);");
/* 1385 */           this.out.println(indent + "    env->Set" + S + "ArrayRegion(rarg, 0, rcapacity, (j" + s + "*)rptr);");
/* 1386 */           this.out.println(indent + "}");
/* 1387 */           if (adapterInfo != null) {
/* 1388 */             this.out.println(indent + "if (deallocator != 0 && rptr != NULL) {");
/* 1389 */             this.out.println(indent + "    (*(void(*)(void*))jlong_to_ptr(deallocator))((void*)rptr);");
/* 1390 */             this.out.println(indent + "}");
/*      */           }
/* 1392 */         } else if (Buffer.class.isAssignableFrom(methodInfo.returnType)) {
/* 1393 */           if (methodInfo.bufferGetter)
/* 1394 */             this.out.println(indent + "jint rcapacity = size;");
/* 1395 */           else if (adapterInfo == null) {
/* 1396 */             this.out.println(indent + "jint rcapacity = rptr != NULL ? 1 : 0;");
/*      */           }
/* 1398 */           this.out.println(indent + "if (rptr != NULL) {");
/* 1399 */           this.out.println(indent + "    rarg = env->NewDirectByteBuffer(rptr, rcapacity);");
/* 1400 */           this.out.println(indent + "}");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private void doParametersAfter(MethodInformation methodInfo) {
/* 1407 */     if (methodInfo.throwsException != null) {
/* 1408 */       this.mayThrowExceptions = true;
/* 1409 */       this.out.println("    } catch (...) {");
/* 1410 */       this.out.println("        exc = JavaCPP_handleException(env, " + this.jclasses.register(methodInfo.throwsException) + ");");
/* 1411 */       this.out.println("    }");
/* 1412 */       this.out.println();
/*      */     }
/* 1414 */     for (int j = 0; j < methodInfo.parameterTypes.length; j++)
/* 1415 */       if (methodInfo.parameterRaw[j] == 0)
/*      */       {
/* 1418 */         Annotation passBy = getParameterBy(methodInfo, j);
/* 1419 */         String cast = getParameterCast(methodInfo, j);
/* 1420 */         String[] typeName = getCastedCPPTypeName(methodInfo.parameterAnnotations[j], methodInfo.parameterTypes[j]);
/* 1421 */         AdapterInformation adapterInfo = getParameterAdapterInformation(true, methodInfo, j);
/* 1422 */         if ("void*".equals(typeName[0])) {
/* 1423 */           typeName[0] = "char*";
/*      */         }
/* 1425 */         if (Pointer.class.isAssignableFrom(methodInfo.parameterTypes[j])) {
/* 1426 */           if (adapterInfo != null) {
/* 1427 */             for (int k = 0; k < adapterInfo.argc; k++) {
/* 1428 */               this.out.println("    " + typeName[0] + " rptr" + (j + k) + typeName[1] + " = " + cast + "adapter" + j + ";");
/* 1429 */               this.out.println("    jint rsize" + (j + k) + " = (jint)adapter" + j + ".size" + (k > 0 ? k + 1 + ";" : ";"));
/* 1430 */               this.out.println("    if (rptr" + (j + k) + " != " + cast + "ptr" + (j + k) + ") {");
/* 1431 */               this.out.println("        jvalue args[3];");
/* 1432 */               this.out.println("        args[0].j = ptr_to_jlong(rptr" + (j + k) + ");");
/* 1433 */               this.out.println("        args[1].i = rsize" + (j + k) + ";");
/* 1434 */               this.out.println("        args[2].j = ptr_to_jlong(&(" + adapterInfo.name + "::deallocate));");
/* 1435 */               this.out.println("        env->CallNonvirtualVoidMethodA(arg" + j + ", JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
/*      */ 
/* 1437 */               this.out.println("    } else {");
/* 1438 */               this.out.println("        env->SetIntField(arg" + j + ", JavaCPP_limitFID, rsize" + (j + k) + " + position" + (j + k) + ");");
/* 1439 */               this.out.println("    }");
/*      */             }
/* 1441 */           } else if ((((passBy instanceof ByPtrPtr)) || ((passBy instanceof ByPtrRef))) && (!methodInfo.valueSetter) && (!methodInfo.memberSetter))
/*      */           {
/* 1443 */             if (!methodInfo.parameterTypes[j].isAnnotationPresent(Opaque.class)) {
/* 1444 */               this.out.println("    ptr" + j + " -= position" + j + ";");
/*      */             }
/* 1446 */             this.out.println("    if (arg" + j + " != NULL) env->SetLongField(arg" + j + ", JavaCPP_addressFID, ptr_to_jlong(ptr" + j + "));");
/*      */           }
/*      */         }
/* 1449 */         else if (methodInfo.parameterTypes[j] == String.class) {
/* 1450 */           this.out.println("    if (arg" + j + " != NULL) env->ReleaseStringUTFChars(arg" + j + ", ptr" + j + ");");
/* 1451 */         } else if ((methodInfo.parameterTypes[j].isArray()) && (methodInfo.parameterTypes[j].getComponentType().isPrimitive()))
/*      */         {
/* 1453 */           this.out.print("    if (arg" + j + " != NULL) ");
/* 1454 */           if ((methodInfo.valueGetter) || (methodInfo.valueSetter) || (methodInfo.memberGetter) || (methodInfo.memberSetter))
/*      */           {
/* 1456 */             this.out.println("env->ReleasePrimitiveArrayCritical(arg" + j + ", ptr" + j + ", 0);");
/*      */           } else {
/* 1458 */             String s = methodInfo.parameterTypes[j].getComponentType().getName();
/* 1459 */             String S = Character.toUpperCase(s.charAt(0)) + s.substring(1);
/* 1460 */             this.out.println("env->Release" + S + "ArrayElements(arg" + j + ", (j" + s + "*)ptr" + j + ", 0);");
/*      */           }
/*      */         }
/*      */       }
/*      */   }
/*      */ 
/*      */   private void doCallback(Class<?> cls, Method callbackMethod, String callbackName, boolean needFunctor) {
/* 1467 */     Class callbackReturnType = callbackMethod.getReturnType();
/* 1468 */     Class[] callbackParameterTypes = callbackMethod.getParameterTypes();
/* 1469 */     Annotation[] callbackAnnotations = callbackMethod.getAnnotations();
/* 1470 */     Annotation[][] callbackParameterAnnotations = callbackMethod.getParameterAnnotations();
/*      */ 
/* 1472 */     String instanceTypeName = getFunctionClassName(cls);
/* 1473 */     String[] callbackTypeName = getCPPTypeName(cls);
/* 1474 */     String[] returnConvention = callbackTypeName[0].split("\\(");
/* 1475 */     returnConvention[1] = getConstValueTypeName(new String[] { returnConvention[1] });
/* 1476 */     String parameterDeclaration = callbackTypeName[1].substring(1);
/* 1477 */     this.callbacks.register("static " + instanceTypeName + " " + callbackName + "_instance;");
/* 1478 */     this.jclassesInit.register(cls);
/* 1479 */     if (this.out2 != null) {
/* 1480 */       this.out2.println("JNIIMPORT " + returnConvention[0] + (returnConvention.length > 1 ? returnConvention[1] : "") + callbackName + parameterDeclaration + ";");
/*      */     }
/*      */ 
/* 1483 */     this.out.println("JNIEXPORT " + returnConvention[0] + (returnConvention.length > 1 ? returnConvention[1] : "") + callbackName + parameterDeclaration + " {");
/*      */ 
/* 1485 */     this.out.print((callbackReturnType != Void.TYPE ? "    return " : "    ") + callbackName + "_instance(");
/* 1486 */     for (int j = 0; j < callbackParameterTypes.length; j++) {
/* 1487 */       this.out.print("arg" + j);
/* 1488 */       if (j < callbackParameterTypes.length - 1) {
/* 1489 */         this.out.print(", ");
/*      */       }
/*      */     }
/* 1492 */     this.out.println(");");
/* 1493 */     this.out.println("}");
/* 1494 */     if (!needFunctor) {
/* 1495 */       return;
/*      */     }
/*      */ 
/* 1498 */     this.out.println(returnConvention[0] + instanceTypeName + "::operator()" + parameterDeclaration + " {");
/* 1499 */     String returnPrefix = "";
/* 1500 */     if (callbackReturnType != Void.TYPE) {
/* 1501 */       this.out.println("    " + getJNITypeName(callbackReturnType) + " rarg = 0;");
/* 1502 */       returnPrefix = "rarg = ";
/* 1503 */       if (callbackReturnType == String.class) {
/* 1504 */         returnPrefix = returnPrefix + "(jstring)";
/*      */       }
/*      */     }
/* 1507 */     String callbackReturnCast = getCast(callbackAnnotations, callbackReturnType);
/* 1508 */     Annotation returnBy = getBy(callbackAnnotations);
/* 1509 */     String[] returnTypeName = getCPPTypeName(callbackReturnType);
/* 1510 */     String returnValueTypeName = getValueTypeName(returnTypeName);
/* 1511 */     AdapterInformation returnAdapterInfo = getAdapterInformation(false, returnValueTypeName, callbackAnnotations);
/*      */ 
/* 1513 */     this.out.println("    jthrowable exc = NULL;");
/* 1514 */     this.out.println("    JNIEnv* env;");
/* 1515 */     this.out.println("    int attached = JavaCPP_getEnv(&env);");
/* 1516 */     this.out.println("    if (attached < 0) {");
/* 1517 */     this.out.println("        goto end;");
/* 1518 */     this.out.println("    }");
/* 1519 */     this.out.println("{");
/* 1520 */     if (callbackParameterTypes.length > 0) {
/* 1521 */       this.out.println("    jvalue args[" + callbackParameterTypes.length + "];");
/* 1522 */       for (int j = 0; j < callbackParameterTypes.length; j++) {
/* 1523 */         if (callbackParameterTypes[j].isPrimitive()) {
/* 1524 */           this.out.println("    args[" + j + "]." + getSignature(callbackParameterTypes[j]).toLowerCase() + " = (" + getJNITypeName(callbackParameterTypes[j]) + ")arg" + j + ";");
/*      */         }
/*      */         else
/*      */         {
/* 1528 */           Annotation passBy = getBy(callbackParameterAnnotations[j]);
/* 1529 */           String[] typeName = getCPPTypeName(callbackParameterTypes[j]);
/* 1530 */           String valueTypeName = getValueTypeName(typeName);
/* 1531 */           AdapterInformation adapterInfo = getAdapterInformation(false, valueTypeName, callbackParameterAnnotations[j]);
/*      */ 
/* 1533 */           boolean needInit = false;
/* 1534 */           if (adapterInfo != null) {
/* 1535 */             this.usesAdapters = true;
/* 1536 */             this.out.println("    " + adapterInfo.name + " adapter" + j + "(arg" + j + ");");
/* 1537 */             if (callbackParameterTypes[j] != String.class) {
/* 1538 */               this.out.println("    jint size" + j + " = (jint)adapter" + j + ".size;");
/* 1539 */               this.out.println("    jlong deallocator" + j + " = ptr_to_jlong(&(" + adapterInfo.name + "::deallocate));");
/*      */             }
/* 1541 */             needInit = true;
/* 1542 */           } else if ((((passBy instanceof ByVal)) && (callbackParameterTypes[j] != Pointer.class)) || (FunctionPointer.class.isAssignableFrom(callbackParameterTypes[j])))
/*      */           {
/* 1544 */             this.out.println("    jint size" + j + " = 1;");
/* 1545 */             this.out.println("    jlong deallocator" + j + " = ptr_to_jlong(&JavaCPP_" + mangle(callbackParameterTypes[j].getName()) + "_deallocate);");
/*      */ 
/* 1547 */             this.deallocators.register(callbackParameterTypes[j]);
/* 1548 */             needInit = true;
/*      */           }
/*      */ 
/* 1551 */           if ((Pointer.class.isAssignableFrom(callbackParameterTypes[j])) || (Buffer.class.isAssignableFrom(callbackParameterTypes[j])) || ((callbackParameterTypes[j].isArray()) && (callbackParameterTypes[j].getComponentType().isPrimitive())))
/*      */           {
/* 1555 */             if (FunctionPointer.class.isAssignableFrom(callbackParameterTypes[j])) {
/* 1556 */               this.functions.register(callbackParameterTypes[j]);
/* 1557 */               typeName[0] = (getFunctionClassName(callbackParameterTypes[j]) + "*");
/* 1558 */               typeName[1] = "";
/* 1559 */               valueTypeName = getValueTypeName(typeName);
/*      */             }
/* 1561 */             this.out.println("    " + getJNITypeName(callbackParameterTypes[j]) + " obj" + j + " = NULL;");
/* 1562 */             this.out.println("    " + typeName[0] + " ptr" + j + typeName[1] + " = NULL;");
/* 1563 */             if (FunctionPointer.class.isAssignableFrom(callbackParameterTypes[j])) {
/* 1564 */               this.out.println("    ptr" + j + " = new (std::nothrow) " + valueTypeName + ";");
/* 1565 */               this.out.println("    if (ptr" + j + " != NULL) {");
/* 1566 */               this.out.println("        ptr" + j + "->ptr = arg" + j + ";");
/* 1567 */               this.out.println("    }");
/* 1568 */             } else if (adapterInfo != null) {
/* 1569 */               this.out.println("    ptr" + j + " = adapter" + j + ";");
/* 1570 */             } else if (((passBy instanceof ByVal)) && (callbackParameterTypes[j] != Pointer.class)) {
/* 1571 */               this.out.println("    ptr" + j + (getNoException(callbackParameterTypes[j], callbackMethod) ? " = new (std::nothrow) " : " = new ") + valueTypeName + typeName[1] + "(*(" + typeName[0] + typeName[1] + ")&arg" + j + ");");
/*      */             }
/* 1574 */             else if (((passBy instanceof ByVal)) || ((passBy instanceof ByRef))) {
/* 1575 */               this.out.println("    ptr" + j + " = (" + typeName[0] + typeName[1] + ")&arg" + j + ";");
/* 1576 */             } else if ((passBy instanceof ByPtrPtr)) {
/* 1577 */               this.out.println("    if (arg" + j + " == NULL) {");
/* 1578 */               this.out.println("        JavaCPP_log(\"Pointer address of argument " + j + " is NULL in callback for " + cls.getCanonicalName() + ".\");");
/* 1579 */               this.out.println("    } else {");
/* 1580 */               this.out.println("        ptr" + j + " = (" + typeName[0] + typeName[1] + ")*arg" + j + ";");
/* 1581 */               this.out.println("    }");
/*      */             } else {
/* 1583 */               this.out.println("    ptr" + j + " = (" + typeName[0] + typeName[1] + ")arg" + j + ";");
/*      */             }
/*      */           }
/*      */ 
/* 1587 */           if (Pointer.class.isAssignableFrom(callbackParameterTypes[j])) {
/* 1588 */             String s = "    obj" + j + " = env->AllocObject(JavaCPP_getClass(env, " + this.jclasses.register(callbackParameterTypes[j]) + "));";
/*      */ 
/* 1590 */             this.jclassesInit.register(callbackParameterTypes[j]);
/* 1591 */             adapterInfo = getAdapterInformation(true, valueTypeName, callbackParameterAnnotations[j]);
/* 1592 */             if ((adapterInfo != null) || ((passBy instanceof ByPtrPtr)) || ((passBy instanceof ByPtrRef))) {
/* 1593 */               this.out.println(s);
/*      */             } else {
/* 1595 */               this.out.println("    if (ptr" + j + " != NULL) { ");
/* 1596 */               this.out.println("    " + s);
/* 1597 */               this.out.println("    }");
/*      */             }
/* 1599 */             this.out.println("    if (obj" + j + " != NULL) { ");
/* 1600 */             if (needInit) {
/* 1601 */               this.out.println("        if (deallocator" + j + " != 0) {");
/* 1602 */               this.out.println("            jvalue args[3];");
/* 1603 */               this.out.println("            args[0].j = ptr_to_jlong(ptr" + j + ");");
/* 1604 */               this.out.println("            args[1].i = size" + j + ";");
/* 1605 */               this.out.println("            args[2].j = deallocator" + j + ";");
/* 1606 */               this.out.println("            env->CallNonvirtualVoidMethodA(obj" + j + ", JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
/*      */ 
/* 1608 */               this.out.println("        } else {");
/* 1609 */               this.out.println("            env->SetLongField(obj" + j + ", JavaCPP_addressFID, ptr_to_jlong(ptr" + j + "));");
/* 1610 */               this.out.println("            env->SetIntField(obj" + j + ", JavaCPP_limitFID, size" + j + ");");
/* 1611 */               this.out.println("            env->SetIntField(obj" + j + ", JavaCPP_capacityFID, size" + j + ");");
/* 1612 */               this.out.println("        }");
/*      */             } else {
/* 1614 */               this.out.println("        env->SetLongField(obj" + j + ", JavaCPP_addressFID, ptr_to_jlong(ptr" + j + "));");
/*      */             }
/* 1616 */             this.out.println("    }");
/* 1617 */             this.out.println("    args[" + j + "].l = obj" + j + ";");
/* 1618 */           } else if (callbackParameterTypes[j] == String.class) {
/* 1619 */             this.out.println("    jstring obj" + j + " = (const char*)" + (adapterInfo != null ? "adapter" : "arg") + j + " == NULL ? NULL : env->NewStringUTF((const char*)" + (adapterInfo != null ? "adapter" : "arg") + j + ");");
/*      */ 
/* 1621 */             this.out.println("    args[" + j + "].l = obj" + j + ";");
/* 1622 */           } else if ((callbackParameterTypes[j].isArray()) && (callbackParameterTypes[j].getComponentType().isPrimitive()))
/*      */           {
/* 1624 */             if (adapterInfo == null) {
/* 1625 */               this.out.println("    jint size" + j + " = ptr" + j + " != NULL ? 1 : 0;");
/*      */             }
/* 1627 */             String s = callbackParameterTypes[j].getComponentType().getName();
/* 1628 */             String S = Character.toUpperCase(s.charAt(0)) + s.substring(1);
/* 1629 */             this.out.println("    if (ptr" + j + " != NULL) {");
/* 1630 */             this.out.println("        obj" + j + " = env->New" + S + "Array(size" + j + ");");
/* 1631 */             this.out.println("        env->Set" + S + "ArrayRegion(obj" + j + ", 0, size" + j + ", (j" + s + "*)ptr" + j + ");");
/* 1632 */             this.out.println("    }");
/* 1633 */             if (adapterInfo != null) {
/* 1634 */               this.out.println("    if (deallocator" + j + " != 0 && ptr" + j + " != NULL) {");
/* 1635 */               this.out.println("        (*(void(*)(void*))jlong_to_ptr(deallocator" + j + "))((void*)ptr" + j + ");");
/* 1636 */               this.out.println("    }");
/*      */             }
/* 1638 */           } else if (Buffer.class.isAssignableFrom(callbackParameterTypes[j])) {
/* 1639 */             if (adapterInfo == null) {
/* 1640 */               this.out.println("    jint size" + j + " = ptr" + j + " != NULL ? 1 : 0;");
/*      */             }
/* 1642 */             this.out.println("    if (ptr" + j + " != NULL) {");
/* 1643 */             this.out.println("        obj" + j + " = env->NewDirectByteBuffer(ptr" + j + ", size" + j + ");");
/* 1644 */             this.out.println("    }");
/*      */           } else {
/* 1646 */             logger.log(Level.WARNING, "Callback \"" + callbackMethod + "\" has unsupported parameter type \"" + callbackParameterTypes[j].getCanonicalName() + "\". Compilation will most likely fail.");
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1653 */     this.out.println("    if (obj == NULL) {");
/* 1654 */     this.out.println("        obj = env->NewGlobalRef(env->AllocObject(JavaCPP_getClass(env, " + this.jclasses.register(cls) + ")));");
/* 1655 */     this.out.println("        if (obj == NULL) {");
/* 1656 */     this.out.println("            JavaCPP_log(\"Error creating global reference of " + cls.getCanonicalName() + " instance for callback.\");");
/* 1657 */     this.out.println("        } else {");
/* 1658 */     this.out.println("            env->SetLongField(obj, JavaCPP_addressFID, ptr_to_jlong(this));");
/* 1659 */     this.out.println("        }");
/* 1660 */     this.out.println("        ptr = &" + callbackName + ";");
/* 1661 */     this.out.println("    }");
/* 1662 */     this.out.println("    if (mid == NULL) {");
/* 1663 */     this.out.println("        mid = env->GetMethodID(JavaCPP_getClass(env, " + this.jclasses.register(cls) + "), \"" + callbackMethod.getName() + "\", \"(" + getSignature(callbackMethod.getParameterTypes()) + ")" + getSignature(callbackMethod.getReturnType()) + "\");");
/*      */ 
/* 1665 */     this.out.println("    }");
/* 1666 */     this.out.println("    if (env->IsSameObject(obj, NULL)) {");
/* 1667 */     this.out.println("        JavaCPP_log(\"Function pointer object is NULL in callback for " + cls.getCanonicalName() + ".\");");
/* 1668 */     this.out.println("    } else if (mid == NULL) {");
/* 1669 */     this.out.println("        JavaCPP_log(\"Error getting method ID of function caller \\\"" + callbackMethod + "\\\" for callback.\");");
/* 1670 */     this.out.println("    } else {");
/* 1671 */     String s = "Object";
/* 1672 */     if (callbackReturnType.isPrimitive()) {
/* 1673 */       s = callbackReturnType.getName();
/* 1674 */       s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
/*      */     }
/* 1676 */     this.out.println("        " + returnPrefix + "env->Call" + s + "MethodA(obj, mid, " + (callbackParameterTypes.length == 0 ? "NULL);" : "args);"));
/* 1677 */     this.out.println("        if ((exc = env->ExceptionOccurred()) != NULL) {");
/* 1678 */     this.out.println("            env->ExceptionClear();");
/* 1679 */     this.out.println("        }");
/* 1680 */     this.out.println("    }");
/*      */ 
/* 1682 */     for (int j = 0; j < callbackParameterTypes.length; j++) {
/* 1683 */       if (Pointer.class.isAssignableFrom(callbackParameterTypes[j])) {
/* 1684 */         String[] typeName = getCPPTypeName(callbackParameterTypes[j]);
/* 1685 */         Annotation passBy = getBy(callbackParameterAnnotations[j]);
/* 1686 */         String cast = getCast(callbackParameterAnnotations[j], callbackParameterTypes[j]);
/* 1687 */         String valueTypeName = getValueTypeName(typeName);
/* 1688 */         AdapterInformation adapterInfo = getAdapterInformation(true, valueTypeName, callbackParameterAnnotations[j]);
/*      */ 
/* 1690 */         if ("void*".equals(typeName[0])) {
/* 1691 */           typeName[0] = "char*";
/*      */         }
/* 1693 */         if ((adapterInfo != null) || ((passBy instanceof ByPtrPtr)) || ((passBy instanceof ByPtrRef))) {
/* 1694 */           this.out.println("    " + typeName[0] + " rptr" + j + typeName[1] + " = (" + typeName[0] + typeName[1] + ")jlong_to_ptr(env->GetLongField(obj" + j + ", JavaCPP_addressFID));");
/*      */ 
/* 1696 */           if (adapterInfo != null) {
/* 1697 */             this.out.println("    jint rsize" + j + " = env->GetIntField(obj" + j + ", JavaCPP_limitFID);");
/*      */           }
/* 1699 */           if (!callbackParameterTypes[j].isAnnotationPresent(Opaque.class)) {
/* 1700 */             this.out.println("    jint rposition" + j + " = env->GetIntField(obj" + j + ", JavaCPP_positionFID);");
/* 1701 */             this.out.println("    rptr" + j + " += rposition" + j + ";");
/* 1702 */             if (adapterInfo != null) {
/* 1703 */               this.out.println("    rsize" + j + " -= rposition" + j + ";");
/*      */             }
/*      */           }
/* 1706 */           if (adapterInfo != null) {
/* 1707 */             this.out.println("    adapter" + j + ".assign(rptr" + j + ", rsize" + j + ");");
/* 1708 */           } else if ((passBy instanceof ByPtrPtr)) {
/* 1709 */             this.out.println("    if (arg" + j + " != NULL) {");
/* 1710 */             this.out.println("        *arg" + j + " = *" + cast + "&rptr" + j + ";");
/* 1711 */             this.out.println("    }");
/* 1712 */           } else if ((passBy instanceof ByPtrRef)) {
/* 1713 */             this.out.println("    arg" + j + " = " + cast + "rptr" + j + ";");
/*      */           }
/*      */         }
/*      */       }
/* 1717 */       if (!callbackParameterTypes[j].isPrimitive()) {
/* 1718 */         this.out.println("    env->DeleteLocalRef(obj" + j + ");");
/*      */       }
/*      */     }
/* 1721 */     this.out.println("}");
/* 1722 */     this.out.println("end:");
/*      */ 
/* 1724 */     if (callbackReturnType != Void.TYPE) {
/* 1725 */       if ("void*".equals(returnTypeName[0])) {
/* 1726 */         returnTypeName[0] = "char*";
/*      */       }
/* 1728 */       if (Pointer.class.isAssignableFrom(callbackReturnType)) {
/* 1729 */         this.out.println("    " + returnTypeName[0] + " rptr" + returnTypeName[1] + " = rarg == NULL ? NULL : (" + returnTypeName[0] + returnTypeName[1] + ")jlong_to_ptr(env->GetLongField(rarg, JavaCPP_addressFID));");
/*      */ 
/* 1731 */         if (returnAdapterInfo != null) {
/* 1732 */           this.out.println("    jint rsize = rarg == NULL ? 0 : env->GetIntField(rarg, JavaCPP_limitFID);");
/*      */         }
/* 1734 */         if (!callbackReturnType.isAnnotationPresent(Opaque.class)) {
/* 1735 */           this.out.println("    jint rposition = rarg == NULL ? 0 : env->GetIntField(rarg, JavaCPP_positionFID);");
/* 1736 */           this.out.println("    rptr += rposition;");
/* 1737 */           if (returnAdapterInfo != null)
/* 1738 */             this.out.println("    rsize -= rposition;");
/*      */         }
/*      */       }
/* 1741 */       else if (callbackReturnType == String.class) {
/* 1742 */         this.out.println("    " + returnTypeName[0] + " rptr" + returnTypeName[1] + " = rarg == NULL ? NULL : env->GetStringUTFChars(rarg, NULL);");
/* 1743 */         if (returnAdapterInfo != null)
/* 1744 */           this.out.println("    jint rsize = 0;");
/*      */       }
/* 1746 */       else if (Buffer.class.isAssignableFrom(callbackReturnType)) {
/* 1747 */         this.out.println("    " + returnTypeName[0] + " rptr" + returnTypeName[1] + " = rarg == NULL ? NULL : env->GetDirectBufferAddress(rarg);");
/* 1748 */         if (returnAdapterInfo != null)
/* 1749 */           this.out.println("    jint rsize = rarg == NULL ? 0 : env->GetDirectBufferCapacity(rarg);");
/*      */       }
/* 1751 */       else if (!callbackReturnType.isPrimitive()) {
/* 1752 */         logger.log(Level.WARNING, "Callback \"" + callbackMethod + "\" has unsupported return type \"" + callbackReturnType.getCanonicalName() + "\". Compilation will most likely fail.");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1757 */     this.out.println("    if (exc != NULL) {");
/* 1758 */     this.out.println("        jclass cls = env->GetObjectClass(exc);");
/* 1759 */     this.out.println("        jmethodID mid = env->GetMethodID(cls, \"toString\", \"()Ljava/lang/String;\");");
/* 1760 */     this.out.println("        env->DeleteLocalRef(cls);");
/* 1761 */     this.out.println("        jstring str = (jstring)env->CallObjectMethod(exc, mid);");
/* 1762 */     this.out.println("        env->DeleteLocalRef(exc);");
/* 1763 */     this.out.println("        const char *msg = env->GetStringUTFChars(str, NULL);");
/* 1764 */     this.out.println("        JavaCPP_exception e(msg);");
/* 1765 */     this.out.println("        env->ReleaseStringUTFChars(str, msg);");
/* 1766 */     this.out.println("        env->DeleteLocalRef(str);");
/* 1767 */     this.out.println("        JavaCPP_detach(attached);");
/* 1768 */     this.out.println("        throw e;");
/* 1769 */     this.out.println("    } else {");
/* 1770 */     this.out.println("        JavaCPP_detach(attached);");
/* 1771 */     this.out.println("    }");
/*      */ 
/* 1773 */     if (callbackReturnType != Void.TYPE) {
/* 1774 */       if (callbackReturnType.isPrimitive()) {
/* 1775 */         this.out.println("    return " + callbackReturnCast + "rarg;");
/* 1776 */       } else if (returnAdapterInfo != null) {
/* 1777 */         this.usesAdapters = true;
/* 1778 */         this.out.println("    return " + returnAdapterInfo.name + "(" + callbackReturnCast + "rptr, rsize);");
/* 1779 */       } else if (FunctionPointer.class.isAssignableFrom(callbackReturnType)) {
/* 1780 */         this.functions.register(callbackReturnType);
/* 1781 */         this.out.println("    return " + callbackReturnCast + "(rptr == NULL ? NULL : rptr->ptr);");
/* 1782 */       } else if (((returnBy instanceof ByVal)) || ((returnBy instanceof ByRef))) {
/* 1783 */         this.out.println("    if (rptr == NULL) {");
/* 1784 */         this.out.println("        JavaCPP_log(\"Return pointer address is NULL in callback for " + cls.getCanonicalName() + ".\");");
/* 1785 */         this.out.println("        static " + returnValueTypeName + " empty" + returnTypeName[1] + ";");
/* 1786 */         this.out.println("        return empty;");
/* 1787 */         this.out.println("    } else {");
/* 1788 */         this.out.println("        return *" + callbackReturnCast + "rptr;");
/* 1789 */         this.out.println("    }");
/* 1790 */       } else if ((returnBy instanceof ByPtrPtr)) {
/* 1791 */         this.out.println("    return " + callbackReturnCast + "&rptr;");
/*      */       } else {
/* 1793 */         this.out.println("    return " + callbackReturnCast + "rptr;");
/*      */       }
/*      */     }
/* 1796 */     this.out.println("}");
/*      */   }
/*      */ 
/*      */   private void doCallbackAllocator(Class cls, String callbackName)
/*      */   {
/* 1802 */     String instanceTypeName = getFunctionClassName(cls);
/* 1803 */     this.out.println("    obj = env->NewWeakGlobalRef(obj);");
/* 1804 */     this.out.println("    if (obj == NULL) {");
/* 1805 */     this.out.println("        JavaCPP_log(\"Error creating global reference of " + cls.getCanonicalName() + " instance for callback.\");");
/* 1806 */     this.out.println("        return;");
/* 1807 */     this.out.println("    }");
/* 1808 */     this.out.println("    " + instanceTypeName + "* rptr = new (std::nothrow) " + instanceTypeName + ";");
/* 1809 */     this.out.println("    if (rptr != NULL) {");
/* 1810 */     this.out.println("        rptr->ptr = &" + callbackName + ";");
/* 1811 */     this.out.println("        rptr->obj = obj;");
/* 1812 */     this.out.println("        jvalue args[3];");
/* 1813 */     this.out.println("        args[0].j = ptr_to_jlong(rptr);");
/* 1814 */     this.out.println("        args[1].i = 1;");
/* 1815 */     this.out.println("        args[2].j = ptr_to_jlong(&JavaCPP_" + mangle(cls.getName()) + "_deallocate);");
/* 1816 */     this.deallocators.register(cls);
/* 1817 */     this.out.println("        env->CallNonvirtualVoidMethodA(obj, JavaCPP_getClass(env, " + this.jclasses.register(Pointer.class) + "), JavaCPP_initMID, args);");
/*      */ 
/* 1819 */     this.out.println("        " + callbackName + "_instance = *rptr;");
/* 1820 */     this.out.println("    }");
/* 1821 */     this.out.println("}");
/*      */   }
/*      */ 
/*      */   public boolean checkPlatform(Class<?> cls) {
/* 1825 */     Properties classProperties = (Properties)cls.getAnnotation(Properties.class);
/*      */ 
/* 1827 */     if (classProperties != null) {
/* 1828 */       Class[] classes = classProperties.inherit();
/* 1829 */       if (classes != null) {
/* 1830 */         for (Class c : classes) {
/* 1831 */           if (checkPlatform(c)) {
/* 1832 */             return true;
/*      */           }
/*      */         }
/*      */       }
/* 1836 */       Platform[] platforms = classProperties.value();
/* 1837 */       if (platforms != null) {
/* 1838 */         for (Platform p : platforms) {
/* 1839 */           if (checkPlatform(p))
/* 1840 */             return true;
/*      */         }
/*      */       }
/*      */     }
/* 1844 */     else if (checkPlatform((Platform)cls.getAnnotation(Platform.class))) {
/* 1845 */       return true;
/*      */     }
/* 1847 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean checkPlatform(Platform platform) {
/* 1851 */     if (platform == null) {
/* 1852 */       return true;
/*      */     }
/* 1854 */     String platformName = this.properties.getProperty("platform.name");
/* 1855 */     String[][] names = { platform.value(), platform.not() };
/* 1856 */     boolean[] matches = { false, false };
/* 1857 */     for (int i = 0; i < names.length; i++) {
/* 1858 */       for (String s : names[i]) {
/* 1859 */         if (platformName.startsWith(s)) {
/* 1860 */           matches[i] = true;
/* 1861 */           break;
/*      */         }
/*      */       }
/*      */     }
/* 1865 */     if (((names[0].length == 0) || (matches[0] != 0)) && ((names[1].length == 0) || (matches[1] == 0))) {
/* 1866 */       return true;
/*      */     }
/* 1868 */     return false;
/*      */   }
/*      */ 
/*      */   private String getFunctionClassName(Class<?> cls) {
/* 1872 */     Name name = (Name)cls.getAnnotation(Name.class);
/* 1873 */     return "JavaCPP_" + mangle(cls.getName());
/*      */   }
/*      */ 
/*      */   private static Method getFunctionMethod(Class<?> cls, boolean[] callbackAllocators) {
/* 1877 */     if (!FunctionPointer.class.isAssignableFrom(cls)) {
/* 1878 */       return null;
/*      */     }
/* 1880 */     Method[] methods = cls.getDeclaredMethods();
/* 1881 */     Method functionMethod = null;
/* 1882 */     for (int i = 0; i < methods.length; i++) {
/* 1883 */       String methodName = methods[i].getName();
/* 1884 */       int modifiers = methods[i].getModifiers();
/* 1885 */       Class[] parameterTypes = methods[i].getParameterTypes();
/* 1886 */       Class returnType = methods[i].getReturnType();
/* 1887 */       if (!Modifier.isStatic(modifiers))
/*      */       {
/* 1890 */         if ((callbackAllocators != null) && (methodName.startsWith("allocate")) && (Modifier.isNative(modifiers)) && (returnType == Void.TYPE) && (parameterTypes.length == 0))
/*      */         {
/* 1894 */           callbackAllocators[i] = true;
/* 1895 */         } else if ((methodName.startsWith("call")) || (methodName.startsWith("apply")))
/*      */         {
/* 1897 */           functionMethod = methods[i];
/*      */         }
/*      */       }
/*      */     }
/* 1900 */     return functionMethod;
/*      */   }
/*      */ 
/*      */   public static MethodInformation getMethodInformation(Method method)
/*      */   {
/* 1920 */     if (!Modifier.isNative(method.getModifiers())) {
/* 1921 */       return null;
/*      */     }
/* 1923 */     MethodInformation info = new MethodInformation();
/* 1924 */     info.cls = method.getDeclaringClass();
/* 1925 */     info.method = method;
/* 1926 */     info.annotations = method.getAnnotations();
/* 1927 */     info.modifiers = method.getModifiers();
/* 1928 */     info.returnType = method.getReturnType();
/* 1929 */     info.name = method.getName();
/* 1930 */     Name name = (Name)method.getAnnotation(Name.class);
/* 1931 */     info.memberName = new String[] { name != null ? name.value() : info.name };
/* 1932 */     Index index = (Index)method.getAnnotation(Index.class);
/* 1933 */     info.dim = (index != null ? index.value() : 0);
/* 1934 */     info.parameterTypes = method.getParameterTypes();
/* 1935 */     info.parameterAnnotations = method.getParameterAnnotations();
/* 1936 */     info.returnRaw = method.isAnnotationPresent(Raw.class);
/* 1937 */     info.withEnv = (info.returnRaw ? ((Raw)method.getAnnotation(Raw.class)).withEnv() : false);
/* 1938 */     info.parameterRaw = new boolean[info.parameterAnnotations.length];
/* 1939 */     for (int i = 0; i < info.parameterAnnotations.length; i++) {
/* 1940 */       for (int j = 0; j < info.parameterAnnotations[i].length; j++) {
/* 1941 */         if ((info.parameterAnnotations[i][j] instanceof Raw)) {
/* 1942 */           info.parameterRaw[i] = true;
/* 1943 */           info.withEnv |= ((Raw)info.parameterAnnotations[i][j]).withEnv();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1948 */     boolean canBeGetter = (info.returnType != Void.TYPE) || ((info.parameterTypes.length > 0) && (info.parameterTypes[0].isArray()) && (info.parameterTypes[0].getComponentType().isPrimitive()));
/*      */ 
/* 1950 */     boolean canBeSetter = ((info.returnType == Void.TYPE) || (info.returnType == info.cls)) && (info.parameterTypes.length > 0);
/*      */ 
/* 1960 */     boolean canBeAllocator = (!Modifier.isStatic(info.modifiers)) && (info.returnType == Void.TYPE);
/*      */ 
/* 1962 */     boolean canBeArrayAllocator = (canBeAllocator) && (info.parameterTypes.length == 1) && ((info.parameterTypes[0] == Integer.TYPE) || (info.parameterTypes[0] == Long.TYPE));
/*      */ 
/* 1965 */     boolean valueGetter = false;
/* 1966 */     boolean valueSetter = false;
/* 1967 */     boolean memberGetter = false;
/* 1968 */     boolean memberSetter = false;
/* 1969 */     boolean noReturnGetter = false;
/* 1970 */     Method pairedMethod = null;
/* 1971 */     Method[] methods = info.cls.getDeclaredMethods();
/* 1972 */     for (int i = 0; i < methods.length; i++) {
/* 1973 */       Method method2 = methods[i];
/* 1974 */       int modifiers2 = method2.getModifiers();
/* 1975 */       Class returnType2 = method2.getReturnType();
/* 1976 */       String methodName2 = method2.getName();
/* 1977 */       Class[] parameterTypes2 = method2.getParameterTypes();
/*      */ 
/* 1979 */       if ((!method.equals(method2)) && (Modifier.isNative(modifiers2)))
/*      */       {
/* 1983 */         boolean canBeValueGetter = false;
/* 1984 */         boolean canBeValueSetter = false;
/* 1985 */         if ((canBeGetter) && ("get".equals(info.name)) && ("put".equals(methodName2))) {
/* 1986 */           canBeValueGetter = true;
/* 1987 */         } else if ((canBeSetter) && ("put".equals(info.name)) && ("get".equals(methodName2))) {
/* 1988 */           canBeValueSetter = true; } else {
/* 1989 */           if (!methodName2.equals(info.name)) continue;
/* 1990 */           info.overloaded = true;
/*      */         }
/*      */ 
/* 1995 */         boolean sameIndexParameters = true;
/* 1996 */         for (int j = 0; (j < info.parameterTypes.length) && (j < parameterTypes2.length); j++) {
/* 1997 */           if (info.parameterTypes[j] != parameterTypes2[j]) {
/* 1998 */             sameIndexParameters = false;
/*      */           }
/*      */         }
/* 2001 */         if (sameIndexParameters)
/*      */         {
/* 2005 */           boolean parameterAsReturn = (canBeValueGetter) && (info.parameterTypes.length > 0) && (info.parameterTypes[0].isArray()) && (info.parameterTypes[0].getComponentType().isPrimitive());
/*      */ 
/* 2007 */           boolean parameterAsReturn2 = (canBeValueSetter) && (parameterTypes2.length > 0) && (parameterTypes2[0].isArray()) && (parameterTypes2[0].getComponentType().isPrimitive());
/*      */ 
/* 2010 */           if (canBeGetter) if (parameterTypes2.length - (parameterAsReturn ? 0 : 1) == info.parameterTypes.length) if (((parameterAsReturn ? info.parameterTypes[(info.parameterTypes.length - 1)] : info.returnType) == parameterTypes2[(parameterTypes2.length - 1)]) && ((returnType2 == Void.TYPE) || (returnType2 == info.cls)))
/*      */               {
/* 2013 */                 pairedMethod = method2;
/* 2014 */                 valueGetter = canBeValueGetter;
/* 2015 */                 memberGetter = !canBeValueGetter;
/* 2016 */                 noReturnGetter = parameterAsReturn; continue;
/*      */               } 
/* 2017 */           if (canBeSetter) if (info.parameterTypes.length - (parameterAsReturn2 ? 0 : 1) == parameterTypes2.length) if ((parameterAsReturn2 ? parameterTypes2[(parameterTypes2.length - 1)] : returnType2) == info.parameterTypes[(info.parameterTypes.length - 1)])
/*      */               {
/* 2020 */                 pairedMethod = method2;
/* 2021 */                 valueSetter = canBeValueSetter;
/* 2022 */                 memberSetter = !canBeValueSetter;
/*      */               } 
/*      */         }
/*      */       }
/*      */     }
/* 2026 */     Annotation behavior = getBehavior(info.annotations);
/* 2027 */     if ((canBeGetter) && ((behavior instanceof ValueGetter))) {
/* 2028 */       info.valueGetter = true;
/* 2029 */       info.noReturnGetter = noReturnGetter;
/* 2030 */     } else if ((canBeSetter) && ((behavior instanceof ValueSetter))) {
/* 2031 */       info.valueSetter = true;
/* 2032 */     } else if ((canBeGetter) && ((behavior instanceof MemberGetter))) {
/* 2033 */       info.memberGetter = true;
/* 2034 */       info.noReturnGetter = noReturnGetter;
/* 2035 */     } else if ((canBeSetter) && ((behavior instanceof MemberSetter))) {
/* 2036 */       info.memberSetter = true;
/* 2037 */     } else if ((canBeAllocator) && ((behavior instanceof Allocator))) {
/* 2038 */       info.allocator = true;
/* 2039 */     } else if ((canBeArrayAllocator) && ((behavior instanceof ArrayAllocator))) {
/* 2040 */       info.allocator = (info.arrayAllocator = 1);
/* 2041 */     } else if (behavior == null)
/*      */     {
/* 2043 */       if ((info.returnType == Void.TYPE) && ("deallocate".equals(info.name)) && (!Modifier.isStatic(info.modifiers)) && (info.parameterTypes.length == 2) && (info.parameterTypes[0] == Long.TYPE) && (info.parameterTypes[1] == Long.TYPE))
/*      */       {
/* 2046 */         info.deallocator = true;
/* 2047 */       } else if ((canBeAllocator) && ("allocate".equals(info.name))) {
/* 2048 */         info.allocator = true;
/* 2049 */       } else if ((canBeArrayAllocator) && ("allocateArray".equals(info.name))) {
/* 2050 */         info.allocator = (info.arrayAllocator = 1);
/* 2051 */       } else if ((info.returnType.isAssignableFrom(ByteBuffer.class)) && ("asDirectBuffer".equals(info.name)) && (!Modifier.isStatic(info.modifiers)) && (info.parameterTypes.length == 0))
/*      */       {
/* 2053 */         info.bufferGetter = true;
/* 2054 */       } else if (valueGetter) {
/* 2055 */         info.valueGetter = true;
/* 2056 */         info.noReturnGetter = noReturnGetter;
/* 2057 */         info.pairedMethod = pairedMethod;
/* 2058 */       } else if (valueSetter) {
/* 2059 */         info.valueSetter = true;
/* 2060 */         info.pairedMethod = pairedMethod;
/* 2061 */       } else if (memberGetter) {
/* 2062 */         info.memberGetter = true;
/* 2063 */         info.noReturnGetter = noReturnGetter;
/* 2064 */         info.pairedMethod = pairedMethod;
/* 2065 */       } else if (memberSetter) {
/* 2066 */         info.memberSetter = true;
/* 2067 */         info.pairedMethod = pairedMethod;
/*      */       }
/*      */     } else {
/* 2070 */       logger.log(Level.WARNING, "Method \"" + method + "\" cannot behave like a \"" + behavior + "\". No code will be generated.");
/*      */ 
/* 2072 */       return null;
/*      */     }
/*      */ 
/* 2075 */     if ((name == null) && (info.pairedMethod != null)) {
/* 2076 */       name = (Name)info.pairedMethod.getAnnotation(Name.class);
/* 2077 */       if (name != null) {
/* 2078 */         info.memberName = name.value();
/*      */       }
/*      */     }
/*      */ 
/* 2082 */     info.noOffset = ((info.cls.isAnnotationPresent(NoOffset.class)) || (method.isAnnotationPresent(NoOffset.class)) || (method.isAnnotationPresent(Index.class)));
/*      */ 
/* 2085 */     if ((!info.noOffset) && (info.pairedMethod != null)) {
/* 2086 */       info.noOffset = ((info.pairedMethod.isAnnotationPresent(NoOffset.class)) || (info.pairedMethod.isAnnotationPresent(Index.class)));
/*      */     }
/*      */ 
/* 2090 */     if ((info.parameterTypes.length == 0) || (!info.parameterTypes[0].isArray())) {
/* 2091 */       if ((info.valueGetter) || (info.memberGetter))
/* 2092 */         info.dim = info.parameterTypes.length;
/* 2093 */       else if ((info.memberSetter) || (info.valueSetter)) {
/* 2094 */         info.dim = (info.parameterTypes.length - 1);
/*      */       }
/*      */     }
/*      */ 
/* 2098 */     info.throwsException = null;
/* 2099 */     if ((!getNoException(info.cls, method)) && (
/* 2100 */       (((getBy(info.annotations) instanceof ByVal)) && (!getNoException(info.returnType, method))) || ((!info.deallocator) && (!info.valueGetter) && (!info.valueSetter) && (!info.memberGetter) && (!info.memberSetter) && (!info.bufferGetter))))
/*      */     {
/* 2103 */       Class[] exceptions = method.getExceptionTypes();
/* 2104 */       info.throwsException = (exceptions.length > 0 ? exceptions[0] : RuntimeException.class);
/*      */     }
/*      */ 
/* 2107 */     return info;
/*      */   }
/*      */ 
/*      */   public static boolean getNoException(Class<?> cls, Method method) {
/* 2111 */     boolean noException = (baseClasses.contains(cls)) || (method.isAnnotationPresent(NoException.class));
/*      */ 
/* 2113 */     while ((!noException) && (cls != null) && 
/* 2114 */       (!(noException = cls.isAnnotationPresent(NoException.class))))
/*      */     {
/* 2117 */       cls = cls.getDeclaringClass();
/*      */     }
/* 2119 */     return noException;
/*      */   }
/*      */ 
/*      */   public static AdapterInformation getParameterAdapterInformation(boolean out, MethodInformation methodInfo, int j)
/*      */   {
/* 2129 */     if ((out) && ((methodInfo.parameterTypes[j] == String.class) || (methodInfo.valueSetter) || (methodInfo.memberSetter))) {
/* 2130 */       return null;
/*      */     }
/* 2132 */     String typeName = getParameterCast(methodInfo, j);
/* 2133 */     if ((typeName != null) && (typeName.startsWith("(")) && (typeName.endsWith(")"))) {
/* 2134 */       typeName = typeName.substring(1, typeName.length() - 1);
/*      */     }
/* 2136 */     if ((typeName == null) || (typeName.length() == 0)) {
/* 2137 */       typeName = getCastedCPPTypeName(methodInfo.parameterAnnotations[j], methodInfo.parameterTypes[j])[0];
/*      */     }
/* 2139 */     String valueTypeName = getValueTypeName(new String[] { typeName });
/* 2140 */     AdapterInformation adapter = getAdapterInformation(out, valueTypeName, methodInfo.parameterAnnotations[j]);
/* 2141 */     if ((adapter == null) && (methodInfo.pairedMethod != null) && ((methodInfo.valueSetter) || (methodInfo.memberSetter)))
/*      */     {
/* 2143 */       adapter = getAdapterInformation(out, valueTypeName, methodInfo.pairedMethod.getAnnotations());
/*      */     }
/* 2145 */     return adapter;
/*      */   }
/*      */   public static AdapterInformation getAdapterInformation(boolean out, String valueTypeName, Annotation[] annotations) {
/* 2148 */     AdapterInformation adapterInfo = null;
/* 2149 */     boolean constant = false;
/* 2150 */     String cast = "";
/* 2151 */     for (Annotation a : annotations) {
/* 2152 */       Adapter adapter = (a instanceof Adapter) ? (Adapter)a : (Adapter)a.annotationType().getAnnotation(Adapter.class);
/* 2153 */       if (adapter != null) {
/* 2154 */         adapterInfo = new AdapterInformation();
/* 2155 */         adapterInfo.name = adapter.value();
/* 2156 */         adapterInfo.argc = adapter.argc();
/* 2157 */         if (a != adapter) {
/*      */           try {
/* 2159 */             Class cls = a.annotationType();
/* 2160 */             if (cls.isAnnotationPresent(Const.class))
/* 2161 */               constant = true;
/*      */             try
/*      */             {
/* 2164 */               String value = cls.getDeclaredMethod("value", new Class[0]).invoke(a, new Object[0]).toString();
/* 2165 */               if ((value != null) && (value.length() > 0)) {
/* 2166 */                 valueTypeName = value;
/*      */               }
/*      */             }
/*      */             catch (NoSuchMethodException e)
/*      */             {
/* 2171 */               valueTypeName = null;
/*      */             }
/* 2173 */             Cast c = (Cast)cls.getAnnotation(Cast.class);
/* 2174 */             if ((c != null) && (cast.length() == 0)) {
/* 2175 */               cast = c.value()[0];
/* 2176 */               if (valueTypeName != null) {
/* 2177 */                 cast = cast + "< " + valueTypeName + " >";
/*      */               }
/* 2179 */               if (c.value().length > 1)
/* 2180 */                 cast = cast + c.value()[1];
/*      */             }
/*      */           }
/*      */           catch (Exception ex) {
/* 2184 */             logger.log(Level.WARNING, "Could not invoke the value() method on annotation \"" + a + "\".", ex);
/*      */           }
/* 2186 */           if ((valueTypeName != null) && (valueTypeName.length() > 0))
/*      */           {
/*      */             AdapterInformation tmp360_359 = adapterInfo; tmp360_359.name = (tmp360_359.name + "< " + valueTypeName + " >");
/*      */           }
/*      */         }
/* 2190 */       } else if ((a instanceof Const)) {
/* 2191 */         constant = true;
/* 2192 */       } else if ((a instanceof Cast)) {
/* 2193 */         Cast c = (Cast)a;
/* 2194 */         if (c.value().length > 1) {
/* 2195 */           cast = c.value()[1];
/*      */         }
/*      */       }
/*      */     }
/* 2199 */     if (adapterInfo != null) {
/* 2200 */       adapterInfo.cast = cast;
/* 2201 */       adapterInfo.constant = constant;
/*      */     }
/* 2203 */     return (out) && (constant) ? null : adapterInfo;
/*      */   }
/*      */ 
/*      */   public static String getParameterCast(MethodInformation methodInfo, int j) {
/* 2207 */     String cast = getCast(methodInfo.parameterAnnotations[j], methodInfo.parameterTypes[j]);
/* 2208 */     if (((cast == null) || (cast.length() == 0)) && (j == methodInfo.parameterTypes.length - 1) && ((methodInfo.valueSetter) || (methodInfo.memberSetter)) && (methodInfo.pairedMethod != null))
/*      */     {
/* 2210 */       cast = getCast(methodInfo.pairedMethod.getAnnotations(), methodInfo.pairedMethod.getReturnType());
/*      */     }
/* 2212 */     return cast;
/*      */   }
/*      */ 
/*      */   public static String getCast(Annotation[] annotations, Class<?> type) {
/* 2216 */     String[] typeName = null;
/* 2217 */     for (Annotation a : annotations) {
/* 2218 */       if ((((a instanceof Cast)) && (((Cast)a).value()[0].length() > 0)) || ((a instanceof Const))) {
/* 2219 */         typeName = getCastedCPPTypeName(annotations, type);
/* 2220 */         break;
/*      */       }
/*      */     }
/* 2223 */     return (typeName != null) && (typeName.length > 0) ? "(" + typeName[0] + typeName[1] + ")" : "";
/*      */   }
/*      */ 
/*      */   public static Annotation getParameterBy(MethodInformation methodInfo, int j) {
/* 2227 */     Annotation passBy = getBy(methodInfo.parameterAnnotations[j]);
/* 2228 */     if ((passBy == null) && (methodInfo.pairedMethod != null) && ((methodInfo.valueSetter) || (methodInfo.memberSetter)))
/*      */     {
/* 2230 */       passBy = getBy(methodInfo.pairedMethod.getAnnotations());
/*      */     }
/* 2232 */     return passBy;
/*      */   }
/*      */ 
/*      */   public static Annotation getBy(Annotation[] annotations) {
/* 2236 */     Annotation byAnnotation = null;
/* 2237 */     for (Annotation a : annotations) {
/* 2238 */       if (((a instanceof ByPtr)) || ((a instanceof ByPtrPtr)) || ((a instanceof ByPtrRef)) || ((a instanceof ByRef)) || ((a instanceof ByVal)))
/*      */       {
/* 2240 */         if (byAnnotation != null) {
/* 2241 */           logger.log(Level.WARNING, "\"By\" annotation \"" + byAnnotation + "\" already found. Ignoring superfluous annotation \"" + a + "\".");
/*      */         }
/*      */         else {
/* 2244 */           byAnnotation = a;
/*      */         }
/*      */       }
/*      */     }
/* 2248 */     return byAnnotation;
/*      */   }
/*      */ 
/*      */   public static Annotation getBehavior(Annotation[] annotations) {
/* 2252 */     Annotation behaviorAnnotation = null;
/* 2253 */     for (Annotation a : annotations) {
/* 2254 */       if (((a instanceof Function)) || ((a instanceof Allocator)) || ((a instanceof ArrayAllocator)) || ((a instanceof ValueSetter)) || ((a instanceof ValueGetter)) || ((a instanceof MemberGetter)) || ((a instanceof MemberSetter)))
/*      */       {
/* 2257 */         if (behaviorAnnotation != null) {
/* 2258 */           logger.log(Level.WARNING, "Behavior annotation \"" + behaviorAnnotation + "\" already found. Ignoring superfluous annotation \"" + a + "\".");
/*      */         }
/*      */         else {
/* 2261 */           behaviorAnnotation = a;
/*      */         }
/*      */       }
/*      */     }
/* 2265 */     return behaviorAnnotation;
/*      */   }
/*      */ 
/*      */   public static String getConstValueTypeName(String[] typeName) {
/* 2269 */     String type = typeName[0];
/* 2270 */     if ((type.endsWith("*")) || (type.endsWith("&"))) {
/* 2271 */       type = type.substring(0, type.length() - 1);
/*      */     }
/* 2273 */     return type;
/*      */   }
/*      */ 
/*      */   public static String getValueTypeName(String[] typeName) {
/* 2277 */     String type = typeName[0];
/* 2278 */     if (type.startsWith("const "))
/* 2279 */       type = type.substring(6, type.length() - 1);
/* 2280 */     else if ((type.endsWith("*")) || (type.endsWith("&"))) {
/* 2281 */       type = type.substring(0, type.length() - 1);
/*      */     }
/* 2283 */     return type;
/*      */   }
/*      */ 
/*      */   public static String[] getAnnotatedCPPTypeName(Annotation[] annotations, Class<?> type) {
/* 2287 */     String[] typeName = getCastedCPPTypeName(annotations, type);
/* 2288 */     String prefix = typeName[0];
/* 2289 */     String suffix = typeName[1];
/*      */ 
/* 2291 */     boolean casted = false;
/* 2292 */     for (Annotation a : annotations) {
/* 2293 */       if ((((a instanceof Cast)) && (((Cast)a).value()[0].length() > 0)) || ((a instanceof Const))) {
/* 2294 */         casted = true;
/* 2295 */         break;
/*      */       }
/*      */     }
/*      */ 
/* 2299 */     Annotation by = getBy(annotations);
/* 2300 */     if ((by instanceof ByVal))
/* 2301 */       prefix = getConstValueTypeName(typeName);
/* 2302 */     else if ((by instanceof ByRef))
/* 2303 */       prefix = getConstValueTypeName(typeName) + "&";
/* 2304 */     else if (((by instanceof ByPtrPtr)) && (!casted))
/* 2305 */       prefix = prefix + "*";
/* 2306 */     else if ((by instanceof ByPtrRef)) {
/* 2307 */       prefix = prefix + "&";
/*      */     }
/*      */ 
/* 2310 */     typeName[0] = prefix;
/* 2311 */     typeName[1] = suffix;
/* 2312 */     return typeName;
/*      */   }
/*      */ 
/*      */   public static String[] getCastedCPPTypeName(Annotation[] annotations, Class<?> type) {
/* 2316 */     String[] typeName = null;
/* 2317 */     boolean warning = false; boolean adapter = false;
/* 2318 */     for (Annotation a : annotations) {
/* 2319 */       if ((a instanceof Cast)) {
/* 2320 */         warning = typeName != null;
/* 2321 */         String prefix = ((Cast)a).value()[0]; String suffix = "";
/* 2322 */         int parenthesis = prefix.indexOf(')');
/* 2323 */         if (parenthesis > 0) {
/* 2324 */           suffix = prefix.substring(parenthesis).trim();
/* 2325 */           prefix = prefix.substring(0, parenthesis).trim();
/*      */         }
/* 2327 */         typeName = prefix.length() > 0 ? new String[] { prefix, suffix } : null;
/* 2328 */       } else if ((a instanceof Const)) {
/* 2329 */         if ((warning = typeName != null ? 1 : 0) == 0)
/*      */         {
/* 2333 */           typeName = getCPPTypeName(type);
/* 2334 */           if (((Const)a).value())
/* 2335 */             typeName[0] = (getValueTypeName(typeName) + " const *");
/*      */           else {
/* 2337 */             typeName[0] = ("const " + typeName[0]);
/*      */           }
/* 2339 */           Annotation by = getBy(annotations);
/* 2340 */           if ((by instanceof ByPtrPtr))
/*      */           {
/*      */             int tmp258_257 = 0;
/*      */             String[] tmp258_256 = typeName; tmp258_256[tmp258_257] = (tmp258_256[tmp258_257] + "*");
/*      */           }
/*      */         } } else if (((a instanceof Adapter)) || (a.annotationType().isAnnotationPresent(Adapter.class))) {
/* 2344 */         adapter = true;
/*      */       }
/*      */     }
/* 2347 */     if ((warning) && (!adapter)) {
/* 2348 */       logger.log(Level.WARNING, "Without \"Adapter\", \"Cast\" and \"Const\" annotations are mutually exclusive.");
/*      */     }
/* 2350 */     if (typeName == null) {
/* 2351 */       typeName = getCPPTypeName(type);
/*      */     }
/* 2353 */     return typeName;
/*      */   }
/*      */ 
/*      */   public static String[] getCPPTypeName(Class<?> type) {
/* 2357 */     String prefix = ""; String suffix = "";
/* 2358 */     if ((type == Buffer.class) || (type == Pointer.class)) {
/* 2359 */       prefix = "void*";
/* 2360 */     } else if ((type == [B.class) || (type == ByteBuffer.class) || (type == BytePointer.class)) {
/* 2361 */       prefix = "signed char*";
/* 2362 */     } else if ((type == [S.class) || (type == ShortBuffer.class) || (type == ShortPointer.class)) {
/* 2363 */       prefix = "short*";
/* 2364 */     } else if ((type == [I.class) || (type == IntBuffer.class) || (type == IntPointer.class)) {
/* 2365 */       prefix = "int*";
/* 2366 */     } else if ((type == [J.class) || (type == LongBuffer.class) || (type == LongPointer.class)) {
/* 2367 */       prefix = "jlong*";
/* 2368 */     } else if ((type == [F.class) || (type == FloatBuffer.class) || (type == FloatPointer.class)) {
/* 2369 */       prefix = "float*";
/* 2370 */     } else if ((type == [D.class) || (type == DoubleBuffer.class) || (type == DoublePointer.class)) {
/* 2371 */       prefix = "double*";
/* 2372 */     } else if ((type == [C.class) || (type == CharBuffer.class) || (type == CharPointer.class)) {
/* 2373 */       prefix = "unsigned short*";
/* 2374 */     } else if (type == [Z.class) {
/* 2375 */       prefix = "unsigned char*";
/* 2376 */     } else if (type == PointerPointer.class) {
/* 2377 */       prefix = "void**";
/* 2378 */     } else if (type == String.class) {
/* 2379 */       prefix = "const char*";
/* 2380 */     } else if (type == Byte.TYPE) {
/* 2381 */       prefix = "signed char";
/* 2382 */     } else if (type == Long.TYPE) {
/* 2383 */       prefix = "jlong";
/* 2384 */     } else if (type == Character.TYPE) {
/* 2385 */       prefix = "unsigned short";
/* 2386 */     } else if (type == Boolean.TYPE) {
/* 2387 */       prefix = "unsigned char";
/* 2388 */     } else if (type.isPrimitive()) {
/* 2389 */       prefix = type.getName();
/* 2390 */     } else if (FunctionPointer.class.isAssignableFrom(type)) {
/* 2391 */       Method functionMethod = getFunctionMethod(type, null);
/* 2392 */       if (functionMethod != null) {
/* 2393 */         Convention convention = (Convention)type.getAnnotation(Convention.class);
/* 2394 */         String callingConvention = convention.value() + " ";
/* 2395 */         Namespace namespace = (Namespace)type.getAnnotation(Namespace.class);
/* 2396 */         String spaceName = namespace == null ? "" : namespace.value();
/* 2397 */         if ((spaceName.length() > 0) && (!spaceName.endsWith("::"))) {
/* 2398 */           spaceName = spaceName + "::";
/*      */         }
/* 2400 */         Class returnType = functionMethod.getReturnType();
/* 2401 */         Class[] parameterTypes = functionMethod.getParameterTypes();
/* 2402 */         Annotation[] annotations = functionMethod.getAnnotations();
/* 2403 */         Annotation[][] parameterAnnotations = functionMethod.getParameterAnnotations();
/* 2404 */         String[] returnTypeName = getAnnotatedCPPTypeName(annotations, returnType);
/* 2405 */         AdapterInformation returnAdapterInfo = getAdapterInformation(false, getValueTypeName(returnTypeName), annotations);
/* 2406 */         if ((returnAdapterInfo != null) && (returnAdapterInfo.cast.length() > 0))
/* 2407 */           prefix = returnAdapterInfo.cast;
/*      */         else {
/* 2409 */           prefix = returnTypeName[0] + returnTypeName[1];
/*      */         }
/* 2411 */         prefix = prefix + " (" + callingConvention + spaceName + "*";
/* 2412 */         suffix = ")(";
/* 2413 */         if ((namespace != null) && (!Pointer.class.isAssignableFrom(parameterTypes[0]))) {
/* 2414 */           logger.log(Level.WARNING, "First parameter of caller method call() or apply() for member function pointer " + type.getCanonicalName() + " is not a Pointer. Compilation will most likely fail.");
/*      */         }
/*      */ 
/* 2417 */         for (int j = namespace == null ? 0 : 1; j < parameterTypes.length; j++) {
/* 2418 */           String[] paramTypeName = getAnnotatedCPPTypeName(parameterAnnotations[j], parameterTypes[j]);
/* 2419 */           AdapterInformation paramAdapterInfo = getAdapterInformation(false, getValueTypeName(paramTypeName), parameterAnnotations[j]);
/* 2420 */           if ((paramAdapterInfo != null) && (paramAdapterInfo.cast.length() > 0))
/* 2421 */             suffix = suffix + paramAdapterInfo.cast + " arg" + j;
/*      */           else {
/* 2423 */             suffix = suffix + paramTypeName[0] + " arg" + j + paramTypeName[1];
/*      */           }
/* 2425 */           if (j < parameterTypes.length - 1) {
/* 2426 */             suffix = suffix + ", ";
/*      */           }
/*      */         }
/* 2429 */         suffix = suffix + ")";
/* 2430 */         if (type.isAnnotationPresent(Const.class))
/* 2431 */           suffix = suffix + " const";
/*      */       }
/*      */     }
/*      */     else {
/* 2435 */       String scopedType = getCPPScopeName(type);
/* 2436 */       if (scopedType.length() > 0)
/* 2437 */         prefix = scopedType + "*";
/*      */       else {
/* 2439 */         logger.log(Level.WARNING, "The class " + type.getCanonicalName() + " does not map to any C++ type. Compilation will most likely fail.");
/*      */       }
/*      */     }
/*      */ 
/* 2443 */     return new String[] { prefix, suffix };
/*      */   }
/*      */ 
/*      */   public static String getCPPScopeName(MethodInformation methodInfo) {
/* 2447 */     String scopeName = getCPPScopeName(methodInfo.cls);
/* 2448 */     Namespace namespace = (Namespace)methodInfo.method.getAnnotation(Namespace.class);
/* 2449 */     String spaceName = namespace == null ? "" : namespace.value();
/* 2450 */     if (((namespace != null) && (namespace.value().length() == 0)) || (spaceName.startsWith("::"))) {
/* 2451 */       scopeName = "";
/*      */     }
/* 2453 */     if ((scopeName.length() > 0) && (!scopeName.endsWith("::"))) {
/* 2454 */       scopeName = scopeName + "::";
/*      */     }
/* 2456 */     scopeName = scopeName + spaceName;
/* 2457 */     if ((spaceName.length() > 0) && (!spaceName.endsWith("::"))) {
/* 2458 */       scopeName = scopeName + "::";
/*      */     }
/* 2460 */     return scopeName + methodInfo.memberName[0];
/*      */   }
/*      */ 
/*      */   public static String getCPPScopeName(Class<?> type) {
/* 2464 */     String scopeName = "";
/* 2465 */     while (type != null) {
/* 2466 */       Namespace namespace = (Namespace)type.getAnnotation(Namespace.class);
/* 2467 */       String spaceName = namespace == null ? "" : namespace.value();
/* 2468 */       if ((Pointer.class.isAssignableFrom(type)) && (type != Pointer.class)) {
/* 2469 */         Name name = (Name)type.getAnnotation(Name.class);
/*      */         String s;
/* 2471 */         if (name == null) {
/* 2472 */           String s = type.getName();
/* 2473 */           int i = s.lastIndexOf("$");
/* 2474 */           if (i < 0) {
/* 2475 */             i = s.lastIndexOf(".");
/*      */           }
/* 2477 */           s = s.substring(i + 1);
/*      */         } else {
/* 2479 */           s = name.value()[0];
/*      */         }
/* 2481 */         if ((spaceName.length() > 0) && (!spaceName.endsWith("::"))) {
/* 2482 */           spaceName = spaceName + "::";
/*      */         }
/* 2484 */         spaceName = spaceName + s;
/*      */       }
/* 2486 */       if ((scopeName.length() > 0) && (!spaceName.endsWith("::"))) {
/* 2487 */         spaceName = spaceName + "::";
/*      */       }
/* 2489 */       scopeName = spaceName + scopeName;
/* 2490 */       if (((namespace != null) && (namespace.value().length() == 0)) || (spaceName.startsWith("::")))
/*      */       {
/*      */         break;
/*      */       }
/* 2494 */       type = type.getDeclaringClass();
/*      */     }
/* 2496 */     return scopeName;
/*      */   }
/*      */ 
/*      */   public static String getJNITypeName(Class type) {
/* 2500 */     if (type == Byte.TYPE)
/* 2501 */       return "jbyte";
/* 2502 */     if (type == Short.TYPE)
/* 2503 */       return "jshort";
/* 2504 */     if (type == Integer.TYPE)
/* 2505 */       return "jint";
/* 2506 */     if (type == Long.TYPE)
/* 2507 */       return "jlong";
/* 2508 */     if (type == Float.TYPE)
/* 2509 */       return "jfloat";
/* 2510 */     if (type == Double.TYPE)
/* 2511 */       return "jdouble";
/* 2512 */     if (type == Character.TYPE)
/* 2513 */       return "jchar";
/* 2514 */     if (type == Boolean.TYPE)
/* 2515 */       return "jboolean";
/* 2516 */     if (type == [B.class)
/* 2517 */       return "jbyteArray";
/* 2518 */     if (type == [S.class)
/* 2519 */       return "jshortArray";
/* 2520 */     if (type == [I.class)
/* 2521 */       return "jintArray";
/* 2522 */     if (type == [J.class)
/* 2523 */       return "jlongArray";
/* 2524 */     if (type == [F.class)
/* 2525 */       return "jfloatArray";
/* 2526 */     if (type == [D.class)
/* 2527 */       return "jdoubleArray";
/* 2528 */     if (type == [C.class)
/* 2529 */       return "jcharArray";
/* 2530 */     if (type == [Z.class)
/* 2531 */       return "jbooleanArray";
/* 2532 */     if (type.isArray())
/* 2533 */       return "jobjectArray";
/* 2534 */     if (type == String.class)
/* 2535 */       return "jstring";
/* 2536 */     if (type == Class.class)
/* 2537 */       return "jclass";
/* 2538 */     if (type == Void.TYPE) {
/* 2539 */       return "void";
/*      */     }
/* 2541 */     return "jobject";
/*      */   }
/*      */ 
/*      */   public static String getSignature(Class[] types)
/*      */   {
/* 2546 */     StringBuilder signature = new StringBuilder(2 * types.length);
/* 2547 */     for (int i = 0; i < types.length; i++) {
/* 2548 */       signature.append(getSignature(types[i]));
/*      */     }
/* 2550 */     return signature.toString();
/*      */   }
/*      */   public static String getSignature(Class type) {
/* 2553 */     if (type == Byte.TYPE)
/* 2554 */       return "B";
/* 2555 */     if (type == Short.TYPE)
/* 2556 */       return "S";
/* 2557 */     if (type == Integer.TYPE)
/* 2558 */       return "I";
/* 2559 */     if (type == Long.TYPE)
/* 2560 */       return "J";
/* 2561 */     if (type == Float.TYPE)
/* 2562 */       return "F";
/* 2563 */     if (type == Double.TYPE)
/* 2564 */       return "D";
/* 2565 */     if (type == Boolean.TYPE)
/* 2566 */       return "Z";
/* 2567 */     if (type == Character.TYPE)
/* 2568 */       return "C";
/* 2569 */     if (type == Void.TYPE)
/* 2570 */       return "V";
/* 2571 */     if (type.isArray()) {
/* 2572 */       return type.getName().replace(".", "/");
/*      */     }
/* 2574 */     return "L" + type.getName().replace(".", "/") + ";";
/*      */   }
/*      */ 
/*      */   public static String mangle(String name)
/*      */   {
/* 2579 */     StringBuilder mangledName = new StringBuilder(name.length());
/* 2580 */     for (int i = 0; i < name.length(); i++) {
/* 2581 */       char c = name.charAt(i);
/* 2582 */       if (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))) {
/* 2583 */         mangledName.append(c);
/* 2584 */       } else if (c == '_') {
/* 2585 */         mangledName.append("_1");
/* 2586 */       } else if (c == ';') {
/* 2587 */         mangledName.append("_2");
/* 2588 */       } else if (c == '[') {
/* 2589 */         mangledName.append("_3");
/* 2590 */       } else if ((c == '.') || (c == '/')) {
/* 2591 */         mangledName.append("_");
/*      */       } else {
/* 2593 */         String code = Integer.toHexString(c);
/* 2594 */         mangledName.append("_0");
/* 2595 */         switch (code.length()) { case 1:
/* 2596 */           mangledName.append("0");
/*      */         case 2:
/* 2597 */           mangledName.append("0");
/*      */         case 3:
/* 2598 */           mangledName.append("0"); }
/* 2599 */         mangledName.append(code);
/*      */       }
/*      */     }
/*      */ 
/* 2603 */     return mangledName.toString();
/*      */   }
/*      */ 
/*      */   public static class AdapterInformation
/*      */   {
/*      */     public String name;
/*      */     public int argc;
/*      */     public String cast;
/*      */     public boolean constant;
/*      */   }
/*      */ 
/*      */   public static class MethodInformation
/*      */   {
/*      */     public Class<?> cls;
/*      */     public Method method;
/*      */     public Annotation[] annotations;
/*      */     public int modifiers;
/*      */     public Class<?> returnType;
/*      */     public String name;
/*      */     public String[] memberName;
/*      */     public int dim;
/*      */     public boolean[] parameterRaw;
/*      */     public Class<?>[] parameterTypes;
/*      */     public Annotation[][] parameterAnnotations;
/*      */     public boolean returnRaw;
/*      */     public boolean withEnv;
/*      */     public boolean overloaded;
/*      */     public boolean noOffset;
/*      */     public boolean deallocator;
/*      */     public boolean allocator;
/*      */     public boolean arrayAllocator;
/*      */     public boolean bufferGetter;
/*      */     public boolean valueGetter;
/*      */     public boolean valueSetter;
/*      */     public boolean memberGetter;
/*      */     public boolean memberSetter;
/*      */     public boolean noReturnGetter;
/*      */     public Method pairedMethod;
/*      */     public Class<?> throwsException;
/*      */   }
/*      */ 
/*      */   public static class LinkedListRegister<E> extends LinkedList<E>
/*      */   {
/*      */     public int register(E e)
/*      */     {
/*  121 */       int i = indexOf(e);
/*  122 */       if (i < 0) {
/*  123 */         add(e);
/*  124 */         i = size() - 1;
/*      */       }
/*  126 */       return i;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.Generator
 * JD-Core Version:    0.6.2
 */