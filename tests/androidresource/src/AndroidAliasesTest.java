import androidx.annotations.StringRes;
import android.annotations.AnyRes;
import android.annotations.RawRes;

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

        any_res = a;

        b = raw_res;

        any_res = string_res;


        a = any_res + b;

        string_res = a - b;

        any_res = raw_res * string_res;

        raw_res = a / any_res;


        a += string_res;

        raw_res -= any_res;

        any_res *= string_res;

        string_res /= b;
    }
}
