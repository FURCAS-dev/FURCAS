/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext <em>Context</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExtentMap <em>Extent Map</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery()
 * @model
 * @generated
 */
public interface OclQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EObject)
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery_Context()
	 * @model
	 * @generated
	 */
	EObject getContext();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EObject value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(OCLExpression)
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery_Expression()
	 * @model dataType="de.hpi.sam.bp2009.solution.oclEvaluator.expression"
	 * @generated
	 */
	OCLExpression getExpression();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(Object)
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery_Result()
	 * @model
	 * @generated
	 */
	Object getResult();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Object value);

	/**
	 * Returns the value of the '<em><b>Extent Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent Map</em>' attribute.
	 * @see #setExtentMap(Map)
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#getOclQuery_ExtentMap()
	 * @model transient="true"
	 * @generated
	 */
	Map<EClass, EList<? extends EObject>> getExtentMap();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery#getExtentMap <em>Extent Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent Map</em>' attribute.
	 * @see #getExtentMap()
	 * @generated
	 */
	void setExtentMap(Map<EClass, EList<? extends EObject>> value);

} // OclQuery
