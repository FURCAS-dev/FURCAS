/*
 * Created on 16.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class MoveShapeContext.
 */
public class MoveShapeContext extends MoveContext implements IMoveShapeContext {

	private int deltaX;

	private int deltaY;

	private Shape shape;

	private ContainerShape sourceContainer;

	private ContainerShape targetContainer;

	private Connection targetConnection;

	/**
	 * The Constructor.
	 * 
	 * @param shape
	 *            the shape
	 */
	public MoveShapeContext(Shape shape) {
		super();
		setShape(shape);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IMoveShapeContext#getDeltaX()
	 */
	public int getDeltaX() {
		return deltaX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IMoveShapeContext#getDeltaY()
	 */
	public int getDeltaY() {
		return deltaY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IPictogramElementContext#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return getShape();
	}

	/**
	 * Gets the shape.
	 * 
	 * @return Returns the shape.
	 */
	public Shape getShape() {
		return shape;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ILayoutShapeContext#getSourceContainer()
	 */
	public ContainerShape getSourceContainer() {
		return sourceContainer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ITargetConnectionContext#getTargetConnection()
	 */
	public Connection getTargetConnection() {
		return targetConnection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ILayoutShapeContext#getTargetContainer()
	 */
	public ContainerShape getTargetContainer() {
		return targetContainer;
	}

	/**
	 * Sets the delta x.
	 * 
	 * @param deltaX
	 *            the new delta x
	 */
	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	/**
	 * Sets the delta y.
	 * 
	 * @param deltaY
	 *            the new delta y
	 */
	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}

	/**
	 * @param shape
	 *            The shape to set.
	 */
	private void setShape(Shape shape) {
		this.shape = shape;
	}

	/**
	 * Sets the source container.
	 * 
	 * @param sourceContainer
	 *            The sourceContainer to set.
	 */
	public void setSourceContainer(ContainerShape sourceContainer) {
		this.sourceContainer = sourceContainer;
	}

	/**
	 * Sets the target connection.
	 * 
	 * @param targetConnection
	 *            The target connection to set.
	 */
	public void setTargetConnection(Connection targetConnection) {
		this.targetConnection = targetConnection;
	}

	/**
	 * Sets the target container.
	 * 
	 * @param targetContainer
	 *            The targetContainer to set.
	 */
	public void setTargetContainer(ContainerShape targetContainer) {
		this.targetContainer = targetContainer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.impl.LocationContext#toString()
	 */
	@Override
	public String toString() {
		String ret = super.toString();
		ret = ret + "(deltaX=" + getDeltaX() + ", deltaY=" + getDeltaY() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return ret;
	}
}
