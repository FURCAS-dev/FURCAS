package com.sap.mi.gfw.internal.autolayout;

import com.sap.mi.gfw.autolayout.ILayoutStructureProvider;
import com.sap.mi.gfw.features.IFeatureProvider;

/**
 * The Class AbstractGraphTransformation.
 */
public abstract class AbstractGraphTransformation implements IGraphTransformation {

	/**
	 * The Constant PROVIDER_EDGE_TO_MODEL_REFERENCE.
	 */
	protected static final Object PROVIDER_EDGE_TO_MODEL_REFERENCE = "provider_edge_to_model_reference"; //$NON-NLS-1$

	/**
	 * The Constant PROVIDER_SHAPE_TO_NODE.
	 */
	protected static final Object PROVIDER_SHAPE_TO_NODE = "provider_model_object_to_node"; //$NON-NLS-1$

	// private static final Object PROVIDER_MODEL_REFERENCE_TO_OLD_POINTS =
	// "provider_model_reference_to_old_points";

	private ILayoutStructureProvider layoutStructureProvider;

	private IFeatureProvider featureProvider;

	/**
	 * The Constructor.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param layoutStructureProvider
	 *            the layout structure provider
	 */
	protected AbstractGraphTransformation(IFeatureProvider featureProvider, ILayoutStructureProvider layoutStructureProvider) {
		super();
		setLayoutStructureProvider(layoutStructureProvider);
		setFeatureProvider(featureProvider);
	}

	/**
	 * Gets the layout structure provider.
	 * 
	 * @return the layout structure provider
	 */
	protected ILayoutStructureProvider getLayoutStructureProvider() {
		return layoutStructureProvider;
	}

	/**
	 * Gets the feature provider.
	 * 
	 * @return the feature provider
	 */
	protected IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}

	/**
	 * Sets the feature provider.
	 * 
	 * @param featureProvider
	 *            the featureProvider to set
	 */
	protected void setFeatureProvider(IFeatureProvider featureProvider) {
		this.featureProvider = featureProvider;
	}

	/**
	 * Sets the layout structure provider.
	 * 
	 * @param layoutStructureProvider
	 *            the layoutStructureProvider to set
	 */
	protected void setLayoutStructureProvider(ILayoutStructureProvider layoutStructureProvider) {
		this.layoutStructureProvider = layoutStructureProvider;
	}

	// private DefaultAutoLayoutPreferences autoLayoutPreferences = new
	// DefaultAutoLayoutPreferences();

}
