/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>And Exp</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AndExpTest extends ExpressionTest {

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static void main(String[] args) {
        TestRunner.run(AndExpTest.class);
    }

        /**
     * Constructs a new And Exp test case with the given name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public AndExpTest(String name) {
        super(name);
    }

        /**
     * Returns the fixture for this And Exp test case.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected AndExp getFixture() {
        return (AndExp)fixture;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
        @Override
        protected void setUp() throws Exception {
        setFixture(TCSFactory.eINSTANCE.createAndExp());
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

} //AndExpTest
