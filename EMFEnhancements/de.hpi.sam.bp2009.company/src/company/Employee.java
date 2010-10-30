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
 *   <li>{@link company.Employee#getIntern <em>Intern</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getEmployee()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL UniqueNames='Employee.allInstances()->forAll(e | e <> self implies e.name <> self.name)' BossIsOldest='self.age <= self.employer.boss.age' divBossSecretary='if self.directed->isEmpty() then\r\nself.secretary.oclIsUndefined()\r\nelse\r\nnot self.secretary.oclIsUndefined()\r\nendif' secretaryOlderThanBoss='if self.directed->notEmpty() and\r\nnot self.secretary.oclIsUndefined() then\r\nself.age < self.secretary.age \r\nelse true\r\nendif' Boss10YearsOlderThanEmployee='self.age + 10 <= self.employer.boss.age' Secretary10YearsOlderThanBoss='if self.directed->notEmpty() and\r\nnot self.secretary.oclIsUndefined() then\r\nself.age + 10 < self.secretary.age \r\nelse true\r\nendif'"
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
     * @see #setAge(int)
     * @see company.CompanyPackage#getEmployee_Age()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    int getAge();

    /**
     * Sets the value of the '{@link company.Employee#getAge <em>Age</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Age</em>' attribute.
     * @see #getAge()
     * @generated
     */
	void setAge(int value);

				/**
     * Returns the value of the '<em><b>Salary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Salary</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Salary</em>' attribute.
     * @see #setSalary(int)
     * @see company.CompanyPackage#getEmployee_Salary()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    int getSalary();

    /**
     * Sets the value of the '{@link company.Employee#getSalary <em>Salary</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Salary</em>' attribute.
     * @see #getSalary()
     * @generated
     */
	void setSalary(int value);

				/**
     * Returns the value of the '<em><b>Employer</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link company.Department#getEmployee <em>Employee</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Employer</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Employer</em>' container reference.
     * @see #setEmployer(Department)
     * @see company.CompanyPackage#getEmployee_Employer()
     * @see company.Department#getEmployee
     * @model opposite="employee" resolveProxies="false" transient="false"
     * @generated
     */
    Department getEmployer();

    /**
     * Sets the value of the '{@link company.Employee#getEmployer <em>Employer</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Employer</em>' container reference.
     * @see #getEmployer()
     * @generated
     */
    void setEmployer(Department value);

    /**
     * Returns the value of the '<em><b>Managed</b></em>' reference.
     * It is bidirectional and its opposite is '{@link company.Department#getBoss <em>Boss</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Managed</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Managed</em>' reference.
     * @see #setManaged(Department)
     * @see company.CompanyPackage#getEmployee_Managed()
     * @see company.Department#getBoss
     * @model opposite="boss" resolveProxies="false"
     * @generated
     */
    Department getManaged();

    /**
     * Sets the value of the '{@link company.Employee#getManaged <em>Managed</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Managed</em>' reference.
     * @see #getManaged()
     * @generated
     */
    void setManaged(Department value);

    /**
     * Returns the value of the '<em><b>Directed</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link company.Division#getDirector <em>Director</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Directed</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Directed</em>' container reference.
     * @see #setDirected(Division)
     * @see company.CompanyPackage#getEmployee_Directed()
     * @see company.Division#getDirector
     * @model opposite="director" resolveProxies="false" transient="false"
     * @generated
     */
    Division getDirected();

    /**
     * Sets the value of the '{@link company.Employee#getDirected <em>Directed</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Directed</em>' container reference.
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
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='secretary2boss'"
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

    /**
     * Returns the value of the '<em><b>Intern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Intern</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Intern</em>' reference.
     * @see #setIntern(Student)
     * @see company.CompanyPackage#getEmployee_Intern()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='student2employee'"
     * @generated
     */
    Student getIntern();

    /**
     * Sets the value of the '{@link company.Employee#getIntern <em>Intern</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Intern</em>' reference.
     * @see #getIntern()
     * @generated
     */
    void setIntern(Student value);

} // Employee
