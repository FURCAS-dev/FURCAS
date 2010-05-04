/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessconfigurationPackage;
import configuration.businessconfiguration.ValueSet;
import configuration.businessconfiguration.ValueSetEntry;

import dataaccess.expressions.Expression;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Set Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#getCanBeChanged <em>Can Be Changed</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#getCanBeDeleted <em>Can Be Deleted</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#getValueSet <em>Value Set</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetEntryImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueSetEntryImpl extends NamedElementImpl implements ValueSetEntry
{
  /**
   * The cached value of the '{@link #getCanBeChanged() <em>Can Be Changed</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCanBeChanged()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean canBeChanged;

  /**
   * The cached value of the '{@link #getCanBeDeleted() <em>Can Be Deleted</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCanBeDeleted()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean canBeDeleted;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Expression value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValueSetEntryImpl()
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
    return BusinessconfigurationPackage.Literals.VALUE_SET_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getCanBeChanged()
  {
    return canBeChanged;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCanBeChanged(runtime.primitivetypes.Boolean newCanBeChanged, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldCanBeChanged = canBeChanged;
    canBeChanged = newCanBeChanged;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED, oldCanBeChanged, newCanBeChanged);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCanBeChanged(runtime.primitivetypes.Boolean newCanBeChanged)
  {
    if (newCanBeChanged != canBeChanged)
    {
      NotificationChain msgs = null;
      if (canBeChanged != null)
        msgs = ((InternalEObject)canBeChanged).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED, null, msgs);
      if (newCanBeChanged != null)
        msgs = ((InternalEObject)newCanBeChanged).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED, null, msgs);
      msgs = basicSetCanBeChanged(newCanBeChanged, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED, newCanBeChanged, newCanBeChanged));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getCanBeDeleted()
  {
    return canBeDeleted;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCanBeDeleted(runtime.primitivetypes.Boolean newCanBeDeleted, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldCanBeDeleted = canBeDeleted;
    canBeDeleted = newCanBeDeleted;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED, oldCanBeDeleted, newCanBeDeleted);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCanBeDeleted(runtime.primitivetypes.Boolean newCanBeDeleted)
  {
    if (newCanBeDeleted != canBeDeleted)
    {
      NotificationChain msgs = null;
      if (canBeDeleted != null)
        msgs = ((InternalEObject)canBeDeleted).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED, null, msgs);
      if (newCanBeDeleted != null)
        msgs = ((InternalEObject)newCanBeDeleted).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED, null, msgs);
      msgs = basicSetCanBeDeleted(newCanBeDeleted, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED, newCanBeDeleted, newCanBeDeleted));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueSet getValueSet()
  {
    if (eContainerFeatureID() != BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET) return null;
    return (ValueSet)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueSet(ValueSet newValueSet, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newValueSet, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueSet(ValueSet newValueSet)
  {
    if (newValueSet != eInternalContainer() || (eContainerFeatureID() != BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET && newValueSet != null))
    {
      if (EcoreUtil.isAncestor(this, newValueSet))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newValueSet != null)
        msgs = ((InternalEObject)newValueSet).eInverseAdd(this, BusinessconfigurationPackage.VALUE_SET__ENTRIES, ValueSet.class, msgs);
      msgs = basicSetValueSet(newValueSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET, newValueSet, newValueSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs)
  {
    Expression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Expression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE, newValue, newValue));
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
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetValueSet((ValueSet)otherEnd, msgs);
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
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
        return basicSetCanBeChanged(null, msgs);
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
        return basicSetCanBeDeleted(null, msgs);
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        return basicSetValueSet(null, msgs);
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
        return basicSetValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        return eInternalContainer().eInverseRemove(this, BusinessconfigurationPackage.VALUE_SET__ENTRIES, ValueSet.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
        return getCanBeChanged();
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
        return getCanBeDeleted();
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        return getValueSet();
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
        return getValue();
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
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
        setCanBeChanged((runtime.primitivetypes.Boolean)newValue);
        return;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
        setCanBeDeleted((runtime.primitivetypes.Boolean)newValue);
        return;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        setValueSet((ValueSet)newValue);
        return;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
        setValue((Expression)newValue);
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
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
        setCanBeChanged((runtime.primitivetypes.Boolean)null);
        return;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
        setCanBeDeleted((runtime.primitivetypes.Boolean)null);
        return;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        setValueSet((ValueSet)null);
        return;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
        setValue((Expression)null);
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
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_CHANGED:
        return canBeChanged != null;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__CAN_BE_DELETED:
        return canBeDeleted != null;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET:
        return getValueSet() != null;
      case BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //ValueSetEntryImpl
