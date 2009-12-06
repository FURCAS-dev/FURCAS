/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: UMLSwitch.java,v 1.10 2009/12/06 18:26:13 ewillink Exp $
 */
package org.eclipse.ocl.uml.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.uml.*;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.Visitable;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.ValueSpecification;

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
 * @see org.eclipse.ocl.uml.UMLPackage
 * @generated
 */
public class UMLSwitch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLSwitch() {
		if (modelPackage == null) {
			modelPackage = UMLPackage.eINSTANCE;
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
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty()
				? defaultCase(theEObject)
				: doSwitch(eSuperTypes.get(0), theEObject);
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
			case UMLPackage.ANY_TYPE : {
				AnyType anyType = (AnyType) theEObject;
				T result = caseAnyType(anyType);
				if (result == null)
					result = caseClassifier(anyType);
				if (result == null)
					result = caseTypes_AnyType(anyType);
				if (result == null)
					result = caseNamespace(anyType);
				if (result == null)
					result = caseRedefinableElement(anyType);
				if (result == null)
					result = caseType(anyType);
				if (result == null)
					result = caseTemplateableElement(anyType);
				if (result == null)
					result = casePredefinedType(anyType);
				if (result == null)
					result = casePackageableElement(anyType);
				if (result == null)
					result = caseNamedElement(anyType);
				if (result == null)
					result = caseParameterableElement(anyType);
				if (result == null)
					result = caseElement(anyType);
				if (result == null)
					result = caseEModelElement(anyType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.VOID_TYPE : {
				VoidType voidType = (VoidType) theEObject;
				T result = caseVoidType(voidType);
				if (result == null)
					result = caseClassifier(voidType);
				if (result == null)
					result = caseTypes_VoidType(voidType);
				if (result == null)
					result = caseNamespace(voidType);
				if (result == null)
					result = caseRedefinableElement(voidType);
				if (result == null)
					result = caseType(voidType);
				if (result == null)
					result = caseTemplateableElement(voidType);
				if (result == null)
					result = casePredefinedType(voidType);
				if (result == null)
					result = casePackageableElement(voidType);
				if (result == null)
					result = caseNamedElement(voidType);
				if (result == null)
					result = caseParameterableElement(voidType);
				if (result == null)
					result = caseElement(voidType);
				if (result == null)
					result = caseEModelElement(voidType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.INVALID_TYPE : {
				InvalidType invalidType = (InvalidType) theEObject;
				T result = caseInvalidType(invalidType);
				if (result == null)
					result = caseClassifier(invalidType);
				if (result == null)
					result = caseTypes_InvalidType(invalidType);
				if (result == null)
					result = caseNamespace(invalidType);
				if (result == null)
					result = caseRedefinableElement(invalidType);
				if (result == null)
					result = caseType(invalidType);
				if (result == null)
					result = caseTemplateableElement(invalidType);
				if (result == null)
					result = casePredefinedType(invalidType);
				if (result == null)
					result = casePackageableElement(invalidType);
				if (result == null)
					result = caseNamedElement(invalidType);
				if (result == null)
					result = caseParameterableElement(invalidType);
				if (result == null)
					result = caseElement(invalidType);
				if (result == null)
					result = caseEModelElement(invalidType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.ELEMENT_TYPE : {
				ElementType elementType = (ElementType) theEObject;
				T result = caseElementType(elementType);
				if (result == null)
					result = caseClassifier(elementType);
				if (result == null)
					result = caseTypes_ElementType(elementType);
				if (result == null)
					result = caseNamespace(elementType);
				if (result == null)
					result = caseRedefinableElement(elementType);
				if (result == null)
					result = caseType(elementType);
				if (result == null)
					result = caseTemplateableElement(elementType);
				if (result == null)
					result = casePackageableElement(elementType);
				if (result == null)
					result = caseNamedElement(elementType);
				if (result == null)
					result = caseParameterableElement(elementType);
				if (result == null)
					result = caseElement(elementType);
				if (result == null)
					result = caseEModelElement(elementType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.TYPE_TYPE : {
				TypeType typeType = (TypeType) theEObject;
				T result = caseTypeType(typeType);
				if (result == null)
					result = caseClassifier(typeType);
				if (result == null)
					result = caseTypes_TypeType(typeType);
				if (result == null)
					result = caseNamespace(typeType);
				if (result == null)
					result = caseRedefinableElement(typeType);
				if (result == null)
					result = caseType(typeType);
				if (result == null)
					result = caseTemplateableElement(typeType);
				if (result == null)
					result = casePredefinedType(typeType);
				if (result == null)
					result = casePackageableElement(typeType);
				if (result == null)
					result = caseNamedElement(typeType);
				if (result == null)
					result = caseParameterableElement(typeType);
				if (result == null)
					result = caseElement(typeType);
				if (result == null)
					result = caseEModelElement(typeType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.MESSAGE_TYPE : {
				MessageType messageType = (MessageType) theEObject;
				T result = caseMessageType(messageType);
				if (result == null)
					result = caseClassifier(messageType);
				if (result == null)
					result = caseTypes_MessageType(messageType);
				if (result == null)
					result = caseNamespace(messageType);
				if (result == null)
					result = caseRedefinableElement(messageType);
				if (result == null)
					result = caseType(messageType);
				if (result == null)
					result = caseTemplateableElement(messageType);
				if (result == null)
					result = casePredefinedType(messageType);
				if (result == null)
					result = casePackageableElement(messageType);
				if (result == null)
					result = caseNamedElement(messageType);
				if (result == null)
					result = caseParameterableElement(messageType);
				if (result == null)
					result = caseElement(messageType);
				if (result == null)
					result = caseEModelElement(messageType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.PRIMITIVE_TYPE : {
				PrimitiveType primitiveType = (PrimitiveType) theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null)
					result = caseUML_PrimitiveType(primitiveType);
				if (result == null)
					result = caseTypes_PrimitiveType(primitiveType);
				if (result == null)
					result = caseDataType(primitiveType);
				if (result == null)
					result = casePredefinedType(primitiveType);
				if (result == null)
					result = caseClassifier(primitiveType);
				if (result == null)
					result = caseNamespace(primitiveType);
				if (result == null)
					result = caseRedefinableElement(primitiveType);
				if (result == null)
					result = caseType(primitiveType);
				if (result == null)
					result = caseTemplateableElement(primitiveType);
				if (result == null)
					result = casePackageableElement(primitiveType);
				if (result == null)
					result = caseNamedElement(primitiveType);
				if (result == null)
					result = caseParameterableElement(primitiveType);
				if (result == null)
					result = caseElement(primitiveType);
				if (result == null)
					result = caseEModelElement(primitiveType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.COLLECTION_TYPE : {
				CollectionType collectionType = (CollectionType) theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null)
					result = caseDataType(collectionType);
				if (result == null)
					result = caseTypes_CollectionType(collectionType);
				if (result == null)
					result = caseClassifier(collectionType);
				if (result == null)
					result = casePredefinedType(collectionType);
				if (result == null)
					result = caseTypedASTNode(collectionType);
				if (result == null)
					result = caseNamespace(collectionType);
				if (result == null)
					result = caseRedefinableElement(collectionType);
				if (result == null)
					result = caseType(collectionType);
				if (result == null)
					result = caseTemplateableElement(collectionType);
				if (result == null)
					result = caseASTNode(collectionType);
				if (result == null)
					result = casePackageableElement(collectionType);
				if (result == null)
					result = caseNamedElement(collectionType);
				if (result == null)
					result = caseParameterableElement(collectionType);
				if (result == null)
					result = caseElement(collectionType);
				if (result == null)
					result = caseEModelElement(collectionType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.TUPLE_TYPE : {
				TupleType tupleType = (TupleType) theEObject;
				T result = caseTupleType(tupleType);
				if (result == null)
					result = caseDataType(tupleType);
				if (result == null)
					result = caseTypes_TupleType(tupleType);
				if (result == null)
					result = caseClassifier(tupleType);
				if (result == null)
					result = casePredefinedType(tupleType);
				if (result == null)
					result = caseNamespace(tupleType);
				if (result == null)
					result = caseRedefinableElement(tupleType);
				if (result == null)
					result = caseType(tupleType);
				if (result == null)
					result = caseTemplateableElement(tupleType);
				if (result == null)
					result = casePackageableElement(tupleType);
				if (result == null)
					result = caseNamedElement(tupleType);
				if (result == null)
					result = caseParameterableElement(tupleType);
				if (result == null)
					result = caseElement(tupleType);
				if (result == null)
					result = caseEModelElement(tupleType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.BAG_TYPE : {
				BagType bagType = (BagType) theEObject;
				T result = caseBagType(bagType);
				if (result == null)
					result = caseCollectionType(bagType);
				if (result == null)
					result = caseTypes_BagType(bagType);
				if (result == null)
					result = caseDataType(bagType);
				if (result == null)
					result = caseTypes_CollectionType(bagType);
				if (result == null)
					result = caseClassifier(bagType);
				if (result == null)
					result = casePredefinedType(bagType);
				if (result == null)
					result = caseTypedASTNode(bagType);
				if (result == null)
					result = caseNamespace(bagType);
				if (result == null)
					result = caseRedefinableElement(bagType);
				if (result == null)
					result = caseType(bagType);
				if (result == null)
					result = caseTemplateableElement(bagType);
				if (result == null)
					result = caseASTNode(bagType);
				if (result == null)
					result = casePackageableElement(bagType);
				if (result == null)
					result = caseNamedElement(bagType);
				if (result == null)
					result = caseParameterableElement(bagType);
				if (result == null)
					result = caseElement(bagType);
				if (result == null)
					result = caseEModelElement(bagType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.SET_TYPE : {
				SetType setType = (SetType) theEObject;
				T result = caseSetType(setType);
				if (result == null)
					result = caseCollectionType(setType);
				if (result == null)
					result = caseTypes_SetType(setType);
				if (result == null)
					result = caseDataType(setType);
				if (result == null)
					result = caseTypes_CollectionType(setType);
				if (result == null)
					result = caseClassifier(setType);
				if (result == null)
					result = casePredefinedType(setType);
				if (result == null)
					result = caseTypedASTNode(setType);
				if (result == null)
					result = caseNamespace(setType);
				if (result == null)
					result = caseRedefinableElement(setType);
				if (result == null)
					result = caseType(setType);
				if (result == null)
					result = caseTemplateableElement(setType);
				if (result == null)
					result = caseASTNode(setType);
				if (result == null)
					result = casePackageableElement(setType);
				if (result == null)
					result = caseNamedElement(setType);
				if (result == null)
					result = caseParameterableElement(setType);
				if (result == null)
					result = caseElement(setType);
				if (result == null)
					result = caseEModelElement(setType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.ORDERED_SET_TYPE : {
				OrderedSetType orderedSetType = (OrderedSetType) theEObject;
				T result = caseOrderedSetType(orderedSetType);
				if (result == null)
					result = caseCollectionType(orderedSetType);
				if (result == null)
					result = caseTypes_OrderedSetType(orderedSetType);
				if (result == null)
					result = caseDataType(orderedSetType);
				if (result == null)
					result = caseTypes_CollectionType(orderedSetType);
				if (result == null)
					result = caseClassifier(orderedSetType);
				if (result == null)
					result = casePredefinedType(orderedSetType);
				if (result == null)
					result = caseTypedASTNode(orderedSetType);
				if (result == null)
					result = caseNamespace(orderedSetType);
				if (result == null)
					result = caseRedefinableElement(orderedSetType);
				if (result == null)
					result = caseType(orderedSetType);
				if (result == null)
					result = caseTemplateableElement(orderedSetType);
				if (result == null)
					result = caseASTNode(orderedSetType);
				if (result == null)
					result = casePackageableElement(orderedSetType);
				if (result == null)
					result = caseNamedElement(orderedSetType);
				if (result == null)
					result = caseParameterableElement(orderedSetType);
				if (result == null)
					result = caseElement(orderedSetType);
				if (result == null)
					result = caseEModelElement(orderedSetType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.SEQUENCE_TYPE : {
				SequenceType sequenceType = (SequenceType) theEObject;
				T result = caseSequenceType(sequenceType);
				if (result == null)
					result = caseCollectionType(sequenceType);
				if (result == null)
					result = caseTypes_SequenceType(sequenceType);
				if (result == null)
					result = caseDataType(sequenceType);
				if (result == null)
					result = caseTypes_CollectionType(sequenceType);
				if (result == null)
					result = caseClassifier(sequenceType);
				if (result == null)
					result = casePredefinedType(sequenceType);
				if (result == null)
					result = caseTypedASTNode(sequenceType);
				if (result == null)
					result = caseNamespace(sequenceType);
				if (result == null)
					result = caseRedefinableElement(sequenceType);
				if (result == null)
					result = caseType(sequenceType);
				if (result == null)
					result = caseTemplateableElement(sequenceType);
				if (result == null)
					result = caseASTNode(sequenceType);
				if (result == null)
					result = casePackageableElement(sequenceType);
				if (result == null)
					result = caseNamedElement(sequenceType);
				if (result == null)
					result = caseParameterableElement(sequenceType);
				if (result == null)
					result = caseElement(sequenceType);
				if (result == null)
					result = caseEModelElement(sequenceType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.EXPRESSION_IN_OCL : {
				ExpressionInOCL expressionInOCL = (ExpressionInOCL) theEObject;
				T result = caseExpressionInOCL(expressionInOCL);
				if (result == null)
					result = caseOpaqueExpression(expressionInOCL);
				if (result == null)
					result = caseUtilities_ExpressionInOCL(expressionInOCL);
				if (result == null)
					result = caseValueSpecification(expressionInOCL);
				if (result == null)
					result = caseVisitable(expressionInOCL);
				if (result == null)
					result = casePackageableElement(expressionInOCL);
				if (result == null)
					result = caseTypedElement(expressionInOCL);
				if (result == null)
					result = caseNamedElement(expressionInOCL);
				if (result == null)
					result = caseParameterableElement(expressionInOCL);
				if (result == null)
					result = caseElement(expressionInOCL);
				if (result == null)
					result = caseEModelElement(expressionInOCL);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.ASSOCIATION_CLASS_CALL_EXP : {
				AssociationClassCallExp associationClassCallExp = (AssociationClassCallExp) theEObject;
				T result = caseAssociationClassCallExp(associationClassCallExp);
				if (result == null)
					result = caseNavigationCallExp(associationClassCallExp);
				if (result == null)
					result = caseExpressions_AssociationClassCallExp(associationClassCallExp);
				if (result == null)
					result = caseFeatureCallExp(associationClassCallExp);
				if (result == null)
					result = caseExpressions_NavigationCallExp(associationClassCallExp);
				if (result == null)
					result = caseCallExp(associationClassCallExp);
				if (result == null)
					result = caseExpressions_FeatureCallExp(associationClassCallExp);
				if (result == null)
					result = caseOCLExpression(associationClassCallExp);
				if (result == null)
					result = caseExpressions_CallExp(associationClassCallExp);
				if (result == null)
					result = caseTypedElement(associationClassCallExp);
				if (result == null)
					result = caseExpressions_OCLExpression(associationClassCallExp);
				if (result == null)
					result = caseCallingASTNode(associationClassCallExp);
				if (result == null)
					result = caseNamedElement(associationClassCallExp);
				if (result == null)
					result = caseUtilities_TypedElement(associationClassCallExp);
				if (result == null)
					result = caseVisitable(associationClassCallExp);
				if (result == null)
					result = caseASTNode(associationClassCallExp);
				if (result == null)
					result = caseElement(associationClassCallExp);
				if (result == null)
					result = caseEModelElement(associationClassCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.NAVIGATION_CALL_EXP : {
				NavigationCallExp navigationCallExp = (NavigationCallExp) theEObject;
				T result = caseNavigationCallExp(navigationCallExp);
				if (result == null)
					result = caseFeatureCallExp(navigationCallExp);
				if (result == null)
					result = caseExpressions_NavigationCallExp(navigationCallExp);
				if (result == null)
					result = caseCallExp(navigationCallExp);
				if (result == null)
					result = caseExpressions_FeatureCallExp(navigationCallExp);
				if (result == null)
					result = caseOCLExpression(navigationCallExp);
				if (result == null)
					result = caseExpressions_CallExp(navigationCallExp);
				if (result == null)
					result = caseTypedElement(navigationCallExp);
				if (result == null)
					result = caseExpressions_OCLExpression(navigationCallExp);
				if (result == null)
					result = caseCallingASTNode(navigationCallExp);
				if (result == null)
					result = caseNamedElement(navigationCallExp);
				if (result == null)
					result = caseUtilities_TypedElement(navigationCallExp);
				if (result == null)
					result = caseVisitable(navigationCallExp);
				if (result == null)
					result = caseASTNode(navigationCallExp);
				if (result == null)
					result = caseElement(navigationCallExp);
				if (result == null)
					result = caseEModelElement(navigationCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.FEATURE_CALL_EXP : {
				FeatureCallExp featureCallExp = (FeatureCallExp) theEObject;
				T result = caseFeatureCallExp(featureCallExp);
				if (result == null)
					result = caseCallExp(featureCallExp);
				if (result == null)
					result = caseExpressions_FeatureCallExp(featureCallExp);
				if (result == null)
					result = caseOCLExpression(featureCallExp);
				if (result == null)
					result = caseExpressions_CallExp(featureCallExp);
				if (result == null)
					result = caseTypedElement(featureCallExp);
				if (result == null)
					result = caseExpressions_OCLExpression(featureCallExp);
				if (result == null)
					result = caseCallingASTNode(featureCallExp);
				if (result == null)
					result = caseNamedElement(featureCallExp);
				if (result == null)
					result = caseUtilities_TypedElement(featureCallExp);
				if (result == null)
					result = caseVisitable(featureCallExp);
				if (result == null)
					result = caseASTNode(featureCallExp);
				if (result == null)
					result = caseElement(featureCallExp);
				if (result == null)
					result = caseEModelElement(featureCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.CALL_EXP : {
				CallExp callExp = (CallExp) theEObject;
				T result = caseCallExp(callExp);
				if (result == null)
					result = caseOCLExpression(callExp);
				if (result == null)
					result = caseExpressions_CallExp(callExp);
				if (result == null)
					result = caseTypedElement(callExp);
				if (result == null)
					result = caseExpressions_OCLExpression(callExp);
				if (result == null)
					result = caseCallingASTNode(callExp);
				if (result == null)
					result = caseNamedElement(callExp);
				if (result == null)
					result = caseUtilities_TypedElement(callExp);
				if (result == null)
					result = caseVisitable(callExp);
				if (result == null)
					result = caseASTNode(callExp);
				if (result == null)
					result = caseElement(callExp);
				if (result == null)
					result = caseEModelElement(callExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.OCL_EXPRESSION : {
				OCLExpression oclExpression = (OCLExpression) theEObject;
				T result = caseOCLExpression(oclExpression);
				if (result == null)
					result = caseTypedElement(oclExpression);
				if (result == null)
					result = caseExpressions_OCLExpression(oclExpression);
				if (result == null)
					result = caseNamedElement(oclExpression);
				if (result == null)
					result = caseUtilities_TypedElement(oclExpression);
				if (result == null)
					result = caseVisitable(oclExpression);
				if (result == null)
					result = caseASTNode(oclExpression);
				if (result == null)
					result = caseElement(oclExpression);
				if (result == null)
					result = caseEModelElement(oclExpression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.BOOLEAN_LITERAL_EXP : {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp) theEObject;
				T result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null)
					result = casePrimitiveLiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseExpressions_BooleanLiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseLiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseOCLExpression(booleanLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(booleanLiteralExp);
				if (result == null)
					result = caseTypedElement(booleanLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(booleanLiteralExp);
				if (result == null)
					result = caseNamedElement(booleanLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(booleanLiteralExp);
				if (result == null)
					result = caseVisitable(booleanLiteralExp);
				if (result == null)
					result = caseASTNode(booleanLiteralExp);
				if (result == null)
					result = caseElement(booleanLiteralExp);
				if (result == null)
					result = caseEModelElement(booleanLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.PRIMITIVE_LITERAL_EXP : {
				PrimitiveLiteralExp primitiveLiteralExp = (PrimitiveLiteralExp) theEObject;
				T result = casePrimitiveLiteralExp(primitiveLiteralExp);
				if (result == null)
					result = caseLiteralExp(primitiveLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(primitiveLiteralExp);
				if (result == null)
					result = caseOCLExpression(primitiveLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(primitiveLiteralExp);
				if (result == null)
					result = caseTypedElement(primitiveLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(primitiveLiteralExp);
				if (result == null)
					result = caseNamedElement(primitiveLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(primitiveLiteralExp);
				if (result == null)
					result = caseVisitable(primitiveLiteralExp);
				if (result == null)
					result = caseASTNode(primitiveLiteralExp);
				if (result == null)
					result = caseElement(primitiveLiteralExp);
				if (result == null)
					result = caseEModelElement(primitiveLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.LITERAL_EXP : {
				LiteralExp literalExp = (LiteralExp) theEObject;
				T result = caseLiteralExp(literalExp);
				if (result == null)
					result = caseOCLExpression(literalExp);
				if (result == null)
					result = caseExpressions_LiteralExp(literalExp);
				if (result == null)
					result = caseTypedElement(literalExp);
				if (result == null)
					result = caseExpressions_OCLExpression(literalExp);
				if (result == null)
					result = caseNamedElement(literalExp);
				if (result == null)
					result = caseUtilities_TypedElement(literalExp);
				if (result == null)
					result = caseVisitable(literalExp);
				if (result == null)
					result = caseASTNode(literalExp);
				if (result == null)
					result = caseElement(literalExp);
				if (result == null)
					result = caseEModelElement(literalExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.COLLECTION_ITEM : {
				CollectionItem collectionItem = (CollectionItem) theEObject;
				T result = caseCollectionItem(collectionItem);
				if (result == null)
					result = caseCollectionLiteralPart(collectionItem);
				if (result == null)
					result = caseExpressions_CollectionItem(collectionItem);
				if (result == null)
					result = caseTypedElement(collectionItem);
				if (result == null)
					result = caseExpressions_CollectionLiteralPart(collectionItem);
				if (result == null)
					result = caseNamedElement(collectionItem);
				if (result == null)
					result = caseUtilities_TypedElement(collectionItem);
				if (result == null)
					result = caseVisitable(collectionItem);
				if (result == null)
					result = caseElement(collectionItem);
				if (result == null)
					result = caseEModelElement(collectionItem);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.COLLECTION_LITERAL_PART : {
				CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart) theEObject;
				T result = caseCollectionLiteralPart(collectionLiteralPart);
				if (result == null)
					result = caseTypedElement(collectionLiteralPart);
				if (result == null)
					result = caseExpressions_CollectionLiteralPart(collectionLiteralPart);
				if (result == null)
					result = caseNamedElement(collectionLiteralPart);
				if (result == null)
					result = caseUtilities_TypedElement(collectionLiteralPart);
				if (result == null)
					result = caseVisitable(collectionLiteralPart);
				if (result == null)
					result = caseElement(collectionLiteralPart);
				if (result == null)
					result = caseEModelElement(collectionLiteralPart);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.COLLECTION_LITERAL_EXP : {
				CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp) theEObject;
				T result = caseCollectionLiteralExp(collectionLiteralExp);
				if (result == null)
					result = caseLiteralExp(collectionLiteralExp);
				if (result == null)
					result = caseExpressions_CollectionLiteralExp(collectionLiteralExp);
				if (result == null)
					result = caseOCLExpression(collectionLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(collectionLiteralExp);
				if (result == null)
					result = caseTypedElement(collectionLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(collectionLiteralExp);
				if (result == null)
					result = caseNamedElement(collectionLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(collectionLiteralExp);
				if (result == null)
					result = caseVisitable(collectionLiteralExp);
				if (result == null)
					result = caseASTNode(collectionLiteralExp);
				if (result == null)
					result = caseElement(collectionLiteralExp);
				if (result == null)
					result = caseEModelElement(collectionLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.COLLECTION_RANGE : {
				CollectionRange collectionRange = (CollectionRange) theEObject;
				T result = caseCollectionRange(collectionRange);
				if (result == null)
					result = caseCollectionLiteralPart(collectionRange);
				if (result == null)
					result = caseExpressions_CollectionRange(collectionRange);
				if (result == null)
					result = caseTypedElement(collectionRange);
				if (result == null)
					result = caseExpressions_CollectionLiteralPart(collectionRange);
				if (result == null)
					result = caseNamedElement(collectionRange);
				if (result == null)
					result = caseUtilities_TypedElement(collectionRange);
				if (result == null)
					result = caseVisitable(collectionRange);
				if (result == null)
					result = caseElement(collectionRange);
				if (result == null)
					result = caseEModelElement(collectionRange);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.ENUM_LITERAL_EXP : {
				EnumLiteralExp enumLiteralExp = (EnumLiteralExp) theEObject;
				T result = caseEnumLiteralExp(enumLiteralExp);
				if (result == null)
					result = caseLiteralExp(enumLiteralExp);
				if (result == null)
					result = caseExpressions_EnumLiteralExp(enumLiteralExp);
				if (result == null)
					result = caseOCLExpression(enumLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(enumLiteralExp);
				if (result == null)
					result = caseTypedElement(enumLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(enumLiteralExp);
				if (result == null)
					result = caseNamedElement(enumLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(enumLiteralExp);
				if (result == null)
					result = caseVisitable(enumLiteralExp);
				if (result == null)
					result = caseASTNode(enumLiteralExp);
				if (result == null)
					result = caseElement(enumLiteralExp);
				if (result == null)
					result = caseEModelElement(enumLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.IF_EXP : {
				IfExp ifExp = (IfExp) theEObject;
				T result = caseIfExp(ifExp);
				if (result == null)
					result = caseOCLExpression(ifExp);
				if (result == null)
					result = caseExpressions_IfExp(ifExp);
				if (result == null)
					result = caseTypedElement(ifExp);
				if (result == null)
					result = caseExpressions_OCLExpression(ifExp);
				if (result == null)
					result = caseNamedElement(ifExp);
				if (result == null)
					result = caseUtilities_TypedElement(ifExp);
				if (result == null)
					result = caseVisitable(ifExp);
				if (result == null)
					result = caseASTNode(ifExp);
				if (result == null)
					result = caseElement(ifExp);
				if (result == null)
					result = caseEModelElement(ifExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.INTEGER_LITERAL_EXP : {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp) theEObject;
				T result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseNumericLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseExpressions_IntegerLiteralExp(integerLiteralExp);
				if (result == null)
					result = casePrimitiveLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseExpressions_NumericLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(integerLiteralExp);
				if (result == null)
					result = caseOCLExpression(integerLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(integerLiteralExp);
				if (result == null)
					result = caseTypedElement(integerLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(integerLiteralExp);
				if (result == null)
					result = caseNamedElement(integerLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(integerLiteralExp);
				if (result == null)
					result = caseVisitable(integerLiteralExp);
				if (result == null)
					result = caseASTNode(integerLiteralExp);
				if (result == null)
					result = caseElement(integerLiteralExp);
				if (result == null)
					result = caseEModelElement(integerLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.NUMERIC_LITERAL_EXP : {
				NumericLiteralExp numericLiteralExp = (NumericLiteralExp) theEObject;
				T result = caseNumericLiteralExp(numericLiteralExp);
				if (result == null)
					result = casePrimitiveLiteralExp(numericLiteralExp);
				if (result == null)
					result = caseExpressions_NumericLiteralExp(numericLiteralExp);
				if (result == null)
					result = caseLiteralExp(numericLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(numericLiteralExp);
				if (result == null)
					result = caseOCLExpression(numericLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(numericLiteralExp);
				if (result == null)
					result = caseTypedElement(numericLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(numericLiteralExp);
				if (result == null)
					result = caseNamedElement(numericLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(numericLiteralExp);
				if (result == null)
					result = caseVisitable(numericLiteralExp);
				if (result == null)
					result = caseASTNode(numericLiteralExp);
				if (result == null)
					result = caseElement(numericLiteralExp);
				if (result == null)
					result = caseEModelElement(numericLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.UNLIMITED_NATURAL_LITERAL_EXP : {
				UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp = (UnlimitedNaturalLiteralExp) theEObject;
				T result = caseUnlimitedNaturalLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseNumericLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseExpressions_UnlimitedNaturalLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = casePrimitiveLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseExpressions_NumericLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseOCLExpression(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseTypedElement(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseNamedElement(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseVisitable(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseASTNode(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseElement(unlimitedNaturalLiteralExp);
				if (result == null)
					result = caseEModelElement(unlimitedNaturalLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.INVALID_LITERAL_EXP : {
				InvalidLiteralExp invalidLiteralExp = (InvalidLiteralExp) theEObject;
				T result = caseInvalidLiteralExp(invalidLiteralExp);
				if (result == null)
					result = caseLiteralExp(invalidLiteralExp);
				if (result == null)
					result = caseExpressions_InvalidLiteralExp(invalidLiteralExp);
				if (result == null)
					result = caseOCLExpression(invalidLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(invalidLiteralExp);
				if (result == null)
					result = caseTypedElement(invalidLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(invalidLiteralExp);
				if (result == null)
					result = caseNamedElement(invalidLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(invalidLiteralExp);
				if (result == null)
					result = caseVisitable(invalidLiteralExp);
				if (result == null)
					result = caseASTNode(invalidLiteralExp);
				if (result == null)
					result = caseElement(invalidLiteralExp);
				if (result == null)
					result = caseEModelElement(invalidLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.ITERATE_EXP : {
				IterateExp iterateExp = (IterateExp) theEObject;
				T result = caseIterateExp(iterateExp);
				if (result == null)
					result = caseLoopExp(iterateExp);
				if (result == null)
					result = caseExpressions_IterateExp(iterateExp);
				if (result == null)
					result = caseCallExp(iterateExp);
				if (result == null)
					result = caseExpressions_LoopExp(iterateExp);
				if (result == null)
					result = caseOCLExpression(iterateExp);
				if (result == null)
					result = caseExpressions_CallExp(iterateExp);
				if (result == null)
					result = caseTypedElement(iterateExp);
				if (result == null)
					result = caseExpressions_OCLExpression(iterateExp);
				if (result == null)
					result = caseCallingASTNode(iterateExp);
				if (result == null)
					result = caseNamedElement(iterateExp);
				if (result == null)
					result = caseUtilities_TypedElement(iterateExp);
				if (result == null)
					result = caseVisitable(iterateExp);
				if (result == null)
					result = caseASTNode(iterateExp);
				if (result == null)
					result = caseElement(iterateExp);
				if (result == null)
					result = caseEModelElement(iterateExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.LOOP_EXP : {
				LoopExp loopExp = (LoopExp) theEObject;
				T result = caseLoopExp(loopExp);
				if (result == null)
					result = caseCallExp(loopExp);
				if (result == null)
					result = caseExpressions_LoopExp(loopExp);
				if (result == null)
					result = caseOCLExpression(loopExp);
				if (result == null)
					result = caseExpressions_CallExp(loopExp);
				if (result == null)
					result = caseTypedElement(loopExp);
				if (result == null)
					result = caseExpressions_OCLExpression(loopExp);
				if (result == null)
					result = caseCallingASTNode(loopExp);
				if (result == null)
					result = caseNamedElement(loopExp);
				if (result == null)
					result = caseUtilities_TypedElement(loopExp);
				if (result == null)
					result = caseVisitable(loopExp);
				if (result == null)
					result = caseASTNode(loopExp);
				if (result == null)
					result = caseElement(loopExp);
				if (result == null)
					result = caseEModelElement(loopExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.ITERATOR_EXP : {
				IteratorExp iteratorExp = (IteratorExp) theEObject;
				T result = caseIteratorExp(iteratorExp);
				if (result == null)
					result = caseLoopExp(iteratorExp);
				if (result == null)
					result = caseExpressions_IteratorExp(iteratorExp);
				if (result == null)
					result = caseCallExp(iteratorExp);
				if (result == null)
					result = caseExpressions_LoopExp(iteratorExp);
				if (result == null)
					result = caseOCLExpression(iteratorExp);
				if (result == null)
					result = caseExpressions_CallExp(iteratorExp);
				if (result == null)
					result = caseTypedElement(iteratorExp);
				if (result == null)
					result = caseExpressions_OCLExpression(iteratorExp);
				if (result == null)
					result = caseCallingASTNode(iteratorExp);
				if (result == null)
					result = caseNamedElement(iteratorExp);
				if (result == null)
					result = caseUtilities_TypedElement(iteratorExp);
				if (result == null)
					result = caseVisitable(iteratorExp);
				if (result == null)
					result = caseASTNode(iteratorExp);
				if (result == null)
					result = caseElement(iteratorExp);
				if (result == null)
					result = caseEModelElement(iteratorExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.LET_EXP : {
				LetExp letExp = (LetExp) theEObject;
				T result = caseLetExp(letExp);
				if (result == null)
					result = caseOCLExpression(letExp);
				if (result == null)
					result = caseExpressions_LetExp(letExp);
				if (result == null)
					result = caseTypedElement(letExp);
				if (result == null)
					result = caseExpressions_OCLExpression(letExp);
				if (result == null)
					result = caseNamedElement(letExp);
				if (result == null)
					result = caseUtilities_TypedElement(letExp);
				if (result == null)
					result = caseVisitable(letExp);
				if (result == null)
					result = caseASTNode(letExp);
				if (result == null)
					result = caseElement(letExp);
				if (result == null)
					result = caseEModelElement(letExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.MESSAGE_EXP : {
				MessageExp messageExp = (MessageExp) theEObject;
				T result = caseMessageExp(messageExp);
				if (result == null)
					result = caseOCLExpression(messageExp);
				if (result == null)
					result = caseExpressions_MessageExp(messageExp);
				if (result == null)
					result = caseTypedElement(messageExp);
				if (result == null)
					result = caseExpressions_OCLExpression(messageExp);
				if (result == null)
					result = caseCallingASTNode(messageExp);
				if (result == null)
					result = caseNamedElement(messageExp);
				if (result == null)
					result = caseUtilities_TypedElement(messageExp);
				if (result == null)
					result = caseVisitable(messageExp);
				if (result == null)
					result = caseASTNode(messageExp);
				if (result == null)
					result = caseElement(messageExp);
				if (result == null)
					result = caseEModelElement(messageExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.NULL_LITERAL_EXP : {
				NullLiteralExp nullLiteralExp = (NullLiteralExp) theEObject;
				T result = caseNullLiteralExp(nullLiteralExp);
				if (result == null)
					result = caseLiteralExp(nullLiteralExp);
				if (result == null)
					result = caseExpressions_NullLiteralExp(nullLiteralExp);
				if (result == null)
					result = caseOCLExpression(nullLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(nullLiteralExp);
				if (result == null)
					result = caseTypedElement(nullLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(nullLiteralExp);
				if (result == null)
					result = caseNamedElement(nullLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(nullLiteralExp);
				if (result == null)
					result = caseVisitable(nullLiteralExp);
				if (result == null)
					result = caseASTNode(nullLiteralExp);
				if (result == null)
					result = caseElement(nullLiteralExp);
				if (result == null)
					result = caseEModelElement(nullLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.OPERATION_CALL_EXP : {
				OperationCallExp operationCallExp = (OperationCallExp) theEObject;
				T result = caseOperationCallExp(operationCallExp);
				if (result == null)
					result = caseFeatureCallExp(operationCallExp);
				if (result == null)
					result = caseExpressions_OperationCallExp(operationCallExp);
				if (result == null)
					result = caseCallExp(operationCallExp);
				if (result == null)
					result = caseExpressions_FeatureCallExp(operationCallExp);
				if (result == null)
					result = caseOCLExpression(operationCallExp);
				if (result == null)
					result = caseExpressions_CallExp(operationCallExp);
				if (result == null)
					result = caseTypedElement(operationCallExp);
				if (result == null)
					result = caseExpressions_OCLExpression(operationCallExp);
				if (result == null)
					result = caseCallingASTNode(operationCallExp);
				if (result == null)
					result = caseNamedElement(operationCallExp);
				if (result == null)
					result = caseUtilities_TypedElement(operationCallExp);
				if (result == null)
					result = caseVisitable(operationCallExp);
				if (result == null)
					result = caseASTNode(operationCallExp);
				if (result == null)
					result = caseElement(operationCallExp);
				if (result == null)
					result = caseEModelElement(operationCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.PROPERTY_CALL_EXP : {
				PropertyCallExp propertyCallExp = (PropertyCallExp) theEObject;
				T result = casePropertyCallExp(propertyCallExp);
				if (result == null)
					result = caseNavigationCallExp(propertyCallExp);
				if (result == null)
					result = caseExpressions_PropertyCallExp(propertyCallExp);
				if (result == null)
					result = caseFeatureCallExp(propertyCallExp);
				if (result == null)
					result = caseExpressions_NavigationCallExp(propertyCallExp);
				if (result == null)
					result = caseCallExp(propertyCallExp);
				if (result == null)
					result = caseExpressions_FeatureCallExp(propertyCallExp);
				if (result == null)
					result = caseOCLExpression(propertyCallExp);
				if (result == null)
					result = caseExpressions_CallExp(propertyCallExp);
				if (result == null)
					result = caseTypedElement(propertyCallExp);
				if (result == null)
					result = caseExpressions_OCLExpression(propertyCallExp);
				if (result == null)
					result = caseCallingASTNode(propertyCallExp);
				if (result == null)
					result = caseNamedElement(propertyCallExp);
				if (result == null)
					result = caseUtilities_TypedElement(propertyCallExp);
				if (result == null)
					result = caseVisitable(propertyCallExp);
				if (result == null)
					result = caseASTNode(propertyCallExp);
				if (result == null)
					result = caseElement(propertyCallExp);
				if (result == null)
					result = caseEModelElement(propertyCallExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.REAL_LITERAL_EXP : {
				RealLiteralExp realLiteralExp = (RealLiteralExp) theEObject;
				T result = caseRealLiteralExp(realLiteralExp);
				if (result == null)
					result = caseNumericLiteralExp(realLiteralExp);
				if (result == null)
					result = caseExpressions_RealLiteralExp(realLiteralExp);
				if (result == null)
					result = casePrimitiveLiteralExp(realLiteralExp);
				if (result == null)
					result = caseExpressions_NumericLiteralExp(realLiteralExp);
				if (result == null)
					result = caseLiteralExp(realLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(realLiteralExp);
				if (result == null)
					result = caseOCLExpression(realLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(realLiteralExp);
				if (result == null)
					result = caseTypedElement(realLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(realLiteralExp);
				if (result == null)
					result = caseNamedElement(realLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(realLiteralExp);
				if (result == null)
					result = caseVisitable(realLiteralExp);
				if (result == null)
					result = caseASTNode(realLiteralExp);
				if (result == null)
					result = caseElement(realLiteralExp);
				if (result == null)
					result = caseEModelElement(realLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.STATE_EXP : {
				StateExp stateExp = (StateExp) theEObject;
				T result = caseStateExp(stateExp);
				if (result == null)
					result = caseOCLExpression(stateExp);
				if (result == null)
					result = caseExpressions_StateExp(stateExp);
				if (result == null)
					result = caseTypedElement(stateExp);
				if (result == null)
					result = caseExpressions_OCLExpression(stateExp);
				if (result == null)
					result = caseNamedElement(stateExp);
				if (result == null)
					result = caseUtilities_TypedElement(stateExp);
				if (result == null)
					result = caseVisitable(stateExp);
				if (result == null)
					result = caseASTNode(stateExp);
				if (result == null)
					result = caseElement(stateExp);
				if (result == null)
					result = caseEModelElement(stateExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.STRING_LITERAL_EXP : {
				StringLiteralExp stringLiteralExp = (StringLiteralExp) theEObject;
				T result = caseStringLiteralExp(stringLiteralExp);
				if (result == null)
					result = casePrimitiveLiteralExp(stringLiteralExp);
				if (result == null)
					result = caseExpressions_StringLiteralExp(stringLiteralExp);
				if (result == null)
					result = caseLiteralExp(stringLiteralExp);
				if (result == null)
					result = caseExpressions_PrimitiveLiteralExp(stringLiteralExp);
				if (result == null)
					result = caseOCLExpression(stringLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(stringLiteralExp);
				if (result == null)
					result = caseTypedElement(stringLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(stringLiteralExp);
				if (result == null)
					result = caseNamedElement(stringLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(stringLiteralExp);
				if (result == null)
					result = caseVisitable(stringLiteralExp);
				if (result == null)
					result = caseASTNode(stringLiteralExp);
				if (result == null)
					result = caseElement(stringLiteralExp);
				if (result == null)
					result = caseEModelElement(stringLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.TUPLE_LITERAL_EXP : {
				TupleLiteralExp tupleLiteralExp = (TupleLiteralExp) theEObject;
				T result = caseTupleLiteralExp(tupleLiteralExp);
				if (result == null)
					result = caseLiteralExp(tupleLiteralExp);
				if (result == null)
					result = caseExpressions_TupleLiteralExp(tupleLiteralExp);
				if (result == null)
					result = caseOCLExpression(tupleLiteralExp);
				if (result == null)
					result = caseExpressions_LiteralExp(tupleLiteralExp);
				if (result == null)
					result = caseTypedElement(tupleLiteralExp);
				if (result == null)
					result = caseExpressions_OCLExpression(tupleLiteralExp);
				if (result == null)
					result = caseNamedElement(tupleLiteralExp);
				if (result == null)
					result = caseUtilities_TypedElement(tupleLiteralExp);
				if (result == null)
					result = caseVisitable(tupleLiteralExp);
				if (result == null)
					result = caseASTNode(tupleLiteralExp);
				if (result == null)
					result = caseElement(tupleLiteralExp);
				if (result == null)
					result = caseEModelElement(tupleLiteralExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.TUPLE_LITERAL_PART : {
				TupleLiteralPart tupleLiteralPart = (TupleLiteralPart) theEObject;
				T result = caseTupleLiteralPart(tupleLiteralPart);
				if (result == null)
					result = caseTypedElement(tupleLiteralPart);
				if (result == null)
					result = caseExpressions_TupleLiteralPart(tupleLiteralPart);
				if (result == null)
					result = caseNamedElement(tupleLiteralPart);
				if (result == null)
					result = caseUtilities_TypedElement(tupleLiteralPart);
				if (result == null)
					result = caseVisitable(tupleLiteralPart);
				if (result == null)
					result = caseTypedASTNode(tupleLiteralPart);
				if (result == null)
					result = caseElement(tupleLiteralPart);
				if (result == null)
					result = caseASTNode(tupleLiteralPart);
				if (result == null)
					result = caseEModelElement(tupleLiteralPart);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.TYPE_EXP : {
				TypeExp typeExp = (TypeExp) theEObject;
				T result = caseTypeExp(typeExp);
				if (result == null)
					result = caseOCLExpression(typeExp);
				if (result == null)
					result = caseExpressions_TypeExp(typeExp);
				if (result == null)
					result = caseTypedElement(typeExp);
				if (result == null)
					result = caseExpressions_OCLExpression(typeExp);
				if (result == null)
					result = caseNamedElement(typeExp);
				if (result == null)
					result = caseUtilities_TypedElement(typeExp);
				if (result == null)
					result = caseVisitable(typeExp);
				if (result == null)
					result = caseASTNode(typeExp);
				if (result == null)
					result = caseElement(typeExp);
				if (result == null)
					result = caseEModelElement(typeExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.UNSPECIFIED_VALUE_EXP : {
				UnspecifiedValueExp unspecifiedValueExp = (UnspecifiedValueExp) theEObject;
				T result = caseUnspecifiedValueExp(unspecifiedValueExp);
				if (result == null)
					result = caseOCLExpression(unspecifiedValueExp);
				if (result == null)
					result = caseExpressions_UnspecifiedValueExp(unspecifiedValueExp);
				if (result == null)
					result = caseTypedElement(unspecifiedValueExp);
				if (result == null)
					result = caseExpressions_OCLExpression(unspecifiedValueExp);
				if (result == null)
					result = caseTypedASTNode(unspecifiedValueExp);
				if (result == null)
					result = caseNamedElement(unspecifiedValueExp);
				if (result == null)
					result = caseUtilities_TypedElement(unspecifiedValueExp);
				if (result == null)
					result = caseVisitable(unspecifiedValueExp);
				if (result == null)
					result = caseASTNode(unspecifiedValueExp);
				if (result == null)
					result = caseElement(unspecifiedValueExp);
				if (result == null)
					result = caseEModelElement(unspecifiedValueExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.VARIABLE : {
				Variable variable = (Variable) theEObject;
				T result = caseVariable(variable);
				if (result == null)
					result = caseTypedElement(variable);
				if (result == null)
					result = caseExpressions_Variable(variable);
				if (result == null)
					result = caseNamedElement(variable);
				if (result == null)
					result = caseUtilities_TypedElement(variable);
				if (result == null)
					result = caseVisitable(variable);
				if (result == null)
					result = caseTypedASTNode(variable);
				if (result == null)
					result = caseElement(variable);
				if (result == null)
					result = caseASTNode(variable);
				if (result == null)
					result = caseEModelElement(variable);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.VARIABLE_EXP : {
				VariableExp variableExp = (VariableExp) theEObject;
				T result = caseVariableExp(variableExp);
				if (result == null)
					result = caseOCLExpression(variableExp);
				if (result == null)
					result = caseExpressions_VariableExp(variableExp);
				if (result == null)
					result = caseTypedElement(variableExp);
				if (result == null)
					result = caseExpressions_OCLExpression(variableExp);
				if (result == null)
					result = caseNamedElement(variableExp);
				if (result == null)
					result = caseUtilities_TypedElement(variableExp);
				if (result == null)
					result = caseVisitable(variableExp);
				if (result == null)
					result = caseASTNode(variableExp);
				if (result == null)
					result = caseElement(variableExp);
				if (result == null)
					result = caseEModelElement(variableExp);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case UMLPackage.TEMPLATE_PARAMETER_TYPE : {
				TemplateParameterType templateParameterType = (TemplateParameterType) theEObject;
				T result = caseTemplateParameterType(templateParameterType);
				if (result == null)
					result = caseClassifier(templateParameterType);
				if (result == null)
					result = caseTypes_TemplateParameterType(templateParameterType);
				if (result == null)
					result = caseNamespace(templateParameterType);
				if (result == null)
					result = caseRedefinableElement(templateParameterType);
				if (result == null)
					result = caseType(templateParameterType);
				if (result == null)
					result = caseTemplateableElement(templateParameterType);
				if (result == null)
					result = casePackageableElement(templateParameterType);
				if (result == null)
					result = caseNamedElement(templateParameterType);
				if (result == null)
					result = caseParameterableElement(templateParameterType);
				if (result == null)
					result = caseElement(templateParameterType);
				if (result == null)
					result = caseEModelElement(templateParameterType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default :
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidType(InvalidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementType(ElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeType(TypeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageType(MessageType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleType(TupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionInOCL(ExpressionInOCL object) {
		return null;
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
	public T caseAssociationClassCallExp(AssociationClassCallExp object) {
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
	public T caseNavigationCallExp(NavigationCallExp object) {
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
	public T caseFeatureCallExp(FeatureCallExp object) {
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
	public T caseCallExp(CallExp object) {
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
	public T caseOCLExpression(OCLExpression object) {
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
	public T caseBooleanLiteralExp(BooleanLiteralExp object) {
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
	public T casePrimitiveLiteralExp(PrimitiveLiteralExp object) {
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
	public T caseLiteralExp(LiteralExp object) {
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
	public T caseCollectionItem(CollectionItem object) {
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
	public T caseCollectionLiteralPart(CollectionLiteralPart object) {
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
	public T caseCollectionLiteralExp(CollectionLiteralExp object) {
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
	public T caseCollectionRange(CollectionRange object) {
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
	public T caseEnumLiteralExp(EnumLiteralExp object) {
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
	public T caseIfExp(IfExp object) {
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
	public T caseIntegerLiteralExp(IntegerLiteralExp object) {
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
	public T caseNumericLiteralExp(NumericLiteralExp object) {
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
	public T caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp object) {
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
	public T caseInvalidLiteralExp(InvalidLiteralExp object) {
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
	public T caseIterateExp(IterateExp object) {
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
	public T caseLoopExp(LoopExp object) {
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
	public T caseIteratorExp(IteratorExp object) {
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
	public T caseLetExp(LetExp object) {
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
	public T caseMessageExp(MessageExp object) {
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
	public T caseNullLiteralExp(NullLiteralExp object) {
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
	public T caseOperationCallExp(OperationCallExp object) {
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
	public T casePropertyCallExp(PropertyCallExp object) {
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
	public T caseRealLiteralExp(RealLiteralExp object) {
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
	public T caseStateExp(StateExp object) {
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
	public T caseStringLiteralExp(StringLiteralExp object) {
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
	public T caseTupleLiteralExp(TupleLiteralExp object) {
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
	public T caseTupleLiteralPart(TupleLiteralPart object) {
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
	public T caseTypeExp(TypeExp object) {
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
	public T caseUnspecifiedValueExp(UnspecifiedValueExp object) {
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
	public T caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterType(TemplateParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redefinable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redefinable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedefinableElement(RedefinableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterableElement(ParameterableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageableElement(PackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElement(TemplateableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <O> T casePredefinedType(PredefinedType<O> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <O> T caseTypes_AnyType(org.eclipse.ocl.types.AnyType<O> object) {
		return caseAnyType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <O> T caseTypes_VoidType(org.eclipse.ocl.types.VoidType<O> object) {
		return caseVoidType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <O> T caseTypes_InvalidType(
			org.eclipse.ocl.types.InvalidType<O> object) {
		return caseInvalidType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public T caseTypes_ElementType(org.eclipse.ocl.types.ElementType object) {
		return caseElementType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseTypes_TypeType(
			org.eclipse.ocl.types.TypeType<C, O> object) {
		return caseTypeType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O, P> T caseTypes_MessageType(
			org.eclipse.ocl.types.MessageType<C, O, P> object) {
		return caseMessageType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUML_PrimitiveType(org.eclipse.uml2.uml.PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <O> T caseTypes_PrimitiveType(
			org.eclipse.ocl.types.PrimitiveType<O> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseTypes_CollectionType(
			org.eclipse.ocl.types.CollectionType<C, O> object) {
		return caseCollectionType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <O, P> T caseTypes_TupleType(
			org.eclipse.ocl.types.TupleType<O, P> object) {
		return caseTupleType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseTypes_BagType(org.eclipse.ocl.types.BagType<C, O> object) {
		return caseBagType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseTypes_SetType(org.eclipse.ocl.types.SetType<C, O> object) {
		return caseSetType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseTypes_OrderedSetType(
			org.eclipse.ocl.types.OrderedSetType<C, O> object) {
		return caseOrderedSetType_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseTypes_SequenceType(
			org.eclipse.ocl.types.SequenceType<C, O> object) {
		return caseSequenceType_1(object);
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
	 * Returns the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueSpecification(ValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueExpression(OpaqueExpression object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseUtilities_ExpressionInOCL(
			org.eclipse.ocl.utilities.ExpressionInOCL<C, PM> object) {
		return caseExpressionInOCL_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C> T caseUtilities_TypedElement(
			org.eclipse.ocl.utilities.TypedElement<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_OCLExpression(
			org.eclipse.ocl.expressions.OCLExpression<C> object) {
		return caseOCLExpression_1(object);
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
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_CallExp(
			org.eclipse.ocl.expressions.CallExp<C> object) {
		return caseCallExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_FeatureCallExp(
			org.eclipse.ocl.expressions.FeatureCallExp<C> object) {
		return caseFeatureCallExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, P> T caseExpressions_NavigationCallExp(
			org.eclipse.ocl.expressions.NavigationCallExp<C, P> object) {
		return caseNavigationCallExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, P> T caseExpressions_AssociationClassCallExp(
			org.eclipse.ocl.expressions.AssociationClassCallExp<C, P> object) {
		return caseAssociationClassCallExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_LiteralExp(
			org.eclipse.ocl.expressions.LiteralExp<C> object) {
		return caseLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_PrimitiveLiteralExp(
			org.eclipse.ocl.expressions.PrimitiveLiteralExp<C> object) {
		return casePrimitiveLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_BooleanLiteralExp(
			org.eclipse.ocl.expressions.BooleanLiteralExp<C> object) {
		return caseBooleanLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_CollectionLiteralPart(
			org.eclipse.ocl.expressions.CollectionLiteralPart<C> object) {
		return caseCollectionLiteralPart_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_CollectionItem(
			org.eclipse.ocl.expressions.CollectionItem<C> object) {
		return caseCollectionItem_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_CollectionLiteralExp(
			org.eclipse.ocl.expressions.CollectionLiteralExp<C> object) {
		return caseCollectionLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_CollectionRange(
			org.eclipse.ocl.expressions.CollectionRange<C> object) {
		return caseCollectionRange_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, EL> T caseExpressions_EnumLiteralExp(
			org.eclipse.ocl.expressions.EnumLiteralExp<C, EL> object) {
		return caseEnumLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_IfExp(
			org.eclipse.ocl.expressions.IfExp<C> object) {
		return caseIfExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_NumericLiteralExp(
			org.eclipse.ocl.expressions.NumericLiteralExp<C> object) {
		return caseNumericLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_IntegerLiteralExp(
			org.eclipse.ocl.expressions.IntegerLiteralExp<C> object) {
		return caseIntegerLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_UnlimitedNaturalLiteralExp(
			org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp<C> object) {
		return caseUnlimitedNaturalLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_InvalidLiteralExp(
			org.eclipse.ocl.expressions.InvalidLiteralExp<C> object) {
		return caseInvalidLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseExpressions_LoopExp(
			org.eclipse.ocl.expressions.LoopExp<C, PM> object) {
		return caseLoopExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseExpressions_IterateExp(
			org.eclipse.ocl.expressions.IterateExp<C, PM> object) {
		return caseIterateExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseExpressions_IteratorExp(
			org.eclipse.ocl.expressions.IteratorExp<C, PM> object) {
		return caseIteratorExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseExpressions_LetExp(
			org.eclipse.ocl.expressions.LetExp<C, PM> object) {
		return caseLetExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, COA, SSA> T caseExpressions_MessageExp(
			org.eclipse.ocl.expressions.MessageExp<C, COA, SSA> object) {
		return caseMessageExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_NullLiteralExp(
			org.eclipse.ocl.expressions.NullLiteralExp<C> object) {
		return caseNullLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, O> T caseExpressions_OperationCallExp(
			org.eclipse.ocl.expressions.OperationCallExp<C, O> object) {
		return caseOperationCallExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, P> T caseExpressions_PropertyCallExp(
			org.eclipse.ocl.expressions.PropertyCallExp<C, P> object) {
		return casePropertyCallExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_RealLiteralExp(
			org.eclipse.ocl.expressions.RealLiteralExp<C> object) {
		return caseRealLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, S> T caseExpressions_StateExp(
			org.eclipse.ocl.expressions.StateExp<C, S> object) {
		return caseStateExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_StringLiteralExp(
			org.eclipse.ocl.expressions.StringLiteralExp<C> object) {
		return caseStringLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, P> T caseExpressions_TupleLiteralExp(
			org.eclipse.ocl.expressions.TupleLiteralExp<C, P> object) {
		return caseTupleLiteralExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, P> T caseExpressions_TupleLiteralPart(
			org.eclipse.ocl.expressions.TupleLiteralPart<C, P> object) {
		return caseTupleLiteralPart_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_TypeExp(
			org.eclipse.ocl.expressions.TypeExp<C> object) {
		return caseTypeExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C> T caseExpressions_UnspecifiedValueExp(
			org.eclipse.ocl.expressions.UnspecifiedValueExp<C> object) {
		return caseUnspecifiedValueExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseExpressions_Variable(
			org.eclipse.ocl.expressions.Variable<C, PM> object) {
		return caseVariable_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated NOT (generated version returns null)
	 */
	@SuppressWarnings("deprecation")
	public <C, PM> T caseExpressions_VariableExp(
			org.eclipse.ocl.expressions.VariableExp<C, PM> object) {
		return caseVariableExp_1(object);
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <O> T caseTypes_TemplateParameterType(
			org.eclipse.ocl.types.TemplateParameterType<O> object) {
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

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_AnyType} method, instead.
	 */
	@Deprecated
	public <O> T caseAnyType_1(org.eclipse.ocl.types.AnyType<O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_CollectionType} method, instead.
	 */
	@Deprecated
	public <C, O> T caseCollectionType_1(
			org.eclipse.ocl.types.CollectionType<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_BagType} method, instead.
	 */
	@Deprecated
	public <C, O> T caseBagType_1(org.eclipse.ocl.types.BagType<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_ElementType} method, instead.
	 */
	@Deprecated
	public T caseElementType_1(org.eclipse.ocl.types.ElementType object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_InvalidType} method, instead.
	 */
	@Deprecated
	public <O> T caseInvalidType_1(org.eclipse.ocl.types.InvalidType<O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_MessageType} method, instead.
	 */
	@Deprecated
	public <C, O, P> T caseMessageType_1(
			org.eclipse.ocl.types.MessageType<C, O, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_OrderedSetType} method, instead.
	 */
	@Deprecated
	public <C, O> T caseOrderedSetType_1(
			org.eclipse.ocl.types.OrderedSetType<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_SequenceType} method, instead.
	 */
	@Deprecated
	public <C, O> T caseSequenceType_1(
			org.eclipse.ocl.types.SequenceType<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_SetType} method, instead.
	 */
	@Deprecated
	public <C, O> T caseSetType_1(org.eclipse.ocl.types.SetType<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_TupleType} method, instead.
	 */
	@Deprecated
	public <O, P> T caseTupleType_1(org.eclipse.ocl.types.TupleType<O, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_TypeType} method, instead.
	 */
	@Deprecated
	public <C, O> T caseTypeType_1(org.eclipse.ocl.types.TypeType<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseTypes_VoidType} method, instead.
	 */
	@Deprecated
	public <O> T caseVoidType_1(org.eclipse.ocl.types.VoidType<O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseUtilities_ExpressionInOCL} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseExpressionInOCL_1(
			org.eclipse.ocl.utilities.ExpressionInOCL<C, PM> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_OCLExpression} method, instead.
	 */
	@Deprecated
	public <C> T caseOCLExpression_1(
			org.eclipse.ocl.expressions.OCLExpression<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_CallExp} method, instead.
	 */
	@Deprecated
	public <C> T caseCallExp_1(org.eclipse.ocl.expressions.CallExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_FeatureCallExp} method, instead.
	 */
	@Deprecated
	public <C> T caseFeatureCallExp_1(
			org.eclipse.ocl.expressions.FeatureCallExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_NavigationCallExp} method, instead.
	 */
	@Deprecated
	public <C, P> T caseNavigationCallExp_1(
			org.eclipse.ocl.expressions.NavigationCallExp<C, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_AssociationClassCallExp} method, instead.
	 */
	@Deprecated
	public <C, P> T caseAssociationClassCallExp_1(
			org.eclipse.ocl.expressions.AssociationClassCallExp<C, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_LiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseLiteralExp_1(
			org.eclipse.ocl.expressions.LiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_PrimitiveLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T casePrimitiveLiteralExp_1(
			org.eclipse.ocl.expressions.PrimitiveLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_BooleanLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseBooleanLiteralExp_1(
			org.eclipse.ocl.expressions.BooleanLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_CollectionLiteralPart} method, instead.
	 */
	@Deprecated
	public <C> T caseCollectionLiteralPart_1(
			org.eclipse.ocl.expressions.CollectionLiteralPart<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_CollectionItem} method, instead.
	 */
	@Deprecated
	public <C> T caseCollectionItem_1(
			org.eclipse.ocl.expressions.CollectionItem<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_CollectionLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseCollectionLiteralExp_1(
			org.eclipse.ocl.expressions.CollectionLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_CollectionRange} method, instead.
	 */
	@Deprecated
	public <C> T caseCollectionRange_1(
			org.eclipse.ocl.expressions.CollectionRange<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_EnumLiteralExp} method, instead.
	 */
	@Deprecated
	public <C, EL> T caseEnumLiteralExp_1(
			org.eclipse.ocl.expressions.EnumLiteralExp<C, EL> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_IfExp} method, instead.
	 */
	@Deprecated
	public <C> T caseIfExp_1(org.eclipse.ocl.expressions.IfExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_NumericLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseNumericLiteralExp_1(
			org.eclipse.ocl.expressions.NumericLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_IntegerLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseIntegerLiteralExp_1(
			org.eclipse.ocl.expressions.IntegerLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_UnlimitedNaturalLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseUnlimitedNaturalLiteralExp_1(
			org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_InvalidLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseInvalidLiteralExp_1(
			org.eclipse.ocl.expressions.InvalidLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_LoopExp} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseLoopExp_1(
			org.eclipse.ocl.expressions.LoopExp<C, PM> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_IterateExp} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseIterateExp_1(
			org.eclipse.ocl.expressions.IterateExp<C, PM> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_IteratorExp} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseIteratorExp_1(
			org.eclipse.ocl.expressions.IteratorExp<C, PM> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_LetExp} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseLetExp_1(
			org.eclipse.ocl.expressions.LetExp<C, PM> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_MessageExp} method, instead.
	 */
	@Deprecated
	public <C, COA, SSA> T caseMessageExp_1(
			org.eclipse.ocl.expressions.MessageExp<C, COA, SSA> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_NullLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseNullLiteralExp_1(
			org.eclipse.ocl.expressions.NullLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_OperationCallExp} method, instead.
	 */
	@Deprecated
	public <C, O> T caseOperationCallExp_1(
			org.eclipse.ocl.expressions.OperationCallExp<C, O> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_PropertyCallExp} method, instead.
	 */
	@Deprecated
	public <C, P> T casePropertyCallExp_1(
			org.eclipse.ocl.expressions.PropertyCallExp<C, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_RealLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseRealLiteralExp_1(
			org.eclipse.ocl.expressions.RealLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_StateExp} method, instead.
	 */
	@Deprecated
	public <C, S> T caseStateExp_1(
			org.eclipse.ocl.expressions.StateExp<C, S> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_StringLiteralExp} method, instead.
	 */
	@Deprecated
	public <C> T caseStringLiteralExp_1(
			org.eclipse.ocl.expressions.StringLiteralExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_TupleLiteralExp} method, instead.
	 */
	@Deprecated
	public <C, P> T caseTupleLiteralExp_1(
			org.eclipse.ocl.expressions.TupleLiteralExp<C, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_TupleLiteralPart} method, instead.
	 */
	@Deprecated
	public <C, P> T caseTupleLiteralPart_1(
			org.eclipse.ocl.expressions.TupleLiteralPart<C, P> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_TypeExp} method, instead.
	 */
	@Deprecated
	public <C> T caseTypeExp_1(org.eclipse.ocl.expressions.TypeExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_UnspecifiedValueExp} method, instead.
	 */
	@Deprecated
	public <C> T caseUnspecifiedValueExp_1(
			org.eclipse.ocl.expressions.UnspecifiedValueExp<C> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_Variable} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseVariable_1(
			org.eclipse.ocl.expressions.Variable<C, PM> object) {
		return null;
	}

	/**
	 * @deprecated Since 2.0, override the {@link #caseExpressions_VariableExp} method, instead.
	 */
	@Deprecated
	public <C, PM> T caseVariableExp_1(
			org.eclipse.ocl.expressions.VariableExp<C, PM> object) {
		return null;
	}

} //UMLSwitch
