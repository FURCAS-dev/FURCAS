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
 * $Id: ICommonParseController.java,v 1.1 2010/03/11 14:51:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;

/**
 * ICommonParseController provides the extenderd interface for the controller that
 * produces a new ICommonParseResult fronm each parse(). The parsed result comprises
 * distinct AST and CST representations.  
 */
public interface ICommonParseController extends IParseController
{
	public enum TokenKind {
		EOF,
		ERROR,
		IDENTIFIER,
		INTEGER,
		REAL,
		STRING,
		KEYWORD,
		LINE_COMMENT,			// e.g. a Java // comment
		PARAGRAPH_COMMENT,		// e.g. a Java /* ... */ comment
		OTHER
	}

	public ICreationFactory getCreationFactory();

	public ICommonParseResult getCurrentResult();

	public ILabelProvider getLabelProvider();

    public TokenKind getTokenKind(int kind);
    
    /**
     * Parse the input string to create a new parse result that is cached for reaccess
     * as getCurrentResult() and getCurrentAst(). The monitor may indicate the progress
     * of long running operations. This method should only be used for parses that are
     * intended to refresh the main editor display.
     * 
     * Bug 257627 identifies how abuse of this method can cause adverse screen artefacts.  
	 *
     * @param input the input string
     * @param monitor the progress monitor
     * @return the parsed result
     */
    public ICommonParseResult parse(String input, IProgressMonitor monitor);

    /**
     * Parse the input string to create a new parse result that is not cached. The monitor
     * may indicate the progress of long running operations. This method should be used for
     * independent parses such as builds that should not interact with the regular parses
     * that contribute to the editor display.
	 *
     * @param input the input string
     * @param monitor the progress monitor
     * @return the parsed result
     */
	public ICommonParseResult parseWithoutCaching(String input, IProgressMonitor monitor);
}
