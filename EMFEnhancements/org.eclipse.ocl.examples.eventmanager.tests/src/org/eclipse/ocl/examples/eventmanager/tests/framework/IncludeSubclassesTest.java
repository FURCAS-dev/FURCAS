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


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationHelper;
import org.eclipse.ocl.examples.impactanalyzer.testutils.BaseDepartmentTest;


public class IncludeSubclassesTest extends BaseDepartmentTest {
    private EventManager m;

    class App extends AdapterImpl{
        public boolean noti = false;

        @Override
        public void notifyChanged(Notification msg) {
            this.noti =true;
            
        }
    }
    @Override
    public void setUp() {
        super.setUp();
        // m = new EventManagerNaive(comp.eResource().getResourceSet());
        m = EventManagerFactory.eINSTANCE.getEventManagerFor(comp.eResource().getResourceSet());
    }

    @Override
    public void tearDown() {
        m= null;
        super.tearDown();
        
    }
    
    public void testIncludingSubclassesFilterElementInsertionStudentGotStudent(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(student);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(student), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
    public void testIncludingSubclassesFilterElementInsertionEmployeeGotStudent(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(employee);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(student), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
    
    public void testIncludingSubclassesFilterElementInsertionEmployeeGotFreelancer(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(employee);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(freelance), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
    public void testIncludingSubclassesSimpleFreeLanceVSEmployee(){
        EventFilter includeSubClass = EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(employee);
        App includeSubClassApp = new App();
        m.subscribe(includeSubClass, includeSubClassApp);

        EventFilter excludeSubClass = EventManagerFactory.eINSTANCE.createClassFilter(employee);
        App excludeSubClassApp = new App();
        m.subscribe(excludeSubClass, excludeSubClassApp);

        EventFilter includeSubClassNew = EventManagerFactory.eINSTANCE.createNewValueClassFilterIncludingSubclasses(employee);
        App includeSubClassNewApp = new App();
        m.subscribe(includeSubClassNew, includeSubClassNewApp);

        EventFilter excludeSubClassNew = EventManagerFactory.eINSTANCE.createNewValueClassFilter(employee);
        App excludeSubClassNewApp = new App();
        m.subscribe(excludeSubClassNew, excludeSubClassNewApp);

        EventFilter includeSubClassOld = EventManagerFactory.eINSTANCE.createOldValueClassFilterIncludingSubclasses(employee);
        App includeSubClassOldApp = new App();
        m.subscribe(includeSubClassOld, includeSubClassOldApp);

        EventFilter excludeSubClassOld = EventManagerFactory.eINSTANCE.createOldValueClassFilter(employee);
        App excludeSubClassOldApp = new App();
        m.subscribe(excludeSubClassOld, excludeSubClassOldApp);

        EObject freeLance = this.comp.getEFactoryInstance().create(freelance);
        NotificationHelper.createNewElementAddToResourceNotification(freeLance, this.comp.eResource());
        assertTrue(includeSubClassApp.noti);
        assertFalse(excludeSubClassApp.noti);
        assertTrue(includeSubClassNewApp.noti);
        assertFalse(excludeSubClassNewApp.noti);
        assertFalse(includeSubClassOldApp.noti);
        assertFalse(excludeSubClassOldApp.noti);
        reset(includeSubClassApp, excludeSubClassApp, includeSubClassNewApp,
                excludeSubClassNewApp, includeSubClassOldApp,excludeSubClassOldApp);
        
        EObject emPloyee = this.comp.getEFactoryInstance().create(employee);
        NotificationHelper.createNewElementAddToResourceNotification(emPloyee, this.comp.eResource());
        assertTrue(includeSubClassApp.noti);
        assertTrue(excludeSubClassApp.noti);
        assertTrue(includeSubClassNewApp.noti);
        assertTrue(excludeSubClassNewApp.noti);
        assertFalse(includeSubClassOldApp.noti);
        assertFalse(excludeSubClassOldApp.noti);
        reset(includeSubClassApp, excludeSubClassApp, includeSubClassNewApp,
                excludeSubClassNewApp, includeSubClassOldApp,excludeSubClassOldApp);
        
        NotificationHelper.createElementDeleteNotification(emPloyee);
        assertTrue(includeSubClassApp.noti);
        assertTrue(excludeSubClassApp.noti);
        assertFalse(includeSubClassNewApp.noti);
        assertFalse(excludeSubClassNewApp.noti);
        assertTrue(includeSubClassOldApp.noti);
        assertTrue(excludeSubClassOldApp.noti);
        reset(includeSubClassApp, excludeSubClassApp, includeSubClassNewApp,
                excludeSubClassNewApp, includeSubClassOldApp,excludeSubClassOldApp);  
        NotificationHelper.createElementDeleteNotification(freeLance);
        assertTrue(includeSubClassApp.noti);
        assertFalse(excludeSubClassApp.noti);
        assertFalse(includeSubClassNewApp.noti);
        assertFalse(excludeSubClassNewApp.noti);
        assertTrue(includeSubClassOldApp.noti);
        assertFalse(excludeSubClassOldApp.noti);
        reset(includeSubClassApp, excludeSubClassApp, includeSubClassNewApp,
                excludeSubClassNewApp, includeSubClassOldApp,excludeSubClassOldApp);
        
    }
    
    
    private void reset(App...apps){
        for(App a:apps){
            a.noti=false;
        }
    }
}
