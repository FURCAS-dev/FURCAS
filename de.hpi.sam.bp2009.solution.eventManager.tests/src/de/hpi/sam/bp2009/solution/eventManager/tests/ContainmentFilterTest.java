/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Containment Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainmentFilterTest extends EventFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ContainmentFilterTest.class);
	}

	private DynamicEObjectImpl containedObject;
	private ENotificationImpl matchingNotification;

	/**
	 * Constructs a new Containment Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ContainmentFilterTest() {
		super();
	}

	/**
	 * Returns the fixture for this Containment Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ContainmentFilter getFixture() {
		return (ContainmentFilter)fixture;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setUp()  {
		setFixture(EventManagerFactory.eINSTANCE.createContainmentFilter());
		EReference cFeature = EcoreFactory.eINSTANCE.createEReference();
		cFeature.setName("test");
		cFeature.setContainment(true);
		cFeature.setLowerBound(0);
		cFeature.setUpperBound(-1);
		EPackage p= EcoreFactory.eINSTANCE.createEPackage();
		p.setName("test");
		p.setNsPrefix("test");
		p.setNsURI("uri");
		EClass notiClass = EcoreFactory.eINSTANCE.createEClass();
		p.getEClassifiers().add(notiClass);
		notiClass.setName("testClass");
		cFeature.setEType(notiClass);
		notiClass.getEStructuralFeatures().add(cFeature);
		EObject testObject = new DynamicEObjectImpl(notiClass);
		containedObject = new DynamicEObjectImpl(notiClass);
		((EList)testObject.eGet(cFeature)).add(containedObject);
		matchingNotification = new ENotificationImpl((InternalEObject)testObject, Notification.ADD_MANY, cFeature, new BasicEList<EObject>(), testObject.eGet(cFeature));
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown() {
		setFixture(null);
		containedObject = null;
		matchingNotification = null;
	}

	@Override
	public void testMatchesFor__Notification() {
		assertTrue(getFixture().matchesFor(matchingNotification));
	}

	@Override
	public void testBuildNotificationIdentifiers__NotificationIdentifier() {
		EList<NotificationIdentifier> result = getFixture().buildNotificationIdentifiers(EventManagerFactory.eINSTANCE.createNotificationIdentifier());
		assertTrue(result!=null && result.size()==1);
		assertTrue(result.get(0).isContainment());
		
	}

} //ContainmentFilterTest
