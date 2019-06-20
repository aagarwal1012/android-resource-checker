package org.checkerframework.checker.androidresource;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree.Kind;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.source.Result;
import org.checkerframework.framework.type.AnnotatedTypeMirror;

public class AndroidResourceVisitor extends BaseTypeVisitor<AndroidResourceAnnotatedTypeFactory> {
    public AndroidResourceVisitor(BaseTypeChecker checker) {
        super(checker);
    }

    @Override
    public Void visitBinary(BinaryTree node, Void aVoid) {

        ExpressionTree leftOperand = node.getLeftOperand();
        ExpressionTree rightOperand = node.getRightOperand();
        AnnotatedTypeMirror leftOperandType = atypeFactory.getAnnotatedType(leftOperand);
        AnnotatedTypeMirror rightOperandType = atypeFactory.getAnnotatedType(rightOperand);

        Kind kind = node.getKind();

        switch (kind){
            case DIVIDE:
            case REMAINDER:
                if (leftOperandType.hasAnnotation())
                break;

            case RIGHT_SHIFT:
                if (leftOpType.hasAnnotation(Unsigned.class)
                        && !isMaskedShiftEitherSignedness(node)
                        && !isCastedShiftEitherSignedness(node)) {
                    checker.report(Result.failure("shift.signed", kind), leftOp);
                }
                break;

            case UNSIGNED_RIGHT_SHIFT:
                if (leftOpType.hasAnnotation(Signed.class)
                        && !isMaskedShiftEitherSignedness(node)
                        && !isCastedShiftEitherSignedness(node)) {
                    checker.report(Result.failure("shift.unsigned", kind), leftOp);
                }
                break;

            case LEFT_SHIFT:
                break;

            case GREATER_THAN:
            case GREATER_THAN_EQUAL:
            case LESS_THAN:
            case LESS_THAN_EQUAL:
                if (leftOpType.hasAnnotation(Unsigned.class)) {
                    checker.report(Result.failure("comparison.unsignedlhs"), leftOp);
                } else if (rightOpType.hasAnnotation(Unsigned.class)) {
                    checker.report(Result.failure("comparison.unsignedrhs"), rightOp);
                }
                break;

            case EQUAL_TO:
            case NOT_EQUAL_TO:
                if (leftOpType.hasAnnotation(Unsigned.class)
                        && rightOpType.hasAnnotation(Signed.class)) {
                    checker.report(Result.failure("comparison.mixed.unsignedlhs"), node);
                } else if (leftOpType.hasAnnotation(Signed.class)
                        && rightOpType.hasAnnotation(Unsigned.class)) {
                    checker.report(Result.failure("comparison.mixed.unsignedrhs"), node);
                }
                break;

            default:
                if (leftOpType.hasAnnotation(Unsigned.class)
                        && rightOpType.hasAnnotation(Signed.class)) {
                    checker.report(Result.failure("operation.mixed.unsignedlhs", kind), node);
                } else if (leftOpType.hasAnnotation(Signed.class)
                        && rightOpType.hasAnnotation(Unsigned.class)) {
                    checker.report(Result.failure("operation.mixed.unsignedrhs", kind), node);
                }
                break;
        }

        return super.visitBinary(node, aVoid);
    }
}
