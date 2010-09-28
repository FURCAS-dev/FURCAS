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
 * $Id: ArrowExpScopeAdapter.java,v 1.7 2010/09/28 16:28:37 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS;


public class ArrowExpScopeAdapter extends OperatorExpScopeAdapter<InfixExpCS>
{
//	private ClassifierCS sourceType1 = null;

	public ArrowExpScopeAdapter(InfixExpCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.INFIX_EXP_CS__ARGUMENT) {
			/*
			 * An Arrow argument is looked up in the scope of a Collection and if the
			 * source is not a Collection the source is promoted to a Singleton Set.
			 */
			ScopeAdapter sourceScope = getScopeAdapter(getTarget().getSource());
			if (sourceScope != null) {
				TypeBindingsCS bindings = scopeView.getBindings();
				ClassifierCS csType = sourceScope.getSynthesizedType(bindings);
				if (csType != null) {
					ClassifierCS libraryCollectionType = getLibraryCollectionType();
					ClassifierCS collectionType = null;
					if (conformsTo(csType, libraryCollectionType, bindings)) {
						collectionType = csType;
					}
					else {
						collectionType = getLibraryType("Set", csType);
					}
					ScopeAdapter typeScope = getScopeAdapter(collectionType);
					if (typeScope != null) {
						typeScope.getInnerScopeView(null, bindings).computeLookupWithParents(environmentView);
					}
				}
			}
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.SUB_EXP_CS__SOURCE) {
			ExpCS source = getTarget().getSource();
			if (source instanceof NameExpCS) {
				OperatorExpCS argumentParent = getTarget().getArgumentParent();
				if ((argumentParent == null) || !isNavigation(argumentParent)) {		// This is the left-most source e.g. source->arg
					environmentView.require(
						BaseCSTPackage.Literals.TYPE_CS,
						EssentialOCLCSTPackage.Literals.VARIABLE_CS,
						BaseCSTPackage.Literals.PARAMETER_CS,
						BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS);			
				}
				else {		// This is not the left-most source e.g. preamble.source->arg
					environmentView.require(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS);
				}
			}
		}
		return scopeView.getOuterScope();
	}

	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		ExpCS argument = getTarget().getArgument();
		return getScopeAdapter(argument).getSynthesizedType(bindings);
	}
}
