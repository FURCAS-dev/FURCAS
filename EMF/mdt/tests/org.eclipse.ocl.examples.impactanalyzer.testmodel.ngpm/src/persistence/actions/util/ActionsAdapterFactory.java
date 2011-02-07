/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsAdapterFactory.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package persistence.actions.util;

import behavioral.actions.Statement;
import behavioral.actions.StatementWithArgument;

import data.classes.InScope;

import dataaccess.expressions.WithArgument;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import persistence.actions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see persistence.actions.ActionsPackage
 * @generated
 */
public class ActionsAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ActionsPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ActionsPackage.eINSTANCE;
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
	@Override
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
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ActionsSwitch<Adapter> modelSwitch =
		new ActionsSwitch<Adapter>() {
            @Override
            public Adapter caseStore(Store object) {
                return createStoreAdapter();
            }
            @Override
            public Adapter caseDelete(Delete object) {
                return createDeleteAdapter();
            }
            @Override
            public Adapter caseStatementWithEntityArgument(StatementWithEntityArgument object) {
                return createStatementWithEntityArgumentAdapter();
            }
            @Override
            public Adapter caseRollback(Rollback object) {
                return createRollbackAdapter();
            }
            @Override
            public Adapter caseInScope(InScope object) {
                return createInScopeAdapter();
            }
            @Override
            public Adapter caseStatement(Statement object) {
                return createStatementAdapter();
            }
            @Override
            public Adapter caseWithArgument(WithArgument object) {
                return createWithArgumentAdapter();
            }
            @Override
            public Adapter caseStatementWithArgument(StatementWithArgument object) {
                return createStatementWithArgumentAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
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
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link persistence.actions.Store <em>Store</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see persistence.actions.Store
     * @generated
     */
	public Adapter createStoreAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link persistence.actions.Delete <em>Delete</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see persistence.actions.Delete
     * @generated
     */
	public Adapter createDeleteAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link persistence.actions.StatementWithEntityArgument <em>Statement With Entity Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see persistence.actions.StatementWithEntityArgument
     * @generated
     */
	public Adapter createStatementWithEntityArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link persistence.actions.Rollback <em>Rollback</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see persistence.actions.Rollback
     * @generated
     */
	public Adapter createRollbackAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.InScope <em>In Scope</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.InScope
     * @generated
     */
	public Adapter createInScopeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Statement <em>Statement</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Statement
     * @generated
     */
	public Adapter createStatementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.WithArgument <em>With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.WithArgument
     * @generated
     */
	public Adapter createWithArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.StatementWithArgument <em>Statement With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.StatementWithArgument
     * @generated
     */
	public Adapter createStatementWithArgumentAdapter() {
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

} //ActionsAdapterFactory
