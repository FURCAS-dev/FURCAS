/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsSwitch.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.actions.util;

import behavioral.actions.*;

import data.classes.FunctionSignatureImplementation;
import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SignatureImplementation;
import data.classes.TypedElement;

import dataaccess.expressions.Conditional;
import dataaccess.expressions.WithArgument;

import java.util.List;

import modelmanagement.NamedElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see behavioral.actions.ActionsPackage
 * @generated
 */
public class ActionsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ActionsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsSwitch() {
        if (modelPackage == null) {
            modelPackage = ActionsPackage.eINSTANCE;
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ActionsPackage.ASSIGNMENT: {
                Assignment assignment = (Assignment)theEObject;
                T result = caseAssignment(assignment);
                if (result == null) result = caseStatementWithArgument(assignment);
                if (result == null) result = caseStatement(assignment);
                if (result == null) result = caseWithArgument(assignment);
                if (result == null) result = caseInScope(assignment);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.STATEMENT: {
                Statement statement = (Statement)theEObject;
                T result = caseStatement(statement);
                if (result == null) result = caseInScope(statement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.BLOCK: {
                Block block = (Block)theEObject;
                T result = caseBlock(block);
                if (result == null) result = caseFunctionSignatureImplementation(block);
                if (result == null) result = caseInScope(block);
                if (result == null) result = caseSignatureImplementation(block);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.IF_ELSE: {
                IfElse ifElse = (IfElse)theEObject;
                T result = caseIfElse(ifElse);
                if (result == null) result = caseConditionalStatement(ifElse);
                if (result == null) result = caseStatementWithNestedBlocks(ifElse);
                if (result == null) result = caseConditional(ifElse);
                if (result == null) result = caseStatement(ifElse);
                if (result == null) result = caseInScope(ifElse);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.WHILE_LOOP: {
                WhileLoop whileLoop = (WhileLoop)theEObject;
                T result = caseWhileLoop(whileLoop);
                if (result == null) result = caseConditionalStatement(whileLoop);
                if (result == null) result = caseSingleBlockStatement(whileLoop);
                if (result == null) result = caseConditional(whileLoop);
                if (result == null) result = caseStatementWithNestedBlocks(whileLoop);
                if (result == null) result = caseStatement(whileLoop);
                if (result == null) result = caseInScope(whileLoop);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.FOREACH: {
                Foreach foreach = (Foreach)theEObject;
                T result = caseForeach(foreach);
                if (result == null) result = caseSingleBlockStatement(foreach);
                if (result == null) result = caseStatementWithNestedBlocks(foreach);
                if (result == null) result = caseStatement(foreach);
                if (result == null) result = caseInScope(foreach);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.RETURN: {
                Return return_ = (Return)theEObject;
                T result = caseReturn(return_);
                if (result == null) result = caseStatementWithArgument(return_);
                if (result == null) result = caseStatement(return_);
                if (result == null) result = caseWithArgument(return_);
                if (result == null) result = caseInScope(return_);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.ADD_LINK: {
                AddLink addLink = (AddLink)theEObject;
                T result = caseAddLink(addLink);
                if (result == null) result = caseLinkManipulationStatement(addLink);
                if (result == null) result = caseStatement(addLink);
                if (result == null) result = caseInScope(addLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.REMOVE_LINK: {
                RemoveLink removeLink = (RemoveLink)theEObject;
                T result = caseRemoveLink(removeLink);
                if (result == null) result = caseLinkManipulationStatement(removeLink);
                if (result == null) result = caseStatement(removeLink);
                if (result == null) result = caseInScope(removeLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.LINK_MANIPULATION_STATEMENT: {
                LinkManipulationStatement linkManipulationStatement = (LinkManipulationStatement)theEObject;
                T result = caseLinkManipulationStatement(linkManipulationStatement);
                if (result == null) result = caseStatement(linkManipulationStatement);
                if (result == null) result = caseInScope(linkManipulationStatement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.EXPRESSION_STATEMENT: {
                ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
                T result = caseExpressionStatement(expressionStatement);
                if (result == null) result = caseStatement(expressionStatement);
                if (result == null) result = caseInScope(expressionStatement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.SORT: {
                Sort sort = (Sort)theEObject;
                T result = caseSort(sort);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.QUERY_INVOCATION: {
                QueryInvocation queryInvocation = (QueryInvocation)theEObject;
                T result = caseQueryInvocation(queryInvocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.CONSTANT: {
                Constant constant = (Constant)theEObject;
                T result = caseConstant(constant);
                if (result == null) result = caseNamedValueWithOptionalInitExpression(constant);
                if (result == null) result = caseNamedValue(constant);
                if (result == null) result = caseNamedElement(constant);
                if (result == null) result = caseTypedElement(constant);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.VARIABLE: {
                Variable variable = (Variable)theEObject;
                T result = caseVariable(variable);
                if (result == null) result = caseNamedValueWithOptionalInitExpression(variable);
                if (result == null) result = caseNamedValue(variable);
                if (result == null) result = caseNamedElement(variable);
                if (result == null) result = caseTypedElement(variable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.ITERATOR: {
                Iterator iterator = (Iterator)theEObject;
                T result = caseIterator(iterator);
                if (result == null) result = caseNamedValue(iterator);
                if (result == null) result = caseNamedElement(iterator);
                if (result == null) result = caseTypedElement(iterator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.NAMED_VALUE_DECLARATION: {
                NamedValueDeclaration namedValueDeclaration = (NamedValueDeclaration)theEObject;
                T result = caseNamedValueDeclaration(namedValueDeclaration);
                if (result == null) result = caseStatement(namedValueDeclaration);
                if (result == null) result = caseInScope(namedValueDeclaration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS: {
                StatementWithNestedBlocks statementWithNestedBlocks = (StatementWithNestedBlocks)theEObject;
                T result = caseStatementWithNestedBlocks(statementWithNestedBlocks);
                if (result == null) result = caseStatement(statementWithNestedBlocks);
                if (result == null) result = caseInScope(statementWithNestedBlocks);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.SINGLE_BLOCK_STATEMENT: {
                SingleBlockStatement singleBlockStatement = (SingleBlockStatement)theEObject;
                T result = caseSingleBlockStatement(singleBlockStatement);
                if (result == null) result = caseStatementWithNestedBlocks(singleBlockStatement);
                if (result == null) result = caseStatement(singleBlockStatement);
                if (result == null) result = caseInScope(singleBlockStatement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.STATEMENT_WITH_ARGUMENT: {
                StatementWithArgument statementWithArgument = (StatementWithArgument)theEObject;
                T result = caseStatementWithArgument(statementWithArgument);
                if (result == null) result = caseStatement(statementWithArgument);
                if (result == null) result = caseWithArgument(statementWithArgument);
                if (result == null) result = caseInScope(statementWithArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION: {
                NamedValueWithOptionalInitExpression namedValueWithOptionalInitExpression = (NamedValueWithOptionalInitExpression)theEObject;
                T result = caseNamedValueWithOptionalInitExpression(namedValueWithOptionalInitExpression);
                if (result == null) result = caseNamedValue(namedValueWithOptionalInitExpression);
                if (result == null) result = caseNamedElement(namedValueWithOptionalInitExpression);
                if (result == null) result = caseTypedElement(namedValueWithOptionalInitExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.CONDITIONAL_STATEMENT: {
                ConditionalStatement conditionalStatement = (ConditionalStatement)theEObject;
                T result = caseConditionalStatement(conditionalStatement);
                if (result == null) result = caseConditional(conditionalStatement);
                if (result == null) result = caseStatement(conditionalStatement);
                if (result == null) result = caseInScope(conditionalStatement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAssignment(Assignment object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatement(Statement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBlock(Block object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>If Else</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>If Else</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIfElse(IfElse object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>While Loop</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>While Loop</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseWhileLoop(WhileLoop object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Foreach</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Foreach</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseForeach(Foreach object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Return</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseReturn(Return object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Add Link</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Add Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAddLink(AddLink object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Remove Link</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Remove Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRemoveLink(RemoveLink object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Link Manipulation Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Manipulation Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLinkManipulationStatement(LinkManipulationStatement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExpressionStatement(ExpressionStatement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sort</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sort</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSort(Sort object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Query Invocation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Invocation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQueryInvocation(QueryInvocation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConstant(Constant object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseVariable(Variable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Iterator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIterator(Iterator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Value Declaration</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Value Declaration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedValueDeclaration(NamedValueDeclaration object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Statement With Nested Blocks</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement With Nested Blocks</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatementWithNestedBlocks(StatementWithNestedBlocks object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Single Block Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Single Block Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSingleBlockStatement(SingleBlockStatement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Statement With Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement With Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatementWithArgument(StatementWithArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Value With Optional Init Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Value With Optional Init Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedValueWithOptionalInitExpression(NamedValueWithOptionalInitExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Conditional Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Conditional Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConditionalStatement(ConditionalStatement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>In Scope</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>In Scope</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInScope(InScope object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>With Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>With Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseWithArgument(WithArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSignatureImplementation(SignatureImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Function Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Function Signature Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFunctionSignatureImplementation(FunctionSignatureImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Conditional</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Conditional</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConditional(Conditional object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedElement(NamedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypedElement(TypedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedValue(NamedValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public T defaultCase(EObject object) {
        return null;
    }

} //ActionsSwitch
