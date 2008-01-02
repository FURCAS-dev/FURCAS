/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ExpressionsSwitch.java,v 1.6 2008/01/02 20:12:59 cdamus Exp $
 */
package org.eclipse.ocl.expressions.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.expressions.*;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.NumericLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;


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
 * @see org.eclipse.ocl.expressions.ExpressionsPackage
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
            case ExpressionsPackage.ASSOCIATION_CLASS_CALL_EXP: {
                AssociationClassCallExp<?, ?> associationClassCallExp = (AssociationClassCallExp<?, ?>)theEObject;
                T result = caseAssociationClassCallExp(associationClassCallExp);
                if (result == null) result = caseNavigationCallExp(associationClassCallExp);
                if (result == null) result = caseFeatureCallExp(associationClassCallExp);
                if (result == null) result = caseCallExp(associationClassCallExp);
                if (result == null) result = caseOCLExpression(associationClassCallExp);
                if (result == null) result = caseCallingASTNode(associationClassCallExp);
                if (result == null) result = caseTypedElement(associationClassCallExp);
                if (result == null) result = caseVisitable(associationClassCallExp);
                if (result == null) result = caseASTNode(associationClassCallExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.NAVIGATION_CALL_EXP: {
                NavigationCallExp<?, ?> navigationCallExp = (NavigationCallExp<?, ?>)theEObject;
                T result = caseNavigationCallExp(navigationCallExp);
                if (result == null) result = caseFeatureCallExp(navigationCallExp);
                if (result == null) result = caseCallExp(navigationCallExp);
                if (result == null) result = caseOCLExpression(navigationCallExp);
                if (result == null) result = caseCallingASTNode(navigationCallExp);
                if (result == null) result = caseTypedElement(navigationCallExp);
                if (result == null) result = caseVisitable(navigationCallExp);
                if (result == null) result = caseASTNode(navigationCallExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.FEATURE_CALL_EXP: {
                FeatureCallExp<?> featureCallExp = (FeatureCallExp<?>)theEObject;
                T result = caseFeatureCallExp(featureCallExp);
                if (result == null) result = caseCallExp(featureCallExp);
                if (result == null) result = caseOCLExpression(featureCallExp);
                if (result == null) result = caseCallingASTNode(featureCallExp);
                if (result == null) result = caseTypedElement(featureCallExp);
                if (result == null) result = caseVisitable(featureCallExp);
                if (result == null) result = caseASTNode(featureCallExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.CALL_EXP: {
                CallExp<?> callExp = (CallExp<?>)theEObject;
                T result = caseCallExp(callExp);
                if (result == null) result = caseOCLExpression(callExp);
                if (result == null) result = caseCallingASTNode(callExp);
                if (result == null) result = caseTypedElement(callExp);
                if (result == null) result = caseVisitable(callExp);
                if (result == null) result = caseASTNode(callExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.OCL_EXPRESSION: {
                OCLExpression<?> oclExpression = (OCLExpression<?>)theEObject;
                T result = caseOCLExpression(oclExpression);
                if (result == null) result = caseTypedElement(oclExpression);
                if (result == null) result = caseVisitable(oclExpression);
                if (result == null) result = caseASTNode(oclExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.BOOLEAN_LITERAL_EXP: {
                BooleanLiteralExp<?> booleanLiteralExp = (BooleanLiteralExp<?>)theEObject;
                T result = caseBooleanLiteralExp(booleanLiteralExp);
                if (result == null) result = casePrimitiveLiteralExp(booleanLiteralExp);
                if (result == null) result = caseLiteralExp(booleanLiteralExp);
                if (result == null) result = caseOCLExpression(booleanLiteralExp);
                if (result == null) result = caseTypedElement(booleanLiteralExp);
                if (result == null) result = caseVisitable(booleanLiteralExp);
                if (result == null) result = caseASTNode(booleanLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.PRIMITIVE_LITERAL_EXP: {
                PrimitiveLiteralExp<?> primitiveLiteralExp = (PrimitiveLiteralExp<?>)theEObject;
                T result = casePrimitiveLiteralExp(primitiveLiteralExp);
                if (result == null) result = caseLiteralExp(primitiveLiteralExp);
                if (result == null) result = caseOCLExpression(primitiveLiteralExp);
                if (result == null) result = caseTypedElement(primitiveLiteralExp);
                if (result == null) result = caseVisitable(primitiveLiteralExp);
                if (result == null) result = caseASTNode(primitiveLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.LITERAL_EXP: {
                LiteralExp<?> literalExp = (LiteralExp<?>)theEObject;
                T result = caseLiteralExp(literalExp);
                if (result == null) result = caseOCLExpression(literalExp);
                if (result == null) result = caseTypedElement(literalExp);
                if (result == null) result = caseVisitable(literalExp);
                if (result == null) result = caseASTNode(literalExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.COLLECTION_ITEM: {
                CollectionItem<?> collectionItem = (CollectionItem<?>)theEObject;
                T result = caseCollectionItem(collectionItem);
                if (result == null) result = caseCollectionLiteralPart(collectionItem);
                if (result == null) result = caseTypedElement(collectionItem);
                if (result == null) result = caseVisitable(collectionItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.COLLECTION_LITERAL_PART: {
                CollectionLiteralPart<?> collectionLiteralPart = (CollectionLiteralPart<?>)theEObject;
                T result = caseCollectionLiteralPart(collectionLiteralPart);
                if (result == null) result = caseTypedElement(collectionLiteralPart);
                if (result == null) result = caseVisitable(collectionLiteralPart);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.COLLECTION_LITERAL_EXP: {
                CollectionLiteralExp<?> collectionLiteralExp = (CollectionLiteralExp<?>)theEObject;
                T result = caseCollectionLiteralExp(collectionLiteralExp);
                if (result == null) result = caseLiteralExp(collectionLiteralExp);
                if (result == null) result = caseOCLExpression(collectionLiteralExp);
                if (result == null) result = caseTypedElement(collectionLiteralExp);
                if (result == null) result = caseVisitable(collectionLiteralExp);
                if (result == null) result = caseASTNode(collectionLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.COLLECTION_RANGE: {
                CollectionRange<?> collectionRange = (CollectionRange<?>)theEObject;
                T result = caseCollectionRange(collectionRange);
                if (result == null) result = caseCollectionLiteralPart(collectionRange);
                if (result == null) result = caseTypedElement(collectionRange);
                if (result == null) result = caseVisitable(collectionRange);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.ENUM_LITERAL_EXP: {
                EnumLiteralExp<?, ?> enumLiteralExp = (EnumLiteralExp<?, ?>)theEObject;
                T result = caseEnumLiteralExp(enumLiteralExp);
                if (result == null) result = caseLiteralExp(enumLiteralExp);
                if (result == null) result = caseOCLExpression(enumLiteralExp);
                if (result == null) result = caseTypedElement(enumLiteralExp);
                if (result == null) result = caseVisitable(enumLiteralExp);
                if (result == null) result = caseASTNode(enumLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.IF_EXP: {
                IfExp<?> ifExp = (IfExp<?>)theEObject;
                T result = caseIfExp(ifExp);
                if (result == null) result = caseOCLExpression(ifExp);
                if (result == null) result = caseTypedElement(ifExp);
                if (result == null) result = caseVisitable(ifExp);
                if (result == null) result = caseASTNode(ifExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.INTEGER_LITERAL_EXP: {
                IntegerLiteralExp<?> integerLiteralExp = (IntegerLiteralExp<?>)theEObject;
                T result = caseIntegerLiteralExp(integerLiteralExp);
                if (result == null) result = caseNumericLiteralExp(integerLiteralExp);
                if (result == null) result = casePrimitiveLiteralExp(integerLiteralExp);
                if (result == null) result = caseLiteralExp(integerLiteralExp);
                if (result == null) result = caseOCLExpression(integerLiteralExp);
                if (result == null) result = caseTypedElement(integerLiteralExp);
                if (result == null) result = caseVisitable(integerLiteralExp);
                if (result == null) result = caseASTNode(integerLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.NUMERIC_LITERAL_EXP: {
                NumericLiteralExp<?> numericLiteralExp = (NumericLiteralExp<?>)theEObject;
                T result = caseNumericLiteralExp(numericLiteralExp);
                if (result == null) result = casePrimitiveLiteralExp(numericLiteralExp);
                if (result == null) result = caseLiteralExp(numericLiteralExp);
                if (result == null) result = caseOCLExpression(numericLiteralExp);
                if (result == null) result = caseTypedElement(numericLiteralExp);
                if (result == null) result = caseVisitable(numericLiteralExp);
                if (result == null) result = caseASTNode(numericLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP: {
                UnlimitedNaturalLiteralExp<?> unlimitedNaturalLiteralExp = (UnlimitedNaturalLiteralExp<?>)theEObject;
                T result = caseUnlimitedNaturalLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null) result = caseNumericLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null) result = casePrimitiveLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null) result = caseLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null) result = caseOCLExpression(unlimitedNaturalLiteralExp);
                if (result == null) result = caseTypedElement(unlimitedNaturalLiteralExp);
                if (result == null) result = caseVisitable(unlimitedNaturalLiteralExp);
                if (result == null) result = caseASTNode(unlimitedNaturalLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.INVALID_LITERAL_EXP: {
                InvalidLiteralExp<?> invalidLiteralExp = (InvalidLiteralExp<?>)theEObject;
                T result = caseInvalidLiteralExp(invalidLiteralExp);
                if (result == null) result = caseLiteralExp(invalidLiteralExp);
                if (result == null) result = caseOCLExpression(invalidLiteralExp);
                if (result == null) result = caseTypedElement(invalidLiteralExp);
                if (result == null) result = caseVisitable(invalidLiteralExp);
                if (result == null) result = caseASTNode(invalidLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.ITERATE_EXP: {
                IterateExp<?, ?> iterateExp = (IterateExp<?, ?>)theEObject;
                T result = caseIterateExp(iterateExp);
                if (result == null) result = caseLoopExp(iterateExp);
                if (result == null) result = caseCallExp(iterateExp);
                if (result == null) result = caseOCLExpression(iterateExp);
                if (result == null) result = caseCallingASTNode(iterateExp);
                if (result == null) result = caseTypedElement(iterateExp);
                if (result == null) result = caseVisitable(iterateExp);
                if (result == null) result = caseASTNode(iterateExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.LOOP_EXP: {
                LoopExp<?, ?> loopExp = (LoopExp<?, ?>)theEObject;
                T result = caseLoopExp(loopExp);
                if (result == null) result = caseCallExp(loopExp);
                if (result == null) result = caseOCLExpression(loopExp);
                if (result == null) result = caseCallingASTNode(loopExp);
                if (result == null) result = caseTypedElement(loopExp);
                if (result == null) result = caseVisitable(loopExp);
                if (result == null) result = caseASTNode(loopExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.VARIABLE: {
                Variable<?, ?> variable = (Variable<?, ?>)theEObject;
                T result = caseVariable(variable);
                if (result == null) result = caseTypedElement(variable);
                if (result == null) result = caseVisitable(variable);
                if (result == null) result = caseTypedASTNode(variable);
                if (result == null) result = caseASTNode(variable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.ITERATOR_EXP: {
                IteratorExp<?, ?> iteratorExp = (IteratorExp<?, ?>)theEObject;
                T result = caseIteratorExp(iteratorExp);
                if (result == null) result = caseLoopExp(iteratorExp);
                if (result == null) result = caseCallExp(iteratorExp);
                if (result == null) result = caseOCLExpression(iteratorExp);
                if (result == null) result = caseCallingASTNode(iteratorExp);
                if (result == null) result = caseTypedElement(iteratorExp);
                if (result == null) result = caseVisitable(iteratorExp);
                if (result == null) result = caseASTNode(iteratorExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.LET_EXP: {
                LetExp<?, ?> letExp = (LetExp<?, ?>)theEObject;
                T result = caseLetExp(letExp);
                if (result == null) result = caseOCLExpression(letExp);
                if (result == null) result = caseTypedElement(letExp);
                if (result == null) result = caseVisitable(letExp);
                if (result == null) result = caseASTNode(letExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.MESSAGE_EXP: {
                MessageExp<?, ?, ?> messageExp = (MessageExp<?, ?, ?>)theEObject;
                T result = caseMessageExp(messageExp);
                if (result == null) result = caseOCLExpression(messageExp);
                if (result == null) result = caseCallingASTNode(messageExp);
                if (result == null) result = caseTypedElement(messageExp);
                if (result == null) result = caseVisitable(messageExp);
                if (result == null) result = caseASTNode(messageExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.NULL_LITERAL_EXP: {
                NullLiteralExp<?> nullLiteralExp = (NullLiteralExp<?>)theEObject;
                T result = caseNullLiteralExp(nullLiteralExp);
                if (result == null) result = caseLiteralExp(nullLiteralExp);
                if (result == null) result = caseOCLExpression(nullLiteralExp);
                if (result == null) result = caseTypedElement(nullLiteralExp);
                if (result == null) result = caseVisitable(nullLiteralExp);
                if (result == null) result = caseASTNode(nullLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.OPERATION_CALL_EXP: {
                OperationCallExp<?, ?> operationCallExp = (OperationCallExp<?, ?>)theEObject;
                T result = caseOperationCallExp(operationCallExp);
                if (result == null) result = caseFeatureCallExp(operationCallExp);
                if (result == null) result = caseCallExp(operationCallExp);
                if (result == null) result = caseOCLExpression(operationCallExp);
                if (result == null) result = caseCallingASTNode(operationCallExp);
                if (result == null) result = caseTypedElement(operationCallExp);
                if (result == null) result = caseVisitable(operationCallExp);
                if (result == null) result = caseASTNode(operationCallExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.PROPERTY_CALL_EXP: {
                PropertyCallExp<?, ?> propertyCallExp = (PropertyCallExp<?, ?>)theEObject;
                T result = casePropertyCallExp(propertyCallExp);
                if (result == null) result = caseNavigationCallExp(propertyCallExp);
                if (result == null) result = caseFeatureCallExp(propertyCallExp);
                if (result == null) result = caseCallExp(propertyCallExp);
                if (result == null) result = caseOCLExpression(propertyCallExp);
                if (result == null) result = caseCallingASTNode(propertyCallExp);
                if (result == null) result = caseTypedElement(propertyCallExp);
                if (result == null) result = caseVisitable(propertyCallExp);
                if (result == null) result = caseASTNode(propertyCallExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.REAL_LITERAL_EXP: {
                RealLiteralExp<?> realLiteralExp = (RealLiteralExp<?>)theEObject;
                T result = caseRealLiteralExp(realLiteralExp);
                if (result == null) result = caseNumericLiteralExp(realLiteralExp);
                if (result == null) result = casePrimitiveLiteralExp(realLiteralExp);
                if (result == null) result = caseLiteralExp(realLiteralExp);
                if (result == null) result = caseOCLExpression(realLiteralExp);
                if (result == null) result = caseTypedElement(realLiteralExp);
                if (result == null) result = caseVisitable(realLiteralExp);
                if (result == null) result = caseASTNode(realLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.STATE_EXP: {
                StateExp<?, ?> stateExp = (StateExp<?, ?>)theEObject;
                T result = caseStateExp(stateExp);
                if (result == null) result = caseOCLExpression(stateExp);
                if (result == null) result = caseTypedElement(stateExp);
                if (result == null) result = caseVisitable(stateExp);
                if (result == null) result = caseASTNode(stateExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.STRING_LITERAL_EXP: {
                StringLiteralExp<?> stringLiteralExp = (StringLiteralExp<?>)theEObject;
                T result = caseStringLiteralExp(stringLiteralExp);
                if (result == null) result = casePrimitiveLiteralExp(stringLiteralExp);
                if (result == null) result = caseLiteralExp(stringLiteralExp);
                if (result == null) result = caseOCLExpression(stringLiteralExp);
                if (result == null) result = caseTypedElement(stringLiteralExp);
                if (result == null) result = caseVisitable(stringLiteralExp);
                if (result == null) result = caseASTNode(stringLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.TUPLE_LITERAL_EXP: {
                TupleLiteralExp<?, ?> tupleLiteralExp = (TupleLiteralExp<?, ?>)theEObject;
                T result = caseTupleLiteralExp(tupleLiteralExp);
                if (result == null) result = caseLiteralExp(tupleLiteralExp);
                if (result == null) result = caseOCLExpression(tupleLiteralExp);
                if (result == null) result = caseTypedElement(tupleLiteralExp);
                if (result == null) result = caseVisitable(tupleLiteralExp);
                if (result == null) result = caseASTNode(tupleLiteralExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.TUPLE_LITERAL_PART: {
                TupleLiteralPart<?, ?> tupleLiteralPart = (TupleLiteralPart<?, ?>)theEObject;
                T result = caseTupleLiteralPart(tupleLiteralPart);
                if (result == null) result = caseTypedElement(tupleLiteralPart);
                if (result == null) result = caseVisitable(tupleLiteralPart);
                if (result == null) result = caseTypedASTNode(tupleLiteralPart);
                if (result == null) result = caseASTNode(tupleLiteralPart);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.TYPE_EXP: {
                TypeExp<?> typeExp = (TypeExp<?>)theEObject;
                T result = caseTypeExp(typeExp);
                if (result == null) result = caseOCLExpression(typeExp);
                if (result == null) result = caseTypedElement(typeExp);
                if (result == null) result = caseVisitable(typeExp);
                if (result == null) result = caseASTNode(typeExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.UNSPECIFIED_VALUE_EXP: {
                UnspecifiedValueExp<?> unspecifiedValueExp = (UnspecifiedValueExp<?>)theEObject;
                T result = caseUnspecifiedValueExp(unspecifiedValueExp);
                if (result == null) result = caseOCLExpression(unspecifiedValueExp);
                if (result == null) result = caseTypedASTNode(unspecifiedValueExp);
                if (result == null) result = caseTypedElement(unspecifiedValueExp);
                if (result == null) result = caseVisitable(unspecifiedValueExp);
                if (result == null) result = caseASTNode(unspecifiedValueExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.VARIABLE_EXP: {
                VariableExp<?, ?> variableExp = (VariableExp<?, ?>)theEObject;
                T result = caseVariableExp(variableExp);
                if (result == null) result = caseOCLExpression(variableExp);
                if (result == null) result = caseTypedElement(variableExp);
                if (result == null) result = caseVisitable(variableExp);
                if (result == null) result = caseASTNode(variableExp);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, P> T caseAssociationClassCallExp(AssociationClassCallExp<C, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseBooleanLiteralExp(BooleanLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseCallExp(CallExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseCollectionItem(CollectionItem<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseCollectionLiteralExp(CollectionLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseCollectionLiteralPart(CollectionLiteralPart<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseCollectionRange(CollectionRange<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, EL> T caseEnumLiteralExp(EnumLiteralExp<C, EL> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseFeatureCallExp(FeatureCallExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseIfExp(IfExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseIntegerLiteralExp(IntegerLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseInvalidLiteralExp(InvalidLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, PM> T caseIterateExp(IterateExp<C, PM> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, PM> T caseIteratorExp(IteratorExp<C, PM> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, PM> T caseLetExp(LetExp<C, PM> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseLiteralExp(LiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, PM> T caseLoopExp(LoopExp<C, PM> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, COA, SSA> T caseMessageExp(MessageExp<C, COA, SSA> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, P> T caseNavigationCallExp(NavigationCallExp<C, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseNullLiteralExp(NullLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseNumericLiteralExp(NumericLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseOCLExpression(OCLExpression<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseOperationCallExp(OperationCallExp<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T casePrimitiveLiteralExp(PrimitiveLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, P> T casePropertyCallExp(PropertyCallExp<C, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseRealLiteralExp(RealLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>State Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>State Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, S> T caseStateExp(StateExp<C, S> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseStringLiteralExp(StringLiteralExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, P> T caseTupleLiteralExp(TupleLiteralExp<C, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, P> T caseTupleLiteralPart(TupleLiteralPart<C, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseTypeExp(TypeExp<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T caseUnspecifiedValueExp(UnspecifiedValueExp<C> object) {
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
	public <C, PM> T caseVariable(Variable<C, PM> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, PM> T caseVariableExp(VariableExp<C, PM> object) {
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
	public <C> T caseTypedElement(TypedElement<C> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseVisitable(Visitable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseASTNode(ASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCallingASTNode(CallingASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypedASTNode(TypedASTNode object) {
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
