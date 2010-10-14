/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.util;

import data.classes.*;

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
 * @see data.classes.ClassesPackage
 * @generated
 */
public class ClassesValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final ClassesValidator INSTANCE = new ClassesValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "data.classes";

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
	public ClassesValidator() {
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
      return ClassesPackage.eINSTANCE;
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
            case ClassesPackage.ASSOCIATION:
                return validateAssociation((Association)value, diagnostics, context);
            case ClassesPackage.SIGNATURE:
                return validateSignature((Signature)value, diagnostics, context);
            case ClassesPackage.ASSOCIATION_END:
                return validateAssociationEnd((AssociationEnd)value, diagnostics, context);
            case ClassesPackage.SAP_CLASS:
                return validateSapClass((SapClass)value, diagnostics, context);
            case ClassesPackage.DELEGATION:
                return validateDelegation((Delegation)value, diagnostics, context);
            case ClassesPackage.TYPED_ELEMENT:
                return validateTypedElement((TypedElement)value, diagnostics, context);
            case ClassesPackage.CONTEXT:
                return validateContext((Context)value, diagnostics, context);
            case ClassesPackage.MULTIPLICITY:
                return validateMultiplicity((Multiplicity)value, diagnostics, context);
            case ClassesPackage.SIGNATURE_IMPLEMENTATION:
                return validateSignatureImplementation((SignatureImplementation)value, diagnostics, context);
            case ClassesPackage.LINK_TRAVERSAL:
                return validateLinkTraversal((LinkTraversal)value, diagnostics, context);
            case ClassesPackage.LINK_ADDITION:
                return validateLinkAddition((LinkAddition)value, diagnostics, context);
            case ClassesPackage.LINK_REMOVAL:
                return validateLinkRemoval((LinkRemoval)value, diagnostics, context);
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION:
                return validateAssociationEndSignatureImplementation((AssociationEndSignatureImplementation)value, diagnostics, context);
            case ClassesPackage.CLASS_TYPE_DEFINITION:
                return validateClassTypeDefinition((ClassTypeDefinition)value, diagnostics, context);
            case ClassesPackage.TYPE_DEFINITION:
                return validateTypeDefinition((TypeDefinition)value, diagnostics, context);
            case ClassesPackage.NESTED_TYPE_DEFINITION:
                return validateNestedTypeDefinition((NestedTypeDefinition)value, diagnostics, context);
            case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION:
                return validateFunctionSignatureTypeDefinition((FunctionSignatureTypeDefinition)value, diagnostics, context);
            case ClassesPackage.METHOD_SIGNATURE:
                return validateMethodSignature((MethodSignature)value, diagnostics, context);
            case ClassesPackage.FUNCTION_SIGNATURE:
                return validateFunctionSignature((FunctionSignature)value, diagnostics, context);
            case ClassesPackage.LINK_SETTING:
                return validateLinkSetting((LinkSetting)value, diagnostics, context);
            case ClassesPackage.TYPE_ADAPTER:
                return validateTypeAdapter((TypeAdapter)value, diagnostics, context);
            case ClassesPackage.PARAMETER:
                return validateParameter((Parameter)value, diagnostics, context);
            case ClassesPackage.NAMED_VALUE:
                return validateNamedValue((NamedValue)value, diagnostics, context);
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION:
                return validatePlatformSpecificImplementation((PlatformSpecificImplementation)value, diagnostics, context);
            case ClassesPackage.NATIVE_IMPL:
                return validateNativeImpl((NativeImpl)value, diagnostics, context);
            case ClassesPackage.SIGNATURE_OWNER:
                return validateSignatureOwner((SignatureOwner)value, diagnostics, context);
            case ClassesPackage.EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION:
                return validateExtentModifyingAssociationEndSignatureImplementation((ExtentModifyingAssociationEndSignatureImplementation)value, diagnostics, context);
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION:
                return validateFunctionSignatureImplementation((FunctionSignatureImplementation)value, diagnostics, context);
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER:
                return validateActualObjectParameter((ActualObjectParameter)value, diagnostics, context);
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS:
                return validateConverterBetweenParametrizations((ConverterBetweenParametrizations)value, diagnostics, context);
            case ClassesPackage.LINK_MANIPULATION_AT_POSITION:
                return validateLinkManipulationAtPosition((LinkManipulationAtPosition)value, diagnostics, context);
            case ClassesPackage.IN_SCOPE:
                return validateInScope((InScope)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociation(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(association, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(association, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(association, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociation_UniquenessOnBothEndsMustBeTheSame(association, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociation_AtMostOneCompositeEnd(association, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociation_AtLeastOneNavigableEnd(association, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociation_AtMostOneEqualityContributionForTwoValueClasses(association, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociation_AtMostOneOrderedEnd(association, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the UniquenessOnBothEndsMustBeTheSame constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION__UNIQUENESS_ON_BOTH_ENDS_MUST_BE_THE_SAME__EEXPRESSION = "self.ends->forAll( e1, e2 : AssociationEnd |\r\n" +
        "              e1 <> e2 implies e1.type.unique = e2.type.unique)";

	/**
     * Validates the UniquenessOnBothEndsMustBeTheSame constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociation_UniquenessOnBothEndsMustBeTheSame(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION,
                 association,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "UniquenessOnBothEndsMustBeTheSame",
                 ASSOCIATION__UNIQUENESS_ON_BOTH_ENDS_MUST_BE_THE_SAME__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the AtMostOneCompositeEnd constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION__AT_MOST_ONE_COMPOSITE_END__EEXPRESSION = "self.ends->select(composite)->size() < 2";

	/**
     * Validates the AtMostOneCompositeEnd constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociation_AtMostOneCompositeEnd(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION,
                 association,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "AtMostOneCompositeEnd",
                 ASSOCIATION__AT_MOST_ONE_COMPOSITE_END__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the AtLeastOneNavigableEnd constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION__AT_LEAST_ONE_NAVIGABLE_END__EEXPRESSION = "self.ends->select(ae:AssociationEnd | ae.navigable)->notEmpty()";

	/**
     * Validates the AtLeastOneNavigableEnd constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociation_AtLeastOneNavigableEnd(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION,
                 association,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "AtLeastOneNavigableEnd",
                 ASSOCIATION__AT_LEAST_ONE_NAVIGABLE_END__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the AtMostOneEqualityContributionForTwoValueClasses constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION__AT_MOST_ONE_EQUALITY_CONTRIBUTION_FOR_TWO_VALUE_CLASSES__EEXPRESSION = "self.ends->select(contributesToEquality and type.clazz.valueType)->size() < 2";

	/**
     * Validates the AtMostOneEqualityContributionForTwoValueClasses constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociation_AtMostOneEqualityContributionForTwoValueClasses(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION,
                 association,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "AtMostOneEqualityContributionForTwoValueClasses",
                 ASSOCIATION__AT_MOST_ONE_EQUALITY_CONTRIBUTION_FOR_TWO_VALUE_CLASSES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the AtMostOneOrderedEnd constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION__AT_MOST_ONE_ORDERED_END__EEXPRESSION = "self.ends->select(ae|ae.type.ordered)->size() < 2";

	/**
     * Validates the AtMostOneOrderedEnd constraint of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociation_AtMostOneOrderedEnd(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION,
                 association,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "AtMostOneOrderedEnd",
                 ASSOCIATION__AT_MOST_ONE_ORDERED_END__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignature(Signature signature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(signature, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(signature, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignature_OnlyTrailingOptionalParameters(signature, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the OnlyTrailingOptionalParameters constraint of '<em>Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SIGNATURE__ONLY_TRAILING_OPTIONAL_PARAMETERS__EEXPRESSION = "self.input->forAll(p | p.defaultValue->notEmpty() implies Sequence{(self.input->indexOf(p)+1)..self.input->size()}->forAll(\r\n" +
        "    i | self.input->at(i).defaultValue->notEmpty()))";

	/**
     * Validates the OnlyTrailingOptionalParameters constraint of '<em>Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignature_OnlyTrailingOptionalParameters(Signature signature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.SIGNATURE,
                 signature,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "OnlyTrailingOptionalParameters",
                 SIGNATURE__ONLY_TRAILING_OPTIONAL_PARAMETERS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEnd(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(associationEnd, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEnd_ExposingClassesEqualOppositeEndsType(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEnd_NoCompositionWithValueClass(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEnd_EqualityContributionsMustBeExposedAndNavigable(associationEnd, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEnd_EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds(associationEnd, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ExposingClassesEqualOppositeEndsType constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END__EXPOSING_CLASSES_EQUAL_OPPOSITE_ENDS_TYPE__EEXPRESSION = "self.signatureImplementations.implements_.owner->forAll(c:SignatureOwner | c = self.otherEnd().type.clazz)";

	/**
     * Validates the ExposingClassesEqualOppositeEndsType constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEnd_ExposingClassesEqualOppositeEndsType(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION_END,
                 associationEnd,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ExposingClassesEqualOppositeEndsType",
                 ASSOCIATION_END__EXPOSING_CLASSES_EQUAL_OPPOSITE_ENDS_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the NoCompositionWithValueClass constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END__NO_COMPOSITION_WITH_VALUE_CLASS__EEXPRESSION = "self.composite implies self.association.ends.type->forAll(ctd:ClassTypeDefinition | not ctd.clazz.valueType)";

	/**
     * Validates the NoCompositionWithValueClass constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEnd_NoCompositionWithValueClass(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION_END,
                 associationEnd,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "NoCompositionWithValueClass",
                 ASSOCIATION_END__NO_COMPOSITION_WITH_VALUE_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the EqualityContributionsMustBeExposedAndNavigable constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END__EQUALITY_CONTRIBUTIONS_MUST_BE_EXPOSED_AND_NAVIGABLE__EEXPRESSION = "self.contributesToEquality implies (self.otherEnd().signatureImplementations->notEmpty() and self.otherEnd().navigable)";

	/**
     * Validates the EqualityContributionsMustBeExposedAndNavigable constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEnd_EqualityContributionsMustBeExposedAndNavigable(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION_END,
                 associationEnd,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "EqualityContributionsMustBeExposedAndNavigable",
                 ASSOCIATION_END__EQUALITY_CONTRIBUTIONS_MUST_BE_EXPOSED_AND_NAVIGABLE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END__EQUALITY_CONTRIBUTING_END_ON_VALUE_MUST_HAVE_UNLIMITED_UPPER_BOUNDS__EEXPRESSION = "(self.type.clazz.valueType and self.contributesToEquality and\r\n" +
        "   self.type.clazz.getAssociationEnds()->exists(ae |\r\n" +
        "     ae <> self and ae.contributesToEquality)) implies\r\n" +
        "  self.type.isMany()";

	/**
     * Validates the EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds constraint of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEnd_EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION_END,
                 associationEnd,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds",
                 ASSOCIATION_END__EQUALITY_CONTRIBUTING_END_ON_VALUE_MUST_HAVE_UNLIMITED_UPPER_BOUNDS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSapClass(SapClass sapClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(sapClass, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validateSapClass_OnlyValueClassesCanHaveObjectParameters(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validateSapClass_OnlyObjectParameterizedClassesCanHaveConverter(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validateSapClass_OnlyTrailingOptionalParameters(sapClass, diagnostics, context);
        if (result || diagnostics != null) result &= validateSapClass_NoRecursionForObjectParameters(sapClass, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the OnlyValueClassesCanHaveObjectParameters constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SAP_CLASS__ONLY_VALUE_CLASSES_CAN_HAVE_OBJECT_PARAMETERS__EEXPRESSION = "self.formalObjectParameters->notEmpty() implies self.valueType";

	/**
     * Validates the OnlyValueClassesCanHaveObjectParameters constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSapClass_OnlyValueClassesCanHaveObjectParameters(SapClass sapClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.SAP_CLASS,
                 sapClass,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "OnlyValueClassesCanHaveObjectParameters",
                 SAP_CLASS__ONLY_VALUE_CLASSES_CAN_HAVE_OBJECT_PARAMETERS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the OnlyObjectParameterizedClassesCanHaveConverter constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SAP_CLASS__ONLY_OBJECT_PARAMETERIZED_CLASSES_CAN_HAVE_CONVERTER__EEXPRESSION = "self.converterBetweenParametrizations->notEmpty() implies self.formalObjectParameters->notEmpty()";

	/**
     * Validates the OnlyObjectParameterizedClassesCanHaveConverter constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSapClass_OnlyObjectParameterizedClassesCanHaveConverter(SapClass sapClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.SAP_CLASS,
                 sapClass,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "OnlyObjectParameterizedClassesCanHaveConverter",
                 SAP_CLASS__ONLY_OBJECT_PARAMETERIZED_CLASSES_CAN_HAVE_CONVERTER__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the OnlyTrailingOptionalParameters constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SAP_CLASS__ONLY_TRAILING_OPTIONAL_PARAMETERS__EEXPRESSION = "self.formalObjectParameters->forAll(p | p.defaultValue->notEmpty() implies Sequence{(self.formalObjectParameters->indexOf(p)+1)..self.formalObjectParameters->size()}->forAll(\r\n" +
        "    i | self.formalObjectParameters->at(i).defaultValue->notEmpty()))";

	/**
     * Validates the OnlyTrailingOptionalParameters constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSapClass_OnlyTrailingOptionalParameters(SapClass sapClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.SAP_CLASS,
                 sapClass,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "OnlyTrailingOptionalParameters",
                 SAP_CLASS__ONLY_TRAILING_OPTIONAL_PARAMETERS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the NoRecursionForObjectParameters constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SAP_CLASS__NO_RECURSION_FOR_OBJECT_PARAMETERS__EEXPRESSION = "true  --  TODO implement this";

	/**
     * Validates the NoRecursionForObjectParameters constraint of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSapClass_NoRecursionForObjectParameters(SapClass sapClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.SAP_CLASS,
                 sapClass,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "NoRecursionForObjectParameters",
                 SAP_CLASS__NO_RECURSION_FOR_OBJECT_PARAMETERS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDelegation(Delegation delegation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(delegation, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(delegation, diagnostics, context);
        if (result || diagnostics != null) result &= validateDelegation_ToEndMustHaveMultiplicityOfOne(delegation, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ToEndMustHaveMultiplicityOfOne constraint of '<em>Delegation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DELEGATION__TO_END_MUST_HAVE_MULTIPLICITY_OF_ONE__EEXPRESSION = "self.from.otherEnd().type.lowerMultiplicity = 1 and\r\n" +
        "  self.from.otherEnd().type.upperMultiplicity = 1";

	/**
     * Validates the ToEndMustHaveMultiplicityOfOne constraint of '<em>Delegation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDelegation_ToEndMustHaveMultiplicityOfOne(Delegation delegation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.DELEGATION,
                 delegation,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ToEndMustHaveMultiplicityOfOne",
                 DELEGATION__TO_END_MUST_HAVE_MULTIPLICITY_OF_ONE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(typedElement, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
        if (!validate_NoCircularContainment(context, diagnostics, theContext)) return false;
        boolean result = validate_EveryMultiplicityConforms(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_UniqueID(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validateContext_ConditionMustBeBoolean(context, diagnostics, theContext);
        if (result || diagnostics != null) result &= validateContext_ConstraintForRightClass(context, diagnostics, theContext);
        return result;
    }

	/**
     * The cached validation expression for the ConditionMustBeBoolean constraint of '<em>Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONTEXT__CONDITION_MUST_BE_BOOLEAN__EEXPRESSION = "self.condition.getType().upperMultiplicity = 1 and\r\n" +
        "  self.condition.getType().oclIsKindOf(ClassTypeDefinition) and\r\n" +
        "  self.condition.getType().oclAsType(ClassTypeDefinition).clazz.name = 'Boolean'";

	/**
     * Validates the ConditionMustBeBoolean constraint of '<em>Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateContext_ConditionMustBeBoolean(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
        return
            validate
                (ClassesPackage.Literals.CONTEXT,
                 context,
                 diagnostics,
                 theContext,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ConditionMustBeBoolean",
                 CONTEXT__CONDITION_MUST_BE_BOOLEAN__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ConstraintForRightClass constraint of '<em>Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONTEXT__CONSTRAINT_FOR_RIGHT_CLASS__EEXPRESSION = "self.constraints->forAll(c | c.constrainedType = self.for_)";

	/**
     * Validates the ConstraintForRightClass constraint of '<em>Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateContext_ConstraintForRightClass(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
        return
            validate
                (ClassesPackage.Literals.CONTEXT,
                 context,
                 diagnostics,
                 theContext,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ConstraintForRightClass",
                 CONTEXT__CONSTRAINT_FOR_RIGHT_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMultiplicity(Multiplicity multiplicity, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(multiplicity, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignatureImplementation(SignatureImplementation signatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(signatureImplementation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkTraversal(LinkTraversal linkTraversal, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(linkTraversal, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkTraversal_OutputTypeMatchEndType(linkTraversal, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkTraversal_MustBeNavigable(linkTraversal, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the OutputTypeMatchEndType constraint of '<em>Link Traversal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_TRAVERSAL__OUTPUT_TYPE_MATCH_END_TYPE__EEXPRESSION = "self.implements_.input->isEmpty() and\r\n" +
        "  self.implements_.output.oclIsKindOf(ClassTypeDefinition) and \r\n" +
        "  self.implements_.output.oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz";

	/**
     * Validates the OutputTypeMatchEndType constraint of '<em>Link Traversal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkTraversal_OutputTypeMatchEndType(LinkTraversal linkTraversal, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.LINK_TRAVERSAL,
                 linkTraversal,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "OutputTypeMatchEndType",
                 LINK_TRAVERSAL__OUTPUT_TYPE_MATCH_END_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MustBeNavigable constraint of '<em>Link Traversal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_TRAVERSAL__MUST_BE_NAVIGABLE__EEXPRESSION = "self.end.navigable";

	/**
     * Validates the MustBeNavigable constraint of '<em>Link Traversal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkTraversal_MustBeNavigable(LinkTraversal linkTraversal, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.LINK_TRAVERSAL,
                 linkTraversal,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "MustBeNavigable",
                 LINK_TRAVERSAL__MUST_BE_NAVIGABLE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkAddition(LinkAddition linkAddition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(linkAddition, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotModifyExtentIfEqualityRelevantForValueClass(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotImplementSideEffectFreeOperation(linkAddition, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkAddition_AdditionInputTypeMatchEndType(linkAddition, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the AdditionInputTypeMatchEndType constraint of '<em>Link Addition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_ADDITION__ADDITION_INPUT_TYPE_MATCH_END_TYPE__EEXPRESSION = "self.implements_.output->isEmpty() and\r\n" +
        "  self.implements_.input->size() = 1 and \r\n" +
        "  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n" +
        "  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz";

	/**
     * Validates the AdditionInputTypeMatchEndType constraint of '<em>Link Addition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkAddition_AdditionInputTypeMatchEndType(LinkAddition linkAddition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.LINK_ADDITION,
                 linkAddition,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "AdditionInputTypeMatchEndType",
                 LINK_ADDITION__ADDITION_INPUT_TYPE_MATCH_END_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkRemoval(LinkRemoval linkRemoval, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(linkRemoval, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotModifyExtentIfEqualityRelevantForValueClass(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotImplementSideEffectFreeOperation(linkRemoval, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkRemoval_RemovalTypeMatchEndType(linkRemoval, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the RemovalTypeMatchEndType constraint of '<em>Link Removal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_REMOVAL__REMOVAL_TYPE_MATCH_END_TYPE__EEXPRESSION = "self.implements_.output->isEmpty() and\r\n" +
        "  self.implements_.input->size() = 1 and \r\n" +
        "  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n" +
        "  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz";

	/**
     * Validates the RemovalTypeMatchEndType constraint of '<em>Link Removal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkRemoval_RemovalTypeMatchEndType(LinkRemoval linkRemoval, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.LINK_REMOVAL,
                 linkRemoval,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "RemovalTypeMatchEndType",
                 LINK_REMOVAL__REMOVAL_TYPE_MATCH_END_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEndSignatureImplementation(AssociationEndSignatureImplementation associationEndSignatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(associationEndSignatureImplementation, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(associationEndSignatureImplementation, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt constraint of '<em>Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__ONLY_ON_OTHER_ENDS_CLASS_OR_CLASS_CONFORMING_TO_IT_OR_ADAPTER_ADAPTING_TO_IT__EEXPRESSION = "(self.implements_.owner.oclIsKindOf(SapClass) and\r\n" +
        "    self.implements_.owner.oclAsType(SapClass).conformsTo(self.end.otherEnd().type.clazz))\r\n" +
        "  or   (self.implements_.owner.oclIsKindOf(TypeAdapter) and\r\n" +
        "    self.implements_.owner.oclAsType(TypeAdapter).adapted.conformsTo(self.end.otherEnd().type.clazz))";

	/**
     * Validates the OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt constraint of '<em>Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(AssociationEndSignatureImplementation associationEndSignatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION,
                 associationEndSignatureImplementation,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt",
                 ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__ONLY_ON_OTHER_ENDS_CLASS_OR_CLASS_CONFORMING_TO_IT_OR_ADAPTER_ADAPTING_TO_IT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateClassTypeDefinition(ClassTypeDefinition classTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(classTypeDefinition, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validateClassTypeDefinition_ActualObjectsParametersMatchSignature(classTypeDefinition, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ActualObjectsParametersMatchSignature constraint of '<em>Class Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CLASS_TYPE_DEFINITION__ACTUAL_OBJECTS_PARAMETERS_MATCH_SIGNATURE__EEXPRESSION = "let numberOfMandatoryParameters:Integer =\r\n" +
        "    self.clazz.formalObjectParameters->select(p|p.defaultValue->isEmpty())->size()\r\n" +
        "  in\r\n" +
        "  self.objectParameters->size() >= numberOfMandatoryParameters and\r\n" +
        "  self.objectParameters->size() <= self.clazz.formalObjectParameters->size() and\r\n" +
        "  Sequence{1..self.objectParameters->size()}->forAll(i:Integer|\r\n" +
        "    self.objectParameters->at(i).formalObjectParameter =\r\n" +
        "    self.clazz.formalObjectParameters->at(i))";

	/**
     * Validates the ActualObjectsParametersMatchSignature constraint of '<em>Class Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateClassTypeDefinition_ActualObjectsParametersMatchSignature(ClassTypeDefinition classTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.CLASS_TYPE_DEFINITION,
                 classTypeDefinition,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ActualObjectsParametersMatchSignature",
                 CLASS_TYPE_DEFINITION__ACTUAL_OBJECTS_PARAMETERS_MATCH_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypeDefinition(TypeDefinition typeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(typeDefinition, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNestedTypeDefinition(NestedTypeDefinition nestedTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(nestedTypeDefinition, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nestedTypeDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validateNestedTypeDefinition_NestedIsAlwaysMany(nestedTypeDefinition, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the NestedIsAlwaysMany constraint of '<em>Nested Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String NESTED_TYPE_DEFINITION__NESTED_IS_ALWAYS_MANY__EEXPRESSION = "self.isMany()";

	/**
     * Validates the NestedIsAlwaysMany constraint of '<em>Nested Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNestedTypeDefinition_NestedIsAlwaysMany(NestedTypeDefinition nestedTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.NESTED_TYPE_DEFINITION,
                 nestedTypeDefinition,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "NestedIsAlwaysMany",
                 NESTED_TYPE_DEFINITION__NESTED_IS_ALWAYS_MANY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionSignatureTypeDefinition(FunctionSignatureTypeDefinition functionSignatureTypeDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(functionSignatureTypeDefinition, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMethodSignature(MethodSignature methodSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(methodSignature, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(methodSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignature_OnlyTrailingOptionalParameters(methodSignature, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionSignature(FunctionSignature functionSignature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(functionSignature, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionSignature, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignature_OnlyTrailingOptionalParameters(functionSignature, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkSetting(LinkSetting linkSetting, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(linkSetting, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotModifyExtentIfEqualityRelevantForValueClass(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotImplementSideEffectFreeOperation(linkSetting, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkSetting_InputTypeMatchEndType(linkSetting, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the InputTypeMatchEndType constraint of '<em>Link Setting</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_SETTING__INPUT_TYPE_MATCH_END_TYPE__EEXPRESSION = "self.implements_.output->isEmpty() and\r\n" +
        "  self.implements_.input->size() = 1 and \r\n" +
        "  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n" +
        "  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz";

	/**
     * Validates the InputTypeMatchEndType constraint of '<em>Link Setting</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkSetting_InputTypeMatchEndType(LinkSetting linkSetting, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.LINK_SETTING,
                 linkSetting,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "InputTypeMatchEndType",
                 LINK_SETTING__INPUT_TYPE_MATCH_END_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypeAdapter(TypeAdapter typeAdapter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(typeAdapter, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validateTypeAdapter_AllSignatureConforms(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validateTypeAdapter_SignaturesCannotBeAbstract(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validateTypeAdapter_IsFullAdaptationToTo(typeAdapter, diagnostics, context);
        if (result || diagnostics != null) result &= validateTypeAdapter_ValuesToValues_EntitiesToEntities(typeAdapter, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the AllSignatureConforms constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TYPE_ADAPTER__ALL_SIGNATURE_CONFORMS__EEXPRESSION = "self.ownedSignatures->forAll(selfSig:MethodSignature |\r\n" +
        "    self.to.signaturesWithDelegation()->exists(toSig:MethodSignature |\r\n" +
        "       selfSig.conformsTo(toSig)))";

	/**
     * Validates the AllSignatureConforms constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypeAdapter_AllSignatureConforms(TypeAdapter typeAdapter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.TYPE_ADAPTER,
                 typeAdapter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "AllSignatureConforms",
                 TYPE_ADAPTER__ALL_SIGNATURE_CONFORMS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the SignaturesCannotBeAbstract constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TYPE_ADAPTER__SIGNATURES_CANNOT_BE_ABSTRACT__EEXPRESSION = "self.ownedSignatures->forAll(selfSig:MethodSignature | not selfSig.isAbstract())";

	/**
     * Validates the SignaturesCannotBeAbstract constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypeAdapter_SignaturesCannotBeAbstract(TypeAdapter typeAdapter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.TYPE_ADAPTER,
                 typeAdapter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "SignaturesCannotBeAbstract",
                 TYPE_ADAPTER__SIGNATURES_CANNOT_BE_ABSTRACT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the IsFullAdaptationToTo constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TYPE_ADAPTER__IS_FULL_ADAPTATION_TO_TO__EEXPRESSION = "self.to.signaturesWithDelegation()->forAll(toSig|\r\n" +
        "    self.adapted.signaturesWithDelegation()->exists(adaptedSig|\r\n" +
        "      adaptedSig.conformsTo(toSig))\r\n" +
        "    or self.ownedSignatures->exists(ownedSig|\r\n" +
        "      ownedSig.conformsTo(toSig)))";

	/**
     * Validates the IsFullAdaptationToTo constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypeAdapter_IsFullAdaptationToTo(TypeAdapter typeAdapter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.TYPE_ADAPTER,
                 typeAdapter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "IsFullAdaptationToTo",
                 TYPE_ADAPTER__IS_FULL_ADAPTATION_TO_TO__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ValuesToValues_EntitiesToEntities constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TYPE_ADAPTER__VALUES_TO_VALUES_ENTITIES_TO_ENTITIES__EEXPRESSION = "self.adapted.valueType = self.to.valueType";

	/**
     * Validates the ValuesToValues_EntitiesToEntities constraint of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTypeAdapter_ValuesToValues_EntitiesToEntities(TypeAdapter typeAdapter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.TYPE_ADAPTER,
                 typeAdapter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ValuesToValues_EntitiesToEntities",
                 TYPE_ADAPTER__VALUES_TO_VALUES_ENTITIES_TO_ENTITIES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
        if (result || diagnostics != null) result &= validateParameter_DefaultValueType(parameter, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the DefaultValueType constraint of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String PARAMETER__DEFAULT_VALUE_TYPE__EEXPRESSION = "self.defaultValue->notEmpty() implies self.defaultValue.getType().conformsTo(self.getType())";

	/**
     * Validates the DefaultValueType constraint of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateParameter_DefaultValueType(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.PARAMETER,
                 parameter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "DefaultValueType",
                 PARAMETER__DEFAULT_VALUE_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNamedValue(NamedValue namedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(namedValue, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePlatformSpecificImplementation(PlatformSpecificImplementation platformSpecificImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(platformSpecificImplementation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNativeImpl(NativeImpl nativeImpl, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(nativeImpl, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignatureOwner(SignatureOwner signatureOwner, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(signatureOwner, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExtentModifyingAssociationEndSignatureImplementation(ExtentModifyingAssociationEndSignatureImplementation extentModifyingAssociationEndSignatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(extentModifyingAssociationEndSignatureImplementation, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotModifyExtentIfEqualityRelevantForValueClass(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotImplementSideEffectFreeOperation(extentModifyingAssociationEndSignatureImplementation, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the MustNotModifyExtentIfEqualityRelevantForValueClass constraint of '<em>Extent Modifying Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__MUST_NOT_MODIFY_EXTENT_IF_EQUALITY_RELEVANT_FOR_VALUE_CLASS__EEXPRESSION = "end.association.ends->forAll(ae:AssociationEnd |\r\n" +
        "    ae.contributesToEquality implies not ae.type.clazz.valueType)";

	/**
     * Validates the MustNotModifyExtentIfEqualityRelevantForValueClass constraint of '<em>Extent Modifying Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExtentModifyingAssociationEndSignatureImplementation_MustNotModifyExtentIfEqualityRelevantForValueClass(ExtentModifyingAssociationEndSignatureImplementation extentModifyingAssociationEndSignatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION,
                 extentModifyingAssociationEndSignatureImplementation,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "MustNotModifyExtentIfEqualityRelevantForValueClass",
                 EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__MUST_NOT_MODIFY_EXTENT_IF_EQUALITY_RELEVANT_FOR_VALUE_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MustNotImplementSideEffectFreeOperation constraint of '<em>Extent Modifying Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__MUST_NOT_IMPLEMENT_SIDE_EFFECT_FREE_OPERATION__EEXPRESSION = "not self.implements_.sideEffectFree";

	/**
     * Validates the MustNotImplementSideEffectFreeOperation constraint of '<em>Extent Modifying Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExtentModifyingAssociationEndSignatureImplementation_MustNotImplementSideEffectFreeOperation(ExtentModifyingAssociationEndSignatureImplementation extentModifyingAssociationEndSignatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION,
                 extentModifyingAssociationEndSignatureImplementation,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "MustNotImplementSideEffectFreeOperation",
                 EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__MUST_NOT_IMPLEMENT_SIDE_EFFECT_FREE_OPERATION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionSignatureImplementation(FunctionSignatureImplementation functionSignatureImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(functionSignatureImplementation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateActualObjectParameter(ActualObjectParameter actualObjectParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(actualObjectParameter, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConverterBetweenParametrizations(ConverterBetweenParametrizations converterBetweenParametrizations, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(converterBetweenParametrizations, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validateConverterBetweenParametrizations_MustHaveConcreteMethod(converterBetweenParametrizations, diagnostics, context);
        if (result || diagnostics != null) result &= validateConverterBetweenParametrizations_FormalObjectParametersConformToMethodParameters(converterBetweenParametrizations, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the MustHaveConcreteMethod constraint of '<em>Converter Between Parametrizations</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONVERTER_BETWEEN_PARAMETRIZATIONS__MUST_HAVE_CONCRETE_METHOD__EEXPRESSION = "not self.conversionMethod.isAbstract()";

	/**
     * Validates the MustHaveConcreteMethod constraint of '<em>Converter Between Parametrizations</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConverterBetweenParametrizations_MustHaveConcreteMethod(ConverterBetweenParametrizations converterBetweenParametrizations, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.CONVERTER_BETWEEN_PARAMETRIZATIONS,
                 converterBetweenParametrizations,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "MustHaveConcreteMethod",
                 CONVERTER_BETWEEN_PARAMETRIZATIONS__MUST_HAVE_CONCRETE_METHOD__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the FormalObjectParametersConformToMethodParameters constraint of '<em>Converter Between Parametrizations</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONVERTER_BETWEEN_PARAMETRIZATIONS__FORMAL_OBJECT_PARAMETERS_CONFORM_TO_METHOD_PARAMETERS__EEXPRESSION = "self.conversionMethod.input->size() = self.clazz.formalObjectParameters->size() and\r\n" +
        "  Sequence{1..self.conversionMethod.input->size()}->forAll(i |\r\n" +
        "    self.clazz.formalObjectParameters->at(i).conformsTo(self.conversionMethod.input->at(i)))";

	/**
     * Validates the FormalObjectParametersConformToMethodParameters constraint of '<em>Converter Between Parametrizations</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConverterBetweenParametrizations_FormalObjectParametersConformToMethodParameters(ConverterBetweenParametrizations converterBetweenParametrizations, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ClassesPackage.Literals.CONVERTER_BETWEEN_PARAMETRIZATIONS,
                 converterBetweenParametrizations,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "FormalObjectParametersConformToMethodParameters",
                 CONVERTER_BETWEEN_PARAMETRIZATIONS__FORMAL_OBJECT_PARAMETERS_CONFORM_TO_METHOD_PARAMETERS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkManipulationAtPosition(LinkManipulationAtPosition linkManipulationAtPosition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(linkManipulationAtPosition, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndSignatureImplementation_OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotModifyExtentIfEqualityRelevantForValueClass(linkManipulationAtPosition, diagnostics, context);
        if (result || diagnostics != null) result &= validateExtentModifyingAssociationEndSignatureImplementation_MustNotImplementSideEffectFreeOperation(linkManipulationAtPosition, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateInScope(InScope inScope, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(inScope, diagnostics, context);
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

} //ClassesValidator
