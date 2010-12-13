/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.Company.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.query2.test.mm.Company.CompanyFactory;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.Company.Department;
import org.eclipse.emf.query2.test.mm.Company.Division;
import org.eclipse.emf.query2.test.mm.Company.Employee;
import org.eclipse.emf.query2.test.mm.Company.Freelance;
import org.eclipse.emf.query2.test.mm.Company.Student;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompanyPackageImpl extends EPackageImpl implements CompanyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass employeeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass departmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freelanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass studentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompanyPackageImpl() {
		super(eNS_URI, CompanyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CompanyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompanyPackage init() {
		if (isInited) return (CompanyPackage)EPackage.Registry.INSTANCE.getEPackage(CompanyPackage.eNS_URI);

		// Obtain or create and register package
		CompanyPackageImpl theCompanyPackage = (CompanyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompanyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompanyPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCompanyPackage.createPackageContents();

		// Initialize created meta-data
		theCompanyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompanyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompanyPackage.eNS_URI, theCompanyPackage);
		return theCompanyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmployee() {
		return employeeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_Name() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_Age() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_Salary() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmployee_Employer() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmployee_Managed() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmployee_Directed() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmployee_Secretary() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDepartment() {
		return departmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartment_Name() {
		return (EAttribute)departmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartment_MaxJuniors() {
		return (EAttribute)departmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartment_Budget() {
		return (EAttribute)departmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_Employee() {
		return (EReference)departmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_Boss() {
		return (EReference)departmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_Division() {
		return (EReference)departmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFreelance() {
		return freelanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFreelance_Assignment() {
		return (EAttribute)freelanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDivision() {
		return divisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDivision_Name() {
		return (EAttribute)divisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDivision_Department() {
		return (EReference)divisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDivision_Director() {
		return (EReference)divisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDivision_Budget() {
		return (EAttribute)divisionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStudent() {
		return studentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanyFactory getCompanyFactory() {
		return (CompanyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		employeeEClass = createEClass(EMPLOYEE);
		createEAttribute(employeeEClass, EMPLOYEE__NAME);
		createEAttribute(employeeEClass, EMPLOYEE__AGE);
		createEAttribute(employeeEClass, EMPLOYEE__SALARY);
		createEReference(employeeEClass, EMPLOYEE__EMPLOYER);
		createEReference(employeeEClass, EMPLOYEE__MANAGED);
		createEReference(employeeEClass, EMPLOYEE__DIRECTED);
		createEReference(employeeEClass, EMPLOYEE__SECRETARY);

		departmentEClass = createEClass(DEPARTMENT);
		createEAttribute(departmentEClass, DEPARTMENT__NAME);
		createEAttribute(departmentEClass, DEPARTMENT__MAX_JUNIORS);
		createEAttribute(departmentEClass, DEPARTMENT__BUDGET);
		createEReference(departmentEClass, DEPARTMENT__EMPLOYEE);
		createEReference(departmentEClass, DEPARTMENT__BOSS);
		createEReference(departmentEClass, DEPARTMENT__DIVISION);

		freelanceEClass = createEClass(FREELANCE);
		createEAttribute(freelanceEClass, FREELANCE__ASSIGNMENT);

		divisionEClass = createEClass(DIVISION);
		createEAttribute(divisionEClass, DIVISION__NAME);
		createEReference(divisionEClass, DIVISION__DEPARTMENT);
		createEReference(divisionEClass, DIVISION__DIRECTOR);
		createEAttribute(divisionEClass, DIVISION__BUDGET);

		studentEClass = createEClass(STUDENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		freelanceEClass.getESuperTypes().add(this.getEmployee());
		studentEClass.getESuperTypes().add(this.getEmployee());

		// Initialize classes and features; add operations and parameters
		initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmployee_Name(), ecorePackage.getEString(), "name", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEmployee_Age(), ecorePackage.getEInt(), "age", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEmployee_Salary(), ecorePackage.getEInt(), "salary", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEmployee_Employer(), this.getDepartment(), this.getDepartment_Employee(), "employer", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEmployee_Managed(), this.getDepartment(), this.getDepartment_Boss(), "managed", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEmployee_Directed(), this.getDivision(), this.getDivision_Director(), "directed", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEmployee_Secretary(), this.getEmployee(), null, "secretary", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(departmentEClass, Department.class, "Department", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDepartment_Name(), ecorePackage.getEString(), "name", null, 1, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDepartment_MaxJuniors(), ecorePackage.getEInt(), "maxJuniors", null, 1, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDepartment_Budget(), ecorePackage.getEInt(), "budget", null, 1, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDepartment_Employee(), this.getEmployee(), this.getEmployee_Employer(), "employee", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDepartment_Boss(), this.getEmployee(), this.getEmployee_Managed(), "boss", null, 1, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDepartment_Division(), this.getDivision(), this.getDivision_Department(), "division", null, 0, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(departmentEClass, ecorePackage.getEInt(), "calcExpenses", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(freelanceEClass, Freelance.class, "Freelance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFreelance_Assignment(), ecorePackage.getEInt(), "assignment", null, 1, 1, Freelance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(divisionEClass, Division.class, "Division", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDivision_Name(), ecorePackage.getEString(), "name", null, 1, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDivision_Department(), this.getDepartment(), this.getDepartment_Division(), "department", null, 1, -1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDivision_Director(), this.getEmployee(), this.getEmployee_Directed(), "director", null, 1, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDivision_Budget(), ecorePackage.getEInt(), "budget", null, 1, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(studentEClass, Student.class, "Student", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://sap.com/MOIN
		createMOINAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://sap.com/MOIN</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMOINAnnotations() {
		String source = "http://sap.com/MOIN";		
		addAnnotation
		  (employeeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Employee",
			 "metaObjectMofId", "473C6EB6D6B7E0D6939411DC9D9E00199904B925",
			 "isStructureType", "false",
			 "ova", "secretary"
		   });		
		addAnnotation
		  (getEmployee_Employer(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.WorksIn",
			 "metaObjectMofId", "473C6EB6D6B7E0F1939411DCB3E500199904B925",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getEmployee_Managed(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Manages",
			 "metaObjectMofId", "473C6EB6D6B7E0F4939411DC9A9200199904B925",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getEmployee_Directed(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Directs",
			 "metaObjectMofId", "473C6EB6D6BA51D0939411DCBE8300199904B925",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getEmployee_Secretary(), 
		   source, 
		   new String[] {
			 "ovaMofId", "473C6EB6D6B7E0D5939411DCB2A400199904B925"
		   });		
		addAnnotation
		  (departmentEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Department",
			 "metaObjectMofId", "473C6EB6D6B7E0E1939411DCA5E700199904B925",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getDepartment_Employee(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.WorksIn",
			 "metaObjectMofId", "473C6EB6D6B7E0F1939411DCB3E500199904B925",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getDepartment_Boss(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Manages",
			 "metaObjectMofId", "473C6EB6D6B7E0F4939411DC9A9200199904B925",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (freelanceEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Freelance",
			 "metaObjectMofId", "473C6EB6D6B7E0E7939411DC988800199904B925",
			 "isStructureType", "false",
			 "ova", "secretary"
		   });		
		addAnnotation
		  (divisionEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Division",
			 "metaObjectMofId", "473C6EB6D6B7E0EE939411DCC52900199904B925",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getDivision_Department(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Divides",
			 "metaObjectMofId", "473C6EB6D6B7E0F7939411DC867200199904B925",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getDivision_Director(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Directs",
			 "metaObjectMofId", "473C6EB6D6BA51D0939411DCBE8300199904B925",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (studentEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/test/company[1.0.0]",
			 "metaObject", "Company.Student",
			 "metaObjectMofId", "47B2E2DF72495980DA2F11DC9D5D00199904B925",
			 "isStructureType", "false",
			 "ova", "secretary"
		   });
	}

} //CompanyPackageImpl
