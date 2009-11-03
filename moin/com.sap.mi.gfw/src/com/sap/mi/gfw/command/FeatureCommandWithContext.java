/*
 * Created on 04.07.2005
 */
package com.sap.mi.gfw.command;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureAndContext;
import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class FeatureCommandWithContext.
 */
public abstract class FeatureCommandWithContext extends FeatureCommand implements IFeatureAndContext {

	/**
	 * The context.
	 */
	IContext context = null;

	/**
	 * The Constructor.
	 * 
	 * @param context
	 *            the context
	 * @param feature
	 *            the feature
	 */
	protected FeatureCommandWithContext(IFeature feature, IContext context) {
		super(feature);
		setContext(context);
	}

	/**
	 * Gets the context.
	 * 
	 * @return Returns the context.
	 */
	public IContext getContext() {
		return context;
	}

	/**
	 * Sets the context.
	 * 
	 * @param context
	 *            The context to set.
	 */
	private void setContext(IContext context) {
		this.context = context;
	}

	// public boolean canExecute() {
	// return false;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#canUndo()
	 */
	public boolean canUndo() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#undo()
	 */
	public boolean undo() {
		return false;
	}
}