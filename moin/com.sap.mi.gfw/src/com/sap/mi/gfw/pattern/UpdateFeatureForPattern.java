package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.impl.AbstractUpdateFeature;
import com.sap.mi.gfw.util.T;

/**
 * The Class UpdateFeatureForPattern.
 */
public class UpdateFeatureForPattern extends AbstractUpdateFeature {

	private IFeatureForPattern delegate;

	/**
	 * Instantiates a new update feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public UpdateFeatureForPattern(IFeatureProvider featureProvider, IPattern pattern) {
		super(featureProvider);
		delegate = new FeatureForPatternDelegate(pattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IUpdate#canUpdate(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public boolean canUpdate(IUpdateContext context) {
		IPattern pattern = delegate.getPattern();
		boolean ret = pattern.canUpdate(context);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IUpdate#updateNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateNeeded(IUpdateContext context) {
		if (T.racer().info()) {
			T.racer().info("UpdateFeatureForPattern", "updateNeeded", "context: " + context); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		IReason ret = delegate.getPattern().updateNeeded(context);
		if (T.racer().info()) {
			T.racer().info("UpdateFeatureForPattern", "updateNeeded", "returns " + ret.toString()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IUpdate#update(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public boolean update(IUpdateContext context) {
		return delegate.getPattern().update(context);
	}
}
