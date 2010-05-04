/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.configuration2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtime.configuration2.Configuration2Factory;
import runtime.configuration2.Configuration2Package;
import runtime.configuration2.NumberRangeImpl;
import runtime.configuration2.PurchaseOrder;
import runtime.configuration2.PurchaseOrderNumberRanges;
import runtime.configuration2.SalesOrder;
import runtime.configuration2.SalesOrderNumberRanges;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Configuration2FactoryImpl extends EFactoryImpl implements Configuration2Factory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Configuration2Factory init()
  {
    try
    {
      Configuration2Factory theConfiguration2Factory = (Configuration2Factory)EPackage.Registry.INSTANCE.getEFactory("http:///runtime/configuration2.ecore"); 
      if (theConfiguration2Factory != null)
      {
        return theConfiguration2Factory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Configuration2FactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Configuration2FactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case Configuration2Package.SALES_ORDER: return createSalesOrder();
      case Configuration2Package.NUMBER_RANGE_IMPL: return createNumberRangeImpl();
      case Configuration2Package.PURCHASE_ORDER: return createPurchaseOrder();
      case Configuration2Package.PURCHASE_ORDER_NUMBER_RANGES: return createPurchaseOrderNumberRanges();
      case Configuration2Package.SALES_ORDER_NUMBER_RANGES: return createSalesOrderNumberRanges();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SalesOrder createSalesOrder()
  {
    SalesOrderImpl salesOrder = new SalesOrderImpl();
    return salesOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberRangeImpl createNumberRangeImpl()
  {
    NumberRangeImplImpl numberRangeImpl = new NumberRangeImplImpl();
    return numberRangeImpl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PurchaseOrder createPurchaseOrder()
  {
    PurchaseOrderImpl purchaseOrder = new PurchaseOrderImpl();
    return purchaseOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PurchaseOrderNumberRanges createPurchaseOrderNumberRanges()
  {
    PurchaseOrderNumberRangesImpl purchaseOrderNumberRanges = new PurchaseOrderNumberRangesImpl();
    return purchaseOrderNumberRanges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SalesOrderNumberRanges createSalesOrderNumberRanges()
  {
    SalesOrderNumberRangesImpl salesOrderNumberRanges = new SalesOrderNumberRangesImpl();
    return salesOrderNumberRanges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Configuration2Package getConfiguration2Package()
  {
    return (Configuration2Package)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Configuration2Package getPackage()
  {
    return Configuration2Package.eINSTANCE;
  }

} //Configuration2FactoryImpl
