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
 * $Id: InfixExpScopeAdapter.java,v 1.1 2010/05/03 05:37:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;


public class InfixExpScopeAdapter extends EssentialOCLScopeAdapter<InfixExpCS>
{
	public InfixExpScopeAdapter(InfixExpCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.INFIX_EXP_CS__ARGUMENT) {
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
		InfixExpCS target = getTarget();		
		ExpCS source = target.getSource();
		TypeCS sourceType = getScopeAdapter(source).getType();
		AbstractScopeAdapter<?> sourceScopeAdapter = getScopeAdapter(sourceType);
		if (sourceScopeAdapter == null) {
			return null;
		}
		IScope sourceScope = sourceScopeAdapter.getExclusiveScopeAccessor(null);
		if (sourceScope == null) {
			return null;
		}
		IEObjectDescription selfDescription = sourceScope.getContentByName(target.getOp());
		if (selfDescription == null) {
			return null;
		}
		EObject csOperation = selfDescription.getEObjectOrProxy();
		if (!(csOperation instanceof OperationCS)) {
			return null;
		}
		return getLibType((OperationCS)csOperation);
	}
}
