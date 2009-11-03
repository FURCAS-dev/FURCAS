package com.sap.mi.gfw.mapping;

import java.util.Collections;
import java.util.List;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.IDataMapping;

/**
 * The Class StructureMappingMulti.
 */
public abstract class StructureMappingMulti extends StructureMapping implements IStructureMappingMulti {

	/**
	 * Instantiates a new structure mapping multi.
	 * 
	 * @param dataMapping
	 *            the data mapping
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public StructureMappingMulti(IDataMapping dataMapping, IMappingProvider mappingProvider) {
		super(dataMapping, mappingProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.IStructureMappingMulti#getLinkCreationInfos(java.lang.Object)
	 */
	public List<ILinkCreationInfo> getLinkCreationInfos(Object mainBusinessObject) {
		ILinkCreationInfo linkCreationInfo = new LinkCreationInfo(mainBusinessObject);
		return Collections.singletonList(linkCreationInfo);
	}
}
