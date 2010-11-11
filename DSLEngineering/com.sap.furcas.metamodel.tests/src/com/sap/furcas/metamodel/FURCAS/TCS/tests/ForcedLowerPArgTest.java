/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Forced Lower PArg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForcedLowerPArgTest extends PropertyArgTest {

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static void main(String[] args) {
		TestRunner.run(ForcedLowerPArgTest.class);
	}

        /**
	 * Constructs a new Forced Lower PArg test case with the given name.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public ForcedLowerPArgTest(String name) {
		super(name);
	}

        /**
	 * Returns the fixture for this Forced Lower PArg test case.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected ForcedLowerPArg getFixture() {
		return (ForcedLowerPArg)fixture;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
        @Override
        protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createForcedLowerPArg());
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

} //ForcedLowerPArgTest
