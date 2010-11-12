/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonProblemHandler.java,v 1.1 2010/03/11 14:51:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import lpg.runtime.IToken;

import org.eclipse.core.resources.IMarker;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.builder.MarkerProblemHandler;
import org.eclipse.ocl.examples.editor.ui.builder.ProblemLimit;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.DerivedPrsStream;

/**
 * A CommonProblemHandler arranges for errors, reported via the MDT OCL
 * ProblemHandler API, to be redirected to an IMP IMessageHandler.  
 */
public class CommonProblemHandler extends AbstractProblemHandler
{
	protected final IMessageHandler handler;
	private ProblemLimit problemLimit = null;
	
	public CommonProblemHandler(AbstractParser parser, IMessageHandler handler) {
		super(parser);
		this.handler = handler;
		handler.clearMessages();
	}

	public IToken getNearestTokenAtCharacter(int offset) {		// FIXME Move to AbstractParser
        AbstractParser parser = getParser();
        DerivedPrsStream parseStream = parser.getIPrsStream();
		int maxIndex = parseStream.getSize();
        if (maxIndex <= 0)
        	return null;
		int tokenIndex = parseStream.getTokenIndexAtCharacter(offset);
		if (tokenIndex >= 0)
			return parseStream.getTokenAt(tokenIndex >= maxIndex ? (maxIndex-1) : tokenIndex);
		tokenIndex = -tokenIndex + 1; 							// offset is between tokens
		IToken prevToken = parseStream.getTokenAt(tokenIndex >= maxIndex ? (maxIndex-1) : tokenIndex);
		IToken nextToken = parseStream.getTokenAt((tokenIndex+1) >= maxIndex ? (maxIndex-1) : (tokenIndex+1));
		int prevEndOffset = prevToken.getEndOffset();
		int nextStartOffset = nextToken.getStartOffset();
		int postEnd = offset - prevEndOffset;
		int preStart = nextStartOffset - offset;
		if (postEnd >= 0) {
			if (preStart >= 0)
				return preStart < postEnd ? prevToken : nextToken;
			else
				return prevToken;
		}
		else {
			if (preStart >= 0)
				return nextToken;
			else
				return nextToken;		// Anything is better than null
		}
	}		

	@Override
	public void handleProblem(Severity problemSeverity,
			Phase processingPhase, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		try {
			if (startOffset < 0)
				startOffset = 0;
			if (endOffset < 0)
				endOffset = 0;
			IToken startToken = getNearestTokenAtCharacter(startOffset);
			IToken endToken = getNearestTokenAtCharacter(endOffset);
			int startLine = startToken != null ? startToken.getLine() : 0;
			int startCol = startToken != null ? startToken.getColumn() : 0;
			int endLine = endToken != null ? endToken.getLine() : 0;
			int endCol = endToken != null ? endToken.getColumn() : 0;
			String adjustedMessage = problemMessage;
			if (problemLimit != null) {
				Integer severity = MarkerProblemHandler.severityMap.get(problemSeverity);
				adjustedMessage = problemLimit.check(severity != null ? severity.intValue() : IMarker.SEVERITY_ERROR, adjustedMessage);
				if (adjustedMessage == null)
					return;
			}
			// FIXME Get Annotation to display alternate severities
			String prefixedMessage = problemSeverity != null ? (problemSeverity.name() + ": " + problemMessage) : problemMessage;
			handler.handleSimpleMessage(prefixedMessage, startOffset, endOffset,
		            startCol, endCol, startLine, endLine);
			if (adjustedMessage != problemMessage)
				throw new ProblemLimit.LimitExceededException(adjustedMessage);
		} catch(Throwable e) {
			OCLExamplesEditorPlugin.logError("Failed to handleProblem", e);
		}
	}
	
	public void setProblemLimit(ProblemLimit problemLimit) {
		this.problemLimit = problemLimit;
	}
}