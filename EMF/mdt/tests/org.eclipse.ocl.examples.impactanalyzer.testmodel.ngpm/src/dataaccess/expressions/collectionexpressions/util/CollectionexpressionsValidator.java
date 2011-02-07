/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionexpressionsValidator.java,v 1.1 2011/02/07 17:20:42 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions.util;

import dataaccess.expressions.collectionexpressions.*;

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
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage
 * @generated
 */
public class CollectionexpressionsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final CollectionexpressionsValidator INSTANCE = new CollectionexpressionsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "dataaccess.expressions.collectionexpressions";

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
	public CollectionexpressionsValidator() {
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
      return CollectionexpressionsPackage.eINSTANCE;
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
            case CollectionexpressionsPackage.INCLUDING:
                return validateIncluding((Including)value, diagnostics, context);
            case CollectionexpressionsPackage.EXCLUDING:
                return validateExcluding((Excluding)value, diagnostics, context);
            case CollectionexpressionsPackage.INCLUDING_AT:
                return validateIncludingAt((IncludingAt)value, diagnostics, context);
            case CollectionexpressionsPackage.ITERATE:
                return validateIterate((Iterate)value, diagnostics, context);
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION:
                return validateCollectionExpression((CollectionExpression)value, diagnostics, context);
            case CollectionexpressionsPackage.EXCLUDING_AT:
                return validateExcludingAt((ExcludingAt)value, diagnostics, context);
            case CollectionexpressionsPackage.WITH_POSITION:
                return validateWithPosition((WithPosition)value, diagnostics, context);
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT:
                return validateCollectionExpressionWithArgument((CollectionExpressionWithArgument)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateIncluding(Including including, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(including, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(including, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(including, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionExpressionWithArgument_ArgumentTypeMustConformToCollectionExpressionType(including, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExcluding(Excluding excluding, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(excluding, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(excluding, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionExpressionWithArgument_ArgumentTypeMustConformToCollectionExpressionType(excluding, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateIncludingAt(IncludingAt includingAt, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(includingAt, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionExpressionWithArgument_ArgumentTypeMustConformToCollectionExpressionType(includingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validateWithPosition_SourceMustBeOrdered(includingAt, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateIterate(Iterate iterate, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(iterate, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iterate, diagnostics, context);
        if (result || diagnostics != null) result &= validateIterate_AccumulatorTypeEqualsExpressionType(iterate, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the AccumulatorTypeEqualsExpressionType constraint of '<em>Iterate</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ITERATE__ACCUMULATOR_TYPE_EQUALS_EXPRESSION_TYPE__EEXPRESSION = "self.accumulator->notEmpty() implies\r\n" +
        "  (self.accumulator.ownedTypeDefinition->notEmpty() implies\r\n" +
        "     self.accumulator.ownedTypeDefinition.conformsTo(self.iteratorExpression.getType()))";

	/**
     * Validates the AccumulatorTypeEqualsExpressionType constraint of '<em>Iterate</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateIterate_AccumulatorTypeEqualsExpressionType(Iterate iterate, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CollectionexpressionsPackage.Literals.ITERATE,
                 iterate,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "AccumulatorTypeEqualsExpressionType",
                 ITERATE__ACCUMULATOR_TYPE_EQUALS_EXPRESSION_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCollectionExpression(CollectionExpression collectionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(collectionExpression, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExcludingAt(ExcludingAt excludingAt, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(excludingAt, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionExpressionWithArgument_ArgumentTypeMustConformToCollectionExpressionType(excludingAt, diagnostics, context);
        if (result || diagnostics != null) result &= validateWithPosition_SourceMustBeOrdered(excludingAt, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateWithPosition(WithPosition withPosition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(withPosition, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(withPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validateWithPosition_SourceMustBeOrdered(withPosition, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the SourceMustBeOrdered constraint of '<em>With Position</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String WITH_POSITION__SOURCE_MUST_BE_ORDERED__EEXPRESSION = "self.argument.getType().ordered";

	/**
     * Validates the SourceMustBeOrdered constraint of '<em>With Position</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateWithPosition_SourceMustBeOrdered(WithPosition withPosition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CollectionexpressionsPackage.Literals.WITH_POSITION,
                 withPosition,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SourceMustBeOrdered",
                 WITH_POSITION__SOURCE_MUST_BE_ORDERED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCollectionExpressionWithArgument(CollectionExpressionWithArgument collectionExpressionWithArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(collectionExpressionWithArgument, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionExpressionWithArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionExpressionWithArgument_ArgumentTypeMustConformToCollectionExpressionType(collectionExpressionWithArgument, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ArgumentTypeMustConformToCollectionExpressionType constraint of '<em>Collection Expression With Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT_TYPE_MUST_CONFORM_TO_COLLECTION_EXPRESSION_TYPE__EEXPRESSION = "let snl : Integer = source.getType().getNestingLevel() in let anl : Integer = argument.getType().getNestingLevel() in\r\n" +
        "    if snl = anl then\r\n" +
        "      source.getType().conformsToIgnoringMultiplicity(argument.getType())\r\n" +
        "    else\r\n" +
        "      if snl = (anl + 1) then\r\n" +
        "        source.getType().oclAsType(data::classes::NestedTypeDefinition).type.conformsToIgnoringMultiplicity(argument.getType())\r\n" +
        "      else\r\n" +
        "        if (snl + 1) = anl then\r\n" +
        "          source.getType().conformsToIgnoringMultiplicity(argument.getType().oclAsType(data::classes::NestedTypeDefinition).type)\r\n" +
        "        else\r\n" +
        "          false\r\n" +
        "        endif\r\n" +
        "      endif\r\n" +
        "    endif";

	/**
     * Validates the ArgumentTypeMustConformToCollectionExpressionType constraint of '<em>Collection Expression With Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCollectionExpressionWithArgument_ArgumentTypeMustConformToCollectionExpressionType(CollectionExpressionWithArgument collectionExpressionWithArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CollectionexpressionsPackage.Literals.COLLECTION_EXPRESSION_WITH_ARGUMENT,
                 collectionExpressionWithArgument,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ArgumentTypeMustConformToCollectionExpressionType",
                 COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT_TYPE_MUST_CONFORM_TO_COLLECTION_EXPRESSION_TYPE__EEXPRESSION,
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

} //CollectionexpressionsValidator
