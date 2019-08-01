package org.checkerframework.checker.androidresource.qual.res;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.androidresource.qual.ResourceTop;
import org.checkerframework.framework.qual.SubtypeOf;

/**
 * Represents a resource type. Use when the specific type of resource is not known but it must be a
 * resource type. <br>
 * Super type of all {@code @XXXRes}.
 */
@SubtypeOf({ResourceTop.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface AnyRes {}
