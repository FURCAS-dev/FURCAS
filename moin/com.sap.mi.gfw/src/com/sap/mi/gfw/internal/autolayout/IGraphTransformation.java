package com.sap.mi.gfw.internal.autolayout;

import y.layout.LayoutGraph;

/**
 * The Interface IGraphTransformation.
 */
public interface IGraphTransformation {

	/**
	 * Creates the layout graph.
	 * 
	 * @return the layout graph
	 */
	LayoutGraph createLayoutGraph();

	/**
	 * Perform layout graph.
	 * 
	 * @param layoutGraph
	 *            the layout graph
	 */
	void performLayoutGraph(LayoutGraph layoutGraph);
}