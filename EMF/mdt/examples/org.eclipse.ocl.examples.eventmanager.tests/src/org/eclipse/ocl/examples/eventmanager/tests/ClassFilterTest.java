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

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Class Filter</b></em>'. <!-- end-user-doc -->
 */
public class ClassFilterTest extends EventFilterTest {

    private EClass cls;
    private DynamicEObjectImpl inst;
    private NotificationImpl noti;
    private EClass superCls;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(ClassFilterTest.class);
    }

    /**
     * Constructs a new Class Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public ClassFilterTest() {
        super();
    }

    /**
     * Returns the fixture for this Class Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    @Override
    protected ClassFilter getFixture() {
        return (ClassFilter) fixture;
    }

    public class TestNoti extends NotificationImpl {

        private Object notifier;

        public TestNoti(int eventType, boolean oldBooleanValue, boolean newBooleanValue, Object noti) {
            super(eventType, oldBooleanValue, newBooleanValue);
            notifier = noti;
        }

        @Override
        public Object getNotifier() {
            return notifier;
        }

    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        cls = EcoreFactory.eINSTANCE.createEClass();
        cls.setName("theClass");
        superCls = EcoreFactory.eINSTANCE.createEClass();
        superCls.setName("super");
        cls.getESuperTypes().add(superCls);
        inst = new DynamicEObjectImpl(cls);
        noti = new TestNoti(0, false, false, inst);
        setFixture(EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(superCls));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        cls = null;
        inst = null;
        noti = null;
        setFixture(null);
    }

    /**
     * Tests the '
     * {@link org.eclipse.ocl.examples.eventmanager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.ocl.examples.eventmanager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__Notification() {
        setFixture(EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(cls));
        assertTrue("Matches an Event from the given class", getFixture().matchesFor(noti));
    }

    public void testMatchesWithSubclasses() {
        setFixture(EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(superCls));
        assertTrue("Matches an Event from the given class", getFixture().matchesFor(noti));
    }

} // ClassFilterTest
