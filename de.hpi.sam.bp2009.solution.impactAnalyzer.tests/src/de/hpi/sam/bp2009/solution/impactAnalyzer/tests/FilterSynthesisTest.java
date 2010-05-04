package de.hpi.sam.bp2009.solution.impactAnalyzer.tests;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * Class scope analysis test
 */
public class FilterSynthesisTest extends de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest {

    private ImpactAnalyzer ia;

    private final Set<OCLExpression<EClassifier>> stmts = new HashSet<OCLExpression<EClassifier>>( );

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
    private boolean checkAffectedStatements( Set<OCLExpression<EClassifier>> iaResult, Set<OCLExpression<EClassifier>> expectedAffectedStmts ) {

        if ( iaResult.size( ) != expectedAffectedStmts.size( ) ) {
            return false;
        }
        Set<OCLExpression<EClassifier>> affectedStmts = new HashSet<OCLExpression<EClassifier>>( );
        for ( Iterator<OCLExpression<EClassifier>> i = iaResult.iterator( ); i.hasNext( ); ) {
            affectedStmts.add( i.next( ));
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
    public void tearDown( ) {

        super.tearDown( );
        this.stmts.clear( );
        this.ia = null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#prepare()
     */
    @Override
    @Before
    public void setUp( ) {

        super.setUp( );

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
            this.ia = new ImpactAnalyzerImpl();
            
            while(this.stmts.iterator().hasNext()){
                OCLExpression<EClassifier> exp = this.stmts.iterator().next();
                //why filter isn't saved?? we think this is done for caching purpose only
                this.ia.createFilterForQuery(exp, true);
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

        System.out.println( "===Statements:=============================================\n" );
        for ( Iterator<OCLExpression<EClassifier>> i = this.stmts.iterator( ); i.hasNext( ); ) {
            OCLExpression<EClassifier> stmt = i.next( );
            System.out.println( stmt );
        }
        System.out.println( "===END====================================================\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testAttributeValueChangedEventAge( ) {
        
        System.out.println( "===affected Statements for 'AttributeValueChangedEvent(Employee.age)'===\n" );
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, new Integer( 23 ), new Integer( 42 )); 
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossIsOldestAST);
        expectedStmts.add(this.maxJuniorsAST);        
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);       
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * @param noti a {@link Notification} including a model change
     * @return the {@link OCLExpression<EClassifier>}s which are affected by the given {@link Notification}
     */
    private HashSet<OCLExpression<EClassifier>> filterStatementsForNotification(Notification noti) {
        HashSet<OCLExpression<EClassifier>> affectedStmts = new HashSet<OCLExpression<EClassifier>>();
        while(this.stmts.iterator().hasNext()){
            OCLExpression<EClassifier> exp = this.stmts.iterator().next();
            EventFilter filter = this.ia.createFilterForQuery(exp, true);           
            if (filter.matchesFor(noti)){
                affectedStmts.add(exp);
            }
        }
        return affectedStmts;
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     * @throws Exception
     */
    @Test
    public void testAttributeValueChangedEventAssignment( ) {

        System.out.println( "===affected Statements for 'AttributeValueChangedEvent(Freelance.assignment)'===\n" );
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment, new Integer( 23 ), new Integer( 42 ));
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.validAssignmentAST);
        
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testAttributeValueChangedEventName( ) {

        Notification noti = NotificationHelper.createAttributeChangeNotification( this.aEmployee, this.employeeName, "Hinz", "Kunz" );
        System.out.println( "===affected Statements for 'AttributeValueChangedEvent(Employee.name)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.uniqueNamesAST);
        
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testAttributeValueChangedEventSalary( ) {

        Notification noti = NotificationHelper.createAttributeChangeNotification( this.aEmployee, this.employeeSalary, new Integer( 1234 ), new Integer( 1234 ) );
        System.out.println( "===affected Statements for 'AttributeValueChangedEvent(Employee.salary)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.bossHighestSalaryAST);
        //expectedStmts.add(this.expensesRestrictionAST);
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
      
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testAttributeValueChangedEventBudget( ) {

        Notification noti = NotificationHelper.createAttributeChangeNotification(  this.aDepartment, this.departmentBudget, new Integer( 1234 ), new Integer( 1234 ) );
        System.out.println( "===affected Statements for 'AttributeValueChangedEvent(Department.budget)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);        
        Set<OCLExpression<EClassifier>> expectedStmts = Collections.emptySet( );//expectedStmts.add(this.expensesRestrictionAST);
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testElementAddedEventDepartment( ) {

        Notification noti = NotificationHelper.createElementAddNotification( this.aDepartment );
        System.out.println( "===affected Statements for 'ElementAddedEvent(Department)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.maxJuniorsAST); 
        expectedStmts.add(this.bossHighestSalaryAST);
       
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testElementAddedEventEmployee( ) {

        Notification noti = NotificationHelper.createElementAddNotification( this.aEmployee );
        System.out.println( "===affected Statements for 'ElementAddedEvent(Employee)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.bossIsOldestAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testElementAddedEventFreelance( ) {

        Notification noti = NotificationHelper.createElementAddNotification( this.aFreelance );
        System.out.println( "===affected Statements for 'ElementAddedEvent(Freelance)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.validAssignmentAST);
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.bossIsOldestAST); 
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testElementRemovedEventDepartment( ) {

        Notification noti = NotificationHelper.createElementDeleteNotification( this.aDepartment );
        System.out.println( "===affected Statements for 'ElementRemovedEvent(Department)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = Collections.emptySet();
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testElementRemovedEventEmployee( ) {

        Notification noti = NotificationHelper.createElementDeleteNotification( this.aEmployee );
        System.out.println( "===affected Statements for 'ElementRemovedEvent(Employee)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.uniqueNamesAST);

        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testElementRemovedEventFreelance( ) {

        Notification noti = NotificationHelper.createElementDeleteNotification( this.aFreelance );
        System.out.println( "===affected Statements for 'ElementRemovedEvent(Freelance)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.uniqueNamesAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testLinkAddedEventManages( ) {

        Notification noti = NotificationHelper.createReferenceAddNotification( this.aDepartment, this.bossRef, this.aEmployee);
        System.out.println( "===affected Statements for 'LinkAddEvent(Manages)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.bossIsOldestAST);
        // this.expensesRestrictionAST
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testLinkAddedEventWorksIn( ) {

        Notification noti = NotificationHelper.createReferenceAddNotification( this.aDepartment, this.employeeRef, this.aEmployee );
        System.out.println( "===affected Statements for 'LinkAddEvent(WorksIn)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        // this.expensesRestrictionAST
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testLinkRemovedEventManages( ) {

        Notification noti = NotificationHelper.createReferenceRemoveNotification( this.aDepartment, this.bossRef, this.aEmployee );
        System.out.println( "===affected Statements for 'LinkRemoveEvent(Manages)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.bossIsOldestAST);
        // this.expensesRestrictionAST
        
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
        System.out.println( "===END=======================================================\n\n" );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     * 
     */
    @Test
    public void testLinkRemovedEventWorksIn( ) {

        Notification noti = NotificationHelper.createReferenceRemoveNotification( this.aDepartment, this.employeeRef, this.aEmployee );
        System.out.println( "===affected Statements for 'LinkRemoveEvent(WorksIn)'===\n" );
        
        HashSet<OCLExpression<EClassifier>> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression<EClassifier>> expectedStmts = new HashSet<OCLExpression<EClassifier>>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        // this.expensesRestrictionAST
        // TODO this fails right now because bossisoldest is returned in affected statements
        // TODO not sure if this can be fixed
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
         System.out.println( "===END=======================================================\n\n" );
    }

}