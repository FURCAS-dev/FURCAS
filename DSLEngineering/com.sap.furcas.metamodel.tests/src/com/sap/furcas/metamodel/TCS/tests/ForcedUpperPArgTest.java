/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.tests;

import com.sap.furcas.metamodel.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Forced Upper PArg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForcedUpperPArgTest extends PropertyArgTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(ForcedUpperPArgTest.class);
        }

        /**
         * Constructs a new Forced Upper PArg test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ForcedUpperPArgTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Forced Upper PArg test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected ForcedUpperPArg getFixture() {
                return (ForcedUpperPArg)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createForcedUpperPArg());
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

} //ForcedUpperPArgTest
