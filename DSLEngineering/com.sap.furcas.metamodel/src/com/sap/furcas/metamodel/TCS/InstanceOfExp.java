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
 * A representation of the model object '<em><b>Instance Of Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.InstanceOfExp#getSupertype <em>Supertype</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInstanceOfExp()
 * @model
 * @generated
 */
public interface InstanceOfExp extends AtomExp {

	/**
	 * Returns the value of the '<em><b>Supertype</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertype</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertype</em>' attribute list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInstanceOfExp_Supertype()
	 * @model
	 * @generated
	 */
	EList<String> getSupertype();
} // InstanceOfExp
