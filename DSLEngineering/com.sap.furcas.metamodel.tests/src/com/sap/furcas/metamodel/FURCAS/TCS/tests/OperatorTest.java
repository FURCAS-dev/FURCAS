/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorTest extends NamedElementTest {

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static void main(String[] args) {
		TestRunner.run(OperatorTest.class);
	}

        /**
	 * Constructs a new Operator test case with the given name.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OperatorTest(String name) {
		super(name);
	}

        /**
	 * Returns the fixture for this Operator test case.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected Operator getFixture() {
		return (Operator)fixture;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
        @Override
        protected void setUp() throws Exception {
		setFixture(TCSFactory.eINSTANCE.createOperator());
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

} //OperatorTest
