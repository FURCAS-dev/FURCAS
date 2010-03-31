package com.sap.tc.moin.repository.test.ocl.ia;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.events.InternalEventFactory;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.test.ocl.ia.helper.BaseDepartmentTest;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.ElementCreateEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkAddEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.MRIImpl;

/**
 * Class scope analysis test
 */
public class TestClassScopeAnalysis extends BaseDepartmentTest {

    private ImpactAnalyzer ia;

    private final Set<OclStatement> stmts = new HashSet<OclStatement>( );

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

        super.afterTestMethod( );
        this.stmts.clear( );
        this.ia = null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#prepare()
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // create some instances
        this.createInstances( 1, 5, 1 );

        if ( this.stmts.isEmpty( ) ) {
            this.stmts.add( this.notBossFreelanceAST );
            this.stmts.add( this.validAssignmentAST );
            this.stmts.add( this.uniqueNamesAST );
            this.stmts.add( this.oldEmployeeAST );
            this.stmts.add( this.bossHighestSalaryAST );
            this.stmts.add( this.bossIsOldestAST );
            this.stmts.add( this.maxJuniorsAST );
            // this.stmts.add(this.expensesRestrictionAST);
        }
        if ( this.ia == null ) {
            this.ia = new ImpactAnalyzer( false );
            synchronized ( this.syncObjectForWrite ) {
                this.ia.analyze( this.stmts, this.myJmiCreator );
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
        for ( Iterator<OclStatement> i = this.stmts.iterator( ); i.hasNext( ); ) {
            OclStatement stmt = i.next( );
            this.info( this.serializer.serialize( stmt ) );
        }
        this.info( "===END====================================================\n" );
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

        AttributeValueChangeEvent employeeAgeChanged = new AttributeValueChangeEventImpl( coreConnection, this.aEmployee, this.employeeAge, new Integer( 23 ), new Integer( 42 ) );
        this.info( "===affected Statements for 'AttributeValueChangedEvent(Employee.age)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeAgeChanged );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.bossIsOldestAST, this.maxJuniorsAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testAttributeValueChangedEventAssignment( ) throws Exception {

        AttributeValueChangeEvent freelanceAssignmentChanged = new AttributeValueChangeEventImpl( coreConnection, this.aFreelance, this.freelanceAssignment, new Integer( 23 ), new Integer( 42 ) );
        this.info( "===affected Statements for 'AttributeValueChangedEvent(Freelance.assignment)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, freelanceAssignmentChanged );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.validAssignmentAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testAttributeValueChangedEventName( ) throws Exception {

        AttributeValueChangeEvent employeeNameChanged = new AttributeValueChangeEventImpl( coreConnection, this.aEmployee, this.employeeName, "Hinz", "Kunz" );
        this.info( "===affected Statements for 'AttributeValueChangedEvent(Employee.name)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeNameChanged );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testAttributeValueChangedEventSalary( ) throws Exception {

        AttributeValueChangeEvent employeeNameChanged = new AttributeValueChangeEventImpl( coreConnection, this.aEmployee, this.employeeSalary, new Integer( 1234 ), new Integer( 1234 ) );
        this.info( "===affected Statements for 'AttributeValueChangedEvent(Employee.salary)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeNameChanged );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.bossHighestSalaryAST } );
        // , this.expensesRestrictionAST });
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testAttributeValueChangedEventBudget( ) throws Exception {

        AttributeValueChangeEvent employeeNameChanged = new AttributeValueChangeEventImpl( coreConnection, this.aDepartment, this.departmentBudget, new Integer( 1234 ), new Integer( 1234 ) );
        this.info( "===affected Statements for 'AttributeValueChangedEvent(Department.budget)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeNameChanged );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = Collections.emptySet( );// asSet(new OclStatement[] { this.expensesRestrictionAST });
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testElementAddedEventDepartment( ) throws Exception {

        ElementCreateEvent departmentAdded = new ElementCreateEventImpl( coreConnection, this.aDepartment );
        this.info( "===affected Statements for 'ElementAddedEvent(Department)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, departmentAdded );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.notBossFreelanceAST, this.maxJuniorsAST, this.bossHighestSalaryAST } );// , this.expensesRestrictionAST});
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testElementAddedEventEmployee( ) throws Exception {

        ElementCreateEvent employeeAdded = new ElementCreateEventImpl( coreConnection, this.aEmployee );
        this.info( "===affected Statements for 'ElementAddedEvent(Employee)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeAdded );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST, this.bossIsOldestAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testElementAddedEventFreelance( ) throws Exception {

        ElementCreateEvent freelanceAdded = new ElementCreateEventImpl( coreConnection, this.aFreelance );
        this.info( "===affected Statements for 'ElementAddedEvent(Freelance)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, freelanceAdded );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.validAssignmentAST, this.uniqueNamesAST, this.bossIsOldestAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testElementRemovedEventDepartment( ) throws Exception {

        ElementDeleteEvent departmentRemoved = new ElementDeleteEventImpl( coreConnection, this.aDepartment );
        this.info( "===affected Statements for 'ElementRemovedEvent(Department)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, departmentRemoved );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] {} );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testElementRemovedEventEmployee( ) throws Exception {

        ElementDeleteEvent employeeRemoved = new ElementDeleteEventImpl( coreConnection, this.aEmployee );
        this.info( "===affected Statements for 'ElementRemovedEvent(Employee)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeRemoved );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testElementRemovedEventFreelance( ) throws Exception {

        ElementDeleteEvent freelanceRemoved = new ElementDeleteEventImpl( coreConnection, this.aFreelance );
        this.info( "===affected Statements for 'ElementRemovedEvent(Freelance)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, freelanceRemoved );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.uniqueNamesAST } );
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testLinkAddedEventManages( ) throws Exception {

        List<MRI> dummy = new Vector<MRI>( );
        dummy.add( new MRIImpl( this.aEmployee ) );
        dummy.add( new MRIImpl( this.aDepartment ) );
        LinkAddEvent bossHired = new LinkAddEventImpl( coreConnection, dummy, this.bossRef.getReferencedEnd( coreConnection ) );

        this.info( "===affected Statements for 'LinkAddEvent(Manages)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, bossHired );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.notBossFreelanceAST, this.bossHighestSalaryAST, this.bossIsOldestAST } ); // , this.expensesRestrictionAST
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testLinkAddedEventWorksIn( ) throws Exception {

        List<MRI> dummy = new Vector<MRI>( );
        dummy.add( new MRIImpl( this.aEmployee ) );
        dummy.add( new MRIImpl( this.aDepartment ) );
        LinkAddEvent employeeHired = new LinkAddEventImpl( coreConnection, dummy, this.employeeRef.getReferencedEnd( coreConnection ) );
        this.info( "===affected Statements for 'LinkAddEvent(WorksIn)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeHired );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.bossHighestSalaryAST, this.maxJuniorsAST, this.bossIsOldestAST } );
        // this.expensesRestrictionAST});
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
        }
        this.info( "===END=======================================================\n\n" );
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

        List<MRI> dummy = new Vector<MRI>( );
        dummy.add( new MRIImpl( this.aEmployee ) );
        dummy.add( new MRIImpl( this.aDepartment ) );
        LinkRemoveEvent bossFired = new LinkRemoveEventImpl( coreConnection, dummy, this.bossRef.getReferencedEnd( coreConnection ) );

        this.info( "===affected Statements for 'LinkRemoveEvent(Manages)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, bossFired );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.notBossFreelanceAST, this.bossHighestSalaryAST, this.bossIsOldestAST } ); // , this.expensesRestrictionAST });
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
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
    public void testLinkRemovedEventWorksIn( ) throws Exception {

        List<MRI> dummy = new Vector<MRI>( );
        dummy.add( new MRIImpl( this.aEmployee ) );
        dummy.add( new MRIImpl( this.aDepartment ) );
        LinkRemoveEvent employeeFired = new LinkRemoveEventImpl( coreConnection, dummy, this.employeeRef.getReferencedEnd( coreConnection ) );

        this.info( "===affected Statements for 'LinkRemoveEvent(WorksIn)'===\n" );
        Set<EvaluationUnit> affectedStmts = this.ia.filter( coreConnection, employeeFired );
        printAffectedStatements( affectedStmts );
        Set<OclStatement> expectedStmts = asSet( new OclStatement[] { this.oldEmployeeAST, this.bossHighestSalaryAST, this.maxJuniorsAST, this.bossIsOldestAST } );
        // this.expensesRestrictionAST});
        // TODO this fails right now because bossisoldest is returned in affected statements
        // TODO not sure if this can be fixed
        if ( checkAffectedStatements( affectedStmts, expectedStmts ) ) {
            this.info( "PASSED\n\n" );
        } else {
            this.info( "FAILED\n\n" );
            printHint( affectedStmts, expectedStmts );
            flop( "FAILED" );
        }
        this.info( "===END=======================================================\n\n" );
    }

}