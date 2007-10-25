/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CSTSwitch.java,v 1.2 2007/10/25 16:00:24 cdamus Exp $
 */
package org.eclipse.ocl.cst.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.cst.*;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DerValueCS;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InitValueCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;

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
 * @see org.eclipse.ocl.cst.CSTPackage
 * @generated
 */
public class CSTSwitch<T> {
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
            case CSTPackage.CST_NODE: {
                CSTNode cstNode = (CSTNode)theEObject;
                T result = caseCSTNode(cstNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.PACKAGE_DECLARATION_CS: {
                PackageDeclarationCS packageDeclarationCS = (PackageDeclarationCS)theEObject;
                T result = casePackageDeclarationCS(packageDeclarationCS);
                if (result == null) result = caseCSTNode(packageDeclarationCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.PATH_NAME_CS: {
                PathNameCS pathNameCS = (PathNameCS)theEObject;
                T result = casePathNameCS(pathNameCS);
                if (result == null) result = caseTypeCS(pathNameCS);
                if (result == null) result = caseOCLExpressionCS(pathNameCS);
                if (result == null) result = caseCSTNode(pathNameCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.TYPE_CS: {
                TypeCS typeCS = (TypeCS)theEObject;
                T result = caseTypeCS(typeCS);
                if (result == null) result = caseOCLExpressionCS(typeCS);
                if (result == null) result = caseCSTNode(typeCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.OCL_EXPRESSION_CS: {
                OCLExpressionCS oclExpressionCS = (OCLExpressionCS)theEObject;
                T result = caseOCLExpressionCS(oclExpressionCS);
                if (result == null) result = caseCSTNode(oclExpressionCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.CONTEXT_DECL_CS: {
                ContextDeclCS contextDeclCS = (ContextDeclCS)theEObject;
                T result = caseContextDeclCS(contextDeclCS);
                if (result == null) result = caseCSTNode(contextDeclCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.PROPERTY_CONTEXT_CS: {
                PropertyContextCS propertyContextCS = (PropertyContextCS)theEObject;
                T result = casePropertyContextCS(propertyContextCS);
                if (result == null) result = caseContextDeclCS(propertyContextCS);
                if (result == null) result = caseCSTNode(propertyContextCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.SIMPLE_NAME_CS: {
                SimpleNameCS simpleNameCS = (SimpleNameCS)theEObject;
                T result = caseSimpleNameCS(simpleNameCS);
                if (result == null) result = caseOCLExpressionCS(simpleNameCS);
                if (result == null) result = caseCSTNode(simpleNameCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.INIT_OR_DER_VALUE_CS: {
                InitOrDerValueCS initOrDerValueCS = (InitOrDerValueCS)theEObject;
                T result = caseInitOrDerValueCS(initOrDerValueCS);
                if (result == null) result = caseCSTNode(initOrDerValueCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS: {
                ClassifierContextDeclCS classifierContextDeclCS = (ClassifierContextDeclCS)theEObject;
                T result = caseClassifierContextDeclCS(classifierContextDeclCS);
                if (result == null) result = caseContextDeclCS(classifierContextDeclCS);
                if (result == null) result = caseCSTNode(classifierContextDeclCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.INV_OR_DEF_CS: {
                InvOrDefCS invOrDefCS = (InvOrDefCS)theEObject;
                T result = caseInvOrDefCS(invOrDefCS);
                if (result == null) result = caseCSTNode(invOrDefCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.OPERATION_CONTEXT_DECL_CS: {
                OperationContextDeclCS operationContextDeclCS = (OperationContextDeclCS)theEObject;
                T result = caseOperationContextDeclCS(operationContextDeclCS);
                if (result == null) result = caseContextDeclCS(operationContextDeclCS);
                if (result == null) result = caseCSTNode(operationContextDeclCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.OPERATION_CS: {
                OperationCS operationCS = (OperationCS)theEObject;
                T result = caseOperationCS(operationCS);
                if (result == null) result = caseCSTNode(operationCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.VARIABLE_CS: {
                VariableCS variableCS = (VariableCS)theEObject;
                T result = caseVariableCS(variableCS);
                if (result == null) result = caseCSTNode(variableCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS: {
                PrePostOrBodyDeclCS prePostOrBodyDeclCS = (PrePostOrBodyDeclCS)theEObject;
                T result = casePrePostOrBodyDeclCS(prePostOrBodyDeclCS);
                if (result == null) result = caseCSTNode(prePostOrBodyDeclCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.DER_VALUE_CS: {
                DerValueCS derValueCS = (DerValueCS)theEObject;
                T result = caseDerValueCS(derValueCS);
                if (result == null) result = caseInitOrDerValueCS(derValueCS);
                if (result == null) result = caseCSTNode(derValueCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.INIT_VALUE_CS: {
                InitValueCS initValueCS = (InitValueCS)theEObject;
                T result = caseInitValueCS(initValueCS);
                if (result == null) result = caseInitOrDerValueCS(initValueCS);
                if (result == null) result = caseCSTNode(initValueCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.INV_CS: {
                InvCS invCS = (InvCS)theEObject;
                T result = caseInvCS(invCS);
                if (result == null) result = caseInvOrDefCS(invCS);
                if (result == null) result = caseCSTNode(invCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.DEF_CS: {
                DefCS defCS = (DefCS)theEObject;
                T result = caseDefCS(defCS);
                if (result == null) result = caseInvOrDefCS(defCS);
                if (result == null) result = caseCSTNode(defCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.DEF_EXPRESSION_CS: {
                DefExpressionCS defExpressionCS = (DefExpressionCS)theEObject;
                T result = caseDefExpressionCS(defExpressionCS);
                if (result == null) result = caseCSTNode(defExpressionCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.VARIABLE_EXP_CS: {
                VariableExpCS variableExpCS = (VariableExpCS)theEObject;
                T result = caseVariableExpCS(variableExpCS);
                if (result == null) result = caseOCLExpressionCS(variableExpCS);
                if (result == null) result = caseCSTNode(variableExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.IS_MARKED_PRE_CS: {
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)theEObject;
                T result = caseIsMarkedPreCS(isMarkedPreCS);
                if (result == null) result = caseCSTNode(isMarkedPreCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.PRIMITIVE_TYPE_CS: {
                PrimitiveTypeCS primitiveTypeCS = (PrimitiveTypeCS)theEObject;
                T result = casePrimitiveTypeCS(primitiveTypeCS);
                if (result == null) result = caseSimpleNameCS(primitiveTypeCS);
                if (result == null) result = caseTypeCS(primitiveTypeCS);
                if (result == null) result = caseOCLExpressionCS(primitiveTypeCS);
                if (result == null) result = caseCSTNode(primitiveTypeCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.TUPLE_TYPE_CS: {
                TupleTypeCS tupleTypeCS = (TupleTypeCS)theEObject;
                T result = caseTupleTypeCS(tupleTypeCS);
                if (result == null) result = caseTypeCS(tupleTypeCS);
                if (result == null) result = caseOCLExpressionCS(tupleTypeCS);
                if (result == null) result = caseCSTNode(tupleTypeCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.COLLECTION_TYPE_CS: {
                CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
                T result = caseCollectionTypeCS(collectionTypeCS);
                if (result == null) result = caseTypeCS(collectionTypeCS);
                if (result == null) result = caseOCLExpressionCS(collectionTypeCS);
                if (result == null) result = caseCSTNode(collectionTypeCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.LET_EXP_CS: {
                LetExpCS letExpCS = (LetExpCS)theEObject;
                T result = caseLetExpCS(letExpCS);
                if (result == null) result = caseOCLExpressionCS(letExpCS);
                if (result == null) result = caseCSTNode(letExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.IF_EXP_CS: {
                IfExpCS ifExpCS = (IfExpCS)theEObject;
                T result = caseIfExpCS(ifExpCS);
                if (result == null) result = caseOCLExpressionCS(ifExpCS);
                if (result == null) result = caseCSTNode(ifExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.MESSAGE_EXP_CS: {
                MessageExpCS messageExpCS = (MessageExpCS)theEObject;
                T result = caseMessageExpCS(messageExpCS);
                if (result == null) result = caseOCLExpressionCS(messageExpCS);
                if (result == null) result = caseCSTNode(messageExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.OCL_MESSAGE_ARG_CS: {
                OCLMessageArgCS oclMessageArgCS = (OCLMessageArgCS)theEObject;
                T result = caseOCLMessageArgCS(oclMessageArgCS);
                if (result == null) result = caseCSTNode(oclMessageArgCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.LITERAL_EXP_CS: {
                LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
                T result = caseLiteralExpCS(literalExpCS);
                if (result == null) result = caseOCLExpressionCS(literalExpCS);
                if (result == null) result = caseCSTNode(literalExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.ENUM_LITERAL_EXP_CS: {
                EnumLiteralExpCS enumLiteralExpCS = (EnumLiteralExpCS)theEObject;
                T result = caseEnumLiteralExpCS(enumLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(enumLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(enumLiteralExpCS);
                if (result == null) result = caseCSTNode(enumLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.COLLECTION_LITERAL_EXP_CS: {
                CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
                T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(collectionLiteralExpCS);
                if (result == null) result = caseCSTNode(collectionLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.COLLECTION_LITERAL_PART_CS: {
                CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
                T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
                if (result == null) result = caseCSTNode(collectionLiteralPartCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.TUPLE_LITERAL_EXP_CS: {
                TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
                T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(tupleLiteralExpCS);
                if (result == null) result = caseCSTNode(tupleLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.PRIMITIVE_LITERAL_EXP_CS: {
                PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
                T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(primitiveLiteralExpCS);
                if (result == null) result = caseCSTNode(primitiveLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.INTEGER_LITERAL_EXP_CS: {
                IntegerLiteralExpCS integerLiteralExpCS = (IntegerLiteralExpCS)theEObject;
                T result = caseIntegerLiteralExpCS(integerLiteralExpCS);
                if (result == null) result = casePrimitiveLiteralExpCS(integerLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(integerLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(integerLiteralExpCS);
                if (result == null) result = caseCSTNode(integerLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS: {
                UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS = (UnlimitedNaturalLiteralExpCS)theEObject;
                T result = caseUnlimitedNaturalLiteralExpCS(unlimitedNaturalLiteralExpCS);
                if (result == null) result = casePrimitiveLiteralExpCS(unlimitedNaturalLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(unlimitedNaturalLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(unlimitedNaturalLiteralExpCS);
                if (result == null) result = caseCSTNode(unlimitedNaturalLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.REAL_LITERAL_EXP_CS: {
                RealLiteralExpCS realLiteralExpCS = (RealLiteralExpCS)theEObject;
                T result = caseRealLiteralExpCS(realLiteralExpCS);
                if (result == null) result = casePrimitiveLiteralExpCS(realLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(realLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(realLiteralExpCS);
                if (result == null) result = caseCSTNode(realLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.STRING_LITERAL_EXP_CS: {
                StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
                T result = caseStringLiteralExpCS(stringLiteralExpCS);
                if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(stringLiteralExpCS);
                if (result == null) result = caseCSTNode(stringLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.BOOLEAN_LITERAL_EXP_CS: {
                BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
                T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
                if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(booleanLiteralExpCS);
                if (result == null) result = caseCSTNode(booleanLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.NULL_LITERAL_EXP_CS: {
                NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
                T result = caseNullLiteralExpCS(nullLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(nullLiteralExpCS);
                if (result == null) result = caseCSTNode(nullLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.INVALID_LITERAL_EXP_CS: {
                InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
                T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
                if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
                if (result == null) result = caseOCLExpressionCS(invalidLiteralExpCS);
                if (result == null) result = caseCSTNode(invalidLiteralExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.COLLECTION_RANGE_CS: {
                CollectionRangeCS collectionRangeCS = (CollectionRangeCS)theEObject;
                T result = caseCollectionRangeCS(collectionRangeCS);
                if (result == null) result = caseCollectionLiteralPartCS(collectionRangeCS);
                if (result == null) result = caseCSTNode(collectionRangeCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.CALL_EXP_CS: {
                CallExpCS callExpCS = (CallExpCS)theEObject;
                T result = caseCallExpCS(callExpCS);
                if (result == null) result = caseOCLExpressionCS(callExpCS);
                if (result == null) result = caseCSTNode(callExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.LOOP_EXP_CS: {
                LoopExpCS loopExpCS = (LoopExpCS)theEObject;
                T result = caseLoopExpCS(loopExpCS);
                if (result == null) result = caseCallExpCS(loopExpCS);
                if (result == null) result = caseOCLExpressionCS(loopExpCS);
                if (result == null) result = caseCSTNode(loopExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.ITERATOR_EXP_CS: {
                IteratorExpCS iteratorExpCS = (IteratorExpCS)theEObject;
                T result = caseIteratorExpCS(iteratorExpCS);
                if (result == null) result = caseLoopExpCS(iteratorExpCS);
                if (result == null) result = caseCallExpCS(iteratorExpCS);
                if (result == null) result = caseOCLExpressionCS(iteratorExpCS);
                if (result == null) result = caseCSTNode(iteratorExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.ITERATE_EXP_CS: {
                IterateExpCS iterateExpCS = (IterateExpCS)theEObject;
                T result = caseIterateExpCS(iterateExpCS);
                if (result == null) result = caseLoopExpCS(iterateExpCS);
                if (result == null) result = caseCallExpCS(iterateExpCS);
                if (result == null) result = caseOCLExpressionCS(iterateExpCS);
                if (result == null) result = caseCSTNode(iterateExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.FEATURE_CALL_EXP_CS: {
                FeatureCallExpCS featureCallExpCS = (FeatureCallExpCS)theEObject;
                T result = caseFeatureCallExpCS(featureCallExpCS);
                if (result == null) result = caseCallExpCS(featureCallExpCS);
                if (result == null) result = caseOCLExpressionCS(featureCallExpCS);
                if (result == null) result = caseCSTNode(featureCallExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.OPERATION_CALL_EXP_CS: {
                OperationCallExpCS operationCallExpCS = (OperationCallExpCS)theEObject;
                T result = caseOperationCallExpCS(operationCallExpCS);
                if (result == null) result = caseFeatureCallExpCS(operationCallExpCS);
                if (result == null) result = caseCallExpCS(operationCallExpCS);
                if (result == null) result = caseOCLExpressionCS(operationCallExpCS);
                if (result == null) result = caseCSTNode(operationCallExpCS);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CSTPackage.STATE_EXP_CS: {
                StateExpCS stateExpCS = (StateExpCS)theEObject;
                T result = caseStateExpCS(stateExpCS);
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
     * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCSTNode(CSTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Package Declaration CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Package Declaration CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePackageDeclarationCS(PackageDeclarationCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Context Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Context Decl CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseContextDeclCS(ContextDeclCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Property Context CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property Context CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePropertyContextCS(PropertyContextCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseClassifierContextDeclCS(ClassifierContextDeclCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOperationContextDeclCS(OperationContextDeclCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Pre Post Or Body Decl CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pre Post Or Body Decl CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePrePostOrBodyDeclCS(PrePostOrBodyDeclCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Operation CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOperationCS(OperationCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Init Or Der Value CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Init Or Der Value CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInitOrDerValueCS(InitOrDerValueCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Der Value CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Der Value CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDerValueCS(DerValueCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Init Value CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Init Value CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInitValueCS(InitValueCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Inv Or Def CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Inv Or Def CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInvOrDefCS(InvOrDefCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Inv CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Inv CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInvCS(InvCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Def CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Def CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDefCS(DefCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Def Expression CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Def Expression CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDefExpressionCS(DefExpressionCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePathNameCS(PathNameCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Variable Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseVariableExpCS(VariableExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Simple Name CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Name CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimpleNameCS(SimpleNameCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Type CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypeCS(TypeCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Type CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Type CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePrimitiveTypeCS(PrimitiveTypeCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Type CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Type CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTupleTypeCS(TupleTypeCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCollectionTypeCS(CollectionTypeCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOCLExpressionCS(OCLExpressionCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLetExpCS(LetExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIfExpCS(IfExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Message Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMessageExpCS(MessageExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>OCL Message Arg CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>OCL Message Arg CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOCLMessageArgCS(OCLMessageArgCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Variable CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseVariableCS(VariableCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLiteralExpCS(LiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEnumLiteralExpCS(EnumLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTupleLiteralExpCS(TupleLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIntegerLiteralExpCS(IntegerLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Real Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRealLiteralExpCS(RealLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStringLiteralExpCS(StringLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Range CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Range CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCollectionRangeCS(CollectionRangeCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCallExpCS(CallExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLoopExpCS(LoopExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Iterator Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterator Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIteratorExpCS(IteratorExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Iterate Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterate Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIterateExpCS(IterateExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature Call Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFeatureCallExpCS(FeatureCallExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOperationCallExpCS(OperationCallExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Is Marked Pre CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Is Marked Pre CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIsMarkedPreCS(IsMarkedPreCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>State Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>State Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStateExpCS(StateExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNullLiteralExpCS(NullLiteralExpCS object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
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

} //CSTSwitch
