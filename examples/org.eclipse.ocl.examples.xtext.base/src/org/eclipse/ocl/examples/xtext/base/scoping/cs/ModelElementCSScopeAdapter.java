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
 * $Id: ModelElementCSScopeAdapter.java,v 1.3 2011/02/08 17:43:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

/**
 * A ModelElementCSScopeAdapter provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements and pivot element counterparts.
 *
 * @param <T>
 */
public abstract class ModelElementCSScopeAdapter<CS extends ModelElementCS, P extends Element> extends ElementCSScopeAdapter<CS>
{	
	protected final Class<CS> csClass;
	protected final Class<P> pivotClass;
	
	/**
	 * Creates an instance.
	 * @param parent 
	 */
	protected ModelElementCSScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		this(typeManager, csElement.eContainer(), csElement, pivotClass);
	}
	
	protected ModelElementCSScopeAdapter(TypeManager typeManager, EObject csParent, CS csElement, Class<P> pivotClass) {
		this(typeManager, csParent != null ? getScopeCSAdapter((ElementCS) csParent) : null, csElement, pivotClass);
	}

	@SuppressWarnings("unchecked")
	private ModelElementCSScopeAdapter(TypeManager typeManager, ScopeCSAdapter parentScopeAdapter, CS csElement, Class<P> pivotClass) {
		super(typeManager, parentScopeAdapter, csElement);
		this.csClass = (Class<CS>) csElement.getClass();
		this.pivotClass = pivotClass;
	}

	public P getPivot() {
		Element pivot = target.getPivot();
		if (pivot ==  null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivot.getClass())) {
			throw new ClassCastException("Incorrect pivot class");
		}
		@SuppressWarnings("unchecked")
		P castPivot = (P) pivot;
		return castPivot;
	}

	/**
	 * Return the scope in which to resolve an element following a list of namespaces.
	 */
	protected ScopeView getNamespaceScope(EnvironmentView environmentView,
			ScopeView scopeView, List<Namespace> namespaces) {
		int namespaceCount = namespaces.size();
		if (namespaceCount > 0) {
			ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, namespaces.get(namespaceCount-1));
			if (scopeAdapter != null) {
				return scopeAdapter.computeLookup(environmentView, scopeView);
			}				
			return null;
		}
		return scopeView.getOuterScope();
	}

	/**
	 * Return the scope in which to resolve a member of a list of namespaces.
	 * <p>
	 * This code assumes that the calling context attempts to resolve namespaces
	 * from the outer most, so that the first proxy denotes the next namespace to resolve.
	 */
	protected ScopeView getNextNamespaceScope(EnvironmentView environmentView,
			ScopeView scopeView, EList<Namespace> namespaces) {
		// FIXME Use this for all namespace lists and all nested qualified names
		InternalEList<Namespace> internalNamespaces = (InternalEList<Namespace>)namespaces;
		int iMax = internalNamespaces.size();
		for (int i = 0; i < iMax; i++) {
			Namespace namespace = internalNamespaces.basicGet(i);
			if (namespace.eIsProxy()) {
				if (i <= 0) {
					return scopeView.getOuterScope();
				}
				else {
					ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, internalNamespaces.get(iMax-1));
					if (scopeAdapter != null) {
						return scopeAdapter.computeLookup(environmentView, scopeView);
					}
					else {
						return null;
					}
				}
			}
		}
		return null;
	}
}
