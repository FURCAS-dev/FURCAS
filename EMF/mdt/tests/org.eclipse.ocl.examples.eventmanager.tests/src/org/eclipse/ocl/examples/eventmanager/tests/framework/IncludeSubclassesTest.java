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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
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
}
