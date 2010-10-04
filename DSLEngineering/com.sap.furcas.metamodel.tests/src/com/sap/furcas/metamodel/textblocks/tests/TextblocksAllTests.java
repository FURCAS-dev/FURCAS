/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Textblocks</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextblocksAllTests extends TestSuite {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(suite());
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static Test suite() {
                TestSuite suite = new TextblocksAllTests("Textblocks Tests");
                suite.addTest(TextblocksTests.suite());
                return suite;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public TextblocksAllTests(String name) {
                super(name);
        }

} //TextblocksAllTests
