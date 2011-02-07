/**
 * <copyright>
 * </copyright>
 *
 * $Id: LiteralsValidator.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.literals.util;

import dataaccess.expressions.literals.*;

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
 * @see dataaccess.expressions.literals.LiteralsPackage
 * @generated
 */
public class LiteralsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final LiteralsValidator INSTANCE = new LiteralsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "dataaccess.expressions.literals";

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
	public LiteralsValidator() {
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
      return LiteralsPackage.eINSTANCE;
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
            case LiteralsPackage.LITERAL:
                return validateLiteral((Literal)value, diagnostics, context);
            case LiteralsPackage.BINARY_LITERAL:
                return validateBinaryLiteral((BinaryLiteral)value, diagnostics, context);
            case LiteralsPackage.STRING_LITERAL:
                return validateStringLiteral((StringLiteral)value, diagnostics, context);
            case LiteralsPackage.NUMBER_LITERAL:
                return validateNumberLiteral((NumberLiteral)value, diagnostics, context);
            case LiteralsPackage.TIME_POINT_LITERAL:
                return validateTimePointLiteral((TimePointLiteral)value, diagnostics, context);
            case LiteralsPackage.BOOLEAN_LITERAL:
                return validateBooleanLiteral((BooleanLiteral)value, diagnostics, context);
            case LiteralsPackage.OBJECT_LITERAL:
                return validateObjectLiteral((ObjectLiteral)value, diagnostics, context);
            case LiteralsPackage.VALUE_INIT:
                return validateValueInit((ValueInit)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLiteral(Literal literal, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(literal, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBinaryLiteral(BinaryLiteral binaryLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(binaryLiteral, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(stringLiteral, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNumberLiteral(NumberLiteral numberLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(numberLiteral, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTimePointLiteral(TimePointLiteral timePointLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(timePointLiteral, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBooleanLiteral(BooleanLiteral booleanLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(booleanLiteral, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectLiteral(ObjectLiteral objectLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(objectLiteral, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectLiteral_ObjectLiteralsForValueClassesOnly(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectLiteral_ObjectLiteralPropertiesOnRightClass(objectLiteral, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectLiteral_ValuesMustBeProvidedForAllMandatoryProperties(objectLiteral, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ObjectLiteralsForValueClassesOnly constraint of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_LITERAL__OBJECT_LITERALS_FOR_VALUE_CLASSES_ONLY__EEXPRESSION = "self.valueClass.valueType";

	/**
     * Validates the ObjectLiteralsForValueClassesOnly constraint of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectLiteral_ObjectLiteralsForValueClassesOnly(ObjectLiteral objectLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (LiteralsPackage.Literals.OBJECT_LITERAL,
                 objectLiteral,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ObjectLiteralsForValueClassesOnly",
                 OBJECT_LITERAL__OBJECT_LITERALS_FOR_VALUE_CLASSES_ONLY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ObjectLiteralPropertiesOnRightClass constraint of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_LITERAL__OBJECT_LITERAL_PROPERTIES_ON_RIGHT_CLASS__EEXPRESSION = "self.propertyValues->forAll(vi|vi.forEnd.otherEnd().type.clazz = self.valueClass)";

	/**
     * Validates the ObjectLiteralPropertiesOnRightClass constraint of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectLiteral_ObjectLiteralPropertiesOnRightClass(ObjectLiteral objectLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (LiteralsPackage.Literals.OBJECT_LITERAL,
                 objectLiteral,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ObjectLiteralPropertiesOnRightClass",
                 OBJECT_LITERAL__OBJECT_LITERAL_PROPERTIES_ON_RIGHT_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ValuesMustBeProvidedForAllMandatoryProperties constraint of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_LITERAL__VALUES_MUST_BE_PROVIDED_FOR_ALL_MANDATORY_PROPERTIES__EEXPRESSION = "self.valueClass.getEqualityRelevantAssociationEnds()->select(ae | ae.otherEnd().type.lowerMultiplicity > 0)->forAll(ae |\r\n" +
        "      self.propertyValues->exists(pv | pv.forEnd.otherEnd() = ae))";

	/**
     * Validates the ValuesMustBeProvidedForAllMandatoryProperties constraint of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectLiteral_ValuesMustBeProvidedForAllMandatoryProperties(ObjectLiteral objectLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (LiteralsPackage.Literals.OBJECT_LITERAL,
                 objectLiteral,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ValuesMustBeProvidedForAllMandatoryProperties",
                 OBJECT_LITERAL__VALUES_MUST_BE_PROVIDED_FOR_ALL_MANDATORY_PROPERTIES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateValueInit(ValueInit valueInit, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(valueInit, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(valueInit, diagnostics, context);
        if (result || diagnostics != null) result &= validateValueInit_ValueInitTypeConforms(valueInit, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ValueInitTypeConforms constraint of '<em>Value Init</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String VALUE_INIT__VALUE_INIT_TYPE_CONFORMS__EEXPRESSION = "self.value.getType().conformsTo(self.forEnd.type)";

	/**
     * Validates the ValueInitTypeConforms constraint of '<em>Value Init</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateValueInit_ValueInitTypeConforms(ValueInit valueInit, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (LiteralsPackage.Literals.VALUE_INIT,
                 valueInit,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ValueInitTypeConforms",
                 VALUE_INIT__VALUE_INIT_TYPE_CONFORMS__EEXPRESSION,
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

} //LiteralsValidator
