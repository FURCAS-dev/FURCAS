/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.tests;

import com.sap.furcas.metamodel.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sequence In Alternative</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SequenceInAlternativeTest extends SequenceTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(SequenceInAlternativeTest.class);
        }

        /**
         * Constructs a new Sequence In Alternative test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public SequenceInAlternativeTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Sequence In Alternative test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected SequenceInAlternative getFixture() {
                return (SequenceInAlternative)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createSequenceInAlternative());
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

} //SequenceInAlternativeTest
