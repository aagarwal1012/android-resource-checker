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

/**
 * AndroidResourceAnnotatedTypeFactory build types with @XXXRes and @XXXContainer annotations.
 */
public class AndroidResourceAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {

    /**
     * The @ResourceTop annotation.
     */
    protected final AnnotationMirror RESOURCE_TOP =
            AnnotationBuilder.fromClass(elements, ResourceTop.class);

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
     * The @XmlContainer annotation.
     */
    protected final AnnotationMirror XML_CONTAINER =
            AnnotationBuilder.fromClass(elements, XmlContainer.class);

    public AndroidResourceAnnotatedTypeFactory(BaseTypeChecker checker) {
        super(checker);
        postInit();
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
         * Assign @XXXRes annotations to member select.
         * First it checks whether the expression has the @XXXContainer annotation
         * then allocates the corresponding @XXXRes annotation.
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

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, PLURALS_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(PLURALS_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, RAW_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(RAW_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, STRING_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(STRING_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, STYLEABLE_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(STYLEABLE_RES);

            else if (AnnotationUtils.areSame(expressionContainerAnnotation, XML_CONTAINER))
                annotatedTypeMirror.replaceAnnotation(XML_RES);

        }

        /**
         * Assigning @XXXContainer annotations to member select.
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
                case "xml":
                    annotatedTypeMirror.replaceAnnotation(XML_CONTAINER);
                    break;
            }
        }
    }
}
