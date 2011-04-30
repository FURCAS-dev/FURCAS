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

package org.eclipse.imp.parser;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.language.ILanguageService;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 2005  All Rights Reserved
 */

/**
 * A language service that needs to be notified in order to update in response to source
 * code changes.
 * @author Claffra
 * @author rfuhrer@watson.ibm.com
 */
public interface IModelListener extends ILanguageService {
    // BROKEN!!!
    // The following has no notion of the scope of analysis. E.g., providing a language
    // service may require analysis within a much wider scope than a compilation unit
    // (such as whole program analysis). Also, analyses don't really form a linear order.
    public enum AnalysisRequired {
	NONE(0),
	LEXICAL_ANALYSIS(1),
	SYNTACTIC_ANALYSIS(2),
	NAME_ANALYSIS(3),
	TYPE_ANALYSIS(4),
	CALLGRAPH_ANALYSIS(5),
	POINTER_ANALYSIS(6);

	private final int fLevel;

	private AnalysisRequired(int i) { fLevel= i; }

	public int level() { return fLevel; }
    };

    public AnalysisRequired getAnalysisRequired();

    /**
     * Notify the listener that the document has been updated and a new AST has been computed
     * @param parseController the parse controller that, among other things, provides the most recent AST
     * @param monitor the progress monitor; listener should cancel when monitor.isCanceled() is true
     */
    public void update(IParseController parseController, IProgressMonitor monitor);
}
