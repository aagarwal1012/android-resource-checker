package org.checkerframework.checker.androidresource.qual.res;

import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

@SubtypeOf({AnyRes.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface AnimatorRes {
}
