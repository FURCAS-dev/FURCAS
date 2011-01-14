/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompanyPackageImpl.java,v 1.1 2011/01/13 23:14:14 auhl Exp $
 */
package company.impl;

import company.Company;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import primitivetypes.PrimitivetypesPackage;
import primitivetypes.impl.PrimitivetypesPackageImpl;

import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;
import company.Freelance;
import company.Student;
import company.util.CompanyValidator;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass companyEClass = null;

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
     * @see company.CompanyPackage#eNS_URI
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

        // Obtain or create and register interdependencies
        PrimitivetypesPackageImpl thePrimitivetypesPackage = (PrimitivetypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI) instanceof PrimitivetypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI) : PrimitivetypesPackage.eINSTANCE);

        // Create package meta-data objects
        theCompanyPackage.createPackageContents();
        thePrimitivetypesPackage.createPackageContents();

        // Initialize created meta-data
        theCompanyPackage.initializePackageContents();
        thePrimitivetypesPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theCompanyPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return CompanyValidator.INSTANCE;
                 }
             });

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
    public EReference getEmployee_Intern() {
        return (EReference)employeeEClass.getEStructuralFeatures().get(7);
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
        public EReference getDepartment_SubDepartment() {
        return (EReference)departmentEClass.getEStructuralFeatures().get(5);
    }

/**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getDepartment_ParentDepartment() {
        return (EReference)departmentEClass.getEStructuralFeatures().get(6);
    }

/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDepartment_EmployeeOfTheMonth() {
        return (EReference)departmentEClass.getEStructuralFeatures().get(7);
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
    public EReference getDivision_EmployeesOfTheMonth() {
        return (EReference)divisionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDivision_NumberEmployeesOfTheMonth() {
        return (EAttribute)divisionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDivision_Company() {
        return (EReference)divisionEClass.getEStructuralFeatures().get(6);
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
    public EClass getCompany() {
        return companyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompany_Division() {
        return (EReference)companyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompany_EotmDelta() {
        return (EAttribute)companyEClass.getEStructuralFeatures().get(1);
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
        createEReference(employeeEClass, EMPLOYEE__INTERN);

        departmentEClass = createEClass(DEPARTMENT);
        createEAttribute(departmentEClass, DEPARTMENT__NAME);
        createEAttribute(departmentEClass, DEPARTMENT__MAX_JUNIORS);
        createEAttribute(departmentEClass, DEPARTMENT__BUDGET);
        createEReference(departmentEClass, DEPARTMENT__EMPLOYEE);
        createEReference(departmentEClass, DEPARTMENT__BOSS);
        createEReference(departmentEClass, DEPARTMENT__SUB_DEPARTMENT);
        createEReference(departmentEClass, DEPARTMENT__PARENT_DEPARTMENT);
        createEReference(departmentEClass, DEPARTMENT__EMPLOYEE_OF_THE_MONTH);

        freelanceEClass = createEClass(FREELANCE);
        createEAttribute(freelanceEClass, FREELANCE__ASSIGNMENT);

        divisionEClass = createEClass(DIVISION);
        createEAttribute(divisionEClass, DIVISION__NAME);
        createEReference(divisionEClass, DIVISION__DEPARTMENT);
        createEReference(divisionEClass, DIVISION__DIRECTOR);
        createEAttribute(divisionEClass, DIVISION__BUDGET);
        createEReference(divisionEClass, DIVISION__EMPLOYEES_OF_THE_MONTH);
        createEAttribute(divisionEClass, DIVISION__NUMBER_EMPLOYEES_OF_THE_MONTH);
        createEReference(divisionEClass, DIVISION__COMPANY);

        studentEClass = createEClass(STUDENT);

        companyEClass = createEClass(COMPANY);
        createEReference(companyEClass, COMPANY__DIVISION);
        createEAttribute(companyEClass, COMPANY__EOTM_DELTA);
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

        // Obtain other dependent packages
        PrimitivetypesPackage thePrimitivetypesPackage = (PrimitivetypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        freelanceEClass.getESuperTypes().add(this.getEmployee());
        studentEClass.getESuperTypes().add(this.getEmployee());

        // Initialize classes and features; add operations and parameters
        initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEmployee_Name(), thePrimitivetypesPackage.getString(), "name", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEmployee_Age(), thePrimitivetypesPackage.getInteger(), "age", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEmployee_Salary(), thePrimitivetypesPackage.getInteger(), "salary", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEmployee_Employer(), this.getDepartment(), this.getDepartment_Employee(), "employer", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEmployee_Managed(), this.getDepartment(), this.getDepartment_Boss(), "managed", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEmployee_Directed(), this.getDivision(), this.getDivision_Director(), "directed", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEmployee_Secretary(), this.getEmployee(), null, "secretary", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEmployee_Intern(), this.getStudent(), null, "intern", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(departmentEClass, Department.class, "Department", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDepartment_Name(), thePrimitivetypesPackage.getString(), "name", null, 0, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDepartment_MaxJuniors(), thePrimitivetypesPackage.getInteger(), "maxJuniors", null, 0, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDepartment_Budget(), thePrimitivetypesPackage.getInteger(), "budget", "0", 0, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDepartment_Employee(), this.getEmployee(), this.getEmployee_Employer(), "employee", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDepartment_Boss(), this.getEmployee(), this.getEmployee_Managed(), "boss", null, 0, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDepartment_SubDepartment(), this.getDepartment(), this.getDepartment_ParentDepartment(), "subDepartment", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDepartment_ParentDepartment(), this.getDepartment(), this.getDepartment_SubDepartment(), "parentDepartment", null, 0, 1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDepartment_EmployeeOfTheMonth(), this.getEmployee(), null, "employeeOfTheMonth", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(departmentEClass, thePrimitivetypesPackage.getInteger(), "calcExpenses", 0, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(departmentEClass, thePrimitivetypesPackage.getInteger(), "sumBudget", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(freelanceEClass, Freelance.class, "Freelance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFreelance_Assignment(), thePrimitivetypesPackage.getInteger(), "assignment", null, 0, 1, Freelance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(divisionEClass, Division.class, "Division", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDivision_Name(), thePrimitivetypesPackage.getString(), "name", null, 0, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDivision_Department(), this.getDepartment(), null, "department", null, 0, -1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDivision_Director(), this.getEmployee(), this.getEmployee_Directed(), "director", null, 0, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDivision_Budget(), thePrimitivetypesPackage.getInteger(), "budget", null, 0, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDivision_EmployeesOfTheMonth(), this.getEmployee(), null, "employeesOfTheMonth", null, 0, -1, Division.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDivision_NumberEmployeesOfTheMonth(), thePrimitivetypesPackage.getInteger(), "numberEmployeesOfTheMonth", "", 0, 1, Division.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
        initEReference(getDivision_Company(), this.getCompany(), this.getCompany_Division(), "company", null, 0, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(studentEClass, Student.class, "Student", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(companyEClass, Company.class, "Company", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCompany_Division(), this.getDivision(), this.getDivision_Company(), "division", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCompany_EotmDelta(), thePrimitivetypesPackage.getInteger(), "eotmDelta", null, 0, 1, Company.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http://www.eclipse.org/emf/2002/Ecore/OCL
        createOCLAnnotations();
        // http://schema.omg.org/spec/MOF/2.0/emof.xml
        createEmofAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";		
        addAnnotation
          (this, 
           source, 
           new String[] {
             "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
             "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
             "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
           });			
        addAnnotation
          (employeeEClass, 
           source, 
           new String[] {
             "constraints", "UniqueNames BossIsOldest divBossSecretary secretaryOlderThanBoss Boss10YearsOlderThanEmployee Secretary10YearsOlderThanBoss"
           });					
        addAnnotation
          (departmentEClass, 
           source, 
           new String[] {
             "constraints", "NotBossFreelance OldEmployee MaxJuniors BossHighestSalary boss10YearsOlderThanJunior BudgetRestriction MaxJuniorsWarning departmentMustHaveDivision"
           });					
        addAnnotation
          (freelanceEClass, 
           source, 
           new String[] {
             "constraints", "ValidAssignment ValidAssignmentWarning StudentAndFreelancesAge"
           });			
        addAnnotation
          (divisionEClass, 
           source, 
           new String[] {
             "constraints", "nasty limitEmployeesOfTheMonth nestedDerivation"
           });						
        addAnnotation
          (studentEClass, 
           source, 
           new String[] {
             "constraints", "StudentAndFreelancesAge"
           });			
        addAnnotation
          (companyEClass, 
           source, 
           new String[] {
             "constraints", "eotmDeltaMax"
           });	
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected void createOCLAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";			
        addAnnotation
          (employeeEClass, 
           source, 
           new String[] {
             "UniqueNames", "Employee.allInstances()->forAll(e | e <> self implies e.name <> self.name)",
             "BossIsOldest", "self.age <= self.employer.boss.age",
             "divBossSecretary", "if self.directed->isEmpty() then\r\nself.secretary.oclIsUndefined()\r\nelse\r\nnot self.secretary.oclIsUndefined()\r\nendif",
             "secretaryOlderThanBoss", "if self.directed->notEmpty() and\r\nnot self.secretary.oclIsUndefined() then\r\nself.age < self.secretary.age \r\nelse true\r\nendif",
             "Boss10YearsOlderThanEmployee", "self.age + 10 <= self.employer.boss.age",
             "Secretary10YearsOlderThanBoss", "if self.directed->notEmpty() and\r\nnot self.secretary.oclIsUndefined() then\r\nself.age + 10 < self.secretary.age \r\nelse true\r\nendif"
           });					
        addAnnotation
          (departmentEClass, 
           source, 
           new String[] {
             "NotBossFreelance", "not (self.boss.oclIsTypeOf(Freelance))",
             "OldEmployee", "self.employee->exists(e | e.age > 45)",
             "MaxJuniors", "self.employee->select(e|e.age < 25)->size()\r\n<self.maxJuniors",
             "BossHighestSalary", "self.employee->select(e|e.salary >= self.boss.salary)->size() <= 1",
             "boss10YearsOlderThanJunior", "let t:Tuple(boss:Employee,junior:Employee)=\r\nTuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in\r\nt.boss.age > t.junior.age + 10",
             "BudgetRestriction", "self.calcExpenses() <= self.budget",
             "MaxJuniorsWarning", "if self.maxJuniors > 1\r\nthen\r\nself.employee->select(e|e.age < 25)->size()\r\n<self.maxJuniors - 1\r\nelse\r\ntrue\r\nendif",
             "departmentMustHaveDivision", "self.department2division->notEmpty()"
           });			
        addAnnotation
          (departmentEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "self.employee->iterate(e ; s : Integer = 0 | s + e.salary) + self.boss.salary"
           });		
        addAnnotation
          (departmentEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "if self.subDepartment->size() >= 1 then\r\n\tself.subDepartment->iterate(department; return : Integer = 0 | return + department.sumBudget()) + self.budget\r\nelse\r\n\tself.budget\r\nendif "
           });		
        addAnnotation
          (freelanceEClass, 
           source, 
           new String[] {
             "ValidAssignment", "self.assignment >= 5 and self.assignment <= 30",
             "ValidAssignmentWarning", "self.assignment >= 5 and self.assignment <= 40",
             "StudentAndFreelancesAge", "self.age < 40"
           });			
        addAnnotation
          (divisionEClass, 
           source, 
           new String[] {
             "nasty", "self.department->collect(d| \r\nd.employee->including(d.boss)).salary->sum() < budget",
             "limitEmployeesOfTheMonth", "self.employeesOfTheMonth->size() <= self.department->size()",
             "nestedDerivation", "self.numberEmployeesOfTheMonth <= self.department->size()"
           });				
        addAnnotation
          (getDivision_EmployeesOfTheMonth(), 
           source, 
           new String[] {
             "derivation", "self.department.employeeOfTheMonth"
           });		
        addAnnotation
          (getDivision_NumberEmployeesOfTheMonth(), 
           source, 
           new String[] {
             "derivation", "self.employeesOfTheMonth->size()"
           });		
        addAnnotation
          (studentEClass, 
           source, 
           new String[] {
             "StudentAndFreelancesAge", "self.age < 40"
           });			
        addAnnotation
          (companyEClass, 
           source, 
           new String[] {
             "eotmDeltaMax", "self.eotmDelta <= 5"
           });			
        addAnnotation
          (getCompany_EotmDelta(), 
           source, 
           new String[] {
             "derivation", "let maxEOTMDivision:Division=self.division->sortedBy(i | i.numberEmployeesOfTheMonth)->last() in let minEOTMDivision:Division=self.division->sortedBy(i | i.numberEmployeesOfTheMonth)->first() in maxEOTMDivision.numberEmployeesOfTheMonth - minEOTMDivision.numberEmployeesOfTheMonth"
           });
    }

/**
     * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEmofAnnotations() {
        String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml";					
        addAnnotation
          (getEmployee_Secretary(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "secretary2boss"
           });		
        addAnnotation
          (getEmployee_Intern(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "student2employee"
           });										
        addAnnotation
          (getDivision_Department(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "department2division"
           });							
    }

} //CompanyPackageImpl
