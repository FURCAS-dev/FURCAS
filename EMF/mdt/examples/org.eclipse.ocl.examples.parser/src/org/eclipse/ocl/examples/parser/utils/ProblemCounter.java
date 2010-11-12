/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ProblemCounter.java,v 1.2 2010/04/08 06:26:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler;

public class ProblemCounter extends AbstractProblemHandler
{
	private static final Severity[] summarySeverities = new Severity[] { Severity.FATAL, Severity.ERROR, Severity.WARNING };

	private Map<ProblemHandler.Severity, Map<ProblemHandler.Phase, Integer>> problemsCounts = null;
	
	public ProblemCounter() {
		super(null);
	}

/*	public int getAllProblems() {
	}

	public int getAnalyzerProblems() {
		Integer count = problemCounts.get(ProblemHandler.Phase.ANALYZER);
		return count != null ? count.intValue() : 0;
	}

	public int getLexerProblems() {
		Integer count = problemCounts.get(ProblemHandler.Phase.LEXER);
		return count != null ? count.intValue() : 0;
	}

	public int getParserProblems() {
		Integer count = problemCounts.get(ProblemHandler.Phase.PARSER);
		return count != null ? count.intValue() : 0;
	} */

	public int getExactProblemCount(Severity problemSeverity) {
		int sum = 0;
		if (problemsCounts != null) {
			Map<ProblemHandler.Phase, Integer> problemsCount = problemsCounts.get(problemSeverity);
			if (problemsCount != null)
				for (Integer problemCount : problemsCount.values())
					sum += problemCount.intValue();
		}
		return sum;
	}

	public int getExactProblemCount(Severity problemSeverity, Phase processingPhase) {
		int sum = 0;
		if (problemsCounts != null) {
			Map<ProblemHandler.Phase, Integer> problemsCount = problemsCounts.get(problemSeverity);
			if (problemsCount != null) {
				Integer problemCount = problemsCount.get(processingPhase);
				if (problemCount != null)
					sum += problemCount.intValue();
			}
		}
		return sum;
	}

	public int getProblemCount() {
		int sum = 0;
		if (problemsCounts != null) {
			for (Map<ProblemHandler.Phase, Integer> problemsCount : problemsCounts.values())
				for (Integer problemCount : problemsCount.values())
					sum += problemCount.intValue();
		}
		return sum;
	}

	public int getProblemCount(Phase processingPhase) {
		int sum = 0;
		if (problemsCounts != null) {
			for (Map<ProblemHandler.Phase, Integer> problemsCount : problemsCounts.values()) {
				Integer problemCount = problemsCount.get(processingPhase);
				if (problemCount != null)
					sum += problemCount.intValue();
			}
		}
		return sum;
	}

	public int getRelevantProblemCount(Severity thresholdSeverity) {
		int sum = 0;
		if (problemsCounts != null) {
			for (Severity problemSeverity : problemsCounts.keySet()) {
				if (isRelevantSeverity(problemSeverity, thresholdSeverity)) {	
					Map<ProblemHandler.Phase, Integer> problemsCount = problemsCounts.get(problemSeverity);
					for (Integer problemCount : problemsCount.values())
						sum += problemCount.intValue();
				}
			}
		}
		return sum;
	}

	public int getRelevantProblemCount(Severity thresholdSeverity, Phase processingPhase) {
		int sum = 0;
		if (problemsCounts != null) {
			for (Severity problemSeverity : problemsCounts.keySet()) {
				if (isRelevantSeverity(problemSeverity, thresholdSeverity)) {	
					Map<ProblemHandler.Phase, Integer> problemsCount = problemsCounts.get(problemSeverity);
					Integer problemCount = problemsCount.get(processingPhase);
					if (problemCount != null)
						sum += problemCount.intValue();
				}
			}
		}
		return sum;
	}

	public String getSummary() {
		if (problemsCounts != null) {
			StringBuilder s = new StringBuilder();
			for (Severity thresholdSeverity : summarySeverities) {
				int count = 0;
				for (Severity problemSeverity : problemsCounts.keySet()) {
					if (isRelevantSeverity(problemSeverity, thresholdSeverity)) {	
						Map<ProblemHandler.Phase, Integer> problemsCount = problemsCounts.get(problemSeverity);
						for (Phase problemPhase : problemsCount.keySet()) {
							if (s.length() > 0)
								s.append(", ");
							Integer problemCount = problemsCount.get(problemPhase);
							s.append(problemCount);
							s.append(" ");
							s.append(problemPhase);
							count += problemCount.intValue();
						}
					}
				}
				if (s.length() > 0) {
					s.append(" ");
					s.append(thresholdSeverity);
					if (count != 1)
						s.append("s");
					return s.toString();
				}
			}
		}
		return "No problems";
	}

	private boolean isRelevantSeverity(Severity problemSeverity, Severity thresholdSeverity) {
		// FIXME Workaround Bugzilla 214013
		return (problemSeverity.compareTo(thresholdSeverity) >= 0) && (problemSeverity != Severity.CANCEL);
	}

/*	public int getValidatorProblems() {
		Integer count = problemCounts.get(ProblemHandler.Phase.VALIDATOR);
		return count != null ? count.intValue() : 0;
	} */

	@Override public void handleProblem(Severity problemSeverity, Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		if (problemsCounts == null)
			problemsCounts = new HashMap<ProblemHandler.Severity, Map<ProblemHandler.Phase, Integer>>()	;		
		Map<ProblemHandler.Phase, Integer> problemsCount = problemsCounts.get(problemSeverity);
		if (problemsCount == null) {
			problemsCount = new HashMap<ProblemHandler.Phase, Integer>();
			problemsCounts.put(problemSeverity, problemsCount);		
		}
		Integer problemCount = problemsCount.get(processingPhase);
		int newCount = problemCount != null ? problemCount.intValue() + 1 : 1;
		problemsCount.put(processingPhase, Integer.valueOf(newCount));
	}

	@Override
	public String toString() {
		return getSummary();
	}
}