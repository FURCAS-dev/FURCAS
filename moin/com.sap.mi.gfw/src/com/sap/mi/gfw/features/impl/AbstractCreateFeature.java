/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.util.T;

/**
 * The Class AbstractCreateFeature.
 */
public abstract class AbstractCreateFeature extends AbstractFeature implements ICreateFeature {

	private String description;

	private String name;

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            feature provider
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 */
	public AbstractCreateFeature(IFeatureProvider fp, String name, String description) {
		super(fp);
		setName(name);
		setDescription(description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ICreateFeature#getDescription()
	 */
	public String getCreateDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ICreateFeature#getName()
	 */
	public String getCreateName() {
		return name;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	private void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	private void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		final String SIGNATURE = "canExecute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractCreateFeature.class, SIGNATURE, new Object[] { context });
		}
		boolean ret = false;
		if (context instanceof ICreateContext) {
			ret = canCreate((ICreateContext) context);
		}

		if (info) {
			T.racer().exiting(AbstractCreateFeature.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		final String SIGNATURE = "execute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractCreateFeature.class, SIGNATURE, new Object[] { context });
		}
		if (context instanceof ICreateContext) {
			create((ICreateContext) context);
		}
		if (info) {
			T.racer().exiting(AbstractCreateFeature.class, SIGNATURE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreate#getCreateImageId()
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
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
}