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
 * $Id: OCLstdlibCSTPackage.java,v 1.5 2010/05/24 08:59:14 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST;

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
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTFactory
 * @model kind="package"
 * @generated
 */
public interface OCLstdlibCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclstdlibCST";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.0.0/OCLstdlibCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclstdlibCST";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl <em>Lib Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibClassifierCS()
	 * @generated
	 */
	int LIB_CLASSIFIER_CS = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__ANNOTATIONS = BaseCSTPackage.CLASS_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__ORIGINAL_OBJECT = BaseCSTPackage.CLASS_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__NAME = BaseCSTPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__TYPE_PARAMETERS = BaseCSTPackage.CLASS_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__OWNER = BaseCSTPackage.CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__SUPER_TYPES = BaseCSTPackage.CLASS_CS__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__OPERATIONS = BaseCSTPackage.CLASS_CS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES = BaseCSTPackage.CLASS_CS__STRUCTURAL_FEATURES;

	/**
	 * The number of structural features of the '<em>Lib Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASSIFIER_CS_FEATURE_COUNT = BaseCSTPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibBoundClassCSImpl <em>Lib Bound Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibBoundClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibBoundClassCS()
	 * @generated
	 */
	int LIB_BOUND_CLASS_CS = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__ANNOTATIONS = LIB_CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__ORIGINAL_OBJECT = LIB_CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__ORIGINAL_XMI_ID = LIB_CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__NAME = LIB_CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__TYPE_PARAMETERS = LIB_CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__OWNER = LIB_CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__SUPER_TYPES = LIB_CLASSIFIER_CS__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__OPERATIONS = LIB_CLASSIFIER_CS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__STRUCTURAL_FEATURES = LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__BINDINGS = LIB_CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS__BINDS = LIB_CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lib Bound Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_BOUND_CLASS_CS_FEATURE_COUNT = LIB_CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibClassCS()
	 * @generated
	 */
	int LIB_CLASS_CS = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__ANNOTATIONS = LIB_CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__ORIGINAL_OBJECT = LIB_CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__ORIGINAL_XMI_ID = LIB_CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__NAME = LIB_CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__TYPE_PARAMETERS = LIB_CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNER = LIB_CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__SUPER_TYPES = LIB_CLASSIFIER_CS__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OPERATIONS = LIB_CLASSIFIER_CS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__STRUCTURAL_FEATURES = LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__CLASS = LIB_CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conforms To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__CONFORMS_TO = LIB_CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lib Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS_FEATURE_COUNT = LIB_CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibDocumentCSImpl <em>Lib Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibDocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibDocumentCS()
	 * @generated
	 */
	int LIB_DOCUMENT_CS = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__ANNOTATIONS = BaseCSTPackage.DOCUMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__ORIGINAL_OBJECT = BaseCSTPackage.DOCUMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.DOCUMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__NAME = BaseCSTPackage.DOCUMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__IMPORTS = BaseCSTPackage.DOCUMENT_CS__IMPORTS;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__LIBRARIES = BaseCSTPackage.DOCUMENT_CS__LIBRARIES;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS__PACKAGES = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_DOCUMENT_CS_FEATURE_COUNT = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibIterationCS()
	 * @generated
	 */
	int LIB_ITERATION_CS = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__ANNOTATIONS = BaseCSTPackage.OPERATION_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__ORIGINAL_OBJECT = BaseCSTPackage.OPERATION_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__NAME = BaseCSTPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__LOWER = BaseCSTPackage.OPERATION_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__MULTIPLICITY = BaseCSTPackage.OPERATION_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__QUALIFIERS = BaseCSTPackage.OPERATION_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__TYPE = BaseCSTPackage.OPERATION_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__UPPER = BaseCSTPackage.OPERATION_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__IS_STATIC = BaseCSTPackage.OPERATION_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__IS_DEFINITION = BaseCSTPackage.OPERATION_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__PARAMETERS = BaseCSTPackage.OPERATION_CS__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__TYPE_PARAMETERS = BaseCSTPackage.OPERATION_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNER = BaseCSTPackage.OPERATION_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__CLASS = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Iteration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS_FEATURE_COUNT = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibOperationCS()
	 * @generated
	 */
	int LIB_OPERATION_CS = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__ANNOTATIONS = BaseCSTPackage.OPERATION_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__ORIGINAL_OBJECT = BaseCSTPackage.OPERATION_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__NAME = BaseCSTPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__LOWER = BaseCSTPackage.OPERATION_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__MULTIPLICITY = BaseCSTPackage.OPERATION_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__QUALIFIERS = BaseCSTPackage.OPERATION_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__TYPE = BaseCSTPackage.OPERATION_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__UPPER = BaseCSTPackage.OPERATION_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__IS_STATIC = BaseCSTPackage.OPERATION_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__IS_DEFINITION = BaseCSTPackage.OPERATION_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__PARAMETERS = BaseCSTPackage.OPERATION_CS__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__TYPE_PARAMETERS = BaseCSTPackage.OPERATION_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNER = BaseCSTPackage.OPERATION_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__CLASS = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS_FEATURE_COUNT = BaseCSTPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPackageCSImpl <em>Lib Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibPackageCS()
	 * @generated
	 */
	int LIB_PACKAGE_CS = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__ANNOTATIONS = BaseCSTPackage.PACKAGE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__ORIGINAL_OBJECT = BaseCSTPackage.PACKAGE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__NAME = BaseCSTPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__CLASSIFIERS = BaseCSTPackage.PACKAGE_CS__CLASSIFIERS;

	/**
	 * The feature id for the '<em><b>Subpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__SUBPACKAGES = BaseCSTPackage.PACKAGE_CS__SUBPACKAGES;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__PREFIX = BaseCSTPackage.PACKAGE_CS__PREFIX;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__URI = BaseCSTPackage.PACKAGE_CS__URI;

	/**
	 * The number of structural features of the '<em>Lib Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS_FEATURE_COUNT = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibPropertyCS()
	 * @generated
	 */
	int LIB_PROPERTY_CS = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__ANNOTATIONS = BaseCSTPackage.ATTRIBUTE_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__ORIGINAL_OBJECT = BaseCSTPackage.ATTRIBUTE_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__ORIGINAL_XMI_ID = BaseCSTPackage.ATTRIBUTE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__NAME = BaseCSTPackage.ATTRIBUTE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__LOWER = BaseCSTPackage.ATTRIBUTE_CS__LOWER;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__MULTIPLICITY = BaseCSTPackage.ATTRIBUTE_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__QUALIFIERS = BaseCSTPackage.ATTRIBUTE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__TYPE = BaseCSTPackage.ATTRIBUTE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__UPPER = BaseCSTPackage.ATTRIBUTE_CS__UPPER;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__IS_STATIC = BaseCSTPackage.ATTRIBUTE_CS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__IS_DEFINITION = BaseCSTPackage.ATTRIBUTE_CS__IS_DEFINITION;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNER = BaseCSTPackage.ATTRIBUTE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__CLASS = BaseCSTPackage.ATTRIBUTE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS_FEATURE_COUNT = BaseCSTPackage.ATTRIBUTE_CS_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibBoundClassCS <em>Lib Bound Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Bound Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibBoundClassCS
	 * @generated
	 */
	EClass getLibBoundClassCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS <em>Lib Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS
	 * @generated
	 */
	EClass getLibClassCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getClass_()
	 * @see #getLibClassCS()
	 * @generated
	 */
	EAttribute getLibClassCS_Class();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getConformsTo <em>Conforms To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conforms To</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getConformsTo()
	 * @see #getLibClassCS()
	 * @generated
	 */
	EReference getLibClassCS_ConformsTo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassifierCS <em>Lib Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Classifier CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassifierCS
	 * @generated
	 */
	EClass getLibClassifierCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS <em>Lib Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS
	 * @generated
	 */
	EClass getLibDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS#getPackages()
	 * @see #getLibDocumentCS()
	 * @generated
	 */
	EReference getLibDocumentCS_Packages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS <em>Lib Iteration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Iteration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS
	 * @generated
	 */
	EClass getLibIterationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getClass_()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EAttribute getLibIterationCS_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS <em>Lib Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS
	 * @generated
	 */
	EClass getLibOperationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS#getClass_()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS <em>Lib Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS
	 * @generated
	 */
	EClass getLibPackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS <em>Lib Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Property CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS
	 * @generated
	 */
	EClass getLibPropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS#getClass_()
	 * @see #getLibPropertyCS()
	 * @generated
	 */
	EAttribute getLibPropertyCS_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLstdlibCSTFactory getOCLstdlibCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibBoundClassCSImpl <em>Lib Bound Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibBoundClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibBoundClassCS()
		 * @generated
		 */
		EClass LIB_BOUND_CLASS_CS = eINSTANCE.getLibBoundClassCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibClassCS()
		 * @generated
		 */
		EClass LIB_CLASS_CS = eINSTANCE.getLibClassCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_CLASS_CS__CLASS = eINSTANCE.getLibClassCS_Class();

		/**
		 * The meta object literal for the '<em><b>Conforms To</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_CLASS_CS__CONFORMS_TO = eINSTANCE.getLibClassCS_ConformsTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl <em>Lib Classifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibClassifierCS()
		 * @generated
		 */
		EClass LIB_CLASSIFIER_CS = eINSTANCE.getLibClassifierCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibDocumentCSImpl <em>Lib Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibDocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibDocumentCS()
		 * @generated
		 */
		EClass LIB_DOCUMENT_CS = eINSTANCE.getLibDocumentCS();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_DOCUMENT_CS__PACKAGES = eINSTANCE.getLibDocumentCS_Packages();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibIterationCS()
		 * @generated
		 */
		EClass LIB_ITERATION_CS = eINSTANCE.getLibIterationCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_ITERATION_CS__CLASS = eINSTANCE.getLibIterationCS_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibOperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibOperationCS()
		 * @generated
		 */
		EClass LIB_OPERATION_CS = eINSTANCE.getLibOperationCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__CLASS = eINSTANCE.getLibOperationCS_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPackageCSImpl <em>Lib Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibPackageCS()
		 * @generated
		 */
		EClass LIB_PACKAGE_CS = eINSTANCE.getLibPackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibPropertyCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTPackageImpl#getLibPropertyCS()
		 * @generated
		 */
		EClass LIB_PROPERTY_CS = eINSTANCE.getLibPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_PROPERTY_CS__CLASS = eINSTANCE.getLibPropertyCS_Class();

	}

} //OCLstdlibCSTPackage
