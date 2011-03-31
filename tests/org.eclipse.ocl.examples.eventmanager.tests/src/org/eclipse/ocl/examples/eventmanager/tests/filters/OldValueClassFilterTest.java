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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilter;
import org.junit.Test;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Old Value Class Filter</b></em>'. <!-- end-user-doc -->
 */
public class OldValueClassFilterTest extends ClassFilterTest {

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
	private EClass cls;

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
    	cls = EcoreFactory.eINSTANCE.createEClass();
    	cls.setName("my class");
    	
    	setFixture(EventManagerFactory.eINSTANCE.createOldValueClassFilter(cls));
    }
    @Override
    public void testMatchesFor__Notification() {
    	noti = new ENotificationImpl(null, Notification.ADD, null, new DynamicEObjectImpl(cls), null);
        assertTrue("exact class match", getFixture().matchesFor(noti));
        noti = new ENotificationImpl(null, Notification.ADD, null, null, EcoreFactory.eINSTANCE.createEClass());
        assertFalse(getFixture().matchesFor(noti));
    }

    /**
     * {@link OldValueClassFilter this filter} does not supports subclasses 
     */
    @Test
    public void testMatchesFor__SubclassNotification() {
   	
    	EClass childCls = EcoreFactory.eINSTANCE.createEClass();
    	childCls.setName("child");
    	childCls.getESuperTypes().add(cls);
    	noti = new ENotificationImpl(null, Notification.ADD, null, new DynamicEObjectImpl(childCls), null);
        assertFalse("exact class match", getFixture().matchesFor(noti));
    }
	EClass testCls = EcoreFactory.eINSTANCE.createEClass();
	@Override
	public Notification[] giveMatchingNotifications() {
		EList<EObject> list = new BasicEList<EObject>();
		list.add(new DynamicEObjectImpl(testCls));
		return new Notification[]{ new ENotificationImpl(null, 0, null, new DynamicEObjectImpl(testCls), null),
				new ENotificationImpl(null, 0, null, list, null)};
	}
	@Override
	public Notification giveNotMatchingNotifcation() {
		EClass otherCls = EcoreFactory.eINSTANCE.createEClass();
		return new ENotificationImpl(null, 0, null, new DynamicEObjectImpl(otherCls), null);
	}
	@Override
	public EventFilter giveTestFilter() {
		return EventManagerFactory.eINSTANCE.createOldValueClassFilter(testCls);
	}
} // OldValueClassFilterTest
