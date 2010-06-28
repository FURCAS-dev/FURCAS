package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import company.CompanyFactory;
import company.Department;
import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.ExampleApp;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

public class FilterSynthesisEMEnabledTest extends FilterSynthesisTest {
    private EventManager m;

    @Override
    public void setUp() {
        super.setUp();
        this.eS = new HashSet<ExampleApp>();
        // m = new EventManagerNaive(comp.eResource().getResourceSet());
        m = new EventManagerTableBased(comp.eResource().getResourceSet());
    }
    @Override
    public void tearDown() {
        for(ExampleApp app:eS){
            m.unsubscribe(app);
        }
        this.eS = null;
        this.m= null;
        super.tearDown();
      
    }
    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAgeEventManager() {
        comp.eResource().getContents().add(this.aEmployee);

        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();
        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, 23,
                42);

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

        NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment, 23,
                42);

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

        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeSalary, 1234, 1234);

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

        NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, 1234, 
                1234);

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

        NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, 1234, 
                4000);

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
        Department newDep = CompanyFactory.eINSTANCE.createDepartment();
        this.aDivision.getDepartment().add(newDep);
        HashSet<OCLExpression> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(newDep);

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
    Set<ExampleApp> eS = new HashSet<ExampleApp>();

    private HashSet<OCLExpression> filterStatementsWithEM() {
        HashSet<OCLExpression> affectedStmts = new HashSet<OCLExpression>();
        for (Iterator<OCLExpression> i = this.stmts.iterator(); i.hasNext();) {
            OCLExpression exp = i.next();
            EventFilter filter = this.ia.createFilterForExpression(exp, true);
            ExampleApp app = new ExampleApp(exp, affectedStmts);
            m.subscribe(filter, app);
            eS.add(app);
        }
        return affectedStmts;
    }
}
