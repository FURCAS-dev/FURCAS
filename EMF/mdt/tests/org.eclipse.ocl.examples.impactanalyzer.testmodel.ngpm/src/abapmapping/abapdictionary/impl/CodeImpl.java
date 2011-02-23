/**
 * <copyright>
 * </copyright>
 *
 * $Id: CodeImpl.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.Code;
import abapmapping.abapdictionary.CodeValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeImpl#isExtensible <em>Extensible</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeImpl extends DataElementImpl implements Code {
	/**
     * The default value of the '{@link #isExtensible() <em>Extensible</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isExtensible()
     * @generated
     * @ordered
     */
	protected static final boolean EXTENSIBLE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isExtensible() <em>Extensible</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isExtensible()
     * @generated
     * @ordered
     */
	protected boolean extensible = EXTENSIBLE_EDEFAULT;

	/**
     * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
	protected EList<CodeValue> values;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CodeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AbapdictionaryPackage.Literals.CODE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isExtensible() {
        return extensible;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExtensible(boolean newExtensible) {
        boolean oldExtensible = extensible;
        extensible = newExtensible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE__EXTENSIBLE, oldExtensible, extensible));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<CodeValue> getValues() {
        if (values == null) {
            values = new EObjectContainmentEList.Resolving<CodeValue>(CodeValue.class, this, AbapdictionaryPackage.CODE__VALUES);
        }
        return values;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AbapdictionaryPackage.CODE__VALUES:
                return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
            case AbapdictionaryPackage.CODE__EXTENSIBLE:
                return isExtensible();
            case AbapdictionaryPackage.CODE__VALUES:
                return getValues();
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
            case AbapdictionaryPackage.CODE__EXTENSIBLE:
                setExtensible((Boolean)newValue);
                return;
            case AbapdictionaryPackage.CODE__VALUES:
                getValues().clear();
                getValues().addAll((Collection<? extends CodeValue>)newValue);
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
            case AbapdictionaryPackage.CODE__EXTENSIBLE:
                setExtensible(EXTENSIBLE_EDEFAULT);
                return;
            case AbapdictionaryPackage.CODE__VALUES:
                getValues().clear();
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
            case AbapdictionaryPackage.CODE__EXTENSIBLE:
                return extensible != EXTENSIBLE_EDEFAULT;
            case AbapdictionaryPackage.CODE__VALUES:
                return values != null && !values.isEmpty();
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
        result.append(" (extensible: ");
        result.append(extensible);
        result.append(')');
        return result.toString();
    }

} //CodeImpl
