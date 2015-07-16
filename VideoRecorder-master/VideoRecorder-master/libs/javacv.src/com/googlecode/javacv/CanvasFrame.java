/*     */ package com.googlecode.javacv;
/*     */ 
/*     */ import com.googlecode.javacv.cpp.opencv_core.CvScalar;
/*     */ import com.googlecode.javacv.cpp.opencv_core.IplImage;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.DisplayMode;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsDevice;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Image;
/*     */ import java.awt.KeyEventDispatcher;
/*     */ import java.awt.KeyboardFocusManager;
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.color.ICC_ColorSpace;
/*     */ import java.awt.color.ICC_ProfileRGB;
/*     */ import java.awt.event.ComponentAdapter;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.ColorModel;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JRootPane;
/*     */ 
/*     */ public class CanvasFrame extends JFrame
/*     */ {
/* 234 */   public static CanvasFrame global = null;
/*     */   public static final long DEFAULT_LATENCY = 200L;
/* 240 */   private long latency = 200L;
/*     */ 
/* 242 */   private KeyEvent keyEvent = null;
/* 243 */   private KeyEventDispatcher keyEventDispatch = new KeyEventDispatcher() {
/*     */     public boolean dispatchKeyEvent(KeyEvent e) {
/* 245 */       if (e.getID() == 401) {
/* 246 */         synchronized (CanvasFrame.this) {
/* 247 */           CanvasFrame.this.keyEvent = e;
/* 248 */           CanvasFrame.this.notify();
/*     */         }
/*     */       }
/* 251 */       return false;
/*     */     }
/* 243 */   };
/*     */ 
/* 255 */   protected Canvas canvas = null;
/* 256 */   protected boolean needInitialResize = false;
/* 257 */   protected double initialScale = 1.0D;
/* 258 */   protected double inverseGamma = 1.0D;
/* 259 */   private Color color = null;
/* 260 */   private Image image = null;
/* 261 */   private BufferedImage buffer = null;
/*     */ 
/*     */   public static String[] getScreenDescriptions()
/*     */   {
/*  67 */     GraphicsDevice[] screens = getScreenDevices();
/*  68 */     String[] descriptions = new String[screens.length];
/*  69 */     for (int i = 0; i < screens.length; i++) {
/*  70 */       descriptions[i] = screens[i].getIDstring();
/*     */     }
/*  72 */     return descriptions;
/*     */   }
/*     */   public static DisplayMode getDisplayMode(int screenNumber) {
/*  75 */     GraphicsDevice[] screens = getScreenDevices();
/*  76 */     if ((screenNumber >= 0) && (screenNumber < screens.length)) {
/*  77 */       return screens[screenNumber].getDisplayMode();
/*     */     }
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */   public static double getGamma(int screenNumber) {
/*  83 */     GraphicsDevice[] screens = getScreenDevices();
/*  84 */     if ((screenNumber >= 0) && (screenNumber < screens.length)) {
/*  85 */       return getGamma(screens[screenNumber]);
/*     */     }
/*  87 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   public static double getDefaultGamma() {
/*  91 */     return getGamma(getDefaultScreenDevice());
/*     */   }
/*     */ 
/*     */   public static double getGamma(GraphicsDevice screen) {
/*  95 */     ColorSpace cs = screen.getDefaultConfiguration().getColorModel().getColorSpace();
/*  96 */     if (cs.isCS_sRGB())
/*  97 */       return 2.2D;
/*     */     try
/*     */     {
/* 100 */       return ((ICC_ProfileRGB)((ICC_ColorSpace)cs).getProfile()).getGamma(0);
/*     */     } catch (RuntimeException e) {
/*     */     }
/* 103 */     return 0.0D;
/*     */   }
/*     */   public static GraphicsDevice getScreenDevice(int screenNumber) throws CanvasFrame.Exception {
/* 106 */     GraphicsDevice[] screens = getScreenDevices();
/* 107 */     if (screenNumber >= screens.length) {
/* 108 */       throw new Exception("CanvasFrame Error: Screen number " + screenNumber + " not found. " + "There are only " + screens.length + " screens.");
/*     */     }
/*     */ 
/* 111 */     return screens[screenNumber];
/*     */   }
/*     */   public static GraphicsDevice[] getScreenDevices() {
/* 114 */     return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
/*     */   }
/*     */   public static GraphicsDevice getDefaultScreenDevice() {
/* 117 */     return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
/*     */   }
/*     */ 
/*     */   public CanvasFrame(String title) {
/* 121 */     this(title, 0.0D);
/*     */   }
/*     */   public CanvasFrame(String title, double gamma) {
/* 124 */     super(title);
/* 125 */     init(false, null, gamma);
/*     */   }
/*     */ 
/*     */   public CanvasFrame(String title, GraphicsConfiguration gc) {
/* 129 */     this(title, gc, 0.0D);
/*     */   }
/*     */   public CanvasFrame(String title, GraphicsConfiguration gc, double gamma) {
/* 132 */     super(title, gc);
/* 133 */     init(false, null, gamma);
/*     */   }
/*     */ 
/*     */   public CanvasFrame(String title, int screenNumber, DisplayMode displayMode) throws CanvasFrame.Exception {
/* 137 */     this(title, screenNumber, displayMode, 0.0D);
/*     */   }
/*     */   public CanvasFrame(String title, int screenNumber, DisplayMode displayMode, double gamma) throws CanvasFrame.Exception {
/* 140 */     super(title, getScreenDevice(screenNumber).getDefaultConfiguration());
/* 141 */     init(true, displayMode, gamma);
/*     */   }
/*     */ 
/*     */   private void init(final boolean fullScreen, final DisplayMode displayMode, final double gamma) {
/* 145 */     Runnable r = new Runnable() {
/* 146 */       public void run() { KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(CanvasFrame.this.keyEventDispatch);
/*     */ 
/* 149 */         GraphicsDevice gd = CanvasFrame.this.getGraphicsConfiguration().getDevice();
/* 150 */         DisplayMode d = gd.getDisplayMode(); DisplayMode d2 = null;
/* 151 */         if ((displayMode != null) && (d != null)) {
/* 152 */           int w = displayMode.getWidth();
/* 153 */           int h = displayMode.getHeight();
/* 154 */           int b = displayMode.getBitDepth();
/* 155 */           int r = displayMode.getRefreshRate();
/* 156 */           d2 = new DisplayMode(w > 0 ? w : d.getWidth(), h > 0 ? h : d.getHeight(), b > 0 ? b : d.getBitDepth(), r > 0 ? r : d.getRefreshRate());
/*     */         }
/*     */ 
/* 159 */         if (fullScreen) {
/* 160 */           CanvasFrame.this.setUndecorated(true);
/* 161 */           CanvasFrame.this.getRootPane().setWindowDecorationStyle(0);
/* 162 */           CanvasFrame.this.setResizable(false);
/* 163 */           gd.setFullScreenWindow(CanvasFrame.this);
/*     */         } else {
/* 165 */           CanvasFrame.this.setLocationByPlatform(true);
/*     */         }
/* 167 */         if ((d2 != null) && (!d2.equals(d))) {
/* 168 */           gd.setDisplayMode(d2);
/*     */         }
/* 170 */         double g = gamma == 0.0D ? CanvasFrame.getGamma(gd) : gamma;
/* 171 */         CanvasFrame.this.inverseGamma = (g == 0.0D ? 1.0D : 1.0D / g);
/*     */ 
/* 175 */         CanvasFrame.this.setVisible(true);
/*     */ 
/* 177 */         CanvasFrame.this.initCanvas(fullScreen, displayMode, gamma);
/*     */       }
/*     */     };
/* 180 */     if (EventQueue.isDispatchThread())
/* 181 */       r.run();
/*     */     else
/*     */       try {
/* 184 */         EventQueue.invokeAndWait(r);
/*     */       } catch (Exception ex) {
/*     */       }
/*     */   }
/*     */ 
/*     */   protected void initCanvas(boolean fullScreen, DisplayMode displayMode, double gamma) {
/* 190 */     this.canvas = new Canvas() {
/*     */       public void update(Graphics g) {
/* 192 */         paint(g);
/*     */       }
/*     */ 
/*     */       public void paint(Graphics g)
/*     */       {
/*     */         try
/*     */         {
/* 199 */           BufferStrategy strategy = CanvasFrame.this.canvas.getBufferStrategy();
/*     */           do {
/*     */             do {
/* 202 */               g = strategy.getDrawGraphics();
/* 203 */               if (CanvasFrame.this.color != null) {
/* 204 */                 g.setColor(CanvasFrame.this.color);
/* 205 */                 g.fillRect(0, 0, getWidth(), getHeight());
/*     */               }
/* 207 */               if (CanvasFrame.this.image != null) {
/* 208 */                 g.drawImage(CanvasFrame.this.image, 0, 0, getWidth(), getHeight(), null);
/*     */               }
/* 210 */               if (CanvasFrame.this.buffer != null) {
/* 211 */                 g.drawImage(CanvasFrame.this.buffer, 0, 0, getWidth(), getHeight(), null);
/*     */               }
/* 213 */               g.dispose();
/* 214 */             }while (strategy.contentsRestored());
/* 215 */             strategy.show();
/* 216 */           }while (strategy.contentsLost());
/*     */         }
/*     */         catch (NullPointerException e)
/*     */         {
/*     */         }
/*     */         catch (IllegalStateException e)
/*     */         {
/*     */         }
/*     */       }
/*     */     };
/* 221 */     if (fullScreen) {
/* 222 */       this.canvas.setSize(getSize());
/* 223 */       this.needInitialResize = false;
/*     */     } else {
/* 225 */       this.needInitialResize = true;
/*     */     }
/* 227 */     getContentPane().add(this.canvas);
/* 228 */     this.canvas.setVisible(true);
/* 229 */     this.canvas.createBufferStrategy(2);
/*     */   }
/*     */ 
/*     */   public long getLatency()
/*     */   {
/* 266 */     return this.latency;
/*     */   }
/*     */   public void setLatency(long latency) {
/* 269 */     this.latency = latency;
/*     */   }
/*     */   public void waitLatency() throws InterruptedException {
/* 272 */     Thread.sleep(getLatency());
/*     */   }
/*     */ 
/*     */   public KeyEvent waitKey() throws InterruptedException {
/* 276 */     return waitKey(0);
/*     */   }
/*     */   public synchronized KeyEvent waitKey(int delay) throws InterruptedException {
/* 279 */     if (delay >= 0) {
/* 280 */       this.keyEvent = null;
/* 281 */       wait(delay);
/*     */     }
/* 283 */     KeyEvent e = this.keyEvent;
/* 284 */     this.keyEvent = null;
/* 285 */     return e;
/*     */   }
/*     */ 
/*     */   public Canvas getCanvas() {
/* 289 */     return this.canvas;
/*     */   }
/*     */ 
/*     */   public Dimension getCanvasSize() {
/* 293 */     return this.canvas.getSize();
/*     */   }
/*     */   public void setCanvasSize(final int width, final int height) {
/* 296 */     Dimension d = getCanvasSize();
/* 297 */     if ((d.width == width) && (d.height == height)) {
/* 298 */       return;
/*     */     }
/*     */ 
/* 301 */     Runnable r = new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 308 */         CanvasFrame.this.setExtendedState(0);
/* 309 */         CanvasFrame.this.canvas.setSize(width, height);
/* 310 */         CanvasFrame.this.pack();
/* 311 */         CanvasFrame.this.canvas.setSize(width + 1, height + 1);
/* 312 */         CanvasFrame.this.canvas.setSize(width, height);
/* 313 */         CanvasFrame.this.needInitialResize = false;
/*     */       }
/*     */     };
/* 316 */     if (EventQueue.isDispatchThread())
/* 317 */       r.run();
/*     */     else
/*     */       try {
/* 320 */         EventQueue.invokeAndWait(r);
/*     */       } catch (Exception ex) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public double getCanvasScale() {
/* 326 */     return this.initialScale;
/*     */   }
/*     */   public void setCanvasScale(double initialScale) {
/* 329 */     this.initialScale = initialScale;
/* 330 */     this.needInitialResize = true;
/*     */   }
/*     */ 
/*     */   public Graphics2D createGraphics() {
/* 334 */     if ((this.buffer == null) || (this.buffer.getWidth() != this.canvas.getWidth()) || (this.buffer.getHeight() != this.canvas.getHeight())) {
/* 335 */       BufferedImage newbuffer = this.canvas.getGraphicsConfiguration().createCompatibleImage(this.canvas.getWidth(), this.canvas.getHeight(), 3);
/*     */ 
/* 337 */       if (this.buffer != null) {
/* 338 */         Graphics g = newbuffer.getGraphics();
/* 339 */         g.drawImage(this.buffer, 0, 0, null);
/* 340 */         g.dispose();
/*     */       }
/* 342 */       this.buffer = newbuffer;
/*     */     }
/* 344 */     return this.buffer.createGraphics();
/*     */   }
/*     */   public void releaseGraphics(Graphics2D g) {
/* 347 */     g.dispose();
/* 348 */     this.canvas.paint(null);
/*     */   }
/*     */ 
/*     */   public void showColor(opencv_core.CvScalar color) {
/* 352 */     showColor(new Color((int)color.red(), (int)color.green(), (int)color.blue()));
/*     */   }
/*     */   public void showColor(Color color) {
/* 355 */     this.color = color;
/* 356 */     this.image = null;
/* 357 */     this.canvas.paint(null);
/*     */   }
/*     */ 
/*     */   public void showImage(opencv_core.IplImage image)
/*     */   {
/* 363 */     showImage(image, false);
/*     */   }
/*     */   public void showImage(opencv_core.IplImage image, boolean flipChannels) {
/* 366 */     showImage(image.getBufferedImage(image.getBufferedImageType() == 0 ? 1.0D : this.inverseGamma, flipChannels));
/*     */   }
/*     */ 
/*     */   public void showImage(Image image) {
/* 370 */     if (image == null)
/* 371 */       return;
/* 372 */     if ((isResizable()) && (this.needInitialResize)) {
/* 373 */       int w = (int)Math.round(image.getWidth(null) * this.initialScale);
/* 374 */       int h = (int)Math.round(image.getHeight(null) * this.initialScale);
/* 375 */       setCanvasSize(w, h);
/*     */     }
/* 377 */     this.color = null;
/* 378 */     this.image = image;
/* 379 */     this.canvas.paint(null);
/*     */   }
/*     */ 
/*     */   public static void tile(CanvasFrame[] frames)
/*     */   {
/* 397 */     final ComponentAdapter movedListener = new ComponentAdapter()
/*     */     {
/* 388 */       boolean moved = false;
/*     */ 
/* 390 */       public void componentMoved(ComponentEvent e) { this.moved = true;
/* 391 */         Component c = e.getComponent();
/* 392 */         synchronized (c) {
/* 393 */           c.notify();
/*     */         }
/*     */       }
/*     */     };
/* 400 */     int canvasCols = (int)Math.round(Math.sqrt(frames.length));
/* 401 */     if (canvasCols * canvasCols < frames.length)
/*     */     {
/* 406 */       canvasCols++;
/*     */     }
/* 408 */     int canvasX = 0; int canvasY = 0;
/* 409 */     int canvasMaxY = 0;
/* 410 */     for (int i = 0; i < frames.length; i++) {
/* 411 */       final int n = i;
/* 412 */       final int x = canvasX;
/* 413 */       final int y = canvasY;
/*     */       try {
/* 415 */         movedListener.moved = false;
/* 416 */         EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 418 */             this.val$frames[n].addComponentListener(movedListener);
/* 419 */             this.val$frames[n].setLocation(x, y);
/*     */           }
/*     */         });
/* 422 */         int count = 0;
/* 423 */         while ((!movedListener.moved) && (count < 5))
/*     */         {
/* 428 */           synchronized (frames[n]) {
/* 429 */             frames[n].wait(100L);
/*     */           }
/* 431 */           count++;
/*     */         }
/* 433 */         EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 435 */             this.val$frames[n].removeComponentListener(movedListener);
/*     */           } } );
/*     */       } catch (Exception ex) {
/*     */       }
/* 439 */       canvasX = frames[i].getX() + frames[i].getWidth();
/* 440 */       canvasMaxY = Math.max(canvasMaxY, frames[i].getY() + frames[i].getHeight());
/* 441 */       if ((i + 1) % canvasCols == 0) {
/* 442 */         canvasX = 0;
/* 443 */         canvasY = canvasMaxY;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Exception extends Exception
/*     */   {
/*     */     public Exception(String message)
/*     */     {
/*  62 */       super(); } 
/*  63 */     public Exception(String message, Throwable cause) { super(cause); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.CanvasFrame
 * JD-Core Version:    0.6.2
 */