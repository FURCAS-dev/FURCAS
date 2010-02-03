/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage
 * @generated
 */
public interface RandomModelModifierFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RandomModelModifierFactory eINSTANCE = de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Random Model Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Model Modifier</em>'.
	 * @generated
	 */
	RandomModelModifier createRandomModelModifier();

	/**
	 * Returns a new object of class '<em>Option Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option Object</em>'.
	 * @generated
	 */
	RandomModelModifierOptionObject createRandomModelModifierOptionObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RandomModelModifierPackage getRandomModelModifierPackage();

} //RandomModelModifierFactory
