/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopExp.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.LoopExp#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getLoopExp()
 * @model
 * @generated
 */
public interface LoopExp<C, PM> extends CallExp<C> {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OCLExpression<C>)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getLoopExp_Body()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression<C> getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.LoopExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpression<C> value);

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.expressions.Variable<C, PM>}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference list.
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getLoopExp_Iterator()
	 * @model type="org.eclipse.ocl.expressions.Variable" containment="true"
	 * @generated
	 */
	EList<Variable<C, PM>> getIterator();

} // LoopExp
