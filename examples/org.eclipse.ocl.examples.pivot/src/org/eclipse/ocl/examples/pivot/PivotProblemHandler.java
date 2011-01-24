/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotProblemHandler.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.parser.OCLProblemHandler;

public class PivotProblemHandler extends OCLProblemHandler
{
	public PivotProblemHandler(AbstractParser parser) {
		super(parser);
	}
//	public void handleProblem(Severity problemSeverity, Phase processingPhase,
//			String problemMessage, String processingContext, int startOffset, int endOffset) {
//		int lineNumber = parser.getIPrsStream().getTokenAtCharacter(startOffset).getLine();
//		String message = OCLMessages.bind(
//				OCLMessages.ProblemMessage_ERROR_,
//				new Object[] {
//					processingPhase != null ? processingPhase : "?", //$NON-NLS-1$
//					problemSeverity != null ? problemSeverity : "?", //$NON-NLS-1$
//					processingContext != null ? processingContext : "?", //$NON-NLS-1$
//					lineNumber,
//					problemMessage != null ? problemMessage : "?"}); //$NON-NLS-1$
//		addProblem(problemMessage);
//	}

	@Override
	public void parserProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
//		IPrsStream prsStream = getIPrsStream();
//		int leftToken = prsStream.getTokenIndexAtCharacter(startOffset);
//		int rightToken = prsStream.getTokenIndexAtCharacter(endOffset);
//		int leftTokenLoc = (leftToken > rightToken ? rightToken : leftToken);
//		int rightTokenLoc = rightToken;
//	    int line = prsStream.getLine(leftTokenLoc) + getErrorReportLineOffset();
//	    if (line > 0) {
//			String locInfo = OCLMessages.bind(OCLMessages.ErrorReport_RowColumn,
//					new Object[]{
//						new Integer(prsStream.getLine(leftTokenLoc) + getErrorReportLineOffset()),
//						new Integer(prsStream.getColumn(leftTokenLoc)),
//						new Integer(prsStream.getEndLine(rightTokenLoc) + getErrorReportLineOffset()),
//						new Integer(prsStream.getEndColumn(rightTokenLoc))
//				});
//			problemMessage = locInfo + " " + problemMessage; //$NON-NLS-1$
//	    }
	    handleProblem(problemSeverity, Phase.PARSER, problemMessage,
				processingContext, startOffset, endOffset);
	}
}
