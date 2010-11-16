/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.tests;

import com.sap.furcas.metamodel.FURCAS.TCS.PropertyVal;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Property Val</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyValTest extends ValueTest {

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static void main(String[] args) {
        TestRunner.run(PropertyValTest.class);
    }

        /**
     * Constructs a new Property Val test case with the given name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public PropertyValTest(String name) {
        super(name);
    }

        /**
     * Returns the fixture for this Property Val test case.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected PropertyVal getFixture() {
        return (PropertyVal)fixture;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
        @Override
        protected void setUp() throws Exception {
        setFixture(TCSFactory.eINSTANCE.createPropertyVal());
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

} //PropertyValTest
