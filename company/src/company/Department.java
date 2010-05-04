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
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getDepartment()
 * @model annotation="http://de.hpi.sam.bp2009.OCL NotBossFreelance='not self.boss.oclIsTypeOf(Freelance)' OldEmployee='self.employee->exists(e | e.age > 45)' MaxJuniors='self.employee->select(e|e.age < 25)->size()\r\n<self.maxJuniors' BossHighestSalary='self.employee->select(e|e.salary >= self.boss.salary)->size() <= 1' boss10YearsOlderThanJunior='let t:Tuple(boss:Employee,junior:Employee)=\r\nTuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in\r\nt.boss.age > t.junior.age + 10' BudgetRestriction='self.calcExpenses() <= self.budget' MaxJuniorsWarning='if self.maxJuniors > 1\r\nthen\r\nself.employee->select(e|e.age < 25)->size()\r\n<self.maxJuniors - 1\r\nelse\r\ntrue\r\nendif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NotBossFreelance OldEmployee MaxJuniors BossHighestSalary boss10YearsOlderThanJunior BudgetRestriction MaxJuniorsWarning'"
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
     * @see #setMaxJuniors(long)
     * @see company.CompanyPackage#getDepartment_MaxJuniors()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    long getMaxJuniors();

    /**
     * Sets the value of the '{@link company.Department#getMaxJuniors <em>Max Juniors</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Juniors</em>' attribute.
     * @see #getMaxJuniors()
     * @generated
     */
    void setMaxJuniors(long value);

    /**
     * Returns the value of the '<em><b>Budget</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Budget</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Budget</em>' attribute.
     * @see #setBudget(long)
     * @see company.CompanyPackage#getDepartment_Budget()
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    long getBudget();

    /**
     * Sets the value of the '{@link company.Department#getBudget <em>Budget</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Budget</em>' attribute.
     * @see #getBudget()
     * @generated
     */
    void setBudget(long value);

    /**
     * Returns the value of the '<em><b>Employee</b></em>' containment reference list.
     * The list contents are of type {@link company.Employee}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Employee</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Employee</em>' containment reference list.
     * @see company.CompanyPackage#getDepartment_Employee()
     * @model containment="true"
     * @generated
     */
    EList<Employee> getEmployee();

    /**
     * Returns the value of the '<em><b>Boss</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Boss</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Boss</em>' containment reference.
     * @see #setBoss(Employee)
     * @see company.CompanyPackage#getDepartment_Boss()
     * @model containment="true"
     * @generated
     */
    Employee getBoss();

    /**
     * Sets the value of the '{@link company.Department#getBoss <em>Boss</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Boss</em>' containment reference.
     * @see #getBoss()
     * @generated
     */
    void setBoss(Employee value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="primitivetypes.Integer"
     * @generated
     */
    long calcExpenses();

} // Department
