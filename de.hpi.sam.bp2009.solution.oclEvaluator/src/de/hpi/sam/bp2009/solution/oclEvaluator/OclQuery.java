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
 * A representation of the model object '<em><b>Ocl Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext <em>Context</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery()
 * @model
 * @generated
 */
public interface OclQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(EObject)
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery_Context()
	 * @model dataType="de.hpi.sam.bp2009.solution.oclEvaluator.EObject"
	 * @generated
	 */
	EObject getContext();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EObject value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(AbstractOCLCondition)
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery_Condition()
	 * @model dataType="de.hpi.sam.bp2009.solution.oclEvaluator.OclCondition"
	 * @generated
	 */
	AbstractOCLCondition getCondition();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(AbstractOCLCondition value);

} // OclQuery
