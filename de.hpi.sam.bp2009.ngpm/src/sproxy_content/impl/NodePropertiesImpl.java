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

import sproxy_content.NodeProperties;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getEnabledFinal <em>Enabled Final</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getCreateEnabled <em>Create Enabled</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getCreateEnabledFinal <em>Create Enabled Final</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getUpdateEnabled <em>Update Enabled</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getUpdateEnabledFinal <em>Update Enabled Final</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getDeleteEnabled <em>Delete Enabled</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getDeleteEnabledFinal <em>Delete Enabled Final</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getTransientKey <em>Transient Key</em>}</li>
 *   <li>{@link sproxy_content.impl.NodePropertiesImpl#getTransientKeyFinal <em>Transient Key Final</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodePropertiesImpl extends EObjectImpl implements NodeProperties
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
   * The cached value of the '{@link #getCreateEnabled() <em>Create Enabled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateEnabled()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean createEnabled;

  /**
   * The cached value of the '{@link #getCreateEnabledFinal() <em>Create Enabled Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateEnabledFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean createEnabledFinal;

  /**
   * The cached value of the '{@link #getUpdateEnabled() <em>Update Enabled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateEnabled()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean updateEnabled;

  /**
   * The cached value of the '{@link #getUpdateEnabledFinal() <em>Update Enabled Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateEnabledFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean updateEnabledFinal;

  /**
   * The cached value of the '{@link #getDeleteEnabled() <em>Delete Enabled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeleteEnabled()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean deleteEnabled;

  /**
   * The cached value of the '{@link #getDeleteEnabledFinal() <em>Delete Enabled Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeleteEnabledFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean deleteEnabledFinal;

  /**
   * The cached value of the '{@link #getTransientKey() <em>Transient Key</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransientKey()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean transientKey;

  /**
   * The cached value of the '{@link #getTransientKeyFinal() <em>Transient Key Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransientKeyFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean transientKeyFinal;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodePropertiesImpl()
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
    return Sproxy_contentPackage.Literals.NODE_PROPERTIES;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__ENABLED, oldEnabled, newEnabled);
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
        msgs = ((InternalEObject)enabled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__ENABLED, null, msgs);
      if (newEnabled != null)
        msgs = ((InternalEObject)newEnabled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__ENABLED, null, msgs);
      msgs = basicSetEnabled(newEnabled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__ENABLED, newEnabled, newEnabled));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL, oldEnabledFinal, newEnabledFinal);
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
        msgs = ((InternalEObject)enabledFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL, null, msgs);
      if (newEnabledFinal != null)
        msgs = ((InternalEObject)newEnabledFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL, null, msgs);
      msgs = basicSetEnabledFinal(newEnabledFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL, newEnabledFinal, newEnabledFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getCreateEnabled()
  {
    return createEnabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCreateEnabled(runtime.primitivetypes.Boolean newCreateEnabled, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldCreateEnabled = createEnabled;
    createEnabled = newCreateEnabled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED, oldCreateEnabled, newCreateEnabled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreateEnabled(runtime.primitivetypes.Boolean newCreateEnabled)
  {
    if (newCreateEnabled != createEnabled)
    {
      NotificationChain msgs = null;
      if (createEnabled != null)
        msgs = ((InternalEObject)createEnabled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED, null, msgs);
      if (newCreateEnabled != null)
        msgs = ((InternalEObject)newCreateEnabled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED, null, msgs);
      msgs = basicSetCreateEnabled(newCreateEnabled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED, newCreateEnabled, newCreateEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getCreateEnabledFinal()
  {
    return createEnabledFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCreateEnabledFinal(runtime.primitivetypes.Boolean newCreateEnabledFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldCreateEnabledFinal = createEnabledFinal;
    createEnabledFinal = newCreateEnabledFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL, oldCreateEnabledFinal, newCreateEnabledFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreateEnabledFinal(runtime.primitivetypes.Boolean newCreateEnabledFinal)
  {
    if (newCreateEnabledFinal != createEnabledFinal)
    {
      NotificationChain msgs = null;
      if (createEnabledFinal != null)
        msgs = ((InternalEObject)createEnabledFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL, null, msgs);
      if (newCreateEnabledFinal != null)
        msgs = ((InternalEObject)newCreateEnabledFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL, null, msgs);
      msgs = basicSetCreateEnabledFinal(newCreateEnabledFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL, newCreateEnabledFinal, newCreateEnabledFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getUpdateEnabled()
  {
    return updateEnabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpdateEnabled(runtime.primitivetypes.Boolean newUpdateEnabled, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldUpdateEnabled = updateEnabled;
    updateEnabled = newUpdateEnabled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED, oldUpdateEnabled, newUpdateEnabled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdateEnabled(runtime.primitivetypes.Boolean newUpdateEnabled)
  {
    if (newUpdateEnabled != updateEnabled)
    {
      NotificationChain msgs = null;
      if (updateEnabled != null)
        msgs = ((InternalEObject)updateEnabled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED, null, msgs);
      if (newUpdateEnabled != null)
        msgs = ((InternalEObject)newUpdateEnabled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED, null, msgs);
      msgs = basicSetUpdateEnabled(newUpdateEnabled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED, newUpdateEnabled, newUpdateEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getUpdateEnabledFinal()
  {
    return updateEnabledFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpdateEnabledFinal(runtime.primitivetypes.Boolean newUpdateEnabledFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldUpdateEnabledFinal = updateEnabledFinal;
    updateEnabledFinal = newUpdateEnabledFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL, oldUpdateEnabledFinal, newUpdateEnabledFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdateEnabledFinal(runtime.primitivetypes.Boolean newUpdateEnabledFinal)
  {
    if (newUpdateEnabledFinal != updateEnabledFinal)
    {
      NotificationChain msgs = null;
      if (updateEnabledFinal != null)
        msgs = ((InternalEObject)updateEnabledFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL, null, msgs);
      if (newUpdateEnabledFinal != null)
        msgs = ((InternalEObject)newUpdateEnabledFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL, null, msgs);
      msgs = basicSetUpdateEnabledFinal(newUpdateEnabledFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL, newUpdateEnabledFinal, newUpdateEnabledFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getDeleteEnabled()
  {
    return deleteEnabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeleteEnabled(runtime.primitivetypes.Boolean newDeleteEnabled, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldDeleteEnabled = deleteEnabled;
    deleteEnabled = newDeleteEnabled;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED, oldDeleteEnabled, newDeleteEnabled);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeleteEnabled(runtime.primitivetypes.Boolean newDeleteEnabled)
  {
    if (newDeleteEnabled != deleteEnabled)
    {
      NotificationChain msgs = null;
      if (deleteEnabled != null)
        msgs = ((InternalEObject)deleteEnabled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED, null, msgs);
      if (newDeleteEnabled != null)
        msgs = ((InternalEObject)newDeleteEnabled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED, null, msgs);
      msgs = basicSetDeleteEnabled(newDeleteEnabled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED, newDeleteEnabled, newDeleteEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getDeleteEnabledFinal()
  {
    return deleteEnabledFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeleteEnabledFinal(runtime.primitivetypes.Boolean newDeleteEnabledFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldDeleteEnabledFinal = deleteEnabledFinal;
    deleteEnabledFinal = newDeleteEnabledFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL, oldDeleteEnabledFinal, newDeleteEnabledFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeleteEnabledFinal(runtime.primitivetypes.Boolean newDeleteEnabledFinal)
  {
    if (newDeleteEnabledFinal != deleteEnabledFinal)
    {
      NotificationChain msgs = null;
      if (deleteEnabledFinal != null)
        msgs = ((InternalEObject)deleteEnabledFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL, null, msgs);
      if (newDeleteEnabledFinal != null)
        msgs = ((InternalEObject)newDeleteEnabledFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL, null, msgs);
      msgs = basicSetDeleteEnabledFinal(newDeleteEnabledFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL, newDeleteEnabledFinal, newDeleteEnabledFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getTransientKey()
  {
    return transientKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTransientKey(runtime.primitivetypes.Boolean newTransientKey, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldTransientKey = transientKey;
    transientKey = newTransientKey;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY, oldTransientKey, newTransientKey);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransientKey(runtime.primitivetypes.Boolean newTransientKey)
  {
    if (newTransientKey != transientKey)
    {
      NotificationChain msgs = null;
      if (transientKey != null)
        msgs = ((InternalEObject)transientKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY, null, msgs);
      if (newTransientKey != null)
        msgs = ((InternalEObject)newTransientKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY, null, msgs);
      msgs = basicSetTransientKey(newTransientKey, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY, newTransientKey, newTransientKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getTransientKeyFinal()
  {
    return transientKeyFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTransientKeyFinal(runtime.primitivetypes.Boolean newTransientKeyFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldTransientKeyFinal = transientKeyFinal;
    transientKeyFinal = newTransientKeyFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL, oldTransientKeyFinal, newTransientKeyFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransientKeyFinal(runtime.primitivetypes.Boolean newTransientKeyFinal)
  {
    if (newTransientKeyFinal != transientKeyFinal)
    {
      NotificationChain msgs = null;
      if (transientKeyFinal != null)
        msgs = ((InternalEObject)transientKeyFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL, null, msgs);
      if (newTransientKeyFinal != null)
        msgs = ((InternalEObject)newTransientKeyFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL, null, msgs);
      msgs = basicSetTransientKeyFinal(newTransientKeyFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL, newTransientKeyFinal, newTransientKeyFinal));
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
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED:
        return basicSetEnabled(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL:
        return basicSetEnabledFinal(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED:
        return basicSetCreateEnabled(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL:
        return basicSetCreateEnabledFinal(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED:
        return basicSetUpdateEnabled(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL:
        return basicSetUpdateEnabledFinal(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED:
        return basicSetDeleteEnabled(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL:
        return basicSetDeleteEnabledFinal(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY:
        return basicSetTransientKey(null, msgs);
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL:
        return basicSetTransientKeyFinal(null, msgs);
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
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED:
        return getEnabled();
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL:
        return getEnabledFinal();
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED:
        return getCreateEnabled();
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL:
        return getCreateEnabledFinal();
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED:
        return getUpdateEnabled();
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL:
        return getUpdateEnabledFinal();
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED:
        return getDeleteEnabled();
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL:
        return getDeleteEnabledFinal();
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY:
        return getTransientKey();
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL:
        return getTransientKeyFinal();
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
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED:
        setEnabled((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL:
        setEnabledFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED:
        setCreateEnabled((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL:
        setCreateEnabledFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED:
        setUpdateEnabled((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL:
        setUpdateEnabledFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED:
        setDeleteEnabled((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL:
        setDeleteEnabledFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY:
        setTransientKey((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL:
        setTransientKeyFinal((runtime.primitivetypes.Boolean)newValue);
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
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED:
        setEnabled((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL:
        setEnabledFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED:
        setCreateEnabled((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL:
        setCreateEnabledFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED:
        setUpdateEnabled((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL:
        setUpdateEnabledFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED:
        setDeleteEnabled((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL:
        setDeleteEnabledFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY:
        setTransientKey((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL:
        setTransientKeyFinal((runtime.primitivetypes.Boolean)null);
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
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED:
        return enabled != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__ENABLED_FINAL:
        return enabledFinal != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED:
        return createEnabled != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__CREATE_ENABLED_FINAL:
        return createEnabledFinal != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED:
        return updateEnabled != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__UPDATE_ENABLED_FINAL:
        return updateEnabledFinal != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED:
        return deleteEnabled != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__DELETE_ENABLED_FINAL:
        return deleteEnabledFinal != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY:
        return transientKey != null;
      case Sproxy_contentPackage.NODE_PROPERTIES__TRANSIENT_KEY_FINAL:
        return transientKeyFinal != null;
    }
    return super.eIsSet(featureID);
  }

} //NodePropertiesImpl
