/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see company.CompanyFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface CompanyPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "company";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http:///company.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "company";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CompanyPackage eINSTANCE = company.impl.CompanyPackageImpl.init();

    /**
     * The meta object id for the '{@link company.impl.EmployeeImpl <em>Employee</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see company.impl.EmployeeImpl
     * @see company.impl.CompanyPackageImpl#getEmployee()
     * @generated
     */
    int EMPLOYEE = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__NAME = 0;

    /**
     * The feature id for the '<em><b>Age</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__AGE = 1;

    /**
     * The feature id for the '<em><b>Salary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__SALARY = 2;

    /**
     * The feature id for the '<em><b>Employer</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__EMPLOYER = 3;

    /**
     * The feature id for the '<em><b>Managed</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__MANAGED = 4;

    /**
     * The feature id for the '<em><b>Directed</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__DIRECTED = 5;

    /**
     * The feature id for the '<em><b>Secretary</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__SECRETARY = 6;

    /**
     * The feature id for the '<em><b>Intern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE__INTERN = 7;

    /**
     * The number of structural features of the '<em>Employee</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMPLOYEE_FEATURE_COUNT = 8;

    /**
     * The meta object id for the '{@link company.impl.DepartmentImpl <em>Department</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see company.impl.DepartmentImpl
     * @see company.impl.CompanyPackageImpl#getDepartment()
     * @generated
     */
    int DEPARTMENT = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT__NAME = 0;

    /**
     * The feature id for the '<em><b>Max Juniors</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT__MAX_JUNIORS = 1;

    /**
     * The feature id for the '<em><b>Budget</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT__BUDGET = 2;

    /**
     * The feature id for the '<em><b>Employee</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT__EMPLOYEE = 3;

    /**
     * The feature id for the '<em><b>Boss</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT__BOSS = 4;

    /**
     * The feature id for the '<em><b>Sub Department</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DEPARTMENT__SUB_DEPARTMENT = 5;

/**
     * The feature id for the '<em><b>Parent Department</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DEPARTMENT__PARENT_DEPARTMENT = 6;

/**
     * The feature id for the '<em><b>Employee Of The Month</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT__EMPLOYEE_OF_THE_MONTH = 7;

/**
     * The number of structural features of the '<em>Department</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPARTMENT_FEATURE_COUNT = 8;

    /**
     * The meta object id for the '{@link company.impl.FreelanceImpl <em>Freelance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see company.impl.FreelanceImpl
     * @see company.impl.CompanyPackageImpl#getFreelance()
     * @generated
     */
    int FREELANCE = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__NAME = EMPLOYEE__NAME;

    /**
     * The feature id for the '<em><b>Age</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__AGE = EMPLOYEE__AGE;

    /**
     * The feature id for the '<em><b>Salary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__SALARY = EMPLOYEE__SALARY;

    /**
     * The feature id for the '<em><b>Employer</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__EMPLOYER = EMPLOYEE__EMPLOYER;

    /**
     * The feature id for the '<em><b>Managed</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__MANAGED = EMPLOYEE__MANAGED;

    /**
     * The feature id for the '<em><b>Directed</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__DIRECTED = EMPLOYEE__DIRECTED;

    /**
     * The feature id for the '<em><b>Secretary</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__SECRETARY = EMPLOYEE__SECRETARY;

    /**
     * The feature id for the '<em><b>Intern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__INTERN = EMPLOYEE__INTERN;

    /**
     * The feature id for the '<em><b>Assignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE__ASSIGNMENT = EMPLOYEE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Freelance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FREELANCE_FEATURE_COUNT = EMPLOYEE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link company.impl.DivisionImpl <em>Division</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see company.impl.DivisionImpl
     * @see company.impl.CompanyPackageImpl#getDivision()
     * @generated
     */
    int DIVISION = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIVISION__NAME = 0;

    /**
     * The feature id for the '<em><b>Department</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIVISION__DEPARTMENT = 1;

    /**
     * The feature id for the '<em><b>Director</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIVISION__DIRECTOR = 2;

    /**
     * The feature id for the '<em><b>Budget</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIVISION__BUDGET = 3;

    /**
     * The feature id for the '<em><b>Employees Of The Month</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIVISION__EMPLOYEES_OF_THE_MONTH = 4;

    /**
     * The number of structural features of the '<em>Division</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIVISION_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link company.impl.StudentImpl <em>Student</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see company.impl.StudentImpl
     * @see company.impl.CompanyPackageImpl#getStudent()
     * @generated
     */
    int STUDENT = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__NAME = EMPLOYEE__NAME;

    /**
     * The feature id for the '<em><b>Age</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__AGE = EMPLOYEE__AGE;

    /**
     * The feature id for the '<em><b>Salary</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__SALARY = EMPLOYEE__SALARY;

    /**
     * The feature id for the '<em><b>Employer</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__EMPLOYER = EMPLOYEE__EMPLOYER;

    /**
     * The feature id for the '<em><b>Managed</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__MANAGED = EMPLOYEE__MANAGED;

    /**
     * The feature id for the '<em><b>Directed</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__DIRECTED = EMPLOYEE__DIRECTED;

    /**
     * The feature id for the '<em><b>Secretary</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__SECRETARY = EMPLOYEE__SECRETARY;

    /**
     * The feature id for the '<em><b>Intern</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__INTERN = EMPLOYEE__INTERN;

    /**
     * The number of structural features of the '<em>Student</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT_FEATURE_COUNT = EMPLOYEE_FEATURE_COUNT + 0;


    /**
     * Returns the meta object for class '{@link company.Employee <em>Employee</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Employee</em>'.
     * @see company.Employee
     * @generated
     */
    EClass getEmployee();

    /**
     * Returns the meta object for the attribute '{@link company.Employee#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see company.Employee#getName()
     * @see #getEmployee()
     * @generated
     */
    EAttribute getEmployee_Name();

    /**
     * Returns the meta object for the attribute '{@link company.Employee#getAge <em>Age</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Age</em>'.
     * @see company.Employee#getAge()
     * @see #getEmployee()
     * @generated
     */
    EAttribute getEmployee_Age();

    /**
     * Returns the meta object for the attribute '{@link company.Employee#getSalary <em>Salary</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Salary</em>'.
     * @see company.Employee#getSalary()
     * @see #getEmployee()
     * @generated
     */
    EAttribute getEmployee_Salary();

    /**
     * Returns the meta object for the container reference '{@link company.Employee#getEmployer <em>Employer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Employer</em>'.
     * @see company.Employee#getEmployer()
     * @see #getEmployee()
     * @generated
     */
    EReference getEmployee_Employer();

    /**
     * Returns the meta object for the reference '{@link company.Employee#getManaged <em>Managed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Managed</em>'.
     * @see company.Employee#getManaged()
     * @see #getEmployee()
     * @generated
     */
    EReference getEmployee_Managed();

    /**
     * Returns the meta object for the container reference '{@link company.Employee#getDirected <em>Directed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Directed</em>'.
     * @see company.Employee#getDirected()
     * @see #getEmployee()
     * @generated
     */
    EReference getEmployee_Directed();

    /**
     * Returns the meta object for the containment reference '{@link company.Employee#getSecretary <em>Secretary</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Secretary</em>'.
     * @see company.Employee#getSecretary()
     * @see #getEmployee()
     * @generated
     */
    EReference getEmployee_Secretary();

    /**
     * Returns the meta object for the reference '{@link company.Employee#getIntern <em>Intern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Intern</em>'.
     * @see company.Employee#getIntern()
     * @see #getEmployee()
     * @generated
     */
    EReference getEmployee_Intern();

    /**
     * Returns the meta object for class '{@link company.Department <em>Department</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Department</em>'.
     * @see company.Department
     * @generated
     */
    EClass getDepartment();

    /**
     * Returns the meta object for the attribute '{@link company.Department#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see company.Department#getName()
     * @see #getDepartment()
     * @generated
     */
    EAttribute getDepartment_Name();

    /**
     * Returns the meta object for the attribute '{@link company.Department#getMaxJuniors <em>Max Juniors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Juniors</em>'.
     * @see company.Department#getMaxJuniors()
     * @see #getDepartment()
     * @generated
     */
    EAttribute getDepartment_MaxJuniors();

    /**
     * Returns the meta object for the attribute '{@link company.Department#getBudget <em>Budget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Budget</em>'.
     * @see company.Department#getBudget()
     * @see #getDepartment()
     * @generated
     */
    EAttribute getDepartment_Budget();

    /**
     * Returns the meta object for the containment reference list '{@link company.Department#getEmployee <em>Employee</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Employee</em>'.
     * @see company.Department#getEmployee()
     * @see #getDepartment()
     * @generated
     */
    EReference getDepartment_Employee();

    /**
     * Returns the meta object for the reference '{@link company.Department#getBoss <em>Boss</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Boss</em>'.
     * @see company.Department#getBoss()
     * @see #getDepartment()
     * @generated
     */
    EReference getDepartment_Boss();

    /**
     * Returns the meta object for the containment reference list '{@link company.Department#getSubDepartment <em>Sub Department</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Department</em>'.
     * @see company.Department#getSubDepartment()
     * @see #getDepartment()
     * @generated
     */
        EReference getDepartment_SubDepartment();

/**
     * Returns the meta object for the container reference '{@link company.Department#getParentDepartment <em>Parent Department</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent Department</em>'.
     * @see company.Department#getParentDepartment()
     * @see #getDepartment()
     * @generated
     */
        EReference getDepartment_ParentDepartment();

/**
     * Returns the meta object for the reference list '{@link company.Department#getEmployeeOfTheMonth <em>Employee Of The Month</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Employee Of The Month</em>'.
     * @see company.Department#getEmployeeOfTheMonth()
     * @see #getDepartment()
     * @generated
     */
    EReference getDepartment_EmployeeOfTheMonth();

/**
     * Returns the meta object for class '{@link company.Freelance <em>Freelance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Freelance</em>'.
     * @see company.Freelance
     * @generated
     */
    EClass getFreelance();

    /**
     * Returns the meta object for the attribute '{@link company.Freelance#getAssignment <em>Assignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Assignment</em>'.
     * @see company.Freelance#getAssignment()
     * @see #getFreelance()
     * @generated
     */
    EAttribute getFreelance_Assignment();

    /**
     * Returns the meta object for class '{@link company.Division <em>Division</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Division</em>'.
     * @see company.Division
     * @generated
     */
    EClass getDivision();

    /**
     * Returns the meta object for the attribute '{@link company.Division#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see company.Division#getName()
     * @see #getDivision()
     * @generated
     */
    EAttribute getDivision_Name();

    /**
     * Returns the meta object for the containment reference list '{@link company.Division#getDepartment <em>Department</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Department</em>'.
     * @see company.Division#getDepartment()
     * @see #getDivision()
     * @generated
     */
    EReference getDivision_Department();

    /**
     * Returns the meta object for the containment reference '{@link company.Division#getDirector <em>Director</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Director</em>'.
     * @see company.Division#getDirector()
     * @see #getDivision()
     * @generated
     */
    EReference getDivision_Director();

    /**
     * Returns the meta object for the attribute '{@link company.Division#getBudget <em>Budget</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Budget</em>'.
     * @see company.Division#getBudget()
     * @see #getDivision()
     * @generated
     */
    EAttribute getDivision_Budget();

    /**
     * Returns the meta object for the reference list '{@link company.Division#getEmployeesOfTheMonth <em>Employees Of The Month</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Employees Of The Month</em>'.
     * @see company.Division#getEmployeesOfTheMonth()
     * @see #getDivision()
     * @generated
     */
    EReference getDivision_EmployeesOfTheMonth();

    /**
     * Returns the meta object for class '{@link company.Student <em>Student</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Student</em>'.
     * @see company.Student
     * @generated
     */
    EClass getStudent();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CompanyFactory getCompanyFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link company.impl.EmployeeImpl <em>Employee</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see company.impl.EmployeeImpl
         * @see company.impl.CompanyPackageImpl#getEmployee()
         * @generated
         */
        EClass EMPLOYEE = eINSTANCE.getEmployee();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMPLOYEE__NAME = eINSTANCE.getEmployee_Name();

        /**
         * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMPLOYEE__AGE = eINSTANCE.getEmployee_Age();

        /**
         * The meta object literal for the '<em><b>Salary</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMPLOYEE__SALARY = eINSTANCE.getEmployee_Salary();

        /**
         * The meta object literal for the '<em><b>Employer</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EMPLOYEE__EMPLOYER = eINSTANCE.getEmployee_Employer();

        /**
         * The meta object literal for the '<em><b>Managed</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EMPLOYEE__MANAGED = eINSTANCE.getEmployee_Managed();

        /**
         * The meta object literal for the '<em><b>Directed</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EMPLOYEE__DIRECTED = eINSTANCE.getEmployee_Directed();

        /**
         * The meta object literal for the '<em><b>Secretary</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EMPLOYEE__SECRETARY = eINSTANCE.getEmployee_Secretary();

        /**
         * The meta object literal for the '<em><b>Intern</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EMPLOYEE__INTERN = eINSTANCE.getEmployee_Intern();

        /**
         * The meta object literal for the '{@link company.impl.DepartmentImpl <em>Department</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see company.impl.DepartmentImpl
         * @see company.impl.CompanyPackageImpl#getDepartment()
         * @generated
         */
        EClass DEPARTMENT = eINSTANCE.getDepartment();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEPARTMENT__NAME = eINSTANCE.getDepartment_Name();

        /**
         * The meta object literal for the '<em><b>Max Juniors</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEPARTMENT__MAX_JUNIORS = eINSTANCE.getDepartment_MaxJuniors();

        /**
         * The meta object literal for the '<em><b>Budget</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEPARTMENT__BUDGET = eINSTANCE.getDepartment_Budget();

        /**
         * The meta object literal for the '<em><b>Employee</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEPARTMENT__EMPLOYEE = eINSTANCE.getDepartment_Employee();

        /**
         * The meta object literal for the '<em><b>Boss</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEPARTMENT__BOSS = eINSTANCE.getDepartment_Boss();

        /**
         * The meta object literal for the '<em><b>Sub Department</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference DEPARTMENT__SUB_DEPARTMENT = eINSTANCE.getDepartment_SubDepartment();

        /**
         * The meta object literal for the '<em><b>Parent Department</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference DEPARTMENT__PARENT_DEPARTMENT = eINSTANCE.getDepartment_ParentDepartment();

        /**
         * The meta object literal for the '<em><b>Employee Of The Month</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEPARTMENT__EMPLOYEE_OF_THE_MONTH = eINSTANCE.getDepartment_EmployeeOfTheMonth();

        /**
         * The meta object literal for the '{@link company.impl.FreelanceImpl <em>Freelance</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see company.impl.FreelanceImpl
         * @see company.impl.CompanyPackageImpl#getFreelance()
         * @generated
         */
        EClass FREELANCE = eINSTANCE.getFreelance();

        /**
         * The meta object literal for the '<em><b>Assignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FREELANCE__ASSIGNMENT = eINSTANCE.getFreelance_Assignment();

        /**
         * The meta object literal for the '{@link company.impl.DivisionImpl <em>Division</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see company.impl.DivisionImpl
         * @see company.impl.CompanyPackageImpl#getDivision()
         * @generated
         */
        EClass DIVISION = eINSTANCE.getDivision();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIVISION__NAME = eINSTANCE.getDivision_Name();

        /**
         * The meta object literal for the '<em><b>Department</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DIVISION__DEPARTMENT = eINSTANCE.getDivision_Department();

        /**
         * The meta object literal for the '<em><b>Director</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DIVISION__DIRECTOR = eINSTANCE.getDivision_Director();

        /**
         * The meta object literal for the '<em><b>Budget</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIVISION__BUDGET = eINSTANCE.getDivision_Budget();

        /**
         * The meta object literal for the '<em><b>Employees Of The Month</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DIVISION__EMPLOYEES_OF_THE_MONTH = eINSTANCE.getDivision_EmployeesOfTheMonth();

        /**
         * The meta object literal for the '{@link company.impl.StudentImpl <em>Student</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see company.impl.StudentImpl
         * @see company.impl.CompanyPackageImpl#getStudent()
         * @generated
         */
        EClass STUDENT = eINSTANCE.getStudent();

    }

} //CompanyPackage
