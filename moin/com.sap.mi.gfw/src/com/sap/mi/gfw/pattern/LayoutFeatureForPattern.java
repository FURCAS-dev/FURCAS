package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.impl.AbstractLayoutFeature;

/**
 * The Class LayoutFeatureForPattern.
 */
public class LayoutFeatureForPattern extends AbstractLayoutFeature {
	private IFeatureForPattern delegate;

	/**
	 * Instantiates a new layout feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public LayoutFeatureForPattern(IFeatureProvider featureProvider, IPattern pattern) {
		super(featureProvider);
		delegate = new FeatureForPatternDelegate(pattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ILayout#canLayout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public boolean canLayout(ILayoutContext context) {
		IPattern pattern = delegate.getPattern();
		return pattern.canLayout(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ILayout#layout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public boolean layout(ILayoutContext context) {
		return delegate.getPattern().layout(context);
	}
}
