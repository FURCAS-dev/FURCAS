package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveConnectionDecoratorFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * The Class DefaultMoveConnectionDecoratorFeature.
 */
public class DefaultMoveConnectionDecoratorFeature extends AbstractFeature implements IMoveConnectionDecoratorFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultMoveConnectionDecoratorFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveConnectionDecoratorFeature#canLayoutConnectionDecorator(com.sap.mi.gfw.dt.IContext)
	 */
	public boolean canMoveConnectionDecorator(IMoveConnectionDecoratorContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveConnectionDecoratorFeature#layoutConnectionDecorator(com.sap.mi.gfw.dt.IContext)
	 */
	public void moveConnectionDecorator(IMoveConnectionDecoratorContext context) {
		if (!getUserDecision()) {
			return;
		}
		int posX = context.getX();
		int posY = context.getY();

		ConnectionDecorator connectionDecorator = context.getConnectionDecorator();
		GraphicsAlgorithm ga = connectionDecorator.getGraphicsAlgorithm();
		ga.setX(posX);
		ga.setY(posY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IMoveConnectionDecoratorContext) {
			ret = canMoveConnectionDecorator((IMoveConnectionDecoratorContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IMoveConnectionDecoratorContext) {
			IMoveConnectionDecoratorContext moveConnectionDecoratorContext = (IMoveConnectionDecoratorContext) context;
			if (moveConnectionDecoratorContext.isExecuteAllowed()) {
				moveConnectionDecorator(moveConnectionDecoratorContext);
			}
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

	private static final String NAME = Messages.DefaultMoveConnectionDecoratorFeature_0_xfld;
}