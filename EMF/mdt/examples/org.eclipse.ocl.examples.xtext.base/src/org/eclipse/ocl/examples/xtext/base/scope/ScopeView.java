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
 * $Id: ScopeView.java,v 1.2 2010/05/21 20:06:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * ScopeViews support access to some or all of the elements in a scope.
 * Accesses are filtered on the fly since a cache of results does not remain valid
 * for long enough to merit it, with incremental reparsing regularly trashing
 * the CST.
 */
public interface ScopeView extends IScope
{
	
    /**
     * The <code>NULLSCOPEVIEW</code> to be returned by the most outer scope
     */
    final ScopeView NULLSCOPEVIEW = new ScopeView()
    {
		public IEObjectDescription computeLookup(EnvironmentView environmentView) {
			return null;
		}
		
		public void computeLookupWithParents(EnvironmentView environmentView) {
		}
		
    	public Iterable<IEObjectDescription> getAllContents() {
    		return Collections.emptyList();
    	}
		
		public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
			return Collections.emptyList();
		}

		public TypeBindingsCS getBindings() {
			return null;
		}

		public EStructuralFeature getContainmentFeature() {
			return null;
		}

		public IEObjectDescription getContentByEObject(EObject object) {
			return null;
		}

		public IEObjectDescription getContentByName(String name) {
			return null;
		}

		public Iterable<IEObjectDescription> getContents() {
			return Collections.emptyList();
		}

		public ScopeView getOuterScope() {
			return NULLSCOPEVIEW;
		}

		public ScopeAdapter getScopeAdapter() {
			return null;
		}

		public EObject getTarget() {
			return null;
		}

		public EReference getTargetReference() {
			return null;
		}

		public ScopeView getUnqualifiedOuterScope(TypeBindingsCS bindings) {
			return NULLSCOPEVIEW;
		}
    };

    IEObjectDescription computeLookup(EnvironmentView environmentView);

    void computeLookupWithParents(EnvironmentView environmentView);

    TypeBindingsCS getBindings();

	EStructuralFeature getContainmentFeature();

	ScopeView getOuterScope();

	ScopeAdapter getScopeAdapter();

	EObject getTarget();
	
	EReference getTargetReference();

	ScopeView getUnqualifiedOuterScope(TypeBindingsCS bindings);
}