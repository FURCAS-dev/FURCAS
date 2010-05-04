/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import runtime.testwithroles.*;

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
 * @see runtime.testwithroles.TestwithrolesPackage
 * @generated
 */
public class TestwithrolesSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TestwithrolesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithrolesSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TestwithrolesPackage.eINSTANCE;
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
      case TestwithrolesPackage.BUSINESS_PARTNER:
      {
        BusinessPartner businessPartner = (BusinessPartner)theEObject;
        T result = caseBusinessPartner(businessPartner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.SALES_ORDER:
      {
        SalesOrder salesOrder = (SalesOrder)theEObject;
        T result = caseSalesOrder(salesOrder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.BANK_ACCOUNT:
      {
        BankAccount bankAccount = (BankAccount)theEObject;
        T result = caseBankAccount(bankAccount);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.WORK_AGREEMENT:
      {
        WorkAgreement workAgreement = (WorkAgreement)theEObject;
        T result = caseWorkAgreement(workAgreement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.ADDRESS:
      {
        Address address = (Address)theEObject;
        T result = caseAddress(address);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.EMPLOYEE:
      {
        Employee employee = (Employee)theEObject;
        T result = caseEmployee(employee);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.CUSTOMER:
      {
        Customer customer = (Customer)theEObject;
        T result = caseCustomer(customer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.SUPPLIER:
      {
        Supplier supplier = (Supplier)theEObject;
        T result = caseSupplier(supplier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TestwithrolesPackage.EMPLOYER:
      {
        Employer employer = (Employer)theEObject;
        T result = caseEmployer(employer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Business Partner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Business Partner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBusinessPartner(BusinessPartner object)
  {
    return null;
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
   * Returns the result of interpreting the object as an instance of '<em>Bank Account</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bank Account</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBankAccount(BankAccount object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Work Agreement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Work Agreement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorkAgreement(WorkAgreement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Address</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Address</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAddress(Address object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Employee</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Employee</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmployee(Employee object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Customer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Customer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCustomer(Customer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Supplier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supplier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupplier(Supplier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Employer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Employer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmployer(Employer object)
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

} //TestwithrolesSwitch
