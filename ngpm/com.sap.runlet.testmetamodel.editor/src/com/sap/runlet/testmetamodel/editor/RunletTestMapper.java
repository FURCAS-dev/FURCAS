/**
 * 
 */
package com.sap.runlet.testmetamodel.editor;

import generated.RunletTestLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;


public class RunletTestMapper implements ITokenMapper {
	public Object mapColor(Token t) {
		switch (t.getType()) {
		case RunletTestLexer.ARROW:
		case RunletTestLexer.ASSIGN:
		case RunletTestLexer.EQUALS:
			return new TextAttribute (new Color( null, new RGB(0,0,0) ), null, SWT.BOLD);
		case RunletTestLexer.COMMENT:
		case RunletTestLexer.MULTI_LINE_COMMENT:
			return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);			
		case RunletTestLexer.INT:
		case RunletTestLexer.FLOAT:
		case RunletTestLexer.LPAREN:
		case RunletTestLexer.RPAREN:
		case RunletTestLexer.RANGE_OR_INT:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.NONE);
		case RunletTestLexer.NAME:			
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

