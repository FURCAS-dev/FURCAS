package org.eclipse.ocl.examples.eventmanager.tests;


import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.tests.EventManagerTest.Application;

public class LogicalFilterTest extends TestCase {
	private EventManager fixture;
	private Application app;
	private EClass eClass1;
	private EventFilter featureFilterRef;
	private DynamicEObjectImpl eObjectCls1;
	private EClass eClass2;
	private DynamicEObjectImpl eObjectCls2;
	private EClass eClass3;
	private DynamicEObjectImpl eObjectCls3;
	private EClass eClass4;
	private DynamicEObjectImpl eObjectCls4;
	private EReference ref;
	private EventFilter typeFilterAdd;
	private EventFilter classFilterCls1;
	private EventFilter oldValueFilterCls2;
	private EventFilter newValueFilterCls2;
	private EventFilter newValueFilterCls3;
	private EventFilter newValueFilterWithSubclassesCls3;
	private EventFilter newValueFilterWithSubclassesCls4;
	
	public void setUp() throws Exception {
		fixture = EventManagerFactory.eINSTANCE.createEventManager();
		app = new Application();
		eClass1 = EcoreFactory.eINSTANCE.createEClass();
		eClass1.setName("c1");
		eObjectCls1 = new DynamicEObjectImpl(eClass1);
		eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("c2");
		eObjectCls2 = new DynamicEObjectImpl(eClass2);		
		eClass3 = EcoreFactory.eINSTANCE.createEClass();
		eClass3.setName("c3");
		eObjectCls3 = new DynamicEObjectImpl(eClass3);
		eClass4 = EcoreFactory.eINSTANCE.createEClass();
		eClass4.setName("c4");
		eClass4.getESuperTypes().add(eClass3); // c4 extends c3
		eObjectCls4 = new DynamicEObjectImpl(eClass4);
		ref = EcoreFactory.eINSTANCE.createEReference();

		typeFilterAdd = EventManagerFactory.eINSTANCE.createEventTypeFilter(Notification.ADD);
		classFilterCls1 = EventManagerFactory.eINSTANCE.createClassFilter(eClass1);
		oldValueFilterCls2 = EventManagerFactory.eINSTANCE.createOldValueClassFilter(eClass2);
		newValueFilterCls2 = EventManagerFactory.eINSTANCE.createNewValueClassFilter(eClass2);
		newValueFilterCls3 = EventManagerFactory.eINSTANCE.createNewValueClassFilter(eClass3);
		newValueFilterWithSubclassesCls3 = EventManagerFactory.eINSTANCE.createNewValueClassFilterIncludingSubclasses(eClass3);
		newValueFilterWithSubclassesCls4 = EventManagerFactory.eINSTANCE.createNewValueClassFilterIncludingSubclasses(eClass4);
		featureFilterRef = EventManagerFactory.eINSTANCE.createStructuralFeatureFilter(ref);
	}

	public void tearDown() throws Exception {
		fixture.unsubscribe(app);
		fixture=null;
		app=null;
	}
	
	public void testMatchingAndWithSameFilterTypeOnSameElementOfMultiNewValue() {
		EList<EObject> newValue = new BasicEList<EObject>();
		newValue.add(eObjectCls3);
		newValue.add(eObjectCls4);
		Notification n = new ENotificationImpl((InternalEObject) eObjectCls1,
				Notification.ADD_MANY, ref, null, newValue);
		// require an element from newValue to match both eClass3 and eClass4
		// which is possible because eClass4 extends eClass3
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				newValueFilterWithSubclassesCls3, newValueFilterWithSubclassesCls4); 
		assertTrue(f.matchesFor(n)); // should match because eObjectCls4 matches both filters
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testMatchingAndWithSameFilterTypeOnDifferentElementsOfMultiNewValue() {
		EList<EObject> newValue = new BasicEList<EObject>();
		newValue.add(eObjectCls2);
		newValue.add(eObjectCls3);
		Notification n = new ENotificationImpl((InternalEObject) eObjectCls1,
				Notification.ADD_MANY, ref, null, newValue);
		// require an element from newValue to match both eClass3 and eClass4
		// which is not possible for a single element because eClass2 and eClass3 are
		// not in any inheritance relationship
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				newValueFilterCls2, newValueFilterCls3); 
		// neither eObjectCls2 nor eObjectCls3 both fulfill filter for eClass2+eClass3,
		// but each individual NewValueClassFilter matches one of the two objects, and
		// so the AndFilter matches, too.
		assertTrue(f.matchesFor(n));
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleAndFilter1Stage(){
		Notification n = new ENotificationImpl((InternalEObject) eObjectCls1, Notification.ADD, ref, eObjectCls2, eObjectCls3);
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(typeFilterAdd,classFilterCls1,oldValueFilterCls2,newValueFilterCls3,featureFilterRef);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleAndFilter3Stage(){
		Notification n = new ENotificationImpl((InternalEObject) eObjectCls1, Notification.ADD, ref, eObjectCls2, eObjectCls3);
		EventFilter f7 = EventManagerFactory.eINSTANCE.createAndFilterFor(
				EventManagerFactory.eINSTANCE.createAndFilterFor(
						typeFilterAdd,
						classFilterCls1),
						EventManagerFactory.eINSTANCE.createAndFilterFor(
								oldValueFilterCls2,
								EventManagerFactory.eINSTANCE.createAndFilterFor(
										newValueFilterCls3,
										featureFilterRef)));
		fixture.subscribe(f7, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter1Stage1(){
		Notification n = new ENotificationImpl((InternalEObject) eObjectCls1, 0, null, null, null);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(typeFilterAdd,classFilterCls1,oldValueFilterCls2,newValueFilterCls3,featureFilterRef);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter1Stage2(){
		Notification n = new ENotificationImpl(null, Notification.ADD, null, null, null);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(typeFilterAdd,classFilterCls1,oldValueFilterCls2,newValueFilterCls3,featureFilterRef);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter1Stage3(){
		Notification n = new ENotificationImpl(null, 0, null, eObjectCls2, null);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(typeFilterAdd,classFilterCls1,oldValueFilterCls2,newValueFilterCls3,featureFilterRef);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter1Stage4(){
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(typeFilterAdd,classFilterCls1,oldValueFilterCls2,newValueFilterCls3,featureFilterRef);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter1Stage5(){
		Notification n = new ENotificationImpl(null, 0, null, null, null);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(typeFilterAdd,classFilterCls1,oldValueFilterCls2,newValueFilterCls3,featureFilterRef);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertFalse("Get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter2Stage1(){
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						typeFilterAdd,
						classFilterCls1),
						EventManagerFactory.eINSTANCE.createOrFilterFor(
								EventManagerFactory.eINSTANCE.createOrFilterFor(
										oldValueFilterCls2,
										newValueFilterCls3),
										featureFilterRef));
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter2Stage2(){
		Notification n = new ENotificationImpl(null, 0, null, null, null);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						typeFilterAdd,
						classFilterCls1),
						EventManagerFactory.eINSTANCE.createOrFilterFor(
								EventManagerFactory.eINSTANCE.createOrFilterFor(
										oldValueFilterCls2,
										newValueFilterCls3),
										featureFilterRef));
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertFalse("Get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter2StageAndNot1(){
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						typeFilterAdd,
						classFilterCls1),
						EventManagerFactory.eINSTANCE.createOrFilterFor(
								EventManagerFactory.eINSTANCE.createOrFilterFor(
										oldValueFilterCls2,
										EventManagerFactory.eINSTANCE.createNotFilter(newValueFilterCls3)),
										featureFilterRef));
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertFalse("Get notified", app.isNotified());
	}
	
	public void testSimpleOrFilter2StageAndNot2(){
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						typeFilterAdd,
						classFilterCls1),
						EventManagerFactory.eINSTANCE.createOrFilterFor(
								EventManagerFactory.eINSTANCE.createOrFilterFor(
										oldValueFilterCls2,
										EventManagerFactory.eINSTANCE.createNotFilter(newValueFilterCls3)),
										featureFilterRef));
		f = EventManagerFactory.eINSTANCE.createNotFilter(f);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertTrue("Get not  notified", app.isNotified());
	}
	
	public void testSimpleOrFilter2StageDoubleNot(){
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						typeFilterAdd,
						classFilterCls1),
						EventManagerFactory.eINSTANCE.createOrFilterFor(
								EventManagerFactory.eINSTANCE.createOrFilterFor(
										oldValueFilterCls2,
										EventManagerFactory.eINSTANCE.createNotFilter(newValueFilterCls3)),
										featureFilterRef));
		f = EventManagerFactory.eINSTANCE.createNotFilter(f);
		f = EventManagerFactory.eINSTANCE.createNotFilter(f);
		fixture.subscribe(f, app);
		fixture.handleEMFEvent(n);
		assertFalse("Get notified", app.isNotified());
	}
	
	/**
	 * And for 2 identical expressions should get converted to one
	 */
	public void testDeMorgan1(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				EventManagerFactory.eINSTANCE.createNotFilter(
						EventManagerFactory.eINSTANCE.createAndFilterFor(
								newValueFilterCls3, 
								oldValueFilterCls2)),
								EventManagerFactory.eINSTANCE.createOrFilterFor(
										EventManagerFactory.eINSTANCE.createNotFilter(
												newValueFilterCls3
										),
										EventManagerFactory.eINSTANCE.createNotFilter(
												oldValueFilterCls2
										))
		);
		f = EventManagerFactory.eINSTANCE.createNotFilter(f);
		fixture.subscribe(f, app);
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n);
		Notification n3 = new ENotificationImpl(null, 0, null, eObjectCls2, null);
		fixture.handleEMFEvent(n3);
		assertFalse("Get notified",app.isNotified());
		Notification n4 = new ENotificationImpl(null, 0, null, eObjectCls2, eObjectCls3);
		fixture.handleEMFEvent(n4);
		assertTrue("Did not get notified",app.isNotified());
	}
	
	/**
	 * And for 2 identical expressions should get converted to one
	 */
	public void testDeMorgan2(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				EventManagerFactory.eINSTANCE.createNotFilter(
						EventManagerFactory.eINSTANCE.createOrFilterFor(
								newValueFilterCls3, 
								oldValueFilterCls2)),
								EventManagerFactory.eINSTANCE.createAndFilterFor(
										EventManagerFactory.eINSTANCE.createNotFilter(
												newValueFilterCls3
										),
										EventManagerFactory.eINSTANCE.createNotFilter(
												oldValueFilterCls2
										))
		);
		fixture.subscribe(f, app);
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n);
		Notification n3 = new ENotificationImpl(null, 0, null, eObjectCls2, null);
		fixture.handleEMFEvent(n3);
		Notification n4 = new ENotificationImpl(null, 0, null, eObjectCls2, eObjectCls3);
		fixture.handleEMFEvent(n4);
		assertFalse("Get notified",app.isNotified());
		Notification n5 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n5);
		assertTrue("Did not get notified",app.isNotified());
	}
	
	/**
	 * Tautology
	 */
	public void testDeMorganTautology(){
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						newValueFilterCls3, 
						oldValueFilterCls2),
						EventManagerFactory.eINSTANCE.createAndFilterFor(
								EventManagerFactory.eINSTANCE.createNotFilter(
										newValueFilterCls3
								),
								EventManagerFactory.eINSTANCE.createNotFilter(
										oldValueFilterCls2
								))
		);
		fixture.subscribe(f, app);
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified",app.isNotified());
		app.reset();

		Notification n3 = new ENotificationImpl(null, 0, null, eObjectCls2, null);
		fixture.handleEMFEvent(n3);
		assertTrue("Did not get notified",app.isNotified());
		app.reset();

		Notification n4 = new ENotificationImpl(null, 0, null, eObjectCls2, eObjectCls3);
		fixture.handleEMFEvent(n4);
		assertTrue("Did not get notified",app.isNotified());
		app.reset();
		Notification n5 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n5);
		assertTrue("Did not get notified",app.isNotified());
	}
	
	/**
	 * Check that negated filters has the same influence as normal
	 */
	public void testPriorityOfNegatedFilters(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				classFilterCls1, 
				EventManagerFactory.eINSTANCE.createNotFilter(newValueFilterCls3));
		fixture.subscribe(f, app);
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();

		Notification n2 = new ENotificationImpl(eObjectCls1, 0, null, null, eObjectCls2);
		fixture.handleEMFEvent(n2);
		assertTrue("Did not get notified",app.isNotified());
		app.reset();
		
		Notification n3 = new ENotificationImpl(eObjectCls1, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n3);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();

		Notification n4 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n4);
		assertFalse("Erroneously got notified",app.isNotified());
	}
	
	/**
	 * Check that negated filters has the same influence as normal
	 */
	public void testPriorityOfNegatedFiltersReversed(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				EventManagerFactory.eINSTANCE.createNotFilter(classFilterCls1), 
				newValueFilterCls3);
		fixture.subscribe(f, app);
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n);
		assertTrue("Did not get notified",app.isNotified());
		app.reset();

		Notification n2 = new ENotificationImpl(eObjectCls1, 0, null, null, eObjectCls2);
		fixture.handleEMFEvent(n2);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();
		
		Notification n3 = new ENotificationImpl(eObjectCls1, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n3);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();

		Notification n4 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n4);
		assertFalse("Erroneously got notified",app.isNotified());
	}
	
	/**
	 * Tests whether two filters of the same type in an And get handled correctly
	 */
	public void testAndForSameFilterType(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				EventManagerFactory.eINSTANCE.createClassFilter(eClass1),
				EventManagerFactory.eINSTANCE.createClassFilter(eClass2));
		fixture.subscribe(f, app);
		Notification n = new ENotificationImpl(eObjectCls1, 0, null, null, null);
		fixture.handleEMFEvent(n);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();

		Notification n3 = new ENotificationImpl(eObjectCls2, 0, null, null, null);
		fixture.handleEMFEvent(n3);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();
		Notification n6 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n6);
		assertFalse("Erroneously got notified",app.isNotified());
	}
	
	/**
	 * Tests the behavior for a simple contradiction with the same filter once not and once negated
	 */
	public void testSimpleContradiction(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				newValueFilterCls3, 
				EventManagerFactory.eINSTANCE.createNotFilter(newValueFilterCls3));
		fixture.subscribe(f, app);
		Notification n3 = new ENotificationImpl(null, 0, null, null, eObjectCls2);
		fixture.handleEMFEvent(n3);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();
		Notification n6 = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n6);
		assertFalse("Erroneously got notified",app.isNotified());
	}
	
	/**
	 * Contradiction
	 */
	public void testDeMorganContradiction(){
		EventFilter f = EventManagerFactory.eINSTANCE.createAndFilterFor(
				EventManagerFactory.eINSTANCE.createOrFilterFor(
						newValueFilterCls3,
						oldValueFilterCls2),
				EventManagerFactory.eINSTANCE.createAndFilterFor(
						EventManagerFactory.eINSTANCE.createNotFilter(newValueFilterCls3),
						EventManagerFactory.eINSTANCE.createNotFilter(oldValueFilterCls2)));
		fixture.subscribe(f, app);
		Notification n3 = new ENotificationImpl(null, 0, null, eObjectCls2, null);
		fixture.handleEMFEvent(n3);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();
		Notification n4 = new ENotificationImpl(null, 0, null, eObjectCls2, eObjectCls3);
		fixture.handleEMFEvent(n4);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();
		Notification n5 = new ENotificationImpl(null, 0, null, eObjectCls3, eObjectCls2);
		fixture.handleEMFEvent(n5);
		assertFalse("Erroneously got notified",app.isNotified());
		app.reset();
		Notification n6 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n6);
		assertFalse("Erroneously got notified",app.isNotified());
	}
	
	public void testDisjunctiveConversion(){
		EventFilter f = EventManagerFactory.eINSTANCE.createOrFilterFor(
				EventManagerFactory.eINSTANCE.createNotFilter(
						EventManagerFactory.eINSTANCE.createAndFilterFor(
								newValueFilterCls3, 
								oldValueFilterCls2)),
								newValueFilterCls3
		);
		fixture.subscribe(f, app);
		boolean notNotfied = false;
		Notification n = new ENotificationImpl(null, 0, null, null, eObjectCls3);
		fixture.handleEMFEvent(n);
		notNotfied = notNotfied ||  !app.isNotified();
		Notification n3 = new ENotificationImpl(null, 0, null, eObjectCls2, null);
		fixture.handleEMFEvent(n3);
		notNotfied = notNotfied ||  !app.isNotified();
		Notification n4 = new ENotificationImpl(null, 0, null, null, null);
		fixture.handleEMFEvent(n4);
		notNotfied = notNotfied ||  !app.isNotified();
		assertFalse("Did not get notified", notNotfied);
	}
}
