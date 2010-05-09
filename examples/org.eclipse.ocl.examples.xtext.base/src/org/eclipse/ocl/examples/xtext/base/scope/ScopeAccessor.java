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
 * $Id: ScopeAccessor.java,v 1.4 2010/05/09 17:08:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * ScopeAccessors support access to some or all of the elements in a scope.
 * Accesses are filtered on the fly since a cache of results does not remain valid
 * for long enough to merit it, with incremental reparsing regularly trashing
 * the CST.
 */
public class ScopeAccessor extends AbstractScope
{
	protected final AbstractScopeAdapter<?> scopeAdapter;
	protected final EStructuralFeature containmentFeature;
	protected final EReference targetReference;
	
	public ScopeAccessor(AbstractScopeAdapter<?> scopeAdapter, EStructuralFeature containmentFeature, EReference targetReference) {
		this.scopeAdapter = scopeAdapter;
		this.containmentFeature = containmentFeature;
		this.targetReference = targetReference;
	}

	public IEObjectDescription computeInheritedEnvironmentView(EnvironmentView environmentView) {
		boolean continueInOuterScopes = scopeAdapter.computeInheritedEnvironmentView(environmentView, containmentFeature);
		int size = environmentView.getSize();
		if (size == 0) {
			if (continueInOuterScopes) {
				IScope outerScope = getOuterScope();
				if (outerScope instanceof ScopeAccessor) {
					return ((ScopeAccessor)outerScope).computeInheritedEnvironmentView(environmentView);
				}
			}
			scopeAdapter.computeInheritedEnvironmentView(environmentView, containmentFeature);
			return null;
		}
		else if (size == 1){
			return environmentView.getContent();
		}
		else {
			Collection<IEObjectDescription> contents = environmentView.getContents();
			// FIXME error for ambiguous
			return contents.iterator().next();
		}
	}
	
	@Override
	public IEObjectDescription getContentByName(String name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		EnvironmentView environmentView = new EnvironmentView(targetReference, name);
		return computeInheritedEnvironmentView(environmentView);
	}

	public final IScope getOuterScope() {
		AbstractScopeAdapter<?> parent = scopeAdapter.getParent();
		if (parent == null) {
			return IScope.NULLSCOPE;
		}
		EStructuralFeature eContainingFeature = getTarget().eContainingFeature();
		return new ScopeAccessor(parent, eContainingFeature, targetReference);
	}

	public void getPrefix(StringBuffer s) {
		s.append(getTarget().eClass().getName());
		if (containmentFeature != null) {
			s.append("::"); //$NON-NLS-1$
			s.append(containmentFeature.getName());
		}
	}

	public EObject getTarget() {
		return scopeAdapter.getTarget();
	}

	@Override
	protected final Iterable<IEObjectDescription> internalGetContents() {
		EnvironmentView environmentView = new EnvironmentView(targetReference, null);
		scopeAdapter.computeInheritedEnvironmentView(environmentView, containmentFeature);
		return environmentView.getContents();
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("["); //$NON-NLS-1$
		getPrefix(s);
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(getTarget()));
		return s.toString();
	}
}