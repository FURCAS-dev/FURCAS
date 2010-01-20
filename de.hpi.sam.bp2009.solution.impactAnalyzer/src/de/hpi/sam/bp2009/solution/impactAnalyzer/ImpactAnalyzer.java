/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getCurrentQueries <em>Current Queries</em>}</li>
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
	 * Returns the value of the '<em><b>Current Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Queries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Queries</em>' attribute.
	 * @see #setCurrentQueries(EList)
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer_CurrentQueries()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<OclQuery> getCurrentQueries();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer#getCurrentQueries <em>Current Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Queries</em>' attribute.
	 * @see #getCurrentQueries()
	 * @generated
	 */
	void setCurrentQueries(EList<OclQuery> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false" oclQueriesMany="false"
	 * @generated
	 */
	EList<Object> registerQueries(EList<OclQuery> oclQueries);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model oclQueriesMany="false"
	 * @generated
	 */
	void register(EObject root, EList<OclQuery> oclQueries);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model oclQueriesMany="false"
	 * @generated
	 */
	void register(Resource root, EList<OclQuery> oclQueries);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model oclQueriesMany="false"
	 * @generated
	 */
	void register(ResourceSet root, EList<OclQuery> oclQueries);

} // ImpactAnalyzer
