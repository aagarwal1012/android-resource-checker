package org.checkerframework.checker.androidresource.qual.container;

import org.checkerframework.checker.androidresource.qual.ResourceTop;
import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

@SubtypeOf({ResourceTop.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface ArrayContainer {
}
