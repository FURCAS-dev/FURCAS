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
 * $Id: ModelNameAccessor.java,v 1.2 2010/04/08 06:23:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

/**
 * A ModelNameAccessor defines a key to access model registry entries by an informal
 * model name.
 */
public final class ModelNameAccessor extends AbstractAccessor<ModelNameAccessor>
{
	public static final Namespace<ModelNameAccessor> NAMESPACE = new AccessorNamespace<ModelNameAccessor>("Model Name")
	{
		public ModelNameAccessor newInstance(String name)
		{
			return new ModelNameAccessor(name);
		}
	};

	public static class Installer implements Accessor.Installer<ModelNameAccessor>
	{
		public Namespace<ModelNameAccessor> getNamespace() { return NAMESPACE; }
	}

	public ModelNameAccessor(String name) {
		super(NAMESPACE, name);
	}
}
