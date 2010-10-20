/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Function Template</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionTemplateTest extends TemplateTest {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static void main(String[] args) {
                TestRunner.run(FunctionTemplateTest.class);
        }

        /**
         * Constructs a new Function Template test case with the given name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public FunctionTemplateTest(String name) {
                super(name);
        }

        /**
         * Returns the fixture for this Function Template test case.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected FunctionTemplate getFixture() {
                return (FunctionTemplate)fixture;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see junit.framework.TestCase#setUp()
         * @generated
         */
        @Override
        protected void setUp() throws Exception {
                setFixture(TCSFactory.eINSTANCE.createFunctionTemplate());
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

} //FunctionTemplateTest
