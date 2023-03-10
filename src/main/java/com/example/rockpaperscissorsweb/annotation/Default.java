package com.example.rockpaperscissorsweb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.CLASS;

@Target(ElementType.CONSTRUCTOR)
@Retention(value = CLASS)
public @interface Default {
}
