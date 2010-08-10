package de.hpi.sam.bp2009.solution.eventManager.tests.framework;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.Division;
import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;

public class RecursiveContaimentNotificationCreatorTest extends BaseDepartmentTest{

    @Before
    public void setUp() {
        super.setUp();
        super.createInstances(3, 5, 6);
    }

    @After
    public void tearDown(){
        super.tearDown();
    }

    @Test
    public void testCreateNotificationForComposites() {
        Division div = CompanyFactory.eINSTANCE.createDivision();
        Employee aEmployee2 = CompanyFactory.eINSTANCE.createEmployee();
        div.setDirector(aEmployee2);
        aEmployee2.setSecretary(CompanyFactory.eINSTANCE.createEmployee());
        Notification event = NotificationHelper.createElementAddNotification(div, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
        Collection<Notification> list = EventManagerFactory.eINSTANCE.createNotificationForComposites(event);
        /*
         * Expect
         * SET for departement budget
         * SET for departement maxJuniors
         * ADD departement to devision
         */
        assertTrue("Get "+list.size()+" events, expected 3",list.size()==3);
    }
    @Test
    public void testCreateNotificationForComposite() {
        Division div = CompanyFactory.eINSTANCE.createDivision();
        Notification event = NotificationHelper.createElementAddNotification(div, directedRef.getEOpposite(), CompanyFactory.eINSTANCE.createEmployee());
        Collection<Notification> list = EventManagerFactory.eINSTANCE.createNotificationForComposites(event);
        /*
         * Expected
         * SET employee as division director
         * SET division as directed by employee
         * SET employee name
         * SET employee age
         */
        assertTrue("Get "+list.size()+" events, expected 4",list.size()==4);
    }

}
