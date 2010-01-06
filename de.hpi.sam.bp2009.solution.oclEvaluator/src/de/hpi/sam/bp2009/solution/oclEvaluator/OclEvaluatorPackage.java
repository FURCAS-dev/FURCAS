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
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl <em>Ocl Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOclQuery()
	 * @generated
	 */
	int OCL_QUERY = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Ocl Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Ocl Condition</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOclCondition()
	 * @generated
	 */
	int OCL_CONDITION = 2;

	/**
	 * The meta object id for the '<em>EObject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EObject
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getEObject()
	 * @generated
	 */
	int EOBJECT = 3;


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
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext()
	 * @see #getOclQuery()
	 * @generated
	 */
	EAttribute getOclQuery_Context();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getCondition()
	 * @see #getOclQuery()
	 * @generated
	 */
	EAttribute getOclQuery_Condition();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition <em>Ocl Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ocl Condition</em>'.
	 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
	 * @model instanceClass="org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition"
	 * @generated
	 */
	EDataType getOclCondition();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EObject <em>EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EObject</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @model instanceClass="org.eclipse.emf.ecore.EObject"
	 * @generated
	 */
	EDataType getEObject();

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
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY__CONTEXT = eINSTANCE.getOclQuery_Context();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY__CONDITION = eINSTANCE.getOclQuery_Condition();

		/**
		 * The meta object literal for the '<em>Ocl Condition</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getOclCondition()
		 * @generated
		 */
		EDataType OCL_CONDITION = eINSTANCE.getOclCondition();

		/**
		 * The meta object literal for the '<em>EObject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.EObject
		 * @see de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorPackageImpl#getEObject()
		 * @generated
		 */
		EDataType EOBJECT = eINSTANCE.getEObject();

	}

} //OclEvaluatorPackage
