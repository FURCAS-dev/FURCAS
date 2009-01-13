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
 * $Id: AbstractParser.java,v 1.4 2009/01/13 19:44:29 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import java.util.ArrayList;

import lpg.lpgjavaruntime.ErrorToken;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.ParseErrorCodes;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.Token;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.internal.l10n.OCLMessages;
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
		return (AbstractLexer) super.getLexStream();
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
		Token token = new ErrorToken(getIToken(firsttok), getIToken(lasttok),
			getIToken(errortok), getStartOffset(firsttok),
			getEndOffset(lasttok), kind) {

			@Override
			public String toString() {
				if (getPrsStream() == null) {
					return "<toString>"; //$NON-NLS-1$
				}
				int startOffset = getStartOffset();
				int length = getEndOffset() - startOffset;
				if (length < 0) {
					length = -length - 1;
					startOffset = getEndOffset();
				}
				if ((startOffset + length) > getPrsStream().getInputChars().length) {
					return String.valueOf(IToken.EOF);
				}
				return new String(getPrsStream().getInputChars(), startOffset,
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

	@Override
	public void reportError(int errorCode, String locationInfo, int leftToken,
			int rightToken, String tokenText) {
		BasicEnvironment environment = getEnvironment();
		if (environment == null) {
			super.reportError(errorCode, locationInfo, leftToken, rightToken,
				tokenText);
		} else {
			if (errorCode == DELETION_CODE || errorCode == MISPLACED_CODE) {
				tokenText = ""; //$NON-NLS-1$
			}
			environment
				.parserError(errorCode, leftToken, rightToken, tokenText);
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
			String location = super.getFileName() + ':'
				+ super.getEndLine(lasttok) + ':' + super.getEndColumn(lasttok)
				+ ": "; //$NON-NLS-1$
			reportError(ParseErrorCodes.INSERTION_CODE, location, lasttok,
				lasttok, msg);
		} else {
			String location = super.getFileName() + ':'
				+ super.getLine(error_token) + ':'
				+ super.getColumn(error_token) + ':'
				+ super.getEndLine(error_token) + ':'
				+ super.getEndColumn(error_token) + ": "; //$NON-NLS-1$
			reportError(ParseErrorCodes.SUBSTITUTION_CODE, location, firsttok,
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
	 */
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
}
