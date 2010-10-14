/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Or Filter</b></em>'. <!-- end-user-doc -->
 */
public class OrFilterTest extends LogicalEventFilterTest {

    public OrFilterTest() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(OrFilterTest.class);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        super.setUp();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        super.tearDown();
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * <em>Matches For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     */
    public void testMatchesFor__NotificationTwoTrue() {
        OrFilter or = EventManagerFactory.eINSTANCE.createOrFilterFor(trueFilter, trueFilter);
        assertTrue("Two true is true", or.matchesFor(null));
    }

    public void testMatchesFor__NotificationTwoFalse() {
        OrFilter or = EventManagerFactory.eINSTANCE.createOrFilterFor(falseFilter, falseFilter);
        assertFalse("Two false is false", or.matchesFor(null));
    }

    public void testMatchesFor__Notification() {
        OrFilter or = EventManagerFactory.eINSTANCE.createOrFilterFor(falseFilter, trueFilter);
        assertTrue("Two true/false is true", or.matchesFor(null));
    }

} // OrFilterTest
