/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
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
