package com.sap.mi.gfw.platform.ga;

import com.sap.mi.gfw.IGraphicsAlgorithmHolder;
import com.sap.mi.gfw.dt.IDiagramTypeProviderHolder;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.pictograms.PlatformGraphicsAlgorithm;

/**
 * The Interface IRendererContext.
 */
public interface IRendererContext extends IDiagramTypeProviderHolder, IGraphicsAlgorithmHolder {

	/**
	 * Gets the mapping provider.
	 * 
	 * @return the mapping provider
	 */
	IMappingProvider getMappingProvider();

	/**
	 * Gets the platform graphics algorithm.
	 * 
	 * @return the platform graphics algorithm
	 */
	PlatformGraphicsAlgorithm getPlatformGraphicsAlgorithm();
}
