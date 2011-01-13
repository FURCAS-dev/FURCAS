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
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;
import org.eclipse.ocl.examples.testutils.NotificationHelper;

import company.CompanyFactory;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Structural Feature Filter</b></em>'. <!-- end-user-doc -->
 */
public abstract class StructuralFeatureFilterTest extends EventFilterTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(StructuralFeatureFilterTest.class);
    }

    /**
     * Constructs a new Structural Feature Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public StructuralFeatureFilterTest() {
        super();
    }

    private Notification noti;

    /**
     * Returns the fixture for this Structural Feature Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    @Override
    protected StructuralFeatureFilter getFixture() {
        return (StructuralFeatureFilter) fixture;
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
        noti = NotificationHelper.createReferenceAddNotification(aDivision, departmentRef,
                CompanyFactory.eINSTANCE.createDepartment());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        setFixture(null);
    }

    /**
     * Tests the '
     * {@link org.eclipse.ocl.examples.eventmanager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.ocl.examples.eventmanager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__Notification() {
        EventFilter filter1 = EventManagerFactory.eINSTANCE.createAssociationFilter(this.departmentRef);
        assertTrue(filter1.matchesFor(noti));
        EventFilter filter2 = EventManagerFactory.eINSTANCE.createAssociationFilter(this.directedRef);
        assertFalse(filter2.matchesFor(noti));
    }

} // StructuralFeatureFilterTest
