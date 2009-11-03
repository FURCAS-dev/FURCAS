package com.sap.mi.gfw.pattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.mi.gfw.features.DefaultResizeConfiguration;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IResizeConfiguration;
import com.sap.mi.gfw.features.context.IAreaContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.LayoutContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.mapping.IStructureMapping;
import com.sap.mi.gfw.mapping.data.IDataMapping;
import com.sap.mi.gfw.mapping.data.IImageDataMapping;
import com.sap.mi.gfw.mapping.data.ITextDataMapping;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.config.IPatternConfiguration;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.IColorConstant;

/**
 * The Class AbstractPattern.
 */
public abstract class AbstractPattern extends AbstractBasePattern implements IPattern {

	private IPatternConfiguration patternConfiguration;

	/**
	 * Instantiates a new abstract pattern.
	 * 
	 * @param patternConfiguration
	 *            the pattern configuration
	 */
	public AbstractPattern(IPatternConfiguration patternConfiguration) {
		setPatternConfiguration(patternConfiguration);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreate#canCreate(com.sap.mi.gfw.features.context.ICreateContext)
	 */
	public boolean canCreate(ICreateContext context) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ILayout#canLayout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public boolean canLayout(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		return isPatternControlled(pictogramElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IMoveShape#canMoveShape(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	public boolean canMoveShape(IMoveShapeContext context) {
		return context.getSourceContainer() != null && context.getSourceContainer().equals(context.getTargetContainer())
				&& isPatternRoot(context.getPictogramElement());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IResizeShape#canResizeShape(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	public boolean canResizeShape(IResizeShapeContext context) {
		return isPatternRoot(context.getPictogramElement());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IUpdate#canUpdate(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public boolean canUpdate(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		return isPatternControlled(pictogramElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreate#create(com.sap.mi.gfw.features.context.ICreateContext)
	 */
	public Object[] create(ICreateContext context) {
		return EMPTY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.IPattern#getCreateDescription()
	 */
	public String getCreateDescription() {
		return null;
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
	 * @see com.sap.mi.gfw.pattern.IPattern#getCreateName()
	 */
	public String getCreateName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.IPattern#isMainBusinessObjectApplicable(java.lang.Object)
	 */
	abstract public boolean isMainBusinessObjectApplicable(Object mainBusinessObject);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ILayout#layout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public boolean layout(ILayoutContext context) {
		return false;
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
		Shape shapeToMove = context.getShape();
		ContainerShape oldContainerShape = context.getSourceContainer();
		ContainerShape newContainerShape = context.getTargetContainer();

		int x = context.getX();
		int y = context.getY();

		if (oldContainerShape != newContainerShape) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IResizeShape#resizeShape(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	public void resizeShape(IResizeShapeContext context) {
		Shape shape = context.getShape();
		int width = context.getWidth();
		int height = context.getHeight();

		if (shape.getGraphicsAlgorithm() != null) {
			GaUtil.setSizeOfGraphicsAlgorithm(shape.getGraphicsAlgorithm(), width, height);
		}

		layoutPictogramElement(shape);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IUpdate#update(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public boolean update(IUpdateContext context) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IUpdate#updateNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createFalseReason();
	}

	/**
	 * Adds the graphical representation.
	 * 
	 * @param context
	 *            the context
	 * @param newObject
	 *            the new object
	 */
	protected void addGraphicalRepresentation(IAreaContext context, Object newObject) {
		getFeatureProvider().addIfPossible(new AddContext(context, newObject));
	}

	/**
	 * Sublasses can override this method.
	 * 
	 * @return true if moving to negative coordinates should not be possible
	 */
	protected boolean avoidNegativeCoordinates() {
		return false;
	}

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	protected Diagram getDiagram() {
		return getFeatureProvider().getDiagramTypeProvider().getDiagram();
	}

	/**
	 * Gets the image.
	 * 
	 * @param structureMapping
	 *            the structure mapping
	 * @param link
	 *            the link
	 * @return the image
	 */
	protected String getImage(IStructureMapping structureMapping, PictogramLink link) {
		String ret = null;
		IDataMapping dm = structureMapping.getDataMapping();
		if (dm instanceof IImageDataMapping) {
			ret = ((IImageDataMapping) dm).getImageId(link);
		}
		return ret;
	}

	/**
	 * Gets the text.
	 * 
	 * @param structureMapping
	 *            the structure mapping
	 * @param link
	 *            the link
	 * @return the text
	 */
	protected String getText(IStructureMapping structureMapping, PictogramLink link) {
		String ret = null;
		IDataMapping dm = structureMapping.getDataMapping();
		if (dm instanceof ITextDataMapping) {
			ret = ((ITextDataMapping) dm).getText(link);
		}
		return ret;
	}

	/**
	 * This method must be implemented by the pattern developer / provider.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return true, if is pattern controlled
	 */
	abstract protected boolean isPatternControlled(PictogramElement pictogramElement);

	/**
	 * This method must be implemented by the pattern developer / provider.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return true, if is pattern root
	 */
	abstract protected boolean isPatternRoot(PictogramElement pictogramElement);

	/**
	 * Layout pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void layoutPictogramElement(PictogramElement pe) {
		LayoutContext context = new LayoutContext(pe);
		getFeatureProvider().layoutIfPossible(context);
	}

	/**
	 * Update pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void updatePictogramElement(PictogramElement pe) {
		UpdateContext context = new UpdateContext(pe);
		getFeatureProvider().updateIfPossible(context);
		layoutPictogramElement(pe);
	}

	/**
	 * Sets the pattern configuration.
	 * 
	 * @param patternConfiguration
	 *            the patternConfiguration to set
	 */
	protected void setPatternConfiguration(IPatternConfiguration patternConfiguration) {
		this.patternConfiguration = patternConfiguration;
	}

	/**
	 * Gets the pattern configuration.
	 * 
	 * @return the patternConfiguration
	 */
	protected IPatternConfiguration getPatternConfiguration() {
		return patternConfiguration;
	}

	/**
	 * Manage color.
	 * 
	 * @param red
	 *            the red
	 * @param green
	 *            the green
	 * @param blue
	 *            the blue
	 * @return the color
	 */
	protected Color manageColor(int red, int green, int blue) {
		return GaUtil.manageColor(getDiagram(), red, green, blue);
	}

	/**
	 * Manage color.
	 * 
	 * @param colorConstant
	 *            the color constant
	 * @return the color
	 */
	protected Color manageColor(IColorConstant colorConstant) {
		return GaUtil.manageColor(getDiagram(), colorConstant);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.IPattern#completeInfo(com.sap.mi.gfw.features.IDirectEditingInfo, java.lang.Object)
	 */
	public void completeInfo(IDirectEditingInfo info, Object bo) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.IPattern#completeInfo(com.sap.mi.gfw.features.IDirectEditingInfo, java.lang.Object, java.lang.String)
	 */
	public void completeInfo(IDirectEditingInfo info, Object bo, String keyProperty) {
	}

	public IResizeConfiguration getResizeConfiguration() {
		return new DefaultResizeConfiguration();
	}
}
