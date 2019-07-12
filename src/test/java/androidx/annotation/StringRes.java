/**
 * Upstream version:
 * https://android.googlesource.com/platform/frameworks/support/+/master/annotations/src/main/java/androidx/annotation/StringRes.java
 * This annotation is only included for testing purpose.
 */
package androidx.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
public @interface StringRes {
}
