/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class DataTypeTestsFactoryImpl extends EFactoryImpl implements DataTypeTestsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataTypeTestsFactory init() {
		try {
			DataTypeTestsFactory theDataTypeTestsFactory = (DataTypeTestsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///TestMetaModel/DataTypeTests.ecore"); 
			if (theDataTypeTestsFactory != null) {
				return theDataTypeTestsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataTypeTestsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeTestsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DataTypeTestsPackage.ENUMERATION_TEST: return createEnumerationTest();
			case DataTypeTestsPackage.STRUCTURE_TEST: return createStructureTest();
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE: return createStructureTestType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DataTypeTestsPackage.ENUMERATION_TEST_TYPE:
				return createEnumerationTestTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DataTypeTestsPackage.ENUMERATION_TEST_TYPE:
				return convertEnumerationTestTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationTest createEnumerationTest() {
		EnumerationTestImpl enumerationTest = new EnumerationTestImpl();
		return enumerationTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTest createStructureTest() {
		StructureTestImpl structureTest = new StructureTestImpl();
		return structureTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTestType createStructureTestType() {
		StructureTestTypeImpl structureTestType = new StructureTestTypeImpl();
		return structureTestType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationTestType createEnumerationTestTypeFromString(EDataType eDataType, String initialValue) {
		EnumerationTestType result = EnumerationTestType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumerationTestTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeTestsPackage getDataTypeTestsPackage() {
		return (DataTypeTestsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static DataTypeTestsPackage getPackage() {
		return DataTypeTestsPackage.eINSTANCE;
	}

} //DataTypeTestsFactoryImpl
