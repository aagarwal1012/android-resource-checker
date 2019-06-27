import org.checkerframework.checker.androidresource.qual.res.*;

class AndroidResourceTest {

    @AnimatorRes
    int animator_res;

    @AnimRes
    int anim_res;

    @ArrayRes
    int array_res;

    @AttrRes
    int attr_res;

    @BoolRes
    int bool_res;

    @ColorRes
    int color_res;

    @DimenRes
    int dimen_res;

    @DrawableRes
    int drawable_res;

    @FractionRes
    int fraction_res;

    @IdRes
    int id_res;

    @IntegerRes
    int integer_res;

    @InterpolatorRes
    int interpolator_res;

    @LayoutRes
    int layout_res;

    @MenuRes
    int menu_res;

    @PluralsRes
    int plurals_res;

    @RawRes
    int raw_res;

    @StringRes
    int string_res;

    @StyleableRes
    int styleable_res;

    @XmlRes
    int xml_res;

    @AnyRes
    int any_res;

    int a = 10;
    int b = 20;

    int c;

    AndroidResourceTest() {
    }

    void init() {

        any_res = R.string.abc_action_bar_home_description;

        animator_res = R.animator.abc_fade_in_animator;
        anim_res = R.anim.abc_fade_in;
        array_res = R.array.array_res;
        attr_res = R.attr.actionBarDivider;
        bool_res = R.bool.abc_action_bar_embed_tabs;
        color_res = R.color.abc_background_cache_hint_selector_material_dark;
        dimen_res = R.dimen.abc_action_bar_content_inset_material;
        drawable_res = R.drawable.abc_ab_share_pack_mtrl_alpha;
        fraction_res = R.fraction.abc_fraction;
        id_res = R.id.ALT;
        integer_res = R.integer.abc_config_activityDefaultDur;
        interpolator_res = R.interpolator.abc_interpolator;
        layout_res = R.layout.abc_action_bar_view_list_nav_layout;
        menu_res = R.menu.menu_res;
        plurals_res = R.plurals.plurals_res;
        raw_res = R.raw.raw_res;
        string_res = R.string.abc_action_bar_home_description;
        styleable_res = R.styleable.ActionBarLayout_android_layout_gravity;
        xml_res = R.xml.file_paths;

    }

    void AnyResTest() {

        init();

        any_res = R.raw.raw_res;
        any_res = R.plurals.plurals_res;

        any_res = xml_res;
        any_res = string_res;

        // :: error: (assignment.type.incompatible)
        any_res = a;

        c = any_res;


        // :: error: (assignment.type.incompatible)
        any_res = a + b;

        // :: error: (assignment.type.incompatible) :: warning: (binary.operation.not.allowed)
        any_res = a / xml_res;

        // :: error: (assignment.type.incompatible) :: warning: (binary.operation.not.allowed)
        any_res = any_res * b;

        // :: warning: (binary.operation.not.allowed)
        a = animator_res - styleable_res;


        // :: warning: (compound.assignment.not.allowed)
        any_res += a;

        // :: warning: (compound.assignment.not.allowed)
        a *= any_res;

        // :: warning: (compound.assignment.not.allowed)
        any_res /= anim_res;

        // :: error: (compound.assignment.type.incompatible) :: warning: (compound.assignment.not.allowed)
        any_res -= b;

    }

    void Test() {
        @XmlRes int xml_res = R.xml.file_paths;


        // :: warning: (binary.operation.not.allowed)
        c = xml_res - b;

        // :: warning: (compound.assignment.not.allowed)
        xml_res += xml_res;
    }


}