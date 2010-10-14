/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.Action;
import behavioral.status_and_action.design.BusinessObjectNode;
import behavioral.status_and_action.design.DesignPackage;
import behavioral.status_and_action.design.StatusVariable;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Object Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.impl.BusinessObjectNodeImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.impl.BusinessObjectNodeImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessObjectNodeImpl extends NamedElementImpl implements BusinessObjectNode {
	/**
     * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariables()
     * @generated
     * @ordered
     */
	protected EList<StatusVariable> variables;

	/**
     * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getActions()
     * @generated
     * @ordered
     */
	protected EList<Action> actions;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusinessObjectNodeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.BUSINESS_OBJECT_NODE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<StatusVariable> getVariables() {
        if (variables == null) {
            variables = new EObjectContainmentEList.Resolving<StatusVariable>(StatusVariable.class, this, DesignPackage.BUSINESS_OBJECT_NODE__VARIABLES);
        }
        return variables;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Action> getActions() {
        if (actions == null) {
            actions = new EObjectContainmentEList.Resolving<Action>(Action.class, this, DesignPackage.BUSINESS_OBJECT_NODE__ACTIONS);
        }
        return actions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DesignPackage.BUSINESS_OBJECT_NODE__VARIABLES:
                return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
            case DesignPackage.BUSINESS_OBJECT_NODE__ACTIONS:
                return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DesignPackage.BUSINESS_OBJECT_NODE__VARIABLES:
                return getVariables();
            case DesignPackage.BUSINESS_OBJECT_NODE__ACTIONS:
                return getActions();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case DesignPackage.BUSINESS_OBJECT_NODE__VARIABLES:
                getVariables().clear();
                getVariables().addAll((Collection<? extends StatusVariable>)newValue);
                return;
            case DesignPackage.BUSINESS_OBJECT_NODE__ACTIONS:
                getActions().clear();
                getActions().addAll((Collection<? extends Action>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case DesignPackage.BUSINESS_OBJECT_NODE__VARIABLES:
                getVariables().clear();
                return;
            case DesignPackage.BUSINESS_OBJECT_NODE__ACTIONS:
                getActions().clear();
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case DesignPackage.BUSINESS_OBJECT_NODE__VARIABLES:
                return variables != null && !variables.isEmpty();
            case DesignPackage.BUSINESS_OBJECT_NODE__ACTIONS:
                return actions != null && !actions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BusinessObjectNodeImpl
