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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.ocl.types.OCLStandardLibrary;

/**
 * @deprecated Use the {@link org.eclipse.ocl.types.AnyType} interface,
 * instead.  Note also, that the {@link OCLStandardLibrary#getOclAny()}
 * method provides the <tt>OclAny</tt> singleton instance of this metaclass.
 * 
 */
@Deprecated
public interface AnyType extends EClassifier, PredefinedType {
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$
	
	public EList getOperations();
}
