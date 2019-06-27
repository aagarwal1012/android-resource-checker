package org.checkerframework.checker.androidresource.qual;

import org.checkerframework.checker.androidresource.qual.container.*;
import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.framework.qual.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SubtypeOf({AnimatorRes.class, AnimRes.class, ArrayRes.class, AttrRes.class,
        BoolRes.class, ColorRes.class, DimenRes.class, DrawableRes.class, FractionRes.class,
        IdRes.class, IntegerRes.class, InterpolatorRes.class, LayoutRes.class, MenuRes.class,
        PluralsRes.class, RawRes.class, StringRes.class, StyleableRes.class, XmlRes.class,
        AnimatorContainer.class, AnimContainer.class, ArrayContainer.class, AttrContainer.class,
        BoolContainer.class, ColorContainer.class, DimenContainer.class, DrawableContainer.class, FractionContainer.class,
        IdContainer.class, IntegerContainer.class, InterpolatorContainer.class, LayoutContainer.class, MenuContainer.class,
        PluralsContainer.class, RawContainer.class, StringContainer.class, StyleableContainer.class, XmlContainer.class,})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@TargetLocations({TypeUseLocation.EXPLICIT_LOWER_BOUND, TypeUseLocation.EXPLICIT_UPPER_BOUND})
@ImplicitFor(literals = LiteralKind.NULL, typeNames = java.lang.Void.class)
public @interface ResourceBottom {
}
