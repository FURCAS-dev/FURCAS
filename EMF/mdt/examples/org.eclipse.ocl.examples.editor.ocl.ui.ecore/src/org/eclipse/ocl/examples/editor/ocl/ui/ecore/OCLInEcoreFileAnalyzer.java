/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: OCLInEcoreFileAnalyzer.java,v 1.2 2010/03/13 13:16:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.util.List;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.examples.parser.ocl.OCLFileAnalyzer;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLFileEnvironment;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLTopLevelEnvironment;
import org.eclipse.ocl.examples.parser.utils.ProblemCounter;
import org.eclipse.ocl.lpg.ProblemHandler;

/**
 * OCLInEcoreFileAnalyzer refines the basic OCLFileAnalyzer to automatically update
 * the Ecore Resource following an error free analysis.
 */
public class OCLInEcoreFileAnalyzer extends OCLFileAnalyzer
{
	public OCLInEcoreFileAnalyzer(OCLFileEnvironment environment, Monitor monitor) {
		super(environment, monitor);
	}

	@Override
	protected void installConstraints(OCLTopLevelEnvironment environment, List<Constraint> constraints) {
		ProblemHandler problemHandler = environment.getProblemHandler();
		if (!(problemHandler instanceof OCLInEcoreParseController.CountingProblemHandler)) {
			return;		// Never happens
		}
		ProblemCounter problemCounter = ((OCLInEcoreParseController.CountingProblemHandler)problemHandler).getProblemCounter();
		int relevantProblemCount = problemCounter.getRelevantProblemCount(ProblemHandler.Severity.ERROR);
		if (relevantProblemCount > 0) {
			return;		// Do not install erroneous constraints
		}
		ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment = environment.getFileEnvironment();
		ResourceSet resourceSet = fileEnvironment.getResourceSet();
		OCLInEcoreSynchronizer synchronizer = OCLInEcoreSynchronizer.getAdapter(resourceSet);
		if (synchronizer == null) {
			return;		// If a parse scheduled too promptly
		}
		synchronizer.exportConstraintsToResource(environment, constraints);
	}
}
