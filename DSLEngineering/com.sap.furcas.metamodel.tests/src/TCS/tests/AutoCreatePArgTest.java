/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.tests;

import TCS.AutoCreatePArg;
import TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Auto Create PArg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AutoCreatePArgTest extends PropertyArgTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AutoCreatePArgTest.class);
	}

	/**
	 * Constructs a new Auto Create PArg test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoCreatePArgTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Auto Create PArg test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AutoCreatePArg getFixture() {
		return (AutoCreatePArg)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createAutoCreatePArg());
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

} //AutoCreatePArgTest
