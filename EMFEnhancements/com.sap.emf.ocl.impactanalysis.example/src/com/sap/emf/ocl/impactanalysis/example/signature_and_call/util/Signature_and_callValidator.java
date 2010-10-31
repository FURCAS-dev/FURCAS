/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call.util;

import com.sap.emf.ocl.impactanalysis.example.signature_and_call.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage
 * @generated
 */
public class Signature_and_callValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final Signature_and_callValidator INSTANCE = new Signature_and_callValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "com.sap.emf.ocl.impactanalysis.example.signature_and_call";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature_and_callValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
      return Signature_and_callPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case Signature_and_callPackage.SIGNATURE:
                return validateSignature((Signature)value, diagnostics, context);
            case Signature_and_callPackage.PARAMETER:
                return validateParameter((Parameter)value, diagnostics, context);
            case Signature_and_callPackage.NAMED:
                return validateNamed((Named)value, diagnostics, context);
            case Signature_and_callPackage.CALL:
                return validateCall((Call)value, diagnostics, context);
            case Signature_and_callPackage.EXPRESSION:
                return validateExpression((Expression)value, diagnostics, context);
            case Signature_and_callPackage.STRING_LITERAL:
                return validateStringLiteral((StringLiteral)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSignature(Signature signature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(signature, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(parameter, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNamed(Named named, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(named, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCall(Call call, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(call, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(call, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(call, diagnostics, context);
        if (result || diagnostics != null) result &= validateCall_ArgumentsMustMatchParameterList(call, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the ArgumentsMustMatchParameterList constraint of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String CALL__ARGUMENTS_MUST_MATCH_PARAMETER_LIST__EEXPRESSION = "self.arguments->size() = self.signature.parameters->size()";

    /**
     * Validates the ArgumentsMustMatchParameterList constraint of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCall_ArgumentsMustMatchParameterList(Call call, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (Signature_and_callPackage.Literals.CALL,
                 call,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ArgumentsMustMatchParameterList",
                 CALL__ARGUMENTS_MUST_MATCH_PARAMETER_LIST__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExpression(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(expression, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(stringLiteral, diagnostics, context);
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} //Signature_and_callValidator
