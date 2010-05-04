/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtime.testwithroles.Address;
import runtime.testwithroles.BankAccount;
import runtime.testwithroles.BusinessPartner;
import runtime.testwithroles.Customer;
import runtime.testwithroles.Employee;
import runtime.testwithroles.Employer;
import runtime.testwithroles.Supplier;
import runtime.testwithroles.TestwithrolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Partner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.testwithroles.impl.BusinessPartnerImpl#getStreetAddress <em>Street Address</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.BusinessPartnerImpl#getBankAccount <em>Bank Account</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.BusinessPartnerImpl#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.BusinessPartnerImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.BusinessPartnerImpl#getEmployee <em>Employee</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.BusinessPartnerImpl#getEmployer <em>Employer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessPartnerImpl extends EObjectImpl implements BusinessPartner
{
  /**
   * The cached value of the '{@link #getStreetAddress() <em>Street Address</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStreetAddress()
   * @generated
   * @ordered
   */
  protected Address streetAddress;

  /**
   * The cached value of the '{@link #getBankAccount() <em>Bank Account</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBankAccount()
   * @generated
   * @ordered
   */
  protected BankAccount bankAccount;

  /**
   * The cached value of the '{@link #getSupplier() <em>Supplier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupplier()
   * @generated
   * @ordered
   */
  protected EList<Supplier> supplier;

  /**
   * The cached value of the '{@link #getCustomer() <em>Customer</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCustomer()
   * @generated
   * @ordered
   */
  protected EList<Customer> customer;

  /**
   * The cached value of the '{@link #getEmployee() <em>Employee</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmployee()
   * @generated
   * @ordered
   */
  protected EList<Employee> employee;

  /**
   * The cached value of the '{@link #getEmployer() <em>Employer</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmployer()
   * @generated
   * @ordered
   */
  protected EList<Employer> employer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BusinessPartnerImpl()
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
    return TestwithrolesPackage.Literals.BUSINESS_PARTNER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Address getStreetAddress()
  {
    if (streetAddress != null && streetAddress.eIsProxy())
    {
      InternalEObject oldStreetAddress = (InternalEObject)streetAddress;
      streetAddress = (Address)eResolveProxy(oldStreetAddress);
      if (streetAddress != oldStreetAddress)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestwithrolesPackage.BUSINESS_PARTNER__STREET_ADDRESS, oldStreetAddress, streetAddress));
      }
    }
    return streetAddress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Address basicGetStreetAddress()
  {
    return streetAddress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStreetAddress(Address newStreetAddress)
  {
    Address oldStreetAddress = streetAddress;
    streetAddress = newStreetAddress;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.BUSINESS_PARTNER__STREET_ADDRESS, oldStreetAddress, streetAddress));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BankAccount getBankAccount()
  {
    if (bankAccount != null && bankAccount.eIsProxy())
    {
      InternalEObject oldBankAccount = (InternalEObject)bankAccount;
      bankAccount = (BankAccount)eResolveProxy(oldBankAccount);
      if (bankAccount != oldBankAccount)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestwithrolesPackage.BUSINESS_PARTNER__BANK_ACCOUNT, oldBankAccount, bankAccount));
      }
    }
    return bankAccount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BankAccount basicGetBankAccount()
  {
    return bankAccount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBankAccount(BankAccount newBankAccount)
  {
    BankAccount oldBankAccount = bankAccount;
    bankAccount = newBankAccount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.BUSINESS_PARTNER__BANK_ACCOUNT, oldBankAccount, bankAccount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Supplier> getSupplier()
  {
    if (supplier == null)
    {
      supplier = new EObjectContainmentEList<Supplier>(Supplier.class, this, TestwithrolesPackage.BUSINESS_PARTNER__SUPPLIER);
    }
    return supplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Customer> getCustomer()
  {
    if (customer == null)
    {
      customer = new EObjectContainmentEList<Customer>(Customer.class, this, TestwithrolesPackage.BUSINESS_PARTNER__CUSTOMER);
    }
    return customer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Employee> getEmployee()
  {
    if (employee == null)
    {
      employee = new EObjectContainmentEList<Employee>(Employee.class, this, TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYEE);
    }
    return employee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Employer> getEmployer()
  {
    if (employer == null)
    {
      employer = new EObjectContainmentEList<Employer>(Employer.class, this, TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYER);
    }
    return employer;
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
      case TestwithrolesPackage.BUSINESS_PARTNER__SUPPLIER:
        return ((InternalEList<?>)getSupplier()).basicRemove(otherEnd, msgs);
      case TestwithrolesPackage.BUSINESS_PARTNER__CUSTOMER:
        return ((InternalEList<?>)getCustomer()).basicRemove(otherEnd, msgs);
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYEE:
        return ((InternalEList<?>)getEmployee()).basicRemove(otherEnd, msgs);
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYER:
        return ((InternalEList<?>)getEmployer()).basicRemove(otherEnd, msgs);
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
      case TestwithrolesPackage.BUSINESS_PARTNER__STREET_ADDRESS:
        if (resolve) return getStreetAddress();
        return basicGetStreetAddress();
      case TestwithrolesPackage.BUSINESS_PARTNER__BANK_ACCOUNT:
        if (resolve) return getBankAccount();
        return basicGetBankAccount();
      case TestwithrolesPackage.BUSINESS_PARTNER__SUPPLIER:
        return getSupplier();
      case TestwithrolesPackage.BUSINESS_PARTNER__CUSTOMER:
        return getCustomer();
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYEE:
        return getEmployee();
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYER:
        return getEmployer();
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
      case TestwithrolesPackage.BUSINESS_PARTNER__STREET_ADDRESS:
        setStreetAddress((Address)newValue);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__BANK_ACCOUNT:
        setBankAccount((BankAccount)newValue);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__SUPPLIER:
        getSupplier().clear();
        getSupplier().addAll((Collection<? extends Supplier>)newValue);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__CUSTOMER:
        getCustomer().clear();
        getCustomer().addAll((Collection<? extends Customer>)newValue);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYEE:
        getEmployee().clear();
        getEmployee().addAll((Collection<? extends Employee>)newValue);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYER:
        getEmployer().clear();
        getEmployer().addAll((Collection<? extends Employer>)newValue);
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
      case TestwithrolesPackage.BUSINESS_PARTNER__STREET_ADDRESS:
        setStreetAddress((Address)null);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__BANK_ACCOUNT:
        setBankAccount((BankAccount)null);
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__SUPPLIER:
        getSupplier().clear();
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__CUSTOMER:
        getCustomer().clear();
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYEE:
        getEmployee().clear();
        return;
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYER:
        getEmployer().clear();
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
      case TestwithrolesPackage.BUSINESS_PARTNER__STREET_ADDRESS:
        return streetAddress != null;
      case TestwithrolesPackage.BUSINESS_PARTNER__BANK_ACCOUNT:
        return bankAccount != null;
      case TestwithrolesPackage.BUSINESS_PARTNER__SUPPLIER:
        return supplier != null && !supplier.isEmpty();
      case TestwithrolesPackage.BUSINESS_PARTNER__CUSTOMER:
        return customer != null && !customer.isEmpty();
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYEE:
        return employee != null && !employee.isEmpty();
      case TestwithrolesPackage.BUSINESS_PARTNER__EMPLOYER:
        return employer != null && !employer.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BusinessPartnerImpl
