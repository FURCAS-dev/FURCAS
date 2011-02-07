/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpressionsValidator.java,v 1.1 2011/02/07 16:53:52 auhl Exp $
 */
package dataaccess.expressions.util;

import dataaccess.expressions.*;

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
 * @see dataaccess.expressions.ExpressionsPackage
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
	public static final String DIAGNOSTIC_SOURCE = "dataaccess.expressions";

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
	public ExpressionsValidator() {
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
            case ExpressionsPackage.EXPRESSION:
                return validateExpression((Expression)value, diagnostics, context);
            case ExpressionsPackage.VARIABLE_EXPRESSION:
                return validateVariableExpression((VariableExpression)value, diagnostics, context);
            case ExpressionsPackage.METHOD_CALL_EXPRESSION:
                return validateMethodCallExpression((MethodCallExpression)value, diagnostics, context);
            case ExpressionsPackage.OBJECT_BASED_EXPRESSION:
                return validateObjectBasedExpression((ObjectBasedExpression)value, diagnostics, context);
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION:
                return validateObjectCreationExpression((ObjectCreationExpression)value, diagnostics, context);
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION:
                return validateFunctionCallExpression((FunctionCallExpression)value, diagnostics, context);
            case ExpressionsPackage.WITH_ARGUMENT:
                return validateWithArgument((WithArgument)value, diagnostics, context);
            case ExpressionsPackage.THIS:
                return validateThis((This)value, diagnostics, context);
            case ExpressionsPackage.EQUALS:
                return validateEquals((Equals)value, diagnostics, context);
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION:
                return validateAssociationEndNavigationExpression((AssociationEndNavigationExpression)value, diagnostics, context);
            case ExpressionsPackage.SIGNATURE_CALL_EXPRESSION:
                return validateSignatureCallExpression((SignatureCallExpression)value, diagnostics, context);
            case ExpressionsPackage.OBJECT_COUNT:
                return validateObjectCount((ObjectCount)value, diagnostics, context);
            case ExpressionsPackage.REPLACE:
                return validateReplace((Replace)value, diagnostics, context);
            case ExpressionsPackage.NAVIGATION_STEP:
                return validateNavigationStep((NavigationStep)value, diagnostics, context);
            case ExpressionsPackage.HEAD:
                return validateHead((Head)value, diagnostics, context);
            case ExpressionsPackage.TAIL:
                return validateTail((Tail)value, diagnostics, context);
            case ExpressionsPackage.AS_LIST:
                return validateAsList((AsList)value, diagnostics, context);
            case ExpressionsPackage.CONDITIONAL:
                return validateConditional((Conditional)value, diagnostics, context);
            case ExpressionsPackage.TERNARY:
                return validateTernary((Ternary)value, diagnostics, context);
            case ExpressionsPackage.CONTENT_EQUALS:
                return validateContentEquals((ContentEquals)value, diagnostics, context);
            case ExpressionsPackage.EXPRESSION_WITH_ARGUMENT:
                return validateExpressionWithArgument((ExpressionWithArgument)value, diagnostics, context);
            case ExpressionsPackage.CONDITIONAL_EXPRESSION:
                return validateConditionalExpression((ConditionalExpression)value, diagnostics, context);
            case ExpressionsPackage.MAP:
                return validateMap((dataaccess.expressions.Map)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExpression(Expression expression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(expression, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateVariableExpression(VariableExpression variableExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(variableExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateVariableExpression_VariableExpressionType(variableExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the VariableExpressionType constraint of '<em>Variable Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String VARIABLE_EXPRESSION__VARIABLE_EXPRESSION_TYPE__EEXPRESSION = "self.getType().conformsTo(self.variable.getType())";

	/**
     * Validates the VariableExpressionType constraint of '<em>Variable Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateVariableExpression_VariableExpressionType(VariableExpression variableExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.VARIABLE_EXPRESSION,
                 variableExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "VariableExpressionType",
                 VARIABLE_EXPRESSION__VARIABLE_EXPRESSION_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMethodCallExpression(MethodCallExpression methodCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(methodCallExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignatureCallExpression_ParametersTypesMustMatchSignatureParametersTypes(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignatureCallExpression_CallTypeMustMatchSignatureOutput(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateMethodCallExpression_ObjectMustSupportOperation(methodCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateMethodCallExpression_OutputMultiplicities(methodCallExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ObjectMustSupportOperation constraint of '<em>Method Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String METHOD_CALL_EXPRESSION__OBJECT_MUST_SUPPORT_OPERATION__EEXPRESSION = "self.object.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.conformsTo(self.methodSignature.owner.oclAsType(data::classes::SapClass))";

	/**
     * Validates the ObjectMustSupportOperation constraint of '<em>Method Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMethodCallExpression_ObjectMustSupportOperation(MethodCallExpression methodCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.METHOD_CALL_EXPRESSION,
                 methodCallExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ObjectMustSupportOperation",
                 METHOD_CALL_EXPRESSION__OBJECT_MUST_SUPPORT_OPERATION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the OutputMultiplicities constraint of '<em>Method Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String METHOD_CALL_EXPRESSION__OUTPUT_MULTIPLICITIES__EEXPRESSION = "(self.object.getType().isMany() implies (self.getType().isMany() and not self.getType().unique)) and\r\n" +
        "  (self.object.getType().lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))";

	/**
     * Validates the OutputMultiplicities constraint of '<em>Method Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMethodCallExpression_OutputMultiplicities(MethodCallExpression methodCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.METHOD_CALL_EXPRESSION,
                 methodCallExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "OutputMultiplicities",
                 METHOD_CALL_EXPRESSION__OUTPUT_MULTIPLICITIES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectBasedExpression(ObjectBasedExpression objectBasedExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(objectBasedExpression, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCreationExpression(ObjectCreationExpression objectCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(objectCreationExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCreationExpression_CannotInstantiateAbstractClass(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCreationExpression_ExpressionType(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCreationExpression_HasToOwnTypeDefinition(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCreationExpression_CannotInstantiateValueClass(objectCreationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCreationExpression_NoDuplicateInitializers(objectCreationExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the CannotInstantiateAbstractClass constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_CREATION_EXPRESSION__CANNOT_INSTANTIATE_ABSTRACT_CLASS__EEXPRESSION = "not self.classToInstantiate.isAbstract()";

	/**
     * Validates the CannotInstantiateAbstractClass constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCreationExpression_CannotInstantiateAbstractClass(ObjectCreationExpression objectCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_CREATION_EXPRESSION,
                 objectCreationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CannotInstantiateAbstractClass",
                 OBJECT_CREATION_EXPRESSION__CANNOT_INSTANTIATE_ABSTRACT_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ExpressionType constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_CREATION_EXPRESSION__EXPRESSION_TYPE__EEXPRESSION = "self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz = self.classToInstantiate and\r\n" +
        "  self.getType().lowerMultiplicity = 1 and\r\n" +
        "  self.getType().upperMultiplicity = 1";

	/**
     * Validates the ExpressionType constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCreationExpression_ExpressionType(ObjectCreationExpression objectCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_CREATION_EXPRESSION,
                 objectCreationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ExpressionType",
                 OBJECT_CREATION_EXPRESSION__EXPRESSION_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the HasToOwnTypeDefinition constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_CREATION_EXPRESSION__HAS_TO_OWN_TYPE_DEFINITION__EEXPRESSION = "self.ownedTypeDefinition->notEmpty()";

	/**
     * Validates the HasToOwnTypeDefinition constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCreationExpression_HasToOwnTypeDefinition(ObjectCreationExpression objectCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_CREATION_EXPRESSION,
                 objectCreationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "HasToOwnTypeDefinition",
                 OBJECT_CREATION_EXPRESSION__HAS_TO_OWN_TYPE_DEFINITION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the CannotInstantiateValueClass constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_CREATION_EXPRESSION__CANNOT_INSTANTIATE_VALUE_CLASS__EEXPRESSION = "not self.classToInstantiate.valueType";

	/**
     * Validates the CannotInstantiateValueClass constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCreationExpression_CannotInstantiateValueClass(ObjectCreationExpression objectCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_CREATION_EXPRESSION,
                 objectCreationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CannotInstantiateValueClass",
                 OBJECT_CREATION_EXPRESSION__CANNOT_INSTANTIATE_VALUE_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the NoDuplicateInitializers constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_CREATION_EXPRESSION__NO_DUPLICATE_INITIALIZERS__EEXPRESSION = "self.initializers->forAll( a, b | a <> b implies a.methodSignature <> b.methodSignature )";

	/**
     * Validates the NoDuplicateInitializers constraint of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCreationExpression_NoDuplicateInitializers(ObjectCreationExpression objectCreationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_CREATION_EXPRESSION,
                 objectCreationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "NoDuplicateInitializers",
                 OBJECT_CREATION_EXPRESSION__NO_DUPLICATE_INITIALIZERS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionCallExpression(FunctionCallExpression functionCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(functionCallExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignatureCallExpression_ParametersTypesMustMatchSignatureParametersTypes(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignatureCallExpression_CallTypeMustMatchSignatureOutput(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateFunctionCallExpression_ResultType(functionCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateFunctionCallExpression_CalledBlockMustBeFunction(functionCallExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ResultType constraint of '<em>Function Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FUNCTION_CALL_EXPRESSION__RESULT_TYPE__EEXPRESSION = "let fstd:data::classes::FunctionSignatureTypeDefinition = self.calledBlock.getType().getInnermost().oclAsType(data::classes::FunctionSignatureTypeDefinition) in\r\n" +
        "\r\n" +
        "  if fstd.isMany() then\r\n" +
        "    -- calling multiple functions; test is somewhat fuzzy because it doesn't test condormance of nesting structure exactly\r\n" +
        "    self.getType().isMany() and not self.getType().unique and\r\n" +
        "    fstd.signature.output.getInnermost().conformsTo(self.getType().getInnermost()) and\r\n" +
        "    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\r\n" +
        "  else\r\n" +
        "    -- calling a single function\r\n" +
        "    fstd.signature.output.conformsTo(self.getType()) and \r\n" +
        "    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\r\n" +
        "  endif";

	/**
     * Validates the ResultType constraint of '<em>Function Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionCallExpression_ResultType(FunctionCallExpression functionCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.FUNCTION_CALL_EXPRESSION,
                 functionCallExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ResultType",
                 FUNCTION_CALL_EXPRESSION__RESULT_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the CalledBlockMustBeFunction constraint of '<em>Function Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FUNCTION_CALL_EXPRESSION__CALLED_BLOCK_MUST_BE_FUNCTION__EEXPRESSION = "self.calledBlock.getType().getInnermost().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)";

	/**
     * Validates the CalledBlockMustBeFunction constraint of '<em>Function Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFunctionCallExpression_CalledBlockMustBeFunction(FunctionCallExpression functionCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.FUNCTION_CALL_EXPRESSION,
                 functionCallExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CalledBlockMustBeFunction",
                 FUNCTION_CALL_EXPRESSION__CALLED_BLOCK_MUST_BE_FUNCTION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateWithArgument(WithArgument withArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(withArgument, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateThis(This this_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(this_, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateEquals(Equals equals, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(equals, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equals, diagnostics, context);
        if (result || diagnostics != null) result &= validateEquals_ConformaceOneWayOrAnother(equals, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ConformaceOneWayOrAnother constraint of '<em>Equals</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String EQUALS__CONFORMACE_ONE_WAY_OR_ANOTHER__EEXPRESSION = "self.left.getType().conformsTo(self.right.getType()) or\r\n" +
        "  self.right.getType().conformsTo(self.left.getType())";

	/**
     * Validates the ConformaceOneWayOrAnother constraint of '<em>Equals</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateEquals_ConformaceOneWayOrAnother(Equals equals, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.EQUALS,
                 equals,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ConformaceOneWayOrAnother",
                 EQUALS__CONFORMACE_ONE_WAY_OR_ANOTHER__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEndNavigationExpression(AssociationEndNavigationExpression associationEndNavigationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(associationEndNavigationExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndNavigationExpression_ObjectTypeMustMatch(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndNavigationExpression_ResultType(associationEndNavigationExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssociationEndNavigationExpression_EndMustBeNavigable(associationEndNavigationExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ObjectTypeMustMatch constraint of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END_NAVIGATION_EXPRESSION__OBJECT_TYPE_MUST_MATCH__EEXPRESSION = "self.object.getType().conformsToIgnoringMultiplicity(self.toEnd.otherEnd().type)";

	/**
     * Validates the ObjectTypeMustMatch constraint of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEndNavigationExpression_ObjectTypeMustMatch(AssociationEndNavigationExpression associationEndNavigationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.ASSOCIATION_END_NAVIGATION_EXPRESSION,
                 associationEndNavigationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ObjectTypeMustMatch",
                 ASSOCIATION_END_NAVIGATION_EXPRESSION__OBJECT_TYPE_MUST_MATCH__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ResultType constraint of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END_NAVIGATION_EXPRESSION__RESULT_TYPE__EEXPRESSION = "self.getType() = self.toEnd.type";

	/**
     * Validates the ResultType constraint of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEndNavigationExpression_ResultType(AssociationEndNavigationExpression associationEndNavigationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.ASSOCIATION_END_NAVIGATION_EXPRESSION,
                 associationEndNavigationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ResultType",
                 ASSOCIATION_END_NAVIGATION_EXPRESSION__RESULT_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the EndMustBeNavigable constraint of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSOCIATION_END_NAVIGATION_EXPRESSION__END_MUST_BE_NAVIGABLE__EEXPRESSION = "self.toEnd.navigable";

	/**
     * Validates the EndMustBeNavigable constraint of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssociationEndNavigationExpression_EndMustBeNavigable(AssociationEndNavigationExpression associationEndNavigationExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.ASSOCIATION_END_NAVIGATION_EXPRESSION,
                 associationEndNavigationExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "EndMustBeNavigable",
                 ASSOCIATION_END_NAVIGATION_EXPRESSION__END_MUST_BE_NAVIGABLE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignatureCallExpression(SignatureCallExpression signatureCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(signatureCallExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignatureCallExpression_ParametersTypesMustMatchSignatureParametersTypes(signatureCallExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateSignatureCallExpression_CallTypeMustMatchSignatureOutput(signatureCallExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ParametersTypesMustMatchSignatureParametersTypes constraint of '<em>Signature Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SIGNATURE_CALL_EXPRESSION__PARAMETERS_TYPES_MUST_MATCH_SIGNATURE_PARAMETERS_TYPES__EEXPRESSION = "let numberOfMandatoryParameters:Integer =\r\n" +
        "    self.getSignature().input->select(p|p.defaultValue->isEmpty())->size()\r\n" +
        "  in\r\n" +
        "  self.parameters->size() >= numberOfMandatoryParameters and\r\n" +
        "  self.parameters->size() <= self.getSignature().input->size() and\r\n" +
        "  self.parameters->forAll(parameter |\r\n" +
        "    parameter.getType().conformsTo(self.getSignature().input->at(self.parameters->indexOf(parameter)).getType()) )";

	/**
     * Validates the ParametersTypesMustMatchSignatureParametersTypes constraint of '<em>Signature Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignatureCallExpression_ParametersTypesMustMatchSignatureParametersTypes(SignatureCallExpression signatureCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.SIGNATURE_CALL_EXPRESSION,
                 signatureCallExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ParametersTypesMustMatchSignatureParametersTypes",
                 SIGNATURE_CALL_EXPRESSION__PARAMETERS_TYPES_MUST_MATCH_SIGNATURE_PARAMETERS_TYPES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the CallTypeMustMatchSignatureOutput constraint of '<em>Signature Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SIGNATURE_CALL_EXPRESSION__CALL_TYPE_MUST_MATCH_SIGNATURE_OUTPUT__EEXPRESSION = "if self.getSignature().output.oclIsUndefined() then\r\n" +
        "        self.getType().oclIsUndefined()\r\n" +
        "    else \r\n" +
        "        if self.getMultiplicityOfCallTarget().isMany() and self.getSignature().output.isMany() then\r\n" +
        "            let ntd:data::classes::NestedTypeDefinition = self.getType().oclAsType(data::classes::NestedTypeDefinition) in\r\n" +
        "                self.getType().oclIsKindOf(data::classes::NestedTypeDefinition) and \r\n" +
        "                ntd.unique = false and\r\n" +
        "                ntd.ordered = self.getMultiplicityOfCallTarget().ordered and\r\n" +
        "                ntd.lowerMultiplicity = self.getMultiplicityOfCallTarget().lowerMultiplicity and\r\n" +
        "                ntd.upperMultiplicity = self.getMultiplicityOfCallTarget().upperMultiplicity and\r\n" +
        "                self.getSignature().output.conformsTo(ntd.type)\r\n" +
        "        else\r\n" +
        "            let target:data::classes::Multiplicity = self.getMultiplicityOfCallTarget() in\r\n" +
        "            let output:data::classes::TypeDefinition = self.getSignature().output in \r\n" +
        "                ( output.isMany() implies self.getType().unique = output.unique ) and\r\n" +
        "                ( ( output.isMany() or target.isMany() ) implies ( self.getType().ordered = (output.ordered or target.ordered) ) ) and\r\n" +
        "                ( self.getType().lowerMultiplicity = (output.lowerMultiplicity * target.lowerMultiplicity)) and\r\n" +
        "                ( self.getType().upperMultiplicity = (if output.isMany() or target.isMany() then \r\n" +
        "                                                        -1 \r\n" +
        "                                                    else \r\n" +
        "                                                        output.upperMultiplicity * target.upperMultiplicity \r\n" +
        "                                                    endif)) and\r\n" +
        "                self.getType().conformsToIgnoringMultiplicity(output)\r\n" +
        "        endif\r\n" +
        "    endif";

	/**
     * Validates the CallTypeMustMatchSignatureOutput constraint of '<em>Signature Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSignatureCallExpression_CallTypeMustMatchSignatureOutput(SignatureCallExpression signatureCallExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.SIGNATURE_CALL_EXPRESSION,
                 signatureCallExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CallTypeMustMatchSignatureOutput",
                 SIGNATURE_CALL_EXPRESSION__CALL_TYPE_MUST_MATCH_SIGNATURE_OUTPUT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCount(ObjectCount objectCount, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(objectCount, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCount_TypeIsNumber(objectCount, diagnostics, context);
        if (result || diagnostics != null) result &= validateObjectCount_MultiplicityIsOne(objectCount, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the TypeIsNumber constraint of '<em>Object Count</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_COUNT__TYPE_IS_NUMBER__EEXPRESSION = "self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = 'Number'";

	/**
     * Validates the TypeIsNumber constraint of '<em>Object Count</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCount_TypeIsNumber(ObjectCount objectCount, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_COUNT,
                 objectCount,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "TypeIsNumber",
                 OBJECT_COUNT__TYPE_IS_NUMBER__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MultiplicityIsOne constraint of '<em>Object Count</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OBJECT_COUNT__MULTIPLICITY_IS_ONE__EEXPRESSION = "self.getType().upperMultiplicity = 1 and\r\n" +
        "  self.getType().lowerMultiplicity = 1";

	/**
     * Validates the MultiplicityIsOne constraint of '<em>Object Count</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateObjectCount_MultiplicityIsOne(ObjectCount objectCount, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.OBJECT_COUNT,
                 objectCount,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MultiplicityIsOne",
                 OBJECT_COUNT__MULTIPLICITY_IS_ONE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateReplace(Replace replace, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(replace, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validateReplace_SourceObjectIsOfValueType(replace, diagnostics, context);
        if (result || diagnostics != null) result &= validateReplace_WithTypeConformsToLastStepsType(replace, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the SourceObjectIsOfValueType constraint of '<em>Replace</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String REPLACE__SOURCE_OBJECT_IS_OF_VALUE_TYPE__EEXPRESSION = "self.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.object.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType";

	/**
     * Validates the SourceObjectIsOfValueType constraint of '<em>Replace</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateReplace_SourceObjectIsOfValueType(Replace replace, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.REPLACE,
                 replace,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SourceObjectIsOfValueType",
                 REPLACE__SOURCE_OBJECT_IS_OF_VALUE_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the WithTypeConformsToLastStepsType constraint of '<em>Replace</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String REPLACE__WITH_TYPE_CONFORMS_TO_LAST_STEPS_TYPE__EEXPRESSION = "self.with.getType().conformsTo(self.steps->at(self.steps->size()).to.type)";

	/**
     * Validates the WithTypeConformsToLastStepsType constraint of '<em>Replace</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateReplace_WithTypeConformsToLastStepsType(Replace replace, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.REPLACE,
                 replace,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "WithTypeConformsToLastStepsType",
                 REPLACE__WITH_TYPE_CONFORMS_TO_LAST_STEPS_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNavigationStep(NavigationStep navigationStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(navigationStep, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validateNavigationStep_FromEndAttachesToOutputOfPreviousStep(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validateNavigationStep_FilterFunctionExpressionHasFunctionType(navigationStep, diagnostics, context);
        if (result || diagnostics != null) result &= validateNavigationStep_FromEndMustBeEqualityRelevant(navigationStep, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the FromEndAttachesToOutputOfPreviousStep constraint of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String NAVIGATION_STEP__FROM_END_ATTACHES_TO_OUTPUT_OF_PREVIOUS_STEP__EEXPRESSION = "let i:Integer = self.replace.steps->indexOf(self) in\r\n" +
        "  let t:data::classes::ClassTypeDefinition = if i=1 then\r\n" +
        "      self.replace.object.getType().oclAsType(data::classes::ClassTypeDefinition)\r\n" +
        "    else\r\n" +
        "      self.replace.steps->at(-1 + i).to.type\r\n" +
        "    endif\r\n" +
        "  in\r\n" +
        "\r\n" +
        "  self.to.otherEnd().type.clazz.conformsTo(t.clazz)";

	/**
     * Validates the FromEndAttachesToOutputOfPreviousStep constraint of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNavigationStep_FromEndAttachesToOutputOfPreviousStep(NavigationStep navigationStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.NAVIGATION_STEP,
                 navigationStep,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FromEndAttachesToOutputOfPreviousStep",
                 NAVIGATION_STEP__FROM_END_ATTACHES_TO_OUTPUT_OF_PREVIOUS_STEP__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the FilterFunctionExpressionHasFunctionType constraint of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String NAVIGATION_STEP__FILTER_FUNCTION_EXPRESSION_HAS_FUNCTION_TYPE__EEXPRESSION = "self.filterFunction->notEmpty() implies self.filterFunction.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)";

	/**
     * Validates the FilterFunctionExpressionHasFunctionType constraint of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNavigationStep_FilterFunctionExpressionHasFunctionType(NavigationStep navigationStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.NAVIGATION_STEP,
                 navigationStep,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FilterFunctionExpressionHasFunctionType",
                 NAVIGATION_STEP__FILTER_FUNCTION_EXPRESSION_HAS_FUNCTION_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the FromEndMustBeEqualityRelevant constraint of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String NAVIGATION_STEP__FROM_END_MUST_BE_EQUALITY_RELEVANT__EEXPRESSION = "to.otherEnd().contributesToEquality";

	/**
     * Validates the FromEndMustBeEqualityRelevant constraint of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNavigationStep_FromEndMustBeEqualityRelevant(NavigationStep navigationStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.NAVIGATION_STEP,
                 navigationStep,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FromEndMustBeEqualityRelevant",
                 NAVIGATION_STEP__FROM_END_MUST_BE_EQUALITY_RELEVANT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateHead(Head head, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(head, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(head, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(head, diagnostics, context);
        if (result || diagnostics != null) result &= validateHead_IsOrdered(head, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the IsOrdered constraint of '<em>Head</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String HEAD__IS_ORDERED__EEXPRESSION = "self.object.getType().ordered";

	/**
     * Validates the IsOrdered constraint of '<em>Head</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateHead_IsOrdered(Head head, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.HEAD,
                 head,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "IsOrdered",
                 HEAD__IS_ORDERED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTail(Tail tail, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(tail, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tail, diagnostics, context);
        if (result || diagnostics != null) result &= validateTail_IsOrdered(tail, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the IsOrdered constraint of '<em>Tail</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TAIL__IS_ORDERED__EEXPRESSION = "self.object.getType().ordered";

	/**
     * Validates the IsOrdered constraint of '<em>Tail</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTail_IsOrdered(Tail tail, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.TAIL,
                 tail,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "IsOrdered",
                 TAIL__IS_ORDERED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAsList(AsList asList, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(asList, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConditional(Conditional conditional, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(conditional, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conditional, diagnostics, context);
        if (result || diagnostics != null) result &= validateConditional_ConditionMustBeBoolean(conditional, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ConditionMustBeBoolean constraint of '<em>Conditional</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONDITIONAL__CONDITION_MUST_BE_BOOLEAN__EEXPRESSION = "self.condition.getType().upperMultiplicity = 1 and\r\n" +
        "  self.condition.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.condition.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = 'Boolean'";

	/**
     * Validates the ConditionMustBeBoolean constraint of '<em>Conditional</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConditional_ConditionMustBeBoolean(Conditional conditional, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.CONDITIONAL,
                 conditional,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ConditionMustBeBoolean",
                 CONDITIONAL__CONDITION_MUST_BE_BOOLEAN__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTernary(Ternary ternary, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(ternary, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validateConditional_ConditionMustBeBoolean(ternary, diagnostics, context);
        if (result || diagnostics != null) result &= validateTernary_TrueAndFalseExprsConformToResultType(ternary, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the TrueAndFalseExprsConformToResultType constraint of '<em>Ternary</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TERNARY__TRUE_AND_FALSE_EXPRS_CONFORM_TO_RESULT_TYPE__EEXPRESSION = "self.trueExpr.getType().conformsTo(self.getType()) or\r\n" +
        "  self.falseExpr.getType().conformsTo(self.getType())";

	/**
     * Validates the TrueAndFalseExprsConformToResultType constraint of '<em>Ternary</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTernary_TrueAndFalseExprsConformToResultType(Ternary ternary, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.TERNARY,
                 ternary,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "TrueAndFalseExprsConformToResultType",
                 TERNARY__TRUE_AND_FALSE_EXPRS_CONFORM_TO_RESULT_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateContentEquals(ContentEquals contentEquals, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(contentEquals, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validateEquals_ConformaceOneWayOrAnother(contentEquals, diagnostics, context);
        if (result || diagnostics != null) result &= validateContentEquals_ContentEqualsOnlyForEntities(contentEquals, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ContentEqualsOnlyForEntities constraint of '<em>Content Equals</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONTENT_EQUALS__CONTENT_EQUALS_ONLY_FOR_ENTITIES__EEXPRESSION = "self.left.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.right.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  not self.left.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType and\r\n" +
        "  not self.right.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType";

	/**
     * Validates the ContentEqualsOnlyForEntities constraint of '<em>Content Equals</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateContentEquals_ContentEqualsOnlyForEntities(ContentEquals contentEquals, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.CONTENT_EQUALS,
                 contentEquals,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ContentEqualsOnlyForEntities",
                 CONTENT_EQUALS__CONTENT_EQUALS_ONLY_FOR_ENTITIES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExpressionWithArgument(ExpressionWithArgument expressionWithArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(expressionWithArgument, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConditionalExpression(ConditionalExpression conditionalExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(conditionalExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conditionalExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateConditional_ConditionMustBeBoolean(conditionalExpression, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMap(dataaccess.expressions.Map map, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(map, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(map, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(map, diagnostics, context);
        if (result || diagnostics != null) result &= validateMap_ObjectTypeMustConformToFunctionArgument(map, diagnostics, context);
        if (result || diagnostics != null) result &= validateMap_ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput(map, diagnostics, context);
        if (result || diagnostics != null) result &= validateMap_MapFunctionMustBeSideEffectFree(map, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ObjectTypeMustConformToFunctionArgument constraint of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String MAP__OBJECT_TYPE_MUST_CONFORM_TO_FUNCTION_ARGUMENT__EEXPRESSION = "let fstd:data::classes::TypeDefinition = self.argument.getType() in\r\n" +
        "  let sig:data::classes::Signature = fstd.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature in\r\n" +
        "  let t:data::classes::TypeDefinition = self.object.getType() in\r\n" +
        "  let argT:data::classes::TypeDefinition = sig.input->at(1).getType() in\r\n" +
        "  -- if multiplicities match including multiplicities, that's ok\r\n" +
        "  t.conformsTo(argT) or\r\n" +
        "  -- otherwise, pick single multiplicity from object and try again\r\n" +
        "  t.conformsToIgnoringMultiplicity(argT) or\r\n" +
        "  (t.oclIsKindOf(data::classes::NestedTypeDefinition) and t.oclAsType(data::classes::NestedTypeDefinition).type.conformsTo(argT))";

	/**
     * Validates the ObjectTypeMustConformToFunctionArgument constraint of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMap_ObjectTypeMustConformToFunctionArgument(dataaccess.expressions.Map map, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.MAP,
                 map,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ObjectTypeMustConformToFunctionArgument",
                 MAP__OBJECT_TYPE_MUST_CONFORM_TO_FUNCTION_ARGUMENT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput constraint of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String MAP__ARGUMENT_MUST_BE_SINGLE_ARGUMENT_FUNCTION_WITH_NON_VOID_OUTPUT__EEXPRESSION = "let fstd:data::classes::TypeDefinition = self.argument.getType() in\r\n" +
        "  fstd.oclIsKindOf(data::classes::FunctionSignatureTypeDefinition) and\r\n" +
        "  (let sig:data::classes::Signature = fstd.oclAsType(data::classes::FunctionSignatureTypeDefinition).signature in\r\n" +
        "  (sig.output->notEmpty() and\r\n" +
        "  sig.input->size() = 1))";

	/**
     * Validates the ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput constraint of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMap_ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput(dataaccess.expressions.Map map, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.MAP,
                 map,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput",
                 MAP__ARGUMENT_MUST_BE_SINGLE_ARGUMENT_FUNCTION_WITH_NON_VOID_OUTPUT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MapFunctionMustBeSideEffectFree constraint of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String MAP__MAP_FUNCTION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "self.argument.getType().oclAsType(data::classes::FunctionSignatureTypeDefinition).signature.sideEffectFree";

	/**
     * Validates the MapFunctionMustBeSideEffectFree constraint of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateMap_MapFunctionMustBeSideEffectFree(dataaccess.expressions.Map map, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.MAP,
                 map,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MapFunctionMustBeSideEffectFree",
                 MAP__MAP_FUNCTION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
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

} //ExpressionsValidator
