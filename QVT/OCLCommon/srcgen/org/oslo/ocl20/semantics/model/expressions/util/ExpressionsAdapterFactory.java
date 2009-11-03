/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.ModelElement;

import org.oslo.ocl20.semantics.model.expressions.*;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpressionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
	 * --> This implementation returns <code>true</code> if the object is either the model's package
	 * or is an instance object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExpressionsSwitch modelSwitch = new ExpressionsSwitch() {
		public Object caseBooleanLiteralExp(BooleanLiteralExp object) {
			return createBooleanLiteralExpAdapter();
		}

		public Object caseCallExp(CallExp object) {
			return createCallExpAdapter();
		}

		public Object caseCollectionItem(CollectionItem object) {
			return createCollectionItemAdapter();
		}

		public Object caseCollectionLiteralExp(CollectionLiteralExp object) {
			return createCollectionLiteralExpAdapter();
		}

		public Object caseCollectionLiteralPart(CollectionLiteralPart object) {
			return createCollectionLiteralPartAdapter();
		}

		public Object caseCollectionRange(CollectionRange object) {
			return createCollectionRangeAdapter();
		}

		public Object caseEnumLiteralExp(EnumLiteralExp object) {
			return createEnumLiteralExpAdapter();
		}

		public Object caseIfExp(IfExp object) {
			return createIfExpAdapter();
		}

		public Object caseIntegerLiteralExp(IntegerLiteralExp object) {
			return createIntegerLiteralExpAdapter();
		}

		public Object caseIterateExp(IterateExp object) {
			return createIterateExpAdapter();
		}

		public Object caseIteratorExp(IteratorExp object) {
			return createIteratorExpAdapter();
		}

		public Object caseLetExp(LetExp object) {
			return createLetExpAdapter();
		}

		public Object caseLiteralExp(LiteralExp object) {
			return createLiteralExpAdapter();
		}

		public Object caseLoopExp(LoopExp object) {
			return createLoopExpAdapter();
		}

		public Object caseModelPropertyCallExp(ModelPropertyCallExp object) {
			return createModelPropertyCallExpAdapter();
		}

		public Object caseNumericalLiteralExp(NumericalLiteralExp object) {
			return createNumericalLiteralExpAdapter();
		}

		public Object caseOclExpression(OclExpression object) {
			return createOclExpressionAdapter();
		}

		public Object caseOclMessageArg(OclMessageArg object) {
			return createOclMessageArgAdapter();
		}

		public Object caseOclMessageExp(OclMessageExp object) {
			return createOclMessageExpAdapter();
		}

		public Object caseOperationCallExp(OperationCallExp object) {
			return createOperationCallExpAdapter();
		}

		public Object casePropertyCallExp(PropertyCallExp object) {
			return createPropertyCallExpAdapter();
		}

		public Object caseRealLiteralExp(RealLiteralExp object) {
			return createRealLiteralExpAdapter();
		}

		public Object caseStringLiteralExp(StringLiteralExp object) {
			return createStringLiteralExpAdapter();
		}

		public Object caseTupleLiteralExp(TupleLiteralExp object) {
			return createTupleLiteralExpAdapter();
		}

		public Object caseTypeLiteralExp(TypeLiteralExp object) {
			return createTypeLiteralExpAdapter();
		}

		public Object caseUndefinedLiteralExp(UndefinedLiteralExp object) {
			return createUndefinedLiteralExpAdapter();
		}

		public Object caseUnspecifiedValueExp(UnspecifiedValueExp object) {
			return createUnspecifiedValueExpAdapter();
		}

		public Object caseVariableDeclaration(VariableDeclaration object) {
			return createVariableDeclarationAdapter();
		}

		public Object caseVariableExp(VariableExp object) {
			return createVariableExpAdapter();
		}

		public Object caseSemanticsVisitable(SemanticsVisitable object) {
			return createSemanticsVisitableAdapter();
		}

		public Object caseElement(Element object) {
			return createElementAdapter();
		}

		public Object caseModelElement(ModelElement object) {
			return createModelElementAdapter();
		}

		public Object defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter) modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp
	 * <em>Boolean Literal Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp
	 * @generated
	 */
	public Adapter createBooleanLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CallExp <em>Call Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.CallExp
	 * @generated
	 */
	public Adapter createCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionItem
	 * @generated
	 */
	public Adapter createCollectionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp
	 * <em>Collection Literal Exp</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp
	 * @generated
	 */
	public Adapter createCollectionLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart
	 * <em>Collection Literal Part</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart
	 * @generated
	 */
	public Adapter createCollectionLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionRange <em>Collection Range</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionRange
	 * @generated
	 */
	public Adapter createCollectionRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp
	 * @generated
	 */
	public Adapter createEnumLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IfExp <em>If Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.IfExp
	 * @generated
	 */
	public Adapter createIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp
	 * <em>Integer Literal Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp
	 * @generated
	 */
	public Adapter createIntegerLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IterateExp <em>Iterate Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.IterateExp
	 * @generated
	 */
	public Adapter createIterateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IteratorExp <em>Iterator Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.IteratorExp
	 * @generated
	 */
	public Adapter createIteratorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LetExp <em>Let Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.LetExp
	 * @generated
	 */
	public Adapter createLetExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LiteralExp <em>Literal Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.LiteralExp
	 * @generated
	 */
	public Adapter createLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LoopExp <em>Loop Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.LoopExp
	 * @generated
	 */
	public Adapter createLoopExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.ModelPropertyCallExp
	 * <em>Model Property Call Exp</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.ModelPropertyCallExp
	 * @generated
	 */
	public Adapter createModelPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.NumericalLiteralExp
	 * <em>Numerical Literal Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.NumericalLiteralExp
	 * @generated
	 */
	public Adapter createNumericalLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression
	 * @generated
	 */
	public Adapter createOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg <em>Ocl Message Arg</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageArg
	 * @generated
	 */
	public Adapter createOclMessageArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp <em>Ocl Message Exp</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageExp
	 * @generated
	 */
	public Adapter createOclMessageExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp
	 * <em>Operation Call Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.OperationCallExp
	 * @generated
	 */
	public Adapter createOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp <em>Property Call Exp</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.PropertyCallExp
	 * @generated
	 */
	public Adapter createPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.RealLiteralExp
	 * @generated
	 */
	public Adapter createRealLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.StringLiteralExp
	 * <em>String Literal Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.StringLiteralExp
	 * @generated
	 */
	public Adapter createStringLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp
	 * @generated
	 */
	public Adapter createTupleLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp <em>Type Literal Exp</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp
	 * @generated
	 */
	public Adapter createTypeLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp
	 * <em>Undefined Literal Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp
	 * @generated
	 */
	public Adapter createUndefinedLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp
	 * <em>Unspecified Value Exp</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp
	 * @generated
	 */
	public Adapter createUnspecifiedValueExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration
	 * <em>Variable Declaration</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableExp <em>Variable Exp</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableExp
	 * @generated
	 */
	public Adapter createVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.SemanticsVisitable <em>Visitable</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.SemanticsVisitable
	 * @generated
	 */
	public Adapter createSemanticsVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.Element
	 * <em>Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
	 * cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.bridge.ModelElement <em>Model Element</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.ModelElement
	 * @generated
	 */
	public Adapter createModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ExpressionsAdapterFactory
