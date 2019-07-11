import androidx.annotation.StringRes;
import android.annotation.AnyRes;
import android.annotation.RawRes;

public class AndroidAliasesTest {

    @AnyRes
    int any_res;
    @RawRes
    int raw_res;

    @StringRes
    int string_res;

    int a = 10;
    int b = 20;

    int c;

    public AndroidAliasesTest() {
    }

    void init() {
        any_res = R.plurals.plurals_res;
        raw_res = R.raw.raw_res;

        string_res = R.string.abc_action_bar_home_description;
    }

    void test() {
        init();

        // :: error: (assignment.type.incompatible)
        any_res = a;

        b = raw_res;

        any_res = string_res;

        // :: warning: (binary.operation.both.operand.found.resource)
        a = any_res + b;

        // :: error: (assignment.type.incompatible) :: warning: (binary.operation.both.operand.found.resource)
        string_res = a - b;

        // :: warning: (binary.operation.both.operand.found.resource)
        any_res = raw_res * string_res;

        // :: error: (assignment.type.incompatible) :: warning: (binary.operation.both.operand.found.resource)
        raw_res = a / any_res;

        // :: warning: (compound.assignment.both.found.resource)
        a += string_res;

        // :: error: (compound.assignment.type.incompatible) :: warning: (compound.assignment.both.found.resource)
        raw_res -= any_res;

        // :: warning: (compound.assignment.both.found.resource)
        any_res *= string_res;

        // :: error: (compound.assignment.type.incompatible) :: warning: (compound.assignment.both.found.resource)
        string_res /= b;
    }
}
