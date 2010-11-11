/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SymbolTest extends LiteralTest {

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static void main(String[] args) {
		TestRunner.run(SymbolTest.class);
	}

        /**
	 * Constructs a new Symbol test case with the given name.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public SymbolTest(String name) {
		super(name);
	}

        /**
	 * Returns the fixture for this Symbol test case.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected Symbol getFixture() {
		return (Symbol)fixture;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
        @Override
        protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createSymbol());
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

} //SymbolTest
