package org.eclipse.ocl.examples.impactanalyzer.tests.derivedPropertyHandling;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.impl.DerivedPropertyAdapter;
import org.eclipse.ocl.examples.impactanalyzer.testutils.BaseDepartmentTestWithOCL;
import org.junit.Test;

import company.impl.DivisionImpl;

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
    public void testSingleValuedFeature() {
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
    public void testSingleValuedUnsettableFeature() {
    	// TODO: implement me
    	assertTrue(true);
    }

    @Test
    public void testMultiValuedFeature() {
    	// TODO: implement me
    	assertTrue(true);
    }
    
    /**
     * A dummy {@link Adapter} that simply catches the first {@link Notification} it receives.
     * 
     * @author Martin Hanysz
     *
     */
    private class NotificationCatchAdapter implements Adapter{
    	
    	private Notification catchedNotification;
		private Notifier target;

		public Notification getCatchedNotification() {
			return catchedNotification;
		}

		public void notifyChanged(Notification notification) {
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
