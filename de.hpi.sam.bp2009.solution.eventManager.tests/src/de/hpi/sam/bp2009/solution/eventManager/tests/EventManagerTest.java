/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotifierImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import company.CompanyFactory;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.tests.util.EventManagerHelper;
import de.hpi.sam.bp2009.solution.eventManager.util.EventFilterFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

public class EventManagerTest extends BaseDepartmentTest {

    protected EventManager fixture = null;
    private Notifier noti;
    private EventFilter filter;
    private Adapter adapter;
    private Notification lastMsg;
    Notification matchingNotification;

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
        // setFixture(EventManagerFactory.eINSTANCE.createEventManager());
        super.setUp();
        this.createInstances(1, 3, 4);
        setFixture(EventManagerFactory.eINSTANCE.createEventManagerTableBased());
        noti = new NotifierImpl();
        matchingNotification = NotificationHelper.createAttributeChangeNotification(this.aEmployee, this.employeeAge,
                new Long(23), new Long(42));

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
        setFixture(null);
        noti = null;
        filter = null;
        adapter = null;
        lastMsg = null;
        matchingNotification = null;
    }

    public void testSubscribe__EList_EventFilter_Adapter() {
        getFixture().subscribe(EventManagerHelper.getEListFor(noti), filter, adapter);
        assertTrue(noti.eAdapters().size() == 1);
    }

    public void testSubscribeTransactional__EList_EventFilter_Adapter() {
        System.err.println("Implement ME -- SubscribeTransactional__EList_EventFilter_Adapter");
    }


    public void testNotifyApplication__Adapter_Notification_EventFilter() {
        getFixture().notifyApplication(adapter, matchingNotification, filter);
        assertTrue("Application gets notified", matchingNotification.equals(lastMsg));
    }


    public void testHandleEMFEvent__Notification() {
        /*
         * register Application
         */
        getFixture().subscribe(EventManagerHelper.getEListFor(noti), filter, adapter);

        getFixture().handleEMFEvent(matchingNotification);

        assertEquals(matchingNotification, lastMsg);

    }
    @Test
    public void testSimpleElementInsertFilter( ) {
        EventFilter f =EventFilterFactory.getInstance().createFilterForElementInsertionOrDeletion(this.department);
        comp.eResource().getContents().add(aDivision);
        Bool newBool = new Bool();
        filterStatementsWithEM(f, newBool);
        NotificationHelper.createElementAddNotification(aDivision, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
        
        assertTrue(newBool.is);
       
    }
    @Test
    public void testDoubleElementInsertFilter( ) {
        EventFilter f1 =EventFilterFactory.getInstance().createFilterForElementInsertionOrDeletion(this.department);
        EventFilter f2 =EventFilterFactory.getInstance().createFilterForElementInsertionOrDeletion(this.department);
        EventFilter f = new OrFilter(f1,f2);
        comp.eResource().getContents().add(aDivision);
        Bool newBool = new Bool();
        filterStatementsWithEM(f, newBool);
        NotificationHelper.createElementAddNotification(aDivision, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
        
        assertTrue(newBool.is);
       
    }
    private void filterStatementsWithEM(EventFilter filter, Bool b) {

            MyApp app = new MyApp(b);
            EventManager m=EventManagerFactory.eINSTANCE.createEventManagerTableBased();
            EList<Notifier> l = new BasicEList<Notifier>();
            l.add(this.comp.eResource());
            m.subscribe(l, filter, app);
    }
    public class Bool{
        public boolean is=false;
    }
    public void testUnsubscribe__Adapter() {
        getFixture().subscribe(EventManagerHelper.getEListFor(noti), filter, adapter);
        getFixture().unsubscribe(adapter);

        assertFalse((matchingNotification.equals(lastMsg)));
        assertNull(lastMsg);
    }

    public class MyApp extends AdapterImpl {
        private final Bool b;

        public MyApp(Bool b1) {
            b=b1;
        }

        @Override
        public void notifyChanged(Notification msg) {
            this.b.is=true;

        }

    }

} // EventManagerTest
