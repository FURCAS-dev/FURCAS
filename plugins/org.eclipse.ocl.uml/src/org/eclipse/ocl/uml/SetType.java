/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: SetType.java,v 1.3 2008/10/12 01:12:33 cdamus Exp $
 */
package org.eclipse.ocl.uml;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.uml.UMLPackage#getSetType()
 * @model
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface SetType
		extends CollectionType,
		org.eclipse.ocl.types.SetType<Classifier, Operation> {
	// no additional features
} // SetType
