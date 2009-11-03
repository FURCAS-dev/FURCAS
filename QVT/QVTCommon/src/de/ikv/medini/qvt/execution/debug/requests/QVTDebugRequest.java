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

import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEvent;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventUnimplementedInstruction;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReply;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyOK;

/**
 * All debugging request classes derive from this class
 * 
 * @author kiegeland
 * 
 */
abstract public class QVTDebugRequest {

	// null means the request is not yet processed
	QVTDebugReply reply = null;

	private QVTDebugEvent event;

	public QVTDebugReply getReply() {
		return this.reply;
	}

	public void setReply(QVTDebugReply reply) {
		this.reply = reply;
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		this.setEvent(new QVTDebugEventUnimplementedInstruction(this));
		this.setReply(new QVTDebugReplyOK());
	}

	protected void setEvent(QVTDebugEvent event) {
		// processor.triggerEvent(event);
		this.event = event;
	}

	public QVTDebugEvent getEvent() {
		return this.event;
	}

}
