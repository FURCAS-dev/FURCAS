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

import sproxy_content.Field;
import sproxy_content.FieldProperties;
import sproxy_content.Sproxy_contentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getEnabledFinal <em>Enabled Final</em>}</li>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getReadonly <em>Readonly</em>}</li>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getReadonlyFinal <em>Readonly Final</em>}</li>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getMandatory <em>Mandatory</em>}</li>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getMandatoryFinal <em>Mandatory Final</em>}</li>
 *   <li>{@link sproxy_content.impl.FieldPropertiesImpl#getField <em>Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldPropertiesImpl extends EObjectImpl implements FieldProperties
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
   * The cached value of the '{@link #getReadonly() <em>Readonly</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReadonly()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean readonly;

  /**
   * The cached value of the '{@link #getReadonlyFinal() <em>Readonly Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReadonlyFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean readonlyFinal;

  /**
   * The cached value of the '{@link #getMandatory() <em>Mandatory</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMandatory()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean mandatory;

  /**
   * The cached value of the '{@link #getMandatoryFinal() <em>Mandatory Final</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMandatoryFinal()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean mandatoryFinal;

  /**
   * The cached value of the '{@link #getField() <em>Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getField()
   * @generated
   * @ordered
   */
  protected Field field;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldPropertiesImpl()
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
    return Sproxy_contentPackage.Literals.FIELD_PROPERTIES;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED, oldEnabled, newEnabled);
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
        msgs = ((InternalEObject)enabled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED, null, msgs);
      if (newEnabled != null)
        msgs = ((InternalEObject)newEnabled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED, null, msgs);
      msgs = basicSetEnabled(newEnabled, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED, newEnabled, newEnabled));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL, oldEnabledFinal, newEnabledFinal);
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
        msgs = ((InternalEObject)enabledFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL, null, msgs);
      if (newEnabledFinal != null)
        msgs = ((InternalEObject)newEnabledFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL, null, msgs);
      msgs = basicSetEnabledFinal(newEnabledFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL, newEnabledFinal, newEnabledFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getReadonly()
  {
    return readonly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReadonly(runtime.primitivetypes.Boolean newReadonly, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldReadonly = readonly;
    readonly = newReadonly;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__READONLY, oldReadonly, newReadonly);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadonly(runtime.primitivetypes.Boolean newReadonly)
  {
    if (newReadonly != readonly)
    {
      NotificationChain msgs = null;
      if (readonly != null)
        msgs = ((InternalEObject)readonly).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__READONLY, null, msgs);
      if (newReadonly != null)
        msgs = ((InternalEObject)newReadonly).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__READONLY, null, msgs);
      msgs = basicSetReadonly(newReadonly, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__READONLY, newReadonly, newReadonly));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getReadonlyFinal()
  {
    return readonlyFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReadonlyFinal(runtime.primitivetypes.Boolean newReadonlyFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldReadonlyFinal = readonlyFinal;
    readonlyFinal = newReadonlyFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL, oldReadonlyFinal, newReadonlyFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadonlyFinal(runtime.primitivetypes.Boolean newReadonlyFinal)
  {
    if (newReadonlyFinal != readonlyFinal)
    {
      NotificationChain msgs = null;
      if (readonlyFinal != null)
        msgs = ((InternalEObject)readonlyFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL, null, msgs);
      if (newReadonlyFinal != null)
        msgs = ((InternalEObject)newReadonlyFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL, null, msgs);
      msgs = basicSetReadonlyFinal(newReadonlyFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL, newReadonlyFinal, newReadonlyFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getMandatory()
  {
    return mandatory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMandatory(runtime.primitivetypes.Boolean newMandatory, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldMandatory = mandatory;
    mandatory = newMandatory;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY, oldMandatory, newMandatory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMandatory(runtime.primitivetypes.Boolean newMandatory)
  {
    if (newMandatory != mandatory)
    {
      NotificationChain msgs = null;
      if (mandatory != null)
        msgs = ((InternalEObject)mandatory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY, null, msgs);
      if (newMandatory != null)
        msgs = ((InternalEObject)newMandatory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY, null, msgs);
      msgs = basicSetMandatory(newMandatory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY, newMandatory, newMandatory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getMandatoryFinal()
  {
    return mandatoryFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMandatoryFinal(runtime.primitivetypes.Boolean newMandatoryFinal, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldMandatoryFinal = mandatoryFinal;
    mandatoryFinal = newMandatoryFinal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL, oldMandatoryFinal, newMandatoryFinal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMandatoryFinal(runtime.primitivetypes.Boolean newMandatoryFinal)
  {
    if (newMandatoryFinal != mandatoryFinal)
    {
      NotificationChain msgs = null;
      if (mandatoryFinal != null)
        msgs = ((InternalEObject)mandatoryFinal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL, null, msgs);
      if (newMandatoryFinal != null)
        msgs = ((InternalEObject)newMandatoryFinal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL, null, msgs);
      msgs = basicSetMandatoryFinal(newMandatoryFinal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL, newMandatoryFinal, newMandatoryFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Field getField()
  {
    if (field != null && field.eIsProxy())
    {
      InternalEObject oldField = (InternalEObject)field;
      field = (Field)eResolveProxy(oldField);
      if (field != oldField)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sproxy_contentPackage.FIELD_PROPERTIES__FIELD, oldField, field));
      }
    }
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Field basicGetField()
  {
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetField(Field newField, NotificationChain msgs)
  {
    Field oldField = field;
    field = newField;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__FIELD, oldField, newField);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setField(Field newField)
  {
    if (newField != field)
    {
      NotificationChain msgs = null;
      if (field != null)
        msgs = ((InternalEObject)field).eInverseRemove(this, Sproxy_contentPackage.FIELD__PROPERTIES, Field.class, msgs);
      if (newField != null)
        msgs = ((InternalEObject)newField).eInverseAdd(this, Sproxy_contentPackage.FIELD__PROPERTIES, Field.class, msgs);
      msgs = basicSetField(newField, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Sproxy_contentPackage.FIELD_PROPERTIES__FIELD, newField, newField));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Sproxy_contentPackage.FIELD_PROPERTIES__FIELD:
        if (field != null)
          msgs = ((InternalEObject)field).eInverseRemove(this, Sproxy_contentPackage.FIELD__PROPERTIES, Field.class, msgs);
        return basicSetField((Field)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED:
        return basicSetEnabled(null, msgs);
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL:
        return basicSetEnabledFinal(null, msgs);
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY:
        return basicSetReadonly(null, msgs);
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL:
        return basicSetReadonlyFinal(null, msgs);
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY:
        return basicSetMandatory(null, msgs);
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL:
        return basicSetMandatoryFinal(null, msgs);
      case Sproxy_contentPackage.FIELD_PROPERTIES__FIELD:
        return basicSetField(null, msgs);
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
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED:
        return getEnabled();
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL:
        return getEnabledFinal();
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY:
        return getReadonly();
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL:
        return getReadonlyFinal();
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY:
        return getMandatory();
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL:
        return getMandatoryFinal();
      case Sproxy_contentPackage.FIELD_PROPERTIES__FIELD:
        if (resolve) return getField();
        return basicGetField();
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
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED:
        setEnabled((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL:
        setEnabledFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY:
        setReadonly((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL:
        setReadonlyFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY:
        setMandatory((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL:
        setMandatoryFinal((runtime.primitivetypes.Boolean)newValue);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__FIELD:
        setField((Field)newValue);
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
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED:
        setEnabled((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL:
        setEnabledFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY:
        setReadonly((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL:
        setReadonlyFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY:
        setMandatory((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL:
        setMandatoryFinal((runtime.primitivetypes.Boolean)null);
        return;
      case Sproxy_contentPackage.FIELD_PROPERTIES__FIELD:
        setField((Field)null);
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
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED:
        return enabled != null;
      case Sproxy_contentPackage.FIELD_PROPERTIES__ENABLED_FINAL:
        return enabledFinal != null;
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY:
        return readonly != null;
      case Sproxy_contentPackage.FIELD_PROPERTIES__READONLY_FINAL:
        return readonlyFinal != null;
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY:
        return mandatory != null;
      case Sproxy_contentPackage.FIELD_PROPERTIES__MANDATORY_FINAL:
        return mandatoryFinal != null;
      case Sproxy_contentPackage.FIELD_PROPERTIES__FIELD:
        return field != null;
    }
    return super.eIsSet(featureID);
  }

} //FieldPropertiesImpl
