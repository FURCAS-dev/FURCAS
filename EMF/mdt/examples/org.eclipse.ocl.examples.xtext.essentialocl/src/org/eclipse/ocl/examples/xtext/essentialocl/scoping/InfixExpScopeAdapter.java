/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: InfixExpScopeAdapter.java,v 1.5 2010/05/21 20:12:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;

public class InfixExpScopeAdapter extends OperatorExpScopeAdapter<InfixExpCS>
{
	public InfixExpScopeAdapter(InfixExpCS csElement) {
		super(csElement);
	}

	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		ExpCS argument = getTarget().getArgument();
		return getScopeAdapter(argument).getSynthesizedType(bindings);
	}

/*	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		InfixExpCS target = getTarget();		
		ExpCS source = target.getSource();
		TypeCS sourceType = getScopeAdapter(source).getSynthesizedType(bindings);
		ScopeAdapter sourceScopeAdapter = getScopeAdapter(sourceType);
		if (sourceScopeAdapter == null) {
			return null;
		}
		IScope sourceScope = sourceScopeAdapter.getOuterScopeView(null, bindings);
		if (sourceScope == null) {
			return null;
		}
		IEObjectDescription selfDescription = sourceScope.getContentByName(target.getOp());
		if (selfDescription == null) {
			return null;
		}
		EObject csOperation = selfDescription.getEObjectOrProxy();
		if (!(csOperation instanceof OperationCS)) {
			return null;
		}
		return getLibraryType((OperationCS)csOperation, bindings);
	} */
}
