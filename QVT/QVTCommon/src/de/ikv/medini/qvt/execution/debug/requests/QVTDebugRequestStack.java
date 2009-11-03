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

package de.ikv.medini.qvt.execution.debug.requests;

import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyStack;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTDebugStackFrame;

/**
 * Debugging request class to get the stack frame
 * 
 * Always replies with {@link QVTDebugReplyStack}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugRequestStack extends QVTDebugRequest {

	public String toString() {
		return "stack";
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		QVTDebugReplyStack stack = new QVTDebugReplyStack();
		QvtSemanticTask task = debugAdapter.getSuspendedTask();
		while (task != null && task.currentLine() != -1) {
			QVTDebugStackFrame frame = new QVTDebugStackFrame(task);
			stack.addCallerFrame(frame);
			task = task.getCallerTask();
		}
		this.setReply(stack);

	}

}
