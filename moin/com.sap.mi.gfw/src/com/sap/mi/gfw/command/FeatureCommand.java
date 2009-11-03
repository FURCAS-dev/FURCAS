package com.sap.mi.gfw.command;

import com.sap.mi.gfw.IReadOnly;
import com.sap.mi.gfw.IReadOnlyProvider;
import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureHolder;
import com.sap.mi.gfw.features.IFeatureProvider;

/**
 * This command encapsulates a features.
 */
public abstract class FeatureCommand implements ICommand, IFeatureHolder, IReadOnlyProvider {

	/** The Constant NO_FEATURE. */
	private static final String NO_FEATURE = Messages.FeatureCommand_0_xmsg;

	/** The feature. */
	private final IFeature feature;

	/**
	 * The Constructor.
	 * 
	 * @param feature
	 *            the feature
	 */
	public FeatureCommand(IFeature feature) {
		super();
		if (feature == null) {
			throw new IllegalArgumentException("feature must not be null"); //$NON-NLS-1$
		}
		this.feature = feature;
	}

	/**
	 * Gets the feature.
	 * 
	 * @return Returns the feature.
	 */
	public IFeature getFeature() {
		return feature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.IDescription#getDescription()
	 */
	public String getDescription() {
		IFeature f = getFeature();
		if (f != null) {
			return f.getName();
		}
		return NO_FEATURE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProviderHolder#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		return getFeature().getFeatureProvider();
	}

	public boolean isReadOnly() {
		boolean ret = false;
		IFeature f = getFeature();
		if (f != null && f instanceof IReadOnly) {
			ret = true;
		}
		return ret;
	}
}