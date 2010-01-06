/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import de.hpi.sam.bp2009.solution.eventListener.EventListener;

import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

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
public interface ImpactAnalyzer extends EventListener {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model oclQueriesMany="false"
	 * @generated
	 */
	void analyze(ResourceSet resourceSet, EList<AbstractOCLCondition<Object, Object, Object>> oclQueries);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerFor(ModelChangeEvent events);

} // ImpactAnalyzer
