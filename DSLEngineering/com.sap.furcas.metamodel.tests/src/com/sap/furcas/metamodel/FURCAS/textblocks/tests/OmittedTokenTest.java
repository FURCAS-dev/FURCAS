/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.tests;

import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Omitted Token</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OmittedTokenTest extends AbstractTokenTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(OmittedTokenTest.class);
        }

        /**
         * Constructs a new Omitted Token test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public OmittedTokenTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Omitted Token test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected OmittedToken getFixture() {
                return (OmittedToken)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TextblocksFactory.eINSTANCE.createOmittedToken());
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

} //OmittedTokenTest
