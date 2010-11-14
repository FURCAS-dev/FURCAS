package com.sap.furcas.test.testutils;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;

public class StubTokenStream implements TokenStream {

	@Override
	public Token LT(int k) {
		return new CommonToken(0);
	}

	@Override
	public Token get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenSource getTokenSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(int start, int stop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(Token start, Token stop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int LA(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSourceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int index() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mark() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void release(int marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rewind(int marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub

	}

	@Override
	public void seek(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
