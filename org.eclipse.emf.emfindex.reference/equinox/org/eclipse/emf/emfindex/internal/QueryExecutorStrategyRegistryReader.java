/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfindex.EmfIndexPlugin;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.Logger;
import org.eclipse.emf.emfindex.query.Query;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorStrategy;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorWithStrategies;
import org.eclipse.emf.emfindex.util.StringUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author koehnlein
 * 
 */
@Singleton
public class QueryExecutorStrategyRegistryReader {

	private static final String EXTENSION_POINT_ID = "queryExecutorStrategy";

	/**
	 * Fully qualified extension point id by name convention: {@link EmfIndexPlugin#PLUGIN_ID} + "."+
	 * {@link #EXTENSION_POINT_ID}
	 */
	public static final String FQ_EXTENSION_POINT_ID = EmfIndexPlugin.PLUGIN_ID + "." + EXTENSION_POINT_ID;

	public static final String CLASS_ATTRIBUTE_NAME = "class";
	public static final String PRIORITY_ATTRIBUTE_NAME = "priority";

	@SuppressWarnings("unchecked")
	@Inject
	public QueryExecutorStrategyRegistryReader(QueryExecutorWithStrategies queryExecutorWithStrategies, Logger logger) {
		IConfigurationElement[] configurationElementsFor = Platform.getExtensionRegistry().getConfigurationElementsFor(
				FQ_EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : configurationElementsFor) {
			try {
				QueryExecutorStrategy<?, Query<?>, ? extends Index> strategy = (QueryExecutorStrategy<?, Query<?>, ? extends Index>) configurationElement
						.createExecutableExtension(CLASS_ATTRIBUTE_NAME);
				int priority = QueryExecutorStrategy.DEFAULT_PRIORITY;
				String priorityAttribute = configurationElement.getAttribute(PRIORITY_ATTRIBUTE_NAME);
				try {
					priority = Integer.parseInt(priorityAttribute);
				} catch (NumberFormatException e) {
					String className = configurationElement.getAttribute(CLASS_ATTRIBUTE_NAME);
					logger.logError(StringUtils.concat("Invalid priority ", priorityAttribute, " for class ",
							className, ". Using default priority."));
				}
				queryExecutorWithStrategies.addQueryExecutorStrategy(strategy, priority);
			} catch (CoreException e) {
				logger.logError(e.getMessage(), e);
			}
		}
	}
}
