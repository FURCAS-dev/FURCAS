package com.sap.mi.gfw.mapping;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.IDataMapping;

/**
 * The Class StructureMappingGrid.
 */
public abstract class StructureMappingGrid extends StructureMappingMulti implements IStructureMappingGrid {

	/**
	 * Instantiates a new structure mapping grid.
	 * 
	 * @param dataMapping
	 *            the data mapping
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public StructureMappingGrid(IDataMapping dataMapping, IMappingProvider mappingProvider) {
		super(dataMapping, mappingProvider);
	}

}
