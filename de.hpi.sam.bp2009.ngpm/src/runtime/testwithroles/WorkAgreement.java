/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Agreement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithroles.WorkAgreement#getEmployer <em>Employer</em>}</li>
 *   <li>{@link runtime.testwithroles.WorkAgreement#getEmployee <em>Employee</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithroles.TestwithrolesPackage#getWorkAgreement()
 * @model
 * @generated
 */
public interface WorkAgreement extends EObject
{
  /**
   * Returns the value of the '<em><b>Employer</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Employer</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Employer</em>' reference.
   * @see #setEmployer(Employer)
   * @see runtime.testwithroles.TestwithrolesPackage#getWorkAgreement_Employer()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  Employer getEmployer();

  /**
   * Sets the value of the '{@link runtime.testwithroles.WorkAgreement#getEmployer <em>Employer</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Employer</em>' reference.
   * @see #getEmployer()
   * @generated
   */
  void setEmployer(Employer value);

  /**
   * Returns the value of the '<em><b>Employee</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Employee</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Employee</em>' reference.
   * @see #setEmployee(Employee)
   * @see runtime.testwithroles.TestwithrolesPackage#getWorkAgreement_Employee()
   * @model required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  Employee getEmployee();

  /**
   * Sets the value of the '{@link runtime.testwithroles.WorkAgreement#getEmployee <em>Employee</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Employee</em>' reference.
   * @see #getEmployee()
   * @generated
   */
  void setEmployee(Employee value);

} // WorkAgreement
