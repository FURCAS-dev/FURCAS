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
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>And Filter</b></em>'. <!-- end-user-doc -->
 * 
 */
public class AndFilterTest extends LogicalEventFilterTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     */
    public static void main(String[] args) {
        TestRunner.run(AndFilterTest.class);
    }

    /**
     * Constructs a new And Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     */
    public AndFilterTest() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        super.setUp();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        setFixture(null);
        this.falseFilter = null;
        this.trueFilter = null;
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__NotificationTwoTrue() {
        AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilterFor(trueFilter, trueFilter);
        assertTrue("Two true is true", andFilter.matchesFor(null));
    }

    public void testMatchesFor__NotificationTwoFalse() {
        AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilterFor(falseFilter, falseFilter);
        assertFalse("Two false is false", andFilter.matchesFor(null));
    }

    public void testMatchesFor__Notification() {
        AndFilter andFilter = EventManagerFactory.eINSTANCE.createAndFilterFor(falseFilter, trueFilter);
        assertFalse("Two true/false is false",andFilter.matchesFor(null));
    }

} // AndFilterTest
