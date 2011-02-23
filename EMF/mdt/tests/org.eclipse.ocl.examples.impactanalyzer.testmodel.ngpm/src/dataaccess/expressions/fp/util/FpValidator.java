/**
 * <copyright>
 * </copyright>
 *
 * $Id: FpValidator.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions.fp.util;

import dataaccess.expressions.fp.*;

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
 * @see dataaccess.expressions.fp.FpPackage
 * @generated
 */
public class FpValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final FpValidator INSTANCE = new FpValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "dataaccess.expressions.fp";

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
	public FpValidator() {
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
      return FpPackage.eINSTANCE;
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
            case FpPackage.ANONYMOUS_FUNCTION_EXPR:
                return validateAnonymousFunctionExpr((AnonymousFunctionExpr)value, diagnostics, context);
            case FpPackage.FUNCTION_FROM_METHOD_EXPR:
                return validateFunctionFromMethodExpr((FunctionFromMethodExpr)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAnonymousFunctionExpr(AnonymousFunctionExpr anonymousFunctionExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(anonymousFunctionExpr, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validateAnonymousFunctionExpr_TypeMustBeSignatureTypeDefinitionWithImplementation(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validateAnonymousFunctionExpr_HasToOwnSignatureTypeDefinition(anonymousFunctionExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validateAnonymousFunctionExpr_SignatureMustBeFunctionSignature(anonymousFunctionExpr, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the TypeMustBeSignatureTypeDefinitionWithImplementation constraint of '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ANONYMOUS_FUNCTION_EXPR__TYPE_MUST_BE_SIGNATURE_TYPE_DEFINITION_WITH_IMPLEMENTATION__EEXPRESSION = "self.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition) and\r\n" +
        "  self.getType().oclAsType(data::classes::FunctionSignatureTypeDefinition).signature.oclAsType(data::classes::FunctionSignature).implementation->notEmpty()";

	/**
     * Validates the TypeMustBeSignatureTypeDefinitionWithImplementation constraint of '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAnonymousFunctionExpr_TypeMustBeSignatureTypeDefinitionWithImplementation(AnonymousFunctionExpr anonymousFunctionExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (FpPackage.Literals.ANONYMOUS_FUNCTION_EXPR,
                 anonymousFunctionExpr,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "TypeMustBeSignatureTypeDefinitionWithImplementation",
                 ANONYMOUS_FUNCTION_EXPR__TYPE_MUST_BE_SIGNATURE_TYPE_DEFINITION_WITH_IMPLEMENTATION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the HasToOwnSignatureTypeDefinition constraint of '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ANONYMOUS_FUNCTION_EXPR__HAS_TO_OWN_SIGNATURE_TYPE_DEFINITION__EEXPRESSION = "self.ownedTypeDefinition->notEmpty()";

	/**
     * Validates the HasToOwnSignatureTypeDefinition constraint of '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAnonymousFunctionExpr_HasToOwnSignatureTypeDefinition(AnonymousFunctionExpr anonymousFunctionExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (FpPackage.Literals.ANONYMOUS_FUNCTION_EXPR,
                 anonymousFunctionExpr,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "HasToOwnSignatureTypeDefinition",
                 ANONYMOUS_FUNCTION_EXPR__HAS_TO_OWN_SIGNATURE_TYPE_DEFINITION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the SignatureMustBeFunctionSignature constraint of '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ANONYMOUS_FUNCTION_EXPR__SIGNATURE_MUST_BE_FUNCTION_SIGNATURE__EEXPRESSION = "self.ownedTypeDefinition.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature.oclIsKindOf(data::classes::FunctionSignature)";

	/**
     * Validates the SignatureMustBeFunctionSignature constraint of '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAnonymousFunctionExpr_SignatureMustBeFunctionSignature(AnonymousFunctionExpr anonymousFunctionExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (FpPackage.Literals.ANONYMOUS_FUNCTION_EXPR,
                 anonymousFunctionExpr,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SignatureMustBeFunctionSignature",
                 ANONYMOUS_FUNCTION_EXPR__SIGNATURE_MUST_BE_FUNCTION_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionFromMethodExpr(FunctionFromMethodExpr functionFromMethodExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(functionFromMethodExpr, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validateFunctionFromMethodExpr_SignatureAvailableOnObjectsClass(functionFromMethodExpr, diagnostics, context);
        if (result || diagnostics != null) result &= validateFunctionFromMethodExpr_MethodSignatureConformsToFunctionSignature(functionFromMethodExpr, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the SignatureAvailableOnObjectsClass constraint of '<em>Function From Method Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FUNCTION_FROM_METHOD_EXPR__SIGNATURE_AVAILABLE_ON_OBJECTS_CLASS__EEXPRESSION = "self.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.object.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.conformsTo(self.method.owner.oclAsType(data::classes::SapClass))";

	/**
     * Validates the SignatureAvailableOnObjectsClass constraint of '<em>Function From Method Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionFromMethodExpr_SignatureAvailableOnObjectsClass(FunctionFromMethodExpr functionFromMethodExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (FpPackage.Literals.FUNCTION_FROM_METHOD_EXPR,
                 functionFromMethodExpr,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SignatureAvailableOnObjectsClass",
                 FUNCTION_FROM_METHOD_EXPR__SIGNATURE_AVAILABLE_ON_OBJECTS_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MethodSignatureConformsToFunctionSignature constraint of '<em>Function From Method Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FUNCTION_FROM_METHOD_EXPR__METHOD_SIGNATURE_CONFORMS_TO_FUNCTION_SIGNATURE__EEXPRESSION = "self.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition) and\r\n" +
        "    self.method.conformsTo(self.getType().oclAsType(data::classes::FunctionSignatureTypeDefinition).signature)";

	/**
     * Validates the MethodSignatureConformsToFunctionSignature constraint of '<em>Function From Method Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionFromMethodExpr_MethodSignatureConformsToFunctionSignature(FunctionFromMethodExpr functionFromMethodExpr, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (FpPackage.Literals.FUNCTION_FROM_METHOD_EXPR,
                 functionFromMethodExpr,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MethodSignatureConformsToFunctionSignature",
                 FUNCTION_FROM_METHOD_EXPR__METHOD_SIGNATURE_CONFORMS_TO_FUNCTION_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
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

} //FpValidator
