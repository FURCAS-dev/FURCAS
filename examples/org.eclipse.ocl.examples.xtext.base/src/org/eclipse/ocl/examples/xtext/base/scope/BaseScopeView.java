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
 * $Id: BaseScopeView.java,v 1.2 2010/05/21 20:06:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.AbstractScope;

/**
 * ScopeViews support access to some or all of the elements in a scope.
 * Accesses are filtered on the fly since a cache of results does not remain valid
 * for long enough to merit it, with incremental reparsing regularly trashing
 * the CST.
 */
public class BaseScopeView extends AbstractScope implements ScopeView
{
	protected final ScopeAdapter scopeAdapter;					// Adapting the CST node
	protected final EStructuralFeature containmentFeature;		// Selecting child-specific candidates, null for child-independent
	protected final EReference targetReference;					// Selecting permissible candidate types
	protected final TypeBindingsCS bindings;					// Configuring potential candidates
	
	public BaseScopeView(ScopeAdapter scopeAdapter, EStructuralFeature containmentFeature, EReference targetReference, TypeBindingsCS bindings) {
		this.scopeAdapter = scopeAdapter;
		this.containmentFeature = containmentFeature;
		this.targetReference = targetReference;
		this.bindings = bindings;
		assert bindings != null;
	}

	public BaseScopeView(ScopeView scopeView, TypeBindingsCS bindings) {
		this.scopeAdapter = scopeView.getScopeAdapter();
		this.containmentFeature = scopeView.getContainmentFeature();
		this.targetReference = scopeView.getTargetReference();
		this.bindings = bindings;
		assert bindings != null;
	}
	
	public IEObjectDescription computeLookup(EnvironmentView environmentView) {
		ScopeView outerScope = scopeAdapter.computeLookup(environmentView, this);
		int size = environmentView.getSize();
		if ((size == 0) || (environmentView.getName() == null)) {
			if (outerScope != null) {
				return outerScope.computeLookup(environmentView);
			}
//			scopeAdapter.computeLookup(environmentView, this);
			return null;
		}
		else if (size == 1) {
			return environmentView.getContent();
		}
		else {
			List<IEObjectDescription> contents = environmentView.getContents();
			// FIXME error for ambiguous
			return contents.get(0);
		}
	}

	public void computeLookupWithParents(EnvironmentView environmentView) {
		ScopeView outerScope = scopeAdapter.computeLookup(environmentView, this);
		if (outerScope != null) {
			if ((environmentView.getSize() == 0) || (environmentView.getName() == null)) {
				outerScope.computeLookupWithParents(environmentView);
			}
		}
	}

	public TypeBindingsCS getBindings() {
//		if (bindings == null) {
//			bindings = Collections.emptyList();
//		}
		return bindings;
	}

	public EStructuralFeature getContainmentFeature() {
		return containmentFeature;
	}
	
	@Override
	public IEObjectDescription getContentByName(String name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		EnvironmentView environmentView = new EnvironmentView(targetReference, name);
		return computeLookup(environmentView);
	}

	public final ScopeView getOuterScope() {
		ScopeAdapter parent = scopeAdapter.getParent();
		if (parent == null) {
			return ScopeView.NULLSCOPEVIEW;
		}
		EStructuralFeature eContainingFeature = getTarget().eContainingFeature();
		return new BaseScopeView(parent, eContainingFeature, targetReference, bindings);
	}

	public ScopeAdapter getScopeAdapter() {
		return scopeAdapter;
	}

	public EObject getTarget() {
		return scopeAdapter.getTarget();
	}

	public EReference getTargetReference() {
		return targetReference;
	}

	public ScopeView getUnqualifiedOuterScope(TypeBindingsCS bindings) {
		for (ScopeAdapter parent = scopeAdapter.getParent(); parent != null; parent = parent.getParent()) {
			EObject target = parent.getTarget();
			if (!(target instanceof QualifiedRefCS)) {
				EStructuralFeature eContainingFeature = target.eContainingFeature();
				return new BaseScopeView(parent, eContainingFeature, targetReference, bindings);
			}
		}
		return ScopeView.NULLSCOPEVIEW;
	}

	@Override
	protected final Iterable<IEObjectDescription> internalGetContents() {
		EnvironmentView environmentView = new EnvironmentView(targetReference, null);
		scopeAdapter.computeLookup(environmentView, this);
		return environmentView.getContents();
	}

	@Override
	public String toString() {
		EObject target = getTarget();
		StringBuffer s = new StringBuffer();
		s.append("["); //$NON-NLS-1$
		s.append(target.eClass().getName());
		if (containmentFeature != null) {
			s.append("::"); //$NON-NLS-1$
			s.append(containmentFeature.getName());
		}
		if (!bindings.getBindings().isEmpty()) {
			s.append("<"); //$NON-NLS-1$
			String prefix = ""; //$NON-NLS-1$
			for (TypeBindingCS binding : bindings.getBindings()) {
				s.append(prefix);
				s.append(binding.getSignature());
				prefix = ","; //$NON-NLS-1$
			}
			s.append(">"); //$NON-NLS-1$
		}
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(target));
		return s.toString();
	}
}