package com.sap.mi.gfw.mapping;

import com.sap.mi.gfw.features.IMappingProvider;

/**
 * The Class MappingProviderProvider.
 */
public abstract class MappingProviderProvider {

	private IMappingProvider mappingProvider;

	/**
	 * Instantiates a new mapping provider provider.
	 * 
	 * @param mappingProvider
	 *            the mapping provider
	 */
	public MappingProviderProvider(IMappingProvider mappingProvider) {
		setMappingProvider(mappingProvider);
	}

	private void setMappingProvider(IMappingProvider mappingProvider) {
		this.mappingProvider = mappingProvider;
	}

	/**
	 * Gets the mapping provider.
	 * 
	 * @return the mapping provider
	 */
	protected IMappingProvider getMappingProvider() {
		return mappingProvider;
	}

}
