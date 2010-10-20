/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.HexadecimalMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hexadecimal Mapping</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HexadecimalMappingTest extends MappingTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(HexadecimalMappingTest.class);
        }

        /**
         * Constructs a new Hexadecimal Mapping test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public HexadecimalMappingTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Hexadecimal Mapping test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected HexadecimalMapping getFixture() {
                return (HexadecimalMapping)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createHexadecimalMapping());
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

} //HexadecimalMappingTest
