/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.contexts.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage
 * @generated
 */
public class ContextsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ContextsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ContextsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextsSwitch modelSwitch =
		new ContextsSwitch() {
			public Object caseClassifierContextDeclAS(ClassifierContextDeclAS object) {
				return createClassifierContextDeclASAdapter();
			}
			public Object caseConstraintAS(ConstraintAS object) {
				return createConstraintASAdapter();
			}
			public Object caseContextDeclarationAS(ContextDeclarationAS object) {
				return createContextDeclarationASAdapter();
			}
			public Object caseOperationAS(OperationAS object) {
				return createOperationASAdapter();
			}
			public Object caseOperationContextDeclAS(OperationContextDeclAS object) {
				return createOperationContextDeclASAdapter();
			}
			public Object casePackageDeclarationAS(PackageDeclarationAS object) {
				return createPackageDeclarationASAdapter();
			}
			public Object casePropertyContextDeclAS(PropertyContextDeclAS object) {
				return createPropertyContextDeclASAdapter();
			}
			public Object caseVariableDeclarationAS(VariableDeclarationAS object) {
				return createVariableDeclarationASAdapter();
			}
			public Object caseVisitable(Visitable object) {
				return createVisitableAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS <em>Classifier Context Decl AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS
	 * @generated
	 */
	public Adapter createClassifierContextDeclASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS <em>Constraint AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintAS
	 * @generated
	 */
	public Adapter createConstraintASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS <em>Context Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS
	 * @generated
	 */
	public Adapter createContextDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS <em>Operation AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationAS
	 * @generated
	 */
	public Adapter createOperationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS <em>Operation Context Decl AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS
	 * @generated
	 */
	public Adapter createOperationContextDeclASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS <em>Package Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS
	 * @generated
	 */
	public Adapter createPackageDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS <em>Property Context Decl AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS
	 * @generated
	 */
	public Adapter createPropertyContextDeclASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS <em>Variable Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS
	 * @generated
	 */
	public Adapter createVariableDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.Visitable
	 * @generated
	 */
	public Adapter createVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ContextsAdapterFactory
