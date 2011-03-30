/**
 * 
 */
package org.eclipse.ocl.examples.eventmanager.tests.framework;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Philipp Berger
 *
 */
public class EventManagerFactoryImplTest extends TestCase {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link EventManagerFactory#getEventManagerFor(org.eclipse.emf.ecore.resource.ResourceSet)}.
     */
    @Test
    public void testGetEventManagerFor() {
        ResourceSet s1 = new ResourceSetImpl();
        ResourceSet s2 = new ResourceSetImpl();

        EventManager em1 = EventManagerFactory.eINSTANCE.getEventManagerFor(s1);
        EventManager em2 = EventManagerFactory.eINSTANCE.getEventManagerFor(s2);
        EventManager em3 = EventManagerFactory.eINSTANCE.getEventManagerFor(s1);
        EventManager em4 = EventManagerFactory.eINSTANCE.getEventManagerFor(s2);
        
        assertSame(em1, em3);
        assertSame(em2, em4);
        assertNotSame(em1, em2);
        assertNotSame(em3, em4);
    }

    /**
     * Test method for {@link EventManagerFactory#createContainmentFilter()} ensuring that
     * as opposed to earlier versions we get a new filter object for each call
     */
    @Test
    public void testCreateContainmentFilter() {
        assertNotSame(EventManagerFactory.eINSTANCE.createContainmentFilter(), EventManagerFactory.eINSTANCE.createContainmentFilter());
    }

}
