/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Visitable.java,v 1.2 2007/10/11 23:05:05 cdamus Exp $
 */
package org.eclipse.ocl.utilities;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getVisitable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Visitable extends EObject {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	<T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v);

} // Visitable
