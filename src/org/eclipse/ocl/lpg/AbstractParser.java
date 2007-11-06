/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLLPGParser
 *
 * </copyright>
 *
 * $Id: AbstractParser.java,v 1.2 2007/11/06 19:49:00 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.options.ProblemOption;

/**
 * The <code>AbstractParser</code> supports syntactic analysis of a tokens produced by
 * an <code>AbstractLexer</code> to create a corresponding CST, that may in turn be
 * exploited by an <code>AbstractAnalyzer</code> to create an AST.
 * 
 * Derived classes should extend the abstract support for AST from CST from tokens from text
 * parsing and analysis to support the AST and CST classes appropriate to a particular language.
 */
public abstract class AbstractParser extends PrsStream
{
	private final BasicEnvironment environment;

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
	 * Returns a single line string representation of the input chars
	 * for the given range.
	 * 
	 * @param left left most char index
	 * @param right right most char index
	 * @return a single line string representation of the input chars
	 */
	public String computeInputString(int left, int right) {
		StringBuffer result = new StringBuffer(right - left + 1);
		char[] chars = getInputChars();
		if (chars.length > 0) {
			for (int i = left; i <= right; i++) {
				if (chars[i] == '\t') {
					result.append(' ');
				} else if (chars[i] == '\n' || chars[i] == '\r' || chars[i] == '\f') {
					if (i > 0) {
						if (!Character.isWhitespace(chars[i-1])) {
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
	
//	@Override public AbstractLexer getLexStream() {
//		return getLexer();
//	}
	
	public AbstractLexer getLexer() {
		return (AbstractLexer) super.getLexStream();
	}

	public CSTNode parseTokensToCST() {
		return parseTokensToCST(null, 0);
	}
	
	public abstract CSTNode parseTokensToCST(Monitor monitor, int error_repair_count);

	@Override
	public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
		BasicEnvironment environment = getEnvironment();
		if (environment == null) {
            super.reportError(errorCode, locationInfo, leftToken, rightToken, tokenText);
        } else {
			if (errorCode == DELETION_CODE ||
	            errorCode == MISPLACED_CODE) {
                tokenText = ""; //$NON-NLS-1$
            }
			environment.parserError(errorCode, leftToken, rightToken, tokenText);
		}
	}

	@Override public void resetLexStream(LexStream lexStream) {
		setLexStream((AbstractLexer)lexStream);
	}

	public void setLexStream(AbstractLexer lexStream) {
		super.resetLexStream(lexStream);
	}
	
	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>IToken</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, IToken startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>CSTNode</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the 3rd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the given <code>IToken</code> and the
	 * end offset of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 1std given <code>IToken</code> and the
	 * end offset of the 2nd given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Removes the "s surrounding a quoted string, if any.
	 * 
	 * @param quoted a possibly quoted string
	 * @return <code>quoted</code> without the surrounding quotes, or just
	 *	 <code>quoted</code> verbatim if there were none
	 */
	protected String unquote(String quoted) {
		String result = quoted;
	
		if ((result != null) && (result.length() > 1)) {
			int max = result.length() - 1;
	
			if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
				result = result.substring(1, max);
			}
			
			// this is a regexp, so the backslash needs to be
			//   re-escaped, thus "\\" is rendered in a Java
			//   string literal as "\\\\"
			result = result.replaceAll("\\\\\"", "\"");  //$NON-NLS-2$//$NON-NLS-1$
			
			if (!result.equals(quoted)) {
				// check settings for using non-standard closure iterator
				ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
				BasicEnvironment benv = getEnvironment();
				
				if (benv != null) {
					sev = benv.getValue(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE);
				}
				if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
					benv.problem(
						sev, ProblemHandler.Phase.PARSER,
						OCLMessages.bind(OCLMessages.NonStd_DQuote_Escape_, quoted),
						"unquote", //$NON-NLS-1$
						null);
				}
			}
		}
	
		return result;
	}
}
