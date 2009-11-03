/*
 * Created on 12.07.2005
 */
package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.T;

/**
 * The Class AbstractAddFeature.
 */
public abstract class AbstractAddFeature extends AbstractFeature implements IAddFeature {

	/**
	 * The Constant EMPTY.
	 */
	protected static final PictogramElement[] EMPTY = new PictogramElement[0];

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.IContext)
	 */
	public boolean canExecute(IContext context) {
		final String SIGNATURE = "canExecute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractAddFeature.class, SIGNATURE, new Object[] { context });
		}
		boolean ret = false;
		if (context instanceof IAddContext) {
			ret = canAdd((IAddContext) context);
		}
		if (info) {
			T.racer().exiting(AbstractAddFeature.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.IContext)
	 */
	public void execute(IContext context) {
		final String SIGNATURE = "execute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractAddFeature.class, SIGNATURE, new Object[] { context });
		}
		if (context instanceof IAddContext) {
			add((IAddContext) context);
		}
		if (info) {
			T.racer().exiting(AbstractAddFeature.class, SIGNATURE);
		}
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

	private static final String NAME = Messages.AbstractAddFeature_0_xfld;
}