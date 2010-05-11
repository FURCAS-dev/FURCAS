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

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>And Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AndFilterTest extends EventFilterTest {

	protected EventFilterImpl trueFilter;
	protected EventFilterImpl falseFilter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AndFilterTest.class);
	}


	/**
	 * Constructs a new And Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AndFilterTest() {
		super();
	}


	/**
	 * Returns the fixture for this And Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AndFilter getFixture() {
		return (AndFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	public void setUp() {
		setFixture(EventManagerFactory.eINSTANCE.createAndFilter());
		this.trueFilter= new EventFilterImpl() {
			
			@Override
			public boolean matchesFor(Notification event) {
				return true;
				
			}
			
			@Override
			public EList<NotificationIdentifier> buildNotificationIdentifiers(
					NotificationIdentifier identifier) {
				EList<NotificationIdentifier> test = new BasicEList<NotificationIdentifier>();
				test.add(identifier);
				return test ;
				
			}
		};
		this.falseFilter= new EventFilterImpl() {
			
			@Override
			public boolean matchesFor(Notification event) {
				return false;
				
			}
			
			@Override
			public EList<NotificationIdentifier> buildNotificationIdentifiers(
					NotificationIdentifier identifier) {
				EList<NotificationIdentifier> test = new BasicEList<NotificationIdentifier>();
				test.add(identifier);
				if(identifier!=null){
					identifier.setEventType(666);
				}
				return test ;
				
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
	public void tearDown() {
		setFixture(null);
		this.falseFilter = null;
		this.trueFilter = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	public void testMatchesFor__NotificationTwoTrue() {
		getFixture().getFilters().add(trueFilter);
		getFixture().getFilters().add(trueFilter);
		assertTrue("Two true is true", getFixture().matchesFor(null));
	}
	public void testMatchesFor__NotificationTwoFalse() {
		getFixture().getFilters().add(falseFilter);
		getFixture().getFilters().add(falseFilter);
		assertFalse("Two false is false", getFixture().matchesFor(null));
	}
	public void testMatchesFor__Notification() {
		getFixture().getFilters().add(falseFilter);
		getFixture().getFilters().add(trueFilter);
		assertFalse("Two true/false is false", getFixture().matchesFor(null));
	}

	public void testBuildNotificationIdentifiers__NotificationIdentifier() {
		getFixture().getFilters().add(falseFilter);
		getFixture().getFilters().add(trueFilter);
		EList<NotificationIdentifier> result = getFixture().buildNotificationIdentifiers(null);
		assertTrue(result.size()==1);
		assertNull(result.get(0));
	}



} //AndFilterTest
