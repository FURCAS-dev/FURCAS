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
 * $Id: ElementType.java,v 1.4 2007/10/11 23:05:16 cdamus Exp $
 */

package org.eclipse.emf.ocl.types;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.types.OCLStandardLibrary;
/**
 * @deprecated Use the {@link org.eclipse.ocl.types.ElementType} interface,
 * instead.  Note also, that the {@link OCLStandardLibrary#getOclElement()}
 * method provides the <tt>OclElement</tt> generic instance of this metaclass.
 * 
 * @author Edith Schonberg (edith)
 *
 */
@Deprecated
public interface ElementType extends EClass {
	// nothing to add
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

}
