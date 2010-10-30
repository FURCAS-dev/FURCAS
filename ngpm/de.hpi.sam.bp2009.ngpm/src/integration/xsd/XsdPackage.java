/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;

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
 * @see integration.xsd.XsdFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface XsdPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "xsd";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///integration/xsd.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "integration.xsd";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	XsdPackage eINSTANCE = integration.xsd.impl.XsdPackageImpl.init();

	/**
     * The meta object id for the '{@link integration.xsd.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.RootImpl
     * @see integration.xsd.impl.XsdPackageImpl#getRoot()
     * @generated
     */
	int ROOT = 9;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ROOT__ID = 0;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ROOT__ANNO = 1;

	/**
     * The number of structural features of the '<em>Root</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ROOT_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link integration.xsd.impl.ContainableImpl <em>Containable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.ContainableImpl
     * @see integration.xsd.impl.XsdPackageImpl#getContainable()
     * @generated
     */
	int CONTAINABLE = 6;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTAINABLE__ID = ROOT__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTAINABLE__ANNO = ROOT__ANNO;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTAINABLE__MIN_OCCURS = ROOT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTAINABLE__MAX_OCCURS = ROOT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Containable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTAINABLE_FEATURE_COUNT = ROOT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link integration.xsd.impl.SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.SequenceImpl
     * @see integration.xsd.impl.XsdPackageImpl#getSequence()
     * @generated
     */
	int SEQUENCE = 0;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE__ID = CONTAINABLE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE__ANNO = CONTAINABLE__ANNO;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE__MIN_OCCURS = CONTAINABLE__MIN_OCCURS;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE__MAX_OCCURS = CONTAINABLE__MAX_OCCURS;

	/**
     * The feature id for the '<em><b>Children</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE__CHILDREN = CONTAINABLE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Sequence</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_FEATURE_COUNT = CONTAINABLE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.ChoiceImpl <em>Choice</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.ChoiceImpl
     * @see integration.xsd.impl.XsdPackageImpl#getChoice()
     * @generated
     */
	int CHOICE = 1;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CHOICE__ID = CONTAINABLE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CHOICE__ANNO = CONTAINABLE__ANNO;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CHOICE__MIN_OCCURS = CONTAINABLE__MIN_OCCURS;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CHOICE__MAX_OCCURS = CONTAINABLE__MAX_OCCURS;

	/**
     * The feature id for the '<em><b>Children</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CHOICE__CHILDREN = CONTAINABLE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Choice</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CHOICE_FEATURE_COUNT = CONTAINABLE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.NamedElementImpl
     * @see integration.xsd.impl.XsdPackageImpl#getNamedElement()
     * @generated
     */
	int NAMED_ELEMENT = 4;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT__ID = ROOT__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT__ANNO = ROOT__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT__NAME = ROOT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.AbstractTypeImpl
     * @see integration.xsd.impl.XsdPackageImpl#getAbstractType()
     * @generated
     */
	int ABSTRACT_TYPE = 5;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_TYPE__ID = NAMED_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_TYPE__ANNO = NAMED_ELEMENT__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
     * The number of structural features of the '<em>Abstract Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link integration.xsd.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.ComplexTypeImpl
     * @see integration.xsd.impl.XsdPackageImpl#getComplexType()
     * @generated
     */
	int COMPLEX_TYPE = 2;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_TYPE__ANNO = ABSTRACT_TYPE__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Atts</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_TYPE__ATTS = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Content</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_TYPE__CONTENT = ABSTRACT_TYPE_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Complex Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link integration.xsd.impl.ElementDefinitionImpl <em>Element Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.ElementDefinitionImpl
     * @see integration.xsd.impl.XsdPackageImpl#getElementDefinition()
     * @generated
     */
	int ELEMENT_DEFINITION = 3;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_DEFINITION__ID = NAMED_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_DEFINITION__ANNO = NAMED_ELEMENT__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_DEFINITION__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_DEFINITION__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Element Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_DEFINITION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.AttributeImpl
     * @see integration.xsd.impl.XsdPackageImpl#getAttribute()
     * @generated
     */
	int ATTRIBUTE = 7;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE__ID = NAMED_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE__ANNO = NAMED_ELEMENT__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Use</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE__USE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Val</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE__VAL = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Attribute</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link integration.xsd.impl.AnyImpl <em>Any</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.AnyImpl
     * @see integration.xsd.impl.XsdPackageImpl#getAny()
     * @generated
     */
	int ANY = 8;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANY__ID = CONTAINABLE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANY__ANNO = CONTAINABLE__ANNO;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANY__MIN_OCCURS = CONTAINABLE__MIN_OCCURS;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANY__MAX_OCCURS = CONTAINABLE__MAX_OCCURS;

	/**
     * The number of structural features of the '<em>Any</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANY_FEATURE_COUNT = CONTAINABLE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link integration.xsd.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.GroupImpl
     * @see integration.xsd.impl.XsdPackageImpl#getGroup()
     * @generated
     */
	int GROUP = 10;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP__ID = CONTAINABLE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP__ANNO = CONTAINABLE__ANNO;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP__MIN_OCCURS = CONTAINABLE__MIN_OCCURS;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP__MAX_OCCURS = CONTAINABLE__MAX_OCCURS;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP__NAME = CONTAINABLE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Group</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_FEATURE_COUNT = CONTAINABLE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.AnnotationImpl
     * @see integration.xsd.impl.XsdPackageImpl#getAnnotation()
     * @generated
     */
	int ANNOTATION = 11;

	/**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANNOTATION__DOCUMENTATION = 0;

	/**
     * The feature id for the '<em><b>App Info</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANNOTATION__APP_INFO = 1;

	/**
     * The number of structural features of the '<em>Annotation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANNOTATION_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link integration.xsd.impl.NotationImpl <em>Notation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.NotationImpl
     * @see integration.xsd.impl.XsdPackageImpl#getNotation()
     * @generated
     */
	int NOTATION = 12;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NOTATION__ID = NAMED_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NOTATION__ANNO = NAMED_ELEMENT__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NOTATION__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Public Dec</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NOTATION__PUBLIC_DEC = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>System Dec</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NOTATION__SYSTEM_DEC = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Notation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NOTATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link integration.xsd.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.SimpleTypeImpl
     * @see integration.xsd.impl.XsdPackageImpl#getSimpleType()
     * @generated
     */
	int SIMPLE_TYPE = 13;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_TYPE__ANNO = ABSTRACT_TYPE__ANNO;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Content</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_TYPE__CONTENT = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Simple Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.ElementReferenceImpl <em>Element Reference</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.ElementReferenceImpl
     * @see integration.xsd.impl.XsdPackageImpl#getElementReference()
     * @generated
     */
	int ELEMENT_REFERENCE = 14;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_REFERENCE__ID = CONTAINABLE__ID;

	/**
     * The feature id for the '<em><b>Anno</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_REFERENCE__ANNO = CONTAINABLE__ANNO;

	/**
     * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_REFERENCE__MIN_OCCURS = CONTAINABLE__MIN_OCCURS;

	/**
     * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_REFERENCE__MAX_OCCURS = CONTAINABLE__MAX_OCCURS;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_REFERENCE__NAME = CONTAINABLE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Element Reference</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_REFERENCE_FEATURE_COUNT = CONTAINABLE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.xsd.impl.AbstractContentImpl <em>Abstract Content</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.AbstractContentImpl
     * @see integration.xsd.impl.XsdPackageImpl#getAbstractContent()
     * @generated
     */
	int ABSTRACT_CONTENT = 15;

	/**
     * The number of structural features of the '<em>Abstract Content</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_CONTENT_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link integration.xsd.impl.SimpleContentImpl <em>Simple Content</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.SimpleContentImpl
     * @see integration.xsd.impl.XsdPackageImpl#getSimpleContent()
     * @generated
     */
	int SIMPLE_CONTENT = 16;

	/**
     * The feature id for the '<em><b>Base</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_CONTENT__BASE = ABSTRACT_CONTENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Enum Vals</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_CONTENT__ENUM_VALS = ABSTRACT_CONTENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Simple Content</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_CONTENT_FEATURE_COUNT = ABSTRACT_CONTENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link integration.xsd.impl.ComplexContentImpl <em>Complex Content</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.impl.ComplexContentImpl
     * @see integration.xsd.impl.XsdPackageImpl#getComplexContent()
     * @generated
     */
	int COMPLEX_CONTENT = 17;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_CONTENT__MIXED = ABSTRACT_CONTENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Content Model</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_CONTENT__CONTENT_MODEL = ABSTRACT_CONTENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Complex Content</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_CONTENT_FEATURE_COUNT = ABSTRACT_CONTENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link integration.xsd.AttUseType <em>Att Use Type</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.xsd.AttUseType
     * @see integration.xsd.impl.XsdPackageImpl#getAttUseType()
     * @generated
     */
	int ATT_USE_TYPE = 18;


	/**
     * Returns the meta object for class '{@link integration.xsd.Sequence <em>Sequence</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence</em>'.
     * @see integration.xsd.Sequence
     * @generated
     */
	EClass getSequence();

	/**
     * Returns the meta object for the reference list '{@link integration.xsd.Sequence#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Children</em>'.
     * @see integration.xsd.Sequence#getChildren()
     * @see #getSequence()
     * @generated
     */
	EReference getSequence_Children();

	/**
     * Returns the meta object for class '{@link integration.xsd.Choice <em>Choice</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Choice</em>'.
     * @see integration.xsd.Choice
     * @generated
     */
	EClass getChoice();

	/**
     * Returns the meta object for the reference list '{@link integration.xsd.Choice#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Children</em>'.
     * @see integration.xsd.Choice#getChildren()
     * @see #getChoice()
     * @generated
     */
	EReference getChoice_Children();

	/**
     * Returns the meta object for class '{@link integration.xsd.ComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Complex Type</em>'.
     * @see integration.xsd.ComplexType
     * @generated
     */
	EClass getComplexType();

	/**
     * Returns the meta object for the reference list '{@link integration.xsd.ComplexType#getAtts <em>Atts</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Atts</em>'.
     * @see integration.xsd.ComplexType#getAtts()
     * @see #getComplexType()
     * @generated
     */
	EReference getComplexType_Atts();

	/**
     * Returns the meta object for the reference '{@link integration.xsd.ComplexType#getContent <em>Content</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Content</em>'.
     * @see integration.xsd.ComplexType#getContent()
     * @see #getComplexType()
     * @generated
     */
	EReference getComplexType_Content();

	/**
     * Returns the meta object for class '{@link integration.xsd.ElementDefinition <em>Element Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element Definition</em>'.
     * @see integration.xsd.ElementDefinition
     * @generated
     */
	EClass getElementDefinition();

	/**
     * Returns the meta object for the reference '{@link integration.xsd.ElementDefinition#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see integration.xsd.ElementDefinition#getType()
     * @see #getElementDefinition()
     * @generated
     */
	EReference getElementDefinition_Type();

	/**
     * Returns the meta object for class '{@link integration.xsd.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see integration.xsd.NamedElement
     * @generated
     */
	EClass getNamedElement();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see integration.xsd.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
	EAttribute getNamedElement_Name();

	/**
     * Returns the meta object for class '{@link integration.xsd.AbstractType <em>Abstract Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Type</em>'.
     * @see integration.xsd.AbstractType
     * @generated
     */
	EClass getAbstractType();

	/**
     * Returns the meta object for class '{@link integration.xsd.Containable <em>Containable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Containable</em>'.
     * @see integration.xsd.Containable
     * @generated
     */
	EClass getContainable();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Containable#getMinOccurs <em>Min Occurs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Occurs</em>'.
     * @see integration.xsd.Containable#getMinOccurs()
     * @see #getContainable()
     * @generated
     */
	EAttribute getContainable_MinOccurs();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Containable#getMaxOccurs <em>Max Occurs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Occurs</em>'.
     * @see integration.xsd.Containable#getMaxOccurs()
     * @see #getContainable()
     * @generated
     */
	EAttribute getContainable_MaxOccurs();

	/**
     * Returns the meta object for class '{@link integration.xsd.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute</em>'.
     * @see integration.xsd.Attribute
     * @generated
     */
	EClass getAttribute();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Attribute#getUse <em>Use</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use</em>'.
     * @see integration.xsd.Attribute#getUse()
     * @see #getAttribute()
     * @generated
     */
	EAttribute getAttribute_Use();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Attribute#getVal <em>Val</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Val</em>'.
     * @see integration.xsd.Attribute#getVal()
     * @see #getAttribute()
     * @generated
     */
	EAttribute getAttribute_Val();

	/**
     * Returns the meta object for the reference '{@link integration.xsd.Attribute#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see integration.xsd.Attribute#getType()
     * @see #getAttribute()
     * @generated
     */
	EReference getAttribute_Type();

	/**
     * Returns the meta object for class '{@link integration.xsd.Any <em>Any</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Any</em>'.
     * @see integration.xsd.Any
     * @generated
     */
	EClass getAny();

	/**
     * Returns the meta object for class '{@link integration.xsd.Root <em>Root</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Root</em>'.
     * @see integration.xsd.Root
     * @generated
     */
	EClass getRoot();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Root#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see integration.xsd.Root#getId()
     * @see #getRoot()
     * @generated
     */
	EAttribute getRoot_Id();

	/**
     * Returns the meta object for the reference '{@link integration.xsd.Root#getAnno <em>Anno</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Anno</em>'.
     * @see integration.xsd.Root#getAnno()
     * @see #getRoot()
     * @generated
     */
	EReference getRoot_Anno();

	/**
     * Returns the meta object for class '{@link integration.xsd.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group</em>'.
     * @see integration.xsd.Group
     * @generated
     */
	EClass getGroup();

	/**
     * Returns the meta object for class '{@link integration.xsd.Annotation <em>Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Annotation</em>'.
     * @see integration.xsd.Annotation
     * @generated
     */
	EClass getAnnotation();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Annotation#getDocumentation <em>Documentation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Documentation</em>'.
     * @see integration.xsd.Annotation#getDocumentation()
     * @see #getAnnotation()
     * @generated
     */
	EAttribute getAnnotation_Documentation();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Annotation#getAppInfo <em>App Info</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>App Info</em>'.
     * @see integration.xsd.Annotation#getAppInfo()
     * @see #getAnnotation()
     * @generated
     */
	EAttribute getAnnotation_AppInfo();

	/**
     * Returns the meta object for class '{@link integration.xsd.Notation <em>Notation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Notation</em>'.
     * @see integration.xsd.Notation
     * @generated
     */
	EClass getNotation();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Notation#getPublicDec <em>Public Dec</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Public Dec</em>'.
     * @see integration.xsd.Notation#getPublicDec()
     * @see #getNotation()
     * @generated
     */
	EAttribute getNotation_PublicDec();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.Notation#getSystemDec <em>System Dec</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>System Dec</em>'.
     * @see integration.xsd.Notation#getSystemDec()
     * @see #getNotation()
     * @generated
     */
	EAttribute getNotation_SystemDec();

	/**
     * Returns the meta object for class '{@link integration.xsd.SimpleType <em>Simple Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Type</em>'.
     * @see integration.xsd.SimpleType
     * @generated
     */
	EClass getSimpleType();

	/**
     * Returns the meta object for the reference '{@link integration.xsd.SimpleType#getContent <em>Content</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Content</em>'.
     * @see integration.xsd.SimpleType#getContent()
     * @see #getSimpleType()
     * @generated
     */
	EReference getSimpleType_Content();

	/**
     * Returns the meta object for class '{@link integration.xsd.ElementReference <em>Element Reference</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element Reference</em>'.
     * @see integration.xsd.ElementReference
     * @generated
     */
	EClass getElementReference();

	/**
     * Returns the meta object for class '{@link integration.xsd.AbstractContent <em>Abstract Content</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Content</em>'.
     * @see integration.xsd.AbstractContent
     * @generated
     */
	EClass getAbstractContent();

	/**
     * Returns the meta object for class '{@link integration.xsd.SimpleContent <em>Simple Content</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Content</em>'.
     * @see integration.xsd.SimpleContent
     * @generated
     */
	EClass getSimpleContent();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.SimpleContent#getBase <em>Base</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base</em>'.
     * @see integration.xsd.SimpleContent#getBase()
     * @see #getSimpleContent()
     * @generated
     */
	EAttribute getSimpleContent_Base();

	/**
     * Returns the meta object for the attribute list '{@link integration.xsd.SimpleContent#getEnumVals <em>Enum Vals</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Enum Vals</em>'.
     * @see integration.xsd.SimpleContent#getEnumVals()
     * @see #getSimpleContent()
     * @generated
     */
	EAttribute getSimpleContent_EnumVals();

	/**
     * Returns the meta object for class '{@link integration.xsd.ComplexContent <em>Complex Content</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Complex Content</em>'.
     * @see integration.xsd.ComplexContent
     * @generated
     */
	EClass getComplexContent();

	/**
     * Returns the meta object for the attribute '{@link integration.xsd.ComplexContent#isMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mixed</em>'.
     * @see integration.xsd.ComplexContent#isMixed()
     * @see #getComplexContent()
     * @generated
     */
	EAttribute getComplexContent_Mixed();

	/**
     * Returns the meta object for the reference '{@link integration.xsd.ComplexContent#getContentModel <em>Content Model</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Content Model</em>'.
     * @see integration.xsd.ComplexContent#getContentModel()
     * @see #getComplexContent()
     * @generated
     */
	EReference getComplexContent_ContentModel();

	/**
     * Returns the meta object for enum '{@link integration.xsd.AttUseType <em>Att Use Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Att Use Type</em>'.
     * @see integration.xsd.AttUseType
     * @generated
     */
	EEnum getAttUseType();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	XsdFactory getXsdFactory();

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
         * The meta object literal for the '{@link integration.xsd.impl.SequenceImpl <em>Sequence</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.SequenceImpl
         * @see integration.xsd.impl.XsdPackageImpl#getSequence()
         * @generated
         */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
         * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SEQUENCE__CHILDREN = eINSTANCE.getSequence_Children();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.ChoiceImpl <em>Choice</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.ChoiceImpl
         * @see integration.xsd.impl.XsdPackageImpl#getChoice()
         * @generated
         */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
         * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CHOICE__CHILDREN = eINSTANCE.getChoice_Children();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.ComplexTypeImpl
         * @see integration.xsd.impl.XsdPackageImpl#getComplexType()
         * @generated
         */
		EClass COMPLEX_TYPE = eINSTANCE.getComplexType();

		/**
         * The meta object literal for the '<em><b>Atts</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COMPLEX_TYPE__ATTS = eINSTANCE.getComplexType_Atts();

		/**
         * The meta object literal for the '<em><b>Content</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COMPLEX_TYPE__CONTENT = eINSTANCE.getComplexType_Content();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.ElementDefinitionImpl <em>Element Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.ElementDefinitionImpl
         * @see integration.xsd.impl.XsdPackageImpl#getElementDefinition()
         * @generated
         */
		EClass ELEMENT_DEFINITION = eINSTANCE.getElementDefinition();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ELEMENT_DEFINITION__TYPE = eINSTANCE.getElementDefinition_Type();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.NamedElementImpl
         * @see integration.xsd.impl.XsdPackageImpl#getNamedElement()
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
         * The meta object literal for the '{@link integration.xsd.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.AbstractTypeImpl
         * @see integration.xsd.impl.XsdPackageImpl#getAbstractType()
         * @generated
         */
		EClass ABSTRACT_TYPE = eINSTANCE.getAbstractType();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.ContainableImpl <em>Containable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.ContainableImpl
         * @see integration.xsd.impl.XsdPackageImpl#getContainable()
         * @generated
         */
		EClass CONTAINABLE = eINSTANCE.getContainable();

		/**
         * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CONTAINABLE__MIN_OCCURS = eINSTANCE.getContainable_MinOccurs();

		/**
         * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CONTAINABLE__MAX_OCCURS = eINSTANCE.getContainable_MaxOccurs();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.AttributeImpl <em>Attribute</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.AttributeImpl
         * @see integration.xsd.impl.XsdPackageImpl#getAttribute()
         * @generated
         */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
         * The meta object literal for the '<em><b>Use</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE__USE = eINSTANCE.getAttribute_Use();

		/**
         * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE__VAL = eINSTANCE.getAttribute_Val();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.AnyImpl <em>Any</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.AnyImpl
         * @see integration.xsd.impl.XsdPackageImpl#getAny()
         * @generated
         */
		EClass ANY = eINSTANCE.getAny();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.RootImpl <em>Root</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.RootImpl
         * @see integration.xsd.impl.XsdPackageImpl#getRoot()
         * @generated
         */
		EClass ROOT = eINSTANCE.getRoot();

		/**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ROOT__ID = eINSTANCE.getRoot_Id();

		/**
         * The meta object literal for the '<em><b>Anno</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ROOT__ANNO = eINSTANCE.getRoot_Anno();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.GroupImpl <em>Group</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.GroupImpl
         * @see integration.xsd.impl.XsdPackageImpl#getGroup()
         * @generated
         */
		EClass GROUP = eINSTANCE.getGroup();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.AnnotationImpl <em>Annotation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.AnnotationImpl
         * @see integration.xsd.impl.XsdPackageImpl#getAnnotation()
         * @generated
         */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
         * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ANNOTATION__DOCUMENTATION = eINSTANCE.getAnnotation_Documentation();

		/**
         * The meta object literal for the '<em><b>App Info</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ANNOTATION__APP_INFO = eINSTANCE.getAnnotation_AppInfo();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.NotationImpl <em>Notation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.NotationImpl
         * @see integration.xsd.impl.XsdPackageImpl#getNotation()
         * @generated
         */
		EClass NOTATION = eINSTANCE.getNotation();

		/**
         * The meta object literal for the '<em><b>Public Dec</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute NOTATION__PUBLIC_DEC = eINSTANCE.getNotation_PublicDec();

		/**
         * The meta object literal for the '<em><b>System Dec</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute NOTATION__SYSTEM_DEC = eINSTANCE.getNotation_SystemDec();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.SimpleTypeImpl
         * @see integration.xsd.impl.XsdPackageImpl#getSimpleType()
         * @generated
         */
		EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

		/**
         * The meta object literal for the '<em><b>Content</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIMPLE_TYPE__CONTENT = eINSTANCE.getSimpleType_Content();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.ElementReferenceImpl <em>Element Reference</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.ElementReferenceImpl
         * @see integration.xsd.impl.XsdPackageImpl#getElementReference()
         * @generated
         */
		EClass ELEMENT_REFERENCE = eINSTANCE.getElementReference();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.AbstractContentImpl <em>Abstract Content</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.AbstractContentImpl
         * @see integration.xsd.impl.XsdPackageImpl#getAbstractContent()
         * @generated
         */
		EClass ABSTRACT_CONTENT = eINSTANCE.getAbstractContent();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.SimpleContentImpl <em>Simple Content</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.SimpleContentImpl
         * @see integration.xsd.impl.XsdPackageImpl#getSimpleContent()
         * @generated
         */
		EClass SIMPLE_CONTENT = eINSTANCE.getSimpleContent();

		/**
         * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIMPLE_CONTENT__BASE = eINSTANCE.getSimpleContent_Base();

		/**
         * The meta object literal for the '<em><b>Enum Vals</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIMPLE_CONTENT__ENUM_VALS = eINSTANCE.getSimpleContent_EnumVals();

		/**
         * The meta object literal for the '{@link integration.xsd.impl.ComplexContentImpl <em>Complex Content</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.impl.ComplexContentImpl
         * @see integration.xsd.impl.XsdPackageImpl#getComplexContent()
         * @generated
         */
		EClass COMPLEX_CONTENT = eINSTANCE.getComplexContent();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COMPLEX_CONTENT__MIXED = eINSTANCE.getComplexContent_Mixed();

		/**
         * The meta object literal for the '<em><b>Content Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COMPLEX_CONTENT__CONTENT_MODEL = eINSTANCE.getComplexContent_ContentModel();

		/**
         * The meta object literal for the '{@link integration.xsd.AttUseType <em>Att Use Type</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.xsd.AttUseType
         * @see integration.xsd.impl.XsdPackageImpl#getAttUseType()
         * @generated
         */
		EEnum ATT_USE_TYPE = eINSTANCE.getAttUseType();

	}

} //XsdPackage
