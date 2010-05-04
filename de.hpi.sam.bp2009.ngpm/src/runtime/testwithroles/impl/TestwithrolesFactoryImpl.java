/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtime.testwithroles.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestwithrolesFactoryImpl extends EFactoryImpl implements TestwithrolesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TestwithrolesFactory init()
  {
    try
    {
      TestwithrolesFactory theTestwithrolesFactory = (TestwithrolesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///runtime/testwithroles.ecore"); 
      if (theTestwithrolesFactory != null)
      {
        return theTestwithrolesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TestwithrolesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithrolesFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TestwithrolesPackage.BUSINESS_PARTNER: return createBusinessPartner();
      case TestwithrolesPackage.SALES_ORDER: return createSalesOrder();
      case TestwithrolesPackage.BANK_ACCOUNT: return createBankAccount();
      case TestwithrolesPackage.WORK_AGREEMENT: return createWorkAgreement();
      case TestwithrolesPackage.ADDRESS: return createAddress();
      case TestwithrolesPackage.EMPLOYEE: return createEmployee();
      case TestwithrolesPackage.CUSTOMER: return createCustomer();
      case TestwithrolesPackage.SUPPLIER: return createSupplier();
      case TestwithrolesPackage.EMPLOYER: return createEmployer();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BusinessPartner createBusinessPartner()
  {
    BusinessPartnerImpl businessPartner = new BusinessPartnerImpl();
    return businessPartner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SalesOrder createSalesOrder()
  {
    SalesOrderImpl salesOrder = new SalesOrderImpl();
    return salesOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BankAccount createBankAccount()
  {
    BankAccountImpl bankAccount = new BankAccountImpl();
    return bankAccount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkAgreement createWorkAgreement()
  {
    WorkAgreementImpl workAgreement = new WorkAgreementImpl();
    return workAgreement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Address createAddress()
  {
    AddressImpl address = new AddressImpl();
    return address;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Employee createEmployee()
  {
    EmployeeImpl employee = new EmployeeImpl();
    return employee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Customer createCustomer()
  {
    CustomerImpl customer = new CustomerImpl();
    return customer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Supplier createSupplier()
  {
    SupplierImpl supplier = new SupplierImpl();
    return supplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Employer createEmployer()
  {
    EmployerImpl employer = new EmployerImpl();
    return employer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithrolesPackage getTestwithrolesPackage()
  {
    return (TestwithrolesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TestwithrolesPackage getPackage()
  {
    return TestwithrolesPackage.eINSTANCE;
  }

} //TestwithrolesFactoryImpl
