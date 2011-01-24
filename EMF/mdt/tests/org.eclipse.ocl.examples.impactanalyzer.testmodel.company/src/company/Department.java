/**
 * <copyright>
 * </copyright>
 *
 * $Id: Department.java,v 1.1 2011/01/20 15:52:51 auhl Exp $
 */
package company;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Department#getName <em>Name</em>}</li>
 *   <li>{@link company.Department#getMaxJuniors <em>Max Juniors</em>}</li>
 *   <li>{@link company.Department#getBudget <em>Budget</em>}</li>
 *   <li>{@link company.Department#getEmployee <em>Employee</em>}</li>
 *   <li>{@link company.Department#getBoss <em>Boss</em>}</li>
 *   <li>{@link company.Department#getSubDepartment <em>Sub Department</em>}</li>
 *   <li>{@link company.Department#getParentDepartment <em>Parent Department</em>}</li>
 *   <li>{@link company.Department#getEmployeeOfTheMonth <em>Employee Of The Month</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getDepartment()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL NotBossFreelance='not (self.boss.oclIsTypeOf(Freelance))' OldEmployee='self.employee->exists(e | e.age > 45)' MaxJuniors='self.employee->select(e|e.age < 25)->size()\r\n<self.maxJuniors' BossHighestSalary='self.employee->select(e|e.salary >= self.boss.salary)->size() <= 1' boss10YearsOlderThanJunior='let t:Tuple(boss:Employee,junior:Employee)=\r\nTuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in\r\nt.boss.age > t.junior.age + 10' BudgetRestriction='self.calcExpenses() <= self.budget' MaxJuniorsWarning='if self.maxJuniors > 1\r\nthen\r\nself.employee->select(e|e.age < 25)->size()\r\n<self.maxJuniors - 1\r\nelse\r\ntrue\r\nendif' departmentMustHaveDivision='self.department2division->notEmpty()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NotBossFreelance OldEmployee MaxJuniors BossHighestSalary boss10YearsOlderThanJunior BudgetRestriction MaxJuniorsWarning departmentMustHaveDivision'"
 * @generated
 */
public interface Department extends EObject {
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
     * @see company.CompanyPackage#getDepartment_Name()
     * @model dataType="primitivetypes.String"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link company.Department#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Max Juniors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Juniors</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Juniors</em>' attribute.
     * @see #setMaxJuniors(int)
     * @see company.CompanyPackage#getDepartment_MaxJuniors()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    int getMaxJuniors();

    /**
     * Sets the value of the '{@link company.Department#getMaxJuniors <em>Max Juniors</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Juniors</em>' attribute.
     * @see #getMaxJuniors()
     * @generated
     */
	void setMaxJuniors(int value);

				/**
     * Returns the value of the '<em><b>Budget</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Budget</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Budget</em>' attribute.
     * @see #setBudget(int)
     * @see company.CompanyPackage#getDepartment_Budget()
     * @model default="0" dataType="primitivetypes.Integer"
     * @generated
     */
    int getBudget();

    /**
     * Sets the value of the '{@link company.Department#getBudget <em>Budget</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Budget</em>' attribute.
     * @see #getBudget()
     * @generated
     */
	void setBudget(int value);

				/**
     * Returns the value of the '<em><b>Employee</b></em>' containment reference list.
     * The list contents are of type {@link company.Employee}.
     * It is bidirectional and its opposite is '{@link company.Employee#getEmployer <em>Employer</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Employee</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Employee</em>' containment reference list.
     * @see company.CompanyPackage#getDepartment_Employee()
     * @see company.Employee#getEmployer
     * @model opposite="employer" containment="true"
     * @generated
     */
    EList<Employee> getEmployee();

    /**
     * Returns the value of the '<em><b>Boss</b></em>' reference.
     * It is bidirectional and its opposite is '{@link company.Employee#getManaged <em>Managed</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Boss</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Boss</em>' reference.
     * @see #setBoss(Employee)
     * @see company.CompanyPackage#getDepartment_Boss()
     * @see company.Employee#getManaged
     * @model opposite="managed" resolveProxies="false"
     * @generated
     */
    Employee getBoss();

    /**
     * Sets the value of the '{@link company.Department#getBoss <em>Boss</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Boss</em>' reference.
     * @see #getBoss()
     * @generated
     */
    void setBoss(Employee value);

    /**
     * Returns the value of the '<em><b>Sub Department</b></em>' containment reference list.
     * The list contents are of type {@link company.Department}.
     * It is bidirectional and its opposite is '{@link company.Department#getParentDepartment <em>Parent Department</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Sub Department</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Department</em>' containment reference list.
     * @see company.CompanyPackage#getDepartment_SubDepartment()
     * @see company.Department#getParentDepartment
     * @model opposite="parentDepartment" containment="true"
     * @generated
     */
        EList<Department> getSubDepartment();

/**
     * Returns the value of the '<em><b>Parent Department</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link company.Department#getSubDepartment <em>Sub Department</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Parent Department</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Parent Department</em>' container reference.
     * @see #setParentDepartment(Department)
     * @see company.CompanyPackage#getDepartment_ParentDepartment()
     * @see company.Department#getSubDepartment
     * @model opposite="subDepartment" resolveProxies="false" transient="false"
     * @generated
     */
        Department getParentDepartment();

/**
     * Sets the value of the '{@link company.Department#getParentDepartment <em>Parent Department</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent Department</em>' container reference.
     * @see #getParentDepartment()
     * @generated
     */
        void setParentDepartment(Department value);

/**
     * Returns the value of the '<em><b>Employee Of The Month</b></em>' reference list.
     * The list contents are of type {@link company.Employee}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Employee Of The Month</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Employee Of The Month</em>' reference list.
     * @see company.CompanyPackage#getDepartment_EmployeeOfTheMonth()
     * @model
     * @generated
     */
    EList<Employee> getEmployeeOfTheMonth();

/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="primitivetypes.Integer"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.employee->iterate(e ; s : Integer = 0 | s + e.salary) + self.boss.salary'"
     * @generated
     */
    int calcExpenses();

/**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @model dataType="primitivetypes.Integer"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.subDepartment->size() >= 1 then\r\n\tself.subDepartment->iterate(department; return : Integer = 0 | return + department.sumBudget()) + self.budget\r\nelse\r\n\tself.budget\r\nendif '"
     * @generated
     */
        int sumBudget();

} // Department
