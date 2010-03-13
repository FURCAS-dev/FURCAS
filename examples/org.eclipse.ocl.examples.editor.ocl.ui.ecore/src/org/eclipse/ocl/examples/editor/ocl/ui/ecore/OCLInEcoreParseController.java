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
 * $Id: OCLInEcoreParseController.java,v 1.2 2010/03/13 13:16:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import org.eclipse.ocl.examples.editor.ocl.ui.imp.OCLParseController;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.examples.parser.utils.ProblemCounter;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.util.ProblemHandlerWrapper;

public class OCLInEcoreParseController extends OCLParseController
{
	public static class CountingProblemHandler extends ProblemHandlerWrapper.Tee
	{
		ProblemCounter problemCounter = new ProblemCounter();
		
		private CountingProblemHandler(ProblemHandler delegate, ProblemCounter problemCounter) {
			super(delegate, problemCounter);
			this.problemCounter = problemCounter;
		}
		
		public ProblemCounter getProblemCounter() {
			return problemCounter;
		}
	}

	public OCLInEcoreParseController() {
		super(OCLInEcoreCreationFactory.INSTANCE);
	}

	@Override
	protected ProblemHandler createProblemHandler(ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment) {
		ProblemHandler superProblemHandler = super.createProblemHandler(environment);
		return new CountingProblemHandler(superProblemHandler, new ProblemCounter());
	}
}
