/*
 * Created on 04.10.2005
 */
package com.sap.mi.gfw.features.jam;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;

/**
 * The Class AbstractCreateConnectionFeature.
 */
public abstract class AbstractCreateConnectionFeature extends AbstractFeature implements ICreateConnectionFeature {

	private String createDescription;

	private String createName;

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 */
	public AbstractCreateConnectionFeature(IFeatureProvider fp, String name, String description) {
		super(fp);
		setCreateName(name);
		setCreateDescription(description);
	}

	/**
	 * Gets the create description.
	 * 
	 * @return Returns the description.
	 */
	public String getCreateDescription() {
		return createDescription;
	}

	/**
	 * Gets the create name.
	 * 
	 * @return Returns the name.
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	private void setCreateDescription(String description) {
		this.createDescription = description;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	private void setCreateName(String name) {
		this.createName = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof ICreateConnectionContext) {
			ret = canCreate((ICreateConnectionContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof ICreateConnectionContext) {
			create((ICreateConnectionContext) context);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateInfo#getCreateImageId()
	 */
	public String getCreateImageId() {
		return null;
	}

	public String getCreateLargeImageId() {
		return getCreateImageId();
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

	private static final String NAME = Messages.AbstractCreateConnectionFeature_0_xfld;
}