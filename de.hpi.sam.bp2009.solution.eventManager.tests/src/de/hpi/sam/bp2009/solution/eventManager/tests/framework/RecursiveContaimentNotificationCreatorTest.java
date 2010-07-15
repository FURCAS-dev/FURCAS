package de.hpi.sam.bp2009.solution.eventManager.tests.framework;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.Division;

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
        div.setDirector(aEmployee);
        aEmployee.setSecretary(CompanyFactory.eINSTANCE.createEmployee());
        Notification event = NotificationHelper.createElementAddNotification(div, departmentRef, aDepartment);
        Collection<Notification> list = EventManagerFactory.eINSTANCE.createNotificationForComposites(event);
        assertTrue(list.size()==2);
    }
    @Test
    public void testCreateNotificationForComposite() {
        Division div = CompanyFactory.eINSTANCE.createDivision();
//        div.setDirector(aEmployee);
        Notification event = NotificationHelper.createElementAddNotification(div, directedRef.getEOpposite(), aEmployee);
        Collection<Notification> list = EventManagerFactory.eINSTANCE.createNotificationForComposites(event);
        assertTrue(list.size()==2);
    }

}
