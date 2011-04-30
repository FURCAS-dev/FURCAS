package com.sap.furcas.example.bibtex.dsl.imp.tokenColorer;

import generated.BibtexLexer;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import com.sap.furcas.ide.editor.imp.services.FurcasTokenColorer;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

public class BibtexTokenColorer extends FurcasTokenColorer {

    protected final TextAttribute identifierAttribute, keywordAttribute, numberAttribute, commentAttribute, stringAttribute;

    public BibtexTokenColorer() {
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
        case BibtexLexer.EOF:
            return null;
        case BibtexLexer.WS:
            return null;
        case BibtexLexer.STRING:
            return stringAttribute;
        case BibtexLexer.COMMENT:
            return commentAttribute;
        case BibtexLexer.NAME:
            return identifierAttribute;
        default:
            return keywordAttribute;
        }
    }
}
