package org.checkerframework.checker.androidresource;

import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.VariableTree;
import org.checkerframework.checker.androidresource.qual.Resource;
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

    protected final AnnotationMirror RESOURCE =
            AnnotationBuilder.fromClass(elements, Resource.class);

    protected final AnnotationMirror ANY_RES =
            AnnotationBuilder.fromClass(elements, AnyRes.class);
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

        @Override
        public Void visitVariable(VariableTree node, AnnotatedTypeMirror annotatedTypeMirror) {

            // Adding annotation to variable having type [R].
            if (node.getType().getClass().getName().endsWith(".R")) {
                annotatedTypeMirror.addAnnotation(RESOURCE);
            }

            return null;
        }


        /*
         * Method for a tree node for a member access expression. For example:
         *       expression . identifier
         */
        @Override
        public Void visitMemberSelect(MemberSelectTree node, AnnotatedTypeMirror annotatedTypeMirror) {

            String expressionClassName = node.getExpression().getClass().getName();

            // If expression is of type [R]
            if (expressionClassName.endsWith(".R")) {
                if (node.getIdentifier().length() != 0) {
                    // Assigning annotations to containers
                    switch (node.getIdentifier().toString()) {
                        case "animator":
                            annotatedTypeMirror.addAnnotation(ANIMATOR_CONTAINER);
                            break;
                        case "anim":
                            annotatedTypeMirror.addAnnotation(ANIM_CONTAINER);
                            break;
                        case "array":
                            annotatedTypeMirror.addAnnotation(ARRAY_CONTAINER);
                            break;
                        case "attr":
                            annotatedTypeMirror.addAnnotation(ATTR_CONTAINER);
                            break;
                        case "bool":
                            annotatedTypeMirror.addAnnotation(BOOL_CONTAINER);
                            break;
                        case "color":
                            annotatedTypeMirror.addAnnotation(COLOR_CONTAINER);
                            break;
                        case "dimen":
                            annotatedTypeMirror.addAnnotation(DIMEN_CONTAINER);
                            break;
                        case "drawable":
                            annotatedTypeMirror.addAnnotation(DRAWABLE_CONTAINER);
                            break;
                        case "fraction":
                            annotatedTypeMirror.addAnnotation(FRACTION_CONTAINER);
                            break;
                        case "id":
                            annotatedTypeMirror.addAnnotation(ID_CONTAINER);
                            break;
                        case "integer":
                            annotatedTypeMirror.addAnnotation(INTEGER_CONTAINER);
                            break;
                        case "interpolator":
                            annotatedTypeMirror.addAnnotation(INTERPOLATOR_CONTAINER);
                            break;
                        case "layout":
                            annotatedTypeMirror.addAnnotation(LAYOUT_CONTAINER);
                            break;
                        case "menu":
                            annotatedTypeMirror.addAnnotation(MENU_CONTAINER);
                            break;
                        case "plurals":
                            annotatedTypeMirror.addAnnotation(PLURALS_CONTAINER);
                            break;
                        case "raw":
                            annotatedTypeMirror.addAnnotation(RAW_CONTAINER);
                            break;
                        case "string":
                            annotatedTypeMirror.addAnnotation(STRING_CONTAINER);
                            break;
                        case "styleable":
                            annotatedTypeMirror.addAnnotation(STYLEABLE_CONTAINER);
                            break;
                        case "xml":
                            annotatedTypeMirror.addAnnotation(XML_CONTAINER);
                            break;
                    }
                }
            }

            // Add annotation to container elements.
            if (expressionClassName.contains(".R.")) {
                int index = expressionClassName.indexOf(".R.");
                String endPart = expressionClassName.substring(index + 3);
                switch (endPart) {
                    case "animator":
                        annotatedTypeMirror.addAnnotation(ANIMATOR_RES);
                        break;
                    case "anim":
                        annotatedTypeMirror.addAnnotation(ANIM_RES);
                        break;
                    case "array":
                        annotatedTypeMirror.addAnnotation(ARRAY_RES);
                        break;
                    case "attr":
                        annotatedTypeMirror.addAnnotation(ATTR_RES);
                        break;
                    case "bool":
                        annotatedTypeMirror.addAnnotation(BOOL_RES);
                        break;
                    case "color":
                        annotatedTypeMirror.addAnnotation(COLOR_RES);
                        break;
                    case "dimen":
                        annotatedTypeMirror.addAnnotation(DIMEN_RES);
                        break;
                    case "drawable":
                        annotatedTypeMirror.addAnnotation(DRAWABLE_RES);
                        break;
                    case "fraction":
                        annotatedTypeMirror.addAnnotation(FRACTION_RES);
                        break;
                    case "id":
                        annotatedTypeMirror.addAnnotation(ID_RES);
                        break;
                    case "integer":
                        annotatedTypeMirror.addAnnotation(INTEGER_RES);
                        break;
                    case "interpolator":
                        annotatedTypeMirror.addAnnotation(INTERPOLATOR_RES);
                        break;
                    case "layout":
                        annotatedTypeMirror.addAnnotation(LAYOUT_RES);
                        break;
                    case "menu":
                        annotatedTypeMirror.addAnnotation(MENU_RES);
                        break;
                    case "plurals":
                        annotatedTypeMirror.addAnnotation(PLURALS_RES);
                        break;
                    case "raw":
                        annotatedTypeMirror.addAnnotation(RAW_RES);
                        break;
                    case "string":
                        annotatedTypeMirror.addAnnotation(STRING_RES);
                        break;
                    case "styleable":
                        annotatedTypeMirror.addAnnotation(STYLEABLE_RES);
                        break;
                    case "xml":
                        annotatedTypeMirror.addAnnotation(XML_RES);
                        break;
                }
            }

            return null;
        }
    }
}
