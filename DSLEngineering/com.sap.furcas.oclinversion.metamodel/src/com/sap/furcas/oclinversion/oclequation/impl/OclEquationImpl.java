/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.oclequation.impl;

import com.sap.furcas.oclinversion.oclequation.OclEquation;
import com.sap.furcas.oclinversion.oclequation.OclequationPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl#getRight <em>Right</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl#isIsSource <em>Is Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclEquationImpl extends EObjectImpl implements OclEquation {
    /**
     * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLeft()
     * @generated
     * @ordered
     */
    protected OCLExpression left;

    /**
     * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRight()
     * @generated
     * @ordered
     */
    protected OCLExpression right;

    /**
     * The default value of the '{@link #isIsSource() <em>Is Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsSource()
     * @generated
     * @ordered
     */
    protected static final boolean IS_SOURCE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsSource() <em>Is Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsSource()
     * @generated
     * @ordered
     */
    protected boolean isSource = IS_SOURCE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OclEquationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OclequationPackage.Literals.OCL_EQUATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OCLExpression getLeft() {
        return left;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLeft(OCLExpression newLeft, NotificationChain msgs) {
        OCLExpression oldLeft = left;
        left = newLeft;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclequationPackage.OCL_EQUATION__LEFT, oldLeft, newLeft);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLeft(OCLExpression newLeft) {
        if (newLeft != left) {
            NotificationChain msgs = null;
            if (left != null)
                msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclequationPackage.OCL_EQUATION__LEFT, null, msgs);
            if (newLeft != null)
                msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclequationPackage.OCL_EQUATION__LEFT, null, msgs);
            msgs = basicSetLeft(newLeft, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclequationPackage.OCL_EQUATION__LEFT, newLeft, newLeft));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OCLExpression getRight() {
        return right;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRight(OCLExpression newRight, NotificationChain msgs) {
        OCLExpression oldRight = right;
        right = newRight;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclequationPackage.OCL_EQUATION__RIGHT, oldRight, newRight);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRight(OCLExpression newRight) {
        if (newRight != right) {
            NotificationChain msgs = null;
            if (right != null)
                msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclequationPackage.OCL_EQUATION__RIGHT, null, msgs);
            if (newRight != null)
                msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclequationPackage.OCL_EQUATION__RIGHT, null, msgs);
            msgs = basicSetRight(newRight, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclequationPackage.OCL_EQUATION__RIGHT, newRight, newRight));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsSource() {
        return isSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsSource(boolean newIsSource) {
        boolean oldIsSource = isSource;
        isSource = newIsSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclequationPackage.OCL_EQUATION__IS_SOURCE, oldIsSource, isSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case OclequationPackage.OCL_EQUATION__LEFT:
                return basicSetLeft(null, msgs);
            case OclequationPackage.OCL_EQUATION__RIGHT:
                return basicSetRight(null, msgs);
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
            case OclequationPackage.OCL_EQUATION__LEFT:
                return getLeft();
            case OclequationPackage.OCL_EQUATION__RIGHT:
                return getRight();
            case OclequationPackage.OCL_EQUATION__IS_SOURCE:
                return isIsSource();
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
            case OclequationPackage.OCL_EQUATION__LEFT:
                setLeft((OCLExpression)newValue);
                return;
            case OclequationPackage.OCL_EQUATION__RIGHT:
                setRight((OCLExpression)newValue);
                return;
            case OclequationPackage.OCL_EQUATION__IS_SOURCE:
                setIsSource((Boolean)newValue);
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
            case OclequationPackage.OCL_EQUATION__LEFT:
                setLeft((OCLExpression)null);
                return;
            case OclequationPackage.OCL_EQUATION__RIGHT:
                setRight((OCLExpression)null);
                return;
            case OclequationPackage.OCL_EQUATION__IS_SOURCE:
                setIsSource(IS_SOURCE_EDEFAULT);
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
            case OclequationPackage.OCL_EQUATION__LEFT:
                return left != null;
            case OclequationPackage.OCL_EQUATION__RIGHT:
                return right != null;
            case OclequationPackage.OCL_EQUATION__IS_SOURCE:
                return isSource != IS_SOURCE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (isSource: ");
        result.append(isSource);
        result.append(')');
        return result.toString();
    }

} //OclEquationImpl
