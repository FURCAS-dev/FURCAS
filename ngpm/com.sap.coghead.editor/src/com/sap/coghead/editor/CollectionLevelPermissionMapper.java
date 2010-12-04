/**
 * 
 */
package com.sap.coghead.editor;

import generated.CollectionLevelPermissionLexer;
import generated.CollectionLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;


public class CollectionLevelPermissionMapper implements ITokenMapper {
	public Object mapColor(Token t) {
		switch (t.getType()) {
		case CollectionLevelPermissionLexer.ARROW:
		case CollectionLevelPermissionLexer.ASSIGN:
		case CollectionLevelPermissionLexer.EQUALS:
			return new TextAttribute (new Color( null, new RGB(0,0,0) ), null, SWT.BOLD);
		case CollectionLevelPermissionLexer.COMMENT:
		case CollectionLevelPermissionLexer.MULTI_LINE_COMMENT:
			return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);			
		case CollectionLexer.STRING:
		    return new TextAttribute (new Color( null, new RGB(0,10,200) ), null, SWT.NONE);
		case CollectionLevelPermissionLexer.LPAREN:
		case CollectionLevelPermissionLexer.RPAREN:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.NONE);
		case CollectionLevelPermissionLexer.NAME:			
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

