/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLLPGParser
 *             - Bugs 243976, 259818
 *   Zeligsoft - Bug 243976
 *   
 * </copyright>
 *
 * $Id: AbstractParser.java,v 1.7 2009/12/27 15:49:50 asanchez Exp $
 */
package org.eclipse.ocl.lpg;

import java.text.StringCharacterIterator;
import java.util.ArrayList;

import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;
import lpg.runtime.LexStream;
import lpg.runtime.Monitor;
import lpg.runtime.ParseErrorCodes;
import lpg.runtime.PrsStream;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;

/**
 * The <code>AbstractParser</code> supports syntactic analysis of a tokens
 * produced by an <code>AbstractLexer</code> to create a corresponding CST, that
 * may in turn be exploited by an <code>AbstractAnalyzer</code> to create an
 * AST.
 * 
 * Derived classes should extend the abstract support for AST from CST from
 * tokens from text parsing and analysis to support the AST and CST classes
 * appropriate to a particular language.
 */
public abstract class AbstractParser
		extends PrsStream {

	private final BasicEnvironment environment;

	private int defaultRepairCount = 0;

	public AbstractParser(BasicEnvironment environment) {
		this.environment = environment;
		environment.setParser(this);
	}

	public AbstractParser(AbstractLexer lexer) {
		super(lexer);
		this.environment = lexer.getEnvironment();
		environment.setParser(this);
	}

	/**
	 * Returns a single line string representation of the input chars for the
	 * given range.
	 * 
	 * @param left
	 *            left most char index
	 * @param right
	 *            right most char index
	 * @return a single line string representation of the input chars
	 */
	public String computeInputString(int left, int right) {
		StringBuffer result = new StringBuffer(right - left + 1);
		char[] chars = getInputChars();
		if (chars.length > 0) {
			for (int i = left; i <= right; i++) {
				if (chars[i] == '\t') {
					result.append(' ');
				} else if (chars[i] == '\n' || chars[i] == '\r'
					|| chars[i] == '\f') {
					if (i > 0) {
						if (!Character.isWhitespace(chars[i - 1])) {
							result.append(' ');
						}
					}
				} else {
					result.append(chars[i]);
				}

			}
		}
		return result.toString();
	}

	public BasicEnvironment getEnvironment() {
		return environment;
	}

	/**
	 * This function returns the index of the token element containing the
	 * offset specified. If such a token does not exist, it returns the negation
	 * of the index of the element immediately preceding the offset.
	 * 
	 * @since 1.3
	 */
	public ErrorToken getErrorTokenAtCharacter(int offset) {
		ErrorToken bestToken = null;
		for (int i = getSize(); --i >= 0;) {
			IToken token = getTokenAt(i);
			if (!(token instanceof ErrorToken)) {
				break;
			}
			IToken errorToken = ((ErrorToken) token).getErrorToken();
			if (offset >= errorToken.getStartOffset()
				&& offset <= errorToken.getEndOffset()) {
				if ((bestToken == null)
					|| ((bestToken.getStartOffset() <= errorToken
						.getStartOffset()) && (token.getEndOffset() <= errorToken
						.getEndOffset()))) {
					bestToken = (ErrorToken) token;
				}
			}
		}
		return bestToken;
	}

	/**
	 * @since 1.3
	 */
	public int getDefaultRepairCount() {
		return defaultRepairCount;
	}

	/**
	 * @since 1.3
	 */
	public int getErrorTokens() {
		return getTokens().size() - getStreamLength();
	}

	public AbstractLexer getLexer() {
		return (AbstractLexer) super.getILexStream();
	}

	/**
	 * Overridden to search only the non-Error nodes, which are the only tokens
	 * in monotonic order.
	 */
	@Override
	public int getTokenIndexAtCharacter(int offset) {
		int low = 0;
		int high = getSize();
		while (high > low) {
			IToken highToken = getTokenAt(high - 1);
			if (!(highToken instanceof ErrorToken)) {
				break;
			}
			high--;
		}
		while (high > low) {
			int mid = (high + low) / 2;
			IToken mid_element = getTokenAt(mid);
			if (offset >= mid_element.getStartOffset()
				&& offset <= mid_element.getEndOffset()) {
				return mid;
			} else if (offset < mid_element.getStartOffset()) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return -(low - 1);
	}

	@Override
	public int makeErrorToken(int firsttok, int lasttok, int errortok, int kind) {
		@SuppressWarnings("unchecked")
		ArrayList<IToken> tokens = getTokens();
		int index = tokens.size(); // the next index

		//
		// Note that when creating an error token, we do not remap its kind.
		// Since this is not a lexical operation, it is the responsibility of
		// the calling program (a parser driver) to pass to us the proper kind
		// that it wants for an error token.
		//
		IToken token = new ErrorToken(getIToken(firsttok), getIToken(lasttok),
			getIToken(errortok), getStartOffset(firsttok),
			getEndOffset(lasttok), kind) {

			@Override
			public String toString() {
				if (getIPrsStream() == null) {
					return "<toString>"; //$NON-NLS-1$
				}
				int startOffset = getStartOffset();
				int length = getEndOffset() + 1 - startOffset;
				if (length < 0) {
					length = -length - 1;
					startOffset = getEndOffset();
				}
				if ((startOffset + length) > getIPrsStream().getInputChars().length) {
					return String.valueOf(IToken.EOF);
				}
				return new String(getIPrsStream().getInputChars(), startOffset,
					length);
			}

		};
		token.setTokenIndex(index);
		tokens.add(token);
		token.setAdjunctIndex(getAdjuncts().size());
		return index;
	}

	public CSTNode parseTokensToCST() {
		return parseTokensToCST(null, defaultRepairCount);
	}

	public abstract CSTNode parseTokensToCST(Monitor monitor,
			int error_repair_count);

	/**
	 * 
	 * @since 3.0
	 */
	@Override 
	public void reportError(int errorCode, int leftToken, int errorToken, 
			int rightToken, String[] errorInfo) { 
		BasicEnvironment environment = getEnvironment(); 
		if (environment == null) { 
			super.reportError(errorCode, leftToken, errorToken, rightToken, errorInfo); 
		} else {			 
			// TODO Revise this. BasicEnvironment.parserError doesn't have a String[] argument
			String tokenText = errorInfo.length > 0 ? errorInfo[0] : ""; //$NON-NLS-1$
			if (errorCode == PrsStream.DELETION_CODE || errorCode == PrsStream.MISPLACED_CODE) {  
				tokenText = ""; //$NON-NLS-1$  
			}  
			environment.parserError(errorCode, leftToken, rightToken, tokenText); 
		} 
	}

	/**
	 * Report error message for given error_token.
	 * 
	 * @param error_token
	 *            the error taken index
	 * @param msg
	 *            the message to report
	 * 
	 * @since 1.3
	 */
	public final void reportErrorTokenMessage(int error_token, String msg) {
		int firsttok = super.getFirstRealToken(error_token);
		int lasttok = super.getLastRealToken(error_token);
		if (firsttok > lasttok) {
			reportError(ParseErrorCodes.INSERTION_CODE, lasttok,
				lasttok, msg);
		} else {
			reportError(ParseErrorCodes.SUBSTITUTION_CODE, firsttok,
				lasttok, msg);
		}
	}

	@Override
	public void resetLexStream(LexStream lexStream) {
		setLexStream((AbstractLexer) lexStream);
	}

	/**
	 * Sets the number of repairs to be performed by a parser capable of
	 * performing repairs (the BacktrackingParser) unless overridden on the
	 * specific parser invocation method.
	 * 
	 * @param defaultRepairCount
	 *            the default repair count
	 * 
	 * @throws IllegalArgumentException
	 *             if the <tt>defaultRepairCount</tt> is negative
	 * 
	 * @since 1.3
	 */
	public void setDefaultRepairCount(int defaultRepairCount) {
		if (defaultRepairCount < 0) {
			throw new IllegalArgumentException("negative default repair count"); //$NON-NLS-1$
		}

		this.defaultRepairCount = defaultRepairCount;
	}

	public void setLexStream(AbstractLexer lexStream) {
		super.resetLexStream(lexStream);
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start and end offsets of the given <code>IToken</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param startEnd
	 *            <code>IToken</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, IToken startEnd) {
		cstNode.setStartToken(startEnd);
		cstNode.setEndToken(startEnd);
		int startOffset = startEnd.getStartOffset();
		int endOffset = startEnd.getEndOffset();
		if (endOffset < startOffset) {
			cstNode.setStartOffset(endOffset);
			cstNode.setEndOffset(startOffset);
		} else {
			cstNode.setStartOffset(startOffset);
			cstNode.setEndOffset(endOffset);
		}
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start and end offsets of the 2nd given <code>CSTNode</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param startEnd
	 *            <code>CSTNode</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		cstNode.setStartToken(startEnd.getStartToken());
		cstNode.setEndToken(startEnd.getEndToken());
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the 2nd given <code>CSTNode</code> and the end offset of
	 * the 3rd given <code>CSTNode</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>CSTNode</code> to retrieve start offset from
	 * @param end
	 *            <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		cstNode.setStartToken(start.getStartToken());
		cstNode.setEndToken(end.getEndToken());
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the 2nd given <code>CSTNode</code> and the end offset of
	 * the given <code>IToken</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>CSTNode</code> to retrieve start offset from
	 * @param end
	 *            <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		cstNode.setStartToken(start.getStartToken());
		cstNode.setEndToken(end);
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the given <code>IToken</code> and the end offset of the
	 * 2nd given <code>CSTNode</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>IToken</code> to retrieve start offset from
	 * @param end
	 *            <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		cstNode.setStartToken(start);
		cstNode.setEndToken(end.getEndToken());
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the 1std given <code>IToken</code> and the end offset of
	 * the 2nd given <code>IToken</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>IToken</code> to retrieve start offset from
	 * @param end
	 *            <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		cstNode.setStartToken(start);
		cstNode.setEndToken(end);
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}
	
	/**
	 * Removes the "s surrounding a quoted string, if any.
	 * 
	 * @param quoted
	 *            a possibly quoted string
	 * @return <code>quoted</code> without the surrounding quotes, or just
	 *         <code>quoted</code> verbatim if there were none
	 *         
	 * @deprecated Use unDoubleQuote 
	 */
	@Deprecated
	protected String unquote(String quoted) {
		String result = quoted;

		if ((result != null) && (result.length() > 1)) {
			int max = result.length() - 1;

			if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
				result = result.substring(1, max);
			}

			// this is a regexp, so the backslash needs to be
			// re-escaped, thus "\\" is rendered in a Java
			// string literal as "\\\\"
			result = result.replaceAll("\\\\\"", "\""); //$NON-NLS-2$//$NON-NLS-1$

			if (!result.equals(quoted)) {
				// check settings for using non-standard closure iterator
				ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
				BasicEnvironment benv = getEnvironment();

				if (benv != null) {
					sev = benv
						.getValue(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE);
				}
				if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
					benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
						.bind(OCLMessages.NonStd_DQuote_Escape_, quoted),
						"unquote", //$NON-NLS-1$
						null);
				}
			}
		}

		return result;
	}
	
	/**
	 * Removes any "s surrounding a quoted string and decodes any escape sequences
	 * within it using {@link #decodeEscapeSequence}.
	 *<p>
	 * For MDT/OCL 1.3.0 compatibility, a problem is reported if double
	 * quotes are present and the {@link #ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE}
	 * severity is not {@link #ProblemHandler.Severity.OK}.
	 * 
	 * @param token containing string to be decoded
	 * @return string value of <code>token</code> with escapes replaced
	 * @since 3.0
	 */
	protected String unDoubleQuote(IToken token) {
		if (token == null) {
			return null;
		}
		String quoted = token.toString();
		if (quoted == null) {
			return null;
		}
		int quotedLength = quoted.length();
		if ((quotedLength < 2) || (quoted.charAt(0) != '"') || (quoted.charAt(quotedLength-1) != '"')) {
			return quoted;
		}
		ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
		BasicEnvironment benv = getEnvironment();

		if (benv != null) {
			sev = benv
				.getValue(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE);
		}
		if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
			benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
				.bind(OCLMessages.NonStd_DQuote_Escape_, quoted),
				"unquote", //$NON-NLS-1$
				token);
		}
		return decodeString(token, quoted.substring(1, quotedLength-1));
	}
	
	/**
	 * Removes any 's surrounding a quoted string and decodes any escape sequences
	 * within it using {@link #decodeEscapeSequence}.
	 *<p>
	 * For MDT/OCL 1.3.0 compatibility, escape sequences are only converted
	 * if the {@link #ParsingOption.USE_BACKSLASH_ESCAPE_PROCESSING} is set.
	 * 
	 * @param token containing string to be decoded
	 * @return string value of <code>token</code> with escapes replaced
	 * @since 3.0
	 */
	protected String unSingleQuote(IToken token) {
		if (token == null) {
			return null;
		}
		String quoted = token.toString();
		if (quoted == null) {
			return null;
		}
		int quotedLength = quoted.length();
		if ((quotedLength < 2) || (quoted.charAt(0) != '\'') || (quoted.charAt(quotedLength-1) != '\'')) {
			return quoted;
		}
		String unquoted = quoted.substring(1, quotedLength-1);
		Boolean backslashProcessingEnabled = null;
		BasicEnvironment benv = getEnvironment();
		if (benv != null) {
			backslashProcessingEnabled = benv
				.getValue(ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		}
		if ((backslashProcessingEnabled == null) || !backslashProcessingEnabled) {
			return unquoted;
		}
		return decodeString(token, unquoted);
	}

	/**
	 * Returns a string with any escape sequences decoded by {@link #decodeEscapeSequence}.
	 * 
	 * @param token the token from which the string originated
	 * @param string to be decoded
	 * @return <code>string</code> without any escapes replaced
	 * @since 3.0
	 */
	protected String decodeString(IToken token, String string) {
		if (string.indexOf('\\') < 0) {
			return string;			
		}
		StringBuffer s = new StringBuffer();
		StringCharacterIterator i = new StringCharacterIterator(string);
		for (char c = i.first(); c != StringCharacterIterator.DONE; c = i.next()) {
			if (c != '\\') {
				s.append(c);
			}
			else {
				int iStart = i.getIndex();
				char ch = decodeEscapeSequence(i);
				if (ch != StringCharacterIterator.DONE) {
					s.append(ch);
				}
				else {
					BasicEnvironment benv = getEnvironment();
					benv.problem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.PARSER, OCLMessages
						.bind(OCLMessages.InvalidEscapeSequence_ERROR, string.substring(iStart, i.getIndex())),
						"unquote", //$NON-NLS-1$
						token);
					return string;
				}
			}
		}
		return s.toString();
	}

	/**
	 * Decodes an escape sequence in accordance with the Issue 14357
	 * proposals for Concrete Syntaxes. For compatibility octal escape sequences
	 * are also supported.
	 *  <p>
	 *  <table border="0" align="left">
	 *  <tr><td><b><tt>\b</tt></b></td> <td><tt>\u0008</tt>: backspace <tt>BS</tt></td></tr>
	 *  <tr><td><b><tt>\t</tt></b></td> <td><tt>\u0009</tt>: horizontal tab <tt>HT</tt></td></tr>
	 *  <tr><td><b><tt>\n</tt></b></td> <td><tt>\u000a</tt>: line feed <tt>LF</tt></td></tr>
	 *  <tr><td><b><tt>\f</tt></b></td> <td><tt>\u000c</tt>: form feed <tt>FF</tt></td></tr> 
	 *  <tr><td><b><tt>\r</tt></b></td> <td><tt>\u000d</tt>: carriage return <tt>CR</tt></td></tr>
	 *  <tr><td><b><tt>\"</tt></b></td> <td><tt>\u0022</tt>: double quote <tt>"</tt></td></tr>
	 *  <tr><td><b><tt>\'</tt></b></td> <td><tt>\u0027</tt>: single quote <tt>'</tt></td></tr>
	 *  <tr><td><b><tt>\\</tt></b></td> <td><tt>\u005c</tt>: backslash <tt>\</tt></td></tr>
	 *  <tr><td><b><tt>\x<i>hh</i></tt></b></td> <td><tt>\</tt><tt>u00<i>hh</i></tt>: hex byte</td></tr>
	 *  <tr><td><b><tt>\</tt><tt>u<i>hhhh</i></tt></b></td> <td><tt>\</tt><tt>u<i>hhhh</i></tt>: hex code point</td></tr>
	 *  <tr><td><b><tt>\<i>7$</i></tt></b></td> <td><tt>\</tt><tt>u000<i>o</i></tt>: octal byte</td></tr>
	 *  <tr><td><b><tt>\<i>77</i></tt></b></td> <td><tt>\</tt><tt>u00<i>ff</i></tt>: octal byte</td></tr>
	 *  <tr><td><b><tt>\<i>37$</i></tt></b></td> <td><tt>\</tt><tt>u00<i>ff</i></tt>: octal byte</td></tr>
	 *  <tr><td><b><tt>\<i>377</i></tt></b></td> <td><tt>\</tt><tt>u00<i>ff</i></tt>: octal byte</td></tr>
	 *  <tr><td></td> <td></td></tr>
	 *  <tr><td><b><tt><i>h</i></tt></b></td> <td>hex digit (0-9, a-f, A-F)</td></tr>
	 *  <tr><td><b><tt><i>7</i></tt></b></td> <td>octal digit (0-7)</td></tr>
	 *  <tr><td><b><tt><i>3</i></tt></b></td> <td>octal prefix digit (0-3)</td></tr>
	 *  <tr><td><b><tt><i>$</i></tt></b></td> <td>end of string or non-octal digit next letter</td></tr>
	 *  </table>
	 *  <p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	 *  <p>
	 * @param i character iterator pointing at first character after the introducer
	 * 
	 * @return the decoded character and i updated to point to the first character following the
	 * escape sequence, or DONE and i unchanged if the escape sequence is unrecognised
	 * @since 3.0
	 */
	protected char decodeEscapeSequence(StringCharacterIterator i) {
		int savedIndex = i.getIndex();
		char c = i.next();
		switch (c) {
			case 'b' : return '\b';
			case 'f' : return '\f';
			case 't' : return '\t';
			case 'n' : return '\n';
			case 'r' : return '\r';
			case '\\' : return '\\';
			case '\'' : return '\'';
			case '"' : return '\"';
			case '0' :
			case '1' :
			case '2' :
			case '3' : {
				int c1 = c - '0';
				int c2 = decodeOctalCharacter(i);
				if (c2 < 0) {
					return (char)(c1);					
				}
				int c3 = decodeOctalCharacter(i);
				if (c3 < 0) {
					return (char)((c1 << 3) + c2);
				}
				return (char)((c1 << 6) + (c2 << 3) + c3);
			}
			case '4' :
			case '5' :
			case '6' :
			case '7' : {
				int c1 = c - '0';
				int c2 = decodeOctalCharacter(i);
				if (c2 < 0) {
					i.previous();
					return (char)(c1);					
				}
				return (char)((c1 << 3) + c2);
			}
			case 'x' : {
				int c1 = decodeHexCharacter(i.next());
				int c2 = decodeHexCharacter(i.next());
				if ((c1 < 0) || (c2 < 0)) {
					break;
				}
				return (char)((c1 << 4) + c2);
			}
			case 'u' : {
				int c1 = decodeHexCharacter(i.next());
				int c2 = decodeHexCharacter(i.next());
				int c3 = decodeHexCharacter(i.next());
				int c4 = decodeHexCharacter(i.next());
				if ((c1 < 0) || (c2 < 0) || (c3 < 0) || (c4 < 0)) {
					break;
				}
				return (char)((c1 << 12) + (c2 << 8) + (c3 << 4) + c4);
			}
		}
		i.setIndex(savedIndex);		// Give derived augmentations the same starting point
		return StringCharacterIterator.DONE;
	}

	/**
	 * Return the value of the next character if it is a hexadecimal character.
	 * 
	 * @param c potentially hex character
	 * @return the hex value or -1 if the next character is not a hex character
	 * @since 3.0
	 */
	protected int decodeHexCharacter(char c) {
		if (('0' <= c) && (c <= '9')) {
			return c - '0';
		}
		if (('A' <= c) && (c <= 'F')) {
			return 10 + c - 'A';
		}
		if (('a' <= c) && (c <= 'f')) {
			return 10 + c - 'a';
		}
		return -1;
	}

	/**
	 * Return the value of the next character if it is an octal character.
	 * 
	 * @param c potentially octal character
	 * @return the hex value or -1 if the next character is not a octal character
	 * @since 3.0
	 */
	protected int decodeOctalCharacter(StringCharacterIterator i) {
		char c = i.next();
		if (c == StringCharacterIterator.DONE) {
			return -1;					
		}
		if (('0' <= c) && (c <= '7')) {
			return c - '0';
		}
		i.previous();
		return -1;
	}
}
