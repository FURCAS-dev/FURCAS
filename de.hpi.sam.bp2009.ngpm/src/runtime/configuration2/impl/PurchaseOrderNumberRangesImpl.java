/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import runtime.configuration2.Configuration2Package;
import runtime.configuration2.PurchaseOrderNumberRanges;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Purchase Order Number Ranges</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.configuration2.impl.PurchaseOrderNumberRangesImpl#getNr1 <em>Nr1</em>}</li>
 *   <li>{@link runtime.configuration2.impl.PurchaseOrderNumberRangesImpl#getNr2 <em>Nr2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PurchaseOrderNumberRangesImpl extends EObjectImpl implements PurchaseOrderNumberRanges
{
  /**
   * The cached value of the '{@link #getNr1() <em>Nr1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNr1()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String nr1;

  /**
   * The cached value of the '{@link #getNr2() <em>Nr2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNr2()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String nr2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PurchaseOrderNumberRangesImpl()
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
    return Configuration2Package.Literals.PURCHASE_ORDER_NUMBER_RANGES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getNr1()
  {
    return nr1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNr1(runtime.primitivetypes.String newNr1, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldNr1 = nr1;
    nr1 = newNr1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1, oldNr1, newNr1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNr1(runtime.primitivetypes.String newNr1)
  {
    if (newNr1 != nr1)
    {
      NotificationChain msgs = null;
      if (nr1 != null)
        msgs = ((InternalEObject)nr1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1, null, msgs);
      if (newNr1 != null)
        msgs = ((InternalEObject)newNr1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1, null, msgs);
      msgs = basicSetNr1(newNr1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1, newNr1, newNr1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getNr2()
  {
    return nr2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNr2(runtime.primitivetypes.String newNr2, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldNr2 = nr2;
    nr2 = newNr2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2, oldNr2, newNr2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNr2(runtime.primitivetypes.String newNr2)
  {
    if (newNr2 != nr2)
    {
      NotificationChain msgs = null;
      if (nr2 != null)
        msgs = ((InternalEObject)nr2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2, null, msgs);
      if (newNr2 != null)
        msgs = ((InternalEObject)newNr2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2, null, msgs);
      msgs = basicSetNr2(newNr2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2, newNr2, newNr2));
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
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1:
        return basicSetNr1(null, msgs);
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2:
        return basicSetNr2(null, msgs);
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
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1:
        return getNr1();
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2:
        return getNr2();
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
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1:
        setNr1((runtime.primitivetypes.String)newValue);
        return;
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2:
        setNr2((runtime.primitivetypes.String)newValue);
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
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1:
        setNr1((runtime.primitivetypes.String)null);
        return;
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2:
        setNr2((runtime.primitivetypes.String)null);
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
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR1:
        return nr1 != null;
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES__NR2:
        return nr2 != null;
    }
    return super.eIsSet(featureID);
  }

} //PurchaseOrderNumberRangesImpl
