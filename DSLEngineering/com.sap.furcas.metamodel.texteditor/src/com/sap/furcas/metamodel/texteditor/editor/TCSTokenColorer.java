package com.sap.furcas.metamodel.texteditor.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import com.sap.furcas.ide.editor.imp.services.FurcasTokenColorer;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.parser.tcs.stable.TCSLexer;

public class TCSTokenColorer extends FurcasTokenColorer {

    protected final TextAttribute identifierAttribute, keywordAttribute, numberAttribute, commentAttribute, stringAttribute;

    public TCSTokenColorer() {
        super();

        Display display = Display.getDefault();
        numberAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_YELLOW), null, SWT.BOLD);
        
        identifierAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_BLACK), null, SWT.NORMAL);
        stringAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_BLUE), null, SWT.NORMAL);
        
        commentAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.ITALIC);
        keywordAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD);
    }

    @Override
    public TextAttribute getColoring(AbstractToken token) {
        switch (token.getType()) {
        case TCSLexer.EOF:
            return null;
        case TCSLexer.WS:
            return null;
        case TCSLexer.STRING:
            return stringAttribute;
        case TCSLexer.COMMENT:
            return commentAttribute;
        case TCSLexer.NAME:
            return identifierAttribute;
        default:
            return keywordAttribute;
        }
    }
  
}
