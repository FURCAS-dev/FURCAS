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
 * $Id: ProblemHandlerDiagnosticChain.java,v 1.2 2010/04/08 06:26:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;

/**
 * ProblemHandlerDiagnosticChain implements DiagnosticChain and redirects
 * Diagnostics to a ProblemHandler. If constructed with a BasicEnvironment
 * the environment is used to assist in mapping diagnostic objects to CSTNode
 * so that problems identify their character range.
 */
public class ProblemHandlerDiagnosticChain implements DiagnosticChain
{
	protected final BasicEnvironment environment;
	protected final ProblemHandler problemHandler;
	
	public ProblemHandlerDiagnosticChain(ProblemHandler problemHandler) {
		this.environment = null;
		this.problemHandler = problemHandler;
	}
	
	public ProblemHandlerDiagnosticChain(BasicEnvironment environment) {
		this.environment = environment;
		this.problemHandler = environment.getProblemHandler();
	}
	
	public void add(Diagnostic diagnostic) {
		if (diagnostic == null)
			return;
		List<Diagnostic> kids = diagnostic.getChildren();
		if (!kids.isEmpty()) {
			for (Diagnostic kid : kids)
				add(kid);
		}
		else {
			List<?> objects = diagnostic.getData();
			CSTNode cstNode = null;
			if (!objects.isEmpty()) {
				Object object = objects.get(0);
				if (object != null) {
					if (environment != null)
						cstNode = environment.getASTMapping(object);
					else if (object instanceof CSTNode)
						cstNode = (CSTNode) object;
				}
			}
			int startOffset = cstNode != null ? cstNode.getStartOffset() : 0;
			int endOffset = cstNode != null ? cstNode.getEndOffset() : 0;
			Severity problemSeverity = Severity.INFO;
			if (diagnostic.getSeverity() >= Diagnostic.ERROR)
				problemSeverity = Severity.ERROR;
			else if (diagnostic.getSeverity() >= Diagnostic.WARNING)
				problemSeverity = Severity.WARNING;				
			String problemMessage = diagnostic.getMessage();
			String problemContext = diagnostic.getSource();
			handleProblem(problemSeverity, problemMessage, problemContext, startOffset, endOffset);
		}
	}

	public void addAll(Diagnostic diagnostic) {
		for (Diagnostic child : diagnostic.getChildren())
			add(child);
	}

	protected void handleProblem(Severity problemSeverity, String problemMessage, String problemContext, int startOffset, int endOffset) {
		problemHandler.validatorProblem(problemSeverity, problemMessage, problemContext, startOffset, endOffset);
	}

	public void merge(Diagnostic diagnostic) {
		if (diagnostic.getChildren().isEmpty())
			add(diagnostic);
		else
			addAll(diagnostic);
	}
}