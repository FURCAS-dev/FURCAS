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
 * $Id: DefScopeAdapter.java,v 1.4 2010/05/16 19:26:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;

public class DefScopeAdapter extends EssentialOCLScopeAdapter<DefCS>
{
	public DefScopeAdapter(DefCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSTPackage.Literals.DEF_CS__PARAMETERS) {
			return scopeView.getOuterScope();
		}
		else {
			environmentView.addNamedElements(EssentialOCLCSTPackage.Literals.VARIABLE_CS, getTarget().getParameters(), scopeView.getBindings());
//			environmentView.addElement("result", operation);	// FIXME transient VariableCS		
//			environmentView.addElement("self", (ElementCS) operation.eContainer());
			return scopeView.getOuterScope();
		}
	}
}
