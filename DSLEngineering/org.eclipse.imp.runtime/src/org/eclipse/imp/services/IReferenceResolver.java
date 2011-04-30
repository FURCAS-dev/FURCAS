/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.services;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;


/**
 * Specifies methods to support the construction of hyperlinks between
 * AST nodes.
 * 
 * @author sutton
 *
 */
public interface IReferenceResolver extends ILanguageService {
	
	/**
	 * Returns the AST node that represents the target of a hyperlink that
	 * has the given AST node as a source and that is interpreted in the
	 * context of the AST represented by the given parse controller.
	 * 
	 * Normally the source and target nodes should both occur in the AST
	 * represented by the given parse controller.
	 * 
	 * @param node				The AST node to be considered as the source
	 * 							of a hyperlink
	 * @param parseController	The parse controller that contains the AST with
	 * 							respect to which the link is defined
	 * @return					The AST node that is the target of the hyperlink,
	 * 							if found, or null if no target node has been found
	 */
	public Object getLinkTarget(Object node, IParseController parseController);
	
	
	/**
	 * Returns a text string to be associated with a hyperlink.
	 *
	 * Historical note:  So far in practice we have obtained the link
	 * text from the source node.  This method may also be used with the
	 * target node.  If a need arises, we can add another method that
	 * would take two nodes.  SMS 13 Jun 2006.
	 * 
	 * @param node		The node with respect to which the link text is
	 * 					to be determined
	 * @return			The link text determined with respect to the
	 * 					given node.
	 */
	public String getLinkText(Object node);	

}
