/*
 * Created on 27.09.2005
 */
package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;

/**
 * The Class FreeFormConnectionEditPart.
 */
public class FreeFormConnectionEditPart extends ConnectionEditPart {

	/**
	 * The Constructor.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param connection
	 *            the connection
	 */
	public FreeFormConnectionEditPart(IConfigurationProvider configurationProvider, Connection connection) {
		super(configurationProvider, connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.ConnectionEditPart#createFigure()
	 */
	@Override
	public IFigure createFigure() {
		IFigure ret = super.createFigure();
		if (ret instanceof org.eclipse.draw2d.Connection) {
			org.eclipse.draw2d.Connection draw2dConnection = (org.eclipse.draw2d.Connection) ret;
			draw2dConnection.setConnectionRouter(new BendpointConnectionRouter());
		}
		return ret;
	}

	private void refreshBendpoints() {
		FreeFormConnection ffc = (FreeFormConnection) getConnection();
		if (!MoinHelper.isObjectAlive(ffc)) {
			return;
		}

		List<Bendpoint> pointList = new ArrayList<Bendpoint>();
		for (Iterator iter = ffc.getBendpoints().iterator(); iter.hasNext();) {
			com.sap.mi.gfw.mm.datatypes.Point point = (com.sap.mi.gfw.mm.datatypes.Point) iter.next();
			Bendpoint draw2dBendPoint = DataTypeTransformation.toDraw2dBendPoint(point);
			pointList.add(draw2dBendPoint);
		}
		getConnectionFigure().setRoutingConstraint(pointList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.ConnectionEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, getConfigurationProvider().getEditPolicyFactory()
				.createConnectionBendpointsEditPolicy());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.parts.ConnectionEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBendpoints();
	}
}
