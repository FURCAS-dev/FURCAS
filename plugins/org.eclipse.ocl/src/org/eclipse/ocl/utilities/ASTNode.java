/**
 * <copyright>
 * </copyright>
 *
 * $Id: ASTNode.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.utilities;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AST Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.ASTNode#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.ASTNode#getEndPosition <em>End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getASTNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ASTNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Position</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Position</em>' attribute.
	 * @see #setStartPosition(int)
	 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getASTNode_StartPosition()
	 * @model default="-1" transient="true"
	 * @generated
	 */
	int getStartPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.utilities.ASTNode#getStartPosition <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Position</em>' attribute.
	 * @see #getStartPosition()
	 * @generated
	 */
	void setStartPosition(int value);

	/**
	 * Returns the value of the '<em><b>End Position</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Position</em>' attribute.
	 * @see #setEndPosition(int)
	 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getASTNode_EndPosition()
	 * @model default="-1" transient="true"
	 * @generated
	 */
	int getEndPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.utilities.ASTNode#getEndPosition <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Position</em>' attribute.
	 * @see #getEndPosition()
	 * @generated
	 */
	void setEndPosition(int value);

} // ASTNode
