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

import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Or Filter</b></em>'. <!-- end-user-doc -->
 */
public class OrFilterTest extends LogicalEventFilterTest {

    public OrFilterTest() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(OrFilterTest.class);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() throws Exception{
        super.setUp();
        setFixture(EventManagerFactory.eINSTANCE.createOrFilterFor(trueFilter, trueFilter));
    }

    /**
     * Tests the '
     * {@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__NotificationTwoTrue() {
        EventFilter or = EventManagerFactory.eINSTANCE.createOrFilterFor(trueFilter, trueFilter);
        assertTrue("Two true is true", or.matchesFor(null));
    }

    public void testMatchesFor__NotificationTwoFalse() {
        EventFilter or = EventManagerFactory.eINSTANCE.createOrFilterFor(falseFilter, falseFilter);
        assertFalse("Two false is false", or.matchesFor(null));
    }

    public void testMatchesFor__Notification() {
        EventFilter or = EventManagerFactory.eINSTANCE.createOrFilterFor(falseFilter, trueFilter);
        assertTrue("Two true/false is true", or.matchesFor(null));
    }
	@Override
	Object getFilterCriterion1() {
		return 1;
	}

	@Override
	Object getFilterCriterion2() {
		return 2;
	}

	@Override
	EventFilter getFilterFor(Object f) {
		if(f==null){
			return EventManagerFactory.eINSTANCE.createOrFilterFor(trueFilter, trueFilter);
		}else if((Integer)f==1){
			return EventManagerFactory.eINSTANCE.createOrFilterFor(falseFilter, trueFilter);
		}else{
			return EventManagerFactory.eINSTANCE.createOrFilterFor(falseFilter, falseFilter);
		}

	}
} // OrFilterTest
