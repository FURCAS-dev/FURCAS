/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.ecore.OCL.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Evaluator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorPackage#getQueryEvaluator()
 * @model
 * @generated
 */
public interface QueryEvaluator extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model queryDataType="de.hpi.sam.bp2009.benchframework.queryEvaluator.Query" contextInstancesMany="false"
	 * @generated
	 */
	boolean evaluateQuery(Query query, EList<?> contextInstances);

} // QueryEvaluator
