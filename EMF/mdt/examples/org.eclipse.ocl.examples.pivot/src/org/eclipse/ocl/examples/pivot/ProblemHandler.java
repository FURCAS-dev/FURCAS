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
 * $Id: ProblemHandler.java,v 1.1 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;

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
}
