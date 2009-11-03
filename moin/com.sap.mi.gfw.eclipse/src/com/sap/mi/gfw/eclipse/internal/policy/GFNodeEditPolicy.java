package com.sap.mi.gfw.eclipse.internal.policy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.swt.SWT;

import com.sap.mi.gfw.eclipse.internal.command.CreateConnectionCommand;
import com.sap.mi.gfw.eclipse.internal.command.ReconnectCommand;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.requests.ContextButtonDragRequest;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.GFColorConstants;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.impl.ReconnectionContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class GFNodeEditPolicy extends GraphicalNodeEditPolicy {

	private IConfigurationProvider configurationProvider;

	Rectangle rec;

	/**
	 * Retrieves bounds of the source figure and updates the rec variable. If not applicable, sets rec to <code>null</code>.
	 * 
	 * @param req
	 *            The Request of the current createDummyConnection call.
	 */
	private void identifySourceFigure(Request req) {
		if (req instanceof CreateConnectionRequest) {
			CreateConnectionRequest r = (CreateConnectionRequest) req;
			if (r.getSourceEditPart() instanceof AbstractGraphicalEditPart) {
				AbstractGraphicalEditPart ep = (AbstractGraphicalEditPart) r.getSourceEditPart();
				rec = ep.getFigure().getBounds();
			}
		} else {
			rec = null;
		}
	}

	@Override
	protected org.eclipse.draw2d.Connection createDummyConnection(Request req) {
		identifySourceFigure(req);
		PolylineConnection c = new PolylineConnection() {
			@Override
			public void paint(Graphics g) {
				// We do not draw unless the target position of the
				// dummy connection lies outside of the source figure's bounds.
				if (rec != null && rec.contains(getPoints().getLastPoint())) {
					return;
				}
				g.setAntialias(SWT.ON);
				super.paint(g);
			}
		};

		c.setLineWidth((int) (2 * configurationProvider.getDiagramEditor().getZoomLevel()));
		c.setForegroundColor(GFColorConstants.HANDLE_BG);
		c.setLineStyle(SWT.LINE_DASH);
		return c;
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		// BUGFIX: dummy figure doesnt get removed when using GFOptionCommand
		if (request instanceof CreateConnectionRequest) {
			eraseCreationFeedback((CreateConnectionRequest) request);
		}
	}

	/**
	 * 
	 */
	public GFNodeEditPolicy(IConfigurationProvider configurationProvider) {
		super();
		this.configurationProvider = configurationProvider;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {

		if (request instanceof ContextButtonDragRequest) {

			ContextButtonDragRequest cbdr = (ContextButtonDragRequest) request;

			CreateConnectionCommand cmd = new CreateConnectionCommand(configurationProvider, (PictogramElement) getHost().getModel(), cbdr
					.getContextButtonEntry().getDragAndDropFeatures());

			request.setStartCommand(cmd);
			cmd.setLocation(request.getLocation());
			return cmd;

		}

		else if ((getHost().getModel() instanceof PictogramElement) && (request.getNewObject() instanceof List)) {

			List<IFeature> features = (List<IFeature>) request.getNewObject();

			CreateConnectionCommand cmd = new CreateConnectionCommand(configurationProvider, (PictogramElement) getHost().getModel(),
					features);
			if (!cmd.canStartConnection()) {
				return null;
			}
			cmd.setLocation(request.getLocation());
			request.setStartCommand(cmd);
			return cmd;

		}
		return null;
	}

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {

		if (request.getStartCommand() instanceof CreateConnectionCommand) {

			CreateConnectionCommand cmd = (CreateConnectionCommand) request.getStartCommand();

			Object target = request.getTargetEditPart().getModel();
			if (target instanceof PictogramElement) {
				cmd.setTarget((PictogramElement) target);
			}

			cmd.setLocation(request.getLocation());

			if (cmd.canExecute()) {
				return cmd;
			}

		}

		return null;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		Connection conn = (Connection) request.getConnectionEditPart().getModel();
		return getReconnectCommand(conn, conn.getEnd(), ReconnectionContext.RECONNECT_TARGET);
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		Connection conn = (Connection) request.getConnectionEditPart().getModel();
		return getReconnectCommand(conn, conn.getStart(), ReconnectionContext.RECONNECT_SOURCE);
	}

	private ReconnectCommand getReconnectCommand(Connection conn, Anchor oldAnchor, String reconnectType) {
		PictogramElement newTarget = (PictogramElement) getHost().getModel();
		Anchor newAnchor = getAnchorForPictogramElement(newTarget);
		ReconnectCommand cmd = new ReconnectCommand(getConfigurationProvider(), conn, oldAnchor, newAnchor, newTarget, reconnectType);
		return cmd;
	}

	private Anchor getAnchorForPictogramElement(PictogramElement connectionTarget) {
		if (connectionTarget instanceof Anchor) {
			return (Anchor) connectionTarget;
		} else if (connectionTarget instanceof AnchorContainer) {
			Collection existingAnchors = ((AnchorContainer) connectionTarget).getAnchors();
			for (Iterator iter = existingAnchors.iterator(); iter.hasNext();) {
				Anchor anchor = (Anchor) iter.next();
				if (anchor instanceof ChopboxAnchor) {
					return anchor;
				}
			}
		}
		return null;
	}

	protected IConfigurationProvider getConfigurationProvider() {
		return configurationProvider;
	}

}