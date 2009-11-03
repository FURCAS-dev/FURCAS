package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IResizeConfiguration;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.impl.DefaultResizeShapeFeature;

/**
 * The Class ResizeShapeFeatureForPattern.
 */
public class ResizeShapeFeatureForPattern extends DefaultResizeShapeFeature {

	private IFeatureForPattern delegate;

	/**
	 * Instantiates a new resize shape feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public ResizeShapeFeatureForPattern(IFeatureProvider featureProvider, IPattern pattern) {
		super(featureProvider);
		delegate = new FeatureForPatternDelegate(pattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.DefaultResizeShapeFeature#canResizeShape(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		IPattern pattern = delegate.getPattern();
		return pattern.canResizeShape(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.DefaultResizeShapeFeature#resizeShape(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	@Override
	public void resizeShape(IResizeShapeContext context) {
		delegate.getPattern().resizeShape(context);
	}

	@Override
	public IResizeConfiguration getResizeConfiguration() {
		IPattern pattern = delegate.getPattern();
		IResizeConfiguration resizeConfiguration = pattern.getResizeConfiguration();
		if (resizeConfiguration != null) {
			return resizeConfiguration;
		}
		return super.getResizeConfiguration();
	}
}
