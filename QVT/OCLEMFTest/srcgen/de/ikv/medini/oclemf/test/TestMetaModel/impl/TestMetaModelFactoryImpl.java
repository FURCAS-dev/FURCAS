/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.*;

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
public class TestMetaModelFactoryImpl extends EFactoryImpl implements TestMetaModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestMetaModelFactory init() {
		try {
			TestMetaModelFactory theTestMetaModelFactory = (TestMetaModelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///TestMetaModel.ecore"); 
			if (theTestMetaModelFactory != null) {
				return theTestMetaModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestMetaModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestMetaModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestMetaModelPackage.TOP_LEVEL_DUMMY_CLASS: return createTopLevelDummyClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelDummyClass createTopLevelDummyClass() {
		TopLevelDummyClassImpl topLevelDummyClass = new TopLevelDummyClassImpl();
		return topLevelDummyClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestMetaModelPackage getTestMetaModelPackage() {
		return (TestMetaModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static TestMetaModelPackage getPackage() {
		return TestMetaModelPackage.eINSTANCE;
	}

} //TestMetaModelFactoryImpl
