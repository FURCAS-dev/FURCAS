/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call.tests;

import com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature;
import com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SignatureTest extends NamedTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(SignatureTest.class);
    }

    /**
     * Constructs a new Signature test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignatureTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Signature test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Signature getFixture() {
        return (Signature)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(Signature_and_callFactory.eINSTANCE.createSignature());
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

} //SignatureTest
