package furcas.examples.editor; 

import javax.xml.soap.Text;

import generated.BibtexLexer; 

import org.antlr.runtime.Token; 
import org.eclipse.jface.text.TextAttribute; 
import org.eclipse.swt.SWT; 
import org.eclipse.swt.graphics.Color; 
import org.eclipse.swt.graphics.RGB; 

import com.sap.furcas.ide.editor.ITokenMapper;

public class BibtexMapper implements ITokenMapper { 

	public Object mapColor(Token t) { 
		switch (t.getType()) { 
			case BibtexLexer.NAME:
			    return new TextAttribute(new Color(null, new RGB(0, 160, 0)), null, SWT.ITALIC);
			case BibtexLexer.T__15:
			case BibtexLexer.T__18:
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
