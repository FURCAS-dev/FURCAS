/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>And Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AndFilterTest extends EventFilterTest {

    protected EventFilter trueFilter;
    protected EventFilter falseFilter;

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
        this.trueFilter= new TrueFilter();
        this.falseFilter= new FalseFilter();
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
     * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
     * @generated NOT
     */
    public void testMatchesFor__NotificationTwoTrue() {
        getFixture().getOperands().add(trueFilter);
        getFixture().getOperands().add(trueFilter);
        assertTrue("Two true is true", getFixture().matchesFor(null));
    }
    public void testMatchesFor__NotificationTwoFalse() {
        getFixture().getOperands().add(falseFilter);
        getFixture().getOperands().add(falseFilter);
        assertFalse("Two false is false", getFixture().matchesFor(null));
    }
    public void testMatchesFor__Notification() {
        getFixture().getOperands().add(falseFilter);
        getFixture().getOperands().add(trueFilter);
        assertFalse("Two true/false is false", getFixture().matchesFor(null));
    }

    public void testBuildNotificationIdentifiers__NotificationIdentifier() {
        getFixture().getOperands().add(falseFilter);
        getFixture().getOperands().add(trueFilter);
        EList<NotificationIdentifier> result = getFixture().buildNotificationIdentifiers(null);
        assertTrue(result.size()==1);
        assertNull(result.get(0));
    }



} //AndFilterTest
