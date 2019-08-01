package org.checkerframework.checker.androidresource;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.CompoundAssignmentTree;
import com.sun.source.tree.Tree.Kind;
import javax.lang.model.element.AnnotationMirror;
import org.checkerframework.checker.androidresource.qual.ResourceBottom;
import org.checkerframework.checker.androidresource.qual.ResourceTop;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.basetype.BaseTypeVisitor;
import org.checkerframework.framework.source.Result;
import org.checkerframework.framework.type.AnnotatedTypeMirror;
import org.checkerframework.javacutil.AnnotationBuilder;
import org.checkerframework.javacutil.AnnotationUtils;

/**
 * A type checking visitor for android-resource type system.
 *
 * <p>It gives warning when any variable/literal having {@code @XXXRes} or {@code @XXXContainer}
 * performs any binary operation{except {@code EQUAL_TO} and {@code NOT_EQUAL_TO}} or compound
 * assignment.
 */
public class AndroidResourceVisitor extends BaseTypeVisitor<AndroidResourceAnnotatedTypeFactory> {

  /** The @ResourceTop annotation. */
  protected final AnnotationMirror RESOURCE_TOP =
      AnnotationBuilder.fromClass(elements, ResourceTop.class);

  /** The @ResourceBottom annotation. */
  protected final AnnotationMirror RESOURCE_BOTTOM =
      AnnotationBuilder.fromClass(elements, ResourceBottom.class);

  public AndroidResourceVisitor(BaseTypeChecker checker) {
    super(checker);
  }

  /**
   * Gives a warning whenever operands in a binary assignment have a annotation of type <code>
   * @XXXRes</code> or <code>@XXXContainer</code>.
   */
  @Override
  public Void visitBinary(BinaryTree node, Void aVoid) {

    Kind kind = node.getKind();

    //        System.out.println(node.toString() + ", " + node.getKind() + "\n");

    switch (kind) {
      case EQUAL_TO:
      case NOT_EQUAL_TO:
        break;

      default:
        giveBinaryOperationWarning(node, kind);
    }

    return super.visitBinary(node, aVoid);
  }

  /** Issues warning to the {@link BinaryTree} node. */
  protected void giveBinaryOperationWarning(BinaryTree node, Kind kind) {

    AnnotatedTypeMirror leftOperandType = atypeFactory.getAnnotatedType(node.getLeftOperand());
    AnnotatedTypeMirror rightOperandType = atypeFactory.getAnnotatedType(node.getRightOperand());

    boolean leftOperandHasResOrContainerAnnotation =
        checkAnnotatedTypeHasResOrContainerAnnotations(leftOperandType);
    boolean rightOperandHasResOrContainerAnnotation =
        checkAnnotatedTypeHasResOrContainerAnnotations(rightOperandType);

    if (leftOperandHasResOrContainerAnnotation && !rightOperandHasResOrContainerAnnotation)
      checker.report(
          Result.warning("binary.operation.left.operand.found.resource", kind, leftOperandType),
          node);
    else if (!leftOperandHasResOrContainerAnnotation && rightOperandHasResOrContainerAnnotation)
      checker.report(
          Result.warning("binary.operation.right.operand.found.resource", kind, rightOperandType),
          node);
    else if (leftOperandHasResOrContainerAnnotation && rightOperandHasResOrContainerAnnotation)
      checker.report(
          Result.warning(
              "binary.operation.both.operand.found.resource",
              kind,
              leftOperandType,
              rightOperandType),
          node);
  }

  /**
   * Gives a warning whenever expression/variable in a compound assignment have a annotation of type
   * <code>@XXXRes</code> or <code>@XXXContainer</code>.
   */
  @Override
  public Void visitCompoundAssignment(CompoundAssignmentTree node, Void p) {

    AnnotatedTypeMirror expressionType = atypeFactory.getAnnotatedType(node.getExpression());
    AnnotatedTypeMirror variableType = atypeFactory.getAnnotatedType(node.getVariable());

    Kind kind = node.getKind();

    boolean expressionTypeHasResOrContainerAnnotations =
        checkAnnotatedTypeHasResOrContainerAnnotations(expressionType);
    boolean variableTypeHasResOrContainerAnnotations =
        checkAnnotatedTypeHasResOrContainerAnnotations(variableType);

    //        System.out.println(node.toString() + ", " + node.getKind() + "\n");

    if (expressionTypeHasResOrContainerAnnotations && !variableTypeHasResOrContainerAnnotations)
      checker.report(
          Result.warning("compound.assignment.expression.found.resource", kind, expressionType),
          node);
    else if (!expressionTypeHasResOrContainerAnnotations
        && variableTypeHasResOrContainerAnnotations)
      checker.report(
          Result.warning("compound.assignment.variable.found.resource", kind, variableType), node);
    else if (expressionTypeHasResOrContainerAnnotations && variableTypeHasResOrContainerAnnotations)
      checker.report(
          Result.warning(
              "compound.assignment.both.found.resource", kind, expressionType, variableType),
          node);

    return super.visitCompoundAssignment(node, p);
  }

  /**
   * Method to check <code>@XXXRes</code> or <code>@XXXContainer</code> annotations.
   *
   * @return whether the given {@link AnnotatedTypeMirror} contains the <code>@XXXRes</code> or
   *     <code>@XXXContainer</code> annotations or not.
   */
  public boolean checkAnnotatedTypeHasResOrContainerAnnotations(
      AnnotatedTypeMirror annotatedTypeMirror) {

    AnnotationMirror annotationMirror = annotatedTypeMirror.getAnnotationInHierarchy(RESOURCE_TOP);

    return annotationMirror != null
        && !AnnotationUtils.areSame(annotationMirror, RESOURCE_TOP)
        && !AnnotationUtils.areSame(annotationMirror, RESOURCE_BOTTOM);
  }
}
