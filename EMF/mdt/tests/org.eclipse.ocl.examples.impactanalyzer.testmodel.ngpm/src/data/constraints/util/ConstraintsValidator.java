/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstraintsValidator.java,v 1.1 2011/02/07 17:18:47 auhl Exp $
 */
package data.constraints.util;

import data.constraints.*;

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
 * @see data.constraints.ConstraintsPackage
 * @generated
 */
public class ConstraintsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final ConstraintsValidator INSTANCE = new ConstraintsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "data.constraints";

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
	public ConstraintsValidator() {
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
      return ConstraintsPackage.eINSTANCE;
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
            case ConstraintsPackage.CONSTRAINT:
                return validateConstraint((Constraint)value, diagnostics, context);
            case ConstraintsPackage.SEVERITY_IN_STATE:
                return validateSeverityInState((SeverityInState)value, diagnostics, context);
            case ConstraintsPackage.OBJECT_STATE:
                return validateObjectState((ObjectState)value, diagnostics, context);
            case ConstraintsPackage.SEVERITY:
                return validateSeverity((Severity)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(constraint, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validateConstraint_ExpressionTypeMustBeBoolean(constraint, diagnostics, context);
        if (result || diagnostics != null) result &= validateConstraint_MustBeOwned(constraint, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ExpressionTypeMustBeBoolean constraint of '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONSTRAINT__EXPRESSION_TYPE_MUST_BE_BOOLEAN__EEXPRESSION = "self.constraintExpression.getType().upperMultiplicity = 1 and\r\n" +
        "  self.constraintExpression.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.constraintExpression.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = 'Boolean'";

	/**
     * Validates the ExpressionTypeMustBeBoolean constraint of '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConstraint_ExpressionTypeMustBeBoolean(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ConstraintsPackage.Literals.CONSTRAINT,
                 constraint,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ExpressionTypeMustBeBoolean",
                 CONSTRAINT__EXPRESSION_TYPE_MUST_BE_BOOLEAN__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MustBeOwned constraint of '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONSTRAINT__MUST_BE_OWNED__EEXPRESSION = "self.constrainedType->notEmpty() or\r\n" +
        "  self.theContext->notEmpty() or\r\n" +
        "  self.preconditionForSignature->notEmpty() or\r\n" +
        "  self.postconditionForSignature->notEmpty()";

	/**
     * Validates the MustBeOwned constraint of '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConstraint_MustBeOwned(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ConstraintsPackage.Literals.CONSTRAINT,
                 constraint,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MustBeOwned",
                 CONSTRAINT__MUST_BE_OWNED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSeverityInState(SeverityInState severityInState, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(severityInState, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectState(ObjectState objectState, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSeverity(Severity severity, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
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

} //ConstraintsValidator
