/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtime.testwithroles.Customer;
import runtime.testwithroles.SalesOrder;
import runtime.testwithroles.TestwithrolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.testwithroles.impl.CustomerImpl#getSalesOrder <em>Sales Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerImpl extends EObjectImpl implements Customer
{
  /**
   * The cached value of the '{@link #getSalesOrder() <em>Sales Order</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSalesOrder()
   * @generated
   * @ordered
   */
  protected EList<SalesOrder> salesOrder;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CustomerImpl()
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
    return TestwithrolesPackage.Literals.CUSTOMER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SalesOrder> getSalesOrder()
  {
    if (salesOrder == null)
    {
      salesOrder = new EObjectWithInverseResolvingEList<SalesOrder>(SalesOrder.class, this, TestwithrolesPackage.CUSTOMER__SALES_ORDER, TestwithrolesPackage.SALES_ORDER__BUYER);
    }
    return salesOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TestwithrolesPackage.CUSTOMER__SALES_ORDER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSalesOrder()).basicAdd(otherEnd, msgs);
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
      case TestwithrolesPackage.CUSTOMER__SALES_ORDER:
        return ((InternalEList<?>)getSalesOrder()).basicRemove(otherEnd, msgs);
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
      case TestwithrolesPackage.CUSTOMER__SALES_ORDER:
        return getSalesOrder();
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
      case TestwithrolesPackage.CUSTOMER__SALES_ORDER:
        getSalesOrder().clear();
        getSalesOrder().addAll((Collection<? extends SalesOrder>)newValue);
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
      case TestwithrolesPackage.CUSTOMER__SALES_ORDER:
        getSalesOrder().clear();
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
      case TestwithrolesPackage.CUSTOMER__SALES_ORDER:
        return salesOrder != null && !salesOrder.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CustomerImpl
