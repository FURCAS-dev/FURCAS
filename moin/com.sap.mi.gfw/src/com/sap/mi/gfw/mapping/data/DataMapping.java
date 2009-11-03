package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.MappingProviderProvider;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DataMapping.
 */
public abstract class DataMapping extends MappingProviderProvider implements IDataMapping {

	private static final String DEFAULT_UPDATE_WARNING = Messages.DataMapping_0_xmsg;

	/**
	 * Instantiates a new data mapping.
	 * 
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public DataMapping(IMappingProvider mappingProvider) {
		super(mappingProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.data.IDataMapping#getUpdateWarning(com.sap.mi.gfw.mm.links.PictogramLink)
	 */
	public String getUpdateWarning(PictogramLink pictogramLink) {
		return DEFAULT_UPDATE_WARNING;
	}

	/**
	 * Gets the business object.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the business object
	 */
	protected Object getBusinessObject(PictogramLink link) {
		final IMappingProvider mp = getMappingProvider();
		final PictogramElement pe = link.getPictogramElement();
		return mp.getBusinessObjectForPictogramElement(pe);
	}
}
