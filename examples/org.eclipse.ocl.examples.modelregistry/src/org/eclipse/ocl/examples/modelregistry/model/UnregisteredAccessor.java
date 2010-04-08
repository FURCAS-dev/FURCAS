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
 * $Id: UnregisteredAccessor.java,v 1.2 2010/04/08 06:23:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

/**
 * An UnregisteredAccessor defines a key to access model registry entries by an 
 * unregistered accessor namespace.
 */
public class UnregisteredAccessor extends AbstractAccessor<UnregisteredAccessor>
{	
	public UnregisteredAccessor(String namespaceName, String name) {
		super(new AccessorNamespace<UnregisteredAccessor>(namespaceName)
		{
			public UnregisteredAccessor newInstance(String name) throws Exception {
				throw new UnsupportedOperationException(getClass().getName() + ".newInstance");
			}
		}, name);
	}
}
