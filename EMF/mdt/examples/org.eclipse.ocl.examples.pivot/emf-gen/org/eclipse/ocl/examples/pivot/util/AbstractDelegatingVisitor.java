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
 * $Id: AbstractDelegatingVisitor.java,v 1.6 2011/02/15 19:58:28 ewillink Exp $
 */
package	org.eclipse.ocl.examples.pivot.util;

/**
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, D extends Visitor<R, C>>
	extends AbstractVisitor<R, C>
	implements Visitor<R, C>
{
    protected final D delegate;
    
    protected AbstractDelegatingVisitor(D delegate, C context) {
    	super(context);
        assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$        
        this.delegate = delegate;        
//        delegate.setUndecoratedVisitor(this);
    }

    /**
     * Delegates to my decorated visitor.
     */
//	public DecorableVisitor<R, C> createNestedVisitor() {
//        return delegate.createNestedVisitor();
//	}
  
    /**
     * Obtains the visitor that I decorate.
     * 
     * @return my decorated visitor
     */
    protected final D getDelegate() {
        return delegate;
    }

	public R visiting(Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public R visitAnnotation(org.eclipse.ocl.examples.pivot.Annotation object) {
		return delegate.visitAnnotation(object);
	}

	public R visitAnyType(org.eclipse.ocl.examples.pivot.AnyType object) {
		return delegate.visitAnyType(object);
	}

	public R visitAssociationClass(org.eclipse.ocl.examples.pivot.AssociationClass object) {
		return delegate.visitAssociationClass(object);
	}

	public R visitAssociationClassCallExp(org.eclipse.ocl.examples.pivot.AssociationClassCallExp object) {
		return delegate.visitAssociationClassCallExp(object);
	}

	public R visitBagType(org.eclipse.ocl.examples.pivot.BagType object) {
		return delegate.visitBagType(object);
	}

	public R visitBooleanLiteralExp(org.eclipse.ocl.examples.pivot.BooleanLiteralExp object) {
		return delegate.visitBooleanLiteralExp(object);
	}

	public R visitCallExp(org.eclipse.ocl.examples.pivot.CallExp object) {
		return delegate.visitCallExp(object);
	}

	public R visitCallOperationAction(org.eclipse.ocl.examples.pivot.CallOperationAction object) {
		return delegate.visitCallOperationAction(object);
	}

	public R visitClass(org.eclipse.ocl.examples.pivot.Class object) {
		return delegate.visitClass(object);
	}

	public R visitCollectionItem(org.eclipse.ocl.examples.pivot.CollectionItem object) {
		return delegate.visitCollectionItem(object);
	}

	public R visitCollectionLiteralExp(org.eclipse.ocl.examples.pivot.CollectionLiteralExp object) {
		return delegate.visitCollectionLiteralExp(object);
	}

	public R visitCollectionLiteralPart(org.eclipse.ocl.examples.pivot.CollectionLiteralPart object) {
		return delegate.visitCollectionLiteralPart(object);
	}

	public R visitCollectionRange(org.eclipse.ocl.examples.pivot.CollectionRange object) {
		return delegate.visitCollectionRange(object);
	}

	public R visitCollectionType(org.eclipse.ocl.examples.pivot.CollectionType object) {
		return delegate.visitCollectionType(object);
	}

	public R visitComment(org.eclipse.ocl.examples.pivot.Comment object) {
		return delegate.visitComment(object);
	}

	public R visitCompleteEnvironment(org.eclipse.ocl.examples.pivot.CompleteEnvironment object) {
		return delegate.visitCompleteEnvironment(object);
	}

	public R visitCompleteIteration(org.eclipse.ocl.examples.pivot.CompleteIteration object) {
		return delegate.visitCompleteIteration(object);
	}

	public R visitCompleteOperation(org.eclipse.ocl.examples.pivot.CompleteOperation object) {
		return delegate.visitCompleteOperation(object);
	}

	public R visitCompletePackage(org.eclipse.ocl.examples.pivot.CompletePackage object) {
		return delegate.visitCompletePackage(object);
	}

	public R visitCompleteProperty(org.eclipse.ocl.examples.pivot.CompleteProperty object) {
		return delegate.visitCompleteProperty(object);
	}

	public R visitCompleteType(org.eclipse.ocl.examples.pivot.CompleteType object) {
		return delegate.visitCompleteType(object);
	}

	public R visitConstraint(org.eclipse.ocl.examples.pivot.Constraint object) {
		return delegate.visitConstraint(object);
	}

	public R visitDataType(org.eclipse.ocl.examples.pivot.DataType object) {
		return delegate.visitDataType(object);
	}

	public R visitDetail(org.eclipse.ocl.examples.pivot.Detail object) {
		return delegate.visitDetail(object);
	}

	public R visitElement(org.eclipse.ocl.examples.pivot.Element object) {
		return delegate.visitElement(object);
	}

	public R visitEnumLiteralExp(org.eclipse.ocl.examples.pivot.EnumLiteralExp object) {
		return delegate.visitEnumLiteralExp(object);
	}

	public R visitEnumeration(org.eclipse.ocl.examples.pivot.Enumeration object) {
		return delegate.visitEnumeration(object);
	}

	public R visitEnumerationLiteral(org.eclipse.ocl.examples.pivot.EnumerationLiteral object) {
		return delegate.visitEnumerationLiteral(object);
	}

	public R visitExpressionInOcl(org.eclipse.ocl.examples.pivot.ExpressionInOcl object) {
		return delegate.visitExpressionInOcl(object);
	}

	public R visitFeature(org.eclipse.ocl.examples.pivot.Feature object) {
		return delegate.visitFeature(object);
	}

	public R visitFeatureCallExp(org.eclipse.ocl.examples.pivot.FeatureCallExp object) {
		return delegate.visitFeatureCallExp(object);
	}

	public R visitIfExp(org.eclipse.ocl.examples.pivot.IfExp object) {
		return delegate.visitIfExp(object);
	}

	public R visitIntegerLiteralExp(org.eclipse.ocl.examples.pivot.IntegerLiteralExp object) {
		return delegate.visitIntegerLiteralExp(object);
	}

	public R visitInvalidLiteralExp(org.eclipse.ocl.examples.pivot.InvalidLiteralExp object) {
		return delegate.visitInvalidLiteralExp(object);
	}

	public R visitInvalidType(org.eclipse.ocl.examples.pivot.InvalidType object) {
		return delegate.visitInvalidType(object);
	}

	public R visitIterateExp(org.eclipse.ocl.examples.pivot.IterateExp object) {
		return delegate.visitIterateExp(object);
	}

	public R visitIteration(org.eclipse.ocl.examples.pivot.Iteration object) {
		return delegate.visitIteration(object);
	}

	public R visitIteratorExp(org.eclipse.ocl.examples.pivot.IteratorExp object) {
		return delegate.visitIteratorExp(object);
	}

	public R visitLambdaType(org.eclipse.ocl.examples.pivot.LambdaType object) {
		return delegate.visitLambdaType(object);
	}

	public R visitLetExp(org.eclipse.ocl.examples.pivot.LetExp object) {
		return delegate.visitLetExp(object);
	}

	public R visitLibrary(org.eclipse.ocl.examples.pivot.Library object) {
		return delegate.visitLibrary(object);
	}

	public R visitLiteralExp(org.eclipse.ocl.examples.pivot.LiteralExp object) {
		return delegate.visitLiteralExp(object);
	}

	public R visitLoopExp(org.eclipse.ocl.examples.pivot.LoopExp object) {
		return delegate.visitLoopExp(object);
	}

	public R visitMessageExp(org.eclipse.ocl.examples.pivot.MessageExp object) {
		return delegate.visitMessageExp(object);
	}

	public R visitMessageType(org.eclipse.ocl.examples.pivot.MessageType object) {
		return delegate.visitMessageType(object);
	}

	public R visitMonikeredElement(org.eclipse.ocl.examples.pivot.MonikeredElement object) {
		return delegate.visitMonikeredElement(object);
	}

	public R visitMultiplicityElement(org.eclipse.ocl.examples.pivot.MultiplicityElement object) {
		return delegate.visitMultiplicityElement(object);
	}

	public R visitNamedElement(org.eclipse.ocl.examples.pivot.NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	public R visitNamespace(org.eclipse.ocl.examples.pivot.Namespace object) {
		return delegate.visitNamespace(object);
	}

	public R visitNavigationCallExp(org.eclipse.ocl.examples.pivot.NavigationCallExp object) {
		return delegate.visitNavigationCallExp(object);
	}

	public R visitNullLiteralExp(org.eclipse.ocl.examples.pivot.NullLiteralExp object) {
		return delegate.visitNullLiteralExp(object);
	}

	public R visitNumericLiteralExp(org.eclipse.ocl.examples.pivot.NumericLiteralExp object) {
		return delegate.visitNumericLiteralExp(object);
	}

	public R visitOclExpression(org.eclipse.ocl.examples.pivot.OclExpression object) {
		return delegate.visitOclExpression(object);
	}

	public R visitOpaqueExpression(org.eclipse.ocl.examples.pivot.OpaqueExpression object) {
		return delegate.visitOpaqueExpression(object);
	}

	public R visitOperation(org.eclipse.ocl.examples.pivot.Operation object) {
		return delegate.visitOperation(object);
	}

	public R visitOperationCallExp(org.eclipse.ocl.examples.pivot.OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	public R visitOperationTemplateParameter(org.eclipse.ocl.examples.pivot.OperationTemplateParameter object) {
		return delegate.visitOperationTemplateParameter(object);
	}

	public R visitOrderedSetType(org.eclipse.ocl.examples.pivot.OrderedSetType object) {
		return delegate.visitOrderedSetType(object);
	}

	public R visitPackage(org.eclipse.ocl.examples.pivot.Package object) {
		return delegate.visitPackage(object);
	}

	public R visitPackageableElement(org.eclipse.ocl.examples.pivot.PackageableElement object) {
		return delegate.visitPackageableElement(object);
	}

	public R visitParameter(org.eclipse.ocl.examples.pivot.Parameter object) {
		return delegate.visitParameter(object);
	}

	public R visitParameterableElement(org.eclipse.ocl.examples.pivot.ParameterableElement object) {
		return delegate.visitParameterableElement(object);
	}

	public R visitPrecedence(org.eclipse.ocl.examples.pivot.Precedence object) {
		return delegate.visitPrecedence(object);
	}

	public R visitPrimitiveLiteralExp(org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp object) {
		return delegate.visitPrimitiveLiteralExp(object);
	}

	public R visitPrimitiveType(org.eclipse.ocl.examples.pivot.PrimitiveType object) {
		return delegate.visitPrimitiveType(object);
	}

	public R visitProperty(org.eclipse.ocl.examples.pivot.Property object) {
		return delegate.visitProperty(object);
	}

	public R visitPropertyCallExp(org.eclipse.ocl.examples.pivot.PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	public R visitRealLiteralExp(org.eclipse.ocl.examples.pivot.RealLiteralExp object) {
		return delegate.visitRealLiteralExp(object);
	}

	public R visitSendSignalAction(org.eclipse.ocl.examples.pivot.SendSignalAction object) {
		return delegate.visitSendSignalAction(object);
	}

	public R visitSequenceType(org.eclipse.ocl.examples.pivot.SequenceType object) {
		return delegate.visitSequenceType(object);
	}

	public R visitSetType(org.eclipse.ocl.examples.pivot.SetType object) {
		return delegate.visitSetType(object);
	}

	public R visitSignal(org.eclipse.ocl.examples.pivot.Signal object) {
		return delegate.visitSignal(object);
	}

	public R visitState(org.eclipse.ocl.examples.pivot.State object) {
		return delegate.visitState(object);
	}

	public R visitStateExp(org.eclipse.ocl.examples.pivot.StateExp object) {
		return delegate.visitStateExp(object);
	}

	public R visitStringLiteralExp(org.eclipse.ocl.examples.pivot.StringLiteralExp object) {
		return delegate.visitStringLiteralExp(object);
	}

	public R visitTemplateBinding(org.eclipse.ocl.examples.pivot.TemplateBinding object) {
		return delegate.visitTemplateBinding(object);
	}

	public R visitTemplateParameter(org.eclipse.ocl.examples.pivot.TemplateParameter object) {
		return delegate.visitTemplateParameter(object);
	}

	public R visitTemplateParameterSubstitution(org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution object) {
		return delegate.visitTemplateParameterSubstitution(object);
	}

	public R visitTemplateParameterType(org.eclipse.ocl.examples.pivot.TemplateParameterType object) {
		return delegate.visitTemplateParameterType(object);
	}

	public R visitTemplateSignature(org.eclipse.ocl.examples.pivot.TemplateSignature object) {
		return delegate.visitTemplateSignature(object);
	}

	public R visitTemplateableElement(org.eclipse.ocl.examples.pivot.TemplateableElement object) {
		return delegate.visitTemplateableElement(object);
	}

	public R visitTupleLiteralExp(org.eclipse.ocl.examples.pivot.TupleLiteralExp object) {
		return delegate.visitTupleLiteralExp(object);
	}

	public R visitTupleLiteralPart(org.eclipse.ocl.examples.pivot.TupleLiteralPart object) {
		return delegate.visitTupleLiteralPart(object);
	}

	public R visitTupleType(org.eclipse.ocl.examples.pivot.TupleType object) {
		return delegate.visitTupleType(object);
	}

	public R visitType(org.eclipse.ocl.examples.pivot.Type object) {
		return delegate.visitType(object);
	}

	public R visitTypeExp(org.eclipse.ocl.examples.pivot.TypeExp object) {
		return delegate.visitTypeExp(object);
	}

	public R visitTypeTemplateParameter(org.eclipse.ocl.examples.pivot.TypeTemplateParameter object) {
		return delegate.visitTypeTemplateParameter(object);
	}

	public R visitTypedElement(org.eclipse.ocl.examples.pivot.TypedElement object) {
		return delegate.visitTypedElement(object);
	}

	public R visitTypedMultiplicityElement(org.eclipse.ocl.examples.pivot.TypedMultiplicityElement object) {
		return delegate.visitTypedMultiplicityElement(object);
	}

	public R visitUnlimitedNaturalLiteralExp(org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp object) {
		return delegate.visitUnlimitedNaturalLiteralExp(object);
	}

	public R visitUnspecifiedType(org.eclipse.ocl.examples.pivot.UnspecifiedType object) {
		return delegate.visitUnspecifiedType(object);
	}

	public R visitUnspecifiedValueExp(org.eclipse.ocl.examples.pivot.UnspecifiedValueExp object) {
		return delegate.visitUnspecifiedValueExp(object);
	}

	public R visitValueSpecification(org.eclipse.ocl.examples.pivot.ValueSpecification object) {
		return delegate.visitValueSpecification(object);
	}

	public R visitVariable(org.eclipse.ocl.examples.pivot.Variable object) {
		return delegate.visitVariable(object);
	}

	public R visitVariableDeclaration(org.eclipse.ocl.examples.pivot.VariableDeclaration object) {
		return delegate.visitVariableDeclaration(object);
	}

	public R visitVariableExp(org.eclipse.ocl.examples.pivot.VariableExp object) {
		return delegate.visitVariableExp(object);
	}

	public R visitVoidType(org.eclipse.ocl.examples.pivot.VoidType object) {
		return delegate.visitVoidType(object);
	}
}
