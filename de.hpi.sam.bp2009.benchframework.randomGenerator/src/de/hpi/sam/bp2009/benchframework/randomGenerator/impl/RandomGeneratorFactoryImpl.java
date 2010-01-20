/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import de.hpi.sam.bp2009.benchframework.randomGenerator.*;

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
public class RandomGeneratorFactoryImpl extends EFactoryImpl implements RandomGeneratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RandomGeneratorFactory init() {
		try {
			RandomGeneratorFactory theRandomGeneratorFactory = (RandomGeneratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.randomGenerator"); 
			if (theRandomGeneratorFactory != null) {
				return theRandomGeneratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RandomGeneratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGeneratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RandomGeneratorPackage.RANDOM_GENERATOR: return createRandomGenerator();
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT: return createRandomGeneratorOptionObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGenerator createRandomGenerator() {
		RandomGeneratorImpl randomGenerator = new RandomGeneratorImpl();
		return randomGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGeneratorOptionObject createRandomGeneratorOptionObject() {
		RandomGeneratorOptionObjectImpl randomGeneratorOptionObject = new RandomGeneratorOptionObjectImpl();
		return randomGeneratorOptionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGeneratorPackage getRandomGeneratorPackage() {
		return (RandomGeneratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RandomGeneratorPackage getPackage() {
		return RandomGeneratorPackage.eINSTANCE;
	}

} //RandomGeneratorFactoryImpl
