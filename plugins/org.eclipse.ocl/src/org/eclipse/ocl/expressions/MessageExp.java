/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageExp.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.utilities.CallingASTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.MessageExp#getSentSignal <em>Sent Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getMessageExp()
 * @model
 * @generated
 */
public interface MessageExp<C, COA, SSA> extends OCLExpression<C>, CallingASTNode {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OCLExpression<C>)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getMessageExp_Target()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression<C> getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.MessageExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OCLExpression<C> value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.expressions.OCLExpression<C>}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getMessageExp_Argument()
	 * @model type="org.eclipse.ocl.expressions.OCLExpression" containment="true"
	 * @generated
	 */
	EList<OCLExpression<C>> getArgument();

	/**
	 * Returns the value of the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Operation</em>' containment reference.
	 * @see #setCalledOperation(COA)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getMessageExp_CalledOperation()
	 * @model containment="true"
	 * @generated
	 */
	COA getCalledOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.MessageExp#getCalledOperation <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Operation</em>' containment reference.
	 * @see #getCalledOperation()
	 * @generated
	 */
	void setCalledOperation(COA value);

	/**
	 * Returns the value of the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sent Signal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sent Signal</em>' containment reference.
	 * @see #setSentSignal(SSA)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getMessageExp_SentSignal()
	 * @model containment="true"
	 * @generated
	 */
	SSA getSentSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.MessageExp#getSentSignal <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sent Signal</em>' containment reference.
	 * @see #getSentSignal()
	 * @generated
	 */
	void setSentSignal(SSA value);

} // MessageExp
