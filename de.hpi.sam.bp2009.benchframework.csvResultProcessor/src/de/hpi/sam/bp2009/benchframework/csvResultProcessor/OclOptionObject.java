/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor;

import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.benchframework.OptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#isUseImpactAnalyzer <em>Use Impact Analyzer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclOptionObject()
 * @model
 * @generated
 */
public interface OclOptionObject extends OptionObject {
	
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' attribute list.
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclOptionObject_Constraints()
	 * @model
	 * @generated
	 */
	EList<String> getConstraints();

	/**
	 * Returns the value of the '<em><b>Use Impact Analyzer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Impact Analyzer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Impact Analyzer</em>' attribute.
	 * @see #setUseImpactAnalyzer(boolean)
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclOptionObject_UseImpactAnalyzer()
	 * @model
	 * @generated
	 */
	boolean isUseImpactAnalyzer();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject#isUseImpactAnalyzer <em>Use Impact Analyzer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Impact Analyzer</em>' attribute.
	 * @see #isUseImpactAnalyzer()
	 * @generated
	 */
	void setUseImpactAnalyzer(boolean value);
} // OclOptionObject
