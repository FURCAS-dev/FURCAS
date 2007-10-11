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
 *   E.D.Willink - Initial API and implementation
 *   IBM - Refactor severity and phase as types for localization
 *
 * </copyright>
 *
 * $Id: AbstractProblemHandler.java,v 1.1 2007/10/11 23:04:53 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import lpg.lpgjavaruntime.ParseErrorCodes;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * Partial implementation of the {@link ProblemHandler} API, useful for
 * subclasses to selectively override behaviour.
 */
// TODO: Why implement ParseErrorCodes?
public abstract class AbstractProblemHandler implements ProblemHandler, ParseErrorCodes
{
	private AbstractParser parser;
	private int errorReportLineOffset = 0;
	
	/**
	 * Initializes me with the parser that can supply line number locations for
	 * problems.
	 * 
	 * @param parser my parser
	 */
	protected AbstractProblemHandler(AbstractParser parser) {
		this.parser = parser;
	}

	/**
	 * The default implementation just prints the message using <code>System.out.println</code>.
	 * @param message the problem description
	 */
	protected void addProblem(String message) {
		System.out.println(message);		
	}

	public void analyzerProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		handleProblem(problemSeverity, Phase.ANALYZER, problemMessage,
				processingContext, startOffset, endOffset);
	}		
	
	/**
	 * This default implementation does nothing.
	 */
	public void beginParse() {
		// nothing to do
	}

	/**
	 * This default implementation does nothing.
	 */
	public void endParse() {
		// nothing to do		
	}
	
	/**
	 * This default implementation does nothing.
	 */
	public void beginValidation() {
		// nothing to do
	}
	
	/**
	 * This default implementation does nothing.
	 */
	public void endValidation() {
		// nothing to do
	}
	
	public void flush(Monitor monitor) {
		// nothing to do
	}
	
	public void setParser(AbstractParser parser) {
		this.parser = parser;
	}
	
	public AbstractParser getParser() {
		return parser;
	}

	/**
	 * Implements the interface, invoking <code>addProblem</code> with a line comprising
	 * <code>processingPhase-problemSeverity in processingContext; lineNumber : problemMessage</code>.
	 */
	public void handleProblem(Severity problemSeverity, Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		int lineNumber = parser.getTokenAtCharacter(startOffset).getLine();
		String message = OCLMessages.bind(
				OCLMessages.ProblemMessage_ERROR_,
				new Object[] {
					processingPhase != null ? processingPhase : "?", //$NON-NLS-1$
					problemSeverity != null ? problemSeverity : "?", //$NON-NLS-1$
					processingContext != null ? processingContext : "?", //$NON-NLS-1$
					lineNumber,
					problemMessage != null ? problemMessage : "?"}); //$NON-NLS-1$
		addProblem(message);
	}

	public void lexerProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		handleProblem(problemSeverity, Phase.LEXER, problemMessage,
				processingContext, startOffset, endOffset);
	}		

	public void parserProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		handleProblem(problemSeverity, Phase.PARSER, problemMessage,
				processingContext, startOffset, endOffset);
	}		

	public void utilityProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		handleProblem(problemSeverity, Phase.UTILITY, problemMessage,
				processingContext, startOffset, endOffset);
	}		

	public void validatorProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		handleProblem(problemSeverity, Phase.VALIDATOR, problemMessage,
				processingContext, startOffset, endOffset);
	}		

	public void setErrorReportLineOffset(int offset) {
		errorReportLineOffset = offset;
	}
	
	public int getErrorReportLineOffset() {
		return errorReportLineOffset;
	}
}
