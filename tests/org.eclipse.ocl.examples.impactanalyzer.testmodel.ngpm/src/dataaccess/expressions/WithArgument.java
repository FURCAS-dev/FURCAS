/**
 * <copyright>
 * </copyright>
 *
 * $Id: WithArgument.java,v 1.2 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>With Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.WithArgument#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getWithArgument()
 * @model abstract="true"
 * @generated
 */
public interface WithArgument extends EObject {
	/**
     * Returns the value of the '<em><b>Argument</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getArgumentOf <em>Argument Of</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Argument</em>' containment reference.
     * @see #setArgument(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getWithArgument_Argument()
     * @see dataaccess.expressions.Expression#getArgumentOf
     * @model opposite="argumentOf" containment="true" resolveProxies="true"
     * @generated
     */
	Expression getArgument();

	/**
     * Sets the value of the '{@link dataaccess.expressions.WithArgument#getArgument <em>Argument</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Argument</em>' containment reference.
     * @see #getArgument()
     * @generated
     */
	void setArgument(Expression value);

} // WithArgument
