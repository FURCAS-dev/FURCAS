/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.processcomponents.util;

import modelmanagement.NamedElement;
import modelmanagement.PackageOwner;

import modelmanagement.processcomponents.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see modelmanagement.processcomponents.ProcesscomponentsPackage
 * @generated
 */
public class ProcesscomponentsAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ProcesscomponentsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcesscomponentsAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ProcesscomponentsPackage.eINSTANCE;
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
  protected ProcesscomponentsSwitch<Adapter> modelSwitch =
    new ProcesscomponentsSwitch<Adapter>()
    {
      @Override
      public Adapter caseProcessComponent(ProcessComponent object)
      {
        return createProcessComponentAdapter();
      }
      @Override
      public Adapter caseProcessComponentInsideCompany(ProcessComponentInsideCompany object)
      {
        return createProcessComponentInsideCompanyAdapter();
      }
      @Override
      public Adapter caseProcessComponentOutsideCompany(ProcessComponentOutsideCompany object)
      {
        return createProcessComponentOutsideCompanyAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter casePackageOwner(PackageOwner object)
      {
        return createPackageOwnerAdapter();
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
   * Creates a new adapter for an object of class '{@link modelmanagement.processcomponents.ProcessComponent <em>Process Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelmanagement.processcomponents.ProcessComponent
   * @generated
   */
  public Adapter createProcessComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelmanagement.processcomponents.ProcessComponentInsideCompany <em>Process Component Inside Company</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelmanagement.processcomponents.ProcessComponentInsideCompany
   * @generated
   */
  public Adapter createProcessComponentInsideCompanyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelmanagement.processcomponents.ProcessComponentOutsideCompany <em>Process Component Outside Company</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelmanagement.processcomponents.ProcessComponentOutsideCompany
   * @generated
   */
  public Adapter createProcessComponentOutsideCompanyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelmanagement.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelmanagement.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelmanagement.PackageOwner <em>Package Owner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelmanagement.PackageOwner
   * @generated
   */
  public Adapter createPackageOwnerAdapter()
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

} //ProcesscomponentsAdapterFactory
