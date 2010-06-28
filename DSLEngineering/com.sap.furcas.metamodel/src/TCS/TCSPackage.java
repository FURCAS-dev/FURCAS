/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;

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
 * @see TCS.TCSFactory
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
	TCSPackage eINSTANCE = TCS.impl.TCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link TCS.impl.LocatedElementImpl <em>Located Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.LocatedElementImpl
	 * @see TCS.impl.TCSPackageImpl#getLocatedElement()
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
	 * The meta object id for the '{@link TCS.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.NamedElementImpl
	 * @see TCS.impl.TCSPackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link TCS.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ConcreteSyntaxImpl
	 * @see TCS.impl.TCSPackageImpl#getConcreteSyntax()
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
	 * The meta object id for the '{@link TCS.impl.QualifiedNamedElementImpl <em>Qualified Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.QualifiedNamedElementImpl
	 * @see TCS.impl.TCSPackageImpl#getQualifiedNamedElement()
	 * @generated
	 */
	int QUALIFIED_NAMED_ELEMENT = 73;

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
	 * The meta object id for the '{@link TCS.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.TemplateImpl
	 * @see TCS.impl.TCSPackageImpl#getTemplate()
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
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = QUALIFIED_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link TCS.impl.FunctionTemplateImpl <em>Function Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.FunctionTemplateImpl
	 * @see TCS.impl.TCSPackageImpl#getFunctionTemplate()
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
	 * The meta object id for the '{@link TCS.impl.ClassTemplateImpl <em>Class Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ClassTemplateImpl
	 * @see TCS.impl.TCSPackageImpl#getClassTemplate()
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
	int CLASS_TEMPLATE__LOCATION = TEMPLATE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__COMMENTS_BEFORE = TEMPLATE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__COMMENTS_AFTER = TEMPLATE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__NAMES = TEMPLATE__NAMES;

	/**
	 * The feature id for the '<em><b>Meta Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__META_REFERENCE = TEMPLATE__META_REFERENCE;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__CONCRETE_SYNTAX = TEMPLATE__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__DISAMBIGUATE = TEMPLATE__DISAMBIGUATE;

	/**
	 * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__DISAMBIGUATE_V3 = TEMPLATE__DISAMBIGUATE_V3;

	/**
	 * The feature id for the '<em><b>Template Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__TEMPLATE_SEQUENCE = TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__MODIFIERS = TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_ABSTRACT = TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Deep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_DEEP = TEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Prefix Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__PREFIX_SEQUENCE = TEMPLATE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Operatored</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_OPERATORED = TEMPLATE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Operator List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__OPERATOR_LIST = TEMPLATE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_MAIN = TEMPLATE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_MULTI = TEMPLATE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_CONTEXT = TEMPLATE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Add To Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_ADD_TO_CONTEXT = TEMPLATE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Is Non Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__IS_NON_PRIMARY = TEMPLATE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE__MODE = TEMPLATE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Class Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TEMPLATE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link TCS.impl.PrimitiveTemplateImpl <em>Primitive Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.PrimitiveTemplateImpl
	 * @see TCS.impl.TCSPackageImpl#getPrimitiveTemplate()
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
	 * The feature id for the '<em><b>Template Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TEMPLATE__TEMPLATE_NAME = TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TEMPLATE__IS_DEFAULT = TEMPLATE_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link TCS.impl.OperatorTemplateImpl <em>Operator Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OperatorTemplateImpl
	 * @see TCS.impl.TCSPackageImpl#getOperatorTemplate()
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
	int OPERATOR_TEMPLATE__LOCATION = TEMPLATE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__COMMENTS_BEFORE = TEMPLATE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__COMMENTS_AFTER = TEMPLATE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__NAMES = TEMPLATE__NAMES;

	/**
	 * The feature id for the '<em><b>Meta Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__META_REFERENCE = TEMPLATE__META_REFERENCE;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__CONCRETE_SYNTAX = TEMPLATE__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Disambiguate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__DISAMBIGUATE = TEMPLATE__DISAMBIGUATE;

	/**
	 * The feature id for the '<em><b>Disambiguate V3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__DISAMBIGUATE_V3 = TEMPLATE__DISAMBIGUATE_V3;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__OPERATORS = TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__SOURCE = TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Store Op To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__STORE_OP_TO = TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Store Right To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__STORE_RIGHT_TO = TEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ot Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__OT_SEQUENCE = TEMPLATE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE__IS_CONTEXT = TEMPLATE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Operator Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TEMPLATE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link TCS.impl.EnumerationTemplateImpl <em>Enumeration Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.EnumerationTemplateImpl
	 * @see TCS.impl.TCSPackageImpl#getEnumerationTemplate()
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
	 * The meta object id for the '{@link TCS.impl.EnumLiteralMappingImpl <em>Enum Literal Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.EnumLiteralMappingImpl
	 * @see TCS.impl.TCSPackageImpl#getEnumLiteralMapping()
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
	 * The meta object id for the '{@link TCS.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.LiteralImpl
	 * @see TCS.impl.TCSPackageImpl#getLiteral()
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
	 * The meta object id for the '{@link TCS.impl.SymbolImpl <em>Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.SymbolImpl
	 * @see TCS.impl.TCSPackageImpl#getSymbol()
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
	 * The meta object id for the '{@link TCS.impl.KeywordImpl <em>Keyword</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.KeywordImpl
	 * @see TCS.impl.TCSPackageImpl#getKeyword()
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
	 * The meta object id for the '{@link TCS.impl.OperatorListImpl <em>Operator List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OperatorListImpl
	 * @see TCS.impl.TCSPackageImpl#getOperatorList()
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
	 * The meta object id for the '{@link TCS.impl.PriorityImpl <em>Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.PriorityImpl
	 * @see TCS.impl.TCSPackageImpl#getPriority()
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
	 * The meta object id for the '{@link TCS.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OperatorImpl
	 * @see TCS.impl.TCSPackageImpl#getOperator()
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
	 * The feature id for the '<em><b>Is Postfix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__IS_POSTFIX = NAMED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link TCS.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.SequenceImpl
	 * @see TCS.impl.TCSPackageImpl#getSequence()
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
	 * The feature id for the '<em><b>Template Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__TEMPLATE_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix Container</b></em>' container reference.
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
	 * The feature id for the '<em><b>Ot Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__OT_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Alternative Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__ALTERNATIVE_CONTAINER = LOCATED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link TCS.impl.SequenceElementImpl <em>Sequence Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.SequenceElementImpl
	 * @see TCS.impl.TCSPackageImpl#getSequenceElement()
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
	 * The number of structural features of the '<em>Sequence Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_ELEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link TCS.impl.LiteralRefImpl <em>Literal Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.LiteralRefImpl
	 * @see TCS.impl.TCSPackageImpl#getLiteralRef()
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
	 * The meta object id for the '{@link TCS.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.PropertyImpl
	 * @see TCS.impl.TCSPackageImpl#getProperty()
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__PROPERTY_ARGS = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link TCS.impl.CustomSeparatorImpl <em>Custom Separator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.CustomSeparatorImpl
	 * @see TCS.impl.TCSPackageImpl#getCustomSeparator()
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
	 * The meta object id for the '{@link TCS.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.BlockImpl
	 * @see TCS.impl.TCSPackageImpl#getBlock()
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
	 * The meta object id for the '{@link TCS.impl.ConditionalElementImpl <em>Conditional Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ConditionalElementImpl
	 * @see TCS.impl.TCSPackageImpl#getConditionalElement()
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
	 * The meta object id for the '{@link TCS.impl.PropertyInitImpl <em>Property Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.PropertyInitImpl
	 * @see TCS.impl.TCSPackageImpl#getPropertyInit()
	 * @generated
	 */
	int PROPERTY_INIT = 23;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT__LOCATION = SEQUENCE_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT__COMMENTS_BEFORE = SEQUENCE_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT__COMMENTS_AFTER = SEQUENCE_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Element Sequence</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT__ELEMENT_SEQUENCE = SEQUENCE_ELEMENT__ELEMENT_SEQUENCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT__NAME = SEQUENCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT__VALUE = SEQUENCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INIT_FEATURE_COUNT = SEQUENCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link TCS.impl.AlternativeImpl <em>Alternative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.AlternativeImpl
	 * @see TCS.impl.TCSPackageImpl#getAlternative()
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
	 * The meta object id for the '{@link TCS.impl.FunctionCallImpl <em>Function Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.FunctionCallImpl
	 * @see TCS.impl.TCSPackageImpl#getFunctionCall()
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
	 * The meta object id for the '{@link TCS.impl.PropertyArgImpl <em>Property Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.PropertyArgImpl
	 * @see TCS.impl.TCSPackageImpl#getPropertyArg()
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
	 * The meta object id for the '{@link TCS.impl.RefersToPArgImpl <em>Refers To PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.RefersToPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getRefersToPArg()
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
	 * The meta object id for the '{@link TCS.impl.LookInPArgImpl <em>Look In PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.LookInPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getLookInPArg()
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
	 * The meta object id for the '{@link TCS.impl.CreateInPArgImpl <em>Create In PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.CreateInPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getCreateInPArg()
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
	 * The meta object id for the '{@link TCS.impl.RefersToKeyPArgImpl <em>Refers To Key PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.RefersToKeyPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getRefersToKeyPArg()
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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERS_TO_KEY_PARG__VALUE = PROPERTY_ARG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Refers To Key PArg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERS_TO_KEY_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link TCS.impl.SeparatorPArgImpl <em>Separator PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.SeparatorPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getSeparatorPArg()
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
	 * The meta object id for the '{@link TCS.impl.AutoCreatePArgImpl <em>Auto Create PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.AutoCreatePArgImpl
	 * @see TCS.impl.TCSPackageImpl#getAutoCreatePArg()
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
	 * The meta object id for the '{@link TCS.impl.ImportContextPArgImpl <em>Import Context PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ImportContextPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getImportContextPArg()
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
	 * The meta object id for the '{@link TCS.impl.ForcedLowerPArgImpl <em>Forced Lower PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ForcedLowerPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getForcedLowerPArg()
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
	 * The meta object id for the '{@link TCS.impl.CreateAsPArgImpl <em>Create As PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.CreateAsPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getCreateAsPArg()
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
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
	 * The meta object id for the '{@link TCS.impl.AsPArgImpl <em>As PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.AsPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getAsPArg()
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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_PARG__VALUE = PROPERTY_ARG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As PArg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_PARG_FEATURE_COUNT = PROPERTY_ARG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link TCS.impl.ModePArgImpl <em>Mode PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ModePArgImpl
	 * @see TCS.impl.TCSPackageImpl#getModePArg()
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
	 * The meta object id for the '{@link TCS.impl.BlockArgImpl <em>Block Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.BlockArgImpl
	 * @see TCS.impl.TCSPackageImpl#getBlockArg()
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
	 * The meta object id for the '{@link TCS.impl.NbNLBArgImpl <em>Nb NLB Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.NbNLBArgImpl
	 * @see TCS.impl.TCSPackageImpl#getNbNLBArg()
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
	 * The meta object id for the '{@link TCS.impl.IndentIncrBArgImpl <em>Indent Incr BArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.IndentIncrBArgImpl
	 * @see TCS.impl.TCSPackageImpl#getIndentIncrBArg()
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
	 * The meta object id for the '{@link TCS.impl.StartNLBArgImpl <em>Start NLB Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.StartNLBArgImpl
	 * @see TCS.impl.TCSPackageImpl#getStartNLBArg()
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
	 * The meta object id for the '{@link TCS.impl.StartNbNLBArgImpl <em>Start Nb NLB Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.StartNbNLBArgImpl
	 * @see TCS.impl.TCSPackageImpl#getStartNbNLBArg()
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
	 * The meta object id for the '{@link TCS.impl.EndNLBArgImpl <em>End NLB Arg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.EndNLBArgImpl
	 * @see TCS.impl.TCSPackageImpl#getEndNLBArg()
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
	 * The meta object id for the '{@link TCS.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ExpressionImpl
	 * @see TCS.impl.TCSPackageImpl#getExpression()
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
	 * The meta object id for the '{@link TCS.impl.AndExpImpl <em>And Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.AndExpImpl
	 * @see TCS.impl.TCSPackageImpl#getAndExp()
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
	 * The meta object id for the '{@link TCS.impl.AtomExpImpl <em>Atom Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.AtomExpImpl
	 * @see TCS.impl.TCSPackageImpl#getAtomExp()
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
	 * The number of structural features of the '<em>Atom Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_EXP_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link TCS.impl.EqualsExpImpl <em>Equals Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.EqualsExpImpl
	 * @see TCS.impl.TCSPackageImpl#getEqualsExp()
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
	 * The meta object id for the '{@link TCS.impl.BooleanPropertyExpImpl <em>Boolean Property Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.BooleanPropertyExpImpl
	 * @see TCS.impl.TCSPackageImpl#getBooleanPropertyExp()
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
	 * The number of structural features of the '<em>Boolean Property Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PROPERTY_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link TCS.impl.IsDefinedExpImpl <em>Is Defined Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.IsDefinedExpImpl
	 * @see TCS.impl.TCSPackageImpl#getIsDefinedExp()
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
	 * The number of structural features of the '<em>Is Defined Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DEFINED_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link TCS.impl.OneExpImpl <em>One Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OneExpImpl
	 * @see TCS.impl.TCSPackageImpl#getOneExp()
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
	 * The number of structural features of the '<em>One Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_EXP_FEATURE_COUNT = ATOM_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link TCS.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ValueImpl
	 * @see TCS.impl.TCSPackageImpl#getValue()
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
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link TCS.impl.StringValImpl <em>String Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.StringValImpl
	 * @see TCS.impl.TCSPackageImpl#getStringVal()
	 * @generated
	 */
	int STRING_VAL = 52;

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
	 * The meta object id for the '{@link TCS.impl.IntegerValImpl <em>Integer Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.IntegerValImpl
	 * @see TCS.impl.TCSPackageImpl#getIntegerVal()
	 * @generated
	 */
	int INTEGER_VAL = 53;

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
	 * The meta object id for the '{@link TCS.impl.NegativeIntegerValImpl <em>Negative Integer Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.NegativeIntegerValImpl
	 * @see TCS.impl.TCSPackageImpl#getNegativeIntegerVal()
	 * @generated
	 */
	int NEGATIVE_INTEGER_VAL = 54;

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
	 * The meta object id for the '{@link TCS.impl.EnumLiteralValImpl <em>Enum Literal Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.EnumLiteralValImpl
	 * @see TCS.impl.TCSPackageImpl#getEnumLiteralVal()
	 * @generated
	 */
	int ENUM_LITERAL_VAL = 55;

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
	int ENUM_LITERAL_VAL__NAME = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Val</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link TCS.impl.PropertyValImpl <em>Property Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.PropertyValImpl
	 * @see TCS.impl.TCSPackageImpl#getPropertyVal()
	 * @generated
	 */
	int PROPERTY_VAL = 56;

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
	 * The feature id for the '<em><b>Property Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VAL__PROPERTY_NAME = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Val</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link TCS.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.TokenImpl
	 * @see TCS.impl.TCSPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 57;

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
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link TCS.impl.OrPatternImpl <em>Or Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OrPatternImpl
	 * @see TCS.impl.TCSPackageImpl#getOrPattern()
	 * @generated
	 */
	int OR_PATTERN = 58;

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
	 * The meta object id for the '{@link TCS.impl.SimplePatternImpl <em>Simple Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.SimplePatternImpl
	 * @see TCS.impl.TCSPackageImpl#getSimplePattern()
	 * @generated
	 */
	int SIMPLE_PATTERN = 59;

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
	 * The meta object id for the '{@link TCS.impl.RulePatternImpl <em>Rule Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.RulePatternImpl
	 * @see TCS.impl.TCSPackageImpl#getRulePattern()
	 * @generated
	 */
	int RULE_PATTERN = 60;

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
	 * The meta object id for the '{@link TCS.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.RuleImpl
	 * @see TCS.impl.TCSPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 61;

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
	 * The meta object id for the '{@link TCS.impl.WordRuleImpl <em>Word Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.WordRuleImpl
	 * @see TCS.impl.TCSPackageImpl#getWordRule()
	 * @generated
	 */
	int WORD_RULE = 62;

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
	 * The meta object id for the '{@link TCS.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.WordImpl
	 * @see TCS.impl.TCSPackageImpl#getWord()
	 * @generated
	 */
	int WORD = 63;

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
	 * The meta object id for the '{@link TCS.impl.EndOfLineRuleImpl <em>End Of Line Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.EndOfLineRuleImpl
	 * @see TCS.impl.TCSPackageImpl#getEndOfLineRule()
	 * @generated
	 */
	int END_OF_LINE_RULE = 64;

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
	 * The meta object id for the '{@link TCS.impl.MultiLineRuleImpl <em>Multi Line Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.MultiLineRuleImpl
	 * @see TCS.impl.TCSPackageImpl#getMultiLineRule()
	 * @generated
	 */
	int MULTI_LINE_RULE = 65;

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
	 * The feature id for the '<em><b>Drop Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LINE_RULE__DROP_START = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LINE_RULE__END = RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Drop End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LINE_RULE__DROP_END = RULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Esc</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LINE_RULE__ESC = RULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Esc Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LINE_RULE__ESC_MAPPINGS = RULE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Multi Line Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LINE_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link TCS.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.MappingImpl
	 * @see TCS.impl.TCSPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 66;

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
	 * The meta object id for the '{@link TCS.impl.SimpleMappingImpl <em>Simple Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.SimpleMappingImpl
	 * @see TCS.impl.TCSPackageImpl#getSimpleMapping()
	 * @generated
	 */
	int SIMPLE_MAPPING = 67;

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
	 * The meta object id for the '{@link TCS.impl.WildcardMappingImpl <em>Wildcard Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.WildcardMappingImpl
	 * @see TCS.impl.TCSPackageImpl#getWildcardMapping()
	 * @generated
	 */
	int WILDCARD_MAPPING = 68;

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
	 * The meta object id for the '{@link TCS.impl.OctalMappingImpl <em>Octal Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OctalMappingImpl
	 * @see TCS.impl.TCSPackageImpl#getOctalMapping()
	 * @generated
	 */
	int OCTAL_MAPPING = 69;

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
	 * The meta object id for the '{@link TCS.impl.HexadecimalMappingImpl <em>Hexadecimal Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.HexadecimalMappingImpl
	 * @see TCS.impl.TCSPackageImpl#getHexadecimalMapping()
	 * @generated
	 */
	int HEXADECIMAL_MAPPING = 70;

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
	 * The meta object id for the '{@link TCS.impl.StringPatternImpl <em>String Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.StringPatternImpl
	 * @see TCS.impl.TCSPackageImpl#getStringPattern()
	 * @generated
	 */
	int STRING_PATTERN = 71;

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
	 * The meta object id for the '{@link TCS.impl.ClassPatternImpl <em>Class Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.ClassPatternImpl
	 * @see TCS.impl.TCSPackageImpl#getClassPattern()
	 * @generated
	 */
	int CLASS_PATTERN = 72;

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
	 * The meta object id for the '{@link TCS.impl.OCLQueryPArgImpl <em>OCL Query PArg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.impl.OCLQueryPArgImpl
	 * @see TCS.impl.TCSPackageImpl#getOCLQueryPArg()
	 * @generated
	 */
	int OCL_QUERY_PARG = 74;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY_PARG__QUERY = 0;

	/**
	 * The number of structural features of the '<em>OCL Query PArg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY_PARG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link TCS.TemplateModifiers <em>Template Modifiers</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.TemplateModifiers
	 * @see TCS.impl.TCSPackageImpl#getTemplateModifiers()
	 * @generated
	 */
	int TEMPLATE_MODIFIERS = 75;

	/**
	 * The meta object id for the '{@link TCS.SpaceKind <em>Space Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.SpaceKind
	 * @see TCS.impl.TCSPackageImpl#getSpaceKind()
	 * @generated
	 */
	int SPACE_KIND = 76;

	/**
	 * The meta object id for the '{@link TCS.Associativity <em>Associativity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.Associativity
	 * @see TCS.impl.TCSPackageImpl#getAssociativity()
	 * @generated
	 */
	int ASSOCIATIVITY = 77;

	/**
	 * The meta object id for the '{@link TCS.AutoCreateKind <em>Auto Create Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TCS.AutoCreateKind
	 * @see TCS.impl.TCSPackageImpl#getAutoCreateKind()
	 * @generated
	 */
	int AUTO_CREATE_KIND = 78;


	/**
	 * Returns the meta object for class '{@link TCS.LocatedElement <em>Located Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Located Element</em>'.
	 * @see TCS.LocatedElement
	 * @generated
	 */
	EClass getLocatedElement();

	/**
	 * Returns the meta object for the attribute '{@link TCS.LocatedElement#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see TCS.LocatedElement#getLocation()
	 * @see #getLocatedElement()
	 * @generated
	 */
	EAttribute getLocatedElement_Location();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.LocatedElement#getCommentsBefore <em>Comments Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments Before</em>'.
	 * @see TCS.LocatedElement#getCommentsBefore()
	 * @see #getLocatedElement()
	 * @generated
	 */
	EAttribute getLocatedElement_CommentsBefore();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.LocatedElement#getCommentsAfter <em>Comments After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments After</em>'.
	 * @see TCS.LocatedElement#getCommentsAfter()
	 * @see #getLocatedElement()
	 * @generated
	 */
	EAttribute getLocatedElement_CommentsAfter();

	/**
	 * Returns the meta object for class '{@link TCS.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see TCS.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link TCS.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link TCS.ConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Syntax</em>'.
	 * @see TCS.ConcreteSyntax
	 * @generated
	 */
	EClass getConcreteSyntax();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ConcreteSyntax#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see TCS.ConcreteSyntax#getK()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EAttribute getConcreteSyntax_K();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.ConcreteSyntax#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Templates</em>'.
	 * @see TCS.ConcreteSyntax#getTemplates()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Templates();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.ConcreteSyntax#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keywords</em>'.
	 * @see TCS.ConcreteSyntax#getKeywords()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Keywords();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.ConcreteSyntax#getSymbols <em>Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Symbols</em>'.
	 * @see TCS.ConcreteSyntax#getSymbols()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Symbols();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.ConcreteSyntax#getOperatorLists <em>Operator Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operator Lists</em>'.
	 * @see TCS.ConcreteSyntax#getOperatorLists()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_OperatorLists();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.ConcreteSyntax#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see TCS.ConcreteSyntax#getTokens()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Tokens();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ConcreteSyntax#getLexer <em>Lexer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lexer</em>'.
	 * @see TCS.ConcreteSyntax#getLexer()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EAttribute getConcreteSyntax_Lexer();

	/**
	 * Returns the meta object for class '{@link TCS.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see TCS.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Template#getConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Concrete Syntax</em>'.
	 * @see TCS.Template#getConcreteSyntax()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_ConcreteSyntax();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Template#getDisambiguate <em>Disambiguate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disambiguate</em>'.
	 * @see TCS.Template#getDisambiguate()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Disambiguate();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Template#getDisambiguateV3 <em>Disambiguate V3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disambiguate V3</em>'.
	 * @see TCS.Template#getDisambiguateV3()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_DisambiguateV3();

	/**
	 * Returns the meta object for class '{@link TCS.FunctionTemplate <em>Function Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Template</em>'.
	 * @see TCS.FunctionTemplate
	 * @generated
	 */
	EClass getFunctionTemplate();

	/**
	 * Returns the meta object for the attribute '{@link TCS.FunctionTemplate#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see TCS.FunctionTemplate#getFunctionName()
	 * @see #getFunctionTemplate()
	 * @generated
	 */
	EAttribute getFunctionTemplate_FunctionName();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.FunctionTemplate#getFunctionSequence <em>Function Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function Sequence</em>'.
	 * @see TCS.FunctionTemplate#getFunctionSequence()
	 * @see #getFunctionTemplate()
	 * @generated
	 */
	EReference getFunctionTemplate_FunctionSequence();

	/**
	 * Returns the meta object for class '{@link TCS.ClassTemplate <em>Class Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Template</em>'.
	 * @see TCS.ClassTemplate
	 * @generated
	 */
	EClass getClassTemplate();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.ClassTemplate#getTemplateSequence <em>Template Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template Sequence</em>'.
	 * @see TCS.ClassTemplate#getTemplateSequence()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EReference getClassTemplate_TemplateSequence();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.ClassTemplate#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Modifiers</em>'.
	 * @see TCS.ClassTemplate#getModifiers()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_Modifiers();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see TCS.ClassTemplate#isIsAbstract()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsDeep <em>Is Deep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deep</em>'.
	 * @see TCS.ClassTemplate#isIsDeep()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsDeep();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.ClassTemplate#getPrefixSequence <em>Prefix Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prefix Sequence</em>'.
	 * @see TCS.ClassTemplate#getPrefixSequence()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EReference getClassTemplate_PrefixSequence();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsOperatored <em>Is Operatored</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Operatored</em>'.
	 * @see TCS.ClassTemplate#isIsOperatored()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsOperatored();

	/**
	 * Returns the meta object for the reference '{@link TCS.ClassTemplate#getOperatorList <em>Operator List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator List</em>'.
	 * @see TCS.ClassTemplate#getOperatorList()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EReference getClassTemplate_OperatorList();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsMain <em>Is Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Main</em>'.
	 * @see TCS.ClassTemplate#isIsMain()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsMain();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsMulti <em>Is Multi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Multi</em>'.
	 * @see TCS.ClassTemplate#isIsMulti()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsMulti();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsContext <em>Is Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Context</em>'.
	 * @see TCS.ClassTemplate#isIsContext()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsContext();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsAddToContext <em>Is Add To Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Add To Context</em>'.
	 * @see TCS.ClassTemplate#isIsAddToContext()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsAddToContext();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#isIsNonPrimary <em>Is Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Non Primary</em>'.
	 * @see TCS.ClassTemplate#isIsNonPrimary()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_IsNonPrimary();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ClassTemplate#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see TCS.ClassTemplate#getMode()
	 * @see #getClassTemplate()
	 * @generated
	 */
	EAttribute getClassTemplate_Mode();

	/**
	 * Returns the meta object for class '{@link TCS.PrimitiveTemplate <em>Primitive Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Template</em>'.
	 * @see TCS.PrimitiveTemplate
	 * @generated
	 */
	EClass getPrimitiveTemplate();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PrimitiveTemplate#getTemplateName <em>Template Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template Name</em>'.
	 * @see TCS.PrimitiveTemplate#getTemplateName()
	 * @see #getPrimitiveTemplate()
	 * @generated
	 */
	EAttribute getPrimitiveTemplate_TemplateName();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PrimitiveTemplate#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see TCS.PrimitiveTemplate#isIsDefault()
	 * @see #getPrimitiveTemplate()
	 * @generated
	 */
	EAttribute getPrimitiveTemplate_IsDefault();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PrimitiveTemplate#getTokenName <em>Token Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Name</em>'.
	 * @see TCS.PrimitiveTemplate#getTokenName()
	 * @see #getPrimitiveTemplate()
	 * @generated
	 */
	EAttribute getPrimitiveTemplate_TokenName();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PrimitiveTemplate#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.PrimitiveTemplate#getValue()
	 * @see #getPrimitiveTemplate()
	 * @generated
	 */
	EAttribute getPrimitiveTemplate_Value();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PrimitiveTemplate#getSerializer <em>Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serializer</em>'.
	 * @see TCS.PrimitiveTemplate#getSerializer()
	 * @see #getPrimitiveTemplate()
	 * @generated
	 */
	EAttribute getPrimitiveTemplate_Serializer();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PrimitiveTemplate#isOrKeyword <em>Or Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Or Keyword</em>'.
	 * @see TCS.PrimitiveTemplate#isOrKeyword()
	 * @see #getPrimitiveTemplate()
	 * @generated
	 */
	EAttribute getPrimitiveTemplate_OrKeyword();

	/**
	 * Returns the meta object for class '{@link TCS.OperatorTemplate <em>Operator Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Template</em>'.
	 * @see TCS.OperatorTemplate
	 * @generated
	 */
	EClass getOperatorTemplate();

	/**
	 * Returns the meta object for the reference list '{@link TCS.OperatorTemplate#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operators</em>'.
	 * @see TCS.OperatorTemplate#getOperators()
	 * @see #getOperatorTemplate()
	 * @generated
	 */
	EReference getOperatorTemplate_Operators();

	/**
	 * Returns the meta object for the attribute '{@link TCS.OperatorTemplate#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see TCS.OperatorTemplate#getSource()
	 * @see #getOperatorTemplate()
	 * @generated
	 */
	EAttribute getOperatorTemplate_Source();

	/**
	 * Returns the meta object for the attribute '{@link TCS.OperatorTemplate#getStoreOpTo <em>Store Op To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Op To</em>'.
	 * @see TCS.OperatorTemplate#getStoreOpTo()
	 * @see #getOperatorTemplate()
	 * @generated
	 */
	EAttribute getOperatorTemplate_StoreOpTo();

	/**
	 * Returns the meta object for the attribute '{@link TCS.OperatorTemplate#getStoreRightTo <em>Store Right To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Right To</em>'.
	 * @see TCS.OperatorTemplate#getStoreRightTo()
	 * @see #getOperatorTemplate()
	 * @generated
	 */
	EAttribute getOperatorTemplate_StoreRightTo();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.OperatorTemplate#getOtSequence <em>Ot Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ot Sequence</em>'.
	 * @see TCS.OperatorTemplate#getOtSequence()
	 * @see #getOperatorTemplate()
	 * @generated
	 */
	EReference getOperatorTemplate_OtSequence();

	/**
	 * Returns the meta object for the attribute '{@link TCS.OperatorTemplate#isIsContext <em>Is Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Context</em>'.
	 * @see TCS.OperatorTemplate#isIsContext()
	 * @see #getOperatorTemplate()
	 * @generated
	 */
	EAttribute getOperatorTemplate_IsContext();

	/**
	 * Returns the meta object for class '{@link TCS.EnumerationTemplate <em>Enumeration Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Template</em>'.
	 * @see TCS.EnumerationTemplate
	 * @generated
	 */
	EClass getEnumerationTemplate();

	/**
	 * Returns the meta object for the attribute '{@link TCS.EnumerationTemplate#isAutomatic <em>Automatic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Automatic</em>'.
	 * @see TCS.EnumerationTemplate#isAutomatic()
	 * @see #getEnumerationTemplate()
	 * @generated
	 */
	EAttribute getEnumerationTemplate_Automatic();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.EnumerationTemplate#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see TCS.EnumerationTemplate#getMappings()
	 * @see #getEnumerationTemplate()
	 * @generated
	 */
	EReference getEnumerationTemplate_Mappings();

	/**
	 * Returns the meta object for class '{@link TCS.EnumLiteralMapping <em>Enum Literal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Mapping</em>'.
	 * @see TCS.EnumLiteralMapping
	 * @generated
	 */
	EClass getEnumLiteralMapping();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.EnumLiteralMapping#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal</em>'.
	 * @see TCS.EnumLiteralMapping#getLiteral()
	 * @see #getEnumLiteralMapping()
	 * @generated
	 */
	EReference getEnumLiteralMapping_Literal();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.EnumLiteralMapping#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see TCS.EnumLiteralMapping#getElement()
	 * @see #getEnumLiteralMapping()
	 * @generated
	 */
	EReference getEnumLiteralMapping_Element();

	/**
	 * Returns the meta object for class '{@link TCS.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see TCS.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the reference list '{@link TCS.Literal#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operators</em>'.
	 * @see TCS.Literal#getOperators()
	 * @see #getLiteral()
	 * @generated
	 */
	EReference getLiteral_Operators();

	/**
	 * Returns the meta object for the reference list '{@link TCS.Literal#getLiteralRefs <em>Literal Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Literal Refs</em>'.
	 * @see TCS.Literal#getLiteralRefs()
	 * @see #getLiteral()
	 * @generated
	 */
	EReference getLiteral_LiteralRefs();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Literal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.Literal#getValue()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Value();

	/**
	 * Returns the meta object for class '{@link TCS.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol</em>'.
	 * @see TCS.Symbol
	 * @generated
	 */
	EClass getSymbol();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.Symbol#getSpaces <em>Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Spaces</em>'.
	 * @see TCS.Symbol#getSpaces()
	 * @see #getSymbol()
	 * @generated
	 */
	EAttribute getSymbol_Spaces();

	/**
	 * Returns the meta object for class '{@link TCS.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyword</em>'.
	 * @see TCS.Keyword
	 * @generated
	 */
	EClass getKeyword();

	/**
	 * Returns the meta object for class '{@link TCS.OperatorList <em>Operator List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator List</em>'.
	 * @see TCS.OperatorList
	 * @generated
	 */
	EClass getOperatorList();

	/**
	 * Returns the meta object for the attribute '{@link TCS.OperatorList#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.OperatorList#getName()
	 * @see #getOperatorList()
	 * @generated
	 */
	EAttribute getOperatorList_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.OperatorList#getPriorities <em>Priorities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Priorities</em>'.
	 * @see TCS.OperatorList#getPriorities()
	 * @see #getOperatorList()
	 * @generated
	 */
	EReference getOperatorList_Priorities();

	/**
	 * Returns the meta object for class '{@link TCS.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority</em>'.
	 * @see TCS.Priority
	 * @generated
	 */
	EClass getPriority();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Priority#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>List</em>'.
	 * @see TCS.Priority#getList()
	 * @see #getPriority()
	 * @generated
	 */
	EReference getPriority_List();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Priority#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.Priority#getValue()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_Value();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Priority#getAssociativity <em>Associativity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Associativity</em>'.
	 * @see TCS.Priority#getAssociativity()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_Associativity();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.Priority#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see TCS.Priority#getOperators()
	 * @see #getPriority()
	 * @generated
	 */
	EReference getPriority_Operators();

	/**
	 * Returns the meta object for class '{@link TCS.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see TCS.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Operator#isIsPostfix <em>Is Postfix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Postfix</em>'.
	 * @see TCS.Operator#isIsPostfix()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_IsPostfix();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Operator#getArity <em>Arity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arity</em>'.
	 * @see TCS.Operator#getArity()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Arity();

	/**
	 * Returns the meta object for the reference '{@link TCS.Operator#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see TCS.Operator#getLiteral()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Literal();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Operator#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Priority</em>'.
	 * @see TCS.Operator#getPriority()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Priority();

	/**
	 * Returns the meta object for the reference list '{@link TCS.Operator#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Templates</em>'.
	 * @see TCS.Operator#getTemplates()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Templates();

	/**
	 * Returns the meta object for class '{@link TCS.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see TCS.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.Sequence#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see TCS.Sequence#getElements()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Elements();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getTemplateContainer <em>Template Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Template Container</em>'.
	 * @see TCS.Sequence#getTemplateContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_TemplateContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getPrefixContainer <em>Prefix Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Prefix Container</em>'.
	 * @see TCS.Sequence#getPrefixContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_PrefixContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getFunctionContainer <em>Function Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function Container</em>'.
	 * @see TCS.Sequence#getFunctionContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_FunctionContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getBlockContainer <em>Block Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block Container</em>'.
	 * @see TCS.Sequence#getBlockContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_BlockContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getThenContainer <em>Then Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Then Container</em>'.
	 * @see TCS.Sequence#getThenContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_ThenContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getElseContainer <em>Else Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Else Container</em>'.
	 * @see TCS.Sequence#getElseContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_ElseContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getSeparatorContainer <em>Separator Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Separator Container</em>'.
	 * @see TCS.Sequence#getSeparatorContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_SeparatorContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getOtContainer <em>Ot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Ot Container</em>'.
	 * @see TCS.Sequence#getOtContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_OtContainer();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Sequence#getAlternativeContainer <em>Alternative Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Alternative Container</em>'.
	 * @see TCS.Sequence#getAlternativeContainer()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_AlternativeContainer();

	/**
	 * Returns the meta object for class '{@link TCS.SequenceElement <em>Sequence Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Element</em>'.
	 * @see TCS.SequenceElement
	 * @generated
	 */
	EClass getSequenceElement();

	/**
	 * Returns the meta object for the container reference '{@link TCS.SequenceElement#getElementSequence <em>Element Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Element Sequence</em>'.
	 * @see TCS.SequenceElement#getElementSequence()
	 * @see #getSequenceElement()
	 * @generated
	 */
	EReference getSequenceElement_ElementSequence();

	/**
	 * Returns the meta object for class '{@link TCS.LiteralRef <em>Literal Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Ref</em>'.
	 * @see TCS.LiteralRef
	 * @generated
	 */
	EClass getLiteralRef();

	/**
	 * Returns the meta object for the reference '{@link TCS.LiteralRef#getReferredLiteral <em>Referred Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Literal</em>'.
	 * @see TCS.LiteralRef#getReferredLiteral()
	 * @see #getLiteralRef()
	 * @generated
	 */
	EReference getLiteralRef_ReferredLiteral();

	/**
	 * Returns the meta object for class '{@link TCS.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see TCS.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.Property#getPropertyArgs <em>Property Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Args</em>'.
	 * @see TCS.Property#getPropertyArgs()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_PropertyArgs();

	/**
	 * Returns the meta object for class '{@link TCS.CustomSeparator <em>Custom Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Separator</em>'.
	 * @see TCS.CustomSeparator
	 * @generated
	 */
	EClass getCustomSeparator();

	/**
	 * Returns the meta object for the attribute '{@link TCS.CustomSeparator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.CustomSeparator#getName()
	 * @see #getCustomSeparator()
	 * @generated
	 */
	EAttribute getCustomSeparator_Name();

	/**
	 * Returns the meta object for class '{@link TCS.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see TCS.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.Block#getBlockSequence <em>Block Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block Sequence</em>'.
	 * @see TCS.Block#getBlockSequence()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_BlockSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.Block#getBlockArgs <em>Block Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Block Args</em>'.
	 * @see TCS.Block#getBlockArgs()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_BlockArgs();

	/**
	 * Returns the meta object for class '{@link TCS.ConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Element</em>'.
	 * @see TCS.ConditionalElement
	 * @generated
	 */
	EClass getConditionalElement();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.ConditionalElement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see TCS.ConditionalElement#getCondition()
	 * @see #getConditionalElement()
	 * @generated
	 */
	EReference getConditionalElement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.ConditionalElement#getThenSequence <em>Then Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Sequence</em>'.
	 * @see TCS.ConditionalElement#getThenSequence()
	 * @see #getConditionalElement()
	 * @generated
	 */
	EReference getConditionalElement_ThenSequence();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.ConditionalElement#getElseSequence <em>Else Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Sequence</em>'.
	 * @see TCS.ConditionalElement#getElseSequence()
	 * @see #getConditionalElement()
	 * @generated
	 */
	EReference getConditionalElement_ElseSequence();

	/**
	 * Returns the meta object for class '{@link TCS.PropertyInit <em>Property Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Init</em>'.
	 * @see TCS.PropertyInit
	 * @generated
	 */
	EClass getPropertyInit();

	/**
	 * Returns the meta object for the attribute '{@link TCS.PropertyInit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.PropertyInit#getName()
	 * @see #getPropertyInit()
	 * @generated
	 */
	EAttribute getPropertyInit_Name();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.PropertyInit#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see TCS.PropertyInit#getValue()
	 * @see #getPropertyInit()
	 * @generated
	 */
	EReference getPropertyInit_Value();

	/**
	 * Returns the meta object for class '{@link TCS.Alternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative</em>'.
	 * @see TCS.Alternative
	 * @generated
	 */
	EClass getAlternative();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.Alternative#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see TCS.Alternative#getSequences()
	 * @see #getAlternative()
	 * @generated
	 */
	EReference getAlternative_Sequences();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Alternative#isIsMulti <em>Is Multi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Multi</em>'.
	 * @see TCS.Alternative#isIsMulti()
	 * @see #getAlternative()
	 * @generated
	 */
	EAttribute getAlternative_IsMulti();

	/**
	 * Returns the meta object for class '{@link TCS.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call</em>'.
	 * @see TCS.FunctionCall
	 * @generated
	 */
	EClass getFunctionCall();

	/**
	 * Returns the meta object for the reference '{@link TCS.FunctionCall#getCalledFunction <em>Called Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Function</em>'.
	 * @see TCS.FunctionCall#getCalledFunction()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_CalledFunction();

	/**
	 * Returns the meta object for class '{@link TCS.PropertyArg <em>Property Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Arg</em>'.
	 * @see TCS.PropertyArg
	 * @generated
	 */
	EClass getPropertyArg();

	/**
	 * Returns the meta object for the container reference '{@link TCS.PropertyArg#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Property</em>'.
	 * @see TCS.PropertyArg#getProperty()
	 * @see #getPropertyArg()
	 * @generated
	 */
	EReference getPropertyArg_Property();

	/**
	 * Returns the meta object for class '{@link TCS.RefersToPArg <em>Refers To PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refers To PArg</em>'.
	 * @see TCS.RefersToPArg
	 * @generated
	 */
	EClass getRefersToPArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.RefersToPArg#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see TCS.RefersToPArg#getPropertyName()
	 * @see #getRefersToPArg()
	 * @generated
	 */
	EAttribute getRefersToPArg_PropertyName();

	/**
	 * Returns the meta object for class '{@link TCS.LookInPArg <em>Look In PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Look In PArg</em>'.
	 * @see TCS.LookInPArg
	 * @generated
	 */
	EClass getLookInPArg();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.LookInPArg#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Property Name</em>'.
	 * @see TCS.LookInPArg#getPropertyName()
	 * @see #getLookInPArg()
	 * @generated
	 */
	EAttribute getLookInPArg_PropertyName();

	/**
	 * Returns the meta object for class '{@link TCS.CreateInPArg <em>Create In PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create In PArg</em>'.
	 * @see TCS.CreateInPArg
	 * @generated
	 */
	EClass getCreateInPArg();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.CreateInPArg#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Property Name</em>'.
	 * @see TCS.CreateInPArg#getPropertyName()
	 * @see #getCreateInPArg()
	 * @generated
	 */
	EAttribute getCreateInPArg_PropertyName();

	/**
	 * Returns the meta object for class '{@link TCS.RefersToKeyPArg <em>Refers To Key PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refers To Key PArg</em>'.
	 * @see TCS.RefersToKeyPArg
	 * @generated
	 */
	EClass getRefersToKeyPArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.RefersToKeyPArg#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.RefersToKeyPArg#isValue()
	 * @see #getRefersToKeyPArg()
	 * @generated
	 */
	EAttribute getRefersToKeyPArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.SeparatorPArg <em>Separator PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Separator PArg</em>'.
	 * @see TCS.SeparatorPArg
	 * @generated
	 */
	EClass getSeparatorPArg();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.SeparatorPArg#getSeparatorSequence <em>Separator Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Separator Sequence</em>'.
	 * @see TCS.SeparatorPArg#getSeparatorSequence()
	 * @see #getSeparatorPArg()
	 * @generated
	 */
	EReference getSeparatorPArg_SeparatorSequence();

	/**
	 * Returns the meta object for class '{@link TCS.AutoCreatePArg <em>Auto Create PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auto Create PArg</em>'.
	 * @see TCS.AutoCreatePArg
	 * @generated
	 */
	EClass getAutoCreatePArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.AutoCreatePArg#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.AutoCreatePArg#getValue()
	 * @see #getAutoCreatePArg()
	 * @generated
	 */
	EAttribute getAutoCreatePArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.ImportContextPArg <em>Import Context PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Context PArg</em>'.
	 * @see TCS.ImportContextPArg
	 * @generated
	 */
	EClass getImportContextPArg();

	/**
	 * Returns the meta object for class '{@link TCS.ForcedLowerPArg <em>Forced Lower PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forced Lower PArg</em>'.
	 * @see TCS.ForcedLowerPArg
	 * @generated
	 */
	EClass getForcedLowerPArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ForcedLowerPArg#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.ForcedLowerPArg#getValue()
	 * @see #getForcedLowerPArg()
	 * @generated
	 */
	EAttribute getForcedLowerPArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.CreateAsPArg <em>Create As PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create As PArg</em>'.
	 * @see TCS.CreateAsPArg
	 * @generated
	 */
	EClass getCreateAsPArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.CreateAsPArg#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.CreateAsPArg#getName()
	 * @see #getCreateAsPArg()
	 * @generated
	 */
	EAttribute getCreateAsPArg_Name();

	/**
	 * Returns the meta object for class '{@link TCS.AsPArg <em>As PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As PArg</em>'.
	 * @see TCS.AsPArg
	 * @generated
	 */
	EClass getAsPArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.AsPArg#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.AsPArg#getValue()
	 * @see #getAsPArg()
	 * @generated
	 */
	EAttribute getAsPArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.ModePArg <em>Mode PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode PArg</em>'.
	 * @see TCS.ModePArg
	 * @generated
	 */
	EClass getModePArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.ModePArg#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see TCS.ModePArg#getMode()
	 * @see #getModePArg()
	 * @generated
	 */
	EAttribute getModePArg_Mode();

	/**
	 * Returns the meta object for class '{@link TCS.BlockArg <em>Block Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Arg</em>'.
	 * @see TCS.BlockArg
	 * @generated
	 */
	EClass getBlockArg();

	/**
	 * Returns the meta object for the container reference '{@link TCS.BlockArg#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block</em>'.
	 * @see TCS.BlockArg#getBlock()
	 * @see #getBlockArg()
	 * @generated
	 */
	EReference getBlockArg_Block();

	/**
	 * Returns the meta object for class '{@link TCS.NbNLBArg <em>Nb NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nb NLB Arg</em>'.
	 * @see TCS.NbNLBArg
	 * @generated
	 */
	EClass getNbNLBArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.NbNLBArg#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.NbNLBArg#getValue()
	 * @see #getNbNLBArg()
	 * @generated
	 */
	EAttribute getNbNLBArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.IndentIncrBArg <em>Indent Incr BArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indent Incr BArg</em>'.
	 * @see TCS.IndentIncrBArg
	 * @generated
	 */
	EClass getIndentIncrBArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.IndentIncrBArg#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.IndentIncrBArg#getValue()
	 * @see #getIndentIncrBArg()
	 * @generated
	 */
	EAttribute getIndentIncrBArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.StartNLBArg <em>Start NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start NLB Arg</em>'.
	 * @see TCS.StartNLBArg
	 * @generated
	 */
	EClass getStartNLBArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.StartNLBArg#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.StartNLBArg#isValue()
	 * @see #getStartNLBArg()
	 * @generated
	 */
	EAttribute getStartNLBArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.StartNbNLBArg <em>Start Nb NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Nb NLB Arg</em>'.
	 * @see TCS.StartNbNLBArg
	 * @generated
	 */
	EClass getStartNbNLBArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.StartNbNLBArg#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.StartNbNLBArg#getValue()
	 * @see #getStartNbNLBArg()
	 * @generated
	 */
	EAttribute getStartNbNLBArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.EndNLBArg <em>End NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End NLB Arg</em>'.
	 * @see TCS.EndNLBArg
	 * @generated
	 */
	EClass getEndNLBArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.EndNLBArg#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.EndNLBArg#isValue()
	 * @see #getEndNLBArg()
	 * @generated
	 */
	EAttribute getEndNLBArg_Value();

	/**
	 * Returns the meta object for class '{@link TCS.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see TCS.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the container reference '{@link TCS.Expression#getConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conditional Element</em>'.
	 * @see TCS.Expression#getConditionalElement()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ConditionalElement();

	/**
	 * Returns the meta object for class '{@link TCS.AndExp <em>And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Exp</em>'.
	 * @see TCS.AndExp
	 * @generated
	 */
	EClass getAndExp();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.AndExp#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see TCS.AndExp#getExpressions()
	 * @see #getAndExp()
	 * @generated
	 */
	EReference getAndExp_Expressions();

	/**
	 * Returns the meta object for class '{@link TCS.AtomExp <em>Atom Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom Exp</em>'.
	 * @see TCS.AtomExp
	 * @generated
	 */
	EClass getAtomExp();

	/**
	 * Returns the meta object for the container reference '{@link TCS.AtomExp#getAndExp <em>And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>And Exp</em>'.
	 * @see TCS.AtomExp#getAndExp()
	 * @see #getAtomExp()
	 * @generated
	 */
	EReference getAtomExp_AndExp();

	/**
	 * Returns the meta object for the attribute '{@link TCS.AtomExp#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see TCS.AtomExp#getPropertyName()
	 * @see #getAtomExp()
	 * @generated
	 */
	EAttribute getAtomExp_PropertyName();

	/**
	 * Returns the meta object for class '{@link TCS.EqualsExp <em>Equals Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equals Exp</em>'.
	 * @see TCS.EqualsExp
	 * @generated
	 */
	EClass getEqualsExp();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.EqualsExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see TCS.EqualsExp#getValue()
	 * @see #getEqualsExp()
	 * @generated
	 */
	EReference getEqualsExp_Value();

	/**
	 * Returns the meta object for class '{@link TCS.BooleanPropertyExp <em>Boolean Property Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Property Exp</em>'.
	 * @see TCS.BooleanPropertyExp
	 * @generated
	 */
	EClass getBooleanPropertyExp();

	/**
	 * Returns the meta object for class '{@link TCS.IsDefinedExp <em>Is Defined Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Defined Exp</em>'.
	 * @see TCS.IsDefinedExp
	 * @generated
	 */
	EClass getIsDefinedExp();

	/**
	 * Returns the meta object for class '{@link TCS.OneExp <em>One Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>One Exp</em>'.
	 * @see TCS.OneExp
	 * @generated
	 */
	EClass getOneExp();

	/**
	 * Returns the meta object for class '{@link TCS.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see TCS.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link TCS.StringVal <em>String Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Val</em>'.
	 * @see TCS.StringVal
	 * @generated
	 */
	EClass getStringVal();

	/**
	 * Returns the meta object for the attribute '{@link TCS.StringVal#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see TCS.StringVal#getSymbol()
	 * @see #getStringVal()
	 * @generated
	 */
	EAttribute getStringVal_Symbol();

	/**
	 * Returns the meta object for class '{@link TCS.IntegerVal <em>Integer Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Val</em>'.
	 * @see TCS.IntegerVal
	 * @generated
	 */
	EClass getIntegerVal();

	/**
	 * Returns the meta object for the attribute '{@link TCS.IntegerVal#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see TCS.IntegerVal#getSymbol()
	 * @see #getIntegerVal()
	 * @generated
	 */
	EAttribute getIntegerVal_Symbol();

	/**
	 * Returns the meta object for class '{@link TCS.NegativeIntegerVal <em>Negative Integer Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Negative Integer Val</em>'.
	 * @see TCS.NegativeIntegerVal
	 * @generated
	 */
	EClass getNegativeIntegerVal();

	/**
	 * Returns the meta object for the attribute '{@link TCS.NegativeIntegerVal#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see TCS.NegativeIntegerVal#getSymbol()
	 * @see #getNegativeIntegerVal()
	 * @generated
	 */
	EAttribute getNegativeIntegerVal_Symbol();

	/**
	 * Returns the meta object for class '{@link TCS.EnumLiteralVal <em>Enum Literal Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Val</em>'.
	 * @see TCS.EnumLiteralVal
	 * @generated
	 */
	EClass getEnumLiteralVal();

	/**
	 * Returns the meta object for the attribute '{@link TCS.EnumLiteralVal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see TCS.EnumLiteralVal#getName()
	 * @see #getEnumLiteralVal()
	 * @generated
	 */
	EAttribute getEnumLiteralVal_Name();

	/**
	 * Returns the meta object for class '{@link TCS.PropertyVal <em>Property Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Val</em>'.
	 * @see TCS.PropertyVal
	 * @generated
	 */
	EClass getPropertyVal();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.PropertyVal#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Property Name</em>'.
	 * @see TCS.PropertyVal#getPropertyName()
	 * @see #getPropertyVal()
	 * @generated
	 */
	EAttribute getPropertyVal_PropertyName();

	/**
	 * Returns the meta object for class '{@link TCS.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see TCS.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.Token#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see TCS.Token#getPattern()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_Pattern();

	/**
	 * Returns the meta object for class '{@link TCS.OrPattern <em>Or Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Pattern</em>'.
	 * @see TCS.OrPattern
	 * @generated
	 */
	EClass getOrPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.OrPattern#getSimplePatterns <em>Simple Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Patterns</em>'.
	 * @see TCS.OrPattern#getSimplePatterns()
	 * @see #getOrPattern()
	 * @generated
	 */
	EReference getOrPattern_SimplePatterns();

	/**
	 * Returns the meta object for class '{@link TCS.SimplePattern <em>Simple Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Pattern</em>'.
	 * @see TCS.SimplePattern
	 * @generated
	 */
	EClass getSimplePattern();

	/**
	 * Returns the meta object for class '{@link TCS.RulePattern <em>Rule Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Pattern</em>'.
	 * @see TCS.RulePattern
	 * @generated
	 */
	EClass getRulePattern();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.RulePattern#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule</em>'.
	 * @see TCS.RulePattern#getRule()
	 * @see #getRulePattern()
	 * @generated
	 */
	EReference getRulePattern_Rule();

	/**
	 * Returns the meta object for class '{@link TCS.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see TCS.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for class '{@link TCS.WordRule <em>Word Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word Rule</em>'.
	 * @see TCS.WordRule
	 * @generated
	 */
	EClass getWordRule();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.WordRule#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see TCS.WordRule#getStart()
	 * @see #getWordRule()
	 * @generated
	 */
	EReference getWordRule_Start();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.WordRule#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Part</em>'.
	 * @see TCS.WordRule#getPart()
	 * @see #getWordRule()
	 * @generated
	 */
	EReference getWordRule_Part();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.WordRule#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see TCS.WordRule#getEnd()
	 * @see #getWordRule()
	 * @generated
	 */
	EReference getWordRule_End();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.WordRule#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Words</em>'.
	 * @see TCS.WordRule#getWords()
	 * @see #getWordRule()
	 * @generated
	 */
	EReference getWordRule_Words();

	/**
	 * Returns the meta object for class '{@link TCS.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see TCS.Word
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for the attribute '{@link TCS.Word#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token</em>'.
	 * @see TCS.Word#getToken()
	 * @see #getWord()
	 * @generated
	 */
	EAttribute getWord_Token();

	/**
	 * Returns the meta object for class '{@link TCS.EndOfLineRule <em>End Of Line Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Of Line Rule</em>'.
	 * @see TCS.EndOfLineRule
	 * @generated
	 */
	EClass getEndOfLineRule();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.EndOfLineRule#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see TCS.EndOfLineRule#getStart()
	 * @see #getEndOfLineRule()
	 * @generated
	 */
	EReference getEndOfLineRule_Start();

	/**
	 * Returns the meta object for the attribute '{@link TCS.EndOfLineRule#isDropStart <em>Drop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drop Start</em>'.
	 * @see TCS.EndOfLineRule#isDropStart()
	 * @see #getEndOfLineRule()
	 * @generated
	 */
	EAttribute getEndOfLineRule_DropStart();

	/**
	 * Returns the meta object for class '{@link TCS.MultiLineRule <em>Multi Line Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Line Rule</em>'.
	 * @see TCS.MultiLineRule
	 * @generated
	 */
	EClass getMultiLineRule();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.MultiLineRule#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see TCS.MultiLineRule#getStart()
	 * @see #getMultiLineRule()
	 * @generated
	 */
	EReference getMultiLineRule_Start();

	/**
	 * Returns the meta object for the attribute '{@link TCS.MultiLineRule#isDropStart <em>Drop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drop Start</em>'.
	 * @see TCS.MultiLineRule#isDropStart()
	 * @see #getMultiLineRule()
	 * @generated
	 */
	EAttribute getMultiLineRule_DropStart();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.MultiLineRule#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see TCS.MultiLineRule#getEnd()
	 * @see #getMultiLineRule()
	 * @generated
	 */
	EReference getMultiLineRule_End();

	/**
	 * Returns the meta object for the attribute '{@link TCS.MultiLineRule#isDropEnd <em>Drop End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drop End</em>'.
	 * @see TCS.MultiLineRule#isDropEnd()
	 * @see #getMultiLineRule()
	 * @generated
	 */
	EAttribute getMultiLineRule_DropEnd();

	/**
	 * Returns the meta object for the containment reference '{@link TCS.MultiLineRule#getEsc <em>Esc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Esc</em>'.
	 * @see TCS.MultiLineRule#getEsc()
	 * @see #getMultiLineRule()
	 * @generated
	 */
	EReference getMultiLineRule_Esc();

	/**
	 * Returns the meta object for the containment reference list '{@link TCS.MultiLineRule#getEscMappings <em>Esc Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Esc Mappings</em>'.
	 * @see TCS.MultiLineRule#getEscMappings()
	 * @see #getMultiLineRule()
	 * @generated
	 */
	EReference getMultiLineRule_EscMappings();

	/**
	 * Returns the meta object for class '{@link TCS.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see TCS.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for class '{@link TCS.SimpleMapping <em>Simple Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Mapping</em>'.
	 * @see TCS.SimpleMapping
	 * @generated
	 */
	EClass getSimpleMapping();

	/**
	 * Returns the meta object for the attribute '{@link TCS.SimpleMapping#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see TCS.SimpleMapping#getKey()
	 * @see #getSimpleMapping()
	 * @generated
	 */
	EAttribute getSimpleMapping_Key();

	/**
	 * Returns the meta object for the attribute '{@link TCS.SimpleMapping#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see TCS.SimpleMapping#getValue()
	 * @see #getSimpleMapping()
	 * @generated
	 */
	EAttribute getSimpleMapping_Value();

	/**
	 * Returns the meta object for class '{@link TCS.WildcardMapping <em>Wildcard Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Mapping</em>'.
	 * @see TCS.WildcardMapping
	 * @generated
	 */
	EClass getWildcardMapping();

	/**
	 * Returns the meta object for class '{@link TCS.OctalMapping <em>Octal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Octal Mapping</em>'.
	 * @see TCS.OctalMapping
	 * @generated
	 */
	EClass getOctalMapping();

	/**
	 * Returns the meta object for class '{@link TCS.HexadecimalMapping <em>Hexadecimal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hexadecimal Mapping</em>'.
	 * @see TCS.HexadecimalMapping
	 * @generated
	 */
	EClass getHexadecimalMapping();

	/**
	 * Returns the meta object for class '{@link TCS.StringPattern <em>String Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Pattern</em>'.
	 * @see TCS.StringPattern
	 * @generated
	 */
	EClass getStringPattern();

	/**
	 * Returns the meta object for class '{@link TCS.ClassPattern <em>Class Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Pattern</em>'.
	 * @see TCS.ClassPattern
	 * @generated
	 */
	EClass getClassPattern();

	/**
	 * Returns the meta object for class '{@link TCS.QualifiedNamedElement <em>Qualified Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Named Element</em>'.
	 * @see TCS.QualifiedNamedElement
	 * @generated
	 */
	EClass getQualifiedNamedElement();

	/**
	 * Returns the meta object for the attribute list '{@link TCS.QualifiedNamedElement#getNames <em>Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Names</em>'.
	 * @see TCS.QualifiedNamedElement#getNames()
	 * @see #getQualifiedNamedElement()
	 * @generated
	 */
	EAttribute getQualifiedNamedElement_Names();

	/**
	 * Returns the meta object for the reference '{@link TCS.QualifiedNamedElement#getMetaReference <em>Meta Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Reference</em>'.
	 * @see TCS.QualifiedNamedElement#getMetaReference()
	 * @see #getQualifiedNamedElement()
	 * @generated
	 */
	EReference getQualifiedNamedElement_MetaReference();

	/**
	 * Returns the meta object for class '{@link TCS.OCLQueryPArg <em>OCL Query PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Query PArg</em>'.
	 * @see TCS.OCLQueryPArg
	 * @generated
	 */
	EClass getOCLQueryPArg();

	/**
	 * Returns the meta object for the attribute '{@link TCS.OCLQueryPArg#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see TCS.OCLQueryPArg#getQuery()
	 * @see #getOCLQueryPArg()
	 * @generated
	 */
	EAttribute getOCLQueryPArg_Query();

	/**
	 * Returns the meta object for enum '{@link TCS.TemplateModifiers <em>Template Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Template Modifiers</em>'.
	 * @see TCS.TemplateModifiers
	 * @generated
	 */
	EEnum getTemplateModifiers();

	/**
	 * Returns the meta object for enum '{@link TCS.SpaceKind <em>Space Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Space Kind</em>'.
	 * @see TCS.SpaceKind
	 * @generated
	 */
	EEnum getSpaceKind();

	/**
	 * Returns the meta object for enum '{@link TCS.Associativity <em>Associativity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Associativity</em>'.
	 * @see TCS.Associativity
	 * @generated
	 */
	EEnum getAssociativity();

	/**
	 * Returns the meta object for enum '{@link TCS.AutoCreateKind <em>Auto Create Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Auto Create Kind</em>'.
	 * @see TCS.AutoCreateKind
	 * @generated
	 */
	EEnum getAutoCreateKind();

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
		 * The meta object literal for the '{@link TCS.impl.LocatedElementImpl <em>Located Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.LocatedElementImpl
		 * @see TCS.impl.TCSPackageImpl#getLocatedElement()
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
		 * The meta object literal for the '{@link TCS.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.NamedElementImpl
		 * @see TCS.impl.TCSPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link TCS.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ConcreteSyntaxImpl
		 * @see TCS.impl.TCSPackageImpl#getConcreteSyntax()
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
		 * The meta object literal for the '{@link TCS.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.TemplateImpl
		 * @see TCS.impl.TCSPackageImpl#getTemplate()
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
		 * The meta object literal for the '{@link TCS.impl.FunctionTemplateImpl <em>Function Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.FunctionTemplateImpl
		 * @see TCS.impl.TCSPackageImpl#getFunctionTemplate()
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
		 * The meta object literal for the '{@link TCS.impl.ClassTemplateImpl <em>Class Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ClassTemplateImpl
		 * @see TCS.impl.TCSPackageImpl#getClassTemplate()
		 * @generated
		 */
		EClass CLASS_TEMPLATE = eINSTANCE.getClassTemplate();

		/**
		 * The meta object literal for the '<em><b>Template Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEMPLATE__TEMPLATE_SEQUENCE = eINSTANCE.getClassTemplate_TemplateSequence();

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
		 * The meta object literal for the '<em><b>Prefix Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TEMPLATE__PREFIX_SEQUENCE = eINSTANCE.getClassTemplate_PrefixSequence();

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
		 * The meta object literal for the '<em><b>Is Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_TEMPLATE__IS_CONTEXT = eINSTANCE.getClassTemplate_IsContext();

		/**
		 * The meta object literal for the '<em><b>Is Add To Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_TEMPLATE__IS_ADD_TO_CONTEXT = eINSTANCE.getClassTemplate_IsAddToContext();

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
		 * The meta object literal for the '{@link TCS.impl.PrimitiveTemplateImpl <em>Primitive Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.PrimitiveTemplateImpl
		 * @see TCS.impl.TCSPackageImpl#getPrimitiveTemplate()
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
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TEMPLATE__IS_DEFAULT = eINSTANCE.getPrimitiveTemplate_IsDefault();

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
		 * The meta object literal for the '{@link TCS.impl.OperatorTemplateImpl <em>Operator Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OperatorTemplateImpl
		 * @see TCS.impl.TCSPackageImpl#getOperatorTemplate()
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
		 * The meta object literal for the '<em><b>Ot Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_TEMPLATE__OT_SEQUENCE = eINSTANCE.getOperatorTemplate_OtSequence();

		/**
		 * The meta object literal for the '<em><b>Is Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR_TEMPLATE__IS_CONTEXT = eINSTANCE.getOperatorTemplate_IsContext();

		/**
		 * The meta object literal for the '{@link TCS.impl.EnumerationTemplateImpl <em>Enumeration Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.EnumerationTemplateImpl
		 * @see TCS.impl.TCSPackageImpl#getEnumerationTemplate()
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
		 * The meta object literal for the '{@link TCS.impl.EnumLiteralMappingImpl <em>Enum Literal Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.EnumLiteralMappingImpl
		 * @see TCS.impl.TCSPackageImpl#getEnumLiteralMapping()
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
		 * The meta object literal for the '{@link TCS.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.LiteralImpl
		 * @see TCS.impl.TCSPackageImpl#getLiteral()
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
		 * The meta object literal for the '{@link TCS.impl.SymbolImpl <em>Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.SymbolImpl
		 * @see TCS.impl.TCSPackageImpl#getSymbol()
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
		 * The meta object literal for the '{@link TCS.impl.KeywordImpl <em>Keyword</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.KeywordImpl
		 * @see TCS.impl.TCSPackageImpl#getKeyword()
		 * @generated
		 */
		EClass KEYWORD = eINSTANCE.getKeyword();

		/**
		 * The meta object literal for the '{@link TCS.impl.OperatorListImpl <em>Operator List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OperatorListImpl
		 * @see TCS.impl.TCSPackageImpl#getOperatorList()
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
		 * The meta object literal for the '{@link TCS.impl.PriorityImpl <em>Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.PriorityImpl
		 * @see TCS.impl.TCSPackageImpl#getPriority()
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
		 * The meta object literal for the '{@link TCS.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OperatorImpl
		 * @see TCS.impl.TCSPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Is Postfix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__IS_POSTFIX = eINSTANCE.getOperator_IsPostfix();

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
		 * The meta object literal for the '{@link TCS.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.SequenceImpl
		 * @see TCS.impl.TCSPackageImpl#getSequence()
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
		 * The meta object literal for the '<em><b>Template Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__TEMPLATE_CONTAINER = eINSTANCE.getSequence_TemplateContainer();

		/**
		 * The meta object literal for the '<em><b>Prefix Container</b></em>' container reference feature.
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
		 * The meta object literal for the '<em><b>Ot Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__OT_CONTAINER = eINSTANCE.getSequence_OtContainer();

		/**
		 * The meta object literal for the '<em><b>Alternative Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__ALTERNATIVE_CONTAINER = eINSTANCE.getSequence_AlternativeContainer();

		/**
		 * The meta object literal for the '{@link TCS.impl.SequenceElementImpl <em>Sequence Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.SequenceElementImpl
		 * @see TCS.impl.TCSPackageImpl#getSequenceElement()
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
		 * The meta object literal for the '{@link TCS.impl.LiteralRefImpl <em>Literal Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.LiteralRefImpl
		 * @see TCS.impl.TCSPackageImpl#getLiteralRef()
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
		 * The meta object literal for the '{@link TCS.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.PropertyImpl
		 * @see TCS.impl.TCSPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Property Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__PROPERTY_ARGS = eINSTANCE.getProperty_PropertyArgs();

		/**
		 * The meta object literal for the '{@link TCS.impl.CustomSeparatorImpl <em>Custom Separator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.CustomSeparatorImpl
		 * @see TCS.impl.TCSPackageImpl#getCustomSeparator()
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
		 * The meta object literal for the '{@link TCS.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.BlockImpl
		 * @see TCS.impl.TCSPackageImpl#getBlock()
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
		 * The meta object literal for the '{@link TCS.impl.ConditionalElementImpl <em>Conditional Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ConditionalElementImpl
		 * @see TCS.impl.TCSPackageImpl#getConditionalElement()
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
		 * The meta object literal for the '{@link TCS.impl.PropertyInitImpl <em>Property Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.PropertyInitImpl
		 * @see TCS.impl.TCSPackageImpl#getPropertyInit()
		 * @generated
		 */
		EClass PROPERTY_INIT = eINSTANCE.getPropertyInit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_INIT__NAME = eINSTANCE.getPropertyInit_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_INIT__VALUE = eINSTANCE.getPropertyInit_Value();

		/**
		 * The meta object literal for the '{@link TCS.impl.AlternativeImpl <em>Alternative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.AlternativeImpl
		 * @see TCS.impl.TCSPackageImpl#getAlternative()
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
		 * The meta object literal for the '{@link TCS.impl.FunctionCallImpl <em>Function Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.FunctionCallImpl
		 * @see TCS.impl.TCSPackageImpl#getFunctionCall()
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
		 * The meta object literal for the '{@link TCS.impl.PropertyArgImpl <em>Property Arg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.PropertyArgImpl
		 * @see TCS.impl.TCSPackageImpl#getPropertyArg()
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
		 * The meta object literal for the '{@link TCS.impl.RefersToPArgImpl <em>Refers To PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.RefersToPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getRefersToPArg()
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
		 * The meta object literal for the '{@link TCS.impl.LookInPArgImpl <em>Look In PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.LookInPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getLookInPArg()
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
		 * The meta object literal for the '{@link TCS.impl.CreateInPArgImpl <em>Create In PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.CreateInPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getCreateInPArg()
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
		 * The meta object literal for the '{@link TCS.impl.RefersToKeyPArgImpl <em>Refers To Key PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.RefersToKeyPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getRefersToKeyPArg()
		 * @generated
		 */
		EClass REFERS_TO_KEY_PARG = eINSTANCE.getRefersToKeyPArg();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERS_TO_KEY_PARG__VALUE = eINSTANCE.getRefersToKeyPArg_Value();

		/**
		 * The meta object literal for the '{@link TCS.impl.SeparatorPArgImpl <em>Separator PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.SeparatorPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getSeparatorPArg()
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
		 * The meta object literal for the '{@link TCS.impl.AutoCreatePArgImpl <em>Auto Create PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.AutoCreatePArgImpl
		 * @see TCS.impl.TCSPackageImpl#getAutoCreatePArg()
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
		 * The meta object literal for the '{@link TCS.impl.ImportContextPArgImpl <em>Import Context PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ImportContextPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getImportContextPArg()
		 * @generated
		 */
		EClass IMPORT_CONTEXT_PARG = eINSTANCE.getImportContextPArg();

		/**
		 * The meta object literal for the '{@link TCS.impl.ForcedLowerPArgImpl <em>Forced Lower PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ForcedLowerPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getForcedLowerPArg()
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
		 * The meta object literal for the '{@link TCS.impl.CreateAsPArgImpl <em>Create As PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.CreateAsPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getCreateAsPArg()
		 * @generated
		 */
		EClass CREATE_AS_PARG = eINSTANCE.getCreateAsPArg();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_AS_PARG__NAME = eINSTANCE.getCreateAsPArg_Name();

		/**
		 * The meta object literal for the '{@link TCS.impl.AsPArgImpl <em>As PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.AsPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getAsPArg()
		 * @generated
		 */
		EClass AS_PARG = eINSTANCE.getAsPArg();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AS_PARG__VALUE = eINSTANCE.getAsPArg_Value();

		/**
		 * The meta object literal for the '{@link TCS.impl.ModePArgImpl <em>Mode PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ModePArgImpl
		 * @see TCS.impl.TCSPackageImpl#getModePArg()
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
		 * The meta object literal for the '{@link TCS.impl.BlockArgImpl <em>Block Arg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.BlockArgImpl
		 * @see TCS.impl.TCSPackageImpl#getBlockArg()
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
		 * The meta object literal for the '{@link TCS.impl.NbNLBArgImpl <em>Nb NLB Arg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.NbNLBArgImpl
		 * @see TCS.impl.TCSPackageImpl#getNbNLBArg()
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
		 * The meta object literal for the '{@link TCS.impl.IndentIncrBArgImpl <em>Indent Incr BArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.IndentIncrBArgImpl
		 * @see TCS.impl.TCSPackageImpl#getIndentIncrBArg()
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
		 * The meta object literal for the '{@link TCS.impl.StartNLBArgImpl <em>Start NLB Arg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.StartNLBArgImpl
		 * @see TCS.impl.TCSPackageImpl#getStartNLBArg()
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
		 * The meta object literal for the '{@link TCS.impl.StartNbNLBArgImpl <em>Start Nb NLB Arg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.StartNbNLBArgImpl
		 * @see TCS.impl.TCSPackageImpl#getStartNbNLBArg()
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
		 * The meta object literal for the '{@link TCS.impl.EndNLBArgImpl <em>End NLB Arg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.EndNLBArgImpl
		 * @see TCS.impl.TCSPackageImpl#getEndNLBArg()
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
		 * The meta object literal for the '{@link TCS.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ExpressionImpl
		 * @see TCS.impl.TCSPackageImpl#getExpression()
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
		 * The meta object literal for the '{@link TCS.impl.AndExpImpl <em>And Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.AndExpImpl
		 * @see TCS.impl.TCSPackageImpl#getAndExp()
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
		 * The meta object literal for the '{@link TCS.impl.AtomExpImpl <em>Atom Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.AtomExpImpl
		 * @see TCS.impl.TCSPackageImpl#getAtomExp()
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
		 * The meta object literal for the '{@link TCS.impl.EqualsExpImpl <em>Equals Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.EqualsExpImpl
		 * @see TCS.impl.TCSPackageImpl#getEqualsExp()
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
		 * The meta object literal for the '{@link TCS.impl.BooleanPropertyExpImpl <em>Boolean Property Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.BooleanPropertyExpImpl
		 * @see TCS.impl.TCSPackageImpl#getBooleanPropertyExp()
		 * @generated
		 */
		EClass BOOLEAN_PROPERTY_EXP = eINSTANCE.getBooleanPropertyExp();

		/**
		 * The meta object literal for the '{@link TCS.impl.IsDefinedExpImpl <em>Is Defined Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.IsDefinedExpImpl
		 * @see TCS.impl.TCSPackageImpl#getIsDefinedExp()
		 * @generated
		 */
		EClass IS_DEFINED_EXP = eINSTANCE.getIsDefinedExp();

		/**
		 * The meta object literal for the '{@link TCS.impl.OneExpImpl <em>One Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OneExpImpl
		 * @see TCS.impl.TCSPackageImpl#getOneExp()
		 * @generated
		 */
		EClass ONE_EXP = eINSTANCE.getOneExp();

		/**
		 * The meta object literal for the '{@link TCS.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ValueImpl
		 * @see TCS.impl.TCSPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link TCS.impl.StringValImpl <em>String Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.StringValImpl
		 * @see TCS.impl.TCSPackageImpl#getStringVal()
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
		 * The meta object literal for the '{@link TCS.impl.IntegerValImpl <em>Integer Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.IntegerValImpl
		 * @see TCS.impl.TCSPackageImpl#getIntegerVal()
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
		 * The meta object literal for the '{@link TCS.impl.NegativeIntegerValImpl <em>Negative Integer Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.NegativeIntegerValImpl
		 * @see TCS.impl.TCSPackageImpl#getNegativeIntegerVal()
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
		 * The meta object literal for the '{@link TCS.impl.EnumLiteralValImpl <em>Enum Literal Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.EnumLiteralValImpl
		 * @see TCS.impl.TCSPackageImpl#getEnumLiteralVal()
		 * @generated
		 */
		EClass ENUM_LITERAL_VAL = eINSTANCE.getEnumLiteralVal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_VAL__NAME = eINSTANCE.getEnumLiteralVal_Name();

		/**
		 * The meta object literal for the '{@link TCS.impl.PropertyValImpl <em>Property Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.PropertyValImpl
		 * @see TCS.impl.TCSPackageImpl#getPropertyVal()
		 * @generated
		 */
		EClass PROPERTY_VAL = eINSTANCE.getPropertyVal();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_VAL__PROPERTY_NAME = eINSTANCE.getPropertyVal_PropertyName();

		/**
		 * The meta object literal for the '{@link TCS.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.TokenImpl
		 * @see TCS.impl.TCSPackageImpl#getToken()
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
		 * The meta object literal for the '{@link TCS.impl.OrPatternImpl <em>Or Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OrPatternImpl
		 * @see TCS.impl.TCSPackageImpl#getOrPattern()
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
		 * The meta object literal for the '{@link TCS.impl.SimplePatternImpl <em>Simple Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.SimplePatternImpl
		 * @see TCS.impl.TCSPackageImpl#getSimplePattern()
		 * @generated
		 */
		EClass SIMPLE_PATTERN = eINSTANCE.getSimplePattern();

		/**
		 * The meta object literal for the '{@link TCS.impl.RulePatternImpl <em>Rule Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.RulePatternImpl
		 * @see TCS.impl.TCSPackageImpl#getRulePattern()
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
		 * The meta object literal for the '{@link TCS.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.RuleImpl
		 * @see TCS.impl.TCSPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '{@link TCS.impl.WordRuleImpl <em>Word Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.WordRuleImpl
		 * @see TCS.impl.TCSPackageImpl#getWordRule()
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
		 * The meta object literal for the '{@link TCS.impl.WordImpl <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.WordImpl
		 * @see TCS.impl.TCSPackageImpl#getWord()
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
		 * The meta object literal for the '{@link TCS.impl.EndOfLineRuleImpl <em>End Of Line Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.EndOfLineRuleImpl
		 * @see TCS.impl.TCSPackageImpl#getEndOfLineRule()
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
		 * The meta object literal for the '{@link TCS.impl.MultiLineRuleImpl <em>Multi Line Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.MultiLineRuleImpl
		 * @see TCS.impl.TCSPackageImpl#getMultiLineRule()
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
		 * The meta object literal for the '<em><b>Drop Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_LINE_RULE__DROP_START = eINSTANCE.getMultiLineRule_DropStart();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_LINE_RULE__END = eINSTANCE.getMultiLineRule_End();

		/**
		 * The meta object literal for the '<em><b>Drop End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_LINE_RULE__DROP_END = eINSTANCE.getMultiLineRule_DropEnd();

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
		 * The meta object literal for the '{@link TCS.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.MappingImpl
		 * @see TCS.impl.TCSPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '{@link TCS.impl.SimpleMappingImpl <em>Simple Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.SimpleMappingImpl
		 * @see TCS.impl.TCSPackageImpl#getSimpleMapping()
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
		 * The meta object literal for the '{@link TCS.impl.WildcardMappingImpl <em>Wildcard Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.WildcardMappingImpl
		 * @see TCS.impl.TCSPackageImpl#getWildcardMapping()
		 * @generated
		 */
		EClass WILDCARD_MAPPING = eINSTANCE.getWildcardMapping();

		/**
		 * The meta object literal for the '{@link TCS.impl.OctalMappingImpl <em>Octal Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OctalMappingImpl
		 * @see TCS.impl.TCSPackageImpl#getOctalMapping()
		 * @generated
		 */
		EClass OCTAL_MAPPING = eINSTANCE.getOctalMapping();

		/**
		 * The meta object literal for the '{@link TCS.impl.HexadecimalMappingImpl <em>Hexadecimal Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.HexadecimalMappingImpl
		 * @see TCS.impl.TCSPackageImpl#getHexadecimalMapping()
		 * @generated
		 */
		EClass HEXADECIMAL_MAPPING = eINSTANCE.getHexadecimalMapping();

		/**
		 * The meta object literal for the '{@link TCS.impl.StringPatternImpl <em>String Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.StringPatternImpl
		 * @see TCS.impl.TCSPackageImpl#getStringPattern()
		 * @generated
		 */
		EClass STRING_PATTERN = eINSTANCE.getStringPattern();

		/**
		 * The meta object literal for the '{@link TCS.impl.ClassPatternImpl <em>Class Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.ClassPatternImpl
		 * @see TCS.impl.TCSPackageImpl#getClassPattern()
		 * @generated
		 */
		EClass CLASS_PATTERN = eINSTANCE.getClassPattern();

		/**
		 * The meta object literal for the '{@link TCS.impl.QualifiedNamedElementImpl <em>Qualified Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.QualifiedNamedElementImpl
		 * @see TCS.impl.TCSPackageImpl#getQualifiedNamedElement()
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
		 * The meta object literal for the '{@link TCS.impl.OCLQueryPArgImpl <em>OCL Query PArg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.impl.OCLQueryPArgImpl
		 * @see TCS.impl.TCSPackageImpl#getOCLQueryPArg()
		 * @generated
		 */
		EClass OCL_QUERY_PARG = eINSTANCE.getOCLQueryPArg();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY_PARG__QUERY = eINSTANCE.getOCLQueryPArg_Query();

		/**
		 * The meta object literal for the '{@link TCS.TemplateModifiers <em>Template Modifiers</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.TemplateModifiers
		 * @see TCS.impl.TCSPackageImpl#getTemplateModifiers()
		 * @generated
		 */
		EEnum TEMPLATE_MODIFIERS = eINSTANCE.getTemplateModifiers();

		/**
		 * The meta object literal for the '{@link TCS.SpaceKind <em>Space Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.SpaceKind
		 * @see TCS.impl.TCSPackageImpl#getSpaceKind()
		 * @generated
		 */
		EEnum SPACE_KIND = eINSTANCE.getSpaceKind();

		/**
		 * The meta object literal for the '{@link TCS.Associativity <em>Associativity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.Associativity
		 * @see TCS.impl.TCSPackageImpl#getAssociativity()
		 * @generated
		 */
		EEnum ASSOCIATIVITY = eINSTANCE.getAssociativity();

		/**
		 * The meta object literal for the '{@link TCS.AutoCreateKind <em>Auto Create Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TCS.AutoCreateKind
		 * @see TCS.impl.TCSPackageImpl#getAutoCreateKind()
		 * @generated
		 */
		EEnum AUTO_CREATE_KIND = eINSTANCE.getAutoCreateKind();

	}

} //TCSPackage
