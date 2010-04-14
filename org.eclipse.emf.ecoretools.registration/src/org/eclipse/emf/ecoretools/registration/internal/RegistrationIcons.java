/***********************************************************************
 * Copyright (c) 2007, 2008 INRIA and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    INRIA - initial API and implementation
 *
 * $Id: RegistrationIcons.java,v 1.3 2008/05/12 21:50:02 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.registration.internal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import org.eclipse.emf.ecoretools.registration.RegistrationPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * This class is used as an images registry. It automatically loads some images
 * in the initialize method and provides a getImage method to access to image
 * corresponding to the given path.
 * 
 */
public class RegistrationIcons {

	/**
	 * This class is a singleton.
	 */
	static private RegistrationIcons instance = null;

	/**
	 * We need to access to images in the plugin hierarchy. This URL will help
	 * us.
	 */
	static final private URL pluginURL = RegistrationPlugin.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$

	/**
	 * This is the icons registry : a name corresponds to an image.
	 */
	private Hashtable<String, Image> icons = new Hashtable<String, Image>();

	/**
	 * A private constructor which just call an initialize method.
	 * 
	 */
	private RegistrationIcons() {
		initialize();
	}

	/**
	 * Loads some images whose name come from RegistrationConstants class.
	 * 
	 */
	private void initialize() {
		try {
			Image icon_folder = ImageDescriptor.createFromURL(new URL(pluginURL, "/icons/obj16/folder.gif")).createImage(); //$NON-NLS-1$
			Image icon_project = ImageDescriptor.createFromURL(new URL(pluginURL, "/icons/obj16/project.gif")).createImage(); //$NON-NLS-1$
			Image icon_ecoreModelFile = ImageDescriptor.createFromURL(new URL(pluginURL, "/icons/obj16/EcoreModelFile.gif")).createImage(); //$NON-NLS-1$
			Image icon_generatedPackage = ImageDescriptor.createFromURL(new URL(pluginURL, "/icons/obj16/generated_package.gif")).createImage(); //$NON-NLS-1$
			icons.put(RegistrationConstants.FOLDER, icon_folder); // instance
			icons.put(RegistrationConstants.PROJECT, icon_project);
			icons.put(RegistrationConstants.IMG_ECORE_FILE, icon_ecoreModelFile);
			icons.put(RegistrationConstants.IMG_GENERATED_PACKAGE, icon_generatedPackage);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves an image for the given path
	 * 
	 * @param path
	 * @return Image
	 */
	static public Image get(String path) {
		if (instance == null)
			instance = new RegistrationIcons();
		return instance.icons.get(path);
	}
}
