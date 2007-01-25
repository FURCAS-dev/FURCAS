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
 * $Id: OCLExpression.java,v 1.3 2007/01/25 18:34:36 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;


import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.Visitable;

/**
 * @deprecated Use the {@link org.eclipse.ocl.expressions.OCLExpression} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 *
 * @model abstract="true"
 */
public interface OCLExpression extends TypedElement, Visitable, ASTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

}
