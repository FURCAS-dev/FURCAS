/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.SimpleContent;
import integration.xsd.XsdPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.SimpleContentImpl#getBase <em>Base</em>}</li>
 *   <li>{@link integration.xsd.impl.SimpleContentImpl#getEnumVals <em>Enum Vals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleContentImpl extends AbstractContentImpl implements SimpleContent {
	/**
     * The default value of the '{@link #getBase() <em>Base</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBase()
     * @generated
     * @ordered
     */
	protected static final String BASE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getBase() <em>Base</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBase()
     * @generated
     * @ordered
     */
	protected String base = BASE_EDEFAULT;

	/**
     * The cached value of the '{@link #getEnumVals() <em>Enum Vals</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumVals()
     * @generated
     * @ordered
     */
	protected EList<String> enumVals;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SimpleContentImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return XsdPackage.Literals.SIMPLE_CONTENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getBase() {
        return base;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBase(String newBase) {
        String oldBase = base;
        base = newBase;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.SIMPLE_CONTENT__BASE, oldBase, base));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<String> getEnumVals() {
        if (enumVals == null) {
            enumVals = new EDataTypeEList<String>(String.class, this, XsdPackage.SIMPLE_CONTENT__ENUM_VALS);
        }
        return enumVals;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XsdPackage.SIMPLE_CONTENT__BASE:
                return getBase();
            case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
                return getEnumVals();
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
            case XsdPackage.SIMPLE_CONTENT__BASE:
                setBase((String)newValue);
                return;
            case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
                getEnumVals().clear();
                getEnumVals().addAll((Collection<? extends String>)newValue);
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
            case XsdPackage.SIMPLE_CONTENT__BASE:
                setBase(BASE_EDEFAULT);
                return;
            case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
                getEnumVals().clear();
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
            case XsdPackage.SIMPLE_CONTENT__BASE:
                return BASE_EDEFAULT == null ? base != null : !BASE_EDEFAULT.equals(base);
            case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
                return enumVals != null && !enumVals.isEmpty();
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
        result.append(" (base: ");
        result.append(base);
        result.append(", enumVals: ");
        result.append(enumVals);
        result.append(')');
        return result.toString();
    }

} //SimpleContentImpl
