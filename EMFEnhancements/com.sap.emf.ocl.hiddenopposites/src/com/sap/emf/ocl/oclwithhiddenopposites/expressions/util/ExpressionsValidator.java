/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.expressions.util;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsValidator extends EObjectValidator {
	/**
         * The cached model package
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static final ExpressionsValidator INSTANCE = new ExpressionsValidator();

	/**
         * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see org.eclipse.emf.common.util.Diagnostic#getSource()
         * @see org.eclipse.emf.common.util.Diagnostic#getCode()
         * @generated
         */
	public static final String DIAGNOSTIC_SOURCE = "com.sap.emf.ocl.oclwithhiddenopposites.expressions";

	/**
         * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Property type' of 'Opposite Property Call Exp'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static final int OPPOSITE_PROPERTY_CALL_EXP__PROPERTY_TYPE = 1;

	/**
         * A constant with a fixed name that can be used as the base value for additional hand written constants.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
         * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
         * The cached base package validator.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected EcoreValidator ecoreValidator;

	/**
         * The cached base package validator.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public ExpressionsValidator() {
                super();
                ecoreValidator = EcoreValidator.INSTANCE;
                ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
        }

	/**
         * Returns the package of this validator switch.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EPackage getEPackage() {
          return ExpressionsPackage.eINSTANCE;
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
                        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP:
                                return validateOppositePropertyCallExp((OppositePropertyCallExp)value, diagnostics, context);
                        default:
                                return true;
                }
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public boolean validateOppositePropertyCallExp(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
                if (!validate_NoCircularContainment(oppositePropertyCallExp, diagnostics, context)) return false;
                boolean result = validate_EveryMultiplicityConforms(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_EveryProxyResolves(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_UniqueID(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_EveryKeyUnique(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(oppositePropertyCallExp, diagnostics, context);
                if (result || diagnostics != null) result &= validateOppositePropertyCallExp_property_type(oppositePropertyCallExp, diagnostics, context);
                return result;
        }

	/**
         * Validates the property_type constraint of '<em>Opposite Property Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public boolean validateOppositePropertyCallExp_property_type(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
                return oppositePropertyCallExp.property_type(diagnostics, context);
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

} //ExpressionsValidator
