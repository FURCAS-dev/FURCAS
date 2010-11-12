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
 * $Id: OperatorExpScopeAdapter.java,v 1.2 2010/05/29 15:31:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS;


public abstract class OperatorExpScopeAdapter<T extends OperatorExpCS> extends SubExpScopeAdapter<T>
{
	public OperatorExpScopeAdapter(T csElement) {
		super(csElement);
	}

	@Override
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		if (containmentFeature == EssentialOCLCSTPackage.Literals.SUB_EXP_CS__SOURCE) {
			return getParentSourceScope();
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.INFIX_EXP_CS__ARGUMENT) {
			return getScopeAdapter(getTarget().getSource());
		}
		else {
			return super.getSourceScope(containmentFeature);
		}
	}

	protected boolean isNavigation(OperatorExpCS opExp) {
		String op = opExp.getOp();
		if (".".equals(op)) {
			return true;
		}
		if ("->".equals(op)) {
			return true;
		}
		return false;
	}
}
