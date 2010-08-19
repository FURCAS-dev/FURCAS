/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Assignment;
import behavioral.actions.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.VariableImpl#getAssignments <em>Assignments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends NamedValueWithOptionalInitExpressionImpl implements Variable {
	/**
     * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAssignments()
     * @generated
     * @ordered
     */
	protected EList<Assignment> assignments;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected VariableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.VARIABLE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Assignment> getAssignments() {
        if (assignments == null) {
            assignments = new EObjectWithInverseResolvingEList<Assignment>(Assignment.class, this, ActionsPackage.VARIABLE__ASSIGNMENTS, ActionsPackage.ASSIGNMENT__ASSIGN_TO);
        }
        return assignments;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void getCommonTypeOfAssignments() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.VARIABLE__ASSIGNMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.VARIABLE__ASSIGNMENTS:
                return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
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
            case ActionsPackage.VARIABLE__ASSIGNMENTS:
                return getAssignments();
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
            case ActionsPackage.VARIABLE__ASSIGNMENTS:
                getAssignments().clear();
                getAssignments().addAll((Collection<? extends Assignment>)newValue);
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
            case ActionsPackage.VARIABLE__ASSIGNMENTS:
                getAssignments().clear();
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
            case ActionsPackage.VARIABLE__ASSIGNMENTS:
                return assignments != null && !assignments.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //VariableImpl
