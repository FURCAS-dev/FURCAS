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
 * $Id$
 */

package org.eclipse.emf.ocl.types;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.ocl.types.OCLStandardLibrary;

/**
 * @deprecated Use the {@link org.eclipse.ocl.types.MessageType} interface,
 * instead.  Note also, that the {@link OCLStandardLibrary#getOclMessage()}
 * method provides the <tt>OclMessage</tt> generic instance of this metaclass.
 * 
 * @author Edith Schonberg (edith)
 *
 */
public interface MessageType extends EClass, PredefinedType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * @model lowerBound=0  upperBound=1
	 */
	public EClass getReferredSignal();
	

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Signal</em>' reference.
	 * @see #getReferredSignal()
	 * @generated
	 */
	void setReferredSignal(EClass value);

	/**
	 * @model lowerBound=0  upperBound=1
	 */
	public EOperation getReferredOperation();
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(EOperation value);

}
