/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import java.util.Map;

import de.hpi.sam.bp2009.benchframework.ResultObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclResult#getQueriesToResults <em>Queries To Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclResult()
 * @model
 * @generated
 */
public interface OclResult extends ResultObject {
	/**
	 * Returns the value of the '<em><b>Queries To Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries To Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries To Results</em>' attribute.
	 * @see #setQueriesToResults(Map)
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclResult_QueriesToResults()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, Boolean> getQueriesToResults();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclResult#getQueriesToResults <em>Queries To Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queries To Results</em>' attribute.
	 * @see #getQueriesToResults()
	 * @generated
	 */
	void setQueriesToResults(Map<String, Boolean> value);

} // OclResult
