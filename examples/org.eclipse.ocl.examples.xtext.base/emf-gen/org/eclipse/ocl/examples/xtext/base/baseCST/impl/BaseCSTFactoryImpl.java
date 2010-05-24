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
 * $Id: BaseCSTFactoryImpl.java,v 1.3 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.base.baseCST.*;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

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
		try {
			BaseCSTFactory theBaseCSTFactory = (BaseCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.0.0/BaseCST"); //$NON-NLS-1$ 
			if (theBaseCSTFactory != null) {
				return theBaseCSTFactory;
			}
		}
		catch (Exception exception) {
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
		switch (eClass.getClassifierID()) {
			case BaseCSTPackage.ATTRIBUTE_CS_REF: return createAttributeCSRef();
			case BaseCSTPackage.BOUND_CLASS_CS: return createBoundClassCS();
			case BaseCSTPackage.BOUND_CLASSIFIER_CS: return createBoundClassifierCS();
			case BaseCSTPackage.BOUND_DOCUMENT_CS: return createBoundDocumentCS();
			case BaseCSTPackage.BOUND_OPERATION_CS: return createBoundOperationCS();
			case BaseCSTPackage.CLASS_CS_REF: return createClassCSRef();
			case BaseCSTPackage.COLLECTION_TYPE_REF_CS: return createCollectionTypeRefCS();
			case BaseCSTPackage.DETAIL_CS: return createDetailCS();
			case BaseCSTPackage.ENUM_LITERAL_CS: return createEnumLiteralCS();
			case BaseCSTPackage.IMPORT_CS: return createImportCS();
			case BaseCSTPackage.LIBRARY_CS: return createLibraryCS();
			case BaseCSTPackage.MODEL_ELEMENT_CS_REF: return createModelElementCSRef();
			case BaseCSTPackage.PACKAGE_CS: return createPackageCS();
			case BaseCSTPackage.PARAMETER_CS: return createParameterCS();
			case BaseCSTPackage.PRIMITIVE_TYPE_REF_CS: return createPrimitiveTypeRefCS();
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS: return createQualifiedClassifierRefCS();
			case BaseCSTPackage.QUALIFIED_OPERATION_REF_CS: return createQualifiedOperationRefCS();
			case BaseCSTPackage.QUALIFIED_PACKAGE_REF_CS: return createQualifiedPackageRefCS();
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS: return createQualifiedStructuralFeatureRefCS();
			case BaseCSTPackage.QUALIFIED_TYPE_REF_CS: return createQualifiedTypeRefCS();
			case BaseCSTPackage.REFERENCE_CS_REF: return createReferenceCSRef();
			case BaseCSTPackage.SIMPLE_CLASSIFIER_REF_CS: return createSimpleClassifierRefCS();
			case BaseCSTPackage.SIMPLE_OPERATION_REF_CS: return createSimpleOperationRefCS();
			case BaseCSTPackage.SIMPLE_PACKAGE_REF_CS: return createSimplePackageRefCS();
			case BaseCSTPackage.SIMPLE_STRUCTURAL_FEATURE_REF_CS: return createSimpleStructuralFeatureRefCS();
			case BaseCSTPackage.TYPE_BINDING_CS: return createTypeBindingCS();
			case BaseCSTPackage.TYPE_BINDINGS_CS: return createTypeBindingsCS();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BaseCSTPackage.SIGNATURE:
				return createSignatureFromString(eDataType, initialValue);
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
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BaseCSTPackage.SIGNATURE:
				return convertSignatureToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
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
	public BoundClassCS createBoundClassCS() {
		BoundClassCSImpl boundClassCS = new BoundClassCSImpl();
		return boundClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundClassifierCS createBoundClassifierCS() {
		BoundClassifierCSImpl boundClassifierCS = new BoundClassifierCSImpl();
		return boundClassifierCS;
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
	public BoundOperationCS createBoundOperationCS() {
		BoundOperationCSImpl boundOperationCS = new BoundOperationCSImpl();
		return boundOperationCS;
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
	public DetailCS createDetailCS() {
		DetailCSImpl detailCS = new DetailCSImpl();
		return detailCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralCS createEnumLiteralCS() {
		EnumLiteralCSImpl enumLiteralCS = new EnumLiteralCSImpl();
		return enumLiteralCS;
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
	public QualifiedClassifierRefCS createQualifiedClassifierRefCS() {
		QualifiedClassifierRefCSImpl qualifiedClassifierRefCS = new QualifiedClassifierRefCSImpl();
		return qualifiedClassifierRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedOperationRefCS createQualifiedOperationRefCS() {
		QualifiedOperationRefCSImpl qualifiedOperationRefCS = new QualifiedOperationRefCSImpl();
		return qualifiedOperationRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedPackageRefCS createQualifiedPackageRefCS() {
		QualifiedPackageRefCSImpl qualifiedPackageRefCS = new QualifiedPackageRefCSImpl();
		return qualifiedPackageRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedStructuralFeatureRefCS createQualifiedStructuralFeatureRefCS() {
		QualifiedStructuralFeatureRefCSImpl qualifiedStructuralFeatureRefCS = new QualifiedStructuralFeatureRefCSImpl();
		return qualifiedStructuralFeatureRefCS;
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
	public ReferenceCSRef createReferenceCSRef() {
		ReferenceCSRefImpl referenceCSRef = new ReferenceCSRefImpl();
		return referenceCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleClassifierRefCS createSimpleClassifierRefCS() {
		SimpleClassifierRefCSImpl simpleClassifierRefCS = new SimpleClassifierRefCSImpl();
		return simpleClassifierRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOperationRefCS createSimpleOperationRefCS() {
		SimpleOperationRefCSImpl simpleOperationRefCS = new SimpleOperationRefCSImpl();
		return simpleOperationRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePackageRefCS createSimplePackageRefCS() {
		SimplePackageRefCSImpl simplePackageRefCS = new SimplePackageRefCSImpl();
		return simplePackageRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleStructuralFeatureRefCS createSimpleStructuralFeatureRefCS() {
		SimpleStructuralFeatureRefCSImpl simpleStructuralFeatureRefCS = new SimpleStructuralFeatureRefCSImpl();
		return simpleStructuralFeatureRefCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeBindingCS createTypeBindingCS() {
		TypeBindingCSImpl typeBindingCS = new TypeBindingCSImpl();
		return typeBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeBindingsCS createTypeBindingsCS() {
		TypeBindingsCSImpl typeBindingsCS = new TypeBindingsCSImpl();
		return typeBindingsCS;
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
	public Signature createSignatureFromString(EDataType eDataType, String initialValue) {
		return (Signature)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSignatureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
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
