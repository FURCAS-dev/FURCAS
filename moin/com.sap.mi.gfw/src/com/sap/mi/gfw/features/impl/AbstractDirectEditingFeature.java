package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.util.T;

/**
 * The Class AbstractDirectEditingFeature.
 */
public abstract class AbstractDirectEditingFeature extends AbstractFeature implements IDirectEditingFeature {

	/**
	 * The Constant EMPTY_STRING_ARRAY.
	 */
	protected static final String[] EMPTY_STRING_ARRAY = new String[0];

	/**
	 * Instantiates a new abstract direct editing feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		final String SIGNATURE = "canExecute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractDirectEditingFeature.class, SIGNATURE, new Object[] { context });
		}
		boolean ret = false;
		if (context instanceof IDirectEditingContext) {
			ret = canDirectEdit((IDirectEditingContext) context);
		}

		if (info) {
			T.racer().exiting(AbstractDirectEditingFeature.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public boolean canDirectEdit(IDirectEditingContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		// nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingFeature#getPossibleValues(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String[] getPossibleValues(IDirectEditingContext context) {
		return EMPTY_STRING_ARRAY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingFeature#getValueProposals(java.lang.String,
	 * com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String[] getValueProposals(String value, int caretPos, IDirectEditingContext context) {
		return EMPTY_STRING_ARRAY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingFeature#checkValueValid(java.lang.String,
	 * com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String checkValueValid(String value, IDirectEditingContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingFeature#completeValue(java.lang.String, java.lang.String,
	 * com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String completeValue(String value, int caretPos, String choosenValue, IDirectEditingContext context) {
		return choosenValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#stretchTextfieldToFitText()
	 */
	public boolean stretchTextfieldToFitText() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#isAutoCompletionEnabled()
	 */
	public boolean isAutoCompletionEnabled() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#isCompletionAvailable()
	 */
	public boolean isCompletionAvailable() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	private static final String NAME = Messages.AbstractDirectEditingFeature_0_xfld;
}