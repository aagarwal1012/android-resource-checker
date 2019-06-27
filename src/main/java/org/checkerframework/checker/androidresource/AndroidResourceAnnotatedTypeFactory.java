package org.checkerframework.checker.androidresource;

import com.sun.source.tree.MemberSelectTree;
import org.checkerframework.checker.androidresource.qual.container.*;
import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.framework.type.AnnotatedTypeFactory;
import org.checkerframework.framework.type.AnnotatedTypeMirror;
import org.checkerframework.framework.type.treeannotator.ListTreeAnnotator;
import org.checkerframework.framework.type.treeannotator.TreeAnnotator;
import org.checkerframework.javacutil.AnnotationBuilder;

import javax.lang.model.element.AnnotationMirror;

public class AndroidResourceAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {

    protected final AnnotationMirror ANIMATOR_RES =
            AnnotationBuilder.fromClass(elements, AnimatorRes.class);
    protected final AnnotationMirror ANIM_RES =
            AnnotationBuilder.fromClass(elements, AnimRes.class);
    protected final AnnotationMirror ARRAY_RES =
            AnnotationBuilder.fromClass(elements, ArrayRes.class);
    protected final AnnotationMirror ATTR_RES =
            AnnotationBuilder.fromClass(elements, AttrRes.class);
    protected final AnnotationMirror BOOL_RES =
            AnnotationBuilder.fromClass(elements, BoolRes.class);
    protected final AnnotationMirror COLOR_RES =
            AnnotationBuilder.fromClass(elements, ColorRes.class);
    protected final AnnotationMirror DIMEN_RES =
            AnnotationBuilder.fromClass(elements, DimenRes.class);
    protected final AnnotationMirror DRAWABLE_RES =
            AnnotationBuilder.fromClass(elements, DrawableRes.class);
    protected final AnnotationMirror FRACTION_RES =
            AnnotationBuilder.fromClass(elements, FractionRes.class);
    protected final AnnotationMirror ID_RES =
            AnnotationBuilder.fromClass(elements, IdRes.class);
    protected final AnnotationMirror INTEGER_RES =
            AnnotationBuilder.fromClass(elements, IntegerRes.class);
    protected final AnnotationMirror INTERPOLATOR_RES =
            AnnotationBuilder.fromClass(elements, InterpolatorRes.class);
    protected final AnnotationMirror LAYOUT_RES =
            AnnotationBuilder.fromClass(elements, LayoutRes.class);
    protected final AnnotationMirror MENU_RES =
            AnnotationBuilder.fromClass(elements, MenuRes.class);
    protected final AnnotationMirror PLURALS_RES =
            AnnotationBuilder.fromClass(elements, PluralsRes.class);
    protected final AnnotationMirror RAW_RES =
            AnnotationBuilder.fromClass(elements, RawRes.class);
    protected final AnnotationMirror STRING_RES =
            AnnotationBuilder.fromClass(elements, StringRes.class);
    protected final AnnotationMirror STYLEABLE_RES =
            AnnotationBuilder.fromClass(elements, StyleableRes.class);
    protected final AnnotationMirror XML_RES =
            AnnotationBuilder.fromClass(elements, XmlRes.class);

    protected final AnnotationMirror ANIMATOR_CONTAINER =
            AnnotationBuilder.fromClass(elements, AnimatorContainer.class);
    protected final AnnotationMirror ANIM_CONTAINER =
            AnnotationBuilder.fromClass(elements, AnimContainer.class);
    protected final AnnotationMirror ARRAY_CONTAINER =
            AnnotationBuilder.fromClass(elements, ArrayContainer.class);
    protected final AnnotationMirror ATTR_CONTAINER =
            AnnotationBuilder.fromClass(elements, AttrContainer.class);
    protected final AnnotationMirror BOOL_CONTAINER =
            AnnotationBuilder.fromClass(elements, BoolContainer.class);
    protected final AnnotationMirror COLOR_CONTAINER =
            AnnotationBuilder.fromClass(elements, ColorContainer.class);
    protected final AnnotationMirror DIMEN_CONTAINER =
            AnnotationBuilder.fromClass(elements, DimenContainer.class);
    protected final AnnotationMirror DRAWABLE_CONTAINER =
            AnnotationBuilder.fromClass(elements, DrawableContainer.class);
    protected final AnnotationMirror FRACTION_CONTAINER =
            AnnotationBuilder.fromClass(elements, FractionContainer.class);
    protected final AnnotationMirror ID_CONTAINER =
            AnnotationBuilder.fromClass(elements, IdContainer.class);
    protected final AnnotationMirror INTEGER_CONTAINER =
            AnnotationBuilder.fromClass(elements, IntegerContainer.class);
    protected final AnnotationMirror INTERPOLATOR_CONTAINER =
            AnnotationBuilder.fromClass(elements, InterpolatorContainer.class);
    protected final AnnotationMirror LAYOUT_CONTAINER =
            AnnotationBuilder.fromClass(elements, LayoutContainer.class);
    protected final AnnotationMirror MENU_CONTAINER =
            AnnotationBuilder.fromClass(elements, MenuContainer.class);
    protected final AnnotationMirror PLURALS_CONTAINER =
            AnnotationBuilder.fromClass(elements, PluralsContainer.class);
    protected final AnnotationMirror RAW_CONTAINER =
            AnnotationBuilder.fromClass(elements, RawContainer.class);
    protected final AnnotationMirror STRING_CONTAINER =
            AnnotationBuilder.fromClass(elements, StringContainer.class);
    protected final AnnotationMirror STYLEABLE_CONTAINER =
            AnnotationBuilder.fromClass(elements, StyleableContainer.class);
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

        public AndroidResourceTreeAnnotator(AnnotatedTypeFactory atypeFactory) {
            super(atypeFactory);
        }

        /*
         * Method for a tree node for a member access expression. For example:
         *       expression . identifier
         */
        @Override
        public Void visitMemberSelect(MemberSelectTree node, AnnotatedTypeMirror annotatedTypeMirror) {

            String expression = node.getExpression().toString();
            String identifier = node.getIdentifier().toString();

            assignContainerAnnotations(annotatedTypeMirror, expression, identifier);

            assignResAnnotations(annotatedTypeMirror, expression);

//            System.out.println("Expression: " + node.getExpression() + ", Identifier: " + node.getIdentifier()
//                    + ", ATM: " + annotatedTypeMirror.toString() + "\n");

            return null;
        }

        /**
         * Assign @XXXRes annotations to member select.
         *
         * @param annotatedTypeMirror
         * @param expression
         */
        private void assignResAnnotations(AnnotatedTypeMirror annotatedTypeMirror, String expression) {
            if (expression.startsWith("R.")) {
                String containerExpression = expression.substring(2);
                switch (containerExpression) {
                    case "animator":
                        annotatedTypeMirror.replaceAnnotation(ANIMATOR_RES);
                        break;
                    case "anim":
                        annotatedTypeMirror.replaceAnnotation(ANIM_RES);
                        break;
                    case "array":
                        annotatedTypeMirror.replaceAnnotation(ARRAY_RES);
                        break;
                    case "attr":
                        annotatedTypeMirror.replaceAnnotation(ATTR_RES);
                        break;
                    case "bool":
                        annotatedTypeMirror.replaceAnnotation(BOOL_RES);
                        break;
                    case "color":
                        annotatedTypeMirror.replaceAnnotation(COLOR_RES);
                        break;
                    case "dimen":
                        annotatedTypeMirror.replaceAnnotation(DIMEN_RES);
                        break;
                    case "drawable":
                        annotatedTypeMirror.replaceAnnotation(DRAWABLE_RES);
                        break;
                    case "fraction":
                        annotatedTypeMirror.replaceAnnotation(FRACTION_RES);
                        break;
                    case "id":
                        annotatedTypeMirror.replaceAnnotation(ID_RES);
                        break;
                    case "integer":
                        annotatedTypeMirror.replaceAnnotation(INTEGER_RES);
                        break;
                    case "interpolator":
                        annotatedTypeMirror.replaceAnnotation(INTERPOLATOR_RES);
                        break;
                    case "layout":
                        annotatedTypeMirror.replaceAnnotation(LAYOUT_RES);
                        break;
                    case "menu":
                        annotatedTypeMirror.replaceAnnotation(MENU_RES);
                        break;
                    case "plurals":
                        annotatedTypeMirror.replaceAnnotation(PLURALS_RES);
                        break;
                    case "raw":
                        annotatedTypeMirror.replaceAnnotation(RAW_RES);
                        break;
                    case "string":
                        annotatedTypeMirror.replaceAnnotation(STRING_RES);
                        break;
                    case "styleable":
                        annotatedTypeMirror.replaceAnnotation(STYLEABLE_RES);
                        break;
                    case "xml":
                        annotatedTypeMirror.replaceAnnotation(XML_RES);
                        break;
                }
            }
        }

        /**
         * Assigning @XXXContainer annotations to member select.
         *
         * @param annotatedTypeMirror
         * @param expression
         * @param identifier
         */
        private void assignContainerAnnotations(AnnotatedTypeMirror annotatedTypeMirror, String expression, String identifier) {
            if (expression.equals("R")) {
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
}