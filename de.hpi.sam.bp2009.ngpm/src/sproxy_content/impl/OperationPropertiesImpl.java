/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import sproxy_content.OperationProperties;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.OperationPropertiesImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link sproxy_content.impl.OperationPropertiesImpl#getEnabledFinal <em>Enabled Final</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationPropertiesImpl extends EObjectImpl implements OperationProperties
{
  /**
   * The cached value of the '{@link #getEnabled() <em>Enabled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnabled()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean enabled;

  /**
   * The cached value of the '{@link #getEnabledFinal() <em>Enabled Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnabledFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean enabledFinal;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationPropertiesImpl()
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
    return Sproxy_contentPackage.Literals.OPERATION_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getEnabled()
  {
    return enabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnabled(runtime.primitivetypes.Boolean newEnabled, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldEnabled = enabled;
    enabled = newEnabled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED, oldEnabled, newEnabled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnabled(runtime.primitivetypes.Boolean newEnabled)
  {
    if (newEnabled != enabled)
    {
      NotificationChain msgs = null;
      if (enabled != null)
        msgs = ((InternalEObject)enabled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED, null, msgs);
      if (newEnabled != null)
        msgs = ((InternalEObject)newEnabled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED, null, msgs);
      msgs = basicSetEnabled(newEnabled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED, newEnabled, newEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getEnabledFinal()
  {
    return enabledFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnabledFinal(runtime.primitivetypes.Boolean newEnabledFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldEnabledFinal = enabledFinal;
    enabledFinal = newEnabledFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL, oldEnabledFinal, newEnabledFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnabledFinal(runtime.primitivetypes.Boolean newEnabledFinal)
  {
    if (newEnabledFinal != enabledFinal)
    {
      NotificationChain msgs = null;
      if (enabledFinal != null)
        msgs = ((InternalEObject)enabledFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL, null, msgs);
      if (newEnabledFinal != null)
        msgs = ((InternalEObject)newEnabledFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL, null, msgs);
      msgs = basicSetEnabledFinal(newEnabledFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL, newEnabledFinal, newEnabledFinal));
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
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED:
        return basicSetEnabled(null, msgs);
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL:
        return basicSetEnabledFinal(null, msgs);
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
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED:
        return getEnabled();
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL:
        return getEnabledFinal();
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
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED:
        setEnabled((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL:
        setEnabledFinal((runtime.primitivetypes.Boolean)newValue);
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
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED:
        setEnabled((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL:
        setEnabledFinal((runtime.primitivetypes.Boolean)null);
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
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED:
        return enabled != null;
      case Sproxy_contentPackage.OPERATION_PROPERTIES__ENABLED_FINAL:
        return enabledFinal != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationPropertiesImpl
