/*     */ package com.googlecode.javacpp;
/*     */ 
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ 
/*     */ public class Pointer
/*     */ {
/* 268 */   private static final ReferenceQueue<Pointer> referenceQueue = new ReferenceQueue();
/*     */ 
/* 280 */   protected long address = 0L;
/*     */ 
/* 282 */   protected int position = 0;
/*     */ 
/* 284 */   protected int limit = 0;
/*     */ 
/* 286 */   protected int capacity = 0;
/*     */ 
/* 288 */   private Deallocator deallocator = null;
/*     */ 
/*     */   public Pointer()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Pointer(final Pointer p)
/*     */   {
/*  80 */     if (p != null) {
/*  81 */       this.address = p.address;
/*  82 */       this.position = p.position;
/*  83 */       this.limit = p.limit;
/*  84 */       this.capacity = p.capacity;
/*  85 */       if (p.deallocator != null)
/*  86 */         this.deallocator = new Deallocator() { public void deallocate() { p.deallocate(); }
/*     */ 
/*     */         };
/*     */     }
/*     */   }
/*     */ 
/*     */   public Pointer(final Buffer b)
/*     */   {
/*  98 */     if (b != null) {
/*  99 */       allocate(b);
/*     */     }
/* 101 */     if (!isNull()) {
/* 102 */       this.position = b.position();
/* 103 */       this.limit = b.limit();
/* 104 */       this.capacity = b.capacity();
/* 105 */       this.deallocator = new Deallocator() { Buffer bb = b;
/*     */ 
/* 105 */         public void deallocate() { this.bb = null; }
/*     */ 
/*     */       };
/*     */     }
/*     */   }
/*     */ 
/*     */   private native void allocate(Buffer paramBuffer);
/*     */ 
/*     */   void init(long allocatedAddress, int allocatedCapacity, long deallocatorAddress)
/*     */   {
/* 119 */     this.address = allocatedAddress;
/* 120 */     this.position = 0;
/* 121 */     this.limit = allocatedCapacity;
/* 122 */     this.capacity = allocatedCapacity;
/* 123 */     deallocator(new NativeDeallocator(this, deallocatorAddress));
/*     */   }
/*     */ 
/*     */   protected static <P extends Pointer> P withDeallocator(P p)
/*     */   {
/* 138 */     return p.deallocator(new CustomDeallocator(p));
/*     */   }
/*     */ 
/*     */   public static void deallocateReferences()
/*     */   {
/* 272 */     DeallocatorReference r = null;
/* 273 */     while ((r = (DeallocatorReference)referenceQueue.poll()) != null) {
/* 274 */       r.clear();
/* 275 */       r.remove();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isNull()
/*     */   {
/* 292 */     return this.address == 0L;
/*     */   }
/*     */ 
/*     */   public void setNull() {
/* 296 */     this.address = 0L;
/*     */   }
/*     */ 
/*     */   public int position()
/*     */   {
/* 301 */     return this.position;
/*     */   }
/*     */ 
/*     */   public <P extends Pointer> P position(int position)
/*     */   {
/* 311 */     this.position = position;
/* 312 */     return this;
/*     */   }
/*     */ 
/*     */   public int limit()
/*     */   {
/* 317 */     return this.limit;
/*     */   }
/*     */ 
/*     */   public <P extends Pointer> P limit(int limit)
/*     */   {
/* 327 */     this.limit = limit;
/* 328 */     return this;
/*     */   }
/*     */ 
/*     */   public int capacity()
/*     */   {
/* 333 */     return this.capacity;
/*     */   }
/*     */ 
/*     */   public <P extends Pointer> P capacity(int capacity)
/*     */   {
/* 343 */     this.limit = capacity;
/* 344 */     this.capacity = capacity;
/* 345 */     return this;
/*     */   }
/*     */ 
/*     */   protected Deallocator deallocator()
/*     */   {
/* 350 */     return this.deallocator;
/*     */   }
/*     */ 
/*     */   protected <P extends Pointer> P deallocator(Deallocator deallocator)
/*     */   {
/* 361 */     if (this.deallocator != null) {
/* 362 */       this.deallocator.deallocate();
/* 363 */       this.deallocator = null;
/*     */     }
/* 365 */     deallocateReferences();
/* 366 */     if ((deallocator != null) && (!deallocator.equals(null))) {
/* 367 */       this.deallocator = deallocator;
/* 368 */       DeallocatorReference r = (deallocator instanceof DeallocatorReference) ? (DeallocatorReference)deallocator : new DeallocatorReference(this, deallocator);
/*     */ 
/* 371 */       r.add();
/*     */     }
/* 373 */     return this;
/*     */   }
/*     */ 
/*     */   public void deallocate()
/*     */   {
/* 378 */     deallocate(true);
/*     */   }
/*     */ 
/*     */   public void deallocate(boolean deallocate)
/*     */   {
/* 385 */     if ((deallocate) && (this.deallocator != null)) {
/* 386 */       this.deallocator.deallocate();
/* 387 */       this.address = 0L; } else {
/* 388 */       synchronized (DeallocatorReference.class) {
/* 389 */         DeallocatorReference r = DeallocatorReference.head;
/* 390 */         while (r != null) {
/* 391 */           if (r.deallocator == this.deallocator) {
/* 392 */             r.deallocator = null;
/* 393 */             r.clear();
/* 394 */             r.remove();
/* 395 */             break;
/*     */           }
/* 397 */           r = r.next;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public int offsetof(String member) {
/* 404 */     int offset = -1;
/*     */     try {
/* 406 */       Class c = getClass();
/* 407 */       if (c != Pointer.class)
/* 408 */         offset = Loader.offsetof(c, member);
/*     */     } catch (NullPointerException e) {
/*     */     }
/* 411 */     return offset;
/*     */   }
/*     */ 
/*     */   public int sizeof()
/*     */   {
/* 416 */     Class c = getClass();
/* 417 */     if ((c == Pointer.class) || (c == BytePointer.class))
/*     */     {
/* 419 */       return 1;
/*     */     }
/* 421 */     return offsetof("sizeof");
/*     */   }
/*     */ 
/*     */   private native ByteBuffer asDirectBuffer();
/*     */ 
/*     */   public ByteBuffer asByteBuffer()
/*     */   {
/* 434 */     if (isNull()) {
/* 435 */       return null;
/*     */     }
/* 437 */     if ((this.limit > 0) && (this.limit < this.position)) {
/* 438 */       throw new IllegalArgumentException("limit < position: (" + this.limit + " < " + this.position + ")");
/*     */     }
/* 440 */     int valueSize = sizeof();
/* 441 */     int arrayPosition = this.position;
/* 442 */     int arrayLimit = this.limit;
/* 443 */     this.position = (valueSize * arrayPosition);
/* 444 */     this.limit = (valueSize * (arrayLimit <= 0 ? arrayPosition + 1 : arrayLimit));
/* 445 */     ByteBuffer b = asDirectBuffer().order(ByteOrder.nativeOrder());
/* 446 */     this.position = arrayPosition;
/* 447 */     this.limit = arrayLimit;
/* 448 */     return b;
/*     */   }
/*     */ 
/*     */   public Buffer asBuffer()
/*     */   {
/* 463 */     return asByteBuffer();
/*     */   }
/*     */ 
/*     */   public static native Pointer memchr(Pointer paramPointer, int paramInt, long paramLong);
/*     */ 
/*     */   public static native int memcmp(Pointer paramPointer1, Pointer paramPointer2, long paramLong);
/*     */ 
/*     */   public static native Pointer memcpy(Pointer paramPointer1, Pointer paramPointer2, long paramLong);
/*     */ 
/*     */   public static native Pointer memmove(Pointer paramPointer1, Pointer paramPointer2, long paramLong);
/*     */ 
/*     */   public static native Pointer memset(Pointer paramPointer, int paramInt, long paramLong);
/*     */ 
/*     */   public <P extends Pointer> P put(Pointer p)
/*     */   {
/* 481 */     if ((p.limit > 0) && (p.limit < p.position)) {
/* 482 */       throw new IllegalArgumentException("limit < position: (" + p.limit + " < " + p.position + ")");
/*     */     }
/* 484 */     int size = sizeof();
/* 485 */     int psize = p.sizeof();
/* 486 */     int length = psize * (p.limit <= 0 ? 1 : p.limit - p.position);
/* 487 */     this.position *= size;
/* 488 */     p.position *= psize;
/* 489 */     memcpy(this, p, length);
/* 490 */     this.position /= size;
/* 491 */     p.position /= psize;
/* 492 */     return this;
/*     */   }
/*     */ 
/*     */   public <P extends Pointer> P fill(int b)
/*     */   {
/* 504 */     if ((this.limit > 0) && (this.limit < this.position)) {
/* 505 */       throw new IllegalArgumentException("limit < position: (" + this.limit + " < " + this.position + ")");
/*     */     }
/* 507 */     int size = sizeof();
/* 508 */     int length = size * (this.limit <= 0 ? 1 : this.limit - this.position);
/* 509 */     this.position *= size;
/* 510 */     memset(this, b, length);
/* 511 */     this.position /= size;
/* 512 */     return this;
/*     */   }
/*     */   public <P extends Pointer> P zero() {
/* 515 */     return fill(0);
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 526 */     if (obj == this)
/* 527 */       return true;
/* 528 */     if (obj == null)
/* 529 */       return isNull();
/* 530 */     if (obj.getClass() != getClass()) {
/* 531 */       return false;
/*     */     }
/* 533 */     Pointer other = (Pointer)obj;
/* 534 */     return (this.address == other.address) && (this.position == other.position);
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 540 */     return (int)this.address;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 546 */     return getClass().getName() + "[address=0x" + Long.toHexString(this.address) + ",position=" + this.position + ",limit=" + this.limit + ",capacity=" + this.capacity + ",deallocator=" + this.deallocator + "]";
/*     */   }
/*     */ 
/*     */   private static class DeallocatorReference extends PhantomReference<Pointer>
/*     */   {
/* 226 */     static DeallocatorReference head = null;
/* 227 */     DeallocatorReference prev = null; DeallocatorReference next = null;
/*     */     Pointer.Deallocator deallocator;
/*     */ 
/*     */     DeallocatorReference(Pointer p, Pointer.Deallocator deallocator)
/*     */     {
/* 222 */       super(Pointer.referenceQueue);
/* 223 */       this.deallocator = deallocator;
/*     */     }
/*     */ 
/*     */     final void add()
/*     */     {
/* 231 */       synchronized (DeallocatorReference.class) {
/* 232 */         if (head == null) {
/* 233 */           head = this;
/*     */         } else {
/* 235 */           this.next = head;
/* 236 */           head = this; this.next.prev = this;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     final void remove() {
/* 242 */       synchronized (DeallocatorReference.class) {
/* 243 */         if ((this.prev == this) && (this.next == this)) {
/* 244 */           return;
/*     */         }
/* 246 */         if (this.prev == null)
/* 247 */           head = this.next;
/*     */         else {
/* 249 */           this.prev.next = this.next;
/*     */         }
/* 251 */         if (this.next != null) {
/* 252 */           this.next.prev = this.prev;
/*     */         }
/* 254 */         this.next = this; this.prev = this;
/*     */       }
/*     */     }
/*     */ 
/*     */     public void clear() {
/* 259 */       super.clear();
/* 260 */       if (this.deallocator != null) {
/* 261 */         this.deallocator.deallocate();
/* 262 */         this.deallocator = null;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static class NativeDeallocator extends Pointer.DeallocatorReference
/*     */     implements Pointer.Deallocator
/*     */   {
/*     */     private long allocatedAddress;
/*     */     private long deallocatorAddress;
/*     */ 
/*     */     NativeDeallocator(Pointer p, long deallocatorAddress)
/*     */     {
/* 195 */       super(null);
/* 196 */       this.deallocator = this;
/* 197 */       this.allocatedAddress = p.address;
/* 198 */       this.deallocatorAddress = deallocatorAddress;
/*     */     }
/*     */ 
/*     */     public void deallocate()
/*     */     {
/* 205 */       if ((this.allocatedAddress != 0L) && (this.deallocatorAddress != 0L))
/*     */       {
/* 208 */         deallocate(this.allocatedAddress, this.deallocatorAddress);
/* 209 */         this.allocatedAddress = (this.deallocatorAddress = 0L);
/*     */       }
/*     */     }
/*     */ 
/*     */     private native void deallocate(long paramLong1, long paramLong2);
/*     */   }
/*     */ 
/*     */   protected static class CustomDeallocator extends Pointer.DeallocatorReference
/*     */     implements Pointer.Deallocator
/*     */   {
/* 176 */     Pointer pointer = null;
/* 177 */     Method method = null;
/*     */ 
/*     */     public CustomDeallocator(Pointer p)
/*     */     {
/* 150 */       super(null);
/* 151 */       this.deallocator = this;
/* 152 */       Class cls = p.getClass();
/* 153 */       for (Method m : cls.getDeclaredMethods()) {
/* 154 */         Class[] parameters = m.getParameterTypes();
/* 155 */         if ((Modifier.isStatic(m.getModifiers())) && (m.getReturnType().equals(Void.TYPE)) && (m.getName().equals("deallocate")) && (parameters.length == 1) && (Pointer.class.isAssignableFrom(parameters[0])))
/*     */         {
/* 158 */           m.setAccessible(true);
/* 159 */           this.method = m;
/* 160 */           break;
/*     */         }
/*     */       }
/* 163 */       if (this.method == null) {
/* 164 */         throw new RuntimeException(new NoSuchMethodException("static void " + cls.getCanonicalName() + ".deallocate(" + Pointer.class.getCanonicalName() + ")"));
/*     */       }
/*     */       try
/*     */       {
/* 168 */         Constructor c = cls.getConstructor(new Class[] { Pointer.class });
/* 169 */         c.setAccessible(true);
/* 170 */         this.pointer = ((Pointer)c.newInstance(new Object[] { p }));
/*     */       } catch (Exception ex) {
/* 172 */         throw new RuntimeException(ex);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void deallocate()
/*     */     {
/*     */       try
/*     */       {
/* 181 */         this.method.invoke(null, new Object[] { this.pointer });
/* 182 */         this.pointer.setNull();
/*     */       } catch (Exception ex) {
/* 184 */         throw new RuntimeException(ex);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static abstract interface Deallocator
/*     */   {
/*     */     public abstract void deallocate();
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.Pointer
 * JD-Core Version:    0.6.2
 */