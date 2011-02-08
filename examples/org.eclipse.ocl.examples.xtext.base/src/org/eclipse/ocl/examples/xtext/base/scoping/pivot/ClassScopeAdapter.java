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
 * $Id: ClassScopeAdapter.java,v 1.3 2011/02/08 17:43:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import java.util.List;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ClassScopeAdapter extends AbstractPivotScopeAdapter<org.eclipse.ocl.examples.pivot.Class>
{
	public ClassScopeAdapter(TypeManager typeManager, org.eclipse.ocl.examples.pivot.Class pivotElement) {
		super(typeManager, pivotElement);
	}

	public void addInheritedContents(EnvironmentView environmentView, org.eclipse.ocl.examples.pivot.Class target, ScopeView scopeView) {
		List<org.eclipse.ocl.examples.pivot.Class> superClasses = target.getSuperClasses();
		if (superClasses.size() > 0) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : superClasses) {
				environmentView.addElementsOfScope(typeManager, superClass, scopeView);
			}
		}
		else {
			Type anyType = typeManager.getOclAnyType();
			Type libType = typeManager.getClassifierType();
			if ((libType != target) && (anyType != target)){		// FIXME Is this the right place for the trap
				addLibContents(environmentView, libType, scopeView);
			}
		}
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		org.eclipse.ocl.examples.pivot.Class unspecializedPivot;
		if (target.getTemplateBindings().size() > 0) {
			unspecializedPivot = PivotUtil.getUnspecializedTemplateableElement(target);
		}
		else {
			unspecializedPivot = target;
			environmentView.addElements(PivotUtil.getTypeTemplateParameterables(target));
		}
		environmentView.addNamedElements( unspecializedPivot.getOwnedOperations());
		environmentView.addNamedElements(unspecializedPivot.getOwnedAttributes());
		if (!environmentView.hasFinalResult()) {
//			if (environmentView.getRequiredType() != BaseCSTPackage.Literals.TYPE_CS) { // Avoid creating bindings for nested type parameters
			addInheritedContents(environmentView, unspecializedPivot, scopeView);
//			if ((environmentView.getSize() == 0) && (environmentView.getRequiredType() != BaseCSTPackage.Literals.TYPE_CS)) { // Avoid creating bindings for nested type parameters
//				for (org.eclipse.ocl.examples.pivot.Class superClass : pivot.getSuperClasses()) {
//					ScopeView nestedScopeView = scopeView;
//	//				if (csType instanceof BoundClassifierCS) {
//	//					nestedScopeView = new BaseScopeView(scopeView, ((BoundClassifierCS)csType).getBindings());
//	//				}
//					environmentView.addElementsOfScope(superClass, nestedScopeView);
//				}
		}
		return scopeView.getOuterScope();
	}

/*	@Override
	public TypeManager getTypeManager() {
		Resource resource = target.eResource();
		return TypeManager.getAdapter(resource.getResourceSet());
	} */
}
