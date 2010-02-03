/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import de.hpi.sam.bp2009.solution.eventManager.EventNotification;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Reevaluate Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification#getReevaluatedQueries <em>Reevaluated Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getQueryReevaluateNotification()
 * @model
 * @generated
 */
public interface QueryReevaluateNotification extends EventNotification {
	/**
	 * Returns the value of the '<em><b>Reevaluated Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reevaluated Queries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reevaluated Queries</em>' attribute.
	 * @see #setReevaluatedQueries(EList)
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getQueryReevaluateNotification_ReevaluatedQueries()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<OclQuery> getReevaluatedQueries();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification#getReevaluatedQueries <em>Reevaluated Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reevaluated Queries</em>' attribute.
	 * @see #getReevaluatedQueries()
	 * @generated
	 */
	void setReevaluatedQueries(EList<OclQuery> value);

} // QueryReevaluateNotification
