package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.links.PictogramLink;

/**
 * The Class TextDataMapping.
 */
public abstract class TextDataMapping extends DataMapping implements ITextDataMapping {

	/**
	 * Instantiates a new text data mapping.
	 * 
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public TextDataMapping(IMappingProvider mappingProvider) {
		super(mappingProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.data.ITextDataMapping#getText(com.sap.mi.gfw.mm.links.PictogramLink)
	 */
	public String getText(PictogramLink link) {
		return ""; //$NON-NLS-1$
	}
}
