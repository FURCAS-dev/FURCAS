package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.impl.AbstractCreateFeature;

/**
 * The Class CreateFeatureForPattern.
 */
public class CreateFeatureForPattern extends AbstractCreateFeature {
	private IFeatureForPattern delegate;

	/**
	 * Instantiates a new creates the feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public CreateFeatureForPattern(IFeatureProvider featureProvider, IPattern pattern) {
		super(featureProvider, pattern.getCreateName(), pattern.getCreateDescription());
		delegate = new FeatureForPatternDelegate(pattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreate#canCreate(com.sap.mi.gfw.features.context.ICreateContext)
	 */
	public boolean canCreate(ICreateContext context) {
		IPattern pattern = delegate.getPattern();
		boolean ret = /* pattern.isContextApplicable(context) && */pattern.canCreate(context);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreate#create(com.sap.mi.gfw.features.context.ICreateContext)
	 */
	public Object[] create(ICreateContext context) {
		return delegate.getPattern().create(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractCreateFeature#getCreateImageId()
	 */
	@Override
	public String getCreateImageId() {
		return delegate.getPattern().getCreateImageId();
	}

	@Override
	public String getCreateLargeImageId() {
		return delegate.getPattern().getCreateLargeImageId();
	}

	/**
	 * Gets the pattern.
	 * 
	 * @return the pattern
	 */
	public IPattern getPattern() {
		return delegate.getPattern();
	}

}
