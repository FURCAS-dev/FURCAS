/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import data.classes.NamedValue;

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

} // Iterator
