/*
 * Created on 04.07.2005
 */
package com.sap.mi.gfw.command;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class GenericFeatureCommandWithContext.
 */
public class GenericFeatureCommandWithContext extends FeatureCommandWithContext {

	/**
	 * The Constructor.
	 * 
	 * @param context
	 *            the context
	 * @param feature
	 *            the feature
	 */
	public GenericFeatureCommandWithContext(IFeature feature, IContext context) {
		super(feature, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#canExecute()
	 */
	public boolean canExecute() {
		boolean ret = true;
		IFeature f = getFeature();
		IContext c = getContext();
		ret = ret && f != null && c != null && f.canExecute(c);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#execute()
	 */
	public boolean execute() {
		if (getContext() != null && getFeature() != null && getFeature().canExecute(getContext())) {
			getFeature().execute(getContext());
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.FeatureCommandWithContext#canUndo()
	 */
	@Override
	public boolean canUndo() {
		boolean ret = false;
		IFeature f = getFeature();
		IContext c = getContext();
		ret = f != null && f.canUndo(c);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.FeatureCommandWithContext#undo()
	 */
	@Override
	public boolean undo() {
		boolean ret = false;
		// IFeature f = getFeature();
		// IContext c = getContext();
		// ret = f != null && f.undo(c);
		return ret;
	}
}