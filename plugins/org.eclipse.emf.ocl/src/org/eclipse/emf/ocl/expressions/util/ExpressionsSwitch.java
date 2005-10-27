/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions.util;


import org.eclipse.emf.ocl.expressions.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.ModelPropertyCallExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.NumericLiteralExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OclMessageArg;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.CallingAstNode;
import org.eclipse.emf.ocl.internal.utilities.TypedAstNode;
import org.eclipse.emf.ocl.internal.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch {
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
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP: {
				AssociationEndCallExp associationEndCallExp = (AssociationEndCallExp)theEObject;
				Object result = caseAssociationEndCallExp(associationEndCallExp);
				if (result == null) result = caseNavigationCallExp(associationEndCallExp);
				if (result == null) result = caseModelPropertyCallExp(associationEndCallExp);
				if (result == null) result = casePropertyCallExp(associationEndCallExp);
				if (result == null) result = caseOclExpression(associationEndCallExp);
				if (result == null) result = caseCallingAstNode(associationEndCallExp);
				if (result == null) result = caseENamedElement(associationEndCallExp);
				if (result == null) result = caseVisitable(associationEndCallExp);
				if (result == null) result = caseAstNode(associationEndCallExp);
				if (result == null) result = caseEModelElement(associationEndCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP: {
				AttributeCallExp attributeCallExp = (AttributeCallExp)theEObject;
				Object result = caseAttributeCallExp(attributeCallExp);
				if (result == null) result = caseModelPropertyCallExp(attributeCallExp);
				if (result == null) result = casePropertyCallExp(attributeCallExp);
				if (result == null) result = caseOclExpression(attributeCallExp);
				if (result == null) result = caseCallingAstNode(attributeCallExp);
				if (result == null) result = caseENamedElement(attributeCallExp);
				if (result == null) result = caseVisitable(attributeCallExp);
				if (result == null) result = caseAstNode(attributeCallExp);
				if (result == null) result = caseEModelElement(attributeCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP: {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
				Object result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(booleanLiteralExp);
				if (result == null) result = caseLiteralExp(booleanLiteralExp);
				if (result == null) result = caseOclExpression(booleanLiteralExp);
				if (result == null) result = caseENamedElement(booleanLiteralExp);
				if (result == null) result = caseVisitable(booleanLiteralExp);
				if (result == null) result = caseAstNode(booleanLiteralExp);
				if (result == null) result = caseEModelElement(booleanLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_ITEM: {
				CollectionItem collectionItem = (CollectionItem)theEObject;
				Object result = caseCollectionItem(collectionItem);
				if (result == null) result = caseCollectionLiteralPart(collectionItem);
				if (result == null) result = caseENamedElement(collectionItem);
				if (result == null) result = caseEModelElement(collectionItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_LITERAL_EXP: {
				CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp)theEObject;
				Object result = caseCollectionLiteralExp(collectionLiteralExp);
				if (result == null) result = caseLiteralExp(collectionLiteralExp);
				if (result == null) result = caseOclExpression(collectionLiteralExp);
				if (result == null) result = caseENamedElement(collectionLiteralExp);
				if (result == null) result = caseVisitable(collectionLiteralExp);
				if (result == null) result = caseAstNode(collectionLiteralExp);
				if (result == null) result = caseEModelElement(collectionLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_LITERAL_PART: {
				CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart)theEObject;
				Object result = caseCollectionLiteralPart(collectionLiteralPart);
				if (result == null) result = caseENamedElement(collectionLiteralPart);
				if (result == null) result = caseEModelElement(collectionLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_RANGE: {
				CollectionRange collectionRange = (CollectionRange)theEObject;
				Object result = caseCollectionRange(collectionRange);
				if (result == null) result = caseCollectionLiteralPart(collectionRange);
				if (result == null) result = caseENamedElement(collectionRange);
				if (result == null) result = caseEModelElement(collectionRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ENUM_LITERAL_EXP: {
				EnumLiteralExp enumLiteralExp = (EnumLiteralExp)theEObject;
				Object result = caseEnumLiteralExp(enumLiteralExp);
				if (result == null) result = caseLiteralExp(enumLiteralExp);
				if (result == null) result = caseOclExpression(enumLiteralExp);
				if (result == null) result = caseENamedElement(enumLiteralExp);
				if (result == null) result = caseVisitable(enumLiteralExp);
				if (result == null) result = caseAstNode(enumLiteralExp);
				if (result == null) result = caseEModelElement(enumLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IF_EXP: {
				IfExp ifExp = (IfExp)theEObject;
				Object result = caseIfExp(ifExp);
				if (result == null) result = caseOclExpression(ifExp);
				if (result == null) result = caseENamedElement(ifExp);
				if (result == null) result = caseVisitable(ifExp);
				if (result == null) result = caseAstNode(ifExp);
				if (result == null) result = caseEModelElement(ifExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.INTEGER_LITERAL_EXP: {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp)theEObject;
				Object result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null) result = caseNumericLiteralExp(integerLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(integerLiteralExp);
				if (result == null) result = caseLiteralExp(integerLiteralExp);
				if (result == null) result = caseOclExpression(integerLiteralExp);
				if (result == null) result = caseENamedElement(integerLiteralExp);
				if (result == null) result = caseVisitable(integerLiteralExp);
				if (result == null) result = caseAstNode(integerLiteralExp);
				if (result == null) result = caseEModelElement(integerLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ITERATE_EXP: {
				IterateExp iterateExp = (IterateExp)theEObject;
				Object result = caseIterateExp(iterateExp);
				if (result == null) result = caseLoopExp(iterateExp);
				if (result == null) result = casePropertyCallExp(iterateExp);
				if (result == null) result = caseOclExpression(iterateExp);
				if (result == null) result = caseCallingAstNode(iterateExp);
				if (result == null) result = caseENamedElement(iterateExp);
				if (result == null) result = caseVisitable(iterateExp);
				if (result == null) result = caseAstNode(iterateExp);
				if (result == null) result = caseEModelElement(iterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ITERATOR_EXP: {
				IteratorExp iteratorExp = (IteratorExp)theEObject;
				Object result = caseIteratorExp(iteratorExp);
				if (result == null) result = caseLoopExp(iteratorExp);
				if (result == null) result = casePropertyCallExp(iteratorExp);
				if (result == null) result = caseOclExpression(iteratorExp);
				if (result == null) result = caseCallingAstNode(iteratorExp);
				if (result == null) result = caseENamedElement(iteratorExp);
				if (result == null) result = caseVisitable(iteratorExp);
				if (result == null) result = caseAstNode(iteratorExp);
				if (result == null) result = caseEModelElement(iteratorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LET_EXP: {
				LetExp letExp = (LetExp)theEObject;
				Object result = caseLetExp(letExp);
				if (result == null) result = caseOclExpression(letExp);
				if (result == null) result = caseENamedElement(letExp);
				if (result == null) result = caseVisitable(letExp);
				if (result == null) result = caseAstNode(letExp);
				if (result == null) result = caseEModelElement(letExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LITERAL_EXP: {
				LiteralExp literalExp = (LiteralExp)theEObject;
				Object result = caseLiteralExp(literalExp);
				if (result == null) result = caseOclExpression(literalExp);
				if (result == null) result = caseENamedElement(literalExp);
				if (result == null) result = caseVisitable(literalExp);
				if (result == null) result = caseAstNode(literalExp);
				if (result == null) result = caseEModelElement(literalExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LOOP_EXP: {
				LoopExp loopExp = (LoopExp)theEObject;
				Object result = caseLoopExp(loopExp);
				if (result == null) result = casePropertyCallExp(loopExp);
				if (result == null) result = caseOclExpression(loopExp);
				if (result == null) result = caseCallingAstNode(loopExp);
				if (result == null) result = caseENamedElement(loopExp);
				if (result == null) result = caseVisitable(loopExp);
				if (result == null) result = caseAstNode(loopExp);
				if (result == null) result = caseEModelElement(loopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MODEL_PROPERTY_CALL_EXP: {
				ModelPropertyCallExp modelPropertyCallExp = (ModelPropertyCallExp)theEObject;
				Object result = caseModelPropertyCallExp(modelPropertyCallExp);
				if (result == null) result = casePropertyCallExp(modelPropertyCallExp);
				if (result == null) result = caseOclExpression(modelPropertyCallExp);
				if (result == null) result = caseCallingAstNode(modelPropertyCallExp);
				if (result == null) result = caseENamedElement(modelPropertyCallExp);
				if (result == null) result = caseVisitable(modelPropertyCallExp);
				if (result == null) result = caseAstNode(modelPropertyCallExp);
				if (result == null) result = caseEModelElement(modelPropertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NAVIGATION_CALL_EXP: {
				NavigationCallExp navigationCallExp = (NavigationCallExp)theEObject;
				Object result = caseNavigationCallExp(navigationCallExp);
				if (result == null) result = caseModelPropertyCallExp(navigationCallExp);
				if (result == null) result = casePropertyCallExp(navigationCallExp);
				if (result == null) result = caseOclExpression(navigationCallExp);
				if (result == null) result = caseCallingAstNode(navigationCallExp);
				if (result == null) result = caseENamedElement(navigationCallExp);
				if (result == null) result = caseVisitable(navigationCallExp);
				if (result == null) result = caseAstNode(navigationCallExp);
				if (result == null) result = caseEModelElement(navigationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NUMERIC_LITERAL_EXP: {
				NumericLiteralExp numericLiteralExp = (NumericLiteralExp)theEObject;
				Object result = caseNumericLiteralExp(numericLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(numericLiteralExp);
				if (result == null) result = caseLiteralExp(numericLiteralExp);
				if (result == null) result = caseOclExpression(numericLiteralExp);
				if (result == null) result = caseENamedElement(numericLiteralExp);
				if (result == null) result = caseVisitable(numericLiteralExp);
				if (result == null) result = caseAstNode(numericLiteralExp);
				if (result == null) result = caseEModelElement(numericLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_EXPRESSION: {
				OclExpression oclExpression = (OclExpression)theEObject;
				Object result = caseOclExpression(oclExpression);
				if (result == null) result = caseENamedElement(oclExpression);
				if (result == null) result = caseVisitable(oclExpression);
				if (result == null) result = caseAstNode(oclExpression);
				if (result == null) result = caseEModelElement(oclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_MESSAGE_ARG: {
				OclMessageArg oclMessageArg = (OclMessageArg)theEObject;
				Object result = caseOclMessageArg(oclMessageArg);
				if (result == null) result = caseENamedElement(oclMessageArg);
				if (result == null) result = caseEModelElement(oclMessageArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				Object result = caseOperationCallExp(operationCallExp);
				if (result == null) result = caseModelPropertyCallExp(operationCallExp);
				if (result == null) result = casePropertyCallExp(operationCallExp);
				if (result == null) result = caseOclExpression(operationCallExp);
				if (result == null) result = caseCallingAstNode(operationCallExp);
				if (result == null) result = caseENamedElement(operationCallExp);
				if (result == null) result = caseVisitable(operationCallExp);
				if (result == null) result = caseAstNode(operationCallExp);
				if (result == null) result = caseEModelElement(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PRIMITIVE_LITERAL_EXP: {
				PrimitiveLiteralExp primitiveLiteralExp = (PrimitiveLiteralExp)theEObject;
				Object result = casePrimitiveLiteralExp(primitiveLiteralExp);
				if (result == null) result = caseLiteralExp(primitiveLiteralExp);
				if (result == null) result = caseOclExpression(primitiveLiteralExp);
				if (result == null) result = caseENamedElement(primitiveLiteralExp);
				if (result == null) result = caseVisitable(primitiveLiteralExp);
				if (result == null) result = caseAstNode(primitiveLiteralExp);
				if (result == null) result = caseEModelElement(primitiveLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PROPERTY_CALL_EXP: {
				PropertyCallExp propertyCallExp = (PropertyCallExp)theEObject;
				Object result = casePropertyCallExp(propertyCallExp);
				if (result == null) result = caseOclExpression(propertyCallExp);
				if (result == null) result = caseCallingAstNode(propertyCallExp);
				if (result == null) result = caseENamedElement(propertyCallExp);
				if (result == null) result = caseVisitable(propertyCallExp);
				if (result == null) result = caseAstNode(propertyCallExp);
				if (result == null) result = caseEModelElement(propertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.REAL_LITERAL_EXP: {
				RealLiteralExp realLiteralExp = (RealLiteralExp)theEObject;
				Object result = caseRealLiteralExp(realLiteralExp);
				if (result == null) result = caseNumericLiteralExp(realLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(realLiteralExp);
				if (result == null) result = caseLiteralExp(realLiteralExp);
				if (result == null) result = caseOclExpression(realLiteralExp);
				if (result == null) result = caseENamedElement(realLiteralExp);
				if (result == null) result = caseVisitable(realLiteralExp);
				if (result == null) result = caseAstNode(realLiteralExp);
				if (result == null) result = caseEModelElement(realLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.STRING_LITERAL_EXP: {
				StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
				Object result = caseStringLiteralExp(stringLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(stringLiteralExp);
				if (result == null) result = caseLiteralExp(stringLiteralExp);
				if (result == null) result = caseOclExpression(stringLiteralExp);
				if (result == null) result = caseENamedElement(stringLiteralExp);
				if (result == null) result = caseVisitable(stringLiteralExp);
				if (result == null) result = caseAstNode(stringLiteralExp);
				if (result == null) result = caseEModelElement(stringLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TUPLE_LITERAL_EXP: {
				TupleLiteralExp tupleLiteralExp = (TupleLiteralExp)theEObject;
				Object result = caseTupleLiteralExp(tupleLiteralExp);
				if (result == null) result = caseLiteralExp(tupleLiteralExp);
				if (result == null) result = caseOclExpression(tupleLiteralExp);
				if (result == null) result = caseENamedElement(tupleLiteralExp);
				if (result == null) result = caseVisitable(tupleLiteralExp);
				if (result == null) result = caseAstNode(tupleLiteralExp);
				if (result == null) result = caseEModelElement(tupleLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNSPECIFIED_VALUE_EXP: {
				UnspecifiedValueExp unspecifiedValueExp = (UnspecifiedValueExp)theEObject;
				Object result = caseUnspecifiedValueExp(unspecifiedValueExp);
				if (result == null) result = caseOclExpression(unspecifiedValueExp);
				if (result == null) result = caseENamedElement(unspecifiedValueExp);
				if (result == null) result = caseVisitable(unspecifiedValueExp);
				if (result == null) result = caseAstNode(unspecifiedValueExp);
				if (result == null) result = caseEModelElement(unspecifiedValueExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				Object result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseENamedElement(variableDeclaration);
				if (result == null) result = caseVisitable(variableDeclaration);
				if (result == null) result = caseTypedAstNode(variableDeclaration);
				if (result == null) result = caseEModelElement(variableDeclaration);
				if (result == null) result = caseAstNode(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp)theEObject;
				Object result = caseVariableExp(variableExp);
				if (result == null) result = caseOclExpression(variableExp);
				if (result == null) result = caseENamedElement(variableExp);
				if (result == null) result = caseVisitable(variableExp);
				if (result == null) result = caseAstNode(variableExp);
				if (result == null) result = caseEModelElement(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ASSOCIATION_CLASS_CALL_EXP: {
				AssociationClassCallExp associationClassCallExp = (AssociationClassCallExp)theEObject;
				Object result = caseAssociationClassCallExp(associationClassCallExp);
				if (result == null) result = caseNavigationCallExp(associationClassCallExp);
				if (result == null) result = caseModelPropertyCallExp(associationClassCallExp);
				if (result == null) result = casePropertyCallExp(associationClassCallExp);
				if (result == null) result = caseOclExpression(associationClassCallExp);
				if (result == null) result = caseCallingAstNode(associationClassCallExp);
				if (result == null) result = caseENamedElement(associationClassCallExp);
				if (result == null) result = caseVisitable(associationClassCallExp);
				if (result == null) result = caseAstNode(associationClassCallExp);
				if (result == null) result = caseEModelElement(associationClassCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Association End Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Association End Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAssociationEndCallExp(AssociationEndCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Attribute Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Attribute Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeCallExp(AttributeCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanLiteralExp(BooleanLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionItem(CollectionItem object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralExp(CollectionLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralPart(CollectionLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionRange(CollectionRange object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIfExp(IfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerLiteralExp(IntegerLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIterateExp(IterateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIteratorExp(IteratorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLetExp(LetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLiteralExp(LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Model Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Model Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelPropertyCallExp(ModelPropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Navigation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Navigation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNavigationCallExp(NavigationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNumericLiteralExp(NumericLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclExpression(OclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ocl Message Arg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ocl Message Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclMessageArg(OclMessageArg object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveLiteralExp(PrimitiveLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealLiteralExp(RealLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>String Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringLiteralExp(StringLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleLiteralExp(TupleLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unspecified Value Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unspecified Value Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnspecifiedValueExp(UnspecifiedValueExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Association Class Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Association Class Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAssociationClassCallExp(AssociationClassCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ast Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ast Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAstNode(AstNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Calling Ast Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Calling Ast Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCallingAstNode(CallingAstNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Typed Ast Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Typed Ast Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypedAstNode(TypedAstNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumLiteralExp(EnumLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseENamedElement(ENamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ExpressionsSwitch
