/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Employee#getName <em>Name</em>}</li>
 *   <li>{@link company.Employee#getAge <em>Age</em>}</li>
 *   <li>{@link company.Employee#getSalary <em>Salary</em>}</li>
 *   <li>{@link company.Employee#getEmployer <em>Employer</em>}</li>
 *   <li>{@link company.Employee#getManaged <em>Managed</em>}</li>
 *   <li>{@link company.Employee#getDirected <em>Directed</em>}</li>
 *   <li>{@link company.Employee#getSecretary <em>Secretary</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getEmployee()
 * @model annotation="http://de.hpi.sam.bp2009.OCL UniqueNames='Employee.allInstances()->forAll(e | e <> self implies e.name <> self.name)' BossIsOldest='self.age <= self.employer.boss.age' divBossSecretary='if self.directed->isEmpty() then\r\nself.secretary.oclIsUndefined()\r\nelse\r\nnot self.secretary.oclIsUndefined()\r\nendif' secretaryOlderThanBoss='if self.directed->notEmpty() and\r\nnot self.secretary.oclIsUndefined() then\r\nself.age < self.secretary.age \r\nelse true\r\nendif' Boss10YearsOlderThanEmployee='self.age + 10 <= self.employer.boss.age' Secretary10YearsOlderThanBoss='if self.directed->notEmpty() and\r\nnot self.secretary.oclIsUndefined() then\r\nself.age + 10 < self.secretary.age \r\nelse true\r\nendif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueNames BossIsOldest divBossSecretary secretaryOlderThanBoss Boss10YearsOlderThanEmployee Secretary10YearsOlderThanBoss'"
 * @generated
 */
public interface Employee extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see company.CompanyPackage#getEmployee_Name()
     * @model dataType="primitivetypes.String"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link company.Employee#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Age</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Age</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Age</em>' attribute.
     * @see #setAge(long)
     * @see company.CompanyPackage#getEmployee_Age()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    long getAge();

    /**
     * Sets the value of the '{@link company.Employee#getAge <em>Age</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Age</em>' attribute.
     * @see #getAge()
     * @generated
     */
    void setAge(long value);

    /**
     * Returns the value of the '<em><b>Salary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Salary</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Salary</em>' attribute.
     * @see #setSalary(long)
     * @see company.CompanyPackage#getEmployee_Salary()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    long getSalary();

    /**
     * Sets the value of the '{@link company.Employee#getSalary <em>Salary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Salary</em>' attribute.
     * @see #getSalary()
     * @generated
     */
    void setSalary(long value);

    /**
     * Returns the value of the '<em><b>Employer</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Employer</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Employer</em>' containment reference.
     * @see #setEmployer(Department)
     * @see company.CompanyPackage#getEmployee_Employer()
     * @model containment="true"
     * @generated
     */
    Department getEmployer();

    /**
     * Sets the value of the '{@link company.Employee#getEmployer <em>Employer</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Employer</em>' containment reference.
     * @see #getEmployer()
     * @generated
     */
    void setEmployer(Department value);

    /**
     * Returns the value of the '<em><b>Managed</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Managed</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Managed</em>' containment reference.
     * @see #setManaged(Department)
     * @see company.CompanyPackage#getEmployee_Managed()
     * @model containment="true"
     * @generated
     */
    Department getManaged();

    /**
     * Sets the value of the '{@link company.Employee#getManaged <em>Managed</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Managed</em>' containment reference.
     * @see #getManaged()
     * @generated
     */
    void setManaged(Department value);

    /**
     * Returns the value of the '<em><b>Directed</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Directed</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Directed</em>' containment reference.
     * @see #setDirected(Division)
     * @see company.CompanyPackage#getEmployee_Directed()
     * @model containment="true"
     * @generated
     */
    Division getDirected();

    /**
     * Sets the value of the '{@link company.Employee#getDirected <em>Directed</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Directed</em>' containment reference.
     * @see #getDirected()
     * @generated
     */
    void setDirected(Division value);

    /**
     * Returns the value of the '<em><b>Secretary</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Secretary</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Secretary</em>' containment reference.
     * @see #setSecretary(Employee)
     * @see company.CompanyPackage#getEmployee_Secretary()
     * @model containment="true"
     * @generated
     */
    Employee getSecretary();

    /**
     * Sets the value of the '{@link company.Employee#getSecretary <em>Secretary</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Secretary</em>' containment reference.
     * @see #getSecretary()
     * @generated
     */
    void setSecretary(Employee value);

} // Employee
