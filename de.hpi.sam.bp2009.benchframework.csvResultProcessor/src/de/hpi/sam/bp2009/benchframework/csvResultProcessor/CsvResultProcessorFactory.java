/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessorPackage
 * @generated
 */
public interface CsvResultProcessorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CsvResultProcessorFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Csv Result Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Csv Result Processor</em>'.
	 * @generated
	 */
	CsvResultProcessor createCsvResultProcessor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CsvResultProcessorPackage getCsvResultProcessorPackage();

} //CsvResultProcessorFactory
