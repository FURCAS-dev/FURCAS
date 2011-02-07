/**
 * <copyright>
 * </copyright>
 *
 * $Id: DimensionDefinition.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package dataaccess.analytics;

import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A dimension definition is not named. It owns a named iterator that can be used by the mapExpression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.analytics.DimensionDefinition#getGroupBy <em>Group By</em>}</li>
 *   <li>{@link dataaccess.analytics.DimensionDefinition#getExpression <em>Expression</em>}</li>
 *   <li>{@link dataaccess.analytics.DimensionDefinition#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.analytics.AnalyticsPackage#getDimensionDefinition()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL DimensionExpressionMustBeSideEffectFree='self.expression.isSideEffectFree()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DimensionExpressionMustBeSideEffectFree'"
 * @generated
 */
public interface DimensionDefinition extends EObject {
	/**
     * Returns the value of the '<em><b>Group By</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.GroupBy#getDimensions <em>Dimensions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group By</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Group By</em>' container reference.
     * @see #setGroupBy(GroupBy)
     * @see dataaccess.analytics.AnalyticsPackage#getDimensionDefinition_GroupBy()
     * @see dataaccess.analytics.GroupBy#getDimensions
     * @model opposite="dimensions" required="true"
     * @generated
     */
	GroupBy getGroupBy();

	/**
     * Sets the value of the '{@link dataaccess.analytics.DimensionDefinition#getGroupBy <em>Group By</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Group By</em>' container reference.
     * @see #getGroupBy()
     * @generated
     */
	void setGroupBy(GroupBy value);

	/**
     * Returns the value of the '<em><b>Expression</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' containment reference.
     * @see #setExpression(Expression)
     * @see dataaccess.analytics.AnalyticsPackage#getDimensionDefinition_Expression()
     * @see dataaccess.expressions.Expression#getDimension
     * @model opposite="dimension" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getExpression();

	/**
     * Sets the value of the '{@link dataaccess.analytics.DimensionDefinition#getExpression <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' containment reference.
     * @see #getExpression()
     * @generated
     */
	void setExpression(Expression value);

	/**
     * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Iterator</em>' containment reference.
     * @see #setIterator(Iterator)
     * @see dataaccess.analytics.AnalyticsPackage#getDimensionDefinition_Iterator()
     * @see behavioral.actions.Iterator#getDimension
     * @model opposite="dimension" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Iterator getIterator();

	/**
     * Sets the value of the '{@link dataaccess.analytics.DimensionDefinition#getIterator <em>Iterator</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Iterator</em>' containment reference.
     * @see #getIterator()
     * @generated
     */
	void setIterator(Iterator value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.iterator.name'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	String getName();

} // DimensionDefinition
