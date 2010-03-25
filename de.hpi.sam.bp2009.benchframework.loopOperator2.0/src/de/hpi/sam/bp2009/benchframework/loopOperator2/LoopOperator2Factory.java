/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package
 * @generated
 */
public interface LoopOperator2Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoopOperator2Factory eINSTANCE = de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Start Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Loop</em>'.
	 * @generated
	 */
	StartLoop createStartLoop();

	/**
	 * Returns a new object of class '<em>End Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Loop</em>'.
	 * @generated
	 */
	EndLoop createEndLoop();

	/**
	 * Returns a new object of class '<em>Loop Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Option</em>'.
	 * @generated
	 */
	LoopOption createLoopOption();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LoopOperator2Package getLoopOperator2Package();

} //LoopOperator2Factory
