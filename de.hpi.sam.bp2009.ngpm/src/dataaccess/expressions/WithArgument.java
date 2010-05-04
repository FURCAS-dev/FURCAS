/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
public interface WithArgument extends EObject
{
  /**
   * Returns the value of the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument</em>' containment reference.
   * @see #setArgument(Expression)
   * @see dataaccess.expressions.ExpressionsPackage#getWithArgument_Argument()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='argumentOf'"
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
