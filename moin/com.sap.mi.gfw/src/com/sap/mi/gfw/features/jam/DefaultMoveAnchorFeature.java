/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features.jam;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveAnchorFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IMoveAnchorContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.BoxRelativeAnchor;
import com.sap.mi.gfw.mm.pictograms.FixPointAnchor;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.util.GaUtil;

/**
 * The Class DefaultMoveAnchorFeature.
 */
public class DefaultMoveAnchorFeature extends AbstractFeature implements IMoveAnchorFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultMoveAnchorFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveAnchorFeature#canLayoutAnchor(com.sap.mi.gfw.dt.IContext)
	 */
	public boolean canMoveAnchor(IMoveAnchorContext context) {
		Anchor anchor = context.getAnchor();
		return (anchor instanceof FixPointAnchor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveAnchorFeature#layoutAnchor(com.sap.mi.gfw.dt.IContext)
	 */
	public void moveAnchor(IMoveAnchorContext context) {
		if (!getUserDecision()) {
			return;
		}
		int posX = context.getX();
		int posY = context.getY();

		moveAnchor(context.getAnchor(), posX, posY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveAnchorFeature#preLayoutAnchor(com.sap.mi.gfw.dt.IContext)
	 */
	public void preMoveAnchor(IMoveAnchorContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveAnchorFeature#postLayoutAnchor(com.sap.mi.gfw.dt.IContext)
	 */
	public void postMoveAnchor(IMoveAnchorContext context) {
	}

	/**
	 * Move anchor.
	 * 
	 * @param anchor
	 *            the anchor
	 * @param posX
	 *            the pos x
	 * @param posY
	 *            the pos y
	 */
	protected void moveAnchor(Anchor anchor, int posX, int posY) {
		int x = (posX < 0) ? 0 : posX;
		int y = (posY < 0) ? 0 : posY;

		// TODO change to flexible anchor-size
		// GraphicalEditPart parent = (GraphicalEditPart) ep.getParent();
		// IFigure figure = parent.getFigure();
		// Rectangle clientArea = figure.getClientArea();
		// if ((x + 10) > clientArea.width) {
		// x = clientArea.width - 10;
		// }
		// if ((y + 10) > clientArea.height) {
		// y = clientArea.height - 10;
		// }

		if (anchor instanceof FixPointAnchor) {
			FixPointAnchor fpAnchor = (FixPointAnchor) anchor;
			fpAnchor.setLocation(GaUtil.createPoint(fpAnchor, x, y));
		} else if (anchor instanceof BoxRelativeAnchor) {
			BoxRelativeAnchor brAnchor = (BoxRelativeAnchor) anchor;
			AnchorContainer anchorContainer = brAnchor.getParent();
			GraphicsAlgorithm anchorContainerGa = anchorContainer.getGraphicsAlgorithm();
			IDimension sizeOfGraphicsAlgorithm = GaUtil.calculateSizeOfGraphicsAlgorithm(anchorContainerGa, false);
			int width = sizeOfGraphicsAlgorithm.getWidth();
			double newRelativeX = 1d * posX / width;
			brAnchor.setRelativeWidth(newRelativeX);
			int height = sizeOfGraphicsAlgorithm.getHeight();
			double newRelativeY = 1d * posY / height;
			brAnchor.setRelativeHeight(newRelativeY);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IMoveAnchorContext) {
			ret = canMoveAnchor((IMoveAnchorContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IMoveAnchorContext) {
			moveAnchor((IMoveAnchorContext) context);
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

	private static final String NAME = Messages.DefaultMoveAnchorFeature_0_xfld;
}