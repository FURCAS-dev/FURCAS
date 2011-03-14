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
 * $Id: LetExpCSScopeAdapter.java,v 1.5 2011/03/13 11:44:07 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

public class LetExpCSScopeAdapter extends ExpCSScopeAdapter<LetExpCS, LetExp>
{
	public LetExpCSScopeAdapter(TypeManager typeManager, LetExpCS csElement) {
		super(typeManager, csElement, LetExp.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		EObject child = scopeView.getChild();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.LET_EXP_CS__VARIABLE) {
			for (VariableCS csVariable : target.getVariable()) {
				if (csVariable == child) {
					break;
				}
				Variable variable = PivotUtil.getPivot(Variable.class, csVariable);
				if (variable != null) {		// Maybe null while resolving namespaces
					environmentView.addNamedElement(variable);
				}
			}
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.LET_EXP_CS__IN) {
			for (VariableCS csVariable : target.getVariable()) {
				Variable variable = PivotUtil.getPivot(Variable.class, csVariable);
				if (variable != null) {		// Maybe null while resolving namespaces
					environmentView.addNamedElement(variable);
				}
			}
		}
		return scopeView.getOuterScope();
	}
}
