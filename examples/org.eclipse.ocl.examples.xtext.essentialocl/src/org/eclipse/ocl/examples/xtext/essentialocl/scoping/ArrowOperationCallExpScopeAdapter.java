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
 * $Id: ArrowOperationCallExpScopeAdapter.java,v 1.3 2010/05/09 10:32:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
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
		if (containmentFeature == EssentialOCLCSTPackage.Literals.ROUND_BRACKET_EXP_CS__ARGUMENTS) {
			RoundBracketExpCS target = getTarget();
			filteredAccesses.addNamedElement(EssentialOCLCSTPackage.Literals.VARIABLE_CS, target.getVariable1());
			filteredAccesses.addNamedElement(EssentialOCLCSTPackage.Literals.VARIABLE_CS, target.getVariable2());
//			filteredAccesses.addElement("self", target.getVariable1().getType());
		}
	}
}
