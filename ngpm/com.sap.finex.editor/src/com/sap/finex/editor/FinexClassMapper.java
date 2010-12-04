/**
 * 
 */
package com.sap.finex.editor;

import generated.FinexClassLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class FinexClassMapper implements ITokenMapper {
    public Object mapColor(Token t) {
	switch (t.getType()) {
	case FinexClassLexer.ASSIGN:
	case FinexClassLexer.EQUALS:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.BOLD);
	case FinexClassLexer.COMMENT:
	case FinexClassLexer.MULTI_LINE_COMMENT:
	    return new TextAttribute(new Color(null, new RGB(63, 127, 95)), null, SWT.ITALIC);
	case FinexClassLexer.INT:
	case FinexClassLexer.FLOAT:
	case FinexClassLexer.LPAREN:
	case FinexClassLexer.RPAREN:
	case FinexClassLexer.RANGE_OR_INT:
	    return new TextAttribute(new Color(null, new RGB(255, 0, 255)), null, SWT.NONE);
	case FinexClassLexer.FIRST_LOWERCASE_NAME:
	case FinexClassLexer.FIRST_UPPERCASE_NAME:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.NONE);
	default:
	    return new TextAttribute(new Color(null, new RGB(200, 0, 180)), null, SWT.BOLD);
	}
    }

    @Override
    public TextAttribute getComment() {
	return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);
    }

}
