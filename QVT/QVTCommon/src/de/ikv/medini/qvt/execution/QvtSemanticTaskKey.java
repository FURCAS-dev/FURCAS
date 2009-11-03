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

package de.ikv.medini.qvt.execution;

/**
 * Wrapper class for <code>QvtSemanticTask</code>. The purpose of this class is to manage <code>QvtSemanticTask</code> instances in a
 * <code>Set<code> while defining equality only on their source domains.
 * 
 * @author kiegeland
 *
 */
public class QvtSemanticTaskKey {

	/**
	 * The referred task
	 */
	private QvtSemanticTask task;

	QvtSemanticTaskKey(QvtSemanticTask task) {
		this.task = task;
	}

	/**
	 * Cache for the calculated hash code for better performance
	 */
	private int hashCode;

	/**
	 * Equal iff the traces are equal in target direction
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null) {
			if (obj instanceof QvtSemanticTaskKey) {
				return this.task.equalsOnSourceDomains(((QvtSemanticTaskKey) obj).task);
			}
			return false;
		}
		return false;
	}

	public int hashCode() {
		if (this.hashCode == 0) {
			this.hashCode = this.task.getTrace().hashCodeInDirection(this.task.getTargetModel());
		}
		return this.hashCode;
	}

}
