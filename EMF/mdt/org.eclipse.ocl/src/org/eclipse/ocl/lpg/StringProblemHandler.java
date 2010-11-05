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
 *   E.D.Willink - refactored to separate from OCLParser
 *
 * </copyright>
 *
 * $Id: StringProblemHandler.java,v 1.1 2007/10/11 23:04:53 cdamus Exp $
 */
package org.eclipse.ocl.lpg;


/**
 * A <code>StringProblemHandler</code> counts and accumulates all problem reports, so that
 * all problems may be processed on completion of semantic/syntactic/lexical analysis.
 */
public class StringProblemHandler extends AbstractProblemHandler
{	
	private int problemCount = 0;
	private StringBuffer problemString = new StringBuffer();

	public StringProblemHandler(AbstractParser parser) {
		super(parser);
	}

	/**
	 * Accumulate the problemMessage followed by new-line.
	 */
	@Override
	protected void addProblem(String problemMessage) {
		problemString.append(problemMessage);
		problemString.append("\n"); //$NON-NLS-1$
		problemCount++;
	}

	/**
	 * Return the number of reported problems.
	 * @return number of problems
	 */
	public int getProblemCount() {
		return problemCount;
	}

	/**
	 * Return the accumulated problem report, corresponding the concatenation of each
	 * <code>addProblem</code> invocation argument with a new-line following each.
	 * @return the accumulated problem report
	 */
	public String getProblemString() {
		return problemString.toString();
	}
}
