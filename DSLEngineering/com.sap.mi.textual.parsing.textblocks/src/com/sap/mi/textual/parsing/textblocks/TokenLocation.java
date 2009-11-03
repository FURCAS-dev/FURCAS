package com.sap.mi.textual.parsing.textblocks;

import textblocks.AbstractToken;

public class TokenLocation {

	private int offset;
	private AbstractToken tok;

	public TokenLocation(AbstractToken readToken, int readOffset) {
		tok = readToken;
		// TODO Auto-generated constructor stub
		offset = readOffset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public void setTok(AbstractToken tok) {
		this.tok = tok;
	}

	public AbstractToken getTok() {
		return tok;
	}

}
