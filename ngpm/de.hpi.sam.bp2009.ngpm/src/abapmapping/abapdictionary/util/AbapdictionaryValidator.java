/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.util;

import abapmapping.abapdictionary.*;

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
 * @see abapmapping.abapdictionary.AbapdictionaryPackage
 * @generated
 */
public class AbapdictionaryValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final AbapdictionaryValidator INSTANCE = new AbapdictionaryValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "abapmapping.abapdictionary";

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
	public AbapdictionaryValidator() {
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
      return AbapdictionaryPackage.eINSTANCE;
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
            case AbapdictionaryPackage.XSD_TYPE:
                return validateXsdType((XsdType)value, diagnostics, context);
            case AbapdictionaryPackage.UNSTRUCTURED_ABAP_TYPE:
                return validateUnstructuredAbapType((UnstructuredAbapType)value, diagnostics, context);
            case AbapdictionaryPackage.CODE_VALUE:
                return validateCodeValue((CodeValue)value, diagnostics, context);
            case AbapdictionaryPackage.CODE:
                return validateCode((Code)value, diagnostics, context);
            case AbapdictionaryPackage.DATA_ELEMENT:
                return validateDataElement((DataElement)value, diagnostics, context);
            case AbapdictionaryPackage.ABAP_TYPE:
                return validateAbapType((AbapType)value, diagnostics, context);
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE:
                return validateAbapStructureType((AbapStructureType)value, diagnostics, context);
            case AbapdictionaryPackage.ABAP_STRUCTURE_FIELD:
                return validateAbapStructureField((AbapStructureField)value, diagnostics, context);
            case AbapdictionaryPackage.ABAP_PRIMTIVE_TYPE:
                return validateAbapPrimtiveType((AbapPrimtiveType)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateXsdType(XsdType xsdType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(xsdType, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateUnstructuredAbapType(UnstructuredAbapType unstructuredAbapType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(unstructuredAbapType, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCodeValue(CodeValue codeValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(codeValue, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCode(Code code, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(code, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(code, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(code, diagnostics, context);
        if (result || diagnostics != null) result &= validateCode_TypeOfValuesEqualsAbapType(code, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the TypeOfValuesEqualsAbapType constraint of '<em>Code</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CODE__TYPE_OF_VALUES_EQUALS_ABAP_TYPE__EEXPRESSION = "self.values->forAll(cv:CodeValue |\r\n" +
        "      cv.type = self.abapType)";

	/**
     * Validates the TypeOfValuesEqualsAbapType constraint of '<em>Code</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCode_TypeOfValuesEqualsAbapType(Code code, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AbapdictionaryPackage.Literals.CODE,
                 code,
                 diagnostics,
                 context,
                 "http://de.hpi.sam.bp2009.OCL",
                 "TypeOfValuesEqualsAbapType",
                 CODE__TYPE_OF_VALUES_EQUALS_ABAP_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDataElement(DataElement dataElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(dataElement, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapType(AbapType abapType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapType, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapStructureType(AbapStructureType abapStructureType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapStructureType, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapStructureField(AbapStructureField abapStructureField, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapStructureField, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAbapPrimtiveType(AbapPrimtiveType abapPrimtiveType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abapPrimtiveType, diagnostics, context);
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

} //AbapdictionaryValidator
