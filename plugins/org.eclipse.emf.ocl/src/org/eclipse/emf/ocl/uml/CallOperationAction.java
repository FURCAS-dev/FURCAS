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
 * $Id: CallOperationAction.java,v 1.3 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * @deprecated Use the {@link org.eclipse.ocl.ecore.CallOperationAction} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 */
@Deprecated
public interface CallOperationAction extends EObject {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public EOperation getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.CallOperationAction#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

}
