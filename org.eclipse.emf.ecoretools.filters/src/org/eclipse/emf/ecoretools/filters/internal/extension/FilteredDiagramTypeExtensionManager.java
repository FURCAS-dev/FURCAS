/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: FilteredDiagramTypeExtensionManager.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecoretools.filters.diagramfilters.IDiagramFilter;
import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;

public class FilteredDiagramTypeExtensionManager implements IRegistryChangeListener {

	private static FilteredDiagramTypeExtensionManager instance;

	private static final String ATT_MODEL_ID = "modelId"; //$NON-NLS-1$

	private static final String ATT_DIAGRAM_FILTER = "diagramFilter"; //$NON-NLS-1$

	public static FilteredDiagramTypeExtensionManager getInstance() {
		if (instance == null) {
			instance = new FilteredDiagramTypeExtensionManager();
		}
		return instance;
	}

	private Map<String, FilteredDiagramTypeExtension> filteredDiagramType;

	private FilteredDiagramTypeExtensionManager() {
		Platform.getExtensionRegistry().addRegistryChangeListener(this);
		filteredDiagramType = new HashMap<String, FilteredDiagramTypeExtension>();
		initialize();
	}

	/**
	 * Add extension to map
	 * 
	 * @param extension
	 */
	private void addFilteredDiagramTypeExtension(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		// Iterates on all the nodes
		for (int j = 0; j < elements.length; j++) {
			IConfigurationElement extElement = elements[j];

			if (checkRequiredTags(extElement)) {
				String modelId = extElement.getAttribute(ATT_MODEL_ID);

				// The autosarDiagramTypeInitializer is not yet defined.
				if (!filteredDiagramType.containsKey(modelId)) {
					FilteredDiagramTypeExtension filteredDiagramTypeExtension = new FilteredDiagramTypeExtension(modelId);

					try {
						if (extElement.getAttribute(ATT_DIAGRAM_FILTER) != null) {
							IDiagramFilter diagramFilter = (IDiagramFilter) FilterPlugin.createExtension(extElement, ATT_DIAGRAM_FILTER);

							filteredDiagramTypeExtension.setDiagramFilter(diagramFilter);
						}

						// Store it in the cache
						filteredDiagramType.put(modelId, filteredDiagramTypeExtension);
					} catch (CoreException ce) {
						FilterPlugin.log(ce);
					}
				}
			}
		}
	}

	/**
	 * Only for the tag : ATT_MODEL_ID
	 * 
	 * @param extendedClassLoaderElement
	 *            element
	 * 
	 * @return <code>true</code> if the Tags exist
	 */
	private boolean checkRequiredTags(IConfigurationElement extendedClassLoaderElement) {
		String modelId = extendedClassLoaderElement.getAttribute(ATT_MODEL_ID);

		return (!"".equals(modelId)); //$NON-NLS-1$
	}

	public Map<String, FilteredDiagramTypeExtension> getFilteredDiagramType() {
		initialize();

		return filteredDiagramType;
	}

	public FilteredDiagramTypeExtension getFilteredDiagramTypeExtension(String modelId) {
		FilteredDiagramTypeExtension filteredDiagramTypeExtension = filteredDiagramType.get(modelId);

		return filteredDiagramTypeExtension;
	}

	private void initialize() {
		if (filteredDiagramType.isEmpty()) {
			retrieveTypeProviders();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IRegistryChangeListener#registryChanged(org.eclipse.core.runtime.IRegistryChangeEvent)
	 */
	public void registryChanged(IRegistryChangeEvent event) {
		// TODO Auto-generated method stub

	}

	private void retrieveTypeProviders() {
		// Iterate on extension points.
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(FilterPlugin.PLUGIN_ID, FilterPlugin.FILTERED_DIAGRAM_TYPE_EXTENSION_ID);

		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			addFilteredDiagramTypeExtension(extensions[i]);
		}
	}
}