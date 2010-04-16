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
 * $Id: OCLinEcoreCSTPackage.java,v 1.2 2010/04/16 18:05:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory
 * @model kind="package"
 * @generated
 */
public interface OCLinEcoreCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclinEcoreCST";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.0.0/OCLinEcoreCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclinEcoreCST";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.xtext.oclinecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLinEcoreCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS <em>Model Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getModelElementCS()
	 * @generated
	 */
	int MODEL_ELEMENT_CS = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Model Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAnnotationElementCS()
	 * @generated
	 */
	int ANNOTATION_ELEMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAnnotationCS()
	 * @generated
	 */
	int ANNOTATION_CS = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ANNOTATIONS = ANNOTATION_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__DETAILS = ANNOTATION_ELEMENT_CS__DETAILS;

	/**
	 * The feature id for the '<em><b>Id Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ID_SOURCE = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__STRING_SOURCE = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__CONTENTS = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__REFERENCES = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Annotation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS_FEATURE_COUNT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS <em>Named Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getNamedElementCS()
	 * @generated
	 */
	int NAMED_ELEMENT_CS = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS <em>Typed Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypedElementCS()
	 * @generated
	 */
	int TYPED_ELEMENT_CS = 43;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS <em>Structural Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getStructuralFeatureCS()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_CS = 37;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ANNOTATIONS = TYPED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__LOWER = TYPED_ELEMENT_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__MULTIPLICITY = TYPED_ELEMENT_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__QUALIFIERS = TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__TYPE = TYPED_ELEMENT_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__CONSTRAINTS = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL = TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Structural Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAttributeCS()
	 * @generated
	 */
	int ATTRIBUTE_CS = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ANNOTATIONS = STRUCTURAL_FEATURE_CS__ANNOTATIONS;

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
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__CONSTRAINTS = STRUCTURAL_FEATURE_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__DEFAULT_VALUE_LITERAL = STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL;

	/**
	 * The number of structural features of the '<em>Attribute CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeRefImpl <em>Attribute Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAttributeRef()
	 * @generated
	 */
	int ATTRIBUTE_REF = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSRefImpl <em>Attribute CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAttributeCSRef()
	 * @generated
	 */
	int ATTRIBUTE_CS_REF = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSImpl <em>Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeCS()
	 * @generated
	 */
	int TYPE_CS = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS <em>Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassifierCS()
	 * @generated
	 */
	int CLASSIFIER_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSImpl <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefImpl <em>Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeRef()
	 * @generated
	 */
	int TYPE_REF = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassRefImpl <em>Class Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassRef()
	 * @generated
	 */
	int CLASS_REF = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSRefImpl <em>Class CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassCSRef()
	 * @generated
	 */
	int CLASS_CS_REF = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentCSImpl <em>Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDocumentCS()
	 * @generated
	 */
	int DOCUMENT_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassRefImpl <em>EClass Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEClassRef()
	 * @generated
	 */
	int ECLASS_REF = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierRefImpl <em>EClassifier Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEClassifierRef()
	 * @generated
	 */
	int ECLASSIFIER_REF = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EDataTypeRefImpl <em>EData Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EDataTypeRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEDataTypeRef()
	 * @generated
	 */
	int EDATA_TYPE_REF = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceRefImpl <em>Reference Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getReferenceRef()
	 * @generated
	 */
	int REFERENCE_REF = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EReferenceRefImpl <em>EReference Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EReferenceRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEReferenceRef()
	 * @generated
	 */
	int EREFERENCE_REF = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumCSImpl <em>Enum CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEnumCS()
	 * @generated
	 */
	int ENUM_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumLiteralCSImpl <em>Enum Literal CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumLiteralCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEnumLiteralCS()
	 * @generated
	 */
	int ENUM_LITERAL_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ImportCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OperationCSImpl <em>Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOperationCS()
	 * @generated
	 */
	int OPERATION_CS = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl <em>Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getPackageCS()
	 * @generated
	 */
	int PACKAGE_CS = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getParameterCS()
	 * @generated
	 */
	int PARAMETER_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getReferenceCS()
	 * @generated
	 */
	int REFERENCE_CS = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSRefImpl <em>Reference CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getReferenceCSRef()
	 * @generated
	 */
	int REFERENCE_CS_REF = 35;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS
	 * @generated
	 */
	EClass getAnnotationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getIdSource <em>Id Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getIdSource()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EAttribute getAnnotationCS_IdSource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getStringSource <em>String Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getStringSource()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EAttribute getAnnotationCS_StringSource();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getContents()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_Contents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS#getReferences()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_References();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS
	 * @generated
	 */
	EClass getAnnotationElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS#getDetails()
	 * @see #getAnnotationElementCS()
	 * @generated
	 */
	EReference getAnnotationElementCS_Details();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS <em>Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS
	 * @generated
	 */
	EClass getAttributeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef <em>Attribute CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef
	 * @generated
	 */
	EClass getAttributeCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef#getRef()
	 * @see #getAttributeCSRef()
	 * @generated
	 */
	EReference getAttributeCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef <em>Attribute Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef
	 * @generated
	 */
	EClass getAttributeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS
	 * @generated
	 */
	EClass getClassCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Types</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS#getSuperTypes()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS#getOperations()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS#getStructuralFeatures <em>Structural Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structural Features</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS#getStructuralFeatures()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_StructuralFeatures();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef <em>Class CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef
	 * @generated
	 */
	EClass getClassCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef#getRef()
	 * @see #getClassCSRef()
	 * @generated
	 */
	EReference getClassCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassRef <em>Class Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassRef
	 * @generated
	 */
	EClass getClassRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS <em>Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS
	 * @generated
	 */
	EClass getClassifierCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getConstraints()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getInstanceClassName()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EAttribute getClassifierCS_InstanceClassName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getQualifiers()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EAttribute getClassifierCS_Qualifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS#getTypeParameters()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_TypeParameters();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeRefImpl <em>Data Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeRef()
	 * @generated
	 */
	int DATA_TYPE_REF = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeOrEnumCSImpl <em>Data Type Or Enum CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeOrEnumCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeOrEnumCS()
	 * @generated
	 */
	int DATA_TYPE_OR_ENUM_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeCS()
	 * @generated
	 */
	int DATA_TYPE_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSRefImpl <em>Data Type CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeCSRef()
	 * @generated
	 */
	int DATA_TYPE_CS_REF = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DetailCSImpl <em>Detail CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DetailCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDetailCS()
	 * @generated
	 */
	int DETAIL_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EAttributeRefImpl <em>EAttribute Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EAttributeRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEAttributeRef()
	 * @generated
	 */
	int EATTRIBUTE_REF = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierCSRefImpl <em>EClassifier CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEClassifierCSRef()
	 * @generated
	 */
	int ECLASSIFIER_CS_REF = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ObjectRefImpl <em>Object Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ObjectRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getObjectRef()
	 * @generated
	 */
	int OBJECT_REF = 30;

	/**
	 * The number of structural features of the '<em>Object Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REF_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Attribute Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REF_FEATURE_COUNT = OBJECT_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_REF__REF = ATTRIBUTE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_REF_FEATURE_COUNT = ATTRIBUTE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The number of structural features of the '<em>Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ANNOTATIONS = TYPE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__NAME = TYPE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__CONSTRAINTS = TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__INSTANCE_CLASS_NAME = TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__QUALIFIERS = TYPE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__TYPE_PARAMETERS = TYPE_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ANNOTATIONS = CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__CONSTRAINTS = CLASSIFIER_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__QUALIFIERS = CLASSIFIER_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__TYPE_PARAMETERS = CLASSIFIER_CS__TYPE_PARAMETERS;

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
	 * The number of structural features of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_FEATURE_COUNT = OBJECT_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_REF__REF = CLASS_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_REF_FEATURE_COUNT = CLASS_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

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
	 * The feature id for the '<em><b>Expr Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__EXPR_VALUE = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Data Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__ANNOTATIONS = CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__CONSTRAINTS = CLASSIFIER_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__QUALIFIERS = CLASSIFIER_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__TYPE_PARAMETERS = CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The number of structural features of the '<em>Data Type Or Enum CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ANNOTATIONS = DATA_TYPE_OR_ENUM_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__NAME = DATA_TYPE_OR_ENUM_CS__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__CONSTRAINTS = DATA_TYPE_OR_ENUM_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__INSTANCE_CLASS_NAME = DATA_TYPE_OR_ENUM_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__QUALIFIERS = DATA_TYPE_OR_ENUM_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__TYPE_PARAMETERS = DATA_TYPE_OR_ENUM_CS__TYPE_PARAMETERS;

	/**
	 * The number of structural features of the '<em>Data Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS_FEATURE_COUNT = DATA_TYPE_OR_ENUM_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS_REF__REF = DATA_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS_REF_FEATURE_COUNT = DATA_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__ID_NAME = 0;

	/**
	 * The feature id for the '<em><b>String Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__STRING_NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Detail CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__PACKAGES = 1;

	/**
	 * The number of structural features of the '<em>Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDocumentationCS()
	 * @generated
	 */
	int DOCUMENTATION_CS = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ANNOTATIONS = ANNOTATION_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__DETAILS = ANNOTATION_ELEMENT_CS__DETAILS;

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
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_REF__REF = ATTRIBUTE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EAttribute Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_REF_FEATURE_COUNT = ATTRIBUTE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_REF__REF = CLASS_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EClass Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_REF_FEATURE_COUNT = CLASS_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_CS_REF__REF = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_CS_REF__MODEL_NAME = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EClassifier CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_CS_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_REF__REF = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EClassifier Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_REF__REF = DATA_TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EData Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_REF_FEATURE_COUNT = DATA_TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EObjectRefImpl <em>EObject Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EObjectRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEObjectRef()
	 * @generated
	 */
	int EOBJECT_REF = 22;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_REF__REF = OBJECT_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_REF_FEATURE_COUNT = OBJECT_REF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REF_FEATURE_COUNT = OBJECT_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_REF__REF = REFERENCE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EReference Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_REF_FEATURE_COUNT = REFERENCE_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__ANNOTATIONS = DATA_TYPE_OR_ENUM_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__NAME = DATA_TYPE_OR_ENUM_CS__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__CONSTRAINTS = DATA_TYPE_OR_ENUM_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__INSTANCE_CLASS_NAME = DATA_TYPE_OR_ENUM_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__QUALIFIERS = DATA_TYPE_OR_ENUM_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__TYPE_PARAMETERS = DATA_TYPE_OR_ENUM_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__LITERALS = DATA_TYPE_OR_ENUM_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS_FEATURE_COUNT = DATA_TYPE_OR_ENUM_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

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
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ALIAS = 0;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__EPACKAGE = 1;

	/**
	 * The number of structural features of the '<em>Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ModelElementCSRefImpl <em>Model Element CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ModelElementCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getModelElementCSRef()
	 * @generated
	 */
	int MODEL_ELEMENT_CS_REF = 28;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_REF__REF = OBJECT_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_REF_FEATURE_COUNT = OBJECT_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ANNOTATIONS = TYPED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__LOWER = TYPED_ELEMENT_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__MULTIPLICITY = TYPED_ELEMENT_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__QUALIFIERS = TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__TYPE = TYPED_ELEMENT_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__UPPER = TYPED_ELEMENT_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__CONSTRAINTS = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__PARAMETERS = TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__TYPE_PARAMETERS = TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__EXCEPTIONS = TYPED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ANNOTATIONS = NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__CLASSIFIERS = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__SUBPACKAGES = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__PREFIX = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__URI = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ANNOTATIONS = TYPED_ELEMENT_CS__ANNOTATIONS;

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
	 * The number of structural features of the '<em>Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ANNOTATIONS = STRUCTURAL_FEATURE_CS__ANNOTATIONS;

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
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__CONSTRAINTS = STRUCTURAL_FEATURE_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__DEFAULT_VALUE_LITERAL = STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL;

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
	int REFERENCE_CS_REF__REF = REFERENCE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS_REF_FEATURE_COUNT = REFERENCE_REF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSRefImpl <em>Type CS Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSRefImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeCSRef()
	 * @generated
	 */
	int TYPE_CS_REF = 39;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_REF__REF = TYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type CS Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_REF_FEATURE_COUNT = TYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeParameterCS()
	 * @generated
	 */
	int TYPE_PARAMETER_CS = 40;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ANNOTATIONS = TYPE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__NAME = TYPE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__EXTENDS = TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__SUPER = TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeRefCS()
	 * @generated
	 */
	int TYPE_REF_CS = 42;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__ANNOTATIONS = MODEL_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypedTypeRefCS()
	 * @generated
	 */
	int TYPED_TYPE_REF_CS = 44;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__ANNOTATIONS = TYPE_REF_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__TYPE = TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__TYPE_ARGUMENTS = TYPE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS_FEATURE_COUNT = TYPE_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.WildcardTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getWildcardTypeRefCS()
	 * @generated
	 */
	int WILDCARD_TYPE_REF_CS = 45;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__ANNOTATIONS = TYPE_REF_CS__ANNOTATIONS;

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS <em>Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS
	 * @generated
	 */
	EClass getDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS#getImports()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS#getPackages()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Packages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS <em>Documentation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS
	 * @generated
	 */
	EClass getDocumentationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS#getValue()
	 * @see #getDocumentationCS()
	 * @generated
	 */
	EAttribute getDocumentationCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef <em>EAttribute Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAttribute Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef
	 * @generated
	 */
	EClass getEAttributeRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef#getRef()
	 * @see #getEAttributeRef()
	 * @generated
	 */
	EReference getEAttributeRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef <em>EClass Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef
	 * @generated
	 */
	EClass getEClassRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef#getRef()
	 * @see #getEClassRef()
	 * @generated
	 */
	EReference getEClassRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef <em>EClassifier CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClassifier CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef
	 * @generated
	 */
	EClass getEClassifierCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef#getRef()
	 * @see #getEClassifierCSRef()
	 * @generated
	 */
	EReference getEClassifierCSRef_Ref();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef#getModelName()
	 * @see #getEClassifierCSRef()
	 * @generated
	 */
	EAttribute getEClassifierCSRef_ModelName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef <em>EClassifier Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClassifier Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef
	 * @generated
	 */
	EClass getEClassifierRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef#getRef()
	 * @see #getEClassifierRef()
	 * @generated
	 */
	EReference getEClassifierRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef <em>EData Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EData Type Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef
	 * @generated
	 */
	EClass getEDataTypeRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef#getRef()
	 * @see #getEDataTypeRef()
	 * @generated
	 */
	EReference getEDataTypeRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef <em>EObject Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef
	 * @generated
	 */
	EClass getEObjectRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef#getRef()
	 * @see #getEObjectRef()
	 * @generated
	 */
	EReference getEObjectRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef <em>EReference Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef
	 * @generated
	 */
	EClass getEReferenceRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef#getRef()
	 * @see #getEReferenceRef()
	 * @generated
	 */
	EReference getEReferenceRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS <em>Enum CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS
	 * @generated
	 */
	EClass getEnumCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS#getLiterals()
	 * @see #getEnumCS()
	 * @generated
	 */
	EReference getEnumCS_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS <em>Enum Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS
	 * @generated
	 */
	EClass getEnumLiteralCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS#getValue()
	 * @see #getEnumLiteralCS()
	 * @generated
	 */
	EAttribute getEnumLiteralCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS
	 * @generated
	 */
	EClass getImportCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS#getAlias()
	 * @see #getImportCS()
	 * @generated
	 */
	EAttribute getImportCS_Alias();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS#getEPackage <em>EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EPackage</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS#getEPackage()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_EPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS
	 * @generated
	 */
	EClass getModelElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS#getAnnotations()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_Annotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef <em>Model Element CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef
	 * @generated
	 */
	EClass getModelElementCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef#getRef()
	 * @see #getModelElementCSRef()
	 * @generated
	 */
	EReference getModelElementCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS
	 * @generated
	 */
	EClass getNamedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS#getName()
	 * @see #getNamedElementCS()
	 * @generated
	 */
	EAttribute getNamedElementCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef <em>Object Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef
	 * @generated
	 */
	EClass getObjectRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS
	 * @generated
	 */
	EClass getOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getConstraints()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getParameters()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getTypeParameters()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_TypeParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS#getExceptions()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Exceptions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS
	 * @generated
	 */
	EClass getPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getClassifiers <em>Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifiers</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getClassifiers()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_Classifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getSubpackages <em>Subpackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subpackages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getSubpackages()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_Subpackages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getPrefix()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getUri()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS
	 * @generated
	 */
	EClass getParameterCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS <em>Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS
	 * @generated
	 */
	EClass getReferenceCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Opposite</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS#getOpposite()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_Opposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS#getKeys()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_Keys();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef <em>Reference CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef
	 * @generated
	 */
	EClass getReferenceCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef#getRef()
	 * @see #getReferenceCSRef()
	 * @generated
	 */
	EReference getReferenceCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef <em>Reference Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef
	 * @generated
	 */
	EClass getReferenceRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS
	 * @generated
	 */
	EClass getStructuralFeatureCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS#getConstraints()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EReference getStructuralFeatureCS_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS#getDefaultValueLiteral <em>Default Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value Literal</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS#getDefaultValueLiteral()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EAttribute getStructuralFeatureCS_DefaultValueLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCS
	 * @generated
	 */
	EClass getTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef <em>Type CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef
	 * @generated
	 */
	EClass getTypeCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef#getRef()
	 * @see #getTypeCSRef()
	 * @generated
	 */
	EReference getTypeCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS
	 * @generated
	 */
	EClass getTypedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getLower()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getMultiplicity()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Multiplicity();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getQualifiers()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Qualifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getType()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EReference getTypedElementCS_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS#getUpper()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Upper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS <em>Typed Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS
	 * @generated
	 */
	EClass getTypedTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS#getType()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS#getTypeArguments()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_TypeArguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS <em>Wildcard Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS
	 * @generated
	 */
	EClass getWildcardTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS#getExtends()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS#getSuper()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_Super();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS <em>Type Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS
	 * @generated
	 */
	EClass getTypeParameterCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS#getExtends()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS#getSuper()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_Super();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef
	 * @generated
	 */
	EClass getTypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS
	 * @generated
	 */
	EClass getTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS
	 * @generated
	 */
	EClass getConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getStereotype()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EAttribute getConstraintCS_Stereotype();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprString <em>Expr String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr String</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprString()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EAttribute getConstraintCS_ExprString();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprValue <em>Expr Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprValue()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_ExprValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeRef <em>Data Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeRef
	 * @generated
	 */
	EClass getDataTypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS
	 * @generated
	 */
	EClass getDataTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS <em>Data Type Or Enum CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Or Enum CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS
	 * @generated
	 */
	EClass getDataTypeOrEnumCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef <em>Data Type CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type CS Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef
	 * @generated
	 */
	EClass getDataTypeCSRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef#getRef()
	 * @see #getDataTypeCSRef()
	 * @generated
	 */
	EReference getDataTypeCSRef_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS <em>Detail CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS
	 * @generated
	 */
	EClass getDetailCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS#getIdName <em>Id Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS#getIdName()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_IdName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS#getStringName <em>String Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS#getStringName()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_StringName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS#getValue()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLinEcoreCSTFactory getOCLinEcoreCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAnnotationCS()
		 * @generated
		 */
		EClass ANNOTATION_CS = eINSTANCE.getAnnotationCS();

		/**
		 * The meta object literal for the '<em><b>Id Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_CS__ID_SOURCE = eINSTANCE.getAnnotationCS_IdSource();

		/**
		 * The meta object literal for the '<em><b>String Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_CS__STRING_SOURCE = eINSTANCE.getAnnotationCS_StringSource();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__CONTENTS = eINSTANCE.getAnnotationCS_Contents();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__REFERENCES = eINSTANCE.getAnnotationCS_References();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAnnotationElementCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAttributeCS()
		 * @generated
		 */
		EClass ATTRIBUTE_CS = eINSTANCE.getAttributeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSRefImpl <em>Attribute CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAttributeCSRef()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeRefImpl <em>Attribute Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AttributeRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getAttributeRef()
		 * @generated
		 */
		EClass ATTRIBUTE_REF = eINSTANCE.getAttributeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSImpl <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSRefImpl <em>Class CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassCSRef()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassRefImpl <em>Class Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ClassRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassRef()
		 * @generated
		 */
		EClass CLASS_REF = eINSTANCE.getClassRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS <em>Classifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getClassifierCS()
		 * @generated
		 */
		EClass CLASSIFIER_CS = eINSTANCE.getClassifierCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__CONSTRAINTS = eINSTANCE.getClassifierCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CS__INSTANCE_CLASS_NAME = eINSTANCE.getClassifierCS_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CS__QUALIFIERS = eINSTANCE.getClassifierCS_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__TYPE_PARAMETERS = eINSTANCE.getClassifierCS_TypeParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentCSImpl <em>Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDocumentCS()
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
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_CS__PACKAGES = eINSTANCE.getDocumentCS_Packages();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDocumentationCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EAttributeRefImpl <em>EAttribute Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EAttributeRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEAttributeRef()
		 * @generated
		 */
		EClass EATTRIBUTE_REF = eINSTANCE.getEAttributeRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EATTRIBUTE_REF__REF = eINSTANCE.getEAttributeRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassRefImpl <em>EClass Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEClassRef()
		 * @generated
		 */
		EClass ECLASS_REF = eINSTANCE.getEClassRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_REF__REF = eINSTANCE.getEClassRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierCSRefImpl <em>EClassifier CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEClassifierCSRef()
		 * @generated
		 */
		EClass ECLASSIFIER_CS_REF = eINSTANCE.getEClassifierCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASSIFIER_CS_REF__REF = eINSTANCE.getEClassifierCSRef_Ref();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASSIFIER_CS_REF__MODEL_NAME = eINSTANCE.getEClassifierCSRef_ModelName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierRefImpl <em>EClassifier Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EClassifierRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEClassifierRef()
		 * @generated
		 */
		EClass ECLASSIFIER_REF = eINSTANCE.getEClassifierRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASSIFIER_REF__REF = eINSTANCE.getEClassifierRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EDataTypeRefImpl <em>EData Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EDataTypeRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEDataTypeRef()
		 * @generated
		 */
		EClass EDATA_TYPE_REF = eINSTANCE.getEDataTypeRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDATA_TYPE_REF__REF = eINSTANCE.getEDataTypeRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EObjectRefImpl <em>EObject Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EObjectRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEObjectRef()
		 * @generated
		 */
		EClass EOBJECT_REF = eINSTANCE.getEObjectRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_REF__REF = eINSTANCE.getEObjectRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EReferenceRefImpl <em>EReference Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EReferenceRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEReferenceRef()
		 * @generated
		 */
		EClass EREFERENCE_REF = eINSTANCE.getEReferenceRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_REF__REF = eINSTANCE.getEReferenceRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumCSImpl <em>Enum CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEnumCS()
		 * @generated
		 */
		EClass ENUM_CS = eINSTANCE.getEnumCS();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CS__LITERALS = eINSTANCE.getEnumCS_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumLiteralCSImpl <em>Enum Literal CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumLiteralCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEnumLiteralCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ImportCSImpl <em>Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ImportCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getImportCS()
		 * @generated
		 */
		EClass IMPORT_CS = eINSTANCE.getImportCS();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_CS__ALIAS = eINSTANCE.getImportCS_Alias();

		/**
		 * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__EPACKAGE = eINSTANCE.getImportCS_EPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS <em>Model Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getModelElementCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ModelElementCSRefImpl <em>Model Element CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ModelElementCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getModelElementCSRef()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS <em>Named Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getNamedElementCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ObjectRefImpl <em>Object Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ObjectRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getObjectRef()
		 * @generated
		 */
		EClass OBJECT_REF = eINSTANCE.getObjectRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OperationCSImpl <em>Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOperationCS()
		 * @generated
		 */
		EClass OPERATION_CS = eINSTANCE.getOperationCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__CONSTRAINTS = eINSTANCE.getOperationCS_Constraints();

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
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__EXCEPTIONS = eINSTANCE.getOperationCS_Exceptions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl <em>Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getPackageCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getParameterCS()
		 * @generated
		 */
		EClass PARAMETER_CS = eINSTANCE.getParameterCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getReferenceCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSRefImpl <em>Reference CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getReferenceCSRef()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceRefImpl <em>Reference Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getReferenceRef()
		 * @generated
		 */
		EClass REFERENCE_REF = eINSTANCE.getReferenceRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS <em>Structural Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getStructuralFeatureCS()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_CS = eINSTANCE.getStructuralFeatureCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_CS__CONSTRAINTS = eINSTANCE.getStructuralFeatureCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Default Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL = eINSTANCE.getStructuralFeatureCS_DefaultValueLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSImpl <em>Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeCS()
		 * @generated
		 */
		EClass TYPE_CS = eINSTANCE.getTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSRefImpl <em>Type CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeCSRef()
		 * @generated
		 */
		EClass TYPE_CS_REF = eINSTANCE.getTypeCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CS_REF__REF = eINSTANCE.getTypeCSRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS <em>Typed Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypedElementCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypedTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypedTypeRefCS()
		 * @generated
		 */
		EClass TYPED_TYPE_REF_CS = eINSTANCE.getTypedTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__TYPE = eINSTANCE.getTypedTypeRefCS_Type();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__TYPE_ARGUMENTS = eINSTANCE.getTypedTypeRefCS_TypeArguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.WildcardTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getWildcardTypeRefCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeParameterCS()
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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefImpl <em>Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeRef()
		 * @generated
		 */
		EClass TYPE_REF = eINSTANCE.getTypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.TypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getTypeRefCS()
		 * @generated
		 */
		EClass TYPE_REF_CS = eINSTANCE.getTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getConstraintCS()
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
		 * The meta object literal for the '<em><b>Expr Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__EXPR_VALUE = eINSTANCE.getConstraintCS_ExprValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeRefImpl <em>Data Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeRef()
		 * @generated
		 */
		EClass DATA_TYPE_REF = eINSTANCE.getDataTypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeCS()
		 * @generated
		 */
		EClass DATA_TYPE_CS = eINSTANCE.getDataTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeOrEnumCSImpl <em>Data Type Or Enum CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeOrEnumCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeOrEnumCS()
		 * @generated
		 */
		EClass DATA_TYPE_OR_ENUM_CS = eINSTANCE.getDataTypeOrEnumCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSRefImpl <em>Data Type CS Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSRefImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeCSRef()
		 * @generated
		 */
		EClass DATA_TYPE_CS_REF = eINSTANCE.getDataTypeCSRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_CS_REF__REF = eINSTANCE.getDataTypeCSRef_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DetailCSImpl <em>Detail CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DetailCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDetailCS()
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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__VALUE = eINSTANCE.getDetailCS_Value();

	}

} //OCLinEcoreCSTPackage
