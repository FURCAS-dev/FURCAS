package com.sap.mi.gfw.mapping;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.IDataMapping;

/**
 * The Class StructureMappingSingle.
 */
public abstract class StructureMappingSingle extends StructureMapping implements IStructureMappingSingle {

	/**
	 * Instantiates a new structure mapping single.
	 * 
	 * @param dataMapping
	 *            the data mapping
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public StructureMappingSingle(IDataMapping dataMapping, IMappingProvider mappingProvider) {
		super(dataMapping, mappingProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.IStructureMappingSingle#getLinkCreationInfo(java.lang.Object)
	 */
	public ILinkCreationInfo getLinkCreationInfo(Object mainBusinessObject) {
		return new LinkCreationInfo(mainBusinessObject);
	}
}
