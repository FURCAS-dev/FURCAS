package com.sap.mi.gfw.autolayout;

import y.layout.BufferedLayouter;
import y.layout.LayoutGraph;
import y.layout.Layouter;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.internal.autolayout.DefaultGraphTransformation;
import com.sap.mi.gfw.internal.autolayout.IGraphTransformation;

/**
 * The Class AutoLayoutEngine.
 */
public class AutoLayoutEngine {

	/**
	 * Auto layout.
	 * 
	 * @param layouter
	 *            the layouter
	 * @param featureProvider
	 *            the feature provider
	 * @param layoutStructureProvider
	 *            the layout structure provider
	 */
	public static void autoLayout(Layouter layouter, IFeatureProvider featureProvider, ILayoutStructureProvider layoutStructureProvider) {
		if (layouter == null || featureProvider == null || layoutStructureProvider == null) {
			return;
		}
		IGraphTransformation defaultGraphTransformation = new DefaultGraphTransformation(featureProvider, layoutStructureProvider);
		autoLayout(layouter, defaultGraphTransformation);
	}

	/**
	 * Auto layout.
	 * 
	 * @param layouter
	 *            the layouter
	 * @param graphTransformation
	 *            the graph transformation
	 */
	public static void autoLayout(Layouter layouter, IGraphTransformation graphTransformation) {
		if (layouter == null || graphTransformation == null) {
			return;
		}

		// create graph
		LayoutGraph graph = graphTransformation.createLayoutGraph();

		// perform layout
		BufferedLayouter bufferedLayouter = new BufferedLayouter(layouter);
		if (bufferedLayouter.canLayout(graph))
			bufferedLayouter.doLayout(graph);

		graphTransformation.performLayoutGraph(graph);
	}
}