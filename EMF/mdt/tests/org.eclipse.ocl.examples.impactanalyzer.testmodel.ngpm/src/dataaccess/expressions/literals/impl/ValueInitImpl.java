/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueInitImpl.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions.literals.impl;

import data.classes.AssociationEnd;

import dataaccess.expressions.Expression;

import dataaccess.expressions.literals.LiteralsPackage;
import dataaccess.expressions.literals.ValueInit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.literals.impl.ValueInitImpl#getForEnd <em>For End</em>}</li>
 *   <li>{@link dataaccess.expressions.literals.impl.ValueInitImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueInitImpl extends EObjectImpl implements ValueInit {
	/**
     * The cached value of the '{@link #getForEnd() <em>For End</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getForEnd()
     * @generated
     * @ordered
     */
	protected AssociationEnd forEnd;

	/**
     * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected Expression value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ValueInitImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return LiteralsPackage.Literals.VALUE_INIT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getForEnd() {
        if (forEnd != null && forEnd.eIsProxy()) {
            InternalEObject oldForEnd = (InternalEObject)forEnd;
            forEnd = (AssociationEnd)eResolveProxy(oldForEnd);
            if (forEnd != oldForEnd) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, LiteralsPackage.VALUE_INIT__FOR_END, oldForEnd, forEnd));
            }
        }
        return forEnd;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd basicGetForEnd() {
        return forEnd;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setForEnd(AssociationEnd newForEnd) {
        AssociationEnd oldForEnd = forEnd;
        forEnd = newForEnd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LiteralsPackage.VALUE_INIT__FOR_END, oldForEnd, forEnd));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getValue() {
        if (value != null && value.eIsProxy()) {
            InternalEObject oldValue = (InternalEObject)value;
            value = (Expression)eResolveProxy(oldValue);
            if (value != oldValue) {
                InternalEObject newValue = (InternalEObject)value;
                NotificationChain msgs = oldValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LiteralsPackage.VALUE_INIT__VALUE, null, null);
                if (newValue.eInternalContainer() == null) {
                    msgs = newValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LiteralsPackage.VALUE_INIT__VALUE, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, LiteralsPackage.VALUE_INIT__VALUE, oldValue, value));
            }
        }
        return value;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs) {
        Expression oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LiteralsPackage.VALUE_INIT__VALUE, oldValue, newValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(Expression newValue) {
        if (newValue != value) {
            NotificationChain msgs = null;
            if (value != null)
                msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LiteralsPackage.VALUE_INIT__VALUE, null, msgs);
            if (newValue != null)
                msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LiteralsPackage.VALUE_INIT__VALUE, null, msgs);
            msgs = basicSetValue(newValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LiteralsPackage.VALUE_INIT__VALUE, newValue, newValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case LiteralsPackage.VALUE_INIT__VALUE:
                return basicSetValue(null, msgs);
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
            case LiteralsPackage.VALUE_INIT__FOR_END:
                if (resolve) return getForEnd();
                return basicGetForEnd();
            case LiteralsPackage.VALUE_INIT__VALUE:
                if (resolve) return getValue();
                return basicGetValue();
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
            case LiteralsPackage.VALUE_INIT__FOR_END:
                setForEnd((AssociationEnd)newValue);
                return;
            case LiteralsPackage.VALUE_INIT__VALUE:
                setValue((Expression)newValue);
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
            case LiteralsPackage.VALUE_INIT__FOR_END:
                setForEnd((AssociationEnd)null);
                return;
            case LiteralsPackage.VALUE_INIT__VALUE:
                setValue((Expression)null);
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
            case LiteralsPackage.VALUE_INIT__FOR_END:
                return forEnd != null;
            case LiteralsPackage.VALUE_INIT__VALUE:
                return value != null;
        }
        return super.eIsSet(featureID);
    }

} //ValueInitImpl
