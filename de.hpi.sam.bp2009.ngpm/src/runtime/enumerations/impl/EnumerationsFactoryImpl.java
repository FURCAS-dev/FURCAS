/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.enumerations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtime.enumerations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumerationsFactoryImpl extends EFactoryImpl implements EnumerationsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EnumerationsFactory init()
  {
    try
    {
      EnumerationsFactory theEnumerationsFactory = (EnumerationsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///runtime/enumerations.ecore"); 
      if (theEnumerationsFactory != null)
      {
        return theEnumerationsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EnumerationsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationsFactoryImpl()
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
      case EnumerationsPackage.ENUMERATION: return createEnumeration();
      case EnumerationsPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enumeration createEnumeration()
  {
    EnumerationImpl enumeration = new EnumerationImpl();
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationLiteral createEnumerationLiteral()
  {
    EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
    return enumerationLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationsPackage getEnumerationsPackage()
  {
    return (EnumerationsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EnumerationsPackage getPackage()
  {
    return EnumerationsPackage.eINSTANCE;
  }

} //EnumerationsFactoryImpl
