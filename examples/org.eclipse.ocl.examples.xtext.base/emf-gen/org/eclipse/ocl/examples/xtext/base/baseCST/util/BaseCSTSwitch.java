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
 * $Id: BaseCSTSwitch.java,v 1.4 2011/01/24 20:59:32 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.util.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

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
public class BaseCSTSwitch<T> {
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
		if (modelPackage == null)
		{
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
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
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
		switch (classifierID)
		{
			case BaseCSTPackage.ANNOTATION_CS:
			{
				AnnotationCS annotationCS = (AnnotationCS)theEObject;
				T result = caseAnnotationCS(annotationCS);
				if (result == null) result = caseAnnotationElementCS(annotationCS);
				if (result == null) result = caseNamedElementCS(annotationCS);
				if (result == null) result = caseMonikeredElementCS(annotationCS);
				if (result == null) result = caseNameable(annotationCS);
				if (result == null) result = caseModelElementCS(annotationCS);
				if (result == null) result = caseElementCS(annotationCS);
				if (result == null) result = casePivotable(annotationCS);
				if (result == null) result = caseVisitableCS(annotationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ANNOTATION_ELEMENT_CS:
			{
				AnnotationElementCS annotationElementCS = (AnnotationElementCS)theEObject;
				T result = caseAnnotationElementCS(annotationElementCS);
				if (result == null) result = caseNamedElementCS(annotationElementCS);
				if (result == null) result = caseMonikeredElementCS(annotationElementCS);
				if (result == null) result = caseNameable(annotationElementCS);
				if (result == null) result = caseModelElementCS(annotationElementCS);
				if (result == null) result = caseElementCS(annotationElementCS);
				if (result == null) result = casePivotable(annotationElementCS);
				if (result == null) result = caseVisitableCS(annotationElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ATTRIBUTE_CS:
			{
				AttributeCS attributeCS = (AttributeCS)theEObject;
				T result = caseAttributeCS(attributeCS);
				if (result == null) result = caseStructuralFeatureCS(attributeCS);
				if (result == null) result = caseFeatureCS(attributeCS);
				if (result == null) result = caseTypedElementCS(attributeCS);
				if (result == null) result = caseNamedElementCS(attributeCS);
				if (result == null) result = caseMonikeredElementCS(attributeCS);
				if (result == null) result = caseNameable(attributeCS);
				if (result == null) result = caseModelElementCS(attributeCS);
				if (result == null) result = caseElementCS(attributeCS);
				if (result == null) result = casePivotable(attributeCS);
				if (result == null) result = caseVisitableCS(attributeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ATTRIBUTE_CS_REF:
			{
				AttributeCSRef attributeCSRef = (AttributeCSRef)theEObject;
				T result = caseAttributeCSRef(attributeCSRef);
				if (result == null) result = caseElementCS(attributeCSRef);
				if (result == null) result = caseVisitableCS(attributeCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.BOUND_DOCUMENT_CS:
			{
				BoundDocumentCS boundDocumentCS = (BoundDocumentCS)theEObject;
				T result = caseBoundDocumentCS(boundDocumentCS);
				if (result == null) result = casePackageCS(boundDocumentCS);
				if (result == null) result = caseNamespaceCS(boundDocumentCS);
				if (result == null) result = caseNamedElementCS(boundDocumentCS);
				if (result == null) result = caseMonikeredElementCS(boundDocumentCS);
				if (result == null) result = caseNameable(boundDocumentCS);
				if (result == null) result = caseModelElementCS(boundDocumentCS);
				if (result == null) result = caseElementCS(boundDocumentCS);
				if (result == null) result = casePivotable(boundDocumentCS);
				if (result == null) result = caseVisitableCS(boundDocumentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASS_CS:
			{
				ClassCS classCS = (ClassCS)theEObject;
				T result = caseClassCS(classCS);
				if (result == null) result = caseClassifierCS(classCS);
				if (result == null) result = caseNamespaceCS(classCS);
				if (result == null) result = caseNamedElementCS(classCS);
				if (result == null) result = caseTypeCS(classCS);
				if (result == null) result = caseTemplateableElementCS(classCS);
				if (result == null) result = caseParameterableElementCS(classCS);
				if (result == null) result = caseMonikeredElementCS(classCS);
				if (result == null) result = caseNameable(classCS);
				if (result == null) result = caseModelElementCS(classCS);
				if (result == null) result = caseElementCS(classCS);
				if (result == null) result = casePivotable(classCS);
				if (result == null) result = caseVisitableCS(classCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASS_CS_REF:
			{
				ClassCSRef classCSRef = (ClassCSRef)theEObject;
				T result = caseClassCSRef(classCSRef);
				if (result == null) result = caseElementCS(classCSRef);
				if (result == null) result = caseVisitableCS(classCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASSIFIER_CS:
			{
				ClassifierCS classifierCS = (ClassifierCS)theEObject;
				T result = caseClassifierCS(classifierCS);
				if (result == null) result = caseNamedElementCS(classifierCS);
				if (result == null) result = caseTypeCS(classifierCS);
				if (result == null) result = caseTemplateableElementCS(classifierCS);
				if (result == null) result = caseParameterableElementCS(classifierCS);
				if (result == null) result = caseMonikeredElementCS(classifierCS);
				if (result == null) result = caseNameable(classifierCS);
				if (result == null) result = caseModelElementCS(classifierCS);
				if (result == null) result = caseElementCS(classifierCS);
				if (result == null) result = casePivotable(classifierCS);
				if (result == null) result = caseVisitableCS(classifierCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CLASSIFIER_REF_CS:
			{
				ClassifierRefCS classifierRefCS = (ClassifierRefCS)theEObject;
				T result = caseClassifierRefCS(classifierRefCS);
				if (result == null) result = caseModelElementCS(classifierRefCS);
				if (result == null) result = caseElementCS(classifierRefCS);
				if (result == null) result = casePivotable(classifierRefCS);
				if (result == null) result = caseVisitableCS(classifierRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.COLLECTION_TYPE_REF_CS:
			{
				CollectionTypeRefCS collectionTypeRefCS = (CollectionTypeRefCS)theEObject;
				T result = caseCollectionTypeRefCS(collectionTypeRefCS);
				if (result == null) result = caseTypedTypeRefCS(collectionTypeRefCS);
				if (result == null) result = caseParameterizedTypeRefCS(collectionTypeRefCS);
				if (result == null) result = caseTypedRefCS(collectionTypeRefCS);
				if (result == null) result = caseTypeRefCS(collectionTypeRefCS);
				if (result == null) result = caseParameterableElementCS(collectionTypeRefCS);
				if (result == null) result = caseMonikeredElementCS(collectionTypeRefCS);
				if (result == null) result = caseModelElementCS(collectionTypeRefCS);
				if (result == null) result = caseElementCS(collectionTypeRefCS);
				if (result == null) result = casePivotable(collectionTypeRefCS);
				if (result == null) result = caseVisitableCS(collectionTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.CONSTRAINT_CS:
			{
				ConstraintCS constraintCS = (ConstraintCS)theEObject;
				T result = caseConstraintCS(constraintCS);
				if (result == null) result = caseNamedElementCS(constraintCS);
				if (result == null) result = caseMonikeredElementCS(constraintCS);
				if (result == null) result = caseNameable(constraintCS);
				if (result == null) result = caseModelElementCS(constraintCS);
				if (result == null) result = caseElementCS(constraintCS);
				if (result == null) result = casePivotable(constraintCS);
				if (result == null) result = caseVisitableCS(constraintCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.DATA_TYPE_CS:
			{
				DataTypeCS dataTypeCS = (DataTypeCS)theEObject;
				T result = caseDataTypeCS(dataTypeCS);
				if (result == null) result = caseClassifierCS(dataTypeCS);
				if (result == null) result = caseNamespaceCS(dataTypeCS);
				if (result == null) result = caseNamedElementCS(dataTypeCS);
				if (result == null) result = caseTypeCS(dataTypeCS);
				if (result == null) result = caseTemplateableElementCS(dataTypeCS);
				if (result == null) result = caseParameterableElementCS(dataTypeCS);
				if (result == null) result = caseMonikeredElementCS(dataTypeCS);
				if (result == null) result = caseNameable(dataTypeCS);
				if (result == null) result = caseModelElementCS(dataTypeCS);
				if (result == null) result = caseElementCS(dataTypeCS);
				if (result == null) result = casePivotable(dataTypeCS);
				if (result == null) result = caseVisitableCS(dataTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.DETAIL_CS:
			{
				DetailCS detailCS = (DetailCS)theEObject;
				T result = caseDetailCS(detailCS);
				if (result == null) result = caseNamedElementCS(detailCS);
				if (result == null) result = caseMonikeredElementCS(detailCS);
				if (result == null) result = caseNameable(detailCS);
				if (result == null) result = caseModelElementCS(detailCS);
				if (result == null) result = caseElementCS(detailCS);
				if (result == null) result = casePivotable(detailCS);
				if (result == null) result = caseVisitableCS(detailCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.DOCUMENTATION_CS:
			{
				DocumentationCS documentationCS = (DocumentationCS)theEObject;
				T result = caseDocumentationCS(documentationCS);
				if (result == null) result = caseAnnotationElementCS(documentationCS);
				if (result == null) result = caseNamedElementCS(documentationCS);
				if (result == null) result = caseMonikeredElementCS(documentationCS);
				if (result == null) result = caseNameable(documentationCS);
				if (result == null) result = caseModelElementCS(documentationCS);
				if (result == null) result = caseElementCS(documentationCS);
				if (result == null) result = casePivotable(documentationCS);
				if (result == null) result = caseVisitableCS(documentationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ELEMENT_CS:
			{
				ElementCS elementCS = (ElementCS)theEObject;
				T result = caseElementCS(elementCS);
				if (result == null) result = caseVisitableCS(elementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ENUMERATION_CS:
			{
				EnumerationCS enumerationCS = (EnumerationCS)theEObject;
				T result = caseEnumerationCS(enumerationCS);
				if (result == null) result = caseClassifierCS(enumerationCS);
				if (result == null) result = caseNamespaceCS(enumerationCS);
				if (result == null) result = caseNamedElementCS(enumerationCS);
				if (result == null) result = caseTypeCS(enumerationCS);
				if (result == null) result = caseTemplateableElementCS(enumerationCS);
				if (result == null) result = caseParameterableElementCS(enumerationCS);
				if (result == null) result = caseMonikeredElementCS(enumerationCS);
				if (result == null) result = caseNameable(enumerationCS);
				if (result == null) result = caseModelElementCS(enumerationCS);
				if (result == null) result = caseElementCS(enumerationCS);
				if (result == null) result = casePivotable(enumerationCS);
				if (result == null) result = caseVisitableCS(enumerationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ENUMERATION_LITERAL_CS:
			{
				EnumerationLiteralCS enumerationLiteralCS = (EnumerationLiteralCS)theEObject;
				T result = caseEnumerationLiteralCS(enumerationLiteralCS);
				if (result == null) result = caseNamedElementCS(enumerationLiteralCS);
				if (result == null) result = caseMonikeredElementCS(enumerationLiteralCS);
				if (result == null) result = caseNameable(enumerationLiteralCS);
				if (result == null) result = caseModelElementCS(enumerationLiteralCS);
				if (result == null) result = caseElementCS(enumerationLiteralCS);
				if (result == null) result = casePivotable(enumerationLiteralCS);
				if (result == null) result = caseVisitableCS(enumerationLiteralCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.FEATURE_CS:
			{
				FeatureCS featureCS = (FeatureCS)theEObject;
				T result = caseFeatureCS(featureCS);
				if (result == null) result = caseTypedElementCS(featureCS);
				if (result == null) result = caseNamedElementCS(featureCS);
				if (result == null) result = caseMonikeredElementCS(featureCS);
				if (result == null) result = caseNameable(featureCS);
				if (result == null) result = caseModelElementCS(featureCS);
				if (result == null) result = caseElementCS(featureCS);
				if (result == null) result = casePivotable(featureCS);
				if (result == null) result = caseVisitableCS(featureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.IMPORT_CS:
			{
				ImportCS importCS = (ImportCS)theEObject;
				T result = caseImportCS(importCS);
				if (result == null) result = caseNamespaceCS(importCS);
				if (result == null) result = caseNamedElementCS(importCS);
				if (result == null) result = caseMonikeredElementCS(importCS);
				if (result == null) result = caseNameable(importCS);
				if (result == null) result = caseModelElementCS(importCS);
				if (result == null) result = caseElementCS(importCS);
				if (result == null) result = casePivotable(importCS);
				if (result == null) result = caseVisitableCS(importCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.LIBRARY_CS:
			{
				LibraryCS libraryCS = (LibraryCS)theEObject;
				T result = caseLibraryCS(libraryCS);
				if (result == null) result = caseNamespaceCS(libraryCS);
				if (result == null) result = caseNamedElementCS(libraryCS);
				if (result == null) result = caseMonikeredElementCS(libraryCS);
				if (result == null) result = caseNameable(libraryCS);
				if (result == null) result = caseModelElementCS(libraryCS);
				if (result == null) result = caseElementCS(libraryCS);
				if (result == null) result = casePivotable(libraryCS);
				if (result == null) result = caseVisitableCS(libraryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.MODEL_ELEMENT_CS:
			{
				ModelElementCS modelElementCS = (ModelElementCS)theEObject;
				T result = caseModelElementCS(modelElementCS);
				if (result == null) result = caseElementCS(modelElementCS);
				if (result == null) result = casePivotable(modelElementCS);
				if (result == null) result = caseVisitableCS(modelElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.MODEL_ELEMENT_CS_REF:
			{
				ModelElementCSRef modelElementCSRef = (ModelElementCSRef)theEObject;
				T result = caseModelElementCSRef(modelElementCSRef);
				if (result == null) result = caseElementCS(modelElementCSRef);
				if (result == null) result = caseVisitableCS(modelElementCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.MONIKERED_ELEMENT_CS:
			{
				MonikeredElementCS monikeredElementCS = (MonikeredElementCS)theEObject;
				T result = caseMonikeredElementCS(monikeredElementCS);
				if (result == null) result = caseModelElementCS(monikeredElementCS);
				if (result == null) result = caseElementCS(monikeredElementCS);
				if (result == null) result = casePivotable(monikeredElementCS);
				if (result == null) result = caseVisitableCS(monikeredElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.NAMED_ELEMENT_CS:
			{
				NamedElementCS namedElementCS = (NamedElementCS)theEObject;
				T result = caseNamedElementCS(namedElementCS);
				if (result == null) result = caseMonikeredElementCS(namedElementCS);
				if (result == null) result = caseNameable(namedElementCS);
				if (result == null) result = caseModelElementCS(namedElementCS);
				if (result == null) result = caseElementCS(namedElementCS);
				if (result == null) result = casePivotable(namedElementCS);
				if (result == null) result = caseVisitableCS(namedElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.NAMESPACE_CS:
			{
				NamespaceCS namespaceCS = (NamespaceCS)theEObject;
				T result = caseNamespaceCS(namespaceCS);
				if (result == null) result = caseNamedElementCS(namespaceCS);
				if (result == null) result = caseMonikeredElementCS(namespaceCS);
				if (result == null) result = caseNameable(namespaceCS);
				if (result == null) result = caseModelElementCS(namespaceCS);
				if (result == null) result = caseElementCS(namespaceCS);
				if (result == null) result = casePivotable(namespaceCS);
				if (result == null) result = caseVisitableCS(namespaceCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.OPERATION_CS:
			{
				OperationCS operationCS = (OperationCS)theEObject;
				T result = caseOperationCS(operationCS);
				if (result == null) result = caseFeatureCS(operationCS);
				if (result == null) result = caseTemplateableElementCS(operationCS);
				if (result == null) result = caseTypedElementCS(operationCS);
				if (result == null) result = caseNamedElementCS(operationCS);
				if (result == null) result = caseMonikeredElementCS(operationCS);
				if (result == null) result = caseNameable(operationCS);
				if (result == null) result = caseModelElementCS(operationCS);
				if (result == null) result = caseElementCS(operationCS);
				if (result == null) result = casePivotable(operationCS);
				if (result == null) result = caseVisitableCS(operationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.OPERATION_REF_CS:
			{
				OperationRefCS operationRefCS = (OperationRefCS)theEObject;
				T result = caseOperationRefCS(operationRefCS);
				if (result == null) result = caseModelElementCS(operationRefCS);
				if (result == null) result = caseElementCS(operationRefCS);
				if (result == null) result = casePivotable(operationRefCS);
				if (result == null) result = caseVisitableCS(operationRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PACKAGE_CS:
			{
				PackageCS packageCS = (PackageCS)theEObject;
				T result = casePackageCS(packageCS);
				if (result == null) result = caseNamespaceCS(packageCS);
				if (result == null) result = caseNamedElementCS(packageCS);
				if (result == null) result = caseMonikeredElementCS(packageCS);
				if (result == null) result = caseNameable(packageCS);
				if (result == null) result = caseModelElementCS(packageCS);
				if (result == null) result = caseElementCS(packageCS);
				if (result == null) result = casePivotable(packageCS);
				if (result == null) result = caseVisitableCS(packageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PACKAGE_REF_CS:
			{
				PackageRefCS packageRefCS = (PackageRefCS)theEObject;
				T result = casePackageRefCS(packageRefCS);
				if (result == null) result = caseMonikeredElementCS(packageRefCS);
				if (result == null) result = caseModelElementCS(packageRefCS);
				if (result == null) result = caseElementCS(packageRefCS);
				if (result == null) result = casePivotable(packageRefCS);
				if (result == null) result = caseVisitableCS(packageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PARAMETER_CS:
			{
				ParameterCS parameterCS = (ParameterCS)theEObject;
				T result = caseParameterCS(parameterCS);
				if (result == null) result = caseTypedElementCS(parameterCS);
				if (result == null) result = caseNamedElementCS(parameterCS);
				if (result == null) result = caseMonikeredElementCS(parameterCS);
				if (result == null) result = caseNameable(parameterCS);
				if (result == null) result = caseModelElementCS(parameterCS);
				if (result == null) result = caseElementCS(parameterCS);
				if (result == null) result = casePivotable(parameterCS);
				if (result == null) result = caseVisitableCS(parameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PARAMETERABLE_ELEMENT_CS:
			{
				ParameterableElementCS parameterableElementCS = (ParameterableElementCS)theEObject;
				T result = caseParameterableElementCS(parameterableElementCS);
				if (result == null) result = caseMonikeredElementCS(parameterableElementCS);
				if (result == null) result = caseModelElementCS(parameterableElementCS);
				if (result == null) result = caseElementCS(parameterableElementCS);
				if (result == null) result = casePivotable(parameterableElementCS);
				if (result == null) result = caseVisitableCS(parameterableElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS:
			{
				ParameterizedTypeRefCS parameterizedTypeRefCS = (ParameterizedTypeRefCS)theEObject;
				T result = caseParameterizedTypeRefCS(parameterizedTypeRefCS);
				if (result == null) result = caseTypedRefCS(parameterizedTypeRefCS);
				if (result == null) result = caseTypeRefCS(parameterizedTypeRefCS);
				if (result == null) result = caseParameterableElementCS(parameterizedTypeRefCS);
				if (result == null) result = caseMonikeredElementCS(parameterizedTypeRefCS);
				if (result == null) result = caseModelElementCS(parameterizedTypeRefCS);
				if (result == null) result = caseElementCS(parameterizedTypeRefCS);
				if (result == null) result = casePivotable(parameterizedTypeRefCS);
				if (result == null) result = caseVisitableCS(parameterizedTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.PRIMITIVE_TYPE_REF_CS:
			{
				PrimitiveTypeRefCS primitiveTypeRefCS = (PrimitiveTypeRefCS)theEObject;
				T result = casePrimitiveTypeRefCS(primitiveTypeRefCS);
				if (result == null) result = caseTypedRefCS(primitiveTypeRefCS);
				if (result == null) result = caseNamedElementCS(primitiveTypeRefCS);
				if (result == null) result = caseTypeRefCS(primitiveTypeRefCS);
				if (result == null) result = caseNameable(primitiveTypeRefCS);
				if (result == null) result = caseParameterableElementCS(primitiveTypeRefCS);
				if (result == null) result = caseMonikeredElementCS(primitiveTypeRefCS);
				if (result == null) result = caseModelElementCS(primitiveTypeRefCS);
				if (result == null) result = caseElementCS(primitiveTypeRefCS);
				if (result == null) result = casePivotable(primitiveTypeRefCS);
				if (result == null) result = caseVisitableCS(primitiveTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS:
			{
				QualifiedClassifierRefCS qualifiedClassifierRefCS = (QualifiedClassifierRefCS)theEObject;
				T result = caseQualifiedClassifierRefCS(qualifiedClassifierRefCS);
				if (result == null) result = caseClassifierRefCS(qualifiedClassifierRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedClassifierRefCS);
				if (result == null) result = caseModelElementCS(qualifiedClassifierRefCS);
				if (result == null) result = caseElementCS(qualifiedClassifierRefCS);
				if (result == null) result = casePivotable(qualifiedClassifierRefCS);
				if (result == null) result = caseVisitableCS(qualifiedClassifierRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_OPERATION_REF_CS:
			{
				QualifiedOperationRefCS qualifiedOperationRefCS = (QualifiedOperationRefCS)theEObject;
				T result = caseQualifiedOperationRefCS(qualifiedOperationRefCS);
				if (result == null) result = caseOperationRefCS(qualifiedOperationRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedOperationRefCS);
				if (result == null) result = caseModelElementCS(qualifiedOperationRefCS);
				if (result == null) result = caseElementCS(qualifiedOperationRefCS);
				if (result == null) result = casePivotable(qualifiedOperationRefCS);
				if (result == null) result = caseVisitableCS(qualifiedOperationRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_PACKAGE_REF_CS:
			{
				QualifiedPackageRefCS qualifiedPackageRefCS = (QualifiedPackageRefCS)theEObject;
				T result = caseQualifiedPackageRefCS(qualifiedPackageRefCS);
				if (result == null) result = casePackageRefCS(qualifiedPackageRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedPackageRefCS);
				if (result == null) result = caseMonikeredElementCS(qualifiedPackageRefCS);
				if (result == null) result = caseModelElementCS(qualifiedPackageRefCS);
				if (result == null) result = caseElementCS(qualifiedPackageRefCS);
				if (result == null) result = casePivotable(qualifiedPackageRefCS);
				if (result == null) result = caseVisitableCS(qualifiedPackageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_REF_CS:
			{
				QualifiedRefCS<?> qualifiedRefCS = (QualifiedRefCS<?>)theEObject;
				T result = caseQualifiedRefCS(qualifiedRefCS);
				if (result == null) result = caseModelElementCS(qualifiedRefCS);
				if (result == null) result = caseElementCS(qualifiedRefCS);
				if (result == null) result = casePivotable(qualifiedRefCS);
				if (result == null) result = caseVisitableCS(qualifiedRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS:
			{
				QualifiedStructuralFeatureRefCS qualifiedStructuralFeatureRefCS = (QualifiedStructuralFeatureRefCS)theEObject;
				T result = caseQualifiedStructuralFeatureRefCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseStructuralFeatureRefCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseModelElementCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseElementCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = casePivotable(qualifiedStructuralFeatureRefCS);
				if (result == null) result = caseVisitableCS(qualifiedStructuralFeatureRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.QUALIFIED_TYPE_REF_CS:
			{
				QualifiedTypeRefCS qualifiedTypeRefCS = (QualifiedTypeRefCS)theEObject;
				T result = caseQualifiedTypeRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseParameterizedTypeRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseQualifiedRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseTypedRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseTypeRefCS(qualifiedTypeRefCS);
				if (result == null) result = caseParameterableElementCS(qualifiedTypeRefCS);
				if (result == null) result = caseMonikeredElementCS(qualifiedTypeRefCS);
				if (result == null) result = caseModelElementCS(qualifiedTypeRefCS);
				if (result == null) result = caseElementCS(qualifiedTypeRefCS);
				if (result == null) result = casePivotable(qualifiedTypeRefCS);
				if (result == null) result = caseVisitableCS(qualifiedTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.REFERENCE_CS:
			{
				ReferenceCS referenceCS = (ReferenceCS)theEObject;
				T result = caseReferenceCS(referenceCS);
				if (result == null) result = caseStructuralFeatureCS(referenceCS);
				if (result == null) result = caseFeatureCS(referenceCS);
				if (result == null) result = caseTypedElementCS(referenceCS);
				if (result == null) result = caseNamedElementCS(referenceCS);
				if (result == null) result = caseMonikeredElementCS(referenceCS);
				if (result == null) result = caseNameable(referenceCS);
				if (result == null) result = caseModelElementCS(referenceCS);
				if (result == null) result = caseElementCS(referenceCS);
				if (result == null) result = casePivotable(referenceCS);
				if (result == null) result = caseVisitableCS(referenceCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.REFERENCE_CS_REF:
			{
				ReferenceCSRef referenceCSRef = (ReferenceCSRef)theEObject;
				T result = caseReferenceCSRef(referenceCSRef);
				if (result == null) result = caseElementCS(referenceCSRef);
				if (result == null) result = caseVisitableCS(referenceCSRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ROOT_CS:
			{
				RootCS rootCS = (RootCS)theEObject;
				T result = caseRootCS(rootCS);
				if (result == null) result = caseModelElementCS(rootCS);
				if (result == null) result = caseElementCS(rootCS);
				if (result == null) result = casePivotable(rootCS);
				if (result == null) result = caseVisitableCS(rootCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.ROOT_PACKAGE_CS:
			{
				RootPackageCS rootPackageCS = (RootPackageCS)theEObject;
				T result = caseRootPackageCS(rootPackageCS);
				if (result == null) result = casePackageCS(rootPackageCS);
				if (result == null) result = caseRootCS(rootPackageCS);
				if (result == null) result = caseNamespaceCS(rootPackageCS);
				if (result == null) result = caseNamedElementCS(rootPackageCS);
				if (result == null) result = caseMonikeredElementCS(rootPackageCS);
				if (result == null) result = caseNameable(rootPackageCS);
				if (result == null) result = caseModelElementCS(rootPackageCS);
				if (result == null) result = caseElementCS(rootPackageCS);
				if (result == null) result = casePivotable(rootPackageCS);
				if (result == null) result = caseVisitableCS(rootPackageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_CLASSIFIER_REF_CS:
			{
				SimpleClassifierRefCS simpleClassifierRefCS = (SimpleClassifierRefCS)theEObject;
				T result = caseSimpleClassifierRefCS(simpleClassifierRefCS);
				if (result == null) result = caseClassifierRefCS(simpleClassifierRefCS);
				if (result == null) result = caseModelElementCS(simpleClassifierRefCS);
				if (result == null) result = caseElementCS(simpleClassifierRefCS);
				if (result == null) result = casePivotable(simpleClassifierRefCS);
				if (result == null) result = caseVisitableCS(simpleClassifierRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_OPERATION_REF_CS:
			{
				SimpleOperationRefCS simpleOperationRefCS = (SimpleOperationRefCS)theEObject;
				T result = caseSimpleOperationRefCS(simpleOperationRefCS);
				if (result == null) result = caseOperationRefCS(simpleOperationRefCS);
				if (result == null) result = caseModelElementCS(simpleOperationRefCS);
				if (result == null) result = caseElementCS(simpleOperationRefCS);
				if (result == null) result = casePivotable(simpleOperationRefCS);
				if (result == null) result = caseVisitableCS(simpleOperationRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_PACKAGE_REF_CS:
			{
				SimplePackageRefCS simplePackageRefCS = (SimplePackageRefCS)theEObject;
				T result = caseSimplePackageRefCS(simplePackageRefCS);
				if (result == null) result = casePackageRefCS(simplePackageRefCS);
				if (result == null) result = caseMonikeredElementCS(simplePackageRefCS);
				if (result == null) result = caseModelElementCS(simplePackageRefCS);
				if (result == null) result = caseElementCS(simplePackageRefCS);
				if (result == null) result = casePivotable(simplePackageRefCS);
				if (result == null) result = caseVisitableCS(simplePackageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.SIMPLE_STRUCTURAL_FEATURE_REF_CS:
			{
				SimpleStructuralFeatureRefCS simpleStructuralFeatureRefCS = (SimpleStructuralFeatureRefCS)theEObject;
				T result = caseSimpleStructuralFeatureRefCS(simpleStructuralFeatureRefCS);
				if (result == null) result = caseStructuralFeatureRefCS(simpleStructuralFeatureRefCS);
				if (result == null) result = caseModelElementCS(simpleStructuralFeatureRefCS);
				if (result == null) result = caseElementCS(simpleStructuralFeatureRefCS);
				if (result == null) result = casePivotable(simpleStructuralFeatureRefCS);
				if (result == null) result = caseVisitableCS(simpleStructuralFeatureRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.STRUCTURAL_FEATURE_CS:
			{
				StructuralFeatureCS structuralFeatureCS = (StructuralFeatureCS)theEObject;
				T result = caseStructuralFeatureCS(structuralFeatureCS);
				if (result == null) result = caseFeatureCS(structuralFeatureCS);
				if (result == null) result = caseTypedElementCS(structuralFeatureCS);
				if (result == null) result = caseNamedElementCS(structuralFeatureCS);
				if (result == null) result = caseMonikeredElementCS(structuralFeatureCS);
				if (result == null) result = caseNameable(structuralFeatureCS);
				if (result == null) result = caseModelElementCS(structuralFeatureCS);
				if (result == null) result = caseElementCS(structuralFeatureCS);
				if (result == null) result = casePivotable(structuralFeatureCS);
				if (result == null) result = caseVisitableCS(structuralFeatureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.STRUCTURAL_FEATURE_REF_CS:
			{
				StructuralFeatureRefCS structuralFeatureRefCS = (StructuralFeatureRefCS)theEObject;
				T result = caseStructuralFeatureRefCS(structuralFeatureRefCS);
				if (result == null) result = caseModelElementCS(structuralFeatureRefCS);
				if (result == null) result = caseElementCS(structuralFeatureRefCS);
				if (result == null) result = casePivotable(structuralFeatureRefCS);
				if (result == null) result = caseVisitableCS(structuralFeatureRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TEMPLATE_BINDING_CS:
			{
				TemplateBindingCS templateBindingCS = (TemplateBindingCS)theEObject;
				T result = caseTemplateBindingCS(templateBindingCS);
				if (result == null) result = caseModelElementCS(templateBindingCS);
				if (result == null) result = caseElementCS(templateBindingCS);
				if (result == null) result = casePivotable(templateBindingCS);
				if (result == null) result = caseVisitableCS(templateBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TEMPLATE_PARAMETER_CS:
			{
				TemplateParameterCS templateParameterCS = (TemplateParameterCS)theEObject;
				T result = caseTemplateParameterCS(templateParameterCS);
				if (result == null) result = caseNamedElementCS(templateParameterCS);
				if (result == null) result = caseMonikeredElementCS(templateParameterCS);
				if (result == null) result = caseNameable(templateParameterCS);
				if (result == null) result = caseModelElementCS(templateParameterCS);
				if (result == null) result = caseElementCS(templateParameterCS);
				if (result == null) result = casePivotable(templateParameterCS);
				if (result == null) result = caseVisitableCS(templateParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
			{
				TemplateParameterSubstitutionCS templateParameterSubstitutionCS = (TemplateParameterSubstitutionCS)theEObject;
				T result = caseTemplateParameterSubstitutionCS(templateParameterSubstitutionCS);
				if (result == null) result = caseModelElementCS(templateParameterSubstitutionCS);
				if (result == null) result = caseElementCS(templateParameterSubstitutionCS);
				if (result == null) result = casePivotable(templateParameterSubstitutionCS);
				if (result == null) result = caseVisitableCS(templateParameterSubstitutionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS:
			{
				TemplateSignatureCS templateSignatureCS = (TemplateSignatureCS)theEObject;
				T result = caseTemplateSignatureCS(templateSignatureCS);
				if (result == null) result = caseMonikeredElementCS(templateSignatureCS);
				if (result == null) result = caseModelElementCS(templateSignatureCS);
				if (result == null) result = caseElementCS(templateSignatureCS);
				if (result == null) result = casePivotable(templateSignatureCS);
				if (result == null) result = caseVisitableCS(templateSignatureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS:
			{
				TemplateableElementCS templateableElementCS = (TemplateableElementCS)theEObject;
				T result = caseTemplateableElementCS(templateableElementCS);
				if (result == null) result = caseMonikeredElementCS(templateableElementCS);
				if (result == null) result = caseModelElementCS(templateableElementCS);
				if (result == null) result = caseElementCS(templateableElementCS);
				if (result == null) result = casePivotable(templateableElementCS);
				if (result == null) result = caseVisitableCS(templateableElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TUPLE_PART_CS:
			{
				TuplePartCS tuplePartCS = (TuplePartCS)theEObject;
				T result = caseTuplePartCS(tuplePartCS);
				if (result == null) result = caseTypedElementCS(tuplePartCS);
				if (result == null) result = caseNamedElementCS(tuplePartCS);
				if (result == null) result = caseMonikeredElementCS(tuplePartCS);
				if (result == null) result = caseNameable(tuplePartCS);
				if (result == null) result = caseModelElementCS(tuplePartCS);
				if (result == null) result = caseElementCS(tuplePartCS);
				if (result == null) result = casePivotable(tuplePartCS);
				if (result == null) result = caseVisitableCS(tuplePartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TUPLE_TYPE_CS:
			{
				TupleTypeCS tupleTypeCS = (TupleTypeCS)theEObject;
				T result = caseTupleTypeCS(tupleTypeCS);
				if (result == null) result = caseNamedElementCS(tupleTypeCS);
				if (result == null) result = caseTypedRefCS(tupleTypeCS);
				if (result == null) result = caseNameable(tupleTypeCS);
				if (result == null) result = caseTypeRefCS(tupleTypeCS);
				if (result == null) result = caseModelElementCS(tupleTypeCS);
				if (result == null) result = caseParameterableElementCS(tupleTypeCS);
				if (result == null) result = caseMonikeredElementCS(tupleTypeCS);
				if (result == null) result = caseElementCS(tupleTypeCS);
				if (result == null) result = casePivotable(tupleTypeCS);
				if (result == null) result = caseVisitableCS(tupleTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_CS:
			{
				TypeCS typeCS = (TypeCS)theEObject;
				T result = caseTypeCS(typeCS);
				if (result == null) result = caseMonikeredElementCS(typeCS);
				if (result == null) result = caseModelElementCS(typeCS);
				if (result == null) result = caseElementCS(typeCS);
				if (result == null) result = casePivotable(typeCS);
				if (result == null) result = caseVisitableCS(typeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_PARAMETER_CS:
			{
				TypeParameterCS typeParameterCS = (TypeParameterCS)theEObject;
				T result = caseTypeParameterCS(typeParameterCS);
				if (result == null) result = caseTemplateParameterCS(typeParameterCS);
				if (result == null) result = caseTypeCS(typeParameterCS);
				if (result == null) result = caseNamedElementCS(typeParameterCS);
				if (result == null) result = caseMonikeredElementCS(typeParameterCS);
				if (result == null) result = caseNameable(typeParameterCS);
				if (result == null) result = caseModelElementCS(typeParameterCS);
				if (result == null) result = caseElementCS(typeParameterCS);
				if (result == null) result = casePivotable(typeParameterCS);
				if (result == null) result = caseVisitableCS(typeParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPE_REF_CS:
			{
				TypeRefCS typeRefCS = (TypeRefCS)theEObject;
				T result = caseTypeRefCS(typeRefCS);
				if (result == null) result = caseParameterableElementCS(typeRefCS);
				if (result == null) result = caseMonikeredElementCS(typeRefCS);
				if (result == null) result = caseModelElementCS(typeRefCS);
				if (result == null) result = caseElementCS(typeRefCS);
				if (result == null) result = casePivotable(typeRefCS);
				if (result == null) result = caseVisitableCS(typeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPED_ELEMENT_CS:
			{
				TypedElementCS typedElementCS = (TypedElementCS)theEObject;
				T result = caseTypedElementCS(typedElementCS);
				if (result == null) result = caseNamedElementCS(typedElementCS);
				if (result == null) result = caseMonikeredElementCS(typedElementCS);
				if (result == null) result = caseNameable(typedElementCS);
				if (result == null) result = caseModelElementCS(typedElementCS);
				if (result == null) result = caseElementCS(typedElementCS);
				if (result == null) result = casePivotable(typedElementCS);
				if (result == null) result = caseVisitableCS(typedElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPED_REF_CS:
			{
				TypedRefCS typedRefCS = (TypedRefCS)theEObject;
				T result = caseTypedRefCS(typedRefCS);
				if (result == null) result = caseTypeRefCS(typedRefCS);
				if (result == null) result = caseParameterableElementCS(typedRefCS);
				if (result == null) result = caseMonikeredElementCS(typedRefCS);
				if (result == null) result = caseModelElementCS(typedRefCS);
				if (result == null) result = caseElementCS(typedRefCS);
				if (result == null) result = casePivotable(typedRefCS);
				if (result == null) result = caseVisitableCS(typedRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.TYPED_TYPE_REF_CS:
			{
				TypedTypeRefCS typedTypeRefCS = (TypedTypeRefCS)theEObject;
				T result = caseTypedTypeRefCS(typedTypeRefCS);
				if (result == null) result = caseParameterizedTypeRefCS(typedTypeRefCS);
				if (result == null) result = caseTypedRefCS(typedTypeRefCS);
				if (result == null) result = caseTypeRefCS(typedTypeRefCS);
				if (result == null) result = caseParameterableElementCS(typedTypeRefCS);
				if (result == null) result = caseMonikeredElementCS(typedTypeRefCS);
				if (result == null) result = caseModelElementCS(typedTypeRefCS);
				if (result == null) result = caseElementCS(typedTypeRefCS);
				if (result == null) result = casePivotable(typedTypeRefCS);
				if (result == null) result = caseVisitableCS(typedTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaseCSTPackage.WILDCARD_TYPE_REF_CS:
			{
				WildcardTypeRefCS wildcardTypeRefCS = (WildcardTypeRefCS)theEObject;
				T result = caseWildcardTypeRefCS(wildcardTypeRefCS);
				if (result == null) result = caseTypeRefCS(wildcardTypeRefCS);
				if (result == null) result = caseParameterableElementCS(wildcardTypeRefCS);
				if (result == null) result = caseMonikeredElementCS(wildcardTypeRefCS);
				if (result == null) result = caseModelElementCS(wildcardTypeRefCS);
				if (result == null) result = caseElementCS(wildcardTypeRefCS);
				if (result == null) result = casePivotable(wildcardTypeRefCS);
				if (result == null) result = caseVisitableCS(wildcardTypeRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationCS(AnnotationCS object)
	{
		return null;
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
	public T caseAnnotationElementCS(AnnotationElementCS object) {
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
	public T caseAttributeCS(AttributeCS object) {
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
	public T caseAttributeCSRef(AttributeCSRef object) {
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
	public T caseBoundDocumentCS(BoundDocumentCS object) {
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
	public T caseClassCS(ClassCS object) {
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
	public T caseClassCSRef(ClassCSRef object) {
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
	public T caseClassifierCS(ClassifierCS object) {
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
	public T caseClassifierRefCS(ClassifierRefCS object) {
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
	public T caseCollectionTypeRefCS(CollectionTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintCS(ConstraintCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeCS(DataTypeCS object)
	{
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
	public T caseDetailCS(DetailCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documentation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentationCS(DocumentationCS object)
	{
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
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationCS(EnumerationCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteralCS(EnumerationLiteralCS object)
	{
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
	public T caseFeatureCS(FeatureCS object) {
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
	public T caseImportCS(ImportCS object) {
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
	public T caseLibraryCS(LibraryCS object) {
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
	public T caseModelElementCS(ModelElementCS object) {
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
	public T caseModelElementCSRef(ModelElementCSRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Monikered Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monikered Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonikeredElementCS(MonikeredElementCS object)
	{
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
	public T caseNamedElementCS(NamedElementCS object) {
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
	public T caseNamespaceCS(NamespaceCS object) {
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
	public T caseOperationRefCS(OperationRefCS object) {
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
	public T casePackageCS(PackageCS object) {
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
	public T casePackageRefCS(PackageRefCS object) {
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
	public T caseParameterCS(ParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterableElementCS(ParameterableElementCS object) {
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
	public T caseParameterizedTypeRefCS(ParameterizedTypeRefCS object) {
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
	public T casePrimitiveTypeRefCS(PrimitiveTypeRefCS object) {
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
	public T caseQualifiedClassifierRefCS(QualifiedClassifierRefCS object) {
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
	public T caseQualifiedOperationRefCS(QualifiedOperationRefCS object) {
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
	public T caseQualifiedPackageRefCS(QualifiedPackageRefCS object) {
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
	public <E extends ElementCS> T caseQualifiedRefCS(QualifiedRefCS<E> object) {
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
	public T caseQualifiedStructuralFeatureRefCS(QualifiedStructuralFeatureRefCS object) {
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
	public T caseQualifiedTypeRefCS(QualifiedTypeRefCS object) {
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
	public T caseReferenceCS(ReferenceCS object) {
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
	public T caseReferenceCSRef(ReferenceCSRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootPackageCS(RootPackageCS object)
	{
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
	public T caseSimpleClassifierRefCS(SimpleClassifierRefCS object) {
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
	public T caseSimpleOperationRefCS(SimpleOperationRefCS object) {
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
	public T caseSimplePackageRefCS(SimplePackageRefCS object) {
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
	public T caseSimpleStructuralFeatureRefCS(SimpleStructuralFeatureRefCS object) {
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
	public T caseStructuralFeatureCS(StructuralFeatureCS object) {
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
	public T caseStructuralFeatureRefCS(StructuralFeatureRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateBindingCS(TemplateBindingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterCS(TemplateParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Substitution CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Substitution CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Signature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Signature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateSignatureCS(TemplateSignatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElementCS(TemplateableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTuplePartCS(TuplePartCS object)
	{
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
	public T caseTupleTypeCS(TupleTypeCS object)
	{
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
	public T caseTypeParameterCS(TypeParameterCS object) {
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
	public T caseTypeRefCS(TypeRefCS object) {
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
	public T caseTypedElementCS(TypedElementCS object) {
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
	public T caseTypedRefCS(TypedRefCS object) {
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
	public T caseTypedTypeRefCS(TypedTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object)
	{
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
	public T caseWildcardTypeRefCS(WildcardTypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotable(Pivotable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object)
	{
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

} //BaseCSTSwitch
