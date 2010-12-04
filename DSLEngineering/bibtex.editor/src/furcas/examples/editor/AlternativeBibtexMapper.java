package furcas.examples.editor; 

import generated.AlternativeBibtexLexer;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.sap.furcas.ide.editor.ITokenMapper;

public class AlternativeBibtexMapper implements ITokenMapper { 

	public Object mapColor(Token t) { 
		switch (t.getType()) { 
			case AlternativeBibtexLexer.NAME:
			    return new TextAttribute(new Color(null, new RGB(0, 160, 0)), null, SWT.ITALIC);
			case AlternativeBibtexLexer.T__15:
			    return new TextAttribute(new Color(null, new RGB(150, 100, 0)), null, SWT.BOLD);
			default: 
			    return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.NONE);
			
		} 
	}

	@Override
	public TextAttribute getComment() {
		// TODO Auto-generated method stub
		return new TextAttribute(new Color(null, new RGB(0, 0, 0)), null, SWT.DEFAULT);
	} 
} 
