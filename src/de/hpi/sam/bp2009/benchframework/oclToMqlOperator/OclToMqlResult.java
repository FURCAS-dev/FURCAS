/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator;

import de.hpi.sam.bp2009.benchframework.ResultObject;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl To Mql Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult#getQueriesToResults <em>Queries To Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#getOclToMqlResult()
 * @model
 * @generated
 */
public interface OclToMqlResult extends ResultObject {
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
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#getOclToMqlResult_QueriesToResults()
     * @model transient="true"
     * @generated
     */
    Map<String, Object> getQueriesToResults();

    /**
     * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult#getQueriesToResults <em>Queries To Results</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Queries To Results</em>' attribute.
     * @see #getQueriesToResults()
     * @generated
     */
    void setQueriesToResults(Map<String, Object> value);

} // OclToMqlResult
