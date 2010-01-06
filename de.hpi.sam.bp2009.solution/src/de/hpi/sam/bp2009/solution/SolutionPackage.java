/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hpi.sam.bp2009.solution.SolutionFactory
 * @model kind="package"
 * @generated
 */
public interface SolutionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "solution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SolutionPackage eINSTANCE = de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl <em>Expression Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getExpressionSupplier()
	 * @generated
	 */
	int EXPRESSION_SUPPLIER = 0;

	/**
	 * The feature id for the '<em><b>IA</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER__IA = 0;

	/**
	 * The number of structural features of the '<em>Expression Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SUPPLIER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.EventListener <em>Event Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.EventListener
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getEventListener()
	 * @generated
	 */
	int EVENT_LISTENER = 4;

	/**
	 * The number of structural features of the '<em>Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_LISTENER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impl.ImpactAnalyzerImpl <em>Impact Analyzer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impl.ImpactAnalyzerImpl
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getImpactAnalyzer()
	 * @generated
	 */
	int IMPACT_ANALYZER = 1;

	/**
	 * The feature id for the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__EVENT_MANAGER = EVENT_LISTENER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Evaluator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__OCL_EVALUATOR = EVENT_LISTENER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Impact Analyzer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER_FEATURE_COUNT = EVENT_LISTENER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impl.OclEvaluatorImpl <em>Ocl Evaluator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impl.OclEvaluatorImpl
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getOclEvaluator()
	 * @generated
	 */
	int OCL_EVALUATOR = 2;

	/**
	 * The number of structural features of the '<em>Ocl Evaluator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EVALUATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impl.PersistenzImpl <em>Persistenz</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impl.PersistenzImpl
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getPersistenz()
	 * @generated
	 */
	int PERSISTENZ = 3;

	/**
	 * The feature id for the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENZ__EVENT_MANAGER = 0;

	/**
	 * The number of structural features of the '<em>Persistenz</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSISTENZ_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>Ocl Query</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
	 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getOclQuery()
	 * @generated
	 */
	int OCL_QUERY = 5;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.ExpressionSupplier <em>Expression Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Supplier</em>'.
	 * @see de.hpi.sam.bp2009.solution.ExpressionSupplier
	 * @generated
	 */
	EClass getExpressionSupplier();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.ExpressionSupplier#getIA <em>IA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>IA</em>'.
	 * @see de.hpi.sam.bp2009.solution.ExpressionSupplier#getIA()
	 * @see #getExpressionSupplier()
	 * @generated
	 */
	EReference getExpressionSupplier_IA();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer <em>Impact Analyzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analyzer</em>'.
	 * @see de.hpi.sam.bp2009.solution.ImpactAnalyzer
	 * @generated
	 */
	EClass getImpactAnalyzer();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer#getEventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.solution.ImpactAnalyzer#getEventManager()
	 * @see #getImpactAnalyzer()
	 * @generated
	 */
	EReference getImpactAnalyzer_EventManager();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer#getOclEvaluator <em>Ocl Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Evaluator</em>'.
	 * @see de.hpi.sam.bp2009.solution.ImpactAnalyzer#getOclEvaluator()
	 * @see #getImpactAnalyzer()
	 * @generated
	 */
	EReference getImpactAnalyzer_OclEvaluator();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.OclEvaluator <em>Ocl Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Evaluator</em>'.
	 * @see de.hpi.sam.bp2009.solution.OclEvaluator
	 * @generated
	 */
	EClass getOclEvaluator();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.Persistenz <em>Persistenz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Persistenz</em>'.
	 * @see de.hpi.sam.bp2009.solution.Persistenz
	 * @generated
	 */
	EClass getPersistenz();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.Persistenz#getEventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.solution.Persistenz#getEventManager()
	 * @see #getPersistenz()
	 * @generated
	 */
	EReference getPersistenz_EventManager();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.EventListener <em>Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Listener</em>'.
	 * @see de.hpi.sam.bp2009.solution.EventListener
	 * @generated
	 */
	EClass getEventListener();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition <em>Ocl Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ocl Query</em>'.
	 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
	 * @model instanceClass="org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition"
	 * @generated
	 */
	EDataType getOclQuery();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SolutionFactory getSolutionFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl <em>Expression Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impl.ExpressionSupplierImpl
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getExpressionSupplier()
		 * @generated
		 */
		EClass EXPRESSION_SUPPLIER = eINSTANCE.getExpressionSupplier();

		/**
		 * The meta object literal for the '<em><b>IA</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_SUPPLIER__IA = eINSTANCE.getExpressionSupplier_IA();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impl.ImpactAnalyzerImpl <em>Impact Analyzer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impl.ImpactAnalyzerImpl
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getImpactAnalyzer()
		 * @generated
		 */
		EClass IMPACT_ANALYZER = eINSTANCE.getImpactAnalyzer();

		/**
		 * The meta object literal for the '<em><b>Event Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYZER__EVENT_MANAGER = eINSTANCE.getImpactAnalyzer_EventManager();

		/**
		 * The meta object literal for the '<em><b>Ocl Evaluator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYZER__OCL_EVALUATOR = eINSTANCE.getImpactAnalyzer_OclEvaluator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impl.OclEvaluatorImpl <em>Ocl Evaluator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impl.OclEvaluatorImpl
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getOclEvaluator()
		 * @generated
		 */
		EClass OCL_EVALUATOR = eINSTANCE.getOclEvaluator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impl.PersistenzImpl <em>Persistenz</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impl.PersistenzImpl
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getPersistenz()
		 * @generated
		 */
		EClass PERSISTENZ = eINSTANCE.getPersistenz();

		/**
		 * The meta object literal for the '<em><b>Event Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSISTENZ__EVENT_MANAGER = eINSTANCE.getPersistenz_EventManager();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.EventListener <em>Event Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.EventListener
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getEventListener()
		 * @generated
		 */
		EClass EVENT_LISTENER = eINSTANCE.getEventListener();

		/**
		 * The meta object literal for the '<em>Ocl Query</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
		 * @see de.hpi.sam.bp2009.solution.impl.SolutionPackageImpl#getOclQuery()
		 * @generated
		 */
		EDataType OCL_QUERY = eINSTANCE.getOclQuery();

	}

} //SolutionPackage
