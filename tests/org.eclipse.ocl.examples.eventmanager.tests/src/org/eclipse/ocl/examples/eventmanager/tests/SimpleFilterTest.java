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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;
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
	private static class MyClassFilter extends ClassFilter{
		public MyClassFilter(EClass clazz, boolean negated) {
			super(clazz, negated);
		}
		@Override
		public org.eclipse.ocl.examples.eventmanager.filters.ClassFilter clone() {
			return new MyClassFilter(getWantedClass(), true);
		}
		
	}
    public void testBehaviourForUnknownFilter(){
    	ClassFilter f = new MyClassFilter(null, false);
    	boolean thrown=false;
    	try {
        	fixture.subscribe(f,app );
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue("No Exception thrown", thrown);
    }
	/**
	 * Tests whether the {@link Notification notifications} defined by
	 * the {@link EventFilterTest test} trigger the {@link EventManager manager}
	 * @param test
	 */
	public void assertHandleEmfEvent(EventFilterTest test){
		app.reset();
		fixture.subscribe(test.giveTestFilter(), app);
		fixture.handleEMFEvent(test.giveNotMatchingNotifcation());
		assertFalse("Get wrongly notified", app.isNotified());
		app.reset();
		for(Notification n: test.giveMatchingNotifications()){
			fixture.handleEMFEvent(n);
			assertTrue("Get not notified", app.isNotified());
			app.reset();
		}
		fixture.unsubscribe(app);
	}
	/**
	 * Tests whether the {@link Notification notifications} defined by
	 * the {@link EventFilterTest test} trigger the {@link EventManager manager}
	 * as difference to {@link #assertHandleEmfEvent(EventFilterTest)} here the filter are used negated
	 * @param test
	 */
	public void assertNegatedHandleEmfEvent(EventFilterTest test){
		EventFilter f = test.giveTestFilter();
		((AbstractEventFilter)f).setNegated(true);
		app.reset();
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(test.giveNotMatchingNotifcation());
		assertTrue("Get not notfied negated", app.isNotified());
		app.reset();
		for(Notification n: test.giveMatchingNotifications()){
			fixture.handleEMFEvent(n);
			assertFalse("Get wrongly notified negated", app.isNotified());
			app.reset();
		}
		fixture.unsubscribe(app);
	}
	/**
	 * @see AssociationFilterTest#giveTestFilter()
	 * @see AssociationFilterTest#giveMatchingNotifications()
	 * @see AssociationFilterTest#giveNotMatchingNotifcation()
	 */
	public void testReferenceFilter(){
		assertHandleEmfEvent(new AssociationFilterTest());
		assertNegatedHandleEmfEvent(new AssociationFilterTest());
	}
	/**
	 * @see AttributeFilterTest#giveTestFilter()
	 * @see AttributeFilterTest#giveMatchingNotifications()
	 * @see AttributeFilterTest#giveNotMatchingNotifcation()
	 */
	public void testAttributeFilter(){
		assertHandleEmfEvent(new AttributeFilterTest());
		assertNegatedHandleEmfEvent(new AttributeFilterTest());
	}
	/**
	 * @see ClassFilterTest#giveTestFilter()
	 * @see ClassFilterTest#giveMatchingNotifications()
	 * @see ClassFilterTest#giveNotMatchingNotifcation()
	 */
	public void testClassFilter(){
		assertHandleEmfEvent(new ClassFilterTest());
		assertNegatedHandleEmfEvent(new ClassFilterTest());
	}
	/**
	 * @see ContainmentFilterTest#giveTestFilter()
	 * @see ContainmentFilterTest#giveMatchingNotifications()
	 * @see ContainmentFilterTest#giveNotMatchingNotifcation()
	 */
	public void testContainmentFilter(){
		assertHandleEmfEvent(new ContainmentFilterTest());
		assertNegatedHandleEmfEvent(new ContainmentFilterTest());
	}
	/**
	 * @see EventTypeFilterTest#giveTestFilter()
	 * @see EventTypeFilterTest#giveMatchingNotifications()
	 * @see EventTypeFilterTest#giveNotMatchingNotifcation()
	 */
	public void testEventTypeFilter(){
		assertHandleEmfEvent(new EventTypeFilterTest());
		assertNegatedHandleEmfEvent(new EventTypeFilterTest());
	}
	/**
	 * @see NewValueClassFilterTest#giveTestFilter()
	 * @see NewValueClassFilterTest#giveMatchingNotifications()
	 * @see NewValueClassFilterTest#giveNotMatchingNotifcation()
	 */
	public void testNewValueClassFilter(){
		assertHandleEmfEvent(new NewValueClassFilterTest());
		assertNegatedHandleEmfEvent(new NewValueClassFilterTest());
	}
	/**
	 * @see NewValueClassIncludingSubclassesFilterTest#giveTestFilter()
	 * @see NewValueClassIncludingSubclassesFilterTest#giveMatchingNotifications()
	 * @see NewValueClassIncludingSubclassesFilterTest#giveNotMatchingNotifcation()
	 */
	public void testNewValueClassIncludingSubclassesFilter(){
		assertHandleEmfEvent(new NewValueClassIncludingSubclassesFilterTest());
		assertNegatedHandleEmfEvent(new NewValueClassIncludingSubclassesFilterTest());
	}
	/**
	 * @see OldValueClassFilterTest#giveTestFilter()
	 * @see OldValueClassFilterTest#giveMatchingNotifications()
	 * @see OldValueClassFilterTest#giveNotMatchingNotifcation()
	 */
	public void testOldValueClassFilter(){
		assertHandleEmfEvent(new OldValueClassFilterTest());
		assertNegatedHandleEmfEvent(new OldValueClassFilterTest());
	}
	/**
	 * @see OldValueClassIncludingSubclassesFilterTest#giveTestFilter()
	 * @see OldValueClassIncludingSubclassesFilterTest#giveMatchingNotifications()
	 * @see OldValueClassIncludingSubclassesFilterTest#giveNotMatchingNotifcation()
	 */
	public void testOldValueClassIncludingSubclassesFilter(){
		assertHandleEmfEvent(new OldValueClassIncludingSubclassesFilterTest());
		assertNegatedHandleEmfEvent(new OldValueClassIncludingSubclassesFilterTest());
	}
	
}
