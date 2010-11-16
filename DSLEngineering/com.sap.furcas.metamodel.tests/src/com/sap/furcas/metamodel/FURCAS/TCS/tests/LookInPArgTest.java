/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Look In PArg</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LookInPArgTest extends PropertyArgTest {

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static void main(String[] args) {
        TestRunner.run(LookInPArgTest.class);
    }

        /**
     * Constructs a new Look In PArg test case with the given name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public LookInPArgTest(String name) {
        super(name);
    }

        /**
     * Returns the fixture for this Look In PArg test case.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected LookInPArg getFixture() {
        return (LookInPArg)fixture;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
        @Override
        protected void setUp() throws Exception {
        setFixture(TCSFactory.eINSTANCE.createLookInPArg());
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

} //LookInPArgTest
