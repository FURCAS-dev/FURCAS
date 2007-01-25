/**
 * <copyright>
 * </copyright>
 *
 * $Id: CallExp.java,v 1.1 2007/01/25 18:24:33 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.ocl.utilities.CallingASTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CallExp#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCallExp()
 * @model abstract="true"
 * @generated
 */
public interface CallExp<C> extends OCLExpression<C>, CallingASTNode {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OCLExpression<C>)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCallExp_Source()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression<C> getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.CallExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OCLExpression<C> value);

} // CallExp
