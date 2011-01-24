/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseCSTValidator.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
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
import org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind;
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
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage
 * @generated
 */
public class BaseCSTValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final BaseCSTValidator INSTANCE = new BaseCSTValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.examples.xtext.base.baseCST"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSTValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return BaseCSTPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case BaseCSTPackage.ANNOTATION_CS:
				return validateAnnotationCS((AnnotationCS)value, diagnostics, context);
			case BaseCSTPackage.ANNOTATION_ELEMENT_CS:
				return validateAnnotationElementCS((AnnotationElementCS)value, diagnostics, context);
			case BaseCSTPackage.ATTRIBUTE_CS:
				return validateAttributeCS((AttributeCS)value, diagnostics, context);
			case BaseCSTPackage.ATTRIBUTE_CS_REF:
				return validateAttributeCSRef((AttributeCSRef)value, diagnostics, context);
			case BaseCSTPackage.BOUND_DOCUMENT_CS:
				return validateBoundDocumentCS((BoundDocumentCS)value, diagnostics, context);
			case BaseCSTPackage.CLASS_CS:
				return validateClassCS((ClassCS)value, diagnostics, context);
			case BaseCSTPackage.CLASS_CS_REF:
				return validateClassCSRef((ClassCSRef)value, diagnostics, context);
			case BaseCSTPackage.CLASSIFIER_CS:
				return validateClassifierCS((ClassifierCS)value, diagnostics, context);
			case BaseCSTPackage.CLASSIFIER_REF_CS:
				return validateClassifierRefCS((ClassifierRefCS)value, diagnostics, context);
			case BaseCSTPackage.COLLECTION_TYPE_REF_CS:
				return validateCollectionTypeRefCS((CollectionTypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.CONSTRAINT_CS:
				return validateConstraintCS((ConstraintCS)value, diagnostics, context);
			case BaseCSTPackage.DATA_TYPE_CS:
				return validateDataTypeCS((DataTypeCS)value, diagnostics, context);
			case BaseCSTPackage.DETAIL_CS:
				return validateDetailCS((DetailCS)value, diagnostics, context);
			case BaseCSTPackage.DOCUMENTATION_CS:
				return validateDocumentationCS((DocumentationCS)value, diagnostics, context);
			case BaseCSTPackage.ELEMENT_CS:
				return validateElementCS((ElementCS)value, diagnostics, context);
			case BaseCSTPackage.ENUMERATION_CS:
				return validateEnumerationCS((EnumerationCS)value, diagnostics, context);
			case BaseCSTPackage.ENUMERATION_LITERAL_CS:
				return validateEnumerationLiteralCS((EnumerationLiteralCS)value, diagnostics, context);
			case BaseCSTPackage.FEATURE_CS:
				return validateFeatureCS((FeatureCS)value, diagnostics, context);
			case BaseCSTPackage.IMPORT_CS:
				return validateImportCS((ImportCS)value, diagnostics, context);
			case BaseCSTPackage.LIBRARY_CS:
				return validateLibraryCS((LibraryCS)value, diagnostics, context);
			case BaseCSTPackage.MODEL_ELEMENT_CS:
				return validateModelElementCS((ModelElementCS)value, diagnostics, context);
			case BaseCSTPackage.MODEL_ELEMENT_CS_REF:
				return validateModelElementCSRef((ModelElementCSRef)value, diagnostics, context);
			case BaseCSTPackage.MONIKERED_ELEMENT_CS:
				return validateMonikeredElementCS((MonikeredElementCS)value, diagnostics, context);
			case BaseCSTPackage.NAMED_ELEMENT_CS:
				return validateNamedElementCS((NamedElementCS)value, diagnostics, context);
			case BaseCSTPackage.NAMESPACE_CS:
				return validateNamespaceCS((NamespaceCS)value, diagnostics, context);
			case BaseCSTPackage.OPERATION_CS:
				return validateOperationCS((OperationCS)value, diagnostics, context);
			case BaseCSTPackage.OPERATION_REF_CS:
				return validateOperationRefCS((OperationRefCS)value, diagnostics, context);
			case BaseCSTPackage.PACKAGE_CS:
				return validatePackageCS((PackageCS)value, diagnostics, context);
			case BaseCSTPackage.PACKAGE_REF_CS:
				return validatePackageRefCS((PackageRefCS)value, diagnostics, context);
			case BaseCSTPackage.PARAMETER_CS:
				return validateParameterCS((ParameterCS)value, diagnostics, context);
			case BaseCSTPackage.PARAMETERABLE_ELEMENT_CS:
				return validateParameterableElementCS((ParameterableElementCS)value, diagnostics, context);
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS:
				return validateParameterizedTypeRefCS((ParameterizedTypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.PRIMITIVE_TYPE_REF_CS:
				return validatePrimitiveTypeRefCS((PrimitiveTypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS:
				return validateQualifiedClassifierRefCS((QualifiedClassifierRefCS)value, diagnostics, context);
			case BaseCSTPackage.QUALIFIED_OPERATION_REF_CS:
				return validateQualifiedOperationRefCS((QualifiedOperationRefCS)value, diagnostics, context);
			case BaseCSTPackage.QUALIFIED_PACKAGE_REF_CS:
				return validateQualifiedPackageRefCS((QualifiedPackageRefCS)value, diagnostics, context);
			case BaseCSTPackage.QUALIFIED_REF_CS:
				return validateQualifiedRefCS((QualifiedRefCS<?>)value, diagnostics, context);
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS:
				return validateQualifiedStructuralFeatureRefCS((QualifiedStructuralFeatureRefCS)value, diagnostics, context);
			case BaseCSTPackage.QUALIFIED_TYPE_REF_CS:
				return validateQualifiedTypeRefCS((QualifiedTypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.REFERENCE_CS:
				return validateReferenceCS((ReferenceCS)value, diagnostics, context);
			case BaseCSTPackage.REFERENCE_CS_REF:
				return validateReferenceCSRef((ReferenceCSRef)value, diagnostics, context);
			case BaseCSTPackage.ROOT_CS:
				return validateRootCS((RootCS)value, diagnostics, context);
			case BaseCSTPackage.ROOT_PACKAGE_CS:
				return validateRootPackageCS((RootPackageCS)value, diagnostics, context);
			case BaseCSTPackage.SIMPLE_CLASSIFIER_REF_CS:
				return validateSimpleClassifierRefCS((SimpleClassifierRefCS)value, diagnostics, context);
			case BaseCSTPackage.SIMPLE_OPERATION_REF_CS:
				return validateSimpleOperationRefCS((SimpleOperationRefCS)value, diagnostics, context);
			case BaseCSTPackage.SIMPLE_PACKAGE_REF_CS:
				return validateSimplePackageRefCS((SimplePackageRefCS)value, diagnostics, context);
			case BaseCSTPackage.SIMPLE_STRUCTURAL_FEATURE_REF_CS:
				return validateSimpleStructuralFeatureRefCS((SimpleStructuralFeatureRefCS)value, diagnostics, context);
			case BaseCSTPackage.STRUCTURAL_FEATURE_CS:
				return validateStructuralFeatureCS((StructuralFeatureCS)value, diagnostics, context);
			case BaseCSTPackage.STRUCTURAL_FEATURE_REF_CS:
				return validateStructuralFeatureRefCS((StructuralFeatureRefCS)value, diagnostics, context);
			case BaseCSTPackage.TEMPLATE_BINDING_CS:
				return validateTemplateBindingCS((TemplateBindingCS)value, diagnostics, context);
			case BaseCSTPackage.TEMPLATE_PARAMETER_CS:
				return validateTemplateParameterCS((TemplateParameterCS)value, diagnostics, context);
			case BaseCSTPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				return validateTemplateParameterSubstitutionCS((TemplateParameterSubstitutionCS)value, diagnostics, context);
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS:
				return validateTemplateSignatureCS((TemplateSignatureCS)value, diagnostics, context);
			case BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS:
				return validateTemplateableElementCS((TemplateableElementCS)value, diagnostics, context);
			case BaseCSTPackage.TUPLE_PART_CS:
				return validateTuplePartCS((TuplePartCS)value, diagnostics, context);
			case BaseCSTPackage.TUPLE_TYPE_CS:
				return validateTupleTypeCS((TupleTypeCS)value, diagnostics, context);
			case BaseCSTPackage.TYPE_CS:
				return validateTypeCS((TypeCS)value, diagnostics, context);
			case BaseCSTPackage.TYPE_PARAMETER_CS:
				return validateTypeParameterCS((TypeParameterCS)value, diagnostics, context);
			case BaseCSTPackage.TYPE_REF_CS:
				return validateTypeRefCS((TypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.TYPED_ELEMENT_CS:
				return validateTypedElementCS((TypedElementCS)value, diagnostics, context);
			case BaseCSTPackage.TYPED_REF_CS:
				return validateTypedRefCS((TypedRefCS)value, diagnostics, context);
			case BaseCSTPackage.TYPED_TYPE_REF_CS:
				return validateTypedTypeRefCS((TypedTypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.VISITABLE_CS:
				return validateVisitableCS((VisitableCS)value, diagnostics, context);
			case BaseCSTPackage.WILDCARD_TYPE_REF_CS:
				return validateWildcardTypeRefCS((WildcardTypeRefCS)value, diagnostics, context);
			case BaseCSTPackage.ITERATOR_KIND:
				return validateIteratorKind((IteratorKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationCS(AnnotationCS annotationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(annotationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationElementCS(AnnotationElementCS annotationElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(annotationElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeCS(AttributeCS attributeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(attributeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeCSRef(AttributeCSRef attributeCSRef, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(attributeCSRef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoundDocumentCS(BoundDocumentCS boundDocumentCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(boundDocumentCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassCS(ClassCS classCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(classCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassCSRef(ClassCSRef classCSRef, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(classCSRef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierCS(ClassifierCS classifierCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(classifierCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierRefCS(ClassifierRefCS classifierRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(classifierRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTypeRefCS(CollectionTypeRefCS collectionTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(collectionTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraintCS(ConstraintCS constraintCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(constraintCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeCS(DataTypeCS dataTypeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(dataTypeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetailCS(DetailCS detailCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(detailCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentationCS(DocumentationCS documentationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(documentationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementCS(ElementCS elementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(elementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationCS(EnumerationCS enumerationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(enumerationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteralCS(EnumerationLiteralCS enumerationLiteralCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(enumerationLiteralCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCS(FeatureCS featureCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(featureCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportCS(ImportCS importCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(importCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryCS(LibraryCS libraryCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(libraryCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementCS(ModelElementCS modelElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(modelElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementCSRef(ModelElementCSRef modelElementCSRef, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(modelElementCSRef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMonikeredElementCS(MonikeredElementCS monikeredElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(monikeredElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElementCS(NamedElementCS namedElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(namedElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespaceCS(NamespaceCS namespaceCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(namespaceCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCS(OperationCS operationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(operationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationRefCS(OperationRefCS operationRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(operationRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageCS(PackageCS packageCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(packageCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageRefCS(PackageRefCS packageRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(packageRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterCS(ParameterCS parameterCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(parameterCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterableElementCS(ParameterableElementCS parameterableElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(parameterableElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterizedTypeRefCS(ParameterizedTypeRefCS parameterizedTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(parameterizedTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveTypeRefCS(PrimitiveTypeRefCS primitiveTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(primitiveTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedClassifierRefCS(QualifiedClassifierRefCS qualifiedClassifierRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedClassifierRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedOperationRefCS(QualifiedOperationRefCS qualifiedOperationRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedOperationRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedPackageRefCS(QualifiedPackageRefCS qualifiedPackageRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedPackageRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedRefCS(QualifiedRefCS<?> qualifiedRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedStructuralFeatureRefCS(QualifiedStructuralFeatureRefCS qualifiedStructuralFeatureRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedStructuralFeatureRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedTypeRefCS(QualifiedTypeRefCS qualifiedTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceCS(ReferenceCS referenceCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(referenceCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceCSRef(ReferenceCSRef referenceCSRef, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(referenceCSRef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootCS(RootCS rootCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(rootCS, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validateRootCS_TestConstraint(rootCS, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TestConstraint constraint of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROOT_CS__TEST_CONSTRAINT__EEXPRESSION = "true"; //$NON-NLS-1$

	/**
	 * Validates the TestConstraint constraint of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootCS_TestConstraint(RootCS rootCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(BaseCSTPackage.Literals.ROOT_CS,
				 rootCS,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$
				 "TestConstraint", //$NON-NLS-1$
				 ROOT_CS__TEST_CONSTRAINT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootPackageCS(RootPackageCS rootPackageCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(rootPackageCS, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validateRootPackageCS_TestConstraint(rootPackageCS, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TestConstraint constraint of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROOT_PACKAGE_CS__TEST_CONSTRAINT__EEXPRESSION = "true"; //$NON-NLS-1$

	/**
	 * Validates the TestConstraint constraint of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootPackageCS_TestConstraint(RootPackageCS rootPackageCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
						 new Object[] { "TestConstraint", getObjectLabel(rootPackageCS, context) }, //$NON-NLS-1$
						 new Object[] { rootPackageCS },
						 context));
			}
			return false;
		}
		return validateRootCS_TestConstraint(rootPackageCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleClassifierRefCS(SimpleClassifierRefCS simpleClassifierRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(simpleClassifierRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleOperationRefCS(SimpleOperationRefCS simpleOperationRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(simpleOperationRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimplePackageRefCS(SimplePackageRefCS simplePackageRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(simplePackageRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleStructuralFeatureRefCS(SimpleStructuralFeatureRefCS simpleStructuralFeatureRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(simpleStructuralFeatureRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureCS(StructuralFeatureCS structuralFeatureCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(structuralFeatureCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureRefCS(StructuralFeatureRefCS structuralFeatureRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(structuralFeatureRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBindingCS(TemplateBindingCS templateBindingCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateBindingCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterCS(TemplateParameterCS templateParameterCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateParameterCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS templateParameterSubstitutionCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateParameterSubstitutionCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignatureCS(TemplateSignatureCS templateSignatureCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateSignatureCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateableElementCS(TemplateableElementCS templateableElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateableElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuplePartCS(TuplePartCS tuplePartCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(tuplePartCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleTypeCS(TupleTypeCS tupleTypeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(tupleTypeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeCS(TypeCS typeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeParameterCS(TypeParameterCS typeParameterCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typeParameterCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeRefCS(TypeRefCS typeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementCS(TypedElementCS typedElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typedElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedRefCS(TypedRefCS typedRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typedRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedTypeRefCS(TypedTypeRefCS typedTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typedTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitableCS(VisitableCS visitableCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)visitableCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWildcardTypeRefCS(WildcardTypeRefCS wildcardTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(wildcardTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorKind(IteratorKind iteratorKind, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //BaseCSTValidator
