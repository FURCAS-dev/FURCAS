/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: OCLExpression.java,v 1.2 2007/02/14 13:42:14 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOCLExpression()
 * @model abstract="true"
 *        extendedMetaData="name='OclExpression'"
 * @generated
 */
public interface OCLExpression<C> extends TypedElement<C>, Visitable, ASTNode {
    // no additional features
} // OCLExpression
