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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationHelper;
import org.junit.Test;

import company.CompanyFactory;
import company.Department;
import company.Division;
import company.Employee;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.testutils.BaseDepartmentTest;

public class EventManagerTest extends BaseDepartmentTest {

    protected EventManager fixture = null;
    private EventFilter filter;
    private Adapter adapter;
    private Notification lastMsg;
    Notification matchingNotification;

    public class MyApp extends AdapterImpl implements Adapter {
        private final Bool b;

        public MyApp(Bool b1) {
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
        super.setUp();
        this.createInstances(1, 3, 4);
        setFixture((EventManager) EventManagerFactory.eINSTANCE.getEventManagerFor(this.comp.eResource().getResourceSet()));
        matchingNotification = NotificationHelper.createAttributeChangeNotification(this.aFreelance, this.employeeAge,
                new Integer(23), new Integer(42));

        filter = new AttributeFilter(this.employeeAge);
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


    public void testSubscribeTransactional__EList_EventFilter_Adapter() {
        System.err.println("Implement ME -- SubscribeTransactional__EList_EventFilter_Adapter");
    }

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
        EventFilter f = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(this.department);
        comp.eResource().getContents().add(aDivision);
        Bool newBool = new Bool();
        filterStatementsWithEM(f, newBool);
        NotificationHelper.createElementAddNotification(aDivision, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
        assertTrue(newBool.is);
    }

    @Test
    public void testDoubleElementInsertFilter() {
        EventFilter f1 = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(this.department);
        EventFilter f2 = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(this.department);
        EventFilter f = new OrFilter(f1, f2);
        comp.eResource().getContents().add(aDivision);
        Bool newBool = new Bool();
        filterStatementsWithEM(f, newBool);
        NotificationHelper.createElementAddNotification(aDivision, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
        assertTrue(newBool.is);
    }

    private void filterStatementsWithEM(EventFilter filter, Bool b) {
        MyApp app = new MyApp(b);
        EventManager m = EventManagerFactory.eINSTANCE.getEventManagerFor(this.comp.eResource().getResourceSet());
        m.subscribe(filter, app);
    }

    public class Bool {
        public boolean is = false;
    }

    public void testUnsubscribe__Adapter() {
        getFixture().subscribe(filter, adapter);
        getFixture().unsubscribe(adapter);

        assertFalse((matchingNotification.equals(lastMsg)));
        assertNull(lastMsg);
    }
    public void testResourceAddContainmentFilter(){
       Resource r = this.comp.eResource();
       Bool b = new Bool();
       getFixture().subscribe(ContainmentFilter.INSTANCE, new MyApp(b));
       r.getContents().add(this.aEmployee);
       assertTrue(b.is);
    }
    public void testResourceRemoveContainmentFilter(){
        Resource r = this.comp.eResource();
        Bool b = new Bool();
        r.getContents().add(this.aEmployee);
        getFixture().subscribe(ContainmentFilter.INSTANCE, new MyApp(b));
        r.getContents().remove(this.aEmployee);
        assertTrue(b.is);
     }
    public void testResourceCompositeAddContainmentFilter(){
        Resource r = this.comp.eResource();
        Bool b = new Bool();
        MyApp app = new MyApp(b);
        getFixture().subscribe( new ClassFilter(department, false), app);
        r.getContents().add(this.aDivision);
        assertTrue(b.is);
     }
    public void testContainerSet(){
        Department dep = CompanyFactory.eINSTANCE.createDepartment();
        Employee empl = CompanyFactory.eINSTANCE.createEmployee();
        
        Bool b1 = new Bool();
        MyApp my = new MyApp(b1 );
        empl.eAdapters().add(my);
        dep.getEmployee().add(empl);
        assertTrue(my.b.is);
        
        Division div = CompanyFactory.eINSTANCE.createDivision();
        
        b1 = new Bool();
        my = new MyApp(b1);
        div.eAdapters().add(my);
        div.getDepartment().add(dep);
        assertTrue(my.b.is);
    }    

} // EventManagerTest
