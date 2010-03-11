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
 * $Id: CommonContentProposer.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;



import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IContentProposer;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public abstract class CommonContentProposer implements IContentProposer
{
	protected CommonContentProposals createProposals(ICommonParseResult parseResult, int offset) {
		return new CommonContentProposals(parseResult, offset);
	}

	/**
	 * Returns an array of content proposals applicable relative to the AST of the given
	 * parse controller at the given position.
	 * 
	 * (The provided ITextViewer is not used in the default implementation provided here
	 * but but is stipulated by the IContentProposer interface for purposes such as accessing
	 * the IDocument for which content proposals are sought.)
	 * 
	 * @param controller	A parse controller from which the AST of the document being edited
	 * 						can be obtained
	 * @param int			The offset for which content proposals are sought
	 * @param viewer		The viewer in which the document represented by the AST in the given
	 * 						parse controller is being displayed (may be null for some implementations)
	 * @return				An array of completion proposals applicable relative to the AST of the given
	 * 						parse controller at the given position
	 */
	public ICompletionProposal[] getContentProposals(IParseController controller, int offset, ITextViewer viewer) {
		ICommonParseController commonParseController = (ICommonParseController) controller;
		ICommonParseResult parseResult = commonParseController.getCurrentResult();
		if (parseResult == null)
			return new ICompletionProposal[0];
		CommonContentProposals proposals = createProposals(parseResult, offset); // a list of proposals.
		proposals.computeProposals();
		return proposals.sortProposals();
	}
}
