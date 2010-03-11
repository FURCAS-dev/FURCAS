/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.parser.unparser;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.utilities.UMLReflection;

public abstract class UnparserWithReflection<C, O, P, EL, PM, S, COA, SSA, CT> extends AbstractUnparser
{
	protected final UMLReflection<?, C, O, P, EL, PM, S, COA, SSA, CT> uml;

	public UnparserWithReflection(Resource resource, UMLReflection<?, C, O, P, EL, PM, S, COA, SSA, CT> uml) {
		super(resource);
		this.uml = uml;
	}
	
	@Override protected String formatName(Object object) {
		return uml.getName(object);
	}

	@Override protected String formatQualifiedName(Object object) {
		return uml.getQualifiedName(object);
	}
	
	protected O getOperation(COA callOperationAction) {
		return (uml == null)? null : uml.getOperation(callOperationAction);
	}
	
	protected C getSignal(SSA sendSignalAction) {
		return (uml == null)? null : uml.getSignal(sendSignalAction);
	}
}
