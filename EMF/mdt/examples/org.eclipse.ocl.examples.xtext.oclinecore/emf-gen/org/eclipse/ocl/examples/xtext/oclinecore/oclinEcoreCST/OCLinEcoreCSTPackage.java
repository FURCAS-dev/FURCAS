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
 * $Id: OCLinEcoreCSTPackage.java,v 1.6 2010/05/24 08:55:13 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;

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
	int ANNOTATION_CS__ANNOTATIONS = BaseCSTPackage.ANNOTATION_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ORIGINAL_OBJECT = BaseCSTPackage.ANNOTATION_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__DETAILS = BaseCSTPackage.ANNOTATION_ELEMENT_CS__DETAILS;

	/**
	 * The feature id for the '<em><b>Id Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ID_SOURCE = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__STRING_SOURCE = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__CONTENTS = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__REFERENCES = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Annotation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS_FEATURE_COUNT = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS <em>OC Lin Ecore Structural Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreStructuralFeatureCS()
	 * @generated
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreAttributeCSImpl <em>OC Lin Ecore Attribute CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreAttributeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreAttributeCS()
	 * @generated
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumCSImpl <em>Enum CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.EnumCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getEnumCS()
	 * @generated
	 */
	int ENUM_CS = 5;

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS <em>OC Lin Ecore Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Attribute CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS
	 * @generated
	 */
	EClass getOCLinEcoreAttributeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS <em>OC Lin Ecore Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS
	 * @generated
	 */
	EClass getOCLinEcoreClassCS();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeOrEnumCSImpl <em>Data Type Or Enum CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeOrEnumCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeOrEnumCS()
	 * @generated
	 */
	int DATA_TYPE_OR_ENUM_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DataTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDataTypeCS()
	 * @generated
	 */
	int DATA_TYPE_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS <em>OC Lin Ecore Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreClassifierCS()
	 * @generated
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl <em>OC Lin Ecore Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreClassCS()
	 * @generated
	 */
	int OC_LIN_ECORE_CLASS_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.DocumentationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getDocumentationCS()
	 * @generated
	 */
	int DOCUMENTATION_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreDocumentCSImpl <em>OC Lin Ecore Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreDocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreDocumentCS()
	 * @generated
	 */
	int OC_LIN_ECORE_DOCUMENT_CS = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ANNOTATIONS = BaseCSTPackage.NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ORIGINAL_OBJECT = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__STEREOTYPE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__EXPR_STRING = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expr Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__EXPR_VALUE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__ANNOTATIONS = BaseCSTPackage.CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__ORIGINAL_OBJECT = BaseCSTPackage.CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__NAME = BaseCSTPackage.CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__TYPE_PARAMETERS = BaseCSTPackage.CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__OWNER = BaseCSTPackage.CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__CONSTRAINTS = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__INSTANCE_CLASS_NAME = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS__QUALIFIERS = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASSIFIER_CS_FEATURE_COUNT = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__ANNOTATIONS = OC_LIN_ECORE_CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__ORIGINAL_OBJECT = OC_LIN_ECORE_CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__ORIGINAL_XMI_ID = OC_LIN_ECORE_CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__NAME = OC_LIN_ECORE_CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__TYPE_PARAMETERS = OC_LIN_ECORE_CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__OWNER = OC_LIN_ECORE_CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__CONSTRAINTS = OC_LIN_ECORE_CLASSIFIER_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__INSTANCE_CLASS_NAME = OC_LIN_ECORE_CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS__QUALIFIERS = OC_LIN_ECORE_CLASSIFIER_CS__QUALIFIERS;

	/**
	 * The number of structural features of the '<em>Data Type Or Enum CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OR_ENUM_CS_FEATURE_COUNT = OC_LIN_ECORE_CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ANNOTATIONS = DATA_TYPE_OR_ENUM_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ORIGINAL_OBJECT = DATA_TYPE_OR_ENUM_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ORIGINAL_XMI_ID = DATA_TYPE_OR_ENUM_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__NAME = DATA_TYPE_OR_ENUM_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__TYPE_PARAMETERS = DATA_TYPE_OR_ENUM_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNER = DATA_TYPE_OR_ENUM_CS__OWNER;

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
	 * The number of structural features of the '<em>Data Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS_FEATURE_COUNT = DATA_TYPE_OR_ENUM_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ANNOTATIONS = BaseCSTPackage.ANNOTATION_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ORIGINAL_OBJECT = BaseCSTPackage.ANNOTATION_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__DETAILS = BaseCSTPackage.ANNOTATION_ELEMENT_CS__DETAILS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__VALUE = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Documentation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS_FEATURE_COUNT = BaseCSTPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreOperationCSImpl <em>OC Lin Ecore Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreOperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreOperationCS()
	 * @generated
	 */
	int OC_LIN_ECORE_OPERATION_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcorePackageCSImpl <em>OC Lin Ecore Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcorePackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcorePackageCS()
	 * @generated
	 */
	int OC_LIN_ECORE_PACKAGE_CS = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__ANNOTATIONS = DATA_TYPE_OR_ENUM_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__ORIGINAL_OBJECT = DATA_TYPE_OR_ENUM_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__ORIGINAL_XMI_ID = DATA_TYPE_OR_ENUM_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__NAME = DATA_TYPE_OR_ENUM_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__TYPE_PARAMETERS = DATA_TYPE_OR_ENUM_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CS__OWNER = DATA_TYPE_OR_ENUM_CS__OWNER;

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
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ANNOTATIONS = BaseCSTPackage.STRUCTURAL_FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT = BaseCSTPackage.STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__NAME = BaseCSTPackage.STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__LOWER = BaseCSTPackage.STRUCTURAL_FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__MULTIPLICITY = BaseCSTPackage.STRUCTURAL_FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__QUALIFIERS = BaseCSTPackage.STRUCTURAL_FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__TYPE = BaseCSTPackage.STRUCTURAL_FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__UPPER = BaseCSTPackage.STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__IS_STATIC = BaseCSTPackage.STRUCTURAL_FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__IS_DEFINITION = BaseCSTPackage.STRUCTURAL_FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__OWNER = BaseCSTPackage.STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__CONSTRAINTS = BaseCSTPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL = BaseCSTPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Structural Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_STRUCTURAL_FEATURE_CS_FEATURE_COUNT = BaseCSTPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__ANNOTATIONS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__ORIGINAL_OBJECT = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__ORIGINAL_XMI_ID = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__NAME = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__LOWER = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__MULTIPLICITY = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__QUALIFIERS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__TYPE = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__UPPER = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__IS_STATIC = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__IS_DEFINITION = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__OWNER = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__CONSTRAINTS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS__DEFAULT_VALUE_LITERAL = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Attribute CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_ATTRIBUTE_CS_FEATURE_COUNT = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__ANNOTATIONS = OC_LIN_ECORE_CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__ORIGINAL_OBJECT = OC_LIN_ECORE_CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__ORIGINAL_XMI_ID = OC_LIN_ECORE_CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__NAME = OC_LIN_ECORE_CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__TYPE_PARAMETERS = OC_LIN_ECORE_CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__OWNER = OC_LIN_ECORE_CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__CONSTRAINTS = OC_LIN_ECORE_CLASSIFIER_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__INSTANCE_CLASS_NAME = OC_LIN_ECORE_CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__QUALIFIERS = OC_LIN_ECORE_CLASSIFIER_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__SUPER_TYPES = OC_LIN_ECORE_CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__OPERATIONS = OC_LIN_ECORE_CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS__STRUCTURAL_FEATURES = OC_LIN_ECORE_CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CLASS_CS_FEATURE_COUNT = OC_LIN_ECORE_CLASSIFIER_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__ANNOTATIONS = BaseCSTPackage.DOCUMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__ORIGINAL_OBJECT = BaseCSTPackage.DOCUMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.DOCUMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__NAME = BaseCSTPackage.DOCUMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__IMPORTS = BaseCSTPackage.DOCUMENT_CS__IMPORTS;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__LIBRARIES = BaseCSTPackage.DOCUMENT_CS__LIBRARIES;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS__PACKAGES = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_DOCUMENT_CS_FEATURE_COUNT = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__ANNOTATIONS = BaseCSTPackage.OPERATION_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__ORIGINAL_OBJECT = BaseCSTPackage.OPERATION_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__NAME = BaseCSTPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__LOWER = BaseCSTPackage.OPERATION_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__MULTIPLICITY = BaseCSTPackage.OPERATION_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__QUALIFIERS = BaseCSTPackage.OPERATION_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__TYPE = BaseCSTPackage.OPERATION_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__UPPER = BaseCSTPackage.OPERATION_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__IS_STATIC = BaseCSTPackage.OPERATION_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__IS_DEFINITION = BaseCSTPackage.OPERATION_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__PARAMETERS = BaseCSTPackage.OPERATION_CS__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__TYPE_PARAMETERS = BaseCSTPackage.OPERATION_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__OWNER = BaseCSTPackage.OPERATION_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__CONSTRAINTS = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS__EXCEPTIONS = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_OPERATION_CS_FEATURE_COUNT = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__ANNOTATIONS = BaseCSTPackage.PACKAGE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__ORIGINAL_OBJECT = BaseCSTPackage.PACKAGE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__NAME = BaseCSTPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__CLASSIFIERS = BaseCSTPackage.PACKAGE_CS__CLASSIFIERS;

	/**
	 * The feature id for the '<em><b>Subpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__SUBPACKAGES = BaseCSTPackage.PACKAGE_CS__SUBPACKAGES;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__PREFIX = BaseCSTPackage.PACKAGE_CS__PREFIX;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS__URI = BaseCSTPackage.PACKAGE_CS__URI;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_PACKAGE_CS_FEATURE_COUNT = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreReferenceCSImpl <em>OC Lin Ecore Reference CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreReferenceCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreReferenceCS()
	 * @generated
	 */
	int OC_LIN_ECORE_REFERENCE_CS = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__ANNOTATIONS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__ORIGINAL_OBJECT = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__ORIGINAL_XMI_ID = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__NAME = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__LOWER = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__MULTIPLICITY = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__QUALIFIERS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__TYPE = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__UPPER = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__IS_STATIC = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__IS_DEFINITION = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__OWNER = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__CONSTRAINTS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__DEFAULT_VALUE_LITERAL = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__OPPOSITE = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS__KEYS = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Reference CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_REFERENCE_CS_FEATURE_COUNT = OC_LIN_ECORE_STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PostconditionCSImpl <em>Postcondition CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PostconditionCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getPostconditionCS()
	 * @generated
	 */
	int POSTCONDITION_CS = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__ANNOTATIONS = CONSTRAINT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__ORIGINAL_OBJECT = CONSTRAINT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__ORIGINAL_XMI_ID = CONSTRAINT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__NAME = CONSTRAINT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__STEREOTYPE = CONSTRAINT_CS__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__EXPR_STRING = CONSTRAINT_CS__EXPR_STRING;

	/**
	 * The feature id for the '<em><b>Expr Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS__EXPR_VALUE = CONSTRAINT_CS__EXPR_VALUE;

	/**
	 * The number of structural features of the '<em>Postcondition CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_CS_FEATURE_COUNT = CONSTRAINT_CS_FEATURE_COUNT + 0;

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS <em>OC Lin Ecore Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Classifier CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS
	 * @generated
	 */
	EClass getOCLinEcoreClassifierCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS#getConstraints()
	 * @see #getOCLinEcoreClassifierCS()
	 * @generated
	 */
	EReference getOCLinEcoreClassifierCS_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS#getInstanceClassName()
	 * @see #getOCLinEcoreClassifierCS()
	 * @generated
	 */
	EAttribute getOCLinEcoreClassifierCS_InstanceClassName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS#getQualifiers()
	 * @see #getOCLinEcoreClassifierCS()
	 * @generated
	 */
	EAttribute getOCLinEcoreClassifierCS_Qualifiers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS <em>OC Lin Ecore Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS
	 * @generated
	 */
	EClass getOCLinEcoreDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS#getPackages()
	 * @see #getOCLinEcoreDocumentCS()
	 * @generated
	 */
	EReference getOCLinEcoreDocumentCS_Packages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS <em>OC Lin Ecore Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS
	 * @generated
	 */
	EClass getOCLinEcoreOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS#getConstraints()
	 * @see #getOCLinEcoreOperationCS()
	 * @generated
	 */
	EReference getOCLinEcoreOperationCS_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS#getExceptions()
	 * @see #getOCLinEcoreOperationCS()
	 * @generated
	 */
	EReference getOCLinEcoreOperationCS_Exceptions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS <em>OC Lin Ecore Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS
	 * @generated
	 */
	EClass getOCLinEcorePackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS <em>OC Lin Ecore Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Reference CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS
	 * @generated
	 */
	EClass getOCLinEcoreReferenceCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS#getKeys()
	 * @see #getOCLinEcoreReferenceCS()
	 * @generated
	 */
	EReference getOCLinEcoreReferenceCS_Keys();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS <em>OC Lin Ecore Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Structural Feature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS
	 * @generated
	 */
	EClass getOCLinEcoreStructuralFeatureCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getConstraints()
	 * @see #getOCLinEcoreStructuralFeatureCS()
	 * @generated
	 */
	EReference getOCLinEcoreStructuralFeatureCS_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getDefaultValueLiteral <em>Default Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value Literal</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getDefaultValueLiteral()
	 * @see #getOCLinEcoreStructuralFeatureCS()
	 * @generated
	 */
	EAttribute getOCLinEcoreStructuralFeatureCS_DefaultValueLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PostconditionCS <em>Postcondition CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postcondition CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PostconditionCS
	 * @generated
	 */
	EClass getPostconditionCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreAttributeCSImpl <em>OC Lin Ecore Attribute CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreAttributeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreAttributeCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_ATTRIBUTE_CS = eINSTANCE.getOCLinEcoreAttributeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl <em>OC Lin Ecore Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreClassCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_CLASS_CS = eINSTANCE.getOCLinEcoreClassCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS <em>OC Lin Ecore Classifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreClassifierCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_CLASSIFIER_CS = eINSTANCE.getOCLinEcoreClassifierCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OC_LIN_ECORE_CLASSIFIER_CS__CONSTRAINTS = eINSTANCE.getOCLinEcoreClassifierCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OC_LIN_ECORE_CLASSIFIER_CS__INSTANCE_CLASS_NAME = eINSTANCE.getOCLinEcoreClassifierCS_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OC_LIN_ECORE_CLASSIFIER_CS__QUALIFIERS = eINSTANCE.getOCLinEcoreClassifierCS_Qualifiers();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreDocumentCSImpl <em>OC Lin Ecore Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreDocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreDocumentCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_DOCUMENT_CS = eINSTANCE.getOCLinEcoreDocumentCS();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OC_LIN_ECORE_DOCUMENT_CS__PACKAGES = eINSTANCE.getOCLinEcoreDocumentCS_Packages();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreOperationCSImpl <em>OC Lin Ecore Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreOperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreOperationCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_OPERATION_CS = eINSTANCE.getOCLinEcoreOperationCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OC_LIN_ECORE_OPERATION_CS__CONSTRAINTS = eINSTANCE.getOCLinEcoreOperationCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OC_LIN_ECORE_OPERATION_CS__EXCEPTIONS = eINSTANCE.getOCLinEcoreOperationCS_Exceptions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcorePackageCSImpl <em>OC Lin Ecore Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcorePackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcorePackageCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_PACKAGE_CS = eINSTANCE.getOCLinEcorePackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreReferenceCSImpl <em>OC Lin Ecore Reference CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreReferenceCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreReferenceCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_REFERENCE_CS = eINSTANCE.getOCLinEcoreReferenceCS();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OC_LIN_ECORE_REFERENCE_CS__KEYS = eINSTANCE.getOCLinEcoreReferenceCS_Keys();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS <em>OC Lin Ecore Structural Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getOCLinEcoreStructuralFeatureCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_STRUCTURAL_FEATURE_CS = eINSTANCE.getOCLinEcoreStructuralFeatureCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__CONSTRAINTS = eINSTANCE.getOCLinEcoreStructuralFeatureCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Default Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OC_LIN_ECORE_STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL = eINSTANCE.getOCLinEcoreStructuralFeatureCS_DefaultValueLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PostconditionCSImpl <em>Postcondition CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PostconditionCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.OCLinEcoreCSTPackageImpl#getPostconditionCS()
		 * @generated
		 */
		EClass POSTCONDITION_CS = eINSTANCE.getPostconditionCS();

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

	}

} //OCLinEcoreCSTPackage
