import androidx.annotations.FractionRes;
import androidx.annotations.StringRes;
import android.annotations.AnyRes;
import android.annotations.RawRes;
import android.support.annotation.AttrRes;
import android.support.annotation.XmlRes;

public class AndroidAliasesTest {

    @AnyRes int any_res;
    @RawRes int raw_res;

    @FractionRes int fraction_res;
    @StringRes int string_res;

    @AttrRes int attr_res;
    @XmlRes int xml_res;

    public AndroidAliasesTest() {
    }

    void Test() {
        any_res = R.plurals.plurals_res;
        raw_res = R.raw.raw_res;

        fraction_res = R.fraction.abc_fraction;
        string_res = R.string.abc_action_bar_home_description;

        attr_res = R.attr.actionBarDivider;
        xml_res = R.xml.file_paths;
    }
}
