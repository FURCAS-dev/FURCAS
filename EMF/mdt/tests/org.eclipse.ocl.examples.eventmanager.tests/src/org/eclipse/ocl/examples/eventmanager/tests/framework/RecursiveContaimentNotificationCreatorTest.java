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
package org.eclipse.ocl.examples.eventmanager.tests.framework;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.testutils.BaseDepartmentTest;
import org.eclipse.ocl.examples.testutils.NotificationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.Division;
import company.Employee;


public class RecursiveContaimentNotificationCreatorTest extends BaseDepartmentTest {

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
