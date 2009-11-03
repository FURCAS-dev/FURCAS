package com.sap.mi.fwk.ui;

import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;

/**
 * Image provider serving default error and warning marker images.
 * 
 * @author d024127
 * 
 */
public class ImageProvider {

	public static final String DECORATOR_ERROR_IMAGE = MiFwkUIPlugin.DECORATOR_ERROR_IMAGE;
	public static final String DECORATOR_WARNING_IMAGE = MiFwkUIPlugin.DECORATOR_WARNING_IMAGE;

	/**
	 * Returns the corresponding image descriptor.
	 * 
	 * @param key
	 *            The image key
	 * @return The image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		return MiFwkUIPlugin.getDefault().getImageDescriptor(key);
	}
}
