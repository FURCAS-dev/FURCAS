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
 * $Id: ElementCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.scope.RootCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.pivot.AbstractScopeAdapter;

/**
 * An ElementCSScopeAdapter provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements.
 *
 * @param <T>
 */
public abstract class ElementCSScopeAdapter<CS extends ElementCS> extends AbstractScopeAdapter<CS> implements ScopeCSAdapter
{	
	protected final RootCSScopeAdapter root;
	protected long unresolveableModificationCount = -1;
	
	protected ElementCSScopeAdapter(TypeManager typeManager, CS csElement) {
		this(typeManager, getScopeCSAdapter((ElementCS) csElement.eContainer()), csElement);
	}

	protected ElementCSScopeAdapter(TypeManager typeManager, ScopeCSAdapter parent, CS target) {
		super(typeManager, parent, target);
		this.root = parent != null ? parent.getRootScopeAdapter() : null;	// Seems to be null on Outline refresh ?? thread conflict ??
		assert (root != null) || (target instanceof RootCS);
	}	

	public RootCSScopeAdapter getRootScopeAdapter() {
		return root;
	}
	
	public boolean isUnresolvable() {
		return (root == null) || (unresolveableModificationCount >= root.getModificationCount());
	}

	public void setUnresolvable() {
		if (root != null) {
			unresolveableModificationCount = root.getModificationCount();
		}
	}

	@Override
	public String toString() {
		return target.toString();
	}
}
