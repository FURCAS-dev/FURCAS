/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

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
	 * @model
	 * @generated
	 */
	EventFilter createFilterForQuery(Constraint query);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Constraint getContextObjects(ModelChangeEvent event, Constraint query);

} // ImpactAnalyzer
