package com.sap.mi.gfw.platform.ga;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PlatformGraphicsAlgorithm;

/**
 * The Class RendererContext.
 */
public class RendererContext implements IRendererContext {
	private PlatformGraphicsAlgorithm platformGraphicsAlgorithm;

	private IDiagramTypeProvider diagramTypeProvider;

	/**
	 * Instantiates a new renderer context.
	 * 
	 * @param pga
	 *            the pga
	 * @param dtp
	 *            the dtp
	 */
	public RendererContext(PlatformGraphicsAlgorithm pga, IDiagramTypeProvider dtp) {
		setPlatformGraphicsAlgorithm(pga);
		setDiagramTypeProvider(dtp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.ga.IRendererContext#getMappingProvider()
	 */
	public IMappingProvider getMappingProvider() {
		return getDiagramTypeProvider().getFeatureProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.platform.ga.IRendererContext#getPlatformGraphicsAlgorithm()
	 */
	public PlatformGraphicsAlgorithm getPlatformGraphicsAlgorithm() {
		return platformGraphicsAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.dt.IDiagramTypeProviderHolder#getDiagramTypeProvider()
	 */
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return diagramTypeProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.IGraphicsAlgorithmHolder#getGraphicsAlgorithm()
	 */
	public GraphicsAlgorithm getGraphicsAlgorithm() {
		return getPlatformGraphicsAlgorithm();
	}

	/**
	 * @param platformGraphicsAlgorithm
	 *            the platformGraphicsAlgorithm to set
	 */
	private void setPlatformGraphicsAlgorithm(PlatformGraphicsAlgorithm platformGraphicsAlgorithm) {
		this.platformGraphicsAlgorithm = platformGraphicsAlgorithm;
	}

	/**
	 * @param diagramTypeProvider
	 *            the diagramTypeProvider to set
	 */
	private void setDiagramTypeProvider(IDiagramTypeProvider diagramTypeProvider) {
		this.diagramTypeProvider = diagramTypeProvider;
	}
}
