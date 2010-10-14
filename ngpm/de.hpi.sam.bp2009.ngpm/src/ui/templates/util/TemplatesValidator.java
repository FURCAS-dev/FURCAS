/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ui.templates.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import ui.templates.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ui.templates.TemplatesPackage
 * @generated
 */
public class TemplatesValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final TemplatesValidator INSTANCE = new TemplatesValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "ui.templates";

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
	public TemplatesValidator() {
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
      return TemplatesPackage.eINSTANCE;
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
            case TemplatesPackage.STRING_TEMPLATE:
                return validateStringTemplate((StringTemplate)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStringTemplate(StringTemplate stringTemplate, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(stringTemplate, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stringTemplate, diagnostics, context);
        if (result || diagnostics != null) result &= validateStringTemplate_expressionMustBeSideEffectFree(stringTemplate, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the expressionMustBeSideEffectFree constraint of '<em>String Template</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String STRING_TEMPLATE__EXPRESSION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "self.expressions->forAll( e | e.isSideEffectFree() )";

	/**
     * Validates the expressionMustBeSideEffectFree constraint of '<em>String Template</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStringTemplate_expressionMustBeSideEffectFree(StringTemplate stringTemplate, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (TemplatesPackage.Literals.STRING_TEMPLATE,
                 stringTemplate,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "expressionMustBeSideEffectFree",
                 STRING_TEMPLATE__EXPRESSION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
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

} //TemplatesValidator
