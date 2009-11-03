package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import org.eclipse.jface.fieldassist.IContentProposal;

public class ContentProposal implements IContentProposal {

	private IDirectEditHolder directEditHolder;

	private String proposalText;

	private String currentText;

	private String description;

	private int cursorPosition;

	public ContentProposal(IDirectEditHolder directEditHolder, int cursorPosition, String currentText, String proposalText,
			String description) {
		this.directEditHolder = directEditHolder;
		this.cursorPosition = cursorPosition;
		this.currentText = currentText;
		this.proposalText = proposalText;
		this.description = description;
	}

	public String getContent() {
		String ret = directEditHolder.getDirectEditingFeature().completeValue(currentText, getCursorPosition(), proposalText,
				directEditHolder.getDirectEditingContext());
		return ret;
	}

	public int getCursorPosition() {
		return cursorPosition;
	}

	public String getDescription() {
		return description;
	}

	public String getLabel() {
		return proposalText;
	}
}
