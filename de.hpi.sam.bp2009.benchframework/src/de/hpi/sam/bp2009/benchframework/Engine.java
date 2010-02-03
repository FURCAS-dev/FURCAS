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
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Engine#getExeptionsDuringLastRun <em>Exeptions During Last Run</em>}</li>
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
	 * Returns the value of the '<em><b>Exeptions During Last Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exeptions During Last Run</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exeptions During Last Run</em>' attribute.
	 * @see #setExeptionsDuringLastRun(EList)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine_ExeptionsDuringLastRun()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Exception> getExeptionsDuringLastRun();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.Engine#getExeptionsDuringLastRun <em>Exeptions During Last Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exeptions During Last Run</em>' attribute.
	 * @see #getExeptionsDuringLastRun()
	 * @generated
	 */
	void setExeptionsDuringLastRun(EList<Exception> value);

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<ResultProcessor> getRegisteredResultProcessors();

} // Engine
