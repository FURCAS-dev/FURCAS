/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreach Predicate Property Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit#getPredicateSemantic <em>Predicate Semantic</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getForeachPredicatePropertyInit()
 * @model
 * @generated
 */
public interface ForeachPredicatePropertyInit extends PropertyInit {
	/**
	 * Returns the value of the '<em><b>Predicate Semantic</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.PredicateSemantic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate Semantic</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate Semantic</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getForeachPredicatePropertyInit_PredicateSemantic()
	 * @model containment="true"
	 * @generated
	 */
	EList<PredicateSemantic> getPredicateSemantic();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getForeachPredicatePropertyInit_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

} // ForeachPredicatePropertyInit
