/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: AbstractAccessor.java,v 1.2 2010/04/08 06:23:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;


/**
 * A ModelNameAccesor defines a key to access model registry entries by an informal
 * model name.
 */
public abstract class AbstractAccessor<A extends Accessor<A>> implements Accessor<A>
{
	protected final String name;
	protected final Namespace<A> namespace;
	
	protected AbstractAccessor(Namespace<A> namespace, String name) {
		this.namespace = namespace;
		this.name = name;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof AbstractAccessor<?>))
			return false;
		return name.equals(((AbstractAccessor<?>)object).name);
	}

	public String getName() { return name; }

	public Namespace<A> getNamespace() { return namespace; }

	@Override
	public int hashCode() {
		return name.hashCode() + 55;
	}
	
	@Override
	public String toString() { return name; }
}
