/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions;

import behavioral.actions.Constant;
import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Given the number of iterators variables, assigns all possible tuples of values from the source expression to the iterators (combinatorial product). In particular, if only only one iterator variable is provided, this variable will "loop" through the values in the source expression. If the source expression has an ordered multiplicity, the iteration order corresponds with that order. Otherwise, iteration order is arbitrary and undefined.
 * 
 * For each combination of iterator variable values, the iteratorExpression will be evaluated. The result of each evaluation is assigned to the accumulator variable.
 * 
 * The iteratorExpression can use all iterators variables as well as the accumulator if one is declared, and of course all other variables in scope as well (block variables, etc.). If an accumulator is declared, an initial value must be provided for it.
 * 
 * The result of the Iterate expression is the value that the accumulator has when the iteration terminates or the value of the last iteratorExpression evaluation if no accumulator has been provided. By this rationale, the type of the Iterate expression equals the type of the iteratorExpression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.Iterate#getIterators <em>Iterators</em>}</li>
 *   <li>{@link dataaccess.expressions.collectionexpressions.Iterate#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link dataaccess.expressions.collectionexpressions.Iterate#getIteratorExpression <em>Iterator Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getIterate()
 * @model annotation="http://de.hpi.sam.bp2009.OCL AccumulatorTypeEqualsExpressionType='self.accumulator->notEmpty() implies\r\n  (self.accumulator.ownedTypeDefinition->notEmpty() implies\r\n     self.accumulator.ownedTypeDefinition.conformsTo(self.iteratorExpression.getType()))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AccumulatorTypeEqualsExpressionType'"
 * @generated
 */
public interface Iterate extends CollectionExpression {
	/**
     * Returns the value of the '<em><b>Iterators</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.actions.Iterator}.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getIterate <em>Iterate</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Iterators</em>' containment reference list.
     * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getIterate_Iterators()
     * @see behavioral.actions.Iterator#getIterate
     * @model opposite="iterate" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	EList<Iterator> getIterators();

	/**
     * Returns the value of the '<em><b>Accumulator</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Constant#getIterate <em>Iterate</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accumulator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Accumulator</em>' containment reference.
     * @see #setAccumulator(Constant)
     * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getIterate_Accumulator()
     * @see behavioral.actions.Constant#getIterate
     * @model opposite="iterate" containment="true" resolveProxies="true"
     * @generated
     */
	Constant getAccumulator();

	/**
     * Sets the value of the '{@link dataaccess.expressions.collectionexpressions.Iterate#getAccumulator <em>Accumulator</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Accumulator</em>' containment reference.
     * @see #getAccumulator()
     * @generated
     */
	void setAccumulator(Constant value);

	/**
     * Returns the value of the '<em><b>Iterator Expression</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getInIterator <em>In Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Iterator Expression</em>' containment reference.
     * @see #setIteratorExpression(Expression)
     * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getIterate_IteratorExpression()
     * @see dataaccess.expressions.Expression#getInIterator
     * @model opposite="inIterator" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getIteratorExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.collectionexpressions.Iterate#getIteratorExpression <em>Iterator Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Iterator Expression</em>' containment reference.
     * @see #getIteratorExpression()
     * @generated
     */
	void setIteratorExpression(Expression value);

} // Iterate
