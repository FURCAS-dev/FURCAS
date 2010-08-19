/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.literals.util;

import data.classes.InScope;
import data.classes.TypedElement;

import dataaccess.expressions.Expression;

import dataaccess.expressions.literals.*;

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
 * @see dataaccess.expressions.literals.LiteralsPackage
 * @generated
 */
public class LiteralsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static LiteralsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LiteralsSwitch() {
        if (modelPackage == null) {
            modelPackage = LiteralsPackage.eINSTANCE;
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
            case LiteralsPackage.LITERAL: {
                Literal literal = (Literal)theEObject;
                T result = caseLiteral(literal);
                if (result == null) result = caseExpression(literal);
                if (result == null) result = caseTypedElement(literal);
                if (result == null) result = caseInScope(literal);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.BINARY_LITERAL: {
                BinaryLiteral binaryLiteral = (BinaryLiteral)theEObject;
                T result = caseBinaryLiteral(binaryLiteral);
                if (result == null) result = caseLiteral(binaryLiteral);
                if (result == null) result = caseExpression(binaryLiteral);
                if (result == null) result = caseTypedElement(binaryLiteral);
                if (result == null) result = caseInScope(binaryLiteral);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.STRING_LITERAL: {
                StringLiteral stringLiteral = (StringLiteral)theEObject;
                T result = caseStringLiteral(stringLiteral);
                if (result == null) result = caseLiteral(stringLiteral);
                if (result == null) result = caseExpression(stringLiteral);
                if (result == null) result = caseTypedElement(stringLiteral);
                if (result == null) result = caseInScope(stringLiteral);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.NUMBER_LITERAL: {
                NumberLiteral numberLiteral = (NumberLiteral)theEObject;
                T result = caseNumberLiteral(numberLiteral);
                if (result == null) result = caseLiteral(numberLiteral);
                if (result == null) result = caseExpression(numberLiteral);
                if (result == null) result = caseTypedElement(numberLiteral);
                if (result == null) result = caseInScope(numberLiteral);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.TIME_POINT_LITERAL: {
                TimePointLiteral timePointLiteral = (TimePointLiteral)theEObject;
                T result = caseTimePointLiteral(timePointLiteral);
                if (result == null) result = caseLiteral(timePointLiteral);
                if (result == null) result = caseExpression(timePointLiteral);
                if (result == null) result = caseTypedElement(timePointLiteral);
                if (result == null) result = caseInScope(timePointLiteral);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.BOOLEAN_LITERAL: {
                BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
                T result = caseBooleanLiteral(booleanLiteral);
                if (result == null) result = caseLiteral(booleanLiteral);
                if (result == null) result = caseExpression(booleanLiteral);
                if (result == null) result = caseTypedElement(booleanLiteral);
                if (result == null) result = caseInScope(booleanLiteral);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.OBJECT_LITERAL: {
                ObjectLiteral objectLiteral = (ObjectLiteral)theEObject;
                T result = caseObjectLiteral(objectLiteral);
                if (result == null) result = caseExpression(objectLiteral);
                if (result == null) result = caseTypedElement(objectLiteral);
                if (result == null) result = caseInScope(objectLiteral);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case LiteralsPackage.VALUE_INIT: {
                ValueInit valueInit = (ValueInit)theEObject;
                T result = caseValueInit(valueInit);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLiteral(Literal object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Binary Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binary Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBinaryLiteral(BinaryLiteral object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStringLiteral(StringLiteral object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Number Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Number Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNumberLiteral(NumberLiteral object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Time Point Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Time Point Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTimePointLiteral(TimePointLiteral object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBooleanLiteral(BooleanLiteral object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Object Literal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Object Literal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseObjectLiteral(ObjectLiteral object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Value Init</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Init</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseValueInit(ValueInit object) {
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

} //LiteralsSwitch
