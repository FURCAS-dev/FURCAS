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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
public class SimpleUrlPatternImpl extends UrlPatternImpl implements SimpleUrlPattern
{
  /**
   * The cached value of the '{@link #getBaseUrl() <em>Base Url</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseUrl()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String baseUrl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleUrlPatternImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return BindingPackage.Literals.SIMPLE_URL_PATTERN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getBaseUrl()
  {
    return baseUrl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaseUrl(runtime.primitivetypes.String newBaseUrl, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldBaseUrl = baseUrl;
    baseUrl = newBaseUrl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BindingPackage.SIMPLE_URL_PATTERN__BASE_URL, oldBaseUrl, newBaseUrl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaseUrl(runtime.primitivetypes.String newBaseUrl)
  {
    if (newBaseUrl != baseUrl)
    {
      NotificationChain msgs = null;
      if (baseUrl != null)
        msgs = ((InternalEObject)baseUrl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BindingPackage.SIMPLE_URL_PATTERN__BASE_URL, null, msgs);
      if (newBaseUrl != null)
        msgs = ((InternalEObject)newBaseUrl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BindingPackage.SIMPLE_URL_PATTERN__BASE_URL, null, msgs);
      msgs = basicSetBaseUrl(newBaseUrl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.SIMPLE_URL_PATTERN__BASE_URL, newBaseUrl, newBaseUrl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
        return basicSetBaseUrl(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
        setBaseUrl((runtime.primitivetypes.String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
        setBaseUrl((runtime.primitivetypes.String)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case BindingPackage.SIMPLE_URL_PATTERN__BASE_URL:
        return baseUrl != null;
    }
    return super.eIsSet(featureID);
  }

} //SimpleUrlPatternImpl
