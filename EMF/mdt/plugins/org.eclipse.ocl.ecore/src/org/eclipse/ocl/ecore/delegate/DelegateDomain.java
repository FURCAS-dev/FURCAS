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
 * $Id: DelegateDomain.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

/**
 * A pluggable, dynamic implementation of a delegate domain supervising
 * delegated behavior.
 * 
 * @since 3.0
 */
public interface DelegateDomain {

	/**
	 * A factory for creating delegate domains.
	 */
	interface Factory {
		/**
		 * The global instance used when no factory is registered.
		 */
		Factory INSTANCE = new OCLDelegateDomainFactory();

		/**
		 * Creates the delegate domain for the specified <tt>ePackage</tt>.
		 * 
		 * @param ePackage
		 *            the package
		 * @return its delegate domain
		 */
		DelegateDomain createDelegateDomain(String delegateURI,
				EPackage ePackage);

		/**
		 * A <code>Factory</code> wrapper that is used by the
		 * {@link Factory.Registry}.
		 */
		interface Descriptor {

			DelegateDomain.Factory getFactory();
		}

		/**
		 * A registry of delegate domain factories.
		 */
		interface Registry
				extends Map<String, Object> {

			Factory.Registry INSTANCE = new Impl();

			DelegateDomain.Factory getFactory(String uri);

			class Impl
					extends HashMap<String, Object>
					implements Factory.Registry {

				private static final long serialVersionUID = 1L;

				@Override
				public Object get(Object key) {
					Object factory = super.get(key);
					if (factory instanceof Factory.Descriptor) {
						Factory.Descriptor factoryDescriptor = (Factory.Descriptor) factory;
						factory = factoryDescriptor.getFactory();
						put((String) key, factory);
						return factory;
					} else {
						return factory;
					}
				}

				public DelegateDomain.Factory getFactory(String uri) {
					return (DelegateDomain.Factory) get(uri);
				}
			}
		}
	}

	/**
	 * Dispose of this delegate domain releasing any resources cached to support
	 * delegated behaviour for the associated package.
	 */
	void dispose();

	/**
	 * Get the delegate domain name.
	 * 
	 * @return the delegate URI
	 */
	String getURI();
}