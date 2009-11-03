/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;

import org.oslo.ocl20.semantics.model.contexts.*;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage
 * @generated
 */
public class ContextsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ContextsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContextsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ContextsPackage.eINSTANCE;
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
	protected ContextsSwitch modelSwitch = new ContextsSwitch() {
		public Object caseClassifierContextDecl(ClassifierContextDecl object) {
			return createClassifierContextDeclAdapter();
		}

		public Object caseConstraint(Constraint object) {
			return createConstraintAdapter();
		}

		public Object caseContextDeclaration(ContextDeclaration object) {
			return createContextDeclarationAdapter();
		}

		public Object caseDefinedOperation(DefinedOperation object) {
			return createDefinedOperationAdapter();
		}

		public Object caseDefinedProperty(DefinedProperty object) {
			return createDefinedPropertyAdapter();
		}

		public Object caseOperationContextDecl(OperationContextDecl object) {
			return createOperationContextDeclAdapter();
		}

		public Object casePropertyContextDecl(PropertyContextDecl object) {
			return createPropertyContextDeclAdapter();
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

		public Object caseOperation(Operation object) {
			return createOperationAdapter();
		}

		public Object caseProperty(Property object) {
			return createPropertyAdapter();
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
	 * {@link org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl
	 * <em>Classifier Context Decl</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl
	 * @generated
	 */
	public Adapter createClassifierContextDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint <em>Constraint</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration
	 * <em>Context Declaration</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextDeclaration
	 * @generated
	 */
	public Adapter createContextDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedOperation <em>Defined Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.DefinedOperation
	 * @generated
	 */
	public Adapter createDefinedOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedProperty <em>Defined Property</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.DefinedProperty
	 * @generated
	 */
	public Adapter createDefinedPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.OperationContextDecl
	 * <em>Operation Context Decl</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.OperationContextDecl
	 * @generated
	 */
	public Adapter createOperationContextDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl
	 * <em>Property Context Decl</em>}'. <!-- begin-user-doc --> This default implementation returns
	 * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
	 * catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl
	 * @generated
	 */
	public Adapter createPropertyContextDeclAdapter() {
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
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.bridge.Operation <em>Operation</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.oslo.ocl20.semantics.bridge.Property <em>Property</em>}'. <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
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

} // ContextsAdapterFactory
