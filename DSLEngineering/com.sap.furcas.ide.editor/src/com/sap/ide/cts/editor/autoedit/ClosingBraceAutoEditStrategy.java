package com.sap.ide.cts.editor.autoedit;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

import com.sap.ide.cts.editor.matching.CtsStaticMatcher;

public class ClosingBraceAutoEditStrategy implements IAutoEditStrategy {

    private boolean lastCommandWasEdited = false;
    private String lastCommandText = "";
    private int insertedBracketPos;

    @Override
    public void customizeDocumentCommand(IDocument d, DocumentCommand c) {

	CtsStaticMatcher bStaticMatcher = new CtsStaticMatcher();
	//Check if the user typed what we auto edited just before
	//if so overwrite our stuff so that duplication is made. 
	if(lastCommandWasEdited && lastCommandText.equals(c.text)) {
	    c.length = c.length + lastCommandText.length();
	    lastCommandWasEdited = false;
	}
	if (c.length == 0 && c.text != null
		&& bStaticMatcher.isOpeningText(c.text)) {
	    lastCommandWasEdited = true; 
	    lastCommandText = bStaticMatcher.getClosingText(c.text);
	    insertedBracketPos = c.offset;
	    c.text = c.text + lastCommandText;
	    arrangeCarret(d, c);
	} else if(c.offset == insertedBracketPos + 1){
	    lastCommandWasEdited = true;
	    insertedBracketPos += c.text.length();
	} else {
	    lastCommandWasEdited = false;
	}

    }

    private void arrangeCarret(IDocument d, DocumentCommand c) {
	c.shiftsCaret = false;
	c.doit = false;
	c.caretOffset = c.offset + 1;

    }

}

