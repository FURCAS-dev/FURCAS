package com.sap.mi.gfw.eclipse.platform;

import com.sap.mi.gfw.platform.IGFWExtension;

public interface IImageProvider extends IGFWExtension {

	/**
	 * @param pluginId
	 *            The pluginId of the plug-in containing the image files provided by this image-provider
	 */
	void setPluginId(String pluginId);

	/**
	 * @return The pluginId of the plug-in containing the image files provided by this image-provider
	 */
	String getPluginId();

	/**
	 * This is a method simply returns the location of the image file in the plug-in. The path is relative to the root of the plug-in. The
	 * path must not have a leading "." or path separator. Clients should use a path like "icons/mysample.gif" rather than
	 * "./icons/mysample.gif" or "/icons/mysample.gif". </p>
	 * 
	 * @return imageFilePath the relative path of the image file, relative to the root of the plug-in; the path must be legal
	 */
	String getImageFilePath(String imageId);
}
