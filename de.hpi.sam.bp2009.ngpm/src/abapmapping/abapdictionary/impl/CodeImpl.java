/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.Code;
import abapmapping.abapdictionary.CodeValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeImpl#getExtensible <em>Extensible</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.CodeImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeImpl extends DataElementImpl implements Code
{
  /**
   * The cached value of the '{@link #getExtensible() <em>Extensible</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensible()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.Boolean extensible;

  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<CodeValue> values;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeImpl()
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
    return AbapdictionaryPackage.Literals.CODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean getExtensible()
  {
    return extensible;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtensible(runtime.primitivetypes.Boolean newExtensible, NotificationChain msgs)
  {
    runtime.primitivetypes.Boolean oldExtensible = extensible;
    extensible = newExtensible;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE__EXTENSIBLE, oldExtensible, newExtensible);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtensible(runtime.primitivetypes.Boolean newExtensible)
  {
    if (newExtensible != extensible)
    {
      NotificationChain msgs = null;
      if (extensible != null)
        msgs = ((InternalEObject)extensible).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.CODE__EXTENSIBLE, null, msgs);
      if (newExtensible != null)
        msgs = ((InternalEObject)newExtensible).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.CODE__EXTENSIBLE, null, msgs);
      msgs = basicSetExtensible(newExtensible, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.CODE__EXTENSIBLE, newExtensible, newExtensible));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CodeValue> getValues()
  {
    if (values == null)
    {
      values = new EObjectContainmentEList<CodeValue>(CodeValue.class, this, AbapdictionaryPackage.CODE__VALUES);
    }
    return values;
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
      case AbapdictionaryPackage.CODE__EXTENSIBLE:
        return basicSetExtensible(null, msgs);
      case AbapdictionaryPackage.CODE__VALUES:
        return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
      case AbapdictionaryPackage.CODE__EXTENSIBLE:
        return getExtensible();
      case AbapdictionaryPackage.CODE__VALUES:
        return getValues();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AbapdictionaryPackage.CODE__EXTENSIBLE:
        setExtensible((runtime.primitivetypes.Boolean)newValue);
        return;
      case AbapdictionaryPackage.CODE__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends CodeValue>)newValue);
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
      case AbapdictionaryPackage.CODE__EXTENSIBLE:
        setExtensible((runtime.primitivetypes.Boolean)null);
        return;
      case AbapdictionaryPackage.CODE__VALUES:
        getValues().clear();
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
      case AbapdictionaryPackage.CODE__EXTENSIBLE:
        return extensible != null;
      case AbapdictionaryPackage.CODE__VALUES:
        return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CodeImpl
