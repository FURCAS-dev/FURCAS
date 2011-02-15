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
 * $Id: BaseScopeView.java,v 1.5 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.xtext.naming.QualifiedName;
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
	@Deprecated
	private static ScopeView getParent(ScopeAdapter scopeAdapter, EReference targetReference) {
		ScopeAdapter parent = scopeAdapter.getParent();
		if (parent == null) {
			return ScopeView.NULLSCOPEVIEW;
		}
		EObject target = scopeAdapter.getTarget();
		EStructuralFeature eContainingFeature = target.eContainingFeature();
		return new BaseScopeView(parent, target, eContainingFeature, targetReference);
	}
	
	protected final ScopeAdapter scopeAdapter;					// Adapting the CST node
	protected final EObject child;								// Child targeted by containmentFeature, null for child-independent
	protected final EStructuralFeature containmentFeature;		// Selecting child-specific candidates, null for child-independent
	protected final EReference targetReference;					// Selecting permissible candidate types
	
	public BaseScopeView(ScopeAdapter scopeAdapter, EObject child, EStructuralFeature containmentFeature, EReference targetReference) {
		super(getParent(scopeAdapter, targetReference), false);
		this.scopeAdapter = scopeAdapter;
		this.child = child;
		this.containmentFeature = containmentFeature;
		this.targetReference = targetReference;
	}

	public BaseScopeView(ScopeView scopeView) {
		super(getParent(scopeView.getScopeAdapter(), scopeView.getTargetReference()), false);
		this.scopeAdapter = scopeView.getScopeAdapter();
		this.child = scopeView.getChild();
		this.containmentFeature = scopeView.getContainmentFeature();
		this.targetReference = scopeView.getTargetReference();
	}

	public void computeLookupWithParents(EnvironmentView environmentView) {
		// FIXME This is not a usefully distinct functionality
		ScopeView outerScope = scopeAdapter.computeLookup(environmentView, this);
		if (outerScope != null) {
			if (!environmentView.hasFinalResult()) {
				outerScope.computeLookupWithParents(environmentView);
			}
		}
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		EnvironmentView environmentView = new EnvironmentView(getTypeManager(), targetReference, null);
		computeLookupWithParents(environmentView);
		return environmentView.getDescriptions();
	}

	public EObject getChild() {
		return child;
	}

	public EStructuralFeature getContainmentFeature() {
		return containmentFeature;
	}
	
//	@Override
//	public IEObjectDescription getContentByName(String name) {
//		if (name == null)
//			throw new NullPointerException("name"); //$NON-NLS-1$
//		EnvironmentView environmentView = new EnvironmentView(targetReference, name);
//		return computeLookup(environmentView);
//	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		EnvironmentView environmentView = new EnvironmentView(getTypeManager(), targetReference, name.toString());
		int size = environmentView.computeLookups(this);
		if (size <= 0) {
			return null;
		}
		else if (size == 1) {
			return Collections.singletonList(environmentView.getDescription());
		}
		else {
			List<IEObjectDescription> contents = environmentView.getDescriptions();
			return contents;
		}
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		if (name == null)
			throw new NullPointerException("name"); //$NON-NLS-1$
		EnvironmentView environmentView = new EnvironmentView(getTypeManager(), targetReference, name.toString());
		int size = environmentView.computeLookups(this);
		if (size <= 0) {
			return null;
		}
		else if (size == 1) {
			return environmentView.getDescription();
		}
		else {
			return null;
//			return environmentView.getDescriptions().get(0);
		}
	}

	@Deprecated
	public ScopeView getOuterScope() {
		return (ScopeView) getParent();
	}
	
	public ScopeAdapter getScopeAdapter() {
		return scopeAdapter;
	}

	public final EObject getTarget() {
		return scopeAdapter.getTarget();
	}

	public EReference getTargetReference() {
		return targetReference;
	}

	private TypeManager getTypeManager() {
		return scopeAdapter.getTypeManager();
	}

	@Override
	protected final Iterable<IEObjectDescription> getAllLocalElements() {
		EnvironmentView environmentView = new EnvironmentView(getTypeManager(), targetReference, null);
		scopeAdapter.computeLookup(environmentView, this);
		return environmentView.getDescriptions();
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
/*		if (!bindings.getBindings().isEmpty()) {
			s.append("<"); //$NON-NLS-1$
			String prefix = ""; //$NON-NLS-1$
			for (TypeBindingCS binding : bindings.getBindings()) {
				s.append(prefix);
				s.append(binding.getSignature());
				prefix = ","; //$NON-NLS-1$
			}
			s.append(">"); //$NON-NLS-1$
		} */
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(target));
		return s.toString();
	}
}