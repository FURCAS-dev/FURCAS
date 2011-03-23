/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.tests.derivedPropertyHandling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.DerivedPropertyNotifier;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.impl.DerivedPropertyNotifierImpl;
import org.eclipse.ocl.examples.impactanalyzer.testutils.BaseDepartmentTestWithOCL;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.junit.Test;

import company.Employee;

/**
 * This test will check, if the {@link DerivedPropertyNotifierImpl} works correctly.
 * 
 * @author Martin Hanysz
 *
 */
public class DerivedPropertyAdapterTest extends BaseDepartmentTestWithOCL {

    protected EventManager eventManager;
    
    @Override
    public void setUp() {
        super.setUp();
        this.createInstances(2, 5, 3);
        this.eventManager = EventManagerFactory.eINSTANCE.createEventManagerFor(rs);
    }

    @Override
    public void tearDown() {
        super.tearDown();
        this.eventManager = null;
    }
    
    // Register an adapter at any derived feature we want to test and let it fetch the first notification it gets.
    // Afterwards simply make a change that will affect this derived feature and see if the correct notification comes along.

    /**
     * Creates a new Company instance, expecting an event to be thrown for the derived
     * <code>name</code> property by the {@link EventManager} but not by the element itself.
     */
    @Test
    public void testNewContextElementCausesNoNotificationOnElement() {
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(
    			comp, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	EObject newCompany = comp.getEFactoryInstance().create(companyClass);
    	NotificationCatchAdapter notificationCatcher1 = new NotificationCatchAdapter();
    	newCompany.eAdapters().add(notificationCatcher1);
    	NotificationCatchAdapter notificationCatcher2 = new NotificationCatchAdapter();
    	EventManager em = EventManagerFactory.eINSTANCE.getEventManagerFor(comp.eResource().getResourceSet());
    	em.subscribe(EventManagerFactory.eINSTANCE.createStructuralFeatureFilter(companyClass.getEStructuralFeature("name")),
    			notificationCatcher2);

    	// add newCompany to resource, triggering ADD event and hence the onNewContextNotification
    	// for derived property "name"
    	this.aCompany.eResource().getContents().add(newCompany);
        Notification notification1 = notificationCatcher1.getCaughtNotification();
        assertNull(notification1);
        Notification notification2 = notificationCatcher2.getCaughtNotification();
        assertNotNull(notification2);
        assertEquals(companyClass.getEStructuralFeature("name"), notification2.getFeature());
        assertNull(notification2.getOldStringValue());
        assertNotNull(notification2.getNewStringValue());
    }
    
    @Test
    public void testNonDerivedFeature() {
    	Exception exception = null;
		try {
    		ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.employeeName, OCLFactory.getInstance());
    	}
    	catch(IllegalArgumentException e){
    		exception = e;
    	}
    	// We assert to get an IllegalArgumentException if we pass a non derived property to the DerivedPropertyAdapter.
    	assertNotNull(exception);
    }
    
    @Test
    public void testTouch() {
    	// add a director to touch it by setting it again to the same value
    	this.aDivision.setDirector(this.aEmployee);
    	
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionDirector, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aCompany.eAdapters().add(notificationCatcher);
        
    	// Touch director of aDivision. That will not change the divisionDirector property of aCompany.
    	this.aDivision.setDirector(this.aEmployee);
        
        // The DerivedPropertyAdapter will simply exit on receiving a touch notification.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive no notification at all because the derivedProperty didn't change and can't be touched because it's unchangeable.
        assertNull(notification);   	
    }
    
    @Test
    public void testSingleValuedFeatureSet() {
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.numberEmployeesOfTheMonth, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Add an employee of the month to aDepartment. That will change the numberEmployeesOfTheMonth property of aDepartments division.
        this.aDepartment.getEmployeeOfTheMonth().add(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property numberEmployeesOfTheMonth.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a SET of aDivision.numberEmployeesOfTheMonth to 1.
        assertNotNull(notification);
        assertEquals(this.numberEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.SET);
        assertEquals(new Integer(1), notification.getNewValue());
        
    }
    
    @Test
    public void testUnsettableSingleValuedFeatureSet() {
    	// unset the feature to set it later on
    	this.aDivision.unsetDirector();
    	
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionDirector, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aCompany.eAdapters().add(notificationCatcher);
        
    	// Set director of aDivision. That will change the divisionDirector property of aCompany.
        this.aDivision.setDirector(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aCompany to send a change notification for it's derived property divisionDirector.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a SET of aCompany.divisionDirector to aEmployee.
        assertNotNull(notification);
        assertEquals(this.divisionDirector, notification.getFeature());
        assertEquals(this.aCompany, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.SET);
        assertEquals(this.aEmployee, notification.getNewValue());
    }
    
    @Test
    public void testUnsettableSingleValuedFeatureUnset() {
    	// add a director to unset
    	this.aDivision.setDirector(this.aEmployee);
    	
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionDirector, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aCompany.eAdapters().add(notificationCatcher);
        
    	// Unset director of aDivision. That will change the divisionDirector property of aCompany.
        this.aDivision.unsetDirector();
        
        // The DerivedPropertyAdapter will cause aCompany to send a change notification for it's derived property divisionDirector.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a UNSET of aCompany.divisionDirector to null.
        assertNotNull(notification);
        assertEquals(this.divisionDirector, notification.getFeature());
        assertEquals(this.aCompany, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.UNSET);
        assertEquals(null, notification.getNewValue());
    }

    @Test
    public void testMultiValuedFeatureAddOne() {
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionEmployeesOfTheMonth, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Add an employee of the month to aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().add(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a ADD of aDivision.employeesOfTheMonth to a collection containing aEmployee only.
        assertNotNull(notification);
        assertEquals(this.divisionEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.ADD);
        assertTrue(((List<?>)notification.getNewValue()).size() == 1);
        assertTrue(((List<?>)notification.getNewValue()).contains(aEmployee));
    }
    
    @Test
    public void testMultiValuedFeatureAddMany() {
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionEmployeesOfTheMonth, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Add two employees of the month to aDepartment. That will change the employeesOfTheMonth property of aDivision.
    	Collection<Employee> employeesToAdd = new ArrayList<Employee>();
    	employeesToAdd.add(this.aEmployee);
        employeesToAdd.add(this.createEmployee());
        this.aDepartment.getEmployeeOfTheMonth().addAll(employeesToAdd);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a ADD_MANY of aDivision.employeesOfTheMonth to a collection containing both employeesToAdd.
        assertNotNull(notification);
        assertEquals(this.divisionEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.ADD_MANY);
        assertTrue(((List<?>)notification.getNewValue()).size() == 2);
        assertTrue(((List<?>)notification.getNewValue()).containsAll(employeesToAdd));
    }
    
    @Test
    public void testMultiValuedFeatureRemoveOne() {
    	// set an employee to remove
    	this.aDepartment.getEmployeeOfTheMonth().add(this.aEmployee);
    	
    	DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionEmployeesOfTheMonth, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Remove an employee of the month of aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().remove(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a REMOVE of aDivision.employeesOfTheMonth to an empty collection.
        assertNotNull(notification);
        assertEquals(this.divisionEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.REMOVE);
        assertTrue(((List<?>)notification.getNewValue()).size() == 0);
    }
    
    @Test
    public void testMultiValuedFeatureRemoveMany() {
    	// set two employee to remove
    	Collection<Employee> employeesToRemove = new ArrayList<Employee>();
    	employeesToRemove.add(this.aEmployee);
    	employeesToRemove.add(this.createEmployee());
        this.aDepartment.getEmployeeOfTheMonth().addAll(employeesToRemove);
    	
        DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionEmployeesOfTheMonth, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Remove both employees of the month of aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().removeAll(employeesToRemove);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a REMOVE_MANY of aDivision.employeesOfTheMonth to an empty collection.
        assertNotNull(notification);
        assertEquals(this.divisionEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.REMOVE_MANY);
        assertTrue(((List<?>)notification.getNewValue()).size() == 0);
    }
    
    @Test
    public void testMultiValuedFeatureMove() {
    	// This test currently fails because the IA calculates there is no impact when changing the order of an ordered feature.
    	// TODO: clarify if this is wanted behavior and if so, edit the DerivedPropertyAdapter accordingly
    	
    	// set two employee to shuffle around (Division.employeesOfTheMonth is actually ordered, which was not of interest in the previous tests)
    	List<Employee> employeesToShuffle = new ArrayList<Employee>();
    	employeesToShuffle.add(this.aEmployee);
    	employeesToShuffle.add(this.createEmployee());
        this.aDepartment.getEmployeeOfTheMonth().addAll(employeesToShuffle);
    	
        DerivedPropertyNotifier derivedPropertyNotifier = ImpactAnalyzerFactory.INSTANCE.createDerivedPropertyNotifier(this.divisionEmployeesOfTheMonth, OCLFactory.getInstance());
    	derivedPropertyNotifier.subscribe(EventManagerFactory.eINSTANCE.getEventManagerFor(this.aCompany.eResource().getResourceSet()));
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Move the first employee of the month of aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().move(1, this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCaughtNotification();
        
        // We assert to receive a MOVE of aDivision.employeesOfTheMonth to a collection where aEmployee is the last entry.
        assertNotNull(notification);
        assertEquals(this.divisionEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.MOVE);
        assertTrue(((List<?>)notification.getNewValue()).size() == 2);
        assertEquals(employeesToShuffle.get(1),((List<?>)notification.getNewValue()).get(0));
        assertEquals(this.aEmployee,((List<?>)notification.getNewValue()).get(1));
    }
    
    /**
     * A dummy {@link Adapter} that simply catches the first {@link Notification} it receives.
     * 
     * @author Martin Hanysz
     *
     */
    private class NotificationCatchAdapter implements Adapter{
    	
    	private Notification caughtNotification = null;
		private Notifier target = null;

		public Notification getCaughtNotification() {
			return caughtNotification;
		}

		public void notifyChanged(Notification notification) {
			if(caughtNotification == null)
				caughtNotification = notification;
		}

		public Notifier getTarget() {
	        return target;
	    }

	    public void setTarget(Notifier newTarget) {
	        target = newTarget;
	    }

	    public boolean isAdapterForType(Object type) {
	        return type == DerivedPropertyNotifierImpl.class;
	    }
    	
    }
}
