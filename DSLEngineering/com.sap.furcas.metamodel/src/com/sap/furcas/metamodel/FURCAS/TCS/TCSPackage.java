/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

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
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory
 * @model kind="package"
 * @generated
 */
public interface TCSPackage extends EPackage {
        /**
     * The package name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        String eNAME = "TCS";

        /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        String eNS_URI = "http://www.furcas.org/TCS";

        /**
     * The package namespace name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        String eNS_PREFIX = "com.sap.furcas.TCS";

        /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        TCSPackage eINSTANCE = com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl.init();

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LocatedElementImpl <em>Located Element</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LocatedElementImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLocatedElement()
     * @generated
     */
        int LOCATED_ELEMENT = 0;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOCATED_ELEMENT__LOCATION = 0;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOCATED_ELEMENT__COMMENTS_BEFORE = 1;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOCATED_ELEMENT__COMMENTS_AFTER = 2;

        /**
     * The number of structural features of the '<em>Located Element</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOCATED_ELEMENT_FEATURE_COUNT = 3;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.NamedElementImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getNamedElement()
     * @generated
     */
        int NAMED_ELEMENT = 1;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NAMED_ELEMENT__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NAMED_ELEMENT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NAMED_ELEMENT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NAMED_ELEMENT__NAME = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NAMED_ELEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getConcreteSyntax()
     * @generated
     */
        int CONCRETE_SYNTAX = 2;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__LOCATION = NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__COMMENTS_BEFORE = NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__COMMENTS_AFTER = NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__NAME = NAMED_ELEMENT__NAME;

        /**
     * The feature id for the '<em><b>K</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__K = NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Templates</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__TEMPLATES = NAMED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Keywords</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__KEYWORDS = NAMED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Symbols</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__SYMBOLS = NAMED_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Operator Lists</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__OPERATOR_LISTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

        /**
     * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__TOKENS = NAMED_ELEMENT_FEATURE_COUNT + 5;

        /**
     * The feature id for the '<em><b>Lexer</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX__LEXER = NAMED_ELEMENT_FEATURE_COUNT + 6;

        /**
     * The number of structural features of the '<em>Concrete Syntax</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONCRETE_SYNTAX_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QualifiedNamedElementImpl <em>Qualified Named Element</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.QualifiedNamedElementImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getQualifiedNamedElement()
     * @generated
     */
        int QUALIFIED_NAMED_ELEMENT = 69;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUALIFIED_NAMED_ELEMENT__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUALIFIED_NAMED_ELEMENT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUALIFIED_NAMED_ELEMENT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUALIFIED_NAMED_ELEMENT__NAMES = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUALIFIED_NAMED_ELEMENT__META_REFERENCE = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Qualified Named Element</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl <em>Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getTemplate()
     * @generated
     */
        int TEMPLATE = 3;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__LOCATION = QUALIFIED_NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__COMMENTS_BEFORE = QUALIFIED_NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__COMMENTS_AFTER = QUALIFIED_NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__NAMES = QUALIFIED_NAMED_ELEMENT__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__META_REFERENCE = QUALIFIED_NAMED_ELEMENT__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__CONCRETE_SYNTAX = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__DISAMBIGUATE = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE__DISAMBIGUATE_V3 = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TEMPLATE__SEM_DISAMBIGUATE = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 3;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TEMPLATE__TEXT_BLOCK_DEFINITION = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 4;

								/**
     * The number of structural features of the '<em>Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TEMPLATE_FEATURE_COUNT = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 5;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionTemplateImpl <em>Function Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionTemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getFunctionTemplate()
     * @generated
     */
        int FUNCTION_TEMPLATE = 4;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__LOCATION = TEMPLATE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__COMMENTS_BEFORE = TEMPLATE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__COMMENTS_AFTER = TEMPLATE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__NAMES = TEMPLATE__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__META_REFERENCE = TEMPLATE__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__CONCRETE_SYNTAX = TEMPLATE__CONCRETE_SYNTAX;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__DISAMBIGUATE = TEMPLATE__DISAMBIGUATE;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__DISAMBIGUATE_V3 = TEMPLATE__DISAMBIGUATE_V3;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_TEMPLATE__SEM_DISAMBIGUATE = TEMPLATE__SEM_DISAMBIGUATE;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_TEMPLATE__TEXT_BLOCK_DEFINITION = TEMPLATE__TEXT_BLOCK_DEFINITION;

								/**
     * The feature id for the '<em><b>Function Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__FUNCTION_NAME = TEMPLATE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Function Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE__FUNCTION_SEQUENCE = TEMPLATE_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Function Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_TEMPLATE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl <em>Context Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getContextTemplate()
     * @generated
     */
        int CONTEXT_TEMPLATE = 77;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__LOCATION = TEMPLATE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__COMMENTS_BEFORE = TEMPLATE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__COMMENTS_AFTER = TEMPLATE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__NAMES = TEMPLATE__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__META_REFERENCE = TEMPLATE__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__CONCRETE_SYNTAX = TEMPLATE__CONCRETE_SYNTAX;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__DISAMBIGUATE = TEMPLATE__DISAMBIGUATE;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__DISAMBIGUATE_V3 = TEMPLATE__DISAMBIGUATE_V3;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_TEMPLATE__SEM_DISAMBIGUATE = TEMPLATE__SEM_DISAMBIGUATE;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_TEMPLATE__TEXT_BLOCK_DEFINITION = TEMPLATE__TEXT_BLOCK_DEFINITION;

								/**
     * The feature id for the '<em><b>Is Context</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__IS_CONTEXT = TEMPLATE_FEATURE_COUNT + 0;

								/**
     * The feature id for the '<em><b>Is Add To Context</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT = TEMPLATE_FEATURE_COUNT + 1;

								/**
     * The feature id for the '<em><b>Is Reference Only</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__IS_REFERENCE_ONLY = TEMPLATE_FEATURE_COUNT + 2;

								/**
     * The feature id for the '<em><b>Context Tags</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__CONTEXT_TAGS = TEMPLATE_FEATURE_COUNT + 3;

								/**
     * The feature id for the '<em><b>Scope</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE__SCOPE = TEMPLATE_FEATURE_COUNT + 4;

								/**
     * The feature id for the '<em><b>Template Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE = TEMPLATE_FEATURE_COUNT + 5;

                                /**
     * The number of structural features of the '<em>Context Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TEMPLATE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 6;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl <em>Class Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getClassTemplate()
     * @generated
     */
        int CLASS_TEMPLATE = 5;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__LOCATION = CONTEXT_TEMPLATE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__COMMENTS_BEFORE = CONTEXT_TEMPLATE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__COMMENTS_AFTER = CONTEXT_TEMPLATE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__NAMES = CONTEXT_TEMPLATE__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__META_REFERENCE = CONTEXT_TEMPLATE__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__CONCRETE_SYNTAX = CONTEXT_TEMPLATE__CONCRETE_SYNTAX;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__DISAMBIGUATE = CONTEXT_TEMPLATE__DISAMBIGUATE;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__DISAMBIGUATE_V3 = CONTEXT_TEMPLATE__DISAMBIGUATE_V3;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TEMPLATE__SEM_DISAMBIGUATE = CONTEXT_TEMPLATE__SEM_DISAMBIGUATE;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TEMPLATE__TEXT_BLOCK_DEFINITION = CONTEXT_TEMPLATE__TEXT_BLOCK_DEFINITION;

								/**
     * The feature id for the '<em><b>Is Context</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_CONTEXT = CONTEXT_TEMPLATE__IS_CONTEXT;

								/**
     * The feature id for the '<em><b>Is Add To Context</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_ADD_TO_CONTEXT = CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT;

								/**
     * The feature id for the '<em><b>Is Reference Only</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_REFERENCE_ONLY = CONTEXT_TEMPLATE__IS_REFERENCE_ONLY;

								/**
     * The feature id for the '<em><b>Context Tags</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__CONTEXT_TAGS = CONTEXT_TEMPLATE__CONTEXT_TAGS;

								/**
     * The feature id for the '<em><b>Scope</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__SCOPE = CONTEXT_TEMPLATE__SCOPE;

								/**
     * The feature id for the '<em><b>Template Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__TEMPLATE_SEQUENCE = CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE;

        /**
     * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__MODIFIERS = CONTEXT_TEMPLATE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_ABSTRACT = CONTEXT_TEMPLATE_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Is Deep</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_DEEP = CONTEXT_TEMPLATE_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Is Operatored</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_OPERATORED = CONTEXT_TEMPLATE_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Operator List</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__OPERATOR_LIST = CONTEXT_TEMPLATE_FEATURE_COUNT + 4;

        /**
     * The feature id for the '<em><b>Is Main</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_MAIN = CONTEXT_TEMPLATE_FEATURE_COUNT + 5;

        /**
     * The feature id for the '<em><b>Is Multi</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_MULTI = CONTEXT_TEMPLATE_FEATURE_COUNT + 6;

        /**
     * The feature id for the '<em><b>Is Non Primary</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__IS_NON_PRIMARY = CONTEXT_TEMPLATE_FEATURE_COUNT + 7;

        /**
     * The feature id for the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE__MODE = CONTEXT_TEMPLATE_FEATURE_COUNT + 8;

        /**
     * The number of structural features of the '<em>Class Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_TEMPLATE_FEATURE_COUNT = CONTEXT_TEMPLATE_FEATURE_COUNT + 9;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl <em>Primitive Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPrimitiveTemplate()
     * @generated
     */
        int PRIMITIVE_TEMPLATE = 6;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__LOCATION = TEMPLATE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__COMMENTS_BEFORE = TEMPLATE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__COMMENTS_AFTER = TEMPLATE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__NAMES = TEMPLATE__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__META_REFERENCE = TEMPLATE__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__CONCRETE_SYNTAX = TEMPLATE__CONCRETE_SYNTAX;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__DISAMBIGUATE = TEMPLATE__DISAMBIGUATE;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__DISAMBIGUATE_V3 = TEMPLATE__DISAMBIGUATE_V3;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TEMPLATE__SEM_DISAMBIGUATE = TEMPLATE__SEM_DISAMBIGUATE;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TEMPLATE__TEXT_BLOCK_DEFINITION = TEMPLATE__TEXT_BLOCK_DEFINITION;

								/**
     * The feature id for the '<em><b>Template Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__TEMPLATE_NAME = TEMPLATE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_TEMPLATE__DEFAULT = TEMPLATE_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Token Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__TOKEN_NAME = TEMPLATE_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__VALUE = TEMPLATE_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Serializer</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__SERIALIZER = TEMPLATE_FEATURE_COUNT + 4;

        /**
     * The feature id for the '<em><b>Or Keyword</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE__OR_KEYWORD = TEMPLATE_FEATURE_COUNT + 5;

        /**
     * The number of structural features of the '<em>Primitive Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_TEMPLATE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 6;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl <em>Operator Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOperatorTemplate()
     * @generated
     */
        int OPERATOR_TEMPLATE = 7;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__LOCATION = CONTEXT_TEMPLATE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__COMMENTS_BEFORE = CONTEXT_TEMPLATE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__COMMENTS_AFTER = CONTEXT_TEMPLATE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__NAMES = CONTEXT_TEMPLATE__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__META_REFERENCE = CONTEXT_TEMPLATE__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__CONCRETE_SYNTAX = CONTEXT_TEMPLATE__CONCRETE_SYNTAX;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__DISAMBIGUATE = CONTEXT_TEMPLATE__DISAMBIGUATE;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__DISAMBIGUATE_V3 = CONTEXT_TEMPLATE__DISAMBIGUATE_V3;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATOR_TEMPLATE__SEM_DISAMBIGUATE = CONTEXT_TEMPLATE__SEM_DISAMBIGUATE;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATOR_TEMPLATE__TEXT_BLOCK_DEFINITION = CONTEXT_TEMPLATE__TEXT_BLOCK_DEFINITION;

								/**
     * The feature id for the '<em><b>Is Context</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__IS_CONTEXT = CONTEXT_TEMPLATE__IS_CONTEXT;

								/**
     * The feature id for the '<em><b>Is Add To Context</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__IS_ADD_TO_CONTEXT = CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT;

								/**
     * The feature id for the '<em><b>Is Reference Only</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__IS_REFERENCE_ONLY = CONTEXT_TEMPLATE__IS_REFERENCE_ONLY;

								/**
     * The feature id for the '<em><b>Context Tags</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__CONTEXT_TAGS = CONTEXT_TEMPLATE__CONTEXT_TAGS;

								/**
     * The feature id for the '<em><b>Scope</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__SCOPE = CONTEXT_TEMPLATE__SCOPE;

								/**
     * The feature id for the '<em><b>Template Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATOR_TEMPLATE__TEMPLATE_SEQUENCE = CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE;

                                /**
     * The feature id for the '<em><b>Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__OPERATORS = CONTEXT_TEMPLATE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__SOURCE = CONTEXT_TEMPLATE_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Store Op To</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__STORE_OP_TO = CONTEXT_TEMPLATE_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Store Right To</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__STORE_RIGHT_TO = CONTEXT_TEMPLATE_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Store Operator To</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__STORE_OPERATOR_TO = CONTEXT_TEMPLATE_FEATURE_COUNT + 4;

        /**
     * The feature id for the '<em><b>Store Left Side To</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO = CONTEXT_TEMPLATE_FEATURE_COUNT + 5;

        /**
     * The feature id for the '<em><b>Store Right Side To</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO = CONTEXT_TEMPLATE_FEATURE_COUNT + 6;

        /**
     * The number of structural features of the '<em>Operator Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_TEMPLATE_FEATURE_COUNT = CONTEXT_TEMPLATE_FEATURE_COUNT + 7;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumerationTemplateImpl <em>Enumeration Template</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumerationTemplateImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEnumerationTemplate()
     * @generated
     */
        int ENUMERATION_TEMPLATE = 8;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__LOCATION = TEMPLATE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__COMMENTS_BEFORE = TEMPLATE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__COMMENTS_AFTER = TEMPLATE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Names</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__NAMES = TEMPLATE__NAMES;

        /**
     * The feature id for the '<em><b>Meta Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__META_REFERENCE = TEMPLATE__META_REFERENCE;

        /**
     * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__CONCRETE_SYNTAX = TEMPLATE__CONCRETE_SYNTAX;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__DISAMBIGUATE = TEMPLATE__DISAMBIGUATE;

        /**
     * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__DISAMBIGUATE_V3 = TEMPLATE__DISAMBIGUATE_V3;

        /**
     * The feature id for the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUMERATION_TEMPLATE__SEM_DISAMBIGUATE = TEMPLATE__SEM_DISAMBIGUATE;

								/**
     * The feature id for the '<em><b>Text Block Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENUMERATION_TEMPLATE__TEXT_BLOCK_DEFINITION = TEMPLATE__TEXT_BLOCK_DEFINITION;

								/**
     * The feature id for the '<em><b>Automatic</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__AUTOMATIC = TEMPLATE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE__MAPPINGS = TEMPLATE_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Enumeration Template</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUMERATION_TEMPLATE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralMappingImpl <em>Enum Literal Mapping</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralMappingImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEnumLiteralMapping()
     * @generated
     */
        int ENUM_LITERAL_MAPPING = 9;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_MAPPING__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_MAPPING__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_MAPPING__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Literal</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_MAPPING__LITERAL = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_MAPPING__ELEMENT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Enum Literal Mapping</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_MAPPING_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLiteral()
     * @generated
     */
        int LITERAL = 10;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__LOCATION = NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__COMMENTS_BEFORE = NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__COMMENTS_AFTER = NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__NAME = NAMED_ELEMENT__NAME;

        /**
     * The feature id for the '<em><b>Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__OPERATORS = NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Literal Refs</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__LITERAL_REFS = NAMED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The number of structural features of the '<em>Literal</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SymbolImpl <em>Symbol</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SymbolImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSymbol()
     * @generated
     */
        int SYMBOL = 11;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__LOCATION = LITERAL__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__COMMENTS_BEFORE = LITERAL__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__COMMENTS_AFTER = LITERAL__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__NAME = LITERAL__NAME;

        /**
     * The feature id for the '<em><b>Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__OPERATORS = LITERAL__OPERATORS;

        /**
     * The feature id for the '<em><b>Literal Refs</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__LITERAL_REFS = LITERAL__LITERAL_REFS;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__VALUE = LITERAL__VALUE;

        /**
     * The feature id for the '<em><b>Spaces</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL__SPACES = LITERAL_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Symbol</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SYMBOL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.KeywordImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getKeyword()
     * @generated
     */
        int KEYWORD = 12;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__LOCATION = LITERAL__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__COMMENTS_BEFORE = LITERAL__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__COMMENTS_AFTER = LITERAL__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__NAME = LITERAL__NAME;

        /**
     * The feature id for the '<em><b>Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__OPERATORS = LITERAL__OPERATORS;

        /**
     * The feature id for the '<em><b>Literal Refs</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__LITERAL_REFS = LITERAL__LITERAL_REFS;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD__VALUE = LITERAL__VALUE;

        /**
     * The number of structural features of the '<em>Keyword</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int KEYWORD_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorListImpl <em>Operator List</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorListImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOperatorList()
     * @generated
     */
        int OPERATOR_LIST = 13;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_LIST__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_LIST__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_LIST__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_LIST__NAME = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Priorities</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_LIST__PRIORITIES = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Operator List</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_LIST_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl <em>Priority</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPriority()
     * @generated
     */
        int PRIORITY = 14;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>List</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__LIST = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__VALUE = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Associativity</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__ASSOCIATIVITY = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Operators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY__OPERATORS = LOCATED_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The number of structural features of the '<em>Priority</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIORITY_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 4;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl <em>Operator</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOperator()
     * @generated
     */
        int OPERATOR = 15;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__LOCATION = NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__COMMENTS_BEFORE = NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__COMMENTS_AFTER = NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__NAME = NAMED_ELEMENT__NAME;

        /**
     * The feature id for the '<em><b>Postfix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATOR__POSTFIX = NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Arity</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__ARITY = NAMED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Literal</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__LITERAL = NAMED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Priority</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__PRIORITY = NAMED_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Templates</b></em>' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR__TEMPLATES = NAMED_ELEMENT_FEATURE_COUNT + 4;

        /**
     * The number of structural features of the '<em>Operator</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OPERATOR_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSequence()
     * @generated
     */
        int SEQUENCE = 16;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__ELEMENTS = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Template Container</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__TEMPLATE_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Prefix Container</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__PREFIX_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Function Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__FUNCTION_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Block Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__BLOCK_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 4;

        /**
     * The feature id for the '<em><b>Then Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__THEN_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 5;

        /**
     * The feature id for the '<em><b>Else Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__ELSE_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 6;

        /**
     * The feature id for the '<em><b>Separator Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__SEPARATOR_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 7;

        /**
     * The feature id for the '<em><b>Ot Container</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE__OT_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 8;

        /**
     * The number of structural features of the '<em>Sequence</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 9;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceElementImpl <em>Sequence Element</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceElementImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSequenceElement()
     * @generated
     */
        int SEQUENCE_ELEMENT = 17;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_ELEMENT__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_ELEMENT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_ELEMENT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_ELEMENT__ELEMENT_SEQUENCE = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_ELEMENT__PARENT_TEMPLATE = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Sequence Element</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_ELEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralRefImpl <em>Literal Ref</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralRefImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLiteralRef()
     * @generated
     */
        int LITERAL_REF = 18;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Referred Literal</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF__REFERRED_LITERAL = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Literal Ref</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LITERAL_REF_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getProperty()
     * @generated
     */
        int PROPERTY = 19;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Property Args</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__PROPERTY_ARGS = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY__PROPERTY_REFERENCE = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Property</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.CustomSeparatorImpl <em>Custom Separator</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.CustomSeparatorImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getCustomSeparator()
     * @generated
     */
        int CUSTOM_SEPARATOR = 20;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR__NAME = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Custom Separator</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CUSTOM_SEPARATOR_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getBlock()
     * @generated
     */
        int BLOCK = 21;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Block Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__BLOCK_SEQUENCE = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Block Args</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK__BLOCK_ARGS = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl <em>Conditional Element</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getConditionalElement()
     * @generated
     */
        int CONDITIONAL_ELEMENT = 22;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__CONDITION = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Then Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__THEN_SEQUENCE = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Else Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT__ELSE_SEQUENCE = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The number of structural features of the '<em>Conditional Element</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONDITIONAL_ELEMENT_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionImpl <em>Injector Action</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getInjectorAction()
     * @generated
     */
        int INJECTOR_ACTION = 79;

        /**
     * The feature id for the '<em><b>Injector Actions Block</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK = 0;

        /**
     * The number of structural features of the '<em>Injector Action</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTION_FEATURE_COUNT = 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyInitImpl <em>Property Init</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyInitImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyInit()
     * @generated
     */
        int PROPERTY_INIT = 80;

        /**
     * The feature id for the '<em><b>Injector Actions Block</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK = INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_INIT__PROPERTY_REFERENCE = INJECTOR_ACTION_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_INIT__VALUE = INJECTOR_ACTION_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_INIT__DEFAULT = INJECTOR_ACTION_FEATURE_COUNT + 2;

        /**
     * The number of structural features of the '<em>Property Init</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_INIT_FEATURE_COUNT = INJECTOR_ACTION_FEATURE_COUNT + 3;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitivePropertyInitImpl <em>Primitive Property Init</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitivePropertyInitImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPrimitivePropertyInit()
     * @generated
     */
        int PRIMITIVE_PROPERTY_INIT = 23;

        /**
     * The feature id for the '<em><b>Injector Actions Block</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK = PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_PROPERTY_INIT__PROPERTY_REFERENCE = PROPERTY_INIT__PROPERTY_REFERENCE;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_PROPERTY_INIT__VALUE = PROPERTY_INIT__VALUE;

        /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_PROPERTY_INIT__DEFAULT = PROPERTY_INIT__DEFAULT;

        /**
     * The number of structural features of the '<em>Primitive Property Init</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PRIMITIVE_PROPERTY_INIT_FEATURE_COUNT = PROPERTY_INIT_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AlternativeImpl <em>Alternative</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AlternativeImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAlternative()
     * @generated
     */
        int ALTERNATIVE = 24;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__SEQUENCES = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Is Multi</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE__IS_MULTI = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Alternative</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ALTERNATIVE_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionCallImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getFunctionCall()
     * @generated
     */
        int FUNCTION_CALL = 25;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Called Function</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL__CALLED_FUNCTION = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Function Call</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FUNCTION_CALL_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyArgImpl <em>Property Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyArg()
     * @generated
     */
        int PROPERTY_ARG = 26;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_ARG__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_ARG__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_ARG__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_ARG__PROPERTY = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Property Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_ARG_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToPArgImpl <em>Refers To PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRefersToPArg()
     * @generated
     */
        int REFERS_TO_PARG = 27;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_PARG__PROPERTY_NAME = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Refers To PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LookInPArgImpl <em>Look In PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LookInPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLookInPArg()
     * @generated
     */
        int LOOK_IN_PARG = 28;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOK_IN_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOK_IN_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOK_IN_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOK_IN_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOK_IN_PARG__PROPERTY_NAME = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Look In PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOK_IN_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateInPArgImpl <em>Create In PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateInPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getCreateInPArg()
     * @generated
     */
        int CREATE_IN_PARG = 29;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_IN_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_IN_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_IN_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_IN_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_IN_PARG__PROPERTY_NAME = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Create In PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_IN_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToKeyPArgImpl <em>Refers To Key PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToKeyPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRefersToKeyPArg()
     * @generated
     */
        int REFERS_TO_KEY_PARG = 30;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_KEY_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_KEY_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_KEY_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_KEY_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The number of structural features of the '<em>Refers To Key PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int REFERS_TO_KEY_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SeparatorPArgImpl <em>Separator PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SeparatorPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSeparatorPArg()
     * @generated
     */
        int SEPARATOR_PARG = 31;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEPARATOR_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEPARATOR_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEPARATOR_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEPARATOR_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Separator Sequence</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEPARATOR_PARG__SEPARATOR_SEQUENCE = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Separator PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEPARATOR_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AutoCreatePArgImpl <em>Auto Create PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AutoCreatePArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAutoCreatePArg()
     * @generated
     */
        int AUTO_CREATE_PARG = 32;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AUTO_CREATE_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AUTO_CREATE_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AUTO_CREATE_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AUTO_CREATE_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AUTO_CREATE_PARG__VALUE = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Auto Create PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AUTO_CREATE_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ImportContextPArgImpl <em>Import Context PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ImportContextPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getImportContextPArg()
     * @generated
     */
        int IMPORT_CONTEXT_PARG = 33;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IMPORT_CONTEXT_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IMPORT_CONTEXT_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IMPORT_CONTEXT_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IMPORT_CONTEXT_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The number of structural features of the '<em>Import Context PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IMPORT_CONTEXT_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedLowerPArgImpl <em>Forced Lower PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedLowerPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getForcedLowerPArg()
     * @generated
     */
        int FORCED_LOWER_PARG = 34;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_LOWER_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_LOWER_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_LOWER_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_LOWER_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_LOWER_PARG__VALUE = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Forced Lower PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_LOWER_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateAsPArgImpl <em>Create As PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateAsPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getCreateAsPArg()
     * @generated
     */
        int CREATE_AS_PARG = 35;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_AS_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_AS_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_AS_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_AS_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_AS_PARG__NAME = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Create As PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CREATE_AS_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AsPArgImpl <em>As PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AsPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAsPArg()
     * @generated
     */
        int AS_PARG = 36;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG__TEMPLATE = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG__VALUE = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>As PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AS_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ModePArgImpl <em>Mode PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ModePArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getModePArg()
     * @generated
     */
        int MODE_PARG = 37;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MODE_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MODE_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MODE_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MODE_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MODE_PARG__MODE = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Mode PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MODE_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockArgImpl <em>Block Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getBlockArg()
     * @generated
     */
        int BLOCK_ARG = 38;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK_ARG__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK_ARG__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK_ARG__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK_ARG__BLOCK = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Block Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BLOCK_ARG_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.NbNLBArgImpl <em>Nb NLB Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.NbNLBArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getNbNLBArg()
     * @generated
     */
        int NB_NLB_ARG = 39;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NB_NLB_ARG__LOCATION = BLOCK_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NB_NLB_ARG__COMMENTS_BEFORE = BLOCK_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NB_NLB_ARG__COMMENTS_AFTER = BLOCK_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NB_NLB_ARG__BLOCK = BLOCK_ARG__BLOCK;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NB_NLB_ARG__VALUE = BLOCK_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Nb NLB Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NB_NLB_ARG_FEATURE_COUNT = BLOCK_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.IndentIncrBArgImpl <em>Indent Incr BArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.IndentIncrBArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getIndentIncrBArg()
     * @generated
     */
        int INDENT_INCR_BARG = 40;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INDENT_INCR_BARG__LOCATION = BLOCK_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INDENT_INCR_BARG__COMMENTS_BEFORE = BLOCK_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INDENT_INCR_BARG__COMMENTS_AFTER = BLOCK_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INDENT_INCR_BARG__BLOCK = BLOCK_ARG__BLOCK;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INDENT_INCR_BARG__VALUE = BLOCK_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Indent Incr BArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INDENT_INCR_BARG_FEATURE_COUNT = BLOCK_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNLBArgImpl <em>Start NLB Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNLBArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStartNLBArg()
     * @generated
     */
        int START_NLB_ARG = 41;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NLB_ARG__LOCATION = BLOCK_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NLB_ARG__COMMENTS_BEFORE = BLOCK_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NLB_ARG__COMMENTS_AFTER = BLOCK_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NLB_ARG__BLOCK = BLOCK_ARG__BLOCK;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_NLB_ARG__VALUE = BLOCK_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Start NLB Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NLB_ARG_FEATURE_COUNT = BLOCK_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNbNLBArgImpl <em>Start Nb NLB Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNbNLBArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStartNbNLBArg()
     * @generated
     */
        int START_NB_NLB_ARG = 42;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NB_NLB_ARG__LOCATION = BLOCK_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NB_NLB_ARG__COMMENTS_BEFORE = BLOCK_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NB_NLB_ARG__COMMENTS_AFTER = BLOCK_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NB_NLB_ARG__BLOCK = BLOCK_ARG__BLOCK;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_NB_NLB_ARG__VALUE = BLOCK_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Start Nb NLB Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int START_NB_NLB_ARG_FEATURE_COUNT = BLOCK_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EndNLBArgImpl <em>End NLB Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EndNLBArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEndNLBArg()
     * @generated
     */
        int END_NLB_ARG = 43;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_NLB_ARG__LOCATION = BLOCK_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_NLB_ARG__COMMENTS_BEFORE = BLOCK_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_NLB_ARG__COMMENTS_AFTER = BLOCK_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_NLB_ARG__BLOCK = BLOCK_ARG__BLOCK;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_NLB_ARG__VALUE = BLOCK_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>End NLB Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_NLB_ARG_FEATURE_COUNT = BLOCK_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ExpressionImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getExpression()
     * @generated
     */
        int EXPRESSION = 44;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EXPRESSION__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EXPRESSION__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EXPRESSION__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Conditional Element</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EXPRESSION__CONDITIONAL_ELEMENT = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EXPRESSION_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AndExpImpl <em>And Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AndExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAndExp()
     * @generated
     */
        int AND_EXP = 45;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AND_EXP__LOCATION = EXPRESSION__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AND_EXP__COMMENTS_BEFORE = EXPRESSION__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AND_EXP__COMMENTS_AFTER = EXPRESSION__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Conditional Element</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AND_EXP__CONDITIONAL_ELEMENT = EXPRESSION__CONDITIONAL_ELEMENT;

        /**
     * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AND_EXP__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>And Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int AND_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl <em>Atom Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAtomExp()
     * @generated
     */
        int ATOM_EXP = 46;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>And Exp</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP__AND_EXP = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP__PROPERTY_NAME = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP__PROPERTY_REFERENCE = LOCATED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The number of structural features of the '<em>Atom Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ATOM_EXP_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 3;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EqualsExpImpl <em>Equals Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EqualsExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEqualsExp()
     * @generated
     */
        int EQUALS_EXP = 47;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__LOCATION = ATOM_EXP__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__COMMENTS_BEFORE = ATOM_EXP__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__COMMENTS_AFTER = ATOM_EXP__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>And Exp</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__AND_EXP = ATOM_EXP__AND_EXP;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__PROPERTY_NAME = ATOM_EXP__PROPERTY_NAME;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__PROPERTY_REFERENCE = ATOM_EXP__PROPERTY_REFERENCE;

        /**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP__VALUE = ATOM_EXP_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Equals Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int EQUALS_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BooleanPropertyExpImpl <em>Boolean Property Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.BooleanPropertyExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getBooleanPropertyExp()
     * @generated
     */
        int BOOLEAN_PROPERTY_EXP = 48;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP__LOCATION = ATOM_EXP__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP__COMMENTS_BEFORE = ATOM_EXP__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP__COMMENTS_AFTER = ATOM_EXP__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>And Exp</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP__AND_EXP = ATOM_EXP__AND_EXP;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP__PROPERTY_NAME = ATOM_EXP__PROPERTY_NAME;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP__PROPERTY_REFERENCE = ATOM_EXP__PROPERTY_REFERENCE;

        /**
     * The number of structural features of the '<em>Boolean Property Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int BOOLEAN_PROPERTY_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.IsDefinedExpImpl <em>Is Defined Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.IsDefinedExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getIsDefinedExp()
     * @generated
     */
        int IS_DEFINED_EXP = 49;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP__LOCATION = ATOM_EXP__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP__COMMENTS_BEFORE = ATOM_EXP__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP__COMMENTS_AFTER = ATOM_EXP__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>And Exp</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP__AND_EXP = ATOM_EXP__AND_EXP;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP__PROPERTY_NAME = ATOM_EXP__PROPERTY_NAME;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP__PROPERTY_REFERENCE = ATOM_EXP__PROPERTY_REFERENCE;

        /**
     * The number of structural features of the '<em>Is Defined Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int IS_DEFINED_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OneExpImpl <em>One Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OneExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOneExp()
     * @generated
     */
        int ONE_EXP = 50;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP__LOCATION = ATOM_EXP__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP__COMMENTS_BEFORE = ATOM_EXP__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP__COMMENTS_AFTER = ATOM_EXP__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>And Exp</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP__AND_EXP = ATOM_EXP__AND_EXP;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP__PROPERTY_NAME = ATOM_EXP__PROPERTY_NAME;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP__PROPERTY_REFERENCE = ATOM_EXP__PROPERTY_REFERENCE;

        /**
     * The number of structural features of the '<em>One Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ONE_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ValueImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getValue()
     * @generated
     */
        int VALUE = 51;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int VALUE__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int VALUE__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int VALUE__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int VALUE__NAME = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Value</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int VALUE_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyValImpl <em>Property Val</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyValImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyVal()
     * @generated
     */
        int PROPERTY_VAL = 52;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_VAL__LOCATION = VALUE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_VAL__COMMENTS_BEFORE = VALUE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_VAL__COMMENTS_AFTER = VALUE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_VAL__NAME = VALUE__NAME;

        /**
     * The number of structural features of the '<em>Property Val</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TokenImpl <em>Token</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TokenImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getToken()
     * @generated
     */
        int TOKEN = 53;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN__LOCATION = NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN__COMMENTS_BEFORE = NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN__COMMENTS_AFTER = NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN__NAME = NAMED_ELEMENT__NAME;

        /**
     * The feature id for the '<em><b>Pattern</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN__PATTERN = NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Omitted</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN__OMITTED = NAMED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Token</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int TOKEN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OrPatternImpl <em>Or Pattern</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OrPatternImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOrPattern()
     * @generated
     */
        int OR_PATTERN = 54;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OR_PATTERN__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OR_PATTERN__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OR_PATTERN__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Simple Patterns</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OR_PATTERN__SIMPLE_PATTERNS = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Or Pattern</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OR_PATTERN_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SimplePatternImpl <em>Simple Pattern</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SimplePatternImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSimplePattern()
     * @generated
     */
        int SIMPLE_PATTERN = 55;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_PATTERN__LOCATION = NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_PATTERN__COMMENTS_BEFORE = NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_PATTERN__COMMENTS_AFTER = NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_PATTERN__NAME = NAMED_ELEMENT__NAME;

        /**
     * The number of structural features of the '<em>Simple Pattern</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_PATTERN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RulePatternImpl <em>Rule Pattern</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RulePatternImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRulePattern()
     * @generated
     */
        int RULE_PATTERN = 56;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_PATTERN__LOCATION = SIMPLE_PATTERN__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_PATTERN__COMMENTS_BEFORE = SIMPLE_PATTERN__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_PATTERN__COMMENTS_AFTER = SIMPLE_PATTERN__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_PATTERN__NAME = SIMPLE_PATTERN__NAME;

        /**
     * The feature id for the '<em><b>Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_PATTERN__RULE = SIMPLE_PATTERN_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Rule Pattern</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_PATTERN_FEATURE_COUNT = SIMPLE_PATTERN_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RuleImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRule()
     * @generated
     */
        int RULE = 57;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The number of structural features of the '<em>Rule</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int RULE_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.WordRuleImpl <em>Word Rule</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.WordRuleImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getWordRule()
     * @generated
     */
        int WORD_RULE = 58;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__LOCATION = RULE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__COMMENTS_BEFORE = RULE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__COMMENTS_AFTER = RULE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__START = RULE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__PART = RULE_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>End</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__END = RULE_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Words</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE__WORDS = RULE_FEATURE_COUNT + 3;

        /**
     * The number of structural features of the '<em>Word Rule</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 4;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.WordImpl <em>Word</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.WordImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getWord()
     * @generated
     */
        int WORD = 59;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD__LOCATION = NAMED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD__COMMENTS_BEFORE = NAMED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD__COMMENTS_AFTER = NAMED_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD__NAME = NAMED_ELEMENT__NAME;

        /**
     * The feature id for the '<em><b>Token</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD__TOKEN = NAMED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Word</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WORD_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EndOfLineRuleImpl <em>End Of Line Rule</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EndOfLineRuleImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEndOfLineRule()
     * @generated
     */
        int END_OF_LINE_RULE = 60;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_OF_LINE_RULE__LOCATION = RULE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_OF_LINE_RULE__COMMENTS_BEFORE = RULE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_OF_LINE_RULE__COMMENTS_AFTER = RULE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_OF_LINE_RULE__START = RULE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Drop Start</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_OF_LINE_RULE__DROP_START = RULE_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>End Of Line Rule</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int END_OF_LINE_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl <em>Multi Line Rule</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getMultiLineRule()
     * @generated
     */
        int MULTI_LINE_RULE = 61;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__LOCATION = RULE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__COMMENTS_BEFORE = RULE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__COMMENTS_AFTER = RULE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__START = RULE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>End</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__END = RULE_FEATURE_COUNT + 1;

        /**
     * The feature id for the '<em><b>Esc</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__ESC = RULE_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Esc Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__ESC_MAPPINGS = RULE_FEATURE_COUNT + 3;

        /**
     * The feature id for the '<em><b>Drop Start</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__DROP_START = RULE_FEATURE_COUNT + 4;

        /**
     * The feature id for the '<em><b>Drop End</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE__DROP_END = RULE_FEATURE_COUNT + 5;

        /**
     * The number of structural features of the '<em>Multi Line Rule</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MULTI_LINE_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 6;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MappingImpl <em>Mapping</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.MappingImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getMapping()
     * @generated
     */
        int MAPPING = 62;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MAPPING__LOCATION = LOCATED_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MAPPING__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MAPPING__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

        /**
     * The number of structural features of the '<em>Mapping</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int MAPPING_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SimpleMappingImpl <em>Simple Mapping</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SimpleMappingImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSimpleMapping()
     * @generated
     */
        int SIMPLE_MAPPING = 63;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_MAPPING__LOCATION = MAPPING__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_MAPPING__COMMENTS_BEFORE = MAPPING__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_MAPPING__COMMENTS_AFTER = MAPPING__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_MAPPING__KEY = MAPPING_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_MAPPING__VALUE = MAPPING_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Simple Mapping</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SIMPLE_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.WildcardMappingImpl <em>Wildcard Mapping</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.WildcardMappingImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getWildcardMapping()
     * @generated
     */
        int WILDCARD_MAPPING = 64;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WILDCARD_MAPPING__LOCATION = MAPPING__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WILDCARD_MAPPING__COMMENTS_BEFORE = MAPPING__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WILDCARD_MAPPING__COMMENTS_AFTER = MAPPING__COMMENTS_AFTER;

        /**
     * The number of structural features of the '<em>Wildcard Mapping</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int WILDCARD_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OctalMappingImpl <em>Octal Mapping</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OctalMappingImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOctalMapping()
     * @generated
     */
        int OCTAL_MAPPING = 65;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCTAL_MAPPING__LOCATION = MAPPING__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCTAL_MAPPING__COMMENTS_BEFORE = MAPPING__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCTAL_MAPPING__COMMENTS_AFTER = MAPPING__COMMENTS_AFTER;

        /**
     * The number of structural features of the '<em>Octal Mapping</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCTAL_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.HexadecimalMappingImpl <em>Hexadecimal Mapping</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.HexadecimalMappingImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getHexadecimalMapping()
     * @generated
     */
        int HEXADECIMAL_MAPPING = 66;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int HEXADECIMAL_MAPPING__LOCATION = MAPPING__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int HEXADECIMAL_MAPPING__COMMENTS_BEFORE = MAPPING__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int HEXADECIMAL_MAPPING__COMMENTS_AFTER = MAPPING__COMMENTS_AFTER;

        /**
     * The number of structural features of the '<em>Hexadecimal Mapping</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int HEXADECIMAL_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StringPatternImpl <em>String Pattern</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StringPatternImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStringPattern()
     * @generated
     */
        int STRING_PATTERN = 67;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_PATTERN__LOCATION = SIMPLE_PATTERN__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_PATTERN__COMMENTS_BEFORE = SIMPLE_PATTERN__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_PATTERN__COMMENTS_AFTER = SIMPLE_PATTERN__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_PATTERN__NAME = SIMPLE_PATTERN__NAME;

        /**
     * The number of structural features of the '<em>String Pattern</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_PATTERN_FEATURE_COUNT = SIMPLE_PATTERN_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassPatternImpl <em>Class Pattern</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassPatternImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getClassPattern()
     * @generated
     */
        int CLASS_PATTERN = 68;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_PATTERN__LOCATION = SIMPLE_PATTERN__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_PATTERN__COMMENTS_BEFORE = SIMPLE_PATTERN__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_PATTERN__COMMENTS_AFTER = SIMPLE_PATTERN__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_PATTERN__NAME = SIMPLE_PATTERN__NAME;

        /**
     * The number of structural features of the '<em>Class Pattern</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CLASS_PATTERN_FEATURE_COUNT = SIMPLE_PATTERN_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedUpperPArgImpl <em>Forced Upper PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedUpperPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getForcedUpperPArg()
     * @generated
     */
        int FORCED_UPPER_PARG = 70;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_UPPER_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_UPPER_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_UPPER_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_UPPER_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_UPPER_PARG__VALUE = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Forced Upper PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FORCED_UPPER_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionsBlockImpl <em>Injector Actions Block</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionsBlockImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getInjectorActionsBlock()
     * @generated
     */
        int INJECTOR_ACTIONS_BLOCK = 71;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__LOCATION = SEQUENCE_ELEMENT__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

        /**
     * The feature id for the '<em><b>Parent Template</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__PARENT_TEMPLATE = SEQUENCE_ELEMENT__PARENT_TEMPLATE;

        /**
     * The feature id for the '<em><b>Property Inits</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Injector Actions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Injector Actions Block</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INJECTOR_ACTIONS_BLOCK_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPArgImpl <em>Ocl PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOclPArg()
     * @generated
     */
        int OCL_PARG = 75;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryPArgImpl <em>Query PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getQueryPArg()
     * @generated
     */
        int QUERY_PARG = 72;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUERY_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUERY_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUERY_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUERY_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Query</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUERY_PARG__QUERY = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Query PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int QUERY_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryByIdentifierPArgImpl <em>Query By Identifier PArg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryByIdentifierPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getQueryByIdentifierPArg()
     * @generated
     */
    int QUERY_BY_IDENTIFIER_PARG = 73;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Query</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG__QUERY = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG__FEATURE = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Query By Identifier PArg</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BY_IDENTIFIER_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FilterPArgImpl <em>Filter PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.FilterPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getFilterPArg()
     * @generated
     */
        int FILTER_PARG = 74;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG__FILTER = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Invert</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG__INVERT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Filter PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FILTER_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 2;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Query Expression</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG__QUERY_EXPRESSION = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Query</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG__QUERY = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Ocl PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl <em>Property Reference</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyReference()
     * @generated
     */
        int PROPERTY_REFERENCE = 76;

        /**
     * The feature id for the '<em><b>Strucfeature</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_REFERENCE__STRUCFEATURE = 0;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_REFERENCE__NAME = 1;

        /**
     * The number of structural features of the '<em>Property Reference</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PROPERTY_REFERENCE_FEATURE_COUNT = 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTagsImpl <em>Context Tags</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTagsImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getContextTags()
     * @generated
     */
        int CONTEXT_TAGS = 78;

        /**
     * The feature id for the '<em><b>Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TAGS__TAGS = 0;

        /**
     * The number of structural features of the '<em>Context Tags</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int CONTEXT_TAGS_FEATURE_COUNT = 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPropertyInitImpl <em>Ocl Property Init</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPropertyInitImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOclPropertyInit()
     * @generated
     */
        int OCL_PROPERTY_INIT = 81;

        /**
     * The feature id for the '<em><b>Injector Actions Block</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK = PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PROPERTY_INIT__PROPERTY_REFERENCE = PROPERTY_INIT__PROPERTY_REFERENCE;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PROPERTY_INIT__VALUE = PROPERTY_INIT__VALUE;

        /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_PROPERTY_INIT__DEFAULT = PROPERTY_INIT__DEFAULT;

        /**
     * The feature id for the '<em><b>Ocl Expression</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PROPERTY_INIT__OCL_EXPRESSION = PROPERTY_INIT_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Ocl Property Init</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int OCL_PROPERTY_INIT_FEATURE_COUNT = PROPERTY_INIT_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ScopeArgImpl <em>Scope Arg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ScopeArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getScopeArg()
     * @generated
     */
        int SCOPE_ARG = 82;

        /**
     * The feature id for the '<em><b>Scope</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SCOPE_ARG__SCOPE = 0;

        /**
     * The number of structural features of the '<em>Scope Arg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SCOPE_ARG_FEATURE_COUNT = 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForeachPredicatePropertyInitImpl <em>Foreach Predicate Property Init</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ForeachPredicatePropertyInitImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getForeachPredicatePropertyInit()
     * @generated
     */
        int FOREACH_PREDICATE_PROPERTY_INIT = 83;

        /**
     * The feature id for the '<em><b>Injector Actions Block</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOREACH_PREDICATE_PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK = PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FOREACH_PREDICATE_PROPERTY_INIT__PROPERTY_REFERENCE = PROPERTY_INIT__PROPERTY_REFERENCE;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FOREACH_PREDICATE_PROPERTY_INIT__VALUE = PROPERTY_INIT__VALUE;

        /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOREACH_PREDICATE_PROPERTY_INIT__DEFAULT = PROPERTY_INIT__DEFAULT;

        /**
     * The feature id for the '<em><b>Predicate Semantic</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC = PROPERTY_INIT_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FOREACH_PREDICATE_PROPERTY_INIT__MODE = PROPERTY_INIT_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Foreach Predicate Property Init</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int FOREACH_PREDICATE_PROPERTY_INIT_FEATURE_COUNT = PROPERTY_INIT_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl <em>Predicate Semantic</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPredicateSemantic()
     * @generated
     */
        int PREDICATE_SEMANTIC = 84;

        /**
     * The feature id for the '<em><b>When</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PREDICATE_SEMANTIC__WHEN = 0;

        /**
     * The feature id for the '<em><b>As</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PREDICATE_SEMANTIC__AS = 1;

        /**
     * The feature id for the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PREDICATE_SEMANTIC__MODE = 2;

        /**
     * The feature id for the '<em><b>Foreach Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PREDICATE_SEMANTIC__FOREACH_PARENT = 3;

        /**
     * The number of structural features of the '<em>Predicate Semantic</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PREDICATE_SEMANTIC_FEATURE_COUNT = 4;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceInAlternativeImpl <em>Sequence In Alternative</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceInAlternativeImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSequenceInAlternative()
     * @generated
     */
        int SEQUENCE_IN_ALTERNATIVE = 85;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__LOCATION = SEQUENCE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__COMMENTS_BEFORE = SEQUENCE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__COMMENTS_AFTER = SEQUENCE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__ELEMENTS = SEQUENCE__ELEMENTS;

        /**
     * The feature id for the '<em><b>Template Container</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__TEMPLATE_CONTAINER = SEQUENCE__TEMPLATE_CONTAINER;

        /**
     * The feature id for the '<em><b>Prefix Container</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__PREFIX_CONTAINER = SEQUENCE__PREFIX_CONTAINER;

        /**
     * The feature id for the '<em><b>Function Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__FUNCTION_CONTAINER = SEQUENCE__FUNCTION_CONTAINER;

        /**
     * The feature id for the '<em><b>Block Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__BLOCK_CONTAINER = SEQUENCE__BLOCK_CONTAINER;

        /**
     * The feature id for the '<em><b>Then Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__THEN_CONTAINER = SEQUENCE__THEN_CONTAINER;

        /**
     * The feature id for the '<em><b>Else Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__ELSE_CONTAINER = SEQUENCE__ELSE_CONTAINER;

        /**
     * The feature id for the '<em><b>Separator Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__SEPARATOR_CONTAINER = SEQUENCE__SEPARATOR_CONTAINER;

        /**
     * The feature id for the '<em><b>Ot Container</b></em>' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__OT_CONTAINER = SEQUENCE__OT_CONTAINER;

        /**
     * The feature id for the '<em><b>Alternative Container</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER = SEQUENCE_FEATURE_COUNT + 0;

        /**
     * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE = SEQUENCE_FEATURE_COUNT + 1;

        /**
     * The number of structural features of the '<em>Sequence In Alternative</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int SEQUENCE_IN_ALTERNATIVE_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 2;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PartialPArgImpl <em>Partial PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PartialPArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPartialPArg()
     * @generated
     */
        int PARTIAL_PARG = 86;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PARTIAL_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PARTIAL_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PARTIAL_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PARTIAL_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The number of structural features of the '<em>Partial PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int PARTIAL_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.DisambiguatePArgImpl <em>Disambiguate PArg</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.DisambiguatePArgImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getDisambiguatePArg()
     * @generated
     */
        int DISAMBIGUATE_PARG = 87;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DISAMBIGUATE_PARG__LOCATION = PROPERTY_ARG__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DISAMBIGUATE_PARG__COMMENTS_BEFORE = PROPERTY_ARG__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DISAMBIGUATE_PARG__COMMENTS_AFTER = PROPERTY_ARG__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Property</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DISAMBIGUATE_PARG__PROPERTY = PROPERTY_ARG__PROPERTY;

        /**
     * The feature id for the '<em><b>Disambiguation</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DISAMBIGUATE_PARG__DISAMBIGUATION = PROPERTY_ARG_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Disambiguate PArg</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int DISAMBIGUATE_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InstanceOfExpImpl <em>Instance Of Exp</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.InstanceOfExpImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getInstanceOfExp()
     * @generated
     */
        int INSTANCE_OF_EXP = 88;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__LOCATION = ATOM_EXP__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__COMMENTS_BEFORE = ATOM_EXP__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__COMMENTS_AFTER = ATOM_EXP__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>And Exp</b></em>' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__AND_EXP = ATOM_EXP__AND_EXP;

        /**
     * The feature id for the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__PROPERTY_NAME = ATOM_EXP__PROPERTY_NAME;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__PROPERTY_REFERENCE = ATOM_EXP__PROPERTY_REFERENCE;

        /**
     * The feature id for the '<em><b>Supertype</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP__SUPERTYPE = ATOM_EXP_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Instance Of Exp</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INSTANCE_OF_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralValImpl <em>Enum Literal Val</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralValImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEnumLiteralVal()
     * @generated
     */
        int ENUM_LITERAL_VAL = 89;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_VAL__LOCATION = VALUE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_VAL__COMMENTS_BEFORE = VALUE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_VAL__COMMENTS_AFTER = VALUE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_VAL__NAME = VALUE__NAME;

        /**
     * The number of structural features of the '<em>Enum Literal Val</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int ENUM_LITERAL_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StringValImpl <em>String Val</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StringValImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStringVal()
     * @generated
     */
        int STRING_VAL = 90;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_VAL__LOCATION = VALUE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_VAL__COMMENTS_BEFORE = VALUE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_VAL__COMMENTS_AFTER = VALUE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_VAL__NAME = VALUE__NAME;

        /**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_VAL__SYMBOL = VALUE_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>String Val</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int STRING_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.IntegerValImpl <em>Integer Val</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.IntegerValImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getIntegerVal()
     * @generated
     */
        int INTEGER_VAL = 91;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INTEGER_VAL__LOCATION = VALUE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INTEGER_VAL__COMMENTS_BEFORE = VALUE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INTEGER_VAL__COMMENTS_AFTER = VALUE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INTEGER_VAL__NAME = VALUE__NAME;

        /**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INTEGER_VAL__SYMBOL = VALUE_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Integer Val</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int INTEGER_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.NegativeIntegerValImpl <em>Negative Integer Val</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.NegativeIntegerValImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getNegativeIntegerVal()
     * @generated
     */
        int NEGATIVE_INTEGER_VAL = 92;

        /**
     * The feature id for the '<em><b>Location</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NEGATIVE_INTEGER_VAL__LOCATION = VALUE__LOCATION;

        /**
     * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NEGATIVE_INTEGER_VAL__COMMENTS_BEFORE = VALUE__COMMENTS_BEFORE;

        /**
     * The feature id for the '<em><b>Comments After</b></em>' attribute list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NEGATIVE_INTEGER_VAL__COMMENTS_AFTER = VALUE__COMMENTS_AFTER;

        /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NEGATIVE_INTEGER_VAL__NAME = VALUE__NAME;

        /**
     * The feature id for the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NEGATIVE_INTEGER_VAL__SYMBOL = VALUE_FEATURE_COUNT + 0;

        /**
     * The number of structural features of the '<em>Negative Integer Val</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int NEGATIVE_INTEGER_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LookupPropertyInitImpl <em>Lookup Property Init</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LookupPropertyInitImpl
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLookupPropertyInit()
     * @generated
     */
        int LOOKUP_PROPERTY_INIT = 93;

        /**
     * The feature id for the '<em><b>Injector Actions Block</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOOKUP_PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK = PROPERTY_INIT__INJECTOR_ACTIONS_BLOCK;

        /**
     * The feature id for the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOKUP_PROPERTY_INIT__PROPERTY_REFERENCE = PROPERTY_INIT__PROPERTY_REFERENCE;

        /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOKUP_PROPERTY_INIT__VALUE = PROPERTY_INIT__VALUE;

        /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOOKUP_PROPERTY_INIT__DEFAULT = PROPERTY_INIT__DEFAULT;

        /**
     * The number of structural features of the '<em>Lookup Property Init</em>' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        int LOOKUP_PROPERTY_INIT_FEATURE_COUNT = PROPERTY_INIT_FEATURE_COUNT + 0;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers <em>Template Modifiers</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getTemplateModifiers()
     * @generated
     */
        int TEMPLATE_MODIFIERS = 94;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind <em>Space Kind</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSpaceKind()
     * @generated
     */
        int SPACE_KIND = 95;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Associativity <em>Associativity</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Associativity
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAssociativity()
     * @generated
     */
        int ASSOCIATIVITY = 96;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind <em>Auto Create Kind</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAutoCreateKind()
     * @generated
     */
        int AUTO_CREATE_KIND = 97;

        /**
     * The meta object id for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind <em>Scope Kind</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind
     * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getScopeKind()
     * @generated
     */
        int SCOPE_KIND = 98;


        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement <em>Located Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Located Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement
     * @generated
     */
        EClass getLocatedElement();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getLocation <em>Location</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Location</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getLocation()
     * @see #getLocatedElement()
     * @generated
     */
        EAttribute getLocatedElement_Location();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getCommentsBefore <em>Comments Before</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Comments Before</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getCommentsBefore()
     * @see #getLocatedElement()
     * @generated
     */
        EAttribute getLocatedElement_CommentsBefore();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getCommentsAfter <em>Comments After</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Comments After</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getCommentsAfter()
     * @see #getLocatedElement()
     * @generated
     */
        EAttribute getLocatedElement_CommentsAfter();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.NamedElement
     * @generated
     */
        EClass getNamedElement();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
        EAttribute getNamedElement_Name();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax <em>Concrete Syntax</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Concrete Syntax</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax
     * @generated
     */
        EClass getConcreteSyntax();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getK <em>K</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>K</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getK()
     * @see #getConcreteSyntax()
     * @generated
     */
        EAttribute getConcreteSyntax_K();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getTemplates <em>Templates</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Templates</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getTemplates()
     * @see #getConcreteSyntax()
     * @generated
     */
        EReference getConcreteSyntax_Templates();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getKeywords <em>Keywords</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Keywords</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getKeywords()
     * @see #getConcreteSyntax()
     * @generated
     */
        EReference getConcreteSyntax_Keywords();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getSymbols <em>Symbols</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Symbols</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getSymbols()
     * @see #getConcreteSyntax()
     * @generated
     */
        EReference getConcreteSyntax_Symbols();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getOperatorLists <em>Operator Lists</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Operator Lists</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getOperatorLists()
     * @see #getConcreteSyntax()
     * @generated
     */
        EReference getConcreteSyntax_OperatorLists();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getTokens <em>Tokens</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tokens</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getTokens()
     * @see #getConcreteSyntax()
     * @generated
     */
        EReference getConcreteSyntax_Tokens();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getLexer <em>Lexer</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lexer</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getLexer()
     * @see #getConcreteSyntax()
     * @generated
     */
        EAttribute getConcreteSyntax_Lexer();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template <em>Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Template
     * @generated
     */
        EClass getTemplate();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getConcreteSyntax <em>Concrete Syntax</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Concrete Syntax</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Template#getConcreteSyntax()
     * @see #getTemplate()
     * @generated
     */
        EReference getTemplate_ConcreteSyntax();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguate <em>Disambiguate</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disambiguate</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguate()
     * @see #getTemplate()
     * @generated
     */
        EAttribute getTemplate_Disambiguate();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguateV3 <em>Disambiguate V3</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disambiguate V3</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguateV3()
     * @see #getTemplate()
     * @generated
     */
        EAttribute getTemplate_DisambiguateV3();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getSemDisambiguate <em>Sem Disambiguate</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sem Disambiguate</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Template#getSemDisambiguate()
     * @see #getTemplate()
     * @generated
     */
	EAttribute getTemplate_SemDisambiguate();

								/**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getTextBlockDefinition <em>Text Block Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Text Block Definition</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Template#getTextBlockDefinition()
     * @see #getTemplate()
     * @generated
     */
	EReference getTemplate_TextBlockDefinition();

								/**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate <em>Function Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate
     * @generated
     */
        EClass getFunctionTemplate();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionName <em>Function Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Function Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionName()
     * @see #getFunctionTemplate()
     * @generated
     */
        EAttribute getFunctionTemplate_FunctionName();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionSequence <em>Function Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Function Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionSequence()
     * @see #getFunctionTemplate()
     * @generated
     */
        EReference getFunctionTemplate_FunctionSequence();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate <em>Class Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Class Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate
     * @generated
     */
        EClass getClassTemplate();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getModifiers <em>Modifiers</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Modifiers</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getModifiers()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_Modifiers();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsAbstract <em>Is Abstract</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Abstract</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsAbstract()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_IsAbstract();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsDeep <em>Is Deep</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Deep</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsDeep()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_IsDeep();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsOperatored <em>Is Operatored</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Operatored</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsOperatored()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_IsOperatored();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getOperatorList <em>Operator List</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Operator List</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getOperatorList()
     * @see #getClassTemplate()
     * @generated
     */
        EReference getClassTemplate_OperatorList();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMain <em>Is Main</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Main</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMain()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_IsMain();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMulti <em>Is Multi</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Multi</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMulti()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_IsMulti();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsNonPrimary <em>Is Non Primary</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Non Primary</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsNonPrimary()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_IsNonPrimary();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getMode <em>Mode</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mode</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getMode()
     * @see #getClassTemplate()
     * @generated
     */
        EAttribute getClassTemplate_Mode();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate <em>Primitive Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate
     * @generated
     */
        EClass getPrimitiveTemplate();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTemplateName <em>Template Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Template Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTemplateName()
     * @see #getPrimitiveTemplate()
     * @generated
     */
        EAttribute getPrimitiveTemplate_TemplateName();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isDefault <em>Default</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isDefault()
     * @see #getPrimitiveTemplate()
     * @generated
     */
    EAttribute getPrimitiveTemplate_Default();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTokenName <em>Token Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Token Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTokenName()
     * @see #getPrimitiveTemplate()
     * @generated
     */
        EAttribute getPrimitiveTemplate_TokenName();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getValue()
     * @see #getPrimitiveTemplate()
     * @generated
     */
        EAttribute getPrimitiveTemplate_Value();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getSerializer <em>Serializer</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Serializer</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getSerializer()
     * @see #getPrimitiveTemplate()
     * @generated
     */
        EAttribute getPrimitiveTemplate_Serializer();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isOrKeyword <em>Or Keyword</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Or Keyword</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isOrKeyword()
     * @see #getPrimitiveTemplate()
     * @generated
     */
        EAttribute getPrimitiveTemplate_OrKeyword();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate <em>Operator Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operator Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate
     * @generated
     */
        EClass getOperatorTemplate();

        /**
     * Returns the meta object for the reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOperators <em>Operators</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Operators</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOperators()
     * @see #getOperatorTemplate()
     * @generated
     */
        EReference getOperatorTemplate_Operators();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getSource()
     * @see #getOperatorTemplate()
     * @generated
     */
        EAttribute getOperatorTemplate_Source();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOpTo <em>Store Op To</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Store Op To</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOpTo()
     * @see #getOperatorTemplate()
     * @generated
     */
        EAttribute getOperatorTemplate_StoreOpTo();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightTo <em>Store Right To</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Store Right To</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightTo()
     * @see #getOperatorTemplate()
     * @generated
     */
        EAttribute getOperatorTemplate_StoreRightTo();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOperatorTo <em>Store Operator To</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Store Operator To</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOperatorTo()
     * @see #getOperatorTemplate()
     * @generated
     */
        EReference getOperatorTemplate_StoreOperatorTo();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreLeftSideTo <em>Store Left Side To</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Store Left Side To</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreLeftSideTo()
     * @see #getOperatorTemplate()
     * @generated
     */
        EReference getOperatorTemplate_StoreLeftSideTo();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightSideTo <em>Store Right Side To</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Store Right Side To</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightSideTo()
     * @see #getOperatorTemplate()
     * @generated
     */
        EReference getOperatorTemplate_StoreRightSideTo();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate <em>Enumeration Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enumeration Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate
     * @generated
     */
        EClass getEnumerationTemplate();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#isAutomatic <em>Automatic</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Automatic</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#isAutomatic()
     * @see #getEnumerationTemplate()
     * @generated
     */
        EAttribute getEnumerationTemplate_Automatic();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Mappings</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#getMappings()
     * @see #getEnumerationTemplate()
     * @generated
     */
        EReference getEnumerationTemplate_Mappings();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping <em>Enum Literal Mapping</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Literal Mapping</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping
     * @generated
     */
        EClass getEnumLiteralMapping();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping#getLiteral <em>Literal</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Literal</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping#getLiteral()
     * @see #getEnumLiteralMapping()
     * @generated
     */
        EReference getEnumLiteralMapping_Literal();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping#getElement()
     * @see #getEnumLiteralMapping()
     * @generated
     */
        EReference getEnumLiteralMapping_Element();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Literal <em>Literal</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literal</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Literal
     * @generated
     */
        EClass getLiteral();

        /**
     * Returns the meta object for the reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Literal#getOperators <em>Operators</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Operators</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Literal#getOperators()
     * @see #getLiteral()
     * @generated
     */
        EReference getLiteral_Operators();

        /**
     * Returns the meta object for the reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Literal#getLiteralRefs <em>Literal Refs</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Literal Refs</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Literal#getLiteralRefs()
     * @see #getLiteral()
     * @generated
     */
        EReference getLiteral_LiteralRefs();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Literal#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Literal#getValue()
     * @see #getLiteral()
     * @generated
     */
        EAttribute getLiteral_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Symbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Symbol</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Symbol
     * @generated
     */
        EClass getSymbol();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Symbol#getSpaces <em>Spaces</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Spaces</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Symbol#getSpaces()
     * @see #getSymbol()
     * @generated
     */
        EAttribute getSymbol_Spaces();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Keyword <em>Keyword</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Keyword</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Keyword
     * @generated
     */
        EClass getKeyword();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorList <em>Operator List</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operator List</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorList
     * @generated
     */
        EClass getOperatorList();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getName()
     * @see #getOperatorList()
     * @generated
     */
        EAttribute getOperatorList_Name();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getPriorities <em>Priorities</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Priorities</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getPriorities()
     * @see #getOperatorList()
     * @generated
     */
        EReference getOperatorList_Priorities();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority <em>Priority</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Priority</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority
     * @generated
     */
        EClass getPriority();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority#getList <em>List</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>List</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority#getList()
     * @see #getPriority()
     * @generated
     */
        EReference getPriority_List();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority#getValue()
     * @see #getPriority()
     * @generated
     */
        EAttribute getPriority_Value();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority#getAssociativity <em>Associativity</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Associativity</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority#getAssociativity()
     * @see #getPriority()
     * @generated
     */
        EAttribute getPriority_Associativity();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority#getOperators <em>Operators</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Operators</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority#getOperators()
     * @see #getPriority()
     * @generated
     */
        EReference getPriority_Operators();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator <em>Operator</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operator</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator
     * @generated
     */
        EClass getOperator();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#isPostfix <em>Postfix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Postfix</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator#isPostfix()
     * @see #getOperator()
     * @generated
     */
    EAttribute getOperator_Postfix();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getArity <em>Arity</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Arity</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator#getArity()
     * @see #getOperator()
     * @generated
     */
        EAttribute getOperator_Arity();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getLiteral <em>Literal</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Literal</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator#getLiteral()
     * @see #getOperator()
     * @generated
     */
        EReference getOperator_Literal();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getPriority <em>Priority</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Priority</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator#getPriority()
     * @see #getOperator()
     * @generated
     */
        EReference getOperator_Priority();

        /**
     * Returns the meta object for the reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getTemplates <em>Templates</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Templates</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator#getTemplates()
     * @see #getOperator()
     * @generated
     */
        EReference getOperator_Templates();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence <em>Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence
     * @generated
     */
        EClass getSequence();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElements()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_Elements();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getTemplateContainer <em>Template Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Template Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getTemplateContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_TemplateContainer();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getPrefixContainer <em>Prefix Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Prefix Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getPrefixContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_PrefixContainer();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getFunctionContainer <em>Function Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Function Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getFunctionContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_FunctionContainer();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getBlockContainer <em>Block Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Block Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getBlockContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_BlockContainer();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getThenContainer <em>Then Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Then Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getThenContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_ThenContainer();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElseContainer <em>Else Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Else Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElseContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_ElseContainer();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getSeparatorContainer <em>Separator Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Separator Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getSeparatorContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_SeparatorContainer();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getOtContainer <em>Ot Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ot Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getOtContainer()
     * @see #getSequence()
     * @generated
     */
        EReference getSequence_OtContainer();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement <em>Sequence Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement
     * @generated
     */
        EClass getSequenceElement();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement#getElementSequence <em>Element Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Element Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement#getElementSequence()
     * @see #getSequenceElement()
     * @generated
     */
        EReference getSequenceElement_ElementSequence();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement#getParentTemplate <em>Parent Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement#getParentTemplate()
     * @see #getSequenceElement()
     * @generated
     */
        EReference getSequenceElement_ParentTemplate();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef <em>Literal Ref</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literal Ref</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef
     * @generated
     */
        EClass getLiteralRef();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef#getReferredLiteral <em>Referred Literal</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Literal</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef#getReferredLiteral()
     * @see #getLiteralRef()
     * @generated
     */
        EReference getLiteralRef_ReferredLiteral();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Property
     * @generated
     */
        EClass getProperty();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyArgs <em>Property Args</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property Args</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyArgs()
     * @see #getProperty()
     * @generated
     */
        EReference getProperty_PropertyArgs();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyReference <em>Property Reference</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Property Reference</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyReference()
     * @see #getProperty()
     * @generated
     */
        EReference getProperty_PropertyReference();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator <em>Custom Separator</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Separator</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator
     * @generated
     */
        EClass getCustomSeparator();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator#getName()
     * @see #getCustomSeparator()
     * @generated
     */
        EAttribute getCustomSeparator_Name();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Block
     * @generated
     */
        EClass getBlock();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockSequence <em>Block Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Block Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockSequence()
     * @see #getBlock()
     * @generated
     */
        EReference getBlock_BlockSequence();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockArgs <em>Block Args</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Block Args</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Block#getBlockArgs()
     * @see #getBlock()
     * @generated
     */
        EReference getBlock_BlockArgs();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement <em>Conditional Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conditional Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement
     * @generated
     */
        EClass getConditionalElement();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getCondition()
     * @see #getConditionalElement()
     * @generated
     */
        EReference getConditionalElement_Condition();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getThenSequence <em>Then Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Then Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getThenSequence()
     * @see #getConditionalElement()
     * @generated
     */
        EReference getConditionalElement_ThenSequence();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getElseSequence <em>Else Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Else Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getElseSequence()
     * @see #getConditionalElement()
     * @generated
     */
        EReference getConditionalElement_ElseSequence();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit <em>Primitive Property Init</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Property Init</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit
     * @generated
     */
        EClass getPrimitivePropertyInit();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Alternative <em>Alternative</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Alternative</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Alternative
     * @generated
     */
        EClass getAlternative();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.Alternative#getSequences <em>Sequences</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sequences</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Alternative#getSequences()
     * @see #getAlternative()
     * @generated
     */
        EReference getAlternative_Sequences();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Alternative#isIsMulti <em>Is Multi</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Multi</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Alternative#isIsMulti()
     * @see #getAlternative()
     * @generated
     */
        EAttribute getAlternative_IsMulti();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall <em>Function Call</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Call</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall
     * @generated
     */
        EClass getFunctionCall();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall#getCalledFunction <em>Called Function</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Called Function</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall#getCalledFunction()
     * @see #getFunctionCall()
     * @generated
     */
        EReference getFunctionCall_CalledFunction();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg <em>Property Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg
     * @generated
     */
        EClass getPropertyArg();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Property</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg#getProperty()
     * @see #getPropertyArg()
     * @generated
     */
        EReference getPropertyArg_Property();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg <em>Refers To PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Refers To PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg
     * @generated
     */
        EClass getRefersToPArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg#getPropertyName <em>Property Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Property Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg#getPropertyName()
     * @see #getRefersToPArg()
     * @generated
     */
        EAttribute getRefersToPArg_PropertyName();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg <em>Look In PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Look In PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg
     * @generated
     */
        EClass getLookInPArg();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg#getPropertyName <em>Property Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Property Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg#getPropertyName()
     * @see #getLookInPArg()
     * @generated
     */
        EAttribute getLookInPArg_PropertyName();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg <em>Create In PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Create In PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg
     * @generated
     */
        EClass getCreateInPArg();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg#getPropertyName <em>Property Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Property Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg#getPropertyName()
     * @see #getCreateInPArg()
     * @generated
     */
        EAttribute getCreateInPArg_PropertyName();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.RefersToKeyPArg <em>Refers To Key PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Refers To Key PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.RefersToKeyPArg
     * @generated
     */
        EClass getRefersToKeyPArg();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg <em>Separator PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Separator PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg
     * @generated
     */
        EClass getSeparatorPArg();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg#getSeparatorSequence <em>Separator Sequence</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Separator Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg#getSeparatorSequence()
     * @see #getSeparatorPArg()
     * @generated
     */
        EReference getSeparatorPArg_SeparatorSequence();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg <em>Auto Create PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Auto Create PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg
     * @generated
     */
        EClass getAutoCreatePArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg#getValue()
     * @see #getAutoCreatePArg()
     * @generated
     */
        EAttribute getAutoCreatePArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg <em>Import Context PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Import Context PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg
     * @generated
     */
        EClass getImportContextPArg();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg <em>Forced Lower PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Forced Lower PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg
     * @generated
     */
        EClass getForcedLowerPArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg#getValue()
     * @see #getForcedLowerPArg()
     * @generated
     */
        EAttribute getForcedLowerPArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg <em>Create As PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Create As PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg
     * @generated
     */
        EClass getCreateAsPArg();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg#getName()
     * @see #getCreateAsPArg()
     * @generated
     */
        EAttribute getCreateAsPArg_Name();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg <em>As PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>As PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AsPArg
     * @generated
     */
        EClass getAsPArg();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getTemplate <em>Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getTemplate()
     * @see #getAsPArg()
     * @generated
     */
        EReference getAsPArg_Template();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getValue()
     * @see #getAsPArg()
     * @generated
     */
        EAttribute getAsPArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ModePArg <em>Mode PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mode PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ModePArg
     * @generated
     */
        EClass getModePArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ModePArg#getMode <em>Mode</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mode</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ModePArg#getMode()
     * @see #getModePArg()
     * @generated
     */
        EAttribute getModePArg_Mode();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.BlockArg <em>Block Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.BlockArg
     * @generated
     */
        EClass getBlockArg();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.BlockArg#getBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Block</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.BlockArg#getBlock()
     * @see #getBlockArg()
     * @generated
     */
        EReference getBlockArg_Block();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg <em>Nb NLB Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Nb NLB Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg
     * @generated
     */
        EClass getNbNLBArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg#getValue()
     * @see #getNbNLBArg()
     * @generated
     */
    EAttribute getNbNLBArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg <em>Indent Incr BArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Indent Incr BArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg
     * @generated
     */
        EClass getIndentIncrBArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg#getValue()
     * @see #getIndentIncrBArg()
     * @generated
     */
    EAttribute getIndentIncrBArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg <em>Start NLB Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start NLB Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg
     * @generated
     */
        EClass getStartNLBArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg#isValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg#isValue()
     * @see #getStartNLBArg()
     * @generated
     */
    EAttribute getStartNLBArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg <em>Start Nb NLB Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Nb NLB Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg
     * @generated
     */
        EClass getStartNbNLBArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg#getValue()
     * @see #getStartNbNLBArg()
     * @generated
     */
    EAttribute getStartNbNLBArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg <em>End NLB Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>End NLB Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg
     * @generated
     */
        EClass getEndNLBArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg#isValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg#isValue()
     * @see #getEndNLBArg()
     * @generated
     */
    EAttribute getEndNLBArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Expression
     * @generated
     */
        EClass getExpression();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Expression#getConditionalElement <em>Conditional Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Conditional Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Expression#getConditionalElement()
     * @see #getExpression()
     * @generated
     */
        EReference getExpression_ConditionalElement();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.AndExp <em>And Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>And Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AndExp
     * @generated
     */
        EClass getAndExp();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.AndExp#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Expressions</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AndExp#getExpressions()
     * @see #getAndExp()
     * @generated
     */
        EReference getAndExp_Expressions();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp <em>Atom Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Atom Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AtomExp
     * @generated
     */
        EClass getAtomExp();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getAndExp <em>And Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>And Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getAndExp()
     * @see #getAtomExp()
     * @generated
     */
        EReference getAtomExp_AndExp();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyName <em>Property Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Property Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyName()
     * @see #getAtomExp()
     * @generated
     */
        EAttribute getAtomExp_PropertyName();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyReference <em>Property Reference</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Property Reference</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyReference()
     * @see #getAtomExp()
     * @generated
     */
        EReference getAtomExp_PropertyReference();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp <em>Equals Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equals Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp
     * @generated
     */
        EClass getEqualsExp();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp#getValue()
     * @see #getEqualsExp()
     * @generated
     */
        EReference getEqualsExp_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp <em>Boolean Property Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Property Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp
     * @generated
     */
        EClass getBooleanPropertyExp();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp <em>Is Defined Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Is Defined Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp
     * @generated
     */
        EClass getIsDefinedExp();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OneExp <em>One Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>One Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OneExp
     * @generated
     */
        EClass getOneExp();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Value <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Value
     * @generated
     */
        EClass getValue();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Value#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Value#getName()
     * @see #getValue()
     * @generated
     */
        EAttribute getValue_Name();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyVal <em>Property Val</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Val</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyVal
     * @generated
     */
        EClass getPropertyVal();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Token <em>Token</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Token</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Token
     * @generated
     */
        EClass getToken();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.Token#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Pattern</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Token#getPattern()
     * @see #getToken()
     * @generated
     */
        EReference getToken_Pattern();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Token#isOmitted <em>Omitted</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Omitted</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Token#isOmitted()
     * @see #getToken()
     * @generated
     */
        EAttribute getToken_Omitted();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OrPattern <em>Or Pattern</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Or Pattern</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OrPattern
     * @generated
     */
        EClass getOrPattern();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.OrPattern#getSimplePatterns <em>Simple Patterns</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Simple Patterns</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OrPattern#getSimplePatterns()
     * @see #getOrPattern()
     * @generated
     */
        EReference getOrPattern_SimplePatterns();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern <em>Simple Pattern</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Pattern</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern
     * @generated
     */
        EClass getSimplePattern();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.RulePattern <em>Rule Pattern</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rule Pattern</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.RulePattern
     * @generated
     */
        EClass getRulePattern();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.RulePattern#getRule <em>Rule</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Rule</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.RulePattern#getRule()
     * @see #getRulePattern()
     * @generated
     */
        EReference getRulePattern_Rule();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Rule <em>Rule</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rule</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Rule
     * @generated
     */
        EClass getRule();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.WordRule <em>Word Rule</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Word Rule</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.WordRule
     * @generated
     */
        EClass getWordRule();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Start</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getStart()
     * @see #getWordRule()
     * @generated
     */
        EReference getWordRule_Start();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getPart <em>Part</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Part</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getPart()
     * @see #getWordRule()
     * @generated
     */
        EReference getWordRule_Part();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>End</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getEnd()
     * @see #getWordRule()
     * @generated
     */
        EReference getWordRule_End();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getWords <em>Words</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Words</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.WordRule#getWords()
     * @see #getWordRule()
     * @generated
     */
        EReference getWordRule_Words();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Word <em>Word</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Word</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Word
     * @generated
     */
        EClass getWord();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.Word#getToken <em>Token</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Token</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Word#getToken()
     * @see #getWord()
     * @generated
     */
        EAttribute getWord_Token();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule <em>End Of Line Rule</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>End Of Line Rule</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule
     * @generated
     */
        EClass getEndOfLineRule();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Start</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule#getStart()
     * @see #getEndOfLineRule()
     * @generated
     */
        EReference getEndOfLineRule_Start();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule#isDropStart <em>Drop Start</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Drop Start</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule#isDropStart()
     * @see #getEndOfLineRule()
     * @generated
     */
        EAttribute getEndOfLineRule_DropStart();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule <em>Multi Line Rule</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Multi Line Rule</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule
     * @generated
     */
        EClass getMultiLineRule();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Start</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getStart()
     * @see #getMultiLineRule()
     * @generated
     */
        EReference getMultiLineRule_Start();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>End</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEnd()
     * @see #getMultiLineRule()
     * @generated
     */
        EReference getMultiLineRule_End();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEsc <em>Esc</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Esc</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEsc()
     * @see #getMultiLineRule()
     * @generated
     */
        EReference getMultiLineRule_Esc();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEscMappings <em>Esc Mappings</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Esc Mappings</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEscMappings()
     * @see #getMultiLineRule()
     * @generated
     */
        EReference getMultiLineRule_EscMappings();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropStart <em>Drop Start</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Drop Start</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropStart()
     * @see #getMultiLineRule()
     * @generated
     */
        EAttribute getMultiLineRule_DropStart();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropEnd <em>Drop End</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Drop End</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropEnd()
     * @see #getMultiLineRule()
     * @generated
     */
        EAttribute getMultiLineRule_DropEnd();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.Mapping <em>Mapping</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Mapping
     * @generated
     */
        EClass getMapping();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping <em>Simple Mapping</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Mapping</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping
     * @generated
     */
        EClass getSimpleMapping();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping#getKey()
     * @see #getSimpleMapping()
     * @generated
     */
    EAttribute getSimpleMapping_Key();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping#getValue()
     * @see #getSimpleMapping()
     * @generated
     */
    EAttribute getSimpleMapping_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.WildcardMapping <em>Wildcard Mapping</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Wildcard Mapping</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.WildcardMapping
     * @generated
     */
        EClass getWildcardMapping();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OctalMapping <em>Octal Mapping</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Octal Mapping</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OctalMapping
     * @generated
     */
        EClass getOctalMapping();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.HexadecimalMapping <em>Hexadecimal Mapping</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hexadecimal Mapping</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.HexadecimalMapping
     * @generated
     */
        EClass getHexadecimalMapping();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.StringPattern <em>String Pattern</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Pattern</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StringPattern
     * @generated
     */
        EClass getStringPattern();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassPattern <em>Class Pattern</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Class Pattern</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ClassPattern
     * @generated
     */
        EClass getClassPattern();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement <em>Qualified Named Element</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Qualified Named Element</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement
     * @generated
     */
        EClass getQualifiedNamedElement();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getNames <em>Names</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Names</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getNames()
     * @see #getQualifiedNamedElement()
     * @generated
     */
        EAttribute getQualifiedNamedElement_Names();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getMetaReference <em>Meta Reference</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Meta Reference</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getMetaReference()
     * @see #getQualifiedNamedElement()
     * @generated
     */
        EReference getQualifiedNamedElement_MetaReference();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg <em>Forced Upper PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Forced Upper PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg
     * @generated
     */
        EClass getForcedUpperPArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg#getValue()
     * @see #getForcedUpperPArg()
     * @generated
     */
        EAttribute getForcedUpperPArg_Value();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock <em>Injector Actions Block</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Injector Actions Block</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock
     * @generated
     */
        EClass getInjectorActionsBlock();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock#getPropertyInits <em>Property Inits</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property Inits</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock#getPropertyInits()
     * @see #getInjectorActionsBlock()
     * @generated
     */
        EReference getInjectorActionsBlock_PropertyInits();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock#getInjectorActions <em>Injector Actions</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Injector Actions</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock#getInjectorActions()
     * @see #getInjectorActionsBlock()
     * @generated
     */
        EReference getInjectorActionsBlock_InjectorActions();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg <em>Query PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg
     * @generated
     */
        EClass getQueryPArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg#getQuery <em>Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg#getQuery()
     * @see #getQueryPArg()
     * @generated
     */
    EAttribute getQueryPArg_Query();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg <em>Query By Identifier PArg</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query By Identifier PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg
     * @generated
     */
    EClass getQueryByIdentifierPArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg#getQuery <em>Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg#getQuery()
     * @see #getQueryByIdentifierPArg()
     * @generated
     */
    EAttribute getQueryByIdentifierPArg_Query();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg#getFeature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Feature</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg#getFeature()
     * @see #getQueryByIdentifierPArg()
     * @generated
     */
    EAttribute getQueryByIdentifierPArg_Feature();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg <em>Filter PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Filter PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg
     * @generated
     */
        EClass getFilterPArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getFilter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filter</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getFilter()
     * @see #getFilterPArg()
     * @generated
     */
        EAttribute getFilterPArg_Filter();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getInvert <em>Invert</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Invert</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getInvert()
     * @see #getFilterPArg()
     * @generated
     */
        EAttribute getFilterPArg_Invert();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg <em>Ocl PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OclPArg
     * @generated
     */
        EClass getOclPArg();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQueryExpression <em>Query Expression</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Query Expression</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQueryExpression()
     * @see #getOclPArg()
     * @generated
     */
        EReference getOclPArg_QueryExpression();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQuery <em>Query</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQuery()
     * @see #getOclPArg()
     * @generated
     */
        EAttribute getOclPArg_Query();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference <em>Property Reference</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Reference</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference
     * @generated
     */
        EClass getPropertyReference();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getStrucfeature <em>Strucfeature</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Strucfeature</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getStrucfeature()
     * @see #getPropertyReference()
     * @generated
     */
        EReference getPropertyReference_Strucfeature();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getName()
     * @see #getPropertyReference()
     * @generated
     */
        EAttribute getPropertyReference_Name();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate <em>Context Template</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context Template</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate
     * @generated
     */
        EClass getContextTemplate();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsContext <em>Is Context</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Context</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsContext()
     * @see #getContextTemplate()
     * @generated
     */
        EAttribute getContextTemplate_IsContext();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsAddToContext <em>Is Add To Context</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Add To Context</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsAddToContext()
     * @see #getContextTemplate()
     * @generated
     */
        EAttribute getContextTemplate_IsAddToContext();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsReferenceOnly <em>Is Reference Only</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Reference Only</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsReferenceOnly()
     * @see #getContextTemplate()
     * @generated
     */
        EAttribute getContextTemplate_IsReferenceOnly();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getContextTags <em>Context Tags</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Context Tags</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getContextTags()
     * @see #getContextTemplate()
     * @generated
     */
        EReference getContextTemplate_ContextTags();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getScope <em>Scope</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Scope</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getScope()
     * @see #getContextTemplate()
     * @generated
     */
        EReference getContextTemplate_Scope();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getTemplateSequence <em>Template Sequence</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Template Sequence</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getTemplateSequence()
     * @see #getContextTemplate()
     * @generated
     */
    EReference getContextTemplate_TemplateSequence();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTags <em>Context Tags</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context Tags</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTags
     * @generated
     */
        EClass getContextTags();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTags#getTags <em>Tags</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Tags</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ContextTags#getTags()
     * @see #getContextTags()
     * @generated
     */
        EAttribute getContextTags_Tags();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction <em>Injector Action</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Injector Action</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction
     * @generated
     */
        EClass getInjectorAction();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction#getInjectorActionsBlock <em>Injector Actions Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Injector Actions Block</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction#getInjectorActionsBlock()
     * @see #getInjectorAction()
     * @generated
     */
    EReference getInjectorAction_InjectorActionsBlock();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit <em>Property Init</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Init</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit
     * @generated
     */
        EClass getPropertyInit();

        /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getPropertyReference <em>Property Reference</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Property Reference</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getPropertyReference()
     * @see #getPropertyInit()
     * @generated
     */
        EReference getPropertyInit_PropertyReference();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getValue()
     * @see #getPropertyInit()
     * @generated
     */
        EAttribute getPropertyInit_Value();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#isDefault <em>Default</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#isDefault()
     * @see #getPropertyInit()
     * @generated
     */
    EAttribute getPropertyInit_Default();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit <em>Ocl Property Init</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl Property Init</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit
     * @generated
     */
        EClass getOclPropertyInit();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit#getOclExpression <em>Ocl Expression</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ocl Expression</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit#getOclExpression()
     * @see #getOclPropertyInit()
     * @generated
     */
        EReference getOclPropertyInit_OclExpression();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg <em>Scope Arg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scope Arg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg
     * @generated
     */
        EClass getScopeArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg#getScope <em>Scope</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Scope</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg#getScope()
     * @see #getScopeArg()
     * @generated
     */
        EAttribute getScopeArg_Scope();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit <em>Foreach Predicate Property Init</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Foreach Predicate Property Init</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit
     * @generated
     */
        EClass getForeachPredicatePropertyInit();

        /**
     * Returns the meta object for the containment reference list '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit#getPredicateSemantic <em>Predicate Semantic</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Predicate Semantic</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit#getPredicateSemantic()
     * @see #getForeachPredicatePropertyInit()
     * @generated
     */
        EReference getForeachPredicatePropertyInit_PredicateSemantic();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit#getMode <em>Mode</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mode</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit#getMode()
     * @see #getForeachPredicatePropertyInit()
     * @generated
     */
        EAttribute getForeachPredicatePropertyInit_Mode();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic <em>Predicate Semantic</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Predicate Semantic</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic
     * @generated
     */
        EClass getPredicateSemantic();

        /**
     * Returns the meta object for the reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getAs <em>As</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>As</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getAs()
     * @see #getPredicateSemantic()
     * @generated
     */
        EReference getPredicateSemantic_As();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getWhen <em>When</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>When</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getWhen()
     * @see #getPredicateSemantic()
     * @generated
     */
        EAttribute getPredicateSemantic_When();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getMode <em>Mode</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mode</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getMode()
     * @see #getPredicateSemantic()
     * @generated
     */
        EAttribute getPredicateSemantic_Mode();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getForeachParent <em>Foreach Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Foreach Parent</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getForeachParent()
     * @see #getPredicateSemantic()
     * @generated
     */
    EReference getPredicateSemantic_ForeachParent();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative <em>Sequence In Alternative</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence In Alternative</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative
     * @generated
     */
        EClass getSequenceInAlternative();

        /**
     * Returns the meta object for the container reference '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getAlternativeContainer <em>Alternative Container</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Alternative Container</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getAlternativeContainer()
     * @see #getSequenceInAlternative()
     * @generated
     */
        EReference getSequenceInAlternative_AlternativeContainer();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getDisambiguate <em>Disambiguate</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disambiguate</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getDisambiguate()
     * @see #getSequenceInAlternative()
     * @generated
     */
        EAttribute getSequenceInAlternative_Disambiguate();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg <em>Partial PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Partial PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg
     * @generated
     */
        EClass getPartialPArg();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg <em>Disambiguate PArg</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Disambiguate PArg</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg
     * @generated
     */
        EClass getDisambiguatePArg();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg#getDisambiguation <em>Disambiguation</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disambiguation</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg#getDisambiguation()
     * @see #getDisambiguatePArg()
     * @generated
     */
        EAttribute getDisambiguatePArg_Disambiguation();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp <em>Instance Of Exp</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Instance Of Exp</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp
     * @generated
     */
        EClass getInstanceOfExp();

        /**
     * Returns the meta object for the attribute list '{@link com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp#getSupertype <em>Supertype</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Supertype</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp#getSupertype()
     * @see #getInstanceOfExp()
     * @generated
     */
        EAttribute getInstanceOfExp_Supertype();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralVal <em>Enum Literal Val</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Literal Val</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralVal
     * @generated
     */
        EClass getEnumLiteralVal();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.StringVal <em>String Val</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Val</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StringVal
     * @generated
     */
        EClass getStringVal();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.StringVal#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.StringVal#getSymbol()
     * @see #getStringVal()
     * @generated
     */
        EAttribute getStringVal_Symbol();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal <em>Integer Val</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Val</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal
     * @generated
     */
        EClass getIntegerVal();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal#getSymbol()
     * @see #getIntegerVal()
     * @generated
     */
        EAttribute getIntegerVal_Symbol();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal <em>Negative Integer Val</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Negative Integer Val</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal
     * @generated
     */
        EClass getNegativeIntegerVal();

        /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal#getSymbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal#getSymbol()
     * @see #getNegativeIntegerVal()
     * @generated
     */
        EAttribute getNegativeIntegerVal_Symbol();

        /**
     * Returns the meta object for class '{@link com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit <em>Lookup Property Init</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for class '<em>Lookup Property Init</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit
     * @generated
     */
        EClass getLookupPropertyInit();

        /**
     * Returns the meta object for enum '{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers <em>Template Modifiers</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Template Modifiers</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers
     * @generated
     */
        EEnum getTemplateModifiers();

        /**
     * Returns the meta object for enum '{@link com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind <em>Space Kind</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Space Kind</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind
     * @generated
     */
        EEnum getSpaceKind();

        /**
     * Returns the meta object for enum '{@link com.sap.furcas.metamodel.FURCAS.TCS.Associativity <em>Associativity</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Associativity</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Associativity
     * @generated
     */
        EEnum getAssociativity();

        /**
     * Returns the meta object for enum '{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind <em>Auto Create Kind</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Auto Create Kind</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind
     * @generated
     */
        EEnum getAutoCreateKind();

        /**
     * Returns the meta object for enum '{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind <em>Scope Kind</em>}'.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Scope Kind</em>'.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind
     * @generated
     */
        EEnum getScopeKind();

        /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
        TCSFactory getTCSFactory();

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
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LocatedElementImpl <em>Located Element</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LocatedElementImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLocatedElement()
         * @generated
         */
                EClass LOCATED_ELEMENT = eINSTANCE.getLocatedElement();

                /**
         * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute LOCATED_ELEMENT__LOCATION = eINSTANCE.getLocatedElement_Location();

                /**
         * The meta object literal for the '<em><b>Comments Before</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute LOCATED_ELEMENT__COMMENTS_BEFORE = eINSTANCE.getLocatedElement_CommentsBefore();

                /**
         * The meta object literal for the '<em><b>Comments After</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute LOCATED_ELEMENT__COMMENTS_AFTER = eINSTANCE.getLocatedElement_CommentsAfter();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.NamedElementImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getNamedElement()
         * @generated
         */
                EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getConcreteSyntax()
         * @generated
         */
                EClass CONCRETE_SYNTAX = eINSTANCE.getConcreteSyntax();

                /**
         * The meta object literal for the '<em><b>K</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CONCRETE_SYNTAX__K = eINSTANCE.getConcreteSyntax_K();

                /**
         * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONCRETE_SYNTAX__TEMPLATES = eINSTANCE.getConcreteSyntax_Templates();

                /**
         * The meta object literal for the '<em><b>Keywords</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONCRETE_SYNTAX__KEYWORDS = eINSTANCE.getConcreteSyntax_Keywords();

                /**
         * The meta object literal for the '<em><b>Symbols</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONCRETE_SYNTAX__SYMBOLS = eINSTANCE.getConcreteSyntax_Symbols();

                /**
         * The meta object literal for the '<em><b>Operator Lists</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONCRETE_SYNTAX__OPERATOR_LISTS = eINSTANCE.getConcreteSyntax_OperatorLists();

                /**
         * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONCRETE_SYNTAX__TOKENS = eINSTANCE.getConcreteSyntax_Tokens();

                /**
         * The meta object literal for the '<em><b>Lexer</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CONCRETE_SYNTAX__LEXER = eINSTANCE.getConcreteSyntax_Lexer();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl <em>Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getTemplate()
         * @generated
         */
                EClass TEMPLATE = eINSTANCE.getTemplate();

                /**
         * The meta object literal for the '<em><b>Concrete Syntax</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference TEMPLATE__CONCRETE_SYNTAX = eINSTANCE.getTemplate_ConcreteSyntax();

                /**
         * The meta object literal for the '<em><b>Disambiguate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute TEMPLATE__DISAMBIGUATE = eINSTANCE.getTemplate_Disambiguate();

                /**
         * The meta object literal for the '<em><b>Disambiguate V3</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute TEMPLATE__DISAMBIGUATE_V3 = eINSTANCE.getTemplate_DisambiguateV3();

                /**
         * The meta object literal for the '<em><b>Sem Disambiguate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TEMPLATE__SEM_DISAMBIGUATE = eINSTANCE.getTemplate_SemDisambiguate();

																/**
         * The meta object literal for the '<em><b>Text Block Definition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TEMPLATE__TEXT_BLOCK_DEFINITION = eINSTANCE.getTemplate_TextBlockDefinition();

																/**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionTemplateImpl <em>Function Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionTemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getFunctionTemplate()
         * @generated
         */
                EClass FUNCTION_TEMPLATE = eINSTANCE.getFunctionTemplate();

                /**
         * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute FUNCTION_TEMPLATE__FUNCTION_NAME = eINSTANCE.getFunctionTemplate_FunctionName();

                /**
         * The meta object literal for the '<em><b>Function Sequence</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference FUNCTION_TEMPLATE__FUNCTION_SEQUENCE = eINSTANCE.getFunctionTemplate_FunctionSequence();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl <em>Class Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getClassTemplate()
         * @generated
         */
                EClass CLASS_TEMPLATE = eINSTANCE.getClassTemplate();

                /**
         * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__MODIFIERS = eINSTANCE.getClassTemplate_Modifiers();

                /**
         * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__IS_ABSTRACT = eINSTANCE.getClassTemplate_IsAbstract();

                /**
         * The meta object literal for the '<em><b>Is Deep</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__IS_DEEP = eINSTANCE.getClassTemplate_IsDeep();

                /**
         * The meta object literal for the '<em><b>Is Operatored</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__IS_OPERATORED = eINSTANCE.getClassTemplate_IsOperatored();

                /**
         * The meta object literal for the '<em><b>Operator List</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CLASS_TEMPLATE__OPERATOR_LIST = eINSTANCE.getClassTemplate_OperatorList();

                /**
         * The meta object literal for the '<em><b>Is Main</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__IS_MAIN = eINSTANCE.getClassTemplate_IsMain();

                /**
         * The meta object literal for the '<em><b>Is Multi</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__IS_MULTI = eINSTANCE.getClassTemplate_IsMulti();

                /**
         * The meta object literal for the '<em><b>Is Non Primary</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__IS_NON_PRIMARY = eINSTANCE.getClassTemplate_IsNonPrimary();

                /**
         * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CLASS_TEMPLATE__MODE = eINSTANCE.getClassTemplate_Mode();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl <em>Primitive Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPrimitiveTemplate()
         * @generated
         */
                EClass PRIMITIVE_TEMPLATE = eINSTANCE.getPrimitiveTemplate();

                /**
         * The meta object literal for the '<em><b>Template Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIMITIVE_TEMPLATE__TEMPLATE_NAME = eINSTANCE.getPrimitiveTemplate_TemplateName();

                /**
         * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMITIVE_TEMPLATE__DEFAULT = eINSTANCE.getPrimitiveTemplate_Default();

                /**
         * The meta object literal for the '<em><b>Token Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIMITIVE_TEMPLATE__TOKEN_NAME = eINSTANCE.getPrimitiveTemplate_TokenName();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIMITIVE_TEMPLATE__VALUE = eINSTANCE.getPrimitiveTemplate_Value();

                /**
         * The meta object literal for the '<em><b>Serializer</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIMITIVE_TEMPLATE__SERIALIZER = eINSTANCE.getPrimitiveTemplate_Serializer();

                /**
         * The meta object literal for the '<em><b>Or Keyword</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIMITIVE_TEMPLATE__OR_KEYWORD = eINSTANCE.getPrimitiveTemplate_OrKeyword();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl <em>Operator Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOperatorTemplate()
         * @generated
         */
                EClass OPERATOR_TEMPLATE = eINSTANCE.getOperatorTemplate();

                /**
         * The meta object literal for the '<em><b>Operators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR_TEMPLATE__OPERATORS = eINSTANCE.getOperatorTemplate_Operators();

                /**
         * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute OPERATOR_TEMPLATE__SOURCE = eINSTANCE.getOperatorTemplate_Source();

                /**
         * The meta object literal for the '<em><b>Store Op To</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute OPERATOR_TEMPLATE__STORE_OP_TO = eINSTANCE.getOperatorTemplate_StoreOpTo();

                /**
         * The meta object literal for the '<em><b>Store Right To</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute OPERATOR_TEMPLATE__STORE_RIGHT_TO = eINSTANCE.getOperatorTemplate_StoreRightTo();

                /**
         * The meta object literal for the '<em><b>Store Operator To</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR_TEMPLATE__STORE_OPERATOR_TO = eINSTANCE.getOperatorTemplate_StoreOperatorTo();

                /**
         * The meta object literal for the '<em><b>Store Left Side To</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO = eINSTANCE.getOperatorTemplate_StoreLeftSideTo();

                /**
         * The meta object literal for the '<em><b>Store Right Side To</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO = eINSTANCE.getOperatorTemplate_StoreRightSideTo();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumerationTemplateImpl <em>Enumeration Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumerationTemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEnumerationTemplate()
         * @generated
         */
                EClass ENUMERATION_TEMPLATE = eINSTANCE.getEnumerationTemplate();

                /**
         * The meta object literal for the '<em><b>Automatic</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute ENUMERATION_TEMPLATE__AUTOMATIC = eINSTANCE.getEnumerationTemplate_Automatic();

                /**
         * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference ENUMERATION_TEMPLATE__MAPPINGS = eINSTANCE.getEnumerationTemplate_Mappings();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralMappingImpl <em>Enum Literal Mapping</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralMappingImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEnumLiteralMapping()
         * @generated
         */
                EClass ENUM_LITERAL_MAPPING = eINSTANCE.getEnumLiteralMapping();

                /**
         * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference ENUM_LITERAL_MAPPING__LITERAL = eINSTANCE.getEnumLiteralMapping_Literal();

                /**
         * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference ENUM_LITERAL_MAPPING__ELEMENT = eINSTANCE.getEnumLiteralMapping_Element();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl <em>Literal</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLiteral()
         * @generated
         */
                EClass LITERAL = eINSTANCE.getLiteral();

                /**
         * The meta object literal for the '<em><b>Operators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference LITERAL__OPERATORS = eINSTANCE.getLiteral_Operators();

                /**
         * The meta object literal for the '<em><b>Literal Refs</b></em>' reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference LITERAL__LITERAL_REFS = eINSTANCE.getLiteral_LiteralRefs();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SymbolImpl <em>Symbol</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SymbolImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSymbol()
         * @generated
         */
                EClass SYMBOL = eINSTANCE.getSymbol();

                /**
         * The meta object literal for the '<em><b>Spaces</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute SYMBOL__SPACES = eINSTANCE.getSymbol_Spaces();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.KeywordImpl <em>Keyword</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.KeywordImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getKeyword()
         * @generated
         */
                EClass KEYWORD = eINSTANCE.getKeyword();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorListImpl <em>Operator List</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorListImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOperatorList()
         * @generated
         */
                EClass OPERATOR_LIST = eINSTANCE.getOperatorList();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute OPERATOR_LIST__NAME = eINSTANCE.getOperatorList_Name();

                /**
         * The meta object literal for the '<em><b>Priorities</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR_LIST__PRIORITIES = eINSTANCE.getOperatorList_Priorities();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl <em>Priority</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PriorityImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPriority()
         * @generated
         */
                EClass PRIORITY = eINSTANCE.getPriority();

                /**
         * The meta object literal for the '<em><b>List</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PRIORITY__LIST = eINSTANCE.getPriority_List();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIORITY__VALUE = eINSTANCE.getPriority_Value();

                /**
         * The meta object literal for the '<em><b>Associativity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PRIORITY__ASSOCIATIVITY = eINSTANCE.getPriority_Associativity();

                /**
         * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PRIORITY__OPERATORS = eINSTANCE.getPriority_Operators();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl <em>Operator</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOperator()
         * @generated
         */
                EClass OPERATOR = eINSTANCE.getOperator();

                /**
         * The meta object literal for the '<em><b>Postfix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPERATOR__POSTFIX = eINSTANCE.getOperator_Postfix();

                /**
         * The meta object literal for the '<em><b>Arity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute OPERATOR__ARITY = eINSTANCE.getOperator_Arity();

                /**
         * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR__LITERAL = eINSTANCE.getOperator_Literal();

                /**
         * The meta object literal for the '<em><b>Priority</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR__PRIORITY = eINSTANCE.getOperator_Priority();

                /**
         * The meta object literal for the '<em><b>Templates</b></em>' reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OPERATOR__TEMPLATES = eINSTANCE.getOperator_Templates();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl <em>Sequence</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSequence()
         * @generated
         */
                EClass SEQUENCE = eINSTANCE.getSequence();

                /**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__ELEMENTS = eINSTANCE.getSequence_Elements();

                /**
         * The meta object literal for the '<em><b>Template Container</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__TEMPLATE_CONTAINER = eINSTANCE.getSequence_TemplateContainer();

                /**
         * The meta object literal for the '<em><b>Prefix Container</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__PREFIX_CONTAINER = eINSTANCE.getSequence_PrefixContainer();

                /**
         * The meta object literal for the '<em><b>Function Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__FUNCTION_CONTAINER = eINSTANCE.getSequence_FunctionContainer();

                /**
         * The meta object literal for the '<em><b>Block Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__BLOCK_CONTAINER = eINSTANCE.getSequence_BlockContainer();

                /**
         * The meta object literal for the '<em><b>Then Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__THEN_CONTAINER = eINSTANCE.getSequence_ThenContainer();

                /**
         * The meta object literal for the '<em><b>Else Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__ELSE_CONTAINER = eINSTANCE.getSequence_ElseContainer();

                /**
         * The meta object literal for the '<em><b>Separator Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__SEPARATOR_CONTAINER = eINSTANCE.getSequence_SeparatorContainer();

                /**
         * The meta object literal for the '<em><b>Ot Container</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE__OT_CONTAINER = eINSTANCE.getSequence_OtContainer();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceElementImpl <em>Sequence Element</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceElementImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSequenceElement()
         * @generated
         */
                EClass SEQUENCE_ELEMENT = eINSTANCE.getSequenceElement();

                /**
         * The meta object literal for the '<em><b>Element Sequence</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE_ELEMENT__ELEMENT_SEQUENCE = eINSTANCE.getSequenceElement_ElementSequence();

                /**
         * The meta object literal for the '<em><b>Parent Template</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE_ELEMENT__PARENT_TEMPLATE = eINSTANCE.getSequenceElement_ParentTemplate();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralRefImpl <em>Literal Ref</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LiteralRefImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLiteralRef()
         * @generated
         */
                EClass LITERAL_REF = eINSTANCE.getLiteralRef();

                /**
         * The meta object literal for the '<em><b>Referred Literal</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference LITERAL_REF__REFERRED_LITERAL = eINSTANCE.getLiteralRef_ReferredLiteral();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyImpl <em>Property</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getProperty()
         * @generated
         */
                EClass PROPERTY = eINSTANCE.getProperty();

                /**
         * The meta object literal for the '<em><b>Property Args</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PROPERTY__PROPERTY_ARGS = eINSTANCE.getProperty_PropertyArgs();

                /**
         * The meta object literal for the '<em><b>Property Reference</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PROPERTY__PROPERTY_REFERENCE = eINSTANCE.getProperty_PropertyReference();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.CustomSeparatorImpl <em>Custom Separator</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.CustomSeparatorImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getCustomSeparator()
         * @generated
         */
                EClass CUSTOM_SEPARATOR = eINSTANCE.getCustomSeparator();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CUSTOM_SEPARATOR__NAME = eINSTANCE.getCustomSeparator_Name();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockImpl <em>Block</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getBlock()
         * @generated
         */
                EClass BLOCK = eINSTANCE.getBlock();

                /**
         * The meta object literal for the '<em><b>Block Sequence</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference BLOCK__BLOCK_SEQUENCE = eINSTANCE.getBlock_BlockSequence();

                /**
         * The meta object literal for the '<em><b>Block Args</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference BLOCK__BLOCK_ARGS = eINSTANCE.getBlock_BlockArgs();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl <em>Conditional Element</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getConditionalElement()
         * @generated
         */
                EClass CONDITIONAL_ELEMENT = eINSTANCE.getConditionalElement();

                /**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONDITIONAL_ELEMENT__CONDITION = eINSTANCE.getConditionalElement_Condition();

                /**
         * The meta object literal for the '<em><b>Then Sequence</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONDITIONAL_ELEMENT__THEN_SEQUENCE = eINSTANCE.getConditionalElement_ThenSequence();

                /**
         * The meta object literal for the '<em><b>Else Sequence</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONDITIONAL_ELEMENT__ELSE_SEQUENCE = eINSTANCE.getConditionalElement_ElseSequence();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitivePropertyInitImpl <em>Primitive Property Init</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitivePropertyInitImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPrimitivePropertyInit()
         * @generated
         */
                EClass PRIMITIVE_PROPERTY_INIT = eINSTANCE.getPrimitivePropertyInit();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AlternativeImpl <em>Alternative</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AlternativeImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAlternative()
         * @generated
         */
                EClass ALTERNATIVE = eINSTANCE.getAlternative();

                /**
         * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference ALTERNATIVE__SEQUENCES = eINSTANCE.getAlternative_Sequences();

                /**
         * The meta object literal for the '<em><b>Is Multi</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute ALTERNATIVE__IS_MULTI = eINSTANCE.getAlternative_IsMulti();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionCallImpl <em>Function Call</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionCallImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getFunctionCall()
         * @generated
         */
                EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

                /**
         * The meta object literal for the '<em><b>Called Function</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference FUNCTION_CALL__CALLED_FUNCTION = eINSTANCE.getFunctionCall_CalledFunction();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyArgImpl <em>Property Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyArg()
         * @generated
         */
                EClass PROPERTY_ARG = eINSTANCE.getPropertyArg();

                /**
         * The meta object literal for the '<em><b>Property</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PROPERTY_ARG__PROPERTY = eINSTANCE.getPropertyArg_Property();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToPArgImpl <em>Refers To PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRefersToPArg()
         * @generated
         */
                EClass REFERS_TO_PARG = eINSTANCE.getRefersToPArg();

                /**
         * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute REFERS_TO_PARG__PROPERTY_NAME = eINSTANCE.getRefersToPArg_PropertyName();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LookInPArgImpl <em>Look In PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LookInPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLookInPArg()
         * @generated
         */
                EClass LOOK_IN_PARG = eINSTANCE.getLookInPArg();

                /**
         * The meta object literal for the '<em><b>Property Name</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute LOOK_IN_PARG__PROPERTY_NAME = eINSTANCE.getLookInPArg_PropertyName();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateInPArgImpl <em>Create In PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateInPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getCreateInPArg()
         * @generated
         */
                EClass CREATE_IN_PARG = eINSTANCE.getCreateInPArg();

                /**
         * The meta object literal for the '<em><b>Property Name</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CREATE_IN_PARG__PROPERTY_NAME = eINSTANCE.getCreateInPArg_PropertyName();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToKeyPArgImpl <em>Refers To Key PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RefersToKeyPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRefersToKeyPArg()
         * @generated
         */
                EClass REFERS_TO_KEY_PARG = eINSTANCE.getRefersToKeyPArg();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SeparatorPArgImpl <em>Separator PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SeparatorPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSeparatorPArg()
         * @generated
         */
                EClass SEPARATOR_PARG = eINSTANCE.getSeparatorPArg();

                /**
         * The meta object literal for the '<em><b>Separator Sequence</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEPARATOR_PARG__SEPARATOR_SEQUENCE = eINSTANCE.getSeparatorPArg_SeparatorSequence();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AutoCreatePArgImpl <em>Auto Create PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AutoCreatePArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAutoCreatePArg()
         * @generated
         */
                EClass AUTO_CREATE_PARG = eINSTANCE.getAutoCreatePArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute AUTO_CREATE_PARG__VALUE = eINSTANCE.getAutoCreatePArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ImportContextPArgImpl <em>Import Context PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ImportContextPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getImportContextPArg()
         * @generated
         */
                EClass IMPORT_CONTEXT_PARG = eINSTANCE.getImportContextPArg();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedLowerPArgImpl <em>Forced Lower PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedLowerPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getForcedLowerPArg()
         * @generated
         */
                EClass FORCED_LOWER_PARG = eINSTANCE.getForcedLowerPArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute FORCED_LOWER_PARG__VALUE = eINSTANCE.getForcedLowerPArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateAsPArgImpl <em>Create As PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.CreateAsPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getCreateAsPArg()
         * @generated
         */
                EClass CREATE_AS_PARG = eINSTANCE.getCreateAsPArg();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CREATE_AS_PARG__NAME = eINSTANCE.getCreateAsPArg_Name();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AsPArgImpl <em>As PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AsPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAsPArg()
         * @generated
         */
                EClass AS_PARG = eINSTANCE.getAsPArg();

                /**
         * The meta object literal for the '<em><b>Template</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference AS_PARG__TEMPLATE = eINSTANCE.getAsPArg_Template();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute AS_PARG__VALUE = eINSTANCE.getAsPArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ModePArgImpl <em>Mode PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ModePArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getModePArg()
         * @generated
         */
                EClass MODE_PARG = eINSTANCE.getModePArg();

                /**
         * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute MODE_PARG__MODE = eINSTANCE.getModePArg_Mode();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockArgImpl <em>Block Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getBlockArg()
         * @generated
         */
                EClass BLOCK_ARG = eINSTANCE.getBlockArg();

                /**
         * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference BLOCK_ARG__BLOCK = eINSTANCE.getBlockArg_Block();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.NbNLBArgImpl <em>Nb NLB Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.NbNLBArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getNbNLBArg()
         * @generated
         */
                EClass NB_NLB_ARG = eINSTANCE.getNbNLBArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NB_NLB_ARG__VALUE = eINSTANCE.getNbNLBArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.IndentIncrBArgImpl <em>Indent Incr BArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.IndentIncrBArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getIndentIncrBArg()
         * @generated
         */
                EClass INDENT_INCR_BARG = eINSTANCE.getIndentIncrBArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INDENT_INCR_BARG__VALUE = eINSTANCE.getIndentIncrBArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNLBArgImpl <em>Start NLB Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNLBArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStartNLBArg()
         * @generated
         */
                EClass START_NLB_ARG = eINSTANCE.getStartNLBArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute START_NLB_ARG__VALUE = eINSTANCE.getStartNLBArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNbNLBArgImpl <em>Start Nb NLB Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StartNbNLBArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStartNbNLBArg()
         * @generated
         */
                EClass START_NB_NLB_ARG = eINSTANCE.getStartNbNLBArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute START_NB_NLB_ARG__VALUE = eINSTANCE.getStartNbNLBArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EndNLBArgImpl <em>End NLB Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EndNLBArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEndNLBArg()
         * @generated
         */
                EClass END_NLB_ARG = eINSTANCE.getEndNLBArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute END_NLB_ARG__VALUE = eINSTANCE.getEndNLBArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ExpressionImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getExpression()
         * @generated
         */
                EClass EXPRESSION = eINSTANCE.getExpression();

                /**
         * The meta object literal for the '<em><b>Conditional Element</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference EXPRESSION__CONDITIONAL_ELEMENT = eINSTANCE.getExpression_ConditionalElement();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AndExpImpl <em>And Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AndExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAndExp()
         * @generated
         */
                EClass AND_EXP = eINSTANCE.getAndExp();

                /**
         * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference AND_EXP__EXPRESSIONS = eINSTANCE.getAndExp_Expressions();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl <em>Atom Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.AtomExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAtomExp()
         * @generated
         */
                EClass ATOM_EXP = eINSTANCE.getAtomExp();

                /**
         * The meta object literal for the '<em><b>And Exp</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference ATOM_EXP__AND_EXP = eINSTANCE.getAtomExp_AndExp();

                /**
         * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute ATOM_EXP__PROPERTY_NAME = eINSTANCE.getAtomExp_PropertyName();

                /**
         * The meta object literal for the '<em><b>Property Reference</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference ATOM_EXP__PROPERTY_REFERENCE = eINSTANCE.getAtomExp_PropertyReference();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EqualsExpImpl <em>Equals Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EqualsExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEqualsExp()
         * @generated
         */
                EClass EQUALS_EXP = eINSTANCE.getEqualsExp();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference EQUALS_EXP__VALUE = eINSTANCE.getEqualsExp_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BooleanPropertyExpImpl <em>Boolean Property Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.BooleanPropertyExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getBooleanPropertyExp()
         * @generated
         */
                EClass BOOLEAN_PROPERTY_EXP = eINSTANCE.getBooleanPropertyExp();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.IsDefinedExpImpl <em>Is Defined Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.IsDefinedExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getIsDefinedExp()
         * @generated
         */
                EClass IS_DEFINED_EXP = eINSTANCE.getIsDefinedExp();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OneExpImpl <em>One Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OneExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOneExp()
         * @generated
         */
                EClass ONE_EXP = eINSTANCE.getOneExp();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ValueImpl <em>Value</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ValueImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getValue()
         * @generated
         */
                EClass VALUE = eINSTANCE.getValue();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute VALUE__NAME = eINSTANCE.getValue_Name();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyValImpl <em>Property Val</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyValImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyVal()
         * @generated
         */
                EClass PROPERTY_VAL = eINSTANCE.getPropertyVal();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TokenImpl <em>Token</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TokenImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getToken()
         * @generated
         */
                EClass TOKEN = eINSTANCE.getToken();

                /**
         * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference TOKEN__PATTERN = eINSTANCE.getToken_Pattern();

                /**
         * The meta object literal for the '<em><b>Omitted</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute TOKEN__OMITTED = eINSTANCE.getToken_Omitted();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OrPatternImpl <em>Or Pattern</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OrPatternImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOrPattern()
         * @generated
         */
                EClass OR_PATTERN = eINSTANCE.getOrPattern();

                /**
         * The meta object literal for the '<em><b>Simple Patterns</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OR_PATTERN__SIMPLE_PATTERNS = eINSTANCE.getOrPattern_SimplePatterns();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SimplePatternImpl <em>Simple Pattern</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SimplePatternImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSimplePattern()
         * @generated
         */
                EClass SIMPLE_PATTERN = eINSTANCE.getSimplePattern();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RulePatternImpl <em>Rule Pattern</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RulePatternImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRulePattern()
         * @generated
         */
                EClass RULE_PATTERN = eINSTANCE.getRulePattern();

                /**
         * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference RULE_PATTERN__RULE = eINSTANCE.getRulePattern_Rule();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.RuleImpl <em>Rule</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.RuleImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getRule()
         * @generated
         */
                EClass RULE = eINSTANCE.getRule();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.WordRuleImpl <em>Word Rule</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.WordRuleImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getWordRule()
         * @generated
         */
                EClass WORD_RULE = eINSTANCE.getWordRule();

                /**
         * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference WORD_RULE__START = eINSTANCE.getWordRule_Start();

                /**
         * The meta object literal for the '<em><b>Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference WORD_RULE__PART = eINSTANCE.getWordRule_Part();

                /**
         * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference WORD_RULE__END = eINSTANCE.getWordRule_End();

                /**
         * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference WORD_RULE__WORDS = eINSTANCE.getWordRule_Words();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.WordImpl <em>Word</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.WordImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getWord()
         * @generated
         */
                EClass WORD = eINSTANCE.getWord();

                /**
         * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute WORD__TOKEN = eINSTANCE.getWord_Token();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EndOfLineRuleImpl <em>End Of Line Rule</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EndOfLineRuleImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEndOfLineRule()
         * @generated
         */
                EClass END_OF_LINE_RULE = eINSTANCE.getEndOfLineRule();

                /**
         * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference END_OF_LINE_RULE__START = eINSTANCE.getEndOfLineRule_Start();

                /**
         * The meta object literal for the '<em><b>Drop Start</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute END_OF_LINE_RULE__DROP_START = eINSTANCE.getEndOfLineRule_DropStart();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl <em>Multi Line Rule</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getMultiLineRule()
         * @generated
         */
                EClass MULTI_LINE_RULE = eINSTANCE.getMultiLineRule();

                /**
         * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference MULTI_LINE_RULE__START = eINSTANCE.getMultiLineRule_Start();

                /**
         * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference MULTI_LINE_RULE__END = eINSTANCE.getMultiLineRule_End();

                /**
         * The meta object literal for the '<em><b>Esc</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference MULTI_LINE_RULE__ESC = eINSTANCE.getMultiLineRule_Esc();

                /**
         * The meta object literal for the '<em><b>Esc Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference MULTI_LINE_RULE__ESC_MAPPINGS = eINSTANCE.getMultiLineRule_EscMappings();

                /**
         * The meta object literal for the '<em><b>Drop Start</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute MULTI_LINE_RULE__DROP_START = eINSTANCE.getMultiLineRule_DropStart();

                /**
         * The meta object literal for the '<em><b>Drop End</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute MULTI_LINE_RULE__DROP_END = eINSTANCE.getMultiLineRule_DropEnd();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MappingImpl <em>Mapping</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.MappingImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getMapping()
         * @generated
         */
                EClass MAPPING = eINSTANCE.getMapping();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SimpleMappingImpl <em>Simple Mapping</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SimpleMappingImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSimpleMapping()
         * @generated
         */
                EClass SIMPLE_MAPPING = eINSTANCE.getSimpleMapping();

                /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_MAPPING__KEY = eINSTANCE.getSimpleMapping_Key();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_MAPPING__VALUE = eINSTANCE.getSimpleMapping_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.WildcardMappingImpl <em>Wildcard Mapping</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.WildcardMappingImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getWildcardMapping()
         * @generated
         */
                EClass WILDCARD_MAPPING = eINSTANCE.getWildcardMapping();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OctalMappingImpl <em>Octal Mapping</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OctalMappingImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOctalMapping()
         * @generated
         */
                EClass OCTAL_MAPPING = eINSTANCE.getOctalMapping();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.HexadecimalMappingImpl <em>Hexadecimal Mapping</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.HexadecimalMappingImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getHexadecimalMapping()
         * @generated
         */
                EClass HEXADECIMAL_MAPPING = eINSTANCE.getHexadecimalMapping();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StringPatternImpl <em>String Pattern</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StringPatternImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStringPattern()
         * @generated
         */
                EClass STRING_PATTERN = eINSTANCE.getStringPattern();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassPatternImpl <em>Class Pattern</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassPatternImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getClassPattern()
         * @generated
         */
                EClass CLASS_PATTERN = eINSTANCE.getClassPattern();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QualifiedNamedElementImpl <em>Qualified Named Element</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.QualifiedNamedElementImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getQualifiedNamedElement()
         * @generated
         */
                EClass QUALIFIED_NAMED_ELEMENT = eINSTANCE.getQualifiedNamedElement();

                /**
         * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute QUALIFIED_NAMED_ELEMENT__NAMES = eINSTANCE.getQualifiedNamedElement_Names();

                /**
         * The meta object literal for the '<em><b>Meta Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference QUALIFIED_NAMED_ELEMENT__META_REFERENCE = eINSTANCE.getQualifiedNamedElement_MetaReference();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedUpperPArgImpl <em>Forced Upper PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ForcedUpperPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getForcedUpperPArg()
         * @generated
         */
                EClass FORCED_UPPER_PARG = eINSTANCE.getForcedUpperPArg();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute FORCED_UPPER_PARG__VALUE = eINSTANCE.getForcedUpperPArg_Value();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionsBlockImpl <em>Injector Actions Block</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionsBlockImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getInjectorActionsBlock()
         * @generated
         */
                EClass INJECTOR_ACTIONS_BLOCK = eINSTANCE.getInjectorActionsBlock();

                /**
         * The meta object literal for the '<em><b>Property Inits</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS = eINSTANCE.getInjectorActionsBlock_PropertyInits();

                /**
         * The meta object literal for the '<em><b>Injector Actions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS = eINSTANCE.getInjectorActionsBlock_InjectorActions();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryPArgImpl <em>Query PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getQueryPArg()
         * @generated
         */
                EClass QUERY_PARG = eINSTANCE.getQueryPArg();

                /**
         * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_PARG__QUERY = eINSTANCE.getQueryPArg_Query();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryByIdentifierPArgImpl <em>Query By Identifier PArg</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.QueryByIdentifierPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getQueryByIdentifierPArg()
         * @generated
         */
        EClass QUERY_BY_IDENTIFIER_PARG = eINSTANCE.getQueryByIdentifierPArg();

                /**
         * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_BY_IDENTIFIER_PARG__QUERY = eINSTANCE.getQueryByIdentifierPArg_Query();

                /**
         * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_BY_IDENTIFIER_PARG__FEATURE = eINSTANCE.getQueryByIdentifierPArg_Feature();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FilterPArgImpl <em>Filter PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.FilterPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getFilterPArg()
         * @generated
         */
                EClass FILTER_PARG = eINSTANCE.getFilterPArg();

                /**
         * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute FILTER_PARG__FILTER = eINSTANCE.getFilterPArg_Filter();

                /**
         * The meta object literal for the '<em><b>Invert</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute FILTER_PARG__INVERT = eINSTANCE.getFilterPArg_Invert();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPArgImpl <em>Ocl PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOclPArg()
         * @generated
         */
                EClass OCL_PARG = eINSTANCE.getOclPArg();

                /**
         * The meta object literal for the '<em><b>Query Expression</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OCL_PARG__QUERY_EXPRESSION = eINSTANCE.getOclPArg_QueryExpression();

                /**
         * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute OCL_PARG__QUERY = eINSTANCE.getOclPArg_Query();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl <em>Property Reference</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyReferenceImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyReference()
         * @generated
         */
                EClass PROPERTY_REFERENCE = eINSTANCE.getPropertyReference();

                /**
         * The meta object literal for the '<em><b>Strucfeature</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PROPERTY_REFERENCE__STRUCFEATURE = eINSTANCE.getPropertyReference_Strucfeature();

                /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PROPERTY_REFERENCE__NAME = eINSTANCE.getPropertyReference_Name();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl <em>Context Template</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getContextTemplate()
         * @generated
         */
                EClass CONTEXT_TEMPLATE = eINSTANCE.getContextTemplate();

                /**
         * The meta object literal for the '<em><b>Is Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CONTEXT_TEMPLATE__IS_CONTEXT = eINSTANCE.getContextTemplate_IsContext();

                /**
         * The meta object literal for the '<em><b>Is Add To Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT = eINSTANCE.getContextTemplate_IsAddToContext();

                /**
         * The meta object literal for the '<em><b>Is Reference Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CONTEXT_TEMPLATE__IS_REFERENCE_ONLY = eINSTANCE.getContextTemplate_IsReferenceOnly();

                /**
         * The meta object literal for the '<em><b>Context Tags</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONTEXT_TEMPLATE__CONTEXT_TAGS = eINSTANCE.getContextTemplate_ContextTags();

                /**
         * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference CONTEXT_TEMPLATE__SCOPE = eINSTANCE.getContextTemplate_Scope();

                /**
         * The meta object literal for the '<em><b>Template Sequence</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE = eINSTANCE.getContextTemplate_TemplateSequence();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTagsImpl <em>Context Tags</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTagsImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getContextTags()
         * @generated
         */
                EClass CONTEXT_TAGS = eINSTANCE.getContextTags();

                /**
         * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute CONTEXT_TAGS__TAGS = eINSTANCE.getContextTags_Tags();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionImpl <em>Injector Action</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getInjectorAction()
         * @generated
         */
                EClass INJECTOR_ACTION = eINSTANCE.getInjectorAction();

                /**
         * The meta object literal for the '<em><b>Injector Actions Block</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK = eINSTANCE.getInjectorAction_InjectorActionsBlock();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyInitImpl <em>Property Init</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyInitImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPropertyInit()
         * @generated
         */
                EClass PROPERTY_INIT = eINSTANCE.getPropertyInit();

                /**
         * The meta object literal for the '<em><b>Property Reference</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PROPERTY_INIT__PROPERTY_REFERENCE = eINSTANCE.getPropertyInit_PropertyReference();

                /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PROPERTY_INIT__VALUE = eINSTANCE.getPropertyInit_Value();

                /**
         * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY_INIT__DEFAULT = eINSTANCE.getPropertyInit_Default();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPropertyInitImpl <em>Ocl Property Init</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPropertyInitImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getOclPropertyInit()
         * @generated
         */
                EClass OCL_PROPERTY_INIT = eINSTANCE.getOclPropertyInit();

                /**
         * The meta object literal for the '<em><b>Ocl Expression</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference OCL_PROPERTY_INIT__OCL_EXPRESSION = eINSTANCE.getOclPropertyInit_OclExpression();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ScopeArgImpl <em>Scope Arg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ScopeArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getScopeArg()
         * @generated
         */
                EClass SCOPE_ARG = eINSTANCE.getScopeArg();

                /**
         * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute SCOPE_ARG__SCOPE = eINSTANCE.getScopeArg_Scope();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForeachPredicatePropertyInitImpl <em>Foreach Predicate Property Init</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.ForeachPredicatePropertyInitImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getForeachPredicatePropertyInit()
         * @generated
         */
                EClass FOREACH_PREDICATE_PROPERTY_INIT = eINSTANCE.getForeachPredicatePropertyInit();

                /**
         * The meta object literal for the '<em><b>Predicate Semantic</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC = eINSTANCE.getForeachPredicatePropertyInit_PredicateSemantic();

                /**
         * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute FOREACH_PREDICATE_PROPERTY_INIT__MODE = eINSTANCE.getForeachPredicatePropertyInit_Mode();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl <em>Predicate Semantic</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PredicateSemanticImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPredicateSemantic()
         * @generated
         */
                EClass PREDICATE_SEMANTIC = eINSTANCE.getPredicateSemantic();

                /**
         * The meta object literal for the '<em><b>As</b></em>' reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference PREDICATE_SEMANTIC__AS = eINSTANCE.getPredicateSemantic_As();

                /**
         * The meta object literal for the '<em><b>When</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PREDICATE_SEMANTIC__WHEN = eINSTANCE.getPredicateSemantic_When();

                /**
         * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute PREDICATE_SEMANTIC__MODE = eINSTANCE.getPredicateSemantic_Mode();

                /**
         * The meta object literal for the '<em><b>Foreach Parent</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PREDICATE_SEMANTIC__FOREACH_PARENT = eINSTANCE.getPredicateSemantic_ForeachParent();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceInAlternativeImpl <em>Sequence In Alternative</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceInAlternativeImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSequenceInAlternative()
         * @generated
         */
                EClass SEQUENCE_IN_ALTERNATIVE = eINSTANCE.getSequenceInAlternative();

                /**
         * The meta object literal for the '<em><b>Alternative Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EReference SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER = eINSTANCE.getSequenceInAlternative_AlternativeContainer();

                /**
         * The meta object literal for the '<em><b>Disambiguate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE = eINSTANCE.getSequenceInAlternative_Disambiguate();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PartialPArgImpl <em>Partial PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.PartialPArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getPartialPArg()
         * @generated
         */
                EClass PARTIAL_PARG = eINSTANCE.getPartialPArg();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.DisambiguatePArgImpl <em>Disambiguate PArg</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.DisambiguatePArgImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getDisambiguatePArg()
         * @generated
         */
                EClass DISAMBIGUATE_PARG = eINSTANCE.getDisambiguatePArg();

                /**
         * The meta object literal for the '<em><b>Disambiguation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute DISAMBIGUATE_PARG__DISAMBIGUATION = eINSTANCE.getDisambiguatePArg_Disambiguation();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InstanceOfExpImpl <em>Instance Of Exp</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.InstanceOfExpImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getInstanceOfExp()
         * @generated
         */
                EClass INSTANCE_OF_EXP = eINSTANCE.getInstanceOfExp();

                /**
         * The meta object literal for the '<em><b>Supertype</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute INSTANCE_OF_EXP__SUPERTYPE = eINSTANCE.getInstanceOfExp_Supertype();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralValImpl <em>Enum Literal Val</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumLiteralValImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getEnumLiteralVal()
         * @generated
         */
                EClass ENUM_LITERAL_VAL = eINSTANCE.getEnumLiteralVal();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.StringValImpl <em>String Val</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.StringValImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getStringVal()
         * @generated
         */
                EClass STRING_VAL = eINSTANCE.getStringVal();

                /**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute STRING_VAL__SYMBOL = eINSTANCE.getStringVal_Symbol();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.IntegerValImpl <em>Integer Val</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.IntegerValImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getIntegerVal()
         * @generated
         */
                EClass INTEGER_VAL = eINSTANCE.getIntegerVal();

                /**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute INTEGER_VAL__SYMBOL = eINSTANCE.getIntegerVal_Symbol();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.NegativeIntegerValImpl <em>Negative Integer Val</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.NegativeIntegerValImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getNegativeIntegerVal()
         * @generated
         */
                EClass NEGATIVE_INTEGER_VAL = eINSTANCE.getNegativeIntegerVal();

                /**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                EAttribute NEGATIVE_INTEGER_VAL__SYMBOL = eINSTANCE.getNegativeIntegerVal_Symbol();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.LookupPropertyInitImpl <em>Lookup Property Init</em>}' class.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.LookupPropertyInitImpl
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getLookupPropertyInit()
         * @generated
         */
                EClass LOOKUP_PROPERTY_INIT = eINSTANCE.getLookupPropertyInit();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers <em>Template Modifiers</em>}' enum.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getTemplateModifiers()
         * @generated
         */
                EEnum TEMPLATE_MODIFIERS = eINSTANCE.getTemplateModifiers();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind <em>Space Kind</em>}' enum.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getSpaceKind()
         * @generated
         */
                EEnum SPACE_KIND = eINSTANCE.getSpaceKind();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Associativity <em>Associativity</em>}' enum.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.Associativity
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAssociativity()
         * @generated
         */
                EEnum ASSOCIATIVITY = eINSTANCE.getAssociativity();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind <em>Auto Create Kind</em>}' enum.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getAutoCreateKind()
         * @generated
         */
                EEnum AUTO_CREATE_KIND = eINSTANCE.getAutoCreateKind();

                /**
         * The meta object literal for the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind <em>Scope Kind</em>}' enum.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind
         * @see com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl#getScopeKind()
         * @generated
         */
                EEnum SCOPE_KIND = eINSTANCE.getScopeKind();

        }

} //TCSPackage
