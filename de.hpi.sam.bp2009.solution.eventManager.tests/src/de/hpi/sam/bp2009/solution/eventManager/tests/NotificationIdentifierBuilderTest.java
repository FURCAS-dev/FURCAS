/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import java.util.HashSet;
import java.util.Set;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EcoreUtil;

import company.CompanyFactory;
import company.Department;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierBuilder;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Notification Identifier Builder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierBuilder#buildFrom(org.eclipse.emf.common.notify.Notification) <em>Build From</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class NotificationIdentifierBuilderTest extends BaseDepartmentTest {

	/**
	 * The fixture for this Notification Identifier Builder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationIdentifierBuilder fixture = null;
	private Notification noti;
	private NotificationIdentifier id;
	private NotificationIdentifier id1;
	private Department depart;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NotificationIdentifierBuilderTest.class);
	}


	/**
	 * Sets the fixture for this Notification Identifier Builder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(NotificationIdentifierBuilder fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Notification Identifier Builder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationIdentifierBuilder getFixture() {
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
		super.setUp();
	       // create some instances
        this.createInstances( 1, 5, 1 );
		setFixture(EventManagerFactory.eINSTANCE.createNotificationIdentifierBuilder());
		depart =   comp.getCompanyFactory().createDepartment();
		noti = NotificationHelper.createReferenceAddNotification(this.aDivision, this.departmentRef,depart);
		id = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		id.setEventType(Notification.ADD_MANY);
		id.setFeatureURI(EcoreUtil.getURI(this.employeeRef));
		id.setNotifierClassURI(EcoreUtil.getURI(this.department));
		id.setReset(false);
		id.setTouch(true);
		id.getOldValueClassURIs();
		id.getNewValueClassURIs().add(EcoreUtil.getURI(this.employee));
		id.setContainment(true);
		
		id1 =EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		id1.setEventType(Notification.ADD);
		id1.setFeatureURI(EcoreUtil.getURI(this.departmentRef));
		id1.setNotifierClassURI(EcoreUtil.getURI(this.division));
		id1.setReset(false);
		id1.setTouch(false);
		id1.getNewValueClassURIs().add(EcoreUtil.getURI(this.department));
		id1.getOldValueClassURIs();
		id1.setContainment(true);
		
		
		
		
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown()   {
		super.tearDown();
		depart = null;
		id = null;
		id1 = null;
		noti = null;
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierBuilder#buildFrom(org.eclipse.emf.common.notify.Notification) <em>Build From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierBuilder#buildFrom(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	public void testBuildFrom__Notification() {
		Set<NotificationIdentifier> shouldBe = new HashSet<NotificationIdentifier>();
		shouldBe.add(id1);
		Set<NotificationIdentifier> result = getFixture().buildFrom(noti);
		assertEquals(shouldBe, result);
	}
	public void testBuildFrom__NotificationContainment() {
		HashSet<NotificationIdentifier> shouldBe = new HashSet<NotificationIdentifier>();
		shouldBe.add(id1);
		shouldBe.add(id);
		HashSet<NotificationIdentifier> unfortunately = new HashSet<NotificationIdentifier>();
		unfortunately.add(id);
		unfortunately.add(id1);

		depart.getEmployee().add(CompanyFactory.eINSTANCE.createEmployee());
		Set<NotificationIdentifier> result = getFixture().buildFrom(noti);
		assertEquals("same order as expected",unfortunately, result);
		
		assertEquals("Problem with ordered Lists",shouldBe, result);
	}

} //NotificationIdentifierBuilderTest
