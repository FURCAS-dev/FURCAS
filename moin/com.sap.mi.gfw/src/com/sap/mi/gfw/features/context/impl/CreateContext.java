/*
 * Created on 17.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;

/**
 * The Class CreateContext.
 */
public class CreateContext extends AreaContext implements ICreateContext {

	private ContainerShape targetContainer;

	private Connection targetConnection;

	/**
	 * Instantiates a new creates the context.
	 */
	public CreateContext() {
		super();
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
	 * @see com.sap.mi.gfw.features.context.ICreateContext#getTargetContainer()
	 */
	public ContainerShape getTargetContainer() {
		return targetContainer;
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

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " targetConnection: " + getTargetConnection() + " targetContainer: " + getTargetContainer(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
