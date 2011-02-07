/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssignmentImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Assignment;
import behavioral.actions.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.AssignmentImpl#getAssignTo <em>Assign To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentImpl extends StatementWithArgumentImpl implements Assignment {
	/**
     * The cached value of the '{@link #getAssignTo() <em>Assign To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAssignTo()
     * @generated
     * @ordered
     */
	protected Variable assignTo;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AssignmentImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.ASSIGNMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Variable getAssignTo() {
        if (assignTo != null && assignTo.eIsProxy()) {
            InternalEObject oldAssignTo = (InternalEObject)assignTo;
            assignTo = (Variable)eResolveProxy(oldAssignTo);
            if (assignTo != oldAssignTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.ASSIGNMENT__ASSIGN_TO, oldAssignTo, assignTo));
            }
        }
        return assignTo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Variable basicGetAssignTo() {
        return assignTo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAssignTo(Variable newAssignTo, NotificationChain msgs) {
        Variable oldAssignTo = assignTo;
        assignTo = newAssignTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionsPackage.ASSIGNMENT__ASSIGN_TO, oldAssignTo, newAssignTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAssignTo(Variable newAssignTo) {
        if (newAssignTo != assignTo) {
            NotificationChain msgs = null;
            if (assignTo != null)
                msgs = ((InternalEObject)assignTo).eInverseRemove(this, ActionsPackage.VARIABLE__ASSIGNMENTS, Variable.class, msgs);
            if (newAssignTo != null)
                msgs = ((InternalEObject)newAssignTo).eInverseAdd(this, ActionsPackage.VARIABLE__ASSIGNMENTS, Variable.class, msgs);
            msgs = basicSetAssignTo(newAssignTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ASSIGNMENT__ASSIGN_TO, newAssignTo, newAssignTo));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.ASSIGNMENT__ASSIGN_TO:
                if (assignTo != null)
                    msgs = ((InternalEObject)assignTo).eInverseRemove(this, ActionsPackage.VARIABLE__ASSIGNMENTS, Variable.class, msgs);
                return basicSetAssignTo((Variable)otherEnd, msgs);
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
            case ActionsPackage.ASSIGNMENT__ASSIGN_TO:
                return basicSetAssignTo(null, msgs);
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
            case ActionsPackage.ASSIGNMENT__ASSIGN_TO:
                if (resolve) return getAssignTo();
                return basicGetAssignTo();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ActionsPackage.ASSIGNMENT__ASSIGN_TO:
                setAssignTo((Variable)newValue);
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
            case ActionsPackage.ASSIGNMENT__ASSIGN_TO:
                setAssignTo((Variable)null);
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
            case ActionsPackage.ASSIGNMENT__ASSIGN_TO:
                return assignTo != null;
        }
        return super.eIsSet(featureID);
    }

} //AssignmentImpl
