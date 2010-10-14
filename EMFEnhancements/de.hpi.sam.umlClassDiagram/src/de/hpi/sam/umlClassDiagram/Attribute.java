/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Attribute#getAttributeOwner <em>Attribute Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Element {
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
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getAttribute_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Attribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Attribute Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Class#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Owner</em>' container reference.
	 * @see #setAttributeOwner(de.hpi.sam.umlClassDiagram.Class)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getAttribute_AttributeOwner()
	 * @see de.hpi.sam.umlClassDiagram.Class#getAttribute
	 * @model opposite="attribute" transient="false"
	 * @generated
	 */
	de.hpi.sam.umlClassDiagram.Class getAttributeOwner();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Attribute#getAttributeOwner <em>Attribute Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Owner</em>' container reference.
	 * @see #getAttributeOwner()
	 * @generated
	 */
	void setAttributeOwner(de.hpi.sam.umlClassDiagram.Class value);

} // Attribute
