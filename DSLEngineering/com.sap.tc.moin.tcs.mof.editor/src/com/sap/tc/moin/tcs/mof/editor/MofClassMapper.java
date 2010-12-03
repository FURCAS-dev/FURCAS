package com.sap.tc.moin.tcs.mof.editor;

import generated.MofClassLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class MofClassMapper implements ITokenMapper {

    public Object mapColor(Token t) {
	switch (t.getType()) {
	/*
	case MofClassLexer.ARROW:
	case MofClassLexer.ASSIGN:
	case MofClassLexer.EQUALS:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null,
		    SWT.BOLD);
		    */
	case MofClassLexer.COMMENT:
	case MofClassLexer.MULTI_LINE_COMMENT:
	    return new TextAttribute(new Color(null, new RGB(63, 127, 95)),
		    null, SWT.ITALIC);
	case MofClassLexer.INT:
	case MofClassLexer.FLOAT:
	case MofClassLexer.RANGE_OR_INT:
	    return new TextAttribute(new Color(null, new RGB(255, 0, 255)),
		    null, SWT.NONE);
	case MofClassLexer.NAME:
	case MofClassLexer.QNAME:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null,
		    SWT.NONE);
	default:
	    return new TextAttribute(new Color(null, new RGB(200, 0, 180)),
		    null, SWT.BOLD);
	}
    }

    @Override
    public TextAttribute getComment() {
	return new TextAttribute(new Color(null, new RGB(63, 127, 95)), null,
		SWT.ITALIC);
    }
}
