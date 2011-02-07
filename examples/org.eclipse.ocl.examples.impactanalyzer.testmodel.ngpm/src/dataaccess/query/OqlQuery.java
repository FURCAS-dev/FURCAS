/**
 * <copyright>
 * </copyright>
 *
 * $Id: OqlQuery.java,v 1.1 2011/02/07 16:53:52 auhl Exp $
 */
package dataaccess.query;

import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Oql Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.query.OqlQuery#getCondition <em>Condition</em>}</li>
 *   <li>{@link dataaccess.query.OqlQuery#getFromClauses <em>From Clauses</em>}</li>
 *   <li>{@link dataaccess.query.OqlQuery#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.query.QueryPackage#getOqlQuery()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ConditionMustBeBoolean='self.condition->notEmpty() implies\r\n    (self.condition.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n     self.condition.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name=\'Boolean\')' WhereClauseMustBeSideEffectFree='self.condition->forAll(c | c.isSideEffectFree())' HasValueType='self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType' SelectedIteratorsMustHaveClassTypeDefinitionAsType='self.selected->forAll(i | i.getType().oclIsKindOf(data::classes::ClassTypeDefinition))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConditionMustBeBoolean WhereClauseMustBeSideEffectFree HasValueType SelectedIteratorsMustHaveClassTypeDefinitionAsType'"
 * @generated
 */
public interface OqlQuery extends Expression
{
  /**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getConditionOfOqlQuery <em>Condition Of Oql Query</em>}'.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(Expression)
     * @see dataaccess.query.QueryPackage#getOqlQuery_Condition()
     * @see dataaccess.expressions.Expression#getConditionOfOqlQuery
     * @model opposite="conditionOfOqlQuery" containment="true" resolveProxies="true"
     * @generated
     */
  Expression getCondition();

  /**
     * Sets the value of the '{@link dataaccess.query.OqlQuery#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
  void setCondition(Expression value);

  /**
     * Returns the value of the '<em><b>From Clauses</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.query.FromClause}.
     * It is bidirectional and its opposite is '{@link dataaccess.query.FromClause#getFromClauseOfOqlQuery <em>From Clause Of Oql Query</em>}'.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Clauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>From Clauses</em>' containment reference list.
     * @see dataaccess.query.QueryPackage#getOqlQuery_FromClauses()
     * @see dataaccess.query.FromClause#getFromClauseOfOqlQuery
     * @model opposite="fromClauseOfOqlQuery" containment="true" resolveProxies="true" required="true"
     * @generated
     */
  EList<FromClause> getFromClauses();

  /**
     * Returns the value of the '<em><b>Selected</b></em>' reference list.
     * The list contents are of type {@link behavioral.actions.Iterator}.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selected</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Selected</em>' reference list.
     * @see dataaccess.query.QueryPackage#getOqlQuery_Selected()
     * @model required="true"
     * @generated
     */
  EList<Iterator> getSelected();

} // OqlQuery
