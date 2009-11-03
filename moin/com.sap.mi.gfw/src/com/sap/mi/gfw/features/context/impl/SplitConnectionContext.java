package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ISplitConnectionContext;
import com.sap.mi.gfw.features.context.impl.base.DefaultContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class SplitConnectionContext.
 */
public class SplitConnectionContext extends DefaultContext implements ISplitConnectionContext {

	private Connection connection;

	private Shape shape;

	/**
	 * Instantiates a new split connection context.
	 * 
	 * @param connection
	 *            the connection
	 * @param shape
	 *            the shape
	 */
	public SplitConnectionContext(Connection connection, Shape shape) {
		super();
		this.connection = connection;
		this.shape = shape;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ISplitConnectionContext#getConnection()
	 */
	public Connection getConnection() {
		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ISplitConnectionContext#getShape()
	 */
	public Shape getShape() {
		return shape;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " connection: " + getConnection() + " shape: " + getShape(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
