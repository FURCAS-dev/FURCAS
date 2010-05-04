/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.primitivetypes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import runtime.primitivetypes.Binary;
import runtime.primitivetypes.DateTime;
import runtime.primitivetypes.PrimitivetypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see runtime.primitivetypes.PrimitivetypesPackage
 * @generated
 */
public class PrimitivetypesAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PrimitivetypesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitivetypesAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PrimitivetypesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimitivetypesSwitch<Adapter> modelSwitch =
    new PrimitivetypesSwitch<Adapter>()
    {
      @Override
      public Adapter caseBinary(Binary object)
      {
        return createBinaryAdapter();
      }
      @Override
      public Adapter caseBoolean(runtime.primitivetypes.Boolean object)
      {
        return createBooleanAdapter();
      }
      @Override
      public Adapter caseDateTime(DateTime object)
      {
        return createDateTimeAdapter();
      }
      @Override
      public Adapter caseNumber(runtime.primitivetypes.Number object)
      {
        return createNumberAdapter();
      }
      @Override
      public Adapter caseString(runtime.primitivetypes.String object)
      {
        return createStringAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link runtime.primitivetypes.Binary <em>Binary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.primitivetypes.Binary
   * @generated
   */
  public Adapter createBinaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.primitivetypes.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.primitivetypes.Boolean
   * @generated
   */
  public Adapter createBooleanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.primitivetypes.DateTime <em>Date Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.primitivetypes.DateTime
   * @generated
   */
  public Adapter createDateTimeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.primitivetypes.Number <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.primitivetypes.Number
   * @generated
   */
  public Adapter createNumberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link runtime.primitivetypes.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see runtime.primitivetypes.String
   * @generated
   */
  public Adapter createStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PrimitivetypesAdapterFactory
