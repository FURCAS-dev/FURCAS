package org.eclipse.imp.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * Pseudo-ICompletionProposal implementation class for posting error info when proposals can't be computed.
 * Maintains just an error message and a cursor position (so the text cursor position can be left undisturbed
 * after this pseudo-proposal is "inserted").
 * @author rfuhrer@watson.ibm.com
 */
public class ErrorProposal implements ICompletionProposal {
    private final String fDescrip;

    private final int fCursorLoc;

    public ErrorProposal(String descrip, int cursorLoc) {
        fDescrip= descrip;
        fCursorLoc= cursorLoc;
    }

    public void apply(IDocument document) {
        // do nothing
    }

    public String getAdditionalProposalInfo() {
        return null;
    }

    public IContextInformation getContextInformation() {
        return null;
    }

    public String getDisplayString() {
        return fDescrip;
    }

    public Image getImage() {
        return null;
    }

    public Point getSelection(IDocument document) {
        return new Point(fCursorLoc, 0);
    }
}
