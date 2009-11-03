/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.execution.debug.stackframe;

import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestGetValue;

/**
 * Represents an OCL expression which can be evaluated in the context of a stack frame
 */
public class QVTStackFrameExpression extends QVTStackFrameEvaluable {

	private String expression;

	private QVTDebugStackFrame frame;

	public QVTStackFrameExpression(String expression, QVTDebugStackFrame frame) {
		this.expression = expression;
		this.frame = frame;
	}

	public String getExpression() {
		return this.expression;
	}

	public QVTDebugStackFrame getFrame() {
		return this.frame;
	}

	public String toString() {
		return "eval " + this.expression;
	}

	public OclAny evaluate(IDebugAdapter debugAdapter) {
		return QVTDebugRequestGetValue.evaluateOCL(debugAdapter, this.expression, this.frame);
	}
}
