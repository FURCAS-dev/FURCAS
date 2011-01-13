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
package org.eclipse.ocl.examples.eventmanager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilter;
import org.eclipse.ocl.examples.testutils.NotificationHelper;
import org.junit.Test;

import company.CompanyFactory;
import company.Employee;


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
        setFixture(EventManagerFactory.eINSTANCE.createNewValueClassFilter(employee));
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
        assertTrue("exact class match", getFixture().matchesFor(noti));
        noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, boss);
        assertFalse(getFixture().matchesFor(noti));
        this.aDivision.getDepartment().clear();
        noti = NotificationHelper.createReferenceAddNotification(this.aDivision, this.departmentRef,
                CompanyFactory.eINSTANCE.createDepartment());
        assertFalse(getFixture().matchesFor(noti));
    }

    @Test
    public void testMatchesFor__SubclassNotification() {
        Employee boss = CompanyFactory.eINSTANCE.createFreelance();
        noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, boss);
        assertFalse("Should not have matched for subclass", getFixture().matchesFor(noti));
        noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, boss);
        assertFalse(getFixture().matchesFor(noti));
        this.aDivision.getDepartment().clear();
        noti = NotificationHelper.createReferenceAddNotification(this.aDivision, this.departmentRef,
                CompanyFactory.eINSTANCE.createDepartment());
        assertFalse(getFixture().matchesFor(noti));
    }

} // NewValueClassFilterTest
