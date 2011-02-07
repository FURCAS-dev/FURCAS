/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalyticsSwitch.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.analytics.util;

import data.classes.FunctionSignatureImplementation;
import data.classes.InScope;
import data.classes.SignatureImplementation;
import data.classes.TypedElement;

import dataaccess.analytics.*;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectBasedExpression;

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
 * @see dataaccess.analytics.AnalyticsPackage
 * @generated
 */
public class AnalyticsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AnalyticsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AnalyticsSwitch() {
        if (modelPackage == null) {
            modelPackage = AnalyticsPackage.eINSTANCE;
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
            case AnalyticsPackage.DIMENSION: {
                Dimension dimension = (Dimension)theEObject;
                T result = caseDimension(dimension);
                if (result == null) result = caseNamedElement(dimension);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AnalyticsPackage.CELL_SET: {
                CellSet cellSet = (CellSet)theEObject;
                T result = caseCellSet(cellSet);
                if (result == null) result = caseFunctionSignatureImplementation(cellSet);
                if (result == null) result = caseSignatureImplementation(cellSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AnalyticsPackage.DIMENSION_EXPRESSION: {
                DimensionExpression dimensionExpression = (DimensionExpression)theEObject;
                T result = caseDimensionExpression(dimensionExpression);
                if (result == null) result = caseExpression(dimensionExpression);
                if (result == null) result = caseTypedElement(dimensionExpression);
                if (result == null) result = caseInScope(dimensionExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AnalyticsPackage.GROUP_BY: {
                GroupBy groupBy = (GroupBy)theEObject;
                T result = caseGroupBy(groupBy);
                if (result == null) result = caseObjectBasedExpression(groupBy);
                if (result == null) result = caseExpression(groupBy);
                if (result == null) result = caseTypedElement(groupBy);
                if (result == null) result = caseInScope(groupBy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AnalyticsPackage.DIMENSION_DEFINITION: {
                DimensionDefinition dimensionDefinition = (DimensionDefinition)theEObject;
                T result = caseDimensionDefinition(dimensionDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDimension(Dimension object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Cell Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCellSet(CellSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dimension Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDimensionExpression(DimensionExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group By</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseGroupBy(GroupBy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Dimension Definition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dimension Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDimensionDefinition(DimensionDefinition object) {
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

} //AnalyticsSwitch
