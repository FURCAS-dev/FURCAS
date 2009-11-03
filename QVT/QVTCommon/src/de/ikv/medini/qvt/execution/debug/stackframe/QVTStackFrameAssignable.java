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
 * 
 * Represents an expression which can be both evaluated and assigned (e.g. a variable)
 * 
 */
abstract public class QVTStackFrameAssignable extends QVTStackFrameEvaluable {

	public abstract void assign(IDebugAdapter debugAdapter, OclAny value);

	/**
	 * Name of item which can be assigned
	 * 
	 * @return
	 */
	abstract public String getName();

}
