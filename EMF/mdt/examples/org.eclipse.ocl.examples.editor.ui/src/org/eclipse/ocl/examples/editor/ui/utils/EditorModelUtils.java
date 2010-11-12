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
 * $Id: EditorModelUtils.java,v 1.1 2010/03/11 14:51:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.utils;

import lpg.runtime.ILexStream;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.ocl.cst.CSTNode;

public class EditorModelUtils
{
	public static String getTokenFileName(CSTNode cstNode) {
		IToken token = cstNode.getStartToken();
		if (token == null)
			return null;
		IPrsStream prsStream = token.getIPrsStream();
		if (prsStream == null)
			return null;
		ILexStream lexStream = prsStream.getILexStream();
		if (lexStream == null)
			return null;
		return lexStream.getFileName();
	}
}