/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Negative Integer Val</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NegativeIntegerValTest extends ValueTest {

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static void main(String[] args) {
		TestRunner.run(NegativeIntegerValTest.class);
	}

        /**
	 * Constructs a new Negative Integer Val test case with the given name.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NegativeIntegerValTest(String name) {
		super(name);
	}

        /**
	 * Returns the fixture for this Negative Integer Val test case.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected NegativeIntegerVal getFixture() {
		return (NegativeIntegerVal)fixture;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
        @Override
        protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createNegativeIntegerVal());
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

} //NegativeIntegerValTest
