package de.hpi.sam.bp2009.solution.impactAnalyzer.tests;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * Class scope analysis test
 */
public class FilterSynthesisTest extends BaseDepartmentTest {

    private ImpactAnalyzer ia;

    private final Set<OCLExpression> stmts = new HashSet<OCLExpression>( );

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
        }
        if ( this.ia == null ) {
            this.ia = new ImpactAnalyzerImpl();
            Iterator<OCLExpression> i = this.stmts.iterator();
            while(i.hasNext()){
                OCLExpression exp = i.next();
                //filter isn't saved, because this is done for caching purpose only
                this.ia.createFilterForQuery(exp, true);
            }           
        }
    }

    @Override
    @After
    public void tearDown( ) {

        super.tearDown( );
        this.stmts.clear( );
        this.ia = null;
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAge( ) {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, new Long( 23 ), new Long( 42 )); 

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossIsOldestAST);
        expectedStmts.add(this.maxJuniorsAST);                            

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAssignment( ) {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment, new Long( 23 ), new Long( 42 ));
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.validAssignmentAST);
       
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventName( ) {
        Notification noti = NotificationHelper.createAttributeChangeNotification( this.aEmployee, this.employeeName, "Hinz", "Kunz" );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventSalary( ) {
        Notification noti = NotificationHelper.createAttributeChangeNotification( this.aEmployee, this.employeeSalary, new Long( 1234 ), new Long( 1234 ) );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.bossHighestSalaryAST);

        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );     
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventBudget( ) {
        Notification noti = NotificationHelper.createAttributeChangeNotification(  this.aDepartment, this.departmentBudget, new Long( 1234 ), new Long( 1234 ) );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);        
        Set<OCLExpression> expectedStmts = Collections.emptySet( );
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );        
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventDepartment( ) {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDivision, this.departmentRef, comp.getCompanyFactory().createDepartment() );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.maxJuniorsAST); 
        expectedStmts.add(this.bossHighestSalaryAST);
       
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventEmployee( ) {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef,  comp.getCompanyFactory().createEmployee() );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.bossIsOldestAST);
        //added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }
    
    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventFreelance( ) {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory().createFreelance() );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.validAssignmentAST);
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.bossIsOldestAST); 
        //added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventDepartment( ) {
        Notification noti = NotificationHelper.createElementDeleteNotification( this.aDepartment );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        //added by bp2009
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.maxJuniorsAST); 
        expectedStmts.add(this.bossHighestSalaryAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventEmployee( ) {
        Notification noti = NotificationHelper.createElementDeleteNotification( this.aEmployee );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        //added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);

        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventFreelance( ) {

        Notification noti = NotificationHelper.createElementDeleteNotification( this.aFreelance );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        //added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        expectedStmts.add(this.validAssignmentAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testLinkAddedEventManages( ) {
        Notification noti = NotificationHelper.createReferenceAddNotification( this.aDepartment, this.bossRef, comp.getCompanyFactory().createEmployee());
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.bossIsOldestAST);
        //added by bp2009
        expectedStmts.add(this.uniqueNamesAST);

        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testLinkAddedEventWorksIn( ) {
        Notification noti = NotificationHelper.createReferenceAddNotification( this.aDepartment, this.employeeRef, comp.getCompanyFactory().createEmployee() );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        //added by bp2009
        expectedStmts.add(this.uniqueNamesAST);
   
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testLinkRemovedEventManages( ) {
        Notification noti = NotificationHelper.createReferenceRemoveNotification( this.aDepartment, this.bossRef, comp.getCompanyFactory().createEmployee() );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.bossIsOldestAST);
        
        assertTrue ( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected
     * statements to a set of expected affected statements.
     */
    @Test
    public void testLinkRemovedEventWorksIn( ) {
        Notification noti = NotificationHelper.createReferenceRemoveNotification( this.aDepartment, this.employeeRef, this.aEmployee );
        
        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        //added by bp2009
        expectedStmts.add(this.uniqueNamesAST);
        
        assertTrue( checkAffectedStatements( affectedStmts, expectedStmts ) );
    }

    /**
     * @param noti a {@link Notification} including a model change
     * @return the {@link OCLExpression<EClassifier>}s which are affected by the given {@link Notification}
     */
    private HashSet<OCLExpression> filterStatementsForNotification(Notification noti) {
        HashSet<OCLExpression> affectedStmts = new HashSet<OCLExpression>();
        
        for(Iterator<OCLExpression> i = this.stmts.iterator(); i.hasNext();){
            OCLExpression exp = i.next();
            EventFilter filter = this.ia.createFilterForQuery(exp, true); 
            if (filter.matchesFor(noti)){
                affectedStmts.add(exp);
            }
        }
        return affectedStmts;
    }

    /**
     * @param iaResult
     * @param expectedAffectedStmts
     * @return <tt>true</tt> if each {@link OCLExpression} in
     * <tt>expectedAffectedStmts</tt> is contained in
     * <tt>iaResult</tt> and vice versa.
     */
    private boolean checkAffectedStatements( Set<OCLExpression> iaResult, Set<OCLExpression> expectedAffectedStmts ) {
    
        if ( iaResult.size( ) != expectedAffectedStmts.size( ) ) {
            return false;
        }
        Set<OCLExpression> affectedStmts = new HashSet<OCLExpression>( );
        for ( Iterator<OCLExpression> i = iaResult.iterator( ); i.hasNext( ); ) {
            affectedStmts.add( i.next( ));
        }
    
        if ( affectedStmts.containsAll( expectedAffectedStmts ) ) {
            return true;
        }
        return false;
    
    }
}