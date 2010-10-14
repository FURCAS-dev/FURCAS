/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.literals;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A literal of any primitive type, such as "This is a string" or 123 or an enumeration literal or a literal denoting a value of an implicit anonymous class, or a block, or a literal that denotes a (potentially anonymous) class.
 * 
 * The exact type of a literal may not always be possible to decide completely, particularly when it comes to constrained types over primitive types. This can only come in through "post types" and type inference, e.g., in an assignment statement where the type of the lvalue is known.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.literals.Literal#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.literals.LiteralsPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends Expression {
	/**
     * Returns the value of the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Represents the value of this literal as a string. Final interpretation has to happen by the type of the literal expression. For string literals this is particularly straightforward. For numbers and dates, specific formats as defined by the respective types may apply.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Literal</em>' attribute.
     * @see #setLiteral(String)
     * @see dataaccess.expressions.literals.LiteralsPackage#getLiteral_Literal()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	String getLiteral();

	/**
     * Sets the value of the '{@link dataaccess.expressions.literals.Literal#getLiteral <em>Literal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Literal</em>' attribute.
     * @see #getLiteral()
     * @generated
     */
	void setLiteral(String value);

} // Literal
