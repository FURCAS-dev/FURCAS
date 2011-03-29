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

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter;
import org.junit.Test;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Event Filter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
 * <em>Matches For</em>}</li>
 * <li>
 * {@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier)
 * <em>Build Notification Identifiers</em>}</li>
 * </ul>
 * </p>
 * 
 */
public abstract class EventFilterTest extends TestCase{
	/**
	 * The fixture for this Event Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	protected EventFilter fixture = null;
	/**
	 * Sets the fixture for this Event Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	protected void setFixture(EventFilter fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Event Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	protected EventFilter getFixture() {
		return fixture;
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 */
	abstract public void testMatchesFor__Notification();
	
	@Test
	public void testClone() {
		EventFilter f = getFixture();
		EventFilter c = f.clone();
		
		assertTrue("Clone not equals source", c.equals(f));
		assertTrue("Clone has  not same hashkey", c.hashCode() == f.hashCode());

	}
    /**
     * Helper method to test the equals/hashcode methods
     * Creates a filter object dependent on the incoming object
     * @param f influence the filter creation
     * @return new FIlter
     */
    abstract EventFilter getFilterFor(Object f);
    
    /**
     * Gives one object which create a filter by using {@link #getFilterFor(Object)}
     * @return an object
     */
    abstract Object getFilterCriterion1();
    
    /**
     * Gives a object which creates if applicable a different filter to {@link #getFilterCriterion2()}
     * @return an object
     */
    abstract Object getFilterCriterion2();
	/**
	 * Simple test for the hashCode / equals contract
	 */
	public void testSimpleForEqualsAndHashCode() {
		EventFilter f1 = getFilterFor(getFilterCriterion1());
		EventFilter f2 = getFilterFor(getFilterCriterion1());
		EventFilter f3 = getFilterFor(getFilterCriterion2());
		EventFilter f4 = getFilterFor(getFilterCriterion1());
		((AbstractEventFilter) f4).setNegated(true);
		
		assertTrue(f1.equals(f1));
		assertTrue(f1.equals(f2));
		assertFalse(f1.equals(f4));
		if (getFilterCriterion1()!=getFilterCriterion2()) {
			assertFalse(f1.equals(f3));
			assertFalse(f1.hashCode() == f3.hashCode());
		}
		assertFalse(f1.equals(null));
		assertTrue(f1.hashCode() == f2.hashCode());
		assertFalse(f1.hashCode() == f4.hashCode());
	}

	abstract public AbstractEventFilter giveTestFilter();
	abstract public Notification[] giveMatchingNotifications();
	abstract public Notification giveNotMatchingNotifcation();

} // EventFilterTest
