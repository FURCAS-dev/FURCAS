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
 * $Id: ScopeAdapter.java,v 1.3 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * A AbstractScopeAdapter provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements.
 *
 * @param <T>
 */
public interface ScopeAdapter extends Adapter
{	
	public static interface Switch {
		ScopeAdapter createVisitor(EObject eObject);
//		ScopeAdapter doInPackageSwitch(EObject eObject);
	}
	
	/**
	 * Add the local lookup contributions to a view of an Environment.
	 * <p>
	 * The EnvironmentView contains the lookup matching criteria such as a specific name and
	 * accumulates candidate results.
	 * <p>
	 * The input ScopeView identifies the CST node and the containment of the CST child from which
	 * the lookup is made allowing derived implementations to present the alternative environments
	 * specified as the <i>Inherited Attributes</i> in the OCL Specification.
	 * <p>
	 * The returned ScopeView identifies an outer scope in which the lookup may be continued if the
	 * local candidate results are not suitable.
	 * 
	 * @param environmentView the EnvironmentView to compute
	 * @param scopeView the access selectivity to be applied by the lookup
	 * @return an outer ScopeView in which to continue the lookup, or null if none
	 */
	ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView);

	void computeLookup(EnvironmentView environmentView, EReference targetReference);

	ScopeView getInnerScopeView(EReference targetReference);

	ScopeView getOuterScopeView(EReference targetReference);
	
	ScopeAdapter getParent();

	TypeManager getTypeManager();

	RootScopeAdapter getRootScopeAdapter();
	
	ScopeAdapter getSourceScope(EStructuralFeature containmentFeature);

	EObject getTarget();
}
