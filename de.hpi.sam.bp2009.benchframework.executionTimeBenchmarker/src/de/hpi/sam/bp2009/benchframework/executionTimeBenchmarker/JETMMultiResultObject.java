/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker;

import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.benchframework.ResultObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JETM Multi Result Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMMultiResultObject()
 * @model
 * @generated
 */
public interface JETMMultiResultObject extends ResultObject {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' attribute.
	 * @see #setResults(EList)
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMMultiResultObject_Results()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<JETMResultObject> getResults();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject#getResults <em>Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results</em>' attribute.
	 * @see #getResults()
	 * @generated
	 */
	void setResults(EList<JETMResultObject> value);

} // JETMMultiResultObject
