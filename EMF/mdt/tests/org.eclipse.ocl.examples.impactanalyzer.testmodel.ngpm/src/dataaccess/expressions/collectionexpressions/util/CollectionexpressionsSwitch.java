/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionexpressionsSwitch.java,v 1.1 2011/02/07 17:20:42 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions.util;

import data.classes.InScope;
import data.classes.TypedElement;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionWithArgument;
import dataaccess.expressions.WithArgument;

import dataaccess.expressions.collectionexpressions.*;

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
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage
 * @generated
 */
public class CollectionexpressionsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static CollectionexpressionsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionexpressionsSwitch() {
        if (modelPackage == null) {
            modelPackage = CollectionexpressionsPackage.eINSTANCE;
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
            case CollectionexpressionsPackage.INCLUDING: {
                Including including = (Including)theEObject;
                T result = caseIncluding(including);
                if (result == null) result = caseCollectionExpressionWithArgument(including);
                if (result == null) result = caseCollectionExpression(including);
                if (result == null) result = caseExpressionWithArgument(including);
                if (result == null) result = caseExpression(including);
                if (result == null) result = caseWithArgument(including);
                if (result == null) result = caseTypedElement(including);
                if (result == null) result = caseInScope(including);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.EXCLUDING: {
                Excluding excluding = (Excluding)theEObject;
                T result = caseExcluding(excluding);
                if (result == null) result = caseCollectionExpressionWithArgument(excluding);
                if (result == null) result = caseCollectionExpression(excluding);
                if (result == null) result = caseExpressionWithArgument(excluding);
                if (result == null) result = caseExpression(excluding);
                if (result == null) result = caseWithArgument(excluding);
                if (result == null) result = caseTypedElement(excluding);
                if (result == null) result = caseInScope(excluding);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.INCLUDING_AT: {
                IncludingAt includingAt = (IncludingAt)theEObject;
                T result = caseIncludingAt(includingAt);
                if (result == null) result = caseIncluding(includingAt);
                if (result == null) result = caseWithPosition(includingAt);
                if (result == null) result = caseCollectionExpressionWithArgument(includingAt);
                if (result == null) result = caseCollectionExpression(includingAt);
                if (result == null) result = caseExpressionWithArgument(includingAt);
                if (result == null) result = caseExpression(includingAt);
                if (result == null) result = caseWithArgument(includingAt);
                if (result == null) result = caseTypedElement(includingAt);
                if (result == null) result = caseInScope(includingAt);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.ITERATE: {
                Iterate iterate = (Iterate)theEObject;
                T result = caseIterate(iterate);
                if (result == null) result = caseCollectionExpression(iterate);
                if (result == null) result = caseExpression(iterate);
                if (result == null) result = caseTypedElement(iterate);
                if (result == null) result = caseInScope(iterate);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION: {
                CollectionExpression collectionExpression = (CollectionExpression)theEObject;
                T result = caseCollectionExpression(collectionExpression);
                if (result == null) result = caseExpression(collectionExpression);
                if (result == null) result = caseTypedElement(collectionExpression);
                if (result == null) result = caseInScope(collectionExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.EXCLUDING_AT: {
                ExcludingAt excludingAt = (ExcludingAt)theEObject;
                T result = caseExcludingAt(excludingAt);
                if (result == null) result = caseExcluding(excludingAt);
                if (result == null) result = caseWithPosition(excludingAt);
                if (result == null) result = caseCollectionExpressionWithArgument(excludingAt);
                if (result == null) result = caseCollectionExpression(excludingAt);
                if (result == null) result = caseExpressionWithArgument(excludingAt);
                if (result == null) result = caseExpression(excludingAt);
                if (result == null) result = caseWithArgument(excludingAt);
                if (result == null) result = caseTypedElement(excludingAt);
                if (result == null) result = caseInScope(excludingAt);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.WITH_POSITION: {
                WithPosition withPosition = (WithPosition)theEObject;
                T result = caseWithPosition(withPosition);
                if (result == null) result = caseExpressionWithArgument(withPosition);
                if (result == null) result = caseExpression(withPosition);
                if (result == null) result = caseWithArgument(withPosition);
                if (result == null) result = caseTypedElement(withPosition);
                if (result == null) result = caseInScope(withPosition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT: {
                CollectionExpressionWithArgument collectionExpressionWithArgument = (CollectionExpressionWithArgument)theEObject;
                T result = caseCollectionExpressionWithArgument(collectionExpressionWithArgument);
                if (result == null) result = caseCollectionExpression(collectionExpressionWithArgument);
                if (result == null) result = caseExpressionWithArgument(collectionExpressionWithArgument);
                if (result == null) result = caseExpression(collectionExpressionWithArgument);
                if (result == null) result = caseWithArgument(collectionExpressionWithArgument);
                if (result == null) result = caseTypedElement(collectionExpressionWithArgument);
                if (result == null) result = caseInScope(collectionExpressionWithArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Including</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Including</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIncluding(Including object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Excluding</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Excluding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExcluding(Excluding object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Including At</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Including At</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIncludingAt(IncludingAt object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Iterate</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterate</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIterate(Iterate object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCollectionExpression(CollectionExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Excluding At</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Excluding At</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExcludingAt(ExcludingAt object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>With Position</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>With Position</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseWithPosition(WithPosition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Expression With Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Expression With Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCollectionExpressionWithArgument(CollectionExpressionWithArgument object) {
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

} //CollectionexpressionsSwitch
