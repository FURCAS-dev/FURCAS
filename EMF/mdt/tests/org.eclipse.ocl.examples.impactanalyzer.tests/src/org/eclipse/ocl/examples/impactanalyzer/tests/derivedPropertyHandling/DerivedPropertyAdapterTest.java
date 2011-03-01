package org.eclipse.ocl.examples.impactanalyzer.tests.derivedPropertyHandling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.impl.DerivedPropertyAdapter;
import org.eclipse.ocl.examples.impactanalyzer.testutils.BaseDepartmentTestWithOCL;
import org.junit.Test;

import company.Employee;

/**
 * This test will check, if the {@link DerivedPropertyAdapter} works correctly.
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
    // Afterwards simply make a change that will affect / not affect this derived feature and see if the correct notification comes along.

    @Test
    public void testNonDerivedFeature() {
    	Exception exception = null;
		try {
    		new DerivedPropertyAdapter(this.employeeName);
    	}
    	catch(IllegalArgumentException e){
    		exception = e;
    	}
    	assertNotNull(exception);
    }
    
    @Test
    public void testSingleValuedFeatureSet() {
    	new DerivedPropertyAdapter(this.numberEmployeesOfTheMonth);
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Add an employee of the month to aDepartment. That will change the numberEmployeesOfTheMonth property of aDepartments division.
        this.aDepartment.getEmployeeOfTheMonth().add(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property numberEmployeesOfTheMonth.
        Notification notification = notificationCatcher.getCatchedNotification();
        
        // We assert to receive a SET of aDivision.numberEmployeesOfTheMonth to 1.
        assertNotNull(notification);
        assertEquals(this.numberEmployeesOfTheMonth, notification.getFeature());
        assertEquals(this.aDivision, notification.getNotifier());
        assertTrue(notification.getEventType() == Notification.SET);
        assertEquals(new Integer(1), notification.getNewValue());
        
    }
    
    @Test
    public void testSingleValuedFeatureUnset() {
    	// TODO: implement me    	
    }

    @Test
    public void testMultiValuedFeatureAddOne() {
    	new DerivedPropertyAdapter(this.divisionEmployeesOfTheMonth);
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Add an employee of the month to aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().add(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCatchedNotification();
        
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
    	new DerivedPropertyAdapter(this.divisionEmployeesOfTheMonth);
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Add two employees of the month to aDepartment. That will change the employeesOfTheMonth property of aDivision.
    	Collection<Employee> employeesToAdd = new ArrayList<Employee>();
    	employeesToAdd.add(this.aEmployee);
        employeesToAdd.add(this.createEmployee());
        this.aDepartment.getEmployeeOfTheMonth().addAll(employeesToAdd);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCatchedNotification();
        
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
    	
    	new DerivedPropertyAdapter(this.divisionEmployeesOfTheMonth);
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Remove an employee of the month of aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().remove(this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCatchedNotification();
        
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
    	
    	new DerivedPropertyAdapter(this.divisionEmployeesOfTheMonth);
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Remove both employees of the month of aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().removeAll(employeesToRemove);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCatchedNotification();
        
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
    	
    	new DerivedPropertyAdapter(this.divisionEmployeesOfTheMonth);
    	NotificationCatchAdapter notificationCatcher = new NotificationCatchAdapter();
    	this.aDivision.eAdapters().add(notificationCatcher);
        
    	// Move the first employee of the month of aDepartment. That will change the employeesOfTheMonth property of aDivision.
        this.aDepartment.getEmployeeOfTheMonth().move(1, this.aEmployee);
        
        // The DerivedPropertyAdapter will cause aDivision to send a change notification for it's derived property employeesOfTheMonth.
        Notification notification = notificationCatcher.getCatchedNotification();
        
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
    	
    	private Notification catchedNotification = null;
		private Notifier target = null;

		public Notification getCatchedNotification() {
			return catchedNotification;
		}

		public void notifyChanged(Notification notification) {
			if(catchedNotification == null)
				catchedNotification = notification;
		}

		public Notifier getTarget() {
	        return target;
	    }

	    public void setTarget(Notifier newTarget) {
	        target = newTarget;
	    }

	    public boolean isAdapterForType(Object type) {
	        return type == DerivedPropertyAdapter.class;
	    }
    	
    }
}
