/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Custom Separator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomSeparatorTest extends SequenceElementTest {

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static void main(String[] args) {
        TestRunner.run(CustomSeparatorTest.class);
    }

        /**
     * Constructs a new Custom Separator test case with the given name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public CustomSeparatorTest(String name) {
        super(name);
    }

        /**
     * Returns the fixture for this Custom Separator test case.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected CustomSeparator getFixture() {
        return (CustomSeparator)fixture;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
        @Override
        protected void setUp() throws Exception {
        setFixture(TCSFactory.eINSTANCE.createCustomSeparator());
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

} //CustomSeparatorTest
