package com.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.nio.Buffer;

public class Frame
{
  public boolean keyFrame;
  public opencv_core.IplImage image;
  public int sampleRate;
  public Buffer[] samples;
  public Object opaque;
}

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.Frame
 * JD-Core Version:    0.6.2
 */