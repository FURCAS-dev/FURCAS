package de.hpi.sam.bp2009.solution.eventManager.tests.framework;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.tests.FilterSynthesisTest;

public class IncludeSubclassesTest extends FilterSynthesisTest {
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
    
    public void testIncludingSubclassesFilterStudentGotStudent(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(student);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(student), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
    public void testIncludingSubclassesFilterEmployeeGotStudent(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(employee);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(student), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
    public void testIncludingSubclassesFilterEmployeeGotFreelancer(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createFilterForElementInsertion(employee);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(freelance), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
    public void testIncludingSubclasses3(){
        EventFilter filter = EventManagerFactory.eINSTANCE.createClassFilterIncludingSubclasses(employee);
        App app = new App();
        m.subscribe(filter, app);
        NotificationHelper.createNewElementAddToResourceNotification(this.comp.getEFactoryInstance().create(freelance), this.comp.eResource());
        
        assertTrue(app.noti);
        
    }
}
