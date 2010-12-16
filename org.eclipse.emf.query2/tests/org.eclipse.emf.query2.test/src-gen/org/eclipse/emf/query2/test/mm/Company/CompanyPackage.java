/**
 * /*******************************************************************************
 *  * Copyright (c) 2006, 2009 SAP AG and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     SAP AG - initial API and implementation
 *  ******************************************************************************/
 
package org.eclipse.emf.query2.test.mm.Company;

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
 * @see org.eclipse.emf.query2.test.mm.Company.CompanyFactory
 * @model kind="package"
 * @generated
 */
public interface CompanyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Company";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/Company";

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
	CompanyPackage eINSTANCE = org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.EmployeeImpl
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getEmployee()
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
	 * The feature id for the '<em><b>Employer</b></em>' reference.
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
	 * The feature id for the '<em><b>Directed</b></em>' reference.
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
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl <em>Department</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getDepartment()
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
	 * The feature id for the '<em><b>Employee</b></em>' reference list.
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
	 * The feature id for the '<em><b>Division</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT__DIVISION = 5;

	/**
	 * The number of structural features of the '<em>Department</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPARTMENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.FreelanceImpl <em>Freelance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.FreelanceImpl
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getFreelance()
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
	 * The feature id for the '<em><b>Employer</b></em>' reference.
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
	 * The feature id for the '<em><b>Directed</b></em>' reference.
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
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl <em>Division</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getDivision()
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
	 * The feature id for the '<em><b>Department</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__DEPARTMENT = 1;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
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
	 * The feature id for the '<em><b>Commuting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__COMMUTING = 4;

	/**
	 * The number of structural features of the '<em>Division</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.StudentImpl <em>Student</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.StudentImpl
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getStudent()
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
	 * The feature id for the '<em><b>Employer</b></em>' reference.
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
	 * The feature id for the '<em><b>Directed</b></em>' reference.
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
	 * The number of structural features of the '<em>Student</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_FEATURE_COUNT = EMPLOYEE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.TransportImpl <em>Transport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.TransportImpl
	 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getTransport()
	 * @generated
	 */
	int TRANSPORT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Transport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.Company.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getName()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getAge()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Age();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getSalary <em>Salary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Salary</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getSalary()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Salary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getEmployer <em>Employer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Employer</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getEmployer()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Employer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getManaged <em>Managed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Managed</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getManaged()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Managed();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getDirected <em>Directed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Directed</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getDirected()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Directed();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getSecretary <em>Secretary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Secretary</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getSecretary()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Secretary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.Company.Department <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Department</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department
	 * @generated
	 */
	EClass getDepartment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Department#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getName()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Department#getMaxJuniors <em>Max Juniors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Juniors</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getMaxJuniors()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_MaxJuniors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Department#getBudget <em>Budget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Budget</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getBudget()
	 * @see #getDepartment()
	 * @generated
	 */
	EAttribute getDepartment_Budget();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.Company.Department#getEmployee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Employee</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getEmployee()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Employee();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Department#getBoss <em>Boss</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Boss</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getBoss()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Boss();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Department#getDivision <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Division</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getDivision()
	 * @see #getDepartment()
	 * @generated
	 */
	EReference getDepartment_Division();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.Company.Freelance <em>Freelance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Freelance</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Freelance
	 * @generated
	 */
	EClass getFreelance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Freelance#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assignment</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Freelance#getAssignment()
	 * @see #getFreelance()
	 * @generated
	 */
	EAttribute getFreelance_Assignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.Company.Division <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Division</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Division
	 * @generated
	 */
	EClass getDivision();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Division#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getName()
	 * @see #getDivision()
	 * @generated
	 */
	EAttribute getDivision_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.Company.Division#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Department</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getDepartment()
	 * @see #getDivision()
	 * @generated
	 */
	EReference getDivision_Department();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Division#getDirector <em>Director</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Director</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getDirector()
	 * @see #getDivision()
	 * @generated
	 */
	EReference getDivision_Director();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Division#getBudget <em>Budget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Budget</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getBudget()
	 * @see #getDivision()
	 * @generated
	 */
	EAttribute getDivision_Budget();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.Company.Division#getCommuting <em>Commuting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Commuting</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getCommuting()
	 * @see #getDivision()
	 * @generated
	 */
	EReference getDivision_Commuting();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.Company.Student <em>Student</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Student</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Student
	 * @generated
	 */
	EClass getStudent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.Company.Transport <em>Transport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transport</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Transport
	 * @generated
	 */
	EClass getTransport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.Company.Transport#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.Company.Transport#getName()
	 * @see #getTransport()
	 * @generated
	 */
	EAttribute getTransport_Name();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.EmployeeImpl
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getEmployee()
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
		 * The meta object literal for the '<em><b>Employer</b></em>' reference feature.
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
		 * The meta object literal for the '<em><b>Directed</b></em>' reference feature.
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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl <em>Department</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getDepartment()
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
		 * The meta object literal for the '<em><b>Employee</b></em>' reference list feature.
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
		 * The meta object literal for the '<em><b>Division</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPARTMENT__DIVISION = eINSTANCE.getDepartment_Division();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.FreelanceImpl <em>Freelance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.FreelanceImpl
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getFreelance()
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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl <em>Division</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getDivision()
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
		 * The meta object literal for the '<em><b>Department</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIVISION__DEPARTMENT = eINSTANCE.getDivision_Department();

		/**
		 * The meta object literal for the '<em><b>Director</b></em>' reference feature.
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
		 * The meta object literal for the '<em><b>Commuting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIVISION__COMMUTING = eINSTANCE.getDivision_Commuting();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.StudentImpl <em>Student</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.StudentImpl
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getStudent()
		 * @generated
		 */
		EClass STUDENT = eINSTANCE.getStudent();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.Company.impl.TransportImpl <em>Transport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.TransportImpl
		 * @see org.eclipse.emf.query2.test.mm.Company.impl.CompanyPackageImpl#getTransport()
		 * @generated
		 */
		EClass TRANSPORT = eINSTANCE.getTransport();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSPORT__NAME = eINSTANCE.getTransport_Name();

	}

} //CompanyPackage
