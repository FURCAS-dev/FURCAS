/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import company.CompanyFactory;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Structural Feature Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralFeatureFilterTest extends EventFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StructuralFeatureFilterTest.class);
	}


	/**
	 * Constructs a new Structural Feature Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StructuralFeatureFilterTest() {
		super();
	}


	private Notification noti;


	/**
	 * Returns the fixture for this Structural Feature Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StructuralFeatureFilter getFixture() {
		return (StructuralFeatureFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	public void setUp() {
		setFixture(EventManagerFactory.eINSTANCE.createStructuralFeatureFilter());
		super.setUp();
		this.createInstances( 1, 5, 1 );
		noti = NotificationHelper.createReferenceAddNotification(aDivision, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
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
	}


	@Override
	public void testMatchesFor__Notification() {
		getFixture().setFeature(this.departmentRef);
		assertTrue(getFixture().matchesFor(noti));
		getFixture().setFeature(this.directedRef);
		assertFalse(getFixture().matchesFor(noti));
	}


	@Override
	public void testBuildNotificationIdentifiers__NotificationIdentifier() {
		NotificationIdentifier inId = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		NotificationIdentifier should = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		should.setFeatureURI(EcoreUtil.getURI(this.departmentRef));
		getFixture().setFeature(this.departmentRef);
		EList<NotificationIdentifier> actual = getFixture().buildNotificationIdentifiers(inId);
		assertTrue(actual.contains(should));
		getFixture().setFeature(this.directedRef);
		actual = getFixture().buildNotificationIdentifiers(inId);
		assertFalse(actual.contains(should));
		
	}

} //StructuralFeatureFilterTest
