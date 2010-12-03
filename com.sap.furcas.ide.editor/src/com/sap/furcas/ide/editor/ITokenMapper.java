package com.sap.furcas.ide.editor;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;

public interface ITokenMapper {
    
	public TextAttribute mapColor(Token token);

	public TextAttribute getComment();
}