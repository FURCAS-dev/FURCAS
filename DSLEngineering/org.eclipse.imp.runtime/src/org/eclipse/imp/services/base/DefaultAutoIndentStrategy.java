/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Stan Sutton (suttons@us.ibm.com) - initial API and implementation

*******************************************************************************/



package org.eclipse.imp.services.base;

import org.eclipse.imp.services.IAutoEditStrategy;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;


/**
 * Essentially copied from org.eclipse.jface.text.DefaultAutoIndentStrategy
 * but implementing an interface that is not deprecated.
 * 
 * Provides a default implementation that always copies the indentation
 * of the previous line.
 * 
 * @author sutton
 *
 */

public class DefaultAutoIndentStrategy
	extends DefaultIndentLineAutoEditStrategy implements IAutoEditStrategy
{

	/**
	 * Creates a new default auto indent strategy.
	 */
	public DefaultAutoIndentStrategy() {
	}
	
	
}
