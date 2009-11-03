package com.sap.mi.gfw.command;

import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.context.IDirectEditingContext;

/**
 * The Class DirectEditingFeatureCommandWithContext.
 */
public class DirectEditingFeatureCommandWithContext extends GenericFeatureCommandWithContext {

	private String newValue;

	/**
	 * Instantiates a new direct editing feature command with context.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 * @param valueObject
	 *            the value object
	 */
	public DirectEditingFeatureCommandWithContext(IDirectEditingFeature feature, IDirectEditingContext context, String valueObject) {
		super(feature, context);
		setNewValue(valueObject);
	}

	private String getNewValue() {
		return newValue;
	}

	private void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.GenericFeatureCommandWithContext#execute()
	 */
	@Override
	public boolean execute() {
		boolean ret = false;
		if (getFeature() instanceof IDirectEditingFeature && getContext() instanceof IDirectEditingContext) {
			IDirectEditingFeature def = (IDirectEditingFeature) getFeature();
			IDirectEditingContext dec = (IDirectEditingContext) getContext();
			String initialValue = def.getInitialValue(dec);
			if (initialValue == null) {
				initialValue = ""; //$NON-NLS-1$
			}
			if (!initialValue.equals(getNewValue())) {
				def.setValue(getNewValue(), dec);
				ret = true;
			}
		}
		return ret;
	}

}
