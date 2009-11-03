package com.sap.mi.gfw.command;

import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class AddFeatureCommandWithContext.
 */
public class AddFeatureCommandWithContext extends GenericFeatureCommandWithContext {

	/**
	 * The added pictogram element.
	 */
	PictogramElement addedPictogramElement;

	/**
	 * Instantiates a new adds the feature command with context.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public AddFeatureCommandWithContext(IFeature feature, IContext context) {
		super(feature, context);
	}

	/**
	 * Gets the added pictogram elements.
	 * 
	 * @return the added pictogram elements
	 */
	public PictogramElement getAddedPictogramElements() {
		return addedPictogramElement;
	}

	private void setAddedPictogramElements(PictogramElement newPictogramElements) {
		this.addedPictogramElement = newPictogramElements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.GenericFeatureCommandWithContext#execute()
	 */
	@Override
	public boolean execute() {
		boolean ret = false;
		if (getContext() instanceof IAddContext && getFeature() instanceof IAddFeature) {
			IAddFeature addFeature = (IAddFeature) getFeature();
			IAddContext addContext = (IAddContext) getContext();
			if (addFeature.canAdd(addContext)) {
				setAddedPictogramElements(addFeature.add(addContext));
				ret = true;
			}
		}
		return ret;
	}
}
