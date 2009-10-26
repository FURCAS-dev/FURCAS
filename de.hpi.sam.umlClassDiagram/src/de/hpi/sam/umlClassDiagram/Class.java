/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Class#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Class#getMethod <em>Method</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Class#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Class#getIncomingConnections <em>Incoming Connections</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Class#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Class#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Element {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link de.hpi.sam.umlClassDiagram.Attribute}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Attribute#getAttributeOwner <em>Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_Attribute()
	 * @see de.hpi.sam.umlClassDiagram.Attribute#getAttributeOwner
	 * @model opposite="attributeOwner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference list.
	 * The list contents are of type {@link de.hpi.sam.umlClassDiagram.Method}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Method#getMethodOwner <em>Method Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference list.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_Method()
	 * @see de.hpi.sam.umlClassDiagram.Method#getMethodOwner
	 * @model opposite="methodOwner" containment="true"
	 * @generated
	 */
	EList<Method> getMethod();

	/**
	 * Returns the value of the '<em><b>Outgoing Connections</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.umlClassDiagram.Connection}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Connections</em>' reference list.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_OutgoingConnections()
	 * @see de.hpi.sam.umlClassDiagram.Connection#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Connection> getOutgoingConnections();

	/**
	 * Returns the value of the '<em><b>Incoming Connections</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.umlClassDiagram.Connection}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Connection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Connections</em>' reference list.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_IncomingConnections()
	 * @see de.hpi.sam.umlClassDiagram.Connection#getDestination
	 * @model opposite="destination"
	 * @generated
	 */
	EList<Connection> getIncomingConnections();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_IsAbstract()
	 * @model
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Class#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getClass_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Class#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Class
