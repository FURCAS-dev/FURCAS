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
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;


/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Type Filter</b></em>'.
 * <!-- end-user-doc -->
 */
public class EventTypeFilterTest extends EventFilterTest {
	private NotificationImpl notification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(EventTypeFilterTest.class);
	}


	/**
	 * Constructs a new Event Type Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EventTypeFilterTest() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp()   {
		notification = new NotificationImpl(Notification.ADD, false, false);
		setFixture(EventManagerFactory.eINSTANCE.createEventTypeFilter(Notification.ADD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown()  {
		setFixture(null);
		notification = null;
	}

	/**
	 * Tests the '{@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 */
	public void testMatchesFor__Notification() {
		assertTrue(getFixture().matchesFor(notification));
	}


	@Override
	EventFilter getFilterFor(Object f) {
		if(f==null){
			f= 0;
		}
		return EventManagerFactory.eINSTANCE.createEventTypeFilter((Integer)f);
	}


	@Override
	Object getFilterCriterion1() {
		return Notification.ADD;
	}


	@Override
	Object getFilterCriterion2() {
		return Notification.REMOVE;
	}
	@Override
	public Notification[] giveMatchingNotifications() {
		return new Notification[]{ new ENotificationImpl(null, (Integer) getFilterCriterion1(), null, null, null)};
	}
	@Override
	public Notification giveNotMatchingNotifcation() {
		return new ENotificationImpl(null, (Integer) getFilterCriterion2(), null, null, null);
	}
	@Override
	public EventFilter giveTestFilter() {
		return EventManagerFactory.eINSTANCE.createEventTypeFilter((Integer) getFilterCriterion1());
	}

} //EventTypeFilterTest
