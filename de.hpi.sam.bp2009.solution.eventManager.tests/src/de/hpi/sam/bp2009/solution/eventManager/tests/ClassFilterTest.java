/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Class Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassFilterTest extends EventFilterTest {

	private EClass cls;
	private NotificationIdentifier id;
	private DynamicEObjectImpl inst;
	private NotificationImpl noti;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ClassFilterTest.class);
	}


	/**
	 * Constructs a new Class Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ClassFilterTest() {
		super();
	}


	/**
	 * Returns the fixture for this Class Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ClassFilter getFixture() {
		return (ClassFilter)fixture;
	}


	public class TestNoti extends NotificationImpl{

		private Object notifier;
		public TestNoti(int eventType, boolean oldBooleanValue,
				boolean newBooleanValue, Object noti) {
			super(eventType, oldBooleanValue, newBooleanValue);
			notifier = noti;
		}
		@Override
		public Object getNotifier() {
			return notifier;
		}
		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	public void setUp() {
		setFixture(EventManagerFactory.eINSTANCE.createClassFilter());
		cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName("theClass");
		inst = new DynamicEObjectImpl(cls);
		id = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		noti = new TestNoti(0, false, false, inst);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown()    {
		cls = null;
		inst = null;
		id = null;
		noti = null;
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	public void testMatchesFor__Notification() {
		getFixture().setWantedClass(cls);
		assertTrue("Matches an Event from the given class", 
				getFixture().matchesFor(noti));
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier) <em>Build Notification Identifiers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier)
	 * @generated NOT
	 */
	public void testBuildNotificationIdentifiers__NotificationIdentifier() {
		getFixture().setWantedClass(cls);
		NotificationIdentifier ni = getFixture().buildNotificationIdentifiers(id).get(0);
		
		assertEquals(EcoreUtil.getURI(cls), ni.getNotifierClassURI() );
	}

} //ClassFilterTest
