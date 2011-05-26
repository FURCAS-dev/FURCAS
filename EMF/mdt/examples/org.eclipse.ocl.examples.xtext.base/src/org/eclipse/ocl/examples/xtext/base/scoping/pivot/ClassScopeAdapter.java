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
 * $Id: ClassScopeAdapter.java,v 1.10 2011/05/21 14:56:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ClassScopeAdapter extends AbstractPivotScopeAdapter<org.eclipse.ocl.examples.pivot.Class>
{
	private static void addAllContents(EnvironmentView environmentView, Type forType, ScopeView scopeView,
			org.eclipse.ocl.examples.pivot.Class pivotClass, Boolean selectStatic, Set<Type> alreadyVisited) {
		TypeManager typeManager = environmentView.getTypeManager();
		environmentView.addNamedElements(forType, typeManager.getLocalOperations(pivotClass, selectStatic));
		environmentView.addNamedElements(forType, typeManager.getLocalProperties(pivotClass, selectStatic));
		alreadyVisited.add(pivotClass);
		if (!environmentView.hasFinalResult()) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : typeManager.getSuperClasses(pivotClass)) {
				if (!alreadyVisited.contains(superClass)) {
					addAllContents(environmentView, forType, scopeView, superClass, selectStatic, alreadyVisited);
				}
			}
		}
	}
	
	public ClassScopeAdapter(TypeManager typeManager, org.eclipse.ocl.examples.pivot.Class pivotElement) {
		super(typeManager, pivotElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		if (target.getOwningTemplateParameter() != null) {
			return null;
		}
		if (target.getTemplateBindings().size() == 0) {
			environmentView.addElements(PivotUtil.getTypeTemplateParameterables(target));
		}
		TypeManager typeManager = environmentView.getTypeManager();
		if (target instanceof ClassifierType) {
			Type instanceType = ((ClassifierType)target).getInstanceType();
			if ((instanceType instanceof org.eclipse.ocl.examples.pivot.Class) && (instanceType.getOwningTemplateParameter() == null)) {		// Maybe null
				environmentView.addNamedElements(instanceType, typeManager.getLocalOperations(instanceType, Boolean.TRUE));
				environmentView.addNamedElements(instanceType, typeManager.getLocalProperties(instanceType, Boolean.TRUE));
			}
		}
		environmentView.addNamedElements(target, typeManager.getLocalOperations(target, Boolean.FALSE));
		environmentView.addNamedElements(target, typeManager.getLocalProperties(target, Boolean.FALSE));
		if (!environmentView.hasFinalResult()) {
			if (target instanceof ClassifierType) {
				Set<Type> alreadyVisitedMetaTypes = new HashSet<Type>();
				Type instanceType = ((ClassifierType)target).getInstanceType();
				if ((instanceType instanceof org.eclipse.ocl.examples.pivot.Class) && (instanceType.getOwningTemplateParameter() == null)) {		// Maybe null
					addAllContents(environmentView, instanceType, scopeView, (org.eclipse.ocl.examples.pivot.Class)instanceType, Boolean.TRUE, alreadyVisitedMetaTypes);
				}
			}	// FIXME don't shorten non-static search after static match
			Set<Type> alreadyVisitedTypes = new HashSet<Type>();
			for (org.eclipse.ocl.examples.pivot.Class superClass : typeManager.getSuperClasses(target)) {
				addAllContents(environmentView, target, scopeView, superClass, Boolean.FALSE, alreadyVisitedTypes);
			}
		}
		return scopeView.getOuterScope();
	}
}
