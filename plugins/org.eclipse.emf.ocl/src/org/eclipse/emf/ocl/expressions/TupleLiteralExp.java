/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * author edith
 */
/**
 * @model
 */
public interface TupleLiteralExp extends LiteralExp{
	/**
	 * @model type="VariableDeclaration" lowerBound=0
	 */
	public EList getTuplePart();
	
}