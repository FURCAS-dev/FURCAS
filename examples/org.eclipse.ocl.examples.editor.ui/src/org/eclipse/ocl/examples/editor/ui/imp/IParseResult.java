/**
 * <copyright>
 * 
 * Copyright (c) 2009,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: IParseResult.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;

/**
 * An IParseResult encapsulates the result of a parse and provides methods
 * to access the result and the source of the result.
 */
public interface IParseResult
{
	/**
	 * Return the AST created by the parse controller.
	 * 
	 * @return the AST
	 */
	public Object getAST();

	/**
	 * Return the parse controller that created this result.
	 * 
	 * @return the parse controller.
	 */
	public IParseController getParseController();

	/**
	 * Return a locator for source positions.
	 * 
	 * @return the source position locator
	 */
	public ISourcePositionLocator getSourcePositionLocator();

	/**
	 * Returns the source text for the given character offset range
	 * 
	 * @param start first character returned
	 * @param length number of characters returned
	 * 
	 * @return the character range
	 */
	public String getTextRange(int start, int length);
}
