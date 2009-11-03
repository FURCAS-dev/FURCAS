package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.links.PictogramLink;

/**
 * The Class LabelDataMapping.
 */
public abstract class LabelDataMapping extends TextDataMapping implements ILabelDataMapping {

	/**
	 * Instantiates a new label data mapping.
	 * 
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public LabelDataMapping(IMappingProvider mappingProvider) {
		super(mappingProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.IImageDataMapping#getImageId(com.sap.mi.gfw.mm.links.PictogramLink)
	 */
	public String getImageId(PictogramLink link) {
		return null;
	}

}
