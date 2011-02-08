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
 * $Id: BaseCSTPackage.java,v 1.7 2011/02/08 17:43:58 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface BaseCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "baseCST"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/BaseCST"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "baseCST"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.util.VisitableCS <em>Visitable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.util.VisitableCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getVisitableCS()
	 * @generated
	 */
	int VISITABLE_CS = 50;

	/**
	 * The number of structural features of the '<em>Visitable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_CS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl <em>Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getElementCS()
	 * @generated
	 */
	int ELEMENT_CS = 13;

	/**
	 * The number of structural features of the '<em>Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS_FEATURE_COUNT = VISITABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getModelElementCS()
	 * @generated
	 */
	int MODEL_ELEMENT_CS = 19;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__OWNED_ANNOTATION = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__PIVOT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ERROR = ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.MonikeredElementCSImpl <em>Monikered Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.MonikeredElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getMonikeredElementCS()
	 * @generated
	 */
	int MONIKERED_ELEMENT_CS = 21;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_CS__ERROR = MODEL_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_CS__MONIKER = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Monikered Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONIKERED_ELEMENT_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAnnotationElementCS()
	 * @generated
	 */
	int ANNOTATION_ELEMENT_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl <em>Detail CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDetailCS()
	 * @generated
	 */
	int DETAIL_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ImportCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getNamedElementCS()
	 * @generated
	 */
	int NAMED_ELEMENT_CS = 22;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__OWNED_ANNOTATION = MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__PIVOT = MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ORIGINAL_XMI_ID = MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ERROR = MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__MONIKER = MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__NAME = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS_FEATURE_COUNT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassifierCS()
	 * @generated
	 */
	int CLASSIFIER_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedElementCSImpl <em>Typed Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedElementCS()
	 * @generated
	 */
	int TYPED_ELEMENT_CS = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS <em>Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getFeatureCS()
	 * @generated
	 */
	int FEATURE_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getStructuralFeatureCS()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_CS = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAttributeCS()
	 * @generated
	 */
	int ATTRIBUTE_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSRefImpl <em>Attribute CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAttributeCSRef()
	 * @generated
	 */
	int ATTRIBUTE_CS_REF = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSRefImpl <em>Class CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCSRef()
	 * @generated
	 */
	int CLASS_CS_REF = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.LibraryCSImpl <em>Library CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.LibraryCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getLibraryCS()
	 * @generated
	 */
	int LIBRARY_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSRefImpl <em>Model Element CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getModelElementCSRef()
	 * @generated
	 */
	int MODEL_ELEMENT_CS_REF = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS <em>Namespace CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getNamespaceCS()
	 * @generated
	 */
	int NAMESPACE_CS = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationCSImpl <em>Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getOperationCS()
	 * @generated
	 */
	int OPERATION_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageCSImpl <em>Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPackageCS()
	 * @generated
	 */
	int PACKAGE_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterCS()
	 * @generated
	 */
	int PARAMETER_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PrimitiveTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPrimitiveTypeRefCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_REF_CS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getReferenceCS()
	 * @generated
	 */
	int REFERENCE_CS = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSRefImpl <em>Reference CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getReferenceCSRef()
	 * @generated
	 */
	int REFERENCE_CS_REF = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS <em>Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeCS()
	 * @generated
	 */
	int TYPE_CS = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeParameterCS()
	 * @generated
	 */
	int TYPE_PARAMETER_CS = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedTypeRefCS()
	 * @generated
	 */
	int TYPED_TYPE_REF_CS = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.WildcardTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getWildcardTypeRefCS()
	 * @generated
	 */
	int WILDCARD_TYPE_REF_CS = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeRefCS()
	 * @generated
	 */
	int TYPE_REF_CS = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedRefCS()
	 * @generated
	 */
	int TYPED_REF_CS = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.CollectionTypeRefCSImpl <em>Collection Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.CollectionTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getCollectionTypeRefCS()
	 * @generated
	 */
	int COLLECTION_TYPE_REF_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundDocumentCSImpl <em>Bound Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundDocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundDocumentCS()
	 * @generated
	 */
	int BOUND_DOCUMENT_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAnnotationCS()
	 * @generated
	 */
	int ANNOTATION_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS <em>Parameterable Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterableElementCS()
	 * @generated
	 */
	int PARAMETERABLE_ELEMENT_CS = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl <em>Parameterized Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterizedTypeRefCS()
	 * @generated
	 */
	int PARAMETERIZED_TYPE_REF_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS <em>Qualified Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedRefCS()
	 * @generated
	 */
	int QUALIFIED_REF_CS = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedTypeRefCSImpl <em>Qualified Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedTypeRefCS()
	 * @generated
	 */
	int QUALIFIED_TYPE_REF_CS = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateBindingCSImpl <em>Template Binding CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateBindingCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateBindingCS()
	 * @generated
	 */
	int TEMPLATE_BINDING_CS = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterCSImpl <em>Template Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateParameterCS()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_CS = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterSubstitutionCSImpl <em>Template Parameter Substitution CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterSubstitutionCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateSignatureCSImpl <em>Template Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateSignatureCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateSignatureCS()
	 * @generated
	 */
	int TEMPLATE_SIGNATURE_CS = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS <em>Templateable Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateableElementCS()
	 * @generated
	 */
	int TEMPLATEABLE_ELEMENT_CS = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DataTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDataTypeCS()
	 * @generated
	 */
	int DATA_TYPE_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDocumentationCS()
	 * @generated
	 */
	int DOCUMENTATION_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getEnumerationCS()
	 * @generated
	 */
	int ENUMERATION_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationLiteralCSImpl <em>Enumeration Literal CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationLiteralCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getEnumerationLiteralCS()
	 * @generated
	 */
	int ENUMERATION_LITERAL_CS = 15;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__OWNED_DETAIL = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_ANNOTATION = ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__PIVOT = ANNOTATION_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ORIGINAL_XMI_ID = ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ERROR = ANNOTATION_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__MONIKER = ANNOTATION_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__NAME = ANNOTATION_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_DETAIL = ANNOTATION_ELEMENT_CS__OWNED_DETAIL;

	/**
	 * The feature id for the '<em><b>Owned Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_CONTENT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__REFERENCE = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS_FEATURE_COUNT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__LOWER = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__MULTIPLICITY = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__OWNED_TYPE = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__UPPER = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__OWNED_CONSTRAINT = NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__QUALIFIER = NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Typed Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__OWNED_ANNOTATION = TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__PIVOT = TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__ERROR = TYPED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__MONIKER = TYPED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__LOWER = TYPED_ELEMENT_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__MULTIPLICITY = TYPED_ELEMENT_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__OWNED_TYPE = TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__OWNED_CONSTRAINT = TYPED_ELEMENT_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__QUALIFIER = TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The number of structural features of the '<em>Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION = FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__PIVOT = FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID = FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ERROR = FEATURE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__MONIKER = FEATURE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__NAME = FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__LOWER = FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__MULTIPLICITY = FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNED_TYPE = FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__UPPER = FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNED_CONSTRAINT = FEATURE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__QUALIFIER = FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNER = FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__DEFAULT = FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Structural Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS_FEATURE_COUNT = FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNED_ANNOTATION = STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__PIVOT = STRUCTURAL_FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ERROR = STRUCTURAL_FEATURE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__MONIKER = STRUCTURAL_FEATURE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__NAME = STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__LOWER = STRUCTURAL_FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__MULTIPLICITY = STRUCTURAL_FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNED_TYPE = STRUCTURAL_FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__UPPER = STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNED_CONSTRAINT = STRUCTURAL_FEATURE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__QUALIFIER = STRUCTURAL_FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNER = STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__DEFAULT = STRUCTURAL_FEATURE_CS__DEFAULT;

	/**
	 * The number of structural features of the '<em>Attribute CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_REF__REF = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_REF_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The number of structural features of the '<em>Namespace CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_ANNOTATION = NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__PIVOT = NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ERROR = NAMESPACE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__MONIKER = NAMESPACE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_TYPE = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_NESTED_PACKAGE = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NS_PREFIX = NAMESPACE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NS_URI = NAMESPACE_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__OWNED_ANNOTATION = PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__PIVOT = PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__ORIGINAL_XMI_ID = PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__ERROR = PACKAGE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__MONIKER = PACKAGE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__NAME = PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__OWNED_TYPE = PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__OWNED_NESTED_PACKAGE = PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__NS_PREFIX = PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__NS_URI = PACKAGE_CS__NS_URI;

	/**
	 * The number of structural features of the '<em>Bound Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS_FEATURE_COUNT = PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNER = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__INSTANCE_CLASS_NAME = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNED_CONSTRAINT = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__QUALIFIER = NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_ANNOTATION = CLASSIFIER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__PIVOT = CLASSIFIER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ERROR = CLASSIFIER_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__MONIKER = CLASSIFIER_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_TEMPLATE_SIGNATURE = CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_CONSTRAINT = CLASSIFIER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__QUALIFIER = CLASSIFIER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_SUPER_TYPE = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_OPERATION = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_PROPERTY = CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_META_TYPE = CLASSIFIER_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_REF__REF = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_REF_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__OWNED_ANNOTATION = MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__PIVOT = MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__ORIGINAL_XMI_ID = MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__ERROR = MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__MONIKER = MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The number of structural features of the '<em>Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS_FEATURE_COUNT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__OWNED_ANNOTATION = TYPE_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__PIVOT = TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__ORIGINAL_XMI_ID = TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__ERROR = TYPE_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__MONIKER = TYPE_REF_CS__MONIKER;

	/**
	 * The number of structural features of the '<em>Typed Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS_FEATURE_COUNT = TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__OWNED_ANNOTATION = TYPED_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__PIVOT = TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPED_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__ERROR = TYPED_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__MONIKER = TYPED_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameterized Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__OWNED_ANNOTATION = PARAMETERIZED_TYPE_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__PIVOT = PARAMETERIZED_TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__ORIGINAL_XMI_ID = PARAMETERIZED_TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__ERROR = PARAMETERIZED_TYPE_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__MONIKER = PARAMETERIZED_TYPE_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__TYPE = PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS_FEATURE_COUNT = PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__OWNED_ANNOTATION = TYPED_TYPE_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__PIVOT = TYPED_TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPED_TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__ERROR = TYPED_TYPE_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__MONIKER = TYPED_TYPE_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__TYPE = TYPED_TYPE_REF_CS__TYPE;

	/**
	 * The number of structural features of the '<em>Collection Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS_FEATURE_COUNT = TYPED_TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__STEREOTYPE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__EXPR_STRING = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNED_ANNOTATION = CLASSIFIER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__PIVOT = CLASSIFIER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ERROR = CLASSIFIER_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__MONIKER = CLASSIFIER_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNED_TEMPLATE_SIGNATURE = CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNED_CONSTRAINT = CLASSIFIER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__QUALIFIER = CLASSIFIER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__LITERALS = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__VALUE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Detail CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__OWNED_ANNOTATION = ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__PIVOT = ANNOTATION_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ORIGINAL_XMI_ID = ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ERROR = ANNOTATION_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__MONIKER = ANNOTATION_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__NAME = ANNOTATION_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__OWNED_DETAIL = ANNOTATION_ELEMENT_CS__OWNED_DETAIL;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__VALUE = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Documentation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS_FEATURE_COUNT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_ANNOTATION = CLASSIFIER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__PIVOT = CLASSIFIER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__ERROR = CLASSIFIER_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__MONIKER = CLASSIFIER_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_TEMPLATE_SIGNATURE = CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_CONSTRAINT = CLASSIFIER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__QUALIFIER = CLASSIFIER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_LITERALS = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__VALUE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__OWNED_ANNOTATION = NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__PIVOT = NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ERROR = NAMESPACE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__MONIKER = NAMESPACE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__URI = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__NAMESPACE = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__OWNED_ANNOTATION = NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__PIVOT = NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__ERROR = NAMESPACE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__MONIKER = NAMESPACE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__PACKAGE = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_REF__REF = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_REF_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_ANNOTATION = FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__PIVOT = FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ORIGINAL_XMI_ID = FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ERROR = FEATURE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__MONIKER = FEATURE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__NAME = FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__LOWER = FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__MULTIPLICITY = FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_TYPE = FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__UPPER = FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_CONSTRAINT = FEATURE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__QUALIFIER = FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_TEMPLATE_SIGNATURE = FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNING_CLASS = FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_PARAMETER = FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_EXCEPTION = FEATURE_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS_FEATURE_COUNT = FEATURE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNED_ANNOTATION = TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__PIVOT = TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ERROR = TYPED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__MONIKER = TYPED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__LOWER = TYPED_ELEMENT_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__MULTIPLICITY = TYPED_ELEMENT_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNED_TYPE = TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNED_CONSTRAINT = TYPED_ELEMENT_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__QUALIFIER = TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNER = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_CS__OWNED_ANNOTATION = MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_CS__PIVOT = MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_CS__ORIGINAL_XMI_ID = MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_CS__ERROR = MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_CS__MONIKER = MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The number of structural features of the '<em>Parameterable Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_CS_FEATURE_COUNT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__OWNED_ANNOTATION = TYPED_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__PIVOT = TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPED_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__ERROR = TYPED_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__MONIKER = TYPED_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__NAME = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__ERROR = MODEL_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__NAMESPACE = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__ELEMENT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__OWNED_ANNOTATION = PARAMETERIZED_TYPE_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__PIVOT = PARAMETERIZED_TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__ORIGINAL_XMI_ID = PARAMETERIZED_TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__ERROR = PARAMETERIZED_TYPE_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__MONIKER = PARAMETERIZED_TYPE_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__NAMESPACE = PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__ELEMENT = PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS_FEATURE_COUNT = PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNED_ANNOTATION = STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__PIVOT = STRUCTURAL_FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ERROR = STRUCTURAL_FEATURE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__MONIKER = STRUCTURAL_FEATURE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__NAME = STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__LOWER = STRUCTURAL_FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__MULTIPLICITY = STRUCTURAL_FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNED_TYPE = STRUCTURAL_FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__UPPER = STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNED_CONSTRAINT = STRUCTURAL_FEATURE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__QUALIFIER = STRUCTURAL_FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNER = STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__DEFAULT = STRUCTURAL_FEATURE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OPPOSITE = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__KEYS = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS_REF__REF = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS_REF_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootCS <em>Root CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getRootCS()
	 * @generated
	 */
	int ROOT_CS = 34;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__ERROR = MODEL_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_IMPORT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_LIBRARY = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.RootPackageCSImpl <em>Root Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.RootPackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getRootPackageCS()
	 * @generated
	 */
	int ROOT_PACKAGE_CS = 35;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_ANNOTATION = PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__PIVOT = PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__ORIGINAL_XMI_ID = PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__ERROR = PACKAGE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__MONIKER = PACKAGE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__NAME = PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_TYPE = PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE = PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__NS_PREFIX = PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__NS_URI = PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_IMPORT = PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_LIBRARY = PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS_FEATURE_COUNT = PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__ERROR = MODEL_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Owning Template Bindable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parameter Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owning Template Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__ERROR = MODEL_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Owning Template Binding</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Actual Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Parameter Substitution CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__OWNED_ANNOTATION = MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__PIVOT = MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__ORIGINAL_XMI_ID = MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__ERROR = MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__MONIKER = MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Owning Template Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Template Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS_FEATURE_COUNT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__OWNED_ANNOTATION = MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__PIVOT = MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__ORIGINAL_XMI_ID = MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__ERROR = MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__MONIKER = MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Templateable Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS_FEATURE_COUNT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TuplePartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTuplePartCS()
	 * @generated
	 */
	int TUPLE_PART_CS = 42;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__OWNED_ANNOTATION = TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__PIVOT = TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__ERROR = TYPED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__MONIKER = TYPED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__LOWER = TYPED_ELEMENT_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__MULTIPLICITY = TYPED_ELEMENT_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__OWNED_TYPE = TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__OWNED_CONSTRAINT = TYPED_ELEMENT_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__QUALIFIER = TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The number of structural features of the '<em>Tuple Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TupleTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTupleTypeCS()
	 * @generated
	 */
	int TUPLE_TYPE_CS = 43;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__ERROR = NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__MONIKER = NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__OWNED_PARTS = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__OWNED_ANNOTATION = MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__PIVOT = MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__ORIGINAL_XMI_ID = MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__ERROR = MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__MONIKER = MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The number of structural features of the '<em>Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_FEATURE_COUNT = MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNED_ANNOTATION = TEMPLATE_PARAMETER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__PIVOT = TEMPLATE_PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ORIGINAL_XMI_ID = TEMPLATE_PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ERROR = TEMPLATE_PARAMETER_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__MONIKER = TEMPLATE_PARAMETER_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__NAME = TEMPLATE_PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owning Template Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE = TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNED_EXTENDS = TEMPLATE_PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNED_SUPER = TEMPLATE_PARAMETER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS_FEATURE_COUNT = TEMPLATE_PARAMETER_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__OWNED_ANNOTATION = TYPE_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__PIVOT = TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__ERROR = TYPE_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__MONIKER = TYPE_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__EXTENDS = TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__SUPER = TYPE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wildcard Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS_FEATURE_COUNT = TYPE_REF_CS_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind <em>Iterator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getIteratorKind()
	 * @generated
	 */
	int ITERATOR_KIND = 52;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS
	 * @generated
	 */
	EClass getAnnotationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS#getOwnedContent <em>Owned Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Content</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS#getOwnedContent()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_OwnedContent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS#getReference()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_Reference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS
	 * @generated
	 */
	EClass getAnnotationElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS#getOwnedDetail <em>Owned Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Detail</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS#getOwnedDetail()
	 * @see #getAnnotationElementCS()
	 * @generated
	 */
	EReference getAnnotationElementCS_OwnedDetail();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS <em>Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS
	 * @generated
	 */
	EClass getAttributeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef <em>Attribute CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef
	 * @generated
	 */
	EClass getAttributeCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef#getRef()
	 * @see #getAttributeCSRef()
	 * @generated
	 */
	EReference getAttributeCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS <em>Bound Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS
	 * @generated
	 */
	EClass getBoundDocumentCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS
	 * @generated
	 */
	EClass getClassCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedSuperType <em>Owned Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Super Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedSuperType()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedSuperType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedOperation()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedProperty <em>Owned Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedProperty()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedMetaType <em>Owned Meta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Meta Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedMetaType()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedMetaType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef <em>Class CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef
	 * @generated
	 */
	EClass getClassCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef#getRef()
	 * @see #getClassCSRef()
	 * @generated
	 */
	EReference getClassCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS <em>Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS
	 * @generated
	 */
	EClass getClassifierCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwner()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getInstanceClassName()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EAttribute getClassifierCS_InstanceClassName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwnedConstraint <em>Owned Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraint</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwnedConstraint()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_OwnedConstraint();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getQualifier()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EAttribute getClassifierCS_Qualifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS <em>Collection Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS
	 * @generated
	 */
	EClass getCollectionTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS
	 * @generated
	 */
	EClass getConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS#getStereotype()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EAttribute getConstraintCS_Stereotype();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS#getExprString <em>Expr String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr String</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS#getExprString()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EAttribute getConstraintCS_ExprString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS
	 * @generated
	 */
	EClass getDataTypeCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS#getLiterals()
	 * @see #getDataTypeCS()
	 * @generated
	 */
	EReference getDataTypeCS_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS <em>Detail CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS
	 * @generated
	 */
	EClass getDetailCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getValue()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS <em>Documentation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS
	 * @generated
	 */
	EClass getDocumentationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS#getValue()
	 * @see #getDocumentationCS()
	 * @generated
	 */
	EAttribute getDocumentationCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS
	 * @generated
	 */
	EClass getElementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS <em>Enumeration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS
	 * @generated
	 */
	EClass getEnumerationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS#getOwnedLiterals <em>Owned Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literals</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS#getOwnedLiterals()
	 * @see #getEnumerationCS()
	 * @generated
	 */
	EReference getEnumerationCS_OwnedLiterals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS <em>Enumeration Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS
	 * @generated
	 */
	EClass getEnumerationLiteralCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS#getValue()
	 * @see #getEnumerationLiteralCS()
	 * @generated
	 */
	EAttribute getEnumerationLiteralCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS <em>Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS
	 * @generated
	 */
	EClass getFeatureCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS
	 * @generated
	 */
	EClass getImportCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS#getUri()
	 * @see #getImportCS()
	 * @generated
	 */
	EAttribute getImportCS_Uri();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS#getNamespace()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS <em>Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS
	 * @generated
	 */
	EClass getLibraryCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS#getPackage()
	 * @see #getLibraryCS()
	 * @generated
	 */
	EReference getLibraryCS_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS
	 * @generated
	 */
	EClass getModelElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOwnedAnnotation <em>Owned Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOwnedAnnotation()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_OwnedAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getPivot <em>Pivot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pivot</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getPivot()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_Pivot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Xmi Id</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOriginalXmiId()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EAttribute getModelElementCS_OriginalXmiId();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Error</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getError()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EAttribute getModelElementCS_Error();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef <em>Model Element CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef
	 * @generated
	 */
	EClass getModelElementCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef#getRef()
	 * @see #getModelElementCSRef()
	 * @generated
	 */
	EReference getModelElementCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS <em>Monikered Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monikered Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS
	 * @generated
	 */
	EClass getMonikeredElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS#getMoniker <em>Moniker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Moniker</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS#getMoniker()
	 * @see #getMonikeredElementCS()
	 * @generated
	 */
	EAttribute getMonikeredElementCS_Moniker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS
	 * @generated
	 */
	EClass getNamedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS#getName()
	 * @see #getNamedElementCS()
	 * @generated
	 */
	EAttribute getNamedElementCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS <em>Namespace CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS
	 * @generated
	 */
	EClass getNamespaceCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS
	 * @generated
	 */
	EClass getOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwnedParameter()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedParameter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwnedException <em>Owned Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Exception</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwnedException()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedException();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwningClass()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwningClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS
	 * @generated
	 */
	EClass getPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getOwnedType()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getOwnedNestedPackage <em>Owned Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Nested Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getOwnedNestedPackage()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_OwnedNestedPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getNsPrefix()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_NsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getNsURI()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_NsURI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS
	 * @generated
	 */
	EClass getParameterCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS#getOwner()
	 * @see #getParameterCS()
	 * @generated
	 */
	EReference getParameterCS_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS <em>Parameterable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterable Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS
	 * @generated
	 */
	EClass getParameterableElementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS <em>Parameterized Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS
	 * @generated
	 */
	EClass getParameterizedTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS#getOwnedTemplateBinding()
	 * @see #getParameterizedTypeRefCS()
	 * @generated
	 */
	EReference getParameterizedTypeRefCS_OwnedTemplateBinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS <em>Primitive Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS
	 * @generated
	 */
	EClass getPrimitiveTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS <em>Qualified Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS
	 * @generated
	 */
	EClass getQualifiedRefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS#getNamespace()
	 * @see #getQualifiedRefCS()
	 * @generated
	 */
	EReference getQualifiedRefCS_Namespace();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS#getElement()
	 * @see #getQualifiedRefCS()
	 * @generated
	 */
	EReference getQualifiedRefCS_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS <em>Qualified Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS
	 * @generated
	 */
	EClass getQualifiedTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS <em>Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS
	 * @generated
	 */
	EClass getReferenceCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Opposite</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getOpposite()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_Opposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getKeys()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_Keys();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef <em>Reference CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef
	 * @generated
	 */
	EClass getReferenceCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef#getRef()
	 * @see #getReferenceCSRef()
	 * @generated
	 */
	EReference getReferenceCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootCS
	 * @generated
	 */
	EClass getRootCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootCS#getOwnedImport <em>Owned Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Import</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootCS#getOwnedImport()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_OwnedImport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootCS#getOwnedLibrary <em>Owned Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Library</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootCS#getOwnedLibrary()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_OwnedLibrary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS <em>Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS
	 * @generated
	 */
	EClass getRootPackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS
	 * @generated
	 */
	EClass getStructuralFeatureCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS#getOwner()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EReference getStructuralFeatureCS_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS#getDefault()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EAttribute getStructuralFeatureCS_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS <em>Template Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS
	 * @generated
	 */
	EClass getTemplateBindingCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Bindable Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwningTemplateBindableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwnedParameterSubstitution <em>Owned Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwnedParameterSubstitution()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwnedParameterSubstitution();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS <em>Template Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS
	 * @generated
	 */
	EClass getTemplateParameterCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS#getOwningTemplateSignature <em>Owning Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS#getOwningTemplateSignature()
	 * @see #getTemplateParameterCS()
	 * @generated
	 */
	EReference getTemplateParameterCS_OwningTemplateSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS <em>Template Parameter Substitution CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Substitution CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS
	 * @generated
	 */
	EClass getTemplateParameterSubstitutionCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwningTemplateBinding <em>Owning Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwningTemplateBinding()
	 * @see #getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	EReference getTemplateParameterSubstitutionCS_OwningTemplateBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Actual Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwnedActualParameter()
	 * @see #getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	EReference getTemplateParameterSubstitutionCS_OwnedActualParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS <em>Template Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS
	 * @generated
	 */
	EClass getTemplateSignatureCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwningTemplateElement <em>Owning Template Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwningTemplateElement()
	 * @see #getTemplateSignatureCS()
	 * @generated
	 */
	EReference getTemplateSignatureCS_OwningTemplateElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwnedTemplateParameter <em>Owned Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwnedTemplateParameter()
	 * @see #getTemplateSignatureCS()
	 * @generated
	 */
	EReference getTemplateSignatureCS_OwnedTemplateParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS <em>Templateable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templateable Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS
	 * @generated
	 */
	EClass getTemplateableElementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS#getOwnedTemplateSignature()
	 * @see #getTemplateableElementCS()
	 * @generated
	 */
	EReference getTemplateableElementCS_OwnedTemplateSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS <em>Tuple Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS
	 * @generated
	 */
	EClass getTuplePartCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS <em>Tuple Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS
	 * @generated
	 */
	EClass getTupleTypeCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS#getOwnedParts()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EReference getTupleTypeCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS
	 * @generated
	 */
	EClass getTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS <em>Type Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS
	 * @generated
	 */
	EClass getTypeParameterCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getOwnedExtends <em>Owned Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getOwnedExtends()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_OwnedExtends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getOwnedSuper <em>Owned Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getOwnedSuper()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_OwnedSuper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS
	 * @generated
	 */
	EClass getTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS
	 * @generated
	 */
	EClass getTypedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getLower()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getMultiplicity()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getOwnedType()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EReference getTypedElementCS_OwnedType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getUpper()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Upper();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getOwnedConstraint <em>Owned Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraint</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getOwnedConstraint()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EReference getTypedElementCS_OwnedConstraint();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getQualifier()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Qualifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS
	 * @generated
	 */
	EClass getTypedRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS <em>Typed Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS
	 * @generated
	 */
	EClass getTypedTypeRefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getType()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.util.VisitableCS
	 * @model instanceClass="org.eclipse.ocl.examples.xtext.base.util.VisitableCS"
	 * @generated
	 */
	EClass getVisitableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS <em>Wildcard Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS
	 * @generated
	 */
	EClass getWildcardTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getExtends()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS#getSuper()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_Super();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind <em>Iterator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Iterator Kind</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind
	 * @generated
	 */
	EEnum getIteratorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseCSTFactory getBaseCSTFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAnnotationCS()
		 * @generated
		 */
		EClass ANNOTATION_CS = eINSTANCE.getAnnotationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__OWNED_CONTENT = eINSTANCE.getAnnotationCS_OwnedContent();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__REFERENCE = eINSTANCE.getAnnotationCS_Reference();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAnnotationElementCS()
		 * @generated
		 */
		EClass ANNOTATION_ELEMENT_CS = eINSTANCE.getAnnotationElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Detail</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_ELEMENT_CS__OWNED_DETAIL = eINSTANCE.getAnnotationElementCS_OwnedDetail();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAttributeCS()
		 * @generated
		 */
		EClass ATTRIBUTE_CS = eINSTANCE.getAttributeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSRefImpl <em>Attribute CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAttributeCSRef()
		 * @generated
		 */
		EClass ATTRIBUTE_CS_REF = eINSTANCE.getAttributeCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CS_REF__REF = eINSTANCE.getAttributeCSRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundDocumentCSImpl <em>Bound Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundDocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundDocumentCS()
		 * @generated
		 */
		EClass BOUND_DOCUMENT_CS = eINSTANCE.getBoundDocumentCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCS()
		 * @generated
		 */
		EClass CLASS_CS = eINSTANCE.getClassCS();

		/**
		 * The meta object literal for the '<em><b>Owned Super Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_SUPER_TYPE = eINSTANCE.getClassCS_OwnedSuperType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_OPERATION = eINSTANCE.getClassCS_OwnedOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_PROPERTY = eINSTANCE.getClassCS_OwnedProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Meta Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_META_TYPE = eINSTANCE.getClassCS_OwnedMetaType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSRefImpl <em>Class CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCSRef()
		 * @generated
		 */
		EClass CLASS_CS_REF = eINSTANCE.getClassCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS_REF__REF = eINSTANCE.getClassCSRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassifierCS()
		 * @generated
		 */
		EClass CLASSIFIER_CS = eINSTANCE.getClassifierCS();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__OWNER = eINSTANCE.getClassifierCS_Owner();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CS__INSTANCE_CLASS_NAME = eINSTANCE.getClassifierCS_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Owned Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__OWNED_CONSTRAINT = eINSTANCE.getClassifierCS_OwnedConstraint();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CS__QUALIFIER = eINSTANCE.getClassifierCS_Qualifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.CollectionTypeRefCSImpl <em>Collection Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.CollectionTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getCollectionTypeRefCS()
		 * @generated
		 */
		EClass COLLECTION_TYPE_REF_CS = eINSTANCE.getCollectionTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getConstraintCS()
		 * @generated
		 */
		EClass CONSTRAINT_CS = eINSTANCE.getConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_CS__STEREOTYPE = eINSTANCE.getConstraintCS_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Expr String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_CS__EXPR_STRING = eINSTANCE.getConstraintCS_ExprString();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DataTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDataTypeCS()
		 * @generated
		 */
		EClass DATA_TYPE_CS = eINSTANCE.getDataTypeCS();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_CS__LITERALS = eINSTANCE.getDataTypeCS_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl <em>Detail CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDetailCS()
		 * @generated
		 */
		EClass DETAIL_CS = eINSTANCE.getDetailCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__VALUE = eINSTANCE.getDetailCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDocumentationCS()
		 * @generated
		 */
		EClass DOCUMENTATION_CS = eINSTANCE.getDocumentationCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION_CS__VALUE = eINSTANCE.getDocumentationCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl <em>Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getElementCS()
		 * @generated
		 */
		EClass ELEMENT_CS = eINSTANCE.getElementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getEnumerationCS()
		 * @generated
		 */
		EClass ENUMERATION_CS = eINSTANCE.getEnumerationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_CS__OWNED_LITERALS = eINSTANCE.getEnumerationCS_OwnedLiterals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationLiteralCSImpl <em>Enumeration Literal CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumerationLiteralCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getEnumerationLiteralCS()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL_CS = eINSTANCE.getEnumerationLiteralCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL_CS__VALUE = eINSTANCE.getEnumerationLiteralCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS <em>Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getFeatureCS()
		 * @generated
		 */
		EClass FEATURE_CS = eINSTANCE.getFeatureCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ImportCSImpl <em>Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ImportCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getImportCS()
		 * @generated
		 */
		EClass IMPORT_CS = eINSTANCE.getImportCS();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_CS__URI = eINSTANCE.getImportCS_Uri();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__NAMESPACE = eINSTANCE.getImportCS_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.LibraryCSImpl <em>Library CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.LibraryCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getLibraryCS()
		 * @generated
		 */
		EClass LIBRARY_CS = eINSTANCE.getLibraryCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_CS__PACKAGE = eINSTANCE.getLibraryCS_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getModelElementCS()
		 * @generated
		 */
		EClass MODEL_ELEMENT_CS = eINSTANCE.getModelElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Annotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS__OWNED_ANNOTATION = eINSTANCE.getModelElementCS_OwnedAnnotation();

		/**
		 * The meta object literal for the '<em><b>Pivot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS__PIVOT = eINSTANCE.getModelElementCS_Pivot();

		/**
		 * The meta object literal for the '<em><b>Original Xmi Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = eINSTANCE.getModelElementCS_OriginalXmiId();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_CS__ERROR = eINSTANCE.getModelElementCS_Error();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSRefImpl <em>Model Element CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getModelElementCSRef()
		 * @generated
		 */
		EClass MODEL_ELEMENT_CS_REF = eINSTANCE.getModelElementCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS_REF__REF = eINSTANCE.getModelElementCSRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.MonikeredElementCSImpl <em>Monikered Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.MonikeredElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getMonikeredElementCS()
		 * @generated
		 */
		EClass MONIKERED_ELEMENT_CS = eINSTANCE.getMonikeredElementCS();

		/**
		 * The meta object literal for the '<em><b>Moniker</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONIKERED_ELEMENT_CS__MONIKER = eINSTANCE.getMonikeredElementCS_Moniker();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getNamedElementCS()
		 * @generated
		 */
		EClass NAMED_ELEMENT_CS = eINSTANCE.getNamedElementCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT_CS__NAME = eINSTANCE.getNamedElementCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS <em>Namespace CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getNamespaceCS()
		 * @generated
		 */
		EClass NAMESPACE_CS = eINSTANCE.getNamespaceCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationCSImpl <em>Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getOperationCS()
		 * @generated
		 */
		EClass OPERATION_CS = eINSTANCE.getOperationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_PARAMETER = eINSTANCE.getOperationCS_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Owned Exception</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_EXCEPTION = eINSTANCE.getOperationCS_OwnedException();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNING_CLASS = eINSTANCE.getOperationCS_OwningClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageCSImpl <em>Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPackageCS()
		 * @generated
		 */
		EClass PACKAGE_CS = eINSTANCE.getPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__OWNED_TYPE = eINSTANCE.getPackageCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Nested Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__OWNED_NESTED_PACKAGE = eINSTANCE.getPackageCS_OwnedNestedPackage();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NS_PREFIX = eINSTANCE.getPackageCS_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NS_URI = eINSTANCE.getPackageCS_NsURI();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterCS()
		 * @generated
		 */
		EClass PARAMETER_CS = eINSTANCE.getParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_CS__OWNER = eINSTANCE.getParameterCS_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS <em>Parameterable Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterableElementCS()
		 * @generated
		 */
		EClass PARAMETERABLE_ELEMENT_CS = eINSTANCE.getParameterableElementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl <em>Parameterized Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterizedTypeRefCS()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE_REF_CS = eINSTANCE.getParameterizedTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Owned Template Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = eINSTANCE.getParameterizedTypeRefCS_OwnedTemplateBinding();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PrimitiveTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPrimitiveTypeRefCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_REF_CS = eINSTANCE.getPrimitiveTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS <em>Qualified Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedRefCS()
		 * @generated
		 */
		EClass QUALIFIED_REF_CS = eINSTANCE.getQualifiedRefCS();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_REF_CS__NAMESPACE = eINSTANCE.getQualifiedRefCS_Namespace();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_REF_CS__ELEMENT = eINSTANCE.getQualifiedRefCS_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedTypeRefCSImpl <em>Qualified Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedTypeRefCS()
		 * @generated
		 */
		EClass QUALIFIED_TYPE_REF_CS = eINSTANCE.getQualifiedTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getReferenceCS()
		 * @generated
		 */
		EClass REFERENCE_CS = eINSTANCE.getReferenceCS();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__OPPOSITE = eINSTANCE.getReferenceCS_Opposite();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__KEYS = eINSTANCE.getReferenceCS_Keys();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSRefImpl <em>Reference CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getReferenceCSRef()
		 * @generated
		 */
		EClass REFERENCE_CS_REF = eINSTANCE.getReferenceCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS_REF__REF = eINSTANCE.getReferenceCSRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootCS <em>Root CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getRootCS()
		 * @generated
		 */
		EClass ROOT_CS = eINSTANCE.getRootCS();

		/**
		 * The meta object literal for the '<em><b>Owned Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__OWNED_IMPORT = eINSTANCE.getRootCS_OwnedImport();

		/**
		 * The meta object literal for the '<em><b>Owned Library</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__OWNED_LIBRARY = eINSTANCE.getRootCS_OwnedLibrary();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.RootPackageCSImpl <em>Root Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.RootPackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getRootPackageCS()
		 * @generated
		 */
		EClass ROOT_PACKAGE_CS = eINSTANCE.getRootPackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getStructuralFeatureCS()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_CS = eINSTANCE.getStructuralFeatureCS();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_CS__OWNER = eINSTANCE.getStructuralFeatureCS_Owner();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE_CS__DEFAULT = eINSTANCE.getStructuralFeatureCS_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateBindingCSImpl <em>Template Binding CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateBindingCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateBindingCS()
		 * @generated
		 */
		EClass TEMPLATE_BINDING_CS = eINSTANCE.getTemplateBindingCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Bindable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT = eINSTANCE.getTemplateBindingCS_OwningTemplateBindableElement();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter Substitution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateBindingCS_OwnedParameterSubstitution();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterCSImpl <em>Template Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateParameterCS()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_CS = eINSTANCE.getTemplateParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE = eINSTANCE.getTemplateParameterCS_OwningTemplateSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterSubstitutionCSImpl <em>Template Parameter Substitution CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateParameterSubstitutionCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateParameterSubstitutionCS()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_SUBSTITUTION_CS = eINSTANCE.getTemplateParameterSubstitutionCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Binding</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING = eINSTANCE.getTemplateParameterSubstitutionCS_OwningTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Actual Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER = eINSTANCE.getTemplateParameterSubstitutionCS_OwnedActualParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateSignatureCSImpl <em>Template Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateSignatureCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateSignatureCS()
		 * @generated
		 */
		EClass TEMPLATE_SIGNATURE_CS = eINSTANCE.getTemplateSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT = eINSTANCE.getTemplateSignatureCS_OwningTemplateElement();

		/**
		 * The meta object literal for the '<em><b>Owned Template Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER = eINSTANCE.getTemplateSignatureCS_OwnedTemplateParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS <em>Templateable Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTemplateableElementCS()
		 * @generated
		 */
		EClass TEMPLATEABLE_ELEMENT_CS = eINSTANCE.getTemplateableElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Template Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE = eINSTANCE.getTemplateableElementCS_OwnedTemplateSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TuplePartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTuplePartCS()
		 * @generated
		 */
		EClass TUPLE_PART_CS = eINSTANCE.getTuplePartCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TupleTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTupleTypeCS()
		 * @generated
		 */
		EClass TUPLE_TYPE_CS = eINSTANCE.getTupleTypeCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE_CS__OWNED_PARTS = eINSTANCE.getTupleTypeCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS <em>Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeCS()
		 * @generated
		 */
		EClass TYPE_CS = eINSTANCE.getTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeParameterCS()
		 * @generated
		 */
		EClass TYPE_PARAMETER_CS = eINSTANCE.getTypeParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owned Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__OWNED_EXTENDS = eINSTANCE.getTypeParameterCS_OwnedExtends();

		/**
		 * The meta object literal for the '<em><b>Owned Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__OWNED_SUPER = eINSTANCE.getTypeParameterCS_OwnedSuper();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeRefCS()
		 * @generated
		 */
		EClass TYPE_REF_CS = eINSTANCE.getTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedElementCSImpl <em>Typed Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedElementCS()
		 * @generated
		 */
		EClass TYPED_ELEMENT_CS = eINSTANCE.getTypedElementCS();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__LOWER = eINSTANCE.getTypedElementCS_Lower();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__MULTIPLICITY = eINSTANCE.getTypedElementCS_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_CS__OWNED_TYPE = eINSTANCE.getTypedElementCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__UPPER = eINSTANCE.getTypedElementCS_Upper();

		/**
		 * The meta object literal for the '<em><b>Owned Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_CS__OWNED_CONSTRAINT = eINSTANCE.getTypedElementCS_OwnedConstraint();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__QUALIFIER = eINSTANCE.getTypedElementCS_Qualifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedRefCS()
		 * @generated
		 */
		EClass TYPED_REF_CS = eINSTANCE.getTypedRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedTypeRefCS()
		 * @generated
		 */
		EClass TYPED_TYPE_REF_CS = eINSTANCE.getTypedTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__TYPE = eINSTANCE.getTypedTypeRefCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.util.VisitableCS <em>Visitable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.util.VisitableCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getVisitableCS()
		 * @generated
		 */
		EClass VISITABLE_CS = eINSTANCE.getVisitableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.WildcardTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getWildcardTypeRefCS()
		 * @generated
		 */
		EClass WILDCARD_TYPE_REF_CS = eINSTANCE.getWildcardTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_REF_CS__EXTENDS = eINSTANCE.getWildcardTypeRefCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_REF_CS__SUPER = eINSTANCE.getWildcardTypeRefCS_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind <em>Iterator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getIteratorKind()
		 * @generated
		 */
		EEnum ITERATOR_KIND = eINSTANCE.getIteratorKind();

	}

} //BaseCSTPackage
