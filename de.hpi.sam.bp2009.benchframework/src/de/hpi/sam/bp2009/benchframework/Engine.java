/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import java.io.OutputStream;
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
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Engine#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Engine#getResults <em>Results</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Engine#getGenerators <em>Generators</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Engine#getBenchMarkers <em>Bench Markers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine()
 * @model
 * @generated
 */
public interface Engine extends EObject {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine_Operators()
	 * @model
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Results</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.ResultProcessor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine_Results()
	 * @model
	 * @generated
	 */
	EList<ResultProcessor> getResults();

	/**
	 * Returns the value of the '<em><b>Generators</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.Generator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generators</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine_Generators()
	 * @model
	 * @generated
	 */
	EList<Generator> getGenerators();

	/**
	 * Returns the value of the '<em><b>Bench Markers</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.BenchMarker}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bench Markers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bench Markers</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEngine_BenchMarkers()
	 * @model
	 * @generated
	 */
	EList<BenchMarker> getBenchMarkers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model outputStreamDataType="de.hpi.sam.bp2009.benchframework.OutputStream"
	 * @generated
	 */
	void benchmark(OutputStream outputStream);

} // Engine
