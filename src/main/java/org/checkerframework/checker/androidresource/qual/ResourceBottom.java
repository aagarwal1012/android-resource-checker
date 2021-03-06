package org.checkerframework.checker.androidresource.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.androidresource.qual.container.*;
import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TargetLocations;
import org.checkerframework.framework.qual.TypeUseLocation;

/**
 * The bottom type in the AndroidResource type system. Programmers should rarely write this type.
 */
@SubtypeOf({
  AnimatorRes.class,
  AnimRes.class,
  ArrayRes.class,
  AttrRes.class,
  BoolRes.class,
  ColorRes.class,
  DimenRes.class,
  DrawableRes.class,
  FractionRes.class,
  IdRes.class,
  IntegerRes.class,
  InterpolatorRes.class,
  LayoutRes.class,
  MenuRes.class,
  PluralsRes.class,
  RawRes.class,
  StringRes.class,
  StyleableRes.class,
  XmlRes.class,
  FontRes.class,
  NavigationRes.class,
  StyleRes.class,
  TransitionRes.class,
  AnimatorContainer.class,
  AnimContainer.class,
  ArrayContainer.class,
  AttrContainer.class,
  BoolContainer.class,
  ColorContainer.class,
  DimenContainer.class,
  DrawableContainer.class,
  FractionContainer.class,
  IdContainer.class,
  IntegerContainer.class,
  InterpolatorContainer.class,
  LayoutContainer.class,
  MenuContainer.class,
  PluralsContainer.class,
  RawContainer.class,
  StringContainer.class,
  StyleableContainer.class,
  XmlContainer.class,
  FontContainer.class,
  NavigationContainer.class,
  StyleContainer.class,
  TransitionContainer.class,
})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@TargetLocations({TypeUseLocation.EXPLICIT_LOWER_BOUND, TypeUseLocation.EXPLICIT_UPPER_BOUND})
@DefaultFor({TypeUseLocation.LOWER_BOUND})
public @interface ResourceBottom {}
