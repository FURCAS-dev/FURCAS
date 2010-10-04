/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.tests;

import com.sap.furcas.metamodel.TCS.RefersToKeyPArg;
import com.sap.furcas.metamodel.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Refers To Key PArg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefersToKeyPArgTest extends PropertyArgTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(RefersToKeyPArgTest.class);
        }

        /**
         * Constructs a new Refers To Key PArg test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public RefersToKeyPArgTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Refers To Key PArg test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected RefersToKeyPArg getFixture() {
                return (RefersToKeyPArg)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createRefersToKeyPArg());
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

} //RefersToKeyPArgTest
