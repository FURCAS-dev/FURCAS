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
 * $Id: CommonReferenceResolver.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IReferenceResolver;
import org.eclipse.ocl.cst.CSTNode;

public abstract class CommonReferenceResolver implements IReferenceResolver, ILanguageService
{
	/**
	 * Get the text associated with a given node for use in a link
	 * from (or to) that node
	 */
	public String getLinkText(Object node) {
		// TODO:  Replace the call to super.getLinkText(..) with an implementation
		// suitable to you language and link types
		return node.toString();
	}

	/**
	 * Get the target for a given source node in the AST represented by a
	 * given Parse Controller.
	 */
	public Object getLinkTarget(Object node, IParseController controller) {
		return node instanceof CSTNode ? ((CSTNode)node).getAst() : null;
	}
}
