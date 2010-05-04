/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see runtime.configuration2.Configuration2Package
 * @generated
 */
public interface Configuration2Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Configuration2Factory eINSTANCE = runtime.configuration2.impl.Configuration2FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Sales Order</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sales Order</em>'.
   * @generated
   */
  SalesOrder createSalesOrder();

  /**
   * Returns a new object of class '<em>Number Range Impl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Range Impl</em>'.
   * @generated
   */
  NumberRangeImpl createNumberRangeImpl();

  /**
   * Returns a new object of class '<em>Purchase Order</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Purchase Order</em>'.
   * @generated
   */
  PurchaseOrder createPurchaseOrder();

  /**
   * Returns a new object of class '<em>Purchase Order Number Ranges</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Purchase Order Number Ranges</em>'.
   * @generated
   */
  PurchaseOrderNumberRanges createPurchaseOrderNumberRanges();

  /**
   * Returns a new object of class '<em>Sales Order Number Ranges</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sales Order Number Ranges</em>'.
   * @generated
   */
  SalesOrderNumberRanges createSalesOrderNumberRanges();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Configuration2Package getConfiguration2Package();

} //Configuration2Factory
