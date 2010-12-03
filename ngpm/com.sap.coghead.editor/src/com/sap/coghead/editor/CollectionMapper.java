/**
 * 
 */
package com.sap.coghead.editor;

import generated.CollectionLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;


public class CollectionMapper implements ITokenMapper {
	public Object mapColor(Token t) {
		switch (t.getType()) {
		case CollectionLexer.ARROW:
		case CollectionLexer.ASSIGN:
		case CollectionLexer.EQUALS:
			return new TextAttribute (new Color( null, new RGB(0,0,0) ), null, SWT.BOLD);
		case CollectionLexer.COMMENT:
		case CollectionLexer.MULTI_LINE_COMMENT:
			return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);
		case CollectionLexer.STRING:
		    return new TextAttribute (new Color( null, new RGB(0,10,200) ), null, SWT.NONE);
		case CollectionLexer.INT:
		case CollectionLexer.FLOAT:
		case CollectionLexer.LPAREN:
		case CollectionLexer.RPAREN:
		case CollectionLexer.RANGE_OR_INT_OR_FLOAT_OR_DOUBLE:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.NONE);
		case CollectionLexer.NAME:
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

