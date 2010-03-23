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
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getJETMMultiResultObject_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<JETMResultObject> getResults();

} // JETMMultiResultObject
