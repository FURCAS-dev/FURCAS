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
 * $Id: CommonProposal.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class CommonProposal implements ICommonProposal
{
	/**
     * The text shown to the user in the popup view
     */
    private final String proposal;

    /**
     * The new text being added if the user accepts this proposal
     */
    private final String newText;

    /**
     * The old text being removed if the user accepts this proposal
     */
    private final String oldText;

    /**
     * The character index at which both oldText and newText start.
     */
    private final int textStart;

    /**
     * The cursor offset from start of document.
     */
    private final int cursorOffset;

    /**
     * Additional information displayed in the pop-up view to the right of the
     * main proposal list view when this proposal is selected.
     */
    private final String additionalInfo = null;

    private final Image image;

	public CommonProposal(String proposal, int textStart, String newText, String oldText, int cursorOffset, Image image) {
		this.proposal = proposal;
		this.textStart = textStart;
		this.newText = newText;
		this.oldText = oldText;
		this.cursorOffset = cursorOffset;
		this.image = image;
	}

    public void apply(IDocument document) {
		int i = 0;
		int iMax = Math.min(newText.length(), oldText.length());
		for ( ; i < iMax; i++)
			if (newText.charAt(i) != oldText.charAt(i))
				break;
        int oldLength = oldText.length() - i;
        int newLength = newText.length() - i;
        if ((oldLength > 0) || (newLength > 0)) {
	        try {
	 			document.replace(textStart + i, oldLength, newText.substring(i));
	        } catch (BadLocationException e) {
	            e.printStackTrace();
	        }
        }
    }

	public int compareTo(ICommonProposal o) {
		return getDisplayString().compareTo(o.getDisplayString());
	}

    public String getAdditionalProposalInfo() {
        return additionalInfo;
    }

    public IContextInformation getContextInformation() {
        return null;
    }

    public String getDisplayString() {
        return proposal;
    }

	public Image getImage() {
		return image;
	}

    public Point getSelection(IDocument document) {
        return new Point(cursorOffset, 0);
    }
    
    @Override
	public String toString() {
		return proposal;
	}
}