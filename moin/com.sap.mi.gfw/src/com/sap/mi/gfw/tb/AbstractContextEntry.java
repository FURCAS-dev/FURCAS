package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.tc.moin.repository.Connection;

/**
 * The Class AbstractContextEntry.
 */
public class AbstractContextEntry implements IContextEntry {

	private IContext context;

	private IFeature feature;

	private String iconId;

	private String text;

	private String description;

	/**
	 * Instantiates a new abstract context entry.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public AbstractContextEntry(IFeature feature, IContext context) {
		setFeature(feature);
		setContext(context);
		if (feature instanceof ICustomFeature) {
			setIconId(((ICustomFeature) feature).getImageId());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#canExecute()
	 */
	public boolean canExecute() {
		if (getFeature() == null) {
			return false;
		}
		return getFeature().canExecute(getContext());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#execute()
	 */
	public void execute() {
		GenericFeatureCommandWithContext genericFeatureCommandWithContext = new GenericFeatureCommandWithContext(getFeature(), getContext());
		Connection connection = getFeature().getFeatureProvider().getConnection();
		CommandExec.getSingleton().executeCommand(genericFeatureCommandWithContext, connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#getContext()
	 */
	public IContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#getFeature()
	 */
	public IFeature getFeature() {
		return feature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#getIconId()
	 */
	public String getIconId() {
		return iconId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#getText()
	 */
	public String getText() {
		String ret = text;
		if (ret == null) {
			IFeature f = getFeature();
			if (f instanceof ICustomFeature) {
				ICustomFeature customFeature = (ICustomFeature) f;
				ret = customFeature.getName();
			}
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#getDescription()
	 */
	public String getDescription() {
		String ret = description;
		if (ret == null) {
			IFeature f = getFeature();
			if (f instanceof ICustomFeature) {
				ICustomFeature customFeature = (ICustomFeature) f;
				ret = customFeature.getDescription();
			}
		}
		return ret;
	}

	private void setContext(IContext context) {
		this.context = context;
	}

	private void setFeature(IFeature feature) {
		this.feature = feature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#setIconId(java.lang.String)
	 */
	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#setText(java.lang.String)
	 */
	public void setText(String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextEntry#setDescription(java.lang.String)
	 */
	public void setDescription(String text) {
		this.description = text;
	}

}
