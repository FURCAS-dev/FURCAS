/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CSTPackage.java,v 1.2 2007/12/03 18:44:41 cdamus Exp $
 */
package org.eclipse.ocl.cst;

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
 * @see org.eclipse.ocl.cst.CSTFactory
 * @model kind="package"
 * @generated
 */
public interface CSTPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "cst"; //$NON-NLS-1$

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.eclipse.org/ocl/1.1.0/OCL/CST"; //$NON-NLS-1$

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ocl.cst"; //$NON-NLS-1$

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	CSTPackage eINSTANCE = org.eclipse.ocl.cst.impl.CSTPackageImpl.init();

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.CSTNodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.CSTNodeImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCSTNode()
     * @generated
     */
	int CST_NODE = 0;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CST_NODE__START_OFFSET = 0;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CST_NODE__END_OFFSET = 1;

	/**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CST_NODE_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPackageDeclarationCS()
     * @generated
     */
	int PACKAGE_DECLARATION_CS = 1;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_DECLARATION_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_DECLARATION_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_DECLARATION_CS__PATH_NAME_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Context Decls</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_DECLARATION_CS__CONTEXT_DECLS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Package Declaration CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Package Declaration CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_DECLARATION_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.OCLExpressionCSImpl <em>OCL Expression CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.OCLExpressionCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOCLExpressionCS()
     * @generated
     */
	int OCL_EXPRESSION_CS = 4;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The number of structural features of the '<em>OCL Expression CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_EXPRESSION_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.TypeCSImpl <em>Type CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.TypeCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getTypeCS()
     * @generated
     */
	int TYPE_CS = 3;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The number of structural features of the '<em>Type CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.PathNameCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPathNameCS()
     * @generated
     */
	int PATH_NAME_CS = 2;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PATH_NAME_CS__START_OFFSET = TYPE_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PATH_NAME_CS__END_OFFSET = TYPE_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Sequence Of Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PATH_NAME_CS__SEQUENCE_OF_NAMES = TYPE_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Path Name CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PATH_NAME_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.ContextDeclCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getContextDeclCS()
     * @generated
     */
	int CONTEXT_DECL_CS = 5;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_DECL_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_DECL_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The number of structural features of the '<em>Context Decl CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_DECL_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.PropertyContextCSImpl <em>Property Context CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.PropertyContextCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPropertyContextCS()
     * @generated
     */
	int PROPERTY_CONTEXT_CS = 6;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS__START_OFFSET = CONTEXT_DECL_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS__END_OFFSET = CONTEXT_DECL_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS__PATH_NAME_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS__TYPE_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Init Or Der Value CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Property Context CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROPERTY_CONTEXT_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.SimpleNameCSImpl <em>Simple Name CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.SimpleNameCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getSimpleNameCS()
     * @generated
     */
	int SIMPLE_NAME_CS = 7;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_NAME_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_NAME_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_NAME_CS__VALUE = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_NAME_CS__TYPE = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Simple Name CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_NAME_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.InitOrDerValueCSImpl <em>Init Or Der Value CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.InitOrDerValueCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInitOrDerValueCS()
     * @generated
     */
	int INIT_OR_DER_VALUE_CS = 8;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_OR_DER_VALUE_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_OR_DER_VALUE_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Init Or Der Value CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_OR_DER_VALUE_CS__EXPRESSION_CS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Init Or Der Value CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_OR_DER_VALUE_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.ClassifierContextDeclCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getClassifierContextDeclCS()
     * @generated
     */
	int CLASSIFIER_CONTEXT_DECL_CS = 9;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASSIFIER_CONTEXT_DECL_CS__START_OFFSET = CONTEXT_DECL_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASSIFIER_CONTEXT_DECL_CS__END_OFFSET = CONTEXT_DECL_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Inv Or Def CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Classifier Context Decl CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASSIFIER_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.InvOrDefCSImpl <em>Inv Or Def CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.InvOrDefCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInvOrDefCS()
     * @generated
     */
	int INV_OR_DEF_CS = 10;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_OR_DEF_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_OR_DEF_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_OR_DEF_CS__SIMPLE_NAME_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Inv Or Def CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_OR_DEF_CS__INV_OR_DEF_CS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Inv Or Def CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_OR_DEF_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.OperationContextDeclCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOperationContextDeclCS()
     * @generated
     */
	int OPERATION_CONTEXT_DECL_CS = 11;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CONTEXT_DECL_CS__START_OFFSET = CONTEXT_DECL_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CONTEXT_DECL_CS__END_OFFSET = CONTEXT_DECL_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Operation CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CONTEXT_DECL_CS__OPERATION_CS = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Pre Post Or Body Decls</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Operation Context Decl CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.OperationCSImpl <em>Operation CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.OperationCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOperationCS()
     * @generated
     */
	int OPERATION_CS = 12;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS__PATH_NAME_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS__SIMPLE_NAME_CS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS__PARAMETERS = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS__TYPE_CS = CST_NODE_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Operation CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.VariableCSImpl <em>Variable CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.VariableCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getVariableCS()
     * @generated
     */
	int VARIABLE_CS = 13;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_CS__NAME = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_CS__TYPE_CS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_CS__INIT_EXPRESSION = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Variable CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl <em>Pre Post Or Body Decl CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrePostOrBodyDeclCS()
     * @generated
     */
	int PRE_POST_OR_BODY_DECL_CS = 14;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRE_POST_OR_BODY_DECL_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRE_POST_OR_BODY_DECL_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRE_POST_OR_BODY_DECL_CS__KIND = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Pre Post Or Body Decl CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRE_POST_OR_BODY_DECL_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.DerValueCSImpl <em>Der Value CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.DerValueCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDerValueCS()
     * @generated
     */
	int DER_VALUE_CS = 15;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DER_VALUE_CS__START_OFFSET = INIT_OR_DER_VALUE_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DER_VALUE_CS__END_OFFSET = INIT_OR_DER_VALUE_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Init Or Der Value CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DER_VALUE_CS__INIT_OR_DER_VALUE_CS = INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DER_VALUE_CS__EXPRESSION_CS = INIT_OR_DER_VALUE_CS__EXPRESSION_CS;

	/**
     * The number of structural features of the '<em>Der Value CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DER_VALUE_CS_FEATURE_COUNT = INIT_OR_DER_VALUE_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.InitValueCSImpl <em>Init Value CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.InitValueCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInitValueCS()
     * @generated
     */
	int INIT_VALUE_CS = 16;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_VALUE_CS__START_OFFSET = INIT_OR_DER_VALUE_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_VALUE_CS__END_OFFSET = INIT_OR_DER_VALUE_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Init Or Der Value CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_VALUE_CS__INIT_OR_DER_VALUE_CS = INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_VALUE_CS__EXPRESSION_CS = INIT_OR_DER_VALUE_CS__EXPRESSION_CS;

	/**
     * The number of structural features of the '<em>Init Value CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INIT_VALUE_CS_FEATURE_COUNT = INIT_OR_DER_VALUE_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.InvCSImpl <em>Inv CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.InvCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInvCS()
     * @generated
     */
	int INV_CS = 17;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_CS__START_OFFSET = INV_OR_DEF_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_CS__END_OFFSET = INV_OR_DEF_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_CS__SIMPLE_NAME_CS = INV_OR_DEF_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Inv Or Def CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_CS__INV_OR_DEF_CS = INV_OR_DEF_CS__INV_OR_DEF_CS;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_CS__EXPRESSION_CS = INV_OR_DEF_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Inv CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INV_CS_FEATURE_COUNT = INV_OR_DEF_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.DefCSImpl <em>Def CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.DefCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDefCS()
     * @generated
     */
	int DEF_CS = 18;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_CS__START_OFFSET = INV_OR_DEF_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_CS__END_OFFSET = INV_OR_DEF_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_CS__SIMPLE_NAME_CS = INV_OR_DEF_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Inv Or Def CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_CS__INV_OR_DEF_CS = INV_OR_DEF_CS__INV_OR_DEF_CS;

	/**
     * The feature id for the '<em><b>Def Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_CS__DEF_EXPRESSION_CS = INV_OR_DEF_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Def CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_CS_FEATURE_COUNT = INV_OR_DEF_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.DefExpressionCSImpl <em>Def Expression CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.DefExpressionCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDefExpressionCS()
     * @generated
     */
	int DEF_EXPRESSION_CS = 19;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_EXPRESSION_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_EXPRESSION_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Operation CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_EXPRESSION_CS__OPERATION_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Variable CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_EXPRESSION_CS__VARIABLE_CS = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_EXPRESSION_CS__EXPRESSION_CS = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Def Expression CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEF_EXPRESSION_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.VariableExpCSImpl <em>Variable Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.VariableExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getVariableExpCS()
     * @generated
     */
	int VARIABLE_EXP_CS = 20;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_CS__ARGUMENTS = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_CS__SIMPLE_NAME_CS = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_CS__IS_MARKED_PRE_CS = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Variable Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.IsMarkedPreCSImpl <em>Is Marked Pre CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.IsMarkedPreCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIsMarkedPreCS()
     * @generated
     */
	int IS_MARKED_PRE_CS = 21;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IS_MARKED_PRE_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IS_MARKED_PRE_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IS_MARKED_PRE_CS__PRE = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Is Marked Pre CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IS_MARKED_PRE_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.PrimitiveTypeCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrimitiveTypeCS()
     * @generated
     */
	int PRIMITIVE_TYPE_CS = 22;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TYPE_CS__START_OFFSET = SIMPLE_NAME_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TYPE_CS__END_OFFSET = SIMPLE_NAME_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TYPE_CS__VALUE = SIMPLE_NAME_CS__VALUE;

	/**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TYPE_CS__TYPE = SIMPLE_NAME_CS__TYPE;

	/**
     * The number of structural features of the '<em>Primitive Type CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TYPE_CS_FEATURE_COUNT = SIMPLE_NAME_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.TupleTypeCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getTupleTypeCS()
     * @generated
     */
	int TUPLE_TYPE_CS = 23;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_CS__START_OFFSET = TYPE_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_CS__END_OFFSET = TYPE_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_CS__VARIABLES = TYPE_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Tuple Type CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.CollectionTypeCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionTypeCS()
     * @generated
     */
	int COLLECTION_TYPE_CS = 24;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE_CS__START_OFFSET = TYPE_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE_CS__END_OFFSET = TYPE_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Collection Type Identifier</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER = TYPE_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE_CS__TYPE_CS = TYPE_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Collection Type CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.LetExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getLetExpCS()
     * @generated
     */
	int LET_EXP_CS = 25;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_CS__VARIABLES = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>In Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_CS__IN_EXPRESSION = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Let Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LET_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.IfExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIfExpCS()
     * @generated
     */
	int IF_EXP_CS = 26;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_CS__THEN_EXPRESSION = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_CS__ELSE_EXPRESSION = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_CS__CONDITION = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>If Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.MessageExpCSImpl <em>Message Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.MessageExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getMessageExpCS()
     * @generated
     */
	int MESSAGE_EXP_CS = 27;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS__TARGET = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS__KIND = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS__SIMPLE_NAME_CS = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS__ARGUMENTS = OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Message Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.OCLMessageArgCSImpl <em>OCL Message Arg CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.OCLMessageArgCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOCLMessageArgCS()
     * @generated
     */
	int OCL_MESSAGE_ARG_CS = 28;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_MESSAGE_ARG_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_MESSAGE_ARG_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_MESSAGE_ARG_CS__TYPE_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_MESSAGE_ARG_CS__EXPRESSION = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>OCL Message Arg CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_MESSAGE_ARG_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.LiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getLiteralExpCS()
     * @generated
     */
	int LITERAL_EXP_CS = 29;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The number of structural features of the '<em>Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.EnumLiteralExpCSImpl <em>Enum Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.EnumLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getEnumLiteralExpCS()
     * @generated
     */
	int ENUM_LITERAL_EXP_CS = 30;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_CS__START_OFFSET = LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_CS__END_OFFSET = LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_CS__PATH_NAME_CS = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Enum Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUM_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.CollectionLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionLiteralExpCS()
     * @generated
     */
	int COLLECTION_LITERAL_EXP_CS = 31;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_CS__START_OFFSET = LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_CS__END_OFFSET = LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Collection Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Collection Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.CollectionLiteralPartCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionLiteralPartCS()
     * @generated
     */
	int COLLECTION_LITERAL_PART_CS = 32;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART_CS__START_OFFSET = CST_NODE__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART_CS__END_OFFSET = CST_NODE__END_OFFSET;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = CST_NODE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Collection Literal Part CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_LITERAL_PART_CS_FEATURE_COUNT = CST_NODE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.TupleLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getTupleLiteralExpCS()
     * @generated
     */
	int TUPLE_LITERAL_EXP_CS = 33;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP_CS__START_OFFSET = LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP_CS__END_OFFSET = LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP_CS__VARIABLES = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Tuple Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.PrimitiveLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrimitiveLiteralExpCS()
     * @generated
     */
	int PRIMITIVE_LITERAL_EXP_CS = 34;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP_CS__START_OFFSET = LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP_CS__END_OFFSET = LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP_CS__SYMBOL = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Primitive Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.IntegerLiteralExpCSImpl <em>Integer Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.IntegerLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIntegerLiteralExpCS()
     * @generated
     */
	int INTEGER_LITERAL_EXP_CS = 35;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_CS__START_OFFSET = PRIMITIVE_LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_CS__END_OFFSET = PRIMITIVE_LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS__SYMBOL;

	/**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Integer Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGER_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.UnlimitedNaturalLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getUnlimitedNaturalLiteralExpCS()
     * @generated
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS = 36;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__START_OFFSET = PRIMITIVE_LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__END_OFFSET = PRIMITIVE_LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS__SYMBOL;

	/**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__INTEGER_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Unlimited Natural Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.RealLiteralExpCSImpl <em>Real Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.RealLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getRealLiteralExpCS()
     * @generated
     */
	int REAL_LITERAL_EXP_CS = 37;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_CS__START_OFFSET = PRIMITIVE_LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_CS__END_OFFSET = PRIMITIVE_LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS__SYMBOL;

	/**
     * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_CS__REAL_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Real Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.StringLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getStringLiteralExpCS()
     * @generated
     */
	int STRING_LITERAL_EXP_CS = 38;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_CS__START_OFFSET = PRIMITIVE_LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_CS__END_OFFSET = PRIMITIVE_LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS__SYMBOL;

	/**
     * The feature id for the '<em><b>String Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_CS__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>String Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.BooleanLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getBooleanLiteralExpCS()
     * @generated
     */
	int BOOLEAN_LITERAL_EXP_CS = 39;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_CS__START_OFFSET = PRIMITIVE_LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_CS__END_OFFSET = PRIMITIVE_LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS__SYMBOL;

	/**
     * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_CS__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Boolean Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.NullLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getNullLiteralExpCS()
     * @generated
     */
	int NULL_LITERAL_EXP_CS = 40;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP_CS__START_OFFSET = LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP_CS__END_OFFSET = LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP_CS__SYMBOL = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Null Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NULL_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.InvalidLiteralExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInvalidLiteralExpCS()
     * @generated
     */
	int INVALID_LITERAL_EXP_CS = 41;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP_CS__START_OFFSET = LITERAL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP_CS__END_OFFSET = LITERAL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP_CS__SYMBOL = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Invalid Literal Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.CollectionRangeCSImpl <em>Collection Range CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.CollectionRangeCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionRangeCS()
     * @generated
     */
	int COLLECTION_RANGE_CS = 42;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_CS__START_OFFSET = COLLECTION_LITERAL_PART_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_CS__END_OFFSET = COLLECTION_LITERAL_PART_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_CS__EXPRESSION_CS = COLLECTION_LITERAL_PART_CS__EXPRESSION_CS;

	/**
     * The feature id for the '<em><b>Last Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_CS__LAST_EXPRESSION_CS = COLLECTION_LITERAL_PART_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Collection Range CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_RANGE_CS_FEATURE_COUNT = COLLECTION_LITERAL_PART_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.CallExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCallExpCS()
     * @generated
     */
	int CALL_EXP_CS = 43;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_CS__START_OFFSET = OCL_EXPRESSION_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_CS__END_OFFSET = OCL_EXPRESSION_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_CS__SOURCE = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_CS__ACCESSOR = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_CS__SIMPLE_NAME_CS = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Call Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.LoopExpCSImpl <em>Loop Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.LoopExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getLoopExpCS()
     * @generated
     */
	int LOOP_EXP_CS = 44;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__START_OFFSET = CALL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__END_OFFSET = CALL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__SOURCE = CALL_EXP_CS__SOURCE;

	/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__ACCESSOR = CALL_EXP_CS__ACCESSOR;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__SIMPLE_NAME_CS = CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Variable1</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__VARIABLE1 = CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Variable2</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__VARIABLE2 = CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS__BODY = CALL_EXP_CS_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Loop Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOOP_EXP_CS_FEATURE_COUNT = CALL_EXP_CS_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.IteratorExpCSImpl <em>Iterator Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.IteratorExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIteratorExpCS()
     * @generated
     */
	int ITERATOR_EXP_CS = 45;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__START_OFFSET = LOOP_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__END_OFFSET = LOOP_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__SOURCE = LOOP_EXP_CS__SOURCE;

	/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__ACCESSOR = LOOP_EXP_CS__ACCESSOR;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__SIMPLE_NAME_CS = LOOP_EXP_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Variable1</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__VARIABLE1 = LOOP_EXP_CS__VARIABLE1;

	/**
     * The feature id for the '<em><b>Variable2</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__VARIABLE2 = LOOP_EXP_CS__VARIABLE2;

	/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS__BODY = LOOP_EXP_CS__BODY;

	/**
     * The number of structural features of the '<em>Iterator Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_EXP_CS_FEATURE_COUNT = LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.IterateExpCSImpl <em>Iterate Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.IterateExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIterateExpCS()
     * @generated
     */
	int ITERATE_EXP_CS = 46;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__START_OFFSET = LOOP_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__END_OFFSET = LOOP_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__SOURCE = LOOP_EXP_CS__SOURCE;

	/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__ACCESSOR = LOOP_EXP_CS__ACCESSOR;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__SIMPLE_NAME_CS = LOOP_EXP_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Variable1</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__VARIABLE1 = LOOP_EXP_CS__VARIABLE1;

	/**
     * The feature id for the '<em><b>Variable2</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__VARIABLE2 = LOOP_EXP_CS__VARIABLE2;

	/**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS__BODY = LOOP_EXP_CS__BODY;

	/**
     * The number of structural features of the '<em>Iterate Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATE_EXP_CS_FEATURE_COUNT = LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.FeatureCallExpCSImpl <em>Feature Call Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.FeatureCallExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getFeatureCallExpCS()
     * @generated
     */
	int FEATURE_CALL_EXP_CS = 47;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__START_OFFSET = CALL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__END_OFFSET = CALL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__SOURCE = CALL_EXP_CS__SOURCE;

	/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__ACCESSOR = CALL_EXP_CS__ACCESSOR;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__SIMPLE_NAME_CS = CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__ARGUMENTS = CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS = CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Feature Call Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FEATURE_CALL_EXP_CS_FEATURE_COUNT = CALL_EXP_CS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.OperationCallExpCSImpl <em>Operation Call Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.OperationCallExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOperationCallExpCS()
     * @generated
     */
	int OPERATION_CALL_EXP_CS = 48;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__START_OFFSET = FEATURE_CALL_EXP_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__END_OFFSET = FEATURE_CALL_EXP_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__SOURCE = FEATURE_CALL_EXP_CS__SOURCE;

	/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__ACCESSOR = FEATURE_CALL_EXP_CS__ACCESSOR;

	/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS = FEATURE_CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__ARGUMENTS = FEATURE_CALL_EXP_CS__ARGUMENTS;

	/**
     * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS = FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS;

	/**
     * The number of structural features of the '<em>Operation Call Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_CALL_EXP_CS_FEATURE_COUNT = FEATURE_CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.impl.StateExpCSImpl <em>State Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.impl.StateExpCSImpl
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getStateExpCS()
     * @generated
     */
	int STATE_EXP_CS = 49;

	/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP_CS__START_OFFSET = TYPE_CS__START_OFFSET;

	/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP_CS__END_OFFSET = TYPE_CS__END_OFFSET;

	/**
     * The feature id for the '<em><b>Sequence Of Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP_CS__SEQUENCE_OF_NAMES = TYPE_CS_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>State Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATE_EXP_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.SimpleTypeEnum <em>Simple Type Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.SimpleTypeEnum
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getSimpleTypeEnum()
     * @generated
     */
	int SIMPLE_TYPE_ENUM = 50;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.PrePostOrBodyEnum <em>Pre Post Or Body Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.PrePostOrBodyEnum
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrePostOrBodyEnum()
     * @generated
     */
	int PRE_POST_OR_BODY_ENUM = 51;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.CollectionTypeIdentifierEnum <em>Collection Type Identifier Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionTypeIdentifierEnum()
     * @generated
     */
	int COLLECTION_TYPE_IDENTIFIER_ENUM = 52;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.MessageExpKind <em>Message Exp Kind</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.MessageExpKind
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getMessageExpKind()
     * @generated
     */
	int MESSAGE_EXP_KIND = 53;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.cst.DotOrArrowEnum <em>Dot Or Arrow Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.cst.DotOrArrowEnum
     * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDotOrArrowEnum()
     * @generated
     */
	int DOT_OR_ARROW_ENUM = 54;


	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.CSTNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see org.eclipse.ocl.cst.CSTNode
     * @generated
     */
	EClass getCSTNode();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.CSTNode#getStartOffset <em>Start Offset</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start Offset</em>'.
     * @see org.eclipse.ocl.cst.CSTNode#getStartOffset()
     * @see #getCSTNode()
     * @generated
     */
	EAttribute getCSTNode_StartOffset();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.CSTNode#getEndOffset <em>End Offset</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>End Offset</em>'.
     * @see org.eclipse.ocl.cst.CSTNode#getEndOffset()
     * @see #getCSTNode()
     * @generated
     */
	EAttribute getCSTNode_EndOffset();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.PackageDeclarationCS <em>Package Declaration CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Package Declaration CS</em>'.
     * @see org.eclipse.ocl.cst.PackageDeclarationCS
     * @generated
     */
	EClass getPackageDeclarationCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PackageDeclarationCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.ocl.cst.PackageDeclarationCS#getPathNameCS()
     * @see #getPackageDeclarationCS()
     * @generated
     */
	EReference getPackageDeclarationCS_PathNameCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.PackageDeclarationCS#getContextDecls <em>Context Decls</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Context Decls</em>'.
     * @see org.eclipse.ocl.cst.PackageDeclarationCS#getContextDecls()
     * @see #getPackageDeclarationCS()
     * @generated
     */
	EReference getPackageDeclarationCS_ContextDecls();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.cst.PackageDeclarationCS#getPackageDeclarationCS <em>Package Declaration CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Package Declaration CS</em>'.
     * @see org.eclipse.ocl.cst.PackageDeclarationCS#getPackageDeclarationCS()
     * @see #getPackageDeclarationCS()
     * @generated
     */
	EReference getPackageDeclarationCS_PackageDeclarationCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.PathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Path Name CS</em>'.
     * @see org.eclipse.ocl.cst.PathNameCS
     * @generated
     */
	EClass getPathNameCS();

	/**
     * Returns the meta object for the attribute list '{@link org.eclipse.ocl.cst.PathNameCS#getSequenceOfNames <em>Sequence Of Names</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Sequence Of Names</em>'.
     * @see org.eclipse.ocl.cst.PathNameCS#getSequenceOfNames()
     * @see #getPathNameCS()
     * @generated
     */
	EAttribute getPathNameCS_SequenceOfNames();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.TypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type CS</em>'.
     * @see org.eclipse.ocl.cst.TypeCS
     * @generated
     */
	EClass getTypeCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.OCLExpressionCS <em>OCL Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>OCL Expression CS</em>'.
     * @see org.eclipse.ocl.cst.OCLExpressionCS
     * @generated
     */
	EClass getOCLExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.ContextDeclCS <em>Context Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context Decl CS</em>'.
     * @see org.eclipse.ocl.cst.ContextDeclCS
     * @generated
     */
	EClass getContextDeclCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.PropertyContextCS <em>Property Context CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Context CS</em>'.
     * @see org.eclipse.ocl.cst.PropertyContextCS
     * @generated
     */
	EClass getPropertyContextCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PropertyContextCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.ocl.cst.PropertyContextCS#getPathNameCS()
     * @see #getPropertyContextCS()
     * @generated
     */
	EReference getPropertyContextCS_PathNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PropertyContextCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.PropertyContextCS#getSimpleNameCS()
     * @see #getPropertyContextCS()
     * @generated
     */
	EReference getPropertyContextCS_SimpleNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PropertyContextCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.ocl.cst.PropertyContextCS#getTypeCS()
     * @see #getPropertyContextCS()
     * @generated
     */
	EReference getPropertyContextCS_TypeCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PropertyContextCS#getInitOrDerValueCS <em>Init Or Der Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Init Or Der Value CS</em>'.
     * @see org.eclipse.ocl.cst.PropertyContextCS#getInitOrDerValueCS()
     * @see #getPropertyContextCS()
     * @generated
     */
	EReference getPropertyContextCS_InitOrDerValueCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.SimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.SimpleNameCS
     * @generated
     */
	EClass getSimpleNameCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.SimpleNameCS#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.ocl.cst.SimpleNameCS#getValue()
     * @see #getSimpleNameCS()
     * @generated
     */
	EAttribute getSimpleNameCS_Value();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.SimpleNameCS#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.ocl.cst.SimpleNameCS#getType()
     * @see #getSimpleNameCS()
     * @generated
     */
	EAttribute getSimpleNameCS_Type();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.InitOrDerValueCS <em>Init Or Der Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Init Or Der Value CS</em>'.
     * @see org.eclipse.ocl.cst.InitOrDerValueCS
     * @generated
     */
	EClass getInitOrDerValueCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.InitOrDerValueCS#getInitOrDerValueCS <em>Init Or Der Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Init Or Der Value CS</em>'.
     * @see org.eclipse.ocl.cst.InitOrDerValueCS#getInitOrDerValueCS()
     * @see #getInitOrDerValueCS()
     * @generated
     */
	EReference getInitOrDerValueCS_InitOrDerValueCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.InitOrDerValueCS#getExpressionCS <em>Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression CS</em>'.
     * @see org.eclipse.ocl.cst.InitOrDerValueCS#getExpressionCS()
     * @see #getInitOrDerValueCS()
     * @generated
     */
	EReference getInitOrDerValueCS_ExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Classifier Context Decl CS</em>'.
     * @see org.eclipse.ocl.cst.ClassifierContextDeclCS
     * @generated
     */
	EClass getClassifierContextDeclCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.ClassifierContextDeclCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.ocl.cst.ClassifierContextDeclCS#getPathNameCS()
     * @see #getClassifierContextDeclCS()
     * @generated
     */
	EReference getClassifierContextDeclCS_PathNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.ClassifierContextDeclCS#getInvOrDefCS <em>Inv Or Def CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Inv Or Def CS</em>'.
     * @see org.eclipse.ocl.cst.ClassifierContextDeclCS#getInvOrDefCS()
     * @see #getClassifierContextDeclCS()
     * @generated
     */
	EReference getClassifierContextDeclCS_InvOrDefCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.InvOrDefCS <em>Inv Or Def CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Inv Or Def CS</em>'.
     * @see org.eclipse.ocl.cst.InvOrDefCS
     * @generated
     */
	EClass getInvOrDefCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.InvOrDefCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.InvOrDefCS#getSimpleNameCS()
     * @see #getInvOrDefCS()
     * @generated
     */
	EReference getInvOrDefCS_SimpleNameCS();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.cst.InvOrDefCS#getInvOrDefCS <em>Inv Or Def CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Inv Or Def CS</em>'.
     * @see org.eclipse.ocl.cst.InvOrDefCS#getInvOrDefCS()
     * @see #getInvOrDefCS()
     * @generated
     */
	EReference getInvOrDefCS_InvOrDefCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation Context Decl CS</em>'.
     * @see org.eclipse.ocl.cst.OperationContextDeclCS
     * @generated
     */
	EClass getOperationContextDeclCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.OperationContextDeclCS#getOperationCS <em>Operation CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Operation CS</em>'.
     * @see org.eclipse.ocl.cst.OperationContextDeclCS#getOperationCS()
     * @see #getOperationContextDeclCS()
     * @generated
     */
	EReference getOperationContextDeclCS_OperationCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.OperationContextDeclCS#getPrePostOrBodyDecls <em>Pre Post Or Body Decls</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Pre Post Or Body Decls</em>'.
     * @see org.eclipse.ocl.cst.OperationContextDeclCS#getPrePostOrBodyDecls()
     * @see #getOperationContextDeclCS()
     * @generated
     */
	EReference getOperationContextDeclCS_PrePostOrBodyDecls();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.OperationCS <em>Operation CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation CS</em>'.
     * @see org.eclipse.ocl.cst.OperationCS
     * @generated
     */
	EClass getOperationCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.OperationCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.ocl.cst.OperationCS#getPathNameCS()
     * @see #getOperationCS()
     * @generated
     */
	EReference getOperationCS_PathNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.OperationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.OperationCS#getSimpleNameCS()
     * @see #getOperationCS()
     * @generated
     */
	EReference getOperationCS_SimpleNameCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.OperationCS#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.ocl.cst.OperationCS#getParameters()
     * @see #getOperationCS()
     * @generated
     */
	EReference getOperationCS_Parameters();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.OperationCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.ocl.cst.OperationCS#getTypeCS()
     * @see #getOperationCS()
     * @generated
     */
	EReference getOperationCS_TypeCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.VariableCS <em>Variable CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable CS</em>'.
     * @see org.eclipse.ocl.cst.VariableCS
     * @generated
     */
	EClass getVariableCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.VariableCS#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.ocl.cst.VariableCS#getName()
     * @see #getVariableCS()
     * @generated
     */
	EAttribute getVariableCS_Name();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.VariableCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.ocl.cst.VariableCS#getTypeCS()
     * @see #getVariableCS()
     * @generated
     */
	EReference getVariableCS_TypeCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.VariableCS#getInitExpression <em>Init Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Init Expression</em>'.
     * @see org.eclipse.ocl.cst.VariableCS#getInitExpression()
     * @see #getVariableCS()
     * @generated
     */
	EReference getVariableCS_InitExpression();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS <em>Pre Post Or Body Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pre Post Or Body Decl CS</em>'.
     * @see org.eclipse.ocl.cst.PrePostOrBodyDeclCS
     * @generated
     */
	EClass getPrePostOrBodyDeclCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getKind()
     * @see #getPrePostOrBodyDeclCS()
     * @generated
     */
	EAttribute getPrePostOrBodyDeclCS_Kind();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getSimpleNameCS()
     * @see #getPrePostOrBodyDeclCS()
     * @generated
     */
	EReference getPrePostOrBodyDeclCS_SimpleNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getExpressionCS <em>Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression CS</em>'.
     * @see org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getExpressionCS()
     * @see #getPrePostOrBodyDeclCS()
     * @generated
     */
	EReference getPrePostOrBodyDeclCS_ExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.DerValueCS <em>Der Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Der Value CS</em>'.
     * @see org.eclipse.ocl.cst.DerValueCS
     * @generated
     */
	EClass getDerValueCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.InitValueCS <em>Init Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Init Value CS</em>'.
     * @see org.eclipse.ocl.cst.InitValueCS
     * @generated
     */
	EClass getInitValueCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.InvCS <em>Inv CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Inv CS</em>'.
     * @see org.eclipse.ocl.cst.InvCS
     * @generated
     */
	EClass getInvCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.InvCS#getExpressionCS <em>Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression CS</em>'.
     * @see org.eclipse.ocl.cst.InvCS#getExpressionCS()
     * @see #getInvCS()
     * @generated
     */
	EReference getInvCS_ExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.DefCS <em>Def CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Def CS</em>'.
     * @see org.eclipse.ocl.cst.DefCS
     * @generated
     */
	EClass getDefCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.DefCS#getDefExpressionCS <em>Def Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Def Expression CS</em>'.
     * @see org.eclipse.ocl.cst.DefCS#getDefExpressionCS()
     * @see #getDefCS()
     * @generated
     */
	EReference getDefCS_DefExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.DefExpressionCS <em>Def Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Def Expression CS</em>'.
     * @see org.eclipse.ocl.cst.DefExpressionCS
     * @generated
     */
	EClass getDefExpressionCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.DefExpressionCS#getOperationCS <em>Operation CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Operation CS</em>'.
     * @see org.eclipse.ocl.cst.DefExpressionCS#getOperationCS()
     * @see #getDefExpressionCS()
     * @generated
     */
	EReference getDefExpressionCS_OperationCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.DefExpressionCS#getVariableCS <em>Variable CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Variable CS</em>'.
     * @see org.eclipse.ocl.cst.DefExpressionCS#getVariableCS()
     * @see #getDefExpressionCS()
     * @generated
     */
	EReference getDefExpressionCS_VariableCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.DefExpressionCS#getExpressionCS <em>Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression CS</em>'.
     * @see org.eclipse.ocl.cst.DefExpressionCS#getExpressionCS()
     * @see #getDefExpressionCS()
     * @generated
     */
	EReference getDefExpressionCS_ExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.VariableExpCS <em>Variable Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable Exp CS</em>'.
     * @see org.eclipse.ocl.cst.VariableExpCS
     * @generated
     */
	EClass getVariableExpCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.VariableExpCS#getArguments <em>Arguments</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Arguments</em>'.
     * @see org.eclipse.ocl.cst.VariableExpCS#getArguments()
     * @see #getVariableExpCS()
     * @generated
     */
	EReference getVariableExpCS_Arguments();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.VariableExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.VariableExpCS#getSimpleNameCS()
     * @see #getVariableExpCS()
     * @generated
     */
	EReference getVariableExpCS_SimpleNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.VariableExpCS#getIsMarkedPreCS <em>Is Marked Pre CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Is Marked Pre CS</em>'.
     * @see org.eclipse.ocl.cst.VariableExpCS#getIsMarkedPreCS()
     * @see #getVariableExpCS()
     * @generated
     */
	EReference getVariableExpCS_IsMarkedPreCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.IsMarkedPreCS <em>Is Marked Pre CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Is Marked Pre CS</em>'.
     * @see org.eclipse.ocl.cst.IsMarkedPreCS
     * @generated
     */
	EClass getIsMarkedPreCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.IsMarkedPreCS#isPre <em>Pre</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pre</em>'.
     * @see org.eclipse.ocl.cst.IsMarkedPreCS#isPre()
     * @see #getIsMarkedPreCS()
     * @generated
     */
	EAttribute getIsMarkedPreCS_Pre();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Type CS</em>'.
     * @see org.eclipse.ocl.cst.PrimitiveTypeCS
     * @generated
     */
	EClass getPrimitiveTypeCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.TupleTypeCS <em>Tuple Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Type CS</em>'.
     * @see org.eclipse.ocl.cst.TupleTypeCS
     * @generated
     */
	EClass getTupleTypeCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.TupleTypeCS#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see org.eclipse.ocl.cst.TupleTypeCS#getVariables()
     * @see #getTupleTypeCS()
     * @generated
     */
	EReference getTupleTypeCS_Variables();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.CollectionTypeCS <em>Collection Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Type CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionTypeCS
     * @generated
     */
	EClass getCollectionTypeCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.CollectionTypeCS#getCollectionTypeIdentifier <em>Collection Type Identifier</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Collection Type Identifier</em>'.
     * @see org.eclipse.ocl.cst.CollectionTypeCS#getCollectionTypeIdentifier()
     * @see #getCollectionTypeCS()
     * @generated
     */
	EAttribute getCollectionTypeCS_CollectionTypeIdentifier();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.CollectionTypeCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionTypeCS#getTypeCS()
     * @see #getCollectionTypeCS()
     * @generated
     */
	EReference getCollectionTypeCS_TypeCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.LetExpCS <em>Let Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Let Exp CS</em>'.
     * @see org.eclipse.ocl.cst.LetExpCS
     * @generated
     */
	EClass getLetExpCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.LetExpCS#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see org.eclipse.ocl.cst.LetExpCS#getVariables()
     * @see #getLetExpCS()
     * @generated
     */
	EReference getLetExpCS_Variables();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.LetExpCS#getInExpression <em>In Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>In Expression</em>'.
     * @see org.eclipse.ocl.cst.LetExpCS#getInExpression()
     * @see #getLetExpCS()
     * @generated
     */
	EReference getLetExpCS_InExpression();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.IfExpCS <em>If Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>If Exp CS</em>'.
     * @see org.eclipse.ocl.cst.IfExpCS
     * @generated
     */
	EClass getIfExpCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.IfExpCS#getThenExpression <em>Then Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Then Expression</em>'.
     * @see org.eclipse.ocl.cst.IfExpCS#getThenExpression()
     * @see #getIfExpCS()
     * @generated
     */
	EReference getIfExpCS_ThenExpression();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.IfExpCS#getElseExpression <em>Else Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Else Expression</em>'.
     * @see org.eclipse.ocl.cst.IfExpCS#getElseExpression()
     * @see #getIfExpCS()
     * @generated
     */
	EReference getIfExpCS_ElseExpression();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.IfExpCS#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see org.eclipse.ocl.cst.IfExpCS#getCondition()
     * @see #getIfExpCS()
     * @generated
     */
	EReference getIfExpCS_Condition();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.MessageExpCS <em>Message Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Exp CS</em>'.
     * @see org.eclipse.ocl.cst.MessageExpCS
     * @generated
     */
	EClass getMessageExpCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.MessageExpCS#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Target</em>'.
     * @see org.eclipse.ocl.cst.MessageExpCS#getTarget()
     * @see #getMessageExpCS()
     * @generated
     */
	EReference getMessageExpCS_Target();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.MessageExpCS#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.ocl.cst.MessageExpCS#getKind()
     * @see #getMessageExpCS()
     * @generated
     */
	EAttribute getMessageExpCS_Kind();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.MessageExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.MessageExpCS#getSimpleNameCS()
     * @see #getMessageExpCS()
     * @generated
     */
	EReference getMessageExpCS_SimpleNameCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.MessageExpCS#getArguments <em>Arguments</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Arguments</em>'.
     * @see org.eclipse.ocl.cst.MessageExpCS#getArguments()
     * @see #getMessageExpCS()
     * @generated
     */
	EReference getMessageExpCS_Arguments();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.OCLMessageArgCS <em>OCL Message Arg CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>OCL Message Arg CS</em>'.
     * @see org.eclipse.ocl.cst.OCLMessageArgCS
     * @generated
     */
	EClass getOCLMessageArgCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.OCLMessageArgCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.ocl.cst.OCLMessageArgCS#getTypeCS()
     * @see #getOCLMessageArgCS()
     * @generated
     */
	EReference getOCLMessageArgCS_TypeCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.OCLMessageArgCS#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see org.eclipse.ocl.cst.OCLMessageArgCS#getExpression()
     * @see #getOCLMessageArgCS()
     * @generated
     */
	EReference getOCLMessageArgCS_Expression();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.LiteralExpCS <em>Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.LiteralExpCS
     * @generated
     */
	EClass getLiteralExpCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.EnumLiteralExpCS <em>Enum Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.EnumLiteralExpCS
     * @generated
     */
	EClass getEnumLiteralExpCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.EnumLiteralExpCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.ocl.cst.EnumLiteralExpCS#getPathNameCS()
     * @see #getEnumLiteralExpCS()
     * @generated
     */
	EReference getEnumLiteralExpCS_PathNameCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.EnumLiteralExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.EnumLiteralExpCS#getSimpleNameCS()
     * @see #getEnumLiteralExpCS()
     * @generated
     */
	EReference getEnumLiteralExpCS_SimpleNameCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionLiteralExpCS
     * @generated
     */
	EClass getCollectionLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Collection Type</em>'.
     * @see org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionType()
     * @see #getCollectionLiteralExpCS()
     * @generated
     */
	EAttribute getCollectionLiteralExpCS_CollectionType();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionLiteralParts <em>Collection Literal Parts</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Collection Literal Parts</em>'.
     * @see org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionLiteralParts()
     * @see #getCollectionLiteralExpCS()
     * @generated
     */
	EReference getCollectionLiteralExpCS_CollectionLiteralParts();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Literal Part CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionLiteralPartCS
     * @generated
     */
	EClass getCollectionLiteralPartCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionLiteralPartCS#getExpressionCS()
     * @see #getCollectionLiteralPartCS()
     * @generated
     */
	EReference getCollectionLiteralPartCS_ExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.TupleLiteralExpCS
     * @generated
     */
	EClass getTupleLiteralExpCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.TupleLiteralExpCS#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see org.eclipse.ocl.cst.TupleLiteralExpCS#getVariables()
     * @see #getTupleLiteralExpCS()
     * @generated
     */
	EReference getTupleLiteralExpCS_Variables();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.PrimitiveLiteralExpCS
     * @generated
     */
	EClass getPrimitiveLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.PrimitiveLiteralExpCS#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see org.eclipse.ocl.cst.PrimitiveLiteralExpCS#getSymbol()
     * @see #getPrimitiveLiteralExpCS()
     * @generated
     */
	EAttribute getPrimitiveLiteralExpCS_Symbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.IntegerLiteralExpCS <em>Integer Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.IntegerLiteralExpCS
     * @generated
     */
	EClass getIntegerLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.IntegerLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Integer Symbol</em>'.
     * @see org.eclipse.ocl.cst.IntegerLiteralExpCS#getIntegerSymbol()
     * @see #getIntegerLiteralExpCS()
     * @generated
     */
	EAttribute getIntegerLiteralExpCS_IntegerSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unlimited Natural Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS
     * @generated
     */
	EClass getUnlimitedNaturalLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Integer Symbol</em>'.
     * @see org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS#getIntegerSymbol()
     * @see #getUnlimitedNaturalLiteralExpCS()
     * @generated
     */
	EAttribute getUnlimitedNaturalLiteralExpCS_IntegerSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.RealLiteralExpCS <em>Real Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Real Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.RealLiteralExpCS
     * @generated
     */
	EClass getRealLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.RealLiteralExpCS#getRealSymbol <em>Real Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Real Symbol</em>'.
     * @see org.eclipse.ocl.cst.RealLiteralExpCS#getRealSymbol()
     * @see #getRealLiteralExpCS()
     * @generated
     */
	EAttribute getRealLiteralExpCS_RealSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.StringLiteralExpCS
     * @generated
     */
	EClass getStringLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.StringLiteralExpCS#getStringSymbol <em>String Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>String Symbol</em>'.
     * @see org.eclipse.ocl.cst.StringLiteralExpCS#getStringSymbol()
     * @see #getStringLiteralExpCS()
     * @generated
     */
	EAttribute getStringLiteralExpCS_StringSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.BooleanLiteralExpCS
     * @generated
     */
	EClass getBooleanLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.BooleanLiteralExpCS#getBooleanSymbol <em>Boolean Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
     * @see org.eclipse.ocl.cst.BooleanLiteralExpCS#getBooleanSymbol()
     * @see #getBooleanLiteralExpCS()
     * @generated
     */
	EAttribute getBooleanLiteralExpCS_BooleanSymbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Null Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.NullLiteralExpCS
     * @generated
     */
	EClass getNullLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.NullLiteralExpCS#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see org.eclipse.ocl.cst.NullLiteralExpCS#getSymbol()
     * @see #getNullLiteralExpCS()
     * @generated
     */
	EAttribute getNullLiteralExpCS_Symbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Invalid Literal Exp CS</em>'.
     * @see org.eclipse.ocl.cst.InvalidLiteralExpCS
     * @generated
     */
	EClass getInvalidLiteralExpCS();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.InvalidLiteralExpCS#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see org.eclipse.ocl.cst.InvalidLiteralExpCS#getSymbol()
     * @see #getInvalidLiteralExpCS()
     * @generated
     */
	EAttribute getInvalidLiteralExpCS_Symbol();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.CollectionRangeCS <em>Collection Range CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Range CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionRangeCS
     * @generated
     */
	EClass getCollectionRangeCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.CollectionRangeCS#getLastExpressionCS <em>Last Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Last Expression CS</em>'.
     * @see org.eclipse.ocl.cst.CollectionRangeCS#getLastExpressionCS()
     * @see #getCollectionRangeCS()
     * @generated
     */
	EReference getCollectionRangeCS_LastExpressionCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.CallExpCS <em>Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Exp CS</em>'.
     * @see org.eclipse.ocl.cst.CallExpCS
     * @generated
     */
	EClass getCallExpCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.CallExpCS#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Source</em>'.
     * @see org.eclipse.ocl.cst.CallExpCS#getSource()
     * @see #getCallExpCS()
     * @generated
     */
	EReference getCallExpCS_Source();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.cst.CallExpCS#getAccessor <em>Accessor</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Accessor</em>'.
     * @see org.eclipse.ocl.cst.CallExpCS#getAccessor()
     * @see #getCallExpCS()
     * @generated
     */
	EAttribute getCallExpCS_Accessor();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.CallExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.ocl.cst.CallExpCS#getSimpleNameCS()
     * @see #getCallExpCS()
     * @generated
     */
	EReference getCallExpCS_SimpleNameCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.LoopExpCS <em>Loop Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Loop Exp CS</em>'.
     * @see org.eclipse.ocl.cst.LoopExpCS
     * @generated
     */
	EClass getLoopExpCS();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.LoopExpCS#getVariable1 <em>Variable1</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Variable1</em>'.
     * @see org.eclipse.ocl.cst.LoopExpCS#getVariable1()
     * @see #getLoopExpCS()
     * @generated
     */
	EReference getLoopExpCS_Variable1();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.LoopExpCS#getVariable2 <em>Variable2</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Variable2</em>'.
     * @see org.eclipse.ocl.cst.LoopExpCS#getVariable2()
     * @see #getLoopExpCS()
     * @generated
     */
	EReference getLoopExpCS_Variable2();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.LoopExpCS#getBody <em>Body</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Body</em>'.
     * @see org.eclipse.ocl.cst.LoopExpCS#getBody()
     * @see #getLoopExpCS()
     * @generated
     */
	EReference getLoopExpCS_Body();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.IteratorExpCS <em>Iterator Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterator Exp CS</em>'.
     * @see org.eclipse.ocl.cst.IteratorExpCS
     * @generated
     */
	EClass getIteratorExpCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.IterateExpCS <em>Iterate Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterate Exp CS</em>'.
     * @see org.eclipse.ocl.cst.IterateExpCS
     * @generated
     */
	EClass getIterateExpCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.FeatureCallExpCS <em>Feature Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Call Exp CS</em>'.
     * @see org.eclipse.ocl.cst.FeatureCallExpCS
     * @generated
     */
	EClass getFeatureCallExpCS();

	/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.cst.FeatureCallExpCS#getArguments <em>Arguments</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Arguments</em>'.
     * @see org.eclipse.ocl.cst.FeatureCallExpCS#getArguments()
     * @see #getFeatureCallExpCS()
     * @generated
     */
	EReference getFeatureCallExpCS_Arguments();

	/**
     * Returns the meta object for the containment reference '{@link org.eclipse.ocl.cst.FeatureCallExpCS#getIsMarkedPreCS <em>Is Marked Pre CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Is Marked Pre CS</em>'.
     * @see org.eclipse.ocl.cst.FeatureCallExpCS#getIsMarkedPreCS()
     * @see #getFeatureCallExpCS()
     * @generated
     */
	EReference getFeatureCallExpCS_IsMarkedPreCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.OperationCallExpCS <em>Operation Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation Call Exp CS</em>'.
     * @see org.eclipse.ocl.cst.OperationCallExpCS
     * @generated
     */
	EClass getOperationCallExpCS();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.cst.StateExpCS <em>State Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>State Exp CS</em>'.
     * @see org.eclipse.ocl.cst.StateExpCS
     * @generated
     */
	EClass getStateExpCS();

	/**
     * Returns the meta object for the attribute list '{@link org.eclipse.ocl.cst.StateExpCS#getSequenceOfNames <em>Sequence Of Names</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Sequence Of Names</em>'.
     * @see org.eclipse.ocl.cst.StateExpCS#getSequenceOfNames()
     * @see #getStateExpCS()
     * @generated
     */
	EAttribute getStateExpCS_SequenceOfNames();

	/**
     * Returns the meta object for enum '{@link org.eclipse.ocl.cst.SimpleTypeEnum <em>Simple Type Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Simple Type Enum</em>'.
     * @see org.eclipse.ocl.cst.SimpleTypeEnum
     * @generated
     */
	EEnum getSimpleTypeEnum();

	/**
     * Returns the meta object for enum '{@link org.eclipse.ocl.cst.PrePostOrBodyEnum <em>Pre Post Or Body Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Pre Post Or Body Enum</em>'.
     * @see org.eclipse.ocl.cst.PrePostOrBodyEnum
     * @generated
     */
	EEnum getPrePostOrBodyEnum();

	/**
     * Returns the meta object for enum '{@link org.eclipse.ocl.cst.CollectionTypeIdentifierEnum <em>Collection Type Identifier Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Collection Type Identifier Enum</em>'.
     * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
     * @generated
     */
	EEnum getCollectionTypeIdentifierEnum();

	/**
     * Returns the meta object for enum '{@link org.eclipse.ocl.cst.MessageExpKind <em>Message Exp Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Message Exp Kind</em>'.
     * @see org.eclipse.ocl.cst.MessageExpKind
     * @generated
     */
	EEnum getMessageExpKind();

	/**
     * Returns the meta object for enum '{@link org.eclipse.ocl.cst.DotOrArrowEnum <em>Dot Or Arrow Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Dot Or Arrow Enum</em>'.
     * @see org.eclipse.ocl.cst.DotOrArrowEnum
     * @generated
     */
	EEnum getDotOrArrowEnum();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	CSTFactory getCSTFactory();

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
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.CSTNodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.CSTNodeImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCSTNode()
         * @generated
         */
		EClass CST_NODE = eINSTANCE.getCSTNode();

		/**
         * The meta object literal for the '<em><b>Start Offset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CST_NODE__START_OFFSET = eINSTANCE.getCSTNode_StartOffset();

		/**
         * The meta object literal for the '<em><b>End Offset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CST_NODE__END_OFFSET = eINSTANCE.getCSTNode_EndOffset();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPackageDeclarationCS()
         * @generated
         */
		EClass PACKAGE_DECLARATION_CS = eINSTANCE.getPackageDeclarationCS();

		/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_DECLARATION_CS__PATH_NAME_CS = eINSTANCE.getPackageDeclarationCS_PathNameCS();

		/**
         * The meta object literal for the '<em><b>Context Decls</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_DECLARATION_CS__CONTEXT_DECLS = eINSTANCE.getPackageDeclarationCS_ContextDecls();

		/**
         * The meta object literal for the '<em><b>Package Declaration CS</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS = eINSTANCE.getPackageDeclarationCS_PackageDeclarationCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.PathNameCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPathNameCS()
         * @generated
         */
		EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

		/**
         * The meta object literal for the '<em><b>Sequence Of Names</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PATH_NAME_CS__SEQUENCE_OF_NAMES = eINSTANCE.getPathNameCS_SequenceOfNames();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.TypeCSImpl <em>Type CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.TypeCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getTypeCS()
         * @generated
         */
		EClass TYPE_CS = eINSTANCE.getTypeCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.OCLExpressionCSImpl <em>OCL Expression CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.OCLExpressionCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOCLExpressionCS()
         * @generated
         */
		EClass OCL_EXPRESSION_CS = eINSTANCE.getOCLExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.ContextDeclCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getContextDeclCS()
         * @generated
         */
		EClass CONTEXT_DECL_CS = eINSTANCE.getContextDeclCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.PropertyContextCSImpl <em>Property Context CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.PropertyContextCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPropertyContextCS()
         * @generated
         */
		EClass PROPERTY_CONTEXT_CS = eINSTANCE.getPropertyContextCS();

		/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROPERTY_CONTEXT_CS__PATH_NAME_CS = eINSTANCE.getPropertyContextCS_PathNameCS();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS = eINSTANCE.getPropertyContextCS_SimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROPERTY_CONTEXT_CS__TYPE_CS = eINSTANCE.getPropertyContextCS_TypeCS();

		/**
         * The meta object literal for the '<em><b>Init Or Der Value CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS = eINSTANCE.getPropertyContextCS_InitOrDerValueCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.SimpleNameCSImpl <em>Simple Name CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.SimpleNameCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getSimpleNameCS()
         * @generated
         */
		EClass SIMPLE_NAME_CS = eINSTANCE.getSimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIMPLE_NAME_CS__VALUE = eINSTANCE.getSimpleNameCS_Value();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIMPLE_NAME_CS__TYPE = eINSTANCE.getSimpleNameCS_Type();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.InitOrDerValueCSImpl <em>Init Or Der Value CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.InitOrDerValueCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInitOrDerValueCS()
         * @generated
         */
		EClass INIT_OR_DER_VALUE_CS = eINSTANCE.getInitOrDerValueCS();

		/**
         * The meta object literal for the '<em><b>Init Or Der Value CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS = eINSTANCE.getInitOrDerValueCS_InitOrDerValueCS();

		/**
         * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INIT_OR_DER_VALUE_CS__EXPRESSION_CS = eINSTANCE.getInitOrDerValueCS_ExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.ClassifierContextDeclCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getClassifierContextDeclCS()
         * @generated
         */
		EClass CLASSIFIER_CONTEXT_DECL_CS = eINSTANCE.getClassifierContextDeclCS();

		/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS = eINSTANCE.getClassifierContextDeclCS_PathNameCS();

		/**
         * The meta object literal for the '<em><b>Inv Or Def CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS = eINSTANCE.getClassifierContextDeclCS_InvOrDefCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.InvOrDefCSImpl <em>Inv Or Def CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.InvOrDefCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInvOrDefCS()
         * @generated
         */
		EClass INV_OR_DEF_CS = eINSTANCE.getInvOrDefCS();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INV_OR_DEF_CS__SIMPLE_NAME_CS = eINSTANCE.getInvOrDefCS_SimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Inv Or Def CS</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INV_OR_DEF_CS__INV_OR_DEF_CS = eINSTANCE.getInvOrDefCS_InvOrDefCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.OperationContextDeclCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOperationContextDeclCS()
         * @generated
         */
		EClass OPERATION_CONTEXT_DECL_CS = eINSTANCE.getOperationContextDeclCS();

		/**
         * The meta object literal for the '<em><b>Operation CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CONTEXT_DECL_CS__OPERATION_CS = eINSTANCE.getOperationContextDeclCS_OperationCS();

		/**
         * The meta object literal for the '<em><b>Pre Post Or Body Decls</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS = eINSTANCE.getOperationContextDeclCS_PrePostOrBodyDecls();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.OperationCSImpl <em>Operation CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.OperationCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOperationCS()
         * @generated
         */
		EClass OPERATION_CS = eINSTANCE.getOperationCS();

		/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CS__PATH_NAME_CS = eINSTANCE.getOperationCS_PathNameCS();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CS__SIMPLE_NAME_CS = eINSTANCE.getOperationCS_SimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CS__PARAMETERS = eINSTANCE.getOperationCS_Parameters();

		/**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION_CS__TYPE_CS = eINSTANCE.getOperationCS_TypeCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.VariableCSImpl <em>Variable CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.VariableCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getVariableCS()
         * @generated
         */
		EClass VARIABLE_CS = eINSTANCE.getVariableCS();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute VARIABLE_CS__NAME = eINSTANCE.getVariableCS_Name();

		/**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_CS__TYPE_CS = eINSTANCE.getVariableCS_TypeCS();

		/**
         * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_CS__INIT_EXPRESSION = eINSTANCE.getVariableCS_InitExpression();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl <em>Pre Post Or Body Decl CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrePostOrBodyDeclCS()
         * @generated
         */
		EClass PRE_POST_OR_BODY_DECL_CS = eINSTANCE.getPrePostOrBodyDeclCS();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PRE_POST_OR_BODY_DECL_CS__KIND = eINSTANCE.getPrePostOrBodyDeclCS_Kind();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS = eINSTANCE.getPrePostOrBodyDeclCS_SimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS = eINSTANCE.getPrePostOrBodyDeclCS_ExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.DerValueCSImpl <em>Der Value CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.DerValueCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDerValueCS()
         * @generated
         */
		EClass DER_VALUE_CS = eINSTANCE.getDerValueCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.InitValueCSImpl <em>Init Value CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.InitValueCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInitValueCS()
         * @generated
         */
		EClass INIT_VALUE_CS = eINSTANCE.getInitValueCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.InvCSImpl <em>Inv CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.InvCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInvCS()
         * @generated
         */
		EClass INV_CS = eINSTANCE.getInvCS();

		/**
         * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INV_CS__EXPRESSION_CS = eINSTANCE.getInvCS_ExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.DefCSImpl <em>Def CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.DefCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDefCS()
         * @generated
         */
		EClass DEF_CS = eINSTANCE.getDefCS();

		/**
         * The meta object literal for the '<em><b>Def Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DEF_CS__DEF_EXPRESSION_CS = eINSTANCE.getDefCS_DefExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.DefExpressionCSImpl <em>Def Expression CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.DefExpressionCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDefExpressionCS()
         * @generated
         */
		EClass DEF_EXPRESSION_CS = eINSTANCE.getDefExpressionCS();

		/**
         * The meta object literal for the '<em><b>Operation CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DEF_EXPRESSION_CS__OPERATION_CS = eINSTANCE.getDefExpressionCS_OperationCS();

		/**
         * The meta object literal for the '<em><b>Variable CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DEF_EXPRESSION_CS__VARIABLE_CS = eINSTANCE.getDefExpressionCS_VariableCS();

		/**
         * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DEF_EXPRESSION_CS__EXPRESSION_CS = eINSTANCE.getDefExpressionCS_ExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.VariableExpCSImpl <em>Variable Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.VariableExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getVariableExpCS()
         * @generated
         */
		EClass VARIABLE_EXP_CS = eINSTANCE.getVariableExpCS();

		/**
         * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_EXP_CS__ARGUMENTS = eINSTANCE.getVariableExpCS_Arguments();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getVariableExpCS_SimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Is Marked Pre CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_EXP_CS__IS_MARKED_PRE_CS = eINSTANCE.getVariableExpCS_IsMarkedPreCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.IsMarkedPreCSImpl <em>Is Marked Pre CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.IsMarkedPreCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIsMarkedPreCS()
         * @generated
         */
		EClass IS_MARKED_PRE_CS = eINSTANCE.getIsMarkedPreCS();

		/**
         * The meta object literal for the '<em><b>Pre</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute IS_MARKED_PRE_CS__PRE = eINSTANCE.getIsMarkedPreCS_Pre();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.PrimitiveTypeCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrimitiveTypeCS()
         * @generated
         */
		EClass PRIMITIVE_TYPE_CS = eINSTANCE.getPrimitiveTypeCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.TupleTypeCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getTupleTypeCS()
         * @generated
         */
		EClass TUPLE_TYPE_CS = eINSTANCE.getTupleTypeCS();

		/**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TUPLE_TYPE_CS__VARIABLES = eINSTANCE.getTupleTypeCS_Variables();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.CollectionTypeCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionTypeCS()
         * @generated
         */
		EClass COLLECTION_TYPE_CS = eINSTANCE.getCollectionTypeCS();

		/**
         * The meta object literal for the '<em><b>Collection Type Identifier</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER = eINSTANCE.getCollectionTypeCS_CollectionTypeIdentifier();

		/**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_TYPE_CS__TYPE_CS = eINSTANCE.getCollectionTypeCS_TypeCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.LetExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getLetExpCS()
         * @generated
         */
		EClass LET_EXP_CS = eINSTANCE.getLetExpCS();

		/**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LET_EXP_CS__VARIABLES = eINSTANCE.getLetExpCS_Variables();

		/**
         * The meta object literal for the '<em><b>In Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LET_EXP_CS__IN_EXPRESSION = eINSTANCE.getLetExpCS_InExpression();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.IfExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIfExpCS()
         * @generated
         */
		EClass IF_EXP_CS = eINSTANCE.getIfExpCS();

		/**
         * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IF_EXP_CS__THEN_EXPRESSION = eINSTANCE.getIfExpCS_ThenExpression();

		/**
         * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IF_EXP_CS__ELSE_EXPRESSION = eINSTANCE.getIfExpCS_ElseExpression();

		/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IF_EXP_CS__CONDITION = eINSTANCE.getIfExpCS_Condition();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.MessageExpCSImpl <em>Message Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.MessageExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getMessageExpCS()
         * @generated
         */
		EClass MESSAGE_EXP_CS = eINSTANCE.getMessageExpCS();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP_CS__TARGET = eINSTANCE.getMessageExpCS_Target();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MESSAGE_EXP_CS__KIND = eINSTANCE.getMessageExpCS_Kind();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getMessageExpCS_SimpleNameCS();

		/**
         * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_EXP_CS__ARGUMENTS = eINSTANCE.getMessageExpCS_Arguments();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.OCLMessageArgCSImpl <em>OCL Message Arg CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.OCLMessageArgCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOCLMessageArgCS()
         * @generated
         */
		EClass OCL_MESSAGE_ARG_CS = eINSTANCE.getOCLMessageArgCS();

		/**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OCL_MESSAGE_ARG_CS__TYPE_CS = eINSTANCE.getOCLMessageArgCS_TypeCS();

		/**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OCL_MESSAGE_ARG_CS__EXPRESSION = eINSTANCE.getOCLMessageArgCS_Expression();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.LiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getLiteralExpCS()
         * @generated
         */
		EClass LITERAL_EXP_CS = eINSTANCE.getLiteralExpCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.EnumLiteralExpCSImpl <em>Enum Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.EnumLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getEnumLiteralExpCS()
         * @generated
         */
		EClass ENUM_LITERAL_EXP_CS = eINSTANCE.getEnumLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ENUM_LITERAL_EXP_CS__PATH_NAME_CS = eINSTANCE.getEnumLiteralExpCS_PathNameCS();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getEnumLiteralExpCS_SimpleNameCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.CollectionLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionLiteralExpCS()
         * @generated
         */
		EClass COLLECTION_LITERAL_EXP_CS = eINSTANCE.getCollectionLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Collection Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE = eINSTANCE.getCollectionLiteralExpCS_CollectionType();

		/**
         * The meta object literal for the '<em><b>Collection Literal Parts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS = eINSTANCE.getCollectionLiteralExpCS_CollectionLiteralParts();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.CollectionLiteralPartCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionLiteralPartCS()
         * @generated
         */
		EClass COLLECTION_LITERAL_PART_CS = eINSTANCE.getCollectionLiteralPartCS();

		/**
         * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = eINSTANCE.getCollectionLiteralPartCS_ExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.TupleLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getTupleLiteralExpCS()
         * @generated
         */
		EClass TUPLE_LITERAL_EXP_CS = eINSTANCE.getTupleLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TUPLE_LITERAL_EXP_CS__VARIABLES = eINSTANCE.getTupleLiteralExpCS_Variables();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.PrimitiveLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrimitiveLiteralExpCS()
         * @generated
         */
		EClass PRIMITIVE_LITERAL_EXP_CS = eINSTANCE.getPrimitiveLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PRIMITIVE_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getPrimitiveLiteralExpCS_Symbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.IntegerLiteralExpCSImpl <em>Integer Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.IntegerLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIntegerLiteralExpCS()
         * @generated
         */
		EClass INTEGER_LITERAL_EXP_CS = eINSTANCE.getIntegerLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExpCS_IntegerSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.UnlimitedNaturalLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getUnlimitedNaturalLiteralExpCS()
         * @generated
         */
		EClass UNLIMITED_NATURAL_LITERAL_EXP_CS = eINSTANCE.getUnlimitedNaturalLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute UNLIMITED_NATURAL_LITERAL_EXP_CS__INTEGER_SYMBOL = eINSTANCE.getUnlimitedNaturalLiteralExpCS_IntegerSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.RealLiteralExpCSImpl <em>Real Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.RealLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getRealLiteralExpCS()
         * @generated
         */
		EClass REAL_LITERAL_EXP_CS = eINSTANCE.getRealLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute REAL_LITERAL_EXP_CS__REAL_SYMBOL = eINSTANCE.getRealLiteralExpCS_RealSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.StringLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getStringLiteralExpCS()
         * @generated
         */
		EClass STRING_LITERAL_EXP_CS = eINSTANCE.getStringLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute STRING_LITERAL_EXP_CS__STRING_SYMBOL = eINSTANCE.getStringLiteralExpCS_StringSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.BooleanLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getBooleanLiteralExpCS()
         * @generated
         */
		EClass BOOLEAN_LITERAL_EXP_CS = eINSTANCE.getBooleanLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute BOOLEAN_LITERAL_EXP_CS__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExpCS_BooleanSymbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.NullLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getNullLiteralExpCS()
         * @generated
         */
		EClass NULL_LITERAL_EXP_CS = eINSTANCE.getNullLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute NULL_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getNullLiteralExpCS_Symbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.InvalidLiteralExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getInvalidLiteralExpCS()
         * @generated
         */
		EClass INVALID_LITERAL_EXP_CS = eINSTANCE.getInvalidLiteralExpCS();

		/**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute INVALID_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getInvalidLiteralExpCS_Symbol();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.CollectionRangeCSImpl <em>Collection Range CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.CollectionRangeCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionRangeCS()
         * @generated
         */
		EClass COLLECTION_RANGE_CS = eINSTANCE.getCollectionRangeCS();

		/**
         * The meta object literal for the '<em><b>Last Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_RANGE_CS__LAST_EXPRESSION_CS = eINSTANCE.getCollectionRangeCS_LastExpressionCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.CallExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCallExpCS()
         * @generated
         */
		EClass CALL_EXP_CS = eINSTANCE.getCallExpCS();

		/**
         * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CALL_EXP_CS__SOURCE = eINSTANCE.getCallExpCS_Source();

		/**
         * The meta object literal for the '<em><b>Accessor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CALL_EXP_CS__ACCESSOR = eINSTANCE.getCallExpCS_Accessor();

		/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CALL_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getCallExpCS_SimpleNameCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.LoopExpCSImpl <em>Loop Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.LoopExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getLoopExpCS()
         * @generated
         */
		EClass LOOP_EXP_CS = eINSTANCE.getLoopExpCS();

		/**
         * The meta object literal for the '<em><b>Variable1</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LOOP_EXP_CS__VARIABLE1 = eINSTANCE.getLoopExpCS_Variable1();

		/**
         * The meta object literal for the '<em><b>Variable2</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LOOP_EXP_CS__VARIABLE2 = eINSTANCE.getLoopExpCS_Variable2();

		/**
         * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LOOP_EXP_CS__BODY = eINSTANCE.getLoopExpCS_Body();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.IteratorExpCSImpl <em>Iterator Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.IteratorExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIteratorExpCS()
         * @generated
         */
		EClass ITERATOR_EXP_CS = eINSTANCE.getIteratorExpCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.IterateExpCSImpl <em>Iterate Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.IterateExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getIterateExpCS()
         * @generated
         */
		EClass ITERATE_EXP_CS = eINSTANCE.getIterateExpCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.FeatureCallExpCSImpl <em>Feature Call Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.FeatureCallExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getFeatureCallExpCS()
         * @generated
         */
		EClass FEATURE_CALL_EXP_CS = eINSTANCE.getFeatureCallExpCS();

		/**
         * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FEATURE_CALL_EXP_CS__ARGUMENTS = eINSTANCE.getFeatureCallExpCS_Arguments();

		/**
         * The meta object literal for the '<em><b>Is Marked Pre CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS = eINSTANCE.getFeatureCallExpCS_IsMarkedPreCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.OperationCallExpCSImpl <em>Operation Call Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.OperationCallExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getOperationCallExpCS()
         * @generated
         */
		EClass OPERATION_CALL_EXP_CS = eINSTANCE.getOperationCallExpCS();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.impl.StateExpCSImpl <em>State Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.impl.StateExpCSImpl
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getStateExpCS()
         * @generated
         */
		EClass STATE_EXP_CS = eINSTANCE.getStateExpCS();

		/**
         * The meta object literal for the '<em><b>Sequence Of Names</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute STATE_EXP_CS__SEQUENCE_OF_NAMES = eINSTANCE.getStateExpCS_SequenceOfNames();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.SimpleTypeEnum <em>Simple Type Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.SimpleTypeEnum
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getSimpleTypeEnum()
         * @generated
         */
		EEnum SIMPLE_TYPE_ENUM = eINSTANCE.getSimpleTypeEnum();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.PrePostOrBodyEnum <em>Pre Post Or Body Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.PrePostOrBodyEnum
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getPrePostOrBodyEnum()
         * @generated
         */
		EEnum PRE_POST_OR_BODY_ENUM = eINSTANCE.getPrePostOrBodyEnum();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.CollectionTypeIdentifierEnum <em>Collection Type Identifier Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getCollectionTypeIdentifierEnum()
         * @generated
         */
		EEnum COLLECTION_TYPE_IDENTIFIER_ENUM = eINSTANCE.getCollectionTypeIdentifierEnum();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.MessageExpKind <em>Message Exp Kind</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.MessageExpKind
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getMessageExpKind()
         * @generated
         */
		EEnum MESSAGE_EXP_KIND = eINSTANCE.getMessageExpKind();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.cst.DotOrArrowEnum <em>Dot Or Arrow Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.cst.DotOrArrowEnum
         * @see org.eclipse.ocl.cst.impl.CSTPackageImpl#getDotOrArrowEnum()
         * @generated
         */
		EEnum DOT_OR_ARROW_ENUM = eINSTANCE.getDotOrArrowEnum();

	}

} //CSTPackage
