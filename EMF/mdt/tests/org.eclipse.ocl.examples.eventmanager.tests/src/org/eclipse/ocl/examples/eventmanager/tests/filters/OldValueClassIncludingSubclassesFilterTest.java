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
package org.eclipse.ocl.examples.eventmanager.tests.filters;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilterIncludingSubclasses;
import org.junit.Test;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Old Value Class Filter</b></em>'. <!-- end-user-doc -->
 */
public class OldValueClassIncludingSubclassesFilterTest extends ClassFilterTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(OldValueClassIncludingSubclassesFilterTest.class);
    }

    /**
     * Constructs a new Old Value Class Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public OldValueClassIncludingSubclassesFilterTest() {
        super();
    }

    private Notification noti;
	private EClass cls;

    /**
     * Returns the fixture for this Old Value Class Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    @Override
    protected OldValueClassFilterIncludingSubclasses getFixture() {
        return (OldValueClassFilterIncludingSubclasses) fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        super.setUp();
    	cls = EcoreFactory.eINSTANCE.createEClass();
    	cls.setName("my class");
    	
    	setFixture(EventManagerFactory.eINSTANCE.createOldValueClassFilterIncludingSubclasses(cls));    }


    @Override
    public void testMatchesFor__Notification() {
    	noti = new ENotificationImpl(null, Notification.ADD, null, new DynamicEObjectImpl(cls), null);
        assertTrue("exact class match", getFixture().matchesFor(noti));
        noti = new ENotificationImpl(null, Notification.ADD, null, null, EcoreFactory.eINSTANCE.createEClass());
        assertFalse(getFixture().matchesFor(noti));
    }

    /**
     * {@link NewValueClassFilterIncludingSubclasses this filter} supports subclasses 
     */
    @Test
    public void testMatchesFor__SubclassNotification() {
    	EClass childCls = EcoreFactory.eINSTANCE.createEClass();
    	childCls.setName("child");
    	
    	childCls.getESuperTypes().add(cls);
    	
    	noti = new ENotificationImpl(null, Notification.ADD, null, new DynamicEObjectImpl(childCls), null);
        assertTrue("exact class match", getFixture().matchesFor(noti));
    }

} // OldValueClassFilterTest
