package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;

/**
 * The Class MoveConnectionDecoratorContext.
 */
public class MoveConnectionDecoratorContext extends LocationContext implements IMoveConnectionDecoratorContext {

	private ConnectionDecorator connectionDecorator;

	private boolean executeAllowed;

	/**
	 * The Constructor.
	 * 
	 * @param connectionDecorator
	 *            the connection decorator
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param executeAllowed
	 *            the execute allowed
	 */
	public MoveConnectionDecoratorContext(ConnectionDecorator connectionDecorator, int x, int y, boolean executeAllowed) {
		super(x, y);
		setConnectionDecorator(connectionDecorator);
		setExecuteAllowed(executeAllowed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext#getConnectionDecorator()
	 */
	public ConnectionDecorator getConnectionDecorator() {
		return connectionDecorator;
	}

	/**
	 * Sets the connection decorator.
	 * 
	 * @param connectionDecorator
	 *            the new connection decorator
	 */
	protected void setConnectionDecorator(ConnectionDecorator connectionDecorator) {
		this.connectionDecorator = connectionDecorator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext#isExecuteAllowed()
	 */
	public boolean isExecuteAllowed() {
		return executeAllowed;
	}

	/**
	 * Sets the execute allowed.
	 * 
	 * @param executeAllowed
	 *            the new execute allowed
	 */
	protected void setExecuteAllowed(boolean executeAllowed) {
		this.executeAllowed = executeAllowed;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " connectionDecorator: " + getConnectionDecorator() + " executeAllowed: " + isExecuteAllowed(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
