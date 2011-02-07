/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeImpl.java,v 1.1 2011/02/07 16:57:58 auhl Exp $
 */
package integration.xsd.impl;

import integration.xsd.AttUseType;
import integration.xsd.Attribute;
import integration.xsd.SimpleType;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.AttributeImpl#getUse <em>Use</em>}</li>
 *   <li>{@link integration.xsd.impl.AttributeImpl#getVal <em>Val</em>}</li>
 *   <li>{@link integration.xsd.impl.AttributeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends NamedElementImpl implements Attribute {
	/**
     * The default value of the '{@link #getUse() <em>Use</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUse()
     * @generated
     * @ordered
     */
	protected static final AttUseType USE_EDEFAULT = AttUseType.FIXED_VALUE;

	/**
     * The cached value of the '{@link #getUse() <em>Use</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUse()
     * @generated
     * @ordered
     */
	protected AttUseType use = USE_EDEFAULT;

	/**
     * The default value of the '{@link #getVal() <em>Val</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVal()
     * @generated
     * @ordered
     */
	protected static final String VAL_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getVal() <em>Val</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVal()
     * @generated
     * @ordered
     */
	protected String val = VAL_EDEFAULT;

	/**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected SimpleType type;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AttributeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return XsdPackage.Literals.ATTRIBUTE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AttUseType getUse() {
        return use;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUse(AttUseType newUse) {
        AttUseType oldUse = use;
        use = newUse == null ? USE_EDEFAULT : newUse;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ATTRIBUTE__USE, oldUse, use));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getVal() {
        return val;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVal(String newVal) {
        String oldVal = val;
        val = newVal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ATTRIBUTE__VAL, oldVal, val));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleType getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (SimpleType)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsdPackage.ATTRIBUTE__TYPE, oldType, type));
            }
        }
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleType basicGetType() {
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(SimpleType newType) {
        SimpleType oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.ATTRIBUTE__TYPE, oldType, type));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XsdPackage.ATTRIBUTE__USE:
                return getUse();
            case XsdPackage.ATTRIBUTE__VAL:
                return getVal();
            case XsdPackage.ATTRIBUTE__TYPE:
                if (resolve) return getType();
                return basicGetType();
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
            case XsdPackage.ATTRIBUTE__USE:
                setUse((AttUseType)newValue);
                return;
            case XsdPackage.ATTRIBUTE__VAL:
                setVal((String)newValue);
                return;
            case XsdPackage.ATTRIBUTE__TYPE:
                setType((SimpleType)newValue);
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
            case XsdPackage.ATTRIBUTE__USE:
                setUse(USE_EDEFAULT);
                return;
            case XsdPackage.ATTRIBUTE__VAL:
                setVal(VAL_EDEFAULT);
                return;
            case XsdPackage.ATTRIBUTE__TYPE:
                setType((SimpleType)null);
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
            case XsdPackage.ATTRIBUTE__USE:
                return use != USE_EDEFAULT;
            case XsdPackage.ATTRIBUTE__VAL:
                return VAL_EDEFAULT == null ? val != null : !VAL_EDEFAULT.equals(val);
            case XsdPackage.ATTRIBUTE__TYPE:
                return type != null;
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
        result.append(" (use: ");
        result.append(use);
        result.append(", val: ");
        result.append(val);
        result.append(')');
        return result.toString();
    }

} //AttributeImpl
