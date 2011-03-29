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
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;


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
     * Tests the '
     * {@link org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__Notification() {
        noti= new NotificationImpl(Notification.ADD, null, null){
			@Override
        	public Object getFeature() {
        		return getFilterCriterion1();
        	}
        };
        StructuralFeatureFilter filter1 = (StructuralFeatureFilter) getFilterFor(getFilterCriterion1());
        StructuralFeatureFilter filter2 = (StructuralFeatureFilter) getFilterFor(getFilterCriterion2());
        
		assertTrue(filter1.matchesFor(noti));
		assertFalse(filter2.matchesFor(noti));
  
        filter1.setNegated(true);
        filter2.setNegated(true);
        assertFalse(filter1.matchesFor(noti));
		assertTrue(filter2.matchesFor(noti));

    }
    
    public void testSetNegated_Boolean(){
        noti= new NotificationImpl(Notification.ADD, null, null){
			@Override
        	public Object getFeature() {
        		return getFilterCriterion1();
        	}
        };
        StructuralFeatureFilter filter1 = (StructuralFeatureFilter) getFilterFor(getFilterCriterion1());
        StructuralFeatureFilter filter2 = (StructuralFeatureFilter) getFilterFor(getFilterCriterion2());
        filter1.setNegated(true);
        assertTrue(filter1.isNegated());
        assertFalse(filter2.isNegated());
        filter2.setNegated(true);
        assertFalse(filter1.matchesFor(noti));
		assertTrue(filter2.matchesFor(noti));
    }
   

} // StructuralFeatureFilterTest
