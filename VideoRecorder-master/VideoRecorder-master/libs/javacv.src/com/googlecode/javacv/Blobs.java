/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvMat;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class Blobs
/*     */ {
/*  68 */   static int BLOBROWCOUNT = 3500;
/*  69 */   static int BLOBCOLCOUNT = 2700;
/*     */ 
/*  72 */   static int BLOBTOTALCOUNT = (BLOBROWCOUNT + BLOBCOLCOUNT) * 5;
/*     */ 
/*  76 */   public static int BLOBLABEL = 0;
/*  77 */   public static int BLOBPARENT = 1;
/*  78 */   public static int BLOBCOLOR = 2;
/*  79 */   public static int BLOBAREA = 3;
/*  80 */   public static int BLOBPERIMETER = 4;
/*  81 */   public static int BLOBSUMX = 5;
/*  82 */   public static int BLOBSUMY = 6;
/*  83 */   public static int BLOBSUMXX = 7;
/*  84 */   public static int BLOBSUMYY = 8;
/*  85 */   public static int BLOBSUMXY = 9;
/*  86 */   public static int BLOBMINX = 10;
/*  87 */   public static int BLOBMAXX = 11;
/*  88 */   public static int BLOBMINY = 12;
/*  89 */   public static int BLOBMAXY = 13;
/*  90 */   public static int BLOBDATACOUNT = 14;
/*     */ 
/*  92 */   public static int[][] LabelMat = new int[BLOBROWCOUNT][BLOBCOLCOUNT];
/*  93 */   public static double[][] RegionData = new double[BLOBTOTALCOUNT][BLOBDATACOUNT];
/*     */   public static int MaxLabel;
/*     */   public int LabelA;
/*     */   public int LabelB;
/*     */   public int LabelC;
/*     */   public int LabelD;
/*     */   public int ColorA;
/*     */   public int ColorB;
/*     */   public int ColorC;
/*     */   public int ColorD;
/*     */   public int jrow;
/*     */   public int jcol;
/*  99 */   public static int[] SubsumedLabel = new int[BLOBTOTALCOUNT];
/* 100 */   public static int[] CondensationMap = new int[BLOBTOTALCOUNT];
/*     */   static double iField;
/*     */   static double jField;
/*     */   static double[] iProperty;
/*     */   static double[] jProperty;
/*     */ 
/*     */   public void PrintRegionData()
/*     */   {
/* 103 */     PrintRegionData(0, MaxLabel);
/*     */   }
/*     */   public void PrintRegionData(int Label0, int Label1) {
/* 106 */     if (Label0 < 0) Label0 = 0;
/* 107 */     if (Label1 > MaxLabel) Label1 = MaxLabel;
/* 108 */     if (Label1 < Label0) return;
/* 109 */     for (int Label = Label0; Label <= Label1; Label++)
/*     */     {
/* 111 */       double[] Property = RegionData[Label];
/*     */ 
/* 113 */       int ThisLabel = (int)Property[BLOBLABEL];
/* 114 */       int ThisParent = (int)Property[BLOBPARENT];
/* 115 */       int ThisColor = (int)Property[BLOBCOLOR];
/* 116 */       double ThisArea = Property[BLOBAREA];
/* 117 */       double ThisPerimeter = Property[BLOBPERIMETER];
/* 118 */       double ThisSumX = Property[BLOBSUMX];
/* 119 */       double ThisSumY = Property[BLOBSUMY];
/* 120 */       double ThisSumXX = Property[BLOBSUMXX];
/* 121 */       double ThisSumYY = Property[BLOBSUMYY];
/* 122 */       double ThisSumXY = Property[BLOBSUMXY];
/* 123 */       int ThisMinX = (int)Property[BLOBMINX];
/* 124 */       int ThisMaxX = (int)Property[BLOBMAXX];
/* 125 */       int ThisMinY = (int)Property[BLOBMINY];
/* 126 */       int ThisMaxY = (int)Property[BLOBMAXY];
/*     */ 
/* 128 */       String Str1 = " " + Label + ": L[" + ThisLabel + "] P[" + ThisParent + "] C[" + ThisColor + "]";
/* 129 */       String Str2 = " AP[" + ThisArea + ", " + ThisPerimeter + "]";
/* 130 */       String Str3 = " M1[" + ThisSumX + ", " + ThisSumY + "] M2[" + ThisSumXX + ", " + ThisSumYY + ", " + ThisSumXY + "]";
/* 131 */       String Str4 = " MINMAX[" + ThisMinX + ", " + ThisMaxX + ", " + ThisMinY + ", " + ThisMaxY + "]";
/*     */ 
/* 133 */       String Str = Str1 + Str2 + Str3 + Str4;
/* 134 */       System.out.println(Str);
/*     */     }
/* 136 */     System.out.println();
/*     */   }
/*     */ 
/*     */   public static int NextRegion(int Parent, int Color, double MinArea, double MaxArea, int Label)
/*     */   {
/* 142 */     double DParent = Parent;
/* 143 */     double DColor = Color; if (DColor > 0.0D) DColor = 1.0D;
/*     */ 
/* 146 */     for (int i = Label; i <= MaxLabel; i++)
/*     */     {
/* 148 */       double[] Region = RegionData[i];
/* 149 */       double ThisParent = Region[BLOBPARENT];
/* 150 */       double ThisColor = Region[BLOBCOLOR];
/* 151 */       if (((DParent < 0.0D) || (DParent == ThisParent)) && 
/* 152 */         ((DColor < 0.0D) || (DColor == ThisColor)) && 
/* 153 */         (Region[BLOBAREA] >= MinArea)) if (Region[BLOBAREA] <= MaxArea)
/*     */           break;
/*     */     }
/* 156 */     if (i > MaxLabel) i = -1;
/* 157 */     return i;
/*     */   }
/*     */ 
/*     */   public static int PriorRegion(int Parent, int Color, double MinArea, double MaxArea, int Label)
/*     */   {
/* 163 */     double DParent = Parent;
/* 164 */     double DColor = Color; if (DColor > 0.0D) DColor = 1.0D;
/*     */ 
/* 167 */     for (int i = Label; i >= 0; i--)
/*     */     {
/* 169 */       double[] Region = RegionData[i];
/* 170 */       double ThisParent = Region[BLOBPARENT];
/* 171 */       double ThisColor = Region[BLOBCOLOR];
/* 172 */       if (((DParent < 0.0D) || (DParent == ThisParent)) && 
/* 173 */         ((DColor < 0.0D) || (DColor == ThisColor)) && 
/* 174 */         (Region[BLOBAREA] >= MinArea)) if (Region[BLOBAREA] <= MaxArea)
/*     */           break;
/*     */     }
/* 177 */     if (i < 0) i = -1;
/* 178 */     return i;
/*     */   }
/*     */ 
/*     */   public void ResetRegion(int Label)
/*     */   {
/* 183 */     double[] RegionD = RegionData[Label];
/*     */     double tmp87_86 = (RegionD[BLOBCOLOR] = RegionD[BLOBAREA] = RegionD[BLOBPERIMETER] = RegionD[BLOBSUMX] = RegionD[BLOBSUMY] = RegionD[BLOBSUMXX] = RegionD[BLOBSUMYY] = RegionD[BLOBSUMXY] = RegionD[BLOBMINX] = RegionD[BLOBMAXX] = RegionD[BLOBMINY] = RegionD[BLOBMAXY] = 0.0D); RegionD[BLOBPARENT] = tmp87_86; RegionD[BLOBLABEL] = tmp87_86;
/*     */ 
/* 198 */     System.arraycopy(RegionD, 0, RegionData[Label], 0, BLOBDATACOUNT);
/*     */   }
/*     */ 
/*     */   public void OldRegion(int NewLabelD, int Label1, int Label2)
/*     */   {
/* 206 */     int DeltaPerimeter = 0;
/*     */ 
/* 208 */     if ((Label1 >= 0) && (Label1 != NewLabelD))
/*     */     {
/* 210 */       DeltaPerimeter++;
/* 211 */       double[] Region1 = RegionData[Label1];
/* 212 */       Region1[BLOBPERIMETER] += 1.0D;
/* 213 */       System.arraycopy(Region1, 0, RegionData[Label1], 0, BLOBDATACOUNT);
/*     */     }
/*     */ 
/* 216 */     if ((Label2 >= 0) && (Label2 != NewLabelD))
/*     */     {
/* 218 */       DeltaPerimeter++;
/* 219 */       double[] Region2 = RegionData[Label2];
/* 220 */       Region2[BLOBPERIMETER] += 1.0D;
/* 221 */       System.arraycopy(Region2, 0, RegionData[Label2], 0, BLOBDATACOUNT);
/*     */     }
/*     */ 
/* 224 */     this.LabelD = NewLabelD;
/* 225 */     double[] RegionD = RegionData[this.LabelD];
/* 226 */     RegionD[BLOBLABEL] = this.LabelD;
/* 227 */     RegionD[BLOBPARENT] += 0.0D;
/* 228 */     RegionD[BLOBCOLOR] += 0.0D;
/* 229 */     RegionD[BLOBAREA] += 1.0D;
/* 230 */     RegionD[BLOBPERIMETER] += DeltaPerimeter;
/* 231 */     RegionD[BLOBSUMX] += this.jcol;
/* 232 */     RegionD[BLOBSUMY] += this.jrow;
/* 233 */     RegionD[BLOBSUMXX] += this.jcol * this.jcol;
/* 234 */     RegionD[BLOBSUMYY] += this.jrow * this.jrow;
/* 235 */     RegionD[BLOBSUMXY] += this.jcol * this.jrow;
/* 236 */     RegionD[BLOBMINX] = Math.min(RegionD[BLOBMINX], this.jcol);
/* 237 */     RegionD[BLOBMAXX] = Math.max(RegionD[BLOBMAXX], this.jcol);
/* 238 */     RegionD[BLOBMINY] = Math.min(RegionD[BLOBMINY], this.jrow);
/* 239 */     RegionD[BLOBMAXY] = Math.max(RegionD[BLOBMAXY], this.jrow);
/* 240 */     System.arraycopy(RegionD, 0, RegionData[this.LabelD], 0, BLOBDATACOUNT);
/*     */   }
/*     */ 
/*     */   public void NewRegion(int ParentLabel)
/*     */   {
/* 245 */     this.LabelD = (++MaxLabel);
/* 246 */     double[] RegionD = RegionData[this.LabelD];
/* 247 */     RegionD[BLOBLABEL] = this.LabelD;
/* 248 */     RegionD[BLOBPARENT] = ParentLabel;
/* 249 */     RegionD[BLOBCOLOR] = this.ColorD;
/* 250 */     RegionD[BLOBAREA] = 1.0D;
/* 251 */     RegionD[BLOBPERIMETER] = 2.0D;
/* 252 */     RegionD[BLOBSUMX] = this.jcol;
/* 253 */     RegionD[BLOBSUMY] = this.jrow;
/* 254 */     RegionD[BLOBSUMXX] = (this.jcol * this.jcol);
/* 255 */     RegionD[BLOBSUMYY] = (this.jrow * this.jrow);
/* 256 */     RegionD[BLOBSUMXY] = (this.jcol * this.jrow);
/* 257 */     RegionD[BLOBMINX] = this.jcol;
/* 258 */     RegionD[BLOBMAXX] = this.jcol;
/* 259 */     RegionD[BLOBMINY] = this.jrow;
/* 260 */     RegionD[BLOBMAXY] = this.jrow;
/*     */ 
/* 262 */     System.arraycopy(RegionD, 0, RegionData[this.LabelD], 0, BLOBDATACOUNT);
/* 263 */     SubsumedLabel[this.LabelD] = -1;
/*     */ 
/* 265 */     double[] RegionB = RegionData[this.LabelB];
/* 266 */     RegionB[BLOBPERIMETER] += 1.0D;
/* 267 */     System.arraycopy(RegionB, 0, RegionData[this.LabelB], 0, BLOBDATACOUNT);
/*     */ 
/* 269 */     double[] RegionC = RegionData[this.LabelC];
/* 270 */     RegionC[BLOBPERIMETER] += 1.0D;
/*     */ 
/* 272 */     System.arraycopy(RegionC, 0, RegionData[this.LabelC], 0, BLOBDATACOUNT);
/*     */   }
/*     */ 
/*     */   public void Subsume(int GoodLabel, int BadLabel, int PSign)
/*     */   {
/* 277 */     this.LabelD = GoodLabel;
/* 278 */     double[] GoodRegion = RegionData[GoodLabel];
/* 279 */     double[] BadRegion = RegionData[BadLabel];
/*     */ 
/* 281 */     GoodRegion[BLOBLABEL] = GoodRegion[BLOBLABEL];
/* 282 */     GoodRegion[BLOBPARENT] = GoodRegion[BLOBPARENT];
/* 283 */     GoodRegion[BLOBCOLOR] = GoodRegion[BLOBCOLOR];
/* 284 */     GoodRegion[BLOBAREA] += BadRegion[BLOBAREA];
/* 285 */     GoodRegion[BLOBPERIMETER] += BadRegion[BLOBPERIMETER] * PSign;
/* 286 */     GoodRegion[BLOBSUMX] += BadRegion[BLOBSUMX];
/* 287 */     GoodRegion[BLOBSUMY] += BadRegion[BLOBSUMY];
/* 288 */     GoodRegion[BLOBSUMXX] += BadRegion[BLOBSUMXX];
/* 289 */     GoodRegion[BLOBSUMYY] += BadRegion[BLOBSUMYY];
/* 290 */     GoodRegion[BLOBSUMXY] += BadRegion[BLOBSUMXY];
/* 291 */     GoodRegion[BLOBMINX] = Math.min(GoodRegion[BLOBMINX], BadRegion[BLOBMINX]);
/* 292 */     GoodRegion[BLOBMAXX] = Math.max(GoodRegion[BLOBMAXX], BadRegion[BLOBMAXX]);
/* 293 */     GoodRegion[BLOBMINY] = Math.min(GoodRegion[BLOBMINY], BadRegion[BLOBMINY]);
/* 294 */     GoodRegion[BLOBMAXY] = Math.max(GoodRegion[BLOBMAXY], BadRegion[BLOBMAXY]);
/*     */ 
/* 296 */     System.arraycopy(GoodRegion, 0, RegionData[GoodLabel], 0, BLOBDATACOUNT);
/*     */   }
/*     */   public static int SubsumptionChain(int x) {
/* 299 */     return SubsumptionChain(x, 0);
/*     */   }
/*     */   public static int SubsumptionChain(int x, int Print) {
/* 302 */     String Str = "";
/* 303 */     if (Print > 0) Str = "Subsumption chain for " + x + ": ";
/* 304 */     int Lastx = x;
/* 305 */     while (x > -1)
/*     */     {
/* 307 */       Lastx = x;
/* 308 */       if (Print > 0) Str = Str + " " + x;
/* 309 */       if (x == 0) break;
/* 310 */       x = SubsumedLabel[x];
/*     */     }
/* 312 */     if (Print > 0) System.out.println(Str);
/* 313 */     return Lastx;
/*     */   }
/*     */ 
/*     */   public int BlobAnalysis(opencv_core.IplImage Src, int Col0, int Row0, int Cols, int Rows, int Border, int MinArea)
/*     */   {
/* 327 */     opencv_core.CvMat SrcMat = Src.asCvMat();
/* 328 */     int SrcCols = SrcMat.cols();
/* 329 */     int SrcRows = SrcMat.rows();
/*     */ 
/* 331 */     if (Col0 < 0) Col0 = 0;
/* 332 */     if (Row0 < 0) Row0 = 0;
/* 333 */     if (Cols < 0) Cols = SrcCols;
/* 334 */     if (Rows < 0) Rows = SrcRows;
/* 335 */     if (Col0 + Cols > SrcCols) Cols = SrcCols - Col0;
/* 336 */     if (Row0 + Rows > SrcRows) Rows = SrcRows - Row0;
/*     */ 
/* 338 */     if ((Cols > BLOBCOLCOUNT) || (Rows > BLOBROWCOUNT))
/*     */     {
/* 340 */       System.out.println("Error in Class Blobs: Image too large: Edit Blobs.java");
/* 341 */       System.exit(666);
/* 342 */       return 0;
/*     */     }
/*     */ 
/* 346 */     int FillLabel = 0;
/* 347 */     int FillColor = 0; if (Border > 0) FillColor = 1;
/* 348 */     this.LabelA = (this.LabelB = this.LabelC = this.LabelD = 0);
/* 349 */     this.ColorA = (this.ColorB = this.ColorC = this.ColorD = FillColor);
/* 350 */     for (int k = 0; k < BLOBTOTALCOUNT; k++) SubsumedLabel[k] = -1;
/*     */ 
/* 353 */     MaxLabel = 0;
/* 354 */     double[] BorderRegion = RegionData[0];
/* 355 */     BorderRegion[BLOBLABEL] = 0.0D;
/* 356 */     BorderRegion[BLOBPARENT] = -1.0D;
/* 357 */     BorderRegion[BLOBAREA] = (Rows + Cols + 4);
/* 358 */     BorderRegion[BLOBCOLOR] = FillColor;
/* 359 */     BorderRegion[BLOBSUMX] = (0.5D * ((2.0D + Cols) * (Cols - 1.0D)) - Rows - 1.0D);
/* 360 */     BorderRegion[BLOBSUMY] = (0.5D * ((2.0D + Rows) * (Rows - 1.0D)) - Cols - 1.0D);
/* 361 */     BorderRegion[BLOBMINX] = -1.0D;
/* 362 */     BorderRegion[BLOBMINY] = -1.0D;
/* 363 */     BorderRegion[BLOBMAXX] = (Cols + 1.0D);
/* 364 */     BorderRegion[BLOBMAXY] = (Rows + 1.0D);
/* 365 */     System.arraycopy(BorderRegion, 0, RegionData[0], 0, BLOBDATACOUNT);
/*     */ 
/* 393 */     for (int irow = Row0; irow < Row0 + Rows; irow++)
/*     */     {
/* 395 */       this.jrow = (irow - Row0);
/*     */ 
/* 398 */       for (int icol = Col0; icol < Col0 + Cols; icol++)
/*     */       {
/* 400 */         this.jcol = (icol - Col0);
/*     */ 
/* 403 */         this.ColorA = (this.ColorB = this.ColorC = FillColor);
/* 404 */         this.LabelA = (this.LabelB = this.LabelC = this.LabelD = 0);
/* 405 */         this.ColorD = ((int)SrcMat.get(this.jrow, this.jcol));
/*     */ 
/* 407 */         if ((this.jrow == 0) || (this.jcol == 0))
/*     */         {
/* 409 */           if (this.jcol > 0)
/*     */           {
/* 411 */             this.ColorC = ((int)SrcMat.get(this.jrow, this.jcol - 1));
/* 412 */             this.LabelC = LabelMat[this.jrow][(this.jcol - 1)];
/*     */           }
/* 414 */           if (this.jrow > 0)
/*     */           {
/* 416 */             this.ColorB = ((int)SrcMat.get(this.jrow - 1, this.jcol));
/* 417 */             this.LabelB = LabelMat[(this.jrow - 1)][this.jcol];
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 422 */           this.ColorA = ((int)SrcMat.get(this.jrow - 1, this.jcol - 1)); if (this.ColorA > 0) this.ColorA = 1;
/* 423 */           this.ColorB = ((int)SrcMat.get(this.jrow - 1, this.jcol)); if (this.ColorB > 0) this.ColorB = 1;
/* 424 */           this.ColorC = ((int)SrcMat.get(this.jrow, this.jcol - 1)); if (this.ColorC > 0) this.ColorC = 1;
/* 425 */           this.LabelA = LabelMat[(this.jrow - 1)][(this.jcol - 1)];
/* 426 */           this.LabelB = LabelMat[(this.jrow - 1)][this.jcol];
/* 427 */           this.LabelC = LabelMat[this.jrow][(this.jcol - 1)];
/*     */         }
/* 429 */         if (this.ColorA > 0) this.ColorA = 1;
/* 430 */         if (this.ColorB > 0) this.ColorB = 1;
/* 431 */         if (this.ColorC > 0) this.ColorC = 1;
/* 432 */         if (this.ColorD > 0) this.ColorD = 1;
/*     */ 
/* 435 */         int Case = 0;
/* 436 */         if (this.ColorA == this.ColorB)
/*     */         {
/* 438 */           if (this.ColorC == this.ColorD) { if (this.ColorA == this.ColorC) Case = 1; else Case = 2; 
/*     */           }
/* 439 */           else if (this.ColorA == this.ColorC) Case = 5; else Case = 6;
/*     */ 
/*     */         }
/* 443 */         else if (this.ColorC == this.ColorD) { if (this.ColorA == this.ColorC) Case = 3; else Case = 4; 
/*     */         }
/* 444 */         else if (this.ColorA == this.ColorC) Case = 7; else Case = 8;
/*     */ 
/* 448 */         if (Case == 1) { OldRegion(this.LabelC, -1, -1);
/* 449 */         } else if ((Case == 2) || (Case == 3)) { OldRegion(this.LabelC, this.LabelB, this.LabelC);
/* 450 */         } else if ((Case == 5) || (Case == 8))
/*     */         {
/* 452 */           if (((this.jrow == Rows) || (this.jcol == Cols)) && (this.ColorD == FillColor)) OldRegion(0, -1, -1); else
/* 453 */             NewRegion(this.LabelB);
/*     */         }
/* 455 */         else if ((Case == 6) || (Case == 7)) { OldRegion(this.LabelB, this.LabelB, this.LabelC);
/*     */         } else
/*     */         {
/* 458 */           int LabelBRoot = SubsumptionChain(this.LabelB);
/* 459 */           int LabelCRoot = SubsumptionChain(this.LabelC);
/* 460 */           int LabelRoot = Math.min(LabelBRoot, LabelCRoot);
/*     */           int LabelX;
/*     */           int LabelX;
/* 462 */           if (LabelBRoot < LabelCRoot) { OldRegion(this.LabelB, -1, -1); LabelX = this.LabelC; } else {
/* 463 */             OldRegion(this.LabelC, -1, -1); LabelX = this.LabelB;
/* 464 */           }int NextLabelX = LabelX;
/* 465 */           while (LabelRoot < LabelX)
/*     */           {
/* 467 */             NextLabelX = SubsumedLabel[LabelX];
/* 468 */             SubsumedLabel[LabelX] = LabelRoot;
/* 469 */             LabelX = NextLabelX;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 474 */         if (((this.jrow == Rows) || (this.jcol == Cols)) && (this.ColorD == FillColor))
/*     */         {
/* 476 */           if (this.jcol < Cols)
/*     */           {
/* 478 */             if (this.ColorC != FillColor)
/*     */             {
/* 480 */               int LabelRoot = SubsumptionChain(this.LabelB);
/* 481 */               SubsumedLabel[LabelRoot] = 0;
/*     */             }
/*     */           }
/* 484 */           else if (this.jrow < Rows)
/*     */           {
/* 486 */             if (this.ColorB != FillColor)
/*     */             {
/* 488 */               int LabelRoot = SubsumptionChain(this.LabelC);
/* 489 */               SubsumedLabel[LabelRoot] = 0;
/*     */             }
/*     */           }
/* 492 */           OldRegion(0, -1, -1);
/*     */         }
/*     */ 
/* 495 */         LabelMat[this.jrow][this.jcol] = this.LabelD;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 501 */     int Offset = 0;
/* 502 */     for (int Label = 1; Label <= MaxLabel; Label++)
/*     */     {
/* 504 */       if (SubsumedLabel[Label] > -1) Offset++;
/* 505 */       CondensationMap[Label] = (Label - Offset);
/*     */     }
/*     */ 
/* 509 */     for (int Label = 1; Label <= MaxLabel; Label++)
/*     */     {
/* 511 */       int BetterLabel = SubsumptionChain(Label);
/* 512 */       if (BetterLabel != Label) Subsume(BetterLabel, Label, 1);
/*     */ 
/*     */     }
/*     */ 
/* 516 */     int NewMaxLabel = 0;
/* 517 */     for (int OldLabel = 1; OldLabel <= MaxLabel; OldLabel++)
/*     */     {
/* 519 */       if (SubsumedLabel[OldLabel] < 0)
/*     */       {
/* 521 */         double[] OldRegion = RegionData[OldLabel];
/* 522 */         int OldParent = (int)OldRegion[BLOBPARENT];
/* 523 */         int NewLabel = CondensationMap[OldLabel];
/* 524 */         int NewParent = SubsumptionChain(OldParent);
/* 525 */         NewParent = CondensationMap[NewParent];
/* 526 */         OldRegion[BLOBLABEL] = NewLabel;
/* 527 */         OldRegion[BLOBPARENT] = NewParent;
/* 528 */         System.arraycopy(OldRegion, 0, RegionData[NewLabel], 0, BLOBDATACOUNT);
/* 529 */         NewMaxLabel = NewLabel;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 534 */     for (int Label = NewMaxLabel + 1; Label <= MaxLabel; Label++) ResetRegion(Label);
/* 535 */     MaxLabel = NewMaxLabel;
/*     */ 
/* 538 */     for (int Label = MaxLabel; Label > 0; Label--)
/*     */     {
/* 540 */       double[] ThisRegion = RegionData[Label];
/* 541 */       int ThisArea = (int)ThisRegion[BLOBAREA];
/* 542 */       if (ThisArea < MinArea)
/*     */       {
/* 544 */         int ThisParent = (int)ThisRegion[BLOBPARENT];
/* 545 */         SubsumedLabel[Label] = ThisParent;
/*     */       } else {
/* 547 */         SubsumedLabel[Label] = -1;
/*     */       }
/*     */     }
/*     */ 
/* 551 */     Offset = 0;
/* 552 */     for (int Label = 1; Label <= MaxLabel; Label++)
/*     */     {
/* 554 */       if (SubsumedLabel[Label] > -1) Offset++;
/* 555 */       CondensationMap[Label] = (Label - Offset);
/*     */     }
/*     */ 
/* 559 */     for (int Label = 1; Label <= MaxLabel; Label++)
/*     */     {
/* 561 */       int BetterLabel = SubsumptionChain(Label);
/* 562 */       if (BetterLabel != Label) Subsume(BetterLabel, Label, -1);
/*     */ 
/*     */     }
/*     */ 
/* 566 */     for (int OldLabel = 1; OldLabel <= MaxLabel; OldLabel++)
/*     */     {
/* 568 */       if (SubsumedLabel[OldLabel] < 0)
/*     */       {
/* 570 */         double[] OldRegion = RegionData[OldLabel];
/* 571 */         int OldParent = (int)OldRegion[BLOBPARENT];
/* 572 */         int NewLabel = CondensationMap[OldLabel];
/* 573 */         int NewParent = SubsumptionChain(OldParent);
/* 574 */         NewParent = CondensationMap[NewParent];
/* 575 */         OldRegion[BLOBLABEL] = NewLabel;
/* 576 */         OldRegion[BLOBPARENT] = NewParent;
/* 577 */         System.arraycopy(OldRegion, 0, RegionData[NewLabel], 0, BLOBDATACOUNT);
/* 578 */         NewMaxLabel = NewLabel;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 583 */     for (int Label = NewMaxLabel + 1; Label <= MaxLabel; Label++) ResetRegion(Label);
/* 584 */     MaxLabel = NewMaxLabel;
/*     */ 
/* 587 */     for (int Label = 0; Label <= MaxLabel; Label++)
/*     */     {
/* 589 */       double[] ThisRegion = RegionData[Label];
/*     */ 
/* 592 */       double Area = ThisRegion[BLOBAREA];
/* 593 */       double SumX = ThisRegion[BLOBSUMX];
/* 594 */       double SumY = ThisRegion[BLOBSUMY];
/* 595 */       double SumXX = ThisRegion[BLOBSUMXX];
/* 596 */       double SumYY = ThisRegion[BLOBSUMYY];
/* 597 */       double SumXY = ThisRegion[BLOBSUMXY];
/*     */ 
/* 600 */       SumX /= Area;
/* 601 */       SumY /= Area;
/* 602 */       SumXX /= Area;
/* 603 */       SumYY /= Area;
/* 604 */       SumXY /= Area;
/*     */ 
/* 607 */       SumXX -= SumX * SumX;
/* 608 */       SumYY -= SumY * SumY;
/* 609 */       SumXY -= SumX * SumY;
/* 610 */       if ((SumXY > -1.0E-014D) && (SumXY < 1.0E-014D)) SumXY = 0.0D;
/*     */ 
/* 612 */       ThisRegion[BLOBSUMX] = SumX;
/* 613 */       ThisRegion[BLOBSUMY] = SumY;
/* 614 */       ThisRegion[BLOBSUMXX] = SumXX;
/* 615 */       ThisRegion[BLOBSUMYY] = SumYY;
/* 616 */       ThisRegion[BLOBSUMXY] = SumXY;
/*     */ 
/* 618 */       System.arraycopy(ThisRegion, 0, RegionData[Label], 0, BLOBDATACOUNT);
/*     */     }
/*     */ 
/* 622 */     BorderRegion = RegionData[0];
/*     */     double tmp2019_2018 = (BorderRegion[BLOBSUMXY] = 0.0D); BorderRegion[BLOBSUMYY] = tmp2019_2018; BorderRegion[BLOBSUMXX] = tmp2019_2018;
/* 624 */     System.arraycopy(BorderRegion, 0, RegionData[0], 0, BLOBDATACOUNT);
/*     */ 
/* 626 */     return MaxLabel;
/*     */   }
/*     */ 
/*     */   public static void SortRegions(int Col)
/*     */   {
/* 634 */     for (int i = 0; i < MaxLabel; i++)
/*     */     {
/* 636 */       for (int j = i + 1; j <= MaxLabel; j++)
/*     */       {
/* 638 */         iProperty = RegionData[i];
/* 639 */         jProperty = RegionData[j];
/* 640 */         iField = iProperty[Col];
/* 641 */         jField = jProperty[Col];
/* 642 */         if (iField > jField)
/*     */         {
/* 644 */           RegionData[i] = jProperty;
/* 645 */           RegionData[j] = iProperty;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.Blobs
 * JD-Core Version:    0.6.2
 */