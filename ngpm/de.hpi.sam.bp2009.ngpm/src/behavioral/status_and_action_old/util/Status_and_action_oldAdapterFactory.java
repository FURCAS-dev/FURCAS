/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.util;

import behavioral.status_and_action_old.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage
 * @generated
 */
public class Status_and_action_oldAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static Status_and_action_oldPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Status_and_action_oldAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = Status_and_action_oldPackage.eINSTANCE;
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
	protected Status_and_action_oldSwitch<Adapter> modelSwitch =
		new Status_and_action_oldSwitch<Adapter>() {
            @Override
            public Adapter caseSAMAction(SAMAction object) {
                return createSAMActionAdapter();
            }
            @Override
            public Adapter caseSAMStatusVariable(SAMStatusVariable object) {
                return createSAMStatusVariableAdapter();
            }
            @Override
            public Adapter caseSAMDerivator(SAMDerivator object) {
                return createSAMDerivatorAdapter();
            }
            @Override
            public Adapter caseSAMStatusValue(SAMStatusValue object) {
                return createSAMStatusValueAdapter();
            }
            @Override
            public Adapter caseSAMStatusSchema(SAMStatusSchema object) {
                return createSAMStatusSchemaAdapter();
            }
            @Override
            public Adapter caseSAMOperator(SAMOperator object) {
                return createSAMOperatorAdapter();
            }
            @Override
            public Adapter caseSAMSchemaVariable(SAMSchemaVariable object) {
                return createSAMSchemaVariableAdapter();
            }
            @Override
            public Adapter caseSAMSchemaValue(SAMSchemaValue object) {
                return createSAMSchemaValueAdapter();
            }
            @Override
            public Adapter caseSAMSchemaAction(SAMSchemaAction object) {
                return createSAMSchemaActionAdapter();
            }
            @Override
            public Adapter caseSAMSchemaDerivator(SAMSchemaDerivator object) {
                return createSAMSchemaDerivatorAdapter();
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
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMAction <em>SAM Action</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMAction
     * @generated
     */
	public Adapter createSAMActionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMStatusVariable <em>SAM Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMStatusVariable
     * @generated
     */
	public Adapter createSAMStatusVariableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMDerivator <em>SAM Derivator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMDerivator
     * @generated
     */
	public Adapter createSAMDerivatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMStatusValue <em>SAM Status Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMStatusValue
     * @generated
     */
	public Adapter createSAMStatusValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMStatusSchema <em>SAM Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMStatusSchema
     * @generated
     */
	public Adapter createSAMStatusSchemaAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMOperator <em>SAM Operator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMOperator
     * @generated
     */
	public Adapter createSAMOperatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMSchemaVariable <em>SAM Schema Variable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMSchemaVariable
     * @generated
     */
	public Adapter createSAMSchemaVariableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMSchemaValue <em>SAM Schema Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMSchemaValue
     * @generated
     */
	public Adapter createSAMSchemaValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMSchemaAction <em>SAM Schema Action</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMSchemaAction
     * @generated
     */
	public Adapter createSAMSchemaActionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action_old.SAMSchemaDerivator <em>SAM Schema Derivator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action_old.SAMSchemaDerivator
     * @generated
     */
	public Adapter createSAMSchemaDerivatorAdapter() {
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

} //Status_and_action_oldAdapterFactory
