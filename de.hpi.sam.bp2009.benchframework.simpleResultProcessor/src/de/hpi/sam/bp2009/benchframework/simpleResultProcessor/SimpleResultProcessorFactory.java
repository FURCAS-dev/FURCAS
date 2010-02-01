/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.simpleResultProcessor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.simpleResultProcessor.SimpleResultProcessorPackage
 * @generated
 */
public interface SimpleResultProcessorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimpleResultProcessorFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.simpleResultProcessor.impl.SimpleResultProcessorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simple Result Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Result Processor</em>'.
	 * @generated
	 */
	SimpleResultProcessor createSimpleResultProcessor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimpleResultProcessorPackage getSimpleResultProcessorPackage();

} //SimpleResultProcessorFactory
