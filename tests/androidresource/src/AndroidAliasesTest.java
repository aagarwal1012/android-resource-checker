import org.checkerframework.checker.androidresource.qual.res.*;

/**
 * Tests to make sure that Android annotations aliases to the checker annotations.
 */
public class AndroidAliasesTest {

    @android.annotation.AnyRes int android_any_res;
    @android.annotation.RawRes int android_raw_res;

    @androidx.annotation.StringRes int android_string_res;

    @RawRes int checker_raw_res;
    @AnyRes int checker_any_res;
    @StyleRes int checker_style_res;

    int a = 10;
    int b = 20;

    int c;

    public AndroidAliasesTest() {
    }

    void init() {
        android_any_res = R.plurals.plurals_res;
        android_raw_res = R.raw.raw_res;

        android_string_res = R.string.abc_action_bar_home_description;
    }

    void test() {
        init();

        // :: error: (assignment.type.incompatible)
        android_any_res = a;

        b = android_raw_res;

        android_any_res = android_string_res;

        // :: warning: (binary.operation.both.operand.found.resource)
        a = android_any_res + b;

        // :: error: (assignment.type.incompatible) :: warning: (binary.operation.both.operand.found.resource)
        android_string_res = a - b;

        // :: warning: (binary.operation.both.operand.found.resource)
        android_any_res = android_raw_res * android_string_res;

        // :: error: (assignment.type.incompatible) :: warning: (binary.operation.both.operand.found.resource)
        android_raw_res = a / android_any_res;

        // :: warning: (compound.assignment.both.found.resource)
        a += android_string_res;

        // :: error: (compound.assignment.type.incompatible) :: warning: (compound.assignment.both.found.resource)
        android_raw_res -= android_any_res;

        // :: warning: (compound.assignment.both.found.resource)
        android_any_res *= android_string_res;

        // :: error: (compound.assignment.type.incompatible) :: warning: (compound.assignment.both.found.resource)
        android_string_res /= b;
    }

    void assignTest(){
        init();

        checker_any_res = android_string_res;

        checker_raw_res = android_raw_res;

        // :: error: (assignment.type.incompatible)
        checker_style_res = android_any_res;
    }
}
