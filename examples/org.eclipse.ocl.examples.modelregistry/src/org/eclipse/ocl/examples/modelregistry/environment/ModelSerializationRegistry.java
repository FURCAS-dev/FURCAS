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
 * $Id: ModelSerializationRegistry.java,v 1.3 2010/04/08 06:23:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.environment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.modelregistry.model.ModelSerialization;
import org.eclipse.ocl.examples.modelregistry.model.NamedSerialization;

/**
 * The map of serialization name to resource factory.
 */
public class ModelSerializationRegistry
{
	public static abstract class FactorySerializationDelegate extends ClassDelegate<Resource.Factory> implements ModelSerialization
	{
		protected final String serializationName;
		
		public FactorySerializationDelegate(String serializationName, String className) {
			super(className, Resource.Factory.class);
			this.serializationName = serializationName;
		}

		public FactorySerializationDelegate(String serializationName, Resource.Factory instance) {
			super(instance);
			this.serializationName = serializationName;
		}

		public String getFactoryClassName() { return className; }

		public String getName() { return serializationName; }
	}
	
	public static class SerializationFactory extends FactorySerializationDelegate
	{
		public SerializationFactory(String serializationName, Resource.Factory instance) {
			super(serializationName, instance);
		}

		@Override protected Class<?> loadClass(String className) { return null; }
	}

	private final Map<String, ModelSerialization> serializations = new HashMap<String, ModelSerialization>();

	public void addSerializationFactory(String name, Resource.Factory instance) {
		serializations.put(name, new SerializationFactory(name, instance));
	}

	public void addSerializationFactoryDelegate(String name, ModelSerialization modelSerialization) {
		serializations.put(name, modelSerialization);
	}

	public FactorySerializationDelegate getSerialization(String name) {
		ModelSerialization modelSerialisation = serializations.get(name);
		return ClassUtils.asClassOrNull(modelSerialisation, FactorySerializationDelegate.class);
	}

	public ModelSerialization getSerializationOrCreate(String name) {
		ModelSerialization modelSerialization = serializations.get(name);
		if (modelSerialization == null) {
			modelSerialization = new NamedSerialization(name);
			serializations.put(name, modelSerialization);
		}
		return modelSerialization;
	}

	public Collection<String> getSerializations() {
		return serializations.keySet();
	}
}
