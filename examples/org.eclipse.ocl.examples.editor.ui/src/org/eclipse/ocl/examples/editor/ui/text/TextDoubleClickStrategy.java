/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.text;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;

@Deprecated // Use UniversalTextEditor
public class TextDoubleClickStrategy implements ITextDoubleClickStrategy {
	protected ITextViewer fText;

	public TextDoubleClickStrategy() {
		super();
	}
    
	public void doubleClicked(ITextViewer part) {
		int pos = part.getSelectedRange().x;
		if (pos < 0)
			return;
		fText = part;
//		if (!selectComment(pos)) {
			selectWord(pos);
//		}
	}
    
    protected boolean isWordCharacter(char c) {
        return (c != '$') && (Character.isJavaIdentifierPart(c) || (c == '-'));
    }
    
	protected boolean selectWord(int caretPos) {
		IDocument doc = fText.getDocument();
		try {
            char c = doc.getChar(caretPos);
            if (!isWordCharacter(c)) {
                fText.setSelectedRange(caretPos, 1);
                return true;
            }
			int startPos = caretPos;         // Eventually index if first character
			while (startPos-1 >= 0) {
				c = doc.getChar(startPos-1);
				if (!isWordCharacter(c))
					break;
				--startPos;
			}
            c = doc.getChar(startPos);
            if (c == '-')
                startPos++;
			int endPos = caretPos;         // Eventually index past last character
			int length = doc.getLength();
			while (++endPos < length) {
				c = doc.getChar(endPos);
				if (!isWordCharacter(c))
					break;
			}
			if ((startPos <= caretPos) && (caretPos < endPos)) {
                fText.setSelectedRange(startPos, endPos - startPos);
                return true;
			}
            fText.setSelectedRange(caretPos, 1);
            return true;
		} catch (BadLocationException x) {
		}
		return false;
	}
}