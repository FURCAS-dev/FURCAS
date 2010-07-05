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

} // ForeachPredicatePropertyInit
