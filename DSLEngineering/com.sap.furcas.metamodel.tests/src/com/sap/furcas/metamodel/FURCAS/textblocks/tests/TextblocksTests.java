/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>textblocks</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextblocksTests extends TestSuite {

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
        TestSuite suite = new TextblocksTests("textblocks Tests");
        suite.addTestSuite(TextBlockTest.class);
        return suite;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TextblocksTests(String name) {
        super(name);
    }

} //TextblocksTests
