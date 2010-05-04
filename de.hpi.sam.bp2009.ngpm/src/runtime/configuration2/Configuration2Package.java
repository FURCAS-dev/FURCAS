/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see runtime.configuration2.Configuration2Factory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface Configuration2Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "configuration2";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///runtime/configuration2.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "runtime.configuration2";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Configuration2Package eINSTANCE = runtime.configuration2.impl.Configuration2PackageImpl.init();

  /**
   * The meta object id for the '{@link runtime.configuration2.impl.SalesOrderImpl <em>Sales Order</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.configuration2.impl.SalesOrderImpl
   * @see runtime.configuration2.impl.Configuration2PackageImpl#getSalesOrder()
   * @generated
   */
  int SALES_ORDER = 0;

  /**
   * The feature id for the '<em><b>Number Range</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER__NUMBER_RANGE = 0;

  /**
   * The number of structural features of the '<em>Sales Order</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link runtime.configuration2.impl.NumberRangeImplImpl <em>Number Range Impl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.configuration2.impl.NumberRangeImplImpl
   * @see runtime.configuration2.impl.Configuration2PackageImpl#getNumberRangeImpl()
   * @generated
   */
  int NUMBER_RANGE_IMPL = 1;

  /**
   * The number of structural features of the '<em>Number Range Impl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_RANGE_IMPL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.configuration2.impl.PurchaseOrderImpl <em>Purchase Order</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.configuration2.impl.PurchaseOrderImpl
   * @see runtime.configuration2.impl.Configuration2PackageImpl#getPurchaseOrder()
   * @generated
   */
  int PURCHASE_ORDER = 2;

  /**
   * The feature id for the '<em><b>Number Range</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PURCHASE_ORDER__NUMBER_RANGE = 0;

  /**
   * The number of structural features of the '<em>Purchase Order</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PURCHASE_ORDER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link runtime.configuration2.NumberRange <em>Number Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.configuration2.NumberRange
   * @see runtime.configuration2.impl.Configuration2PackageImpl#getNumberRange()
   * @generated
   */
  int NUMBER_RANGE = 3;

  /**
   * The number of structural features of the '<em>Number Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_RANGE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.configuration2.impl.PurchaseOrderNumberRangesImpl <em>Purchase Order Number Ranges</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.configuration2.impl.PurchaseOrderNumberRangesImpl
   * @see runtime.configuration2.impl.Configuration2PackageImpl#getPurchaseOrderNumberRanges()
   * @generated
   */
  int PURCHASE_ORDER_NUMBER_RANGES = 4;

  /**
   * The feature id for the '<em><b>Nr1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PURCHASE_ORDER_NUMBER_RANGES__NR1 = 0;

  /**
   * The feature id for the '<em><b>Nr2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PURCHASE_ORDER_NUMBER_RANGES__NR2 = 1;

  /**
   * The number of structural features of the '<em>Purchase Order Number Ranges</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PURCHASE_ORDER_NUMBER_RANGES_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link runtime.configuration2.impl.SalesOrderNumberRangesImpl <em>Sales Order Number Ranges</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.configuration2.impl.SalesOrderNumberRangesImpl
   * @see runtime.configuration2.impl.Configuration2PackageImpl#getSalesOrderNumberRanges()
   * @generated
   */
  int SALES_ORDER_NUMBER_RANGES = 5;

  /**
   * The feature id for the '<em><b>Nr1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER_NUMBER_RANGES__NR1 = 0;

  /**
   * The feature id for the '<em><b>Nr2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER_NUMBER_RANGES__NR2 = 1;

  /**
   * The number of structural features of the '<em>Sales Order Number Ranges</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SALES_ORDER_NUMBER_RANGES_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link runtime.configuration2.SalesOrder <em>Sales Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sales Order</em>'.
   * @see runtime.configuration2.SalesOrder
   * @generated
   */
  EClass getSalesOrder();

  /**
   * Returns the meta object for the reference list '{@link runtime.configuration2.SalesOrder#getNumberRange <em>Number Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Number Range</em>'.
   * @see runtime.configuration2.SalesOrder#getNumberRange()
   * @see #getSalesOrder()
   * @generated
   */
  EReference getSalesOrder_NumberRange();

  /**
   * Returns the meta object for class '{@link runtime.configuration2.NumberRangeImpl <em>Number Range Impl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Range Impl</em>'.
   * @see runtime.configuration2.NumberRangeImpl
   * @generated
   */
  EClass getNumberRangeImpl();

  /**
   * Returns the meta object for class '{@link runtime.configuration2.PurchaseOrder <em>Purchase Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Purchase Order</em>'.
   * @see runtime.configuration2.PurchaseOrder
   * @generated
   */
  EClass getPurchaseOrder();

  /**
   * Returns the meta object for the reference list '{@link runtime.configuration2.PurchaseOrder#getNumberRange <em>Number Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Number Range</em>'.
   * @see runtime.configuration2.PurchaseOrder#getNumberRange()
   * @see #getPurchaseOrder()
   * @generated
   */
  EReference getPurchaseOrder_NumberRange();

  /**
   * Returns the meta object for class '{@link runtime.configuration2.NumberRange <em>Number Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Range</em>'.
   * @see runtime.configuration2.NumberRange
   * @generated
   */
  EClass getNumberRange();

  /**
   * Returns the meta object for class '{@link runtime.configuration2.PurchaseOrderNumberRanges <em>Purchase Order Number Ranges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Purchase Order Number Ranges</em>'.
   * @see runtime.configuration2.PurchaseOrderNumberRanges
   * @generated
   */
  EClass getPurchaseOrderNumberRanges();

  /**
   * Returns the meta object for the containment reference '{@link runtime.configuration2.PurchaseOrderNumberRanges#getNr1 <em>Nr1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nr1</em>'.
   * @see runtime.configuration2.PurchaseOrderNumberRanges#getNr1()
   * @see #getPurchaseOrderNumberRanges()
   * @generated
   */
  EReference getPurchaseOrderNumberRanges_Nr1();

  /**
   * Returns the meta object for the containment reference '{@link runtime.configuration2.PurchaseOrderNumberRanges#getNr2 <em>Nr2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nr2</em>'.
   * @see runtime.configuration2.PurchaseOrderNumberRanges#getNr2()
   * @see #getPurchaseOrderNumberRanges()
   * @generated
   */
  EReference getPurchaseOrderNumberRanges_Nr2();

  /**
   * Returns the meta object for class '{@link runtime.configuration2.SalesOrderNumberRanges <em>Sales Order Number Ranges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sales Order Number Ranges</em>'.
   * @see runtime.configuration2.SalesOrderNumberRanges
   * @generated
   */
  EClass getSalesOrderNumberRanges();

  /**
   * Returns the meta object for the containment reference '{@link runtime.configuration2.SalesOrderNumberRanges#getNr1 <em>Nr1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nr1</em>'.
   * @see runtime.configuration2.SalesOrderNumberRanges#getNr1()
   * @see #getSalesOrderNumberRanges()
   * @generated
   */
  EReference getSalesOrderNumberRanges_Nr1();

  /**
   * Returns the meta object for the containment reference '{@link runtime.configuration2.SalesOrderNumberRanges#getNr2 <em>Nr2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nr2</em>'.
   * @see runtime.configuration2.SalesOrderNumberRanges#getNr2()
   * @see #getSalesOrderNumberRanges()
   * @generated
   */
  EReference getSalesOrderNumberRanges_Nr2();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Configuration2Factory getConfiguration2Factory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link runtime.configuration2.impl.SalesOrderImpl <em>Sales Order</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.configuration2.impl.SalesOrderImpl
     * @see runtime.configuration2.impl.Configuration2PackageImpl#getSalesOrder()
     * @generated
     */
    EClass SALES_ORDER = eINSTANCE.getSalesOrder();

    /**
     * The meta object literal for the '<em><b>Number Range</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SALES_ORDER__NUMBER_RANGE = eINSTANCE.getSalesOrder_NumberRange();

    /**
     * The meta object literal for the '{@link runtime.configuration2.impl.NumberRangeImplImpl <em>Number Range Impl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.configuration2.impl.NumberRangeImplImpl
     * @see runtime.configuration2.impl.Configuration2PackageImpl#getNumberRangeImpl()
     * @generated
     */
    EClass NUMBER_RANGE_IMPL = eINSTANCE.getNumberRangeImpl();

    /**
     * The meta object literal for the '{@link runtime.configuration2.impl.PurchaseOrderImpl <em>Purchase Order</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.configuration2.impl.PurchaseOrderImpl
     * @see runtime.configuration2.impl.Configuration2PackageImpl#getPurchaseOrder()
     * @generated
     */
    EClass PURCHASE_ORDER = eINSTANCE.getPurchaseOrder();

    /**
     * The meta object literal for the '<em><b>Number Range</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PURCHASE_ORDER__NUMBER_RANGE = eINSTANCE.getPurchaseOrder_NumberRange();

    /**
     * The meta object literal for the '{@link runtime.configuration2.NumberRange <em>Number Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.configuration2.NumberRange
     * @see runtime.configuration2.impl.Configuration2PackageImpl#getNumberRange()
     * @generated
     */
    EClass NUMBER_RANGE = eINSTANCE.getNumberRange();

    /**
     * The meta object literal for the '{@link runtime.configuration2.impl.PurchaseOrderNumberRangesImpl <em>Purchase Order Number Ranges</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.configuration2.impl.PurchaseOrderNumberRangesImpl
     * @see runtime.configuration2.impl.Configuration2PackageImpl#getPurchaseOrderNumberRanges()
     * @generated
     */
    EClass PURCHASE_ORDER_NUMBER_RANGES = eINSTANCE.getPurchaseOrderNumberRanges();

    /**
     * The meta object literal for the '<em><b>Nr1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PURCHASE_ORDER_NUMBER_RANGES__NR1 = eINSTANCE.getPurchaseOrderNumberRanges_Nr1();

    /**
     * The meta object literal for the '<em><b>Nr2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PURCHASE_ORDER_NUMBER_RANGES__NR2 = eINSTANCE.getPurchaseOrderNumberRanges_Nr2();

    /**
     * The meta object literal for the '{@link runtime.configuration2.impl.SalesOrderNumberRangesImpl <em>Sales Order Number Ranges</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.configuration2.impl.SalesOrderNumberRangesImpl
     * @see runtime.configuration2.impl.Configuration2PackageImpl#getSalesOrderNumberRanges()
     * @generated
     */
    EClass SALES_ORDER_NUMBER_RANGES = eINSTANCE.getSalesOrderNumberRanges();

    /**
     * The meta object literal for the '<em><b>Nr1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SALES_ORDER_NUMBER_RANGES__NR1 = eINSTANCE.getSalesOrderNumberRanges_Nr1();

    /**
     * The meta object literal for the '<em><b>Nr2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SALES_ORDER_NUMBER_RANGES__NR2 = eINSTANCE.getSalesOrderNumberRanges_Nr2();

  }

} //Configuration2Package
