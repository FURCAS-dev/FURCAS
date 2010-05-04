/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see runtime.testwithroles.TestwithrolesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface TestwithrolesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "testwithroles";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///runtime/testwithroles.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "runtime.testwithroles";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestwithrolesPackage eINSTANCE = runtime.testwithroles.impl.TestwithrolesPackageImpl.init();

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.BusinessPartnerImpl <em>Business Partner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.BusinessPartnerImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getBusinessPartner()
   * @generated
   */
  int BUSINESS_PARTNER = 0;

  /**
   * The feature id for the '<em><b>Street Address</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER__STREET_ADDRESS = 0;

  /**
   * The feature id for the '<em><b>Bank Account</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER__BANK_ACCOUNT = 1;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER__SUPPLIER = 2;

  /**
   * The feature id for the '<em><b>Customer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER__CUSTOMER = 3;

  /**
   * The feature id for the '<em><b>Employee</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER__EMPLOYEE = 4;

  /**
   * The feature id for the '<em><b>Employer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER__EMPLOYER = 5;

  /**
   * The number of structural features of the '<em>Business Partner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUSINESS_PARTNER_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.SalesOrderImpl <em>Sales Order</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.SalesOrderImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getSalesOrder()
   * @generated
   */
  int SALES_ORDER = 1;

  /**
   * The feature id for the '<em><b>Buyer</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER__BUYER = 0;

  /**
   * The feature id for the '<em><b>Seller</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER__SELLER = 1;

  /**
   * The number of structural features of the '<em>Sales Order</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.BankAccountImpl <em>Bank Account</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.BankAccountImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getBankAccount()
   * @generated
   */
  int BANK_ACCOUNT = 2;

  /**
   * The number of structural features of the '<em>Bank Account</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BANK_ACCOUNT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.WorkAgreementImpl <em>Work Agreement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.WorkAgreementImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getWorkAgreement()
   * @generated
   */
  int WORK_AGREEMENT = 3;

  /**
   * The feature id for the '<em><b>Employer</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORK_AGREEMENT__EMPLOYER = 0;

  /**
   * The feature id for the '<em><b>Employee</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORK_AGREEMENT__EMPLOYEE = 1;

  /**
   * The number of structural features of the '<em>Work Agreement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORK_AGREEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.AddressImpl <em>Address</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.AddressImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getAddress()
   * @generated
   */
  int ADDRESS = 4;

  /**
   * The number of structural features of the '<em>Address</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDRESS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.EmployeeImpl <em>Employee</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.EmployeeImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getEmployee()
   * @generated
   */
  int EMPLOYEE = 5;

  /**
   * The number of structural features of the '<em>Employee</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPLOYEE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.CustomerImpl <em>Customer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.CustomerImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getCustomer()
   * @generated
   */
  int CUSTOMER = 6;

  /**
   * The feature id for the '<em><b>Sales Order</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOMER__SALES_ORDER = 0;

  /**
   * The number of structural features of the '<em>Customer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOMER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.SupplierImpl <em>Supplier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.SupplierImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getSupplier()
   * @generated
   */
  int SUPPLIER = 7;

  /**
   * The feature id for the '<em><b>Sales Order</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPLIER__SALES_ORDER = 0;

  /**
   * The number of structural features of the '<em>Supplier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPLIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link runtime.testwithroles.impl.EmployerImpl <em>Employer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithroles.impl.EmployerImpl
   * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getEmployer()
   * @generated
   */
  int EMPLOYER = 8;

  /**
   * The number of structural features of the '<em>Employer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPLOYER_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link runtime.testwithroles.BusinessPartner <em>Business Partner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Business Partner</em>'.
   * @see runtime.testwithroles.BusinessPartner
   * @generated
   */
  EClass getBusinessPartner();

  /**
   * Returns the meta object for the reference '{@link runtime.testwithroles.BusinessPartner#getStreetAddress <em>Street Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Street Address</em>'.
   * @see runtime.testwithroles.BusinessPartner#getStreetAddress()
   * @see #getBusinessPartner()
   * @generated
   */
  EReference getBusinessPartner_StreetAddress();

  /**
   * Returns the meta object for the reference '{@link runtime.testwithroles.BusinessPartner#getBankAccount <em>Bank Account</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Bank Account</em>'.
   * @see runtime.testwithroles.BusinessPartner#getBankAccount()
   * @see #getBusinessPartner()
   * @generated
   */
  EReference getBusinessPartner_BankAccount();

  /**
   * Returns the meta object for the containment reference list '{@link runtime.testwithroles.BusinessPartner#getSupplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supplier</em>'.
   * @see runtime.testwithroles.BusinessPartner#getSupplier()
   * @see #getBusinessPartner()
   * @generated
   */
  EReference getBusinessPartner_Supplier();

  /**
   * Returns the meta object for the containment reference list '{@link runtime.testwithroles.BusinessPartner#getCustomer <em>Customer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Customer</em>'.
   * @see runtime.testwithroles.BusinessPartner#getCustomer()
   * @see #getBusinessPartner()
   * @generated
   */
  EReference getBusinessPartner_Customer();

  /**
   * Returns the meta object for the containment reference list '{@link runtime.testwithroles.BusinessPartner#getEmployee <em>Employee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Employee</em>'.
   * @see runtime.testwithroles.BusinessPartner#getEmployee()
   * @see #getBusinessPartner()
   * @generated
   */
  EReference getBusinessPartner_Employee();

  /**
   * Returns the meta object for the containment reference list '{@link runtime.testwithroles.BusinessPartner#getEmployer <em>Employer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Employer</em>'.
   * @see runtime.testwithroles.BusinessPartner#getEmployer()
   * @see #getBusinessPartner()
   * @generated
   */
  EReference getBusinessPartner_Employer();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.SalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sales Order</em>'.
   * @see runtime.testwithroles.SalesOrder
   * @generated
   */
  EClass getSalesOrder();

  /**
   * Returns the meta object for the reference '{@link runtime.testwithroles.SalesOrder#getBuyer <em>Buyer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Buyer</em>'.
   * @see runtime.testwithroles.SalesOrder#getBuyer()
   * @see #getSalesOrder()
   * @generated
   */
  EReference getSalesOrder_Buyer();

  /**
   * Returns the meta object for the reference '{@link runtime.testwithroles.SalesOrder#getSeller <em>Seller</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Seller</em>'.
   * @see runtime.testwithroles.SalesOrder#getSeller()
   * @see #getSalesOrder()
   * @generated
   */
  EReference getSalesOrder_Seller();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.BankAccount <em>Bank Account</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bank Account</em>'.
   * @see runtime.testwithroles.BankAccount
   * @generated
   */
  EClass getBankAccount();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.WorkAgreement <em>Work Agreement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Work Agreement</em>'.
   * @see runtime.testwithroles.WorkAgreement
   * @generated
   */
  EClass getWorkAgreement();

  /**
   * Returns the meta object for the reference '{@link runtime.testwithroles.WorkAgreement#getEmployer <em>Employer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Employer</em>'.
   * @see runtime.testwithroles.WorkAgreement#getEmployer()
   * @see #getWorkAgreement()
   * @generated
   */
  EReference getWorkAgreement_Employer();

  /**
   * Returns the meta object for the reference '{@link runtime.testwithroles.WorkAgreement#getEmployee <em>Employee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Employee</em>'.
   * @see runtime.testwithroles.WorkAgreement#getEmployee()
   * @see #getWorkAgreement()
   * @generated
   */
  EReference getWorkAgreement_Employee();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.Address <em>Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Address</em>'.
   * @see runtime.testwithroles.Address
   * @generated
   */
  EClass getAddress();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.Employee <em>Employee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Employee</em>'.
   * @see runtime.testwithroles.Employee
   * @generated
   */
  EClass getEmployee();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.Customer <em>Customer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Customer</em>'.
   * @see runtime.testwithroles.Customer
   * @generated
   */
  EClass getCustomer();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithroles.Customer#getSalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sales Order</em>'.
   * @see runtime.testwithroles.Customer#getSalesOrder()
   * @see #getCustomer()
   * @generated
   */
  EReference getCustomer_SalesOrder();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.Supplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supplier</em>'.
   * @see runtime.testwithroles.Supplier
   * @generated
   */
  EClass getSupplier();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithroles.Supplier#getSalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sales Order</em>'.
   * @see runtime.testwithroles.Supplier#getSalesOrder()
   * @see #getSupplier()
   * @generated
   */
  EReference getSupplier_SalesOrder();

  /**
   * Returns the meta object for class '{@link runtime.testwithroles.Employer <em>Employer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Employer</em>'.
   * @see runtime.testwithroles.Employer
   * @generated
   */
  EClass getEmployer();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TestwithrolesFactory getTestwithrolesFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.BusinessPartnerImpl <em>Business Partner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.BusinessPartnerImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getBusinessPartner()
     * @generated
     */
    EClass BUSINESS_PARTNER = eINSTANCE.getBusinessPartner();

    /**
     * The meta object literal for the '<em><b>Street Address</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUSINESS_PARTNER__STREET_ADDRESS = eINSTANCE.getBusinessPartner_StreetAddress();

    /**
     * The meta object literal for the '<em><b>Bank Account</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUSINESS_PARTNER__BANK_ACCOUNT = eINSTANCE.getBusinessPartner_BankAccount();

    /**
     * The meta object literal for the '<em><b>Supplier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUSINESS_PARTNER__SUPPLIER = eINSTANCE.getBusinessPartner_Supplier();

    /**
     * The meta object literal for the '<em><b>Customer</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUSINESS_PARTNER__CUSTOMER = eINSTANCE.getBusinessPartner_Customer();

    /**
     * The meta object literal for the '<em><b>Employee</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUSINESS_PARTNER__EMPLOYEE = eINSTANCE.getBusinessPartner_Employee();

    /**
     * The meta object literal for the '<em><b>Employer</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUSINESS_PARTNER__EMPLOYER = eINSTANCE.getBusinessPartner_Employer();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.SalesOrderImpl <em>Sales Order</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.SalesOrderImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getSalesOrder()
     * @generated
     */
    EClass SALES_ORDER = eINSTANCE.getSalesOrder();

    /**
     * The meta object literal for the '<em><b>Buyer</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SALES_ORDER__BUYER = eINSTANCE.getSalesOrder_Buyer();

    /**
     * The meta object literal for the '<em><b>Seller</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SALES_ORDER__SELLER = eINSTANCE.getSalesOrder_Seller();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.BankAccountImpl <em>Bank Account</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.BankAccountImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getBankAccount()
     * @generated
     */
    EClass BANK_ACCOUNT = eINSTANCE.getBankAccount();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.WorkAgreementImpl <em>Work Agreement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.WorkAgreementImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getWorkAgreement()
     * @generated
     */
    EClass WORK_AGREEMENT = eINSTANCE.getWorkAgreement();

    /**
     * The meta object literal for the '<em><b>Employer</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORK_AGREEMENT__EMPLOYER = eINSTANCE.getWorkAgreement_Employer();

    /**
     * The meta object literal for the '<em><b>Employee</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORK_AGREEMENT__EMPLOYEE = eINSTANCE.getWorkAgreement_Employee();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.AddressImpl <em>Address</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.AddressImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getAddress()
     * @generated
     */
    EClass ADDRESS = eINSTANCE.getAddress();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.EmployeeImpl <em>Employee</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.EmployeeImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getEmployee()
     * @generated
     */
    EClass EMPLOYEE = eINSTANCE.getEmployee();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.CustomerImpl <em>Customer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.CustomerImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getCustomer()
     * @generated
     */
    EClass CUSTOMER = eINSTANCE.getCustomer();

    /**
     * The meta object literal for the '<em><b>Sales Order</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOMER__SALES_ORDER = eINSTANCE.getCustomer_SalesOrder();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.SupplierImpl <em>Supplier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.SupplierImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getSupplier()
     * @generated
     */
    EClass SUPPLIER = eINSTANCE.getSupplier();

    /**
     * The meta object literal for the '<em><b>Sales Order</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPLIER__SALES_ORDER = eINSTANCE.getSupplier_SalesOrder();

    /**
     * The meta object literal for the '{@link runtime.testwithroles.impl.EmployerImpl <em>Employer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithroles.impl.EmployerImpl
     * @see runtime.testwithroles.impl.TestwithrolesPackageImpl#getEmployer()
     * @generated
     */
    EClass EMPLOYER = eINSTANCE.getEmployer();

  }

} //TestwithrolesPackage
