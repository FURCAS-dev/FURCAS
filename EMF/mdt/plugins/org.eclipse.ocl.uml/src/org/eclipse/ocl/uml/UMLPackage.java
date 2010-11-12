/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 231435, 207365
 * 
 * </copyright>
 *
 * $Id: UMLPackage.java,v 1.11 2009/12/22 18:59:37 ewillink Exp $
 */
package org.eclipse.ocl.uml;

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
 * @see org.eclipse.ocl.uml.UMLFactory
 * @model kind="package"
 * @generated
 */
public interface UMLPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uml"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.1.0/UML"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ocl.uml"; //$NON-NLS-1$

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.uml"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMLPackage eINSTANCE = org.eclipse.ocl.uml.impl.UMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.AnyTypeImpl <em>Any Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.AnyTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getAnyType()
	 * @generated
	 */
	int ANY_TYPE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.VoidTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.InvalidTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getInvalidType()
	 * @generated
	 */
	int INVALID_TYPE = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invalid Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.ElementTypeImpl <em>Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.ElementTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getElementType()
	 * @generated
	 */
	int ELEMENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The number of structural features of the '<em>Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TypeTypeImpl <em>Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.TypeTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The feature id for the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__REFERRED_TYPE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.MessageTypeImpl <em>Message Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.MessageTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getMessageType()
	 * @generated
	 */
	int MESSAGE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_SIGNAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.PrimitiveTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_OPERATION;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.CollectionTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__START_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__END_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TYPE_START_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TYPE_END_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_TYPE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__KIND = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.TupleTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleType()
	 * @generated
	 */
	int TUPLE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_OPERATION;

	/**
	 * The number of structural features of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.BagTypeImpl <em>Bag Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.BagTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNER = COLLECTION_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
	 * The number of structural features of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.SetTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNER = COLLECTION_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.OrderedSetTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 11;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNER = COLLECTION_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.SequenceTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNER = COLLECTION_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.ExpressionInOCLImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getExpressionInOCL()
	 * @generated
	 */
	int EXPRESSION_IN_OCL = 13;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNER = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__NAME = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__TYPE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BODY = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__BODY;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__LANGUAGE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__RESULT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__RESULT;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BEHAVIOR = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BODY_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__CONTEXT_VARIABLE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__RESULT_VARIABLE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__PARAMETER_VARIABLE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Generated Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__GENERATED_TYPE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.OCLExpressionImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOCLExpression()
	 * @generated
	 */
	int OCL_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNER = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TYPE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__START_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__END_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CallExpImpl <em>Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.CallExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCallExp()
	 * @generated
	 */
	int CALL_EXP = 17;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.FeatureCallExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getFeatureCallExp()
	 * @generated
	 */
	int FEATURE_CALL_EXP = 16;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__EANNOTATIONS = CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_ELEMENT = CALL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNER = CALL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_COMMENT = CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__VISIBILITY = CALL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__QUALIFIED_NAME = CALL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__CLIENT_DEPENDENCY = CALL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__NAMESPACE = CALL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__NAME_EXPRESSION = CALL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__START_POSITION = CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__END_POSITION = CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__MARKED_PRE = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.NavigationCallExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getNavigationCallExp()
	 * @generated
	 */
	int NAVIGATION_CALL_EXP = 15;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__EANNOTATIONS = FEATURE_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_ELEMENT = FEATURE_CALL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNER = FEATURE_CALL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_COMMENT = FEATURE_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__VISIBILITY = FEATURE_CALL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__QUALIFIED_NAME = FEATURE_CALL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__CLIENT_DEPENDENCY = FEATURE_CALL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAMESPACE = FEATURE_CALL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAME_EXPRESSION = FEATURE_CALL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__TYPE = FEATURE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__QUALIFIER = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.AssociationClassCallExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getAssociationClassCallExp()
	 * @generated
	 */
	int ASSOCIATION_CLASS_CALL_EXP = 14;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__EANNOTATIONS = NAVIGATION_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_ELEMENT = NAVIGATION_CALL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNER = NAVIGATION_CALL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__VISIBILITY = NAVIGATION_CALL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIED_NAME = NAVIGATION_CALL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__CLIENT_DEPENDENCY = NAVIGATION_CALL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAMESPACE = NAVIGATION_CALL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAME_EXPRESSION = NAVIGATION_CALL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Class Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.LiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getLiteralExp()
	 * @generated
	 */
	int LITERAL_EXP = 21;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The number of structural features of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.PrimitiveLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPrimitiveLiteralExp()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP = 20;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_ELEMENT = LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNER = LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__VISIBILITY = LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__QUALIFIED_NAME = LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__CLIENT_DEPENDENCY = LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__NAMESPACE = LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__NAME_EXPRESSION = LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.BooleanLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 19;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_ELEMENT = PRIMITIVE_LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNER = PRIMITIVE_LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__VISIBILITY = PRIMITIVE_LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__QUALIFIED_NAME = PRIMITIVE_LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__CLIENT_DEPENDENCY = PRIMITIVE_LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAMESPACE = PRIMITIVE_LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAME_EXPRESSION = PRIMITIVE_LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.CollectionLiteralPartImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionLiteralPart()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART = 23;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNER = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__TYPE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Collection Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CollectionItemImpl <em>Collection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.CollectionItemImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionItem()
	 * @generated
	 */
	int COLLECTION_ITEM = 22;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__EANNOTATIONS = COLLECTION_LITERAL_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_ELEMENT = COLLECTION_LITERAL_PART__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNER = COLLECTION_LITERAL_PART__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_COMMENT = COLLECTION_LITERAL_PART__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__VISIBILITY = COLLECTION_LITERAL_PART__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__QUALIFIED_NAME = COLLECTION_LITERAL_PART__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__CLIENT_DEPENDENCY = COLLECTION_LITERAL_PART__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__NAMESPACE = COLLECTION_LITERAL_PART__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__NAME_EXPRESSION = COLLECTION_LITERAL_PART__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.CollectionLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionLiteralExp()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP = 24;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_ELEMENT = LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNER = LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__VISIBILITY = LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__QUALIFIED_NAME = LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__CLIENT_DEPENDENCY = LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAMESPACE = LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAME_EXPRESSION = LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__SIMPLE_RANGE = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.CollectionRangeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionRange()
	 * @generated
	 */
	int COLLECTION_RANGE = 25;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__EANNOTATIONS = COLLECTION_LITERAL_PART__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_ELEMENT = COLLECTION_LITERAL_PART__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNER = COLLECTION_LITERAL_PART__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_COMMENT = COLLECTION_LITERAL_PART__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__VISIBILITY = COLLECTION_LITERAL_PART__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__QUALIFIED_NAME = COLLECTION_LITERAL_PART__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__CLIENT_DEPENDENCY = COLLECTION_LITERAL_PART__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__NAMESPACE = COLLECTION_LITERAL_PART__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__NAME_EXPRESSION = COLLECTION_LITERAL_PART__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.EnumLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getEnumLiteralExp()
	 * @generated
	 */
	int ENUM_LITERAL_EXP = 26;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_ELEMENT = LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNER = LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__VISIBILITY = LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__QUALIFIED_NAME = LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__CLIENT_DEPENDENCY = LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAMESPACE = LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAME_EXPRESSION = LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.IfExpImpl <em>If Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.IfExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIfExp()
	 * @generated
	 */
	int IF_EXP = 27;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.NumericLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getNumericLiteralExp()
	 * @generated
	 */
	int NUMERIC_LITERAL_EXP = 29;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_ELEMENT = PRIMITIVE_LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNER = PRIMITIVE_LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__VISIBILITY = PRIMITIVE_LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__QUALIFIED_NAME = PRIMITIVE_LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__CLIENT_DEPENDENCY = PRIMITIVE_LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__NAMESPACE = PRIMITIVE_LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__NAME_EXPRESSION = PRIMITIVE_LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

	/**
	 * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.IntegerLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 28;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_ELEMENT = NUMERIC_LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNER = NUMERIC_LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__VISIBILITY = NUMERIC_LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__QUALIFIED_NAME = NUMERIC_LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__CLIENT_DEPENDENCY = NUMERIC_LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAMESPACE = NUMERIC_LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAME_EXPRESSION = NUMERIC_LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.UnlimitedNaturalLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getUnlimitedNaturalLiteralExp()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP = 30;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ELEMENT = NUMERIC_LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNER = NUMERIC_LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__VISIBILITY = NUMERIC_LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__QUALIFIED_NAME = NUMERIC_LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__CLIENT_DEPENDENCY = NUMERIC_LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__NAMESPACE = NUMERIC_LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__NAME_EXPRESSION = NUMERIC_LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unlimited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unlimited Natural Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.InvalidLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getInvalidLiteralExp()
	 * @generated
	 */
	int INVALID_LITERAL_EXP = 31;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_ELEMENT = LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNER = LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__VISIBILITY = LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__QUALIFIED_NAME = LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__CLIENT_DEPENDENCY = LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__NAMESPACE = LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__NAME_EXPRESSION = LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The number of structural features of the '<em>Invalid Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.LoopExpImpl <em>Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.LoopExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getLoopExp()
	 * @generated
	 */
	int LOOP_EXP = 33;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__EANNOTATIONS = CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_ELEMENT = CALL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNER = CALL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_COMMENT = CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__VISIBILITY = CALL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__QUALIFIED_NAME = CALL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__CLIENT_DEPENDENCY = CALL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAMESPACE = CALL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAME_EXPRESSION = CALL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__START_POSITION = CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__END_POSITION = CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__BODY = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__ITERATOR = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.IterateExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIterateExp()
	 * @generated
	 */
	int ITERATE_EXP = 32;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__EANNOTATIONS = LOOP_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_ELEMENT = LOOP_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNER = LOOP_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_COMMENT = LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__VISIBILITY = LOOP_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__QUALIFIED_NAME = LOOP_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__CLIENT_DEPENDENCY = LOOP_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAMESPACE = LOOP_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAME_EXPRESSION = LOOP_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__START_POSITION = LOOP_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__END_POSITION = LOOP_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.IteratorExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIteratorExp()
	 * @generated
	 */
	int ITERATOR_EXP = 34;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__EANNOTATIONS = LOOP_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_ELEMENT = LOOP_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNER = LOOP_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_COMMENT = LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__VISIBILITY = LOOP_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__QUALIFIED_NAME = LOOP_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__CLIENT_DEPENDENCY = LOOP_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAMESPACE = LOOP_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAME_EXPRESSION = LOOP_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__START_POSITION = LOOP_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__END_POSITION = LOOP_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
	 * The number of structural features of the '<em>Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.LetExpImpl <em>Let Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.LetExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getLetExp()
	 * @generated
	 */
	int LET_EXP = 35;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.MessageExpImpl <em>Message Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.MessageExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getMessageExp()
	 * @generated
	 */
	int MESSAGE_EXP = 36;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__ARGUMENT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__CALLED_OPERATION = OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__SENT_SIGNAL = OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.NullLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getNullLiteralExp()
	 * @generated
	 */
	int NULL_LITERAL_EXP = 37;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_ELEMENT = LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNER = LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__VISIBILITY = LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__QUALIFIED_NAME = LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__CLIENT_DEPENDENCY = LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__NAMESPACE = LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__NAME_EXPRESSION = LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The number of structural features of the '<em>Null Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.OperationCallExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 38;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__EANNOTATIONS = FEATURE_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_ELEMENT = FEATURE_CALL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNER = FEATURE_CALL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_COMMENT = FEATURE_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__VISIBILITY = FEATURE_CALL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__QUALIFIED_NAME = FEATURE_CALL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__CLIENT_DEPENDENCY = FEATURE_CALL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAMESPACE = FEATURE_CALL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAME_EXPRESSION = FEATURE_CALL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TYPE = FEATURE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__ARGUMENT = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OPERATION_CODE = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.PropertyCallExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPropertyCallExp()
	 * @generated
	 */
	int PROPERTY_CALL_EXP = 39;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__EANNOTATIONS = NAVIGATION_CALL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_ELEMENT = NAVIGATION_CALL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNER = NAVIGATION_CALL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__VISIBILITY = NAVIGATION_CALL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__QUALIFIED_NAME = NAVIGATION_CALL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__CLIENT_DEPENDENCY = NAVIGATION_CALL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAMESPACE = NAVIGATION_CALL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAME_EXPRESSION = NAVIGATION_CALL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.RealLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 40;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__EANNOTATIONS = NUMERIC_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_ELEMENT = NUMERIC_LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNER = NUMERIC_LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__VISIBILITY = NUMERIC_LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__QUALIFIED_NAME = NUMERIC_LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__CLIENT_DEPENDENCY = NUMERIC_LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAMESPACE = NUMERIC_LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAME_EXPRESSION = NUMERIC_LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.StateExpImpl <em>State Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.StateExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getStateExp()
	 * @generated
	 */
	int STATE_EXP = 41;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Referred State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__REFERRED_STATE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.StringLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 42;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__EANNOTATIONS = PRIMITIVE_LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_ELEMENT = PRIMITIVE_LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNER = PRIMITIVE_LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__VISIBILITY = PRIMITIVE_LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__QUALIFIED_NAME = PRIMITIVE_LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__CLIENT_DEPENDENCY = PRIMITIVE_LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAMESPACE = PRIMITIVE_LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAME_EXPRESSION = PRIMITIVE_LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.TupleLiteralExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleLiteralExp()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP = 43;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__EANNOTATIONS = LITERAL_EXP__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_ELEMENT = LITERAL_EXP__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNER = LITERAL_EXP__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__VISIBILITY = LITERAL_EXP__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__QUALIFIED_NAME = LITERAL_EXP__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__CLIENT_DEPENDENCY = LITERAL_EXP__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAMESPACE = LITERAL_EXP__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAME_EXPRESSION = LITERAL_EXP__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.TupleLiteralPartImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleLiteralPart()
	 * @generated
	 */
	int TUPLE_LITERAL_PART = 44;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNER = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__TYPE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__START_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__END_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__TYPE_START_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__TYPE_END_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__VALUE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TypeExpImpl <em>Type Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.TypeExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTypeExp()
	 * @generated
	 */
	int TYPE_EXP = 45;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__REFERRED_TYPE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.UnspecifiedValueExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getUnspecifiedValueExp()
	 * @generated
	 */
	int UNSPECIFIED_VALUE_EXP = 46;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.VariableImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 47;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNER = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__START_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__END_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE_START_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE_END_POSITION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INIT_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__REPRESENTED_PARAMETER = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.VariableExpImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 48;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__EANNOTATIONS = OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_ELEMENT = OCL_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNER = OCL_EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__VISIBILITY = OCL_EXPRESSION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__QUALIFIED_NAME = OCL_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__CLIENT_DEPENDENCY = OCL_EXPRESSION__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAMESPACE = OCL_EXPRESSION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAME_EXPRESSION = OCL_EXPRESSION__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl
	 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTemplateParameterType()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_TYPE = 49;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

	/**
	 * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

	/**
	 * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

	/**
	 * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

	/**
	 * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__SPECIFICATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * This value may change when the model code is regenerated.
	 * It is subject to change without notice.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.ocl.uml.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.AnyType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.uml.AnyType#getOwnedOperations()
	 * @see #getAnyType()
	 * @generated
	 */
	EReference getAnyType_OwnedOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.ocl.uml.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.VoidType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.uml.VoidType#getOwnedOperations()
	 * @see #getVoidType()
	 * @generated
	 */
	EReference getVoidType_OwnedOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.InvalidType <em>Invalid Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Type</em>'.
	 * @see org.eclipse.ocl.uml.InvalidType
	 * @generated
	 */
	EClass getInvalidType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.InvalidType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.uml.InvalidType#getOwnedOperations()
	 * @see #getInvalidType()
	 * @generated
	 */
	EReference getInvalidType_OwnedOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.ElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Type</em>'.
	 * @see org.eclipse.ocl.uml.ElementType
	 * @generated
	 */
	EClass getElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Type</em>'.
	 * @see org.eclipse.ocl.uml.TypeType
	 * @generated
	 */
	EClass getTypeType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.TypeType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.uml.TypeType#getOwnedOperations()
	 * @see #getTypeType()
	 * @generated
	 */
	EReference getTypeType_OwnedOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Type</em>'.
	 * @see org.eclipse.ocl.uml.MessageType
	 * @generated
	 */
	EClass getMessageType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.MessageType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.uml.MessageType#getOwnedOperations()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_OwnedOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.MessageType#getOwnedAttributes <em>Owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attribute</em>'.
	 * @see org.eclipse.ocl.uml.MessageType#getOwnedAttributes()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_OwnedAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.ocl.uml.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.ocl.uml.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.eclipse.ocl.uml.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.eclipse.ocl.uml.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.eclipse.ocl.uml.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.eclipse.ocl.uml.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.eclipse.ocl.uml.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression In OCL</em>'.
	 * @see org.eclipse.ocl.uml.ExpressionInOCL
	 * @generated
	 */
	EClass getExpressionInOCL();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Call Exp</em>'.
	 * @see org.eclipse.ocl.uml.AssociationClassCallExp
	 * @generated
	 */
	EClass getAssociationClassCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Call Exp</em>'.
	 * @see org.eclipse.ocl.uml.NavigationCallExp
	 * @generated
	 */
	EClass getNavigationCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call Exp</em>'.
	 * @see org.eclipse.ocl.uml.FeatureCallExp
	 * @generated
	 */
	EClass getFeatureCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.eclipse.ocl.uml.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Expression</em>'.
	 * @see org.eclipse.ocl.uml.OCLExpression
	 * @generated
	 */
	EClass getOCLExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.PrimitiveLiteralExp
	 * @generated
	 */
	EClass getPrimitiveLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.eclipse.ocl.uml.CollectionItem
	 * @generated
	 */
	EClass getCollectionItem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.eclipse.ocl.uml.CollectionLiteralPart
	 * @generated
	 */
	EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.eclipse.ocl.uml.CollectionRange
	 * @generated
	 */
	EClass getCollectionRange();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.EnumLiteralExp
	 * @generated
	 */
	EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp</em>'.
	 * @see org.eclipse.ocl.uml.IfExp
	 * @generated
	 */
	EClass getIfExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.NumericLiteralExp
	 * @generated
	 */
	EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.UnlimitedNaturalLiteralExp
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.InvalidLiteralExp
	 * @generated
	 */
	EClass getInvalidLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp</em>'.
	 * @see org.eclipse.ocl.uml.IterateExp
	 * @generated
	 */
	EClass getIterateExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp</em>'.
	 * @see org.eclipse.ocl.uml.LoopExp
	 * @generated
	 */
	EClass getLoopExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Exp</em>'.
	 * @see org.eclipse.ocl.uml.IteratorExp
	 * @generated
	 */
	EClass getIteratorExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see org.eclipse.ocl.uml.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Exp</em>'.
	 * @see org.eclipse.ocl.uml.MessageExp
	 * @generated
	 */
	EClass getMessageExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.NullLiteralExp
	 * @generated
	 */
	EClass getNullLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.uml.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.ocl.uml.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Exp</em>'.
	 * @see org.eclipse.ocl.uml.StateExp
	 * @generated
	 */
	EClass getStateExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp</em>'.
	 * @see org.eclipse.ocl.uml.TupleLiteralExp
	 * @generated
	 */
	EClass getTupleLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part</em>'.
	 * @see org.eclipse.ocl.uml.TupleLiteralPart
	 * @generated
	 */
	EClass getTupleLiteralPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Exp</em>'.
	 * @see org.eclipse.ocl.uml.TypeExp
	 * @generated
	 */
	EClass getTypeExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Value Exp</em>'.
	 * @see org.eclipse.ocl.uml.UnspecifiedValueExp
	 * @generated
	 */
	EClass getUnspecifiedValueExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.ocl.uml.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.eclipse.ocl.uml.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.uml.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Type</em>'.
	 * @see org.eclipse.ocl.uml.TemplateParameterType
	 * @generated
	 */
	EClass getTemplateParameterType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.TemplateParameterType#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.uml.TemplateParameterType#getOwnedOperations()
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	EReference getTemplateParameterType_OwnedOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UMLFactory getUMLFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.AnyTypeImpl <em>Any Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.AnyTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getAnyType()
		 * @generated
		 */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANY_TYPE__OWNED_OPERATION = eINSTANCE
			.getAnyType_OwnedOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.VoidTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOID_TYPE__OWNED_OPERATION = eINSTANCE
			.getVoidType_OwnedOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.InvalidTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getInvalidType()
		 * @generated
		 */
		EClass INVALID_TYPE = eINSTANCE.getInvalidType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVALID_TYPE__OWNED_OPERATION = eINSTANCE
			.getInvalidType_OwnedOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.ElementTypeImpl <em>Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.ElementTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getElementType()
		 * @generated
		 */
		EClass ELEMENT_TYPE = eINSTANCE.getElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.TypeTypeImpl <em>Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.TypeTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTypeType()
		 * @generated
		 */
		EClass TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TYPE__OWNED_OPERATION = eINSTANCE
			.getTypeType_OwnedOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.MessageTypeImpl <em>Message Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.MessageTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getMessageType()
		 * @generated
		 */
		EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__OWNED_OPERATION = eINSTANCE
			.getMessageType_OwnedOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__OWNED_ATTRIBUTE = eINSTANCE
			.getMessageType_OwnedAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.PrimitiveTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.CollectionTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.TupleTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleType()
		 * @generated
		 */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.BagTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.SetTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.OrderedSetTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.SequenceTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.ExpressionInOCLImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getExpressionInOCL()
		 * @generated
		 */
		EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.AssociationClassCallExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getAssociationClassCallExp()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS_CALL_EXP = eINSTANCE
			.getAssociationClassCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.NavigationCallExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getNavigationCallExp()
		 * @generated
		 */
		EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.FeatureCallExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getFeatureCallExp()
		 * @generated
		 */
		EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.CallExpImpl <em>Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.CallExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.OCLExpressionImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOCLExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.BooleanLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.PrimitiveLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPrimitiveLiteralExp()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.LiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.CollectionItemImpl <em>Collection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.CollectionItemImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionItem()
		 * @generated
		 */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.CollectionLiteralPartImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionLiteralPart()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.CollectionLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.CollectionRangeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionRange()
		 * @generated
		 */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.EnumLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getEnumLiteralExp()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.IfExpImpl <em>If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.IfExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIfExp()
		 * @generated
		 */
		EClass IF_EXP = eINSTANCE.getIfExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.IntegerLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.NumericLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getNumericLiteralExp()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.UnlimitedNaturalLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getUnlimitedNaturalLiteralExp()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE
			.getUnlimitedNaturalLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.InvalidLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getInvalidLiteralExp()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.IterateExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIterateExp()
		 * @generated
		 */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.LoopExpImpl <em>Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.LoopExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getLoopExp()
		 * @generated
		 */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.IteratorExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getIteratorExp()
		 * @generated
		 */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.LetExpImpl <em>Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.LetExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.MessageExpImpl <em>Message Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.MessageExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getMessageExp()
		 * @generated
		 */
		EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.NullLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getNullLiteralExp()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.OperationCallExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.PropertyCallExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.RealLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.StateExpImpl <em>State Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.StateExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getStateExp()
		 * @generated
		 */
		EClass STATE_EXP = eINSTANCE.getStateExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.StringLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.TupleLiteralExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleLiteralExp()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.TupleLiteralPartImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleLiteralPart()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.TypeExpImpl <em>Type Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.TypeExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTypeExp()
		 * @generated
		 */
		EClass TYPE_EXP = eINSTANCE.getTypeExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.UnspecifiedValueExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getUnspecifiedValueExp()
		 * @generated
		 */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.VariableImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.VariableExpImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 3.0
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.uml.impl.TemplateParameterTypeImpl
		 * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTemplateParameterType()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_TYPE = eINSTANCE.getTemplateParameterType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * @since 3.0
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION = eINSTANCE
			.getTemplateParameterType_OwnedOperation();

	}

} //UMLPackage
