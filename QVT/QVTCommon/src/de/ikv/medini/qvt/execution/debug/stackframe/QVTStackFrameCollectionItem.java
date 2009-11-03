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
import java.util.Collection;
import java.util.List;

import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.execution.debug.IDebugAdapter;

/**
 * Represents an item of a collection value identified by an index in this collection
 */
public class QVTStackFrameCollectionItem extends QVTStackFrameAssignable {

	private int index;

	private OclAny sourceValue;

	private QVTDebugStackFrame frame;

	public QVTStackFrameCollectionItem(int index, OclAny sourceValue) {
		this.index = index;
		this.sourceValue = sourceValue;
	}

	public QVTStackFrameCollectionItem(int index, OclAny sourceValue, QVTDebugStackFrame frame) {
		this.index = index;
		this.sourceValue = sourceValue;
		this.frame = frame;
	}

	public String getName() {
		return "[" + new Integer(this.index).toString() + "]";
	}

	public String toString() {
		return "index " + new Integer(this.index).toString();
	}

	public OclAny getSourceValue() {
		return this.sourceValue;
	}

	public int getIndex() {
		return this.index;
	}

	public OclAny evaluate(IDebugAdapter debugAdapter) {
		if (this.sourceValue != null && this.sourceValue.asJavaObject() instanceof Collection) {
			Collection col = (Collection) this.sourceValue.asJavaObject();
			if (this.index < col.size()) {
				return debugAdapter.getQvtProcessor().getStdLibAdapter().OclAny(new ArrayList(col).get(this.index));
			}
		}
		return null;
	}

	public QVTDebugStackFrame getFrame() {
		return this.frame;
	}

	public void assign(IDebugAdapter debugAdapter, OclAny value) {
		if (this.getSourceValue() != null && this.getSourceValue().asJavaObject() instanceof Collection) {
			Collection col = (Collection) this.getSourceValue().asJavaObject();
			if (this.getIndex() < col.size()) {
				List asList = new ArrayList(col);
				asList.set(this.getIndex(), value.asJavaObject());
				col.clear();
				col.addAll(asList);
			}
		}
	}
}
