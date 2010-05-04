/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.CollectionExpression#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getCollectionExpression()
 * @model abstract="true"
 * @generated
 */
public interface CollectionExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(Expression)
   * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getCollectionExpression_Source()
   * @model containment="true" required="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='collectionExpression'"
   * @generated
   */
  Expression getSource();

  /**
   * Sets the value of the '{@link dataaccess.expressions.collectionexpressions.CollectionExpression#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Expression value);

} // CollectionExpression
