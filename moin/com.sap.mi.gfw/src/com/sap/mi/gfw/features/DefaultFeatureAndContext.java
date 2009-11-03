package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class DefaultFeatureAndContext.
 */
public class DefaultFeatureAndContext implements IFeatureAndContext {
	private IFeature feature;

	private IContext context;

	/**
	 * Instantiates a new default feature and context.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public DefaultFeatureAndContext(IFeature feature, IContext context) {
		super();
		setFeature(feature);
		setContext(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureHolder#getFeature()
	 */
	public IFeature getFeature() {
		return feature;
	}

	private void setFeature(IFeature feature) {
		this.feature = feature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IContextHolder#getContext()
	 */
	public IContext getContext() {
		return context;
	}

	private void setContext(IContext context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = this.getClass().getSimpleName();
		ret = ret + " (Feature: " + getFeature() + " - Context: " + getContext() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return ret;
	}
}
