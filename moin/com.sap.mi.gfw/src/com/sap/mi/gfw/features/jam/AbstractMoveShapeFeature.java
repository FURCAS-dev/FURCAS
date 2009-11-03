package com.sap.mi.gfw.features.jam;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;

/**
 * The Class AbstractMoveShapeFeature.
 */
public abstract class AbstractMoveShapeFeature extends AbstractFeature implements IMoveShapeFeature {

	/**
	 * Instantiates a new abstract move shape feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractMoveShapeFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IMoveShapeContext) {
			ret = canMoveShape((IMoveShapeContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IMoveShapeContext) {
			moveShape((IMoveShapeContext) context);
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

	private static final String NAME = Messages.AbstractMoveShapeFeature_0_xfld;
}
