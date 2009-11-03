package com.sap.mi.gfw.eclipse.platform;

import java.util.Hashtable;

import com.sap.mi.gfw.eclipse.T;
import com.sap.mi.gfw.platform.AbstractGFWExtension;

public abstract class AbstractImageProvider extends AbstractGFWExtension implements IImageProvider {

	private String pluginId;

	private Hashtable<String, String> htKeyImage = new Hashtable<String, String>();

	public AbstractImageProvider() {
		super();
		addAvailableImages();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.platform.IImageProvider#getPluginId()
	 */
	final public String getPluginId() {
		return pluginId;
	}

	/**
	 * @param pluginId
	 *            The pluginId to set.
	 */
	final public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.platform.IImageProvider#getImageFilePath(java.lang.String)
	 */
	final public String getImageFilePath(String imageId) {
		Object htObject = htKeyImage.get(imageId);
		if (htObject instanceof String) {
			return (String) htObject;
		}
		return null;
	}

	final protected void addImageFilePath(String imageId, String imageFilePath) {
		if (htKeyImage.get(imageId) != null)
			T.racer().error("Image with ID '" + imageId + "' is already registered"); //$NON-NLS-1$ //$NON-NLS-2$

		htKeyImage.put(imageId, imageFilePath);
	}

	/**
	 * add all available images with addImageFilePath(String imageId, String imageFilePath);
	 */
	abstract protected void addAvailableImages();
}
