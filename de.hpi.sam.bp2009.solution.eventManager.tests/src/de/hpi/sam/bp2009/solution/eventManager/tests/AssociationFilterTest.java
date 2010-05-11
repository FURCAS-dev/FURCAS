/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Association Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.AssociationFilter#setReference(org.eclipse.emf.ecore.EReference) <em>Set Reference</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AssociationFilterTest extends StructuralFeatureFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AssociationFilterTest.class);
	}

	/**
	 * Constructs a new Association Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AssociationFilterTest() {
		super();
	}

	private EReference reference;


	/**
	 * Returns the fixture for this Association Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AssociationFilter getFixture() {
		return (AssociationFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp()  {
		super.setUp();
		this.createInstances( 1, 5, 1 );

		setFixture(EventManagerFactory.eINSTANCE.createAssociationFilter());
		this.reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName("myReference");
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown() {
		super.tearDown();
		setFixture(null);
		this.reference = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.AssociationFilter#setReference(org.eclipse.emf.ecore.EReference) <em>Set Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.AssociationFilter#setReference(org.eclipse.emf.ecore.EReference)
	 * @generated NOT
	 */
	public void testSetReference__EReference() {
		getFixture().setReference(reference);
		assertSame(getFixture().getFeature(), reference);
	}

} //AssociationFilterTest
