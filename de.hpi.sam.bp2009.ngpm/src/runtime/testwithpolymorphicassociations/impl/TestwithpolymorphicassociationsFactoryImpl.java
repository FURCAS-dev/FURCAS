/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithpolymorphicassociations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import runtime.testwithpolymorphicassociations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestwithpolymorphicassociationsFactoryImpl extends EFactoryImpl implements TestwithpolymorphicassociationsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TestwithpolymorphicassociationsFactory init()
  {
    try
    {
      TestwithpolymorphicassociationsFactory theTestwithpolymorphicassociationsFactory = (TestwithpolymorphicassociationsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///runtime/testwithpolymorphicassociations.ecore"); 
      if (theTestwithpolymorphicassociationsFactory != null)
      {
        return theTestwithpolymorphicassociationsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TestwithpolymorphicassociationsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithpolymorphicassociationsFactoryImpl()
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
      case TestwithpolymorphicassociationsPackage.A: return createA();
      case TestwithpolymorphicassociationsPackage.C: return createC();
      case TestwithpolymorphicassociationsPackage.B: return createB();
      case TestwithpolymorphicassociationsPackage.D: return createD();
      case TestwithpolymorphicassociationsPackage.E: return createE();
      case TestwithpolymorphicassociationsPackage.F: return createF();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public A createA()
  {
    AImpl a = new AImpl();
    return a;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public C createC()
  {
    CImpl c = new CImpl();
    return c;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public B createB()
  {
    BImpl b = new BImpl();
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public D createD()
  {
    DImpl d = new DImpl();
    return d;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public E createE()
  {
    EImpl e = new EImpl();
    return e;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public F createF()
  {
    FImpl f = new FImpl();
    return f;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithpolymorphicassociationsPackage getTestwithpolymorphicassociationsPackage()
  {
    return (TestwithpolymorphicassociationsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TestwithpolymorphicassociationsPackage getPackage()
  {
    return TestwithpolymorphicassociationsPackage.eINSTANCE;
  }

} //TestwithpolymorphicassociationsFactoryImpl
