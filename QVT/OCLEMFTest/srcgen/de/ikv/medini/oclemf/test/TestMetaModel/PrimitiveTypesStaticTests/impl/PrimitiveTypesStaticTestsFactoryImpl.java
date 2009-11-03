/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.*;

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
public class PrimitiveTypesStaticTestsFactoryImpl extends EFactoryImpl implements PrimitiveTypesStaticTestsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveTypesStaticTestsFactory init() {
		try {
			PrimitiveTypesStaticTestsFactory thePrimitiveTypesStaticTestsFactory = (PrimitiveTypesStaticTestsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///TestMetaModel/PrimitiveTypesStaticTests.ecore"); 
			if (thePrimitiveTypesStaticTestsFactory != null) {
				return thePrimitiveTypesStaticTestsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PrimitiveTypesStaticTestsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesStaticTestsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PrimitiveTypesStaticTestsPackage.STATIC_BOOLEAN_TEST: return createStaticBooleanTest();
			case PrimitiveTypesStaticTestsPackage.STATIC_DOUBLE_TEST: return createStaticDoubleTest();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST: return createStaticFloatTest();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST: return createStaticIntegerTest();
			case PrimitiveTypesStaticTestsPackage.STATIC_LONG_TEST: return createStaticLongTest();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST: return createStringTest();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticBooleanTest createStaticBooleanTest() {
		StaticBooleanTestImpl staticBooleanTest = new StaticBooleanTestImpl();
		return staticBooleanTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticDoubleTest createStaticDoubleTest() {
		StaticDoubleTestImpl staticDoubleTest = new StaticDoubleTestImpl();
		return staticDoubleTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticFloatTest createStaticFloatTest() {
		StaticFloatTestImpl staticFloatTest = new StaticFloatTestImpl();
		return staticFloatTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticIntegerTest createStaticIntegerTest() {
		StaticIntegerTestImpl staticIntegerTest = new StaticIntegerTestImpl();
		return staticIntegerTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticLongTest createStaticLongTest() {
		StaticLongTestImpl staticLongTest = new StaticLongTestImpl();
		return staticLongTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTest createStringTest() {
		StringTestImpl stringTest = new StringTestImpl();
		return stringTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesStaticTestsPackage getPrimitiveTypesStaticTestsPackage() {
		return (PrimitiveTypesStaticTestsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static PrimitiveTypesStaticTestsPackage getPackage() {
		return PrimitiveTypesStaticTestsPackage.eINSTANCE;
	}

} //PrimitiveTypesStaticTestsFactoryImpl
