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
 * $Id: DotExpScopeAdapter.java,v 1.2 2010/05/09 10:32:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;


public class DotExpScopeAdapter extends EssentialOCLScopeAdapter<DotExpCS>
{
	public DotExpScopeAdapter(DotExpCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.DOT_EXP_CS__ARGUMENT) {
			ExpCS source = getTarget().getSource();
			AbstractScopeAdapter<?> sourceScope = getScopeAdapter(source);
			if (sourceScope == null) {
				return;
			}
			TypeCS type = sourceScope.getType();
			AbstractScopeAdapter<?> typeScope = getScopeAdapter(type);
			if (typeScope == null) {
				return;
			}
			typeScope.getInclusiveScopeAccessor(null).getFilteredContent(filteredAccesses);	// Non-null value
		}
	}

	@Override
	public TypeCS getType() {
		ExpCS argument = getTarget().getArgument();
		return getScopeAdapter(argument).getType();
	}
}
