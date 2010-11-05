/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *   IBM - Refactor phase and severity as types for localization
 *
 * </copyright>
 *
 * $Id: ProblemHandler.java,v 1.5 2008/01/02 16:56:11 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * A <code>ProblemHandler</code> handles problems detected during the various lexical
 * syntactic, semantic analysis and validation phases of source text processing. 
 * 
 * <code>setParser</code> should be invoked once the source text is available, then
 * <code>handleProblem</code> for each problem and finally <code>flush</code> to send
 * any accumulated problems to an appropriate recipient such as an error log or
 * problem marker view.
 * 
 * See <code>AbstractProblemHandler</code> for a default implementation of the per
 * processing phase convenience methods and <code>StringProblemHandler</code> for
 * a complete handler that just accumulates all problem reports as a string.
 */
public interface ProblemHandler {
	String ERROR_MESSAGES[] = {
	    /* LEX_ERROR_CODE */                     OCLMessages.OCLParseErrorCodes_LEX_ERROR,
	    /* ERROR_CODE */                         OCLMessages.OCLParseErrorCodes_ERROR,
	    /* BEFORE_CODE */                        OCLMessages.OCLParseErrorCodes_BEFORE,
	    /* INSERTION_CODE */                     OCLMessages.OCLParseErrorCodes_INSERTION,
	    /* INVALID_CODE */                       OCLMessages.OCLParseErrorCodes_INVALID,
	    /* SUBSTITUTION_CODE, SECONDARY_CODE */  OCLMessages.OCLParseErrorCodes_SUBSTITUTION_SECONDARY,
	    /* DELETION_CODE */                      OCLMessages.OCLParseErrorCodes_DELETION,
	    /* MERGE_CODE */                         OCLMessages.OCLParseErrorCodes_MERGE,
	    /* MISPLACED_CODE */                     OCLMessages.OCLParseErrorCodes_MISPLACED,
	    /* SCOPE_CODE */                         OCLMessages.OCLParseErrorCodes_SCOPE,
	    /* EOF_CODE */                           OCLMessages.OCLParseErrorCodes_EOF,
	    /* INVALID_TOKEN_CODE */                 OCLMessages.OCLParseErrorCodes_INVALID_TOKEN
	};
	
	/**
	 * Standard processing phases for problem messages.  This class may be
     * extended by custom problem handlers to define additional phases in
     * custom processes.
	 * 
	 * @author Christian W. Damus
	 * 
	 * @since 1.2
	 */
	class Phase implements Comparable<Phase> {
		/** Identifies problems found in the tokenizing (lexing) phase. */
		public static Phase LEXER = new Phase(OCLMessages.Phase_Lexer);
		/** Identifies problems found in the concrete syntax parsing phase. */
		public static Phase PARSER = new Phase(OCLMessages.Phase_Parser);
		/** Identifies problems found in the abstract syntax parsing phase. */
		public static Phase ANALYZER = new Phase(OCLMessages.Phase_Analyzer);
		/** Identifies problems found in the abstract syntax validation phase. */
		public static Phase VALIDATOR = new Phase(OCLMessages.Phase_Validator);
		/** Identifies problems found in a utility method (not really a parsing phase). */
		public static Phase UTILITY = new Phase(OCLMessages.Phase_Utility);
		/** Identifies problems found in un-parsing an OCL expression or constraint. */
		public static Phase UNPARSER = new Phase(OCLMessages.Phase_Unparser);
		
		private final String localizedName;
		
		/**
		 * Creates a new phase instance with a localized name for display in
		 * error messages.
		 * 
		 * @param lname the localized name of the phase
		 */
		protected Phase(String lname) {
			localizedName = lname;
		}

		/**
		 * Phases sort according to their names.
		 */
		public final int compareTo(Phase o) {
			return localizedName.compareTo(o.localizedName);
		}
		
		/**
		 * My hash code is my localized name's hash code.
		 */
		@Override
        public final int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((localizedName == null) ? 0
                : localizedName.hashCode());
            return result;
        }

		/**
		 * I am equal to any <tt>Phase</tt> that has the same localized name
		 * as I.
		 */
        @Override
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Phase)) {
                return false;
            }
            Phase other = (Phase) obj;
            if (localizedName == null) {
                if (other.localizedName != null) {
                    return false;
                }
            } else if (!localizedName.equals(other.localizedName)) {
                return false;
            }
            return true;
        }

        @Override
		public String toString() {
			return localizedName;
		}
	}
	
	/**
	 * Standard problem severities.  The values are defined in increasing
	 * order of their severity.
	 * 
	 * @author Christian W. Damus
	 * 
	 * @since 1.2
	 */
	enum Severity {
		/**
		 * Severity constant indicating absence of any problem.
		 * Corresponds to the EMF {@link Diagnostic} severity
		 * {@link Diagnostic#OK} and Eclipse <tt>IStatus.OK</tt>.
		 */
		OK(OCLMessages.Severity_OK, Diagnostic.OK) {
		    @Override
            public boolean isOK() {
		        return true;
		    }},
		/**
		 * Severity constant indicating an informational message
		 * that, really, is not a problem but a hint or suggestion.
		 * Corresponds to the EMF {@link Diagnostic} severity
		 * {@link Diagnostic#INFO} and Eclipse <tt>IStatus.INFO</tt>.
		 */
		INFO(OCLMessages.Severity_Info, Diagnostic.INFO),
		/**
		 * Severity constant indicating a warning problem.
		 * Corresponds to the EMF {@link Diagnostic} severity
		 * {@link Diagnostic#WARNING} and Eclipse <tt>IStatus.WARNING</tt>.
		 */
		WARNING(OCLMessages.Severity_Warning, Diagnostic.WARNING),
		/**
		 * Severity constant indicating an error problem that does not
		 * prevent the parser from proceeding, but which does indicate
		 * an ill-formed construct.
		 * Corresponds to the EMF {@link Diagnostic} severity
		 * {@link Diagnostic#ERROR} and Eclipse <tt>IStatus.ERROR</tt>.
		 */
		ERROR(OCLMessages.Severity_Error, Diagnostic.ERROR),
		/**
		 * Severity constant indicating an error problem that prevents
		 * the parser from continuing to process the remainder of the
		 * input.
		 * Corresponds to the EMF {@link Diagnostic} severity
		 * {@link Diagnostic#ERROR} and Eclipse <tt>IStatus.ERROR</tt>,
		 * because these frameworks do not distinguish between fatal
		 * and non-fatal conditions.
		 */
		FATAL(OCLMessages.Severity_Fatal_Error, Diagnostic.ERROR),
		/**
		 * Severity constant indicating a deliberate cancellation of the
		 * parsing operation by the user.
		 * Corresponds to the EMF {@link Diagnostic} severity
		 * {@link Diagnostic#CANCEL} and Eclipse <tt>IStatus.CANCEL</tt>.
		 * Cancellation in both of these frameworks, and in OCL, does
		 * not actually indicate an error condition despite its having
		 * the highest value.  However, an operation that was canceled
		 * is incomplete and any results produced are necessarily invalid
		 * as in the case of {@link #FATAL} errors.
		 */
        CANCEL(OCLMessages.Severity_Cancel, Diagnostic.CANCEL);
		
		private final int diagnosticSeverity;
		private final String localizedName;
		
		Severity(String lname, int sev) {
			localizedName = lname;
			diagnosticSeverity = sev;
		}
		
		public int getDiagnosticSeverity() {
			return diagnosticSeverity;
		}
        
        /**
         * Am I the "OK" severity?
         * 
         * @return whether I am OK
         * 
         * @see #OK
         */
        public boolean isOK() {
            return false;
        }
		
		@Override
		public String toString() {
			return localizedName;
		}
	}

	/**
	 * Define the syntactic parser from which source tokens and text may be obtained.
	 * @param parser
	 */
	void setParser(AbstractParser parser);
	
	/**
	 * Queries the parser from which I obtain source tokens and text.
	 * @return my parser
	 */
	AbstractParser getParser();
	
	/**
	 * Handle a problem of problemSeverity that has arisen during processingPhase and which
	 * is explained by problemMessage optionally clarified, if non-null, by processingContext,
	 * and if non-negative by the startOffset and endOffset character indexes in the parsing stream.
	 * 
	 * All other problem handling messages should redirect to this method.
	 * 
	 * @param problemSeverity text describing the problem severity (e.g. <code>errorSeverity</code>)
	 * @param processingPhase optional text describing the processing phase (e.g. <code>analyzerProblem</code>)
	 * @param problemMessage message describing the problem
	 * @param processingContext optional message describing the reporting context (e.g. <code>"PathNameCS"</code>)
	 * @param startOffset (inclusive) index of first source character influencing the problem, -ve if unknown
	 * @param endOffset (exclusive) index of last source character influencing the problem, -ve if unknown
	 */
	void handleProblem(Severity problemSeverity, Phase processingPhase, String problemMessage,
			String processingContext, int startOffset, int endOffset);
	
	/**
	 * Convenience method typically invoking <code>handleProblem</code>
	 * with a <code>analyzerProblem</code> processing phase.
	 * @param problemSeverity text describing the problem severity
	 * @param problemMessage message describing the problem
	 * @param processingContext optional message describing the reporting context (e.g. <code>"PathNameCS"</code>)
	 * @param startOffset (inclusive) index of first source character influencing the problem, -ve if unknown
	 * @param endOffset (exclusive) index of last source character influencing the problem, -ve if unknown
	 */
	void analyzerProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset);

	/**
	 * Convenience method typically invoking <code>handleProblem</code>
	 * with a <code>lexerProblem</code> processing phase.
	 * @param problemSeverity text describing the problem severity
	 * @param problemMessage message describing the problem
	 * @param processingContext optional message describing the reporting context (e.g. <code>"PathNameCS"</code>)
	 * @param startOffset (inclusive) index of first source character influencing the problem, -ve if unknown
	 * @param endOffset (exclusive) index of last source character influencing the problem, -ve if unknown
	 */
	void lexerProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset);

	/**
	 * Convenience method typically invoking <code>handleProblem</code>
	 * with a <code>parserProblem</code> processing phase.
	 * @param problemSeverity text describing the problem severity
	 * @param problemMessage message describing the problem
	 * @param processingContext optional message describing the reporting context (e.g. <code>"PathNameCS"</code>)
	 * @param startOffset (inclusive) index of first source character influencing the problem, -ve if unknown
	 * @param endOffset (exclusive) index of last source character influencing the problem, -ve if unknown
	 */
	void parserProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset);
	
	/**
	 * Convenience method typically invoking <code>handleProblem</code>
	 * with a <code>utilityProblem</code> processing phase.
	 * @param problemSeverity text describing the problem severity
	 * @param problemMessage message describing the problem
	 * @param processingContext optional message describing the reporting context (e.g. <code>"PathNameCS"</code>)
	 * @param startOffset (inclusive) index of first source character influencing the problem, -ve if unknown
	 * @param endOffset (exclusive) index of last source character influencing the problem, -ve if unknown
	 */
	void utilityProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset);

	/**
	 * Convenience method typically invoking <code>handleProblem</code>
	 * with a <code>validatorProblem</code> processing phase.
	 * @param problemSeverity text describing the problem severity
	 * @param problemMessage message describing the problem
	 * @param processingContext optional message describing the reporting context (e.g. <code>"PathNameCS"</code>)
	 * @param startOffset (inclusive) index of first source character influencing the problem, -ve if unknown
	 * @param endOffset (exclusive) index of last source character influencing the problem, -ve if unknown
	 */
	void validatorProblem(Severity problemSeverity, String problemMessage,
			String processingContext, int startOffset, int endOffset);

	/**
	 * Sets the line offset for reporting errors.
	 * E.g,. if an error occurred at line 2, but the offset was
	 * set to -1, then line 1 will be reported.
	 * 
	 * @param offset
	 */
	void setErrorReportLineOffset(int offset);

	/**
	 * Queries the line offset for reporting errors.
	 * E.g,. if an error occurred at line 2, but the offset was
	 * set to -1, then line 1 will be reported.
	 * 
	 * @return the line offset
	 */
	int getErrorReportLineOffset();
	
	/**
	 * Notifies me that parsing is about to begin, from which I may receive
	 * problems.  I should initialize myself accordingly, if necessary.
	 */
	void beginParse();
	
	/**
	 * Notifies me that parsing has completed, and I will get no further
	 * problems in this session.  I may clean up accordingly, if necessary.
	 */
	void endParse();
	
	/**
	 * Notifies me that validation is about to begin, from which I may receive
	 * problems.  I should initialize myself accordingly, if necessary.
	 */
	void beginValidation();
	
	/**
	 * Notifies me that validation has completed, and I will get no further
	 * problems in this session.  I may clean up accordingly, if necessary.
	 */
	void endValidation();
	
	/**
	 * Flush all problems to their recipient. 
	 * 
	 * This method allows handlers to batch up error reports into a single composite
	 * report or transaction. 
	 * 
	 * @param monitor an optional EMF monitor for reporting progress.  May be
	 *    <code>null</code> if not needed by the caller
	 */
	void flush(Monitor monitor);
}
