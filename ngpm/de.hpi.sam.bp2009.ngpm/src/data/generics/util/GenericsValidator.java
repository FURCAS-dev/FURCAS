/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics.util;

import data.classes.util.ClassesValidator;

import data.generics.*;

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
 * @see data.generics.GenericsPackage
 * @generated
 */
public class GenericsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final GenericsValidator INSTANCE = new GenericsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "data.generics";

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
     * The cached base package validator.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClassesValidator classesValidator;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GenericsValidator() {
        super();
        classesValidator = ClassesValidator.INSTANCE;
    }

	/**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EPackage getEPackage() {
      return GenericsPackage.eINSTANCE;
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER:
                return validateFormalTypeParameter((FormalTypeParameter)value, diagnostics, context);
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION:
                return validateParameterizedClassInstantiation((ParameterizedClassInstantiation)value, diagnostics, context);
            case GenericsPackage.CLASS_PARAMETERIZATION:
                return validateClassParameterization((ClassParameterization)value, diagnostics, context);
            case GenericsPackage.ACTUAL_TYPE_PARAMETER:
                return validateActualTypeParameter((ActualTypeParameter)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFormalTypeParameter(FormalTypeParameter formalTypeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(formalTypeParameter, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_OnlyValueClassesCanHaveObjectParameters(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_OnlyObjectParameterizedClassesCanHaveConverter(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_OnlyTrailingOptionalParameters(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_NoRecursionForObjectParameters(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validateFormalTypeParameter_UseInSignaturesOfOwningParamerizedClassOnly(formalTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validateFormalTypeParameter_UseInAssociationsOfOwningParameterizedClassOnly(formalTypeParameter, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the UseInSignaturesOfOwningParamerizedClassOnly constraint of '<em>Formal Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FORMAL_TYPE_PARAMETER__USE_IN_SIGNATURES_OF_OWNING_PARAMERIZED_CLASS_ONLY__EEXPRESSION = "self.elementsOfType.getTypeUsage()->forAll(s | s.oclIsKindOf(data::classes::Parameter) implies \r\n" +
        "   (s.oclAsType(data::classes::Parameter).ownerSignature.oclIsKindOf(data::classes::MethodSignature) and\r\n" +
        "    s.oclAsType(data::classes::Parameter).ownerSignature.oclAsType(data::classes::MethodSignature).owner=self.parameterOf .owningClassDefinition)) and\r\n" +
        "  self.elementsOfType.signaturesWithOutput->forAll(s| s.oclIsKindOf(data::classes::MethodSignature) and \r\n" +
        "    s.oclAsType(data::classes::MethodSignature).owner->notEmpty() and\r\n" +
        "    s.oclAsType(data::classes::MethodSignature).owner=self.parameterOf.owningClassDefinition) and\r\n" +
        "  self.signaturesWithFault->forAll(s| s.oclIsKindOf(data::classes::MethodSignature)  and \r\n" +
        "    s.oclAsType(data::classes::MethodSignature).owner->notEmpty() and\r\n" +
        "    s.oclAsType(data::classes::MethodSignature).owner=self.parameterOf.owningClassDefinition)";

	/**
     * Validates the UseInSignaturesOfOwningParamerizedClassOnly constraint of '<em>Formal Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFormalTypeParameter_UseInSignaturesOfOwningParamerizedClassOnly(FormalTypeParameter formalTypeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (GenericsPackage.Literals.FORMAL_TYPE_PARAMETER,
                 formalTypeParameter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "UseInSignaturesOfOwningParamerizedClassOnly",
                 FORMAL_TYPE_PARAMETER__USE_IN_SIGNATURES_OF_OWNING_PARAMERIZED_CLASS_ONLY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the UseInAssociationsOfOwningParameterizedClassOnly constraint of '<em>Formal Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FORMAL_TYPE_PARAMETER__USE_IN_ASSOCIATIONS_OF_OWNING_PARAMETERIZED_CLASS_ONLY__EEXPRESSION = "self.elementsOfType.associationEnd->\r\n" +
        "    forAll(ae | ae.otherEnd().type.clazz = self.parameterOf.owningClassDefinition)";

	/**
     * Validates the UseInAssociationsOfOwningParameterizedClassOnly constraint of '<em>Formal Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFormalTypeParameter_UseInAssociationsOfOwningParameterizedClassOnly(FormalTypeParameter formalTypeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (GenericsPackage.Literals.FORMAL_TYPE_PARAMETER,
                 formalTypeParameter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "UseInAssociationsOfOwningParameterizedClassOnly",
                 FORMAL_TYPE_PARAMETER__USE_IN_ASSOCIATIONS_OF_OWNING_PARAMETERIZED_CLASS_ONLY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateParameterizedClassInstantiation(ParameterizedClassInstantiation parameterizedClassInstantiation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(parameterizedClassInstantiation, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_OnlyValueClassesCanHaveObjectParameters(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_OnlyObjectParameterizedClassesCanHaveConverter(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_OnlyTrailingOptionalParameters(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= classesValidator.validateSapClass_NoRecursionForObjectParameters(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validateParameterizedClassInstantiation_ActualTypeParametersMatchSignature(parameterizedClassInstantiation, diagnostics, context);
        if (result || diagnostics != null) result &= validateParameterizedClassInstantiation_ClassMustBeParameterized(parameterizedClassInstantiation, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ActualTypeParametersMatchSignature constraint of '<em>Parameterized Class Instantiation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_MATCH_SIGNATURE__EEXPRESSION = "self.actualTypeParametersForInstantiation->size() = self.parameterizedClass.parameterization.formalTypeParameters->size() and\r\n" +
        "  Sequence{1..self.actualTypeParametersForInstantiation->size()}->forAll(i:Integer|\r\n" +
        "    self.actualTypeParametersForInstantiation->at(i).formalTypeParameter =\r\n" +
        "    self.parameterizedClass.parameterization.formalTypeParameters->at(i))";

	/**
     * Validates the ActualTypeParametersMatchSignature constraint of '<em>Parameterized Class Instantiation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateParameterizedClassInstantiation_ActualTypeParametersMatchSignature(ParameterizedClassInstantiation parameterizedClassInstantiation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (GenericsPackage.Literals.PARAMETERIZED_CLASS_INSTANTIATION,
                 parameterizedClassInstantiation,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ActualTypeParametersMatchSignature",
                 PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_MATCH_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ClassMustBeParameterized constraint of '<em>Parameterized Class Instantiation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String PARAMETERIZED_CLASS_INSTANTIATION__CLASS_MUST_BE_PARAMETERIZED__EEXPRESSION = "self.parameterizedClass.parameterization->notEmpty()";

	/**
     * Validates the ClassMustBeParameterized constraint of '<em>Parameterized Class Instantiation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateParameterizedClassInstantiation_ClassMustBeParameterized(ParameterizedClassInstantiation parameterizedClassInstantiation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (GenericsPackage.Literals.PARAMETERIZED_CLASS_INSTANTIATION,
                 parameterizedClassInstantiation,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "ClassMustBeParameterized",
                 PARAMETERIZED_CLASS_INSTANTIATION__CLASS_MUST_BE_PARAMETERIZED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateClassParameterization(ClassParameterization classParameterization, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(classParameterization, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classParameterization, diagnostics, context);
        if (result || diagnostics != null) result &= validateClassParameterization_DistinctFormalTypeParameterNames(classParameterization, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the DistinctFormalTypeParameterNames constraint of '<em>Class Parameterization</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CLASS_PARAMETERIZATION__DISTINCT_FORMAL_TYPE_PARAMETER_NAMES__EEXPRESSION = "self.formalTypeParameters->forAll(i,j|i<>j implies i.name<>j.name)";

	/**
     * Validates the DistinctFormalTypeParameterNames constraint of '<em>Class Parameterization</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateClassParameterization_DistinctFormalTypeParameterNames(ClassParameterization classParameterization, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (GenericsPackage.Literals.CLASS_PARAMETERIZATION,
                 classParameterization,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "DistinctFormalTypeParameterNames",
                 CLASS_PARAMETERIZATION__DISTINCT_FORMAL_TYPE_PARAMETER_NAMES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateActualTypeParameter(ActualTypeParameter actualTypeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(actualTypeParameter, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actualTypeParameter, diagnostics, context);
        if (result || diagnostics != null) result &= validateActualTypeParameter_TypeConformsWithFormalParametersTypeConstraint(actualTypeParameter, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the TypeConformsWithFormalParametersTypeConstraint constraint of '<em>Actual Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ACTUAL_TYPE_PARAMETER__TYPE_CONFORMS_WITH_FORMAL_PARAMETERS_TYPE_CONSTRAINT__EEXPRESSION = "self.formalTypeParameter.typeConstraint->notEmpty() implies\r\n" +
        "    self.type.conformsTo(self.formalTypeParameter.typeConstraint)";

	/**
     * Validates the TypeConformsWithFormalParametersTypeConstraint constraint of '<em>Actual Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateActualTypeParameter_TypeConformsWithFormalParametersTypeConstraint(ActualTypeParameter actualTypeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (GenericsPackage.Literals.ACTUAL_TYPE_PARAMETER,
                 actualTypeParameter,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "TypeConformsWithFormalParametersTypeConstraint",
                 ACTUAL_TYPE_PARAMETER__TYPE_CONFORMS_WITH_FORMAL_PARAMETERS_TYPE_CONSTRAINT__EEXPRESSION,
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

} //GenericsValidator
