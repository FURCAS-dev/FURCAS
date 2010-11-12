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
 * $Id: ScopeAdapter.java,v 1.2 2010/05/21 20:06:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;

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
		ScopeAdapter doInPackageSwitch(EObject eObject);
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

	void computeLookup(EnvironmentView environmentView, EReference targetReference, TypeBindingsCS bindings);

	DocumentScopeAdapter getDocumentScopeAdapter();

	ScopeView getInnerScopeView(EReference targetReference, TypeBindingsCS bindings);

	ScopeView getOuterScopeView(EReference targetReference, TypeBindingsCS bindings);
	
	ScopeAdapter getParent();

	String getSignature();
	
	ScopeAdapter getSourceScope(EStructuralFeature containmentFeature);

	/**
	 * Return the <i>Synthesized Attribute</i> corresponding to the type of the AST
	 * element associated with the target.
	 * 
	 * @return the type or null if unknown
	 */
	ClassifierCS getSynthesizedType(TypeBindingsCS bindings);

	EObject getTarget();
	
	boolean isUnresolvable();

	void setUnresolvable();
}
