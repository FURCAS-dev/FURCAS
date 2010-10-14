/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramFactory
 * @model kind="package"
 * @generated
 */
public interface UmlClassDiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "umlClassDiagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://umlClassDiagram/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "umlClassDiagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlClassDiagramPackage eINSTANCE = de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramImpl <em>Uml Class Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getUmlClassDiagram()
	 * @generated
	 */
	int UML_CLASS_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_CLASS_DIAGRAM__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Uml Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_CLASS_DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.ElementImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__DIAGRAM = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.ClassImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__METHOD = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OUTGOING_CONNECTIONS = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INCOMING_CONNECTIONS = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.AttributeImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ATTRIBUTE_OWNER = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.MethodImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 4;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__METHOD_OWNER = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.ConnectionImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 5;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DIAGRAM = ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DESTINATION = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ANNOTATION = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.CompositionImpl <em>Composition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.CompositionImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getComposition()
	 * @generated
	 */
	int COMPOSITION = 6;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__DIAGRAM = CONNECTION__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__DESTINATION = CONNECTION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__ANNOTATION = CONNECTION__ANNOTATION;

	/**
	 * The number of structural features of the '<em>Composition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.AggregationImpl <em>Aggregation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.AggregationImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getAggregation()
	 * @generated
	 */
	int AGGREGATION = 7;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__DIAGRAM = CONNECTION__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__DESTINATION = CONNECTION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__ANNOTATION = CONNECTION__ANNOTATION;

	/**
	 * The number of structural features of the '<em>Aggregation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.RelationImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 8;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__DIAGRAM = CONNECTION__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__DESTINATION = CONNECTION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ANNOTATION = CONNECTION__ANNOTATION;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.umlClassDiagram.impl.InheritanceImpl <em>Inheritance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.umlClassDiagram.impl.InheritanceImpl
	 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getInheritance()
	 * @generated
	 */
	int INHERITANCE = 9;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITANCE__DIAGRAM = CONNECTION__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITANCE__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITANCE__DESTINATION = CONNECTION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITANCE__ANNOTATION = CONNECTION__ANNOTATION;

	/**
	 * The number of structural features of the '<em>Inheritance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITANCE_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.UmlClassDiagram <em>Uml Class Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uml Class Diagram</em>'.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagram
	 * @generated
	 */
	EClass getUmlClassDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hpi.sam.umlClassDiagram.UmlClassDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagram#getElements()
	 * @see #getUmlClassDiagram()
	 * @generated
	 */
	EReference getUmlClassDiagram_Elements();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the container reference '{@link de.hpi.sam.umlClassDiagram.Element#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Diagram</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Element#getDiagram()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Diagram();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hpi.sam.umlClassDiagram.Class#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class#getAttribute()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attribute();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hpi.sam.umlClassDiagram.Class#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class#getMethod()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Method();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.umlClassDiagram.Class#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class#getOutgoingConnections()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OutgoingConnections();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.umlClassDiagram.Class#getIncomingConnections <em>Incoming Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Connections</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class#getIncomingConnections()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_IncomingConnections();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.umlClassDiagram.Class#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class#isIsAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.umlClassDiagram.Class#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Class#getName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Name();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.umlClassDiagram.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the container reference '{@link de.hpi.sam.umlClassDiagram.Attribute#getAttributeOwner <em>Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Attribute Owner</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Attribute#getAttributeOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_AttributeOwner();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.umlClassDiagram.Method#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Method#getName()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Name();

	/**
	 * Returns the meta object for the container reference '{@link de.hpi.sam.umlClassDiagram.Method#getMethodOwner <em>Method Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Method Owner</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Method#getMethodOwner()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_MethodOwner();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.umlClassDiagram.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Connection#getSource()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Source();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.umlClassDiagram.Connection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Connection#getDestination()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Destination();

	/**
	 * Returns the meta object for the attribute list '{@link de.hpi.sam.umlClassDiagram.Connection#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Annotation</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Connection#getAnnotation()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Annotation();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Composition <em>Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Composition
	 * @generated
	 */
	EClass getComposition();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Aggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Aggregation
	 * @generated
	 */
	EClass getAggregation();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.umlClassDiagram.Inheritance <em>Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inheritance</em>'.
	 * @see de.hpi.sam.umlClassDiagram.Inheritance
	 * @generated
	 */
	EClass getInheritance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlClassDiagramFactory getUmlClassDiagramFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramImpl <em>Uml Class Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getUmlClassDiagram()
		 * @generated
		 */
		EClass UML_CLASS_DIAGRAM = eINSTANCE.getUmlClassDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_CLASS_DIAGRAM__ELEMENTS = eINSTANCE.getUmlClassDiagram_Elements();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.ElementImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__DIAGRAM = eINSTANCE.getElement_Diagram();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.ClassImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTE = eINSTANCE.getClass_Attribute();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__METHOD = eINSTANCE.getClass_Method();

		/**
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OUTGOING_CONNECTIONS = eINSTANCE.getClass_OutgoingConnections();

		/**
		 * The meta object literal for the '<em><b>Incoming Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__INCOMING_CONNECTIONS = eINSTANCE.getClass_IncomingConnections();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ABSTRACT = eINSTANCE.getClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__NAME = eINSTANCE.getClass_Name();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.AttributeImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Attribute Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__ATTRIBUTE_OWNER = eINSTANCE.getAttribute_AttributeOwner();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.MethodImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__NAME = eINSTANCE.getMethod_Name();

		/**
		 * The meta object literal for the '<em><b>Method Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__METHOD_OWNER = eINSTANCE.getMethod_MethodOwner();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.ConnectionImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__DESTINATION = eINSTANCE.getConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ANNOTATION = eINSTANCE.getConnection_Annotation();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.CompositionImpl <em>Composition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.CompositionImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getComposition()
		 * @generated
		 */
		EClass COMPOSITION = eINSTANCE.getComposition();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.AggregationImpl <em>Aggregation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.AggregationImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getAggregation()
		 * @generated
		 */
		EClass AGGREGATION = eINSTANCE.getAggregation();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.RelationImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.umlClassDiagram.impl.InheritanceImpl <em>Inheritance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.umlClassDiagram.impl.InheritanceImpl
		 * @see de.hpi.sam.umlClassDiagram.impl.UmlClassDiagramPackageImpl#getInheritance()
		 * @generated
		 */
		EClass INHERITANCE = eINSTANCE.getInheritance();

	}

} //UmlClassDiagramPackage
