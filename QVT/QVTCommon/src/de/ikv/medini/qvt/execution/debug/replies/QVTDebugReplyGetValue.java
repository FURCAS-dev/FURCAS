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

package de.ikv.medini.qvt.execution.debug.replies;

import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestGetValue;

/**
 * Reply class for {@link QVTDebugRequestGetValue}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugReplyGetValue extends QVTDebugReply {

	private OclAny value;

	public QVTDebugReplyGetValue(OclAny value) {
		this.value = value;
	}

	public String toString() {
		return "" + this.getValue();
	}

	public OclAny getValue() {
		return this.value;
	}

}
