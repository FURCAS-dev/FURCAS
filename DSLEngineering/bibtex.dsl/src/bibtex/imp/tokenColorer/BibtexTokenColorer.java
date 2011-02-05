package bibtex.imp.tokenColorer;

import generated.BibtexLexer;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

public class BibtexTokenColorer implements ITokenColorer {

    protected final TextAttribute doubleAttribute, identifierAttribute, keywordAttribute, numberAttribute, commentAttribute, stringAttribute;

    public BibtexTokenColorer() {
        super();

        Display display = Display.getDefault();
        doubleAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_YELLOW), null, SWT.BOLD);
        numberAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_YELLOW), null, SWT.BOLD);
        
        identifierAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_BLACK), null, SWT.NORMAL);
        stringAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_BLUE), null, SWT.BOLD);
        
        commentAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.ITALIC);
        keywordAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD);
    }

    @Override
    public TextAttribute getColoring(IParseController controller, Object o) {
        AbstractToken token = (AbstractToken) o;

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
    
    @Override
    public IRegion calculateDamageExtent(IRegion seed, IParseController ctlr) {
        return seed;
    }
}
