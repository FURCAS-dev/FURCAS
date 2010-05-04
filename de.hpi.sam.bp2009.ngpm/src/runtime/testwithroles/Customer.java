/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithroles.Customer#getSalesOrder <em>Sales Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithroles.TestwithrolesPackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends EObject
{
  /**
   * Returns the value of the '<em><b>Sales Order</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithroles.SalesOrder}.
   * It is bidirectional and its opposite is '{@link runtime.testwithroles.SalesOrder#getBuyer <em>Buyer</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sales Order</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sales Order</em>' reference list.
   * @see runtime.testwithroles.TestwithrolesPackage#getCustomer_SalesOrder()
   * @see runtime.testwithroles.SalesOrder#getBuyer
   * @model opposite="buyer"
   * @generated
   */
  EList<SalesOrder> getSalesOrder();

} // Customer
