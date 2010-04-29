package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;


import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;

import company.impl.DepartmentImpl;
import company.impl.DivisionImpl;
import company.impl.EmployeeImpl;
import company.impl.FreelanceImpl;

/**
 * This is the super class for all tests based on the Department model.
 */
public class BaseDepartmentTest extends BaseIATest {

    /**
     *  
     */
    protected EPackage companyPackage = null;

    /**
     * the package containing the Company/Department meta model
     */
    protected company.CompanyPackage comp = null;

    /**
     * the set for all instances of Department
     */
    protected Set<company.impl.DepartmentImpl> allDepartments = new HashSet<company.impl.DepartmentImpl>( );

    /**
     * the set of all instances of Freelance
     */
    protected Set<company.impl.FreelanceImpl> allFreelances = new HashSet<company.impl.FreelanceImpl>( );

    /**
     * the set of all instances of Employee
     */
    protected Set<company.impl.EmployeeImpl> allEmployees = new HashSet<company.impl.EmployeeImpl>( );

    /**
     * a ID used to create unique names for employees and freelances
     */
    protected int curImployeeID = 0;

    /**
     * a ID used to create unique names for departments
     */
    protected int curDepartmentID = 0;

    /**
     * a instances of Employee
     */
    protected company.impl.EmployeeImpl aEmployee = null;

    /**
     * a instance of Department
     */
    protected company.impl.DepartmentImpl aDepartment = null;

    /**
     * an instance of Division
     */
    protected company.impl.DivisionImpl aDivision = null;

    /**
     * a instance of Freelance
     */
    protected company.impl.FreelanceImpl aFreelance = null;

    /*
     * constaints
     */
    /**
     * A boss is not allowed to be a freelance
     */
    private static final String notBossFreelance = "context Department \n" + "  inv NotBossFreelance: \n" + "  not self.boss.oclIsTypeOf(Freelance)";

    /**
     * there must be at least one employee older than 45 in each department
     */
    private static final String oldEmployee = "context Department \n" + "  inv OldEmployee: \n" + "  self.employee->exists(e | e.age > 45)";

    /**
     * different employees must have different names
     */
    private static final String uniqueNames = "context Employee \n" + "inv UniqueNames: \n" + "  Employee.allInstances()->forAll(e | \n" + "  e <> self implies e.name <> self.name)";

    /**
     * the assignment of a freelance must be between 5 and 30
     */
    private static final String validAssignment = "context Freelance \n" + "  inv ValidAssignment: \n" + "  self.assignment >= 5 and self.assignment <= 30";

    /**
     * there are at most maxJuniors allowed per department
     */
    private static final String maxJuniors = "context Department inv MaxJuniors: \n" + "self.employee->select(e|e.age < 25)->size() < self.maxJuniors\n";

    /**
     * the boss must be older than his employees
     */
    private static final String bossIsOldest = "context Employee inv BossIsOldest: \n" + "self.age <= self.employer.boss.age\n";

    /**
     * the boss always gets the most money
     */
    private static final String bossHighestSalary = "context Department inv BossHighestSalary: \n" + "self.employee->select(\n" + "	e|e.salary >= self.boss.salary)->size() <= 1\n";

    /**
     * the expenses per department must not exceed its budget
     */
    @SuppressWarnings("unused")
    private static final String expensesRestriction = "context Department inv BudgetRestriction: \n" + "self.calcExpenses() <= self.budget";

    /**
     * defines how to calculate expenses: The sum of the employee's salary plus
     * the boss' salary
     */
    @SuppressWarnings("unused")
    private static final String expensesCalculation = "context Department \n" + "def: calcExpenses():Integer = \n" + "self.employee->iterate(e; sum=0 | sum + e.salary) + \n" + "self.boss.salary";

    /**
     * this is a nasty constraint with 2 navigation path introduced by collect()
     * stating that the salaries of the employees and the bosses must not exceed
     * the division's budget.
     */
    private static final String nastyConstraint = "context Division \n" + "inv nasty: \n" + "self.department->collect(d| \n" + "d.employee->including(d.boss)).salary->sum() < budget";

    /**
     * Only directors are allowed to have a secretary
     */
    private static final String divisionBossSecretary = "context Employee \n" + "inv divBossSecretary: \n" + "if self.directed->isEmpty() then \n" + "   self.secretary.oclIsUndefined() \n" + "else \n" + "   not self.secretary.oclIsUndefined() \n" + "endif";

    /**
     * for security reasons, secretaries must be older than their bosses ;-) the
     * secretary is modeled as an attribute
     */
    private static final String secretaryOlderThanBoss = "context Employee \n" + "inv secretaryOlderThanBoss: \n" + "if self.directed->notEmpty() and \n" + "  not self.secretary.oclIsUndefined() then \n" + "    self.age < self.secretary.age \n" + "else true \n" + "endif";

    /**
     * A boss must be at least 10 years older than the youngest employee in the
     * managed department.
     */
    private static final String boss10YearsOlderThanJunior = "context Department \n" + "inv boss10YearsOlderThanJunior: \n" + "let t:Tuple(boss:Employee,junior:Employee)=" + "Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in \n" + "t.boss.age > t.junior.age + 10";

    /*
     * OCL AST representing the constrains above
     */
    protected OCLExpression notBossFreelanceAST = null;

    protected OCLExpression oldEmployeeAST = null;

    protected OCLExpression uniqueNamesAST = null;

    protected OCLExpression validAssignmentAST = null;

    protected OCLExpression maxJuniorsAST = null;

    protected OCLExpression bossIsOldestAST = null;

    protected OCLExpression bossHighestSalaryAST = null;

    protected OCLExpression expensesRestrictionAST = null;

    protected OCLExpression nastyConstraintAST = null;

    protected OCLExpression divisionBossSecretaryAST = null;

    protected OCLExpression secretaryOlderThanBossAST = null;

    protected OCLExpression boss10YearsOlderThanJuniorAST = null;

    /*
     * for easy access to the model
     */
    protected EClass division = null;

    protected EAttribute divisionBudget = null;

    protected EClass department = null;

    protected EAttribute departmentName = null;

    protected EAttribute departmentMaxJuniors = null;

    protected EAttribute departmentBudget = null;

    protected EClass employee = null;

    protected EAttribute employeeName = null;

    protected EAttribute employeeAge = null;

    protected EAttribute employeeSalary = null;

    protected EAttribute employeeSecretary = null;

    protected EClass freelance = null;

    protected EClass student = null;

    protected EAttribute freelanceAssignment = null;

    protected EReferenceImpl departmentRef = null;

    protected EReferenceImpl bossRef = null;

    protected EReference managedRef = null;

    protected EReferenceImpl employerRef = null;

    protected EReferenceImpl employeeRef = null;

    protected EReferenceImpl directedRef = null;

    /**
     * This method fetches some meta object form the model which are used to
     * create ModelChangeEvents later on
     */
    private void buildModel( ) throws Exception {

//        company.CompanyPackage wrappedPackage = getMOINConnection( ).getPackage( company.CompanyPackage.PACKAGE_DESCRIPTOR );
        this.comp = company.CompanyPackage.eINSTANCE;
        this.division = this.comp.getDivision( ).eClass();
        this.divisionBudget = (EAttribute) this.division.getEStructuralFeature( "budget" );
        this.department = this.comp.getDepartment( ).eClass();
        this.departmentName = (EAttribute) this.department.getEStructuralFeature( "name" );
        this.departmentMaxJuniors = (EAttribute) this.department.getEStructuralFeature( "maxJuniors" );
        this.departmentBudget = (EAttribute) this.department.getEStructuralFeature( "budget" );
        this.bossRef = (EReferenceImpl) this.department.getEStructuralFeature( "boss" );
        this.employeeRef = (EReferenceImpl) this.department.getEStructuralFeature( "employee" );
        this.departmentRef = (EReferenceImpl) this.division.getEStructuralFeature( "department" );
        this.employee = this.comp.getEmployee( ).eClass();
        this.employeeName = (EAttribute) this.employee.getEStructuralFeature( "name" );
        this.employeeAge = (EAttribute) this.employee.getEStructuralFeature( "age" );
        this.employeeSalary = (EAttribute) this.employee.getEStructuralFeature( "salary" );
        this.employerRef = (EReferenceImpl) this.employee.getEStructuralFeature( "employer" );
        this.employeeSecretary = (EAttribute) this.employee.getEStructuralFeature( "secretary" );
        this.directedRef = (EReferenceImpl) this.employee.getEStructuralFeature( "directed" );
        this.managedRef = (EReference) this.employee.getEStructuralFeature( "managed" );
        this.freelance = this.comp.getFreelance( ).eClass();
        this.student = this.comp.getStudent( ).eClass();
        this.freelanceAssignment = (EAttribute) this.freelance.getEStructuralFeature( "assignment" );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#cleanUp()
     */
    @Override
    @After
    public void tearDown() {

        this.resetInstances( );
        super.tearDown();
    }

    private void resetInstances( ) {

        this.companyPackage = null;
        this.comp = null;
        this.allDepartments = null;
        this.allFreelances = null;
        this.allEmployees = null;
        this.aEmployee = null;
        this.aDepartment = null;
        this.aDivision = null;
        this.aFreelance = null;
        this.notBossFreelanceAST = null;
        this.oldEmployeeAST = null;
        this.uniqueNamesAST = null;
        this.validAssignmentAST = null;
        this.maxJuniorsAST = null;
        this.bossIsOldestAST = null;
        this.bossHighestSalaryAST = null;
        this.expensesRestrictionAST = null;
        this.nastyConstraintAST = null;
        this.divisionBossSecretaryAST = null;
        this.secretaryOlderThanBossAST = null;
        this.boss10YearsOlderThanJuniorAST = null;
        this.division = null;
        this.divisionBudget = null;
        this.department = null;
        this.departmentName = null;
        this.departmentMaxJuniors = null;
        this.departmentBudget = null;
        this.employee = null;
        this.employeeName = null;
        this.employeeAge = null;
        this.employeeSalary = null;
        this.employeeSecretary = null;
        this.freelance = null;
        this.student = null;
        this.freelanceAssignment = null;
        this.departmentRef = null;
        this.bossRef = null;
        this.managedRef = null;
        this.employerRef = null;
        this.employeeRef = null;
        this.directedRef = null;
    }

    /**
     * parses the constraints
     */
    private void parseConstraints( ) throws Exception {

        // TODO remove this comment once the user-defined operations are working
        // // parse the helper definition first
        // // so can be used later on
        // OclStatement spentBudget = parse(this.expenses, company);
        // // attach body to the model
        // OclParser parser = new OclParser(this.mmrConnection);
        // Collection c = new Vector();
        // c.add(spentBudget);
        // // continue parsing
        // parser.connectStatementsToContext(c);
        // expensesRestrictionAST = parse(expensesRestriction, company);
        EPackage[] types = new EPackage[] { this.comp };
        this.oldEmployeeAST = parse( oldEmployee, null, types ).iterator( ).next( );
        this.notBossFreelanceAST = parse( notBossFreelance, null, types ).iterator( ).next( );
        this.uniqueNamesAST = parse( uniqueNames, null, types ).iterator( ).next( );
        this.validAssignmentAST = parse( validAssignment, null, types ).iterator( ).next( );
        this.maxJuniorsAST = parse( maxJuniors, null, types ).iterator( ).next( );
        this.bossIsOldestAST = parse( bossIsOldest, null, types ).iterator( ).next( );
        this.bossHighestSalaryAST = parse( bossHighestSalary, null, types ).iterator( ).next( );
        this.nastyConstraintAST = parse( nastyConstraint, null, types ).iterator( ).next( );
        this.divisionBossSecretaryAST = parse( divisionBossSecretary, null, types ).iterator( ).next( );
        this.secretaryOlderThanBossAST = parse( secretaryOlderThanBoss, null, types ).iterator( ).next( );
        this.boss10YearsOlderThanJuniorAST = parse( boss10YearsOlderThanJunior, null, types ).iterator( ).next( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#prepare()
     */
    @Override
    @Before
    public void setUp( ) {

        this.setUp( );
    }

    protected void beforeTestMethod( boolean withParsing ) throws Exception {

        super.setUp( );
        // build up the test model used in the papers
        buildModel( );
        if ( withParsing ) {
            // parse the constraints defined in the papers
            parseConstraints( );
        }
        // // create some instances
        // this.createInstances(1, 5, 1);

    }

    /**
     * Creates a Department instance
     * 
     * @param employees number of employees which are not freelance in the
     * department
     * @param freelances the number of freelances in the department
     * @param maxJuniors the value for the maxJunior attribute
     * @param budget the value for the budget attribute
     */
    private company.impl.DepartmentImpl createDepartment( int employees, int freelances, int maxNumJuniors, int budget ) {

//        Department wrappedDepartment = coreConnection.getWrapper( ).createElementInPartition( Department.class, null );

        DepartmentImpl dep = (DepartmentImpl) company.CompanyFactory.eINSTANCE.createDepartment();
        dep.setName( "Dep" + this.curDepartmentID );
        dep.setMaxJuniors( maxNumJuniors );
        dep.setBudget( budget );
        this.curDepartmentID++;
        EmployeeImpl e = null;
        FreelanceImpl f = null;
        for ( int i = 0; i < employees; i++ ) {
            e = createEmployee( );
            dep.getEmployee( ).add( e );
            e.setEmployer( dep );
        }
        for ( int i = 0; i < freelances; i++ ) {
            f = createFreelance( );
            dep.getEmployee( ).add( f );
            f.setEmployer( dep );
        }
        this.allDepartments.add( dep );
        return dep;
    }

    /**
     * @return an instance of Employee
     */
    private company.impl.EmployeeImpl createEmployee( ) {

//        Employee wrappedEmplyoee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
        EmployeeImpl e = (EmployeeImpl) company.CompanyFactory.eINSTANCE.createEmployee();
        e.setName( "empl" + this.curImployeeID );
        e.setAge( 42 );
        e.setSalary( 2345 );
        this.curImployeeID++;
        this.allEmployees.add( e );
        return e;
    }

    /**
     * @return a instances of Freelance
     */
    private company.impl.FreelanceImpl createFreelance( ) {

//        Freelance wrappedFreelance = coreConnection.getWrapper( ).createElementInPartition( Freelance.class, null );
        FreelanceImpl f = (FreelanceImpl) company.CompanyFactory.eINSTANCE.createFreelance();
        f.setName( "empl" + this.curImployeeID );
        f.setAge( 42 );
        f.setAssignment( 7 );
        f.setSalary( 2345 );
        this.curImployeeID++;
        // this.allEmployees.add(f);
        this.allFreelances.add( f );
        return f;
    }

    /**
     * creates a whole bunch of instances
     * 
     * @param numDepartments the number of departments
     * @param numEmployees the number of employees (not freelance) pre
     * department
     * @param numFreelance the number of freelance per department
     */
    protected void createInstances( double numDepartments, int numEmployees, int numFreelance ) {

        int maxNumJuniors = 3;
        int budget = 50000;
        
//            Division myDivision = this.coreConnection.getWrapper( ).createElementInPartition( Division.class, null );
            this.aDivision = (DivisionImpl) company.CompanyFactory.eINSTANCE.createDivision();
            ( (DivisionImpl) this.aDivision ).setName( "The super Division" );
            ( (DivisionImpl) this.aDivision ).setBudget( 2000000 );
            for ( double i = 0; i < numDepartments; i++ ) {
                createDepartment( numEmployees, numFreelance, maxNumJuniors, budget );
            }
            // pick some instances to which the events will be related
            this.aDepartment = (DepartmentImpl) this.allDepartments.iterator( ).next( );
            this.aDivision.getDepartment( ).add( this.aDepartment );
            this.aEmployee = (EmployeeImpl) this.allEmployees.iterator( ).next( );
            this.aFreelance = (FreelanceImpl) this.allFreelances.iterator( ).next( );
        
    }

//    protected void printAffectedStatements( Set<EvaluationUnit> affectedStmts ) throws Exception {
//
//        for ( Iterator<EvaluationUnit> i = affectedStmts.iterator( ); i.hasNext( ); ) {
//            EvaluationUnit unit = i.next( );
//
//            this.info( "Stmt: " + unit.getAffectedStatement( ).getName( ) + "\n" );
//            this.info( ( unit.getAffectedStatement( ) ) + "\n\n" );
//
//            // if (showJmiGraph) {
//            // JmiTreeViewer tw = new
//            // JmiTreeViewer(unit.getAffectedStatement().getExpression());
//            // tw.setBounds(bounds);
//            // tw.setModal(true);
//            // tw.show();
//            // }
//            for ( Iterator<InstanceSet> j = unit.getInstanceSets( ).iterator( ); j.hasNext( ); ) {
//                InstanceSet iSet = j.next( );
//                this.info( "   Instances:\n" );
//                for ( Iterator<RefObject> it = iSet.getStartingPoints( ).iterator( ); it.hasNext( ); ) {
//                    RefFeatured inst = it.next( );
//                    this.info( "    " + inst + " \n" );
//                }
//                this.info( ( iSet.getNavigationStatement( ) ) + "\n\n" );
//                // FIXME adjust to new interface
//                //this.showJmiTree(iSet.getNavigationStatement().getExpression());
//            }
//        }
//    }

    /**
     * Turns an array of OCLExpressions into a Set of OCLExpressions
     * 
     * @param objects
     * @return the set of statements
     */
    protected Set<OCLExpression> asSet( OCLExpression[] objects ) {

        Set<OCLExpression> s = new HashSet<OCLExpression>( );
        for ( int i = 0; i < objects.length; i++ ) {
            s.add( objects[i] );
        }
        return s;
    }
}
