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
 * $Id: StandardLibraryContribution.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.resource.Resource;

public interface StandardLibraryContribution extends RegisteredContribution<StandardLibraryContribution>
{
	static Registry<StandardLibraryContribution> REGISTRY = new AbstractRegistry<StandardLibraryContribution>();

	static class Descriptor extends AbstractDescriptor<StandardLibraryContribution> implements StandardLibraryContribution
	{
		protected StandardLibraryContribution contribution;

		public Descriptor(IConfigurationElement e, String attrName) {
			super(e, attrName);
		}

		@Override
		protected StandardLibraryContribution createContribution() {
			Object createInstance = createInstance();
			return (StandardLibraryContribution) createInstance;
		}

		public Resource getResource() {
			return getContribution().getResource();
		}
	}

	static final class Null implements StandardLibraryContribution
	{
		public StandardLibraryContribution getContribution() {
			return this;
		}

		public Resource getResource() {
			return null;
		}
	}
	
	/**
	 * A Null contribution may be installed to exploit the manually loaded content
	 * as the standard library.
	 */
	static StandardLibraryContribution NULL = new Null();
	
	/**
	 * Return the resource containing the contribution to the standard library.
	 * 
	 * @return the contributing resource.
	 */
	Resource getResource();
}
