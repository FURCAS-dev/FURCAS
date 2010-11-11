package com.sap.ide.cts.editor;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.TextAttribute;

public interface ITokenMapper {
	Object mapColor(Token t);

	TextAttribute getComment();
}