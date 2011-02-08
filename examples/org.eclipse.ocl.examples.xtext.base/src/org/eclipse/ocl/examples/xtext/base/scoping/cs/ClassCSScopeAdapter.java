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
 * $Id: ClassCSScopeAdapter.java,v 1.3 2011/02/08 17:43:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ClassCSScopeAdapter extends BaseCSScopeAdapter<ClassCS, org.eclipse.ocl.examples.pivot.Class>
{
	public ClassCSScopeAdapter(TypeManager typeManager, ClassCS csElement) {
		super(typeManager, csElement, org.eclipse.ocl.examples.pivot.Class.class);
	}

	public void addInheritedContents(EnvironmentView environmentView, org.eclipse.ocl.examples.pivot.Class target, ScopeView scopeView) {
		List<org.eclipse.ocl.examples.pivot.Class> superClasses = target.getSuperClasses();
		if (superClasses.size() > 0) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : superClasses) {
					environmentView.addElementsOfScope(typeManager, superClass, scopeView);
			}
		}
		else {
			Type libType = typeManager.getClassifierType();
			addLibContents(environmentView, libType, scopeView);
		}
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
//		TypeBindingsCS bindings = scopeView.getBindings();
		org.eclipse.ocl.examples.pivot.Class pivot = getPivot();
		if (pivot != null) {
			if (containmentFeature == BaseCSTPackage.Literals.CLASS_CS__OWNED_SUPER_TYPE) {
				environmentView.addElements(PivotUtil.getTypeTemplateParameterables(pivot));
			}
			else if (containmentFeature == BaseCSTPackage.Literals.CLASS_CS__OWNED_META_TYPE) {
				environmentView.addNamedElement(typeManager.getBagTypeType());
				environmentView.addNamedElement(typeManager.getCollectionTypeType());
				environmentView.addNamedElement(typeManager.getOrderedSetTypeType());
				environmentView.addNamedElement(typeManager.getSequenceTypeType());
				environmentView.addNamedElement(typeManager.getSetTypeType());
				environmentView.addNamedElement(typeManager.getPrimitiveTypeType());
				//				environmentView.addElements(PivotPackage.Literals.TYPE, PivotUtil.getTypeTemplateParameterables(pivot));
			}
			else {
				environmentView.addNamedElements(pivot.getOwnedOperations());
				environmentView.addNamedElements(pivot.getOwnedAttributes());
				environmentView.addElements(PivotUtil.getTypeTemplateParameterables(pivot));
				if (!environmentView.hasFinalResult()) {
//					if (environmentView.getRequiredType() != BaseCSTPackage.Literals.TYPE_CS) { // Avoid creating bindings for nested type parameters
					addInheritedContents(environmentView, pivot, scopeView);
//				if ((environmentView.getSize() == 0) && (environmentView.getRequiredType() != BaseCSTPackage.Literals.TYPE_CS)) { // Avoid creating bindings for nested type parameters
//					for (org.eclipse.ocl.examples.pivot.Class superClass : pivot.getSuperClasses()) {
//						ScopeView nestedScopeView = scopeView;
//	//					if (csType instanceof BoundClassifierCS) {
//	//						nestedScopeView = new BaseScopeView(scopeView, ((BoundClassifierCS)csType).getBindings());
//	//					}
//						environmentView.addElementsOfScope(superClass, nestedScopeView);
//					}
				}
			}
		}
		return scopeView.getOuterScope();
	}
}
