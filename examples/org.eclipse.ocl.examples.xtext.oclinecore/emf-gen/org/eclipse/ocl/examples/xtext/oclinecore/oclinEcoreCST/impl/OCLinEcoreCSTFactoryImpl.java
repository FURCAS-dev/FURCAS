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
 * $Id: OCLinEcoreCSTFactoryImpl.java,v 1.1 2010/04/13 06:44:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSTFactoryImpl extends EFactoryImpl implements OCLinEcoreCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLinEcoreCSTFactory init() {
		try {
			OCLinEcoreCSTFactory theOCLinEcoreCSTFactory = (OCLinEcoreCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.0.0/OCLinEcoreCST"); 
			if (theOCLinEcoreCSTFactory != null) {
				return theOCLinEcoreCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLinEcoreCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTFactoryImpl() {
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
			case OCLinEcoreCSTPackage.ANNOTATION_CS: return createAnnotationCS();
			case OCLinEcoreCSTPackage.ATTRIBUTE_CS: return createAttributeCS();
			case OCLinEcoreCSTPackage.ATTRIBUTE_CS_REF: return createAttributeCSRef();
			case OCLinEcoreCSTPackage.CLASS_CS: return createClassCS();
			case OCLinEcoreCSTPackage.CLASS_CS_REF: return createClassCSRef();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS: return createConstraintCS();
			case OCLinEcoreCSTPackage.DATA_TYPE_CS: return createDataTypeCS();
			case OCLinEcoreCSTPackage.DATA_TYPE_CS_REF: return createDataTypeCSRef();
			case OCLinEcoreCSTPackage.DETAIL_CS: return createDetailCS();
			case OCLinEcoreCSTPackage.DOCUMENT_CS: return createDocumentCS();
			case OCLinEcoreCSTPackage.EATTRIBUTE_REF: return createEAttributeRef();
			case OCLinEcoreCSTPackage.ECLASS_REF: return createEClassRef();
			case OCLinEcoreCSTPackage.ECLASSIFIER_CS_REF: return createEClassifierCSRef();
			case OCLinEcoreCSTPackage.ECLASSIFIER_REF: return createEClassifierRef();
			case OCLinEcoreCSTPackage.EDATA_TYPE_REF: return createEDataTypeRef();
			case OCLinEcoreCSTPackage.EOBJECT_REF: return createEObjectRef();
			case OCLinEcoreCSTPackage.EREFERENCE_REF: return createEReferenceRef();
			case OCLinEcoreCSTPackage.ENUM_CS: return createEnumCS();
			case OCLinEcoreCSTPackage.ENUM_LITERAL_CS: return createEnumLiteralCS();
			case OCLinEcoreCSTPackage.IMPORT_CS: return createImportCS();
			case OCLinEcoreCSTPackage.MODEL_ELEMENT_CS_REF: return createModelElementCSRef();
			case OCLinEcoreCSTPackage.OPERATION_CS: return createOperationCS();
			case OCLinEcoreCSTPackage.PACKAGE_CS: return createPackageCS();
			case OCLinEcoreCSTPackage.PARAMETER_CS: return createParameterCS();
			case OCLinEcoreCSTPackage.REFERENCE_CS: return createReferenceCS();
			case OCLinEcoreCSTPackage.REFERENCE_CS_REF: return createReferenceCSRef();
			case OCLinEcoreCSTPackage.TYPE_CS_REF: return createTypeCSRef();
			case OCLinEcoreCSTPackage.TYPE_PARAMETER_CS: return createTypeParameterCS();
			case OCLinEcoreCSTPackage.TYPED_TYPE_REF_CS: return createTypedTypeRefCS();
			case OCLinEcoreCSTPackage.WILDCARD_TYPE_REF_CS: return createWildcardTypeRefCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationCS createAnnotationCS() {
		AnnotationCSImpl annotationCS = new AnnotationCSImpl();
		return annotationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeCS createAttributeCS() {
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
	public DocumentCS createDocumentCS() {
		DocumentCSImpl documentCS = new DocumentCSImpl();
		return documentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttributeRef createEAttributeRef() {
		EAttributeRefImpl eAttributeRef = new EAttributeRefImpl();
		return eAttributeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassRef createEClassRef() {
		EClassRefImpl eClassRef = new EClassRefImpl();
		return eClassRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifierCSRef createEClassifierCSRef() {
		EClassifierCSRefImpl eClassifierCSRef = new EClassifierCSRefImpl();
		return eClassifierCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifierRef createEClassifierRef() {
		EClassifierRefImpl eClassifierRef = new EClassifierRefImpl();
		return eClassifierRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataTypeRef createEDataTypeRef() {
		EDataTypeRefImpl eDataTypeRef = new EDataTypeRefImpl();
		return eDataTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectRef createEObjectRef() {
		EObjectRefImpl eObjectRef = new EObjectRefImpl();
		return eObjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReferenceRef createEReferenceRef() {
		EReferenceRefImpl eReferenceRef = new EReferenceRefImpl();
		return eReferenceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCS createEnumCS() {
		EnumCSImpl enumCS = new EnumCSImpl();
		return enumCS;
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
	public ModelElementCSRef createModelElementCSRef() {
		ModelElementCSRefImpl modelElementCSRef = new ModelElementCSRefImpl();
		return modelElementCSRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS createOperationCS() {
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
	public ReferenceCS createReferenceCS() {
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
	public TypeCSRef createTypeCSRef() {
		TypeCSRefImpl typeCSRef = new TypeCSRefImpl();
		return typeCSRef;
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
	public ConstraintCS createConstraintCS() {
		ConstraintCSImpl constraintCS = new ConstraintCSImpl();
		return constraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeCS createDataTypeCS() {
		DataTypeCSImpl dataTypeCS = new DataTypeCSImpl();
		return dataTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeCSRef createDataTypeCSRef() {
		DataTypeCSRefImpl dataTypeCSRef = new DataTypeCSRefImpl();
		return dataTypeCSRef;
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
	public OCLinEcoreCSTPackage getOCLinEcoreCSTPackage() {
		return (OCLinEcoreCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLinEcoreCSTPackage getPackage() {
		return OCLinEcoreCSTPackage.eINSTANCE;
	}

} //OCLinEcoreCSTFactoryImpl
