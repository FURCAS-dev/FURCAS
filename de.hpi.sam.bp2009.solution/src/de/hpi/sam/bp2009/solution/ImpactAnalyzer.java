/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer#getEventManager <em>Event Manager</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer#getOclEvaluator <em>Ocl Evaluator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getImpactAnalyzer()
 * @model
 * @generated
 */
public interface ImpactAnalyzer extends EventListener {
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
	 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getImpactAnalyzer_EventManager()
	 * @model
	 * @generated
	 */
	EventManager getEventManager();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer#getEventManager <em>Event Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Manager</em>' reference.
	 * @see #getEventManager()
	 * @generated
	 */
	void setEventManager(EventManager value);

	/**
	 * Returns the value of the '<em><b>Ocl Evaluator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Evaluator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Evaluator</em>' reference.
	 * @see #setOclEvaluator(OclEvaluator)
	 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getImpactAnalyzer_OclEvaluator()
	 * @model
	 * @generated
	 */
	OclEvaluator getOclEvaluator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.ImpactAnalyzer#getOclEvaluator <em>Ocl Evaluator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Evaluator</em>' reference.
	 * @see #getOclEvaluator()
	 * @generated
	 */
	void setOclEvaluator(OclEvaluator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ExpressionSetMany="false"
	 * @generated
	 */
	void analyze(ResourceSet resourceSet, EList<AbstractOCLCondition> ExpressionSet);

} // ImpactAnalyzer
