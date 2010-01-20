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
 * A representation of the model object '<em><b>User Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.UserInterface#getEngine <em>Engine</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.UserInterface#getAvailableOperators <em>Available Operators</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.UserInterface#getResultProcessor <em>Result Processor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getUserInterface()
 * @model abstract="true"
 * @generated
 */
public interface UserInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine</em>' reference.
	 * @see #setEngine(Engine)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getUserInterface_Engine()
	 * @model
	 * @generated
	 */
	Engine getEngine();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.UserInterface#getEngine <em>Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine</em>' reference.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(Engine value);

	/**
	 * Returns the value of the '<em><b>Available Operators</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Operators</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Operators</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getUserInterface_AvailableOperators()
	 * @model
	 * @generated
	 */
	EList<Operator> getAvailableOperators();

	/**
	 * Returns the value of the '<em><b>Result Processor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Processor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Processor</em>' reference.
	 * @see #setResultProcessor(ResultProcessor)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getUserInterface_ResultProcessor()
	 * @model
	 * @generated
	 */
	ResultProcessor getResultProcessor();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.UserInterface#getResultProcessor <em>Result Processor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Processor</em>' reference.
	 * @see #getResultProcessor()
	 * @generated
	 */
	void setResultProcessor(ResultProcessor value);

} // UserInterface
