package org.checkerframework.checker.androidresource;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.MemberSelectTree;
import org.checkerframework.checker.androidresource.qual.ResourceTop;
import org.checkerframework.checker.androidresource.qual.container.*;
import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.framework.type.AnnotatedTypeFactory;
import org.checkerframework.framework.type.AnnotatedTypeMirror;
import org.checkerframework.framework.type.treeannotator.ListTreeAnnotator;
import org.checkerframework.framework.type.treeannotator.TreeAnnotator;
import org.checkerframework.javacutil.AnnotationBuilder;
import org.checkerframework.javacutil.AnnotationUtils;

import javax.lang.model.element.AnnotationMirror;
import java.util.Arrays;
import java.util.List;

/**
 * AndroidResourceAnnotatedTypeFactory build types with <code>@XXXRes</code> or <code>@XXXContainer</code> annotations.
 */
public class AndroidResourceAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {

    /**
     * The @ResourceTop annotation.
     */
    protected final AnnotationMirror RESOURCE_TOP =
            AnnotationBuilder.fromClass(elements, ResourceTop.class);

    /**
     * The @AnyRes annotation.
     */
    protected final AnnotationMirror ANY_RES =
            AnnotationBuilder.fromClass(elements, AnyRes.class);

    /**
     * The @AnimatorRes annotation.
     */
    protected final AnnotationMirror ANIMATOR_RES =
            AnnotationBuilder.fromClass(elements, AnimatorRes.class);
    /**
     * The @AnimRes annotation.
     */
    protected final AnnotationMirror ANIM_RES =
            AnnotationBuilder.fromClass(elements, AnimRes.class);
    /**
     * The @ArrayRes annotation.
     */
    protected final AnnotationMirror ARRAY_RES =
            AnnotationBuilder.fromClass(elements, ArrayRes.class);
    /**
     * The @AttrRes annotation.
     */
    protected final AnnotationMirror ATTR_RES =
            AnnotationBuilder.fromClass(elements, AttrRes.class);
    /**
     * The @BoolRes annotation.
     */
    protected final AnnotationMirror BOOL_RES =
            AnnotationBuilder.fromClass(elements, BoolRes.class);
    /**
     * The @ColorRes annotation.
     */
    protected final AnnotationMirror COLOR_RES =
            AnnotationBuilder.fromClass(elements, ColorRes.class);
    /**
     * The @DimenRes annotation.
     */
    protected final AnnotationMirror DIMEN_RES =
            AnnotationBuilder.fromClass(elements, DimenRes.class);
    /**
     * The @DrawableRes annotation.
     */
    protected final AnnotationMirror DRAWABLE_RES =
            AnnotationBuilder.fromClass(elements, DrawableRes.class);
    /**
     * The @FontRes annotation.
     */
    protected final AnnotationMirror FONT_RES =
            AnnotationBuilder.fromClass(elements, FontRes.class);
    /**
     * The @FractionRes annotation.
     */
    protected final AnnotationMirror FRACTION_RES =
            AnnotationBuilder.fromClass(elements, FractionRes.class);
    /**
     * The @IdRes annotation.
     */
    protected final AnnotationMirror ID_RES =
            AnnotationBuilder.fromClass(elements, IdRes.class);
    /**
     * The @IntegerRes annotation.
     */
    protected final AnnotationMirror INTEGER_RES =
            AnnotationBuilder.fromClass(elements, IntegerRes.class);
    /**
     * The @InterpolatorRes annotation.
     */
    protected final AnnotationMirror INTERPOLATOR_RES =
            AnnotationBuilder.fromClass(elements, InterpolatorRes.class);
    /**
     * The @LayoutRes annotation.
     */
    protected final AnnotationMirror LAYOUT_RES =
            AnnotationBuilder.fromClass(elements, LayoutRes.class);
    /**
     * The @MenuRes annotation.
     */
    protected final AnnotationMirror MENU_RES =
            AnnotationBuilder.fromClass(elements, MenuRes.class);
    /**
     * The @NavigationRes annotation.
     */
    protected final AnnotationMirror NAVIGATION_RES =
            AnnotationBuilder.fromClass(elements, NavigationRes.class);
    /**
     * The @PluralsRes annotation.
     */
    protected final AnnotationMirror PLURALS_RES =
            AnnotationBuilder.fromClass(elements, PluralsRes.class);
    /**
     * The @RawRes annotation.
     */
    protected final AnnotationMirror RAW_RES =
            AnnotationBuilder.fromClass(elements, RawRes.class);
    /**
     * The @StringRes annotation.
     */
    protected final AnnotationMirror STRING_RES =
            AnnotationBuilder.fromClass(elements, StringRes.class);
    /**
     * The @StyleableRes annotation.
     */
    protected final AnnotationMirror STYLEABLE_RES =
            AnnotationBuilder.fromClass(elements, StyleableRes.class);
    /**
     * The @StyleRes annotation.
     */
    protected final AnnotationMirror STYLE_RES =
            AnnotationBuilder.fromClass(elements, StyleRes.class);
    /**
     * The @TransitionRes annotation.
     */
    protected final AnnotationMirror TRANSITION_RES =
            AnnotationBuilder.fromClass(elements, TransitionRes.class);
    /**
     * The @XmlRes annotation.
     */
    protected final AnnotationMirror XML_RES =
            AnnotationBuilder.fromClass(elements, XmlRes.class);

    /**
     * The @AnimatorContainer annotation.
     */
    protected final AnnotationMirror ANIMATOR_CONTAINER =
            AnnotationBuilder.fromClass(elements, AnimatorContainer.class);
    /**
     * The @AnimContainer annotation.
     */
    protected final AnnotationMirror ANIM_CONTAINER =
            AnnotationBuilder.fromClass(elements, AnimContainer.class);
    /**
     * The @ArrayContainer annotation.
     */
    protected final AnnotationMirror ARRAY_CONTAINER =
            AnnotationBuilder.fromClass(elements, ArrayContainer.class);
    /**
     * The @AttrContainer annotation.
     */
    protected final AnnotationMirror ATTR_CONTAINER =
            AnnotationBuilder.fromClass(elements, AttrContainer.class);
    /**
     * The @BoolContainer annotation.
     */
    protected final AnnotationMirror BOOL_CONTAINER =
            AnnotationBuilder.fromClass(elements, BoolContainer.class);
    /**
     * The @ColorContainer annotation.
     */
    protected final AnnotationMirror COLOR_CONTAINER =
            AnnotationBuilder.fromClass(elements, ColorContainer.class);
    /**
     * The @DimenContainer annotation.
     */
    protected final AnnotationMirror DIMEN_CONTAINER =
            AnnotationBuilder.fromClass(elements, DimenContainer.class);
    /**
     * The @DrawableContainer annotation.
     */
    protected final AnnotationMirror DRAWABLE_CONTAINER =
            AnnotationBuilder.fromClass(elements, DrawableContainer.class);
    /**
     * The @FontContainer annotation.
     */
    protected final AnnotationMirror FONT_CONTAINER =
            AnnotationBuilder.fromClass(elements, FontContainer.class);
    /**
     * The @FractionContainer annotation.
     */
    protected final AnnotationMirror FRACTION_CONTAINER =
            AnnotationBuilder.fromClass(elements, FractionContainer.class);
    /**
     * The @IdContainer annotation.
     */
    protected final AnnotationMirror ID_CONTAINER =
            AnnotationBuilder.fromClass(elements, IdContainer.class);
    /**
     * The @IntegerContainer annotation.
     */
    protected final AnnotationMirror INTEGER_CONTAINER =
            AnnotationBuilder.fromClass(elements, IntegerContainer.class);
    /**
     * The @InterpolatorContainer annotation.
     */
    protected final AnnotationMirror INTERPOLATOR_CONTAINER =
            AnnotationBuilder.fromClass(elements, InterpolatorContainer.class);
    /**
     * The @LayoutContainer annotation.
     */
    protected final AnnotationMirror LAYOUT_CONTAINER =
            AnnotationBuilder.fromClass(elements, LayoutContainer.class);
    /**
     * The @MenuContainer annotation.
     */
    protected final AnnotationMirror MENU_CONTAINER =
            AnnotationBuilder.fromClass(elements, MenuContainer.class);
    /**
     * The @NavigationContainer annotation.
     */
    protected final AnnotationMirror NAVIGATION_CONTAINER =
            AnnotationBuilder.fromClass(elements, NavigationContainer.class);
    /**
     * The @PluralsContainer annotation.
     */
    protected final AnnotationMirror PLURALS_CONTAINER =
            AnnotationBuilder.fromClass(elements, PluralsContainer.class);
    /**
     * The @RawContainer annotation.
     */
    protected final AnnotationMirror RAW_CONTAINER =
            AnnotationBuilder.fromClass(elements, RawContainer.class);
    /**
     * The @StringContainer annotation.
     */
    protected final AnnotationMirror STRING_CONTAINER =
            AnnotationBuilder.fromClass(elements, StringContainer.class);
    /**
     * The @StyleableContainer annotation.
     */
    protected final AnnotationMirror STYLEABLE_CONTAINER =
            AnnotationBuilder.fromClass(elements, StyleableContainer.class);
    /**
     * The @StyleContainer annotation.
     */
    protected final AnnotationMirror STYLE_CONTAINER =
            AnnotationBuilder.fromClass(elements, StyleContainer.class);
    /**
     * The @TransitionContainer annotation.
     */
    protected final AnnotationMirror TRANSITION_CONTAINER =
            AnnotationBuilder.fromClass(elements, TransitionContainer.class);
    /**
     * The @XmlContainer annotation.
     */
    protected final AnnotationMirror XML_CONTAINER =
            AnnotationBuilder.fromClass(elements, XmlContainer.class);

    /**
     * Contains Android package prefixes for the actual annotations.
     */
    private static final List<String> ANDROID_PACKAGE_PREFIXES = Arrays.asList(
            // https://android.googlesource.com/platform/frameworks/base/+/master/core/java/android/annotation/
            "android.annotation.",
            // https://developer.android.com/reference/android/support/annotation/package-summary
            "android.support.annotation.",
            // https://developer.android.com/reference/androidx/annotation/package-summary
            "androidx.annotation.");

    public AndroidResourceAnnotatedTypeFactory(BaseTypeChecker checker) {
        super(checker);
        makeAndroidAnnotationsAliasesToChecker();
        postInit();
    }

    /**
     * Make the Android <code>@XXXRes</code> annotations aliases to <i>android-resource-checker</i> annotations.
     */
    private void makeAndroidAnnotationsAliasesToChecker() {

        ANDROID_PACKAGE_PREFIXES.forEach((annotation) -> {
            addAliasedAnnotation(annotation + "AnyRes", ANY_RES);

            addAliasedAnnotation(annotation + "AnimatorRes", ANIMATOR_RES);
            addAliasedAnnotation(annotation + "AnimRes", ANIM_RES);
            addAliasedAnnotation(annotation + "ArrayRes", ARRAY_RES);
            addAliasedAnnotation(annotation + "AttrRes", ATTR_RES);
            addAliasedAnnotation(annotation + "BoolRes", BOOL_RES);
            addAliasedAnnotation(annotation + "ColorRes", COLOR_RES);
            addAliasedAnnotation(annotation + "DimenRes", DIMEN_RES);
            addAliasedAnnotation(annotation + "DrawableRes", DRAWABLE_RES);
            addAliasedAnnotation(annotation + "FractionRes", FRACTION_RES);
            addAliasedAnnotation(annotation + "IdRes", ID_RES);
            addAliasedAnnotation(annotation + "IntegerRes", INTEGER_RES);
            addAliasedAnnotation(annotation + "InterpolatorRes", INTERPOLATOR_RES);
            addAliasedAnnotation(annotation + "LayoutRes", LAYOUT_RES);
            addAliasedAnnotation(annotation + "MenuRes", MENU_RES);
            addAliasedAnnotation(annotation + "PluralsRes", PLURALS_RES);
            addAliasedAnnotation(annotation + "RawRes", RAW_RES);
            addAliasedAnnotation(annotation + "StringRes", STRING_RES);
            addAliasedAnnotation(annotation + "StyleableRes", STYLEABLE_RES);
            addAliasedAnnotation(annotation + "XmlRes", XML_RES);
        });
    }

    @Override
    protected TreeAnnotator createTreeAnnotator() {
        return new ListTreeAnnotator(
                new AndroidResourceTreeAnnotator(this), super.createTreeAnnotator());
    }

    private class AndroidResourceTreeAnnotator extends TreeAnnotator {

        public AndroidResourceTreeAnnotator(AnnotatedTypeFactory annotatedTypeFactory) {
            super(annotatedTypeFactory);
        }

        /*
         * Method for a tree node for a member access expression. For example:
         *       expression . identifier
         */
        @Override
        public Void visitMemberSelect(MemberSelectTree node, AnnotatedTypeMirror annotatedTypeMirror) {

            assignContainerAnnotations(annotatedTypeMirror, node);

            assignResAnnotations(annotatedTypeMirror, node.getExpression());

//            System.out.println("Expression: " + node.getExpression() + ", Identifier: " + node.getIdentifier()
//                    + ", ATM: " + annotatedTypeMirror.toString() + "\n");

            return null;
        }

        /**
         * Assign <code>@XXXRes</code> annotations to member select.
         * First it checks whether the expression has the <code>@XXXContainer</code> annotation
         * then allocates the corresponding <code>@XXXRes</code> annotation.
         */
        private void assignResAnnotations(AnnotatedTypeMirror annotatedTypeMirror, ExpressionTree expressionTree) {

            AnnotatedTypeMirror expressionAnnotatedTypeMirror = getAnnotatedType(expressionTree);

            // Get the annotation from the {@ResourceTop} sub-hierarchy,
            // if such an annotation targets this type; otherwise returns null.
            AnnotationMirror expressionContainerAnnotation = expressionAnnotatedTypeMirror.getAnnotationInHierarchy(RESOURCE_TOP);

            // checks if {expressionContainerAnnotation} is not null.
            if (expressionContainerAnnotation == null)
                return;

            // assigning @XXXRes annotations.
            if (AnnotationUtils.areSame(expressionContainerAnnotation, ANIMATOR_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(ANIMATOR_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, ANIM_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(ANIM_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, ARRAY_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(ARRAY_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, ATTR_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(ATTR_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, BOOL_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(BOOL_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, COLOR_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(COLOR_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, DIMEN_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(DIMEN_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, DRAWABLE_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(DRAWABLE_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, FONT_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(FONT_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, FRACTION_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(FRACTION_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, ID_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(ID_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, INTEGER_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(INTEGER_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, INTERPOLATOR_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(INTERPOLATOR_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, LAYOUT_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(LAYOUT_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, MENU_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(MENU_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, NAVIGATION_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(NAVIGATION_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, PLURALS_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(PLURALS_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, RAW_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(RAW_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, STRING_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(STRING_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, STYLEABLE_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(STYLEABLE_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, STYLE_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(STYLE_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, TRANSITION_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(TRANSITION_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, XML_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(XML_RES);

        }

        /**
         * Assigning <code>@XXXContainer</code> annotations to member select.
         */
        private void assignContainerAnnotations(AnnotatedTypeMirror annotatedTypeMirror, MemberSelectTree node) {

            String expression = node.getExpression().toString();
            String identifier = node.getIdentifier().toString();

            // checks if expression doesn't equal to {R} -> return.
            if (!expression.equals("R"))
                return;

            // assign @XXXContainer annotations.
            switch (identifier) {
                case "animator":
                    annotatedTypeMirror.replaceAnnotation(ANIMATOR_CONTAINER);
                    break;
                case "anim":
                    annotatedTypeMirror.replaceAnnotation(ANIM_CONTAINER);
                    break;
                case "array":
                    annotatedTypeMirror.replaceAnnotation(ARRAY_CONTAINER);
                    break;
                case "attr":
                    annotatedTypeMirror.replaceAnnotation(ATTR_CONTAINER);
                    break;
                case "bool":
                    annotatedTypeMirror.replaceAnnotation(BOOL_CONTAINER);
                    break;
                case "color":
                    annotatedTypeMirror.replaceAnnotation(COLOR_CONTAINER);
                    break;
                case "dimen":
                    annotatedTypeMirror.replaceAnnotation(DIMEN_CONTAINER);
                    break;
                case "drawable":
                    annotatedTypeMirror.replaceAnnotation(DRAWABLE_CONTAINER);
                    break;
                case "font":
                    annotatedTypeMirror.replaceAnnotation(FONT_CONTAINER);
                    break;
                case "fraction":
                    annotatedTypeMirror.replaceAnnotation(FRACTION_CONTAINER);
                    break;
                case "id":
                    annotatedTypeMirror.replaceAnnotation(ID_CONTAINER);
                    break;
                case "integer":
                    annotatedTypeMirror.replaceAnnotation(INTEGER_CONTAINER);
                    break;
                case "interpolator":
                    annotatedTypeMirror.replaceAnnotation(INTERPOLATOR_CONTAINER);
                    break;
                case "layout":
                    annotatedTypeMirror.replaceAnnotation(LAYOUT_CONTAINER);
                    break;
                case "menu":
                    annotatedTypeMirror.replaceAnnotation(MENU_CONTAINER);
                    break;
                case "navigation":
                    annotatedTypeMirror.replaceAnnotation(NAVIGATION_CONTAINER);
                    break;
                case "plurals":
                    annotatedTypeMirror.replaceAnnotation(PLURALS_CONTAINER);
                    break;
                case "raw":
                    annotatedTypeMirror.replaceAnnotation(RAW_CONTAINER);
                    break;
                case "string":
                    annotatedTypeMirror.replaceAnnotation(STRING_CONTAINER);
                    break;
                case "styleable":
                    annotatedTypeMirror.replaceAnnotation(STYLEABLE_CONTAINER);
                    break;
                case "style":
                    annotatedTypeMirror.replaceAnnotation(STYLE_CONTAINER);
                    break;
                case "transition":
                    annotatedTypeMirror.replaceAnnotation(TRANSITION_CONTAINER);
                    break;
                case "xml":
                    annotatedTypeMirror.replaceAnnotation(XML_CONTAINER);
                    break;
            }
        }
    }
}
