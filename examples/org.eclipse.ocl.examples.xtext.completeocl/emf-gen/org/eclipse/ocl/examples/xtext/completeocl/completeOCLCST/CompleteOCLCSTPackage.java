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
 * $Id: CompleteOCLCSTPackage.java,v 1.1 2010/04/13 06:38:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DocumentCSImpl <em>Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getDocumentCS()
	 * @generated
	 */
	int DOCUMENT_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ImportCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 7;

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
	int CONTEXT_DECL_CS = 3;

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
	int CONSTRAINT_CS = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = 1;

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
	int DER_CS = 5;

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
	 * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
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
	int DEF_CS = 4;

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
	 * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Context Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__CONTEXT_NAME = 0;

	/**
	 * The number of structural features of the '<em>Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Context Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__CONTEXT_NAME = CONTEXT_DECL_CS__CONTEXT_NAME;

	/**
	 * The feature id for the '<em><b>Self Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__INVS = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Defs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__DEFS = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Classifier Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Constrained Name</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__IMPORTS = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__PACKAGES = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS__CONTEXTS = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_CS_FEATURE_COUNT = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__IMPORTED_NAMESPACE = 0;

	/**
	 * The number of structural features of the '<em>Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
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
	int OCL_MESSAGE_ARG_CS__TYPE = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ocl Message Arg CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS_FEATURE_COUNT = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

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
	int OCL_MESSAGE_CS__SOURCE = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__OP = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__MESSAGE_NAME = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS__ARGUMENTS = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ocl Message CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_CS_FEATURE_COUNT = EssentialOCLCSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Context Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__CONTEXT_NAME = CONTEXT_DECL_CS__CONTEXT_NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PARAMETERS = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__TYPE = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pres</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PRES = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Posts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__POSTS = CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__BODIES = CONTEXT_DECL_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Operation Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__CONTEXTS = 1;

	/**
	 * The number of structural features of the '<em>Package Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_CS__EXPRESSION = NAMED_CONSTRAINT_CS__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
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
	 * The feature id for the '<em><b>Context Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__CONTEXT_NAME = CONTEXT_DECL_CS__CONTEXT_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__TYPE = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__INIT = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Der</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__DER = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS <em>Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS
	 * @generated
	 */
	EClass getDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS#getImports()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS#getPackages()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS#getContexts()
	 * @see #getDocumentCS()
	 * @generated
	 */
	EReference getDocumentCS_Contexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS
	 * @generated
	 */
	EClass getImportCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS#getImportedNamespace()
	 * @see #getImportCS()
	 * @generated
	 */
	EAttribute getImportCS_ImportedNamespace();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getName()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_Name();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS#getContextName <em>Context Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS#getContextName()
	 * @see #getContextDeclCS()
	 * @generated
	 */
	EReference getContextDeclCS_ContextName();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS#getType()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_Type();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Self Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS#getSelfName()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_SelfName();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getConstrainedName <em>Constrained Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constrained Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS#getConstrainedName()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_ConstrainedName();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS#getType()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Type();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS#getConstraintName <em>Constraint Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS#getConstraintName()
	 * @see #getNamedConstraintCS()
	 * @generated
	 */
	EReference getNamedConstraintCS_ConstraintName();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getSource()
	 * @see #getOclMessageCS()
	 * @generated
	 */
	EReference getOclMessageCS_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getOp()
	 * @see #getOclMessageCS()
	 * @generated
	 */
	EAttribute getOclMessageCS_Op();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getMessageName <em>Message Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS#getMessageName()
	 * @see #getOclMessageCS()
	 * @generated
	 */
	EReference getOclMessageCS_MessageName();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DocumentCSImpl <em>Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.DocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getDocumentCS()
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
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_CS__CONTEXTS = eINSTANCE.getDocumentCS_Contexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ImportCSImpl <em>Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ImportCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.CompleteOCLCSTPackageImpl#getImportCS()
		 * @generated
		 */
		EClass IMPORT_CS = eINSTANCE.getImportCS();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_CS__IMPORTED_NAMESPACE = eINSTANCE.getImportCS_ImportedNamespace();

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
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__NAME = eINSTANCE.getPackageDeclarationCS_Name();

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
		 * The meta object literal for the '<em><b>Context Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_DECL_CS__CONTEXT_NAME = eINSTANCE.getContextDeclCS_ContextName();

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
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__TYPE = eINSTANCE.getPropertyContextDeclCS_Type();

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
		 * The meta object literal for the '<em><b>Self Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = eINSTANCE.getClassifierContextDeclCS_SelfName();

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
		 * The meta object literal for the '<em><b>Constrained Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__CONSTRAINED_NAME = eINSTANCE.getDefCS_ConstrainedName();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__PARAMETERS = eINSTANCE.getOperationContextDeclCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__TYPE = eINSTANCE.getOperationContextDeclCS_Type();

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
		 * The meta object literal for the '<em><b>Constraint Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_CONSTRAINT_CS__CONSTRAINT_NAME = eINSTANCE.getNamedConstraintCS_ConstraintName();

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
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_CS__SOURCE = eINSTANCE.getOclMessageCS_Source();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_MESSAGE_CS__OP = eINSTANCE.getOclMessageCS_Op();

		/**
		 * The meta object literal for the '<em><b>Message Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_CS__MESSAGE_NAME = eINSTANCE.getOclMessageCS_MessageName();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_CS__ARGUMENTS = eINSTANCE.getOclMessageCS_Arguments();

	}

} //CompleteOCLCSTPackage
