/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorFactory
 * @model kind="package"
 * @generated
 */
public interface QueryEvaluatorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "queryEvaluator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.queryEvaluator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.queryEvaluator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueryEvaluatorPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.EmbedQEOperatorImpl <em>Embed QE Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.EmbedQEOperatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getEmbedQEOperator()
	 * @generated
	 */
	int EMBED_QE_OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_QE_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_QE_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_QE_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_QE_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_QE_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Embed QE Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_QE_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorImpl <em>Query Evaluator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getQueryEvaluator()
	 * @generated
	 */
	int QUERY_EVALUATOR = 1;

	/**
	 * The number of structural features of the '<em>Query Evaluator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EVALUATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals <em>Notify Literals</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getQueryEvaluatorNotifyLiterals()
	 * @generated
	 */
	int QUERY_EVALUATOR_NOTIFY_LITERALS = 2;

	/**
	 * The meta object id for the '<em>Query</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.ecore.OCL.Query
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 3;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.EmbedQEOperator <em>Embed QE Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embed QE Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.EmbedQEOperator
	 * @generated
	 */
	EClass getEmbedQEOperator();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator <em>Query Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Evaluator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator
	 * @generated
	 */
	EClass getQueryEvaluator();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals <em>Notify Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Notify Literals</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals
	 * @generated
	 */
	EEnum getQueryEvaluatorNotifyLiterals();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.ecore.OCL.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Query</em>'.
	 * @see org.eclipse.ocl.ecore.OCL.Query
	 * @model instanceClass="org.eclipse.ocl.ecore.OCL.Query"
	 * @generated
	 */
	EDataType getQuery();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QueryEvaluatorFactory getQueryEvaluatorFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.EmbedQEOperatorImpl <em>Embed QE Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.EmbedQEOperatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getEmbedQEOperator()
		 * @generated
		 */
		EClass EMBED_QE_OPERATOR = eINSTANCE.getEmbedQEOperator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorImpl <em>Query Evaluator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getQueryEvaluator()
		 * @generated
		 */
		EClass QUERY_EVALUATOR = eINSTANCE.getQueryEvaluator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals <em>Notify Literals</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getQueryEvaluatorNotifyLiterals()
		 * @generated
		 */
		EEnum QUERY_EVALUATOR_NOTIFY_LITERALS = eINSTANCE.getQueryEvaluatorNotifyLiterals();

		/**
		 * The meta object literal for the '<em>Query</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.ecore.OCL.Query
		 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorPackageImpl#getQuery()
		 * @generated
		 */
		EDataType QUERY = eINSTANCE.getQuery();

	}

} //QueryEvaluatorPackage
