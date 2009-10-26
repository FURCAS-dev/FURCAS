/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Method#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Method#getMethodOwner <em>Method Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Element {
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
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getMethod_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Method#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Method Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Class#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Owner</em>' container reference.
	 * @see #setMethodOwner(de.hpi.sam.umlClassDiagram.Class)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getMethod_MethodOwner()
	 * @see de.hpi.sam.umlClassDiagram.Class#getMethod
	 * @model opposite="method" transient="false"
	 * @generated
	 */
	de.hpi.sam.umlClassDiagram.Class getMethodOwner();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Method#getMethodOwner <em>Method Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Owner</em>' container reference.
	 * @see #getMethodOwner()
	 * @generated
	 */
	void setMethodOwner(de.hpi.sam.umlClassDiagram.Class value);

} // Method
