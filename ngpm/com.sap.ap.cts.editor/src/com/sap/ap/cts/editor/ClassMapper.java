/**
 * 
 */
package com.sap.ap.cts.editor;

import generated.ClassLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class ClassMapper implements ITokenMapper {
    public Object mapColor(Token t) {
	switch (t.getType()) {
	case ClassLexer.ARROW:
	case ClassLexer.ASSIGN:
	case ClassLexer.EQUALS:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.BOLD);
	case ClassLexer.COMMENT:
	case ClassLexer.MULTI_LINE_COMMENT:
	    return new TextAttribute(new Color(null, new RGB(63, 127, 95)), null, SWT.ITALIC);
	case ClassLexer.INT:
	case ClassLexer.FLOAT:
	case ClassLexer.LPAREN:
	case ClassLexer.RPAREN:
	case ClassLexer.RANGE_OR_INT:
	    return new TextAttribute(new Color(null, new RGB(255, 0, 255)), null, SWT.NONE);
	case ClassLexer.NAME:
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
