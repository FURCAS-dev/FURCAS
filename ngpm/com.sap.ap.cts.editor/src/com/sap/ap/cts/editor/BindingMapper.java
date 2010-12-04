/**
 * 
 */
package com.sap.ap.cts.editor;

import generated.BindingLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class BindingMapper implements ITokenMapper {
    public Object mapColor(Token t) {
	switch (t.getType()) {
	case BindingLexer.ARROW:
	case BindingLexer.ASSIGN:
	case BindingLexer.EQUALS:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.BOLD);
	case BindingLexer.COMMENT:
	case BindingLexer.MULTI_LINE_COMMENT:
	    return new TextAttribute(new Color(null, new RGB(0, 255, 0)), null, SWT.ITALIC);
	case BindingLexer.INT:
	case BindingLexer.FLOAT:
	case BindingLexer.LPAREN:
	case BindingLexer.RPAREN:
	case BindingLexer.RANGE_OR_INT:
	    return new TextAttribute(new Color(null, new RGB(255, 0, 255)), null, SWT.NONE);
	case BindingLexer.NAME:
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
