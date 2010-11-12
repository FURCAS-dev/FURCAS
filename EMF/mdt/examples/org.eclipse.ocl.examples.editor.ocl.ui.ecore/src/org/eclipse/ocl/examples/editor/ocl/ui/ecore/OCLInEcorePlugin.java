/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: OCLInEcorePlugin.java,v 1.2 2010/03/13 13:16:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.MissingResourceException;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Logger;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.imp.runtime.PluginBase;
import org.eclipse.ocl.examples.editor.ui.imp.CommonEditorDefinition;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonPlugin;

public class OCLInEcorePlugin extends EMFPlugin
{
	public static final String kPluginID = "org.eclipse.ocl.examples.editor.ocl.ui"; //$NON-NLS-1$
	public static final String kLanguageName = "ocl"; //$NON-NLS-1$

	/**
	 * Keep track of the singleton.
	 */
	public static final OCLInEcorePlugin INSTANCE = new OCLInEcorePlugin();

	/**
	 * Keep track of the singleton.
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 */
	public OCLInEcorePlugin() {
		super(new ResourceLocator[] {});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	public static OCLInEcorePlugin.Implementation getInstance() {
		// SMS 11 Jul 2007
		// Added conditional call to constructor in case the plugin
		// class has not been auto-started
		if (plugin == null)
			new OCLInEcorePlugin();
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends PluginBase
		implements ICommonPlugin, ResourceLocator, Logger, EMFPlugin.InternalEclipsePlugin {

		public CommonEditorDefinition editorDefinition = null;
		/**
		 * The EMF plug-in APIs are all delegated to this helper, so that code
		 * can be shared by plug-in implementations with a different platform
		 * base class (e.g. Plugin).
		 */
		protected EMFPlugin.InternalHelper helper;

		/**
		 * Creates an instance. 
		 */
		public Implementation() {
			super();
			helper = new EMFPlugin.InternalHelper(this);

			// Remember the static instance.
			//
			plugin = this;
		}

		/**
		 * Does the work of fetching the image associated with the key. It
		 * ensures that the image exists.
		 * 
		 * @param key
		 *            the key of the image to fetch.
		 * @exception IOException
		 *                if an image doesn't exist.
		 * @return the description of the image associated with the key.
		 */
		protected Object doGetImage(String key) throws IOException {
			return helper.getImage(key);
		}

		@Override
		public String getID() {
			return kPluginID;
		}

		@Override
		public String getLanguageID() {
			return kLanguageName;
		}

		public CommonEditorDefinition getEditorDefinition() {
			if (editorDefinition == null)
				editorDefinition = CommonEditorDefinition.create(this,
						"model/" + kLanguageName + ".editor"); //$NON-NLS-1$ //$NON-NLS-2$
			return editorDefinition;
		}

		public URL getBaseURL() {
			return helper.getBaseURL();
		}

		public Object getImage(String key) {
			try {
				return doGetImage(key);
			} catch (MalformedURLException exception) {
				throw new WrappedException(exception);
			} catch (IOException exception) {
				throw new MissingResourceException(CommonPlugin.INSTANCE
						.getString("_UI_StringResourceNotFound_exception",
								new Object[] { key }), getClass().getName(),
						key);
			}
		}

		public String getString(String key) {
			return helper.getString(key, true);
		}

		public String getString(String key, boolean translate) {
			return helper.getString(key, translate);
		}

		public String getString(String key, Object[] substitutions) {
			return helper.getString(key, substitutions, true);
		}

		public String getString(String key, Object[] substitutions,
				boolean translate) {
			return helper.getString(key, substitutions, translate);
		}

		/**
		 * Return the plugin ID.
		 */
		public String getSymbolicName() {
			return helper.getSymbolicName();
		}

		public void log(Object logEntry) {
			helper.log(logEntry);
		}
	}
}
