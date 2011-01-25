/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 256040
 *
 * </copyright>
 *
 * $Id: Variable.java,v 1.3 2008/11/24 00:43:06 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.ecore.EcorePackage#getVariable()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedName'"
 * @generated
 */
public interface Variable
		extends ETypedElement,
		org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> {
} // Variable
