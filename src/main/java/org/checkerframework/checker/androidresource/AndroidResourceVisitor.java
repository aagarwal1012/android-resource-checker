package org.checkerframework.checker.androidresource;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.CompoundAssignmentTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree.Kind;
import org.checkerframework.checker.androidresource.qual.ResourceBottom;
import org.checkerframework.checker.androidresource.qual.ResourceTop;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.source.Result;
import org.checkerframework.framework.type.AnnotatedTypeMirror;
import org.checkerframework.javacutil.AnnotationBuilder;

import javax.lang.model.element.AnnotationMirror;

public class AndroidResourceVisitor extends BaseTypeVisitor<AndroidResourceAnnotatedTypeFactory> {

    /**
     * The @ResourceTop annotation.
     */
    protected final AnnotationMirror RESOURCE_TOP =
            AnnotationBuilder.fromClass(elements, ResourceTop.class);

    /**
     * The @ResourceBottom annotation.
     */
    protected final AnnotationMirror RESOURCE_BOTTOM =
            AnnotationBuilder.fromClass(elements, ResourceBottom.class);

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

//        System.out.println(node.toString() + ", " + node.getKind() + "\n");

        switch (kind) {
            case EQUAL_TO:
                break;
            case NOT_EQUAL_TO:
                break;
            default:
                if (checkAnnotatedTypeHasResOrContainerAnnotations(leftOperandType) || checkAnnotatedTypeHasResOrContainerAnnotations(rightOperandType)) {
                    checker.report(Result.warning("binary.operation.not.allowed", kind), node);
                }
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

//        System.out.println(node.toString() + ", " + node.getKind() + "\n");

        if (checkAnnotatedTypeHasResOrContainerAnnotations(expressionType) || checkAnnotatedTypeHasResOrContainerAnnotations(variableType)) {
            checker.report(Result.warning("compound.assignment.not.allowed", kind), node);
        }

        return super.visitCompoundAssignment(node, p);
    }

    /**
     * Method to check XXXRes or XXXContainer annotations.
     *
     * @return whether the given [AnnotatedTypeMirror] contains the XXXRes or XXXContainer annotations or not.
     */
    public boolean checkAnnotatedTypeHasResOrContainerAnnotations(AnnotatedTypeMirror annotatedTypeMirror) {

        AnnotationMirror annotationMirror = annotatedTypeMirror.getAnnotationInHierarchy(RESOURCE_TOP);

        if (annotationMirror == null)
            return false;
        else if (annotationMirror.equals(RESOURCE_TOP) || annotationMirror.equals(RESOURCE_BOTTOM))
            return false;
        else
            return true;
    }
}

