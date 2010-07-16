/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;

import company.CompanyFactory;
import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>New Value Class Filter</b></em>'. <!-- end-user-doc -->
 */
public class NewValueClassFilterTest extends EventFilterTest {

    private Notification noti;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(NewValueClassFilterTest.class);
    }

    /**
     * Constructs a new New Value Class Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public NewValueClassFilterTest() {
        super();
    }

    /**
     * Returns the fixture for this New Value Class Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    @Override
    protected NewValueClassFilter getFixture() {
        return (NewValueClassFilter) fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        super.setUp();
        this.createInstances(1, 5, 1);
        setFixture(EventManagerFactory.eINSTANCE.createNewValueClassFilter(employee, /* includeSubclasses */false));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        setFixture(null);
        super.tearDown();
    }

    @Override
    public void testMatchesFor__Notification() {
        Employee boss = CompanyFactory.eINSTANCE.createEmployee();
        noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, boss);
        assertTrue("No Match to Notification", getFixture().matchesFor(noti));
        noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, boss);
        assertFalse(getFixture().matchesFor(noti));
        this.aDivision.getDepartment().clear();
        noti = NotificationHelper.createReferenceAddNotification(this.aDivision, this.departmentRef,
                CompanyFactory.eINSTANCE.createDepartment());
        assertFalse(getFixture().matchesFor(noti));
    }

} // NewValueClassFilterTest
