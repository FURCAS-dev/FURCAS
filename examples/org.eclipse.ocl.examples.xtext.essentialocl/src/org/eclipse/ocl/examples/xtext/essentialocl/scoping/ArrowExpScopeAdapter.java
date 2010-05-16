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
 * $Id: ArrowExpScopeAdapter.java,v 1.4 2010/05/16 19:19:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;


public class ArrowExpScopeAdapter extends SubExpScopeAdapter<ArrowExpCS>
{
//	private ClassifierCS sourceType1 = null;

	public ArrowExpScopeAdapter(ArrowExpCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.ARROW_EXP_CS__ARGUMENT) {
			ScopeAdapter sourceScope = getScopeAdapter(getTarget().getSource());
			TypeBindingsCS bindings = scopeView.getBindings();
			ClassifierCS csType = sourceScope.getSynthesizedType(bindings);
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
		return scopeView.getOuterScope();
	}

	@Override
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		if (containmentFeature == EssentialOCLCSTPackage.Literals.SUB_EXP_CS__SOURCE) {
			return getParentSourceScope();
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.ARROW_EXP_CS__ARGUMENT) {
			return getScopeAdapter(getTarget().getSource());
		}
		else {
			return super.getSourceScope(containmentFeature);
		}
	}

/*	@Override
	public ClassifierCS getSynthesizedType(EStructuralFeature containmentFeature) {
		if (containmentFeature == EssentialOCLCSTPackage.Literals.SUB_EXP_CS__SOURCE) {
			return getInheritedSynthesizedType();
		}
		else if (containmentFeature == EssentialOCLCSTPackage.Literals.ARROW_EXP_CS__ARGUMENT) {
			return getSourceType();
		}
		else {
			return super.getSynthesizedType(containmentFeature);
		}
	} */

/*	protected ClassifierCS getSourceType() {
		if (sourceType == null) {
			ExpCS source = getTarget().getSource();
			ScopeAdapter sourceScope = getScopeAdapter(source);
			if (sourceScope != null) {
				ClassifierCS type = sourceScope.getSynthesizedType();
				ClassifierCS collectionType = getLibraryCollectionType();
				if (!conformsTo(type, collectionType)) {
					sourceType = getLibraryType(collectionType.getName(), type);
				}
				else {
					sourceType = type;
				}
			}
		}
		return sourceType;
	} */
}
