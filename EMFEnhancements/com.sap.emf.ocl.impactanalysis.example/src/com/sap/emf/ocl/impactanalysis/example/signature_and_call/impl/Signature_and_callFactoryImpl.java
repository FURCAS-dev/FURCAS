/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl;

import com.sap.emf.ocl.impactanalysis.example.signature_and_call.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Signature_and_callFactoryImpl extends EFactoryImpl implements Signature_and_callFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Signature_and_callFactory init() {
        try {
            Signature_and_callFactory theSignature_and_callFactory = (Signature_and_callFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/sac"); 
            if (theSignature_and_callFactory != null) {
                return theSignature_and_callFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Signature_and_callFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature_and_callFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case Signature_and_callPackage.SIGNATURE: return createSignature();
            case Signature_and_callPackage.PARAMETER: return createParameter();
            case Signature_and_callPackage.NAMED: return createNamed();
            case Signature_and_callPackage.CALL: return createCall();
            case Signature_and_callPackage.STRING_LITERAL: return createStringLiteral();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature createSignature() {
        SignatureImpl signature = new SignatureImpl();
        return signature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Named createNamed() {
        NamedImpl named = new NamedImpl();
        return named;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Call createCall() {
        CallImpl call = new CallImpl();
        return call;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StringLiteral createStringLiteral() {
        StringLiteralImpl stringLiteral = new StringLiteralImpl();
        return stringLiteral;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature_and_callPackage getSignature_and_callPackage() {
        return (Signature_and_callPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static Signature_and_callPackage getPackage() {
        return Signature_and_callPackage.eINSTANCE;
    }

} //Signature_and_callFactoryImpl
