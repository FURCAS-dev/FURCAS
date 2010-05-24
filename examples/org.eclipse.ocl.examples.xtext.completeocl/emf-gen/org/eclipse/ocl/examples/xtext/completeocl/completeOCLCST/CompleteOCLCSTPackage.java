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
 * $Id: CompleteOCLCSTPackage.java,v 1.6 2010/05/24 08:58:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

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
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTFactory
 * @model kind="package"
 * @generated
 */
public interface CompleteOCLCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "completeOCLCST";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.0.0/CompleteOCLCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "completeOCLCST";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteOCLCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PackageDeclarationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPackageDeclarationCS()
	 * @generated
	 */
	int PACKAGE_DECLARATION_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getContextDeclCS()
	 * @generated
	 */
	int CONTEXT_DECL_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl <em>Property Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPropertyContextDeclCS()
	 * @generated
	 */
	int PROPERTY_CONTEXT_DECL_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__EXPRESSION = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InitCSImpl <em>Init CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InitCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getInitCS()
	 * @generated
	 */
	int INIT_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DerCSImpl <em>Der CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DerCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getDerCS()
	 * @generated
	 */
	int DER_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getClassifierContextDeclCS()
	 * @generated
	 */
	int CLASSIFIER_CONTEXT_DECL_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.NamedConstraintCSImpl <em>Named Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.NamedConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getNamedConstraintCS()
	 * @generated
	 */
	int NAMED_CONSTRAINT_CS = 10;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CONSTRAINT_CS__EXPRESSION = CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CONSTRAINT_CS__CONSTRAINT_NAME = CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_CONSTRAINT_CS_FEATURE_COUNT = CONSTRAINT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InvCSImpl <em>Inv CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InvCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getInvCS()
	 * @generated
	 */
	int INV_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DefCSImpl <em>Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getDefCS()
	 * @generated
	 */
	int DEF_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OperationContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getOperationContextDeclCS()
	 * @generated
	 */
	int OPERATION_CONTEXT_DECL_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PreCSImpl <em>Pre CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PreCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPreCS()
	 * @generated
	 */
	int PRE_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PostCSImpl <em>Post CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PostCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPostCS()
	 * @generated
	 */
	int POST_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.BodyCSImpl <em>Body CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.BodyCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getBodyCS()
	 * @generated
	 */
	int BODY_CS = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_CS__CONSTRAINT_NAME = NAMED_CONSTRAINT_CS__CONSTRAINT_NAME;

	/**
	 * The number of structural features of the '<em>Body CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_CS_FEATURE_COUNT = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Self Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__INVS = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Defs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__DEFS = CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classifier Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLDocumentCSImpl <em>Complete OCL Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLDocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getCompleteOCLDocumentCS()
	 * @generated
	 */
	int COMPLETE_OCL_DOCUMENT_CS = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__ANNOTATIONS = BaseCSTPackage.DOCUMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__ORIGINAL_OBJECT = BaseCSTPackage.DOCUMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.DOCUMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__NAME = BaseCSTPackage.DOCUMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__IMPORTS = BaseCSTPackage.DOCUMENT_CS__IMPORTS;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__LIBRARIES = BaseCSTPackage.DOCUMENT_CS__LIBRARIES;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__PACKAGES = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__CONTEXTS = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complete OCL Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS_FEATURE_COUNT = BaseCSTPackage.DOCUMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__CONSTRAINT_NAME = NAMED_CONSTRAINT_CS__CONSTRAINT_NAME;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__STATIC = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constrained Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__CONSTRAINED_NAME = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__PARAMETERS = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__TYPE = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS_FEATURE_COUNT = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DER_CS__EXPRESSION = CONSTRAINT_CS__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Der CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DER_CS_FEATURE_COUNT = CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.FeatureContextDeclCSImpl <em>Feature Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.FeatureContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getFeatureContextDeclCS()
	 * @generated
	 */
	int FEATURE_CONTEXT_DECL_CS = 7;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__CLASS = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__TYPE = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_CS__EXPRESSION = CONSTRAINT_CS__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Init CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_CS_FEATURE_COUNT = CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INV_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INV_CS__CONSTRAINT_NAME = NAMED_CONSTRAINT_CS__CONSTRAINT_NAME;

	/**
	 * The number of structural features of the '<em>Inv CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INV_CS_FEATURE_COUNT = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageArgCSImpl <em>Ocl Message Arg CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageArgCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getOclMessageArgCS()
	 * @generated
	 */
	int OCL_MESSAGE_ARG_CS = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__TYPE = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ocl Message Arg CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl <em>Ocl Message CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getOclMessageCS()
	 * @generated
	 */
	int OCL_MESSAGE_CS = 12;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__SOURCE = EssentialOCLCSTPackage.OPERATOR_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__OP = EssentialOCLCSTPackage.OPERATOR_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Message Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__MESSAGE_NAME = EssentialOCLCSTPackage.OPERATOR_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__ARGUMENTS = EssentialOCLCSTPackage.OPERATOR_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ocl Message CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS_FEATURE_COUNT = EssentialOCLCSTPackage.OPERATOR_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__CLASS = FEATURE_CONTEXT_DECL_CS__CLASS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__TYPE = FEATURE_CONTEXT_DECL_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__OPERATION = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PARAMETERS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__RESULT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pres</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PRES = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Posts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__POSTS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__BODIES = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Operation Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS_FEATURE_COUNT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__PACKAGE = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__CONTEXTS = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CS__CONSTRAINT_NAME = NAMED_CONSTRAINT_CS__CONSTRAINT_NAME;

	/**
	 * The number of structural features of the '<em>Post CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CS_FEATURE_COUNT = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_CS__CONSTRAINT_NAME = NAMED_CONSTRAINT_CS__CONSTRAINT_NAME;

	/**
	 * The number of structural features of the '<em>Pre CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_CS_FEATURE_COUNT = NAMED_CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__CLASS = FEATURE_CONTEXT_DECL_CS__CLASS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__TYPE = FEATURE_CONTEXT_DECL_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__PROPERTY = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__INIT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Der</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__DER = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS_FEATURE_COUNT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS <em>Feature Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS
	 * @generated
	 */
	EClass getFeatureContextDeclCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS#getClass_()
	 * @see #getFeatureContextDeclCS()
	 * @generated
	 */
	EReference getFeatureContextDeclCS_Class();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS#getType()
	 * @see #getFeatureContextDeclCS()
	 * @generated
	 */
	EReference getFeatureContextDeclCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS <em>Package Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Declaration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS
	 * @generated
	 */
	EClass getPackageDeclarationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getPackage()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getContexts()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_Contexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS <em>Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS
	 * @generated
	 */
	EClass getContextDeclCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS <em>Property Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS
	 * @generated
	 */
	EClass getPropertyContextDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getProperty()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_Property();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getInit()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_Init();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getDer <em>Der</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Der</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getDer()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_Der();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS <em>Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Init CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS
	 * @generated
	 */
	EClass getInitCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS <em>Der CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Der CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS
	 * @generated
	 */
	EClass getDerCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS
	 * @generated
	 */
	EClass getClassifierContextDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Classifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getClassifier()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_Classifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getSelfName()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EAttribute getClassifierContextDeclCS_SelfName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getInvs <em>Invs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invs</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getInvs()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_Invs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getDefs <em>Defs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defs</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getDefs()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_Defs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS <em>Complete OCL Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete OCL Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS
	 * @generated
	 */
	EClass getCompleteOCLDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS#getPackages()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS#getContexts()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_Contexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS <em>Inv CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inv CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS
	 * @generated
	 */
	EClass getInvCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS <em>Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS
	 * @generated
	 */
	EClass getDefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#isStatic()
	 * @see #getDefCS()
	 * @generated
	 */
	EAttribute getDefCS_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getConstrainedName <em>Constrained Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constrained Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getConstrainedName()
	 * @see #getDefCS()
	 * @generated
	 */
	EAttribute getDefCS_ConstrainedName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getParameters()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getType()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS
	 * @generated
	 */
	EClass getOperationContextDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getOperation()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getParameters()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getResult()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Result();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getPres <em>Pres</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pres</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getPres()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Pres();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getPosts <em>Posts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Posts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getPosts()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Posts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getBodies <em>Bodies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bodies</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getBodies()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Bodies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS <em>Pre CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS
	 * @generated
	 */
	EClass getPreCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS <em>Post CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS
	 * @generated
	 */
	EClass getPostCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS <em>Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS
	 * @generated
	 */
	EClass getBodyCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS
	 * @generated
	 */
	EClass getConstraintCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS#getExpression()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS <em>Named Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS
	 * @generated
	 */
	EClass getNamedConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS#getConstraintName <em>Constraint Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS#getConstraintName()
	 * @see #getNamedConstraintCS()
	 * @generated
	 */
	EAttribute getNamedConstraintCS_ConstraintName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS <em>Ocl Message Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Message Arg CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS
	 * @generated
	 */
	EClass getOclMessageArgCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS#getType()
	 * @see #getOclMessageArgCS()
	 * @generated
	 */
	EReference getOclMessageArgCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS <em>Ocl Message CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Message CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS
	 * @generated
	 */
	EClass getOclMessageCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getMessageName <em>Message Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getMessageName()
	 * @see #getOclMessageCS()
	 * @generated
	 */
	EAttribute getOclMessageCS_MessageName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getArguments()
	 * @see #getOclMessageCS()
	 * @generated
	 */
	EReference getOclMessageCS_Arguments();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompleteOCLCSTFactory getCompleteOCLCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.FeatureContextDeclCSImpl <em>Feature Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.FeatureContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getFeatureContextDeclCS()
		 * @generated
		 */
		EClass FEATURE_CONTEXT_DECL_CS = eINSTANCE.getFeatureContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONTEXT_DECL_CS__CLASS = eINSTANCE.getFeatureContextDeclCS_Class();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONTEXT_DECL_CS__TYPE = eINSTANCE.getFeatureContextDeclCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PackageDeclarationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPackageDeclarationCS()
		 * @generated
		 */
		EClass PACKAGE_DECLARATION_CS = eINSTANCE.getPackageDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__PACKAGE = eINSTANCE.getPackageDeclarationCS_Package();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__CONTEXTS = eINSTANCE.getPackageDeclarationCS_Contexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getContextDeclCS()
		 * @generated
		 */
		EClass CONTEXT_DECL_CS = eINSTANCE.getContextDeclCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl <em>Property Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPropertyContextDeclCS()
		 * @generated
		 */
		EClass PROPERTY_CONTEXT_DECL_CS = eINSTANCE.getPropertyContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__PROPERTY = eINSTANCE.getPropertyContextDeclCS_Property();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__INIT = eINSTANCE.getPropertyContextDeclCS_Init();

		/**
		 * The meta object literal for the '<em><b>Der</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__DER = eINSTANCE.getPropertyContextDeclCS_Der();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InitCSImpl <em>Init CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InitCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getInitCS()
		 * @generated
		 */
		EClass INIT_CS = eINSTANCE.getInitCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DerCSImpl <em>Der CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DerCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getDerCS()
		 * @generated
		 */
		EClass DER_CS = eINSTANCE.getDerCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getClassifierContextDeclCS()
		 * @generated
		 */
		EClass CLASSIFIER_CONTEXT_DECL_CS = eINSTANCE.getClassifierContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER = eINSTANCE.getClassifierContextDeclCS_Classifier();

		/**
		 * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = eINSTANCE.getClassifierContextDeclCS_SelfName();

		/**
		 * The meta object literal for the '<em><b>Invs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__INVS = eINSTANCE.getClassifierContextDeclCS_Invs();

		/**
		 * The meta object literal for the '<em><b>Defs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__DEFS = eINSTANCE.getClassifierContextDeclCS_Defs();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLDocumentCSImpl <em>Complete OCL Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLDocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getCompleteOCLDocumentCS()
		 * @generated
		 */
		EClass COMPLETE_OCL_DOCUMENT_CS = eINSTANCE.getCompleteOCLDocumentCS();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__PACKAGES = eINSTANCE.getCompleteOCLDocumentCS_Packages();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__CONTEXTS = eINSTANCE.getCompleteOCLDocumentCS_Contexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InvCSImpl <em>Inv CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.InvCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getInvCS()
		 * @generated
		 */
		EClass INV_CS = eINSTANCE.getInvCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DefCSImpl <em>Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getDefCS()
		 * @generated
		 */
		EClass DEF_CS = eINSTANCE.getDefCS();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEF_CS__STATIC = eINSTANCE.getDefCS_Static();

		/**
		 * The meta object literal for the '<em><b>Constrained Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEF_CS__CONSTRAINED_NAME = eINSTANCE.getDefCS_ConstrainedName();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__PARAMETERS = eINSTANCE.getDefCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__TYPE = eINSTANCE.getDefCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OperationContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getOperationContextDeclCS()
		 * @generated
		 */
		EClass OPERATION_CONTEXT_DECL_CS = eINSTANCE.getOperationContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OPERATION = eINSTANCE.getOperationContextDeclCS_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__PARAMETERS = eINSTANCE.getOperationContextDeclCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__RESULT = eINSTANCE.getOperationContextDeclCS_Result();

		/**
		 * The meta object literal for the '<em><b>Pres</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__PRES = eINSTANCE.getOperationContextDeclCS_Pres();

		/**
		 * The meta object literal for the '<em><b>Posts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__POSTS = eINSTANCE.getOperationContextDeclCS_Posts();

		/**
		 * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__BODIES = eINSTANCE.getOperationContextDeclCS_Bodies();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PreCSImpl <em>Pre CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PreCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPreCS()
		 * @generated
		 */
		EClass PRE_CS = eINSTANCE.getPreCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PostCSImpl <em>Post CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PostCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getPostCS()
		 * @generated
		 */
		EClass POST_CS = eINSTANCE.getPostCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.BodyCSImpl <em>Body CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.BodyCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getBodyCS()
		 * @generated
		 */
		EClass BODY_CS = eINSTANCE.getBodyCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getConstraintCS()
		 * @generated
		 */
		EClass CONSTRAINT_CS = eINSTANCE.getConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__EXPRESSION = eINSTANCE.getConstraintCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.NamedConstraintCSImpl <em>Named Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.NamedConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getNamedConstraintCS()
		 * @generated
		 */
		EClass NAMED_CONSTRAINT_CS = eINSTANCE.getNamedConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_CONSTRAINT_CS__CONSTRAINT_NAME = eINSTANCE.getNamedConstraintCS_ConstraintName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageArgCSImpl <em>Ocl Message Arg CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageArgCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getOclMessageArgCS()
		 * @generated
		 */
		EClass OCL_MESSAGE_ARG_CS = eINSTANCE.getOclMessageArgCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_ARG_CS__TYPE = eINSTANCE.getOclMessageArgCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl <em>Ocl Message CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getOclMessageCS()
		 * @generated
		 */
		EClass OCL_MESSAGE_CS = eINSTANCE.getOclMessageCS();

		/**
		 * The meta object literal for the '<em><b>Message Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_MESSAGE_CS__MESSAGE_NAME = eINSTANCE.getOclMessageCS_MessageName();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_CS__ARGUMENTS = eINSTANCE.getOclMessageCS_Arguments();

	}

} //CompleteOCLCSTPackage
