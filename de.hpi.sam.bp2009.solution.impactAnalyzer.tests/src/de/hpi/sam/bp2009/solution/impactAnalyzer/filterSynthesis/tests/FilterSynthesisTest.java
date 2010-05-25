package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyPackage;
import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.filters.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.StructuralFeatureFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * Class scope analysis test
 */
public class FilterSynthesisTest extends BaseDepartmentTest {

    protected ImpactAnalyzer ia;

    protected final Set<OCLExpression> stmts = new HashSet<OCLExpression>();

    @Override
    @Before
    public void setUp() {

        super.setUp();
        // create some instances
        this.createInstances(1, 5, 1);

        if (this.stmts.isEmpty()) {
            this.stmts.add(this.notBossFreelanceAST);
            this.stmts.add(this.validAssignmentAST);
            this.stmts.add(this.uniqueNamesAST);
            this.stmts.add(this.oldEmployeeAST);
            this.stmts.add(this.bossHighestSalaryAST);
            this.stmts.add(this.bossIsOldestAST);
            this.stmts.add(this.maxJuniorsAST);
            this.stmts.add(this.expensesRestrictionAST);
            this.stmts.add(this.nastyConstraintAST);
            this.stmts.add(this.divisionBossSecretaryAST);
            this.stmts.add(this.secretaryOlderThanBossAST);
            this.stmts.add(this.boss10YearsOlderThanJuniorAST);
        }
        if (this.ia == null) {
            this.ia = new ImpactAnalyzerImpl();
            Iterator<OCLExpression> i = this.stmts.iterator();
            while (i.hasNext()) {
                OCLExpression exp = i.next();
                // filter isn't saved, because this is done for caching purpose only
                this.ia.createFilterForExpression(exp, true);
            }
        }
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
        this.stmts.clear();
        this.ia = null;
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAge() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, new Long(23),
                new Long(42));

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossIsOldestAST);
        expectedStmts.add(this.maxJuniorsAST);
        // added by bp2009
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAssignment() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment,
                new Long(23), new Long(42));

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.validAssignmentAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventName() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeName, "Hinz",
                "Kunz");

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventSalary() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeSalary, new Long(
                1234), new Long(1234));

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.nastyConstraintAST);
        // added by bp2009
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventBudget() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget,
                new Long(1234), new Long(1234));

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventEmployeeBudget() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget,
                new Long(1234), new Long(4000));

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        // added by bp2009
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventDepartment() {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDivision, this.departmentRef, comp
                .getCompanyFactory().createDepartment());

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        // added by bp2009
        expectedStmts.add(this.expensesRestrictionAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventEmployee() {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp
                .getCompanyFactory().createEmployee());

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.bossIsOldestAST);
        // added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.divisionBossSecretaryAST);
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventFreelance() {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp
                .getCompanyFactory().createFreelance());

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.validAssignmentAST);
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.bossIsOldestAST);
        // added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.divisionBossSecretaryAST);
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventDepartment() {
        Notification noti = NotificationHelper.createElementDeleteNotification(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        // added by bp2009
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.expensesRestrictionAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventEmployee() {
        Notification noti = NotificationHelper.createElementDeleteNotification(this.aEmployee);

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        // added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.divisionBossSecretaryAST);
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventFreelance() {

        Notification noti = NotificationHelper.createElementDeleteNotification(this.aFreelance);

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);
        // added by bp2009
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        expectedStmts.add(this.validAssignmentAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.divisionBossSecretaryAST);
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkAddedEventManages() {
        Employee e = comp.getCompanyFactory().createEmployee();
        e.setEmployer(this.aDepartment);
        Notification noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, e);

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.bossIsOldestAST);
        // added by bp2009
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.expensesRestrictionAST);
        // not expected because boss is not containment and
        // this stmt is affected at creation of new employees and name change
        // expectedStmts.add(this.uniqueNamesAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkAddedEventWorksIn() {
        Notification noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.employeeRef, comp
                .getCompanyFactory().createEmployee());

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        // added by bp2009
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.divisionBossSecretaryAST);
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkRemovedEventManages() {
        Notification noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, comp
                .getCompanyFactory().createEmployee());

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.notBossFreelanceAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.bossIsOldestAST);
        // added by bp2009
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkRemovedEventWorksIn() {
        Notification noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.employeeRef,
                this.aEmployee);

        HashSet<OCLExpression> affectedStmts = filterStatementsForNotification(noti);
        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.oldEmployeeAST);
        expectedStmts.add(this.bossHighestSalaryAST);
        expectedStmts.add(this.maxJuniorsAST);
        expectedStmts.add(this.bossIsOldestAST);
        // added by bp2009
        expectedStmts.add(this.uniqueNamesAST);
        expectedStmts.add(this.nastyConstraintAST);
        expectedStmts.add(this.boss10YearsOlderThanJuniorAST);
        expectedStmts.add(this.divisionBossSecretaryAST);
        expectedStmts.add(this.secretaryOlderThanBossAST);
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    @Test
    public void testFilterConsistencyClassBased() {
        for(OCLExpression exp : this.stmts){
            EventFilter f = this.ia.createFilterForExpression(exp, true);
            assertAllReferencesInPackage(f, this.comp);
            assertAllClassesOfClassFiltersInPackage(f, this.comp);
        }
    }
    


    private void assertAllClassesOfClassFiltersInPackage(EventFilter f, CompanyPackage comp) {
        if(f instanceof LogicalOperationFilter){
            for(EventFilter o: ((LogicalOperationFilter)f).getOperands()){
                assertAllClassesOfClassFiltersInPackage(o, comp);
            }
        }else if(f instanceof ClassFilter){
            EClass wantedClass = ((ClassFilter) f).getWantedClass();
            assertTrue("ClassFilter :::"+f+" has a NULL class", wantedClass!=null);
            assertTrue("ClassFilter :::"+f+" has a class which has no Package ::"+wantedClass, wantedClass.getEPackage()!=null);
            assertTrue("ClassFilter :::"+f+"contains an unexpected Class ::"+wantedClass,wantedClass.getEPackage().equals(comp));
        }
    }

    private void assertAllReferencesInPackage(EventFilter f, CompanyPackage comp) {
        if(f instanceof LogicalOperationFilter){
            for(EventFilter o: ((LogicalOperationFilter)f).getOperands()){
               assertAllReferencesInPackage(o, comp);
            }
        }else if(f instanceof AssociationFilter){
            assertTrue("AssociationFilter :::"+f+" has a NULL reference", ((StructuralFeatureFilter) f).getFeature()!=null);
            EClass wantedClass = ((StructuralFeatureFilter) f).getFeature().getEContainingClass();
            assertTrue("AssociationFilter :::"+f+" has a reference which is not contained in a class", wantedClass!=null);
            assertTrue("AssociationFilter :::"+f+" has a reference which is contained in a class which has no Package ::"+wantedClass, wantedClass.getEPackage()!=null);
            assertTrue("AssociationFilter :::"+f+"has a reference which is contained in a class which is unexpected ::" + wantedClass, wantedClass.getEPackage().equals(comp));
        }
        
    }

    /**
     * @param noti
     *            a {@link Notification} including a model change
     * @return the {@link OCLExpression}s which are affected by the given {@link Notification}
     */
    private HashSet<OCLExpression> filterStatementsForNotification(Notification noti) {
        HashSet<OCLExpression> affectedStmts = new HashSet<OCLExpression>();

        for (Iterator<OCLExpression> i = this.stmts.iterator(); i.hasNext();) {
            OCLExpression exp = i.next();
            EventFilter filter = this.ia.createFilterForExpression(exp, true);
            if (filter.matchesFor(noti)) {
                affectedStmts.add(exp);
            }
        }
        return affectedStmts;
    }
    /**
     * @param iaResult
     * @param expectedAffectedStmts
     * @return <tt>true</tt> if each {@link OCLExpression} in <tt>expectedAffectedStmts</tt> is contained in <tt>iaResult</tt> and
     *         vice versa.
     */
    protected boolean checkAffectedStatements(Set<OCLExpression> iaResult, Set<OCLExpression> expectedAffectedStmts) {
        if (iaResult.size() != expectedAffectedStmts.size()) {
            return false;
        }
        if (iaResult.containsAll(expectedAffectedStmts)) {
            return true;
        }
        return false;
    }
}