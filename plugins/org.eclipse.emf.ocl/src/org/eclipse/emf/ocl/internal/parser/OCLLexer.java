/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLLexer.java,v 1.1 2006/02/13 16:12:00 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import java.io.InputStream;
import java.io.Reader;
import java.util.Hashtable;

import antlr.ANTLRHashString;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.InputBuffer;
import antlr.LexerSharedInputState;
import antlr.NoViableAltForCharException;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.collections.impl.BitSet;

public class OCLLexer extends antlr.CharScanner implements OCLParserTokenTypes, TokenStream
 {

	/** Number of characters absolutely consumed so far. */
	int charCount = 0;
	int tokenStartChar = 0;
	
	/* Override panic to not do a system.exit(). */
	public void panic(String s) {
		throw new Error("CharScanner; panic: " + s);//$NON-NLS-1$
	}

	/* Override panic to not do a system.exit(). */
	public void panic() {
		throw new Error("CharScanner: panic");//$NON-NLS-1$
	}
	
	public void setTokenObjectClass(String className) {
		// ignore the requested class name and use the OCLToken class
		tokenObjectClass = OCLToken.class;
	}
	
	public void consume() throws CharStreamException {
		super.consume();
		
		if (inputState.guessing == 0) {
			// not guessing means that it's consumed for good
			charCount++;
		}
	}
	
	public void resetText() {
		super.resetText();
		tokenStartChar = charCount;
	}
	
	protected Token makeToken(int t) {
		OCLToken result = (OCLToken) super.makeToken(t);
		result.setStartPosition(tokenStartChar);
		return result;
	}
	
	/**
	 * Sets the (initial) character count.  Useful for offsetting the token
	 * position information to account for a string prefix invisible to the
	 * client.
	 */
	public void setCharacterCount(int count) {
		charCount = count;
	}
public OCLLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public OCLLexer(Reader in) {
	this(new CharBuffer(in));
}
public OCLLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public OCLLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("OclVoid", this), new Integer(48));//$NON-NLS-1$
	literals.put(new ANTLRHashString("endpackage", this), new Integer(5));//$NON-NLS-1$
	literals.put(new ANTLRHashString("String", this), new Integer(44));//$NON-NLS-1$
	literals.put(new ANTLRHashString("forAll", this), new Integer(64));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Collection", this), new Integer(52));//$NON-NLS-1$
	literals.put(new ANTLRHashString("sortedBy", this), new Integer(73));//$NON-NLS-1$
	literals.put(new ANTLRHashString("false", this), new Integer(59));//$NON-NLS-1$
	literals.put(new ANTLRHashString("true", this), new Integer(58));//$NON-NLS-1$
	literals.put(new ANTLRHashString("OrderedSet", this), new Integer(53));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Sequence", this), new Integer(51));//$NON-NLS-1$
	literals.put(new ANTLRHashString("let", this), new Integer(42));//$NON-NLS-1$
	literals.put(new ANTLRHashString("and", this), new Integer(19));//$NON-NLS-1$
	literals.put(new ANTLRHashString("select", this), new Integer(70));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Integer", this), new Integer(43));//$NON-NLS-1$
	literals.put(new ANTLRHashString("implies", this), new Integer(18));//$NON-NLS-1$
	literals.put(new ANTLRHashString("OclAny", this), new Integer(47));//$NON-NLS-1$
	literals.put(new ANTLRHashString("collect", this), new Integer(69));//$NON-NLS-1$
	literals.put(new ANTLRHashString("exists", this), new Integer(65));//$NON-NLS-1$
	literals.put(new ANTLRHashString("pre", this), new Integer(14));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Bag", this), new Integer(50));//$NON-NLS-1$
	literals.put(new ANTLRHashString("oclIsKindOf", this), new Integer(78));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Boolean", this), new Integer(46));//$NON-NLS-1$
	literals.put(new ANTLRHashString("context", this), new Integer(9));//$NON-NLS-1$
	literals.put(new ANTLRHashString("closureAll", this), new Integer(81));//$NON-NLS-1$
	literals.put(new ANTLRHashString("closure", this), new Integer(80));//$NON-NLS-1$
	literals.put(new ANTLRHashString("one", this), new Integer(68));//$NON-NLS-1$
	literals.put(new ANTLRHashString("oclAsType", this), new Integer(77));//$NON-NLS-1$
	literals.put(new ANTLRHashString("post", this), new Integer(15));//$NON-NLS-1$
	literals.put(new ANTLRHashString("endif", this), new Integer(31));//$NON-NLS-1$
	literals.put(new ANTLRHashString("inv", this), new Integer(17));//$NON-NLS-1$
	literals.put(new ANTLRHashString("in", this), new Integer(55));//$NON-NLS-1$
	literals.put(new ANTLRHashString("xor", this), new Integer(21));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Set", this), new Integer(49));//$NON-NLS-1$
	literals.put(new ANTLRHashString("or", this), new Integer(20));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Real", this), new Integer(45));//$NON-NLS-1$
	literals.put(new ANTLRHashString("isUnique", this), new Integer(66));//$NON-NLS-1$
	literals.put(new ANTLRHashString("reject", this), new Integer(71));//$NON-NLS-1$
	literals.put(new ANTLRHashString("body", this), new Integer(16));//$NON-NLS-1$
	literals.put(new ANTLRHashString("collectNested", this), new Integer(72));//$NON-NLS-1$
	literals.put(new ANTLRHashString("any", this), new Integer(67));//$NON-NLS-1$
	literals.put(new ANTLRHashString("if", this), new Integer(28));//$NON-NLS-1$
	literals.put(new ANTLRHashString("iterate", this), new Integer(75));//$NON-NLS-1$
	literals.put(new ANTLRHashString("oclIsTypeOf", this), new Integer(79));//$NON-NLS-1$
	literals.put(new ANTLRHashString("Tuple", this), new Integer(54));//$NON-NLS-1$
	literals.put(new ANTLRHashString("package", this), new Integer(4));//$NON-NLS-1$
	literals.put(new ANTLRHashString("else", this), new Integer(30));//$NON-NLS-1$
	literals.put(new ANTLRHashString("not", this), new Integer(36));//$NON-NLS-1$
	literals.put(new ANTLRHashString("then", this), new Integer(29));//$NON-NLS-1$
}

public Token nextToken() throws TokenStreamException {
tryAgain:
	for (;;) {
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\u000c':  case '\r':
				case ' ':
				{
					mWS(true);
					
					break;
				}
				case '|':
				{
					mBAR(true);
					
					break;
				}
				case ',':
				{
					mCOMMA(true);
					
					break;
				}
				case '/':
				{
					mDIVIDE(true);
					
					break;
				}
				case '=':
				{
					mEQUALS(true);
					
					break;
				}
				case '*':
				{
					mMULTIPLY(true);
					
					break;
				}
				case '(':
				{
					mLPAREN(true);
					
					break;
				}
				case ')':
				{
					mRPAREN(true);
					
					break;
				}
				case '[':
				{
					mLBRACKET(true);
					
					break;
				}
				case ']':
				{
					mRBRACKET(true);
					
					break;
				}
				case '{':
				{
					mLBRACE(true);
					
					break;
				}
				case '}':
				{
					mRBRACE(true);
					
					break;
				}
				case '@':
				{
					mPRE(true);
					
					break;
				}
				case '+':
				{
					mPLUS(true);
					
					break;
				}
				case ';':
				{
					mSEMICOLON(true);
					
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mNUMBER_OR_REAL_OR_RANGE_OR_OPERATION(true);
					
					break;
				}
				case '\'':
				{
					mSTRING_LITERAL(true);
					
					break;
				}
				default:
					if ((LA(1)=='-') && (LA(2)=='-')) {
						mSL_COMMENT(true);
						
					}
					else if ((LA(1)=='-') && (LA(2)=='>')) {
						mARROW(true);
						
					}
					else if ((LA(1)=='.') && (LA(2)=='.')) {
						mDOTDOT(true);
						
					}
					else if ((LA(1)==':') && (LA(2)==':')) {
						mDOUBLECOLON(true);
						
					}
					else if ((LA(1)=='>') && (LA(2)=='=')) {
						mGE(true);
						
					}
					else if ((LA(1)=='<') && (LA(2)=='=')) {
						mLE(true);
						
					}
					else if ((LA(1)=='<') && (LA(2)=='>')) {
						mNEQUALS(true);
						
					}
					else if ((LA(1)==':') && (true)) {
						mCOLON(true);
						
					}
					else if ((LA(1)=='.') && (true)) {
						mDOT(true);
						
					}
					else if ((LA(1)=='>') && (true)) {
						mGT(true);
						
					}
					else if ((LA(1)=='<') && (true)) {
						mLT(true);
						
					}
					else if ((LA(1)=='-') && (true)) {
						mMINUS(true);
						
					}
					else if ((_tokenSet_0.member(LA(1)))) {
						mNAME_OR_PATHNAME(true);
						
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		
		
		{
		int _cnt213=0;
		_loop213:
		do {
			switch ( LA(1)) {
			case ' ':
			{
				match(' ');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			case '\u000c':
			{
				match('\f');
				break;
			}
			case '\r':
			{
				match('\r');
				break;
			}
			case '\n':
			{
				match('\n');
				if ( inputState.guessing==0 ) {
					newline();
				}
				break;
			}
			default:
			{
				if ( _cnt213>=1 ) { break _loop213; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt213++;
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SL_COMMENT;
		
		
		match("--");//$NON-NLS-1$
		{
		_loop217:
		do {
			if ((_tokenSet_1.member(LA(1)))) {
				{
				match(_tokenSet_1);
				}
			}
			else {
				break _loop217;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case '\n':
		{
			match('\n');
			break;
		}
		case '\r':
		{
			match('\r');
			{
			if ((LA(1)=='\n')) {
				match('\n');
			}
			else {
				// empty block generated by ANTLR
			}
			
			}
			break;
		}
		default:
			{
			// empty block generated by ANTLR
			}
		}
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP; newline();
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mARROW(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ARROW;
		
		
		match("->");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BAR;
		
		
		match('|');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON;
		
		
		match(':');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDIVIDE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIVIDE;
		
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT;
		
		
		match('.');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOTDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOTDOT;
		
		
		match("..");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOUBLECOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOUBLECOLON;
		
		
		match("::");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQUALS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUALS;
		
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GE;
		
		
		match(">=");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GT;
		
		
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LE;
		
		
		match("<=");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LT;
		
		
		match('<');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS;
		
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMULTIPLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MULTIPLY;
		
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNEQUALS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NEQUALS;
		
		
		match("<>");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LPAREN;
		
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LBRACKET;
		
		
		match('[');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RBRACKET;
		
		
		match(']');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLBRACE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LBRACE;
		
		
		match('{');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRBRACE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RBRACE;
		
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPRE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PRE;
		
		
		match("@pre");//$NON-NLS-1$
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMICOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMICOLON;
		
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNUMBER_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUMBER_LITERAL;
		
		
		{
		int _cnt247=0;
		_loop247:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGIT(false);
			}
			else {
				if ( _cnt247>=1 ) { break _loop247; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt247++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGIT;
		
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREAL_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REAL_LITERAL;
		
		
		{
		mNUMBER_LITERAL(false);
		mDOT(false);
		mNUMBER_LITERAL(false);
		}
		{
		if ((LA(1)=='E'||LA(1)=='e')) {
			mEXPONENT(false);
		}
		else {
			// empty block generated by ANTLR
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEXPONENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXPONENT;
		
		
		{
		switch ( LA(1)) {
		case 'e':
		{
			match('e');
			break;
		}
		case 'E':
		{
			match('E');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case '+':
		{
			match('+');
			break;
		}
		case '-':
		{
			match('-');
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		int _cnt255=0;
		_loop255:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt255>=1 ) { break _loop255; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt255++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOPERATION_EXPR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OPERATION_EXPR;
		
		
		{
		mNUMBER_LITERAL(false);
		mDOT(false);
		mNAME(false);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NAME;
		
		
		if ((_tokenSet_2.member(LA(1)))) {
			mNONQUOTED_NAME(false);
		}
		else if ((LA(1)=='"')) {
			mQUOTED_NAME(false);
		}
		else {
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNUMERIC_URL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUMERIC_URL;
		
		
		mNUMBER_LITERAL(false);
		{
		int _cnt261=0;
		_loop261:
		do {
			if ((LA(1)=='.')) {
				mDOT(false);
				{
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mNUMBER_LITERAL(false);
				}
				else if ((_tokenSet_0.member(LA(1)))) {
					mNAME(false);
				}
				else {
					throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else {
				if ( _cnt261>=1 ) { break _loop261; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt261++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNUMERICPATHNAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUMERICPATHNAME;
		
		
		mNUMERIC_URL(false);
		{
		int _cnt265=0;
		_loop265:
		do {
			if ((LA(1)==':')) {
				mDOUBLECOLON(false);
				{
				if ((_tokenSet_0.member(LA(1)))) {
					mNAME(false);
				}
				else if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mNUMBER_LITERAL(false);
				}
				else {
					throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else {
				if ( _cnt265>=1 ) { break _loop265; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt265++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNUMBER_OR_REAL_OR_RANGE_OR_OPERATION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUMBER_OR_REAL_OR_RANGE_OR_OPERATION;
		
		
		boolean synPredMatched268 = false;
		if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_3.member(LA(2))) && (_tokenSet_4.member(LA(3))))) {
			int _m268 = mark();
			synPredMatched268 = true;
			inputState.guessing++;
			try {
				{
				mNUMERIC_URL(false);
				mDOUBLECOLON(false);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched268 = false;
			}
			rewind(_m268);
inputState.guessing--;
		}
		if ( synPredMatched268 ) {
			mNUMERICPATHNAME(false);
			if ( inputState.guessing==0 ) {
				_ttype = NUMERICPATHNAME;
			}
		}
		else {
			boolean synPredMatched270 = false;
			if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_3.member(LA(2))) && (_tokenSet_4.member(LA(3))))) {
				int _m270 = mark();
				synPredMatched270 = true;
				inputState.guessing++;
				try {
					{
					mNUMBER_LITERAL(false);
					mDOT(false);
					mNAME(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched270 = false;
				}
				rewind(_m270);
inputState.guessing--;
			}
			if ( synPredMatched270 ) {
				mOPERATION_EXPR(false);
				if ( inputState.guessing==0 ) {
					_ttype = OPERATION_EXPR;
				}
			}
			else {
				boolean synPredMatched272 = false;
				if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_3.member(LA(2))) && (_tokenSet_3.member(LA(3))))) {
					int _m272 = mark();
					synPredMatched272 = true;
					inputState.guessing++;
					try {
						{
						mNUMBER_LITERAL(false);
						mDOT(false);
						mNUMBER_LITERAL(false);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched272 = false;
					}
					rewind(_m272);
inputState.guessing--;
				}
				if ( synPredMatched272 ) {
					mREAL_LITERAL(false);
					if ( inputState.guessing==0 ) {
						_ttype = REAL_LITERAL;
					}
				}
				else {
					boolean synPredMatched274 = false;
					if ((((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true))) {
						int _m274 = mark();
						synPredMatched274 = true;
						inputState.guessing++;
						try {
							{
							mNUMBER_LITERAL(false);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched274 = false;
						}
						rewind(_m274);
inputState.guessing--;
					}
					if ( synPredMatched274 ) {
						mNUMBER_LITERAL(false);
						if ( inputState.guessing==0 ) {
							_ttype = NUMBER_LITERAL;
						}
					}
					else {
						throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
					}
					}}}
					if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
						_token = makeToken(_ttype);
						_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
					}
					_returnToken = _token;
				}
				
	public final void mSTRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STRING_LITERAL;
		
		
		match('\'');
		{
		_loop279:
		do {
			if ((LA(1)=='\\')) {
				mESC(false);
			}
			else if ((_tokenSet_5.member(LA(1)))) {
				{
				match(_tokenSet_5);
				}
			}
			else {
				break _loop279;
			}
			
		} while (true);
		}
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESC;
		
		
		match('\\');
		{
		switch ( LA(1)) {
		case 'n':
		{
			match('n');
			break;
		}
		case 'r':
		{
			match('r');
			break;
		}
		case 't':
		{
			match('t');
			break;
		}
		case 'b':
		{
			match('b');
			break;
		}
		case 'f':
		{
			match('f');
			break;
		}
		case '"':
		{
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			break;
		}
		case '\\':
		{
			match('\\');
			break;
		}
		case 'u':
		{
			{
			int _cnt283=0;
			_loop283:
			do {
				if ((LA(1)=='u')) {
					match('u');
				}
				else {
					if ( _cnt283>=1 ) { break _loop283; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt283++;
			} while (true);
			}
			mHEX_DIGIT(false);
			mHEX_DIGIT(false);
			mHEX_DIGIT(false);
			mHEX_DIGIT(false);
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		{
			matchRange('0','3');
			{
			if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\ufffe')) && (true)) {
				matchRange('0','7');
				{
				if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\ufffe')) && (true)) {
					matchRange('0','7');
				}
				else if (((LA(1) >= '\u0003' && LA(1) <= '\ufffe')) && (true) && (true)) {
					// empty block generated by ANTLR
				}
				else {
					throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '\ufffe')) && (true) && (true)) {
				// empty block generated by ANTLR
			}
			else {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			break;
		}
		case '4':  case '5':  case '6':  case '7':
		{
			matchRange('4','7');
			{
			if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\ufffe')) && (true)) {
				matchRange('0','7');
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '\ufffe')) && (true) && (true)) {
				// empty block generated by ANTLR
			}
			else {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mHEX_DIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEX_DIGIT;
		
		
		{
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			matchRange('0','9');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':
		{
			matchRange('A','F');
			break;
		}
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':
		{
			matchRange('a','f');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNONQUOTED_NAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NONQUOTED_NAME;
		
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		default:
			if (((LA(1) >= '\u00c0' && LA(1) <= '\ufffe'))) {
				matchRange('\u00c0','\ufffe');
			}
		else {
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop293:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			default:
				if (((LA(1) >= '\u00a0' && LA(1) <= '\ufffe'))) {
					matchRange('\u00a0','\ufffe');
				}
			else {
				break _loop293;
			}
			}
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mQUOTED_NAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUOTED_NAME;
		
		
		match('"');
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		default:
			if (((LA(1) >= '\u00c0' && LA(1) <= '\ufffe'))) {
				matchRange('\u00c0','\ufffe');
			}
		else {
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop298:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case ' ':
			{
				match(' ');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			case '\\':
			{
				{
				match('\\');
				match('"');
				}
				break;
			}
			default:
				if (((LA(1) >= '\u00a0' && LA(1) <= '\ufffe'))) {
					matchRange('\u00a0','\ufffe');
				}
			else {
				break _loop298;
			}
			}
		} while (true);
		}
		match('"');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNAMEORDOTTEDNAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NAMEORDOTTEDNAME;
		
		
		mNAME(false);
		{
		_loop301:
		do {
			if ((LA(1)=='.')) {
				mDOT(false);
				mNAME(false);
			}
			else {
				break _loop301;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mPATHNAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PATHNAME;
		
		
		mNAMEORDOTTEDNAME(false);
		{
		int _cnt305=0;
		_loop305:
		do {
			if ((LA(1)==':')) {
				mDOUBLECOLON(false);
				{
				if ((_tokenSet_0.member(LA(1)))) {
					mNAME(false);
				}
				else if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mNUMBER_LITERAL(false);
				}
				else {
					throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else {
				if ( _cnt305>=1 ) { break _loop305; } else {throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt305++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNAME_OR_PATHNAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NAME_OR_PATHNAME;
		
		
		boolean synPredMatched308 = false;
		if (((_tokenSet_0.member(LA(1))) && (_tokenSet_6.member(LA(2))) && (_tokenSet_7.member(LA(3))))) {
			int _m308 = mark();
			synPredMatched308 = true;
			inputState.guessing++;
			try {
				{
				mNAMEORDOTTEDNAME(false);
				mDOUBLECOLON(false);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched308 = false;
			}
			rewind(_m308);
inputState.guessing--;
		}
		if ( synPredMatched308 ) {
			mPATHNAME(false);
			if ( inputState.guessing==0 ) {
				_ttype = PATHNAME;
			}
		}
		else {
			boolean synPredMatched310 = false;
			if (((_tokenSet_0.member(LA(1))) && (true) && (true))) {
				int _m310 = mark();
				synPredMatched310 = true;
				inputState.guessing++;
				try {
					{
					mNAME(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched310 = false;
				}
				rewind(_m310);
inputState.guessing--;
			}
			if ( synPredMatched310 ) {
				mNAME(false);
				if ( inputState.guessing==0 ) {
					_ttype = NAME;
				}
			}
			else {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
		
		private static final long[] mk_tokenSet_0() {
			long[] data = new long[2048];
			data[0]=17179869184L;
			data[1]=576460745995190270L;
			for (int i = 3; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
		private static final long[] mk_tokenSet_1() {
			long[] data = new long[2048];
			data[0]=-9224L;
			for (int i = 1; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
		private static final long[] mk_tokenSet_2() {
			long[] data = new long[2048];
			data[1]=576460745995190270L;
			for (int i = 3; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
		private static final long[] mk_tokenSet_3() {
			long[] data = new long[1025];
			data[0]=288019269919178752L;
			return data;
		}
		public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
		private static final long[] mk_tokenSet_4() {
			long[] data = new long[2048];
			data[0]=288019287099047936L;
			data[1]=576460745995190270L;
			for (int i = 3; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
		private static final long[] mk_tokenSet_5() {
			long[] data = new long[2048];
			data[0]=-549755813896L;
			data[1]=-268435457L;
			for (int i = 2; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
		private static final long[] mk_tokenSet_6() {
			long[] data = new long[3072];
			data[0]=576249646070890496L;
			data[1]=576460745995190270L;
			data[2]=-4294967296L;
			for (int i = 3; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
		private static final long[] mk_tokenSet_7() {
			long[] data = new long[3072];
			data[0]=576249667545727488L;
			data[1]=576460746263625726L;
			data[2]=-4294967296L;
			for (int i = 3; i<=1022; i++) { data[i]=-1L; }
			data[1023]=9223372036854775807L;
			return data;
		}
		public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
		
		}
