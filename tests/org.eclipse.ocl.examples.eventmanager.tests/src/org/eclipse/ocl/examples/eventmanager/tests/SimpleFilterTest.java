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


import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.tests.EventManagerTest.Application;
import org.eclipse.ocl.examples.eventmanager.tests.filters.AssociationFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.AttributeFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.ClassFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.ContainmentFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.EventFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.EventTypeFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.NewValueClassFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.NewValueClassIncludingSubclassesFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.OldValueClassFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.OldValueClassIncludingSubclassesFilterTest;

/**
 * This class test whether the {@link EventManagerFactory#createEventManager() event manager}
 * {@link EventManager#handleEMFEvent(org.eclipse.emf.common.notify.Notification) handles} notifications right
 * @author Philipp Berger
 *
 */
public class SimpleFilterTest extends TestCase{

	private EventManager fixture;
	private Application app;

	public void setUp() throws Exception {
		fixture = EventManagerFactory.eINSTANCE.createEventManager();
		app = new Application();
	}

	public void tearDown() throws Exception {
		fixture.unsubscribe(app);
		fixture=null;
		app=null;
	}

	/**
	 * Tests whether the {@link Notification notifications} defined by
	 * the {@link EventFilterTest test} trigger the {@link EventManager manager}
	 * @param test
	 */
	public void assertHandleEmfEvent(EventFilterTest test){
		fixture.subscribe(test.giveTestFilter(), app);
		fixture.handleEMFEvent(test.giveNotMatchingNotifcation());
		assertFalse("Get wrongly notified", app.isNotified());
		app.reset();
		for(Notification n: test.giveMatchingNotifications()){
			fixture.handleEMFEvent(n);
			assertTrue("Get not notified", app.isNotified());
			app.reset();
		}
	}
	/**
	 * @see AssociationFilterTest#giveTestFilter()
	 * @see AssociationFilterTest#giveMatchingNotifications()
	 * @see AssociationFilterTest#giveNotMatchingNotifcation()
	 */
	public void testReferenceFilter(){
		assertHandleEmfEvent(new AssociationFilterTest());
	}
	/**
	 * @see AttributeFilterTest#giveTestFilter()
	 * @see AttributeFilterTest#giveMatchingNotifications()
	 * @see AttributeFilterTest#giveNotMatchingNotifcation()
	 */
	public void testAttributeFilter(){
		assertHandleEmfEvent(new AttributeFilterTest());
	}
	/**
	 * @see ClassFilterTest#giveTestFilter()
	 * @see ClassFilterTest#giveMatchingNotifications()
	 * @see ClassFilterTest#giveNotMatchingNotifcation()
	 */
	public void ClassFilter(){
		assertHandleEmfEvent(new ClassFilterTest());
	}
	/**
	 * @see ContainmentFilterTest#giveTestFilter()
	 * @see ContainmentFilterTest#giveMatchingNotifications()
	 * @see ContainmentFilterTest#giveNotMatchingNotifcation()
	 */
	public void testContainmentFilter(){
		assertHandleEmfEvent(new ContainmentFilterTest());
	}
	/**
	 * @see EventTypeFilterTest#giveTestFilter()
	 * @see EventTypeFilterTest#giveMatchingNotifications()
	 * @see EventTypeFilterTest#giveNotMatchingNotifcation()
	 */
	public void testEventTypeFilter(){
		assertHandleEmfEvent(new EventTypeFilterTest());
	}
	/**
	 * @see NewValueClassFilterTest#giveTestFilter()
	 * @see NewValueClassFilterTest#giveMatchingNotifications()
	 * @see NewValueClassFilterTest#giveNotMatchingNotifcation()
	 */
	public void testNewValueClassFilter(){
		assertHandleEmfEvent(new NewValueClassFilterTest());
	}
	/**
	 * @see NewValueClassIncludingSubclassesFilterTest#giveTestFilter()
	 * @see NewValueClassIncludingSubclassesFilterTest#giveMatchingNotifications()
	 * @see NewValueClassIncludingSubclassesFilterTest#giveNotMatchingNotifcation()
	 */
	public void testNewValueClassIncludingSubclassesFilter(){
		assertHandleEmfEvent(new NewValueClassIncludingSubclassesFilterTest());
	}
	/**
	 * @see OldValueClassFilterTest#giveTestFilter()
	 * @see OldValueClassFilterTest#giveMatchingNotifications()
	 * @see OldValueClassFilterTest#giveNotMatchingNotifcation()
	 */
	public void testOldValueClassFilter(){
		assertHandleEmfEvent(new OldValueClassFilterTest());
	}
	/**
	 * @see OldValueClassIncludingSubclassesFilterTest#giveTestFilter()
	 * @see OldValueClassIncludingSubclassesFilterTest#giveMatchingNotifications()
	 * @see OldValueClassIncludingSubclassesFilterTest#giveNotMatchingNotifcation()
	 */
	public void testOldValueClassIncludingSubclassesFilter(){
		assertHandleEmfEvent(new OldValueClassIncludingSubclassesFilterTest());
	}
	
}
