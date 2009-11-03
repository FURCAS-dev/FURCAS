/*
 * Created on 17.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.IAreaContext;
import com.sap.mi.gfw.features.context.ITargetConnectionContext;
import com.sap.mi.gfw.features.context.ITargetContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.util.T;

/**
 * The Class AddContext.
 */
public class AddContext extends AreaContext implements IAddContext {

	private ContainerShape targetContainer;

	private Connection targetConnection;

	private Object newObject;

	/**
	 * Instantiates a new adds the context.
	 */
	public AddContext() {
		super();
	}

	/**
	 * Instantiates a new adds the context.
	 * 
	 * @param context
	 *            the context
	 * @param newObject
	 *            the new object
	 */
	public AddContext(IAreaContext context, Object newObject) {
		this();
		final String SIGNATURE = "AddContext(IAreaContext, Object)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AddContext.class, SIGNATURE, new Object[] { context, newObject });
		}
		setNewObject(newObject);
		setLocation(context.getX(), context.getY());
		setSize(context.getWidth(), context.getHeight());
		if (context instanceof ITargetContext) {
			ITargetContext targetContext = (ITargetContext) context;
			setTargetContainer(targetContext.getTargetContainer());
		}
		if (context instanceof ITargetConnectionContext) {
			ITargetConnectionContext targetConnectionContext = (ITargetConnectionContext) context;
			setTargetConnection(targetConnectionContext.getTargetConnection());
		}
		if (info) {
			T.racer().exiting(AddContext.class, SIGNATURE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IAddContext#getNewObject()
	 */
	public Object getNewObject() {
		return newObject;
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
	 * @see com.sap.mi.gfw.features.context.IAddContext#getTargetContainer()
	 */
	public ContainerShape getTargetContainer() {
		return targetContainer;
	}

	/**
	 * Sets the new object.
	 * 
	 * @param newObject
	 *            the new object
	 */
	public void setNewObject(Object newObject) {
		this.newObject = newObject;
	}

	/**
	 * Sets the target container.
	 * 
	 * @param targetContainer
	 *            The target container to set.
	 */
	public void setTargetContainer(ContainerShape targetContainer) {
		this.targetContainer = targetContainer;
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

	@Override
	public String toString() {
		String ret = super.toString();
		ret = ret + " newObject: " + getNewObject() + " targetConnection: " + getTargetConnection() + " targetContainer: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ getTargetContainer();
		return ret;
	}

}
