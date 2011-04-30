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
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * This interface is to be implemented by contributors to the org.eclipse.imp.runtime.contentProposer extension point.
 * The Universal IDE Editor will locate a suitable parser for the language being edited.
 * The result of the parser, an AST describing the syntactical elements in the input, is cached
 * and used when the mouse is hovered over elements in the editor.
 * 
 * @author Claffra
 */
public interface IContentProposer extends ILanguageService {
    /**
     * Returns an array of content proposals applicable relative to the AST of the given
     * parse controller at the given position.
     * 
     * The ITextViewer is provided for purposes such as accessing the IDocument with respect
     * to which content proposals are sought.
     * 
     * @param controller    A parse controller from which the AST of the document being edited
     *                      can be obtained
     * @param int           The offset for which content proposals are sought
     * @param viewer        The viewer in which the document represented by the AST in the given
     *                      parse controller is being displayed (may be null for some implementations)
     * @return              An array of completion proposals applicable relative to the AST of the given
     *                      parse controller at the given position
     */
    public ICompletionProposal[] getContentProposals(IParseController controller, int offset, ITextViewer viewer);
}
