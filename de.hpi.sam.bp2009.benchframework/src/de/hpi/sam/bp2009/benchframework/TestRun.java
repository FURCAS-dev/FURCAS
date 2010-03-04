/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A testrun is an internal representation of one single run of the benchmarking framework, containing an ordered list of operators and the model to operate on.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.TestRun#getModel <em>Model</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.TestRun#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getTestRun()
 * @model
 * @generated
 */
public interface TestRun extends EObject {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The model instance for a testrun
	 * If using other formats than EResourceSet @see getInstanceForClass
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(ResourceSet)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getTestRun_Model()
	 * @model transient="true"
	 * @generated
	 */
	ResourceSet getModel();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.TestRun#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(ResourceSet value);

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.bp2009.benchframework.Operator}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.Operator#getTestRun <em>Test Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All operator, that should be executed on exuting the testrun
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operators</em>' reference list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getTestRun_Operators()
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getTestRun
	 * @model opposite="testRun"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns a testrun unique instance of a Class.
	 * The idea is that an operator can register a specific class to the testrun, if another operator use the same class and is aware of other operators, he can just reuse the registered instance.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	<returnType> returnType getInstanceForClass(Class<returnType> aClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * registers a testrun unique instance of a Class.
	 * The idea is that an operator can register a specific class to the testrun, if another operator use the same class and is aware of other operators, he can just reuse the registered instance.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean setInstanceForClass(Class<?> aClass, Object anObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<StartOperator> getStartOperators();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<EndOperator> getEndOperators();

} // TestRun
