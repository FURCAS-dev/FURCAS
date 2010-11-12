/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: ICommonKeyword.java,v 1.1 2010/03/11 14:51:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.ocl.cst.CSTNode;

public interface ICommonKeyword extends Comparable<ICommonKeyword>
{
	/**
	 * Return the text representation of the keyword.
	 */
	public String getText();

	/**
	 * Return true if this keyword could be used as an identifier to replace cstNode.
	 */
	public boolean isIdentifier(CSTNode cstNode);
}