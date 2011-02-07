/**
 * <copyright>
 * </copyright>
 *
 * $Id: GroupBy.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
 */
package dataaccess.analytics;

import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectBasedExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Groups the "object" expression's evaluation result by assigning each of its objects to the "fact" iterator, then evaluating all dimensions' expressions. Those objects having equal dimension results for all dimensions are put into one group. If no mapExpression is provided, the collection of those groups is the result of the GroupBy expression.
 * 
 * If a mapExpression is provided, each group is assigned to the groupedFacts iterator, all dimension values for the respective group are assigned to their iterator and the mapExpression is evaluated with all these iterators in scope. The map expression's output type is raised in multiplicity by one "level". However, the GroupBy's type always has non-unique multiplicity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.analytics.GroupBy#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link dataaccess.analytics.GroupBy#getFact <em>Fact</em>}</li>
 *   <li>{@link dataaccess.analytics.GroupBy#getMapExpression <em>Map Expression</em>}</li>
 *   <li>{@link dataaccess.analytics.GroupBy#getGroupedFacts <em>Grouped Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.analytics.AnalyticsPackage#getGroupBy()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL GroupedFactsIteratorMustExistIfMapExpressionExists='self.mapExpression->notEmpty() implies self.groupedFacts->notEmpty()' MapExpressionMustBeSideEffectFree='if self.mapExpression->notEmpty() then\r\n    self.mapExpression.isSideEffectFree()\r\n  else\r\n    true\r\n  endif' GroupByIteratorsMustHaveDistinctNames='self.dimensions.iterator->asSet()->union(self.groupedFacts->asSet())->union(self.fact->asSet())->forAll(i, j | i<>j implies i.name<>j.name)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='GroupedFactsIteratorMustExistIfMapExpressionExists MapExpressionMustBeSideEffectFree GroupByIteratorsMustHaveDistinctNames'"
 * @generated
 */
public interface GroupBy extends ObjectBasedExpression {
	/**
     * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.analytics.DimensionDefinition}.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.DimensionDefinition#getGroupBy <em>Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dimensions</em>' containment reference list.
     * @see dataaccess.analytics.AnalyticsPackage#getGroupBy_Dimensions()
     * @see dataaccess.analytics.DimensionDefinition#getGroupBy
     * @model opposite="groupBy" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	EList<DimensionDefinition> getDimensions();

	/**
     * Returns the value of the '<em><b>Fact</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getFactOfGroupBy <em>Fact Of Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fact</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Fact</em>' containment reference.
     * @see #setFact(Iterator)
     * @see dataaccess.analytics.AnalyticsPackage#getGroupBy_Fact()
     * @see behavioral.actions.Iterator#getFactOfGroupBy
     * @model opposite="factOfGroupBy" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Iterator getFact();

	/**
     * Sets the value of the '{@link dataaccess.analytics.GroupBy#getFact <em>Fact</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fact</em>' containment reference.
     * @see #getFact()
     * @generated
     */
	void setFact(Iterator value);

	/**
     * Returns the value of the '<em><b>Map Expression</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getMapExpressionOfGroupBy <em>Map Expression Of Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Map Expression</em>' containment reference.
     * @see #setMapExpression(Expression)
     * @see dataaccess.analytics.AnalyticsPackage#getGroupBy_MapExpression()
     * @see dataaccess.expressions.Expression#getMapExpressionOfGroupBy
     * @model opposite="mapExpressionOfGroupBy" containment="true" resolveProxies="true"
     * @generated
     */
	Expression getMapExpression();

	/**
     * Sets the value of the '{@link dataaccess.analytics.GroupBy#getMapExpression <em>Map Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Map Expression</em>' containment reference.
     * @see #getMapExpression()
     * @generated
     */
	void setMapExpression(Expression value);

	/**
     * Returns the value of the '<em><b>Grouped Facts</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getGroupedFactsOfGroupBy <em>Grouped Facts Of Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grouped Facts</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Grouped Facts</em>' containment reference.
     * @see #setGroupedFacts(Iterator)
     * @see dataaccess.analytics.AnalyticsPackage#getGroupBy_GroupedFacts()
     * @see behavioral.actions.Iterator#getGroupedFactsOfGroupBy
     * @model opposite="groupedFactsOfGroupBy" containment="true" resolveProxies="true"
     * @generated
     */
	Iterator getGroupedFacts();

	/**
     * Sets the value of the '{@link dataaccess.analytics.GroupBy#getGroupedFacts <em>Grouped Facts</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grouped Facts</em>' containment reference.
     * @see #getGroupedFacts()
     * @generated
     */
	void setGroupedFacts(Iterator value);

} // GroupBy
