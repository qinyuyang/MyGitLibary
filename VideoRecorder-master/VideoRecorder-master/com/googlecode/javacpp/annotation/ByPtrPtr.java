package com.googlecode.javacpp.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface ByPtrPtr
{
}

/* Location:           E:\androidOpenLibrary\VideoRecorder-master\VideoRecorder-master\libs\javacpp.jar
 * Qualified Name:     com.googlecode.javacpp.annotation.ByPtrPtr
 * JD-Core Version:    0.6.2
 */