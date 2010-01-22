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
 * $Id: OCLProblemHandler.java,v 1.3 2010/01/22 18:37:46 asanchez Exp $
 */
package org.eclipse.ocl.parser;

import lpg.runtime.IPrsStream;

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
	
	@Override
	public void parserProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		IPrsStream prsStream = getIPrsStream();
		int leftToken = prsStream.getTokenIndexAtCharacter(startOffset);
		int rightToken = prsStream.getTokenIndexAtCharacter(endOffset);
		int leftTokenLoc = (leftToken > rightToken ? rightToken : leftToken);
		int rightTokenLoc = rightToken;
	    int line = prsStream.getLine(leftTokenLoc) + getErrorReportLineOffset();
	    if (line > 0) {
			String locInfo = OCLMessages.bind(OCLMessages.ErrorReport_RowColumn,
					new Object[]{
						new Integer(prsStream.getLine(leftTokenLoc) + getErrorReportLineOffset()),
						new Integer(prsStream.getColumn(leftTokenLoc)),
						new Integer(prsStream.getEndLine(rightTokenLoc) + getErrorReportLineOffset()),
						new Integer(prsStream.getEndColumn(rightTokenLoc))
				});
			problemMessage = locInfo + " " + problemMessage; //$NON-NLS-1$
	    }
	    handleProblem(problemSeverity, Phase.PARSER, problemMessage,
				processingContext, startOffset, endOffset);
	}
	
	/**
	 * @since 3.0
	 */
	protected IPrsStream getIPrsStream() {
		return getParser().getIPrsStream();
	}
}
