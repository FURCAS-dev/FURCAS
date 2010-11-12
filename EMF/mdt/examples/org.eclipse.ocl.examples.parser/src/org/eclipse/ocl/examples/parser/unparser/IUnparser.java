/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * $Id: IUnparser.java,v 1.2 2010/04/08 06:26:28 ewillink Exp $
 *
 * </copyright>
 *
 * $Id: IUnparser.java,v 1.2 2010/04/08 06:26:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unparser;

/**
 * An IUnparser, typically in ts AbstractUnparser derived form is constructed with a
 * AST model to be cxonverted to a textual form by ionvoking unparse().
 */
public interface IUnparser
{
	/**
	 * @return the internal representation of the unparsed result as a byte array
	 */
	public byte[] getBytes();

	/**
	 * @return a String representation of the unparsed result
	 */
	public String getString();

	/**
	 * Perform the unparse so that results may be obtained by getBytes() or getString().
	 */
	public void unparse();
}