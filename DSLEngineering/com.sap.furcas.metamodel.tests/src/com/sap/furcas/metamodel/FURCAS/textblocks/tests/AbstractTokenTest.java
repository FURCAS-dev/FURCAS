/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.tests;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Abstract Token</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractTokenTest extends DocumentNodeTest {

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static void main(String[] args) {
		TestRunner.run(AbstractTokenTest.class);
	}

        /**
	 * Constructs a new Abstract Token test case with the given name.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public AbstractTokenTest(String name) {
		super(name);
	}

        /**
	 * Returns the fixture for this Abstract Token test case.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected AbstractToken getFixture() {
		return (AbstractToken)fixture;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
        @Override
        protected void setUp() throws Exception {
		setFixture(TextblocksFactory.eINSTANCE.createAbstractToken());
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

} //AbstractTokenTest
