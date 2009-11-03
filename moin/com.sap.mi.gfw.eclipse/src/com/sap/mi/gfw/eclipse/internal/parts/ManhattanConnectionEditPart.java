/*
 * Created on 27.09.2005
 *


 */
package com.sap.mi.gfw.eclipse.internal.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ManhattanConnectionRouter;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.mm.pictograms.Connection;

/**
 * The Class ManhattanConnectionEditPart.
 */
public class ManhattanConnectionEditPart extends ConnectionEditPart {

	/**
	 * The Constructor.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param connection
	 *            the connection
	 */
	public ManhattanConnectionEditPart(IConfigurationProvider configurationProvider, Connection connection) {
		super(configurationProvider, connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	public IFigure createFigure() {
		IFigure ret = super.createFigure();
		if (ret instanceof org.eclipse.draw2d.Connection) {
			org.eclipse.draw2d.Connection draw2dConnection = (org.eclipse.draw2d.Connection) ret;
			draw2dConnection.setConnectionRouter(new ManhattanConnectionRouter());
		}
		return ret;
	}

}