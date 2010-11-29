/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Division</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Division#getName <em>Name</em>}</li>
 *   <li>{@link company.Division#getDepartment <em>Department</em>}</li>
 *   <li>{@link company.Division#getDirector <em>Director</em>}</li>
 *   <li>{@link company.Division#getBudget <em>Budget</em>}</li>
 *   <li>{@link company.Division#getEmployeesOfTheMonth <em>Employees Of The Month</em>}</li>
 *   <li>{@link company.Division#getNumberEmployeesOfTheMonth <em>Number Employees Of The Month</em>}</li>
 *   <li>{@link company.Division#getCompany <em>Company</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getDivision()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL nasty='self.department->collect(d| \r\nd.employee->including(d.boss)).salary->sum() < budget' limitEmployeesOfTheMonth='self.employeesOfTheMonth->size() <= self.department->size()' nestedDerivation='self.numberEmployeesOfTheMonth <= self.department->size()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nasty limitEmployeesOfTheMonth nestedDerivation'"
 * @generated
 */
public interface Division extends EObject {
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
     * @see company.CompanyPackage#getDivision_Name()
     * @model dataType="primitivetypes.String"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link company.Division#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Department</b></em>' containment reference list.
     * The list contents are of type {@link company.Department}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Department</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Department</em>' containment reference list.
     * @see company.CompanyPackage#getDivision_Department()
     * @model containment="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='department2division'"
     * @generated
     */
    EList<Department> getDepartment();

    /**
     * Returns the value of the '<em><b>Director</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link company.Employee#getDirected <em>Directed</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Director</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Director</em>' containment reference.
     * @see #setDirector(Employee)
     * @see company.CompanyPackage#getDivision_Director()
     * @see company.Employee#getDirected
     * @model opposite="directed" containment="true"
     * @generated
     */
    Employee getDirector();

    /**
     * Sets the value of the '{@link company.Division#getDirector <em>Director</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Director</em>' containment reference.
     * @see #getDirector()
     * @generated
     */
    void setDirector(Employee value);

    /**
     * Returns the value of the '<em><b>Budget</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Budget</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Budget</em>' attribute.
     * @see #setBudget(int)
     * @see company.CompanyPackage#getDivision_Budget()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    int getBudget();

    /**
     * Sets the value of the '{@link company.Division#getBudget <em>Budget</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Budget</em>' attribute.
     * @see #getBudget()
     * @generated
     */
	void setBudget(int value);

    /**
     * Returns the value of the '<em><b>Employees Of The Month</b></em>' reference list.
     * The list contents are of type {@link company.Employee}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Employees Of The Month</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Employees Of The Month</em>' reference list.
     * @see company.CompanyPackage#getDivision_EmployeesOfTheMonth()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.department.employeeOfTheMonth'"
     * @generated
     */
    EList<Employee> getEmployeesOfTheMonth();

    /**
     * Returns the value of the '<em><b>Number Employees Of The Month</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Number Employees Of The Month</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Number Employees Of The Month</em>' attribute.
     * @see company.CompanyPackage#getDivision_NumberEmployeesOfTheMonth()
     * @model default="" dataType="primitivetypes.Integer" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.employeesOfTheMonth->size()'"
     * @generated
     */
    int getNumberEmployeesOfTheMonth();

    /**
     * Returns the value of the '<em><b>Company</b></em>' reference.
     * It is bidirectional and its opposite is '{@link company.Company#getDivision <em>Division</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Company</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Company</em>' reference.
     * @see #setCompany(Company)
     * @see company.CompanyPackage#getDivision_Company()
     * @see company.Company#getDivision
     * @model opposite="division"
     * @generated
     */
    Company getCompany();

    /**
     * Sets the value of the '{@link company.Division#getCompany <em>Company</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Company</em>' reference.
     * @see #getCompany()
     * @generated
     */
    void setCompany(Company value);

} // Division
