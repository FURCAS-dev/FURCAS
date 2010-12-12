/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.tests.filterSynthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.LogicalOperationFilter;
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationHelper;
import org.eclipse.ocl.examples.impactanalyzer.filterSynthesis.FilterSynthesisImpl;
import org.eclipse.ocl.examples.impactanalyzer.impl.OCLFactoryImpl;
import org.eclipse.ocl.examples.impactanalyzer.testutils.BaseDepartmentTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Employee;
import company.Student;


/**
 * Class scope analysis test
 */
public class FilterSynthesisTest extends BaseDepartmentTest {
    protected final Set<ExpressionInOCL> stmts = new HashSet<ExpressionInOCL>();

    @Override
    @Before
    public void setUp() {
        super.setUp();
        // create some instances
        this.createInstances(1, 5, 1);
        if (this.stmts.isEmpty()) {
            this.stmts.add(this.getNotBossFreelanceAST());
            this.stmts.add(this.getValidAssignmentAST());
            this.stmts.add(this.getUniqueNamesAST());
            this.stmts.add(this.getOldEmployeeAST());
            this.stmts.add(this.getBossHighestSalaryAST());
            this.stmts.add(this.getBossIsOldestAST());
            this.stmts.add(this.getMaxJuniorsAST());
            this.stmts.add(this.getExpensesRestrictionAST());
            this.stmts.add(this.getNastyConstraintAST());
            this.stmts.add(this.getDivisionBossSecretaryAST());
            this.stmts.add(this.getSecretaryOlderThanBossAST());
            this.stmts.add(this.getBoss10YearsOlderThanJuniorAST());
        }
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventAge() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge, 23, 42);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testAttributeValueChangedEventAssignment() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.freelanceAssignment, 23,
                42);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getValidAssignmentAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventName() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeName, "Hinz",
                "Kunz");

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getUniqueNamesAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventSalary() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeSalary, 1234, 1234);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testAttributeValueChangedEventBudget() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, 1234,
                1234);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testAttributeValueChangedEventEmployeeBudget() {
        Notification noti = NotificationHelper.createAttributeChangeNotification(this.aDepartment, this.departmentBudget, 1234,
                4000);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
        Set<ExpressionInOCL> expectedStmts = new HashSet<ExpressionInOCL>();
        // added by bp2009
        expectedStmts.add(this.getExpensesRestrictionAST());

        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementAddedEventDepartment() {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDivision, this.departmentRef, comp
                .getCompanyFactory().createDepartment());

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testElementAddedEventEmployee() {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp
                .getCompanyFactory().createEmployee());

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testElementAddedEventFreelance() {
        Notification noti = NotificationHelper.createElementAddNotification(this.aDepartment, this.employeeRef, comp
                .getCompanyFactory().createFreelance());

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
        Set<ExpressionInOCL> missing = new HashSet<ExpressionInOCL>(expectedStmts);
        missing.removeAll(affectedStmts);
        assertTrue(checkAffectedStatements(affectedStmts, expectedStmts));
    }

    /**
     * Sends a {@link Notification} to IA and compares the returned affected statements to a set of expected affected statements.
     */
    @Test
    public void testElementRemovedEventDepartment() {
        Notification noti = NotificationHelper.createElementDeleteNotification(this.aDepartment);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testElementRemovedEventEmployee() {
        Notification noti = NotificationHelper.createElementDeleteNotification(this.aEmployee);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testElementRemovedEventFreelance() {

        Notification noti = NotificationHelper.createElementDeleteNotification(this.aFreelance);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testLinkAddedEventManages() {
        Employee e = comp.getCompanyFactory().createEmployee();
        e.setEmployer(this.aDepartment);
        Notification noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, e);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testLinkAddedEventWorksIn() {
        Notification noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.employeeRef, comp
                .getCompanyFactory().createEmployee());

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testLinkRemovedEventManages() {
        Notification noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, comp
                .getCompanyFactory().createEmployee());

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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
    public void testLinkRemovedEventWorksIn() {
        Notification noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.employeeRef,
                this.aEmployee);

        HashSet<ExpressionInOCL> affectedStmts = filterStatementsForNotification(noti);
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

    @Test
    public void testFilterConsistencyClassBased() {
        for (ExpressionInOCL exp : this.stmts) {
            EventFilter f = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer((OCLExpression) exp.getBodyExpression(),
                    (EClass) exp.getContextVariable().getType(), /* notifyOnNewContextElements */true, new OCLFactoryImpl())
                    .createFilterForExpression();
            assertAllReferencesInPackage(f, this.comp);
            assertAllClassesOfClassFiltersInPackage(f, this.comp);
        }
    }

    @Test
    public void testInsertEventForSubtreeInsertion() {
        rs.getResources().iterator().next().getContents().add(aDivision);
        final List<Notification> notifications = new ArrayList<Notification>();
        Adapter listener = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification notification) {
                notifications.add(notification);
            }
        };
        EventManager eventManager = EventManagerFactory.eINSTANCE.getEventManagerFor(rs);
        EventFilter filter = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(
                (OCLExpression) getSimpleAllInstancesAST().getBodyExpression(), CompanyPackage.eINSTANCE.getEmployee(), /* notifyOnNewContextElements */
                false, new OCLFactoryImpl()).createFilterForExpression();
        eventManager.subscribe(filter, listener);

        // now construct subtree that contains an Employee subclass's instance:
        Department parentDepartment = CompanyFactory.eINSTANCE.createDepartment();
        parentDepartment.setName("Parent department");
        Department subDepartment = CompanyFactory.eINSTANCE.createDepartment();
        subDepartment.setName("Subdepartment");
        parentDepartment.getSubDepartment().add(subDepartment);

        Student student = CompanyFactory.eINSTANCE.createStudent();
        student.setName("The New Student");
        subDepartment.getEmployee().add(student); // this shouldn't trigger the listener because container is not yet in
                                                  // ResourceSet
        // not add department to a container object which is contained in the ResourceSet
        this.aDivision.getDepartment().add(parentDepartment);
        assertEquals(1, notifications.size());
        assertEquals(Notification.ADD, notifications.get(0).getEventType());
        assertEquals(subDepartment, notifications.get(0).getNotifier());
        assertEquals(student, notifications.get(0).getNewValue());
        assertNotNull(eventManager); // ensure it's not garbage-collected
        assertNotNull(listener); // ensure it's not garbage-collected
    }

    /**
     * Tests if the {@link FilterSynthesisImpl} collects derived properties when walking an expression that contains a
     * {@link PropertyCallExp} referring to a derived property.
     */
    @Test
    public void testDerivedPropertyCollection() {
        OCL ocl = OCLFactory.INSTANCE.createOCL(DefaultOppositeEndFinder.getInstance());
        FilterSynthesisImpl filtersyn = new FilterSynthesisImpl((OCLExpression) this.getLimitEmployeesOfTheMonthAST()
                .getBodyExpression(), false, ocl);
        Map<OCLExpression, Set<PropertyCallExp>> derivedProperties = filtersyn.getDerivedProperties();
        OCLExpression derivationExp = SettingBehavior.INSTANCE.getFeatureBody(ocl, divisionEmployeesOfTheMonth);
        Set<PropertyCallExp> derivationCalls = derivedProperties.get(derivationExp);

        assertTrue(derivedProperties.size() == 1);
        assertTrue(derivedProperties.containsKey(derivationExp));
        assertTrue(derivationCalls.size() == 1);
    }

    /**
     * Tests the nested scenario of {@link FilterSynthesisTest#testDerivedPropertyCollection()}. The derivation expression of the
     * accessed property now contains another {@link PropertyCallExp} referencing a derived property.
     */
    @Test
    public void testNestedDerivations() {
        OCL ocl = OCLFactory.INSTANCE.createOCL(DefaultOppositeEndFinder.getInstance());
        FilterSynthesisImpl filtersyn = new FilterSynthesisImpl(
                (OCLExpression) this.getNestedDerivationAST().getBodyExpression(), false, ocl);
        Map<OCLExpression, Set<PropertyCallExp>> derivedProperties = filtersyn.getDerivedProperties();
        OCLExpression derivationExp1 = SettingBehavior.INSTANCE.getFeatureBody(ocl, divisionEmployeesOfTheMonth);
        OCLExpression derivationExp2 = SettingBehavior.INSTANCE.getFeatureBody(ocl, numberEmployeesOfTheMonth);
        Set<PropertyCallExp> derivationCalls1 = derivedProperties.get(derivationExp1);
        Set<PropertyCallExp> derivationCalls2 = derivedProperties.get(derivationExp2);

        assertTrue(derivedProperties.size() == 2);
        assertTrue(derivedProperties.containsKey(derivationExp1));
        assertTrue(derivedProperties.containsKey(derivationExp2));
        assertTrue(derivationCalls1.size() == 1);
        assertTrue(derivationCalls2.size() == 1);
    }

    /**
     * Tests the multi usage scenario of {@link FilterSynthesisTest#testDerivedPropertyCollection()}. Multiple
     * {@link PropertyCallExp}s are referencing the same derived property.
     */
    @Test
    public void testMultipleDerivationUsage() {
        OCL ocl = OCLFactory.INSTANCE.createOCL(DefaultOppositeEndFinder.getInstance());
        FilterSynthesisImpl filtersyn = new FilterSynthesisImpl(
                (OCLExpression) this.getEotmDeltaMaxAST().getBodyExpression(), false, ocl);
        Map<OCLExpression, Set<PropertyCallExp>> derivedProperties = filtersyn.getDerivedProperties();
        OCLExpression derivationExp1 = SettingBehavior.INSTANCE.getFeatureBody(ocl, divisionEmployeesOfTheMonth);
        OCLExpression derivationExp2 = SettingBehavior.INSTANCE.getFeatureBody(ocl, numberEmployeesOfTheMonth);
        OCLExpression derivationExp3 = SettingBehavior.INSTANCE.getFeatureBody(ocl, eotmDelta);
        Set<PropertyCallExp> derivationCalls1 = derivedProperties.get(derivationExp1);
        Set<PropertyCallExp> derivationCalls2 = derivedProperties.get(derivationExp2);
        Set<PropertyCallExp> derivationCalls3 = derivedProperties.get(derivationExp3);
        
        assertTrue(derivedProperties.size() == 3);
        assertTrue(derivedProperties.containsKey(derivationExp1));
        assertTrue(derivedProperties.containsKey(derivationExp2));
        assertTrue(derivedProperties.containsKey(derivationExp3));
        assertTrue(derivationCalls1.size() == 1);
        assertTrue(derivationCalls2.size() == 4);
        assertTrue(derivationCalls3.size() == 1);
    }

    private void assertAllClassesOfClassFiltersInPackage(EventFilter f, CompanyPackage comp) {
        if (f instanceof LogicalOperationFilter) {
            for (EventFilter o : ((LogicalOperationFilter) f).getOperands()) {
                assertAllClassesOfClassFiltersInPackage(o, comp);
            }
        } else if (f instanceof ClassFilter) {
            EClass wantedClass = ((ClassFilter) f).getWantedClass();
            assertTrue("ClassFilter :::" + f + " has a NULL class", wantedClass != null);
            assertTrue("ClassFilter :::" + f + " has a class which has no Package ::" + wantedClass,
                    wantedClass.getEPackage() != null);
            assertTrue("ClassFilter :::" + f + "contains an unexpected Class ::" + wantedClass,
                    wantedClass.getEPackage().equals(comp));
        }
    }

    private void assertAllReferencesInPackage(EventFilter f, CompanyPackage comp) {
        if (f instanceof LogicalOperationFilter) {
            for (EventFilter o : ((LogicalOperationFilter) f).getOperands()) {
                assertAllReferencesInPackage(o, comp);
            }
        } else if (f instanceof AssociationFilter) {
            assertTrue("AssociationFilter :::" + f + " has a NULL reference", ((StructuralFeatureFilter) f).getFeature() != null);
            EClass wantedClass = ((StructuralFeatureFilter) f).getFeature().getEContainingClass();
            assertTrue("AssociationFilter :::" + f + " has a reference which is not contained in a class", wantedClass != null);
            assertTrue("AssociationFilter :::" + f + " has a reference which is contained in a class which has no Package ::"
                    + wantedClass, wantedClass.getEPackage() != null);
            assertTrue("AssociationFilter :::" + f + "has a reference which is contained in a class which is unexpected ::"
                    + wantedClass, wantedClass.getEPackage().equals(comp));
        }

    }

    /**
     * @param noti
     *            a {@link Notification} including a model change
     * @return the {@link OCLExpression}s which are affected by the given {@link Notification}
     */
    private HashSet<ExpressionInOCL> filterStatementsForNotification(Notification noti) {
        Set<ExpressionInOCL> statements = this.stmts;
        return filterStatementsForNotification(noti, statements);
    }

    private HashSet<ExpressionInOCL> filterStatementsForNotification(Notification noti, Set<ExpressionInOCL> statements) {
        HashSet<ExpressionInOCL> affectedStmts = new HashSet<ExpressionInOCL>();
        for (Iterator<ExpressionInOCL> i = statements.iterator(); i.hasNext();) {
            ExpressionInOCL exp = i.next();
            EventFilter filter = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer((OCLExpression) exp.getBodyExpression(),
                    (EClass) exp.getContextVariable().getType(), /* notifyOnNewContextElements */true, new OCLFactoryImpl())
                    .createFilterForExpression();
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
    protected boolean checkAffectedStatements(Set<ExpressionInOCL> iaResult, Set<ExpressionInOCL> expectedAffectedStmts) {
        if (iaResult.size() != expectedAffectedStmts.size()) {
            printDifferences(iaResult, expectedAffectedStmts);
            return false;
        }
        if (iaResult.containsAll(expectedAffectedStmts)) {
            return true;
        }
        printDifferences(iaResult, expectedAffectedStmts);

        return false;
    }

    private void printDifferences(Set<ExpressionInOCL> iaResult, Set<ExpressionInOCL> expectedAffectedStmts) {
        HashSet<ExpressionInOCL> toMuch = new HashSet<ExpressionInOCL>(iaResult);
        toMuch.removeAll(expectedAffectedStmts);

        HashSet<ExpressionInOCL> toLess = new HashSet<ExpressionInOCL>(expectedAffectedStmts);
        toLess.removeAll(iaResult);

        System.err.println("Got more as expected:" + toMuch.size());
        print(toMuch);
        System.err.println("Got less as expected:" + toLess.size());
        print(toLess);

    }

    private void print(HashSet<ExpressionInOCL> toMuch) {
        for (ExpressionInOCL o : toMuch) {
            System.out.println();
            try {
                System.out.print(o.getContextVariable().getType().getName() + " : ");
            } catch (Exception e) {
            }
            System.out.print(o.getBodyExpression());
        }

    }
}
