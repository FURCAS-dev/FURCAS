/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Lookup Property Init</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LookupPropertyInitTest extends PropertyInitTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(LookupPropertyInitTest.class);
        }

        /**
         * Constructs a new Lookup Property Init test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public LookupPropertyInitTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Lookup Property Init test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected LookupPropertyInit getFixture() {
                return (LookupPropertyInit)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createLookupPropertyInit());
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

} //LookupPropertyInitTest
