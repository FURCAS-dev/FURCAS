/**
 * 
 */
package com.sap.ap.cts.editor;

import generated.PackageLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class PackageMapper implements ITokenMapper {
    public Object mapColor(Token t) {
	switch (t.getType()) {
	case PackageLexer.ARROW:
	case PackageLexer.ASSIGN:
	case PackageLexer.EQUALS:
	    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.BOLD);
	case PackageLexer.COMMENT:
	case PackageLexer.MULTI_LINE_COMMENT:
	    return new TextAttribute(new Color(null, new RGB(63, 127, 95)), null, SWT.ITALIC);
	case PackageLexer.INT:
	case PackageLexer.FLOAT:
	case PackageLexer.LPAREN:
	case PackageLexer.RPAREN:
	case PackageLexer.RANGE_OR_INT:
	    return new TextAttribute(new Color(null, new RGB(255, 0, 255)), null, SWT.NONE);
	case PackageLexer.NAME:
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
