/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage
 * @generated
 */
public interface DataTypeTestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataTypeTestsFactory eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.DataTypeTestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Enumeration Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Test</em>'.
	 * @generated
	 */
	EnumerationTest createEnumerationTest();

	/**
	 * Returns a new object of class '<em>Structure Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Test</em>'.
	 * @generated
	 */
	StructureTest createStructureTest();

	/**
	 * Returns a new object of class '<em>Structure Test Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Test Type</em>'.
	 * @generated
	 */
	StructureTestType createStructureTestType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataTypeTestsPackage getDataTypeTestsPackage();

} //DataTypeTestsFactory
