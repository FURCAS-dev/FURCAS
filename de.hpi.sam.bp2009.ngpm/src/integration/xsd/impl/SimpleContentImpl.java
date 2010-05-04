/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.SimpleContent;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.SimpleContentImpl#getBase <em>Base</em>}</li>
 *   <li>{@link integration.xsd.impl.SimpleContentImpl#getEnumVals <em>Enum Vals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleContentImpl extends AbstractContentImpl implements SimpleContent
{
  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String base;

  /**
   * The cached value of the '{@link #getEnumVals() <em>Enum Vals</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumVals()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String enumVals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleContentImpl()
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
    return XsdPackage.Literals.SIMPLE_CONTENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBase(runtime.primitivetypes.String newBase, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldBase = base;
    base = newBase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.SIMPLE_CONTENT__BASE, oldBase, newBase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(runtime.primitivetypes.String newBase)
  {
    if (newBase != base)
    {
      NotificationChain msgs = null;
      if (base != null)
        msgs = ((InternalEObject)base).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.SIMPLE_CONTENT__BASE, null, msgs);
      if (newBase != null)
        msgs = ((InternalEObject)newBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.SIMPLE_CONTENT__BASE, null, msgs);
      msgs = basicSetBase(newBase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.SIMPLE_CONTENT__BASE, newBase, newBase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getEnumVals()
  {
    return enumVals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnumVals(runtime.primitivetypes.String newEnumVals, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldEnumVals = enumVals;
    enumVals = newEnumVals;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsdPackage.SIMPLE_CONTENT__ENUM_VALS, oldEnumVals, newEnumVals);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumVals(runtime.primitivetypes.String newEnumVals)
  {
    if (newEnumVals != enumVals)
    {
      NotificationChain msgs = null;
      if (enumVals != null)
        msgs = ((InternalEObject)enumVals).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsdPackage.SIMPLE_CONTENT__ENUM_VALS, null, msgs);
      if (newEnumVals != null)
        msgs = ((InternalEObject)newEnumVals).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsdPackage.SIMPLE_CONTENT__ENUM_VALS, null, msgs);
      msgs = basicSetEnumVals(newEnumVals, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.SIMPLE_CONTENT__ENUM_VALS, newEnumVals, newEnumVals));
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
      case XsdPackage.SIMPLE_CONTENT__BASE:
        return basicSetBase(null, msgs);
      case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
        return basicSetEnumVals(null, msgs);
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
      case XsdPackage.SIMPLE_CONTENT__BASE:
        return getBase();
      case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
        return getEnumVals();
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
      case XsdPackage.SIMPLE_CONTENT__BASE:
        setBase((runtime.primitivetypes.String)newValue);
        return;
      case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
        setEnumVals((runtime.primitivetypes.String)newValue);
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
      case XsdPackage.SIMPLE_CONTENT__BASE:
        setBase((runtime.primitivetypes.String)null);
        return;
      case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
        setEnumVals((runtime.primitivetypes.String)null);
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
      case XsdPackage.SIMPLE_CONTENT__BASE:
        return base != null;
      case XsdPackage.SIMPLE_CONTENT__ENUM_VALS:
        return enumVals != null;
    }
    return super.eIsSet(featureID);
  }

} //SimpleContentImpl
