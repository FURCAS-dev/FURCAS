/**
 * <copyright>
 * 
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CompanyPackage.java,v 1.4 2010/08/24 16:16:55 ewillink Exp $
 */
package company;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
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
	String eNAME = "company"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/test/2010/Company.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "co"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompanyPackage eINSTANCE = company.impl.CompanyPackageImpl.init();

	/**
	 * The meta object id for the '{@link company.impl.CompanyImpl <em>Company</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.CompanyImpl
	 * @see company.impl.CompanyPackageImpl#getCompany()
	 * @generated
	 */
	int COMPANY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__EMPLOYEES = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__SIZE = 2;

	/**
	 * The number of structural features of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Dummy Invariant</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY___DUMMY_INVARIANT__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link company.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.impl.EmployeeImpl
	 * @see company.impl.CompanyPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Company</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__COMPANY = 2;

	/**
	 * The feature id for the '<em><b>Direct Reports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__DIRECT_REPORTS = 3;

	/**
	 * The feature id for the '<em><b>All Reports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__ALL_REPORTS = 4;

	/**
	 * The feature id for the '<em><b>Reporting Chain</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__REPORTING_CHAIN = 5;

	/**
	 * The feature id for the '<em><b>Has Name As Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__HAS_NAME_AS_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Reports To</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE___REPORTS_TO__EMPLOYEE = 0;

	/**
	 * The operation id for the '<em>No Manager Implies Direct Reports</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE___NO_MANAGER_IMPLIES_DIRECT_REPORTS__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The operation id for the '<em>Has Name As Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE___HAS_NAME_AS_OPERATION = 2;

	/**
	 * The number of operations of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link company.CompanySizeKind <em>Size Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see company.CompanySizeKind
	 * @see company.impl.CompanyPackageImpl#getCompanySizeKind()
	 * @generated
	 */
	int COMPANY_SIZE_KIND = 2;


	/**
	 * Returns the meta object for class '{@link company.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Company</em>'.
	 * @see company.Company
	 * @generated
	 */
	EClass getCompany();

	/**
	 * Returns the meta object for the attribute '{@link company.Company#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see company.Company#getName()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link company.Company#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Employees</em>'.
	 * @see company.Company#getEmployees()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_Employees();

	/**
	 * Returns the meta object for the attribute '{@link company.Company#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see company.Company#getSize()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_Size();

	/**
	 * Returns the meta object for the '{@link company.Company#dummyInvariant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Dummy Invariant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Dummy Invariant</em>' operation.
	 * @see company.Company#dummyInvariant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCompany__DummyInvariant__DiagnosticChain_Map();

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
	 * Returns the meta object for the reference '{@link company.Employee#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Manager</em>'.
	 * @see company.Employee#getManager()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Manager();

	/**
	 * Returns the meta object for the container reference '{@link company.Employee#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Company</em>'.
	 * @see company.Employee#getCompany()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Company();

	/**
	 * Returns the meta object for the reference list '{@link company.Employee#getDirectReports <em>Direct Reports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Direct Reports</em>'.
	 * @see company.Employee#getDirectReports()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_DirectReports();

	/**
	 * Returns the meta object for the reference list '{@link company.Employee#getAllReports <em>All Reports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Reports</em>'.
	 * @see company.Employee#getAllReports()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_AllReports();

	/**
	 * Returns the meta object for the reference list '{@link company.Employee#getReportingChain <em>Reporting Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reporting Chain</em>'.
	 * @see company.Employee#getReportingChain()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_ReportingChain();

	/**
	 * Returns the meta object for the attribute '{@link company.Employee#isHasNameAsAttribute <em>Has Name As Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Name As Attribute</em>'.
	 * @see company.Employee#isHasNameAsAttribute()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_HasNameAsAttribute();

	/**
	 * Returns the meta object for the '{@link company.Employee#reportsTo(company.Employee) <em>Reports To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reports To</em>' operation.
	 * @see company.Employee#reportsTo(company.Employee)
	 * @generated
	 */
	EOperation getEmployee__ReportsTo__Employee();

	/**
	 * Returns the meta object for the '{@link company.Employee#noManagerImpliesDirectReports(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Manager Implies Direct Reports</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>No Manager Implies Direct Reports</em>' operation.
	 * @see company.Employee#noManagerImpliesDirectReports(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getEmployee__NoManagerImpliesDirectReports__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link company.Employee#hasNameAsOperation() <em>Has Name As Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Name As Operation</em>' operation.
	 * @see company.Employee#hasNameAsOperation()
	 * @generated
	 */
	EOperation getEmployee__HasNameAsOperation();

	/**
	 * Returns the meta object for enum '{@link company.CompanySizeKind <em>Size Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Size Kind</em>'.
	 * @see company.CompanySizeKind
	 * @generated
	 */
	EEnum getCompanySizeKind();

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
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link company.impl.CompanyImpl <em>Company</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.impl.CompanyImpl
		 * @see company.impl.CompanyPackageImpl#getCompany()
		 * @generated
		 */
		EClass COMPANY = eINSTANCE.getCompany();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__NAME = eINSTANCE.getCompany_Name();

		/**
		 * The meta object literal for the '<em><b>Employees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__EMPLOYEES = eINSTANCE.getCompany_Employees();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__SIZE = eINSTANCE.getCompany_Size();

		/**
		 * The meta object literal for the '<em><b>Dummy Invariant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPANY___DUMMY_INVARIANT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCompany__DummyInvariant__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__MANAGER = eINSTANCE.getEmployee_Manager();

		/**
		 * The meta object literal for the '<em><b>Company</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__COMPANY = eINSTANCE.getEmployee_Company();

		/**
		 * The meta object literal for the '<em><b>Direct Reports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__DIRECT_REPORTS = eINSTANCE.getEmployee_DirectReports();

		/**
		 * The meta object literal for the '<em><b>All Reports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__ALL_REPORTS = eINSTANCE.getEmployee_AllReports();

		/**
		 * The meta object literal for the '<em><b>Reporting Chain</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__REPORTING_CHAIN = eINSTANCE.getEmployee_ReportingChain();

		/**
		 * The meta object literal for the '<em><b>Has Name As Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__HAS_NAME_AS_ATTRIBUTE = eINSTANCE.getEmployee_HasNameAsAttribute();

		/**
		 * The meta object literal for the '<em><b>Reports To</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMPLOYEE___REPORTS_TO__EMPLOYEE = eINSTANCE.getEmployee__ReportsTo__Employee();

		/**
		 * The meta object literal for the '<em><b>No Manager Implies Direct Reports</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMPLOYEE___NO_MANAGER_IMPLIES_DIRECT_REPORTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getEmployee__NoManagerImpliesDirectReports__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Has Name As Operation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMPLOYEE___HAS_NAME_AS_OPERATION = eINSTANCE.getEmployee__HasNameAsOperation();

		/**
		 * The meta object literal for the '{@link company.CompanySizeKind <em>Size Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see company.CompanySizeKind
		 * @see company.impl.CompanyPackageImpl#getCompanySizeKind()
		 * @generated
		 */
		EEnum COMPANY_SIZE_KIND = eINSTANCE.getCompanySizeKind();

	}

} //CompanyPackage
