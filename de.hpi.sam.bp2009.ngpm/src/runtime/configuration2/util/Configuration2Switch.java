/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import runtime.configuration2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see runtime.configuration2.Configuration2Package
 * @generated
 */
public class Configuration2Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Configuration2Package modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Configuration2Switch()
  {
    if (modelPackage == null)
    {
      modelPackage = Configuration2Package.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Configuration2Package.SALES_ORDER:
      {
        SalesOrder salesOrder = (SalesOrder)theEObject;
        T result = caseSalesOrder(salesOrder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Configuration2Package.NUMBER_RANGE_IMPL:
      {
        NumberRangeImpl numberRangeImpl = (NumberRangeImpl)theEObject;
        T result = caseNumberRangeImpl(numberRangeImpl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Configuration2Package.PURCHASE_ORDER:
      {
        PurchaseOrder purchaseOrder = (PurchaseOrder)theEObject;
        T result = casePurchaseOrder(purchaseOrder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Configuration2Package.NUMBER_RANGE:
      {
        NumberRange numberRange = (NumberRange)theEObject;
        T result = caseNumberRange(numberRange);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES:
      {
        PurchaseOrderNumberRanges purchaseOrderNumberRanges = (PurchaseOrderNumberRanges)theEObject;
        T result = casePurchaseOrderNumberRanges(purchaseOrderNumberRanges);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Configuration2Package.SALES_ORDER_NUMBER_RANGES:
      {
        SalesOrderNumberRanges salesOrderNumberRanges = (SalesOrderNumberRanges)theEObject;
        T result = caseSalesOrderNumberRanges(salesOrderNumberRanges);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sales Order</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sales Order</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSalesOrder(SalesOrder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Range Impl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Range Impl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberRangeImpl(NumberRangeImpl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Purchase Order</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Purchase Order</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePurchaseOrder(PurchaseOrder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberRange(NumberRange object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Purchase Order Number Ranges</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Purchase Order Number Ranges</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePurchaseOrderNumberRanges(PurchaseOrderNumberRanges object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sales Order Number Ranges</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sales Order Number Ranges</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSalesOrderNumberRanges(SalesOrderNumberRanges object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Configuration2Switch
