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
 * $Id: MonikeredElementCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;

/**
 * A ModelElementCSScopeAdapter provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements and pivot element counterparts.
 *
 * @param <T>
 */
public abstract class MonikeredElementCSScopeAdapter<CS extends MonikeredElementCS, P extends MonikeredElement> extends ModelElementCSScopeAdapter<CS, P>
{	
	/**
	 * Creates an instance.
	 * @param parent 
	 */
	protected MonikeredElementCSScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		super(typeManager, csElement, pivotClass);
	}
	
	protected MonikeredElementCSScopeAdapter(TypeManager typeManager, EObject csParent, CS csElement, Class<P> pivotClass) {
		super(typeManager, csParent, csElement, pivotClass);
	}

	public final String getMoniker() {
		return CS2Moniker.toString(target);
	}

	@Override
	public String toString() {
		return String.valueOf(getMoniker());
	}
}
