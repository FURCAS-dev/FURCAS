/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage
 * @generated
 */
public interface RelationshipTestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationshipTestsFactory eINSTANCE = de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.RelationshipTestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Test</em>'.
	 * @generated
	 */
	ClassTest createClassTest();

	/**
	 * Returns a new object of class '<em>Navigable Association Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigable Association Test</em>'.
	 * @generated
	 */
	NavigableAssociationTest createNavigableAssociationTest();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RelationshipTestsPackage getRelationshipTestsPackage();

} //RelationshipTestsFactory
