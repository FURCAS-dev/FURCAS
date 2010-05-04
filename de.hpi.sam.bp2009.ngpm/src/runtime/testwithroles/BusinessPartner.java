/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Partner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithroles.BusinessPartner#getStreetAddress <em>Street Address</em>}</li>
 *   <li>{@link runtime.testwithroles.BusinessPartner#getBankAccount <em>Bank Account</em>}</li>
 *   <li>{@link runtime.testwithroles.BusinessPartner#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link runtime.testwithroles.BusinessPartner#getCustomer <em>Customer</em>}</li>
 *   <li>{@link runtime.testwithroles.BusinessPartner#getEmployee <em>Employee</em>}</li>
 *   <li>{@link runtime.testwithroles.BusinessPartner#getEmployer <em>Employer</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner()
 * @model
 * @generated
 */
public interface BusinessPartner extends EObject
{
  /**
   * Returns the value of the '<em><b>Street Address</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Street Address</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Street Address</em>' reference.
   * @see #setStreetAddress(Address)
   * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner_StreetAddress()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  Address getStreetAddress();

  /**
   * Sets the value of the '{@link runtime.testwithroles.BusinessPartner#getStreetAddress <em>Street Address</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Street Address</em>' reference.
   * @see #getStreetAddress()
   * @generated
   */
  void setStreetAddress(Address value);

  /**
   * Returns the value of the '<em><b>Bank Account</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bank Account</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bank Account</em>' reference.
   * @see #setBankAccount(BankAccount)
   * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner_BankAccount()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  BankAccount getBankAccount();

  /**
   * Sets the value of the '{@link runtime.testwithroles.BusinessPartner#getBankAccount <em>Bank Account</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bank Account</em>' reference.
   * @see #getBankAccount()
   * @generated
   */
  void setBankAccount(BankAccount value);

  /**
   * Returns the value of the '<em><b>Supplier</b></em>' containment reference list.
   * The list contents are of type {@link runtime.testwithroles.Supplier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supplier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supplier</em>' containment reference list.
   * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner_Supplier()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Supplier> getSupplier();

  /**
   * Returns the value of the '<em><b>Customer</b></em>' containment reference list.
   * The list contents are of type {@link runtime.testwithroles.Customer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Customer</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Customer</em>' containment reference list.
   * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner_Customer()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Customer> getCustomer();

  /**
   * Returns the value of the '<em><b>Employee</b></em>' containment reference list.
   * The list contents are of type {@link runtime.testwithroles.Employee}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Employee</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Employee</em>' containment reference list.
   * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner_Employee()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Employee> getEmployee();

  /**
   * Returns the value of the '<em><b>Employer</b></em>' containment reference list.
   * The list contents are of type {@link runtime.testwithroles.Employer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Employer</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Employer</em>' containment reference list.
   * @see runtime.testwithroles.TestwithrolesPackage#getBusinessPartner_Employer()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Employer> getEmployer();

} // BusinessPartner
