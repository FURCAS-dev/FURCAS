package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.expressions.OclExpression;

import com.sap.company.Department;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.company.__impl.DepartmentImpl;
import com.sap.company.__impl.DivisionImpl;
import com.sap.company.__impl.EmployeeImpl;
import com.sap.company.__impl.FreelanceImpl;
import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.events.InternalEventFactory;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.helper.BaseDepartmentTest;

/**
 * @author d022737
 */
public class TestClassScopeAnalysisIntegration extends BaseDepartmentTest {

    private ImpactAnalyzer ia;

    private Map<String, OclStatement> stmts = new HashMap<String, OclStatement>( );

    private ChangeListener myListener;

    Set<ModelChangeEvent> events = new HashSet<ModelChangeEvent>( );

    private FreelanceImpl createFreelance( CoreConnection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary, int assignment ) {

        Freelance myFreelance = conn.getWrapper( ).createElementInPartition( Freelance.class, null );
        FreelanceImpl freelance = (FreelanceImpl) getTestHelper( ).getCorePartitionable( myFreelance );
        freelance.setName( conn, name );
        freelance.setAge( conn, age );
        freelance.setSalary( conn, salary );
        freelance.setSecretary( conn, secretary );
        freelance.setAssignment( conn, assignment );
        return freelance;
    }

    private EmployeeImpl createEmployee( CoreConnection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary ) {

        Employee myEmployee = conn.getWrapper( ).createElementInPartition( Employee.class, null );
        EmployeeImpl employee = (EmployeeImpl) getTestHelper( ).getCorePartitionable( myEmployee );
        employee.setName( conn, name );
        employee.setAge( conn, age );
        employee.setSalary( conn, salary );
        employee.setSecretary( conn, secretary );
        return employee;
    }

    private DepartmentImpl createDepartment( CoreConnection conn, java.lang.String name, int maxJuniors, int budget ) {

        Department myDep = conn.getWrapper( ).createElementInPartition( Department.class, null );
        DepartmentImpl department = (DepartmentImpl) getTestHelper( ).getCorePartitionable( myDep );
        department.setName( conn, name );
        department.setMaxJuniors( conn, maxJuniors );
        department.setBudget( conn, budget );
        return department;
    }

    /**
     * Checks a Set of EvaluationContext against a Set of expected
     * OclStatements.
     * 
     * @param iaResult
     * @param expectedAffectedStmts
     * @return <tt>true</tt> iff each OclStatement in
     * <tt>expectedAffectedStmts</tt> is contained in an EvaluationContext in
     * <tt>iaResult</tt> and vice versa.
     */
    private boolean checkAffectedStatements( Set<EvaluationUnit> iaResult, Set<OclStatement> expectedAffectedStmts ) {

        if ( iaResult.size( ) != expectedAffectedStmts.size( ) ) {
            return false;
        }
        Set<OclStatement> affectedStmts = new HashSet<OclStatement>( );
        for ( Iterator<EvaluationUnit> i = iaResult.iterator( ); i.hasNext( ); ) {
            affectedStmts.add( i.next( ).getAffectedStatement( ) );
        }

        if ( affectedStmts.containsAll( expectedAffectedStmts ) ) {
            return true;
        }
        return false;

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#cleanUp()
     */
    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( getTestHelper( ).getCoreMoin( ) != null && coreConnection.getSession( ) != null ) {
            coreConnection.getSession( ).getEventRegistry( ).deregister( this.myListener );

            if ( ia != null ) {
                this.ia.reset( );
            }
            this.stmts.clear( );
            this.ia = null;
            this.stmts = null;
            this.events.clear( );
            this.events = null;
        }
        super.afterTestMethod( );

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#prepare()
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( false );
        this.myListener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                if ( event instanceof ModelChangeEvent ) {
                    TestClassScopeAnalysisIntegration.this.events.add( (ModelChangeEvent) event );
                }
            }
        };

        // create some instances
        this.createInstances( 1, 5, 1 );

        Set<OclConstraint> parsedConstraints = new HashSet<OclConstraint>( );
        // TODO we need to feed the oclbodyexpressions into the impact analysis, too
        Collection<OclConstraint> allpconstraints = (Collection) ( (RefClassImpl) coreConnection.getClass( OclConstraint.CLASS_DESCRIPTOR ) ).refAllOfClass( coreConnection );

        for ( OclConstraint next : allpconstraints ) {
            // only company constraints, of course
            if ( ( (OclConstraintImpl) next ).getQualifiedName( coreConnection ).get( 0 ).equals( "Company" ) ) {
                parsedConstraints.add( next );
            }
        }

        for ( final OclConstraint constraint : parsedConstraints ) {

            JmiList constrainedElements = (JmiList) ( (OclConstraintImpl) constraint ).getConstrainedElements( coreConnection );
            for ( Iterator it = constrainedElements.iterator( coreConnection ); it.hasNext( ); ) {

                final RefObject element = (RefObject) it.next( );

                OclStatement stmt = new OclStatement( ) {

                    public String getName( ) {

                        return ( (OclConstraintImpl) constraint ).getOclExpression( coreConnection ).getName( );
                    }

                    public int getKind( ) {

                        return OclStatement.INVARIANT;
                    }

                    public OclExpression getExpression( ) {

                        return ( (OclConstraintImpl) constraint ).getOclExpression( coreConnection );
                    }

                    public RefObject getContext( ) {

                        return element;
                    }

                };
                this.stmts.put( constraint.getName( ), stmt );
            }
        }

        if ( this.stmts.isEmpty( ) ) {
            fail( "No OCL Constraints found" );
        }

        Set<OclStatement> iAstatements = new HashSet<OclStatement>( );
        // we want to have only these stmts in the impact analyzer so that if we add stuff to the MM, the test
        // doesn't break

        this.notBossFreelanceAST = this.stmts.get( "NotBossFreelance" );
        iAstatements.add( this.stmts.get( "NotBossFreelance" ) );
        this.oldEmployeeAST = this.stmts.get( "OldEmployee" );
        iAstatements.add( this.stmts.get( "OldEmployee" ) );
        this.uniqueNamesAST = this.stmts.get( "UniqueNames" );
        iAstatements.add( this.stmts.get( "UniqueNames" ) );
        this.validAssignmentAST = this.stmts.get( "ValidAssignment" );
        iAstatements.add( this.stmts.get( "ValidAssignment" ) );
        this.maxJuniorsAST = this.stmts.get( "MaxJuniorsConstraint" );
        iAstatements.add( this.stmts.get( "MaxJuniorsConstraint" ) );
        this.bossIsOldestAST = this.stmts.get( "BossIsOldest" );
        iAstatements.add( this.stmts.get( "BossIsOldest" ) );
        this.bossHighestSalaryAST = this.stmts.get( "BossHighestSalary" );
        iAstatements.add( this.stmts.get( "BossHighestSalary" ) );
        this.expensesRestrictionAST = this.stmts.get( "ExpensesRestriction" );
        iAstatements.add( this.stmts.get( "ExpensesRestriction" ) );
        this.nastyConstraintAST = this.stmts.get( "NastyConstraint" );
        iAstatements.add( this.stmts.get( "NastyConstraint" ) );
        this.divisionBossSecretaryAST = this.stmts.get( "DivisionBossSecretary" );
        iAstatements.add( this.stmts.get( "DivisionBossSecretary" ) );
        this.secretaryOlderThanBossAST = this.stmts.get( "SecretaryOlderThanBoss" );
        iAstatements.add( this.stmts.get( "SecretaryOlderThanBoss" ) );
        this.boss10YearsOlderThanJuniorAST = this.stmts.get( "Boss10YearsOlderThanJunior" );
        iAstatements.add( this.stmts.get( "Boss10YearsOlderThanJunior" ) );

        if ( this.ia == null ) {
            ModelPartition transientPartition = coreConnection.getOrCreateTransientPartitionNonTransactional( "OclTransientPartition" );
            this.ia = new ImpactAnalyzer( false );

            synchronized ( this.syncObjectForWrite ) {
                MoinJmiCreator jmiCreator = new JmiCreator( coreConnection, false, transientPartition );
                EventFilter filter = this.ia.analyze( iAstatements, jmiCreator );
                coreConnection.getSession( ).getEventRegistry( ).registerListener( this.myListener, filter );
            }
        }

    }

    /**
     * prints out all statements which will be fed into IA
     * 
     * @throws Exception
     */
    @Test
    public void testPrintAllStmts( ) throws Exception {

        this.info( "===Statements:=============================================\n" );
        for ( Iterator<OclStatement> i = this.stmts.values( ).iterator( ); i.hasNext( ); ) {
            OclStatement stmt = i.next( );
            this.info( this.serializer.serialize( stmt ) + "\n\n" );
        }
        this.info( "===END====================================================\n\n" );
    }

    /**
     * Feeds a set of ocl statements to IA, fetches the InternalEvents and
     * compares them to a set of expected InternalEvents.
     * 
     * @throws Exception
     */
    @Test
    public void testInternalEvents( ) throws Exception {

        // TODO This will compile, but definitely not work at the moment!
        InternalEventFactory factory = new InternalEventFactory( );

        /*
         * build the expected set of InternalEvents
         */
        Set<InternalEvent> expectedEvents = new HashSet<InternalEvent>( );
        // events for OldEmployee
        expectedEvents.add( factory.createInsertET( this.department ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.employeeAge ) );
        // events for NotBossFreelance
        expectedEvents.add( factory.createInsertET( this.department ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) ) );
        // events for UniqueNames
        expectedEvents.add( factory.createInsertET( this.employee ) );
        expectedEvents.add( factory.createDeleteET( this.employee ) );
        expectedEvents.add( factory.createInsertET( this.freelance ) );
        expectedEvents.add( factory.createDeleteET( this.freelance ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.employeeName ) );
        // events for ValidAssignment
        expectedEvents.add( factory.createInsertET( this.freelance ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.freelanceAssignment ) );
        // events for BossIsOldest
        expectedEvents.add( factory.createInsertET( this.employee ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.employeeAge ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.employerRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.employerRef.getReferencedEnd( coreConnection ) ) );
        // events for bossHighestSalary
        expectedEvents.add( factory.createInsertET( this.department ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.employeeSalary ) );
        // events for MaxJuniors
        expectedEvents.add( factory.createInsertET( this.department ) );
        expectedEvents.add( factory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.employeeAge ) );
        expectedEvents.add( factory.createUpdateAttribute( coreConnection, this.departmentMaxJuniors ) );

        /*
         * checking the internalEvents
         */
        this.info( "===Checking InternalEvents===\n" );
        Set<InternalEvent> iaEvents = this.ia.testingGetInternalEvents( );
        this.printResult( iaEvents, expectedEvents, System.out, true );
        double res = this.checkResultAgainstOptimum( expectedEvents, iaEvents );
        if ( res >= 0 ) {
            this.info( "PASSED: " + res + "\n" );
        } else {
            this.info( "FAILED\n" );
            this.info( "===Missing Events===\n" );
            Set<InternalEvent> missingEvents = new HashSet<InternalEvent>( );
            missingEvents.addAll( expectedEvents );
            missingEvents.removeAll( iaEvents );
            for ( Iterator<InternalEvent> i = missingEvents.iterator( ); i.hasNext( ); ) {
                this.info( i.next( ).toString( ) + "\n" );
            }

        }
        /*
         * Check the returned filter
         */
        // FIXME remove this once MoinFilterGenerator#dump(Filter) has been fixed
        // String filterString = MoinFilterGenerator.dump(filter);
        // this.info("===Returned MoinEventFilter===\n");
        // this.info(filterString);
        this.info( "\n===DONE===\n" );
        if ( res < 0 ) {
            flop( "Checking InternalEvents failed" );
        }
        this.info( "===END=======================================================\n\n" );
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testAttributeValueChangedEventAge( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            int oldValue = this.aEmployee.getAge( );
            this.beforeChange( );
            this.aEmployee.setAge( coreConnection, oldValue + 1 );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.bossIsOldestAST, this.maxJuniorsAST, this.secretaryOlderThanBossAST, this.boss10YearsOlderThanJuniorAST } );
            this.checkEvents( "AttributeValueChangedEvent(Employee.age)", expectedStmts );
            this.aEmployee.setAge( coreConnection, oldValue );
        }

    }

    private void checkEvents( String title, Set<OclStatement> expectedStmts ) throws OclSerializationException {

        if ( this.events.isEmpty( ) ) {
            flop( "No events received for test " + title );
            return;
        }

        Set<EvaluationUnit> evalUnits = this.ia.filter( coreConnection, this.events );

        this.info( "===affected Statements for " + title + "===" );

        if ( checkAffectedStatements( evalUnits, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( evalUnits, expectedStmts );
            flop( "FAILED" );
        }
        this.info( "===END=======================================================" );
    }

    private void beforeChange( ) {

        this.events.clear( );
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testAttributeValueChangedEventAssignment( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            int oldValue = this.aFreelance.getAssignment( );
            this.beforeChange( );
            this.aFreelance.setAssignment( coreConnection, oldValue + 10 );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.validAssignmentAST } );
            this.checkEvents( "AttributeValueChangedEvent(Freelance.assignment)", expectedStmts );
            this.aFreelance.setAssignment( coreConnection, oldValue );
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testAttributeValueChangedEventName( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            String oldValue = this.aEmployee.getName( );
            this.beforeChange( );
            this.aEmployee.setName( coreConnection, "Not" + oldValue + "Anymore" );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST } );
            this.checkEvents( "AttributeValueChangedEvent(Employee.name)", expectedStmts );
            this.aEmployee.setName( coreConnection, oldValue );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testAttributeValueChangedEventSalary( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            int oldValue = this.aEmployee.getSalary( );
            this.beforeChange( );
            this.aEmployee.setSalary( coreConnection, oldValue + 100 );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.bossHighestSalaryAST, this.nastyConstraintAST, this.expensesRestrictionAST } );
            this.checkEvents( "AttributeValueChangedEvent(Employee.salary)", expectedStmts );
            this.aEmployee.setSalary( coreConnection, oldValue );
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testAttributeValueChangedEventBudget( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            int oldValue = this.aDepartment.getBudget( );
            this.beforeChange( );
            this.aDepartment.setBudget( coreConnection, oldValue + 1000 );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.expensesRestrictionAST } );
            this.checkEvents( "AttributeValueChangedEvent(Department.budget)", expectedStmts );
            this.aDepartment.setBudget( coreConnection, oldValue );
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testElementAddedEventDepartment( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            this.beforeChange( );
            Department wrappedDepartment = coreConnection.getWrapper( ).createElementInPartition( Department.class, null );
            DepartmentImpl newDep = (DepartmentImpl) getTestHelper( ).getCorePartitionable( wrappedDepartment );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.notBossFreelanceAST, this.maxJuniorsAST, this.bossHighestSalaryAST, this.boss10YearsOlderThanJuniorAST, this.expensesRestrictionAST } );
            this.checkEvents( "ElementAddedEvent(Department)", expectedStmts );
            newDep.refDelete( coreConnection );
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testElementAddedEventEmployee( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            this.beforeChange( );
            Employee wrappedEmployee = coreConnection.getWrapper( ).createElementInPartition( Employee.class, null );
            EmployeeImpl newEmp = (EmployeeImpl) getTestHelper( ).getCorePartitionable( wrappedEmployee );

            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST, this.bossIsOldestAST, this.divisionBossSecretaryAST, this.secretaryOlderThanBossAST } );
            this.checkEvents( "ElementAddedEvent(Employee)", expectedStmts );
            newEmp.refDelete( coreConnection );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testElementAddedEventFreelance( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            this.beforeChange( );
            Freelance wrappedFreelance = coreConnection.getWrapper( ).createElementInPartition( Freelance.class, null );
            FreelanceImpl newFreelance = (FreelanceImpl) getTestHelper( ).getCorePartitionable( wrappedFreelance );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.validAssignmentAST, this.uniqueNamesAST, this.bossIsOldestAST, this.divisionBossSecretaryAST, this.secretaryOlderThanBossAST } );
            this.checkEvents( "ElementAddedEvent(Freelance)", expectedStmts );
            newFreelance.refDelete( coreConnection );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testElementRemovedEventDepartment( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            DepartmentImpl tempDep = (DepartmentImpl) createDepartment( coreConnection, "SomeDep", 10, 10000 );
            this.beforeChange( );
            tempDep.refDelete( coreConnection );
            if ( !this.events.isEmpty( ) ) {
                Set<OclStatement> expectedStmts = Collections.emptySet( );
                this.checkEvents( "ElementRemovedEvent(Department)", expectedStmts );
                flop( "No event was expected for deletion of department" );
            }
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testElementRemovedEventEmployee( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            EmployeeImpl tempEmp = (EmployeeImpl) createEmployee( coreConnection, "Someone", 39, 500, null );
            this.beforeChange( );
            tempEmp.refDelete( coreConnection );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST } );
            this.checkEvents( "ElementRemovedEvent(Employee)", expectedStmts );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testElementRemovedEventFreelance( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            FreelanceImpl tempFreelance = (FreelanceImpl) createFreelance( coreConnection, "Someone", 20, 0, null, 22 );
            this.beforeChange( );
            tempFreelance.refDelete( coreConnection );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST } );
            this.checkEvents( "ElementRemovedEvent(Freelance)", expectedStmts );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testLinkAddedEventManages( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            EmployeeImpl oldBoss = (EmployeeImpl) this.aDepartment.getBoss( coreConnection );
            this.beforeChange( );
            this.aDepartment.setBoss( coreConnection, this.aEmployee );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.notBossFreelanceAST, this.bossHighestSalaryAST, this.bossIsOldestAST, this.nastyConstraintAST, this.boss10YearsOlderThanJuniorAST, this.expensesRestrictionAST } );
            this.checkEvents( "LinkAddEvent(Manages)", expectedStmts );
            this.aDepartment.setBoss( coreConnection, oldBoss );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testLinkAddedEventWorksIn( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            DepartmentImpl oldDepartment = (DepartmentImpl) this.aEmployee.getEmployer( coreConnection );
            this.aEmployee.setEmployer( coreConnection, null );
            this.beforeChange( );
            this.aEmployee.setEmployer( coreConnection, this.aDepartment );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.bossHighestSalaryAST, this.maxJuniorsAST, this.bossIsOldestAST, this.boss10YearsOlderThanJuniorAST, this.nastyConstraintAST, this.expensesRestrictionAST } );
            this.checkEvents( "LinkAddEvent(WorksIn)", expectedStmts );
            this.aEmployee.setEmployer( coreConnection, oldDepartment );
        }

    }

    /**
     * @param affectedStmts
     * @param expectedStmts
     * @throws OclSerializationException
     */
    private void printHint( Set<EvaluationUnit> affectedStmts, Set<OclStatement> expectedStmts ) throws OclSerializationException {

        this.info( "===expected statements===\n" );
        for ( Iterator<OclStatement> i = expectedStmts.iterator( ); i.hasNext( ); ) {
            OclStatement stmt = i.next( );
            this.info( this.serializer.serialize( stmt ) + "\n" );
        }
        this.info( "===returned affected statements===\n" );
        for ( Iterator<EvaluationUnit> i = affectedStmts.iterator( ); i.hasNext( ); ) {
            this.info( this.serializer.serialize( i.next( ).getAffectedStatement( ) ) + "\n" );
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testLinkRemovedEventManages( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            EmployeeImpl oldBoss = (EmployeeImpl) this.aDepartment.getBoss( coreConnection );
            this.aDepartment.setBoss( coreConnection, this.aEmployee );
            this.beforeChange( );
            this.aDepartment.setBoss( coreConnection, null );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.notBossFreelanceAST, this.bossHighestSalaryAST, this.bossIsOldestAST, this.boss10YearsOlderThanJuniorAST, this.nastyConstraintAST, this.expensesRestrictionAST } );
            this.checkEvents( "LinkRemoveEvent(Manages)", expectedStmts );
            this.aDepartment.setBoss( coreConnection, oldBoss );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testLinkRemovedEventWorksIn( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            DepartmentImpl oldDepartment = (DepartmentImpl) this.aEmployee.getEmployer( coreConnection );
            this.aEmployee.setEmployer( coreConnection, this.aDepartment );
            this.beforeChange( );
            this.aEmployee.setEmployer( coreConnection, null );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.bossHighestSalaryAST, this.maxJuniorsAST, this.bossIsOldestAST, this.boss10YearsOlderThanJuniorAST, this.nastyConstraintAST, this.expensesRestrictionAST } );
            this.checkEvents( "LinkRemoveEvent(WorksIn)", expectedStmts );
            this.aEmployee.setEmployer( coreConnection, oldDepartment );
        }

    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testLinkAddedEventDepartment( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            DepartmentImpl newDepartment = (DepartmentImpl) createDepartment( coreConnection, "NewDepartment", 10, 10000 );
            this.beforeChange( );
            ( (JmiList) ( (DivisionImpl) this.aDivision ).getDepartment( coreConnection ) ).add( coreConnection, newDepartment );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.nastyConstraintAST } );
            this.checkEvents( "LinkAddedEventDepartment", expectedStmts );
            newDepartment.refDelete( coreConnection );
        }
    }

    /**
     * Sends a ModelChangeEvent to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testImplicitLinkRemovedEventDepartment( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            DepartmentImpl newDepartment = (DepartmentImpl) createDepartment( coreConnection, "NewDepartment", 10, 10000 );
            // we create the link explicitly
            ( (JmiList) ( (DivisionImpl) this.aDivision ).getDepartment( coreConnection ) ).add( coreConnection, newDepartment );
            this.beforeChange( );
            // and delete the link implicitly
            newDepartment.refDelete( coreConnection );
            Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.nastyConstraintAST } );
            this.checkEvents( "ImplicitLinkRemovedEventDepartment", expectedStmts );
        }

    }

}
