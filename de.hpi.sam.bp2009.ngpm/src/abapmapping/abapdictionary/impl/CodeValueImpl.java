/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapPrimtiveType;
import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.CodeValue;

import localization.TranslatableText;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import sproxy_content.LanguageDependentText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeValueImpl#getLanguageDependentDescription <em>Language Dependent Description</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeValueImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeValueImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeValueImpl extends EObjectImpl implements CodeValue
{
  /**
   * The cached value of the '{@link #getLanguageDependentDescription() <em>Language Dependent Description</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguageDependentDescription()
   * @generated
   * @ordered
   */
  protected LanguageDependentText languageDependentDescription;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String value;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected TranslatableText description;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected AbapPrimtiveType type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeValueImpl()
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
    return AbapdictionaryPackage.Literals.CODE_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LanguageDependentText getLanguageDependentDescription()
  {
    if (languageDependentDescription != null && languageDependentDescription.eIsProxy())
    {
      InternalEObject oldLanguageDependentDescription = (InternalEObject)languageDependentDescription;
      languageDependentDescription = (LanguageDependentText)eResolveProxy(oldLanguageDependentDescription);
      if (languageDependentDescription != oldLanguageDependentDescription)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbapdictionaryPackage.CODE_VALUE__LANGUAGE_DEPENDENT_DESCRIPTION, oldLanguageDependentDescription, languageDependentDescription));
      }
    }
    return languageDependentDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LanguageDependentText basicGetLanguageDependentDescription()
  {
    return languageDependentDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLanguageDependentDescription(LanguageDependentText newLanguageDependentDescription)
  {
    LanguageDependentText oldLanguageDependentDescription = languageDependentDescription;
    languageDependentDescription = newLanguageDependentDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE_VALUE__LANGUAGE_DEPENDENT_DESCRIPTION, oldLanguageDependentDescription, languageDependentDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(runtime.primitivetypes.String newValue, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE_VALUE__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(runtime.primitivetypes.String newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.CODE_VALUE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.CODE_VALUE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE_VALUE__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TranslatableText getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDescription(TranslatableText newDescription, NotificationChain msgs)
  {
    TranslatableText oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE_VALUE__DESCRIPTION, oldDescription, newDescription);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(TranslatableText newDescription)
  {
    if (newDescription != description)
    {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.CODE_VALUE__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.CODE_VALUE__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE_VALUE__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbapPrimtiveType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (AbapPrimtiveType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbapdictionaryPackage.CODE_VALUE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbapPrimtiveType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(AbapPrimtiveType newType)
  {
    AbapPrimtiveType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE_VALUE__TYPE, oldType, type));
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
      case AbapdictionaryPackage.CODE_VALUE__VALUE:
        return basicSetValue(null, msgs);
      case AbapdictionaryPackage.CODE_VALUE__DESCRIPTION:
        return basicSetDescription(null, msgs);
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
      case AbapdictionaryPackage.CODE_VALUE__LANGUAGE_DEPENDENT_DESCRIPTION:
        if (resolve) return getLanguageDependentDescription();
        return basicGetLanguageDependentDescription();
      case AbapdictionaryPackage.CODE_VALUE__VALUE:
        return getValue();
      case AbapdictionaryPackage.CODE_VALUE__DESCRIPTION:
        return getDescription();
      case AbapdictionaryPackage.CODE_VALUE__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case AbapdictionaryPackage.CODE_VALUE__LANGUAGE_DEPENDENT_DESCRIPTION:
        setLanguageDependentDescription((LanguageDependentText)newValue);
        return;
      case AbapdictionaryPackage.CODE_VALUE__VALUE:
        setValue((runtime.primitivetypes.String)newValue);
        return;
      case AbapdictionaryPackage.CODE_VALUE__DESCRIPTION:
        setDescription((TranslatableText)newValue);
        return;
      case AbapdictionaryPackage.CODE_VALUE__TYPE:
        setType((AbapPrimtiveType)newValue);
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
      case AbapdictionaryPackage.CODE_VALUE__LANGUAGE_DEPENDENT_DESCRIPTION:
        setLanguageDependentDescription((LanguageDependentText)null);
        return;
      case AbapdictionaryPackage.CODE_VALUE__VALUE:
        setValue((runtime.primitivetypes.String)null);
        return;
      case AbapdictionaryPackage.CODE_VALUE__DESCRIPTION:
        setDescription((TranslatableText)null);
        return;
      case AbapdictionaryPackage.CODE_VALUE__TYPE:
        setType((AbapPrimtiveType)null);
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
      case AbapdictionaryPackage.CODE_VALUE__LANGUAGE_DEPENDENT_DESCRIPTION:
        return languageDependentDescription != null;
      case AbapdictionaryPackage.CODE_VALUE__VALUE:
        return value != null;
      case AbapdictionaryPackage.CODE_VALUE__DESCRIPTION:
        return description != null;
      case AbapdictionaryPackage.CODE_VALUE__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

} //CodeValueImpl
