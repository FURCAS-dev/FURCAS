/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.Action#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends Operation
{
  /**
   * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
   * The literals are from the enumeration {@link sproxy_content.Cardinality}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cardinality</em>' attribute.
   * @see sproxy_content.Cardinality
   * @see #setCardinality(Cardinality)
   * @see sproxy_content.Sproxy_contentPackage#getAction_Cardinality()
   * @model
   * @generated
   */
  Cardinality getCardinality();

  /**
   * Sets the value of the '{@link sproxy_content.Action#getCardinality <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardinality</em>' attribute.
   * @see sproxy_content.Cardinality
   * @see #getCardinality()
   * @generated
   */
  void setCardinality(Cardinality value);

} // Action
