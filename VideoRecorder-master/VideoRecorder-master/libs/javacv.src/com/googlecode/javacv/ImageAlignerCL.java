package com.googlecode.javacv;

import com.jogamp.opencl.CLImage2d;

public abstract interface ImageAlignerCL extends ImageAligner
{
  public abstract CLImage2d getTemplateImageCL();

  public abstract void setTemplateImageCL(CLImage2d paramCLImage2d, double[] paramArrayOfDouble);

  public abstract CLImage2d getTargetImageCL();

  public abstract void setTargetImageCL(CLImage2d paramCLImage2d);

  public abstract CLImage2d getTransformedImageCL();

  public abstract CLImage2d getResidualImageCL();

  public abstract CLImage2d getMaskImageCL();

  public abstract CLImage2d[] getImagesCL();
}

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacv.jar
 * Qualified Name:     com.googlecode.javacv.ImageAlignerCL
 * JD-Core Version:    0.6.2
 */