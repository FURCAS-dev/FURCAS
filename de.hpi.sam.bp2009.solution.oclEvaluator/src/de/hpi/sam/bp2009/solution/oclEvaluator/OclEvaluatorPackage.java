/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator;

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
 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorFactory
 * @model kind="package"
 * @generated
 */
public interface OclEvaluatorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclEvaluator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.oclEvaluator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.oclEvaluator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclEvaluatorPackage eINSTANCE = de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OCLEvaluatorImpl <em>OCL Evaluator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OCLEvaluatorImpl
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOCLEvaluator()
	 * @generated
	 */
	int OCL_EVALUATOR = 0;

	/**
	 * The number of structural features of the '<em>OCL Evaluator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EVALUATOR_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator <em>OCL Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Evaluator</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator
	 * @generated
	 */
	EClass getOCLEvaluator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OclEvaluatorFactory getOclEvaluatorFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OCLEvaluatorImpl <em>OCL Evaluator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OCLEvaluatorImpl
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOCLEvaluator()
		 * @generated
		 */
		EClass OCL_EVALUATOR = eINSTANCE.getOCLEvaluator();

	}

} //OclEvaluatorPackage
