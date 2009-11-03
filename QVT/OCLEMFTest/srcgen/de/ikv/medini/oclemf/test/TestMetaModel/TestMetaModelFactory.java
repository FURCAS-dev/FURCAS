/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.TestMetaModelPackage
 * @generated
 */
public interface TestMetaModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestMetaModelFactory eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.impl.TestMetaModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Top Level Dummy Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level Dummy Class</em>'.
	 * @generated
	 */
	TopLevelDummyClass createTopLevelDummyClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestMetaModelPackage getTestMetaModelPackage();

} //TestMetaModelFactory
