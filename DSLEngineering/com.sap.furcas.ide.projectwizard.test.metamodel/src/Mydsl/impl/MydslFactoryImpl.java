/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Mydsl.impl;

import Mydsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MydslFactoryImpl extends EFactoryImpl implements MydslFactory
{
  /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public static MydslFactory init()
  {
        try {
            MydslFactory theMydslFactory = (MydslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.furcas.org/projectwizard/example/mydsl"); 
            if (theMydslFactory != null) {
                return theMydslFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MydslFactoryImpl();
    }

  /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public MydslFactoryImpl()
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
        switch (eClass.getClassifierID()) {
            case MydslPackage.EXAMPLE_CLASS: return createExampleClass();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ExampleClass createExampleClass()
  {
        ExampleClassImpl exampleClass = new ExampleClassImpl();
        return exampleClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public MydslPackage getMydslPackage()
  {
        return (MydslPackage)getEPackage();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
  @Deprecated
  public static MydslPackage getPackage()
  {
        return MydslPackage.eINSTANCE;
    }

} //MydslFactoryImpl
