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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.execution.debug.QVTSourcePosition;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

/**
 * Represents a stack frame
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugStackFrame {

	/**
	 * A list of {@link QVTStackFrameVariable} instances
	 */
	private List variables = new ArrayList();

	private String name;

	private String pseudoCode;

	private QVTSourcePosition sourcePosition;

	private Transformation currentTransformation;

	private TypedModel currentDirection;

	public QVTDebugStackFrame(QvtSemanticTask task) {
		QvtProcessorImpl processor = task.getQvtProcessor();
		this.sourcePosition = task.currentSourcePosition();
		this.name = task.getRelation().getName();
		if (task.currentWhenClause() != null) {
			this.pseudoCode = processor.getPseudoCodeForWhenClause(task.currentClause());
		} else {
			this.pseudoCode = processor.getPseudoCodeForWhereClause(task.currentClause());
		}
		Map binding = new HashMap();
		List templateVariables = task.getRelation().getVariable();
		for (Iterator iter = templateVariables.iterator(); iter.hasNext();) {
			VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iter.next();
			this.variables.add(new QVTStackFrameVariable(this, currentVariableDeclaration, task, task.getCurrentBindingNumber()));
		}

		this.currentTransformation = task.getRelation().getTransformation();
		this.currentDirection = processor.getTargetTypedModel();
	}

	/**
	 * 
	 * @return A list of {@link QVTStackFrameVariable} instances
	 */
	public List getVariables() {
		return this.variables;
	}

	public String toString() {
		return this.sourcePosition.getFile() + "|" + this.sourcePosition.getLine() + "|" + this.name;
	}

	public String getName() {
		return this.name;
	}

	public String getPseudoCode() {
		return this.pseudoCode;
	}

	public boolean hasPseudoCode() {
		return this.pseudoCode != null && !"".equals(this.pseudoCode);
	}

	public QVTSourcePosition getSourcePosition() {
		return this.sourcePosition;
	}

	/**
	 * @return the currentTransformation
	 */
	public Transformation getCurrentTransformation() {
		return this.currentTransformation;
	}

	/**
	 * @return the currentDirection
	 */
	public TypedModel getCurrentDirection() {
		return this.currentDirection;
	}

}
