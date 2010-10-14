/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.XsdType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xsd Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getXsdType <em>Xsd Type</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getFractionDigits <em>Fraction Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XsdTypeImpl extends EObjectImpl implements XsdType {
	/**
     * The default value of the '{@link #getXsdType() <em>Xsd Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getXsdType()
     * @generated
     * @ordered
     */
	protected static final String XSD_TYPE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getXsdType() <em>Xsd Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getXsdType()
     * @generated
     * @ordered
     */
	protected String xsdType = XSD_TYPE_EDEFAULT;

	/**
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
	protected int length = LENGTH_EDEFAULT;

	/**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
	protected static final String PATTERN_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
	protected String pattern = PATTERN_EDEFAULT;

	/**
     * The default value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTotalDigits()
     * @generated
     * @ordered
     */
	protected static final int TOTAL_DIGITS_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTotalDigits()
     * @generated
     * @ordered
     */
	protected int totalDigits = TOTAL_DIGITS_EDEFAULT;

	/**
     * The default value of the '{@link #getFractionDigits() <em>Fraction Digits</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFractionDigits()
     * @generated
     * @ordered
     */
	protected static final int FRACTION_DIGITS_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getFractionDigits() <em>Fraction Digits</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFractionDigits()
     * @generated
     * @ordered
     */
	protected int fractionDigits = FRACTION_DIGITS_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected XsdTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AbapdictionaryPackage.Literals.XSD_TYPE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getXsdType() {
        return xsdType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setXsdType(String newXsdType) {
        String oldXsdType = xsdType;
        xsdType = newXsdType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__XSD_TYPE, oldXsdType, xsdType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getLength() {
        return length;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLength(int newLength) {
        int oldLength = length;
        length = newLength;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__LENGTH, oldLength, length));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getPattern() {
        return pattern;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPattern(String newPattern) {
        String oldPattern = pattern;
        pattern = newPattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__PATTERN, oldPattern, pattern));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getTotalDigits() {
        return totalDigits;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTotalDigits(int newTotalDigits) {
        int oldTotalDigits = totalDigits;
        totalDigits = newTotalDigits;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS, oldTotalDigits, totalDigits));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getFractionDigits() {
        return fractionDigits;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFractionDigits(int newFractionDigits) {
        int oldFractionDigits = fractionDigits;
        fractionDigits = newFractionDigits;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS, oldFractionDigits, fractionDigits));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
                return getXsdType();
            case AbapdictionaryPackage.XSD_TYPE__LENGTH:
                return getLength();
            case AbapdictionaryPackage.XSD_TYPE__PATTERN:
                return getPattern();
            case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
                return getTotalDigits();
            case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
                return getFractionDigits();
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
            case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
                setXsdType((String)newValue);
                return;
            case AbapdictionaryPackage.XSD_TYPE__LENGTH:
                setLength((Integer)newValue);
                return;
            case AbapdictionaryPackage.XSD_TYPE__PATTERN:
                setPattern((String)newValue);
                return;
            case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
                setTotalDigits((Integer)newValue);
                return;
            case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
                setFractionDigits((Integer)newValue);
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
            case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
                setXsdType(XSD_TYPE_EDEFAULT);
                return;
            case AbapdictionaryPackage.XSD_TYPE__LENGTH:
                setLength(LENGTH_EDEFAULT);
                return;
            case AbapdictionaryPackage.XSD_TYPE__PATTERN:
                setPattern(PATTERN_EDEFAULT);
                return;
            case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
                setTotalDigits(TOTAL_DIGITS_EDEFAULT);
                return;
            case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
                setFractionDigits(FRACTION_DIGITS_EDEFAULT);
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
            case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
                return XSD_TYPE_EDEFAULT == null ? xsdType != null : !XSD_TYPE_EDEFAULT.equals(xsdType);
            case AbapdictionaryPackage.XSD_TYPE__LENGTH:
                return length != LENGTH_EDEFAULT;
            case AbapdictionaryPackage.XSD_TYPE__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
            case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
                return totalDigits != TOTAL_DIGITS_EDEFAULT;
            case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
                return fractionDigits != FRACTION_DIGITS_EDEFAULT;
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
        result.append(" (xsdType: ");
        result.append(xsdType);
        result.append(", length: ");
        result.append(length);
        result.append(", pattern: ");
        result.append(pattern);
        result.append(", totalDigits: ");
        result.append(totalDigits);
        result.append(", fractionDigits: ");
        result.append(fractionDigits);
        result.append(')');
        return result.toString();
    }

} //XsdTypeImpl
