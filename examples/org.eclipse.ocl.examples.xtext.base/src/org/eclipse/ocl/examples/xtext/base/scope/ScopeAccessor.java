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
 * $Id: ScopeAccessor.java,v 1.3 2010/05/09 10:38:01 ewillink Exp $
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
	
	@Override
	public IEObjectDescription getContentByName(String name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		FilteredAccesses descriptions = new FilteredAccesses(targetReference, name);
		return getFilteredContent(descriptions);
	}

	public IEObjectDescription getFilteredContent(FilteredAccesses filteredAccesses) {
		scopeAdapter.createContents(filteredAccesses, containmentFeature);
		int size = filteredAccesses.getSize();
		if (size == 0) {
			IScope outerScope = getOuterScope();
			if (outerScope instanceof ScopeAccessor) {
				return ((ScopeAccessor)outerScope).getFilteredContent(filteredAccesses);
			}
			else {
				return null;
			}
		}
		else if (size == 1){
			return filteredAccesses.getContent();
		}
		else {
			Collection<IEObjectDescription> contents = filteredAccesses.getContents();
			// FIXME error for ambiguous
			return contents.iterator().next();
		}
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
		FilteredAccesses descriptions = new FilteredAccesses(targetReference, null);
		scopeAdapter.createContents(descriptions, containmentFeature);
		return descriptions.getContents();
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