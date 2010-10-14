/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter#setAttribute(org.eclipse.emf.ecore.EAttribute) <em>Set Attribute</em>}</li>
 * </ul>
 * </p>
 */
public class AttributeFilterTest extends StructuralFeatureFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(AttributeFilterTest.class);
	}

	/**
	 * Constructs a new Attribute Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public AttributeFilterTest() {
		super();
	}

	private EAttribute attribute;


	/**
	 * Returns the fixture for this Attribute Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected AttributeFilter getFixture() {
		return (AttributeFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp()  {
		super.setUp();
		setFixture(EventManagerFactory.eINSTANCE.createAttributeFilter(null));
		this.attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("myAttribute");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown()   {
		super.tearDown();
		setFixture(null);
		this.attribute = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter#setAttribute(org.eclipse.emf.ecore.EAttribute) <em>Set Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter#setAttribute(org.eclipse.emf.ecore.EAttribute)
	 */
	public void testSetAttribute__EAttribute() {
		AttributeFilter filter = EventManagerFactory.eINSTANCE.createAttributeFilter(attribute);
		assertSame(filter.getFeature(), attribute);
	}

} //AttributeFilterTest
