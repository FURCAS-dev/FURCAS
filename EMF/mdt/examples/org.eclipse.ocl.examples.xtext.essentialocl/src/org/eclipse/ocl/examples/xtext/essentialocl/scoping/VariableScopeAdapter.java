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
 * $Id: VariableScopeAdapter.java,v 1.6 2010/05/29 15:31:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

public class VariableScopeAdapter extends EssentialOCLScopeAdapter<VariableCS>
{
	public VariableScopeAdapter(VariableCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.VARIABLE_CS__TYPE) {			
			return scopeView.getOuterScope();
		}
		else {
			TypeCS type = getTarget().getType();
			ClassifierCS libType = getLibraryType(type, scopeView.getBindings());
			environmentView.addElementsOfScope(libType, scopeView);
			return scopeView.getOuterScope();
		}
	}

	@Override
	public ClassifierCS getLibraryType(ElementCS csElement, TypeBindingsCS bindings) {
		// TODO Auto-generated method stub
		return super.getLibraryType(csElement, bindings);
	}
}
