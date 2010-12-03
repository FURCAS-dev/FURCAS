/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Symbol#getSpaces <em>Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSymbol()
 * @model
 * @generated
 */
public interface Symbol extends Literal {
        /**
	 * Returns the value of the '<em><b>Spaces</b></em>' attribute list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind}.
	 * The literals are from the enumeration {@link com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Spaces</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Spaces</em>' attribute list.
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSymbol_Spaces()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
        EList<SpaceKind> getSpaces();

} // Symbol
