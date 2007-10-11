/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompatibilityEvaluationEnvironment.java,v 1.3 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

/**
 * @author cdamus
 *
 */
public class CompatibilityEvaluationEnvironment extends EcoreEvaluationEnvironment {
	private final org.eclipse.emf.ocl.parser.EvaluationEnvironment oldStyle;

	CompatibilityEvaluationEnvironment(
			org.eclipse.emf.ocl.parser.EvaluationEnvironment oldStyle) {
		
		this.oldStyle = oldStyle;
	}
	
	@Override
    public Object getValueOf(String name) {
		return oldStyle.getValueOf(name);
	}
	
	@Override
    public void add(String name, Object value) {
		oldStyle.add(name, value);
	}

	@Override
    public void replace(String name, Object value) {
		oldStyle.replace(name, value);
	}

	@Override
    public Object remove(String name) {
		return oldStyle.remove(name);
	}

	@Override
    public void clear() {
		oldStyle.clear();
	}

	@Override
    public boolean overrides(EOperation operation, int opcode) {
		return oldStyle.canEvaluate(operation, opcode);
	}

	@Override
    public Object callOperation(EOperation operation, int opcode, Object source,
			Object[] args) throws IllegalArgumentException {
		
		if (opcode > 0) {
			// in the old API, we were only ever asked to invoke pre-defined
			//    operations for which we declared an override
			try {
				return oldStyle.evaluate(operation, opcode, source, args);
			} catch (UnsupportedOperationException e) {
				throw new IllegalArgumentException(e.getLocalizedMessage(), e);
			}
		}
		
		return super.callOperation(operation, opcode, source, args);
	}

}
