/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.pivot/model/pivot.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractExtendingVisitor.java,v 1.5 2011/02/15 10:38:46 ewillink Exp $
 */
package	org.eclipse.ocl.examples.pivot.util;

/**
 * An AbstractExtendingVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingVisitor(C context) {
	    super(context);
	}	

	public R visitAnnotation(org.eclipse.ocl.examples.pivot.Annotation object) {
		return visitNamedElement(object);
	}

	public R visitAnyType(org.eclipse.ocl.examples.pivot.AnyType object) {
		return visitClass(object);
	}

	public R visitAssociationClass(org.eclipse.ocl.examples.pivot.AssociationClass object) {
		return visitClass(object);
	}

	public R visitAssociationClassCallExp(org.eclipse.ocl.examples.pivot.AssociationClassCallExp object) {
		return visitNavigationCallExp(object);
	}

	public R visitBagType(org.eclipse.ocl.examples.pivot.BagType object) {
		return visitCollectionType(object);
	}

	public R visitBooleanLiteralExp(org.eclipse.ocl.examples.pivot.BooleanLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public R visitCallExp(org.eclipse.ocl.examples.pivot.CallExp object) {
		return visitOclExpression(object);
	}

	public R visitCallOperationAction(org.eclipse.ocl.examples.pivot.CallOperationAction object) {
		return visitNamedElement(object);
	}

	public R visitClass(org.eclipse.ocl.examples.pivot.Class object) {
		return visitType(object);
	}

	public R visitCollectionItem(org.eclipse.ocl.examples.pivot.CollectionItem object) {
		return visitCollectionLiteralPart(object);
	}

	public R visitCollectionLiteralExp(org.eclipse.ocl.examples.pivot.CollectionLiteralExp object) {
		return visitLiteralExp(object);
	}

	public R visitCollectionLiteralPart(org.eclipse.ocl.examples.pivot.CollectionLiteralPart object) {
		return visitTypedElement(object);
	}

	public R visitCollectionRange(org.eclipse.ocl.examples.pivot.CollectionRange object) {
		return visitCollectionLiteralPart(object);
	}

	public R visitCollectionType(org.eclipse.ocl.examples.pivot.CollectionType object) {
		return visitDataType(object);
	}

	public R visitComment(org.eclipse.ocl.examples.pivot.Comment object) {
		return visitElement(object);
	}

	public R visitCompleteEnvironment(org.eclipse.ocl.examples.pivot.CompleteEnvironment object) {
		return visitPackage(object);
	}

	public R visitCompleteIteration(org.eclipse.ocl.examples.pivot.CompleteIteration object) {
		return visitIteration(object);
	}

	public R visitCompleteOperation(org.eclipse.ocl.examples.pivot.CompleteOperation object) {
		return visitOperation(object);
	}

	public R visitCompletePackage(org.eclipse.ocl.examples.pivot.CompletePackage object) {
		return visitPackage(object);
	}

	public R visitCompleteProperty(org.eclipse.ocl.examples.pivot.CompleteProperty object) {
		return visitProperty(object);
	}

	public R visitCompleteType(org.eclipse.ocl.examples.pivot.CompleteType object) {
		return visitClass(object);
	}

	public R visitConstraint(org.eclipse.ocl.examples.pivot.Constraint object) {
		return visitNamedElement(object);
	}

	public R visitDataType(org.eclipse.ocl.examples.pivot.DataType object) {
		return visitClass(object);
	}

	public R visitDetail(org.eclipse.ocl.examples.pivot.Detail object) {
		return visitNamedElement(object);
	}

	public R visitElement(org.eclipse.ocl.examples.pivot.Element object) {
		return visiting(object);
	}

	public R visitEnumLiteralExp(org.eclipse.ocl.examples.pivot.EnumLiteralExp object) {
		return visitLiteralExp(object);
	}

	public R visitEnumeration(org.eclipse.ocl.examples.pivot.Enumeration object) {
		return visitDataType(object);
	}

	public R visitEnumerationLiteral(org.eclipse.ocl.examples.pivot.EnumerationLiteral object) {
		return visitNamedElement(object);
	}

	public R visitExpressionInOcl(org.eclipse.ocl.examples.pivot.ExpressionInOcl object) {
		return visitOpaqueExpression(object);
	}

	public R visitFeature(org.eclipse.ocl.examples.pivot.Feature object) {
		return visitTypedMultiplicityElement(object);
	}

	public R visitFeatureCallExp(org.eclipse.ocl.examples.pivot.FeatureCallExp object) {
		return visitCallExp(object);
	}

	public R visitIfExp(org.eclipse.ocl.examples.pivot.IfExp object) {
		return visitOclExpression(object);
	}

	public R visitIntegerLiteralExp(org.eclipse.ocl.examples.pivot.IntegerLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	public R visitInvalidLiteralExp(org.eclipse.ocl.examples.pivot.InvalidLiteralExp object) {
		return visitLiteralExp(object);
	}

	public R visitInvalidType(org.eclipse.ocl.examples.pivot.InvalidType object) {
		return visitClass(object);
	}

	public R visitIterateExp(org.eclipse.ocl.examples.pivot.IterateExp object) {
		return visitLoopExp(object);
	}

	public R visitIteration(org.eclipse.ocl.examples.pivot.Iteration object) {
		return visitOperation(object);
	}

	public R visitIteratorExp(org.eclipse.ocl.examples.pivot.IteratorExp object) {
		return visitLoopExp(object);
	}

	public R visitLambdaType(org.eclipse.ocl.examples.pivot.LambdaType object) {
		return visitDataType(object);
	}

	public R visitLetExp(org.eclipse.ocl.examples.pivot.LetExp object) {
		return visitOclExpression(object);
	}

	public R visitLibrary(org.eclipse.ocl.examples.pivot.Library object) {
		return visitPackage(object);
	}

	public R visitLiteralExp(org.eclipse.ocl.examples.pivot.LiteralExp object) {
		return visitOclExpression(object);
	}

	public R visitLoopExp(org.eclipse.ocl.examples.pivot.LoopExp object) {
		return visitCallExp(object);
	}

	public R visitMessageExp(org.eclipse.ocl.examples.pivot.MessageExp object) {
		return visitOclExpression(object);
	}

	public R visitMessageType(org.eclipse.ocl.examples.pivot.MessageType object) {
		return visitType(object);
	}

	public R visitMonikeredElement(org.eclipse.ocl.examples.pivot.MonikeredElement object) {
		return visitElement(object);
	}

	public R visitMultiplicityElement(org.eclipse.ocl.examples.pivot.MultiplicityElement object) {
		return visitMonikeredElement(object);
	}

	public R visitNamedElement(org.eclipse.ocl.examples.pivot.NamedElement object) {
		return visitMonikeredElement(object);
	}

	public R visitNamespace(org.eclipse.ocl.examples.pivot.Namespace object) {
		return visitNamedElement(object);
	}

	public R visitNavigationCallExp(org.eclipse.ocl.examples.pivot.NavigationCallExp object) {
		return visitFeatureCallExp(object);
	}

	public R visitNullLiteralExp(org.eclipse.ocl.examples.pivot.NullLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public R visitNumericLiteralExp(org.eclipse.ocl.examples.pivot.NumericLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public R visitOclExpression(org.eclipse.ocl.examples.pivot.OclExpression object) {
		return visitTypedElement(object);
	}

	public R visitOpaqueExpression(org.eclipse.ocl.examples.pivot.OpaqueExpression object) {
		return visitValueSpecification(object);
	}

	public R visitOperation(org.eclipse.ocl.examples.pivot.Operation object) {
		return visitTypedElement(object);
	}

	public R visitOperationCallExp(org.eclipse.ocl.examples.pivot.OperationCallExp object) {
		return visitFeatureCallExp(object);
	}

	public R visitOperationTemplateParameter(org.eclipse.ocl.examples.pivot.OperationTemplateParameter object) {
		return visitTemplateParameter(object);
	}

	public R visitOrderedSetType(org.eclipse.ocl.examples.pivot.OrderedSetType object) {
		return visitCollectionType(object);
	}

	public R visitPackage(org.eclipse.ocl.examples.pivot.Package object) {
		return visitNamespace(object);
	}

	public R visitPackageableElement(org.eclipse.ocl.examples.pivot.PackageableElement object) {
		return visitParameterableElement(object);
	}

	public R visitParameter(org.eclipse.ocl.examples.pivot.Parameter object) {
		return visitTypedMultiplicityElement(object);
	}

	public R visitParameterableElement(org.eclipse.ocl.examples.pivot.ParameterableElement object) {
		return visitMonikeredElement(object);
	}

	public R visitPrecedence(org.eclipse.ocl.examples.pivot.Precedence object) {
		return visitNamedElement(object);
	}

	public R visitPrimitiveLiteralExp(org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp object) {
		return visitLiteralExp(object);
	}

	public R visitPrimitiveType(org.eclipse.ocl.examples.pivot.PrimitiveType object) {
		return visitDataType(object);
	}

	public R visitProperty(org.eclipse.ocl.examples.pivot.Property object) {
		return visitTypedElement(object);
	}

	public R visitPropertyCallExp(org.eclipse.ocl.examples.pivot.PropertyCallExp object) {
		return visitNavigationCallExp(object);
	}

	public R visitRealLiteralExp(org.eclipse.ocl.examples.pivot.RealLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	public R visitSendSignalAction(org.eclipse.ocl.examples.pivot.SendSignalAction object) {
		return visitNamedElement(object);
	}

	public R visitSequenceType(org.eclipse.ocl.examples.pivot.SequenceType object) {
		return visitCollectionType(object);
	}

	public R visitSetType(org.eclipse.ocl.examples.pivot.SetType object) {
		return visitCollectionType(object);
	}

	public R visitSignal(org.eclipse.ocl.examples.pivot.Signal object) {
		return visitNamedElement(object);
	}

	public R visitState(org.eclipse.ocl.examples.pivot.State object) {
		return visitNamedElement(object);
	}

	public R visitStateExp(org.eclipse.ocl.examples.pivot.StateExp object) {
		return visitOclExpression(object);
	}

	public R visitStringLiteralExp(org.eclipse.ocl.examples.pivot.StringLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	public R visitTemplateBinding(org.eclipse.ocl.examples.pivot.TemplateBinding object) {
		return visitElement(object);
	}

	public R visitTemplateParameter(org.eclipse.ocl.examples.pivot.TemplateParameter object) {
		return visitElement(object);
	}

	public R visitTemplateParameterSubstitution(org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution object) {
		return visitElement(object);
	}

	public R visitTemplateParameterType(org.eclipse.ocl.examples.pivot.TemplateParameterType object) {
		return visitType(object);
	}

	public R visitTemplateSignature(org.eclipse.ocl.examples.pivot.TemplateSignature object) {
		return visitMonikeredElement(object);
	}

	public R visitTemplateableElement(org.eclipse.ocl.examples.pivot.TemplateableElement object) {
		return visitMonikeredElement(object);
	}

	public R visitTupleLiteralExp(org.eclipse.ocl.examples.pivot.TupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	public R visitTupleLiteralPart(org.eclipse.ocl.examples.pivot.TupleLiteralPart object) {
		return visitVariableDeclaration(object);
	}

	public R visitTupleType(org.eclipse.ocl.examples.pivot.TupleType object) {
		return visitDataType(object);
	}

	public R visitType(org.eclipse.ocl.examples.pivot.Type object) {
		return visitNamedElement(object);
	}

	public R visitTypeExp(org.eclipse.ocl.examples.pivot.TypeExp object) {
		return visitOclExpression(object);
	}

	public R visitTypeTemplateParameter(org.eclipse.ocl.examples.pivot.TypeTemplateParameter object) {
		return visitTemplateParameter(object);
	}

	public R visitTypedElement(org.eclipse.ocl.examples.pivot.TypedElement object) {
		return visitNamedElement(object);
	}

	public R visitTypedMultiplicityElement(org.eclipse.ocl.examples.pivot.TypedMultiplicityElement object) {
		return visitTypedElement(object);
	}

	public R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp object) {
		return visitNumericLiteralExp(object);
	}

	public R visitUnspecifiedType(org.eclipse.ocl.examples.pivot.UnspecifiedType object) {
		return visitType(object);
	}

	public R visitUnspecifiedValueExp(org.eclipse.ocl.examples.pivot.UnspecifiedValueExp object) {
		return visitOclExpression(object);
	}

	public R visitValueSpecification(org.eclipse.ocl.examples.pivot.ValueSpecification object) {
		return visitTypedElement(object);
	}

	public R visitVariable(org.eclipse.ocl.examples.pivot.Variable object) {
		return visitVariableDeclaration(object);
	}

	public R visitVariableDeclaration(org.eclipse.ocl.examples.pivot.VariableDeclaration object) {
		return visitTypedElement(object);
	}

	public R visitVariableExp(org.eclipse.ocl.examples.pivot.VariableExp object) {
		return visitOclExpression(object);
	}

	public R visitVoidType(org.eclipse.ocl.examples.pivot.VoidType object) {
		return visitClass(object);
	}
}
