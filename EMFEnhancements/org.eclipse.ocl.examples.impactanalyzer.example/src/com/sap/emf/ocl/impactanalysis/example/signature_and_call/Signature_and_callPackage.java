/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.impactanalysis.example.signature_and_call;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface Signature_and_callPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "signature_and_call";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://sap.com/sac";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "sac";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Signature_and_callPackage eINSTANCE = com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl.init();

    /**
     * The meta object id for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.NamedImpl <em>Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.NamedImpl
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getNamed()
     * @generated
     */
    int NAMED = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED__NAME = 0;

    /**
     * The number of structural features of the '<em>Named</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.SignatureImpl <em>Signature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.SignatureImpl
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getSignature()
     * @generated
     */
    int SIGNATURE = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE__NAME = NAMED__NAME;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE__PARAMETERS = NAMED_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Signature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ParameterImpl
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getParameter()
     * @generated
     */
    int PARAMETER = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER__NAME = NAMED__NAME;

    /**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ExpressionImpl
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getExpression()
     * @generated
     */
    int EXPRESSION = 4;

    /**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.CallImpl
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getCall()
     * @generated
     */
    int CALL = 3;

    /**
     * The feature id for the '<em><b>Signature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__SIGNATURE = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.StringLiteralImpl
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getStringLiteral()
     * @generated
     */
    int STRING_LITERAL = 5;

    /**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_LITERAL__SYMBOL = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Literal</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signature</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature
     * @generated
     */
    EClass getSignature();

    /**
     * Returns the meta object for the containment reference list '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature#getParameters()
     * @see #getSignature()
     * @generated
     */
    EReference getSignature_Parameters();

    /**
     * Returns the meta object for class '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Parameter
     * @generated
     */
    EClass getParameter();

    /**
     * Returns the meta object for class '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named <em>Named</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named
     * @generated
     */
    EClass getNamed();

    /**
     * Returns the meta object for the attribute '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named#getName()
     * @see #getNamed()
     * @generated
     */
    EAttribute getNamed_Name();

    /**
     * Returns the meta object for class '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call <em>Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call
     * @generated
     */
    EClass getCall();

    /**
     * Returns the meta object for the reference '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getSignature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Signature</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getSignature()
     * @see #getCall()
     * @generated
     */
    EReference getCall_Signature();

    /**
     * Returns the meta object for the containment reference list '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getArguments <em>Arguments</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Arguments</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getArguments()
     * @see #getCall()
     * @generated
     */
    EReference getCall_Arguments();

    /**
     * Returns the meta object for class '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Expression
     * @generated
     */
    EClass getExpression();

    /**
     * Returns the meta object for class '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral <em>String Literal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Literal</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral
     * @generated
     */
    EClass getStringLiteral();

    /**
     * Returns the meta object for the attribute '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral#getSymbol()
     * @see #getStringLiteral()
     * @generated
     */
    EAttribute getStringLiteral_Symbol();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    Signature_and_callFactory getSignature_and_callFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.SignatureImpl <em>Signature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.SignatureImpl
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getSignature()
         * @generated
         */
        EClass SIGNATURE = eINSTANCE.getSignature();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIGNATURE__PARAMETERS = eINSTANCE.getSignature_Parameters();

        /**
         * The meta object literal for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ParameterImpl
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getParameter()
         * @generated
         */
        EClass PARAMETER = eINSTANCE.getParameter();

        /**
         * The meta object literal for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.NamedImpl <em>Named</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.NamedImpl
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getNamed()
         * @generated
         */
        EClass NAMED = eINSTANCE.getNamed();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

        /**
         * The meta object literal for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.CallImpl <em>Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.CallImpl
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getCall()
         * @generated
         */
        EClass CALL = eINSTANCE.getCall();

        /**
         * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALL__SIGNATURE = eINSTANCE.getCall_Signature();

        /**
         * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALL__ARGUMENTS = eINSTANCE.getCall_Arguments();

        /**
         * The meta object literal for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.ExpressionImpl
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getExpression()
         * @generated
         */
        EClass EXPRESSION = eINSTANCE.getExpression();

        /**
         * The meta object literal for the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.StringLiteralImpl <em>String Literal</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.StringLiteralImpl
         * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callPackageImpl#getStringLiteral()
         * @generated
         */
        EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

        /**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_LITERAL__SYMBOL = eINSTANCE.getStringLiteral_Symbol();

    }

} //Signature_and_callPackage
