package com.sap.mi.gfw.autolayout;

import y.layout.LayoutOrientation;
import y.layout.hierarchic.HierarchicGroupLayouter;
import y.layout.hierarchic.HierarchicLayouter;

/**
 * An implementation of the interface ILayouterProvider, which returns the Layouter depending on the values in the
 * DefaultAutoLayoutPreferences.
 */
public class DefaultLayouterFactory {

	/**
	 * Gets the hierarchical group layouter.
	 * 
	 * @return the hierarchical group layouter
	 */
	public static HierarchicGroupLayouter getHierarchicalGroupLayouter() {

		HierarchicGroupLayouter hierarchicGroupLayouter = new HierarchicGroupLayouter();

		hierarchicGroupLayouter.setLayoutOrientation(LayoutOrientation.BOTTOM_TO_TOP);
		hierarchicGroupLayouter.setMinimalLayerDistance(20);
		hierarchicGroupLayouter.setMinimalNodeDistance(20);
		hierarchicGroupLayouter.setMinimalEdgeDistance(20);
		hierarchicGroupLayouter.setLayoutStyle(HierarchicLayouter.LINEAR_SEGMENTS);
		hierarchicGroupLayouter.setLayeringStrategy(HierarchicLayouter.LAYERING_HIERARCHICAL_TIGHT_TREE);
		hierarchicGroupLayouter.setRoutingStyle(HierarchicLayouter.ROUTE_ORTHOGONAL);

		return hierarchicGroupLayouter;
	}
}