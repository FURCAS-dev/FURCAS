/**
 * 
 */
package com.sap.mi.tcs.editor;


import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;
import com.sap.furcas.parser.tcs.stableversion.TCSLexer;


public class TcsMapper implements ITokenMapper {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.IColorMapper#mapColor(antlr.Token)
	 */
	@Override
	public Object mapColor(Token t) {
		switch (t.getType()) {
		case TCSLexer.COMMENT:
			return new TextAttribute (new Color( null, new RGB(50,150,50) ), null, SWT.ITALIC);			
		case TCSLexer.INT:
		case TCSLexer.FLOAT:
			return new TextAttribute (new Color( null, new RGB(0,0,255) ), null, SWT.BOLD);
		case TCSLexer.LPAREN:
		case TCSLexer.RPAREN:
		case TCSLexer.COLON:
		case TCSLexer.COMA:
		case TCSLexer.DLCOLON:
		case TCSLexer.SEMI:
			return new TextAttribute (new Color( null, new RGB(20,0,200) ), null, SWT.NONE);
		case TCSLexer.NAME:			
			return new TextAttribute (new Color( null, new RGB(0,0,0) ), null, SWT.NONE);
		case TCSLexer.STRING:           
            return new TextAttribute (new Color( null, new RGB(10,100,150) ), null, SWT.NONE);
		default:
			return new TextAttribute (new Color( null, new RGB(150,60,150) ), null, SWT.BOLD);
		}
	}

	@Override
	public TextAttribute getComment() {
	    return new TextAttribute (new Color( null, new RGB(63,127,95) ), null, SWT.ITALIC);
	}

}

