/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

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
	int IMPACT_ANALYZER__OCL_EVALUATOR = 0;

	/**
	 * The feature id for the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__EVENT_MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER__QUERIES = 2;

	/**
	 * The number of structural features of the '<em>Impact Analyzer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.QueryReevaluateNotificationImpl <em>Query Reevaluate Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.QueryReevaluateNotificationImpl
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getQueryReevaluateNotification()
	 * @generated
	 */
	int QUERY_REEVALUATE_NOTIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_REEVALUATE_NOTIFICATION__EVENT = EventManagerPackage.EVENT_NOTIFICATION__EVENT;

	/**
	 * The feature id for the '<em><b>Notification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_REEVALUATE_NOTIFICATION__NOTIFICATION = EventManagerPackage.EVENT_NOTIFICATION__NOTIFICATION;

	/**
	 * The feature id for the '<em><b>Reevaluated Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES = EventManagerPackage.EVENT_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Reevaluate Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_REEVALUATE_NOTIFICATION_FEATURE_COUNT = EventManagerPackage.EVENT_NOTIFICATION_FEATURE_COUNT + 1;


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
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queries</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getQueries()
	 * @see #getImpactAnalyzer()
	 * @generated
	 */
	EAttribute getImpactAnalyzer_Queries();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification <em>Query Reevaluate Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Reevaluate Notification</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification
	 * @generated
	 */
	EClass getQueryReevaluateNotification();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification#getReevaluatedQueries <em>Reevaluated Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reevaluated Queries</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification#getReevaluatedQueries()
	 * @see #getQueryReevaluateNotification()
	 * @generated
	 */
	EAttribute getQueryReevaluateNotification_ReevaluatedQueries();

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
		 * The meta object literal for the '<em><b>Queries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT_ANALYZER__QUERIES = eINSTANCE.getImpactAnalyzer_Queries();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.QueryReevaluateNotificationImpl <em>Query Reevaluate Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.QueryReevaluateNotificationImpl
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getQueryReevaluateNotification()
		 * @generated
		 */
		EClass QUERY_REEVALUATE_NOTIFICATION = eINSTANCE.getQueryReevaluateNotification();

		/**
		 * The meta object literal for the '<em><b>Reevaluated Queries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES = eINSTANCE.getQueryReevaluateNotification_ReevaluatedQueries();

	}

} //ImpactAnalyzerPackage
