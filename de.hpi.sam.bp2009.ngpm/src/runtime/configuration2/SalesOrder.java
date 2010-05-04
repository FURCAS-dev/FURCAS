/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sales Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.configuration2.SalesOrder#getNumberRange <em>Number Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.configuration2.Configuration2Package#getSalesOrder()
 * @model
 * @generated
 */
public interface SalesOrder extends EObject
{
  /**
   * Returns the value of the '<em><b>Number Range</b></em>' reference list.
   * The list contents are of type {@link runtime.configuration2.NumberRange}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Range</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Range</em>' reference list.
   * @see runtime.configuration2.Configuration2Package#getSalesOrder_NumberRange()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<NumberRange> getNumberRange();

} // SalesOrder
