/**
 * <copyright>
 * </copyright>
 *
 * $Id: IterateExp.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.IterateExp#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIterateExp()
 * @model
 * @generated
 */
public interface IterateExp<C, PM> extends LoopExp<C, PM> {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(Variable<C, PM>)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIterateExp_Result()
	 * @model containment="true"
	 * @generated
	 */
	Variable<C, PM> getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.IterateExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Variable<C, PM> value);

} // IterateExp
