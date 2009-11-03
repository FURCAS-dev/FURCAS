package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IPrintFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IPrintContext;

/**
 * The Class DefaultPrintFeature.
 */
public class DefaultPrintFeature extends AbstractFeature implements IPrintFeature {

	/**
	 * Instantiates a new default print feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultPrintFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IPrintFeature#canPrint(com.sap.mi.gfw.features.context.IPrintContext)
	 */
	public boolean canPrint(IPrintContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IPrintFeature#postPrint(com.sap.mi.gfw.features.context.IPrintContext)
	 */
	public void postPrint(IPrintContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IPrintFeature#prePrint(com.sap.mi.gfw.features.context.IPrintContext)
	 */
	public void prePrint(IPrintContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IPrintContext) {
			ret = canPrint((IPrintContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		// todo: not possible yet
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

	private static final String NAME = Messages.DefaultPrintFeature_0_xfld;
}
