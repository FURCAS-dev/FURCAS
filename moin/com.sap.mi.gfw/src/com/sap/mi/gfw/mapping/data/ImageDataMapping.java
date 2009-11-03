package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.links.PictogramLink;

/**
 * The Class ImageDataMapping.
 */
public abstract class ImageDataMapping extends DataMapping implements IImageDataMapping {

	/**
	 * Instantiates a new image data mapping.
	 * 
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public ImageDataMapping(IMappingProvider mappingProvider) {
		super(mappingProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.data.IImageDataMapping#getImageId(com.sap.mi.gfw.mm.links.PictogramLink)
	 */
	public String getImageId(PictogramLink link) {
		return null;
	}
}
