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
 * $Id: DefScopeAdapter.java,v 1.2 2010/05/09 10:37:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
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
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == CompleteOCLCSTPackage.Literals.DEF_CS__PARAMETERS) {
		}
		else {
			filteredAccesses.addNamedElements(EssentialOCLCSTPackage.Literals.VARIABLE_CS, getTarget().getParameters());
//			filteredAccesses.addElement("result", operation);	// FIXME transient VariableCS		
//			filteredAccesses.addElement("self", (ElementCS) operation.eContainer());
		}
	}
}
