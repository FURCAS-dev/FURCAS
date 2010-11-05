/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLLPGParser
 *             - Bugs 243976, 295166, 259818
 *   Zeligsoft - Bug 243976
 *   
 * </copyright>
 *
 * $Id: AbstractParser.java,v 1.12 2010/05/03 09:32:32 ewillink Exp $
 */
package org.eclipse.ocl.lpg;

import java.text.StringCharacterIterator;

import lpg.runtime.ErrorToken;
import lpg.runtime.ILexStream;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;
import lpg.runtime.LexStream;
import lpg.runtime.Monitor;
import lpg.runtime.ParseTable;

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
public abstract class AbstractParser {

	private final BasicEnvironment environment;

	private int defaultRepairCount = 0;

	private AbstractLexer lexer;

	public AbstractParser(BasicEnvironment environment) {
		this.environment = environment;
		environment.setParser(this);
	}

	public AbstractParser(AbstractLexer lexer) {
		this.lexer = lexer;
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
		char[] chars = getIPrsStream().getInputChars();
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
	 * @since 1.3
	 */
	public int getDefaultRepairCount() {
		return defaultRepairCount;
	}

	public AbstractLexer getLexer() {
		return lexer;
	}

	/**
	 * @deprecated clients should invoke {@link #parser()}
	 */
	@Deprecated
	public CSTNode parseTokensToCST() {
		return parser(null, defaultRepairCount);
	}
	
	/**
	 * @param lexStream
     * @deprecated To set/reset the lex stream use {@link #reset(ILexStream)}
	 */	
	@Deprecated
	public void resetLexStream(LexStream lexStream) {
		getIPrsStream().resetLexStream(lexStream);
	}


	
	/**
	 * Sets the number of repairs to be performed by a parser capable of
	 * performing repairs (the BacktrackingParser) unless overridden on the
	 * specific parser invocation method.
	 * 
     * When repair count is 0, no Error token recoveries occur.
     * When repair count is > 0, it limits the number of Error token recoveries.
     * When repair count is < 0, the number of error token recoveries is unlimited.
     * 
	 * @param defaultRepairCount
	 *            the default repair count
	 * 
	 * @since 1.3
	 */
	public void setDefaultRepairCount(int defaultRepairCount) {
		this.defaultRepairCount = defaultRepairCount;
	}
	
	/**
     * 
	 * @param lexer
     * @deprecated To set/reset the lex stream use {@link #reset(ILexStream)}
	 */
	@Deprecated
	public void setLexStream(AbstractLexer lexer) {
		this.lexer = lexer;
		getIPrsStream().resetLexStream(lexer.getILexStream());
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
     * <p>
     * Initializes a concrete-syntax node's start and end offsets from the
     * current token in the parser stream.
     * <p>
     * 
     * <p>
     * <b>Note:</b> this method resided in the OCLEssential.g template since 1.2 
     * It has been incorporated in the abstract parser since 3.0
     * </p>
     * 
     * @param cstNode a concrete-syntax node
     * 
     * @since 3.0
     */
	protected void setOffsets(CSTNode cstNode) {
		IToken firstToken = getRhsIToken(1);
		cstNode.setStartToken(firstToken);
		cstNode.setEndToken(firstToken);
		cstNode.setStartOffset(firstToken.getStartOffset());
		cstNode.setEndOffset(firstToken.getEndOffset()-1);
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
					if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
						benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
							.bind(OCLMessages.NonStd_DQuote_Escape_, quoted),
							"unquote", //$NON-NLS-1$
							null);
					}
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
	 * @deprecated double quotes form no part of the OCL specification
	 */
	@Deprecated
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
			if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
				benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
					.bind(OCLMessages.NonStd_DQuote_Escape_, quoted),
					"unquote", //$NON-NLS-1$
					token);
			}
		}
		return decodeString(token, quoted.substring(1, quotedLength-1));
	}
	
	/**
	 * Removes any quotes surrounding the string value of a token
	 * using {@link #unSingleQuote(String,int)} and optionally decode any
	 * escape sequences within it using {@link #decodeEscapeSequence}.
	 *<p>
	 * For MDT/OCL 1.3.0 compatibility, escape sequences conversion can be disabled
	 * by resetting {@link #ParsingOption.USE_BACKSLASH_ESCAPE_PROCESSING}.
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
		String unquoted = unSingleQuote(quoted);
		if (unquoted == null) {
			return quoted;
		}
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
	 * Removes any quotes surrounding a quoted string.
	 *<p>
	 * The default implementation removes a leading/trailing single quote pair,
	 * or an underscore-prefixed leading/trailing single quote pair.
	 * 
	 * @param quoted string to be decoded
	 * @return string content
	 * @since 3.0
	 */
	protected String unSingleQuote(String quoted) {
		int quotedLength = quoted.length();
		if ((quotedLength >= 2) && (quoted.charAt(0) == '\'') && (quoted.charAt(quotedLength-1) == '\'')) {
			return quoted.substring(1, quotedLength-1);
		}
		else if ((quotedLength >= 3) && (quoted.charAt(0) == '_') && (quoted.charAt(1) == '\'') && (quoted.charAt(quotedLength-1) == '\'')) {
			return quoted.substring(2, quotedLength-1);
		}
		else {
			return null;
		}
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
	
	// Some useful methods which will be implemented in the generated Parser
	abstract public String[] orderedTerminalSymbols();
	
	/**
	 * @return the number of different parser tokens
	 * 
	 * @since 3.0
	 */
	abstract public int numTokenKinds();
	
	/**
	 * @return the parser's {@link IPrsStream parseStream}
	 * 
	 * @since 3.0
	 */
	abstract public DerivedPrsStream getIPrsStream();
	
	/**
	 * Resets the parser's {@link ILexStream lexStream}
	 * @param lexStream
	 * 
	 * @since 3.0
	 */
	abstract public void reset(ILexStream lexStream);

	/**
	 * Runs the parser with the current  {@link ILexStream lex} and {@link IPrsStream parse} streams
	 * 
	 * @return the root {@link CSTNode} which results from the parsing process  
	 * @since 3.0
	 */
	abstract public CSTNode parser();
        
	/**
	 * Runs the parser with the current  {@link ILexStream lex} and {@link IPrsStream parse} streams
	 * using the given {@link Monitor}
	 * 
	 * @return the root {@link CSTNode} which results from the parsing process  
	 * @since 3.0
	 */
	abstract public CSTNode parser(Monitor monitor);
        
	/**
	 * Runs the parser with the current  {@link ILexStream lex} and {@link IPrsStream parse} streams
	 * using a given error_repair_count (useful for a backtracking parser) 
	 * 
	 * @return the root {@link CSTNode} which results from the parsing process  
	 * @since 3.0
	 */
	abstract public CSTNode parser(int error_repair_count);
        
	/**
	 * Runs the parser with the current  {@link ILexStream lex} and {@link IPrsStream parse} streams
	 * using the given {@link Monitor} and error_repair_count (useful for a backtracking parser) 
	 * 
	 * @return the root {@link CSTNode} which results from the parsing process  
	 * @since 3.0
	 */
	abstract public CSTNode parser(Monitor monitor, int error_repair_count);
	
	/**
	 * @return the {@link ParseTable} used by the parser
	 * @since 3.0
	 */
	abstract public ParseTable getParseTable();
	
	/**
	 * @since 3.0
	 */
	abstract protected Object getRhsSym(int i);

	/**
	 * @since 3.0
	 */
	abstract protected int getRhsTokenIndex(int i);
	
	/**
	 * @since 3.0
	 */
	abstract protected IToken getRhsIToken(int i);
    
	/**
	 * @since 3.0
	 */
	abstract protected int getRhsFirstTokenIndex(int i);
	
	/**
	 * @since 3.0
	 */
	abstract protected IToken getRhsFirstIToken(int i);

	/**
	 * @since 3.0
	 */
	abstract protected int getRhsLastTokenIndex(int i);
	
	/**
	 * @since 3.0
	 */
	abstract protected IToken getRhsLastIToken(int i);

	/**
	 * @since 3.0
	 */
	abstract protected int getLeftSpan();
	
	/**
	 * @since 3.0
	 */
	abstract protected IToken getLeftIToken();

	/**
	 * @since 3.0
	 */
	abstract protected int getRightSpan();
	
	/**
	 * @since 3.0
	 */
	abstract protected IToken getRightIToken();

	/**
	 * @since 3.0
	 */
	abstract protected int getRhsErrorTokenIndex(int i);
	
	/**
	 * @since 3.0
	 */
	abstract protected ErrorToken getRhsErrorIToken(int i);
    
    /**
     * @since 3.0
	 */
	abstract protected void setResult(Object object);
}
