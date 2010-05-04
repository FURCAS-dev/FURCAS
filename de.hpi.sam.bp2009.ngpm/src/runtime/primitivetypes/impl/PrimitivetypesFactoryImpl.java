/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.primitivetypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtime.primitivetypes.Binary;
import runtime.primitivetypes.DateTime;
import runtime.primitivetypes.PrimitivetypesFactory;
import runtime.primitivetypes.PrimitivetypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitivetypesFactoryImpl extends EFactoryImpl implements PrimitivetypesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PrimitivetypesFactory init()
  {
    try
    {
      PrimitivetypesFactory thePrimitivetypesFactory = (PrimitivetypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///runtime/primitivetypes.ecore"); 
      if (thePrimitivetypesFactory != null)
      {
        return thePrimitivetypesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PrimitivetypesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitivetypesFactoryImpl()
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
      case PrimitivetypesPackage.BINARY: return createBinary();
      case PrimitivetypesPackage.BOOLEAN: return createBoolean();
      case PrimitivetypesPackage.DATE_TIME: return createDateTime();
      case PrimitivetypesPackage.NUMBER: return createNumber();
      case PrimitivetypesPackage.STRING: return createString();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Binary createBinary()
  {
    BinaryImpl binary = new BinaryImpl();
    return binary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Boolean createBoolean()
  {
    BooleanImpl boolean_ = new BooleanImpl();
    return boolean_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DateTime createDateTime()
  {
    DateTimeImpl dateTime = new DateTimeImpl();
    return dateTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.Number createNumber()
  {
    NumberImpl number = new NumberImpl();
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String createString()
  {
    StringImpl string = new StringImpl();
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitivetypesPackage getPrimitivetypesPackage()
  {
    return (PrimitivetypesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PrimitivetypesPackage getPackage()
  {
    return PrimitivetypesPackage.eINSTANCE;
  }

} //PrimitivetypesFactoryImpl
