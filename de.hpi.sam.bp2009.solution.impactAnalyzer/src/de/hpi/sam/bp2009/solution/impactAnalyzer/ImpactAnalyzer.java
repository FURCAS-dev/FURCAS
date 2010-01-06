/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import de.hpi.sam.bp2009.solution.eventListener.EventListener;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.resource.ResourceSet;

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
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer()
 * @model
 * @generated
 */
public interface ImpactAnalyzer extends EventListener {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false" oclQueriesMany="false"
	 * @generated
	 */
	EList<OclQuery> analyze(ResourceSet resourceSet, EList<OclQuery> oclQueries);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerFor(ModelChangeEvent events, ResourceSet resourceSet);

} // ImpactAnalyzer
