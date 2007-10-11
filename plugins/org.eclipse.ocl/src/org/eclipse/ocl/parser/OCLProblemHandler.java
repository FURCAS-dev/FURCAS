/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: OCLProblemHandler.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
 */
package org.eclipse.ocl.parser;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.AbstractProblemHandler;

/**
 * The <code>OCLProblemHandler</code> accumulates a {@link DiagnosticChain} of
 * problems.
 */
public class OCLProblemHandler extends AbstractProblemHandler {

	private DiagnosticChain diagnostics;
	
	public OCLProblemHandler(AbstractParser parser) {
		super(parser);
	}

	@Override
	public void handleProblem(Severity problemSeverity, Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		BasicDiagnostic diagnostic = new BasicDiagnostic(
			problemSeverity.getDiagnosticSeverity(),
			OCLPlugin.getPluginId(),
			1,
			problemMessage,
			new Object[] {processingPhase, processingContext});
		
		if (diagnostics == null) {
			diagnostics = diagnostic;
		} else {
			diagnostics.add(diagnostic);
		}
	}

	public Diagnostic getDiagnostic() {
		return (Diagnostic) diagnostics;
	}
	
	@Override
	public void beginParse() {
		clearDiagnostic();
	}
	
	@Override
	public void beginValidation() {
		clearDiagnostic();
	}
	
	public void clearDiagnostic() {
		diagnostics = null;
	}
	
	/**
	 * Dumps the error code and token info.
	 * 
	 * @param leftToken token index
	 * @param rightToken token index
	 */
	@Override
	public void lexerProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		int leftToken = getParser().getTokenIndexAtCharacter(startOffset);
		if (leftToken < 0) {
            leftToken = -leftToken;
        }
		String message = problemMessage
	             		+ " (" + getParser().getKind(leftToken) + ") : "  //$NON-NLS-1$//$NON-NLS-2$
	             		+ getParser().getStartOffset(leftToken)
	             		+ ":" + getParser().getLineNumberOfTokenAt(leftToken) //$NON-NLS-1$
	             		+ ":" + getParser().getColumnOfTokenAt(leftToken) //$NON-NLS-1$
	             		+ ":" + getParser().getTokenLength(leftToken) //$NON-NLS-1$
	             		+ " " + getParser().getTokenText(leftToken); //$NON-NLS-1$
		handleProblem(problemSeverity, Phase.LEXER, message,
				processingContext, startOffset, endOffset);
	}
	
	@Override
	public void parserProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		int leftToken = getParser().getTokenIndexAtCharacter(startOffset);
		int rightToken = getParser().getTokenIndexAtCharacter(endOffset);
		int leftTokenLoc = (leftToken > rightToken ? rightToken : leftToken);
		int rightTokenLoc = rightToken;
	    int line = getParser().getLine(leftTokenLoc) + getErrorReportLineOffset();
	    if (line > 0) {
			String locInfo = OCLMessages.bind(OCLMessages.ErrorReport_RowColumn,
					new Object[]{
						new Integer((getParser().getLine(leftTokenLoc) + getErrorReportLineOffset())),
						new Integer(getParser().getColumn(leftTokenLoc)),
						new Integer((getParser().getEndLine(rightTokenLoc) + getErrorReportLineOffset())),
						new Integer(getParser().getEndColumn(rightTokenLoc))
				});
			problemMessage = locInfo + " " + problemMessage; //$NON-NLS-1$
	    }
	    handleProblem(problemSeverity, Phase.PARSER, problemMessage,
				processingContext, startOffset, endOffset);
	}
}
