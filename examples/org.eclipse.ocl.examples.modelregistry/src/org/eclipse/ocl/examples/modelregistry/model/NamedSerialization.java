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
 * A NamedSerialisation defines the serialization of a model by an informal name,
 * and is used when the ModelSerialisationRegistryReader has no registration for that name.
 */
public class NamedSerialization implements ModelSerialization
{
	protected final String name;
	
	public NamedSerialization(String name) {
		this.name = name;
	}

	public String getFactoryClassName() { return null; }
	
	public String getName() { return name; }
}
