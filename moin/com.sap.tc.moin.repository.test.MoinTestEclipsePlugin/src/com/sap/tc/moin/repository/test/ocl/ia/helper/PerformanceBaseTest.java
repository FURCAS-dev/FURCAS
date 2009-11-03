package com.sap.tc.moin.repository.test.ocl.ia.helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.IAApplication;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.ElementCreateEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkAddEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.MRIImpl;
import com.sap.tc.moin.repository.test.ocl.ia.performance.IAPerformanceGetInstances;

/**
 * This class provides a base for a performance test based on the company test
 * model. Given a ChangeListener (i.e. an application) it creates an instance of
 * the company test model and bombards the application with events which may or
 * may not be relevant to the set of OclStatemetns the application is iterested
 * in. This test is repeated several times with an increasing number of
 * instances. Time is measured spent by notify().
 * 
 * @author Thomas Hettel (D039141)
 */
public class PerformanceBaseTest extends BaseIATest {

    private long startTimeNano = 0;

    private Set<Employee> allEmployees = new HashSet<Employee>( );

    private int curImployeeID = 0;

    private int curDepartmentID = 0;

    private Set<Department> allDepartments = new HashSet<Department>( );

    private Set<Freelance> allFreelances = new HashSet<Freelance>( );

    private CompanyPackage company;

    private Classifier employee;

    private Classifier department;

    private Classifier freelance;

    private Employee aEmployee;

    private Department aDepartment;

    private Freelance aFreelance;

    private MRI aDepartmentMRI;

    private MRI aEmployeeMRI;

    // private final static String seperator = "===================================================\n";

    /*
     * begin of constaints
     */
    protected String notBossFreelance = "context Department \n" + "  inv NotBossFreelance: \n" + "  not self.boss.oclIsTypeOf(Freelance)";

    protected String oldEmployee = "context Department \n" + "  inv OldEmployee: \n" + "  self.employee->exists(e | e.age > 45)";

    protected String uniqueNames = "context Employee \n" + "inv UniqueNames: \n" + "  Employee.allInstances()->forAll(e | \n" + "  e <> self implies e.name <> self.name)";

    protected String validAssignment = "context Freelance \n" + "  inv ValidAssignment: \n" + "  self.assignment >= 5 and self.assignment <= 30";

    protected String maxJuniors = "context Department inv MaxJuniors: \n" + "self.employee->select(e|e.age < 15)->size() < self.maxJuniors\n";

    protected String bossIsOldest = "context Employee inv BossIsOldest: \n" + "self.age <= self.employer.boss.age\n";

    protected String bossHighestSalary = "context Department inv BossHighestSalary: \n" + "self.employee->select(\n" + " e|e.salary >= self.boss.salary)->size() <= 1\n";

    /*
     * end of constaints
     */

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

    protected Set<OclStatement> classStatements = new HashSet<OclStatement>( );

    protected Set<OclStatement> instanceStatements = new HashSet<OclStatement>( );

    protected int minIt = 1;

    protected int maxIt = 10;

    /**
     * See superclass?
     * 
     * @throws Exception
     */
    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * See superclass?
     * 
     * @throws Exception
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.company = (CompanyPackage) this.connection.getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );
        this.employee = (Classifier) this.company.getEmployee( ).refMetaObject( );
        this.department = (Classifier) this.company.getDepartment( ).refMetaObject( );
        this.freelance = (Classifier) this.company.getFreelance( ).refMetaObject( );
        // parse constraints
        parseConstraints( );
        // add all class statements to a set
        this.classStatements.add( this.uniqueNamesAST );
        // add all instance statements to a set
        this.instanceStatements.add( this.bossHighestSalaryAST );
        this.instanceStatements.add( this.bossIsOldestAST );
        this.instanceStatements.add( this.maxJuniorsAST );
        this.instanceStatements.add( this.validAssignmentAST );
        this.instanceStatements.add( this.oldEmployeeAST );
        // this.instanceStatements.add(notBossFreelanceAST);

    }

    /**
     * runs a number of tests (i.e. raising each possible event once and measure
     * the time spent by notify(). For each test the number of instances is
     * encreased
     * 
     * @param app the change listener
     * @throws Exception
     */
    public void performanceTest( IAApplication app ) throws Exception {

        for ( int i = this.minIt; i <= this.maxIt; i++ ) {
            this.allDepartments.clear( );
            this.allEmployees.clear( );
            this.allFreelances.clear( );
            //this.info("Iteration: " + i);
            startPerformanceTest( );
            createInstances( Math.pow( 2, i - 1 ), 3, 1 );
            //long usedTime = stopPerformanceTest();
            //printNumOfInstances();
            //this.info("Test set up in " + formatTime(usedTime) + "\n");
            //long start = System.nanoTime();
            this.driveTest( app );
            //usedTime = System.nanoTime() - start;
            //this.info("Test finished in " + formatTime(usedTime) + "\n");
        }
        app.getEvaluationDataSet( ).printAsCSL( System.out, false );
    }

    /**
     * @param employees
     * @param freelances
     * @param numMaxJuniors
     * @param budget
     */
    private void createDepartment( int employees, int freelances, int numMaxJuniors, int budget ) {

        Department dep = this.connection.createElementInPartition( Department.class, null );
        dep.setName( "Dep" + this.curDepartmentID );
        dep.setMaxJuniors( numMaxJuniors );
        dep.setBudget( budget );
        this.curDepartmentID++;
        Employee e = null;
        for ( int i = 0; i < employees; i++ ) {
            e = createEmployee( );
            dep.getEmployee( ).add( e );
            e.setEmployer( dep );

        }
        for ( int i = 0; i < freelances; i++ ) {
            e = createFreelance( );
            dep.getEmployee( ).add( e );
            e.setEmployer( dep );

        }
        this.allDepartments.add( dep );
    }

    /**
     * @return the employee
     */
    private Employee createEmployee( ) {

        Employee e = this.connection.createElementInPartition( Employee.class, null );
        e.setName( "empl" + this.curImployeeID );
        e.setAge( 42 );
        e.setSalary( 2345 );
        this.curImployeeID++;
        this.allEmployees.add( e );
        return e;
    }

    /**
     * @return the freelance
     */
    private Freelance createFreelance( ) {

        Freelance f = this.connection.createElementInPartition( Freelance.class, null );
        f.setName( "empl" + this.curImployeeID );
        f.setAge( 42 );
        f.setAssignment( 7 );
        f.setSalary( 2345 );
        this.curImployeeID++;
        this.allEmployees.add( f );
        this.allFreelances.add( f );
        return f;
    }

    /**
     * @param numDepartments
     * @param numEmployees
     * @param numFreelance
     */
    private void createInstances( double numDepartments, int numEmployees, int numFreelance ) {

        int maxNumJuniors = 3;
        int budget = 50000;
        for ( double i = 0; i < numDepartments; i++ ) {
            createDepartment( numEmployees, numFreelance, maxNumJuniors, budget );
        }
        // pick some instances to which the events will be related
        this.aDepartment = this.allDepartments.iterator( ).next( );
        // need the mock mri
        this.aDepartmentMRI = new MRIImpl( this.aDepartment );

        this.aEmployee = this.allEmployees.iterator( ).next( );
        this.aEmployeeMRI = new MRIImpl( this.aEmployee );

        this.aFreelance = this.allFreelances.iterator( ).next( );
    }

    // /**
    // *
    // *
    // */
    // private void createQuiteSomeInstances() {
    // int numDepartments = 100;
    // int numEmployees = 14;
    // int numFreelance = 6;
    // int maxJuniors = 3;
    // int budget = 50000;
    // for (int i = 0; i < numDepartments; i++) {
    // createDepartment(numEmployees, numFreelance, maxJuniors, budget);
    // }
    // }
    //
    // /**
    // *
    // *
    // */
    // private void createAHellOfALotInstances() {
    // int numDepartments = 1000;
    // int numEmployees = 21;
    // int numFreelance = 9;
    // int maxJuniors = 3;
    // int budget = 50000;
    // for (int i = 0; i < numDepartments; i++) {
    // createDepartment(numEmployees, numFreelance, maxJuniors, budget);
    // }
    // }

    /**
     * 
     *  
     */
    private void printNumOfInstances( ) {

        int totalInstances = this.allDepartments.size( );
        totalInstances += this.allEmployees.size( );
        totalInstances += this.allFreelances.size( );
        this.info( "Instances:   " + totalInstances + " total" );
        this.info( "Departments: " + this.allDepartments.size( ) );
        this.info( "Employees:   " + this.allEmployees.size( ) );
        this.info( "Freelances:  " + this.allFreelances.size( ) );
    }

    /**
     * starts measuring time
     */
    private void startPerformanceTest( ) {

        this.startTimeNano = System.nanoTime( );
    }

    /**
     * stops measuring time
     * 
     * @return returns the time passed between startPerformanceTest() and the
     * call of this method.
     */
    private long stopPerformanceTest( ) {

        long stopTimeNano = System.nanoTime( );
        return stopTimeNano - this.startTimeNano;
    }

    private String formatTime( long timeInNanoSeconds ) {

        long milli = timeInNanoSeconds / 1000000;
        if ( milli > 10 ) {
            return "" + milli + " milliseconds";
        }
        long micro = timeInNanoSeconds / 1000;
        if ( micro > 10 ) {
            return "" + micro + " microseconds";
        }
        return "" + timeInNanoSeconds + " nanoseconds";
    }

    /**
     * This methode drives the actual test. It notifies the application about
     * virtual changes to the model. These changes may or may not be relevant to
     * the application's OclStatement. The time spent by the application's
     * notify method is recorded and logged.
     * 
     * @param app the application to test
     */
    private void driveTest( ChangeListener app ) throws Exception {

        // test attributes of employee first
        this.employeeAgeChanged( app );
        this.employeeNameChanged( app );
        this.employeeSalaryChanged( app );
        // test attributes of freelance
        this.freelanceAssignmentChanged( app );
        // test attributes of department
        this.departmentBudgetChanged( app );
        this.departmentMaxJuniorsChanged( app );
        this.departmentNameChanged( app );
        // add
        this.employeeAdded( app );
        this.departmentAdded( app );
        this.freelanceAdded( app );
        // remove
        this.employeeRemoved( app );
        this.departmentRemoved( app );
        this.freelanceRemoved( app );
        // test associations
        this.addEmployeeToDepartment( app );
        this.addBossToDepartment( app );
        this.removeBossFromDepartment( app );
        this.removeEmployeeFromDepartment( app );
    }

    /**
     * Notifies the application about a change of an employee's age and measures
     * the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void employeeAgeChanged( ChangeListener app ) throws Exception {

        Attribute ageAttr = (Attribute) this.employee.lookupElement( "age" );
        Integer age = new Integer( this.aEmployee.getAge( ) );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aEmployee, ageAttr, age, age );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a change of an employee's name and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void employeeNameChanged( ChangeListener app ) throws Exception {

        Attribute nameAttr = (Attribute) this.employee.lookupElement( "name" );
        String name = this.aEmployee.getName( );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aEmployee, nameAttr, name, name );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a change of an employee's salary and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void employeeSalaryChanged( ChangeListener app ) throws Exception {

        Attribute salaryAttr = (Attribute) this.employee.lookupElement( "salary" );
        Integer salary = new Integer( this.aEmployee.getSalary( ) );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aEmployee, salaryAttr, salary, salary );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a new employee and measures the time spent
     * by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void employeeAdded( ChangeListener app ) throws Exception {

        ElementCreateEvent event = new ElementCreateEventImpl( coreConnection, this.aEmployee );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a removed employee and measures the time
     * spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void employeeRemoved( ChangeListener app ) throws Exception {

        ElementDeleteEvent event = new ElementDeleteEventImpl( coreConnection, this.aEmployee );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a change of an freelance's assignment and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void freelanceAssignmentChanged( ChangeListener app ) throws Exception {

        Attribute assignmentAttr = (Attribute) this.freelance.lookupElement( "assignment" );
        Integer assignment = new Integer( this.aFreelance.getAssignment( ) );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aFreelance, assignmentAttr, assignment, assignment );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a new freelance and measures the time
     * spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void freelanceAdded( ChangeListener app ) throws Exception {

        ElementCreateEvent event = new ElementCreateEventImpl( coreConnection, this.aFreelance );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a removed freelance and measures the time
     * spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void freelanceRemoved( ChangeListener app ) throws Exception {

        ElementDeleteEvent event = new ElementDeleteEventImpl( coreConnection, this.aFreelance );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a change of a department's name and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void departmentNameChanged( ChangeListener app ) throws Exception {

        Attribute nameAttr = (Attribute) this.department.lookupElement( "name" );
        String name = this.aDepartment.getName( );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aDepartment, nameAttr, name, name );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a change of a department's maxJunior and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void departmentMaxJuniorsChanged( ChangeListener app ) throws Exception {

        Attribute maxJuniorsAttr = (Attribute) this.department.lookupElement( "maxJuniors" );
        Integer actMaxJuniors = new Integer( this.aDepartment.getMaxJuniors( ) );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aDepartment, maxJuniorsAttr, actMaxJuniors, actMaxJuniors );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a change of a department's budget and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void departmentBudgetChanged( ChangeListener app ) throws Exception {

        Attribute budgetAttr = (Attribute) this.department.lookupElement( "budget" );
        Integer budget = new Integer( this.aDepartment.getBudget( ) );
        AttributeValueChangeEvent event = new AttributeValueChangeEventImpl( coreConnection, this.aDepartment, budgetAttr, budget, budget );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a new department and measures the time
     * spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void departmentAdded( ChangeListener app ) throws Exception {

        ElementCreateEvent event = new ElementCreateEventImpl( coreConnection, this.aDepartment );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a removed department and measures the time
     * spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void departmentRemoved( ChangeListener app ) throws Exception {

        ElementDeleteEvent event = new ElementDeleteEventImpl( coreConnection, this.aDepartment );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    /**
     * Notifies the application about a new employee in a department and
     * measures the time spent by notify().
     * 
     * @param app the application to notify
     * @throws Exception
     */
    private void addEmployeeToDepartment( ChangeListener app ) throws Exception {

        Reference ref = (Reference) this.department.lookupElement( "employee" );
        List<MRI> ends = new Vector<MRI>( );
        ends.add( this.aDepartmentMRI );
        ends.add( this.aEmployeeMRI );
        LinkAddEvent event = new LinkAddEventImpl( coreConnection, ends, ref );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    private void removeEmployeeFromDepartment( ChangeListener app ) throws Exception {

        Reference ref = (Reference) this.department.lookupElement( "employee" );
        List<MRI> ends = new Vector<MRI>( );
        ends.add( this.aDepartmentMRI );
        ends.add( this.aEmployeeMRI );
        LinkRemoveEvent event = new LinkRemoveEventImpl( coreConnection, ends, ref );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    private void addBossToDepartment( ChangeListener app ) throws Exception {

        Reference ref = (Reference) this.department.lookupElement( "boss" );
        List<MRI> ends = new Vector<MRI>( );
        ends.add( this.aDepartmentMRI );
        ends.add( this.aEmployeeMRI );
        LinkAddEvent event = new LinkAddEventImpl( coreConnection, ends, ref );
        startPerformanceTest( );
        app.notify( event );
        this.printEvent( event, stopPerformanceTest( ) );
    }

    private void removeBossFromDepartment( ChangeListener app ) throws Exception {

        // TODO implement when required
    }

    private void printEvent( ModelChangeEvent mce, long timeUsed ) {

        if ( IAPerformanceGetInstances.LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            StringBuilder s = new StringBuilder( );
            if ( mce instanceof AttributeValueChangeEvent ) {
                AttributeValueChangeEvent avce = (AttributeValueChangeEvent) mce;
                s.append( "AttributeValueChangeEvent(" ).append( avce.getAffectedElement( mce.getEventTriggerConnection( ) ) ).append( ", " ).append( avce.getAffectedMetaObject( mce.getEventTriggerConnection( ) ).getName( ) ).append( ", " ).append( avce.getNewValue( ) ).append( ", " )
                    .append( avce.getOldValue( ) ).append( ")" );
            } else if ( mce instanceof ElementCreateEvent ) {
                ElementCreateEvent eae = (ElementCreateEvent) mce;
                s.append( "ElementAddEvent(" ).append( eae.getAffectedElement( mce.getEventTriggerConnection( ) ) ).append( ")" );
            } else if ( mce instanceof ElementDeleteEvent ) {
                ElementDeleteEvent ere = (ElementDeleteEvent) mce;
                s.append( "ElementRemoveEvent(" ).append( ere.getAffectedElementMri( ) ).append( ")" );
            } else if ( mce instanceof LinkAddEvent ) {
                LinkAddEvent lae = (LinkAddEvent) mce;
                MRI storedEnd = lae.getStoredLinkEndMri( );
                LRI nonStoredEnd = lae.getNonStoredLinkEndLri( );
                s.append( "LinkAddEvent(" ).append( ( (Reference) lae.getAffectedMetaObject( mce.getEventTriggerConnection( ) ) ).getName( ) ).append( ", " ).append( storedEnd ).append( ", " ).append( nonStoredEnd ).append( ")" );
            } else if ( mce instanceof LinkRemoveEvent ) {
                LinkRemoveEvent lre = (LinkRemoveEvent) mce;
                MRI storedEnd = lre.getStoredLinkEndMri( );
                LRI nonStoredEnd = lre.getNonStoredLinkEndLri( );
                s.append( "LinkRemoveEvent(" ).append( ( (Reference) lre.getAffectedMetaObject( mce.getEventTriggerConnection( ) ) ).getName( ) ).append( ", " ).append( storedEnd ).append( ", " ).append( nonStoredEnd ).append( ")" );

            }
            s.append( " Time used: " ).append( formatTime( timeUsed ) );
            IAPerformanceGetInstances.LOGGER.trace( MoinSeverity.DEBUG, s.toString( ) );
        }
    }

    /**
     *  
     */
    private void parseConstraints( ) throws Exception {

        RefPackage[] types = new RefPackage[] { this.company };
        this.oldEmployeeAST = parse( this.oldEmployee, null, types ).iterator( ).next( );
        this.notBossFreelanceAST = parse( this.notBossFreelance, null, types ).iterator( ).next( );
        this.uniqueNamesAST = parse( this.uniqueNames, null, types ).iterator( ).next( );
        this.validAssignmentAST = parse( this.validAssignment, null, types ).iterator( ).next( );
        this.maxJuniorsAST = parse( this.maxJuniors, null, types ).iterator( ).next( );
        this.bossIsOldestAST = parse( this.bossIsOldest, null, types ).iterator( ).next( );
        this.bossHighestSalaryAST = parse( this.bossHighestSalary, null, types ).iterator( ).next( );

    }
}