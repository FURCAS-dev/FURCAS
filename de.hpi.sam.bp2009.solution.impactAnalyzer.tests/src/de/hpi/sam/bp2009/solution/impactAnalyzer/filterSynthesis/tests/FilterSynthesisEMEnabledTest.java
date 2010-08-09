package de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import company.CompanyFactory;
import company.Department;
import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.ExampleApp;

public class FilterSynthesisEMEnabledTest extends FilterSynthesisTest {
    private EventManager m;

    @Override
    public void setUp() {
        super.setUp();
        this.eS = new HashSet<ExampleApp>();
        // m = new EventManagerNaive(comp.eResource().getResourceSet());
        m = EventManagerFactory.eINSTANCE.getEventManagerFor(comp.eResource().getResourceSet());
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

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();
        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, 23,
                42);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getBossIsOldestAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        // added by bp2009
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));

    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAssignmentEventManager() {
        comp.eResource().getContents().add(this.aFreelance);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment, 23,
                42);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getValidAssignmentAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventNameEventManagerEventManager() {
        comp.eResource().getContents().add(this.aEmployee);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeName, "Hinz", "Kunz");

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getUniqueNamesAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventSalaryEventManager() {
        comp.eResource().getContents().add(this.aEmployee);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeSalary, 1234, 1234);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getNastyConstraintAST());
        // added by bp2009
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventBudgetEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, 1234, 
                1234);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventEmployeeBudgetEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, 1234, 
                4000);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        // added by bp2009
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventDepartmentEventManager() {
        comp.eResource().getContents().add(this.aDivision);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementAddNotification(this.aDivision, this.departmentRef, comp.getCompanyFactory()
                .createDepartment());

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getNotBossFreelanceAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getBossHighestSalaryAST());
        // added by bp2009
        expectedStmts.add(this.getExpensesRestrictionAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventEmployeeEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory()
                .createEmployee());

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getUniqueNamesAST());
        expectedStmts.add(this.getBossIsOldestAST());
        // added by bp2009
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getDivisionBossSecretaryAST());
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventFreelanceEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory()
                .createFreelance());

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getValidAssignmentAST());
        expectedStmts.add(this.getUniqueNamesAST());
        expectedStmts.add(this.getBossIsOldestAST());
        // added by bp2009
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getDivisionBossSecretaryAST());
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getExpensesRestrictionAST());

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
        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(newDep);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        // added by bp2009
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getNotBossFreelanceAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getExpensesRestrictionAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventEmployeeEventManager() {
        comp.eResource().getContents().add(this.aDivision);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(this.aEmployee);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getUniqueNamesAST());
        // added by bp2009
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getBossIsOldestAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getDivisionBossSecretaryAST());
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getExpensesRestrictionAST());
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventFreelanceEventManager() {
        comp.eResource().getContents().add(this.aDivision);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createElementDeleteNotification(this.aFreelance);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getUniqueNamesAST());
        // added by bp2009
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getBossIsOldestAST());
        expectedStmts.add(this.getValidAssignmentAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getDivisionBossSecretaryAST());
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getExpensesRestrictionAST());
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
        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();


        NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, e);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getNotBossFreelanceAST());
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getBossIsOldestAST());
        // added by bp2009
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getExpensesRestrictionAST());
        // not expected because boss is not containment and
        // this stmt is affected at creation of new employees and name change
        // expectedStmts.add(this.getUniqueNamesAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkAddedEventWorksInInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createReferenceAddNotification(this.aDepartment, this.employeeRef, comp.getCompanyFactory()
                .createEmployee());

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getBossIsOldestAST());
        // added by bp2009
        expectedStmts.add(this.getUniqueNamesAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getDivisionBossSecretaryAST());
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkRemovedEventManagesInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, comp.getCompanyFactory()
                .createEmployee());

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getNotBossFreelanceAST());
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getBossIsOldestAST());
        // added by bp2009
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testLinkRemovedEventWorksInEventManager() {
        comp.eResource().getContents().add(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsWithEM();

        NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.employeeRef, this.aEmployee);

        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getOldEmployeeAST());
        expectedStmts.add(this.getBossHighestSalaryAST());
        expectedStmts.add(this.getMaxJuniorsAST());
        expectedStmts.add(this.getBossIsOldestAST());
        // added by bp2009
        expectedStmts.add(this.getUniqueNamesAST());
        expectedStmts.add(this.getNastyConstraintAST());
        expectedStmts.add(this.getBoss10YearsOlderThanJuniorAST());
        expectedStmts.add(this.getDivisionBossSecretaryAST());
        expectedStmts.add(this.getSecretaryOlderThanBossAST());
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }


    /**
     * @param noti
     *            a {@link Notification} including a model change
     * @return the {@link OCLExpression}s which are affected by the given {@link Notification}
     */
    Set<ExampleApp> eS = new HashSet<ExampleApp>();

    private HashSet<ExpressionInOCL> filterStatementsWithEM() {
        HashSet<ExpressionInOCL> affectedStmts = new HashSet<ExpressionInOCL>();
        for (Iterator<ExpressionInOCL> i = this.stmts.iterator(); i.hasNext();) {
            ExpressionInOCL exp = i.next();
            EventFilter filter = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer((OCLExpression) exp.getBodyExpression(), (EClass) exp
                    .getContextVariable().getType()).createFilterForExpression(true);
            ExampleApp app = new ExampleApp(exp, affectedStmts);
            m.subscribe(filter, app);
            eS.add(app);
        }
        return affectedStmts;
    }
}
