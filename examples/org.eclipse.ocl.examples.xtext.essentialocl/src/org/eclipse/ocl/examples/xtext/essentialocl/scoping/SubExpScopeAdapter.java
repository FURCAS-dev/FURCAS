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
 * $Id: SubExpScopeAdapter.java,v 1.1 2010/05/16 19:19:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;


public abstract class SubExpScopeAdapter<T extends ExpCS> extends EssentialOCLScopeAdapter<T>
{
	public SubExpScopeAdapter(T csElement) {
		super(csElement);
	}

	/*	public ClassifierCS getInheritedSynthesizedType() {
			if (parent == null) {
				return null;
			} else {
				return parent.getSynthesizedType(getTarget().eContainingFeature());
			}
		} */

	protected ScopeAdapter getParentSourceScope() {
		return getParent().getSourceScope(getTarget().eContainingFeature());
	}
}
