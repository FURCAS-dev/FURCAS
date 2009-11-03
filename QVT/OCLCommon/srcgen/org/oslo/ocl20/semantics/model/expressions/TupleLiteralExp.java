/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp#getTuplePart <em>Tuple Part
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Tuple Part</b></em>' reference list. The list contents are
	 * of type {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getTupleLiteralExp
	 * <em>Tuple Literal Exp</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuple Part</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tuple Part</em>' reference list.
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getTupleLiteralExp_TuplePart()
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getTupleLiteralExp
	 * @model type="org.oslo.ocl20.semantics.model.expressions.VariableDeclaration"
	 *        opposite="tupleLiteralExp"
	 * @generated
	 */
	EList getTuplePart();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // TupleLiteralExp
