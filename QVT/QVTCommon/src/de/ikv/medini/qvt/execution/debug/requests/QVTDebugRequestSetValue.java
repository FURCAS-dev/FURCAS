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

import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyFailure;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyOK;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTStackFrameAssignable;

/**
 * Debugging request class to set the value of a variable
 * 
 * Always replies with {@link QVTDebugReplyOK} or {@link QVTDebugReplyFailure}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugRequestSetValue extends QVTDebugRequest {

	private QVTStackFrameAssignable var;

	private String stringValue;

	public QVTDebugRequestSetValue(QVTStackFrameAssignable var, String stringValue) {
		this.var = var;
		this.stringValue = stringValue;
	}

	public String toString() {
		return "set" + this.var;
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		try {
			OclAny oclValue = QVTDebugRequestGetValue.evaluateOCL(debugAdapter, this.stringValue, this.var.getFrame());
			this.var.assign(debugAdapter, oclValue);
			this.setReply(new QVTDebugReplyOK());
		} catch (Throwable e) {
			this.setReply(new QVTDebugReplyFailure(e.getMessage()));
		}

	}

}
