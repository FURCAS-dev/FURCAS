package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.MarqueeDragTracker;
import org.eclipse.swt.SWT;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * A GraphicalEditPart, which model is of the type Diagram.
 */
public class DiagramEditPart extends ContainerShapeEditPart implements IDiagramEditPart {

	/**
	 * Creates a new DiagramEditPart.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param diagram
	 *            the diagram
	 */
	public DiagramEditPart(IConfigurationProvider configurationProvider, Diagram diagram) {
		super(configurationProvider, diagram);
	}

	/**
	 * Creates the Figure of this editpart. This determines how the editpart will be displayed. The actual data for this figure should be
	 * provided in refreshVisuals().
	 * 
	 * @return the i figure
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {

		IFigure f = new FreeformLayer() {

			@Override
			protected void paintFigure(Graphics graphics) {
				graphics.setAntialias(SWT.ON);
				super.paintFigure(graphics);
			}

		};

		GraphicsAlgorithm graphicsAlgorithm = getPictogramElement().getGraphicsAlgorithm();
		f.setBackgroundColor(DataTypeTransformation.toSwtColor(getConfigurationProvider(), GaUtilInternal.getBackgroundColor(
				graphicsAlgorithm, true)));
		f.setLayoutManager(new XYLayout() {

			/**
			 * this is important to prevent infinite loops
			 * 
			 * @see http://www.eclipse.org/gef/developer/gotchas.html
			 */
			@Override
			public Point getOrigin(IFigure parent) {
				return new Point();
			}

		});

		ConnectionLayer cLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		cLayer.setAntialias(SWT.ON);

		return f;
	}

	/**
	 * Returns the DragTracker for this EditPart. By default an EditPart allows supports moving EditParts on drag&drop. However, an EditPart
	 * with children shall use another DragTracker, which supports selecting EditParts like the MarqueSelectionTool, but only, if the
	 * content-pane is selected.
	 * 
	 * @param request
	 *            the request
	 * 
	 * @return the drag tracker
	 * 
	 * @see org.eclipse.gef.EditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		if (request instanceof SelectionRequest) {
			SelectionRequest casted = (SelectionRequest) request;
			// On right-mouse-click use the standard-behaviour, which
			// selects the EditParts. So the ContextMenu will
			// works on the EditPart where the menu appears.
			if (casted.getLastButtonPressed() == 3)
				return super.getDragTracker(request);

			// Is the mouse-location inside the ContentPane?
			Point location = casted.getLocation().getCopy();
			getContentPane().translateToRelative(location);
			if (getContentPane().getClientArea().contains(location))
				return new MarqueeDragTracker();
		}

		// All other EditParts should behave as usual
		return super.getDragTracker(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	public List<PictogramElement> getModelChildren() {
		List<PictogramElement> result = new ArrayList<PictogramElement>();
		result.addAll(super.getModelChildren());

		// return also the active connection-decorators
		Collection<Connection> connections = getDiagram().getConnections();
		for (Connection connection : connections) {
			Collection<ConnectionDecorator> connectionDecorators = connection.getConnectionDecorators();
			for (ConnectionDecorator connectionDecorator : connectionDecorators) {
				if (connectionDecorator.isActive() && connectionDecorator.getGraphicsAlgorithm() != null) {
					result.add(connectionDecorator);
				}
			}
		}

		return result;
	}

	private Diagram getDiagram() {
		return (Diagram) getModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.ShapeEditPart#refresh()
	 */
	@Override
	public void refresh() {
		DiagramEditor editor = (DiagramEditor) getConfigurationProvider().getWorkbenchPart();
		editor.initRefresh();
		super.refresh();
	}
}