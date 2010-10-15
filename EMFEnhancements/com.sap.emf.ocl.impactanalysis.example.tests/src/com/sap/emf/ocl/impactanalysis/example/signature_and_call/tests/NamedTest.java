/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call.tests;

import com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named;
import com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Named</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NamedTest extends TestCase {

    /**
     * The fixture for this Named test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Named fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(NamedTest.class);
    }

    /**
     * Constructs a new Named test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamedTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Named test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture(Named fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Named test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Named getFixture() {
        return fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(Signature_and_callFactory.eINSTANCE.createNamed());
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

} //NamedTest
