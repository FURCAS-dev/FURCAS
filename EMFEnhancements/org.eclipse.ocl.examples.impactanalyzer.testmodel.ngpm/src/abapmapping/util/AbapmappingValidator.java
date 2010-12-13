/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.util;

import abapmapping.*;

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
 * @see abapmapping.AbapmappingPackage
 * @generated
 */
public class AbapmappingValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final AbapmappingValidator INSTANCE = new AbapmappingValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "abapmapping";

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
	public AbapmappingValidator() {
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
      return AbapmappingPackage.eINSTANCE;
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
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION:
                return validateAbapClassImplementationAnnotation((AbapClassImplementationAnnotation)value, diagnostics, context);
            case AbapmappingPackage.ABAP_ASSOCIATION_IMPLEMENTATION_ANNOTATION:
                return validateAbapAssociationImplementationAnnotation((AbapAssociationImplementationAnnotation)value, diagnostics, context);
            case AbapmappingPackage.ABAP_ASSOCIATION_END_IMPLEMENTATION_ANNOTATION:
                return validateAbapAssociationEndImplementationAnnotation((AbapAssociationEndImplementationAnnotation)value, diagnostics, context);
            case AbapmappingPackage.ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION:
                return validateAbapSignatureImplementationAnnotation((AbapSignatureImplementationAnnotation)value, diagnostics, context);
            case AbapmappingPackage.ABAP_CLASS_KIND:
                return validateAbapClassKind((AbapClassKind)value, diagnostics, context);
            case AbapmappingPackage.ABAP_SIGNATURE_KIND:
                return validateAbapSignatureKind((AbapSignatureKind)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapClassImplementationAnnotation(AbapClassImplementationAnnotation abapClassImplementationAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(abapClassImplementationAnnotation, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abapClassImplementationAnnotation, diagnostics, context);
        if (result || diagnostics != null) result &= validateAbapClassImplementationAnnotation_AbapTypeMustBeUnstructured(abapClassImplementationAnnotation, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the AbapTypeMustBeUnstructured constraint of '<em>Abap Class Implementation Annotation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE_MUST_BE_UNSTRUCTURED__EEXPRESSION = "self.kind = AbapClassKind::ABAP_TYPE implies\r\n" +
        "    self.abapType.oclIsKindOf(abapmapping::abapdictionary::UnstructuredAbapType)";

	/**
     * Validates the AbapTypeMustBeUnstructured constraint of '<em>Abap Class Implementation Annotation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapClassImplementationAnnotation_AbapTypeMustBeUnstructured(AbapClassImplementationAnnotation abapClassImplementationAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AbapmappingPackage.Literals.ABAP_CLASS_IMPLEMENTATION_ANNOTATION,
                 abapClassImplementationAnnotation,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "AbapTypeMustBeUnstructured",
                 ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE_MUST_BE_UNSTRUCTURED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapAssociationImplementationAnnotation(AbapAssociationImplementationAnnotation abapAssociationImplementationAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapAssociationImplementationAnnotation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapAssociationEndImplementationAnnotation(AbapAssociationEndImplementationAnnotation abapAssociationEndImplementationAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapAssociationEndImplementationAnnotation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapSignatureImplementationAnnotation(AbapSignatureImplementationAnnotation abapSignatureImplementationAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapSignatureImplementationAnnotation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapClassKind(AbapClassKind abapClassKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapSignatureKind(AbapSignatureKind abapSignatureKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //AbapmappingValidator
