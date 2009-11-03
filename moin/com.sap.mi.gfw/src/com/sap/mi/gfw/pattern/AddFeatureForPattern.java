package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.impl.AbstractAddFeature;
import com.sap.mi.gfw.func.IAdd;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class AddFeatureForPattern.
 */
public class AddFeatureForPattern extends AbstractAddFeature {
	private IAdd pattern;

	/**
	 * Instantiates a new adds the feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public AddFeatureForPattern(IFeatureProvider featureProvider, IAdd pattern) {
		super(featureProvider);
		this.pattern = pattern;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IAdd#canAdd(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public boolean canAdd(IAddContext context) {
		return pattern.canAdd(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IAdd#add(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public PictogramElement add(IAddContext context) {
		return pattern.add(context);
	}
}
