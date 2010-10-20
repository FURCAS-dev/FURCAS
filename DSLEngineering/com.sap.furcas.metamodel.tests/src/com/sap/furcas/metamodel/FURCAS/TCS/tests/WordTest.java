/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.Word;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WordTest extends NamedElementTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(WordTest.class);
        }

        /**
         * Constructs a new Word test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public WordTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Word test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected Word getFixture() {
                return (Word)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createWord());
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

} //WordTest
