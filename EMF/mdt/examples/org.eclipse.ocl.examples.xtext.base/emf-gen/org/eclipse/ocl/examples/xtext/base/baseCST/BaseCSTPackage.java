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
 * $Id: BaseCSTPackage.java,v 1.5 2010/08/17 18:53:39 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	String eNS_URI = "http://www.eclipse.org/ocl/3.0.0/BaseCST"; //$NON-NLS-1$

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl <em>Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getElementCS()
	 * @generated
	 */
	int ELEMENT_CS = 15;

	/**
	 * The number of structural features of the '<em>Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl <em>Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDocumentCS()
	 * @generated
	 */
	int DOCUMENT_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getModelElementCS()
	 * @generated
	 */
	int MODEL_ELEMENT_CS = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ANNOTATIONS = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ORIGINAL_OBJECT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAnnotationElementCS()
	 * @generated
	 */
	int ANNOTATION_ELEMENT_CS = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__DETAILS = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl <em>Detail CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDetailCS()
	 * @generated
	 */
	int DETAIL_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ImportCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 18;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__NAME = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassifierCS()
	 * @generated
	 */
	int CLASSIFIER_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumLiteralCSImpl <em>Enum Literal CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumLiteralCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getEnumLiteralCS()
	 * @generated
	 */
	int ENUM_LITERAL_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS <em>Typed Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedElementCS()
	 * @generated
	 */
	int TYPED_ELEMENT_CS = 50;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ORIGINAL_OBJECT = NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__QUALIFIERS = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__TYPE = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__UPPER = NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Typed Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS <em>Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getFeatureCS()
	 * @generated
	 */
	int FEATURE_CS = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__ANNOTATIONS = TYPED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__ORIGINAL_OBJECT = TYPED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__QUALIFIERS = TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__TYPE = TYPED_ELEMENT_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__IS_STATIC = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__IS_DEFINITION = TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getStructuralFeatureCS()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_CS = 43;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ANNOTATIONS = FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT = FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID = FEATURE_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__QUALIFIERS = FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__TYPE = FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__UPPER = FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__IS_STATIC = FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__IS_DEFINITION = FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNER = FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structural Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS_FEATURE_COUNT = FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS <em>Attribute CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAttributeCS()
	 * @generated
	 */
	int ATTRIBUTE_CS = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ANNOTATIONS = STRUCTURAL_FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ORIGINAL_OBJECT = STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__QUALIFIERS = STRUCTURAL_FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__TYPE = STRUCTURAL_FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__UPPER = STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__IS_STATIC = STRUCTURAL_FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__IS_DEFINITION = STRUCTURAL_FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNER = STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The number of structural features of the '<em>Attribute CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSRefImpl <em>Attribute CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AttributeCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAttributeCSRef()
	 * @generated
	 */
	int ATTRIBUTE_CS_REF = 2;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS <em>Bound Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundElementCS()
	 * @generated
	 */
	int BOUND_ELEMENT_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSRefImpl <em>Class CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCSRef()
	 * @generated
	 */
	int CLASS_CS_REF = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierRefCSImpl <em>Classifier Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassifierRefCS()
	 * @generated
	 */
	int CLASSIFIER_REF_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.LibraryCSImpl <em>Library CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.LibraryCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getLibraryCS()
	 * @generated
	 */
	int LIBRARY_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSRefImpl <em>Model Element CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getModelElementCSRef()
	 * @generated
	 */
	int MODEL_ELEMENT_CS_REF = 21;

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
	int PACKAGE_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterCS()
	 * @generated
	 */
	int PARAMETER_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PrimitiveTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPrimitiveTypeRefCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_REF_CS = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS <em>Reference CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getReferenceCS()
	 * @generated
	 */
	int REFERENCE_CS = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSRefImpl <em>Reference CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ReferenceCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getReferenceCSRef()
	 * @generated
	 */
	int REFERENCE_CS_REF = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS <em>Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeCS()
	 * @generated
	 */
	int TYPE_CS = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeParameterCS()
	 * @generated
	 */
	int TYPE_PARAMETER_CS = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedTypeRefCS()
	 * @generated
	 */
	int TYPED_TYPE_REF_CS = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.WildcardTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getWildcardTypeRefCS()
	 * @generated
	 */
	int WILDCARD_TYPE_REF_CS = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeRefCS()
	 * @generated
	 */
	int TYPE_REF_CS = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypedRefCS()
	 * @generated
	 */
	int TYPED_REF_CS = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.CollectionTypeRefCSImpl <em>Collection Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.CollectionTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getCollectionTypeRefCS()
	 * @generated
	 */
	int COLLECTION_TYPE_REF_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundOperationCSImpl <em>Bound Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundOperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundOperationCS()
	 * @generated
	 */
	int BOUND_OPERATION_CS = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ORIGINAL_OBJECT = NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__TYPE_PARAMETERS = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNER = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassifierCSImpl <em>Bound Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassifierCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundClassifierCS()
	 * @generated
	 */
	int BOUND_CLASSIFIER_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationRefCSImpl <em>Operation Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getOperationRefCS()
	 * @generated
	 */
	int OPERATION_REF_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundDocumentCSImpl <em>Bound Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundDocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundDocumentCS()
	 * @generated
	 */
	int BOUND_DOCUMENT_CS = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ANNOTATIONS = CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ORIGINAL_OBJECT = CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__TYPE_PARAMETERS = CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__SUPER_TYPES = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OPERATIONS = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__STRUCTURAL_FEATURES = CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl <em>Bound Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundClassCS()
	 * @generated
	 */
	int BOUND_CLASS_CS = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__ANNOTATIONS = CLASS_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__ORIGINAL_OBJECT = CLASS_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__ORIGINAL_XMI_ID = CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__NAME = CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__TYPE_PARAMETERS = CLASS_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__OWNER = CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__SUPER_TYPES = CLASS_CS__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__OPERATIONS = CLASS_CS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__STRUCTURAL_FEATURES = CLASS_CS__STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__BINDINGS = CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS__BINDS = CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bound Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASS_CS_FEATURE_COUNT = CLASS_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__ANNOTATIONS = CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__ORIGINAL_OBJECT = CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__TYPE_PARAMETERS = CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__BINDINGS = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS__BINDS = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bound Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CLASSIFIER_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__ORIGINAL_OBJECT = NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ANNOTATIONS = NAMESPACE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ORIGINAL_OBJECT = NAMESPACE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__CLASSIFIERS = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__SUBPACKAGES = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__PREFIX = NAMESPACE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__URI = NAMESPACE_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__ANNOTATIONS = PACKAGE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__ORIGINAL_OBJECT = PACKAGE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__ORIGINAL_XMI_ID = PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__NAME = PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__CLASSIFIERS = PACKAGE_CS__CLASSIFIERS;

	/**
	 * The feature id for the '<em><b>Subpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__SUBPACKAGES = PACKAGE_CS__SUBPACKAGES;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__PREFIX = PACKAGE_CS__PREFIX;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS__URI = PACKAGE_CS__URI;

	/**
	 * The number of structural features of the '<em>Bound Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_DOCUMENT_CS_FEATURE_COUNT = PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS__ORIGINAL_OBJECT = NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS__BINDINGS = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS__BINDS = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bound Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ANNOTATIONS = FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ORIGINAL_OBJECT = FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ORIGINAL_XMI_ID = FEATURE_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__QUALIFIERS = FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__TYPE = FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__UPPER = FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__IS_STATIC = FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__IS_DEFINITION = FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__PARAMETERS = FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__TYPE_PARAMETERS = FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNER = FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS_FEATURE_COUNT = FEATURE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__ANNOTATIONS = OPERATION_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__ORIGINAL_OBJECT = OPERATION_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__ORIGINAL_XMI_ID = OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__NAME = OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__LOWER = OPERATION_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__MULTIPLICITY = OPERATION_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__QUALIFIERS = OPERATION_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__TYPE = OPERATION_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__UPPER = OPERATION_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__IS_STATIC = OPERATION_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__IS_DEFINITION = OPERATION_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__PARAMETERS = OPERATION_CS__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__TYPE_PARAMETERS = OPERATION_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__OWNER = OPERATION_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__BINDINGS = OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS__BINDS = OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bound Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_OPERATION_CS_FEATURE_COUNT = OPERATION_CS_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_REF_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The number of structural features of the '<em>Classifier Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The number of structural features of the '<em>Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__ANNOTATIONS = TYPE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__ORIGINAL_OBJECT = TYPE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__ORIGINAL_XMI_ID = TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The number of structural features of the '<em>Typed Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS_FEATURE_COUNT = TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__ANNOTATIONS = TYPED_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__ORIGINAL_OBJECT = TYPED_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPED_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__NAME = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS__TYPE_ARGUMENTS = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_REF_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__ID_NAME = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__STRING_NAME = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__VALUE = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Detail CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__ANNOTATIONS = NAMESPACE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__ORIGINAL_OBJECT = NAMESPACE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__IMPORTS = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__LIBRARIES = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS__ORIGINAL_OBJECT = NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS__VALUE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ANNOTATIONS = NAMESPACE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ORIGINAL_OBJECT = NAMESPACE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__ANNOTATIONS = NAMESPACE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__ORIGINAL_OBJECT = NAMESPACE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REF_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The number of structural features of the '<em>Operation Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPackageRefCS()
	 * @generated
	 */
	int PACKAGE_REF_CS = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The number of structural features of the '<em>Package Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ANNOTATIONS = TYPED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ORIGINAL_OBJECT = TYPED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__QUALIFIERS = TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__TYPE = TYPED_ELEMENT_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl <em>Parameterized Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterizedTypeRefCS()
	 * @generated
	 */
	int PARAMETERIZED_TYPE_REF_CS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedClassifierRefCSImpl <em>Qualified Classifier Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedClassifierRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedClassifierRefCS()
	 * @generated
	 */
	int QUALIFIED_CLASSIFIER_REF_CS = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedOperationRefCSImpl <em>Qualified Operation Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedOperationRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedOperationRefCS()
	 * @generated
	 */
	int QUALIFIED_OPERATION_REF_CS = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedPackageRefCSImpl <em>Qualified Package Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedPackageRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedPackageRefCS()
	 * @generated
	 */
	int QUALIFIED_PACKAGE_REF_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS <em>Qualified Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedRefCS()
	 * @generated
	 */
	int QUALIFIED_REF_CS = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureRefCSImpl <em>Structural Feature Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getStructuralFeatureRefCS()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_REF_CS = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedStructuralFeatureRefCSImpl <em>Qualified Structural Feature Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedStructuralFeatureRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedStructuralFeatureRefCS()
	 * @generated
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedTypeRefCSImpl <em>Qualified Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedTypeRefCS()
	 * @generated
	 */
	int QUALIFIED_TYPE_REF_CS = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleClassifierRefCSImpl <em>Simple Classifier Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleClassifierRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimpleClassifierRefCS()
	 * @generated
	 */
	int SIMPLE_CLASSIFIER_REF_CS = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleOperationRefCSImpl <em>Simple Operation Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleOperationRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimpleOperationRefCS()
	 * @generated
	 */
	int SIMPLE_OPERATION_REF_CS = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimplePackageRefCSImpl <em>Simple Package Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimplePackageRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimplePackageRefCS()
	 * @generated
	 */
	int SIMPLE_PACKAGE_REF_CS = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleStructuralFeatureRefCSImpl <em>Simple Structural Feature Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleStructuralFeatureRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimpleStructuralFeatureRefCS()
	 * @generated
	 */
	int SIMPLE_STRUCTURAL_FEATURE_REF_CS = 42;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__ANNOTATIONS = TYPED_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__ORIGINAL_OBJECT = TYPED_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPED_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS__TYPE_ARGUMENTS = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameterized Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_REF_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__ANNOTATIONS = TYPED_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__ORIGINAL_OBJECT = TYPED_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPED_REF_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLASSIFIER_REF_CS__ANNOTATIONS = CLASSIFIER_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLASSIFIER_REF_CS__ORIGINAL_OBJECT = CLASSIFIER_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLASSIFIER_REF_CS__ORIGINAL_XMI_ID = CLASSIFIER_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE = CLASSIFIER_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLASSIFIER_REF_CS__ELEMENT = CLASSIFIER_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Classifier Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLASSIFIER_REF_CS_FEATURE_COUNT = CLASSIFIER_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_OPERATION_REF_CS__ANNOTATIONS = OPERATION_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_OPERATION_REF_CS__ORIGINAL_OBJECT = OPERATION_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_OPERATION_REF_CS__ORIGINAL_XMI_ID = OPERATION_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_OPERATION_REF_CS__NAMESPACE = OPERATION_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_OPERATION_REF_CS__ELEMENT = OPERATION_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Operation Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_OPERATION_REF_CS_FEATURE_COUNT = OPERATION_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_PACKAGE_REF_CS__ANNOTATIONS = PACKAGE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_PACKAGE_REF_CS__ORIGINAL_OBJECT = PACKAGE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_PACKAGE_REF_CS__ORIGINAL_XMI_ID = PACKAGE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_PACKAGE_REF_CS__NAMESPACE = PACKAGE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_PACKAGE_REF_CS__ELEMENT = PACKAGE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Package Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_PACKAGE_REF_CS_FEATURE_COUNT = PACKAGE_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_REF_CS__ORIGINAL_OBJECT = MODEL_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_REF_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The number of structural features of the '<em>Structural Feature Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ANNOTATIONS = STRUCTURAL_FEATURE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ORIGINAL_OBJECT = STRUCTURAL_FEATURE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE = STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT = STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Structural Feature Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__ANNOTATIONS = PARAMETERIZED_TYPE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__ORIGINAL_OBJECT = PARAMETERIZED_TYPE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__ORIGINAL_XMI_ID = PARAMETERIZED_TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_TYPE_REF_CS__TYPE_ARGUMENTS = PARAMETERIZED_TYPE_REF_CS__TYPE_ARGUMENTS;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ANNOTATIONS = STRUCTURAL_FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ORIGINAL_OBJECT = STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__QUALIFIERS = STRUCTURAL_FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__TYPE = STRUCTURAL_FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__UPPER = STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__IS_STATIC = STRUCTURAL_FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__IS_DEFINITION = STRUCTURAL_FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNER = STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OPPOSITE = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CLASSIFIER_REF_CS__ANNOTATIONS = CLASSIFIER_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CLASSIFIER_REF_CS__ORIGINAL_OBJECT = CLASSIFIER_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CLASSIFIER_REF_CS__ORIGINAL_XMI_ID = CLASSIFIER_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CLASSIFIER_REF_CS__CLASSIFIER = CLASSIFIER_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Classifier Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CLASSIFIER_REF_CS_FEATURE_COUNT = CLASSIFIER_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_REF_CS__ANNOTATIONS = OPERATION_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_REF_CS__ORIGINAL_OBJECT = OPERATION_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_REF_CS__ORIGINAL_XMI_ID = OPERATION_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_REF_CS__OPERATION = OPERATION_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Operation Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_REF_CS_FEATURE_COUNT = OPERATION_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PACKAGE_REF_CS__ANNOTATIONS = PACKAGE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PACKAGE_REF_CS__ORIGINAL_OBJECT = PACKAGE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PACKAGE_REF_CS__ORIGINAL_XMI_ID = PACKAGE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PACKAGE_REF_CS__PACKAGE = PACKAGE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Package Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PACKAGE_REF_CS_FEATURE_COUNT = PACKAGE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STRUCTURAL_FEATURE_REF_CS__ANNOTATIONS = STRUCTURAL_FEATURE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STRUCTURAL_FEATURE_REF_CS__ORIGINAL_OBJECT = STRUCTURAL_FEATURE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STRUCTURAL_FEATURE_REF_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STRUCTURAL_FEATURE_REF_CS__FEATURE = STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Structural Feature Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingCSImpl <em>Type Binding CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeBindingCS()
	 * @generated
	 */
	int TYPE_BINDING_CS = 45;

	/**
	 * The feature id for the '<em><b>Type Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDING_CS__TYPE_PARAMETER = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDING_CS__TYPE_ARGUMENT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDING_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl <em>Type Bindings CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeBindingsCS()
	 * @generated
	 */
	int TYPE_BINDINGS_CS = 46;

	/**
	 * The feature id for the '<em><b>Bound Document</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDINGS_CS__BOUND_DOCUMENT = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDINGS_CS__BINDINGS = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nested</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDINGS_CS__NESTED = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Bindings CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BINDINGS_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ORIGINAL_OBJECT = NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__EXTENDS = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__SUPER = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__ANNOTATIONS = PARAMETERIZED_TYPE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__ORIGINAL_OBJECT = PARAMETERIZED_TYPE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__ORIGINAL_XMI_ID = PARAMETERIZED_TYPE_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__TYPE_ARGUMENTS = PARAMETERIZED_TYPE_REF_CS__TYPE_ARGUMENTS;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__ANNOTATIONS = TYPE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__ORIGINAL_OBJECT = TYPE_REF_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__ORIGINAL_XMI_ID = TYPE_REF_CS__ORIGINAL_XMI_ID;

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
	 * The meta object id for the '<em>Signature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.util.Signature
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 54;

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS#getDetails()
	 * @see #getAnnotationElementCS()
	 * @generated
	 */
	EReference getAnnotationElementCS_Details();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassCS <em>Bound Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassCS
	 * @generated
	 */
	EClass getBoundClassCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS <em>Bound Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Classifier CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS
	 * @generated
	 */
	EClass getBoundClassifierCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS <em>Bound Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS
	 * @generated
	 */
	EClass getBoundElementCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bindings</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBindings()
	 * @see #getBoundElementCS()
	 * @generated
	 */
	EReference getBoundElementCS_Bindings();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBinds <em>Binds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binds</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS#getBinds()
	 * @see #getBoundElementCS()
	 * @generated
	 */
	EReference getBoundElementCS_Binds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS <em>Bound Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS
	 * @generated
	 */
	EClass getBoundOperationCS();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Types</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getSuperTypes()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOperations()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getStructuralFeatures <em>Structural Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structural Features</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getStructuralFeatures()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_StructuralFeatures();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getTypeParameters()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_TypeParameters();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS <em>Classifier Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS
	 * @generated
	 */
	EClass getClassifierRefCS();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS#getTypeArguments()
	 * @see #getCollectionTypeRefCS()
	 * @generated
	 */
	EReference getCollectionTypeRefCS_TypeArguments();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getIdName <em>Id Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getIdName()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_IdName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getStringName <em>String Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS#getStringName()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_StringName();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS <em>Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS
	 * @generated
	 */
	EClass getDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getImports()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getLibraries <em>Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Libraries</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getLibraries()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Libraries();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS <em>Enum Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS
	 * @generated
	 */
	EClass getEnumLiteralCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS#getValue()
	 * @see #getEnumLiteralCS()
	 * @generated
	 */
	EAttribute getEnumLiteralCS_Value();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsStatic()
	 * @see #getFeatureCS()
	 * @generated
	 */
	EAttribute getFeatureCS_IsStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsDefinition <em>Is Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Definition</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsDefinition()
	 * @see #getFeatureCS()
	 * @generated
	 */
	EAttribute getFeatureCS_IsDefinition();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getAnnotations()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_Annotations();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOriginalObject()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_OriginalObject();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getParameters()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getTypeParameters()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_TypeParameters();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwner()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS <em>Operation Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS
	 * @generated
	 */
	EClass getOperationRefCS();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getClassifiers <em>Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifiers</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getClassifiers()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_Classifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getSubpackages <em>Subpackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subpackages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getSubpackages()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_Subpackages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getPrefix()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getUri()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageRefCS
	 * @generated
	 */
	EClass getPackageRefCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS <em>Parameterized Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS
	 * @generated
	 */
	EClass getParameterizedTypeRefCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS#getTypeArguments()
	 * @see #getParameterizedTypeRefCS()
	 * @generated
	 */
	EReference getParameterizedTypeRefCS_TypeArguments();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS <em>Qualified Classifier Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Classifier Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS
	 * @generated
	 */
	EClass getQualifiedClassifierRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS <em>Qualified Operation Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Operation Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS
	 * @generated
	 */
	EClass getQualifiedOperationRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS <em>Qualified Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Package Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS
	 * @generated
	 */
	EClass getQualifiedPackageRefCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS <em>Qualified Structural Feature Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Structural Feature Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS
	 * @generated
	 */
	EClass getQualifiedStructuralFeatureRefCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS <em>Simple Classifier Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Classifier Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS
	 * @generated
	 */
	EClass getSimpleClassifierRefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS#getClassifier()
	 * @see #getSimpleClassifierRefCS()
	 * @generated
	 */
	EReference getSimpleClassifierRefCS_Classifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS <em>Simple Operation Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Operation Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS
	 * @generated
	 */
	EClass getSimpleOperationRefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS#getOperation()
	 * @see #getSimpleOperationRefCS()
	 * @generated
	 */
	EReference getSimpleOperationRefCS_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS <em>Simple Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Package Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS
	 * @generated
	 */
	EClass getSimplePackageRefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS#getPackage()
	 * @see #getSimplePackageRefCS()
	 * @generated
	 */
	EReference getSimplePackageRefCS_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS <em>Simple Structural Feature Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Structural Feature Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS
	 * @generated
	 */
	EClass getSimpleStructuralFeatureRefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS#getFeature()
	 * @see #getSimpleStructuralFeatureRefCS()
	 * @generated
	 */
	EReference getSimpleStructuralFeatureRefCS_Feature();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS <em>Structural Feature Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS
	 * @generated
	 */
	EClass getStructuralFeatureRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS <em>Type Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Binding CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS
	 * @generated
	 */
	EClass getTypeBindingCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeParameter <em>Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeParameter()
	 * @see #getTypeBindingCS()
	 * @generated
	 */
	EReference getTypeBindingCS_TypeParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeArgument <em>Type Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Argument</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeArgument()
	 * @see #getTypeBindingCS()
	 * @generated
	 */
	EReference getTypeBindingCS_TypeArgument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS <em>Type Bindings CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Bindings CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS
	 * @generated
	 */
	EClass getTypeBindingsCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBoundDocument <em>Bound Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound Document</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBoundDocument()
	 * @see #getTypeBindingsCS()
	 * @generated
	 */
	EReference getTypeBindingsCS_BoundDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getBindings()
	 * @see #getTypeBindingsCS()
	 * @generated
	 */
	EReference getTypeBindingsCS_Bindings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getNested <em>Nested</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS#getNested()
	 * @see #getTypeBindingsCS()
	 * @generated
	 */
	EReference getTypeBindingsCS_Nested();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getExtends()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS#getSuper()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_Super();

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
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getQualifiers()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Qualifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS#getType()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EReference getTypedElementCS_Type();

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
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.xtext.base.util.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Signature</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.util.Signature
	 * @model instanceClass="org.eclipse.ocl.examples.xtext.base.util.Signature"
	 * @generated
	 */
	EDataType getSignature();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getAnnotationElementCS()
		 * @generated
		 */
		EClass ANNOTATION_ELEMENT_CS = eINSTANCE.getAnnotationElementCS();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_ELEMENT_CS__DETAILS = eINSTANCE.getAnnotationElementCS_Details();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS <em>Attribute CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl <em>Bound Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundClassCS()
		 * @generated
		 */
		EClass BOUND_CLASS_CS = eINSTANCE.getBoundClassCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassifierCSImpl <em>Bound Classifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassifierCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundClassifierCS()
		 * @generated
		 */
		EClass BOUND_CLASSIFIER_CS = eINSTANCE.getBoundClassifierCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS <em>Bound Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundElementCS()
		 * @generated
		 */
		EClass BOUND_ELEMENT_CS = eINSTANCE.getBoundElementCS();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_ELEMENT_CS__BINDINGS = eINSTANCE.getBoundElementCS_Bindings();

		/**
		 * The meta object literal for the '<em><b>Binds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_ELEMENT_CS__BINDS = eINSTANCE.getBoundElementCS_Binds();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundOperationCSImpl <em>Bound Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundOperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getBoundOperationCS()
		 * @generated
		 */
		EClass BOUND_OPERATION_CS = eINSTANCE.getBoundOperationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassCS()
		 * @generated
		 */
		EClass CLASS_CS = eINSTANCE.getClassCS();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__SUPER_TYPES = eINSTANCE.getClassCS_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OPERATIONS = eINSTANCE.getClassCS_Operations();

		/**
		 * The meta object literal for the '<em><b>Structural Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__STRUCTURAL_FEATURES = eINSTANCE.getClassCS_StructuralFeatures();

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
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__TYPE_PARAMETERS = eINSTANCE.getClassifierCS_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__OWNER = eINSTANCE.getClassifierCS_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierRefCSImpl <em>Classifier Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getClassifierRefCS()
		 * @generated
		 */
		EClass CLASSIFIER_REF_CS = eINSTANCE.getClassifierRefCS();

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
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_REF_CS__TYPE_ARGUMENTS = eINSTANCE.getCollectionTypeRefCS_TypeArguments();

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
		 * The meta object literal for the '<em><b>Id Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__ID_NAME = eINSTANCE.getDetailCS_IdName();

		/**
		 * The meta object literal for the '<em><b>String Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__STRING_NAME = eINSTANCE.getDetailCS_StringName();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__VALUE = eINSTANCE.getDetailCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl <em>Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getDocumentCS()
		 * @generated
		 */
		EClass DOCUMENT_CS = eINSTANCE.getDocumentCS();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_CS__IMPORTS = eINSTANCE.getDocumentCS_Imports();

		/**
		 * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_CS__LIBRARIES = eINSTANCE.getDocumentCS_Libraries();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumLiteralCSImpl <em>Enum Literal CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.EnumLiteralCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getEnumLiteralCS()
		 * @generated
		 */
		EClass ENUM_LITERAL_CS = eINSTANCE.getEnumLiteralCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_CS__VALUE = eINSTANCE.getEnumLiteralCS_Value();

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
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CS__IS_STATIC = eINSTANCE.getFeatureCS_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Is Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CS__IS_DEFINITION = eINSTANCE.getFeatureCS_IsDefinition();

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
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS__ANNOTATIONS = eINSTANCE.getModelElementCS_Annotations();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS__ORIGINAL_OBJECT = eINSTANCE.getModelElementCS_OriginalObject();

		/**
		 * The meta object literal for the '<em><b>Original Xmi Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = eINSTANCE.getModelElementCS_OriginalXmiId();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__PARAMETERS = eINSTANCE.getOperationCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__TYPE_PARAMETERS = eINSTANCE.getOperationCS_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNER = eINSTANCE.getOperationCS_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationRefCSImpl <em>Operation Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getOperationRefCS()
		 * @generated
		 */
		EClass OPERATION_REF_CS = eINSTANCE.getOperationRefCS();

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
		 * The meta object literal for the '<em><b>Classifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__CLASSIFIERS = eINSTANCE.getPackageCS_Classifiers();

		/**
		 * The meta object literal for the '<em><b>Subpackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__SUBPACKAGES = eINSTANCE.getPackageCS_Subpackages();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__PREFIX = eINSTANCE.getPackageCS_Prefix();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__URI = eINSTANCE.getPackageCS_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getPackageRefCS()
		 * @generated
		 */
		EClass PACKAGE_REF_CS = eINSTANCE.getPackageRefCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl <em>Parameterized Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getParameterizedTypeRefCS()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE_REF_CS = eINSTANCE.getParameterizedTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE_REF_CS__TYPE_ARGUMENTS = eINSTANCE.getParameterizedTypeRefCS_TypeArguments();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedClassifierRefCSImpl <em>Qualified Classifier Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedClassifierRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedClassifierRefCS()
		 * @generated
		 */
		EClass QUALIFIED_CLASSIFIER_REF_CS = eINSTANCE.getQualifiedClassifierRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedOperationRefCSImpl <em>Qualified Operation Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedOperationRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedOperationRefCS()
		 * @generated
		 */
		EClass QUALIFIED_OPERATION_REF_CS = eINSTANCE.getQualifiedOperationRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedPackageRefCSImpl <em>Qualified Package Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedPackageRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedPackageRefCS()
		 * @generated
		 */
		EClass QUALIFIED_PACKAGE_REF_CS = eINSTANCE.getQualifiedPackageRefCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedStructuralFeatureRefCSImpl <em>Qualified Structural Feature Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedStructuralFeatureRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getQualifiedStructuralFeatureRefCS()
		 * @generated
		 */
		EClass QUALIFIED_STRUCTURAL_FEATURE_REF_CS = eINSTANCE.getQualifiedStructuralFeatureRefCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS <em>Reference CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleClassifierRefCSImpl <em>Simple Classifier Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleClassifierRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimpleClassifierRefCS()
		 * @generated
		 */
		EClass SIMPLE_CLASSIFIER_REF_CS = eINSTANCE.getSimpleClassifierRefCS();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_CLASSIFIER_REF_CS__CLASSIFIER = eINSTANCE.getSimpleClassifierRefCS_Classifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleOperationRefCSImpl <em>Simple Operation Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleOperationRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimpleOperationRefCS()
		 * @generated
		 */
		EClass SIMPLE_OPERATION_REF_CS = eINSTANCE.getSimpleOperationRefCS();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_OPERATION_REF_CS__OPERATION = eINSTANCE.getSimpleOperationRefCS_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimplePackageRefCSImpl <em>Simple Package Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimplePackageRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimplePackageRefCS()
		 * @generated
		 */
		EClass SIMPLE_PACKAGE_REF_CS = eINSTANCE.getSimplePackageRefCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PACKAGE_REF_CS__PACKAGE = eINSTANCE.getSimplePackageRefCS_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleStructuralFeatureRefCSImpl <em>Simple Structural Feature Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.SimpleStructuralFeatureRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSimpleStructuralFeatureRefCS()
		 * @generated
		 */
		EClass SIMPLE_STRUCTURAL_FEATURE_REF_CS = eINSTANCE.getSimpleStructuralFeatureRefCS();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_STRUCTURAL_FEATURE_REF_CS__FEATURE = eINSTANCE.getSimpleStructuralFeatureRefCS_Feature();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureRefCSImpl <em>Structural Feature Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.StructuralFeatureRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getStructuralFeatureRefCS()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_REF_CS = eINSTANCE.getStructuralFeatureRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingCSImpl <em>Type Binding CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeBindingCS()
		 * @generated
		 */
		EClass TYPE_BINDING_CS = eINSTANCE.getTypeBindingCS();

		/**
		 * The meta object literal for the '<em><b>Type Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_BINDING_CS__TYPE_PARAMETER = eINSTANCE.getTypeBindingCS_TypeParameter();

		/**
		 * The meta object literal for the '<em><b>Type Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_BINDING_CS__TYPE_ARGUMENT = eINSTANCE.getTypeBindingCS_TypeArgument();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl <em>Type Bindings CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getTypeBindingsCS()
		 * @generated
		 */
		EClass TYPE_BINDINGS_CS = eINSTANCE.getTypeBindingsCS();

		/**
		 * The meta object literal for the '<em><b>Bound Document</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_BINDINGS_CS__BOUND_DOCUMENT = eINSTANCE.getTypeBindingsCS_BoundDocument();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_BINDINGS_CS__BINDINGS = eINSTANCE.getTypeBindingsCS_Bindings();

		/**
		 * The meta object literal for the '<em><b>Nested</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_BINDINGS_CS__NESTED = eINSTANCE.getTypeBindingsCS_Nested();

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
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__EXTENDS = eINSTANCE.getTypeParameterCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__SUPER = eINSTANCE.getTypeParameterCS_Super();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS <em>Typed Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS
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
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__QUALIFIERS = eINSTANCE.getTypedElementCS_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_CS__TYPE = eINSTANCE.getTypedElementCS_Type();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__UPPER = eINSTANCE.getTypedElementCS_Upper();

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
		 * The meta object literal for the '<em>Signature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.util.Signature
		 * @see org.eclipse.ocl.examples.xtext.base.baseCST.impl.BaseCSTPackageImpl#getSignature()
		 * @generated
		 */
		EDataType SIGNATURE = eINSTANCE.getSignature();

	}

} //BaseCSTPackage
