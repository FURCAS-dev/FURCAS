/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: StandardLibraryRegistryReader.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#INSTANCE
 * global} resource factory's
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getProtocolToFactoryMap()
 * protocol} map. Clients are not expected to use this class directly.
 */
public class StandardLibraryRegistryReader extends RegistryReader
{
	static final String TAG_LIBRARY = "library";
	static final String ATT_URI = "uri";
	static final String ATT_CLASS = "class";

	public StandardLibraryRegistryReader() {
		super(Platform.getExtensionRegistry(), PivotPlugin.getPlugin()
			.getBundle().getSymbolicName(), PivotPlugin.STANDARD_LIBRARY_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_LIBRARY)) {
			String uri = element.getAttribute(ATT_URI);
			if (uri == null) {
				logMissingAttribute(element, ATT_URI);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				Object previous = StandardLibraryContribution.REGISTRY
					.put(uri, new StandardLibraryContribution.Descriptor(element, ATT_CLASS));
				if (previous instanceof StandardLibraryContribution.Descriptor) {
					StandardLibraryContribution.Descriptor descriptor = (StandardLibraryContribution.Descriptor) previous;
					EcorePlugin.INSTANCE.log("Both '"
						+ descriptor.getElement().getContributor().getName()
						+ "' and '" + element.getContributor().getName()
						+ "' register a setting delegate factory for '" + uri
						+ "'");
				}
				return true;
			} else {
				StandardLibraryContribution.REGISTRY.remove(uri);
				return true;
			}
		}
	    return false;
	}
}
