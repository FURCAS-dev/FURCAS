/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.tests;

import com.sap.furcas.metamodel.FURCAS.textblocks.tests.TextblocksTests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>FURCAS</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class FURCASAllTests extends TestSuite {

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
		TestSuite suite = new FURCASAllTests("FURCAS Tests");
		suite.addTest(TextblocksTests.suite());
		return suite;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public FURCASAllTests(String name) {
		super(name);
	}

} //FURCASAllTests
