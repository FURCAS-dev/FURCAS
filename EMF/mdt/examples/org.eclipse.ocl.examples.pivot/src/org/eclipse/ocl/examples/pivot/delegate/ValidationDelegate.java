/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: ValidationDelegate.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.ValidationDelegateRegistryImpl;

/**
 * A revised interface for delegating validation expression evaluation
 * adopting the same Factory, Registry, Descriptor architecture as the
 * invocation and setting delegates.
 * 
 * @since 3.0
 */
public interface ValidationDelegate extends EValidator.ValidationDelegate {

	/**
	 * A factory for creating delegate domains.
	 */
	interface Factory extends EValidator.ValidationDelegate {

		/**
		 * A <code>Factory</code> wrapper that is used by the
		 * {@link Factory.Registry}.
		 */
		interface Descriptor extends EValidator.ValidationDelegate.Descriptor {

			ValidationDelegate.Factory getValidationDelegate();
		}

		/**
		 * A registry of delegate domain factories.
		 */
		interface Registry extends EValidator.ValidationDelegate.Registry {

			ValidationDelegate.Factory getValidationDelegate(String uri);

			class Impl extends ValidationDelegateRegistryImpl implements Factory.Registry {

				private static final long serialVersionUID = 1L;

				@Override
				public ValidationDelegate.Factory getValidationDelegate(String uri) {
					return (ValidationDelegate.Factory) get(uri);
				}
			}
		}

		ValidationDelegate createValidationDelegate(EClassifier eClassifier);

		String getURI();
	}
}