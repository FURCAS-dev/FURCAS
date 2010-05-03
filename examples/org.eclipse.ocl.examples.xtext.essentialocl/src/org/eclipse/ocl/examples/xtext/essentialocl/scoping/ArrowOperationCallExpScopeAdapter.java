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
 * $Id: ArrowOperationCallExpScopeAdapter.java,v 1.1 2010/05/03 05:38:00 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;

public class ArrowOperationCallExpScopeAdapter extends EssentialOCLScopeAdapter<RoundBracketExpCS>
{
	public ArrowOperationCallExpScopeAdapter(RoundBracketExpCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else {
			filteredAccesses.addNamedElement(EssentialOCLCSTPackage.Literals.VARIABLE_CS, getTarget().getVariable1());
			filteredAccesses.addNamedElement(EssentialOCLCSTPackage.Literals.VARIABLE_CS, getTarget().getVariable2());
		}
	}
}
