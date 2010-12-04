package com.sap.tc.moin.tcs.mof.editor;

import generated.MofPackageLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class MofPackageMapper implements ITokenMapper {

    public Object mapColor(Token t) {
	switch (t.getType()) {
	/*
	case MofPackageLexer.ARROW:
	case MofPackageLexer.ASSIGN:
	case MofPackageLexer.EQUALS:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null,
		    SWT.BOLD);
	*/
	case MofPackageLexer.COMMENT:
	case MofPackageLexer.MULTI_LINE_COMMENT:
	    return new TextAttribute(new Color(null, new RGB(63, 127, 95)),
		    null, SWT.ITALIC);
	case MofPackageLexer.INT:
	case MofPackageLexer.FLOAT:
	case MofPackageLexer.LPAREN:
	case MofPackageLexer.RPAREN:
	case MofPackageLexer.RANGE_OR_INT:
	    return new TextAttribute(new Color(null, new RGB(255, 0, 255)),
		    null, SWT.NONE);
	case MofPackageLexer.NAME:
	case MofPackageLexer.QNAME:
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
