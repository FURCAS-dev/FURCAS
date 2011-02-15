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
 * $Id: Visitor.java,v 1.5 2011/02/15 10:38:46 ewillink Exp $
 */
package	org.eclipse.ocl.examples.pivot.util;

/**
 */
public interface Visitor<R, C>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	<A> A getAdapter(Class<A> adapter);

	/**
     * Return the result of visiting a visitable for which no more specific pivot type method
     * is available.
     */
	R visiting(org.eclipse.ocl.examples.pivot.util.Visitable visitable);
	
	R visitAnnotation(org.eclipse.ocl.examples.pivot.Annotation object);
	R visitAnyType(org.eclipse.ocl.examples.pivot.AnyType object);
	R visitAssociationClass(org.eclipse.ocl.examples.pivot.AssociationClass object);
	R visitAssociationClassCallExp(org.eclipse.ocl.examples.pivot.AssociationClassCallExp object);
	R visitBagType(org.eclipse.ocl.examples.pivot.BagType object);
	R visitBooleanLiteralExp(org.eclipse.ocl.examples.pivot.BooleanLiteralExp object);
	R visitCallExp(org.eclipse.ocl.examples.pivot.CallExp object);
	R visitCallOperationAction(org.eclipse.ocl.examples.pivot.CallOperationAction object);
	R visitClass(org.eclipse.ocl.examples.pivot.Class object);
	R visitCollectionItem(org.eclipse.ocl.examples.pivot.CollectionItem object);
	R visitCollectionLiteralExp(org.eclipse.ocl.examples.pivot.CollectionLiteralExp object);
	R visitCollectionLiteralPart(org.eclipse.ocl.examples.pivot.CollectionLiteralPart object);
	R visitCollectionRange(org.eclipse.ocl.examples.pivot.CollectionRange object);
	R visitCollectionType(org.eclipse.ocl.examples.pivot.CollectionType object);
	R visitComment(org.eclipse.ocl.examples.pivot.Comment object);
	R visitCompleteEnvironment(org.eclipse.ocl.examples.pivot.CompleteEnvironment object);
	R visitCompleteIteration(org.eclipse.ocl.examples.pivot.CompleteIteration object);
	R visitCompleteOperation(org.eclipse.ocl.examples.pivot.CompleteOperation object);
	R visitCompletePackage(org.eclipse.ocl.examples.pivot.CompletePackage object);
	R visitCompleteProperty(org.eclipse.ocl.examples.pivot.CompleteProperty object);
	R visitCompleteType(org.eclipse.ocl.examples.pivot.CompleteType object);
	R visitConstraint(org.eclipse.ocl.examples.pivot.Constraint object);
	R visitDataType(org.eclipse.ocl.examples.pivot.DataType object);
	R visitDetail(org.eclipse.ocl.examples.pivot.Detail object);
	R visitElement(org.eclipse.ocl.examples.pivot.Element object);
	R visitEnumLiteralExp(org.eclipse.ocl.examples.pivot.EnumLiteralExp object);
	R visitEnumeration(org.eclipse.ocl.examples.pivot.Enumeration object);
	R visitEnumerationLiteral(org.eclipse.ocl.examples.pivot.EnumerationLiteral object);
	R visitExpressionInOcl(org.eclipse.ocl.examples.pivot.ExpressionInOcl object);
	R visitFeature(org.eclipse.ocl.examples.pivot.Feature object);
	R visitFeatureCallExp(org.eclipse.ocl.examples.pivot.FeatureCallExp object);
	R visitIfExp(org.eclipse.ocl.examples.pivot.IfExp object);
	R visitIntegerLiteralExp(org.eclipse.ocl.examples.pivot.IntegerLiteralExp object);
	R visitInvalidLiteralExp(org.eclipse.ocl.examples.pivot.InvalidLiteralExp object);
	R visitInvalidType(org.eclipse.ocl.examples.pivot.InvalidType object);
	R visitIterateExp(org.eclipse.ocl.examples.pivot.IterateExp object);
	R visitIteration(org.eclipse.ocl.examples.pivot.Iteration object);
	R visitIteratorExp(org.eclipse.ocl.examples.pivot.IteratorExp object);
	R visitLambdaType(org.eclipse.ocl.examples.pivot.LambdaType object);
	R visitLetExp(org.eclipse.ocl.examples.pivot.LetExp object);
	R visitLibrary(org.eclipse.ocl.examples.pivot.Library object);
	R visitLiteralExp(org.eclipse.ocl.examples.pivot.LiteralExp object);
	R visitLoopExp(org.eclipse.ocl.examples.pivot.LoopExp object);
	R visitMessageExp(org.eclipse.ocl.examples.pivot.MessageExp object);
	R visitMessageType(org.eclipse.ocl.examples.pivot.MessageType object);
	R visitMonikeredElement(org.eclipse.ocl.examples.pivot.MonikeredElement object);
	R visitMultiplicityElement(org.eclipse.ocl.examples.pivot.MultiplicityElement object);
	R visitNamedElement(org.eclipse.ocl.examples.pivot.NamedElement object);
	R visitNamespace(org.eclipse.ocl.examples.pivot.Namespace object);
	R visitNavigationCallExp(org.eclipse.ocl.examples.pivot.NavigationCallExp object);
	R visitNullLiteralExp(org.eclipse.ocl.examples.pivot.NullLiteralExp object);
	R visitNumericLiteralExp(org.eclipse.ocl.examples.pivot.NumericLiteralExp object);
	R visitOclExpression(org.eclipse.ocl.examples.pivot.OclExpression object);
	R visitOpaqueExpression(org.eclipse.ocl.examples.pivot.OpaqueExpression object);
	R visitOperation(org.eclipse.ocl.examples.pivot.Operation object);
	R visitOperationCallExp(org.eclipse.ocl.examples.pivot.OperationCallExp object);
	R visitOperationTemplateParameter(org.eclipse.ocl.examples.pivot.OperationTemplateParameter object);
	R visitOrderedSetType(org.eclipse.ocl.examples.pivot.OrderedSetType object);
	R visitPackage(org.eclipse.ocl.examples.pivot.Package object);
	R visitPackageableElement(org.eclipse.ocl.examples.pivot.PackageableElement object);
	R visitParameter(org.eclipse.ocl.examples.pivot.Parameter object);
	R visitParameterableElement(org.eclipse.ocl.examples.pivot.ParameterableElement object);
	R visitPrecedence(org.eclipse.ocl.examples.pivot.Precedence object);
	R visitPrimitiveLiteralExp(org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp object);
	R visitPrimitiveType(org.eclipse.ocl.examples.pivot.PrimitiveType object);
	R visitProperty(org.eclipse.ocl.examples.pivot.Property object);
	R visitPropertyCallExp(org.eclipse.ocl.examples.pivot.PropertyCallExp object);
	R visitRealLiteralExp(org.eclipse.ocl.examples.pivot.RealLiteralExp object);
	R visitSendSignalAction(org.eclipse.ocl.examples.pivot.SendSignalAction object);
	R visitSequenceType(org.eclipse.ocl.examples.pivot.SequenceType object);
	R visitSetType(org.eclipse.ocl.examples.pivot.SetType object);
	R visitSignal(org.eclipse.ocl.examples.pivot.Signal object);
	R visitState(org.eclipse.ocl.examples.pivot.State object);
	R visitStateExp(org.eclipse.ocl.examples.pivot.StateExp object);
	R visitStringLiteralExp(org.eclipse.ocl.examples.pivot.StringLiteralExp object);
	R visitTemplateBinding(org.eclipse.ocl.examples.pivot.TemplateBinding object);
	R visitTemplateParameter(org.eclipse.ocl.examples.pivot.TemplateParameter object);
	R visitTemplateParameterSubstitution(org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution object);
	R visitTemplateParameterType(org.eclipse.ocl.examples.pivot.TemplateParameterType object);
	R visitTemplateSignature(org.eclipse.ocl.examples.pivot.TemplateSignature object);
	R visitTemplateableElement(org.eclipse.ocl.examples.pivot.TemplateableElement object);
	R visitTupleLiteralExp(org.eclipse.ocl.examples.pivot.TupleLiteralExp object);
	R visitTupleLiteralPart(org.eclipse.ocl.examples.pivot.TupleLiteralPart object);
	R visitTupleType(org.eclipse.ocl.examples.pivot.TupleType object);
	R visitType(org.eclipse.ocl.examples.pivot.Type object);
	R visitTypeExp(org.eclipse.ocl.examples.pivot.TypeExp object);
	R visitTypeTemplateParameter(org.eclipse.ocl.examples.pivot.TypeTemplateParameter object);
	R visitTypedElement(org.eclipse.ocl.examples.pivot.TypedElement object);
	R visitTypedMultiplicityElement(org.eclipse.ocl.examples.pivot.TypedMultiplicityElement object);
	R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp object);
	R visitUnspecifiedType(org.eclipse.ocl.examples.pivot.UnspecifiedType object);
	R visitUnspecifiedValueExp(org.eclipse.ocl.examples.pivot.UnspecifiedValueExp object);
	R visitValueSpecification(org.eclipse.ocl.examples.pivot.ValueSpecification object);
	R visitVariable(org.eclipse.ocl.examples.pivot.Variable object);
	R visitVariableDeclaration(org.eclipse.ocl.examples.pivot.VariableDeclaration object);
	R visitVariableExp(org.eclipse.ocl.examples.pivot.VariableExp object);
	R visitVoidType(org.eclipse.ocl.examples.pivot.VoidType object);
}
