/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage#getImpactAnalyzer()
 * @model
 * @generated
 */
public interface ImpactAnalyzer extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * synthesis an EventFilter for the given Query, if an event matches the returned filter the OCL query has to be reevaluated.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EventFilter createFilterForQuery(OclQuery query);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Analyse the given OCL Query and backward navigate the Query from the root EObject of the given EventNotification. Return all context object from which the given query has to be reevaluated.
	 * <!-- end-model-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<EObject> getContextObjects(EventNotification event, OclQuery query);

} // ImpactAnalyzer
