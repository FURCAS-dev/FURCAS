/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.query;

import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.query.FromClause#getFromClauseOfOqlQuery <em>From Clause Of Oql Query</em>}</li>
 *   <li>{@link dataaccess.query.FromClause#getFromExpression <em>From Expression</em>}</li>
 *   <li>{@link dataaccess.query.FromClause#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.query.QueryPackage#getFromClause()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL FromClausesMustBeSideEffectFree='self.fromExpression.isSideEffectFree()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FromClausesMustBeSideEffectFree'"
 * @generated
 */
public interface FromClause extends EObject {
	/**
     * Returns the value of the '<em><b>From Clause Of Oql Query</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.query.OqlQuery#getFromClauses <em>From Clauses</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Clause Of Oql Query</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From Clause Of Oql Query</em>' container reference.
     * @see #setFromClauseOfOqlQuery(OqlQuery)
     * @see dataaccess.query.QueryPackage#getFromClause_FromClauseOfOqlQuery()
     * @see dataaccess.query.OqlQuery#getFromClauses
     * @model opposite="fromClauses"
     * @generated
     */
	OqlQuery getFromClauseOfOqlQuery();

	/**
     * Sets the value of the '{@link dataaccess.query.FromClause#getFromClauseOfOqlQuery <em>From Clause Of Oql Query</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Clause Of Oql Query</em>' container reference.
     * @see #getFromClauseOfOqlQuery()
     * @generated
     */
	void setFromClauseOfOqlQuery(OqlQuery value);

	/**
     * Returns the value of the '<em><b>From Expression</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getFromClause <em>From Clause</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From Expression</em>' containment reference.
     * @see #setFromExpression(Expression)
     * @see dataaccess.query.QueryPackage#getFromClause_FromExpression()
     * @see dataaccess.expressions.Expression#getFromClause
     * @model opposite="fromClause" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getFromExpression();

	/**
     * Sets the value of the '{@link dataaccess.query.FromClause#getFromExpression <em>From Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Expression</em>' containment reference.
     * @see #getFromExpression()
     * @generated
     */
	void setFromExpression(Expression value);

	/**
     * Returns the value of the '<em><b>Alias</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getFromClause <em>From Clause</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Alias</em>' containment reference.
     * @see #setAlias(Iterator)
     * @see dataaccess.query.QueryPackage#getFromClause_Alias()
     * @see behavioral.actions.Iterator#getFromClause
     * @model opposite="fromClause" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Iterator getAlias();

	/**
     * Sets the value of the '{@link dataaccess.query.FromClause#getAlias <em>Alias</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alias</em>' containment reference.
     * @see #getAlias()
     * @generated
     */
	void setAlias(Iterator value);

} // FromClause
