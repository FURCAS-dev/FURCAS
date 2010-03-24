/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessorFactory
 * @model kind="package"
 * @generated
 */
public interface CsvResultProcessorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "csvResultProcessor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.csvResultProcessor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.csvResultProcessor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CsvResultProcessorPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl <em>Csv Result Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorPackageImpl#getCsvResultProcessor()
	 * @generated
	 */
	int CSV_RESULT_PROCESSOR = 0;

	/**
	 * The feature id for the '<em><b>Result Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_RESULT_PROCESSOR__RESULT_PAGE = BenchframeworkPackage.RESULT_PROCESSOR__RESULT_PAGE;

	/**
	 * The feature id for the '<em><b>Testrun</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_RESULT_PROCESSOR__TESTRUN = BenchframeworkPackage.RESULT_PROCESSOR__TESTRUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_RESULT_PROCESSOR__NAME = BenchframeworkPackage.RESULT_PROCESSOR__NAME;

	/**
	 * The number of structural features of the '<em>Csv Result Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_RESULT_PROCESSOR_FEATURE_COUNT = BenchframeworkPackage.RESULT_PROCESSOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessor <em>Csv Result Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Csv Result Processor</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessor
	 * @generated
	 */
	EClass getCsvResultProcessor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CsvResultProcessorFactory getCsvResultProcessorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl <em>Csv Result Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl
		 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorPackageImpl#getCsvResultProcessor()
		 * @generated
		 */
		EClass CSV_RESULT_PROCESSOR = eINSTANCE.getCsvResultProcessor();

	}

} //CsvResultProcessorPackage
