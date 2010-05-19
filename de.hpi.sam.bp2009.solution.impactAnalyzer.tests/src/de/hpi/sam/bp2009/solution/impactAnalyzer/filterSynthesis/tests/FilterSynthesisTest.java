package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.ExampleApp;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * Class scope analysis test
 */
public class FilterSynthesisTest extends BaseDepartmentTest {

    private ImpactAnalyzer ia;

    private final Set<OCLExpression> stmts = new HashSet<OCLExpression>();

    @Override
    @Before
    public void setUp() {

        super.setUp();
        this.eS = new HashSet<ExampleApp>();
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
        this.eS = null;
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

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAgeEventManager() {
        comp.eResource().getContents().add(this.aEmployee);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();
        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, new Long(23),
                new Long(42));

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
    public void testAttributeValueChangedEventAssignmentEventManager() {
        comp.eResource().getContents().add(this.aFreelance);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment, new Long(23),
                new Long(42));

        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.validAssignmentAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventNameEventManagerEventManager() {
        comp.eResource().getContents().add(this.aEmployee);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeName, "Hinz", "Kunz");

        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.uniqueNamesAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventSalaryEventManager() {
        comp.eResource().getContents().add(this.aEmployee);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeSalary, new Long(1234), new Long(1234));

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
    public void testAttributeValueChangedEventBudgetEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, new Long(1234), new Long(
                1234));

        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventEmployeeBudgetEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, new Long(1234), new Long(
                4000));

        Set<OCLExpression> expectedStmts = new HashSet<OCLExpression>();
        // added by bp2009
        expectedStmts.add(this.expensesRestrictionAST);

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventDepartmentEventManager() {
        comp.eResource().getContents().add(this.aDivision);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementAddNotification(this.aDivision, this.departmentRef, comp.getCompanyFactory()
                .createDepartment());

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
    public void testElementAddedEventEmployeeEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory()
                .createEmployee());

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
    public void testElementAddedEventFreelanceEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory()
                .createFreelance());

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
    public void testElementRemovedEventDepartmentEventManager() {
        comp.eResource().getContents().add(this.aDivision);
        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(this.aDepartment);

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
    public void testElementRemovedEventEmployeeEventManager() {
        comp.eResource().getContents().add(this.aDivision);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(this.aEmployee);

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
    public void testElementRemovedEventFreelanceEventManager() {
        comp.eResource().getContents().add(this.aDivision);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(this.aFreelance);

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
    public void testLinkAddedEventManagesInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);
        Employee e = comp.getCompanyFactory().createEmployee();
        e.setEmployer(this.aDepartment);
        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();


        NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, e);

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
    public void testLinkAddedEventWorksInInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createReferenceAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory()
                .createEmployee());

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
    public void testLinkRemovedEventManagesInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, comp.getCompanyFactory()
                .createEmployee());

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
    public void testLinkRemovedEventWorksInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.employeeRef, this.aEmployee);

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
     * @param noti
     *            a {@link Notification} including a model change
     * @return the {@link OCLExpression}s which are affected by the given {@link Notification}
     */
    Set<ExampleApp> eS = new HashSet<ExampleApp>();

    private HashSet<OCLExpression> filterStatementsWithEM() {
        HashSet<OCLExpression> affectedStmts = new HashSet<OCLExpression>();
        EventManager m = EventManagerFactory.eINSTANCE.createEventManagerTableBased();

        for (Iterator<OCLExpression> i = this.stmts.iterator(); i.hasNext();) {
            OCLExpression exp = i.next();
            EventFilter filter = this.ia.createFilterForExpression(exp, true);
            ExampleApp app = new ExampleApp(exp, affectedStmts);
            EList<Notifier> l = new BasicEList<Notifier>();
            l.add(this.comp.eResource());
            m.subscribe(l, filter, app);
            eS.add(app);
        }
        return affectedStmts;
    }

    /**
     * @param iaResult
     * @param expectedAffectedStmts
     * @return <tt>true</tt> if each {@link OCLExpression} in <tt>expectedAffectedStmts</tt> is contained in <tt>iaResult</tt> and
     *         vice versa.
     */
    private boolean checkAffectedStatements(Set<OCLExpression> iaResult, Set<OCLExpression> expectedAffectedStmts) {
        if (iaResult.size() != expectedAffectedStmts.size()) {
            return false;
        }
        Set<OCLExpression> affectedStmts = new HashSet<OCLExpression>();
        for (Iterator<OCLExpression> i = iaResult.iterator(); i.hasNext();) {
            affectedStmts.add(i.next());
        }
        if (affectedStmts.containsAll(expectedAffectedStmts)) {
            return true;
        }
        return false;
    }
}