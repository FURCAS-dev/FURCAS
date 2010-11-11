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

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.testutils.BaseDepartmentTest;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Event Filter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
 * <em>Matches For</em>}</li>
 * <li>
 * {@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier)
 * <em>Build Notification Identifiers</em>}</li>
 * </ul>
 * </p>
 * 
 */
public abstract class EventFilterTest extends BaseDepartmentTest {

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
     * {@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    abstract public void testMatchesFor__Notification();

} // EventFilterTest
