/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

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
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorFactory
 * @model kind="package"
 * @generated
 */
public interface OclOperatorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclOperator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.oclOperator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.oclOperator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclOperatorPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl <em>Ocl Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclOperator()
	 * @generated
	 */
	int OCL_OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Ocl Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOptionObjectImpl <em>Ocl Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOptionObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclOptionObject()
	 * @generated
	 */
	int OCL_OPTION_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPTION_OBJECT__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPTION_OBJECT__CONSTRAINTS = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Impact Analyzer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ocl Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclUtilImpl <em>Ocl Util</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclUtilImpl
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclUtil()
	 * @generated
	 */
	int OCL_UTIL = 2;

	/**
	 * The number of structural features of the '<em>Ocl Util</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_UTIL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclResultImpl <em>Ocl Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclResultImpl
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclResult()
	 * @generated
	 */
	int OCL_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_RESULT__STATUS = BenchframeworkPackage.RESULT_OBJECT__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_RESULT__MESSAGE = BenchframeworkPackage.RESULT_OBJECT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Queries To Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_RESULT__QUERIES_TO_RESULTS = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ocl Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_RESULT_FEATURE_COUNT = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOperator <em>Ocl Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOperator
	 * @generated
	 */
	EClass getOclOperator();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject <em>Ocl Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject
	 * @generated
	 */
	EClass getOclOptionObject();

	/**
	 * Returns the meta object for the attribute list '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Constraints</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#getConstraints()
	 * @see #getOclOptionObject()
	 * @generated
	 */
	EAttribute getOclOptionObject_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#isUseImpactAnalyzer <em>Use Impact Analyzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Impact Analyzer</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#isUseImpactAnalyzer()
	 * @see #getOclOptionObject()
	 * @generated
	 */
	EAttribute getOclOptionObject_UseImpactAnalyzer();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil <em>Ocl Util</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Util</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil
	 * @generated
	 */
	EClass getOclUtil();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclResult <em>Ocl Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Result</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclResult
	 * @generated
	 */
	EClass getOclResult();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclResult#getQueriesToResults <em>Queries To Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queries To Results</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclResult#getQueriesToResults()
	 * @see #getOclResult()
	 * @generated
	 */
	EAttribute getOclResult_QueriesToResults();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OclOperatorFactory getOclOperatorFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl <em>Ocl Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclOperator()
		 * @generated
		 */
		EClass OCL_OPERATOR = eINSTANCE.getOclOperator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOptionObjectImpl <em>Ocl Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOptionObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclOptionObject()
		 * @generated
		 */
		EClass OCL_OPTION_OBJECT = eINSTANCE.getOclOptionObject();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_OPTION_OBJECT__CONSTRAINTS = eINSTANCE.getOclOptionObject_Constraints();

		/**
		 * The meta object literal for the '<em><b>Use Impact Analyzer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER = eINSTANCE.getOclOptionObject_UseImpactAnalyzer();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclUtilImpl <em>Ocl Util</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclUtilImpl
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclUtil()
		 * @generated
		 */
		EClass OCL_UTIL = eINSTANCE.getOclUtil();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclResultImpl <em>Ocl Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclResultImpl
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclResult()
		 * @generated
		 */
		EClass OCL_RESULT = eINSTANCE.getOclResult();

		/**
		 * The meta object literal for the '<em><b>Queries To Results</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_RESULT__QUERIES_TO_RESULTS = eINSTANCE.getOclResult_QueriesToResults();

	}

} //OclOperatorPackage
