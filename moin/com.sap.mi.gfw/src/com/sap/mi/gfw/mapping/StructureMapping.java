package com.sap.mi.gfw.mapping;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.IDataMapping;

/**
 * The Class StructureMapping.
 */
public abstract class StructureMapping extends MappingProviderProvider implements IStructureMapping {

	private IDataMapping dataMapping;

	/**
	 * Instantiates a new structure mapping.
	 * 
	 * @param dataMapping
	 *            the data mapping
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public StructureMapping(IDataMapping dataMapping, IMappingProvider mappingProvider) {
		super(mappingProvider);
		setDataMapping(dataMapping);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.IStructureMapping#getDataMapping()
	 */
	public IDataMapping getDataMapping() {
		return dataMapping;
	}

	private void setDataMapping(IDataMapping dataMapping) {
		this.dataMapping = dataMapping;
	}

}
