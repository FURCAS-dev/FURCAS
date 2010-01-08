/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.expressionSupplier;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getAnalyzer <em>Analyzer</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage#getExpressionSupplier()
 * @model
 * @generated
 */
public interface ExpressionSupplier extends EObject {
	/**
	 * Returns the value of the '<em><b>Analyzer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzer</em>' reference.
	 * @see #setAnalyzer(ImpactAnalyzer)
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage#getExpressionSupplier_Analyzer()
	 * @model
	 * @generated
	 */
	ImpactAnalyzer getAnalyzer();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getAnalyzer <em>Analyzer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analyzer</em>' reference.
	 * @see #getAnalyzer()
	 * @generated
	 */
	void setAnalyzer(ImpactAnalyzer value);

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' attribute.
	 * @see #setQueries(EList)
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage#getExpressionSupplier_Queries()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<OclQuery> getQueries();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier#getQueries <em>Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queries</em>' attribute.
	 * @see #getQueries()
	 * @generated
	 */
	void setQueries(EList<OclQuery> value);

} // ExpressionSupplier
