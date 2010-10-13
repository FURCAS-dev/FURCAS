/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks.tests;

import com.sap.furcas.metamodel.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.textblocks.UnlexedToken;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unlexed Token</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnlexedTokenTest extends AbstractTokenTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(UnlexedTokenTest.class);
        }

        /**
         * Constructs a new Unlexed Token test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public UnlexedTokenTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Unlexed Token test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected UnlexedToken getFixture() {
                return (UnlexedToken)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TextblocksFactory.eINSTANCE.createUnlexedToken());
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

} //UnlexedTokenTest
