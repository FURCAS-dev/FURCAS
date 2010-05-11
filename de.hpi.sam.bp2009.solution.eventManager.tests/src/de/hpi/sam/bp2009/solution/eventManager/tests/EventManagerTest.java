/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.notify.impl.NotifierImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl;
import de.hpi.sam.bp2009.solution.eventManager.tests.util.EventManagerHelper;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#subscribe(org.eclipse.emf.common.util.EList, de.hpi.sam.bp2009.solution.eventManager.EventFilter, org.eclipse.emf.common.notify.Adapter) <em>Subscribe</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#subscribeTransactional(org.eclipse.emf.common.util.EList, de.hpi.sam.bp2009.solution.eventManager.EventFilter, org.eclipse.emf.common.notify.Adapter) <em>Subscribe Transactional</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#notifyApplication(org.eclipse.emf.common.notify.Adapter, org.eclipse.emf.common.notify.Notification, de.hpi.sam.bp2009.solution.eventManager.EventFilter) <em>Notify Application</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#handleEMFEvent(org.eclipse.emf.common.notify.Notification) <em>Handle EMF Event</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#unsubscribe(org.eclipse.emf.common.notify.Adapter) <em>Unsubscribe</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EventManagerTest extends TestCase {

	/**
	 * The fixture for this Event Manager test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventManager fixture = null;
	private Notifier noti;
	private EventFilter filter;
	private Adapter adapter;
	private Notification lastMsg;
	private Notification matchingNotification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EventManagerTest.class);
	}


	/**
	 * Constructs a new Event Manager test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerTest(String name) {
		super(name);
	}


	/**
	 * Sets the fixture for this Event Manager test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EventManager fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Event Manager test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventManager getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	public void setUp()   {
		setFixture(EventManagerFactory.eINSTANCE.createEventManager());
		noti = new NotifierImpl();
		matchingNotification = new NotificationImpl(0, true, false);
		filter = new EventFilterImpl() {
			
			@Override
			public boolean matchesFor(Notification event) {	
				return matchingNotification.equals(event);}
			
			@Override
			public EList<NotificationIdentifier> buildNotificationIdentifiers(
					NotificationIdentifier identifier) {
				EList<NotificationIdentifier> result = new BasicEList<NotificationIdentifier>();
				result.addAll(EventManagerFactory.eINSTANCE.createNotificationIdentifierBuilder().buildFrom(matchingNotification));
				return result;
				
			}
		};
		adapter = new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				lastMsg = msg;
				super.notifyChanged(msg);
				
			}
		};
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown()  {
		setFixture(null);
		noti = null;
		filter = null;
		adapter = null;
		lastMsg = null;
		matchingNotification = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#subscribe(org.eclipse.emf.common.util.EList, de.hpi.sam.bp2009.solution.eventManager.EventFilter, org.eclipse.emf.common.notify.Adapter) <em>Subscribe</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager#subscribe(org.eclipse.emf.common.util.EList, de.hpi.sam.bp2009.solution.eventManager.EventFilter, org.eclipse.emf.common.notify.Adapter)
	 * @generated NOT
	 */
	public void testSubscribe__EList_EventFilter_Adapter() {
		getFixture().subscribe(EventManagerHelper.getEListFor(noti), filter, adapter);
		assertTrue(noti.eAdapters().size()==1);
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#subscribeTransactional(org.eclipse.emf.common.util.EList, de.hpi.sam.bp2009.solution.eventManager.EventFilter, org.eclipse.emf.common.notify.Adapter) <em>Subscribe Transactional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager#subscribeTransactional(org.eclipse.emf.common.util.EList, de.hpi.sam.bp2009.solution.eventManager.EventFilter, org.eclipse.emf.common.notify.Adapter)
	 * @generated NOT
	 */
	public void testSubscribeTransactional__EList_EventFilter_Adapter() {
		System.err.println("Implement ME -- SubscribeTransactional__EList_EventFilter_Adapter");
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#notifyApplication(org.eclipse.emf.common.notify.Adapter, org.eclipse.emf.common.notify.Notification, de.hpi.sam.bp2009.solution.eventManager.EventFilter) <em>Notify Application</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager#notifyApplication(org.eclipse.emf.common.notify.Adapter, org.eclipse.emf.common.notify.Notification, de.hpi.sam.bp2009.solution.eventManager.EventFilter)
	 * @generated NOT
	 */
	public void testNotifyApplication__Adapter_Notification_EventFilter() {
		getFixture().notifyApplication(adapter, matchingNotification , filter);
		assertTrue("Application gets notified", matchingNotification.equals(lastMsg));
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#handleEMFEvent(org.eclipse.emf.common.notify.Notification) <em>Handle EMF Event</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager#handleEMFEvent(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	public void testHandleEMFEvent__Notification() {
		/*
		 * register Application
		 */
		getFixture().subscribe(EventManagerHelper.getEListFor(noti), filter, adapter);

		getFixture().handleEMFEvent(matchingNotification);
		
		assertEquals(matchingNotification, lastMsg);
		
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#unsubscribe(org.eclipse.emf.common.notify.Adapter) <em>Unsubscribe</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager#unsubscribe(org.eclipse.emf.common.notify.Adapter)
	 * @generated NOT
	 */
	public void testUnsubscribe__Adapter() {
		getFixture().subscribe(EventManagerHelper.getEListFor(noti), filter, adapter);
		getFixture().unsubscribe(adapter);

		assertFalse((matchingNotification.equals(lastMsg)));
		assertNull(lastMsg);
	}

} //EventManagerTest
