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
 * $Id: ArrowOperationCallExpScopeAdapter.java,v 1.6 2010/05/24 08:55:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibBoundClassCS;

public class ArrowOperationCallExpScopeAdapter extends SubExpScopeAdapter<RoundBracketExpCS>
{
	public ArrowOperationCallExpScopeAdapter(RoundBracketExpCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		ScopeView outerScope = scopeView.getOuterScope();
		TypeBindingsCS bindings = scopeView.getBindings();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.NAMED_EXP_CS__NAME) {
			ScopeAdapter sourceScope = getParentSourceScope();
			ClassifierCS csType = sourceScope.getSynthesizedType(bindings);
			ScopeAdapter typeScope = getScopeAdapter(csType);
			if (typeScope != null) {		// FIXME - need to pass argument types so that operation can be specialized
				typeScope.getInnerScopeView(null, bindings).computeLookupWithParents(environmentView);
			}
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.ROUND_BRACKET_EXP_CS__ARGUMENTS) {
			RoundBracketExpCS target = getTarget();
			environmentView.addNamedElement(EssentialOCLCSTPackage.Literals.VARIABLE_CS, target.getVariable1(), bindings);
			environmentView.addNamedElement(EssentialOCLCSTPackage.Literals.VARIABLE_CS, target.getVariable2(), bindings);
			ClassifierCS libraryCollectionType = getLibraryCollectionType();
			ScopeAdapter sourceScope = getParentSourceScope();
			ClassifierCS csType = sourceScope.getSynthesizedType(bindings);
			ClassifierCS elementType = null;
			if (!conformsTo(csType, libraryCollectionType, bindings)) {
				elementType = csType;
			}
			else if (csType instanceof LibBoundClassCS) {
				TypeBindingsCS boundBindings = ((LibBoundClassCS)csType).getBindings();
				List<TypeBindingCS> bindings2 = boundBindings.getBindings();
				elementType = bindings2.get(0).getTypeArgument();
			}
			ScopeAdapter typeScope = getScopeAdapter(elementType);
			if (typeScope != null) {
				typeScope.getInnerScopeView(null, bindings).computeLookupWithParents(environmentView);
			}
		}
		return outerScope;
	}

	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		NameExpCS nameExp = getTarget().getName();
		NamedElementCS namedElement = nameExp != null ? nameExp.getNamedElement() : null;
		return getLibraryType(namedElement, bindings);
	}
}
