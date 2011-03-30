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
package org.eclipse.ocl.examples.eventmanager.tests.framework;


import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;


public class IncludeSubclassesTest extends TestCase {	
	private ResourceSet set;

    class App extends AdapterImpl{
        public boolean noti = false;

        @Override
        public void notifyChanged(Notification msg) {
            this.noti =true;
            
        }
    }
    @Override
    public void setUp() {
        try {
			super.setUp();
		} catch (Exception e) {
			/*...*/
		}
        set = new ResourceSetImpl();
        Resource r = new ResourceImpl();
        set.getResources().add(r);
        
     }

    @Override
    public void tearDown() {
    	set = null;
        try {
			super.tearDown();
		} catch (Exception e) {
			/*...*/
		}
        
    }
    
    public void testIncludingSubclassesFilterElementInsertionClassGetClass(){
    	EventManager m = EventManagerFactory.eINSTANCE.createEventManagerFor(set);
    	EClass cls = EcoreFactory.eINSTANCE.createEClass();
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(cls);
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setContainment(true);
        Notification noti = new ENotificationImpl(null, Notification.SET, ref, null, new DynamicEObjectImpl(cls));
        App app = new App();
        m.subscribe(filter, app);
        m.handleEMFEvent(noti);
        assertTrue("Application not notified",app.noti);
        app.noti= false;
        
       EList<Adapter> eAdapters = set.getResources().get(0).eAdapters();
       for(int i = 0; i< eAdapters.size(); i++){
    	   eAdapters.get(i).notifyChanged(noti);
       }
       assertTrue("Application not notified",app.noti);

        
    }
    public void testIncludingSubclassesFilterElementInsertionClassGetSubclass(){
    	EventManager m = EventManagerFactory.eINSTANCE.createEventManagerFor(set);
    	EClass cls = EcoreFactory.eINSTANCE.createEClass();
    	EClass subcls = EcoreFactory.eINSTANCE.createEClass();
    	subcls.getESuperTypes().add(cls);
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(cls);
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setContainment(true);
        Notification noti = new ENotificationImpl(null, Notification.SET, ref, null, new DynamicEObjectImpl(subcls));
        App app = new App();
        m.subscribe(filter, app);
        m.handleEMFEvent(noti);
        assertTrue("Application not notified",app.noti);
        app.noti= false;
        
       EList<Adapter> eAdapters = set.getResources().get(0).eAdapters();
       for(int i = 0; i< eAdapters.size(); i++){
    	   eAdapters.get(i).notifyChanged(noti);
       }
       assertTrue("Application not notified",app.noti);
        
    }
    public void testDoubleSubscriptionExpectSubclassButNoSuperClass(){
    	EventManager m = EventManagerFactory.eINSTANCE.createEventManagerFor(set);

    	EClass classA = EcoreFactory.eINSTANCE.createEClass();
    	EClass classB = EcoreFactory.eINSTANCE.createEClass();
    	classB.getESuperTypes().add(classA);
    	EventFilter filter = EventManagerFactory.eINSTANCE.createAndFilterFor(
    			EventManagerFactory.eINSTANCE.createNotFilter(
    					EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(classA)
    					),
    			EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(classB));
    	
        App app = new App();
		boolean thrown = false;
		try {
	        m.subscribe(filter, app);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue("No execption thrown",thrown);
//		TODO uncomment this as soon as the eventmanager can handle multiple entries
//    	EObject object = new DynamicEObjectImpl(classB);
//    	Notification noti = new ENotificationImpl((InternalEObject)object, 0, null, null, null);
//        m.handleEMFEvent(noti);
//        m.unsubscribe(app);
//        
//    	EObject object2 = new DynamicEObjectImpl(classA);
//    	Notification noti2 = new ENotificationImpl((InternalEObject)object2, 0, null, null, null);
//        App app2 = new App();
//        m.subscribe(filter, app2);
//        m.handleEMFEvent(noti2);
//        assertFalse("Application wrongly notified",app2.noti);
//        m.unsubscribe(app2);
//
//    	Notification noti3 = new ENotificationImpl(null, 0, null, null, null);
//        App app3 = new App();
//        m.subscribe(filter, app3);
//        m.handleEMFEvent(noti3);
//        assertFalse("Application wrongly notified",app3.noti);
//        m.unsubscribe(app3);
    }
    public void testDoubleSubscriptionExpectSuperclassButNoSubClass(){
    	EventManager m = EventManagerFactory.eINSTANCE.createEventManagerFor(set);

    	EClass classA = EcoreFactory.eINSTANCE.createEClass();
    	EClass classB = EcoreFactory.eINSTANCE.createEClass();
    	classB.getESuperTypes().add(classA);
    	EventFilter filter = EventManagerFactory.eINSTANCE.createAndFilterFor(
    			EventManagerFactory.eINSTANCE.createNotFilter(
    					EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(classB)
    					),
    			EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(classA));
    	
        App app = new App();
		boolean thrown = false;
		try {
	        m.subscribe(filter, app);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue("No execption thrown",thrown);
//		TODO uncomment this as soon as the eventmanager can handle multiple entries
//    	EObject object = new DynamicEObjectImpl(classB);
//    	Notification noti = new ENotificationImpl((InternalEObject)object, 0, null, null, null);
//        m.handleEMFEvent(noti);
//        m.unsubscribe(app);
//        
//    	EObject object2 = new DynamicEObjectImpl(classA);
//    	Notification noti2 = new ENotificationImpl((InternalEObject)object2, 0, null, null, null);
//        App app2 = new App();
//        m.subscribe(filter, app2);
//        m.handleEMFEvent(noti2);
//        assertTrue("Application not notified",app2.noti);
//        m.unsubscribe(app2);
//
//    	Notification noti3 = new ENotificationImpl(null, 0, null, null, null);
//        App app3 = new App();
//        m.subscribe(filter, app3);
//        m.handleEMFEvent(noti3);
//        assertFalse("Application wrongly notified",app3.noti);
//        m.unsubscribe(app3);
    }
    public void testNegatedSubscriptionClassANotificationSubclassB(){
    	EventManager m = EventManagerFactory.eINSTANCE.createEventManagerFor(set);

    	EClass classA = EcoreFactory.eINSTANCE.createEClass();
    	EClass classB = EcoreFactory.eINSTANCE.createEClass();
    	classB.getESuperTypes().add(classA);
    	EventFilter filter =EventManagerFactory.eINSTANCE.createNotFilter(
    			EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(classA));
    	
        App app = new App();
        m.subscribe(filter, app);
    	EObject object = new DynamicEObjectImpl(classB);
    	Notification noti = new ENotificationImpl((InternalEObject)object, 0, null, null, null);
        m.handleEMFEvent(noti);
        m.unsubscribe(app);
        
        assertFalse("Get wrongly notified", app.noti);
    }
}
