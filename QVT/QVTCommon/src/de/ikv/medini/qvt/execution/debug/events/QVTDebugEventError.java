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

package de.ikv.medini.qvt.execution.debug.events;

/**
 * Event to signal an error
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugEventError extends QVTDebugEvent {

	private String error;

	public QVTDebugEventError(String error) {
		this.error = error;
	}

	public String toString() {
		return "error";
	}

	public String getErrorMessage() {
		return this.error;
	}
}
