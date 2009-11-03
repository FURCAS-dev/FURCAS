/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.oslo.ocl20.syntax.ast.AstPackage#getVisitor()
 * @model
 * @generated
 */
public interface Visitor extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 * @generated
	 */
	Object visit(Visitable visitable, Object data);

} // Visitor
