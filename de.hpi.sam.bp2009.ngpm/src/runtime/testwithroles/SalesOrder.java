/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sales Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithroles.SalesOrder#getBuyer <em>Buyer</em>}</li>
 *   <li>{@link runtime.testwithroles.SalesOrder#getSeller <em>Seller</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithroles.TestwithrolesPackage#getSalesOrder()
 * @model
 * @generated
 */
public interface SalesOrder extends EObject
{
  /**
   * Returns the value of the '<em><b>Buyer</b></em>' reference.
   * It is bidirectional and its opposite is '{@link runtime.testwithroles.Customer#getSalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Buyer</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Buyer</em>' reference.
   * @see #setBuyer(Customer)
   * @see runtime.testwithroles.TestwithrolesPackage#getSalesOrder_Buyer()
   * @see runtime.testwithroles.Customer#getSalesOrder
   * @model opposite="SalesOrder" required="true"
   * @generated
   */
  Customer getBuyer();

  /**
   * Sets the value of the '{@link runtime.testwithroles.SalesOrder#getBuyer <em>Buyer</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Buyer</em>' reference.
   * @see #getBuyer()
   * @generated
   */
  void setBuyer(Customer value);

  /**
   * Returns the value of the '<em><b>Seller</b></em>' reference.
   * It is bidirectional and its opposite is '{@link runtime.testwithroles.Supplier#getSalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Seller</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Seller</em>' reference.
   * @see #setSeller(Supplier)
   * @see runtime.testwithroles.TestwithrolesPackage#getSalesOrder_Seller()
   * @see runtime.testwithroles.Supplier#getSalesOrder
   * @model opposite="SalesOrder" required="true"
   * @generated
   */
  Supplier getSeller();

  /**
   * Sets the value of the '{@link runtime.testwithroles.SalesOrder#getSeller <em>Seller</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Seller</em>' reference.
   * @see #getSeller()
   * @generated
   */
  void setSeller(Supplier value);

} // SalesOrder
