/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: DefScopeAdapter.java,v 1.5 2011/01/24 21:08:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLCSScopeAdapter;

public class DefScopeAdapter extends EssentialOCLCSScopeAdapter<DefCS, TypedElement>
{
	public DefScopeAdapter(TypeManager typeManager, DefCS csElement) {
		super(typeManager, csElement, TypedElement.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSTPackage.Literals.DEF_CS__PARAMETERS) {
			return scopeView.getOuterScope();
		}
		else {
			TypedElement pivot = getPivot();
			if (pivot instanceof Operation) {
				environmentView.addNamedElements(((Operation)pivot).getOwnedParameters());
			}
//			environmentView.addElement("result", operation);	// FIXME transient VariableCS		
//			environmentView.addElement("self", (ElementCS) operation.eContainer());
			return scopeView.getOuterScope();
		}
	}
}
