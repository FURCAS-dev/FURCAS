package com.sap.furcas.example.bibtex.dsl.imp.tokenColorer;

import generated.BibtexAuthorViewLexer;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import com.sap.furcas.ide.editor.imp.services.FurcasTokenColorer;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

public class BibtexAuthorViewTokenColorer extends FurcasTokenColorer {

    protected final TextAttribute identifierAttribute, keywordAttribute, numberAttribute, commentAttribute, stringAttribute;

    public BibtexAuthorViewTokenColorer() {
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
        case BibtexAuthorViewLexer.EOF:
            return null;
        case BibtexAuthorViewLexer.WS:
            return null;
        case BibtexAuthorViewLexer.STRING:
            return stringAttribute;
        case BibtexAuthorViewLexer.COMMENT:
            return commentAttribute;
        case BibtexAuthorViewLexer.NAME:
            return identifierAttribute;
        default:
            return keywordAttribute;
        }
    }
}
