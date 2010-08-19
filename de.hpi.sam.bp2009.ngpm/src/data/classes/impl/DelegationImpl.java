/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.AssociationEnd;
import data.classes.ClassesPackage;
import data.classes.Delegation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.DelegationImpl#isAllFeatures <em>All Features</em>}</li>
 *   <li>{@link data.classes.impl.DelegationImpl#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelegationImpl extends EObjectImpl implements Delegation {
	/**
     * The default value of the '{@link #isAllFeatures() <em>All Features</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAllFeatures()
     * @generated
     * @ordered
     */
	protected static final boolean ALL_FEATURES_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isAllFeatures() <em>All Features</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAllFeatures()
     * @generated
     * @ordered
     */
	protected boolean allFeatures = ALL_FEATURES_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DelegationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.DELEGATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAllFeatures() {
        return allFeatures;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAllFeatures(boolean newAllFeatures) {
        boolean oldAllFeatures = allFeatures;
        allFeatures = newAllFeatures;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.DELEGATION__ALL_FEATURES, oldAllFeatures, allFeatures));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getFrom() {
        if (eContainerFeatureID() != ClassesPackage.DELEGATION__FROM) return null;
        return (AssociationEnd)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociationEnd basicGetFrom() {
        if (eContainerFeatureID() != ClassesPackage.DELEGATION__FROM) return null;
        return (AssociationEnd)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFrom(AssociationEnd newFrom, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFrom, ClassesPackage.DELEGATION__FROM, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFrom(AssociationEnd newFrom) {
        if (newFrom != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.DELEGATION__FROM && newFrom != null)) {
            if (EcoreUtil.isAncestor(this, newFrom))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFrom != null)
                msgs = ((InternalEObject)newFrom).eInverseAdd(this, ClassesPackage.ASSOCIATION_END__DELEGATION, AssociationEnd.class, msgs);
            msgs = basicSetFrom(newFrom, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.DELEGATION__FROM, newFrom, newFrom));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.DELEGATION__FROM:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFrom((AssociationEnd)otherEnd, msgs);
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
            case ClassesPackage.DELEGATION__FROM:
                return basicSetFrom(null, msgs);
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
            case ClassesPackage.DELEGATION__FROM:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.ASSOCIATION_END__DELEGATION, AssociationEnd.class, msgs);
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
            case ClassesPackage.DELEGATION__ALL_FEATURES:
                return isAllFeatures();
            case ClassesPackage.DELEGATION__FROM:
                if (resolve) return getFrom();
                return basicGetFrom();
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
            case ClassesPackage.DELEGATION__ALL_FEATURES:
                setAllFeatures((Boolean)newValue);
                return;
            case ClassesPackage.DELEGATION__FROM:
                setFrom((AssociationEnd)newValue);
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
            case ClassesPackage.DELEGATION__ALL_FEATURES:
                setAllFeatures(ALL_FEATURES_EDEFAULT);
                return;
            case ClassesPackage.DELEGATION__FROM:
                setFrom((AssociationEnd)null);
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
            case ClassesPackage.DELEGATION__ALL_FEATURES:
                return allFeatures != ALL_FEATURES_EDEFAULT;
            case ClassesPackage.DELEGATION__FROM:
                return basicGetFrom() != null;
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
        result.append(" (allFeatures: ");
        result.append(allFeatures);
        result.append(')');
        return result.toString();
    }

} //DelegationImpl
