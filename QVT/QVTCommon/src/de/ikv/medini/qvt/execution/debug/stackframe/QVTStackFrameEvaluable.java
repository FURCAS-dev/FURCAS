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

import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.execution.debug.IDebugAdapter;

/**
 * Represents an expression which can be evaluated with respect to a given stack frame
 */
abstract public class QVTStackFrameEvaluable {

	public abstract OclAny evaluate(IDebugAdapter debugAdapter);

	abstract public QVTDebugStackFrame getFrame();

}
