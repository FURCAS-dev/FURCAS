/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtime.testwithroles.TestwithrolesPackage
 * @generated
 */
public interface TestwithrolesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestwithrolesFactory eINSTANCE = runtime.testwithroles.impl.TestwithrolesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Business Partner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Business Partner</em>'.
   * @generated
   */
  BusinessPartner createBusinessPartner();

  /**
   * Returns a new object of class '<em>Sales Order</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sales Order</em>'.
   * @generated
   */
  SalesOrder createSalesOrder();

  /**
   * Returns a new object of class '<em>Bank Account</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bank Account</em>'.
   * @generated
   */
  BankAccount createBankAccount();

  /**
   * Returns a new object of class '<em>Work Agreement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Work Agreement</em>'.
   * @generated
   */
  WorkAgreement createWorkAgreement();

  /**
   * Returns a new object of class '<em>Address</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Address</em>'.
   * @generated
   */
  Address createAddress();

  /**
   * Returns a new object of class '<em>Employee</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Employee</em>'.
   * @generated
   */
  Employee createEmployee();

  /**
   * Returns a new object of class '<em>Customer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Customer</em>'.
   * @generated
   */
  Customer createCustomer();

  /**
   * Returns a new object of class '<em>Supplier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Supplier</em>'.
   * @generated
   */
  Supplier createSupplier();

  /**
   * Returns a new object of class '<em>Employer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Employer</em>'.
   * @generated
   */
  Employer createEmployer();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TestwithrolesPackage getTestwithrolesPackage();

} //TestwithrolesFactory
