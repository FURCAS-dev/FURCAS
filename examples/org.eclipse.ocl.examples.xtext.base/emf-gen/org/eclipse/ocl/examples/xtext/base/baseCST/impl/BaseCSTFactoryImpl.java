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
 * $Id: BaseCSTFactoryImpl.java,v 1.5 2011/02/08 17:43:58 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseCSTFactoryImpl extends EFactoryImpl implements BaseCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BaseCSTFactory init() {
		try
		{
			BaseCSTFactory theBaseCSTFactory = (BaseCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.1.0/BaseCST"); //$NON-NLS-1$ 
			if (theBaseCSTFactory != null)
			{
				return theBaseCSTFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BaseCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case BaseCSTPackage.ANNOTATION_CS: return createAnnotationCS();
			case BaseCSTPackage.ATTRIBUTE_CS: return createAttributeCS();
			case BaseCSTPackage.ATTRIBUTE_CS_REF: return createAttributeCSRef();
			case BaseCSTPackage.BOUND_DOCUMENT_CS: return createBoundDocumentCS();
			case BaseCSTPackage.CLASS_CS: return createClassCS();
			case BaseCSTPackage.CLASS_CS_REF: return createClassCSRef();
			case BaseCSTPackage.COLLECTION_TYPE_REF_CS: return createCollectionTypeRefCS();
			case BaseCSTPackage.CONSTRAINT_CS: return createConstraintCS();
			case BaseCSTPackage.DATA_TYPE_CS: return createDataTypeCS();
			case BaseCSTPackage.DETAIL_CS: return createDetailCS();
			case BaseCSTPackage.DOCUMENTATION_CS: return createDocumentationCS();
			case BaseCSTPackage.ENUMERATION_CS: return createEnumerationCS();
			case BaseCSTPackage.ENUMERATION_LITERAL_CS: return createEnumerationLiteralCS();
			case BaseCSTPackage.IMPORT_CS: return createImportCS();
			case BaseCSTPackage.LIBRARY_CS: return createLibraryCS();
			case BaseCSTPackage.MODEL_ELEMENT_CS_REF: return createModelElementCSRef();
			case BaseCSTPackage.OPERATION_CS: return createOperationCS();
			case BaseCSTPackage.PACKAGE_CS: return createPackageCS();
			case BaseCSTPackage.PARAMETER_CS: return createParameterCS();
			case BaseCSTPackage.PRIMITIVE_TYPE_REF_CS: return createPrimitiveTypeRefCS();
			case BaseCSTPackage.QUALIFIED_TYPE_REF_CS: return createQualifiedTypeRefCS();
			case BaseCSTPackage.REFERENCE_CS: return createReferenceCS();
			case BaseCSTPackage.REFERENCE_CS_REF: return createReferenceCSRef();
			case BaseCSTPackage.ROOT_PACKAGE_CS: return createRootPackageCS();
			case BaseCSTPackage.TEMPLATE_BINDING_CS: return createTemplateBindingCS();
			case BaseCSTPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS: return createTemplateParameterSubstitutionCS();
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS: return createTemplateSignatureCS();
			case BaseCSTPackage.TUPLE_PART_CS: return createTuplePartCS();
			case BaseCSTPackage.TUPLE_TYPE_CS: return createTupleTypeCS();
			case BaseCSTPackage.TYPE_PARAMETER_CS: return createTypeParameterCS();
			case BaseCSTPackage.TYPED_TYPE_REF_CS: return createTypedTypeRefCS();
			case BaseCSTPackage.WILDCARD_TYPE_REF_CS: return createWildcardTypeRefCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case BaseCSTPackage.ITERATOR_KIND:
				return createIteratorKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case BaseCSTPackage.ITERATOR_KIND:
				return convertIteratorKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationCS createAnnotationCS()
	{
		AnnotationCSImpl annotationCS = new AnnotationCSImpl();
		return annotationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeCS createAttributeCS()
	{
		AttributeCSImpl attributeCS = new AttributeCSImpl();
		return attributeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeCSRef createAttributeCSRef() {
		AttributeCSRefImpl attributeCSRef = new AttributeCSRefImpl();
		return attributeCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundDocumentCS createBoundDocumentCS() {
		BoundDocumentCSImpl boundDocumentCS = new BoundDocumentCSImpl();
		return boundDocumentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS createClassCS() {
		ClassCSImpl classCS = new ClassCSImpl();
		return classCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCSRef createClassCSRef() {
		ClassCSRefImpl classCSRef = new ClassCSRefImpl();
		return classCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeRefCS createCollectionTypeRefCS() {
		CollectionTypeRefCSImpl collectionTypeRefCS = new CollectionTypeRefCSImpl();
		return collectionTypeRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintCS createConstraintCS()
	{
		ConstraintCSImpl constraintCS = new ConstraintCSImpl();
		return constraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeCS createDataTypeCS()
	{
		DataTypeCSImpl dataTypeCS = new DataTypeCSImpl();
		return dataTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailCS createDetailCS() {
		DetailCSImpl detailCS = new DetailCSImpl();
		return detailCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentationCS createDocumentationCS()
	{
		DocumentationCSImpl documentationCS = new DocumentationCSImpl();
		return documentationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationCS createEnumerationCS()
	{
		EnumerationCSImpl enumerationCS = new EnumerationCSImpl();
		return enumerationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralCS createEnumerationLiteralCS()
	{
		EnumerationLiteralCSImpl enumerationLiteralCS = new EnumerationLiteralCSImpl();
		return enumerationLiteralCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportCS createImportCS() {
		ImportCSImpl importCS = new ImportCSImpl();
		return importCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryCS createLibraryCS() {
		LibraryCSImpl libraryCS = new LibraryCSImpl();
		return libraryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementCSRef createModelElementCSRef() {
		ModelElementCSRefImpl modelElementCSRef = new ModelElementCSRefImpl();
		return modelElementCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS createOperationCS()
	{
		OperationCSImpl operationCS = new OperationCSImpl();
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS createPackageCS() {
		PackageCSImpl packageCS = new PackageCSImpl();
		return packageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCS createParameterCS() {
		ParameterCSImpl parameterCS = new ParameterCSImpl();
		return parameterCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeRefCS createPrimitiveTypeRefCS() {
		PrimitiveTypeRefCSImpl primitiveTypeRefCS = new PrimitiveTypeRefCSImpl();
		return primitiveTypeRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedTypeRefCS createQualifiedTypeRefCS() {
		QualifiedTypeRefCSImpl qualifiedTypeRefCS = new QualifiedTypeRefCSImpl();
		return qualifiedTypeRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceCS createReferenceCS()
	{
		ReferenceCSImpl referenceCS = new ReferenceCSImpl();
		return referenceCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceCSRef createReferenceCSRef() {
		ReferenceCSRefImpl referenceCSRef = new ReferenceCSRefImpl();
		return referenceCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootPackageCS createRootPackageCS()
	{
		RootPackageCSImpl rootPackageCS = new RootPackageCSImpl();
		return rootPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCS createTemplateBindingCS() {
		TemplateBindingCSImpl templateBindingCS = new TemplateBindingCSImpl();
		return templateBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameterSubstitutionCS createTemplateParameterSubstitutionCS() {
		TemplateParameterSubstitutionCSImpl templateParameterSubstitutionCS = new TemplateParameterSubstitutionCSImpl();
		return templateParameterSubstitutionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignatureCS createTemplateSignatureCS() {
		TemplateSignatureCSImpl templateSignatureCS = new TemplateSignatureCSImpl();
		return templateSignatureCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TuplePartCS createTuplePartCS()
	{
		TuplePartCSImpl tuplePartCS = new TuplePartCSImpl();
		return tuplePartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleTypeCS createTupleTypeCS()
	{
		TupleTypeCSImpl tupleTypeCS = new TupleTypeCSImpl();
		return tupleTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeParameterCS createTypeParameterCS() {
		TypeParameterCSImpl typeParameterCS = new TypeParameterCSImpl();
		return typeParameterCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedTypeRefCS createTypedTypeRefCS() {
		TypedTypeRefCSImpl typedTypeRefCS = new TypedTypeRefCSImpl();
		return typedTypeRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WildcardTypeRefCS createWildcardTypeRefCS() {
		WildcardTypeRefCSImpl wildcardTypeRefCS = new WildcardTypeRefCSImpl();
		return wildcardTypeRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorKind createIteratorKindFromString(EDataType eDataType, String initialValue)
	{
		IteratorKind result = IteratorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIteratorKindToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSTPackage getBaseCSTPackage() {
		return (BaseCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BaseCSTPackage getPackage() {
		return BaseCSTPackage.eINSTANCE;
	}

} //BaseCSTFactoryImpl
