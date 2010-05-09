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
 * $Id: DefScopeAdapter.java,v 1.3 2010/05/09 17:08:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
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
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == CompleteOCLCSTPackage.Literals.DEF_CS__PARAMETERS) {
		}
		else {
			environmentView.addNamedElements(EssentialOCLCSTPackage.Literals.VARIABLE_CS, getTarget().getParameters());
//			environmentView.addElement("result", operation);	// FIXME transient VariableCS		
//			environmentView.addElement("self", (ElementCS) operation.eContainer());
		}
		return true;
	}
}
