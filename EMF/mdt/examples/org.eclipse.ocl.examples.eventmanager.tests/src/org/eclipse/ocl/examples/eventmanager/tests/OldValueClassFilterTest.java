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
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilter;
import org.eclipse.ocl.examples.testutils.NotificationHelper;

import company.CompanyFactory;
import company.Employee;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Old Value Class Filter</b></em>'. <!-- end-user-doc -->
 */
public class OldValueClassFilterTest extends EventFilterTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(OldValueClassFilterTest.class);
    }

    /**
     * Constructs a new Old Value Class Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public OldValueClassFilterTest() {
        super();
    }

    private Notification noti;

    /**
     * Returns the fixture for this Old Value Class Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    @Override
    protected OldValueClassFilter getFixture() {
        return (OldValueClassFilter) fixture;
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
        setFixture(EventManagerFactory.eINSTANCE.createOldValueClassFilter(employee));
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
        this.aDepartment.setBoss(boss);
        noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, boss);
        assertTrue("No Match to Notification", getFixture().matchesFor(noti));
        noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, boss);
        assertFalse(getFixture().matchesFor(noti));
        this.aDivision.getDepartment().clear();
        noti = NotificationHelper.createReferenceAddNotification(this.aDivision, this.departmentRef,
                CompanyFactory.eINSTANCE.createDepartment());
        assertFalse(getFixture().matchesFor(noti));
    }

    public void testMatchesFor__NotificationNotIncludingSubclasses() {
        Employee boss = CompanyFactory.eINSTANCE.createFreelance();
        this.aDepartment.setBoss(boss);
        noti = NotificationHelper.createReferenceRemoveNotification(this.aDepartment, this.bossRef, boss);
        assertFalse("Subclass should not have been matched", getFixture().matchesFor(noti));
        noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef, boss);
        assertFalse(getFixture().matchesFor(noti));
        this.aDivision.getDepartment().clear();
    }
} // OldValueClassFilterTest
