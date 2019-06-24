package org.checkerframework.checker.androidresource;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.CompoundAssignmentTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree.Kind;
import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.source.Result;
import org.checkerframework.framework.type.AnnotatedTypeMirror;

public class AndroidResourceVisitor extends BaseTypeVisitor<AndroidResourceAnnotatedTypeFactory> {
    public AndroidResourceVisitor(BaseTypeChecker checker) {
        super(checker);
    }

    /**
     * Gives a warning whenever operands in a binary assignment have a annotation of type @XXXRes.
     */
    @Override
    public Void visitBinary(BinaryTree node, Void aVoid) {

        ExpressionTree leftOperand = node.getLeftOperand();
        ExpressionTree rightOperand = node.getRightOperand();
        AnnotatedTypeMirror leftOperandType = atypeFactory.getAnnotatedType(leftOperand);
        AnnotatedTypeMirror rightOperandType = atypeFactory.getAnnotatedType(rightOperand);

        Kind kind = node.getKind();

        System.out.println(node.toString() + ", " + node.getKind() + "\n");

        if (checkOperandsHasResAnnotations(leftOperandType) | checkOperandsHasResAnnotations(rightOperandType)) {
            checker.report(Result.warning("binary.operation.not.allowed", kind), node);
        }

        return super.visitBinary(node, aVoid);
    }

    /**
     * Gives a warning whenever expression/variable in a compound assignment have a annotation of type @XXXRes.
     */
    @Override
    public Void visitCompoundAssignment(CompoundAssignmentTree node, Void p) {

        ExpressionTree expression = node.getExpression();
        ExpressionTree variable = node.getVariable();
        AnnotatedTypeMirror expressionType = atypeFactory.getAnnotatedType(expression);
        AnnotatedTypeMirror variableType = atypeFactory.getAnnotatedType(variable);

        Kind kind = node.getKind();

        System.out.println(node.toString() + ", " + node.getKind() + "\n");

        if (checkOperandsHasResAnnotations(expressionType) | checkOperandsHasResAnnotations(variableType)) {
            checker.report(Result.warning("compound.assignment.not.allowed", kind), node);
        }

        return super.visitCompoundAssignment(node, p);
    }

    /**
     *  Method to check XXXRes annotations.
     *
     * @param annotatedTypeMirror
     * @return whether the given [AnnotatedTypeMirror] contains the XXXRes annoations or not.
     */
    public boolean checkOperandsHasResAnnotations(AnnotatedTypeMirror annotatedTypeMirror) {
        return annotatedTypeMirror.hasAnnotation(AnimatorRes.class) | annotatedTypeMirror.hasAnnotation(AnimRes.class)
                | annotatedTypeMirror.hasAnnotation(AnyRes.class) | annotatedTypeMirror.hasAnnotation(ArrayRes.class)
                | annotatedTypeMirror.hasAnnotation(AttrRes.class) | annotatedTypeMirror.hasAnnotation(BoolRes.class)
                | annotatedTypeMirror.hasAnnotation(ColorRes.class) | annotatedTypeMirror.hasAnnotation(DimenRes.class)
                | annotatedTypeMirror.hasAnnotation(DrawableRes.class) | annotatedTypeMirror.hasAnnotation(FractionRes.class)
                | annotatedTypeMirror.hasAnnotation(IdRes.class) | annotatedTypeMirror.hasAnnotation(IntegerRes.class)
                | annotatedTypeMirror.hasAnnotation(InterpolatorRes.class) | annotatedTypeMirror.hasAnnotation(LayoutRes.class)
                | annotatedTypeMirror.hasAnnotation(MenuRes.class) | annotatedTypeMirror.hasAnnotation(PluralsRes.class)
                | annotatedTypeMirror.hasAnnotation(RawRes.class) | annotatedTypeMirror.hasAnnotation(StringRes.class)
                | annotatedTypeMirror.hasAnnotation(StyleableRes.class) | annotatedTypeMirror.hasAnnotation(XmlRes.class);
    }
}
