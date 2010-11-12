/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseCSTSwitch.java,v 1.3 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.base.baseCST.*;

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
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage
 * @generated
 */
public class BaseCSTSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BaseCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = BaseCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BaseCSTPackage.ANNOTATION_ELEMENT_CS: {
				AnnotationElementCS annotationElementCS = (AnnotationElementCS)theEObject;
				T1 result = caseAnnotationElementCS(annotationElementCS);
				if (result == null) result = caseModelElementCS(annotationElementCS);
				if (result == null) result = caseElementCS(annotationElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ATTRIBUTE_CS: {
				AttributeCS attributeCS = (AttributeCS)theEObject;
				T1 result = caseAttributeCS(attributeCS);
				if (result == null) result = caseStructuralFeatureCS(attributeCS);
				if (result == null) result = caseFeatureCS(attributeCS);
				if (result == null) result = caseTypedElementCS(attributeCS);
				if (result == null) result = caseNamedElementCS(attributeCS);
				if (result == null) result = caseModelElementCS(attributeCS);
				if (result == null) result = caseElementCS(attributeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ATTRIBUTE_CS_REF: {
				AttributeCSRef attributeCSRef = (AttributeCSRef)theEObject;
				T1 result = caseAttributeCSRef(attributeCSRef);
				if (result == null) result = caseElementCS(attributeCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.BOUND_CLASS_CS: {
				BoundClassCS boundClassCS = (BoundClassCS)theEObject;
				T1 result = caseBoundClassCS(boundClassCS);
				if (result == null) result = caseClassCS(boundClassCS);
				if (result == null) result = caseBoundClassifierCS(boundClassCS);
				if (result == null) result = caseClassifierCS(boundClassCS);
				if (result == null) result = caseNamespaceCS(boundClassCS);
				if (result == null) result = caseBoundElementCS(boundClassCS);
				if (result == null) result = caseNamedElementCS(boundClassCS);
				if (result == null) result = caseTypeCS(boundClassCS);
				if (result == null) result = caseModelElementCS(boundClassCS);
				if (result == null) result = caseElementCS(boundClassCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.BOUND_CLASSIFIER_CS: {
				BoundClassifierCS boundClassifierCS = (BoundClassifierCS)theEObject;
				T1 result = caseBoundClassifierCS(boundClassifierCS);
				if (result == null) result = caseClassifierCS(boundClassifierCS);
				if (result == null) result = caseBoundElementCS(boundClassifierCS);
				if (result == null) result = caseNamedElementCS(boundClassifierCS);
				if (result == null) result = caseTypeCS(boundClassifierCS);
				if (result == null) result = caseModelElementCS(boundClassifierCS);
				if (result == null) result = caseElementCS(boundClassifierCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.BOUND_DOCUMENT_CS: {
				BoundDocumentCS boundDocumentCS = (BoundDocumentCS)theEObject;
				T1 result = caseBoundDocumentCS(boundDocumentCS);
				if (result == null) result = casePackageCS(boundDocumentCS);
				if (result == null) result = caseNamespaceCS(boundDocumentCS);
				if (result == null) result = caseNamedElementCS(boundDocumentCS);
				if (result == null) result = caseModelElementCS(boundDocumentCS);
				if (result == null) result = caseElementCS(boundDocumentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.BOUND_ELEMENT_CS: {
				BoundElementCS<?> boundElementCS = (BoundElementCS<?>)theEObject;
				T1 result = caseBoundElementCS(boundElementCS);
				if (result == null) result = caseNamedElementCS(boundElementCS);
				if (result == null) result = caseModelElementCS(boundElementCS);
				if (result == null) result = caseElementCS(boundElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.BOUND_OPERATION_CS: {
				BoundOperationCS boundOperationCS = (BoundOperationCS)theEObject;
				T1 result = caseBoundOperationCS(boundOperationCS);
				if (result == null) result = caseOperationCS(boundOperationCS);
				if (result == null) result = caseBoundElementCS(boundOperationCS);
				if (result == null) result = caseFeatureCS(boundOperationCS);
				if (result == null) result = caseTypedElementCS(boundOperationCS);
				if (result == null) result = caseNamedElementCS(boundOperationCS);
				if (result == null) result = caseModelElementCS(boundOperationCS);
				if (result == null) result = caseElementCS(boundOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASS_CS: {
				ClassCS classCS = (ClassCS)theEObject;
				T1 result = caseClassCS(classCS);
				if (result == null) result = caseClassifierCS(classCS);
				if (result == null) result = caseNamespaceCS(classCS);
				if (result == null) result = caseNamedElementCS(classCS);
				if (result == null) result = caseTypeCS(classCS);
				if (result == null) result = caseModelElementCS(classCS);
				if (result == null) result = caseElementCS(classCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASS_CS_REF: {
				ClassCSRef classCSRef = (ClassCSRef)theEObject;
				T1 result = caseClassCSRef(classCSRef);
				if (result == null) result = caseElementCS(classCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASSIFIER_CS: {
				ClassifierCS classifierCS = (ClassifierCS)theEObject;
				T1 result = caseClassifierCS(classifierCS);
				if (result == null) result = caseNamedElementCS(classifierCS);
				if (result == null) result = caseTypeCS(classifierCS);
				if (result == null) result = caseModelElementCS(classifierCS);
				if (result == null) result = caseElementCS(classifierCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASSIFIER_REF_CS: {
				ClassifierRefCS classifierRefCS = (ClassifierRefCS)theEObject;
				T1 result = caseClassifierRefCS(classifierRefCS);
				if (result == null) result = caseModelElementCS(classifierRefCS);
				if (result == null) result = caseElementCS(classifierRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.COLLECTION_TYPE_REF_CS: {
				CollectionTypeRefCS collectionTypeRefCS = (CollectionTypeRefCS)theEObject;
				T1 result = caseCollectionTypeRefCS(collectionTypeRefCS);
				if (result == null) result = caseTypedRefCS(collectionTypeRefCS);
				if (result == null) result = caseNamedElementCS(collectionTypeRefCS);
				if (result == null) result = caseTypeRefCS(collectionTypeRefCS);
				if (result == null) result = caseModelElementCS(collectionTypeRefCS);
				if (result == null) result = caseElementCS(collectionTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.DETAIL_CS: {
				DetailCS detailCS = (DetailCS)theEObject;
				T1 result = caseDetailCS(detailCS);
				if (result == null) result = caseElementCS(detailCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.DOCUMENT_CS: {
				DocumentCS documentCS = (DocumentCS)theEObject;
				T1 result = caseDocumentCS(documentCS);
				if (result == null) result = caseNamespaceCS(documentCS);
				if (result == null) result = caseNamedElementCS(documentCS);
				if (result == null) result = caseModelElementCS(documentCS);
				if (result == null) result = caseElementCS(documentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ELEMENT_CS: {
				ElementCS elementCS = (ElementCS)theEObject;
				T1 result = caseElementCS(elementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ENUM_LITERAL_CS: {
				EnumLiteralCS enumLiteralCS = (EnumLiteralCS)theEObject;
				T1 result = caseEnumLiteralCS(enumLiteralCS);
				if (result == null) result = caseNamedElementCS(enumLiteralCS);
				if (result == null) result = caseModelElementCS(enumLiteralCS);
				if (result == null) result = caseElementCS(enumLiteralCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.FEATURE_CS: {
				FeatureCS featureCS = (FeatureCS)theEObject;
				T1 result = caseFeatureCS(featureCS);
				if (result == null) result = caseTypedElementCS(featureCS);
				if (result == null) result = caseNamedElementCS(featureCS);
				if (result == null) result = caseModelElementCS(featureCS);
				if (result == null) result = caseElementCS(featureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.IMPORT_CS: {
				ImportCS importCS = (ImportCS)theEObject;
				T1 result = caseImportCS(importCS);
				if (result == null) result = caseNamespaceCS(importCS);
				if (result == null) result = caseNamedElementCS(importCS);
				if (result == null) result = caseModelElementCS(importCS);
				if (result == null) result = caseElementCS(importCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.LIBRARY_CS: {
				LibraryCS libraryCS = (LibraryCS)theEObject;
				T1 result = caseLibraryCS(libraryCS);
				if (result == null) result = caseNamespaceCS(libraryCS);
				if (result == null) result = caseNamedElementCS(libraryCS);
				if (result == null) result = caseModelElementCS(libraryCS);
				if (result == null) result = caseElementCS(libraryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.MODEL_ELEMENT_CS: {
				ModelElementCS modelElementCS = (ModelElementCS)theEObject;
				T1 result = caseModelElementCS(modelElementCS);
				if (result == null) result = caseElementCS(modelElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.MODEL_ELEMENT_CS_REF: {
				ModelElementCSRef modelElementCSRef = (ModelElementCSRef)theEObject;
				T1 result = caseModelElementCSRef(modelElementCSRef);
				if (result == null) result = caseElementCS(modelElementCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.NAMED_ELEMENT_CS: {
				NamedElementCS namedElementCS = (NamedElementCS)theEObject;
				T1 result = caseNamedElementCS(namedElementCS);
				if (result == null) result = caseModelElementCS(namedElementCS);
				if (result == null) result = caseElementCS(namedElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.NAMESPACE_CS: {
				NamespaceCS namespaceCS = (NamespaceCS)theEObject;
				T1 result = caseNamespaceCS(namespaceCS);
				if (result == null) result = caseNamedElementCS(namespaceCS);
				if (result == null) result = caseModelElementCS(namespaceCS);
				if (result == null) result = caseElementCS(namespaceCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.OPERATION_CS: {
				OperationCS operationCS = (OperationCS)theEObject;
				T1 result = caseOperationCS(operationCS);
				if (result == null) result = caseFeatureCS(operationCS);
				if (result == null) result = caseTypedElementCS(operationCS);
				if (result == null) result = caseNamedElementCS(operationCS);
				if (result == null) result = caseModelElementCS(operationCS);
				if (result == null) result = caseElementCS(operationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.OPERATION_REF_CS: {
				OperationRefCS operationRefCS = (OperationRefCS)theEObject;
				T1 result = caseOperationRefCS(operationRefCS);
				if (result == null) result = caseModelElementCS(operationRefCS);
				if (result == null) result = caseElementCS(operationRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PACKAGE_CS: {
				PackageCS packageCS = (PackageCS)theEObject;
				T1 result = casePackageCS(packageCS);
				if (result == null) result = caseNamespaceCS(packageCS);
				if (result == null) result = caseNamedElementCS(packageCS);
				if (result == null) result = caseModelElementCS(packageCS);
				if (result == null) result = caseElementCS(packageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PACKAGE_REF_CS: {
				PackageRefCS packageRefCS = (PackageRefCS)theEObject;
				T1 result = casePackageRefCS(packageRefCS);
				if (result == null) result = caseModelElementCS(packageRefCS);
				if (result == null) result = caseElementCS(packageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PARAMETER_CS: {
				ParameterCS parameterCS = (ParameterCS)theEObject;
				T1 result = caseParameterCS(parameterCS);
				if (result == null) result = caseTypedElementCS(parameterCS);
				if (result == null) result = caseNamedElementCS(parameterCS);
				if (result == null) result = caseModelElementCS(parameterCS);
				if (result == null) result = caseElementCS(parameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS: {
				ParameterizedTypeRefCS parameterizedTypeRefCS = (ParameterizedTypeRefCS)theEObject;
				T1 result = caseParameterizedTypeRefCS(parameterizedTypeRefCS);
				if (result == null) result = caseTypedRefCS(parameterizedTypeRefCS);
				if (result == null) result = caseTypeRefCS(parameterizedTypeRefCS);
				if (result == null) result = caseModelElementCS(parameterizedTypeRefCS);
				if (result == null) result = caseElementCS(parameterizedTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PRIMITIVE_TYPE_REF_CS: {
				PrimitiveTypeRefCS primitiveTypeRefCS = (PrimitiveTypeRefCS)theEObject;
				T1 result = casePrimitiveTypeRefCS(primitiveTypeRefCS);
				if (result == null) result = caseTypedRefCS(primitiveTypeRefCS);
				if (result == null) result = caseNamedElementCS(primitiveTypeRefCS);
				if (result == null) result = caseTypeRefCS(primitiveTypeRefCS);
				if (result == null) result = caseModelElementCS(primitiveTypeRefCS);
				if (result == null) result = caseElementCS(primitiveTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS: {
				QualifiedClassifierRefCS qualifiedClassifierRefCS = (QualifiedClassifierRefCS)theEObject;
				T1 result = caseQualifiedClassifierRefCS(qualifiedClassifierRefCS);
				if (result == null) result = caseClassifierRefCS(qualifiedClassifierRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedClassifierRefCS);
				if (result == null) result = caseModelElementCS(qualifiedClassifierRefCS);
				if (result == null) result = caseElementCS(qualifiedClassifierRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_OPERATION_REF_CS: {
				QualifiedOperationRefCS qualifiedOperationRefCS = (QualifiedOperationRefCS)theEObject;
				T1 result = caseQualifiedOperationRefCS(qualifiedOperationRefCS);
				if (result == null) result = caseOperationRefCS(qualifiedOperationRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedOperationRefCS);
				if (result == null) result = caseModelElementCS(qualifiedOperationRefCS);
				if (result == null) result = caseElementCS(qualifiedOperationRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_PACKAGE_REF_CS: {
				QualifiedPackageRefCS qualifiedPackageRefCS = (QualifiedPackageRefCS)theEObject;
				T1 result = caseQualifiedPackageRefCS(qualifiedPackageRefCS);
				if (result == null) result = casePackageRefCS(qualifiedPackageRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedPackageRefCS);
				if (result == null) result = caseModelElementCS(qualifiedPackageRefCS);
				if (result == null) result = caseElementCS(qualifiedPackageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_REF_CS: {
				QualifiedRefCS<?> qualifiedRefCS = (QualifiedRefCS<?>)theEObject;
				T1 result = caseQualifiedRefCS(qualifiedRefCS);
				if (result == null) result = caseModelElementCS(qualifiedRefCS);
				if (result == null) result = caseElementCS(qualifiedRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS: {
				QualifiedStructuralFeatureRefCS qualifiedStructuralFeatureRefCS = (QualifiedStructuralFeatureRefCS)theEObject;
				T1 result = caseQualifiedStructuralFeatureRefCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseStructuralFeatureRefCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseModelElementCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseElementCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_TYPE_REF_CS: {
				QualifiedTypeRefCS qualifiedTypeRefCS = (QualifiedTypeRefCS)theEObject;
				T1 result = caseQualifiedTypeRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseParameterizedTypeRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseTypedRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseTypeRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseModelElementCS(qualifiedTypeRefCS);
				if (result == null) result = caseElementCS(qualifiedTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.REFERENCE_CS: {
				ReferenceCS referenceCS = (ReferenceCS)theEObject;
				T1 result = caseReferenceCS(referenceCS);
				if (result == null) result = caseStructuralFeatureCS(referenceCS);
				if (result == null) result = caseFeatureCS(referenceCS);
				if (result == null) result = caseTypedElementCS(referenceCS);
				if (result == null) result = caseNamedElementCS(referenceCS);
				if (result == null) result = caseModelElementCS(referenceCS);
				if (result == null) result = caseElementCS(referenceCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.REFERENCE_CS_REF: {
				ReferenceCSRef referenceCSRef = (ReferenceCSRef)theEObject;
				T1 result = caseReferenceCSRef(referenceCSRef);
				if (result == null) result = caseElementCS(referenceCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_CLASSIFIER_REF_CS: {
				SimpleClassifierRefCS simpleClassifierRefCS = (SimpleClassifierRefCS)theEObject;
				T1 result = caseSimpleClassifierRefCS(simpleClassifierRefCS);
				if (result == null) result = caseClassifierRefCS(simpleClassifierRefCS);
				if (result == null) result = caseModelElementCS(simpleClassifierRefCS);
				if (result == null) result = caseElementCS(simpleClassifierRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_OPERATION_REF_CS: {
				SimpleOperationRefCS simpleOperationRefCS = (SimpleOperationRefCS)theEObject;
				T1 result = caseSimpleOperationRefCS(simpleOperationRefCS);
				if (result == null) result = caseOperationRefCS(simpleOperationRefCS);
				if (result == null) result = caseModelElementCS(simpleOperationRefCS);
				if (result == null) result = caseElementCS(simpleOperationRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_PACKAGE_REF_CS: {
				SimplePackageRefCS simplePackageRefCS = (SimplePackageRefCS)theEObject;
				T1 result = caseSimplePackageRefCS(simplePackageRefCS);
				if (result == null) result = casePackageRefCS(simplePackageRefCS);
				if (result == null) result = caseModelElementCS(simplePackageRefCS);
				if (result == null) result = caseElementCS(simplePackageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_STRUCTURAL_FEATURE_REF_CS: {
				SimpleStructuralFeatureRefCS simpleStructuralFeatureRefCS = (SimpleStructuralFeatureRefCS)theEObject;
				T1 result = caseSimpleStructuralFeatureRefCS(simpleStructuralFeatureRefCS);
				if (result == null) result = caseStructuralFeatureRefCS(simpleStructuralFeatureRefCS);
				if (result == null) result = caseModelElementCS(simpleStructuralFeatureRefCS);
				if (result == null) result = caseElementCS(simpleStructuralFeatureRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.STRUCTURAL_FEATURE_CS: {
				StructuralFeatureCS structuralFeatureCS = (StructuralFeatureCS)theEObject;
				T1 result = caseStructuralFeatureCS(structuralFeatureCS);
				if (result == null) result = caseFeatureCS(structuralFeatureCS);
				if (result == null) result = caseTypedElementCS(structuralFeatureCS);
				if (result == null) result = caseNamedElementCS(structuralFeatureCS);
				if (result == null) result = caseModelElementCS(structuralFeatureCS);
				if (result == null) result = caseElementCS(structuralFeatureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.STRUCTURAL_FEATURE_REF_CS: {
				StructuralFeatureRefCS structuralFeatureRefCS = (StructuralFeatureRefCS)theEObject;
				T1 result = caseStructuralFeatureRefCS(structuralFeatureRefCS);
				if (result == null) result = caseModelElementCS(structuralFeatureRefCS);
				if (result == null) result = caseElementCS(structuralFeatureRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_BINDING_CS: {
				TypeBindingCS typeBindingCS = (TypeBindingCS)theEObject;
				T1 result = caseTypeBindingCS(typeBindingCS);
				if (result == null) result = caseElementCS(typeBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_BINDINGS_CS: {
				TypeBindingsCS typeBindingsCS = (TypeBindingsCS)theEObject;
				T1 result = caseTypeBindingsCS(typeBindingsCS);
				if (result == null) result = caseElementCS(typeBindingsCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_CS: {
				TypeCS typeCS = (TypeCS)theEObject;
				T1 result = caseTypeCS(typeCS);
				if (result == null) result = caseElementCS(typeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_PARAMETER_CS: {
				TypeParameterCS typeParameterCS = (TypeParameterCS)theEObject;
				T1 result = caseTypeParameterCS(typeParameterCS);
				if (result == null) result = caseNamedElementCS(typeParameterCS);
				if (result == null) result = caseTypeCS(typeParameterCS);
				if (result == null) result = caseModelElementCS(typeParameterCS);
				if (result == null) result = caseElementCS(typeParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_REF_CS: {
				TypeRefCS typeRefCS = (TypeRefCS)theEObject;
				T1 result = caseTypeRefCS(typeRefCS);
				if (result == null) result = caseModelElementCS(typeRefCS);
				if (result == null) result = caseElementCS(typeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPED_ELEMENT_CS: {
				TypedElementCS typedElementCS = (TypedElementCS)theEObject;
				T1 result = caseTypedElementCS(typedElementCS);
				if (result == null) result = caseNamedElementCS(typedElementCS);
				if (result == null) result = caseModelElementCS(typedElementCS);
				if (result == null) result = caseElementCS(typedElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPED_REF_CS: {
				TypedRefCS typedRefCS = (TypedRefCS)theEObject;
				T1 result = caseTypedRefCS(typedRefCS);
				if (result == null) result = caseTypeRefCS(typedRefCS);
				if (result == null) result = caseModelElementCS(typedRefCS);
				if (result == null) result = caseElementCS(typedRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPED_TYPE_REF_CS: {
				TypedTypeRefCS typedTypeRefCS = (TypedTypeRefCS)theEObject;
				T1 result = caseTypedTypeRefCS(typedTypeRefCS);
				if (result == null) result = caseParameterizedTypeRefCS(typedTypeRefCS);
				if (result == null) result = caseTypedRefCS(typedTypeRefCS);
				if (result == null) result = caseTypeRefCS(typedTypeRefCS);
				if (result == null) result = caseModelElementCS(typedTypeRefCS);
				if (result == null) result = caseElementCS(typedTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.WILDCARD_TYPE_REF_CS: {
				WildcardTypeRefCS wildcardTypeRefCS = (WildcardTypeRefCS)theEObject;
				T1 result = caseWildcardTypeRefCS(wildcardTypeRefCS);
				if (result == null) result = caseTypeRefCS(wildcardTypeRefCS);
				if (result == null) result = caseModelElementCS(wildcardTypeRefCS);
				if (result == null) result = caseElementCS(wildcardTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAnnotationElementCS(AnnotationElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttributeCS(AttributeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute CS Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttributeCSRef(AttributeCSRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoundClassCS(BoundClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Classifier CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Classifier CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoundClassifierCS(BoundClassifierCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Document CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoundDocumentCS(BoundDocumentCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends NamedElementCS> T1 caseBoundElementCS(BoundElementCS<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoundOperationCS(BoundOperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseClassCS(ClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseClassCSRef(ClassCSRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseClassifierCS(ClassifierCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseClassifierRefCS(ClassifierRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionTypeRefCS(CollectionTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Detail CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Detail CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDetailCS(DetailCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDocumentCS(DocumentCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumLiteralCS(EnumLiteralCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeatureCS(FeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImportCS(ImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLibraryCS(LibraryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModelElementCSRef(ModelElementCSRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNamespaceCS(NamespaceCS object) {
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
	public T1 caseOperationCS(OperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationRefCS(OperationRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackageCS(PackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackageRefCS(PackageRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameterCS(ParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameterizedTypeRefCS(ParameterizedTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePrimitiveTypeRefCS(PrimitiveTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Classifier Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Classifier Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseQualifiedClassifierRefCS(QualifiedClassifierRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Operation Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Operation Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseQualifiedOperationRefCS(QualifiedOperationRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Package Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseQualifiedPackageRefCS(QualifiedPackageRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <E extends ElementCS> T1 caseQualifiedRefCS(QualifiedRefCS<E> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Structural Feature Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Structural Feature Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseQualifiedStructuralFeatureRefCS(QualifiedStructuralFeatureRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseQualifiedTypeRefCS(QualifiedTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReferenceCS(ReferenceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference CS Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference CS Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReferenceCSRef(ReferenceCSRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Classifier Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Classifier Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSimpleClassifierRefCS(SimpleClassifierRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Operation Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Operation Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSimpleOperationRefCS(SimpleOperationRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Package Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSimplePackageRefCS(SimplePackageRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Structural Feature Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Structural Feature Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSimpleStructuralFeatureRefCS(SimpleStructuralFeatureRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructuralFeatureCS(StructuralFeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructuralFeatureRefCS(StructuralFeatureRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeBindingCS(TypeBindingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Bindings CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Bindings CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeBindingsCS(TypeBindingsCS object) {
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
	public T1 caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeParameterCS(TypeParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeRefCS(TypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedElementCS(TypedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedRefCS(TypedRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedTypeRefCS(TypedTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wildcard Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wildcard Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWildcardTypeRefCS(WildcardTypeRefCS object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //BaseCSTSwitch
