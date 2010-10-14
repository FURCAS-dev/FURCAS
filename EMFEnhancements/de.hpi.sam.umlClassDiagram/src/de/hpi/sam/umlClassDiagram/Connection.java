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
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Connection#getSource <em>Source</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Connection#getDestination <em>Destination</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Connection#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends Element {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Class#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(de.hpi.sam.umlClassDiagram.Class)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getConnection_Source()
	 * @see de.hpi.sam.umlClassDiagram.Class#getOutgoingConnections
	 * @model opposite="outgoingConnections"
	 * @generated
	 */
	de.hpi.sam.umlClassDiagram.Class getSource();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Connection#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(de.hpi.sam.umlClassDiagram.Class value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Class#getIncomingConnections <em>Incoming Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(de.hpi.sam.umlClassDiagram.Class)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getConnection_Destination()
	 * @see de.hpi.sam.umlClassDiagram.Class#getIncomingConnections
	 * @model opposite="incomingConnections"
	 * @generated
	 */
	de.hpi.sam.umlClassDiagram.Class getDestination();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Connection#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(de.hpi.sam.umlClassDiagram.Class value);

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' attribute list.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getConnection_Annotation()
	 * @model upper="2"
	 * @generated
	 */
	EList<String> getAnnotation();

} // Connection
