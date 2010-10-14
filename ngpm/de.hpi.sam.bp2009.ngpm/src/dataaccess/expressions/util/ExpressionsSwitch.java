/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.util;

import data.classes.InScope;
import data.classes.TypedElement;

import dataaccess.expressions.*;

import java.util.List;

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
 * @see dataaccess.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ExpressionsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsSwitch() {
        if (modelPackage == null) {
            modelPackage = ExpressionsPackage.eINSTANCE;
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
            case ExpressionsPackage.EXPRESSION: {
                Expression expression = (Expression)theEObject;
                T result = caseExpression(expression);
                if (result == null) result = caseTypedElement(expression);
                if (result == null) result = caseInScope(expression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.VARIABLE_EXPRESSION: {
                VariableExpression variableExpression = (VariableExpression)theEObject;
                T result = caseVariableExpression(variableExpression);
                if (result == null) result = caseExpression(variableExpression);
                if (result == null) result = caseTypedElement(variableExpression);
                if (result == null) result = caseInScope(variableExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.METHOD_CALL_EXPRESSION: {
                MethodCallExpression methodCallExpression = (MethodCallExpression)theEObject;
                T result = caseMethodCallExpression(methodCallExpression);
                if (result == null) result = caseObjectBasedExpression(methodCallExpression);
                if (result == null) result = caseSignatureCallExpression(methodCallExpression);
                if (result == null) result = caseExpression(methodCallExpression);
                if (result == null) result = caseTypedElement(methodCallExpression);
                if (result == null) result = caseInScope(methodCallExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.OBJECT_BASED_EXPRESSION: {
                ObjectBasedExpression objectBasedExpression = (ObjectBasedExpression)theEObject;
                T result = caseObjectBasedExpression(objectBasedExpression);
                if (result == null) result = caseExpression(objectBasedExpression);
                if (result == null) result = caseTypedElement(objectBasedExpression);
                if (result == null) result = caseInScope(objectBasedExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION: {
                ObjectCreationExpression objectCreationExpression = (ObjectCreationExpression)theEObject;
                T result = caseObjectCreationExpression(objectCreationExpression);
                if (result == null) result = caseExpression(objectCreationExpression);
                if (result == null) result = caseTypedElement(objectCreationExpression);
                if (result == null) result = caseInScope(objectCreationExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION: {
                FunctionCallExpression functionCallExpression = (FunctionCallExpression)theEObject;
                T result = caseFunctionCallExpression(functionCallExpression);
                if (result == null) result = caseSignatureCallExpression(functionCallExpression);
                if (result == null) result = caseExpression(functionCallExpression);
                if (result == null) result = caseTypedElement(functionCallExpression);
                if (result == null) result = caseInScope(functionCallExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.WITH_ARGUMENT: {
                WithArgument withArgument = (WithArgument)theEObject;
                T result = caseWithArgument(withArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.THIS: {
                This this_ = (This)theEObject;
                T result = caseThis(this_);
                if (result == null) result = caseExpression(this_);
                if (result == null) result = caseTypedElement(this_);
                if (result == null) result = caseInScope(this_);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.EQUALS: {
                Equals equals = (Equals)theEObject;
                T result = caseEquals(equals);
                if (result == null) result = caseExpression(equals);
                if (result == null) result = caseTypedElement(equals);
                if (result == null) result = caseInScope(equals);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION: {
                AssociationEndNavigationExpression associationEndNavigationExpression = (AssociationEndNavigationExpression)theEObject;
                T result = caseAssociationEndNavigationExpression(associationEndNavigationExpression);
                if (result == null) result = caseObjectBasedExpression(associationEndNavigationExpression);
                if (result == null) result = caseExpression(associationEndNavigationExpression);
                if (result == null) result = caseTypedElement(associationEndNavigationExpression);
                if (result == null) result = caseInScope(associationEndNavigationExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.SIGNATURE_CALL_EXPRESSION: {
                SignatureCallExpression signatureCallExpression = (SignatureCallExpression)theEObject;
                T result = caseSignatureCallExpression(signatureCallExpression);
                if (result == null) result = caseExpression(signatureCallExpression);
                if (result == null) result = caseTypedElement(signatureCallExpression);
                if (result == null) result = caseInScope(signatureCallExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.OBJECT_COUNT: {
                ObjectCount objectCount = (ObjectCount)theEObject;
                T result = caseObjectCount(objectCount);
                if (result == null) result = caseObjectBasedExpression(objectCount);
                if (result == null) result = caseExpression(objectCount);
                if (result == null) result = caseTypedElement(objectCount);
                if (result == null) result = caseInScope(objectCount);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.REPLACE: {
                Replace replace = (Replace)theEObject;
                T result = caseReplace(replace);
                if (result == null) result = caseObjectBasedExpression(replace);
                if (result == null) result = caseExpression(replace);
                if (result == null) result = caseTypedElement(replace);
                if (result == null) result = caseInScope(replace);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.NAVIGATION_STEP: {
                NavigationStep navigationStep = (NavigationStep)theEObject;
                T result = caseNavigationStep(navigationStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.HEAD: {
                Head head = (Head)theEObject;
                T result = caseHead(head);
                if (result == null) result = caseObjectBasedExpression(head);
                if (result == null) result = caseExpression(head);
                if (result == null) result = caseTypedElement(head);
                if (result == null) result = caseInScope(head);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.TAIL: {
                Tail tail = (Tail)theEObject;
                T result = caseTail(tail);
                if (result == null) result = caseObjectBasedExpression(tail);
                if (result == null) result = caseExpression(tail);
                if (result == null) result = caseTypedElement(tail);
                if (result == null) result = caseInScope(tail);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.AS_LIST: {
                AsList asList = (AsList)theEObject;
                T result = caseAsList(asList);
                if (result == null) result = caseObjectBasedExpression(asList);
                if (result == null) result = caseExpression(asList);
                if (result == null) result = caseTypedElement(asList);
                if (result == null) result = caseInScope(asList);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.CONDITIONAL: {
                Conditional conditional = (Conditional)theEObject;
                T result = caseConditional(conditional);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.TERNARY: {
                Ternary ternary = (Ternary)theEObject;
                T result = caseTernary(ternary);
                if (result == null) result = caseConditionalExpression(ternary);
                if (result == null) result = caseExpression(ternary);
                if (result == null) result = caseConditional(ternary);
                if (result == null) result = caseTypedElement(ternary);
                if (result == null) result = caseInScope(ternary);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.CONTENT_EQUALS: {
                ContentEquals contentEquals = (ContentEquals)theEObject;
                T result = caseContentEquals(contentEquals);
                if (result == null) result = caseEquals(contentEquals);
                if (result == null) result = caseExpression(contentEquals);
                if (result == null) result = caseTypedElement(contentEquals);
                if (result == null) result = caseInScope(contentEquals);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.EXPRESSION_WITH_ARGUMENT: {
                ExpressionWithArgument expressionWithArgument = (ExpressionWithArgument)theEObject;
                T result = caseExpressionWithArgument(expressionWithArgument);
                if (result == null) result = caseExpression(expressionWithArgument);
                if (result == null) result = caseWithArgument(expressionWithArgument);
                if (result == null) result = caseTypedElement(expressionWithArgument);
                if (result == null) result = caseInScope(expressionWithArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.CONDITIONAL_EXPRESSION: {
                ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
                T result = caseConditionalExpression(conditionalExpression);
                if (result == null) result = caseExpression(conditionalExpression);
                if (result == null) result = caseConditional(conditionalExpression);
                if (result == null) result = caseTypedElement(conditionalExpression);
                if (result == null) result = caseInScope(conditionalExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.MAP: {
                Map map = (Map)theEObject;
                T result = caseMap(map);
                if (result == null) result = caseExpressionWithArgument(map);
                if (result == null) result = caseObjectBasedExpression(map);
                if (result == null) result = caseExpression(map);
                if (result == null) result = caseWithArgument(map);
                if (result == null) result = caseTypedElement(map);
                if (result == null) result = caseInScope(map);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExpression(Expression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Variable Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseVariableExpression(VariableExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Method Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Method Call Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMethodCallExpression(MethodCallExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Object Based Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Object Based Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseObjectBasedExpression(ObjectBasedExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Object Creation Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Object Creation Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseObjectCreationExpression(ObjectCreationExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Function Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Function Call Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFunctionCallExpression(FunctionCallExpression object) {
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
     * Returns the result of interpreting the object as an instance of '<em>This</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>This</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseThis(This object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Equals</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Equals</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEquals(Equals object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Association End Navigation Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association End Navigation Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAssociationEndNavigationExpression(AssociationEndNavigationExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Signature Call Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature Call Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSignatureCallExpression(SignatureCallExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Object Count</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Object Count</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseObjectCount(ObjectCount object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Replace</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Replace</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseReplace(Replace object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Navigation Step</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Navigation Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNavigationStep(NavigationStep object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Head</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Head</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseHead(Head object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tail</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tail</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTail(Tail object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>As List</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>As List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAsList(AsList object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Ternary</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ternary</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTernary(Ternary object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Content Equals</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Content Equals</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseContentEquals(ContentEquals object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Expression With Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression With Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExpressionWithArgument(ExpressionWithArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConditionalExpression(ConditionalExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Map</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMap(Map object) {
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

} //ExpressionsSwitch
