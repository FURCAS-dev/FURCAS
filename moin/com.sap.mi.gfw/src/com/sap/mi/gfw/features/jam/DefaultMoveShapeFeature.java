package com.sap.mi.gfw.features.jam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.GaUtil;

/**
 * The Class DefaultMoveShapeFeature.
 */
public class DefaultMoveShapeFeature extends AbstractMoveShapeFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultMoveShapeFeature(IFeatureProvider fp) {
		super(fp);
	}

	/**
	 * Sublasses can override this method.
	 * 
	 * @return true if moving to negative coordinates should not be possible
	 */
	protected boolean avoidNegativeCoordinates() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveShapeFeature#canMoveShape(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	public boolean canMoveShape(IMoveShapeContext context) {
		return context.getSourceContainer() != null && context.getSourceContainer().equals(context.getTargetContainer());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveShapeFeature#moveShape(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	final public void moveShape(IMoveShapeContext context) {
		preMoveShape(context);
		moveAllBendpoints(context);
		internalMove(context);
		postMoveShape(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveShapeFeature#postMoveShape(com.sap.mi.gfw.dt.IContext)
	 */
	/**
	 * Post move shape.
	 * 
	 * @param context
	 *            the context
	 */
	protected void postMoveShape(IMoveShapeContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveShapeFeature#preMoveShape(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	/**
	 * Pre move shape.
	 * 
	 * @param context
	 *            the context
	 */
	protected void preMoveShape(IMoveShapeContext context) {
	}

	/**
	 * Internal move.
	 * 
	 * @param context
	 *            the context
	 */
	protected void internalMove(IMoveShapeContext context) {
		if (!getUserDecision()) {
			return;
		}
		Shape shapeToMove = context.getShape();
		ContainerShape oldContainerShape = context.getSourceContainer();
		ContainerShape newContainerShape = context.getTargetContainer();

		int x = context.getX();
		int y = context.getY();

		if (oldContainerShape != newContainerShape) {
			// remember selection, because it is lost when temporarily removing the shapes.
			PictogramElement[] currentSelection = getDiagramEditor().getSelectedPictogramElements();
			// the following is a workaround due to an MMR bug
			if (oldContainerShape != null) {
				Collection children = oldContainerShape.getChildren();
				if (children != null) {
					children.remove(shapeToMove);
				}
			}

			shapeToMove.setContainer(newContainerShape);
			if (shapeToMove.getGraphicsAlgorithm() != null) {
				GaUtil.setLocationOfGraphicsAlgorithm(shapeToMove.getGraphicsAlgorithm(), x, y, avoidNegativeCoordinates());
			}
			// restore selection
			getDiagramEditor().setPictogramElementsForSelection(currentSelection);
		} else { // move within the same container
			if (shapeToMove.getGraphicsAlgorithm() != null) {
				GaUtil.setLocationOfGraphicsAlgorithm(shapeToMove.getGraphicsAlgorithm(), x, y, avoidNegativeCoordinates());
			}
		}
	}

	// move bendpoints within a container shape
	/**
	 * Move all bendpoints.
	 * 
	 * @param context
	 *            the context
	 */
	protected void moveAllBendpoints(IMoveShapeContext context) {

		if (!(context.getShape() instanceof ContainerShape)) {
			return;
		}

		ContainerShape shapeToMove = (ContainerShape) context.getShape();

		int x = context.getX();
		int y = context.getY();

		int deltaX = x - shapeToMove.getGraphicsAlgorithm().getX();
		int deltaY = y - shapeToMove.getGraphicsAlgorithm().getY();

		if (deltaX != 0 || deltaY != 0) {

			List<Anchor> anchorsFrom = getAnchors(shapeToMove);
			List<Anchor> anchorsTo = new ArrayList<Anchor>(anchorsFrom);

			for (Anchor anchorFrom : anchorsFrom) {

				Collection<Connection> outgoingConnections = anchorFrom.getOutgoingConnections();

				for (Connection connection : outgoingConnections) {
					for (Anchor anchorTo : anchorsTo) {

						Collection<Connection> incomingConnections = anchorTo.getIncomingConnections();
						if (incomingConnections.contains(connection)) {
							if (connection instanceof FreeFormConnection) {
								FreeFormConnection ffc = (FreeFormConnection) connection;
								List<Point> points = ffc.getBendpoints();
								for (int i = 0; i < points.size(); i++) {
									Point point = points.get(i);
									int oldX = point.getX();
									int oldY = point.getY();
									points.set(i, GaUtil.createPoint(ffc, oldX + deltaX, oldY + deltaY));
								}
							}
						}
					}
				}
			}
		}
	}

	private List<Anchor> getAnchors(ContainerShape containerShape) {
		List<Anchor> ret = new ArrayList<Anchor>();
		ret.addAll(containerShape.getAnchors());

		List<Shape> children = containerShape.getChildren();
		for (Shape shape : children) {
			if (shape instanceof ContainerShape) {
				ret.addAll(getAnchors((ContainerShape) shape));
			} else {
				ret.addAll(shape.getAnchors());
			}
		}
		return ret;
	}
}
