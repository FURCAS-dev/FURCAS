package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

public class ContentProposalProvider implements IContentProposalProvider {

	private IDirectEditHolder directEditHolder;

	public ContentProposalProvider(IDirectEditHolder directEditHolder) {
		this.directEditHolder = directEditHolder;
	}

	public IContentProposal[] getProposals(String contents, int position) {
		// collect and return proposals

		IContentProposal[] proposals = new IContentProposal[0];

		String[] proposalStrings = directEditHolder.getDirectEditingFeature().getValueProposals(contents, position,
				directEditHolder.getDirectEditingContext());

		if (proposalStrings != null) {
			proposals = new IContentProposal[proposalStrings.length];

			for (int i = 0; i < proposalStrings.length; i++) {
				proposals[i] = new ContentProposal(directEditHolder, position, contents, proposalStrings[i], null);
			}
		}

		return proposals;
	}

}