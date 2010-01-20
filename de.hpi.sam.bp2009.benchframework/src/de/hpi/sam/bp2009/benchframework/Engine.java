/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Engine#getTestRuns <em>Test Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine()
 * @model
 * @generated
 */
public interface Engine extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Runs</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.TestRun}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Runs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Runs</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine_TestRuns()
	 * @model
	 * @generated
	 */
	EList<TestRun> getTestRuns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void benchmark();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<Operator> getRegisteredOperators();

} // Engine
