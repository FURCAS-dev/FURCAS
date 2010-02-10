/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl <em>Ocl Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOclQuery()
	 * @generated
	 */
	int OCL_QUERY = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__RESULT = 1;

	/**
	 * The feature id for the '<em><b>Extent Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__EXTENT_MAP = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__EXPRESSION = 3;

	/**
	 * The number of structural features of the '<em>Ocl Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter <em>Interpreter</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getInterpreter()
	 * @generated
	 */
	int INTERPRETER = 2;

	/**
	 * The meta object id for the '<em>expression</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.expressions.OCLExpression
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getexpression()
	 * @generated
	 */
	int EXPRESSION = 3;

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery <em>Ocl Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Query</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery
	 * @generated
	 */
	EClass getOclQuery();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext()
	 * @see #getOclQuery()
	 * @generated
	 */
	EReference getOclQuery_Context();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExpression()
	 * @see #getOclQuery()
	 * @generated
	 */
	EAttribute getOclQuery_Expression();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getResult()
	 * @see #getOclQuery()
	 * @generated
	 */
	EAttribute getOclQuery_Result();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExtentMap <em>Extent Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent Map</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExtentMap()
	 * @see #getOclQuery()
	 * @generated
	 */
	EAttribute getOclQuery_ExtentMap();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter <em>Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interpreter</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter
	 * @generated
	 */
	EEnum getInterpreter();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.expressions.OCLExpression <em>expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>expression</em>'.
	 * @see org.eclipse.ocl.expressions.OCLExpression
	 * @model instanceClass="org.eclipse.ocl.expressions.OCLExpression"
	 * @generated
	 */
	EDataType getexpression();

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

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl <em>Ocl Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOclQuery()
		 * @generated
		 */
		EClass OCL_QUERY = eINSTANCE.getOclQuery();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_QUERY__CONTEXT = eINSTANCE.getOclQuery_Context();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY__EXPRESSION = eINSTANCE.getOclQuery_Expression();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY__RESULT = eINSTANCE.getOclQuery_Result();

		/**
		 * The meta object literal for the '<em><b>Extent Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY__EXTENT_MAP = eINSTANCE.getOclQuery_ExtentMap();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter <em>Interpreter</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getInterpreter()
		 * @generated
		 */
		EEnum INTERPRETER = eINSTANCE.getInterpreter();

		/**
		 * The meta object literal for the '<em>expression</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.expressions.OCLExpression
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getexpression()
		 * @generated
		 */
		EDataType EXPRESSION = eINSTANCE.getexpression();

	}

} //OclEvaluatorPackage
