/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import runtime.testwithroles.Employee;
import runtime.testwithroles.Employer;
import runtime.testwithroles.TestwithrolesPackage;
import runtime.testwithroles.WorkAgreement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Agreement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.testwithroles.impl.WorkAgreementImpl#getEmployer <em>Employer</em>}</li>
 *   <li>{@link runtime.testwithroles.impl.WorkAgreementImpl#getEmployee <em>Employee</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkAgreementImpl extends EObjectImpl implements WorkAgreement
{
  /**
   * The cached value of the '{@link #getEmployer() <em>Employer</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmployer()
   * @generated
   * @ordered
   */
  protected Employer employer;

  /**
   * The cached value of the '{@link #getEmployee() <em>Employee</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmployee()
   * @generated
   * @ordered
   */
  protected Employee employee;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorkAgreementImpl()
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
    return TestwithrolesPackage.Literals.WORK_AGREEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Employer getEmployer()
  {
    if (employer != null && employer.eIsProxy())
    {
      InternalEObject oldEmployer = (InternalEObject)employer;
      employer = (Employer)eResolveProxy(oldEmployer);
      if (employer != oldEmployer)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestwithrolesPackage.WORK_AGREEMENT__EMPLOYER, oldEmployer, employer));
      }
    }
    return employer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Employer basicGetEmployer()
  {
    return employer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmployer(Employer newEmployer)
  {
    Employer oldEmployer = employer;
    employer = newEmployer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.WORK_AGREEMENT__EMPLOYER, oldEmployer, employer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Employee getEmployee()
  {
    if (employee != null && employee.eIsProxy())
    {
      InternalEObject oldEmployee = (InternalEObject)employee;
      employee = (Employee)eResolveProxy(oldEmployee);
      if (employee != oldEmployee)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestwithrolesPackage.WORK_AGREEMENT__EMPLOYEE, oldEmployee, employee));
      }
    }
    return employee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Employee basicGetEmployee()
  {
    return employee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmployee(Employee newEmployee)
  {
    Employee oldEmployee = employee;
    employee = newEmployee;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithrolesPackage.WORK_AGREEMENT__EMPLOYEE, oldEmployee, employee));
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
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYER:
        if (resolve) return getEmployer();
        return basicGetEmployer();
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYEE:
        if (resolve) return getEmployee();
        return basicGetEmployee();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYER:
        setEmployer((Employer)newValue);
        return;
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYEE:
        setEmployee((Employee)newValue);
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
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYER:
        setEmployer((Employer)null);
        return;
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYEE:
        setEmployee((Employee)null);
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
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYER:
        return employer != null;
      case TestwithrolesPackage.WORK_AGREEMENT__EMPLOYEE:
        return employee != null;
    }
    return super.eIsSet(featureID);
  }

} //WorkAgreementImpl
