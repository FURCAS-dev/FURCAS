/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.ModelElement;

import org.oslo.ocl20.semantics.model.expressions.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP: {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp) theEObject;
				Object result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseLiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseOclExpression(booleanLiteralExp);
				if (result == null)
					result = caseModelElement(booleanLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(booleanLiteralExp);
				if (result == null)
					result = caseElement(booleanLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CALL_EXP: {
				CallExp callExp = (CallExp) theEObject;
				Object result = caseCallExp(callExp);
				if (result == null)
					result = caseOclExpression(callExp);
				if (result == null)
					result = caseModelElement(callExp);
				if (result == null)
					result = caseSemanticsVisitable(callExp);
				if (result == null)
					result = caseElement(callExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_ITEM: {
				CollectionItem collectionItem = (CollectionItem) theEObject;
				Object result = caseCollectionItem(collectionItem);
				if (result == null)
					result = caseCollectionLiteralPart(collectionItem);
				if (result == null)
					result = caseSemanticsVisitable(collectionItem);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_LITERAL_EXP: {
				CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp) theEObject;
				Object result = caseCollectionLiteralExp(collectionLiteralExp);
				if (result == null)
					result = caseLiteralExp(collectionLiteralExp);
				if (result == null)
					result = caseOclExpression(collectionLiteralExp);
				if (result == null)
					result = caseModelElement(collectionLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(collectionLiteralExp);
				if (result == null)
					result = caseElement(collectionLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_LITERAL_PART: {
				CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart) theEObject;
				Object result = caseCollectionLiteralPart(collectionLiteralPart);
				if (result == null)
					result = caseSemanticsVisitable(collectionLiteralPart);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_RANGE: {
				CollectionRange collectionRange = (CollectionRange) theEObject;
				Object result = caseCollectionRange(collectionRange);
				if (result == null)
					result = caseCollectionLiteralPart(collectionRange);
				if (result == null)
					result = caseSemanticsVisitable(collectionRange);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ENUM_LITERAL_EXP: {
				EnumLiteralExp enumLiteralExp = (EnumLiteralExp) theEObject;
				Object result = caseEnumLiteralExp(enumLiteralExp);
				if (result == null)
					result = caseLiteralExp(enumLiteralExp);
				if (result == null)
					result = caseOclExpression(enumLiteralExp);
				if (result == null)
					result = caseModelElement(enumLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(enumLiteralExp);
				if (result == null)
					result = caseElement(enumLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IF_EXP: {
				IfExp ifExp = (IfExp) theEObject;
				Object result = caseIfExp(ifExp);
				if (result == null)
					result = caseOclExpression(ifExp);
				if (result == null)
					result = caseModelElement(ifExp);
				if (result == null)
					result = caseSemanticsVisitable(ifExp);
				if (result == null)
					result = caseElement(ifExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.INTEGER_LITERAL_EXP: {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp) theEObject;
				Object result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseNumericalLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseOclExpression(integerLiteralExp);
				if (result == null)
					result = caseModelElement(integerLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(integerLiteralExp);
				if (result == null)
					result = caseElement(integerLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ITERATE_EXP: {
				IterateExp iterateExp = (IterateExp) theEObject;
				Object result = caseIterateExp(iterateExp);
				if (result == null)
					result = caseLoopExp(iterateExp);
				if (result == null)
					result = caseCallExp(iterateExp);
				if (result == null)
					result = caseOclExpression(iterateExp);
				if (result == null)
					result = caseModelElement(iterateExp);
				if (result == null)
					result = caseSemanticsVisitable(iterateExp);
				if (result == null)
					result = caseElement(iterateExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ITERATOR_EXP: {
				IteratorExp iteratorExp = (IteratorExp) theEObject;
				Object result = caseIteratorExp(iteratorExp);
				if (result == null)
					result = caseLoopExp(iteratorExp);
				if (result == null)
					result = caseCallExp(iteratorExp);
				if (result == null)
					result = caseOclExpression(iteratorExp);
				if (result == null)
					result = caseModelElement(iteratorExp);
				if (result == null)
					result = caseSemanticsVisitable(iteratorExp);
				if (result == null)
					result = caseElement(iteratorExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LET_EXP: {
				LetExp letExp = (LetExp) theEObject;
				Object result = caseLetExp(letExp);
				if (result == null)
					result = caseOclExpression(letExp);
				if (result == null)
					result = caseModelElement(letExp);
				if (result == null)
					result = caseSemanticsVisitable(letExp);
				if (result == null)
					result = caseElement(letExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LITERAL_EXP: {
				LiteralExp literalExp = (LiteralExp) theEObject;
				Object result = caseLiteralExp(literalExp);
				if (result == null)
					result = caseOclExpression(literalExp);
				if (result == null)
					result = caseModelElement(literalExp);
				if (result == null)
					result = caseSemanticsVisitable(literalExp);
				if (result == null)
					result = caseElement(literalExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LOOP_EXP: {
				LoopExp loopExp = (LoopExp) theEObject;
				Object result = caseLoopExp(loopExp);
				if (result == null)
					result = caseCallExp(loopExp);
				if (result == null)
					result = caseOclExpression(loopExp);
				if (result == null)
					result = caseModelElement(loopExp);
				if (result == null)
					result = caseSemanticsVisitable(loopExp);
				if (result == null)
					result = caseElement(loopExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MODEL_PROPERTY_CALL_EXP: {
				ModelPropertyCallExp modelPropertyCallExp = (ModelPropertyCallExp) theEObject;
				Object result = caseModelPropertyCallExp(modelPropertyCallExp);
				if (result == null)
					result = caseCallExp(modelPropertyCallExp);
				if (result == null)
					result = caseOclExpression(modelPropertyCallExp);
				if (result == null)
					result = caseModelElement(modelPropertyCallExp);
				if (result == null)
					result = caseSemanticsVisitable(modelPropertyCallExp);
				if (result == null)
					result = caseElement(modelPropertyCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NUMERICAL_LITERAL_EXP: {
				NumericalLiteralExp numericalLiteralExp = (NumericalLiteralExp) theEObject;
				Object result = caseNumericalLiteralExp(numericalLiteralExp);
				if (result == null)
					result = caseLiteralExp(numericalLiteralExp);
				if (result == null)
					result = caseOclExpression(numericalLiteralExp);
				if (result == null)
					result = caseModelElement(numericalLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(numericalLiteralExp);
				if (result == null)
					result = caseElement(numericalLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_EXPRESSION: {
				OclExpression oclExpression = (OclExpression) theEObject;
				Object result = caseOclExpression(oclExpression);
				if (result == null)
					result = caseModelElement(oclExpression);
				if (result == null)
					result = caseSemanticsVisitable(oclExpression);
				if (result == null)
					result = caseElement(oclExpression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_MESSAGE_ARG: {
				OclMessageArg oclMessageArg = (OclMessageArg) theEObject;
				Object result = caseOclMessageArg(oclMessageArg);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_MESSAGE_EXP: {
				OclMessageExp oclMessageExp = (OclMessageExp) theEObject;
				Object result = caseOclMessageExp(oclMessageExp);
				if (result == null)
					result = caseOclExpression(oclMessageExp);
				if (result == null)
					result = caseModelElement(oclMessageExp);
				if (result == null)
					result = caseSemanticsVisitable(oclMessageExp);
				if (result == null)
					result = caseElement(oclMessageExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp) theEObject;
				Object result = caseOperationCallExp(operationCallExp);
				if (result == null)
					result = caseModelPropertyCallExp(operationCallExp);
				if (result == null)
					result = caseCallExp(operationCallExp);
				if (result == null)
					result = caseOclExpression(operationCallExp);
				if (result == null)
					result = caseModelElement(operationCallExp);
				if (result == null)
					result = caseSemanticsVisitable(operationCallExp);
				if (result == null)
					result = caseElement(operationCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PROPERTY_CALL_EXP: {
				PropertyCallExp propertyCallExp = (PropertyCallExp) theEObject;
				Object result = casePropertyCallExp(propertyCallExp);
				if (result == null)
					result = caseModelPropertyCallExp(propertyCallExp);
				if (result == null)
					result = caseCallExp(propertyCallExp);
				if (result == null)
					result = caseOclExpression(propertyCallExp);
				if (result == null)
					result = caseModelElement(propertyCallExp);
				if (result == null)
					result = caseSemanticsVisitable(propertyCallExp);
				if (result == null)
					result = caseElement(propertyCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.REAL_LITERAL_EXP: {
				RealLiteralExp realLiteralExp = (RealLiteralExp) theEObject;
				Object result = caseRealLiteralExp(realLiteralExp);
				if (result == null)
					result = caseNumericalLiteralExp(realLiteralExp);
				if (result == null)
					result = caseLiteralExp(realLiteralExp);
				if (result == null)
					result = caseOclExpression(realLiteralExp);
				if (result == null)
					result = caseModelElement(realLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(realLiteralExp);
				if (result == null)
					result = caseElement(realLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.STRING_LITERAL_EXP: {
				StringLiteralExp stringLiteralExp = (StringLiteralExp) theEObject;
				Object result = caseStringLiteralExp(stringLiteralExp);
				if (result == null)
					result = caseLiteralExp(stringLiteralExp);
				if (result == null)
					result = caseOclExpression(stringLiteralExp);
				if (result == null)
					result = caseModelElement(stringLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(stringLiteralExp);
				if (result == null)
					result = caseElement(stringLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TUPLE_LITERAL_EXP: {
				TupleLiteralExp tupleLiteralExp = (TupleLiteralExp) theEObject;
				Object result = caseTupleLiteralExp(tupleLiteralExp);
				if (result == null)
					result = caseLiteralExp(tupleLiteralExp);
				if (result == null)
					result = caseOclExpression(tupleLiteralExp);
				if (result == null)
					result = caseModelElement(tupleLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(tupleLiteralExp);
				if (result == null)
					result = caseElement(tupleLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TYPE_LITERAL_EXP: {
				TypeLiteralExp typeLiteralExp = (TypeLiteralExp) theEObject;
				Object result = caseTypeLiteralExp(typeLiteralExp);
				if (result == null)
					result = caseLiteralExp(typeLiteralExp);
				if (result == null)
					result = caseOclExpression(typeLiteralExp);
				if (result == null)
					result = caseModelElement(typeLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(typeLiteralExp);
				if (result == null)
					result = caseElement(typeLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNDEFINED_LITERAL_EXP: {
				UndefinedLiteralExp undefinedLiteralExp = (UndefinedLiteralExp) theEObject;
				Object result = caseUndefinedLiteralExp(undefinedLiteralExp);
				if (result == null)
					result = caseLiteralExp(undefinedLiteralExp);
				if (result == null)
					result = caseOclExpression(undefinedLiteralExp);
				if (result == null)
					result = caseModelElement(undefinedLiteralExp);
				if (result == null)
					result = caseSemanticsVisitable(undefinedLiteralExp);
				if (result == null)
					result = caseElement(undefinedLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNSPECIFIED_VALUE_EXP: {
				UnspecifiedValueExp unspecifiedValueExp = (UnspecifiedValueExp) theEObject;
				Object result = caseUnspecifiedValueExp(unspecifiedValueExp);
				if (result == null)
					result = caseOclExpression(unspecifiedValueExp);
				if (result == null)
					result = caseModelElement(unspecifiedValueExp);
				if (result == null)
					result = caseSemanticsVisitable(unspecifiedValueExp);
				if (result == null)
					result = caseElement(unspecifiedValueExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration) theEObject;
				Object result = caseVariableDeclaration(variableDeclaration);
				if (result == null)
					result = caseModelElement(variableDeclaration);
				if (result == null)
					result = caseSemanticsVisitable(variableDeclaration);
				if (result == null)
					result = caseElement(variableDeclaration);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp) theEObject;
				Object result = caseVariableExp(variableExp);
				if (result == null)
					result = caseOclExpression(variableExp);
				if (result == null)
					result = caseModelElement(variableExp);
				if (result == null)
					result = caseSemanticsVisitable(variableExp);
				if (result == null)
					result = caseElement(variableExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>
	 * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>
	 *         '.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanLiteralExp(BooleanLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCallExp(CallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionItem(CollectionItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Collection Literal Exp</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Collection Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralExp(CollectionLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Collection Literal Part</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Collection Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralPart(CollectionLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionRange(CollectionRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumLiteralExp(EnumLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIfExp(IfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>
	 * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>
	 *         '.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerLiteralExp(IntegerLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIterateExp(IterateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIteratorExp(IteratorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLetExp(LetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLiteralExp(LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Model Property Call Exp</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Model Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelPropertyCallExp(ModelPropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Numerical Literal Exp</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Numerical Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNumericalLiteralExp(NumericalLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclExpression(OclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Message Arg</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Message Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclMessageArg(OclMessageArg object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Message Exp</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Message Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclMessageExp(OclMessageExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>
	 * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>
	 *         '.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealLiteralExp(RealLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>
	 * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>
	 *         '.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringLiteralExp(StringLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleLiteralExp(TupleLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal Exp</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypeLiteralExp(TypeLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Undefined Literal Exp</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Undefined Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUndefinedLiteralExp(UndefinedLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Unspecified Value Exp</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Unspecified Value Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnspecifiedValueExp(UnspecifiedValueExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Variable Declaration</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSemanticsVisitable(SemanticsVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} // ExpressionsSwitch
