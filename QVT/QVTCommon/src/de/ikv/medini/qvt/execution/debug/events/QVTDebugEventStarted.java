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
 * Event fired at start of transformation
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugEventStarted extends QVTDebugEvent {

	public String toString() {
		return "started";
	}

	public boolean equals(Object obj) {
		return obj instanceof QVTDebugEventStarted;
	}

	/**
	 * No own state, so return hash code 0
	 */
	public int hashCode() {
		return 0;
	}

}
