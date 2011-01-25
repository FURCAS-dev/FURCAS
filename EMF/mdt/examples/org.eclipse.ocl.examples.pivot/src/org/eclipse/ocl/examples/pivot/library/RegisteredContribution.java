/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: RegisteredContribution.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.plugin.RegistryReader.PluginClassDescriptor;

public interface RegisteredContribution<C extends RegisteredContribution<C>> {

	/**
	 * A registry of contributions.
	 */
	interface Registry<C extends RegisteredContribution<C>> extends Map<String, C> {
	}
	/**
	 * A <code>Factory</code> wrapper that is used by the
	 * {@link Factory.Registry}.
	 */
	interface Descriptor<C extends RegisteredContribution<C>> extends RegisteredContribution<C> {

		IConfigurationElement getElement();
	}

	abstract class AbstractDescriptor<C extends RegisteredContribution<C>> extends PluginClassDescriptor implements Descriptor<C>
	{
		protected C contribution;

		public AbstractDescriptor(IConfigurationElement e, String attrName) {
			super(e, attrName);
		}

		protected abstract C createContribution();

		public IConfigurationElement getElement() {
			return element;
		}
		
		public C getContribution() {
			if (contribution == null) {
				contribution = createContribution();
			}
			return contribution;
		}
	}	

	class AbstractRegistry<C extends RegisteredContribution<C>> extends HashMap<String, C> implements Registry<C>
	{
		private static final long serialVersionUID = 1L;

		@Override
		public C get(Object key) {
			C contribution = super.get(key);
			return contribution != null ? contribution.getContribution() : null;
		}
	}
	
	C getContribution();
}
