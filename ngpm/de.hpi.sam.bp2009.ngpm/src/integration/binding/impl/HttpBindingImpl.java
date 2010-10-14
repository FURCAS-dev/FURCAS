/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.binding.impl;

import integration.binding.BindingPackage;
import integration.binding.HttpBinding;
import integration.binding.UrlPattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Http Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.binding.impl.HttpBindingImpl#getUrlPattern <em>Url Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class HttpBindingImpl extends BindingImpl implements HttpBinding {
	/**
     * The cached value of the '{@link #getUrlPattern() <em>Url Pattern</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUrlPattern()
     * @generated
     * @ordered
     */
	protected UrlPattern urlPattern;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected HttpBindingImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BindingPackage.Literals.HTTP_BINDING;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UrlPattern getUrlPattern() {
        if (urlPattern != null && urlPattern.eIsProxy()) {
            InternalEObject oldUrlPattern = (InternalEObject)urlPattern;
            urlPattern = (UrlPattern)eResolveProxy(oldUrlPattern);
            if (urlPattern != oldUrlPattern) {
                InternalEObject newUrlPattern = (InternalEObject)urlPattern;
                NotificationChain msgs = oldUrlPattern.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BindingPackage.HTTP_BINDING__URL_PATTERN, null, null);
                if (newUrlPattern.eInternalContainer() == null) {
                    msgs = newUrlPattern.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BindingPackage.HTTP_BINDING__URL_PATTERN, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingPackage.HTTP_BINDING__URL_PATTERN, oldUrlPattern, urlPattern));
            }
        }
        return urlPattern;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UrlPattern basicGetUrlPattern() {
        return urlPattern;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetUrlPattern(UrlPattern newUrlPattern, NotificationChain msgs) {
        UrlPattern oldUrlPattern = urlPattern;
        urlPattern = newUrlPattern;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BindingPackage.HTTP_BINDING__URL_PATTERN, oldUrlPattern, newUrlPattern);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUrlPattern(UrlPattern newUrlPattern) {
        if (newUrlPattern != urlPattern) {
            NotificationChain msgs = null;
            if (urlPattern != null)
                msgs = ((InternalEObject)urlPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BindingPackage.HTTP_BINDING__URL_PATTERN, null, msgs);
            if (newUrlPattern != null)
                msgs = ((InternalEObject)newUrlPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BindingPackage.HTTP_BINDING__URL_PATTERN, null, msgs);
            msgs = basicSetUrlPattern(newUrlPattern, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.HTTP_BINDING__URL_PATTERN, newUrlPattern, newUrlPattern));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BindingPackage.HTTP_BINDING__URL_PATTERN:
                return basicSetUrlPattern(null, msgs);
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
            case BindingPackage.HTTP_BINDING__URL_PATTERN:
                if (resolve) return getUrlPattern();
                return basicGetUrlPattern();
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
            case BindingPackage.HTTP_BINDING__URL_PATTERN:
                setUrlPattern((UrlPattern)newValue);
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
            case BindingPackage.HTTP_BINDING__URL_PATTERN:
                setUrlPattern((UrlPattern)null);
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
            case BindingPackage.HTTP_BINDING__URL_PATTERN:
                return urlPattern != null;
        }
        return super.eIsSet(featureID);
    }

} //HttpBindingImpl
