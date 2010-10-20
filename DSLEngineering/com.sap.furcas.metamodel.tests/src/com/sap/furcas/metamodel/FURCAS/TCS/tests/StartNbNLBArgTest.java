/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Start Nb NLB Arg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StartNbNLBArgTest extends BlockArgTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(StartNbNLBArgTest.class);
        }

        /**
         * Constructs a new Start Nb NLB Arg test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public StartNbNLBArgTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Start Nb NLB Arg test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected StartNbNLBArg getFixture() {
                return (StartNbNLBArg)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createStartNbNLBArg());
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

} //StartNbNLBArgTest
