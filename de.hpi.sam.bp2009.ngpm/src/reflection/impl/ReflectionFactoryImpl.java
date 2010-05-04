/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reflection.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import reflection.ReflectionFactory;
import reflection.ReflectionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReflectionFactoryImpl extends EFactoryImpl implements ReflectionFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReflectionFactory init()
  {
    try
    {
      ReflectionFactory theReflectionFactory = (ReflectionFactory)EPackage.Registry.INSTANCE.getEFactory("http:///reflection.ecore"); 
      if (theReflectionFactory != null)
      {
        return theReflectionFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReflectionFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReflectionFactoryImpl()
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
      case ReflectionPackage.OBJECT: return createObject();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public reflection.Object createObject()
  {
    ObjectImpl object = new ObjectImpl();
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReflectionPackage getReflectionPackage()
  {
    return (ReflectionPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReflectionPackage getPackage()
  {
    return ReflectionPackage.eINSTANCE;
  }

} //ReflectionFactoryImpl
