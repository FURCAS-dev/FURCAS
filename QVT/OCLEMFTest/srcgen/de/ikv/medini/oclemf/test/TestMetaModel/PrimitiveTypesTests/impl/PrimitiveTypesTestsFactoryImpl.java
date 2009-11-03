/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.*;

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
public class PrimitiveTypesTestsFactoryImpl extends EFactoryImpl implements PrimitiveTypesTestsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveTypesTestsFactory init() {
		try {
			PrimitiveTypesTestsFactory thePrimitiveTypesTestsFactory = (PrimitiveTypesTestsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///TestMetaModel/PrimitiveTypesTests.ecore"); 
			if (thePrimitiveTypesTestsFactory != null) {
				return thePrimitiveTypesTestsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PrimitiveTypesTestsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesTestsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PrimitiveTypesTestsPackage.BOOLEAN_TEST: return createBooleanTest();
			case PrimitiveTypesTestsPackage.DOUBLE_TEST: return createDoubleTest();
			case PrimitiveTypesTestsPackage.FLOAT_TEST: return createFloatTest();
			case PrimitiveTypesTestsPackage.INTEGER_TEST: return createIntegerTest();
			case PrimitiveTypesTestsPackage.LONG_TEST: return createLongTest();
			case PrimitiveTypesTestsPackage.STRING_TEST: return createStringTest();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanTest createBooleanTest() {
		BooleanTestImpl booleanTest = new BooleanTestImpl();
		return booleanTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleTest createDoubleTest() {
		DoubleTestImpl doubleTest = new DoubleTestImpl();
		return doubleTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatTest createFloatTest() {
		FloatTestImpl floatTest = new FloatTestImpl();
		return floatTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerTest createIntegerTest() {
		IntegerTestImpl integerTest = new IntegerTestImpl();
		return integerTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongTest createLongTest() {
		LongTestImpl longTest = new LongTestImpl();
		return longTest;
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
	public PrimitiveTypesTestsPackage getPrimitiveTypesTestsPackage() {
		return (PrimitiveTypesTestsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static PrimitiveTypesTestsPackage getPackage() {
		return PrimitiveTypesTestsPackage.eINSTANCE;
	}

} //PrimitiveTypesTestsFactoryImpl
