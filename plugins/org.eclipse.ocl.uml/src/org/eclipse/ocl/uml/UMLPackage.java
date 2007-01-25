/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLPackage.java,v 1.1 2007/01/25 18:39:26 cdamus Exp $
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
public interface UMLPackage extends EPackage {
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
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UMLPackage eINSTANCE = org.eclipse.ocl.uml.impl.UMLPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.AnyTypeImpl <em>Any Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.AnyTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getAnyType()
     * @generated
     */
    int ANY_TYPE = 0;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE__OWNED_OPERATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Any Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANY_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.VoidTypeImpl <em>Void Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.VoidTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getVoidType()
     * @generated
     */
    int VOID_TYPE = 1;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE__OWNED_OPERATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Void Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VOID_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.InvalidTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getInvalidType()
     * @generated
     */
    int INVALID_TYPE = 2;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE__OWNED_OPERATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Invalid Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INVALID_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.ElementTypeImpl <em>Element Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.ElementTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getElementType()
     * @generated
     */
    int ELEMENT_TYPE = 3;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

    /**
     * The number of structural features of the '<em>Element Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TypeTypeImpl <em>Type Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.TypeTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTypeType()
     * @generated
     */
    int TYPE_TYPE = 4;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

    /**
     * The feature id for the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REFERRED_TYPE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE__OWNED_OPERATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Type Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.MessageTypeImpl <em>Message Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.MessageTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getMessageType()
     * @generated
     */
    int MESSAGE_TYPE = 5;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER__USE_CASE;

    /**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REFERRED_OPERATION = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Referred Signal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REFERRED_SIGNAL = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_OPERATIONS = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__OWNED_ATTRIBUTES = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Message Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.CLASSIFIER_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.PrimitiveTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getPrimitiveType()
     * @generated
     */
    int PRIMITIVE_TYPE = 6;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE__OWNED_OPERATION;

    /**
     * The number of structural features of the '<em>Primitive Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.PRIMITIVE_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.CollectionTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getCollectionType()
     * @generated
     */
    int COLLECTION_TYPE = 7;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_OPERATION;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__START_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__END_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TYPE_START_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TYPE_END_POSITION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ELEMENT_TYPE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__KIND = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Collection Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.TupleTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getTupleType()
     * @generated
     */
    int TUPLE_TYPE = 8;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ELEMENT_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__PACKAGE_IMPORT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_RULE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__IMPORTED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__IS_LEAF = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__REDEFINED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__REDEFINITION_CONTEXT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__PACKAGE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__TEMPLATE_BINDING = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_TEMPLATE_SIGNATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__IS_ABSTRACT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__GENERALIZATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__POWERTYPE_EXTENT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__FEATURE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INHERITED_MEMBER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__REDEFINED_CLASSIFIER = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__GENERAL = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__SUBSTITUTION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__REPRESENTATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__COLLABORATION_USE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__USE_CASE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_ATTRIBUTE = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__OWNED_OPERATION = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE__OWNED_OPERATION;

    /**
     * The number of structural features of the '<em>Tuple Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TUPLE_TYPE_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.BagTypeImpl <em>Bag Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.BagTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getBagType()
     * @generated
     */
    int BAG_TYPE = 9;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNER = COLLECTION_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Bag Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.SetTypeImpl <em>Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.SetTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getSetType()
     * @generated
     */
    int SET_TYPE = 10;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNER = COLLECTION_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Set Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.OrderedSetTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getOrderedSetType()
     * @generated
     */
    int ORDERED_SET_TYPE = 11;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNER = COLLECTION_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Ordered Set Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.SequenceTypeImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getSequenceType()
     * @generated
     */
    int SEQUENCE_TYPE = 12;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_ELEMENT = COLLECTION_TYPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNER = COLLECTION_TYPE__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__VISIBILITY = COLLECTION_TYPE__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__QUALIFIED_NAME = COLLECTION_TYPE__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__CLIENT_DEPENDENCY = COLLECTION_TYPE__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__NAME_EXPRESSION = COLLECTION_TYPE__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ELEMENT_IMPORT = COLLECTION_TYPE__ELEMENT_IMPORT;

    /**
     * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__PACKAGE_IMPORT = COLLECTION_TYPE__PACKAGE_IMPORT;

    /**
     * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

    /**
     * The feature id for the '<em><b>Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__MEMBER = COLLECTION_TYPE__MEMBER;

    /**
     * The feature id for the '<em><b>Imported Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__IMPORTED_MEMBER = COLLECTION_TYPE__IMPORTED_MEMBER;

    /**
     * The feature id for the '<em><b>Owned Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_MEMBER = COLLECTION_TYPE__OWNED_MEMBER;

    /**
     * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__IS_LEAF = COLLECTION_TYPE__IS_LEAF;

    /**
     * The feature id for the '<em><b>Redefined Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__REDEFINED_ELEMENT = COLLECTION_TYPE__REDEFINED_ELEMENT;

    /**
     * The feature id for the '<em><b>Redefinition Context</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__REDEFINITION_CONTEXT = COLLECTION_TYPE__REDEFINITION_CONTEXT;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Package</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

    /**
     * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

    /**
     * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

    /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

    /**
     * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__GENERALIZATION = COLLECTION_TYPE__GENERALIZATION;

    /**
     * The feature id for the '<em><b>Powertype Extent</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__POWERTYPE_EXTENT = COLLECTION_TYPE__POWERTYPE_EXTENT;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__FEATURE = COLLECTION_TYPE__FEATURE;

    /**
     * The feature id for the '<em><b>Inherited Member</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INHERITED_MEMBER = COLLECTION_TYPE__INHERITED_MEMBER;

    /**
     * The feature id for the '<em><b>Redefined Classifier</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__REDEFINED_CLASSIFIER = COLLECTION_TYPE__REDEFINED_CLASSIFIER;

    /**
     * The feature id for the '<em><b>General</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__GENERAL = COLLECTION_TYPE__GENERAL;

    /**
     * The feature id for the '<em><b>Substitution</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__SUBSTITUTION = COLLECTION_TYPE__SUBSTITUTION;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ATTRIBUTE = COLLECTION_TYPE__ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Representation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__REPRESENTATION = COLLECTION_TYPE__REPRESENTATION;

    /**
     * The feature id for the '<em><b>Collaboration Use</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__COLLABORATION_USE = COLLECTION_TYPE__COLLABORATION_USE;

    /**
     * The feature id for the '<em><b>Owned Use Case</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_USE_CASE = COLLECTION_TYPE__OWNED_USE_CASE;

    /**
     * The feature id for the '<em><b>Use Case</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__USE_CASE = COLLECTION_TYPE__USE_CASE;

    /**
     * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Sequence Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ocl.uml.impl.ExpressionInOCLImpl
     * @see org.eclipse.ocl.uml.impl.UMLPackageImpl#getExpressionInOCL()
     * @generated
     */
    int EXPRESSION_IN_OCL = 13;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__EANNOTATIONS = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__OWNED_ELEMENT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Owner</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__OWNER = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNER;

    /**
     * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__OWNED_COMMENT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNED_COMMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__NAME = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__VISIBILITY = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__VISIBILITY;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__QUALIFIED_NAME = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__QUALIFIED_NAME;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__CLIENT_DEPENDENCY = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__NAMESPACE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__NAMESPACE;

    /**
     * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__NAME_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Template Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__TEMPLATE_PARAMETER = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__TYPE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__TYPE;

    /**
     * The feature id for the '<em><b>Body</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__BODY = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__BODY;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__LANGUAGE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__LANGUAGE;

    /**
     * The feature id for the '<em><b>Result</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__RESULT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__RESULT;

    /**
     * The feature id for the '<em><b>Behavior</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__BEHAVIOR = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION__BEHAVIOR;

    /**
     * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__BODY_EXPRESSION = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Context Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__CONTEXT_VARIABLE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__RESULT_VARIABLE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Parameter Variable</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__PARAMETER_VARIABLE = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Expression In OCL</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL_FEATURE_COUNT = org.eclipse.uml2.uml.UMLPackage.OPAQUE_EXPRESSION_FEATURE_COUNT + 4;


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
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.AnyType#getOwnedOperations <em>Owned Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
     * @see org.eclipse.ocl.uml.AnyType#getOwnedOperations()
     * @see #getAnyType()
     * @generated
     */
    EReference getAnyType_OwnedOperations();

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
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.VoidType#getOwnedOperations <em>Owned Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
     * @see org.eclipse.ocl.uml.VoidType#getOwnedOperations()
     * @see #getVoidType()
     * @generated
     */
    EReference getVoidType_OwnedOperations();

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
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.InvalidType#getOwnedOperations <em>Owned Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
     * @see org.eclipse.ocl.uml.InvalidType#getOwnedOperations()
     * @see #getInvalidType()
     * @generated
     */
    EReference getInvalidType_OwnedOperations();

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
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.TypeType#getOwnedOperations <em>Owned Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
     * @see org.eclipse.ocl.uml.TypeType#getOwnedOperations()
     * @see #getTypeType()
     * @generated
     */
    EReference getTypeType_OwnedOperations();

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
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.MessageType#getOwnedOperations <em>Owned Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
     * @see org.eclipse.ocl.uml.MessageType#getOwnedOperations()
     * @see #getMessageType()
     * @generated
     */
    EReference getMessageType_OwnedOperations();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.uml.MessageType#getOwnedAttributes <em>Owned Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
     * @see org.eclipse.ocl.uml.MessageType#getOwnedAttributes()
     * @see #getMessageType()
     * @generated
     */
    EReference getMessageType_OwnedAttributes();

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
         * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ANY_TYPE__OWNED_OPERATIONS = eINSTANCE.getAnyType_OwnedOperations();

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
         * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VOID_TYPE__OWNED_OPERATIONS = eINSTANCE.getVoidType_OwnedOperations();

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
         * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INVALID_TYPE__OWNED_OPERATIONS = eINSTANCE.getInvalidType_OwnedOperations();

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
         * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TYPE_TYPE__OWNED_OPERATIONS = eINSTANCE.getTypeType_OwnedOperations();

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
         * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MESSAGE_TYPE__OWNED_OPERATIONS = eINSTANCE.getMessageType_OwnedOperations();

        /**
         * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MESSAGE_TYPE__OWNED_ATTRIBUTES = eINSTANCE.getMessageType_OwnedAttributes();

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

    }

} //UMLPackage
