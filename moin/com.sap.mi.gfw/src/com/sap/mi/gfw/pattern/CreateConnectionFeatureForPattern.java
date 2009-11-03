package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.features.jam.AbstractCreateConnectionFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;

/**
 * The Class CreateConnectionFeatureForPattern.
 */
public class CreateConnectionFeatureForPattern extends AbstractCreateConnectionFeature {
	private IConnectionPattern delegate;

	/**
	 * Instantiates a new creates the connection feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public CreateConnectionFeatureForPattern(IFeatureProvider featureProvider, IConnectionPattern pattern) {
		super(featureProvider, pattern.getCreateName(), pattern.getCreateDescription());
		delegate = pattern;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateConnection#canCreate(com.sap.mi.gfw.features.context.ICreateConnectionContext)
	 */
	public boolean canCreate(ICreateConnectionContext context) {
		boolean ret = /* pattern.isContextApplicable(context) && */delegate.canCreate(context);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateConnection#canStartConnection(com.sap.mi.gfw.features.context.ICreateConnectionContext)
	 */
	public boolean canStartConnection(ICreateConnectionContext context) {
		return delegate.canStartConnection(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateConnection#create(com.sap.mi.gfw.features.context.ICreateConnectionContext)
	 */
	public Connection create(ICreateConnectionContext context) {
		return delegate.create(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.jam.AbstractCreateConnectionFeature#getCreateImageId()
	 */
	@Override
	public String getCreateImageId() {
		return delegate.getCreateImageId();
	}

	@Override
	public String getCreateLargeImageId() {
		return delegate.getCreateLargeImageId();
	}

}
