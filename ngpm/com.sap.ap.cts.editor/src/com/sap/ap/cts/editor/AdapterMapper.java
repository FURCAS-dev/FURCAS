/**
 * 
 */
package com.sap.ap.cts.editor;

import generated.AdapterLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;


public class AdapterMapper implements ITokenMapper {
	public Object mapColor(Token t) {
		switch (t.getType()) {
		case AdapterLexer.ARROW:
		case AdapterLexer.ASSIGN:
		case AdapterLexer.EQUALS:
			return new TextAttribute (new Color( null, new RGB(0,0,0) ), null, SWT.BOLD);
		case AdapterLexer.COMMENT:
		case AdapterLexer.MULTI_LINE_COMMENT:
			return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);			
		case AdapterLexer.INT:
		case AdapterLexer.FLOAT:
		case AdapterLexer.LPAREN:
		case AdapterLexer.RPAREN:
		case AdapterLexer.RANGE_OR_INT:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.NONE);
		case AdapterLexer.NAME:			
			return new TextAttribute (new Color( null, new RGB(0,0,0) ), null, SWT.NONE);
		default:
			return new TextAttribute (new Color( null, new RGB(200,0,180) ), null, SWT.BOLD);
		}
	}

	@Override
	public TextAttribute getComment() {
	    return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);
	}

}

