/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IsMarkedPreCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Is Marked Pre CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.IsMarkedPreCS#isPre <em>Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getIsMarkedPreCS()
 * @model
 * @generated
 */
public interface IsMarkedPreCS extends CSTNode {
	/**
     * Returns the value of the '<em><b>Pre</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pre</em>' attribute.
     * @see #setPre(boolean)
     * @see org.eclipse.ocl.cst.CSTPackage#getIsMarkedPreCS_Pre()
     * @model
     * @generated
     */
	boolean isPre();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.IsMarkedPreCS#isPre <em>Pre</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pre</em>' attribute.
     * @see #isPre()
     * @generated
     */
	void setPre(boolean value);

} // IsMarkedPreCS
