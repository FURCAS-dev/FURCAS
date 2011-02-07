/**
 * <copyright>
 * </copyright>
 *
 * $Id: Iterator.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package behavioral.actions;

import data.classes.NamedValue;

import dataaccess.analytics.DimensionDefinition;
import dataaccess.analytics.GroupBy;
import dataaccess.expressions.collectionexpressions.Iterate;

import dataaccess.query.FromClause;
import dataaccess.query.Selection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A named value that can neither be assigned nor needs an initialization expression. It obtains its value by an iterator statement implicitly.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Iterator#getBoundToFor <em>Bound To For</em>}</li>
 *   <li>{@link behavioral.actions.Iterator#getIterate <em>Iterate</em>}</li>
 *   <li>{@link behavioral.actions.Iterator#getSelection <em>Selection</em>}</li>
 *   <li>{@link behavioral.actions.Iterator#getFromClause <em>From Clause</em>}</li>
 *   <li>{@link behavioral.actions.Iterator#getFactOfGroupBy <em>Fact Of Group By</em>}</li>
 *   <li>{@link behavioral.actions.Iterator#getDimension <em>Dimension</em>}</li>
 *   <li>{@link behavioral.actions.Iterator#getGroupedFactsOfGroupBy <em>Grouped Facts Of Group By</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getIterator()
 * @model
 * @generated
 */
public interface Iterator extends NamedValue {
	/**
     * Returns the value of the '<em><b>Bound To For</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Foreach#getForVariable <em>For Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound To For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Bound To For</em>' container reference.
     * @see #setBoundToFor(Foreach)
     * @see behavioral.actions.ActionsPackage#getIterator_BoundToFor()
     * @see behavioral.actions.Foreach#getForVariable
     * @model opposite="forVariable"
     * @generated
     */
	Foreach getBoundToFor();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getBoundToFor <em>Bound To For</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Bound To For</em>' container reference.
     * @see #getBoundToFor()
     * @generated
     */
	void setBoundToFor(Foreach value);

	/**
     * Returns the value of the '<em><b>Iterate</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.collectionexpressions.Iterate#getIterators <em>Iterators</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterate</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Iterate</em>' container reference.
     * @see #setIterate(Iterate)
     * @see behavioral.actions.ActionsPackage#getIterator_Iterate()
     * @see dataaccess.expressions.collectionexpressions.Iterate#getIterators
     * @model opposite="iterators"
     * @generated
     */
	Iterate getIterate();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getIterate <em>Iterate</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Iterate</em>' container reference.
     * @see #getIterate()
     * @generated
     */
	void setIterate(Iterate value);

	/**
     * Returns the value of the '<em><b>Selection</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.query.Selection#getIterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Selection</em>' container reference.
     * @see #setSelection(Selection)
     * @see behavioral.actions.ActionsPackage#getIterator_Selection()
     * @see dataaccess.query.Selection#getIterator
     * @model opposite="iterator"
     * @generated
     */
	Selection getSelection();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getSelection <em>Selection</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selection</em>' container reference.
     * @see #getSelection()
     * @generated
     */
	void setSelection(Selection value);

	/**
     * Returns the value of the '<em><b>From Clause</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.query.FromClause#getAlias <em>Alias</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Clause</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From Clause</em>' container reference.
     * @see #setFromClause(FromClause)
     * @see behavioral.actions.ActionsPackage#getIterator_FromClause()
     * @see dataaccess.query.FromClause#getAlias
     * @model opposite="alias"
     * @generated
     */
	FromClause getFromClause();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getFromClause <em>From Clause</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Clause</em>' container reference.
     * @see #getFromClause()
     * @generated
     */
	void setFromClause(FromClause value);

	/**
     * Returns the value of the '<em><b>Fact Of Group By</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.GroupBy#getFact <em>Fact</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fact Of Group By</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Fact Of Group By</em>' container reference.
     * @see #setFactOfGroupBy(GroupBy)
     * @see behavioral.actions.ActionsPackage#getIterator_FactOfGroupBy()
     * @see dataaccess.analytics.GroupBy#getFact
     * @model opposite="fact"
     * @generated
     */
	GroupBy getFactOfGroupBy();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getFactOfGroupBy <em>Fact Of Group By</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fact Of Group By</em>' container reference.
     * @see #getFactOfGroupBy()
     * @generated
     */
	void setFactOfGroupBy(GroupBy value);

	/**
     * Returns the value of the '<em><b>Dimension</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.DimensionDefinition#getIterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dimension</em>' container reference.
     * @see #setDimension(DimensionDefinition)
     * @see behavioral.actions.ActionsPackage#getIterator_Dimension()
     * @see dataaccess.analytics.DimensionDefinition#getIterator
     * @model opposite="iterator"
     * @generated
     */
	DimensionDefinition getDimension();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getDimension <em>Dimension</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dimension</em>' container reference.
     * @see #getDimension()
     * @generated
     */
	void setDimension(DimensionDefinition value);

	/**
     * Returns the value of the '<em><b>Grouped Facts Of Group By</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.GroupBy#getGroupedFacts <em>Grouped Facts</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grouped Facts Of Group By</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Grouped Facts Of Group By</em>' container reference.
     * @see #setGroupedFactsOfGroupBy(GroupBy)
     * @see behavioral.actions.ActionsPackage#getIterator_GroupedFactsOfGroupBy()
     * @see dataaccess.analytics.GroupBy#getGroupedFacts
     * @model opposite="groupedFacts"
     * @generated
     */
	GroupBy getGroupedFactsOfGroupBy();

	/**
     * Sets the value of the '{@link behavioral.actions.Iterator#getGroupedFactsOfGroupBy <em>Grouped Facts Of Group By</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grouped Facts Of Group By</em>' container reference.
     * @see #getGroupedFactsOfGroupBy()
     * @generated
     */
	void setGroupedFactsOfGroupBy(GroupBy value);

} // Iterator
