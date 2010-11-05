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
 *
 * </copyright>
 *
 * $Id: ProblemHandlerWrapper.java,v 1.1 2007/10/11 23:04:53 cdamus Exp $
 */
package org.eclipse.ocl.util;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;

/**
 * A wrapper for {@link ProblemHandler}s, convenient for subclassing to
 * decorate/intercept an existing problem handler instance.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public class ProblemHandlerWrapper
	implements ProblemHandler {

	private final ProblemHandler delegate;

	/**
	 * Initializes me with the problem-handler to which I delegate.
	 * 
	 * @param delegate m delegate
	 */
	public ProblemHandlerWrapper(ProblemHandler delegate) {
		this.delegate = delegate;
	}

	// Documentation copied from the inherited specification
	public void analyzerProblem(Severity problemSeverity,
			String problemMessage, String processingContext, int startOffset,
			int endOffset) {
		delegate.analyzerProblem(problemSeverity, problemMessage,
			processingContext, startOffset, endOffset);
	}

	// Documentation copied from the inherited specification
	public void beginParse() {
		delegate.beginParse();
	}

	// Documentation copied from the inherited specification
	public void beginValidation() {
		delegate.beginValidation();
	}

	// Documentation copied from the inherited specification
	public void endParse() {
		delegate.endParse();
	}

	// Documentation copied from the inherited specification
	public void endValidation() {
		delegate.endValidation();
	}

	// Documentation copied from the inherited specification
	public void flush(Monitor monitor) {
		delegate.flush(monitor);
	}

	// Documentation copied from the inherited specification
	public int getErrorReportLineOffset() {
		return delegate.getErrorReportLineOffset();
	}

	// Documentation copied from the inherited specification
	public AbstractParser getParser() {
		return delegate.getParser();
	}

	// Documentation copied from the inherited specification
	public void handleProblem(Severity problemSeverity, Phase processingPhase,
			String problemMessage, String processingContext, int startOffset,
			int endOffset) {
		delegate.handleProblem(problemSeverity, processingPhase,
			problemMessage, processingContext, startOffset, endOffset);
	}

	// Documentation copied from the inherited specification
	public void lexerProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		delegate.lexerProblem(problemSeverity, problemMessage,
			processingContext, startOffset, endOffset);
	}

	// Documentation copied from the inherited specification
	public void parserProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		delegate.parserProblem(problemSeverity, problemMessage,
			processingContext, startOffset, endOffset);
	}

	// Documentation copied from the inherited specification
	public void setErrorReportLineOffset(int offset) {
		delegate.setErrorReportLineOffset(offset);
	}

	// Documentation copied from the inherited specification
	public void setParser(AbstractParser parser) {
		delegate.setParser(parser);
	}

	// Documentation copied from the inherited specification
	public void utilityProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset) {
		delegate.utilityProblem(problemSeverity, problemMessage,
			processingContext, startOffset, endOffset);
	}

	// Documentation copied from the inherited specification
	public void validatorProblem(Severity problemSeverity,
			String problemMessage, String processingContext, int startOffset,
			int endOffset) {
		delegate.validatorProblem(problemSeverity, problemMessage,
			processingContext, startOffset, endOffset);
	}

	/**
	 * Like the UNIX tool <tt>tee</tt>, a <tt>Tee</tt> forks problem handling
	 * in two directions, that is, to two other problem-handler instances.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static class Tee extends ProblemHandlerWrapper {
		private final ProblemHandler tee;
		
		/**
		 * Initializes me with the two problem-handler instances to which I
		 * delegate.
		 * 
		 * @param delegate one delegate
		 * @param tee the additional delegate
		 */
		public Tee(ProblemHandler delegate, ProblemHandler tee) {
			super(delegate);
			
			this.tee = tee;
		}

		@Override
		public void analyzerProblem(Severity problemSeverity,
				String problemMessage, String processingContext,
				int startOffset, int endOffset) {
			super.analyzerProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
			tee.analyzerProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
		}

		@Override
		public void beginParse() {
			super.beginParse();
			tee.beginParse();
		}

		@Override
		public void beginValidation() {
			super.beginValidation();
			tee.beginValidation();
		}

		@Override
		public void endParse() {
			super.endParse();
			tee.endParse();
		}

		@Override
		public void endValidation() {
			super.endValidation();
			tee.endValidation();
		}

		@Override
		public void flush(Monitor monitor) {
			super.flush(monitor);
			tee.flush(monitor);
		}

		@Override
		public void handleProblem(Severity problemSeverity,
				Phase processingPhase, String problemMessage,
				String processingContext, int startOffset, int endOffset) {
			super.handleProblem(problemSeverity, processingPhase, problemMessage,
				processingContext, startOffset, endOffset);
			tee.handleProblem(problemSeverity, processingPhase, problemMessage,
				processingContext, startOffset, endOffset);
		}

		@Override
		public void lexerProblem(Severity problemSeverity,
				String problemMessage, String processingContext,
				int startOffset, int endOffset) {
			super.lexerProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
			tee.lexerProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
		}

		@Override
		public void parserProblem(Severity problemSeverity,
				String problemMessage, String processingContext,
				int startOffset, int endOffset) {
			super.parserProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
			tee.parserProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
		}

		@Override
		public void setErrorReportLineOffset(int offset) {
			super.setErrorReportLineOffset(offset);
			tee.setErrorReportLineOffset(offset);
		}

		@Override
		public void setParser(AbstractParser parser) {
			super.setParser(parser);
			tee.setParser(parser);
		}

		@Override
		public void utilityProblem(Severity problemSeverity,
				String problemMessage, String processingContext,
				int startOffset, int endOffset) {
			super.utilityProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
			tee.utilityProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
		}

		@Override
		public void validatorProblem(Severity problemSeverity,
				String problemMessage, String processingContext,
				int startOffset, int endOffset) {
			super.validatorProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
			tee.validatorProblem(problemSeverity, problemMessage, processingContext,
				startOffset, endOffset);
		}
	}
}
