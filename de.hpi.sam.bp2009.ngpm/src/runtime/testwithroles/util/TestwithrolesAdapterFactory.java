/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import runtime.testwithroles.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see runtime.testwithroles.TestwithrolesPackage
 * @generated
 */
public class TestwithrolesAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TestwithrolesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithrolesAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TestwithrolesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestwithrolesSwitch<Adapter> modelSwitch =
    new TestwithrolesSwitch<Adapter>()
    {
      @Override
      public Adapter caseBusinessPartner(BusinessPartner object)
      {
        return createBusinessPartnerAdapter();
      }
      @Override
      public Adapter caseSalesOrder(SalesOrder object)
      {
        return createSalesOrderAdapter();
      }
      @Override
      public Adapter caseBankAccount(BankAccount object)
      {
        return createBankAccountAdapter();
      }
      @Override
      public Adapter caseWorkAgreement(WorkAgreement object)
      {
        return createWorkAgreementAdapter();
      }
      @Override
      public Adapter caseAddress(Address object)
      {
        return createAddressAdapter();
      }
      @Override
      public Adapter caseEmployee(Employee object)
      {
        return createEmployeeAdapter();
      }
      @Override
      public Adapter caseCustomer(Customer object)
      {
        return createCustomerAdapter();
      }
      @Override
      public Adapter caseSupplier(Supplier object)
      {
        return createSupplierAdapter();
      }
      @Override
      public Adapter caseEmployer(Employer object)
      {
        return createEmployerAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.BusinessPartner <em>Business Partner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.BusinessPartner
   * @generated
   */
  public Adapter createBusinessPartnerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.SalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.SalesOrder
   * @generated
   */
  public Adapter createSalesOrderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.BankAccount <em>Bank Account</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.BankAccount
   * @generated
   */
  public Adapter createBankAccountAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.WorkAgreement <em>Work Agreement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.WorkAgreement
   * @generated
   */
  public Adapter createWorkAgreementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.Address <em>Address</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.Address
   * @generated
   */
  public Adapter createAddressAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.Employee <em>Employee</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.Employee
   * @generated
   */
  public Adapter createEmployeeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.Customer <em>Customer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.Customer
   * @generated
   */
  public Adapter createCustomerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.Supplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.Supplier
   * @generated
   */
  public Adapter createSupplierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.testwithroles.Employer <em>Employer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.testwithroles.Employer
   * @generated
   */
  public Adapter createEmployerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TestwithrolesAdapterFactory
