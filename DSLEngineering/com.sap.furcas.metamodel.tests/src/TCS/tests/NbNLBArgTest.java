/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.tests;

import TCS.NbNLBArg;
import TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Nb NLB Arg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NbNLBArgTest extends BlockArgTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NbNLBArgTest.class);
	}

	/**
	 * Constructs a new Nb NLB Arg test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NbNLBArgTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Nb NLB Arg test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NbNLBArg getFixture() {
		return (NbNLBArg)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createNbNLBArg());
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

} //NbNLBArgTest
