/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerFactory
 * @model kind="package"
 * @generated
 */
public interface ModifiedOclOptimizerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifiedOclOptimizer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.modifiedOclOptimizer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedOclOptimizerPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerImpl <em>Modified Ocl Optimizer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl#getModifiedOclOptimizer()
	 * @generated
	 */
	int MODIFIED_OCL_OPTIMIZER = 0;

	/**
	 * The number of structural features of the '<em>Modified Ocl Optimizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_OCL_OPTIMIZER_FEATURE_COUNT = OclEvaluatorPackage.OCL_EVALUATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.EmbedModifiedOclOptOperatorImpl <em>Embed Modified Ocl Opt Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.EmbedModifiedOclOptOperatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl#getEmbedModifiedOclOptOperator()
	 * @generated
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Embed Modified Ocl Opt Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_OCL_OPT_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals <em>Notify Literals</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl#getModifiedOclOptimizerNotifyLiterals()
	 * @generated
	 */
	int MODIFIED_OCL_OPTIMIZER_NOTIFY_LITERALS = 2;

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizer <em>Modified Ocl Optimizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Ocl Optimizer</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizer
	 * @generated
	 */
	EClass getModifiedOclOptimizer();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.EmbedModifiedOclOptOperator <em>Embed Modified Ocl Opt Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embed Modified Ocl Opt Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.EmbedModifiedOclOptOperator
	 * @generated
	 */
	EClass getEmbedModifiedOclOptOperator();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals <em>Notify Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Notify Literals</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals
	 * @generated
	 */
	EEnum getModifiedOclOptimizerNotifyLiterals();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifiedOclOptimizerFactory getModifiedOclOptimizerFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerImpl <em>Modified Ocl Optimizer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl#getModifiedOclOptimizer()
		 * @generated
		 */
		EClass MODIFIED_OCL_OPTIMIZER = eINSTANCE.getModifiedOclOptimizer();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.EmbedModifiedOclOptOperatorImpl <em>Embed Modified Ocl Opt Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.EmbedModifiedOclOptOperatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl#getEmbedModifiedOclOptOperator()
		 * @generated
		 */
		EClass EMBED_MODIFIED_OCL_OPT_OPERATOR = eINSTANCE.getEmbedModifiedOclOptOperator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals <em>Notify Literals</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals
		 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerPackageImpl#getModifiedOclOptimizerNotifyLiterals()
		 * @generated
		 */
		EEnum MODIFIED_OCL_OPTIMIZER_NOTIFY_LITERALS = eINSTANCE.getModifiedOclOptimizerNotifyLiterals();

	}

} //ModifiedOclOptimizerPackage
