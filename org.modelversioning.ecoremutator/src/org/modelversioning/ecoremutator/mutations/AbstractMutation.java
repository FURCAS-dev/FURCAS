/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.mutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.ecoremutator.EcoreMutatorPlugin;

/**
 * Abstract implementation of the {@link Mutation} interface providing basic
 * facilities for mutation implementations.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public abstract class AbstractMutation implements Mutation {

	/**
	 * Default plug in id.
	 */
	private String pluginId = EcoreMutatorPlugin.PLUGIN_ID;

	/**
	 * The logger of this mutation.
	 */
	private ILog logger = EcoreMutatorPlugin.getDefault().getLog();

	/**
	 * The options of this mutation.
	 */
	private Map<Object, Object> options = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLogger(ILog logger) {
		this.logger = logger;
	}

	/**
	 * Returns the currently used plugin id for logging.
	 * 
	 * @return the pluginId currently used.
	 */
	protected String getPluginId() {
		return pluginId;
	}

	/**
	 * Sets the currently used plugin id for logging.
	 * 
	 * @param pluginId
	 *            the pluginId to set
	 */
	protected void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	/**
	 * Logs the specified <code>message</code> for the specified
	 * <code>severity</code>.
	 * 
	 * @param severity
	 *            to use.
	 * @param message
	 *            to log.
	 */
	protected void log(int severity, String message) {
		IStatus status = new Status(severity, pluginId, message);
		this.logger.log(status);
	}

	/**
	 * Logs the specified <code>message</code> with the specified
	 * <code>exception</code> for the specified <code>severity</code>.
	 * 
	 * @param severity
	 *            to use.
	 * @param message
	 *            to log.
	 * @param exception
	 *            to log.
	 */
	protected void log(int severity, String message, Throwable exception) {
		IStatus status = new Status(severity, pluginId, message, exception);
		this.logger.log(status);
	}

	/**
	 * Returns the logger to use.
	 * 
	 * @return to use.
	 */
	protected ILog getLogger() {
		return this.logger;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOptions(Map<Object, Object> options) {
		this.options = options;
	}

	/**
	 * Returns the option value for the specified <code>key</code>.
	 * 
	 * @param key
	 *            key of the searched option.
	 * @return the value of the option or <code>null</code>.
	 */
	public Object getOptionValue(String key) {
		if (this.options != null) {
			return this.options.get(key);
		}
		return null;
	}

	/**
	 * Returns the option value for the specified <code>key</code>. If no value
	 * is set, this method returns the <code>defaultValue</code>.
	 * 
	 * @param key
	 *            key of the searched option.
	 * @param defaultValue
	 *            default value to return if no value is set.
	 * @return the value of the option or <code>defaultValue</code>.
	 */
	public Object getOptionValue(String key, Object defaultValue) {
		if (this.options != null) {
			return this.options.get(key);
		}
		return defaultValue;
	}

	/**
	 * Creates a list containing the specified <code>eObject</code>.
	 * 
	 * @param eObject
	 *            to add to the created list.
	 * @return a list containing <code>eObject</code>.
	 */
	protected static List<EObject> toEObjectList(EObject eObject) {
		List<EObject> list = new ArrayList<EObject>();
		if (eObject != null) {
			list.add(eObject);
		}
		return list;
	}

	/**
	 * Creates a list containing the specified <code>feature</code>.
	 * 
	 * @param feature
	 *            to add to the created list.
	 * @return a list containing <code>feature</code>.
	 */
	protected static List<EStructuralFeature> toFeatureList(
			EStructuralFeature feature) {
		List<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		if (feature != null) {
			list.add(feature);
		}
		return list;
	}

}
