/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getOclEvaluator <em>Ocl Evaluator</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getEventManager <em>Event Manager</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer()
 * @model
 * @generated
 */
public interface ImpactAnalyzer extends EObject {
	/**
	 * Returns the value of the '<em><b>Ocl Evaluator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Evaluator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Evaluator</em>' reference.
	 * @see #setOclEvaluator(OCLEvaluator)
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer_OclEvaluator()
	 * @model
	 * @generated
	 */
	OCLEvaluator getOclEvaluator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getOclEvaluator <em>Ocl Evaluator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Evaluator</em>' reference.
	 * @see #getOclEvaluator()
	 * @generated
	 */
	void setOclEvaluator(OCLEvaluator value);

	/**
	 * Returns the value of the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Manager</em>' reference.
	 * @see #setEventManager(EventManager)
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer_EventManager()
	 * @model
	 * @generated
	 */
	EventManager getEventManager();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getEventManager <em>Event Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Manager</em>' reference.
	 * @see #getEventManager()
	 * @generated
	 */
	void setEventManager(EventManager value);

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' attribute.
	 * @see #setQueries(EList)
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer_Queries()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<OclQuery> getQueries();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getQueries <em>Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queries</em>' attribute.
	 * @see #getQueries()
	 * @generated
	 */
	void setQueries(EList<OclQuery> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model queriesMany="false"
	 * @generated
	 */
	void handleInternalEvent(EList<OclQuery> queries, EventNotification eventNotification);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model applicationDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter"
	 * @generated
	 */
	void notifyApplication(Adapter application, QueryReevaluateNotification msg);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model rootDataType="de.hpi.sam.bp2009.solution.eventManager.Notifier" receiverDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" oclQueriesMany="false"
	 * @generated
	 */
	void register(Notifier root, Adapter receiver, EList<OclQuery> oclQueries);

} // ImpactAnalyzer
