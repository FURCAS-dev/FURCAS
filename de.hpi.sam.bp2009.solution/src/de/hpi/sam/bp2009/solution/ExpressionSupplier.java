/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.ExpressionSupplier#getIA <em>IA</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getExpressionSupplier()
 * @model
 * @generated
 */
public interface ExpressionSupplier extends EObject {
	/**
	 * Returns the value of the '<em><b>IA</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IA</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IA</em>' reference.
	 * @see #setIA(ImpactAnalyzer)
	 * @see de.hpi.sam.bp2009.solution.SolutionPackage#getExpressionSupplier_IA()
	 * @model
	 * @generated
	 */
	ImpactAnalyzer getIA();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.ExpressionSupplier#getIA <em>IA</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IA</em>' reference.
	 * @see #getIA()
	 * @generated
	 */
	void setIA(ImpactAnalyzer value);

} // ExpressionSupplier
