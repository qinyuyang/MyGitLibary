/*      */ package com.googlecode.javacpp;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileReader;
/*      */ import java.io.FileWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.io.Reader;
/*      */ import java.io.StringReader;
/*      */ import java.io.Writer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Properties;
/*      */ import java.util.Scanner;
/*      */ 
/*      */ public class Parser
/*      */ {
/*  750 */   Properties properties = null;
/*  751 */   InfoMap infoMap = null;
/*  752 */   TokenIndexer tokens = null;
/*      */ 
/*      */   public Parser(Properties properties, InfoMap infoMap)
/*      */   {
/*  746 */     this.properties = properties;
/*  747 */     this.infoMap = infoMap;
/*      */   }
/*      */ 
/*      */   static String rescan(String lines, String spacing)
/*      */   {
/*  755 */     String text = "";
/*  756 */     Scanner scanner = new Scanner(lines);
/*  757 */     while (scanner.hasNextLine()) {
/*  758 */       text = text + spacing + scanner.nextLine();
/*  759 */       int newline = spacing.lastIndexOf('\n');
/*  760 */       spacing = newline >= 0 ? spacing.substring(newline) : "\n";
/*      */     }
/*  762 */     return text;
/*      */   }
/*      */ 
/*      */   String vectors()
/*      */   {
/*  767 */     String definitions = "";
/*  768 */     LinkedList infoList = this.infoMap.get("std::vector");
/*  769 */     for (Info info : infoList) {
/*  770 */       if ((info.genericArgs != null) && (info.genericArgs.length != 0) && (info.pointerTypes != null) && (info.pointerTypes.length != 0))
/*      */       {
/*  774 */         String cppType = info.genericArgs[0];
/*  775 */         String cppVectorType = "std::vector<" + cppType + ">";
/*  776 */         String javaVectorType = info.pointerTypes[0];
/*  777 */         String annotations = "@ByRef ";
/*  778 */         String javaType = cppType;
/*  779 */         Info info2 = this.infoMap.getFirst(cppType);
/*  780 */         if (info2 != null) {
/*  781 */           if ((info2.pointerTypes != null) && (info2.pointerTypes.length > 0))
/*  782 */             javaType = info2.pointerTypes[0];
/*  783 */           else if ((info2.valueTypes != null) && (info2.valueTypes.length > 0)) {
/*  784 */             javaType = info2.valueTypes[0];
/*      */           }
/*  786 */           int n = javaType.lastIndexOf(' ');
/*  787 */           if (n >= 0) {
/*  788 */             annotations = javaType.substring(0, n + 1);
/*  789 */             javaType = javaType.substring(n + 1);
/*      */           }
/*      */         }
/*  792 */         this.infoMap.put(new Info(new String[] { cppVectorType }).pointerTypes(new String[] { javaVectorType }));
/*  793 */         definitions = "\n@Name(\"" + cppVectorType + "\") public static class " + javaVectorType + " extends Pointer {\n" + "    static { Loader.load(); }\n" + "    public " + javaVectorType + "(Pointer p) { super(p); }\n" + "    public " + javaVectorType + "(" + javaType + " ... array) { this(array.length); put(array); }\n" + "    public " + javaVectorType + "()       { allocate();  }\n" + "    public " + javaVectorType + "(long n) { allocate(n); }\n" + "    private native void allocate();\n" + "    private native void allocate(@Cast(\"size_t\") long n);\n\n" + "    public native long size();\n" + "    public native void resize(@Cast(\"size_t\") long n);\n\n" + "    @Index public native " + annotations + javaType + " get(@Cast(\"size_t\") long i);\n" + "    public native " + javaVectorType + " put(@Cast(\"size_t\") long i, " + javaType + " value);\n\n" + "    public " + javaVectorType + " put(" + javaType + " ... array) {\n" + "        if (size() < array.length) { resize(array.length); }\n" + "        for (int i = 0; i < array.length; i++) {\n" + "            put(i, array[i]);\n" + "        }\n" + "        return this;\n" + "    }\n" + "}\n";
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  818 */     return definitions;
/*      */   }
/*      */ 
/*      */   TemplateMap template(Context context)
/*      */     throws Parser.Exception
/*      */   {
/*  839 */     if (!this.tokens.get().match(new Object[] { Token.TEMPLATE })) {
/*  840 */       return context.templateMap;
/*      */     }
/*  842 */     TemplateMap map = new TemplateMap(context.templateMap);
/*      */ 
/*  844 */     this.tokens.next().expect(new Object[] { Character.valueOf('<') });
/*  845 */     for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/*  846 */       if (token.match(new Object[] { Integer.valueOf(5) })) {
/*  847 */         map.put(this.tokens.next().expect(new Object[] { Integer.valueOf(5) }).value, null);
/*  848 */         token = this.tokens.next();
/*      */       }
/*  850 */       if (!token.match(new Object[] { Character.valueOf(','), Character.valueOf('>') }))
/*      */       {
/*  852 */         int count = 0;
/*  853 */         for (token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/*  854 */           if (count == 0) if (token.match(new Object[] { Character.valueOf(','), Character.valueOf('>') }))
/*      */               break;
/*  856 */           if (token.match(new Object[] { Character.valueOf('<') }))
/*  857 */             count++;
/*  858 */           else if (token.match(new Object[] { Character.valueOf('>') })) {
/*  859 */             count--;
/*      */           }
/*      */         }
/*      */       }
/*  863 */       if (token.expect(new Object[] { Character.valueOf(','), Character.valueOf('>') }).match(new Object[] { Character.valueOf('>') })) {
/*  864 */         this.tokens.next();
/*  865 */         break;
/*      */       }
/*      */     }
/*  868 */     return map;
/*      */   }
/*      */ 
/*      */   Type type(Context context)
/*      */     throws Parser.Exception
/*      */   {
/*  895 */     Type type = new Type();
/*  896 */     if (this.tokens.get().match(new Object[] { Token.OPERATOR })) {
/*  897 */       type.operator = true;
/*  898 */       this.tokens.next();
/*      */     }
/*  900 */     for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next())
/*  901 */       if (token.match(new Object[] { "::" })) {
/*  902 */         type.cppName += token; } else {
/*  903 */         if (token.match(new Object[] { Character.valueOf('<') })) {
/*  904 */           type.cppName += token;
/*  905 */           for (token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/*  906 */             Type type2 = type(context);
/*  907 */             type.cppName += type2.cppName;
/*  908 */             for (token = this.tokens.get(); !token.match(new Object[] { Token.EOF, Character.valueOf(','), Character.valueOf('>') }); token = this.tokens.next()) {
/*  909 */               type.cppName += token;
/*      */             }
/*  911 */             type.cppName += token;
/*  912 */             if (token.expect(new Object[] { Character.valueOf(','), Character.valueOf('>') }).match(new Object[] { Character.valueOf('>') }))
/*      */               break;
/*      */           }
/*      */         }
/*  916 */         if (token.match(new Object[] { Token.CONST })) {
/*  917 */           type.constValue = true;
/*  918 */         } else if (token.match(new Object[] { Character.valueOf('~') })) {
/*  919 */           type.destructor = true;
/*  920 */         } else if (token.match(new Object[] { Token.STATIC })) {
/*  921 */           type.staticMember = true; } else {
/*  922 */           if (token.match(new Object[] { Token.OPERATOR }))
/*      */             break;
/*      */           boolean pointer;
/*      */           boolean reference;
/*      */           Token token;
/*      */           Info info;
/*      */           boolean valueType;
/*  924 */           if (!token.match(new Object[] { Token.TYPEDEF, Token.USING, Token.ENUM, Token.EXPLICIT, Token.EXTERN, Token.CLASS, Token.STRUCT, Token.UNION, Token.INLINE, Token.VIRTUAL }))
/*      */           {
/*  927 */             if (token.match((Object[])InfoMap.simpleTypes))
/*      */             {
/*      */               Type tmp573_572 = type; tmp573_572.cppName = (tmp573_572.cppName + token.value + " ");
/*  929 */               type.simpleType = true;
/*  930 */             } else if (token.match(new Object[] { Integer.valueOf(5) })) {
/*  931 */               Info info = this.infoMap.getFirst(token.value);
/*  932 */               if ((info != null) && (info.annotations != null)) {
/*  933 */                 for (String s : info.annotations)
/*      */                 {
/*      */                   Type tmp687_686 = type; tmp687_686.annotations = (tmp687_686.annotations + s + " ");
/*      */                 }
/*  936 */               } else if ((type.cppName.length() == 0) || (type.cppName.endsWith("::"))) {
/*  937 */                 type.cppName += token.value;
/*      */               } else {
/*  939 */                 info = this.infoMap.getFirst(this.tokens.get(1).value);
/*  940 */                 if ((info != null) && (info.annotations != null)) break; if (!this.tokens.get(1).match(new Object[] { Character.valueOf('*'), Character.valueOf('&'), Integer.valueOf(5), Token.CONST })) {
/*      */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */             else
/*      */             {
/*  947 */               if (!token.match(new Object[] { Character.valueOf('}') })) break;
/*  948 */               type.anonymous = true;
/*  949 */               this.tokens.next(); break;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*  954 */     type.cppName = type.cppName.trim();
/*  955 */     pointer = false;
/*  956 */     reference = false;
/*  957 */     if ("...".equals(this.tokens.get().value)) {
/*  958 */       this.tokens.next();
/*  959 */       return null;
/*  960 */     }if (type.operator) {
/*  961 */       for (token = this.tokens.get(); !token.match(new Object[] { Token.EOF, Character.valueOf('(') }); token = this.tokens.next()) {
/*  962 */         type.cppName += token;
/*      */       }
/*  964 */       pointer = type.cppName.endsWith("*");
/*  965 */       reference = type.cppName.endsWith("&");
/*      */       Type tmp1057_1056 = type; tmp1057_1056.annotations = (tmp1057_1056.annotations + "@Name(\"operator " + type.cppName + "\") ");
/*  968 */       if (type.constValue) {
/*  969 */         type.annotations += "@Const ";
/*      */       }
/*  971 */       if ((pointer) || (reference)) {
/*  972 */         type.cppName = type.cppName.substring(0, type.cppName.length() - 1);
/*      */       }
/*      */     }
/*  975 */     if ((context.templateMap != null) && (context.templateMap.get(type.cppName) != null)) {
/*  976 */       type.cppName = context.templateMap.get(type.cppName);
/*      */     }
/*  978 */     type.javaName = type.cppName;
/*  979 */     info = this.infoMap.getFirst(type.cppName);
/*  980 */     valueType = false;
/*  981 */     if (info != null) {
/*  982 */       if ((!pointer) && (!reference) && (info.valueTypes != null) && (info.valueTypes.length > 0)) {
/*  983 */         type.javaName = info.valueTypes[0];
/*  984 */         valueType = true;
/*  985 */       } else if ((info.pointerTypes != null) && (info.pointerTypes.length > 0)) {
/*  986 */         type.javaName = info.pointerTypes[0];
/*      */       }
/*      */     }
/*  989 */     if ((type.operator) && (!valueType)) {
/*  990 */       if ((!pointer) && (!reference))
/*  991 */         type.annotations += "@ByVal ";
/*  992 */       else if ((!pointer) && (reference)) {
/*  993 */         type.annotations += "@ByRef ";
/*      */       }
/*      */     }
/*  996 */     return type;
/*      */   }
/*      */ 
/*      */   Declarator declarator(Context context, String defaultName, int infoNumber, int varNumber, boolean arrayAsPointer, boolean pointerAsArray)
/*      */     throws Parser.Exception
/*      */   {
/* 1008 */     boolean isTypedef = this.tokens.get().match(new Object[] { Token.TYPEDEF });
/* 1009 */     boolean isUsing = this.tokens.get().match(new Object[] { Token.USING });
/* 1010 */     Declarator dcl = new Declarator();
/* 1011 */     Type type = dcl.type = type(context);
/* 1012 */     if (type == null) {
/* 1013 */       return null;
/*      */     }
/*      */ 
/* 1016 */     int count = 0;
/* 1017 */     for (Token token = this.tokens.get(); varNumber > 0; token = this.tokens.next()) { if (token.match(new Object[] { Token.EOF })) break;
/* 1018 */       if (token.match(new Object[] { Character.valueOf('('), Character.valueOf('['), Character.valueOf('{') }))
/* 1019 */         count++;
/* 1020 */       else if (token.match(new Object[] { Character.valueOf(')'), Character.valueOf(']'), Character.valueOf('}') }))
/* 1021 */         count--;
/* 1022 */       else if (count <= 0)
/*      */       {
/* 1024 */         if (token.match(new Object[] { Character.valueOf(',') })) {
/* 1025 */           varNumber--;
/* 1026 */         } else if (token.match(new Object[] { Character.valueOf(';') })) {
/* 1027 */           this.tokens.next();
/* 1028 */           return null;
/*      */         }
/*      */       }
/*      */     }
/* 1032 */     String cast = type.cppName;
/* 1033 */     int indirections = 0;
/* 1034 */     boolean reference = false;
/* 1035 */     for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1036 */       if (token.match(new Object[] { Character.valueOf('*') })) {
/* 1037 */         indirections++;
/* 1038 */         cast = cast + "*";
/* 1039 */       } else if (token.match(new Object[] { Character.valueOf('&') })) {
/* 1040 */         reference = true;
/* 1041 */         cast = cast + "*"; } else {
/* 1042 */         if (!token.match(new Object[] { Token.CONST })) break;
/* 1043 */         dcl.constPointer = true;
/* 1044 */         cast = cast + "const";
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1050 */     int[] dims = new int[256];
/* 1051 */     int indirections2 = 0;
/* 1052 */     dcl.cppName = defaultName;
/* 1053 */     if (this.tokens.get().match(new Object[] { Character.valueOf('(') }))
/*      */     {
/* 1055 */       while (this.tokens.get().match(new Object[] { Character.valueOf('(') })) {
/* 1056 */         this.tokens.next();
/*      */       }
/* 1058 */       for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1059 */         if (token.match(new Object[] { Integer.valueOf(5) })) {
/* 1060 */           dcl.cppName = token.value;
/* 1061 */         } else if (token.match(new Object[] { Character.valueOf('*') })) {
/* 1062 */           indirections2++;
/* 1063 */           dcl.convention = dcl.cppName;
/* 1064 */           dcl.cppName = defaultName;
/* 1065 */         } else if (token.match(new Object[] { Character.valueOf('[') })) {
/* 1066 */           Token n = this.tokens.get(1);
/* 1067 */           dims[(dcl.indices++)] = (n.match(new Object[] { Integer.valueOf(1) }) ? Integer.parseInt(n.value) : -1);
/* 1068 */         } else if (token.match(new Object[] { Character.valueOf(')') })) {
/* 1069 */           this.tokens.next();
/* 1070 */           break;
/*      */         }
/*      */       }
/* 1073 */       while (this.tokens.get().match(new Object[] { Character.valueOf(')') }))
/* 1074 */         this.tokens.next();
/*      */     }
/* 1076 */     if (this.tokens.get().match(new Object[] { Integer.valueOf(5) })) {
/* 1077 */       dcl.cppName = "";
/* 1078 */       for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1079 */         if (token.match(new Object[] { "::" })) {
/* 1080 */           dcl.cppName += token; } else {
/* 1081 */           if (token.match(new Object[] { Token.OPERATOR }))
/*      */           {
/*      */             Declarator tmp930_928 = dcl; tmp930_928.cppName = (tmp930_928.cppName + "operator" + this.tokens.next());
/* 1083 */             for (token = this.tokens.next(); !token.match(new Object[] { Token.EOF, Character.valueOf('(') }); token = this.tokens.next()) {
/* 1084 */               dcl.cppName += token;
/*      */             }
/*      */           }
/* 1087 */           if (token.match(new Object[] { Character.valueOf('<') }))
/*      */           {
/* 1089 */             dcl.cppName += token;
/* 1090 */             int count2 = 0;
/* 1091 */             for (token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1092 */               dcl.cppName += token;
/* 1093 */               if (count2 == 0) if (token.match(new Object[] { Character.valueOf(','), Character.valueOf('>') }))
/*      */                   break;
/* 1095 */               if (token.match(new Object[] { Character.valueOf('<') }))
/* 1096 */                 count2++;
/* 1097 */               else if (token.match(new Object[] { Character.valueOf('>') }))
/* 1098 */                 count2--;
/*      */             }
/*      */           } else {
/* 1101 */             if ((!token.match(new Object[] { Integer.valueOf(5) })) || ((dcl.cppName.length() != 0) && (!dcl.cppName.endsWith("::"))))
/*      */               break;
/* 1103 */             dcl.cppName += token;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1110 */     boolean bracket = false;
/* 1111 */     for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1112 */       if (!bracket) if (token.match(new Object[] { Character.valueOf('[') })) {
/* 1113 */           bracket = true;
/* 1114 */           Token n = this.tokens.get(1);
/* 1115 */           dims[(dcl.indices++)] = (n.match(new Object[] { Integer.valueOf(1) }) ? Integer.parseInt(n.value) : -1);
/* 1116 */           continue; }  if (!bracket)
/*      */         break;
/* 1118 */       if (bracket) if (token.match(new Object[] { Character.valueOf(']') })) {
/* 1119 */           bracket = false;
/*      */         }
/*      */     }
/* 1122 */     while ((dcl.indices > 0) && (indirections2 > 0))
/*      */     {
/* 1124 */       dims[(dcl.indices++)] = -1;
/* 1125 */       indirections2--;
/*      */     }
/* 1127 */     if ((arrayAsPointer) && (dcl.indices > 0))
/*      */     {
/* 1129 */       indirections++;
/* 1130 */       String dimCast = "";
/* 1131 */       for (int i = 1; i < dcl.indices; i++) {
/* 1132 */         if (dims[i] > 0) {
/* 1133 */           dimCast = dimCast + "[" + dims[i] + "]";
/*      */         }
/*      */       }
/*      */ 
/* 1137 */       cast = cast + (dimCast.length() > 0 ? "(*)" + dimCast : "*");
/*      */     }
/* 1139 */     if (pointerAsArray) if (indirections > (type.anonymous ? 0 : 1))
/*      */       {
/* 1141 */         dims[(dcl.indices++)] = -1;
/* 1142 */         indirections--;
/* 1143 */         cast = cast.substring(0, cast.length() - 1);
/*      */       }
/*      */ 
/* 1146 */     if (this.tokens.get().match(new Object[] { Character.valueOf(':') }))
/*      */     {
/* 1148 */       type.annotations += "@NoOffset ";
/* 1149 */       this.tokens.next().expect(new Object[] { Integer.valueOf(1) });
/* 1150 */       this.tokens.next().expect(new Object[] { Character.valueOf(','), Character.valueOf(';') });
/*      */     }
/*      */ 
/* 1153 */     int infoLength = 1;
/* 1154 */     boolean valueType = false; boolean needCast = (arrayAsPointer) && (dcl.indices > 1); boolean implicitConst = false;
/* 1155 */     String prefix = (type.constValue) && (indirections < 2) && (!reference) ? "const " : "";
/* 1156 */     Info info = this.infoMap.getFirst(prefix + type.cppName);
/* 1157 */     String ns = "";
/* 1158 */     while ((context.namespace != null) && (info == null) && (!ns.equals(context.namespace))) {
/* 1159 */       int i = context.namespace.indexOf("::", ns.length() + 2);
/* 1160 */       ns = i < 0 ? context.namespace : context.namespace.substring(0, i);
/* 1161 */       info = this.infoMap.getFirst(prefix + ns + "::" + type.cppName);
/*      */     }
/* 1163 */     if (info != null) {
/* 1164 */       valueType = (info.valueTypes != null) && (((type.constValue) && (reference)) || ((indirections == 0) && (!reference)) || (info.pointerTypes == null));
/*      */ 
/* 1166 */       needCast |= info.cast;
/* 1167 */       implicitConst = info.cppNames[0].startsWith("const ");
/* 1168 */       infoLength = info.pointerTypes != null ? info.pointerTypes.length : valueType ? info.valueTypes.length : 1;
/*      */ 
/* 1170 */       dcl.infoNumber = (infoNumber < 0 ? 0 : infoNumber % infoLength);
/* 1171 */       type.javaName = (info.pointerTypes != null ? info.pointerTypes[dcl.infoNumber] : valueType ? info.valueTypes[dcl.infoNumber] : type.javaName);
/*      */ 
/* 1173 */       if (ns.length() > 0) {
/* 1174 */         cast = ns + "::" + cast;
/*      */       }
/*      */     }
/*      */ 
/* 1178 */     if (!valueType) {
/* 1179 */       if ((indirections == 0) && (!reference)) {
/* 1180 */         type.annotations += "@ByVal ";
/* 1181 */       } else if ((indirections == 0) && (reference)) {
/* 1182 */         type.annotations += "@ByRef ";
/* 1183 */       } else if ((indirections == 1) && (reference)) {
/* 1184 */         type.annotations += "@ByPtrRef ";
/* 1185 */       } else if ((indirections == 2) && (!reference) && (infoNumber >= 0)) {
/* 1186 */         type.annotations += "@ByPtrPtr ";
/* 1187 */         if (type.cppName.equals("void"))
/* 1188 */           needCast = true;
/*      */       }
/* 1190 */       else if (indirections >= 2) {
/* 1191 */         dcl.infoNumber += infoLength;
/* 1192 */         needCast = true;
/* 1193 */         type.javaName = "PointerPointer";
/* 1194 */         if (reference) {
/* 1195 */           type.annotations += "@ByRef ";
/*      */         }
/*      */       }
/*      */ 
/* 1199 */       if ((!needCast) && (type.constValue) && (!implicitConst)) {
/* 1200 */         type.annotations = ("@Const " + type.annotations);
/*      */       }
/*      */     }
/* 1203 */     if (needCast) {
/* 1204 */       if (type.constValue) {
/* 1205 */         cast = "const " + cast;
/*      */       }
/* 1207 */       if ((!valueType) && (indirections == 0) && (!reference))
/*      */       {
/*      */         Type tmp2584_2582 = type; tmp2584_2582.annotations = (tmp2584_2582.annotations + "@Cast(\"" + cast + "*\") ");
/*      */       } else {
/* 1210 */         type.annotations = ("@Cast(\"" + cast + "\") " + type.annotations);
/*      */       }
/*      */     }
/*      */ 
/* 1214 */     dcl.javaName = dcl.cppName;
/* 1215 */     info = this.infoMap.getFirst(dcl.cppName);
/* 1216 */     if ((defaultName == null) && (info != null) && (info.javaNames != null) && (info.javaNames.length > 0))
/*      */     {
/*      */       Type tmp2712_2710 = type; tmp2712_2710.annotations = (tmp2712_2710.annotations + "@Name(\"" + dcl.cppName + "\") ");
/* 1218 */       dcl.javaName = info.javaNames[0];
/*      */     }
/*      */ 
/* 1221 */     Parameters params = parameters(context, infoNumber);
/* 1222 */     if (params != null) {
/* 1223 */       dcl.infoNumber = Math.max(dcl.infoNumber, params.infoNumber);
/* 1224 */       if (params.definitions.length() > 0)
/*      */       {
/*      */         Declarator tmp2806_2804 = dcl; tmp2806_2804.definitions = (tmp2806_2804.definitions + params.definitions + "\n");
/*      */       }
/* 1227 */       if (indirections2 == 0) {
/* 1228 */         dcl.parameters = params.list;
/*      */       } else {
/* 1230 */         String functionType = Character.toUpperCase(dcl.javaName.charAt(0)) + dcl.javaName.substring(1) + params.signature;
/*      */ 
/* 1232 */         if (infoNumber <= params.infoNumber)
/*      */         {
/*      */           Declarator tmp2928_2926 = dcl; tmp2928_2926.definitions = (tmp2928_2926.definitions + "public static class " + functionType + " extends FunctionPointer {\n" + "    static { Loader.load(); }\n" + "    public    " + functionType + "(Pointer p) { super(p); }\n" + "    protected " + functionType + "() { allocate(); }\n" + "    private native void allocate();\n" + "    public native " + type.annotations + type.javaName + " call" + params.list + ";\n" + "}\n");
/*      */         }
/*      */ 
/* 1242 */         type.annotations = "";
/* 1243 */         type.javaName = functionType;
/* 1244 */         dcl.parameters = "";
/*      */       }
/*      */     }
/* 1247 */     return dcl;
/*      */   }
/*      */ 
/*      */   String commentBefore() throws Parser.Exception {
/* 1251 */     String comment = "";
/* 1252 */     this.tokens.preprocess = false;
/* 1253 */     while (this.tokens.index > 0) { if (!this.tokens.get(-1).match(new Object[] { Integer.valueOf(4) })) break;
/* 1254 */       this.tokens.index -= 1;
/*      */     }
/* 1256 */     for (Token token = this.tokens.get(); token.match(new Object[] { Integer.valueOf(4) }); token = this.tokens.next()) {
/* 1257 */       if ((token.value.length() <= 3) || (token.value.charAt(3) != '<')) {
/* 1258 */         comment = comment + token.spacing + token.value;
/*      */       }
/*      */     }
/* 1261 */     this.tokens.preprocess = true;
/* 1262 */     return comment;
/*      */   }
/*      */ 
/*      */   String commentAfter() throws Parser.Exception {
/* 1266 */     String comment = "";
/* 1267 */     this.tokens.preprocess = false;
/* 1268 */     while (this.tokens.index > 0) { if (!this.tokens.get(-1).match(new Object[] { Integer.valueOf(4) })) break;
/* 1269 */       this.tokens.index -= 1;
/*      */     }
/* 1271 */     for (Token token = this.tokens.get(); token.match(new Object[] { Integer.valueOf(4) }); token = this.tokens.next()) {
/* 1272 */       if ((token.value.length() > 3) && (token.value.charAt(3) == '<')) {
/* 1273 */         comment = comment + (comment.length() > 0 ? " * " : "/**") + token.value.substring(4);
/*      */       }
/*      */     }
/* 1276 */     if (comment.length() > 0) {
/* 1277 */       if (!comment.endsWith("*/")) {
/* 1278 */         comment = comment + " */";
/*      */       }
/* 1280 */       comment = comment + "\n";
/*      */     }
/* 1282 */     this.tokens.preprocess = true;
/* 1283 */     return comment;
/*      */   }
/*      */ 
/*      */   Declaration attribute() throws Parser.Exception {
/* 1287 */     if (!this.tokens.get().match(new Object[] { Integer.valueOf(5) })) {
/* 1288 */       return null;
/*      */     }
/* 1290 */     Declaration decl = new Declaration();
/* 1291 */     decl.text = this.tokens.get().spacing;
/* 1292 */     if (!this.tokens.next().match(new Object[] { Character.valueOf('(') })) {
/* 1293 */       return decl;
/*      */     }
/*      */ 
/* 1296 */     int count = 1;
/* 1297 */     this.tokens.preprocess = false;
/* 1298 */     for (Token token = this.tokens.next(); (!token.match(new Object[] { Token.EOF })) && (count > 0); token = this.tokens.next()) {
/* 1299 */       if (token.match(new Object[] { Character.valueOf('(') }))
/* 1300 */         count++;
/* 1301 */       else if (token.match(new Object[] { Character.valueOf(')') })) {
/* 1302 */         count--;
/*      */       }
/*      */     }
/* 1305 */     this.tokens.preprocess = true;
/* 1306 */     return decl;
/*      */   }
/*      */ 
/*      */   String body() throws Parser.Exception {
/* 1310 */     if (!this.tokens.get().match(new Object[] { Character.valueOf('{') })) {
/* 1311 */       return null;
/*      */     }
/*      */ 
/* 1314 */     int count = 1;
/* 1315 */     this.tokens.preprocess = false;
/* 1316 */     for (Token token = this.tokens.next(); (!token.match(new Object[] { Token.EOF })) && (count > 0); token = this.tokens.next()) {
/* 1317 */       if (token.match(new Object[] { Character.valueOf('{') }))
/* 1318 */         count++;
/* 1319 */       else if (token.match(new Object[] { Character.valueOf('}') })) {
/* 1320 */         count--;
/*      */       }
/*      */     }
/* 1323 */     this.tokens.preprocess = true;
/* 1324 */     return "";
/*      */   }
/*      */ 
/*      */   Parameters parameters(Context context, int infoNumber)
/*      */     throws Parser.Exception
/*      */   {
/* 1334 */     if (!this.tokens.get().match(new Object[] { Character.valueOf('(') })) {
/* 1335 */       return null;
/*      */     }
/*      */ 
/* 1338 */     int count = 0;
/* 1339 */     Parameters params = new Parameters();
/* 1340 */     params.list = "(";
/* 1341 */     params.names = "(";
/* 1342 */     for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.get()) {
/* 1343 */       String spacing = token.spacing;
/* 1344 */       if (token.match(new Object[] { Character.valueOf(')') }))
/*      */       {
/*      */         Parameters tmp115_113 = params; tmp115_113.list = (tmp115_113.list + spacing + ")");
/* 1346 */         params.names += ")";
/* 1347 */         this.tokens.next();
/* 1348 */         break;
/*      */       }
/* 1350 */       Declarator dcl = declarator(context, "arg" + count++, infoNumber, 0, true, false);
/* 1351 */       if ((dcl != null) && (!dcl.type.javaName.equals("void"))) {
/* 1352 */         params.infoNumber = Math.max(params.infoNumber, dcl.infoNumber);
/*      */         Parameters tmp257_255 = params; tmp257_255.list = (tmp257_255.list + (count > 1 ? "," : "") + spacing + dcl.type.annotations + dcl.type.javaName + " " + dcl.javaName);
/* 1354 */         params.definitions += dcl.definitions;
/* 1355 */         params.signature += '_';
/* 1356 */         for (char c : dcl.type.javaName.substring(dcl.type.javaName.lastIndexOf(' ') + 1).toCharArray())
/* 1357 */           if ((Character.isDigit(c)) || (Character.isLetter(c)) || (c == '_'))
/* 1358 */             params.signature += c;
/*      */         Parameters tmp500_498 = params; tmp500_498.names = (tmp500_498.names + (count > 1 ? ", " : "") + dcl.javaName);
/* 1362 */         if (dcl.javaName.startsWith("arg"))
/*      */           try {
/* 1364 */             count = Integer.parseInt(dcl.javaName.substring(3)) + 1;
/*      */           } catch (NumberFormatException e) {
/*      */           }
/*      */       }
/* 1368 */       if (!this.tokens.get().match(new Object[] { Character.valueOf(','), Character.valueOf(')') }))
/*      */       {
/*      */         Parameters tmp611_609 = params; tmp611_609.list = (tmp611_609.list + "/*" + this.tokens.get());
/* 1371 */         int count2 = 0;
/* 1372 */         token = this.tokens.next(); for (token.spacing = ""; !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1373 */           if (count2 == 0) if (token.match(new Object[] { Character.valueOf(','), Character.valueOf(')') }))
/*      */               break;
/* 1375 */           if (token.match(new Object[] { Character.valueOf('(') }))
/* 1376 */             count2++;
/* 1377 */           else if (token.match(new Object[] { Character.valueOf(')') }))
/* 1378 */             count2--;
/*      */           Parameters tmp770_768 = params; tmp770_768.list = (tmp770_768.list + token.spacing + token);
/*      */         }
/* 1382 */         params.list += "*/";
/*      */       }
/* 1384 */       if (this.tokens.get().expect(new Object[] { Character.valueOf(','), Character.valueOf(')') }).match(new Object[] { Character.valueOf(',') })) {
/* 1385 */         this.tokens.next();
/*      */       }
/*      */     }
/* 1388 */     return params;
/*      */   }
/*      */ 
/*      */   Declaration function(Context context) throws Parser.Exception {
/* 1392 */     int backIndex = this.tokens.index;
/* 1393 */     String spacing = this.tokens.get().spacing;
/* 1394 */     String modifiers = "public native ";
/* 1395 */     Type type = type(context);
/* 1396 */     Parameters params = parameters(context, 0);
/* 1397 */     Declarator dcl = new Declarator();
/* 1398 */     Declaration decl = new Declaration();
/* 1399 */     if (type.javaName.length() == 0)
/*      */     {
/* 1401 */       this.tokens.index = backIndex;
/* 1402 */       return null;
/* 1403 */     }if ((context.group == null) && (params != null))
/*      */     {
/* 1405 */       body();
/* 1406 */       decl.text = spacing;
/* 1407 */       return decl;
/* 1408 */     }if (((type.equals(context.group)) || (type.operator)) && (params != null))
/*      */     {
/* 1410 */       decl.constructor = ((!type.destructor) && (!type.operator));
/* 1411 */       dcl.cppName = type.cppName;
/* 1412 */       dcl.javaName = (type.operator ? "as" + type.javaName : type.javaName);
/* 1413 */       dcl.parameters = params.list;
/* 1414 */       dcl.definitions = params.definitions;
/*      */     } else {
/* 1416 */       this.tokens.index = backIndex;
/* 1417 */       dcl = declarator(context, null, 0, 0, false, false);
/* 1418 */       type = dcl.type;
/*      */     }
/*      */ 
/* 1421 */     if ((type.javaName.length() == 0) || (dcl.parameters.length() == 0)) {
/* 1422 */       this.tokens.index = backIndex;
/* 1423 */       return null;
/* 1424 */     }if ((type.staticMember) || (context.group == null)) {
/* 1425 */       modifiers = "public static native ";
/*      */     }
/*      */ 
/* 1428 */     String definitions = "";
/* 1429 */     LinkedList infoList = this.infoMap.get(dcl.cppName);
/* 1430 */     if (infoList.size() == 0) {
/* 1431 */       infoList.add(null);
/*      */     }
/* 1433 */     for (Info info : infoList) {
/* 1434 */       boolean template = false;
/*      */       int count;
/* 1435 */       if ((info != null) && (info.genericArgs != null) && (context.templateMap != null)) {
/* 1436 */         count = 0;
/* 1437 */         for (Map.Entry e : context.templateMap.entrySet()) {
/* 1438 */           if ((count < info.genericArgs.length) && (e.getValue() == null)) {
/* 1439 */             context.templateMap.put(e.getKey(), info.genericArgs[(count++)]);
/* 1440 */             template = true;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 1445 */       LinkedList prevDcl = new LinkedList();
/* 1446 */       int n = -1; if (n < 2147483647) {
/* 1447 */         this.tokens.index = backIndex;
/* 1448 */         if ((decl.constructor) || (type.destructor) || (type.operator)) {
/* 1449 */           type = type(context);
/* 1450 */           params = parameters(context, n);
/* 1451 */           dcl.cppName = type.cppName;
/* 1452 */           dcl.javaName = (type.operator ? "as" + type.javaName : type.javaName);
/* 1453 */           dcl.parameters = params.list;
/* 1454 */           dcl.definitions = params.definitions;
/* 1455 */           if (this.tokens.get().match(new Object[] { Character.valueOf(':') })) {
/* 1456 */             for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next())
/* 1457 */               if (token.match(new Object[] { Character.valueOf('{'), Character.valueOf(';') }))
/*      */                 break;
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1463 */           dcl = declarator(context, null, n, 0, false, false);
/* 1464 */           type = dcl.type;
/*      */         }
/* 1466 */         boolean found = false;
/* 1467 */         for (Declarator d : prevDcl) {
/* 1468 */           found |= dcl.parameters.equals(d.parameters);
/*      */         }
/* 1470 */         if ((!found) || (n <= 0))
/*      */         {
/* 1472 */           if ((dcl.javaName.length() > 0) && (!found) && (!type.destructor)) {
/* 1473 */             if ((context.namespace != null) && (context.group == null))
/*      */             {
/*      */               Declaration tmp859_857 = decl; tmp859_857.text = (tmp859_857.text + "@Namespace(\"" + context.namespace + "\") ");
/*      */             }
/* 1476 */             if (decl.constructor)
/*      */             {
/*      */               Declaration tmp906_904 = decl; tmp906_904.text = (tmp906_904.text + "public " + dcl.javaName + dcl.parameters + " { allocate" + params.names + "; }\n" + "private native void allocate" + dcl.parameters + ";\n");
/*      */             }
/*      */             else
/*      */             {
/*      */               Declaration tmp988_986 = decl; tmp988_986.text = (tmp988_986.text + modifiers + type.annotations + type.javaName + " " + dcl.javaName + dcl.parameters + ";\n");
/*      */             }
/* 1482 */             definitions = definitions + dcl.definitions;
/*      */           }
/* 1484 */           prevDcl.add(dcl);
/*      */ 
/* 1446 */           n++;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1486 */       while (attribute() != null);
/* 1487 */       if (this.tokens.get().match(new Object[] { Character.valueOf('{') })) {
/* 1488 */         body();
/*      */       } else {
/* 1490 */         if (this.tokens.get().match(new Object[] { Character.valueOf('=') })) {
/* 1491 */           this.tokens.next().expect(new Object[] { "0" });
/* 1492 */           this.tokens.next().expect(new Object[] { Character.valueOf(';') });
/*      */         }
/* 1494 */         this.tokens.next();
/*      */       }
/*      */ 
/* 1497 */       if (!template) {
/*      */         break;
/*      */       }
/*      */     }
/* 1501 */     String comment = commentAfter();
/* 1502 */     decl.text = rescan(definitions + comment + decl.text, spacing);
/* 1503 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration variable(Context context) throws Parser.Exception {
/* 1507 */     int backIndex = this.tokens.index;
/* 1508 */     String spacing = this.tokens.get().spacing;
/* 1509 */     String modifiers = "public static native ";
/* 1510 */     String setterType = "void ";
/* 1511 */     Declarator dcl = declarator(context, null, 0, 0, false, true);
/* 1512 */     String name = dcl.javaName;
/* 1513 */     if (name != null) { if (this.tokens.get().match(new Object[] { Character.valueOf('['), Character.valueOf('='), Character.valueOf(','), Character.valueOf(':'), Character.valueOf(';') })); } else {
/* 1514 */       this.tokens.index = backIndex;
/* 1515 */       return null;
/* 1516 */     }if ((!dcl.type.staticMember) && (context.group != null)) {
/* 1517 */       modifiers = "public native ";
/* 1518 */       setterType = context.group.javaName + " ";
/*      */     }
/*      */ 
/* 1521 */     Declaration decl = new Declaration();
/* 1522 */     String definitions = "";
/* 1523 */     for (Declarator metadcl : new Declarator[] { context.variables != null ? context.variables : null }) {
/* 1524 */       for (int n = 0; n < 2147483647; n++) {
/* 1525 */         this.tokens.index = backIndex;
/* 1526 */         dcl = declarator(context, null, -1, n, false, true);
/* 1527 */         if (dcl == null) {
/*      */           break;
/*      */         }
/* 1530 */         name = dcl.javaName;
/* 1531 */         if ((metadcl == null) || (metadcl.indices == 0) || (dcl.indices == 0))
/*      */         {
/* 1533 */           String indices = "";
/* 1534 */           for (int i = 0; i < ((metadcl == null) || (metadcl.indices == 0) ? dcl.indices : metadcl.indices); i++) {
/* 1535 */             if (i > 0) {
/* 1536 */               indices = indices + ", ";
/*      */             }
/* 1538 */             indices = indices + "int " + (char)(105 + i);
/*      */           }
/* 1540 */           if ((context.namespace != null) && (context.group == null))
/*      */           {
/*      */             Declaration tmp419_417 = decl; tmp419_417.text = (tmp419_417.text + "@Namespace(\"" + context.namespace + "\") ");
/*      */           }
/* 1543 */           if ((metadcl != null) && (metadcl.cppName.length() > 0))
/*      */           {
/*      */             Declaration tmp474_472 = decl; tmp474_472.text = (tmp474_472.text + "@Name({\"" + metadcl.cppName + "\", \"." + dcl.cppName + "\"}) ");
/* 1545 */             name = metadcl.javaName + "_" + dcl.javaName;
/*      */           }
/* 1547 */           if (dcl.type.constValue)
/* 1548 */             decl.text += "@MemberGetter ";
/*      */           Declaration tmp598_596 = decl; tmp598_596.text = (tmp598_596.text + modifiers + dcl.type.annotations + dcl.type.javaName + " " + name + "(" + indices + ");");
/* 1551 */           if (!dcl.type.constValue) {
/* 1552 */             if (indices.length() > 0)
/* 1553 */               indices = indices + ", ";
/*      */             Declaration tmp713_711 = decl; tmp713_711.text = (tmp713_711.text + " " + modifiers + setterType + name + "(" + indices + dcl.type.javaName + " " + name + ");");
/*      */           }
/* 1557 */           decl.text += "\n";
/* 1558 */           definitions = definitions + dcl.definitions;
/*      */         }
/* 1560 */         if (dcl.indices > 0)
/*      */         {
/* 1562 */           this.tokens.index = backIndex;
/* 1563 */           dcl = declarator(context, null, -1, n, true, false);
/* 1564 */           String indices = "";
/* 1565 */           for (int i = 0; i < (metadcl == null ? 0 : metadcl.indices); i++) {
/* 1566 */             if (i > 0) {
/* 1567 */               indices = indices + ", ";
/*      */             }
/* 1569 */             indices = indices + "int " + (char)(105 + i);
/*      */           }
/* 1571 */           if ((context.namespace != null) && (context.group == null))
/*      */           {
/*      */             Declaration tmp976_974 = decl; tmp976_974.text = (tmp976_974.text + "@Namespace(\"" + context.namespace + "\") ");
/*      */           }
/* 1574 */           if ((metadcl != null) && (metadcl.cppName.length() > 0))
/*      */           {
/*      */             Declaration tmp1031_1029 = decl; tmp1031_1029.text = (tmp1031_1029.text + "@Name({\"" + metadcl.cppName + "\", \"." + dcl.cppName + "\"}) ");
/* 1576 */             name = metadcl.javaName + "_" + dcl.javaName;
/*      */           }
/*      */           Declaration tmp1117_1115 = decl; tmp1117_1115.text = (tmp1117_1115.text + "@MemberGetter " + modifiers + dcl.type.annotations + dcl.type.javaName + " " + name + "(" + indices + ");\n");
/*      */         }
/*      */       }
/*      */     }
/* 1582 */     String comment = commentAfter();
/* 1583 */     decl.text = rescan(definitions + comment + decl.text, spacing);
/* 1584 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration macro(Context context) throws Parser.Exception {
/* 1588 */     if (!this.tokens.get().match(new Object[] { Character.valueOf('#') })) {
/* 1589 */       return null;
/*      */     }
/* 1591 */     this.tokens.preprocess = false;
/* 1592 */     String spacing = this.tokens.get().spacing;
/* 1593 */     Token keyword = this.tokens.next();
/*      */ 
/* 1595 */     this.tokens.next();
/* 1596 */     int beginIndex = this.tokens.index;
/* 1597 */     for (Token token = this.tokens.get(); (!token.match(new Object[] { Token.EOF })) && 
/* 1598 */       (token.spacing.indexOf('\n') < 0); token = this.tokens.next());
/* 1602 */     int endIndex = this.tokens.index;
/*      */ 
/* 1604 */     Declaration decl = new Declaration();
/* 1605 */     if ((keyword.match(new Object[] { Token.DEFINE })) && (beginIndex + 1 < endIndex)) {
/* 1606 */       this.tokens.index = beginIndex;
/* 1607 */       String macroName = this.tokens.get().value;
/* 1608 */       Token first = this.tokens.next();
/* 1609 */       if (first.spacing.length() == 0);
/* 1609 */       boolean hasArgs = first.match(new Object[] { Character.valueOf('(') });
/* 1610 */       LinkedList infoList = this.infoMap.get(macroName);
/* 1611 */       if (infoList.size() == 0) {
/* 1612 */         infoList.add(null);
/*      */       }
/* 1614 */       for (Info info : infoList) {
/* 1615 */         if ((hasArgs) && (info == null))
/*      */         {
/* 1617 */           info = new Info(new String[] { macroName }).macroParams(new String[endIndex - this.tokens.index]).text("");
/* 1618 */           int count = 0;
/* 1619 */           for (Token token = this.tokens.get(); this.tokens.index < endIndex; token = this.tokens.next()) {
/* 1620 */             if (token.match(new Object[] { Integer.valueOf(5) }))
/* 1621 */               info.macroParams[(count++)] = token.value;
/* 1622 */             else if (token.match(new Object[] { Character.valueOf(')') })) {
/*      */                 break;
/*      */               }
/*      */           }
/* 1626 */           info.macroParams = ((String[])Arrays.copyOf(info.macroParams, count));
/* 1627 */           for (Token token = this.tokens.next(); this.tokens.index < endIndex; token = this.tokens.next())
/*      */           {
/*      */             Info tmp488_486 = info; tmp488_486.text = (tmp488_486.text + token.spacing + token);
/*      */           }
/* 1630 */           this.infoMap.put(info); } else {
/* 1631 */           if ((info != null) && (info.text == null) && (info.genericArgs != null)) if (info.genericArgs.length > (hasArgs ? 0 : 1))
/*      */             {
/* 1634 */               LinkedList prevDcl = new LinkedList();
/* 1635 */               for (int n = -1; n < 2147483647; n++) {
/* 1636 */                 int count = 1;
/* 1637 */                 this.tokens.index = (beginIndex + 2);
/* 1638 */                 String params = "(";
/* 1639 */                 for (Token token = this.tokens.get(); 
/* 1640 */                   (hasArgs) && (this.tokens.index < endIndex) && (count < info.genericArgs.length); token = this.tokens.next()) {
/* 1641 */                   if (token.match(new Object[] { Integer.valueOf(5) })) {
/* 1642 */                     String type = info.genericArgs[count];
/* 1643 */                     String name = token.value;
/* 1644 */                     if (name.equals("...")) {
/* 1645 */                       name = "arg" + count;
/*      */                     }
/* 1647 */                     params = params + type + " " + name;
/* 1648 */                     count++; if (count < info.genericArgs.length)
/* 1649 */                       params = params + ", ";
/*      */                   } else {
/* 1651 */                     if (token.match(new Object[] { Character.valueOf(')') }))
/*      */                       break;
/*      */                   }
/*      */                 }
/* 1655 */                 while (count < info.genericArgs.length) {
/* 1656 */                   String type = info.genericArgs[count];
/* 1657 */                   String name = "arg" + count;
/* 1658 */                   params = params + type + " " + name;
/* 1659 */                   count++; if (count < info.genericArgs.length) {
/* 1660 */                     params = params + ", ";
/*      */                   }
/*      */                 }
/* 1663 */                 params = params + ")";
/*      */ 
/* 1665 */                 TokenIndexer t = this.tokens;
/* 1666 */                 this.tokens = new TokenIndexer(this.infoMap, new Tokenizer(info.genericArgs[0] + " " + macroName + params).tokenize());
/* 1667 */                 Declarator dcl = declarator(context, null, n, 0, false, false);
/* 1668 */                 this.tokens = t;
/*      */ 
/* 1670 */                 for (int i = 0; i < info.cppNames.length; i++) {
/* 1671 */                   if ((macroName.equals(info.cppNames[i])) && (info.javaNames != null)) {
/* 1672 */                     macroName = "@Name(\"" + info.cppNames[0] + "\") " + info.javaNames[i];
/* 1673 */                     break;
/*      */                   }
/*      */                 }
/*      */ 
/* 1677 */                 boolean found = false;
/* 1678 */                 for (Declarator d : prevDcl) {
/* 1679 */                   found |= dcl.parameters.equals(d.parameters);
/*      */                 }
/* 1681 */                 if ((found) && (n > 0))
/*      */                   break;
/* 1683 */                 if (!found)
/*      */                 {
/*      */                   Declaration tmp1218_1216 = decl; tmp1218_1216.text = (tmp1218_1216.text + "public static native " + dcl.type.annotations + dcl.type.javaName + " " + macroName + dcl.parameters + ";\n");
/*      */                 }
/* 1686 */                 prevDcl.add(dcl);
/*      */               }
/* 1688 */               break label2086; }  if ((info == null) || ((info.text == null) && ((info.genericArgs == null) || (info.genericArgs.length == 1))))
/*      */           {
/* 1691 */             String value = "";
/* 1692 */             String type = "int";
/* 1693 */             String cat = "";
/* 1694 */             this.tokens.index = (beginIndex + 1);
/* 1695 */             Token prevToken = new Token();
/* 1696 */             boolean translate = true;
/* 1697 */             for (Token token = this.tokens.get(); this.tokens.index < endIndex; token = this.tokens.next()) {
/* 1698 */               if (token.match(new Object[] { Integer.valueOf(3) })) {
/* 1699 */                 type = "String"; cat = " + "; break;
/* 1700 */               }if (token.match(new Object[] { Integer.valueOf(2) })) {
/* 1701 */                 type = "double"; cat = ""; break;
/* 1702 */               }if ((token.match(new Object[] { Integer.valueOf(1) })) && (token.value.endsWith("L"))) {
/* 1703 */                 type = "long"; cat = ""; break;
/* 1704 */               }if (prevToken.match(new Object[] { Integer.valueOf(5) })) { if (token.match(new Object[] { Character.valueOf('(') })); } else if (!token.match(new Object[] { Character.valueOf('{'), Character.valueOf('}') }))
/*      */                   break label1558; translate = false;
/*      */ 
/* 1707 */               prevToken = token;
/*      */             }
/* 1709 */             if (info != null) {
/* 1710 */               if (info.genericArgs != null) {
/* 1711 */                 TokenIndexer t = this.tokens;
/* 1712 */                 this.tokens = new TokenIndexer(this.infoMap, new Tokenizer(info.genericArgs[0]).tokenize());
/* 1713 */                 Declarator dcl = declarator(context, null, -1, 0, false, true);
/* 1714 */                 this.tokens = t;
/* 1715 */                 type = dcl.type.annotations + dcl.type.javaName;
/*      */               }
/* 1717 */               for (int i = 0; i < info.cppNames.length; i++) {
/* 1718 */                 if ((macroName.equals(info.cppNames[i])) && (info.javaNames != null)) {
/* 1719 */                   macroName = "@Name(\"" + info.cppNames[0] + "\") " + info.javaNames[i];
/* 1720 */                   break;
/*      */                 }
/*      */               }
/* 1723 */               translate = info.translate;
/*      */             }
/* 1725 */             this.tokens.index = (beginIndex + 1);
/* 1726 */             if (!translate)
/*      */             {
/*      */               Declaration tmp1799_1797 = decl; tmp1799_1797.text = (tmp1799_1797.text + "public static native @MemberGetter " + type + " " + macroName + "();\n");
/* 1728 */               value = " " + macroName + "()";
/*      */             } else {
/* 1730 */               while (this.tokens.get(endIndex - this.tokens.index - 1).match(new Object[] { Integer.valueOf(4) })) {
/* 1731 */                 endIndex--;
/*      */               }
/* 1733 */               for (Token token = this.tokens.get(); this.tokens.index < endIndex; token = this.tokens.next()) {
/* 1734 */                 value = value + token.spacing + token + (this.tokens.index + 1 < endIndex ? cat : "");
/*      */               }
/*      */             }
/* 1737 */             int i = type.lastIndexOf(' ');
/* 1738 */             if (i >= 0) {
/* 1739 */               type = type.substring(i + 1);
/*      */             }
/* 1741 */             if (value.length() > 0)
/*      */             {
/*      */               Declaration tmp2038_2036 = decl; tmp2038_2036.text = (tmp2038_2036.text + "public static final " + type + " " + macroName + " =" + value + ";\n");
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/* 1747 */       label1558: label2086: if (decl.text.length() > 0) {
/* 1748 */         this.tokens.index = endIndex;
/* 1749 */         String comment = commentAfter();
/* 1750 */         decl.text = rescan(comment + decl.text, spacing);
/*      */       }
/*      */     }
/*      */ 
/* 1754 */     if (decl.text.length() == 0)
/*      */     {
/* 1756 */       this.tokens.index = beginIndex;
/* 1757 */       while (this.tokens.get(endIndex - this.tokens.index - 1).match(new Object[] { Integer.valueOf(4) })) {
/* 1758 */         endIndex--;
/*      */       }
/* 1760 */       int n = spacing.lastIndexOf('\n') + 1;
/*      */       Declaration tmp2228_2226 = decl; tmp2228_2226.text = (tmp2228_2226.text + "// " + spacing.substring(n) + "#" + keyword.spacing + keyword);
/* 1762 */       for (Token token = this.tokens.get(); this.tokens.index < endIndex; token = this.tokens.next()) {
/* 1763 */         decl.text += (token.match(new Object[] { "\n" }) ? "\n// " : new StringBuilder().append(token.spacing).append(token).toString());
/*      */       }
/* 1765 */       String comment = commentAfter();
/* 1766 */       decl.text = (spacing.substring(0, n) + comment + decl.text);
/*      */     }
/* 1768 */     this.tokens.preprocess = true;
/* 1769 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration typedef(Context context) throws Parser.Exception {
/* 1773 */     if (!this.tokens.get().match(new Object[] { Token.TYPEDEF })) {
/* 1774 */       return null;
/*      */     }
/* 1776 */     int backIndex = this.tokens.index;
/* 1777 */     String spacing = this.tokens.get().spacing;
/* 1778 */     Declarator dcl = declarator(context, null, 0, 0, true, false);
/* 1779 */     this.tokens.next();
/*      */ 
/* 1781 */     Declaration decl = new Declaration();
/* 1782 */     int endIndex = this.tokens.index;
/* 1783 */     String name = dcl.cppName; String typeName = dcl.type.cppName;
/* 1784 */     if (context.namespace != null) {
/* 1785 */       name = context.namespace + "::" + name;
/*      */     }
/* 1787 */     if (dcl.definitions.length() > 0)
/*      */     {
/* 1789 */       decl.text = dcl.definitions;
/* 1790 */       this.infoMap.put(new Info(new String[] { name }).valueTypes(new String[] { dcl.javaName }));
/* 1791 */     } else if (typeName.equals("void")) {
/* 1792 */       Info info = this.infoMap.getFirst(name);
/* 1793 */       if ((info == null) || (!info.skip)) {
/* 1794 */         decl.text = ("@Opaque public static class " + dcl.javaName + " extends Pointer {\n" + "    public " + dcl.javaName + "() { }\n" + "    public " + dcl.javaName + "(Pointer p) { super(p); }\n" + "}");
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1800 */       Info info = this.infoMap.getFirst(typeName);
/* 1801 */       info = info != null ? info.clone().cppNames(new String[] { name }) : new Info(new String[] { name });
/* 1802 */       if (info.valueTypes == null) {
/* 1803 */         info.valueTypes(new String[] { typeName });
/*      */       }
/* 1805 */       if (info.pointerTypes == null) {
/* 1806 */         info.pointerTypes(new String[] { typeName });
/*      */       }
/* 1808 */       this.infoMap.put(info.cast(true));
/*      */ 
/* 1810 */       this.tokens.index = backIndex;
/* 1811 */       info = this.infoMap.getFirst(this.tokens.next().value);
/* 1812 */       if ((info != null) && (info.templateParams != null)) if (this.tokens.next().match(new Object[] { Character.valueOf('<') })) {
/* 1813 */           info.genericArgs = new String[info.templateParams.length];
/* 1814 */           TemplateMap map = new TemplateMap(context.templateMap);
/* 1815 */           context = context.clone();
/* 1816 */           context.templateMap = map;
/* 1817 */           int count = 0;
/* 1818 */           for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1819 */             Type type = type(context);
/* 1820 */             info.genericArgs[count] = type.cppName;
/* 1821 */             map.put(info.templateParams[count], type.cppName);
/* 1822 */             count++;
/* 1823 */             if (this.tokens.get().expect(new Object[] { Character.valueOf(','), Character.valueOf('>') }).match(new Object[] { Character.valueOf('>') })) {
/* 1824 */               this.tokens.next();
/* 1825 */               break;
/*      */             }
/*      */           }
/* 1828 */           info.pointerTypes(new String[] { dcl.javaName });
/* 1829 */           TokenIndexer t = this.tokens;
/* 1830 */           this.tokens = new TokenIndexer(this.infoMap, new Tokenizer(info.text).tokenize());
/* 1831 */           decl = group(context);
/* 1832 */           this.tokens = t;
/*      */         }
/* 1834 */       this.tokens.index = endIndex;
/*      */     }
/*      */ 
/* 1837 */     String comment = commentAfter();
/* 1838 */     decl.text = rescan(comment + decl.text, spacing);
/* 1839 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration using(Context context) throws Parser.Exception {
/* 1843 */     if (!this.tokens.get().match(new Object[] { Token.USING })) {
/* 1844 */       return null;
/*      */     }
/* 1846 */     String spacing = this.tokens.get().spacing;
/* 1847 */     Declarator dcl = declarator(context, null, 0, 0, true, false);
/* 1848 */     this.tokens.next();
/*      */ 
/* 1850 */     Declaration decl = new Declaration();
/* 1851 */     String name = dcl.type.cppName.substring(dcl.type.cppName.lastIndexOf("::") + 2);
/* 1852 */     Info info = this.infoMap.getFirst(dcl.type.cppName);
/* 1853 */     info = info != null ? info.clone() : new Info(new String[] { name });
/* 1854 */     if (info.valueTypes == null) {
/* 1855 */       info.valueTypes(info.cppNames);
/*      */     }
/* 1857 */     if (info.pointerTypes == null) {
/* 1858 */       info.pointerTypes(info.cppNames);
/*      */     }
/* 1860 */     this.infoMap.put(info.cppNames(new String[] { name }));
/*      */ 
/* 1862 */     String comment = commentAfter();
/* 1863 */     decl.text = rescan(comment + dcl.definitions, spacing);
/* 1864 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration group(Context context) throws Parser.Exception {
/* 1868 */     int backIndex = this.tokens.index;
/* 1869 */     String spacing = this.tokens.get().spacing;
/* 1870 */     boolean isTypedef = this.tokens.get().match(new Object[] { Token.TYPEDEF });
/* 1871 */     boolean foundGroup = false; boolean accessible = true;
/* 1872 */     for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1873 */       if (token.match(new Object[] { Token.CLASS, Token.STRUCT, Token.UNION })) {
/* 1874 */         foundGroup = true;
/* 1875 */         accessible = !token.match(new Object[] { Token.CLASS });
/*      */       } else {
/* 1877 */         if (!token.match(new Object[] { Integer.valueOf(5) }))
/*      */           break;
/*      */       }
/*      */     }
/* 1881 */     if (!foundGroup) {
/* 1882 */       this.tokens.index = backIndex;
/* 1883 */       return null;
/*      */     }
/*      */ 
/* 1886 */     this.tokens.next().expect(new Object[] { Integer.valueOf(5), Character.valueOf('{') });
/* 1887 */     if (isTypedef) if (this.tokens.get(1).match(new Object[] { Character.valueOf('*') })) {
/* 1888 */         this.tokens.next();
/*      */       }
/* 1890 */     if (!this.tokens.get().match(new Object[] { Character.valueOf('{') })) if (this.tokens.get(1).match(new Object[] { Integer.valueOf(5) })) if (!isTypedef) { if (this.tokens.get(2).match(new Object[] { Character.valueOf(';') }));
/*      */         } else {
/* 1892 */           this.tokens.next();
/*      */         }
/* 1894 */     Type type = type(context);
/* 1895 */     Type parent = new Type("Pointer");
/* 1896 */     Declaration decl = new Declaration(type.annotations);
/* 1897 */     String name = type.cppName;
/* 1898 */     boolean anonymous = (!isTypedef) && (name.length() == 0);
/* 1899 */     if (name.length() > 0) if (this.tokens.get().match(new Object[] { Character.valueOf(':') })) {
/* 1900 */         for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1901 */           boolean exposed = false;
/* 1902 */           if (!token.match(new Object[] { Token.VIRTUAL }))
/*      */           {
/* 1904 */             if (token.match(new Object[] { Token.PRIVATE, Token.PROTECTED, Token.PUBLIC })) {
/* 1905 */               exposed = token.match(new Object[] { Token.PUBLIC });
/* 1906 */               this.tokens.next();
/*      */             }
/* 1908 */             Type t = type(context);
/* 1909 */             if (exposed) {
/* 1910 */               parent = t;
/*      */             }
/* 1912 */             if (this.tokens.get().expect(new Object[] { Character.valueOf(','), Character.valueOf('{') }).match(new Object[] { Character.valueOf('{') }))
/*      */               break;
/*      */           }
/*      */         }
/*      */       }
/* 1917 */     if (!this.tokens.get().match(new Object[] { Character.valueOf('{'), Character.valueOf(';') })) {
/* 1918 */       this.tokens.index = backIndex;
/* 1919 */       return null;
/*      */     }
/* 1921 */     int startIndex = this.tokens.index;
/* 1922 */     ArrayList variables = new ArrayList();
/* 1923 */     if (body() != null) if (!this.tokens.get().match(new Object[] { Character.valueOf(';') })) {
/* 1924 */         if (isTypedef) {
/* 1925 */           for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 1926 */             if (token.match(new Object[] { Character.valueOf(';') })) {
/* 1927 */               decl.text += token.spacing;
/* 1928 */               break;
/*      */             }
/* 1930 */             name = type.cppName = type.javaName = token.value;
/*      */           }
/*      */         }
/*      */         else {
/* 1934 */           int index = this.tokens.index - 1;
/* 1935 */           for (int n = 0; n < 2147483647; n++) {
/* 1936 */             this.tokens.index = index;
/* 1937 */             Declarator dcl = declarator(context, null, -1, n, false, true);
/* 1938 */             if (dcl == null) {
/*      */               break;
/*      */             }
/* 1941 */             variables.add(dcl);
/*      */           }
/*      */ 
/* 1944 */           int n = spacing.lastIndexOf('\n');
/* 1945 */           if (n >= 0) {
/* 1946 */             decl.text += spacing.substring(0, n);
/*      */           }
/*      */         }
/*      */       }
/* 1950 */     Info info = this.infoMap.getFirst(name);
/* 1951 */     if ((info != null) && (info.skip)) {
/* 1952 */       decl.text = "";
/* 1953 */       return decl;
/* 1954 */     }if ((info != null) && (info.pointerTypes != null) && (info.pointerTypes.length > 0)) {
/* 1955 */       name = info.pointerTypes[0];
/*      */     }
/* 1957 */     this.tokens.index = startIndex;
/* 1958 */     if (name.length() > 0) if (this.tokens.get().match(new Object[] { Character.valueOf(';') }))
/*      */       {
/* 1960 */         this.tokens.next();
/* 1961 */         if ((info == null) || (!info.complete)) {
/* 1962 */           if ((info != null) && (info.parent != null)) {
/* 1963 */             parent.javaName = info.parent;
/*      */           }
/* 1965 */           this.infoMap.put(new Info(new String[] { type.cppName }).complete(true));
/* 1966 */           if (context.namespace != null)
/*      */           {
/*      */             Declaration tmp1141_1139 = decl; tmp1141_1139.text = (tmp1141_1139.text + "@Namespace(\"" + context.namespace + "\") ");
/*      */           }
/*      */           Declaration tmp1180_1178 = decl; tmp1180_1178.text = (tmp1180_1178.text + "@Opaque public static class " + name + " extends " + parent.javaName + " {\n" + "    public " + name + "() { }\n" + "    public " + name + "(Pointer p) { super(p); }\n" + "}");
/*      */         }
/*      */ 
/* 1974 */         String comment = commentAfter();
/* 1975 */         decl.text = rescan(comment + decl.text, spacing);
/* 1976 */         return decl;
/*      */       } if (info == null) {
/* 1978 */       this.infoMap.put(new Info(new String[] { context.namespace + "::" + name }));
/*      */     }
/*      */ 
/* 1981 */     Context context2 = context.clone();
/* 1982 */     context2.namespace = (context.namespace + "::" + name);
/* 1983 */     if (!anonymous) {
/* 1984 */       context2.group = type;
/*      */     }
/* 1986 */     if (variables.size() > 0) {
/* 1987 */       context2.variables = ((Declarator[])variables.toArray(new Declarator[variables.size()]));
/*      */     }
/* 1989 */     String declarations = "";
/* 1990 */     boolean implicitConstructor = true; boolean defaultConstructor = false;
/* 1991 */     if (this.tokens.get().match(new Object[] { Character.valueOf('{') })) {
/* 1992 */       this.tokens.next();
/*      */     }
/* 1994 */     for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF, Character.valueOf('}') }); token = this.tokens.get()) {
/* 1995 */       if (token.match(new Object[] { Token.PRIVATE, Token.PROTECTED, Token.PUBLIC })) if (this.tokens.next().match(new Object[] { Character.valueOf(':') })) {
/* 1996 */           accessible = token.match(new Object[] { Token.PUBLIC });
/* 1997 */           this.tokens.next();
/*      */         }
/* 1999 */       Declaration decl2 = declaration(context2);
/* 2000 */       if (decl2.constructor) {
/* 2001 */         implicitConstructor = false;
/* 2002 */         defaultConstructor |= decl2.text.contains("allocate()");
/*      */       }
/* 2004 */       if (accessible) {
/* 2005 */         declarations = declarations + decl2.text;
/*      */       }
/*      */     }
/*      */ 
/* 2009 */     if (!anonymous) {
/* 2010 */       decl.text += spacing;
/* 2011 */       if (context.namespace != null)
/*      */       {
/*      */         Declaration tmp1741_1739 = decl; tmp1741_1739.text = (tmp1741_1739.text + "@Namespace(\"" + context.namespace + "\") ");
/*      */       }
/* 2014 */       String templateArgs = "";
/* 2015 */       if ((info != null) && (info.genericArgs != null) && (context.templateMap != null)) {
/* 2016 */         int count = 0;
/* 2017 */         templateArgs = templateArgs + '<';
/* 2018 */         for (Map.Entry e : context.templateMap.entrySet()) {
/* 2019 */           if ((count < info.genericArgs.length) && (e.getValue() == null)) {
/* 2020 */             context.templateMap.put(e.getKey(), info.genericArgs[count]);
/*      */           }
/* 2022 */           if (count++ > 0) {
/* 2023 */             templateArgs = templateArgs + ',';
/*      */           }
/* 2025 */           templateArgs = templateArgs + context.templateMap.get((String)e.getKey());
/*      */         }
/* 2027 */         templateArgs = templateArgs + '>';
/*      */       }
/* 2029 */       if ((!name.equals(type.cppName)) || (templateArgs.length() > 0))
/*      */       {
/*      */         Declaration tmp2022_2020 = decl; tmp2022_2020.text = (tmp2022_2020.text + "@Name(\"" + type.cppName + templateArgs + "\") ");
/*      */       }
/* 2032 */       if (!implicitConstructor) {
/* 2033 */         decl.text += "@NoOffset ";
/*      */       }
/* 2035 */       if ((info != null) && (info.parent != null))
/* 2036 */         parent.javaName = info.parent;
/*      */       Declaration tmp2122_2120 = decl; tmp2122_2120.text = (tmp2122_2120.text + "public static class " + name + " extends " + parent.javaName + " {\n" + "    static { Loader.load(); }\n");
/*      */ 
/* 2041 */       if (implicitConstructor)
/*      */       {
/*      */         Declaration tmp2184_2182 = decl; tmp2184_2182.text = (tmp2184_2182.text + "    public " + name + "() { allocate(); }\n" + "    public " + name + "(int size) { allocateArray(size); }\n" + "    public " + name + "(Pointer p) { super(p); }\n" + "    private native void allocate();\n" + "    private native void allocateArray(int size);\n" + "    @Override public " + name + " position(int position) {\n" + "        return (" + name + ")super.position(position);\n" + "    }\n");
/*      */       }
/*      */       else
/*      */       {
/* 2051 */         if (!defaultConstructor)
/*      */         {
/*      */           Declaration tmp2310_2308 = decl; tmp2310_2308.text = (tmp2310_2308.text + "    public " + name + "() { }\n");
/*      */         }
/*      */         Declaration tmp2348_2346 = decl; tmp2348_2346.text = (tmp2348_2346.text + "    public " + name + "(Pointer p) { super(p); }\n");
/*      */       }
/*      */     }
/* 2057 */     String comment = commentBefore();
/*      */     Declaration tmp2391_2389 = decl; tmp2391_2389.text = (tmp2391_2389.text + declarations + comment);
/* 2059 */     if (!anonymous)
/*      */     {
/*      */       Declaration tmp2428_2426 = decl; tmp2428_2426.text = (tmp2428_2426.text + this.tokens.get().spacing + '}');
/*      */     }
/* 2062 */     for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 2063 */       if (token.match(new Object[] { Character.valueOf(';') })) {
/* 2064 */         decl.text += token.spacing;
/* 2065 */         break;
/*      */       }
/*      */     }
/* 2068 */     this.tokens.next();
/* 2069 */     if (((info == null) || (info.genericArgs == null)) && (context.templateMap != null))
/*      */     {
/* 2071 */       info = new Info(new String[] { type.cppName }).templateParams(new String[context.templateMap.size()]).text("");
/* 2072 */       int count = 0;
/* 2073 */       for (String key : context.templateMap.keySet()) {
/* 2074 */         if (count < info.templateParams.length) {
/* 2075 */           info.templateParams[(count++)] = key;
/*      */         }
/*      */       }
/* 2078 */       int endIndex = this.tokens.index;
/* 2079 */       this.tokens.index = backIndex;
/* 2080 */       this.tokens.preprocess = false;
/* 2081 */       for (Token token = this.tokens.get(); this.tokens.index < endIndex; token = this.tokens.next())
/*      */       {
/*      */         Info tmp2739_2737 = info; tmp2739_2737.text = (tmp2739_2737.text + token.spacing + token);
/*      */       }
/* 2084 */       this.tokens.preprocess = true;
/* 2085 */       this.infoMap.putFirst(info);
/* 2086 */       decl.text = "";
/*      */     }
/* 2088 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration enumeration(Context context) throws Parser.Exception {
/* 2092 */     int backIndex = this.tokens.index;
/* 2093 */     String enumSpacing = this.tokens.get().spacing;
/* 2094 */     boolean isTypedef = this.tokens.get().match(new Object[] { Token.TYPEDEF });
/* 2095 */     boolean foundEnum = false;
/* 2096 */     for (Token token = this.tokens.get(); !token.match(new Object[] { Token.EOF }); token = this.tokens.next()) {
/* 2097 */       if (token.match(new Object[] { Token.ENUM }))
/* 2098 */         foundEnum = true;
/*      */       else {
/* 2100 */         if (!token.match(new Object[] { Integer.valueOf(5) }))
/*      */           break;
/*      */       }
/*      */     }
/* 2104 */     if (!foundEnum) {
/* 2105 */       this.tokens.index = backIndex;
/* 2106 */       return null;
/*      */     }
/*      */ 
/* 2109 */     if (isTypedef) if (!this.tokens.get(1).match(new Object[] { Character.valueOf('{') })) if (this.tokens.get(2).match(new Object[] { Integer.valueOf(5) })) {
/* 2110 */           this.tokens.next();
/*      */         }
/* 2112 */     boolean first = true;
/* 2113 */     int count = 0;
/* 2114 */     String countPrefix = " ";
/* 2115 */     String enumerators = "";
/* 2116 */     String macroText = "";
/* 2117 */     String name = this.tokens.next().expect(new Object[] { Integer.valueOf(5), Character.valueOf('{') }).value;
/* 2118 */     if (!this.tokens.get().match(new Object[] { Character.valueOf('{') })) if (!this.tokens.next().match(new Object[] { Character.valueOf('{') })) {
/* 2119 */         this.tokens.index = backIndex;
/* 2120 */         return null;
/*      */       }
/* 2122 */     for (Token token = this.tokens.next(); !token.match(new Object[] { Token.EOF, Character.valueOf('}') }); token = this.tokens.get()) {
/* 2123 */       Declaration macroDecl = macro(context);
/* 2124 */       if (macroDecl != null) {
/* 2125 */         macroText = macroText + macroDecl.text;
/* 2126 */         if ((!first) && (!macroDecl.text.trim().startsWith("//"))) {
/* 2127 */           enumerators = enumerators + ";\n";
/* 2128 */           macroText = macroText + "\npublic static final int";
/* 2129 */           first = true;
/*      */         }
/*      */       }
/*      */       else {
/* 2133 */         String comment = commentBefore();
/* 2134 */         Token enumerator = this.tokens.get();
/* 2135 */         String spacing2 = " ";
/* 2136 */         String separator = first ? "" : ",";
/* 2137 */         if (this.tokens.next().match(new Object[] { Character.valueOf('=') })) {
/* 2138 */           spacing2 = this.tokens.get().spacing;
/* 2139 */           countPrefix = " ";
/* 2140 */           int count2 = 0;
/* 2141 */           Token prevToken = new Token();
/* 2142 */           boolean translate = true;
/* 2143 */           for (token = this.tokens.next(); (!token.match(new Object[] { Token.EOF, Character.valueOf(','), Character.valueOf('}') })) || (count2 > 0); token = this.tokens.next()) {
/* 2144 */             countPrefix = countPrefix + token.spacing + token;
/* 2145 */             if (token.match(new Object[] { Character.valueOf('(') }))
/* 2146 */               count2++;
/* 2147 */             else if (token.match(new Object[] { Character.valueOf(')') })) {
/* 2148 */               count2--;
/*      */             }
/* 2150 */             if (prevToken.match(new Object[] { Integer.valueOf(5) })) if (token.match(new Object[] { Character.valueOf('(') })) {
/* 2151 */                 translate = false;
/*      */               }
/* 2153 */             prevToken = token;
/*      */           }
/*      */           try {
/* 2156 */             count = Integer.parseInt(countPrefix.trim());
/* 2157 */             countPrefix = " ";
/*      */           } catch (NumberFormatException e) {
/* 2159 */             count = 0;
/* 2160 */             if (!translate) {
/* 2161 */               if (!first) {
/* 2162 */                 separator = ";\n";
/* 2163 */                 first = true;
/*      */               }
/* 2165 */               separator = separator + "public static native @MemberGetter int " + enumerator.value + "();\npublic static final int";
/* 2166 */               countPrefix = " " + enumerator.value + "()";
/*      */             }
/*      */           }
/*      */         }
/* 2170 */         first = false;
/* 2171 */         enumerators = enumerators + separator + macroText + comment;
/* 2172 */         macroText = "";
/* 2173 */         comment = commentAfter();
/* 2174 */         if (comment.length() == 0) if (this.tokens.get().match(new Object[] { Character.valueOf(',') })) {
/* 2175 */             this.tokens.next();
/* 2176 */             comment = commentAfter();
/*      */           }
/* 2178 */         String spacing = enumerator.spacing;
/* 2179 */         if (comment.length() > 0) {
/* 2180 */           enumerators = enumerators + spacing + comment;
/* 2181 */           int newline = spacing.lastIndexOf('\n');
/* 2182 */           if (newline >= 0) {
/* 2183 */             spacing = spacing.substring(newline + 1);
/*      */           }
/*      */         }
/* 2186 */         enumerators = enumerators + spacing + enumerator.value + spacing2 + "=" + countPrefix;
/* 2187 */         if (countPrefix.trim().length() > 0) {
/* 2188 */           if (count > 0)
/* 2189 */             enumerators = enumerators + " + " + count;
/*      */         }
/*      */         else {
/* 2192 */           enumerators = enumerators + count;
/*      */         }
/* 2194 */         count++;
/*      */       }
/*      */     }
/* 2196 */     String comment = commentBefore();
/* 2197 */     Declaration decl = new Declaration();
/* 2198 */     Token token = this.tokens.next();
/* 2199 */     if (token.match(new Object[] { Integer.valueOf(5) }))
/*      */     {
/* 2201 */       name = token.value;
/* 2202 */       token = this.tokens.next();
/*      */     }
/* 2204 */     if (context.namespace != null)
/* 2205 */       name = context.namespace + "::" + name;
/*      */     Declaration tmp1238_1236 = decl; tmp1238_1236.text = (tmp1238_1236.text + enumSpacing + "/** enum " + name + " */\n");
/* 2208 */     int newline = enumSpacing.lastIndexOf('\n');
/* 2209 */     if (newline >= 0) {
/* 2210 */       enumSpacing = enumSpacing.substring(newline + 1);
/*      */     }
/* 2212 */     if (!Character.isWhitespace(enumerators.charAt(0)))
/* 2213 */       enumerators = " " + enumerators;
/*      */     Declaration tmp1337_1335 = decl; tmp1337_1335.text = (tmp1337_1335.text + enumSpacing + "public static final int" + enumerators + token.expect(new Object[] { Character.valueOf(';') }).spacing + ";");
/* 2216 */     this.infoMap.put(new Info(new String[] { name }).valueTypes(new String[] { "int" }).pointerTypes(new String[] { "IntPointer", "IntBuffer", "int[]" }).cast(true));
/* 2217 */     this.tokens.next();
/*      */     Declaration tmp1476_1474 = decl; tmp1476_1474.text = (tmp1476_1474.text + macroText + comment);
/* 2219 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration namespace(Context context) throws Parser.Exception {
/* 2223 */     if (!this.tokens.get().match(new Object[] { Token.NAMESPACE })) {
/* 2224 */       return null;
/*      */     }
/* 2226 */     Declaration decl = new Declaration();
/* 2227 */     String name = this.tokens.next().expect(new Object[] { Integer.valueOf(5) }).value;
/* 2228 */     this.tokens.next().expect(new Object[] { Character.valueOf('{') });
/* 2229 */     this.tokens.next();
/*      */ 
/* 2231 */     context = context.clone();
/* 2232 */     context.namespace = (context.namespace + "::" + name);
/* 2233 */     while (!this.tokens.get().match(new Object[] { Token.EOF, Character.valueOf('}') })) {
/* 2234 */       decl.text += declaration(context).text;
/*      */     }
/* 2236 */     decl.text += this.tokens.get().spacing;
/* 2237 */     this.tokens.next();
/* 2238 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration extern(Context context) throws Parser.Exception {
/* 2242 */     if (this.tokens.get().match(new Object[] { Token.EXTERN })) { if (this.tokens.get(1).match(new Object[] { Integer.valueOf(3) }));
/*      */     } else return null;
/*      */ 
/* 2245 */     Declaration decl = new Declaration();
/* 2246 */     this.tokens.next().expect(new Object[] { "\"C\"" });
/* 2247 */     if (!this.tokens.next().match(new Object[] { Character.valueOf('{') })) {
/* 2248 */       return decl;
/*      */     }
/* 2250 */     this.tokens.next();
/*      */ 
/* 2252 */     while (!this.tokens.get().match(new Object[] { Token.EOF, Character.valueOf('}') })) {
/* 2253 */       decl.text += declaration(context).text;
/*      */     }
/* 2255 */     this.tokens.next();
/* 2256 */     return decl;
/*      */   }
/*      */ 
/*      */   Declaration declaration(Context context)
/*      */     throws Parser.Exception
/*      */   {
/* 2269 */     while (this.tokens.get().match(new Object[] { Character.valueOf(';') })) { if (this.tokens.get().match(new Object[] { Token.EOF })) break;
/* 2270 */       this.tokens.next();
/*      */     }
/* 2272 */     if (context == null) {
/* 2273 */       context = new Context();
/*      */     }
/* 2275 */     String comment = commentBefore();
/* 2276 */     Token token = this.tokens.get();
/* 2277 */     String spacing = token.spacing;
/* 2278 */     TemplateMap map = template(context);
/* 2279 */     if (map != context.templateMap) {
/* 2280 */       token = this.tokens.get();
/* 2281 */       if (token.spacing.length() > 0) {
/* 2282 */         token.spacing = token.spacing.substring(1);
/*      */       }
/* 2284 */       context = context.clone();
/* 2285 */       context.templateMap = map;
/* 2286 */       comment = comment + spacing;
/*      */     }
/* 2288 */     Declaration decl = null;
/* 2289 */     if (((decl = macro(context)) == null) && ((decl = extern(context)) == null) && ((decl = namespace(context)) == null) && ((decl = enumeration(context)) == null) && ((decl = group(context)) == null) && ((decl = typedef(context)) == null) && ((decl = using(context)) == null) && ((decl = function(context)) == null) && ((decl = variable(context)) == null) && ((decl = attribute()) == null))
/*      */     {
/* 2299 */       throw new Exception(token.file + ":" + token.lineNumber + ": Could not parse declaration at '" + token + "'");
/*      */     }
/* 2301 */     decl.text = (comment + decl.text);
/* 2302 */     return decl;
/*      */   }
/*      */ 
/*      */   public void parse(String outputFilename, String[] inputFilenames) throws IOException, Parser.Exception
/*      */   {
/* 2307 */     File[] files = new File[inputFilenames.length];
/* 2308 */     for (int i = 0; i < files.length; i++) {
/* 2309 */       files[i] = new File(inputFilenames[i]);
/*      */     }
/* 2311 */     parse(new File(outputFilename), files);
/*      */   }
/*      */   public void parse(File outputFile, File[] inputFiles) throws IOException, Parser.Exception {
/* 2314 */     ArrayList tokenList = new ArrayList();
/* 2315 */     String lineSeparator = "\n";
/* 2316 */     for (File file : inputFiles) {
/* 2317 */       Info info = this.infoMap.getFirst(file.getName());
/* 2318 */       if ((info == null) || (info.parse))
/*      */       {
/* 2321 */         System.out.println("Parsing header file: " + file);
/* 2322 */         Token token = new Token();
/* 2323 */         token.type = 4;
/* 2324 */         token.value = ("\n/* Wrapper for header file " + file + " */\n\n");
/* 2325 */         tokenList.add(token);
/* 2326 */         Tokenizer tokenizer = new Tokenizer(file);
/* 2327 */         while (!(token = tokenizer.nextToken()).isEmpty()) {
/* 2328 */           if (token.type == -1) {
/* 2329 */             token.type = 4;
/*      */           }
/* 2331 */           tokenList.add(token);
/*      */         }
/* 2333 */         if (lineSeparator == null) {
/* 2334 */           lineSeparator = tokenizer.lineSeparator;
/*      */         }
/* 2336 */         tokenizer.close();
/* 2337 */         token = new Token();
/* 2338 */         token.type = 4;
/* 2339 */         token.spacing = "\n";
/* 2340 */         tokenList.add(token);
/*      */       }
/*      */     }
/* 2342 */     this.tokens = new TokenIndexer(this.infoMap, (Token[])tokenList.toArray(new Token[tokenList.size()]));
/*      */ 
/* 2344 */     Writer out = outputFile != null ? new FileWriter(outputFile) : new Writer()
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
/*      */     };
/* 2349 */     LinkedList infoList = this.infoMap.get(null);
/* 2350 */     for (Info info : infoList) {
/* 2351 */       if (info.text != null) {
/* 2352 */         out.append(info.text.replaceAll("\n", lineSeparator));
/*      */       }
/*      */     }
/* 2355 */     out.append("{" + lineSeparator);
/* 2356 */     out.append("    static { Loader.load(); }" + lineSeparator);
/* 2357 */     out.append(vectors());
/* 2358 */     while (!this.tokens.get().match(new Object[] { Token.EOF })) {
/* 2359 */       out.append(declaration(null).text.replaceAll("\n", lineSeparator));
/*      */     }
/* 2361 */     String comment = commentBefore();
/* 2362 */     if (comment != null) {
/* 2363 */       out.append(comment.replaceAll("\n", lineSeparator));
/*      */     }
/* 2365 */     out.append(lineSeparator + "}" + lineSeparator);
/* 2366 */     out.close();
/*      */   }
/*      */ 
/*      */   public File parse(String outputDirectory, Class cls) throws IOException, Parser.Exception {
/* 2370 */     return parse(new File(outputDirectory), cls);
/*      */   }
/*      */   public File parse(File outputDirectory, Class cls) throws IOException, Parser.Exception {
/* 2373 */     Loader.ClassProperties allProperties = Loader.loadProperties(cls, this.properties, true);
/* 2374 */     Loader.ClassProperties clsProperties = Loader.loadProperties(cls, this.properties, false);
/* 2375 */     LinkedList allFiles = allProperties.getHeaderFiles();
/* 2376 */     LinkedList clsFiles = clsProperties.getHeaderFiles();
/* 2377 */     LinkedList allTargets = allProperties.get("parser.target");
/* 2378 */     LinkedList clsTargets = clsProperties.get("parser.target");
/* 2379 */     String target = (String)clsTargets.getFirst();
/*      */ 
/* 2381 */     String text = "/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */\n\n";
/* 2382 */     int n = target.lastIndexOf('.');
/* 2383 */     if (n >= 0) {
/* 2384 */       text = text + "package " + target.substring(0, n) + ";\n\n";
/*      */     }
/* 2386 */     text = text + "import com.googlecode.javacpp.*;\nimport com.googlecode.javacpp.annotation.*;\nimport java.nio.*;\n\n";
/*      */ 
/* 2389 */     for (String s : allTargets) {
/* 2390 */       if (!target.equals(s)) {
/* 2391 */         text = text + "import static " + s + ".*;\n";
/*      */       }
/*      */     }
/* 2394 */     if (allTargets.size() > 1) {
/* 2395 */       text = text + "\n";
/*      */     }
/* 2397 */     text = text + "public class " + target.substring(n + 1) + " extends " + cls.getCanonicalName() + " ";
/* 2398 */     this.infoMap.put(new Info().text(text));
/*      */ 
/* 2400 */     File targetFile = new File(outputDirectory, target.replace('.', '/') + ".java");
/* 2401 */     System.out.println("Targeting file: " + targetFile);
/* 2402 */     for (File f : allFiles) {
/* 2403 */       if (!clsFiles.contains(f)) {
/* 2404 */         parse(null, new File[] { f });
/*      */       }
/*      */     }
/* 2407 */     parse(targetFile, (File[])clsFiles.toArray(new File[clsFiles.size()]));
/* 2408 */     return targetFile;
/*      */   }
/*      */ 
/*      */   class Declaration
/*      */   {
/* 2264 */     boolean constructor = false;
/* 2265 */     String text = "";
/*      */ 
/*      */     Declaration()
/*      */     {
/*      */     }
/*      */ 
/*      */     Declaration(String text)
/*      */     {
/* 2262 */       this.text = text;
/*      */     }
/*      */   }
/*      */ 
/*      */   static class Parameters
/*      */   {
/* 1329 */     int infoNumber = 0;
/* 1330 */     String list = ""; String definitions = ""; String signature = ""; String names = "";
/*      */   }
/*      */ 
/*      */   static class Declarator
/*      */   {
/*      */     Parser.Type type;
/* 1001 */     int infoNumber = 0; int indices = 0;
/* 1002 */     boolean constPointer = false;
/* 1003 */     String cppName = ""; String javaName = ""; String convention = ""; String definitions = ""; String parameters = "";
/*      */   }
/*      */ 
/*      */   static class Type
/*      */   {
/*  876 */     boolean anonymous = false; boolean constValue = false; boolean destructor = false; boolean operator = false; boolean simpleType = false; boolean staticMember = false;
/*      */ 
/*  878 */     String annotations = ""; String cppName = ""; String javaName = "";
/*      */ 
/*      */     Type()
/*      */     {
/*      */     }
/*      */ 
/*      */     Type(String name)
/*      */     {
/*  874 */       this.cppName = (this.javaName = name);
/*      */     }
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  881 */       if (obj == this)
/*  882 */         return true;
/*  883 */       if (obj == null)
/*  884 */         return false;
/*  885 */       if (obj.getClass() == getClass()) {
/*  886 */         Type other = (Type)obj;
/*  887 */         return (this.cppName.equals(other.cppName)) && (this.javaName.equals(other.javaName));
/*      */       }
/*  889 */       return false;
/*      */     }
/*      */   }
/*      */ 
/*      */   static class TemplateMap extends LinkedHashMap<String, String>
/*      */   {
/*  826 */     LinkedHashMap<String, String> defaults = null;
/*      */ 
/*      */     TemplateMap(TemplateMap defaults)
/*      */     {
/*  824 */       this.defaults = defaults;
/*      */     }
/*      */ 
/*      */     String get(String key)
/*      */     {
/*  829 */       String value = (String)super.get(key);
/*  830 */       if ((value == null) && (this.defaults != null)) {
/*  831 */         return (String)this.defaults.get(key);
/*      */       }
/*  833 */       return value;
/*      */     }
/*      */   }
/*      */ 
/*      */   static class Context
/*      */     implements Cloneable
/*      */   {
/*  729 */     String namespace = null;
/*  730 */     Parser.Type group = null;
/*  731 */     Parser.Declarator[] variables = null;
/*  732 */     Parser.TemplateMap templateMap = null;
/*      */ 
/*      */     public Context clone() {
/*  735 */       Context c = new Context();
/*  736 */       c.namespace = this.namespace;
/*  737 */       c.group = this.group;
/*  738 */       c.variables = this.variables;
/*  739 */       c.templateMap = this.templateMap;
/*  740 */       return c;
/*      */     }
/*      */   }
/*      */ 
/*      */   static class TokenIndexer
/*      */   {
/*  572 */     boolean preprocess = true;
/*  573 */     Parser.InfoMap infoMap = null;
/*  574 */     Parser.Token[] array = null;
/*  575 */     int index = 0;
/*      */ 
/*      */     TokenIndexer(Parser.InfoMap infoMap, Parser.Token[] array)
/*      */     {
/*  568 */       this.infoMap = infoMap;
/*  569 */       this.array = array;
/*      */     }
/*      */ 
/*      */     void filter(int index)
/*      */     {
/*  578 */       if (index + 1 < this.array.length) if (this.array[index].match(new Object[] { Character.valueOf('#') })) if (this.array[(index + 1)].match(new Object[] { Parser.Token.IF, Parser.Token.IFDEF, Parser.Token.IFNDEF }))
/*      */           {
/*  580 */             ArrayList tokens = new ArrayList();
/*  581 */             for (int i = 0; i < index; i++) {
/*  582 */               tokens.add(this.array[i]);
/*      */             }
/*  584 */             int count = 0;
/*  585 */             Parser.Info info = null;
/*  586 */             boolean define = true; boolean defined = false;
/*  587 */             while (index < this.array.length) {
/*  588 */               Parser.Token keyword = null;
/*  589 */               if (this.array[index].match(new Object[] { Character.valueOf('#') })) {
/*  590 */                 if (count == 0) if (this.array[(index + 1)].match(new Object[] { Parser.Token.IF, Parser.Token.IFDEF, Parser.Token.IFNDEF })) {
/*  591 */                     count++;
/*  592 */                     keyword = this.array[(index + 1)]; break label257;
/*      */                   } if (count == 1) if (this.array[(index + 1)].match(new Object[] { Parser.Token.ELIF, Parser.Token.ELSE, Parser.Token.ENDIF })) {
/*  594 */                     keyword = this.array[(index + 1)];
/*      */                   }
/*      */               }
/*  597 */               label257: if (keyword != null) {
/*  598 */                 tokens.add(this.array[(index++)]);
/*  599 */                 tokens.add(this.array[(index++)]);
/*  600 */                 if (keyword.match(new Object[] { Parser.Token.IF, Parser.Token.IFDEF, Parser.Token.IFNDEF, Parser.Token.ELIF })) {
/*  601 */                   String value = "";
/*  602 */                   while ((index < this.array.length) && 
/*  603 */                     (this.array[index].spacing.indexOf('\n') < 0))
/*      */                   {
/*  606 */                     value = value + this.array[index].spacing + this.array[index];
/*  607 */                     tokens.add(this.array[(index++)]);
/*      */                   }
/*  609 */                   define = (info == null) || (!defined);
/*  610 */                   info = this.infoMap.getFirst(value);
/*  611 */                   if (info != null)
/*  612 */                     define = keyword.match(new Object[] { Parser.Token.IFNDEF }) ? false : !info.define ? true : info.define;
/*      */                 }
/*  614 */                 else if (keyword.match(new Object[] { Parser.Token.ELSE })) {
/*  615 */                   define = (info == null) || (!define);
/*  616 */                 } else if (keyword.match(new Object[] { Parser.Token.ENDIF })) {
/*  617 */                   count--;
/*  618 */                   if (count == 0)
/*  619 */                     break;
/*      */                 }
/*      */               }
/*  622 */               else if (define) {
/*  623 */                 tokens.add(this.array[(index++)]);
/*      */               } else {
/*  625 */                 index++;
/*      */               }
/*  627 */               defined = (define) || (defined);
/*      */             }
/*  629 */             while (index < this.array.length) {
/*  630 */               tokens.add(this.array[(index++)]);
/*      */             }
/*  632 */             this.array = ((Parser.Token[])tokens.toArray(new Parser.Token[tokens.size()]));
/*      */           } 
/*      */     }
/*      */ 
/*      */     void expand(int index)
/*      */     {
/*  637 */       if ((index < this.array.length) && (this.infoMap.containsKey(this.array[index].value))) {
/*  638 */         int startIndex = index;
/*  639 */         Parser.Info info = this.infoMap.getFirst(this.array[index].value);
/*  640 */         if ((info != null) && (info.macroParams != null) && (info.text != null)) {
/*  641 */           if (info.macroParams.length > 0) if (index + 1 < this.array.length) { if (this.array[(index + 1)].match(new Object[] { Character.valueOf('(') }));
/*      */             } else {
/*  643 */               return;
/*      */             }
/*  645 */           ArrayList tokens = new ArrayList();
/*  646 */           for (int i = 0; i < index; i++) {
/*  647 */             tokens.add(this.array[i]);
/*      */           }
/*  649 */           ArrayList[] args = new ArrayList[info.macroParams.length];
/*  650 */           int count = 0; int count2 = 0;
/*  651 */           for (index += 2; index < this.array.length; index++) {
/*  652 */             Parser.Token token = this.array[index];
/*  653 */             if (count2 == 0) if (token.match(new Object[] { Character.valueOf(')') }))
/*      */                 break;
/*  655 */             if (count2 == 0) if (token.match(new Object[] { Character.valueOf(',') })) {
/*  656 */                 count++;
/*  657 */                 continue;
/*      */               } if (token.match(new Object[] { Character.valueOf('('), Character.valueOf('['), Character.valueOf('{') }))
/*  659 */               count2++;
/*  660 */             else if (token.match(new Object[] { Character.valueOf(')'), Character.valueOf(']'), Character.valueOf('}') })) {
/*  661 */               count2--;
/*      */             }
/*  663 */             if (args[count] == null) {
/*  664 */               args[count] = new ArrayList();
/*      */             }
/*  666 */             args[count].add(token);
/*      */           }
/*      */           try {
/*  669 */             Parser.Tokenizer tokenizer = new Parser.Tokenizer(info.text);
/*      */             Parser.Token token;
/*  671 */             while (!(token = tokenizer.nextToken()).isEmpty()) {
/*  672 */               boolean foundArg = false;
/*  673 */               for (int i = 0; i < info.macroParams.length; i++) {
/*  674 */                 if (info.macroParams[i].equals(token.value)) {
/*  675 */                   if (tokens.size() == startIndex) {
/*  676 */                     ((Parser.Token)args[i].get(0)).spacing = this.array[startIndex].spacing;
/*      */                   }
/*  678 */                   tokens.addAll(args[i]);
/*  679 */                   foundArg = true;
/*  680 */                   break;
/*      */                 }
/*      */               }
/*  683 */               if (!foundArg) {
/*  684 */                 if (tokens.size() == startIndex) {
/*  685 */                   token.spacing = this.array[startIndex].spacing;
/*      */                 }
/*  687 */                 tokens.add(token);
/*      */               }
/*      */             }
/*      */           } catch (IOException ex) {
/*  691 */             throw new RuntimeException(ex);
/*      */           }
/*  693 */           for (index++; index < this.array.length; index++) {
/*  694 */             tokens.add(this.array[index]);
/*      */           }
/*  696 */           this.array = ((Parser.Token[])tokens.toArray(new Parser.Token[tokens.size()]));
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     int preprocess(int index, int count) {
/*  702 */       while (index < this.array.length) {
/*  703 */         filter(index);
/*  704 */         expand(index);
/*  705 */         if (!this.array[index].match(new Object[] { Integer.valueOf(4) })) { count--; if (count < 0)
/*      */             break;
/*      */         }
/*  708 */         index++;
/*      */       }
/*  710 */       filter(index);
/*  711 */       expand(index);
/*  712 */       return index;
/*      */     }
/*      */ 
/*      */     Parser.Token get() {
/*  716 */       return get(0);
/*      */     }
/*      */     Parser.Token get(int i) {
/*  719 */       int k = this.preprocess ? preprocess(this.index, i) : this.index + i;
/*  720 */       return k < this.array.length ? this.array[k] : Parser.Token.EOF;
/*      */     }
/*      */     Parser.Token next() {
/*  723 */       this.index = (this.preprocess ? preprocess(this.index, 1) : this.index + 1);
/*  724 */       return this.index < this.array.length ? this.array[this.index] : Parser.Token.EOF;
/*      */     }
/*      */   }
/*      */ 
/*      */   static class Tokenizer
/*      */     implements Closeable
/*      */   {
/*  408 */     File file = null;
/*  409 */     Reader reader = null;
/*  410 */     String lineSeparator = null;
/*  411 */     int lastChar = -1; int lineNumber = 1;
/*  412 */     StringBuilder buffer = new StringBuilder();
/*      */ 
/*      */     Tokenizer(Reader reader)
/*      */     {
/*  398 */       this.reader = reader;
/*      */     }
/*      */     Tokenizer(String string) {
/*  401 */       this.reader = new StringReader(string);
/*      */     }
/*      */     Tokenizer(File file) throws FileNotFoundException {
/*  404 */       this.file = file;
/*  405 */       this.reader = new BufferedReader(new FileReader(file));
/*      */     }
/*      */ 
/*      */     public void close()
/*      */       throws IOException
/*      */     {
/*  415 */       this.reader.close();
/*      */     }
/*      */ 
/*      */     int readChar() throws IOException {
/*  419 */       if (this.lastChar != -1) {
/*  420 */         int c = this.lastChar;
/*  421 */         this.lastChar = -1;
/*  422 */         return c;
/*      */       }
/*  424 */       int c = this.reader.read();
/*  425 */       if ((c == 13) || (c == 10)) {
/*  426 */         this.lineNumber += 1;
/*  427 */         int c2 = c == 13 ? this.reader.read() : -1;
/*  428 */         if (this.lineSeparator == null) {
/*  429 */           this.lineSeparator = (c == 13 ? "\r" : (c == 13) && (c2 == 10) ? "\r\n" : "\n");
/*      */         }
/*      */ 
/*  432 */         if (c2 != 10) {
/*  433 */           this.lastChar = c2;
/*      */         }
/*  435 */         c = 10;
/*      */       }
/*  437 */       return c;
/*      */     }
/*      */ 
/*      */     public Parser.Token nextToken() throws IOException {
/*  441 */       Parser.Token token = new Parser.Token();
/*  442 */       int c = readChar();
/*      */ 
/*  444 */       this.buffer.setLength(0);
/*  445 */       if (Character.isWhitespace(c)) {
/*  446 */         this.buffer.append((char)c);
/*  447 */         while (((c = readChar()) != -1) && (Character.isWhitespace(c))) {
/*  448 */           this.buffer.append((char)c);
/*      */         }
/*      */       }
/*  451 */       token.file = this.file;
/*  452 */       token.lineNumber = this.lineNumber;
/*  453 */       token.spacing = this.buffer.toString();
/*      */ 
/*  455 */       this.buffer.setLength(0);
/*  456 */       if ((Character.isLetter(c)) || (c == 95)) {
/*  457 */         token.type = 5;
/*  458 */         this.buffer.append((char)c);
/*  459 */         while (((c = readChar()) != -1) && ((Character.isDigit(c)) || (Character.isLetter(c)) || (c == 95))) {
/*  460 */           this.buffer.append((char)c);
/*      */         }
/*  462 */         token.value = this.buffer.toString();
/*  463 */         this.lastChar = c;
/*  464 */       } else if ((Character.isDigit(c)) || (c == 46) || (c == 45) || (c == 43)) {
/*  465 */         token.type = (c == 46 ? 2 : 1);
/*  466 */         this.buffer.append((char)c);
/*  467 */         int prevc = 0;
/*  468 */         boolean large = false; boolean unsigned = false; boolean hex = false;
/*  469 */         while (((c = readChar()) != -1) && ((Character.isDigit(c)) || (c == 46) || (c == 45) || (c == 43) || ((c >= 97) && (c <= 102)) || (c == 108) || (c == 117) || (c == 120) || ((c >= 65) && (c <= 70)) || (c == 76) || (c == 85) || (c == 88)))
/*      */         {
/*  472 */           switch (c) { case 46:
/*  473 */             token.type = 2; break;
/*      */           case 76:
/*      */           case 108:
/*  474 */             large = true; break;
/*      */           case 85:
/*      */           case 117:
/*  475 */             unsigned = true; break;
/*      */           case 88:
/*      */           case 120:
/*  476 */             hex = true;
/*      */           }
/*  478 */           if ((c != 108) && (c != 76) && (c != 117) && (c != 85)) {
/*  479 */             this.buffer.append((char)c);
/*      */           }
/*  481 */           prevc = c;
/*      */         }
/*  483 */         if ((!hex) && ((prevc == 102) || (prevc == 70))) {
/*  484 */           token.type = 2;
/*      */         }
/*  486 */         if ((token.type == 1) && ((large) || ((unsigned) && (!hex)))) {
/*  487 */           this.buffer.append('L');
/*      */         }
/*  489 */         token.value = this.buffer.toString();
/*  490 */         this.lastChar = c;
/*  491 */       } else if (c == 34) {
/*  492 */         token.type = 3;
/*  493 */         this.buffer.append('"');
/*  494 */         int prevc = 0;
/*  495 */         while (((c = readChar()) != -1) && ((prevc == 92) || (c != 34))) {
/*  496 */           this.buffer.append((char)c);
/*  497 */           prevc = c;
/*      */         }
/*  499 */         this.buffer.append('"');
/*  500 */         token.value = this.buffer.toString();
/*  501 */       } else if (c == 47) {
/*  502 */         c = readChar();
/*  503 */         if (c == 47) {
/*  504 */           token.type = 4;
/*  505 */           this.buffer.append('/').append('/');
/*  506 */           int prevc = 0;
/*  507 */           while (((c = readChar()) != -1) && ((prevc == 92) || (c != 10))) {
/*  508 */             this.buffer.append((char)c);
/*  509 */             prevc = c;
/*      */           }
/*  511 */           token.value = this.buffer.toString();
/*  512 */           this.lastChar = c;
/*  513 */         } else if (c == 42) {
/*  514 */           token.type = 4;
/*  515 */           this.buffer.append('/').append('*');
/*  516 */           int prevc = 0;
/*  517 */           while (((c = readChar()) != -1) && ((prevc != 42) || (c != 47))) {
/*  518 */             this.buffer.append((char)c);
/*  519 */             prevc = c;
/*      */           }
/*  521 */           this.buffer.append('/');
/*  522 */           token.value = this.buffer.toString();
/*      */         } else {
/*  524 */           this.lastChar = c;
/*  525 */           token.type = 47;
/*      */         }
/*  527 */       } else if (c == 58) {
/*  528 */         int c2 = readChar();
/*  529 */         if (c2 == 58) {
/*  530 */           token.type = 6;
/*  531 */           token.value = "::";
/*      */         } else {
/*  533 */           token.type = c;
/*  534 */           this.lastChar = c2;
/*      */         }
/*      */       } else {
/*  537 */         if (c == 92) {
/*  538 */           int c2 = readChar();
/*  539 */           if (c2 == 10) {
/*  540 */             token.type = 4;
/*  541 */             token.value = "\n";
/*  542 */             return token;
/*      */           }
/*  544 */           this.lastChar = c2;
/*      */         }
/*      */ 
/*  547 */         token.type = c;
/*      */       }
/*  549 */       return token;
/*      */     }
/*      */ 
/*      */     Parser.Token[] tokenize() {
/*  553 */       ArrayList tokens = new ArrayList();
/*      */       try
/*      */       {
/*      */         Parser.Token token;
/*  556 */         while (!(token = nextToken()).isEmpty())
/*  557 */           tokens.add(token);
/*      */       }
/*      */       catch (IOException ex) {
/*  560 */         throw new RuntimeException(ex);
/*      */       }
/*  562 */       return (Parser.Token[])tokens.toArray(new Parser.Token[tokens.size()]);
/*      */     }
/*      */   }
/*      */ 
/*      */   static class Token
/*      */     implements Cloneable, Comparable<Token>
/*      */   {
/*      */     static final int INTEGER = 1;
/*      */     static final int FLOAT = 2;
/*      */     static final int STRING = 3;
/*      */     static final int COMMENT = 4;
/*      */     static final int IDENTIFIER = 5;
/*      */     static final int SYMBOL = 6;
/*  301 */     static final Token EOF = new Token();
/*  302 */     static final Token CONST = new Token(5, "const");
/*  303 */     static final Token DEFINE = new Token(5, "define");
/*  304 */     static final Token IF = new Token(5, "if");
/*  305 */     static final Token IFDEF = new Token(5, "ifdef");
/*  306 */     static final Token IFNDEF = new Token(5, "ifndef");
/*  307 */     static final Token ELIF = new Token(5, "elif");
/*  308 */     static final Token ELSE = new Token(5, "else");
/*  309 */     static final Token ENDIF = new Token(5, "endif");
/*  310 */     static final Token ENUM = new Token(5, "enum");
/*  311 */     static final Token EXPLICIT = new Token(5, "explicit");
/*  312 */     static final Token EXTERN = new Token(5, "extern");
/*  313 */     static final Token FRIEND = new Token(5, "friend");
/*  314 */     static final Token INLINE = new Token(5, "inline");
/*  315 */     static final Token STATIC = new Token(5, "static");
/*  316 */     static final Token CLASS = new Token(5, "class");
/*  317 */     static final Token STRUCT = new Token(5, "struct");
/*  318 */     static final Token UNION = new Token(5, "union");
/*  319 */     static final Token TEMPLATE = new Token(5, "template");
/*  320 */     static final Token TYPEDEF = new Token(5, "typedef");
/*  321 */     static final Token TYPENAME = new Token(5, "typename");
/*  322 */     static final Token USING = new Token(5, "using");
/*  323 */     static final Token NAMESPACE = new Token(5, "namespace");
/*  324 */     static final Token OPERATOR = new Token(5, "operator");
/*  325 */     static final Token PRIVATE = new Token(5, "private");
/*  326 */     static final Token PROTECTED = new Token(5, "protected");
/*  327 */     static final Token PUBLIC = new Token(5, "public");
/*  328 */     static final Token VIRTUAL = new Token(5, "virtual");
/*      */ 
/*  330 */     File file = null;
/*  331 */     int lineNumber = 0; int type = -1;
/*  332 */     String spacing = ""; String value = "";
/*      */ 
/*      */     Token()
/*      */     {
/*      */     }
/*      */ 
/*      */     Token(int type, String value)
/*      */     {
/*  290 */       this.type = type; this.value = value;
/*      */     }
/*      */ 
/*      */     boolean match(Object[] tokens)
/*      */     {
/*  335 */       boolean found = false;
/*  336 */       for (Object t : tokens) {
/*  337 */         found = (found) || (equals(t));
/*      */       }
/*  339 */       return found;
/*      */     }
/*      */ 
/*      */     Token expect(Object[] tokens) throws Parser.Exception {
/*  343 */       if (!match(tokens)) {
/*  344 */         throw new Parser.Exception(this.file + ":" + this.lineNumber + ": Unexpected token '" + toString() + "'");
/*      */       }
/*  346 */       return this;
/*      */     }
/*      */ 
/*      */     boolean isEmpty() {
/*  350 */       return (this.type == -1) && (this.spacing.isEmpty());
/*      */     }
/*      */ 
/*      */     public Token clone() {
/*  354 */       Token t = new Token();
/*  355 */       t.file = this.file;
/*  356 */       t.lineNumber = this.lineNumber;
/*  357 */       t.type = this.type;
/*  358 */       t.spacing = this.spacing;
/*  359 */       t.value = this.value;
/*  360 */       return t;
/*      */     }
/*      */ 
/*      */     public boolean equals(Object obj) {
/*  364 */       if (obj == this)
/*  365 */         return true;
/*  366 */       if (obj == null)
/*  367 */         return false;
/*  368 */       if (obj.getClass() == Integer.class)
/*  369 */         return this.type == ((Integer)obj).intValue();
/*  370 */       if (obj.getClass() == Character.class)
/*  371 */         return this.type == ((Character)obj).charValue();
/*  372 */       if (obj.getClass() == String.class)
/*  373 */         return obj.equals(this.value);
/*  374 */       if (obj.getClass() == getClass()) {
/*  375 */         Token other = (Token)obj;
/*  376 */         return (this.type == other.type) && (((this.value == null) && (other.value == null)) || ((this.value != null) && (this.value.equals(other.value))));
/*      */       }
/*      */ 
/*  379 */       return false;
/*      */     }
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  384 */       return this.type;
/*      */     }
/*      */ 
/*      */     public String toString() {
/*  388 */       return (this.value != null) && (this.value.length() > 0) ? this.value : String.valueOf((char)this.type);
/*      */     }
/*      */ 
/*      */     public int compareTo(Token t) {
/*  392 */       return toString().compareTo(t.toString());
/*      */     }
/*      */   }
/*      */ 
/*      */   public static abstract interface InfoMapper
/*      */   {
/*      */     public abstract void map(Parser.InfoMap paramInfoMap);
/*      */   }
/*      */ 
/*      */   public static class InfoMap extends HashMap<String, LinkedList<Parser.Info>>
/*      */   {
/*  105 */     InfoMap parent = null;
/*  106 */     static final String[] simpleTypes = { "signed", "unsigned", "char", "short", "int", "long", "bool", "float", "double" };
/*      */ 
/*  108 */     static final InfoMap defaults = new InfoMap(null).put(new Parser.Info(new String[] { "void" }).valueTypes(new String[] { "void" }).pointerTypes(new String[] { "Pointer" })).put(new Parser.Info(new String[] { "FILE", "std::exception", "va_list" }).pointerTypes(new String[] { "Pointer" }).cast(true)).put(new Parser.Info(new String[] { "int8_t", "jbyte", "signed char" }).valueTypes(new String[] { "byte" }).pointerTypes(new String[] { "BytePointer", "ByteBuffer", "byte[]" })).put(new Parser.Info(new String[] { "uint8_t", "char", "unsigned char" }).valueTypes(new String[] { "byte" }).pointerTypes(new String[] { "BytePointer", "ByteBuffer", "byte[]" }).cast(true)).put(new Parser.Info(new String[] { "int16_t", "jshort", "short", "signed short", "short int", "signed short int" }).valueTypes(new String[] { "short" }).pointerTypes(new String[] { "ShortPointer", "ShortBuffer", "short[]" })).put(new Parser.Info(new String[] { "uint16_t", "unsigned short", "unsigned short int" }).valueTypes(new String[] { "short" }).pointerTypes(new String[] { "ShortPointer", "ShortBuffer", "short[]" }).cast(true)).put(new Parser.Info(new String[] { "int32_t", "jint", "int", "signed int", "signed" }).valueTypes(new String[] { "int" }).pointerTypes(new String[] { "IntPointer", "IntBuffer", "int[]" })).put(new Parser.Info(new String[] { "uint32_t", "unsigned int", "unsigned" }).valueTypes(new String[] { "int" }).pointerTypes(new String[] { "IntPointer", "IntBuffer", "int[]" }).cast(true)).put(new Parser.Info(new String[] { "int64_t", "__int64", "jlong", "long long", "signed long long", "long long int", "signed long long int" }).valueTypes(new String[] { "long" }).pointerTypes(new String[] { "LongPointer", "LongBuffer", "long[]" })).put(new Parser.Info(new String[] { "uint64_t", "__uint64", "unsigned long long", "unsigned long long int" }).valueTypes(new String[] { "long" }).pointerTypes(new String[] { "LongPointer", "LongBuffer", "long[]" }).cast(true)).put(new Parser.Info(new String[] { "long", "signed long", "long int", "signed long int" }).valueTypes(new String[] { "long" }).pointerTypes(new String[] { "CLongPointer" })).put(new Parser.Info(new String[] { "unsigned long", "unsigned long int" }).valueTypes(new String[] { "long" }).pointerTypes(new String[] { "CLongPointer" }).cast(true)).put(new Parser.Info(new String[] { "size_t" }).valueTypes(new String[] { "long" }).pointerTypes(new String[] { "SizeTPointer" }).cast(true)).put(new Parser.Info(new String[] { "float", "jfloat" }).valueTypes(new String[] { "float" }).pointerTypes(new String[] { "FloatPointer", "FloatBuffer", "float[]" })).put(new Parser.Info(new String[] { "double", "jdouble" }).valueTypes(new String[] { "double" }).pointerTypes(new String[] { "DoublePointer", "DoubleBuffer", "double[]" })).put(new Parser.Info(new String[] { "std::complex<float>" }).pointerTypes(new String[] { "FloatPointer", "FloatBuffer", "float[]" }).cast(true)).put(new Parser.Info(new String[] { "std::complex<double>" }).pointerTypes(new String[] { "DoublePointer", "DoubleBuffer", "double[]" }).cast(true)).put(new Parser.Info(new String[] { "bool", "jboolean" }).valueTypes(new String[] { "boolean" }).pointerTypes(new String[] { "BoolPointer" }).cast(true)).put(new Parser.Info(new String[] { "const char" }).valueTypes(new String[] { "byte" }).pointerTypes(new String[] { "@Cast(\"const char*\") BytePointer", "String" })).put(new Parser.Info(new String[] { "std::string" }).valueTypes(new String[] { "@StdString BytePointer", "@StdString String" })).put(new Parser.Info(new String[] { "wchar_t", "WCHAR" }).valueTypes(new String[] { "char" }).pointerTypes(new String[] { "CharPointer" }).cast(true)).put(new Parser.Info(new String[] { "operator->" }).javaNames(new String[] { "access" })).put(new Parser.Info(new String[] { "operator()" }).javaNames(new String[] { "apply" })).put(new Parser.Info(new String[] { "operator[]" }).javaNames(new String[] { "get" })).put(new Parser.Info(new String[] { "operator=" }).javaNames(new String[] { "put" })).put(new Parser.Info(new String[] { "operator+" }).javaNames(new String[] { "add" })).put(new Parser.Info(new String[] { "operator-" }).javaNames(new String[] { "subtract" })).put(new Parser.Info(new String[] { "operator*" }).javaNames(new String[] { "multiply" })).put(new Parser.Info(new String[] { "operator/" }).javaNames(new String[] { "divide" })).put(new Parser.Info(new String[] { "operator%" }).javaNames(new String[] { "mod" })).put(new Parser.Info(new String[] { "operator++" }).javaNames(new String[] { "increment" })).put(new Parser.Info(new String[] { "operator--" }).javaNames(new String[] { "decrement" })).put(new Parser.Info(new String[] { "operator==" }).javaNames(new String[] { "equals" })).put(new Parser.Info(new String[] { "operator!=" }).javaNames(new String[] { "notEquals" })).put(new Parser.Info(new String[] { "operator<" }).javaNames(new String[] { "lessThan" })).put(new Parser.Info(new String[] { "operator>" }).javaNames(new String[] { "greaterThan" })).put(new Parser.Info(new String[] { "operator<=" }).javaNames(new String[] { "lessThanEquals" })).put(new Parser.Info(new String[] { "operator>=" }).javaNames(new String[] { "greaterThanEquals" })).put(new Parser.Info(new String[] { "operator!" }).javaNames(new String[] { "not" })).put(new Parser.Info(new String[] { "operator&&" }).javaNames(new String[] { "and" })).put(new Parser.Info(new String[] { "operator||" }).javaNames(new String[] { "or" })).put(new Parser.Info(new String[] { "operator&" }).javaNames(new String[] { "and" })).put(new Parser.Info(new String[] { "operator|" }).javaNames(new String[] { "or" })).put(new Parser.Info(new String[] { "operator^" }).javaNames(new String[] { "xor" })).put(new Parser.Info(new String[] { "operator~" }).javaNames(new String[] { "not" })).put(new Parser.Info(new String[] { "operator<<" }).javaNames(new String[] { "shiftLeft" })).put(new Parser.Info(new String[] { "operator>>" }).javaNames(new String[] { "shiftRight" })).put(new Parser.Info(new String[] { "operator+=" }).javaNames(new String[] { "addPut" })).put(new Parser.Info(new String[] { "operator-=" }).javaNames(new String[] { "subtractPut" })).put(new Parser.Info(new String[] { "operator*=" }).javaNames(new String[] { "multiplyPut" })).put(new Parser.Info(new String[] { "operator/=" }).javaNames(new String[] { "dividePut" })).put(new Parser.Info(new String[] { "operator%=" }).javaNames(new String[] { "modPut" })).put(new Parser.Info(new String[] { "operator&=" }).javaNames(new String[] { "andPut" })).put(new Parser.Info(new String[] { "operator|=" }).javaNames(new String[] { "orPut" })).put(new Parser.Info(new String[] { "operator^=" }).javaNames(new String[] { "xorPut" })).put(new Parser.Info(new String[] { "operator<<=" }).javaNames(new String[] { "shiftLeftPut" })).put(new Parser.Info(new String[] { "operator>>=" }).javaNames(new String[] { "shiftRightPut" })).put(new Parser.Info(new String[] { "allocate" }).javaNames(new String[] { "_allocate" })).put(new Parser.Info(new String[] { "deallocate" }).javaNames(new String[] { "_deallocate" })).put(new Parser.Info(new String[] { "position" }).javaNames(new String[] { "_position" })).put(new Parser.Info(new String[] { "limit" }).javaNames(new String[] { "_limit" })).put(new Parser.Info(new String[] { "capacity" }).javaNames(new String[] { "_capacity" }));
/*      */ 
/*      */     public InfoMap()
/*      */     {
/*  102 */       this.parent = defaults; } 
/*  103 */     public InfoMap(InfoMap parent) { this.parent = parent; }
/*      */ 
/*      */ 
/*      */     static String sort(String name)
/*      */     {
/*  191 */       return sort(name, false);
/*      */     }
/*      */     static String sort(String name, boolean normalize) {
/*  194 */       if ((name == null) || (name.length() == 0)) {
/*  195 */         return name;
/*      */       }
/*  197 */       boolean foundConst = false; boolean simpleType = true;
/*  198 */       Parser.Token[] tokens = new Parser.Tokenizer(name).tokenize();
/*  199 */       int n = tokens.length;
/*  200 */       for (int i = 0; i < n; i++) {
/*  201 */         if (tokens[i].match(new Object[] { Parser.Token.CONST })) {
/*  202 */           foundConst = true;
/*  203 */           for (int j = i + 1; j < n; j++) {
/*  204 */             tokens[(j - 1)] = tokens[j];
/*      */           }
/*  206 */           i--; n--;
/*  207 */         } else if (Arrays.binarySearch(simpleTypes, tokens[i].value) < 0) {
/*  208 */           simpleType = false;
/*  209 */           break;
/*      */         }
/*      */       }
/*  212 */       if (simpleType) {
/*  213 */         Arrays.sort(tokens, 0, n);
/*  214 */         name = (foundConst ? "const " : "") + tokens[0].value;
/*  215 */         for (int i = 1; i < n; i++) {
/*  216 */           name = name + " " + tokens[i].value;
/*      */         }
/*      */       }
/*  219 */       if (normalize) {
/*  220 */         if (foundConst) {
/*  221 */           name = name.substring(name.indexOf("const") + 5);
/*      */         }
/*  223 */         int template = name.indexOf('<');
/*  224 */         if (template >= 0) {
/*  225 */           name = name.substring(0, template);
/*      */         }
/*      */       }
/*  228 */       return name.trim();
/*      */     }
/*      */ 
/*      */     public LinkedList<Parser.Info> get(String cppName) {
/*  232 */       String key = sort(cppName, false);
/*  233 */       LinkedList infoList = (LinkedList)super.get(key);
/*  234 */       if (infoList == null) {
/*  235 */         key = sort(cppName, true);
/*  236 */         infoList = (LinkedList)super.get(key);
/*      */       }
/*  238 */       if ((infoList == null) && (this.parent != null)) {
/*  239 */         infoList = this.parent.get(cppName);
/*      */       }
/*  241 */       if (infoList == null) {
/*  242 */         infoList = new LinkedList();
/*      */       }
/*  244 */       return infoList;
/*      */     }
/*      */ 
/*      */     public Parser.Info get(int index, String cppName) {
/*  248 */       LinkedList infoList = get(cppName);
/*  249 */       return infoList.size() > 0 ? (Parser.Info)infoList.get(index) : null;
/*      */     }
/*      */ 
/*      */     public Parser.Info getFirst(String cppName) {
/*  253 */       LinkedList infoList = get(cppName);
/*  254 */       return infoList.size() > 0 ? (Parser.Info)infoList.getFirst() : null;
/*      */     }
/*      */ 
/*      */     public InfoMap put(int index, Parser.Info info) {
/*  258 */       for (String cppName : new String[] { info.cppNames != null ? info.cppNames : null }) {
/*  259 */         String key = sort(cppName, false);
/*  260 */         LinkedList infoList = (LinkedList)super.get(key);
/*  261 */         if (infoList == null) {
/*  262 */           super.put(key, infoList = new LinkedList());
/*      */         }
/*  264 */         if (!infoList.contains(info)) {
/*  265 */           switch (index) { case -1:
/*  266 */             infoList.add(info); break;
/*      */           case 0:
/*  267 */             infoList.addFirst(info); break;
/*      */           default:
/*  268 */             infoList.add(index, info);
/*      */           }
/*      */         }
/*      */       }
/*  272 */       return this;
/*      */     }
/*      */ 
/*      */     public InfoMap put(Parser.Info info) {
/*  276 */       return put(-1, info);
/*      */     }
/*      */ 
/*      */     public InfoMap putFirst(Parser.Info info) {
/*  280 */       return put(0, info);
/*      */     }
/*      */ 
/*      */     static
/*      */     {
/*  107 */       Arrays.sort(simpleTypes);
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Info
/*      */     implements Cloneable
/*      */   {
/*   57 */     String[] cppNames = null; String[] javaNames = null; String[] annotations = null; String[] valueTypes = null; String[] pointerTypes = null; String[] genericArgs = null; String[] macroParams = null; String[] templateParams = null;
/*      */ 
/*   59 */     boolean cast = false; boolean define = false; boolean translate = false; boolean complete = false; boolean parse = false; boolean skip = false;
/*   60 */     String parent = null; String text = null;
/*      */ 
/*      */     public Info()
/*      */     {
/*      */     }
/*      */ 
/*      */     public Info(String[] cppNames)
/*      */     {
/*   55 */       this.cppNames = cppNames;
/*      */     }
/*      */ 
/*      */     public Info cppNames(String[] cppNames)
/*      */     {
/*   62 */       this.cppNames = cppNames; return this; } 
/*   63 */     public Info javaNames(String[] javaNames) { this.javaNames = javaNames; return this; } 
/*   64 */     public Info annotations(String[] annotations) { this.annotations = annotations; return this; } 
/*   65 */     public Info valueTypes(String[] valueTypes) { this.valueTypes = valueTypes; return this; } 
/*   66 */     public Info pointerTypes(String[] pointerTypes) { this.pointerTypes = pointerTypes; return this; } 
/*   67 */     public Info genericArgs(String[] genericArgs) { this.genericArgs = genericArgs; return this; } 
/*   68 */     public Info macroParams(String[] macroParams) { this.macroParams = macroParams; return this; } 
/*   69 */     public Info templateParams(String[] templateParams) { this.templateParams = templateParams; return this; } 
/*   70 */     public Info cast(boolean cast) { this.cast = cast; return this; } 
/*   71 */     public Info define(boolean define) { this.define = define; return this; } 
/*   72 */     public Info translate(boolean translate) { this.translate = translate; return this; } 
/*   73 */     public Info complete(boolean complete) { this.complete = complete; return this; } 
/*   74 */     public Info parse(boolean parse) { this.parse = parse; return this; } 
/*   75 */     public Info skip(boolean skip) { this.skip = skip; return this; } 
/*   76 */     public Info parent(String parent) { this.parent = parent; return this; } 
/*   77 */     public Info text(String text) { this.text = text; return this; }
/*      */ 
/*      */     public Info clone() {
/*   80 */       Info i = new Info();
/*   81 */       i.cppNames = (this.cppNames != null ? (String[])this.cppNames.clone() : null);
/*   82 */       i.javaNames = (this.javaNames != null ? (String[])this.javaNames.clone() : null);
/*   83 */       i.annotations = (this.annotations != null ? (String[])this.annotations.clone() : null);
/*   84 */       i.valueTypes = (this.valueTypes != null ? (String[])this.valueTypes.clone() : null);
/*   85 */       i.pointerTypes = (this.pointerTypes != null ? (String[])this.pointerTypes.clone() : null);
/*   86 */       i.genericArgs = (this.genericArgs != null ? (String[])this.genericArgs.clone() : null);
/*   87 */       i.macroParams = (this.macroParams != null ? (String[])this.macroParams.clone() : null);
/*   88 */       i.templateParams = (this.templateParams != null ? (String[])this.templateParams.clone() : null);
/*   89 */       i.cast = this.cast;
/*   90 */       i.define = this.define;
/*   91 */       i.translate = this.translate;
/*   92 */       i.complete = this.complete;
/*   93 */       i.parse = this.parse;
/*   94 */       i.skip = this.skip;
/*   95 */       i.parent = this.parent;
/*   96 */       i.text = this.text;
/*   97 */       return i;
/*      */     }
/*      */   }
/*      */ 
/*      */   public static class Exception extends Exception
/*      */   {
/*      */     public Exception(String message)
/*      */     {
/*   49 */       super(); } 
/*   50 */     public Exception(String message, Throwable cause) { super(cause); }
/*      */ 
/*      */   }
/*      */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.Parser
 * JD-Core Version:    0.6.2
 */