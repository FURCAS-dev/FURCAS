/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueSetEntryImpl.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessconfigurationPackage;
import configuration.businessconfiguration.ValueSet;
import configuration.businessconfiguration.ValueSetEntry;

import dataaccess.expressions.Expression;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Set Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#isCanBeChanged <em>Can Be Changed</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#isCanBeDeleted <em>Can Be Deleted</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#getValueSet <em>Value Set</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueSetEntryImpl extends NamedElementImpl implements ValueSetEntry {
	/**
     * The default value of the '{@link #isCanBeChanged() <em>Can Be Changed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCanBeChanged()
     * @generated
     * @ordered
     */
	protected static final boolean CAN_BE_CHANGED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isCanBeChanged() <em>Can Be Changed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCanBeChanged()
     * @generated
     * @ordered
     */
	protected boolean canBeChanged = CAN_BE_CHANGED_EDEFAULT;

	/**
     * The default value of the '{@link #isCanBeDeleted() <em>Can Be Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCanBeDeleted()
     * @generated
     * @ordered
     */
	protected static final boolean CAN_BE_DELETED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isCanBeDeleted() <em>Can Be Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCanBeDeleted()
     * @generated
     * @ordered
     */
	protected boolean canBeDeleted = CAN_BE_DELETED_EDEFAULT;

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
	protected ValueSetEntryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.VALUE_SET_ENTRY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isCanBeChanged() {
        return canBeChanged;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCanBeChanged(boolean newCanBeChanged) {
        boolean oldCanBeChanged = canBeChanged;
        canBeChanged = newCanBeChanged;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED, oldCanBeChanged, canBeChanged));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isCanBeDeleted() {
        return canBeDeleted;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCanBeDeleted(boolean newCanBeDeleted) {
        boolean oldCanBeDeleted = canBeDeleted;
        canBeDeleted = newCanBeDeleted;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED, oldCanBeDeleted, canBeDeleted));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueSet getValueSet() {
        if (eContainerFeatureID() != BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET) return null;
        return (ValueSet)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueSet basicGetValueSet() {
        if (eContainerFeatureID() != BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET) return null;
        return (ValueSet)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetValueSet(ValueSet newValueSet, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newValueSet, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValueSet(ValueSet newValueSet) {
        if (newValueSet != eInternalContainer() || (eContainerFeatureID() != BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET && newValueSet != null)) {
            if (EcoreUtil.isAncestor(this, newValueSet))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newValueSet != null)
                msgs = ((InternalEObject)newValueSet).eInverseAdd(this, BusinessconfigurationPackage.VALUE_SET__ENTRIES, ValueSet.class, msgs);
            msgs = basicSetValueSet(newValueSet, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET, newValueSet, newValueSet));
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
                NotificationChain msgs = oldValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, null, null);
                if (newValue.eInternalContainer() == null) {
                    msgs = newValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, oldValue, value));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, oldValue, newValue);
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
                msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, null, msgs);
            if (newValue != null)
                msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, null, msgs);
            msgs = basicSetValue(newValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, newValue, newValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetValueSet((ValueSet)otherEnd, msgs);
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
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                return basicSetValueSet(null, msgs);
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                return eInternalContainer().eInverseRemove(this, BusinessconfigurationPackage.VALUE_SET__ENTRIES, ValueSet.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
                return isCanBeChanged();
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
                return isCanBeDeleted();
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                if (resolve) return getValueSet();
                return basicGetValueSet();
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
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
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
                setCanBeChanged((Boolean)newValue);
                return;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
                setCanBeDeleted((Boolean)newValue);
                return;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                setValueSet((ValueSet)newValue);
                return;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
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
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
                setCanBeChanged(CAN_BE_CHANGED_EDEFAULT);
                return;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
                setCanBeDeleted(CAN_BE_DELETED_EDEFAULT);
                return;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                setValueSet((ValueSet)null);
                return;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
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
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
                return canBeChanged != CAN_BE_CHANGED_EDEFAULT;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
                return canBeDeleted != CAN_BE_DELETED_EDEFAULT;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
                return basicGetValueSet() != null;
            case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
                return value != null;
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
        result.append(" (canBeChanged: ");
        result.append(canBeChanged);
        result.append(", canBeDeleted: ");
        result.append(canBeDeleted);
        result.append(')');
        return result.toString();
    }

} //ValueSetEntryImpl
