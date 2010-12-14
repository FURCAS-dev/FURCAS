package bibtex.dsl.editor;

import generated.BibtexLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;


public class BibtexTokenMapper implements ITokenMapper {
	
	@Override
    public TextAttribute mapColor(Token t) {
        switch (t.getType()) {
        case BibtexLexer.NAME:
            return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.NONE);
        default:
            return new TextAttribute(new Color(null, new RGB(200, 0, 180)), null, SWT.BOLD);
        }
    }

    @Override
    public TextAttribute getComment() {
        return new TextAttribute(new Color(null, new RGB(63, 127, 95)), null, SWT.ITALIC);
    }
}
