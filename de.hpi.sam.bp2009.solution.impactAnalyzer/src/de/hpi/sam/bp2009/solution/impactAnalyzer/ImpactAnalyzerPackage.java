/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import de.hpi.sam.bp2009.solution.eventListener.EventListenerPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory
 * @model kind="package"
 * @generated
 */
public interface ImpactAnalyzerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "impactAnalyzer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.impactAnalyzer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.impactAnalyzer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactAnalyzerPackage eINSTANCE = de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl <em>Impact Analyzer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getImpactAnalyzer()
	 * @generated
	 */
	int IMPACT_ANALYZER = 0;

	/**
	 * The feature id for the '<em><b>Ocl Evaluator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__OCL_EVALUATOR = EventListenerPackage.EVENT_LISTENER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__EVENT_MANAGER = EventListenerPackage.EVENT_LISTENER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__CURRENT_QUERIES = EventListenerPackage.EVENT_LISTENER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Impact Analyzer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER_FEATURE_COUNT = EventListenerPackage.EVENT_LISTENER_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer <em>Impact Analyzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analyzer</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer
	 * @generated
	 */
	EClass getImpactAnalyzer();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getOclEvaluator <em>Ocl Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Evaluator</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getOclEvaluator()
	 * @see #getImpactAnalyzer()
	 * @generated
	 */
	EReference getImpactAnalyzer_OclEvaluator();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getEventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getEventManager()
	 * @see #getImpactAnalyzer()
	 * @generated
	 */
	EReference getImpactAnalyzer_EventManager();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getCurrentQueries <em>Current Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Queries</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getCurrentQueries()
	 * @see #getImpactAnalyzer()
	 * @generated
	 */
	EAttribute getImpactAnalyzer_CurrentQueries();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImpactAnalyzerFactory getImpactAnalyzerFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl <em>Impact Analyzer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getImpactAnalyzer()
		 * @generated
		 */
		EClass IMPACT_ANALYZER = eINSTANCE.getImpactAnalyzer();

		/**
		 * The meta object literal for the '<em><b>Ocl Evaluator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYZER__OCL_EVALUATOR = eINSTANCE.getImpactAnalyzer_OclEvaluator();

		/**
		 * The meta object literal for the '<em><b>Event Manager</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYZER__EVENT_MANAGER = eINSTANCE.getImpactAnalyzer_EventManager();

		/**
		 * The meta object literal for the '<em><b>Current Queries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT_ANALYZER__CURRENT_QUERIES = eINSTANCE.getImpactAnalyzer_CurrentQueries();

	}

} //ImpactAnalyzerPackage
