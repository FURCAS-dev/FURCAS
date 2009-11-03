package com.sap.mi.gfw.platform.ga;

/**
 * A factory for creating IGraphicsAlgorithmRenderer objects.
 */
public interface IGraphicsAlgorithmRendererFactory {

	/**
	 * Creates a new IGraphicsAlgorithmRenderer object.
	 * 
	 * @param rendererContext
	 *            the renderer context
	 * 
	 * @return the i graphics algorithm renderer
	 */
	IGraphicsAlgorithmRenderer createGraphicsAlgorithmRenderer(IRendererContext rendererContext);
}
