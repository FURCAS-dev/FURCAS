/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import runtime.testwithroles.Customer;
import runtime.testwithroles.SalesOrder;
import runtime.testwithroles.Supplier;
import runtime.testwithroles.TestwithrolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sales Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.testwithroles.impl.SalesOrderImpl#getBuyer <em>Buyer</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.SalesOrderImpl#getSeller <em>Seller</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SalesOrderImpl extends EObjectImpl implements SalesOrder
{
  /**
   * The cached value of the '{@link #getBuyer() <em>Buyer</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuyer()
   * @generated
   * @ordered
   */
  protected Customer buyer;

  /**
   * The cached value of the '{@link #getSeller() <em>Seller</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeller()
   * @generated
   * @ordered
   */
  protected Supplier seller;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SalesOrderImpl()
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
    return TestwithrolesPackage.Literals.SALES_ORDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Customer getBuyer()
  {
    if (buyer != null && buyer.eIsProxy())
    {
      InternalEObject oldBuyer = (InternalEObject)buyer;
      buyer = (Customer)eResolveProxy(oldBuyer);
      if (buyer != oldBuyer)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestwithrolesPackage.SALES_ORDER__BUYER, oldBuyer, buyer));
      }
    }
    return buyer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Customer basicGetBuyer()
  {
    return buyer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBuyer(Customer newBuyer, NotificationChain msgs)
  {
    Customer oldBuyer = buyer;
    buyer = newBuyer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.SALES_ORDER__BUYER, oldBuyer, newBuyer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBuyer(Customer newBuyer)
  {
    if (newBuyer != buyer)
    {
      NotificationChain msgs = null;
      if (buyer != null)
        msgs = ((InternalEObject)buyer).eInverseRemove(this, TestwithrolesPackage.CUSTOMER__SALES_ORDER, Customer.class, msgs);
      if (newBuyer != null)
        msgs = ((InternalEObject)newBuyer).eInverseAdd(this, TestwithrolesPackage.CUSTOMER__SALES_ORDER, Customer.class, msgs);
      msgs = basicSetBuyer(newBuyer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.SALES_ORDER__BUYER, newBuyer, newBuyer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Supplier getSeller()
  {
    if (seller != null && seller.eIsProxy())
    {
      InternalEObject oldSeller = (InternalEObject)seller;
      seller = (Supplier)eResolveProxy(oldSeller);
      if (seller != oldSeller)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestwithrolesPackage.SALES_ORDER__SELLER, oldSeller, seller));
      }
    }
    return seller;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Supplier basicGetSeller()
  {
    return seller;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSeller(Supplier newSeller, NotificationChain msgs)
  {
    Supplier oldSeller = seller;
    seller = newSeller;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.SALES_ORDER__SELLER, oldSeller, newSeller);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSeller(Supplier newSeller)
  {
    if (newSeller != seller)
    {
      NotificationChain msgs = null;
      if (seller != null)
        msgs = ((InternalEObject)seller).eInverseRemove(this, TestwithrolesPackage.SUPPLIER__SALES_ORDER, Supplier.class, msgs);
      if (newSeller != null)
        msgs = ((InternalEObject)newSeller).eInverseAdd(this, TestwithrolesPackage.SUPPLIER__SALES_ORDER, Supplier.class, msgs);
      msgs = basicSetSeller(newSeller, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.SALES_ORDER__SELLER, newSeller, newSeller));
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
      case TestwithrolesPackage.SALES_ORDER__BUYER:
        if (buyer != null)
          msgs = ((InternalEObject)buyer).eInverseRemove(this, TestwithrolesPackage.CUSTOMER__SALES_ORDER, Customer.class, msgs);
        return basicSetBuyer((Customer)otherEnd, msgs);
      case TestwithrolesPackage.SALES_ORDER__SELLER:
        if (seller != null)
          msgs = ((InternalEObject)seller).eInverseRemove(this, TestwithrolesPackage.SUPPLIER__SALES_ORDER, Supplier.class, msgs);
        return basicSetSeller((Supplier)otherEnd, msgs);
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
      case TestwithrolesPackage.SALES_ORDER__BUYER:
        return basicSetBuyer(null, msgs);
      case TestwithrolesPackage.SALES_ORDER__SELLER:
        return basicSetSeller(null, msgs);
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
      case TestwithrolesPackage.SALES_ORDER__BUYER:
        if (resolve) return getBuyer();
        return basicGetBuyer();
      case TestwithrolesPackage.SALES_ORDER__SELLER:
        if (resolve) return getSeller();
        return basicGetSeller();
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
      case TestwithrolesPackage.SALES_ORDER__BUYER:
        setBuyer((Customer)newValue);
        return;
      case TestwithrolesPackage.SALES_ORDER__SELLER:
        setSeller((Supplier)newValue);
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
      case TestwithrolesPackage.SALES_ORDER__BUYER:
        setBuyer((Customer)null);
        return;
      case TestwithrolesPackage.SALES_ORDER__SELLER:
        setSeller((Supplier)null);
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
      case TestwithrolesPackage.SALES_ORDER__BUYER:
        return buyer != null;
      case TestwithrolesPackage.SALES_ORDER__SELLER:
        return seller != null;
    }
    return super.eIsSet(featureID);
  }

} //SalesOrderImpl
