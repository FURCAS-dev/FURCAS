/*
 * Created on 13.12.2005
 */
package com.sap.mi.gfw.features.jam;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReconnectionFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.Diagram;

/**
 * The Class DefaultReconnectionFeature.
 */
public class DefaultReconnectionFeature extends AbstractFeature implements IReconnectionFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultReconnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IReconnectionFeature#canReconnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public boolean canReconnect(IReconnectionContext context) {
		Connection connection = context.getConnection();
		Anchor newAnchor = getNewAnchor(context);
		boolean ret = (connection != null) && (newAnchor != null) && (connection.getStart() != null) && (connection.getEnd() != null)
				&& !(newAnchor.getParent() instanceof Diagram);
		return ret;
	}

	/**
	 * Gets the new anchor.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the new anchor
	 */
	protected Anchor getNewAnchor(IReconnectionContext context) {
		return context.getNewAnchor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IReconnectionFeature#reconnnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public final void reconnnect(IReconnectionContext context) {
		if (!getUserDecision()) {
			return;
		}
		Connection connection = context.getConnection();
		Anchor newAnchor = context.getNewAnchor();
		Anchor oldAnchor = context.getOldAnchor();

		preReconnnect(context);

		if (connection.getStart().equals(oldAnchor)) {
			connection.setStart(newAnchor);
		} else {
			connection.setEnd(newAnchor);
		}

		postReconnnect(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IReconnectionFeature#preReconnnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public void preReconnnect(IReconnectionContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IReconnectionFeature#postReconnnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public void postReconnnect(IReconnectionContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IReconnectionContext) {
			ret = canReconnect((IReconnectionContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IReconnectionContext) {
			reconnnect((IReconnectionContext) context);
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

	private static final String NAME = Messages.DefaultReconnectionFeature_0_xfld;
}