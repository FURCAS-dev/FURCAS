/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: CSTSwitch.java,v 1.2 2006/05/16 15:07:58 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.internal.cst.*;

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
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage
 * @generated
 */
public class CSTSwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTSwitch() {
		if (modelPackage == null) {
			modelPackage = CSTPackage.eINSTANCE;
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
			case CSTPackage.CST_NODE: {
				CSTNode cstNode = (CSTNode)theEObject;
				Object result = caseCSTNode(cstNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PACKAGE_DECLARATION_CS: {
				PackageDeclarationCS packageDeclarationCS = (PackageDeclarationCS)theEObject;
				Object result = casePackageDeclarationCS(packageDeclarationCS);
				if (result == null) result = caseCSTNode(packageDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CONTEXT_DECL_CS: {
				ContextDeclCS contextDeclCS = (ContextDeclCS)theEObject;
				Object result = caseContextDeclCS(contextDeclCS);
				if (result == null) result = caseCSTNode(contextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PROPERTY_CONTEXT_CS: {
				PropertyContextCS propertyContextCS = (PropertyContextCS)theEObject;
				Object result = casePropertyContextCS(propertyContextCS);
				if (result == null) result = caseContextDeclCS(propertyContextCS);
				if (result == null) result = caseCSTNode(propertyContextCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS: {
				ClassifierContextDeclCS classifierContextDeclCS = (ClassifierContextDeclCS)theEObject;
				Object result = caseClassifierContextDeclCS(classifierContextDeclCS);
				if (result == null) result = caseContextDeclCS(classifierContextDeclCS);
				if (result == null) result = caseCSTNode(classifierContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OPERATION_CONTEXT_DECL_CS: {
				OperationContextDeclCS operationContextDeclCS = (OperationContextDeclCS)theEObject;
				Object result = caseOperationContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseCSTNode(operationContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PRE_POST_OR_BODY_DECL_CS: {
				PrePostOrBodyDeclCS prePostOrBodyDeclCS = (PrePostOrBodyDeclCS)theEObject;
				Object result = casePrePostOrBodyDeclCS(prePostOrBodyDeclCS);
				if (result == null) result = caseCSTNode(prePostOrBodyDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OPERATION_CS: {
				OperationCS operationCS = (OperationCS)theEObject;
				Object result = caseOperationCS(operationCS);
				if (result == null) result = caseCSTNode(operationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INIT_OR_DER_VALUE_CS: {
				InitOrDerValueCS initOrDerValueCS = (InitOrDerValueCS)theEObject;
				Object result = caseInitOrDerValueCS(initOrDerValueCS);
				if (result == null) result = caseCSTNode(initOrDerValueCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DER_VALUE_CS: {
				DerValueCS derValueCS = (DerValueCS)theEObject;
				Object result = caseDerValueCS(derValueCS);
				if (result == null) result = caseInitOrDerValueCS(derValueCS);
				if (result == null) result = caseCSTNode(derValueCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INIT_VALUE_CS: {
				InitValueCS initValueCS = (InitValueCS)theEObject;
				Object result = caseInitValueCS(initValueCS);
				if (result == null) result = caseInitOrDerValueCS(initValueCS);
				if (result == null) result = caseCSTNode(initValueCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INV_OR_DEF_CS: {
				InvOrDefCS invOrDefCS = (InvOrDefCS)theEObject;
				Object result = caseInvOrDefCS(invOrDefCS);
				if (result == null) result = caseCSTNode(invOrDefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INV_CS: {
				InvCS invCS = (InvCS)theEObject;
				Object result = caseInvCS(invCS);
				if (result == null) result = caseInvOrDefCS(invCS);
				if (result == null) result = caseCSTNode(invCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DEF_CS: {
				DefCS defCS = (DefCS)theEObject;
				Object result = caseDefCS(defCS);
				if (result == null) result = caseInvOrDefCS(defCS);
				if (result == null) result = caseCSTNode(defCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DEF_EXPRESSION_CS: {
				DefExpressionCS defExpressionCS = (DefExpressionCS)theEObject;
				Object result = caseDefExpressionCS(defExpressionCS);
				if (result == null) result = caseCSTNode(defExpressionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PATH_NAME_CS: {
				PathNameCS pathNameCS = (PathNameCS)theEObject;
				Object result = casePathNameCS(pathNameCS);
				if (result == null) result = caseTypeCS(pathNameCS);
				if (result == null) result = caseOCLExpressionCS(pathNameCS);
				if (result == null) result = caseCSTNode(pathNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.VARIABLE_EXP_CS: {
				VariableExpCS variableExpCS = (VariableExpCS)theEObject;
				Object result = caseVariableExpCS(variableExpCS);
				if (result == null) result = caseOCLExpressionCS(variableExpCS);
				if (result == null) result = caseCSTNode(variableExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SIMPLE_NAME_CS: {
				SimpleNameCS simpleNameCS = (SimpleNameCS)theEObject;
				Object result = caseSimpleNameCS(simpleNameCS);
				if (result == null) result = caseOCLExpressionCS(simpleNameCS);
				if (result == null) result = caseCSTNode(simpleNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TYPE_CS: {
				TypeCS typeCS = (TypeCS)theEObject;
				Object result = caseTypeCS(typeCS);
				if (result == null) result = caseOCLExpressionCS(typeCS);
				if (result == null) result = caseCSTNode(typeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PRIMITIVE_TYPE_CS: {
				PrimitiveTypeCS primitiveTypeCS = (PrimitiveTypeCS)theEObject;
				Object result = casePrimitiveTypeCS(primitiveTypeCS);
				if (result == null) result = caseSimpleNameCS(primitiveTypeCS);
				if (result == null) result = caseTypeCS(primitiveTypeCS);
				if (result == null) result = caseOCLExpressionCS(primitiveTypeCS);
				if (result == null) result = caseCSTNode(primitiveTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TUPLE_TYPE_CS: {
				TupleTypeCS tupleTypeCS = (TupleTypeCS)theEObject;
				Object result = caseTupleTypeCS(tupleTypeCS);
				if (result == null) result = caseTypeCS(tupleTypeCS);
				if (result == null) result = caseOCLExpressionCS(tupleTypeCS);
				if (result == null) result = caseCSTNode(tupleTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.COLLECTION_TYPE_CS: {
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
				Object result = caseCollectionTypeCS(collectionTypeCS);
				if (result == null) result = caseTypeCS(collectionTypeCS);
				if (result == null) result = caseOCLExpressionCS(collectionTypeCS);
				if (result == null) result = caseCSTNode(collectionTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OCL_EXPRESSION_CS: {
				OCLExpressionCS oclExpressionCS = (OCLExpressionCS)theEObject;
				Object result = caseOCLExpressionCS(oclExpressionCS);
				if (result == null) result = caseCSTNode(oclExpressionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LET_EXP_CS: {
				LetExpCS letExpCS = (LetExpCS)theEObject;
				Object result = caseLetExpCS(letExpCS);
				if (result == null) result = caseOCLExpressionCS(letExpCS);
				if (result == null) result = caseCSTNode(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IF_EXP_CS: {
				IfExpCS ifExpCS = (IfExpCS)theEObject;
				Object result = caseIfExpCS(ifExpCS);
				if (result == null) result = caseOCLExpressionCS(ifExpCS);
				if (result == null) result = caseCSTNode(ifExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MESSAGE_EXP_CS: {
				MessageExpCS messageExpCS = (MessageExpCS)theEObject;
				Object result = caseMessageExpCS(messageExpCS);
				if (result == null) result = caseOCLExpressionCS(messageExpCS);
				if (result == null) result = caseCSTNode(messageExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OCL_MESSAGE_ARG_CS: {
				OCLMessageArgCS oclMessageArgCS = (OCLMessageArgCS)theEObject;
				Object result = caseOCLMessageArgCS(oclMessageArgCS);
				if (result == null) result = caseCSTNode(oclMessageArgCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.VARIABLE_CS: {
				VariableCS variableCS = (VariableCS)theEObject;
				Object result = caseVariableCS(variableCS);
				if (result == null) result = caseCSTNode(variableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LITERAL_EXP_CS: {
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				Object result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = caseOCLExpressionCS(literalExpCS);
				if (result == null) result = caseCSTNode(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ENUM_LITERAL_EXP_CS: {
				EnumLiteralExpCS enumLiteralExpCS = (EnumLiteralExpCS)theEObject;
				Object result = caseEnumLiteralExpCS(enumLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(enumLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(enumLiteralExpCS);
				if (result == null) result = caseCSTNode(enumLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.COLLECTION_LITERAL_EXP_CS: {
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				Object result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(collectionLiteralExpCS);
				if (result == null) result = caseCSTNode(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TUPLE_LITERAL_EXP_CS: {
				TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
				Object result = caseTupleLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(tupleLiteralExpCS);
				if (result == null) result = caseCSTNode(tupleLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PRIMITIVE_LITERAL_EXP_CS: {
				PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
				Object result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(primitiveLiteralExpCS);
				if (result == null) result = caseCSTNode(primitiveLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INTEGER_LITERAL_EXP_CS: {
				IntegerLiteralExpCS integerLiteralExpCS = (IntegerLiteralExpCS)theEObject;
				Object result = caseIntegerLiteralExpCS(integerLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(integerLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(integerLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(integerLiteralExpCS);
				if (result == null) result = caseCSTNode(integerLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.REAL_LITERAL_EXP_CS: {
				RealLiteralExpCS realLiteralExpCS = (RealLiteralExpCS)theEObject;
				Object result = caseRealLiteralExpCS(realLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(realLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(realLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(realLiteralExpCS);
				if (result == null) result = caseCSTNode(realLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.STRING_LITERAL_EXP_CS: {
				StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
				Object result = caseStringLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(stringLiteralExpCS);
				if (result == null) result = caseCSTNode(stringLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.BOOLEAN_LITERAL_EXP_CS: {
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				Object result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(booleanLiteralExpCS);
				if (result == null) result = caseCSTNode(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.NULL_LITERAL_EXP_CS: {
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				Object result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(nullLiteralExpCS);
				if (result == null) result = caseCSTNode(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.INVALID_LITERAL_EXP_CS: {
				InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
				Object result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseOCLExpressionCS(invalidLiteralExpCS);
				if (result == null) result = caseCSTNode(invalidLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.COLLECTION_LITERAL_PART_CS: {
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				Object result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = caseCSTNode(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.COLLECTION_RANGE_CS: {
				CollectionRangeCS collectionRangeCS = (CollectionRangeCS)theEObject;
				Object result = caseCollectionRangeCS(collectionRangeCS);
				if (result == null) result = caseCollectionLiteralPartCS(collectionRangeCS);
				if (result == null) result = caseCSTNode(collectionRangeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CALL_EXP_CS: {
				CallExpCS callExpCS = (CallExpCS)theEObject;
				Object result = caseCallExpCS(callExpCS);
				if (result == null) result = caseOCLExpressionCS(callExpCS);
				if (result == null) result = caseCSTNode(callExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LOOP_EXP_CS: {
				LoopExpCS loopExpCS = (LoopExpCS)theEObject;
				Object result = caseLoopExpCS(loopExpCS);
				if (result == null) result = caseCallExpCS(loopExpCS);
				if (result == null) result = caseOCLExpressionCS(loopExpCS);
				if (result == null) result = caseCSTNode(loopExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ITERATOR_EXP_CS: {
				IteratorExpCS iteratorExpCS = (IteratorExpCS)theEObject;
				Object result = caseIteratorExpCS(iteratorExpCS);
				if (result == null) result = caseLoopExpCS(iteratorExpCS);
				if (result == null) result = caseCallExpCS(iteratorExpCS);
				if (result == null) result = caseOCLExpressionCS(iteratorExpCS);
				if (result == null) result = caseCSTNode(iteratorExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ITERATE_EXP_CS: {
				IterateExpCS iterateExpCS = (IterateExpCS)theEObject;
				Object result = caseIterateExpCS(iterateExpCS);
				if (result == null) result = caseLoopExpCS(iterateExpCS);
				if (result == null) result = caseCallExpCS(iterateExpCS);
				if (result == null) result = caseOCLExpressionCS(iterateExpCS);
				if (result == null) result = caseCSTNode(iterateExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.FEATURE_CALL_EXP_CS: {
				FeatureCallExpCS featureCallExpCS = (FeatureCallExpCS)theEObject;
				Object result = caseFeatureCallExpCS(featureCallExpCS);
				if (result == null) result = caseCallExpCS(featureCallExpCS);
				if (result == null) result = caseOCLExpressionCS(featureCallExpCS);
				if (result == null) result = caseCSTNode(featureCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OPERATION_CALL_EXP_CS: {
				OperationCallExpCS operationCallExpCS = (OperationCallExpCS)theEObject;
				Object result = caseOperationCallExpCS(operationCallExpCS);
				if (result == null) result = caseFeatureCallExpCS(operationCallExpCS);
				if (result == null) result = caseCallExpCS(operationCallExpCS);
				if (result == null) result = caseOCLExpressionCS(operationCallExpCS);
				if (result == null) result = caseCSTNode(operationCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IS_MARKED_PRE_CS: {
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)theEObject;
				Object result = caseIsMarkedPreCS(isMarkedPreCS);
				if (result == null) result = caseCSTNode(isMarkedPreCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.STATE_EXP_CS: {
				StateExpCS stateExpCS = (StateExpCS)theEObject;
				Object result = caseStateExpCS(stateExpCS);
				if (result == null) result = caseTypeCS(stateExpCS);
				if (result == null) result = caseOCLExpressionCS(stateExpCS);
				if (result == null) result = caseCSTNode(stateExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCSTNode(CSTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Package Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Package Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePackageDeclarationCS(PackageDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContextDeclCS(ContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Property Context CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Property Context CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyContextCS(PropertyContextCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Classifier Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Classifier Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassifierContextDeclCS(ClassifierContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Operation Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Operation Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationContextDeclCS(OperationContextDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Pre Post Or Body Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Pre Post Or Body Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrePostOrBodyDeclCS(PrePostOrBodyDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationCS(OperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Init Or Der Value CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Init Or Der Value CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInitOrDerValueCS(InitOrDerValueCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Der Value CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Der Value CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDerValueCS(DerValueCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Init Value CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Init Value CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInitValueCS(InitValueCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Inv Or Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Inv Or Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInvOrDefCS(InvOrDefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Inv CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Inv CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInvCS(InvCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Def CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefCS(DefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Def Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Def Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefExpressionCS(DefExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Path Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePathNameCS(PathNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Variable Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Variable Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableExpCS(VariableExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Simple Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Simple Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimpleNameCS(SimpleNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveTypeCS(PrimitiveTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tuple Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tuple Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleTypeCS(TupleTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionTypeCS(CollectionTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>OCL Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>OCL Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOCLExpressionCS(OCLExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Let Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLetExpCS(LetExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>If Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>If Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIfExpCS(IfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Message Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Message Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMessageExpCS(MessageExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>OCL Message Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>OCL Message Arg CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOCLMessageArgCS(OCLMessageArgCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableCS(VariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLiteralExpCS(LiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Enum Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Enum Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumLiteralExpCS(EnumLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralExpCS(CollectionLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleLiteralExpCS(TupleLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Integer Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Integer Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerLiteralExpCS(IntegerLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Real Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Real Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealLiteralExpCS(RealLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringLiteralExpCS(StringLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralPartCS(CollectionLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Range CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Range CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionRangeCS(CollectionRangeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCallExpCS(CallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Loop Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoopExpCS(LoopExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Iterator Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Iterator Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIteratorExpCS(IteratorExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Iterate Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Iterate Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIterateExpCS(IterateExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Feature Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Feature Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFeatureCallExpCS(FeatureCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationCallExpCS(OperationCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Is Marked Pre CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Is Marked Pre CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIsMarkedPreCS(IsMarkedPreCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>State Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>State Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStateExpCS(StateExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNullLiteralExpCS(NullLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
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

} //CSTSwitch
