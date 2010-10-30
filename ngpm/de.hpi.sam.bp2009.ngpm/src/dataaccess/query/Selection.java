/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.query;

import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectBasedExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Filters the (multi-)object based on the "condition" predicate. The expression can assume an implicit iterator variable "self" to be in scope which holds a single element of the (multi-)object from which to select. self's basic type is the same as that of "object" but with single multiplicity.
 * 
 * The expression's type must be Boolean. If the expression evaluates to true, the single object is part of the resulting object, otherwise not.
 * 
 * The Selection expression's result type is the same as object's type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.query.Selection#getIterator <em>Iterator</em>}</li>
 *   <li>{@link dataaccess.query.Selection#getSelectionExpr <em>Selection Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.query.QueryPackage#getSelection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ConditionMustBeSideEffectFree='self.selectionExpr.isSideEffectFree()' ConditionMustBeBooleanOrNumeric='self.selectionExpr.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n (\r\n    (\r\n      self.selectionExpr.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = \'Boolean\' and\r\n      self.selectionExpr.getType().upperMultiplicity = 1\r\n    )\r\n    or\r\n    (\r\n      self.selectionExpr.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = \'Number\' \r\n      and \r\n      self.object.getType().ordered\r\n    )\r\n  )'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConditionMustBeSideEffectFree ConditionMustBeBooleanOrNumeric'"
 * @generated
 */
public interface Selection extends ObjectBasedExpression {
	/**
     * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getSelection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Iterator</em>' containment reference.
     * @see #setIterator(Iterator)
     * @see dataaccess.query.QueryPackage#getSelection_Iterator()
     * @see behavioral.actions.Iterator#getSelection
     * @model opposite="selection" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Iterator getIterator();

	/**
     * Sets the value of the '{@link dataaccess.query.Selection#getIterator <em>Iterator</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Iterator</em>' containment reference.
     * @see #getIterator()
     * @generated
     */
	void setIterator(Iterator value);

	/**
     * Returns the value of the '<em><b>Selection Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Selection Expr</em>' containment reference.
     * @see #setSelectionExpr(Expression)
     * @see dataaccess.query.QueryPackage#getSelection_SelectionExpr()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='selection'"
     * @generated
     */
	Expression getSelectionExpr();

	/**
     * Sets the value of the '{@link dataaccess.query.Selection#getSelectionExpr <em>Selection Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selection Expr</em>' containment reference.
     * @see #getSelectionExpr()
     * @generated
     */
	void setSelectionExpr(Expression value);

} // Selection
