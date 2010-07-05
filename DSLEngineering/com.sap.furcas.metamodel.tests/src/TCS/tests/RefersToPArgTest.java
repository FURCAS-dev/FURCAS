/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.tests;

import TCS.RefersToPArg;
import TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Refers To PArg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefersToPArgTest extends PropertyArgTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RefersToPArgTest.class);
	}

	/**
	 * Constructs a new Refers To PArg test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefersToPArgTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Refers To PArg test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RefersToPArg getFixture() {
		return (RefersToPArg)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createRefersToPArg());
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

} //RefersToPArgTest
