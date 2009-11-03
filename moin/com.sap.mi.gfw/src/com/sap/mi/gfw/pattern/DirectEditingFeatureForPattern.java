package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.func.IDirectEditing;

/**
 * The Class DirectEditingFeatureForPattern.
 */
public class DirectEditingFeatureForPattern extends AbstractDirectEditingFeature {
	private IDirectEditing delegate;

	/**
	 * Instantiates a new direct editing feature for pattern.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param pattern
	 *            the pattern
	 */
	public DirectEditingFeatureForPattern(IFeatureProvider featureProvider, IDirectEditing pattern) {
		super(featureProvider);
		delegate = pattern;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		return delegate.canDirectEdit(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#checkValueValid(java.lang.String,
	 *      com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		return delegate.checkValueValid(value, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#completeValue(java.lang.String, int, java.lang.String,
	 *      com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public String completeValue(String value, int caretPos, String choosenValue, IDirectEditingContext context) {
		return delegate.completeValue(value, caretPos, choosenValue, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#getPossibleValues(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public String[] getPossibleValues(IDirectEditingContext context) {
		return delegate.getPossibleValues(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#getValueProposals(java.lang.String, int,
	 *      com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public String[] getValueProposals(String value, int caretPos, IDirectEditingContext context) {
		return delegate.getValueProposals(value, caretPos, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#isAutoCompletionEnabled()
	 */
	@Override
	public boolean isAutoCompletionEnabled() {
		return delegate.isAutoCompletionEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#isCompletionAvailable()
	 */
	@Override
	public boolean isCompletionAvailable() {
		return delegate.isCompletionAvailable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#stretchTextfieldToFitText()
	 */
	@Override
	public boolean stretchTextfieldToFitText() {
		return delegate.stretchTextfieldToFitText();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#getEditingType()
	 */
	public int getEditingType() {
		return delegate.getEditingType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#getInitialValue(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String getInitialValue(IDirectEditingContext context) {
		return delegate.getInitialValue(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#setValue(java.lang.String, com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public void setValue(String value, IDirectEditingContext context) {
		delegate.setValue(value, context);
	}
}
