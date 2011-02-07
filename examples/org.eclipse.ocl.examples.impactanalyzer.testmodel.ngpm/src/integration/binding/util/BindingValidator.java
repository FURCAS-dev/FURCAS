/**
 * <copyright>
 * </copyright>
 *
 * $Id: BindingValidator.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package integration.binding.util;

import integration.binding.*;

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
 * @see integration.binding.BindingPackage
 * @generated
 */
public class BindingValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final BindingValidator INSTANCE = new BindingValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "integration.binding";

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
	public BindingValidator() {
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
      return BindingPackage.eINSTANCE;
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
            case BindingPackage.BINDING:
                return validateBinding((Binding)value, diagnostics, context);
            case BindingPackage.HTTP_BINDING:
                return validateHttpBinding((HttpBinding)value, diagnostics, context);
            case BindingPackage.HTTP_GET_BINDING:
                return validateHttpGetBinding((HttpGetBinding)value, diagnostics, context);
            case BindingPackage.HTTP_PUT_BINDING:
                return validateHttpPutBinding((HttpPutBinding)value, diagnostics, context);
            case BindingPackage.URL_PATTERN:
                return validateUrlPattern((UrlPattern)value, diagnostics, context);
            case BindingPackage.SIMPLE_URL_PATTERN:
                return validateSimpleUrlPattern((SimpleUrlPattern)value, diagnostics, context);
            case BindingPackage.REST_URL_PATTERN:
                return validateRestUrlPattern((RestUrlPattern)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBinding(Binding binding, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(binding, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binding, diagnostics, context);
        if (result || diagnostics != null) result &= validateBinding_FunctionExpressionHasFunctionType(binding, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the FunctionExpressionHasFunctionType constraint of '<em>Binding</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String BINDING__FUNCTION_EXPRESSION_HAS_FUNCTION_TYPE__EEXPRESSION = "self.function.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)";

	/**
     * Validates the FunctionExpressionHasFunctionType constraint of '<em>Binding</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBinding_FunctionExpressionHasFunctionType(Binding binding, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (BindingPackage.Literals.BINDING,
                 binding,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FunctionExpressionHasFunctionType",
                 BINDING__FUNCTION_EXPRESSION_HAS_FUNCTION_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateHttpBinding(HttpBinding httpBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(httpBinding, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(httpBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validateBinding_FunctionExpressionHasFunctionType(httpBinding, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateHttpGetBinding(HttpGetBinding httpGetBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(httpGetBinding, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(httpGetBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validateBinding_FunctionExpressionHasFunctionType(httpGetBinding, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateHttpPutBinding(HttpPutBinding httpPutBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(httpPutBinding, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(httpPutBinding, diagnostics, context);
        if (result || diagnostics != null) result &= validateBinding_FunctionExpressionHasFunctionType(httpPutBinding, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateUrlPattern(UrlPattern urlPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(urlPattern, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSimpleUrlPattern(SimpleUrlPattern simpleUrlPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(simpleUrlPattern, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateRestUrlPattern(RestUrlPattern restUrlPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(restUrlPattern, diagnostics, context);
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

} //BindingValidator
