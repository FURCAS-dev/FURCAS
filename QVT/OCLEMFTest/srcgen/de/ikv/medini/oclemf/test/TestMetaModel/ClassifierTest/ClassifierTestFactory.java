/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage
 * @generated
 */
public interface ClassifierTestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassifierTestFactory eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.ClassifierTestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Abstract Super Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Super Class</em>'.
	 * @generated
	 */
	AbstractSuperClass createAbstractSuperClass();

	/**
	 * Returns a new object of class '<em>Sub Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Class</em>'.
	 * @generated
	 */
	SubClass createSubClass();

	/**
	 * Returns a new object of class '<em>Super Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Class</em>'.
	 * @generated
	 */
	SuperClass createSuperClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassifierTestPackage getClassifierTestPackage();

} //ClassifierTestFactory
