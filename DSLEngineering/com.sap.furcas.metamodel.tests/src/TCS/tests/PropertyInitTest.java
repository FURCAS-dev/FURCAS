/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.tests;

import TCS.PropertyInit;
import TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Property Init</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyInitTest extends SequenceElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PropertyInitTest.class);
	}

	/**
	 * Constructs a new Property Init test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyInitTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Property Init test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PropertyInit getFixture() {
		return (PropertyInit)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createPropertyInit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PropertyInitTest
