/**
 * Upstream version:
 * https://android.googlesource.com/platform/frameworks/base/+/master/core/java/android/annotation/AnyRes.java
 * This annotation is only included for testing purpose.
 */
package android.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
public @interface AnyRes {
}
