/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Evaluator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOCLEvaluator()
 * @model
 * @generated
 */
public interface OCLEvaluator extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model queryobjectDataType="de.hpi.sam.bp2009.solution.OclQuery"
	 * @generated
	 */
	void evaluate(AbstractOCLCondition queryobject);

} // OCLEvaluator
