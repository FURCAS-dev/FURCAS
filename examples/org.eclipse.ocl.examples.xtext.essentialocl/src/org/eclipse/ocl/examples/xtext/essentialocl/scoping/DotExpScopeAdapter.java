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
 * $Id: DotExpScopeAdapter.java,v 1.3 2010/05/09 17:08:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;


public class DotExpScopeAdapter extends EssentialOCLScopeAdapter<DotExpCS>
{
	public DotExpScopeAdapter(DotExpCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.DOT_EXP_CS__ARGUMENT) {
			ExpCS source = getTarget().getSource();
			AbstractScopeAdapter<?> sourceScope = getScopeAdapter(source);
			if (sourceScope == null) {
				return true;
			}
			TypeCS type = sourceScope.getType();
			AbstractScopeAdapter<?> typeScope = getScopeAdapter(type);
			if (typeScope == null) {
				return true;
			}
			typeScope.getInclusiveScopeAccessor(null).computeInheritedEnvironmentView(environmentView);	// Non-null value
		}
		return true;
	}

	@Override
	public TypeCS getType() {
		ExpCS argument = getTarget().getArgument();
		return getScopeAdapter(argument).getType();
	}
}
