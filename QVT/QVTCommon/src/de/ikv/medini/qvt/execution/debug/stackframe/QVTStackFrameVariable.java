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

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.execution.debug.IDebugAdapter;

/**
 * Represents e.g. a local variable of a QVT relation
 */
public class QVTStackFrameVariable extends QVTStackFrameAssignable {

	private VariableDeclaration variableDeclaration;

	private QvtSemanticTask task;

	private int bindingNumber;

	private QVTDebugStackFrame frame;

	public QVTStackFrameVariable(QVTDebugStackFrame frame, VariableDeclaration variableDeclaration, QvtSemanticTask task, int bindingNumber) {
		this.frame = frame;
		this.variableDeclaration = variableDeclaration;
		this.task = task;
		this.bindingNumber = bindingNumber;
	}

	public String getName() {
		return this.variableDeclaration.getName();
	}

	public int getBindingNumber() {
		return this.bindingNumber;
	}

	public QvtSemanticTask getTask() {
		return this.task;
	}

	public String toString() {
		return "var " + this.variableDeclaration.getName();
	}

	public OclAny evaluate(IDebugAdapter debugAdapter) {
		return this.getTask().getValueFor(this.getBindingNumber(), this.getName());
	}

	public QVTDebugStackFrame getFrame() {
		return this.frame;
	}

	public void assign(IDebugAdapter debugAdapter, OclAny value) {
		this.getTask().setValueFor(this.getBindingNumber(), this.getName(), value);
	}

	/**
	 * @return The type of the variable
	 */
	public Classifier getDeclaredType() {
		return this.variableDeclaration.getType();
	}
}
