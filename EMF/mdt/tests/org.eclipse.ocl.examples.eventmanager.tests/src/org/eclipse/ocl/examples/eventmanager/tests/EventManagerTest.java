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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.AttributeFilter;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OrFilter;
import org.junit.Test;


public class EventManagerTest extends TestCase {

    protected EventManager fixture = null;
    private EventFilter filter;
    private Adapter adapter;
    private Notification lastMsg;
    Notification matchingNotification;
	private ResourceImpl res;

    public class Bool {
        public boolean is = false;
    }
    public class Application extends AdapterImpl implements Adapter {
        private final Bool b;

        public Application(Bool b1) {
            b = b1;
        }

        @Override
        public void notifyChanged(Notification msg) {
            this.b.is = true;

        }

    }

    public static void main(String[] args) {
        TestRunner.run(EventManagerTest.class);
    }

    protected void setFixture(EventManager fixture) {
        this.fixture = fixture;
    }

    protected EventManager getFixture() {
        return fixture;
    }

    @Override
    public void setUp() {       
        try {
			super.setUp();
		} catch (Exception e) {
			/*...*/
		}
        final EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
        ResourceSet set = new ResourceSetImpl();
        res = new ResourceImpl();
        set.getResources().add(res);
        setFixture((EventManager) EventManagerFactory.eINSTANCE.getEventManagerFor(set));
        matchingNotification = new NotificationImpl(Notification.ADD, null, null){
        	public Object getFeature() {
        		return attr;
        	};
        };

        filter = new AttributeFilter(attr);
        adapter = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                lastMsg = msg;
                super.notifyChanged(msg);

            }
        };
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     * @generated NOT
     */
    @Override
    public void tearDown() {
        EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.remove("http://de.hpi.sam.bp2009.OCL");
        setFixture(null);
        filter = null;
        adapter = null;
        lastMsg = null;
        matchingNotification = null;
    }


//    public void testSubscribeTransactional__EList_EventFilter_Adapter() {
//        System.err.println("Implement ME -- SubscribeTransactional__EList_EventFilter_Adapter");
//    }

    public void testNotifyApplication__Adapter_Notification_EventFilter() {
        adapter.notifyChanged(matchingNotification);
        assertTrue("Application gets notified", matchingNotification.equals(lastMsg));
    }

    public void testHandleEMFEvent__Notification() {
        // register Application
        getFixture().subscribe(filter, adapter);
        getFixture().handleEMFEvent(matchingNotification);
        assertEquals(matchingNotification, lastMsg);

    }

    @Test
    public void testSimpleElementInsertFilter() {
    	EClass cls = EcoreFactory.eINSTANCE.createEClass();
    	
        EventFilter f = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(cls);
        res.getContents().add(new DynamicEObjectImpl(cls));
        Bool newBool = new Bool();
        filterStatementsWithEM(f, newBool);
        getFixture().handleEMFEvent(new NotificationImpl(Notification.ADD, null, new DynamicEObjectImpl(cls)){
        	@Override
        	public Object getFeature() {
        		EReference ref = EcoreFactory.eINSTANCE.createEReference();
        		ref.setContainment(true);        		
        		return ref;
        	}
        });
        assertTrue(newBool.is);
    }

    @Test
    public void testDoubleElementInsertFilter() {
    	EClass cls = EcoreFactory.eINSTANCE.createEClass();
    	
        EventFilter f1 = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(cls);
        EventFilter f2 = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(cls);
        EventFilter f = new OrFilter(f1, f2);
        Bool newBool = new Bool();
        filterStatementsWithEM(f, newBool);
        getFixture().handleEMFEvent(new NotificationImpl(Notification.ADD, null, new DynamicEObjectImpl(cls)){
        	@Override
        	public Object getFeature() {
        		EReference ref = EcoreFactory.eINSTANCE.createEReference();
        		ref.setContainment(true);        		
        		return ref;
        	}
        });
        assertTrue(newBool.is);
    }

    private void filterStatementsWithEM(EventFilter filter, Bool b) {
        Application app = new Application(b);
        getFixture().subscribe(filter, app);
    }


    public void testUnsubscribe__Adapter() {
        getFixture().subscribe(filter, adapter);
        getFixture().unsubscribe(adapter);

        assertFalse((matchingNotification.equals(lastMsg)));
        assertNull(lastMsg);
    }
    public void testResourceAddContainmentFilter(){
//       Resource r = this.comp.eResource();
//       Bool b = new Bool();
//       getFixture().subscribe(ContainmentFilter.INSTANCE, new MyApp(b));
//       r.getContents().add(this.aEmployee);
//       assertTrue(b.is);
    }
    public void testResourceRemoveContainmentFilter(){
//        Resource r = this.comp.eResource();
//        Bool b = new Bool();
//        r.getContents().add(this.aEmployee);
//        getFixture().subscribe(ContainmentFilter.INSTANCE, new MyApp(b));
//        r.getContents().remove(this.aEmployee);
//        assertTrue(b.is);
     }
    public void testResourceCompositeAddContainmentFilter(){
//        Resource r = this.comp.eResource();
//        Bool b = new Bool();
//        MyApp app = new MyApp(b);
//        getFixture().subscribe( new ClassFilter(department, false), app);
//        r.getContents().add(this.aDivision);
//        assertTrue(b.is);
     }
    public void testContainerSet(){
//        Department dep = CompanyFactory.eINSTANCE.createDepartment();
//        Employee empl = CompanyFactory.eINSTANCE.createEmployee();
//        
//        Bool b1 = new Bool();
//        MyApp my = new MyApp(b1 );
//        empl.eAdapters().add(my);
//        dep.getEmployee().add(empl);
//        assertTrue(my.b.is);
//        
//        Division div = CompanyFactory.eINSTANCE.createDivision();
//        
//        b1 = new Bool();
//        my = new MyApp(b1);
//        div.eAdapters().add(my);
//        div.getDepartment().add(dep);
//        assertTrue(my.b.is);
    }    

} // EventManagerTest
