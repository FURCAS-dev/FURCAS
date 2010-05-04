/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import runtime.configuration2.Configuration2Package;
import runtime.configuration2.NumberRange;
import runtime.configuration2.SalesOrder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sales Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.configuration2.impl.SalesOrderImpl#getNumberRange <em>Number Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SalesOrderImpl extends EObjectImpl implements SalesOrder
{
  /**
   * The cached value of the '{@link #getNumberRange() <em>Number Range</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberRange()
   * @generated
   * @ordered
   */
  protected EList<NumberRange> numberRange;

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
    return Configuration2Package.Literals.SALES_ORDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NumberRange> getNumberRange()
  {
    if (numberRange == null)
    {
      numberRange = new EObjectResolvingEList<NumberRange>(NumberRange.class, this, Configuration2Package.SALES_ORDER__NUMBER_RANGE);
    }
    return numberRange;
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
      case Configuration2Package.SALES_ORDER__NUMBER_RANGE:
        return getNumberRange();
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
      case Configuration2Package.SALES_ORDER__NUMBER_RANGE:
        getNumberRange().clear();
        getNumberRange().addAll((Collection<? extends NumberRange>)newValue);
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
      case Configuration2Package.SALES_ORDER__NUMBER_RANGE:
        getNumberRange().clear();
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
      case Configuration2Package.SALES_ORDER__NUMBER_RANGE:
        return numberRange != null && !numberRange.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SalesOrderImpl
