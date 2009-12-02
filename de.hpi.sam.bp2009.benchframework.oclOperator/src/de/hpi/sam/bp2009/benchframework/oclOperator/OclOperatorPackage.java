/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	String eNS_PREFIX = "oclOperator";

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
	 * The feature id for the '<em><b>Default Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATOR__DEFAULT_OPTION = BenchframeworkPackage.OPERATOR__DEFAULT_OPTION;

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
	 * The number of structural features of the '<em>Ocl Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '<em>IQuery Result</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query.statements.IQueryResult
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getIQueryResult()
	 * @generated
	 */
	int IQUERY_RESULT = 3;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator <em>Ocl Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator
	 * @generated
	 */
	EClass getOclOperator();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject <em>Ocl Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject
	 * @generated
	 */
	EClass getOclOptionObject();

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
	 * Returns the meta object for data type '{@link org.eclipse.emf.query.statements.IQueryResult <em>IQuery Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IQuery Result</em>'.
	 * @see org.eclipse.emf.query.statements.IQueryResult
	 * @model instanceClass="org.eclipse.emf.query.statements.IQueryResult"
	 * @generated
	 */
	EDataType getIQueryResult();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclUtilImpl <em>Ocl Util</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclUtilImpl
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getOclUtil()
		 * @generated
		 */
		EClass OCL_UTIL = eINSTANCE.getOclUtil();

		/**
		 * The meta object literal for the '<em>IQuery Result</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query.statements.IQueryResult
		 * @see de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorPackageImpl#getIQueryResult()
		 * @generated
		 */
		EDataType IQUERY_RESULT = eINSTANCE.getIQueryResult();

	}

} //OclOperatorPackage
