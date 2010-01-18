/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Operator#getDefaultOption <em>Default Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Operator#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Operator#getTestRun <em>Test Run</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getOperator()
 * @model abstract="true"
 * @generated
 */
public interface Operator extends EObject {
	/**
	 * Returns the value of the '<em><b>Default Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Option</em>' reference.
	 * @see #setDefaultOption(OptionObject)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getOperator_DefaultOption()
	 * @model
	 * @generated
	 */
	OptionObject getDefaultOption();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.Operator#getDefaultOption <em>Default Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Option</em>' reference.
	 * @see #getDefaultOption()
	 * @generated
	 */
	void setDefaultOption(OptionObject value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(ResultObject)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getOperator_Result()
	 * @model
	 * @generated
	 */
	ResultObject getResult();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.Operator#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(ResultObject value);

	/**
	 * Returns the value of the '<em><b>Test Run</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.TestRun#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Run</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Run</em>' reference.
	 * @see #setTestRun(TestRun)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getOperator_TestRun()
	 * @see de.hpi.sam.bp2009.benchframework.TestRun#getOperators
	 * @model opposite="operators"
	 * @generated
	 */
	TestRun getTestRun();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.Operator#getTestRun <em>Test Run</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Run</em>' reference.
	 * @see #getTestRun()
	 * @generated
	 */
	void setTestRun(TestRun value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute(Resource resource, OptionObject option);

} // Operator
