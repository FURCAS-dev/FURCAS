/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.internal.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * @author Tim Klinger (tklinger)
 *
 * An <code>Visitable</code> object accepts <code>Visitor</code>s.
 *
 */
public interface Visitable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public Object accept(Visitor v);
}
