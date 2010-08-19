/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.binding.impl;

import integration.binding.BindingPackage;
import integration.binding.SimpleUrlPattern;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Url Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.binding.impl.SimpleUrlPatternImpl#getBaseUrl <em>Base Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleUrlPatternImpl extends UrlPatternImpl implements SimpleUrlPattern {
	/**
     * The default value of the '{@link #getBaseUrl() <em>Base Url</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseUrl()
     * @generated
     * @ordered
     */
	protected static final String BASE_URL_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getBaseUrl() <em>Base Url</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseUrl()
     * @generated
     * @ordered
     */
	protected String baseUrl = BASE_URL_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SimpleUrlPatternImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BindingPackage.Literals.SIMPLE_URL_PATTERN;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getBaseUrl() {
        return baseUrl;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBaseUrl(String newBaseUrl) {
        String oldBaseUrl = baseUrl;
        baseUrl = newBaseUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.SIMPLE_URL_PATTERN__BASE_URL, oldBaseUrl, baseUrl));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
                return getBaseUrl();
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
            case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
                setBaseUrl((String)newValue);
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
            case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
                setBaseUrl(BASE_URL_EDEFAULT);
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
            case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
                return BASE_URL_EDEFAULT == null ? baseUrl != null : !BASE_URL_EDEFAULT.equals(baseUrl);
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
        result.append(" (baseUrl: ");
        result.append(baseUrl);
        result.append(')');
        return result.toString();
    }

} //SimpleUrlPatternImpl
