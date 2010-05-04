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
 * A representation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link runtime.testwithroles.Supplier#getSalesOrder <em>Sales Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see runtime.testwithroles.TestwithrolesPackage#getSupplier()
 * @model
 * @generated
 */
public interface Supplier extends EObject
{
  /**
   * Returns the value of the '<em><b>Sales Order</b></em>' reference list.
   * The list contents are of type {@link runtime.testwithroles.SalesOrder}.
   * It is bidirectional and its opposite is '{@link runtime.testwithroles.SalesOrder#getSeller <em>Seller</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sales Order</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sales Order</em>' reference list.
   * @see runtime.testwithroles.TestwithrolesPackage#getSupplier_SalesOrder()
   * @see runtime.testwithroles.SalesOrder#getSeller
   * @model opposite="seller"
   * @generated
   */
  EList<SalesOrder> getSalesOrder();

} // Supplier
