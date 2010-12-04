package com.sap.ide.cts.editor;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.rules.IToken;

import com.sap.furcas.ide.editor.ITokenMapper;

public class ANTLRTokenWrapper implements IToken {

	private Token token;
	private boolean isUndefined;
	private ITokenMapper mapper;
	private boolean isWhitespace;

	public ANTLRTokenWrapper(Token t, ITokenMapper myMapper)
	{
		this.token = t;
		this.isUndefined = false;
		this.isWhitespace = false;
		this.mapper = myMapper;
	}
	
	public Object getData() {
		if (mapper == null)
			return null;
		return mapper.mapColor(token);
	}

	public boolean isEOF() {
		if (token == null)
			return false;
		return token == Token.EOF_TOKEN;
	}

	public boolean isOther() {
		return false;
	}

	public boolean isUndefined() {
		return isUndefined;
	}

	public boolean isWhitespace() {
		return isWhitespace;
	}

	public void setIsWhitespace(boolean isWhitespace) {
		this.isWhitespace = isWhitespace;
	}
	
	public Token getToken() {
		return token;
	}
}
