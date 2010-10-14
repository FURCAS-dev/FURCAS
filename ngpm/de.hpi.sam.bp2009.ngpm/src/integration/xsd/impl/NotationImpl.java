/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.Notation;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.NotationImpl#getPublicDec <em>Public Dec</em>}</li>
 *   <li>{@link integration.xsd.impl.NotationImpl#getSystemDec <em>System Dec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotationImpl extends NamedElementImpl implements Notation {
	/**
     * The default value of the '{@link #getPublicDec() <em>Public Dec</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPublicDec()
     * @generated
     * @ordered
     */
	protected static final String PUBLIC_DEC_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getPublicDec() <em>Public Dec</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPublicDec()
     * @generated
     * @ordered
     */
	protected String publicDec = PUBLIC_DEC_EDEFAULT;

	/**
     * The default value of the '{@link #getSystemDec() <em>System Dec</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSystemDec()
     * @generated
     * @ordered
     */
	protected static final String SYSTEM_DEC_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getSystemDec() <em>System Dec</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSystemDec()
     * @generated
     * @ordered
     */
	protected String systemDec = SYSTEM_DEC_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NotationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return XsdPackage.Literals.NOTATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getPublicDec() {
        return publicDec;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPublicDec(String newPublicDec) {
        String oldPublicDec = publicDec;
        publicDec = newPublicDec;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.NOTATION__PUBLIC_DEC, oldPublicDec, publicDec));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getSystemDec() {
        return systemDec;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSystemDec(String newSystemDec) {
        String oldSystemDec = systemDec;
        systemDec = newSystemDec;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.NOTATION__SYSTEM_DEC, oldSystemDec, systemDec));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XsdPackage.NOTATION__PUBLIC_DEC:
                return getPublicDec();
            case XsdPackage.NOTATION__SYSTEM_DEC:
                return getSystemDec();
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
            case XsdPackage.NOTATION__PUBLIC_DEC:
                setPublicDec((String)newValue);
                return;
            case XsdPackage.NOTATION__SYSTEM_DEC:
                setSystemDec((String)newValue);
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
            case XsdPackage.NOTATION__PUBLIC_DEC:
                setPublicDec(PUBLIC_DEC_EDEFAULT);
                return;
            case XsdPackage.NOTATION__SYSTEM_DEC:
                setSystemDec(SYSTEM_DEC_EDEFAULT);
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
            case XsdPackage.NOTATION__PUBLIC_DEC:
                return PUBLIC_DEC_EDEFAULT == null ? publicDec != null : !PUBLIC_DEC_EDEFAULT.equals(publicDec);
            case XsdPackage.NOTATION__SYSTEM_DEC:
                return SYSTEM_DEC_EDEFAULT == null ? systemDec != null : !SYSTEM_DEC_EDEFAULT.equals(systemDec);
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
        result.append(" (publicDec: ");
        result.append(publicDec);
        result.append(", systemDec: ");
        result.append(systemDec);
        result.append(')');
        return result.toString();
    }

} //NotationImpl
