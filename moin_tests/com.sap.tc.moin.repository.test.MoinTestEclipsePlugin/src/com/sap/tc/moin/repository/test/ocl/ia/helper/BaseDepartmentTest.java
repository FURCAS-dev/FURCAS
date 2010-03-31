package com.sap.tc.moin.repository.test.ocl.ia.helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.company.Division;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.company.__impl.CompanyPackageImpl;
import com.sap.company.__impl.DepartmentImpl;
import com.sap.company.__impl.DivisionImpl;
import com.sap.company.__impl.EmployeeImpl;
import com.sap.company.__impl.FreelanceImpl;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclSerializer;
import com.sap.tc.moin.repository.core.JmiList;

/**
 * This is the super class for all tests based on the Department model.
 */
public class BaseDepartmentTest extends BaseIATest {

    // TODO right now, use the same serializer instance
    protected OclSerializer serializer;

    protected OclSerializer serializerNoPackageNames;

    /**
     *  
     */
    protected MofPackage companyPackage = null;

    /**
     * the package containing the Company/Department meta model
     */
    protected CompanyPackageImpl company = null;

    /**
     * the set fo all instances of Department
     */
    protected Set<DepartmentImpl> allDepartments = new HashSet<DepartmentImpl>( );

    /**
     * the set of all instances of Freelance
     */
    protected Set<FreelanceImpl> allFreelances = new HashSet<FreelanceImpl>( );

    /**
     * the set of all instances of Employee
     */
    protected Set<EmployeeImpl> allEmployees = new HashSet<EmployeeImpl>( );

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
    protected EmployeeImpl aEmployee = null;

    /**
     * a instance of Department
     */
    protected DepartmentImpl aDepartment = null;

    /**
     * an instance of Division
     */
    protected DivisionImpl aDivision = null;

    /**
     * a instance of Freelance
     */
    protected FreelanceImpl aFreelance = null;

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
    private static final String expensesRestriction = "context Department inv BudgetRestriction: \n" + "self.calcExpenses() <= self.budget";

    /**
     * defines how to calculate expenses: The sum of the employee's salary plus
     * the boss' salary
     */
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
    protected OclStatement notBossFreelanceAST = null;

    protected OclStatement oldEmployeeAST = null;

    protected OclStatement uniqueNamesAST = null;

    protected OclStatement validAssignmentAST = null;

    protected OclStatement maxJuniorsAST = null;

    protected OclStatement bossIsOldestAST = null;

    protected OclStatement bossHighestSalaryAST = null;

    protected OclStatement expensesRestrictionAST = null;

    protected OclStatement nastyConstraintAST = null;

    protected OclStatement divisionBossSecretaryAST = null;

    protected OclStatement secretaryOlderThanBossAST = null;

    protected OclStatement boss10YearsOlderThanJuniorAST = null;

    /*
     * for easy access to the model
     */
    protected MofClassImpl division = null;

    protected Attribute divisionBudget = null;

    protected MofClassImpl department = null;

    protected Attribute departmentName = null;

    protected Attribute departmentMaxJuniors = null;

    protected Attribute departmentBudget = null;

    protected MofClassImpl employee = null;

    protected Attribute employeeName = null;

    protected Attribute employeeAge = null;

    protected Attribute employeeSalary = null;

    protected Attribute employeeSecretary = null;

    protected MofClassImpl freelance = null;

    protected MofClassImpl student = null;

    protected Attribute freelanceAssignment = null;

    protected ReferenceImpl departmentRef = null;

    protected ReferenceImpl bossRef = null;

    protected Reference managedRef = null;

    protected ReferenceImpl employerRef = null;

    protected ReferenceImpl employeeRef = null;

    protected ReferenceImpl directedRef = null;

    /**
     * This method fetches some meta object form the model which are used to
     * create ModelChangeEvents later on
     */
    private void buildModel( ) throws Exception {

        CompanyPackage wrappedPackage = getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
        this.company = (CompanyPackageImpl) getTestHelper( ).getCorePartitionable( wrappedPackage );
        this.division = (MofClassImpl) this.company.getDivision( coreConnection ).refMetaObject( );
        this.divisionBudget = (Attribute) this.division.lookupElement( coreConnection, "budget" );
        this.department = (MofClassImpl) this.company.getDepartment( coreConnection ).refMetaObject( );
        this.departmentName = (Attribute) this.department.lookupElement( coreConnection, "name" );
        this.departmentMaxJuniors = (Attribute) this.department.lookupElement( coreConnection, "maxJuniors" );
        this.departmentBudget = (Attribute) this.department.lookupElement( coreConnection, "budget" );
        this.bossRef = (ReferenceImpl) this.department.lookupElement( coreConnection, "boss" );
        this.employeeRef = (ReferenceImpl) this.department.lookupElement( coreConnection, "employee" );
        this.departmentRef = (ReferenceImpl) this.division.lookupElement( coreConnection, "department" );
        this.employee = (MofClassImpl) this.company.getEmployee( coreConnection ).refMetaObject( );
        this.employeeName = (Attribute) this.employee.lookupElement( coreConnection, "name" );
        this.employeeAge = (Attribute) this.employee.lookupElement( coreConnection, "age" );
        this.employeeSalary = (Attribute) this.employee.lookupElement( coreConnection, "salary" );
        this.employerRef = (ReferenceImpl) this.employee.lookupElement( coreConnection, "employer" );
        this.employeeSecretary = (Attribute) this.employee.lookupElement( coreConnection, "secretary" );
        this.directedRef = (ReferenceImpl) this.employee.lookupElement( coreConnection, "directed" );
        this.managedRef = (Reference) this.employee.lookupElement( coreConnection, "managed" );
        this.freelance = (MofClassImpl) this.company.getFreelance( coreConnection ).refMetaObject( );
        this.student = (MofClassImpl) this.company.getStudent( coreConnection ).refMetaObject( );
        this.freelanceAssignment = (Attribute) this.freelance.lookupElement( coreConnection, "assignment" );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#cleanUp()
     */
    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.resetInstances( );
        super.afterTestMethod( );
    }

    private void resetInstances( ) {

        this.serializer = null;
        this.serializerNoPackageNames = null;
        this.companyPackage = null;
        this.company = null;
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
     * parses the constaints
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
        RefPackage[] types = new RefPackage[] { this.company };
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
    public void beforeTestMethod( ) throws Exception {

        this.beforeTestMethod( true );
    }

    protected void beforeTestMethod( boolean withParsing ) throws Exception {

        super.beforeTestMethod( );
        // build up the test model used in the papers
        serializer = com.sap.tc.moin.ocl.utils.impl.OclSerializer.getInstance( coreConnection );
        serializerNoPackageNames = com.sap.tc.moin.ocl.utils.impl.OclSerializer.getInstance( coreConnection );
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
     * @param maxJuniors the value for the maxJunior attribte
     * @param budget the value for the budget attribute
     */
    private DepartmentImpl createDepartment( int employees, int freelances, int maxNumJuniors, int budget ) {

        Department wrappedDepartment = coreConnection.getWrapper( ).createElementInPartition( Department.class, null );

        DepartmentImpl dep = (DepartmentImpl) getTestHelper( ).getCorePartitionable( wrappedDepartment );
        dep.setName( coreConnection, "Dep" + this.curDepartmentID );
        dep.setMaxJuniors( coreConnection, maxNumJuniors );
        dep.setBudget( coreConnection, budget );
        this.curDepartmentID++;
        EmployeeImpl e = null;
        FreelanceImpl f = null;
        for ( int i = 0; i < employees; i++ ) {
            e = createEmployee( );
            ( (JmiList) dep.getEmployee( coreConnection ) ).add( coreConnection, e );
            ( (EmployeeImpl) e ).setEmployer( coreConnection, dep );
        }
        for ( int i = 0; i < freelances; i++ ) {
            f = createFreelance( );
            ( (JmiList) dep.getEmployee( coreConnection ) ).add( coreConnection, f );
            ( (FreelanceImpl) f ).setEmployer( coreConnection, dep );
        }
        this.allDepartments.add( dep );
        return dep;
    }

    /**
     * @return an instance of Employee
     */
    private EmployeeImpl createEmployee( ) {

        Employee wrappedEmplyoee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
        EmployeeImpl e = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedEmplyoee );
        e.setName( coreConnection, "empl" + this.curImployeeID );
        e.setAge( coreConnection, 42 );
        e.setSalary( coreConnection, 2345 );
        this.curImployeeID++;
        this.allEmployees.add( e );
        return e;
    }

    /**
     * @return a instnaces of Freelance
     */
    private FreelanceImpl createFreelance( ) {

        Freelance wrappedFreelance = coreConnection.getWrapper( ).createElementInPartition( Freelance.class, null );
        FreelanceImpl f = (FreelanceImpl) getTestHelper( ).getCorePartitionable( wrappedFreelance );
        f.setName( coreConnection, "empl" + this.curImployeeID );
        f.setAge( coreConnection, 42 );
        f.setAssignment( coreConnection, 7 );
        f.setSalary( coreConnection, 2345 );
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
        synchronized ( this.syncObjectForWrite ) {
            Division myDivision = this.coreConnection.getWrapper( ).createElementInPartition( Division.class, null );
            this.aDivision = (DivisionImpl) getTestHelper( ).getCorePartitionable( myDivision );
            ( (DivisionImpl) this.aDivision ).setName( coreConnection, "The super Division" );
            ( (DivisionImpl) this.aDivision ).setBudget( coreConnection, 2000000 );
            for ( double i = 0; i < numDepartments; i++ ) {
                createDepartment( numEmployees, numFreelance, maxNumJuniors, budget );
            }
            // pick some instances to which the events will be related
            this.aDepartment = (DepartmentImpl) this.allDepartments.iterator( ).next( );
            ( (JmiList) ( (DivisionImpl) this.aDivision ).getDepartment( coreConnection ) ).add( coreConnection, this.aDepartment );
            this.aEmployee = (EmployeeImpl) this.allEmployees.iterator( ).next( );
            this.aFreelance = (FreelanceImpl) this.allFreelances.iterator( ).next( );
        }
    }

    protected void printAffectedStatements( Set<EvaluationUnit> affectedStmts ) throws Exception {

        for ( Iterator<EvaluationUnit> i = affectedStmts.iterator( ); i.hasNext( ); ) {
            EvaluationUnit unit = i.next( );

            this.info( "Stmt: " + unit.getAffectedStatement( ).getName( ) + "\n" );
            this.info( this.serializer.serialize( unit.getAffectedStatement( ) ) + "\n\n" );

            // if (showJmiGraph) {
            // JmiTreeViewer tw = new
            // JmiTreeViewer(unit.getAffectedStatement().getExpression());
            // tw.setBounds(bounds);
            // tw.setModal(true);
            // tw.show();
            // }
            for ( Iterator<InstanceSet> j = unit.getInstanceSets( ).iterator( ); j.hasNext( ); ) {
                InstanceSet iSet = j.next( );
                this.info( "   Instances:\n" );
                for ( Iterator<RefObject> it = iSet.getStartingPoints( ).iterator( ); it.hasNext( ); ) {
                    RefFeatured inst = it.next( );
                    this.info( "    " + inst + " \n" );
                }
                this.info( this.serializer.serialize( iSet.getNavigationStatement( ) ) + "\n\n" );
                // FIXME adjust to new interface
                //this.showJmiTree(iSet.getNavigationStatement().getExpression());
            }
        }
    }

    /**
     * Turns an array of OclStatements into a Set of OclStatements
     * 
     * @param objects
     * @return the set of statements
     */
    protected Set<OclStatement> asSet( OclStatement[] objects ) {

        Set<OclStatement> s = new HashSet<OclStatement>( );
        for ( int i = 0; i < objects.length; i++ ) {
            s.add( objects[i] );
        }
        return s;
    }
}
