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

import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;

import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.execution.debug.IDebugAdapter;

/**
 * Represents a property of a model element
 */
public class QVTStackFrameProperty extends QVTStackFrameAssignable {

	private QVTStackFrameAssignable source;

	private Property property;

	private OclAny sourceValue;

	private QVTDebugStackFrame frame;

	public QVTStackFrameProperty(Property name, QVTStackFrameAssignable source) {
		this.property = name;
		this.source = source;
		if (source != null) {
			this.frame = source.getFrame();
		}
	}

	public QVTStackFrameProperty(Property name, OclAny sourceValue) {
		this.property = name;
		this.sourceValue = sourceValue;
	}

	public QVTStackFrameProperty(Property name, OclAny sourceValue, QVTDebugStackFrame frame) {
		this.property = name;
		this.sourceValue = sourceValue;
		this.frame = frame;
	}

	public String getName() {
		return this.property.getName();
	}

	public Property getProperty() {
		return this.property;
	}

	public QVTStackFrameAssignable getSource() {
		return this.source;
	}

	public OclAny getSourceValue() {
		return this.sourceValue;
	}

	public String toString() {
		return "prop " + this.property;
	}

	public OclAny evaluate(IDebugAdapter debugAdapter) {
		if (this.getSource() != null) {
			OclAny sourceValue = this.getSource().evaluate(debugAdapter);
			return QvtSemanticTask.getPropertyValueOf(this.property, sourceValue, debugAdapter.getQvtProcessor());
		} else {
			return QvtSemanticTask.getPropertyValueOf(this.property, this.getSourceValue(), debugAdapter.getQvtProcessor());
		}
	}

	public QVTDebugStackFrame getFrame() {
		return this.frame;
	}

	public void assign(IDebugAdapter debugAdapter, OclAny value) {
		debugAdapter.getQvtProcessor().getQvtModelManipulationAdaper().setOrAddValueForFeauture((OclAnyModelElement) this.getSourceValue(), this.getProperty(), value);
	}
}
