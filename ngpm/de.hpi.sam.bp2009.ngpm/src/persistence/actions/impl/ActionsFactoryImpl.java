/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.actions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import persistence.actions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsFactoryImpl extends EFactoryImpl implements ActionsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ActionsFactory init() {
        try {
            ActionsFactory theActionsFactory = (ActionsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///persistence/actions.ecore"); 
            if (theActionsFactory != null) {
                return theActionsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ActionsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ActionsPackage.STORE: return createStore();
            case ActionsPackage.DELETE: return createDelete();
            case ActionsPackage.STATEMENT_WITH_ENTITY_ARGUMENT: return createStatementWithEntityArgument();
            case ActionsPackage.ROLLBACK: return createRollback();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Store createStore() {
        StoreImpl store = new StoreImpl();
        return store;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Delete createDelete() {
        DeleteImpl delete = new DeleteImpl();
        return delete;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatementWithEntityArgument createStatementWithEntityArgument() {
        StatementWithEntityArgumentImpl statementWithEntityArgument = new StatementWithEntityArgumentImpl();
        return statementWithEntityArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Rollback createRollback() {
        RollbackImpl rollback = new RollbackImpl();
        return rollback;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsPackage getActionsPackage() {
        return (ActionsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ActionsPackage getPackage() {
        return ActionsPackage.eINSTANCE;
    }

} //ActionsFactoryImpl
