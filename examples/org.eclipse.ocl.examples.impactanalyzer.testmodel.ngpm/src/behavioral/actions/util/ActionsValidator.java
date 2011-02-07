/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsValidator.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.actions.util;

import behavioral.actions.*;

import dataaccess.expressions.util.ExpressionsValidator;

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
 * @see behavioral.actions.ActionsPackage
 * @generated
 */
public class ActionsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final ActionsValidator INSTANCE = new ActionsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "behavioral.actions";

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
	protected ExpressionsValidator expressionsValidator;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsValidator() {
        super();
        expressionsValidator = ExpressionsValidator.INSTANCE;
    }

	/**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EPackage getEPackage() {
      return ActionsPackage.eINSTANCE;
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
            case ActionsPackage.ASSIGNMENT:
                return validateAssignment((Assignment)value, diagnostics, context);
            case ActionsPackage.STATEMENT:
                return validateStatement((Statement)value, diagnostics, context);
            case ActionsPackage.BLOCK:
                return validateBlock((Block)value, diagnostics, context);
            case ActionsPackage.IF_ELSE:
                return validateIfElse((IfElse)value, diagnostics, context);
            case ActionsPackage.WHILE_LOOP:
                return validateWhileLoop((WhileLoop)value, diagnostics, context);
            case ActionsPackage.FOREACH:
                return validateForeach((Foreach)value, diagnostics, context);
            case ActionsPackage.RETURN:
                return validateReturn((Return)value, diagnostics, context);
            case ActionsPackage.ADD_LINK:
                return validateAddLink((AddLink)value, diagnostics, context);
            case ActionsPackage.REMOVE_LINK:
                return validateRemoveLink((RemoveLink)value, diagnostics, context);
            case ActionsPackage.LINK_MANIPULATION_STATEMENT:
                return validateLinkManipulationStatement((LinkManipulationStatement)value, diagnostics, context);
            case ActionsPackage.EXPRESSION_STATEMENT:
                return validateExpressionStatement((ExpressionStatement)value, diagnostics, context);
            case ActionsPackage.SORT:
                return validateSort((Sort)value, diagnostics, context);
            case ActionsPackage.QUERY_INVOCATION:
                return validateQueryInvocation((QueryInvocation)value, diagnostics, context);
            case ActionsPackage.CONSTANT:
                return validateConstant((Constant)value, diagnostics, context);
            case ActionsPackage.VARIABLE:
                return validateVariable((Variable)value, diagnostics, context);
            case ActionsPackage.ITERATOR:
                return validateIterator((Iterator)value, diagnostics, context);
            case ActionsPackage.NAMED_VALUE_DECLARATION:
                return validateNamedValueDeclaration((NamedValueDeclaration)value, diagnostics, context);
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS:
                return validateStatementWithNestedBlocks((StatementWithNestedBlocks)value, diagnostics, context);
            case ActionsPackage.SINGLE_BLOCK_STATEMENT:
                return validateSingleBlockStatement((SingleBlockStatement)value, diagnostics, context);
            case ActionsPackage.STATEMENT_WITH_ARGUMENT:
                return validateStatementWithArgument((StatementWithArgument)value, diagnostics, context);
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION:
                return validateNamedValueWithOptionalInitExpression((NamedValueWithOptionalInitExpression)value, diagnostics, context);
            case ActionsPackage.CONDITIONAL_STATEMENT:
                return validateConditionalStatement((ConditionalStatement)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssignment(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(assignment, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssignment_AssignmentCompatibility(assignment, diagnostics, context);
        if (result || diagnostics != null) result &= validateAssignment_MustHaveArgument(assignment, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the AssignmentCompatibility constraint of '<em>Assignment</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSIGNMENT__ASSIGNMENT_COMPATIBILITY__EEXPRESSION = "self.argument.getType().conformsTo(self.assignTo.getType())";

	/**
     * Validates the AssignmentCompatibility constraint of '<em>Assignment</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssignment_AssignmentCompatibility(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.ASSIGNMENT,
                 assignment,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "AssignmentCompatibility",
                 ASSIGNMENT__ASSIGNMENT_COMPATIBILITY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MustHaveArgument constraint of '<em>Assignment</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ASSIGNMENT__MUST_HAVE_ARGUMENT__EEXPRESSION = "self.argument->notEmpty()";

	/**
     * Validates the MustHaveArgument constraint of '<em>Assignment</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAssignment_MustHaveArgument(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.ASSIGNMENT,
                 assignment,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MustHaveArgument",
                 ASSIGNMENT__MUST_HAVE_ARGUMENT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStatement(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(statement, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBlock(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(block, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(block, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(block, diagnostics, context);
        if (result || diagnostics != null) result &= validateBlock_DoesNotOwnIterators(block, diagnostics, context);
        if (result || diagnostics != null) result &= validateBlock_IsSideEffectFreeIfImplementsSideEffectFreeSignature(block, diagnostics, context);
        if (result || diagnostics != null) result &= validateBlock_DistinctNamedValueNames(block, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the DoesNotOwnIterators constraint of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String BLOCK__DOES_NOT_OWN_ITERATORS__EEXPRESSION = "self.variables->select(i|i.oclIsKindOf(Iterator))->isEmpty()";

	/**
     * Validates the DoesNotOwnIterators constraint of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBlock_DoesNotOwnIterators(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.BLOCK,
                 block,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "DoesNotOwnIterators",
                 BLOCK__DOES_NOT_OWN_ITERATORS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the IsSideEffectFreeIfImplementsSideEffectFreeSignature constraint of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String BLOCK__IS_SIDE_EFFECT_FREE_IF_IMPLEMENTS_SIDE_EFFECT_FREE_SIGNATURE__EEXPRESSION = "self.implements_->notEmpty() implies\r\n" +
        "    (self.implements_.sideEffectFree implies self.isSideEffectFree())";

	/**
     * Validates the IsSideEffectFreeIfImplementsSideEffectFreeSignature constraint of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBlock_IsSideEffectFreeIfImplementsSideEffectFreeSignature(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.BLOCK,
                 block,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "IsSideEffectFreeIfImplementsSideEffectFreeSignature",
                 BLOCK__IS_SIDE_EFFECT_FREE_IF_IMPLEMENTS_SIDE_EFFECT_FREE_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the DistinctNamedValueNames constraint of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String BLOCK__DISTINCT_NAMED_VALUE_NAMES__EEXPRESSION = "self.variables->forAll( i, j | i <> j implies i.name <> j.name )";

	/**
     * Validates the DistinctNamedValueNames constraint of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateBlock_DistinctNamedValueNames(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.BLOCK,
                 block,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "DistinctNamedValueNames",
                 BLOCK__DISTINCT_NAMED_VALUE_NAMES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateIfElse(IfElse ifElse, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(ifElse, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ifElse, diagnostics, context);
        if (result || diagnostics != null) result &= expressionsValidator.validateConditional_ConditionMustBeBoolean(ifElse, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateWhileLoop(WhileLoop whileLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(whileLoop, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= expressionsValidator.validateConditional_ConditionMustBeBoolean(whileLoop, diagnostics, context);
        if (result || diagnostics != null) result &= validateSingleBlockStatement_OwnsExactlyOneBlock(whileLoop, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateForeach(Foreach foreach, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(foreach, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validateSingleBlockStatement_OwnsExactlyOneBlock(foreach, diagnostics, context);
        if (result || diagnostics != null) result &= validateForeach_VariableOwnedByRightBlock(foreach, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the VariableOwnedByRightBlock constraint of '<em>Foreach</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FOREACH__VARIABLE_OWNED_BY_RIGHT_BLOCK__EEXPRESSION = "self.forVariable.owner = self.nestedBlocks->at(1)";

	/**
     * Validates the VariableOwnedByRightBlock constraint of '<em>Foreach</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateForeach_VariableOwnedByRightBlock(Foreach foreach, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.FOREACH,
                 foreach,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "VariableOwnedByRightBlock",
                 FOREACH__VARIABLE_OWNED_BY_RIGHT_BLOCK__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateReturn(Return return_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(return_, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validateReturn_ReturnMustBeLastInBlock(return_, diagnostics, context);
        if (result || diagnostics != null) result &= validateReturn_ReturnTypeMustMatch(return_, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ReturnMustBeLastInBlock constraint of '<em>Return</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String RETURN__RETURN_MUST_BE_LAST_IN_BLOCK__EEXPRESSION = "self = self.block.statements->last()";

	/**
     * Validates the ReturnMustBeLastInBlock constraint of '<em>Return</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateReturn_ReturnMustBeLastInBlock(Return return_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.RETURN,
                 return_,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ReturnMustBeLastInBlock",
                 RETURN__RETURN_MUST_BE_LAST_IN_BLOCK__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ReturnTypeMustMatch constraint of '<em>Return</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String RETURN__RETURN_TYPE_MUST_MATCH__EEXPRESSION = "self.argument.getType().conformsTo(self.getOutermostBlock().getImplementedSignature().output)";

	/**
     * Validates the ReturnTypeMustMatch constraint of '<em>Return</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateReturn_ReturnTypeMustMatch(Return return_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.RETURN,
                 return_,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ReturnTypeMustMatch",
                 RETURN__RETURN_TYPE_MUST_MATCH__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAddLink(AddLink addLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(addLink, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_ObjectsMustConformToEndTypes(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_BlockMustNotImplementSideEffectFreeSignature(addLink, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_NoValueMustBeModified(addLink, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateRemoveLink(RemoveLink removeLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(removeLink, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_ObjectsMustConformToEndTypes(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_BlockMustNotImplementSideEffectFreeSignature(removeLink, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_NoValueMustBeModified(removeLink, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkManipulationStatement(LinkManipulationStatement linkManipulationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(linkManipulationStatement, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_ObjectsMustConformToEndTypes(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_BlockMustNotImplementSideEffectFreeSignature(linkManipulationStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validateLinkManipulationStatement_NoValueMustBeModified(linkManipulationStatement, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ObjectsMustConformToEndTypes constraint of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_MANIPULATION_STATEMENT__OBJECTS_MUST_CONFORM_TO_END_TYPES__EEXPRESSION = "Sequence{1..self.objects->size()}->forAll(i:Integer |\r\n" +
        "    objects->at(i).getType().conformsTo(association.ends->at(i).type))";

	/**
     * Validates the ObjectsMustConformToEndTypes constraint of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkManipulationStatement_ObjectsMustConformToEndTypes(LinkManipulationStatement linkManipulationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.LINK_MANIPULATION_STATEMENT,
                 linkManipulationStatement,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ObjectsMustConformToEndTypes",
                 LINK_MANIPULATION_STATEMENT__OBJECTS_MUST_CONFORM_TO_END_TYPES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the BlockMustNotImplementSideEffectFreeSignature constraint of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_MANIPULATION_STATEMENT__BLOCK_MUST_NOT_IMPLEMENT_SIDE_EFFECT_FREE_SIGNATURE__EEXPRESSION = "self.block.getImplementedSignature()->notEmpty() implies\r\n" +
        "  not self.block.getImplementedSignature().sideEffectFree";

	/**
     * Validates the BlockMustNotImplementSideEffectFreeSignature constraint of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkManipulationStatement_BlockMustNotImplementSideEffectFreeSignature(LinkManipulationStatement linkManipulationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.LINK_MANIPULATION_STATEMENT,
                 linkManipulationStatement,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "BlockMustNotImplementSideEffectFreeSignature",
                 LINK_MANIPULATION_STATEMENT__BLOCK_MUST_NOT_IMPLEMENT_SIDE_EFFECT_FREE_SIGNATURE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the NoValueMustBeModified constraint of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String LINK_MANIPULATION_STATEMENT__NO_VALUE_MUST_BE_MODIFIED__EEXPRESSION = "self.association.ends->forAll(ae:data::classes::AssociationEnd |\r\n" +
        "    ae.type.clazz.valueType implies not ae.contributesToEquality)";

	/**
     * Validates the NoValueMustBeModified constraint of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateLinkManipulationStatement_NoValueMustBeModified(LinkManipulationStatement linkManipulationStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.LINK_MANIPULATION_STATEMENT,
                 linkManipulationStatement,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "NoValueMustBeModified",
                 LINK_MANIPULATION_STATEMENT__NO_VALUE_MUST_BE_MODIFIED__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateExpressionStatement(ExpressionStatement expressionStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(expressionStatement, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSort(Sort sort, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(sort, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateQueryInvocation(QueryInvocation queryInvocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(queryInvocation, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConstant(Constant constant, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(constant, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validateNamedValueWithOptionalInitExpression_AssignmentCompatibility(constant, diagnostics, context);
        if (result || diagnostics != null) result &= validateConstant_InitExpressionTypeMustMatchVariableType(constant, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the InitExpressionTypeMustMatchVariableType constraint of '<em>Constant</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CONSTANT__INIT_EXPRESSION_TYPE_MUST_MATCH_VARIABLE_TYPE__EEXPRESSION = "self.initExpression->notEmpty() implies self.initExpression.getType().conformsTo(self.getType())";

	/**
     * Validates the InitExpressionTypeMustMatchVariableType constraint of '<em>Constant</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConstant_InitExpressionTypeMustMatchVariableType(Constant constant, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.CONSTANT,
                 constant,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "InitExpressionTypeMustMatchVariableType",
                 CONSTANT__INIT_EXPRESSION_TYPE_MUST_MATCH_VARIABLE_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateVariable(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(variable, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validateNamedValueWithOptionalInitExpression_AssignmentCompatibility(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validateVariable_InitExpressionTypeMustMatchVariableType(variable, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the InitExpressionTypeMustMatchVariableType constraint of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String VARIABLE__INIT_EXPRESSION_TYPE_MUST_MATCH_VARIABLE_TYPE__EEXPRESSION = "self.initExpression->notEmpty() implies self.initExpression.getType().conformsTo(self.getType())";

	/**
     * Validates the InitExpressionTypeMustMatchVariableType constraint of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateVariable_InitExpressionTypeMustMatchVariableType(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.VARIABLE,
                 variable,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "InitExpressionTypeMustMatchVariableType",
                 VARIABLE__INIT_EXPRESSION_TYPE_MUST_MATCH_VARIABLE_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateIterator(Iterator iterator, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(iterator, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNamedValueDeclaration(NamedValueDeclaration namedValueDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(namedValueDeclaration, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStatementWithNestedBlocks(StatementWithNestedBlocks statementWithNestedBlocks, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(statementWithNestedBlocks, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSingleBlockStatement(SingleBlockStatement singleBlockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(singleBlockStatement, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(singleBlockStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validateSingleBlockStatement_OwnsExactlyOneBlock(singleBlockStatement, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the OwnsExactlyOneBlock constraint of '<em>Single Block Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SINGLE_BLOCK_STATEMENT__OWNS_EXACTLY_ONE_BLOCK__EEXPRESSION = "self.nestedBlocks->size() = 1";

	/**
     * Validates the OwnsExactlyOneBlock constraint of '<em>Single Block Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSingleBlockStatement_OwnsExactlyOneBlock(SingleBlockStatement singleBlockStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.SINGLE_BLOCK_STATEMENT,
                 singleBlockStatement,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "OwnsExactlyOneBlock",
                 SINGLE_BLOCK_STATEMENT__OWNS_EXACTLY_ONE_BLOCK__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStatementWithArgument(StatementWithArgument statementWithArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(statementWithArgument, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNamedValueWithOptionalInitExpression(NamedValueWithOptionalInitExpression namedValueWithOptionalInitExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(namedValueWithOptionalInitExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedValueWithOptionalInitExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateNamedValueWithOptionalInitExpression_AssignmentCompatibility(namedValueWithOptionalInitExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the AssignmentCompatibility constraint of '<em>Named Value With Optional Init Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__ASSIGNMENT_COMPATIBILITY__EEXPRESSION = "self.initExpression->forAll(ie | ie.getType().conformsTo(self.getType()))";

	/**
     * Validates the AssignmentCompatibility constraint of '<em>Named Value With Optional Init Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNamedValueWithOptionalInitExpression_AssignmentCompatibility(NamedValueWithOptionalInitExpression namedValueWithOptionalInitExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION,
                 namedValueWithOptionalInitExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "AssignmentCompatibility",
                 NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__ASSIGNMENT_COMPATIBILITY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateConditionalStatement(ConditionalStatement conditionalStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(conditionalStatement, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conditionalStatement, diagnostics, context);
        if (result || diagnostics != null) result &= expressionsValidator.validateConditional_ConditionMustBeBoolean(conditionalStatement, diagnostics, context);
        return result;
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

} //ActionsValidator
