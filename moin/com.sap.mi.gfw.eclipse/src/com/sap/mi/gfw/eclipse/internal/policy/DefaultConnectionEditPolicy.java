package com.sap.mi.gfw.eclipse.internal.policy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Color;

import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.command.MoveShapeFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.internal.command.AddModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.command.CreateModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.config.ConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolylineConnection;
import com.sap.mi.gfw.eclipse.internal.parts.ConnectionEditPart;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.GFColorConstants;
import com.sap.mi.gfw.eclipse.internal.util.gef.GEFUtil;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.impl.CreateContext;
import com.sap.mi.gfw.features.context.impl.DeleteContext;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class DefaultConnectionEditPolicy extends ConnectionEditPolicy {

	private IConfigurationProvider _configurationProvider;

	public DefaultConnectionEditPolicy(IConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	protected final IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	@Override
	public Command getCommand(Request request) {
		if (request.getType().equals(REQ_ADD))
			return getAddCommand((ChangeBoundsRequest) request);
		if (request.getType().equals(REQ_CREATE))
			return getCreateCommand((CreateRequest) request);
		return super.getCommand(request);
	}

	protected Command getAddCommand(ChangeBoundsRequest request) {
		Command result = null;

		Object hostModel = getHost().getModel();

		Connection connection = (Connection) hostModel;

		Object model = ((EditPart) request.getEditParts().get(0)).getModel();
		if (model instanceof com.sap.mi.gfw.mm.pictograms.Shape) {
			com.sap.mi.gfw.mm.pictograms.Shape shape = (com.sap.mi.gfw.mm.pictograms.Shape) model;
			IConfigurationProvider configurationProvider = getConfigurationProvider();
			if (configurationProvider instanceof ConfigurationProvider) {
				ConfigurationProvider jmiConfigProv = (ConfigurationProvider) configurationProvider;
				IFeatureProvider featureProvider = jmiConfigProv.getDiagramTypeProvider().getFeatureProvider();

				ContainerShape oldContainer = shape.getContainer();

				ContainerShape targetContainerShape = null;

				Point location = request.getLocation();

				GraphicalViewer graphicalViewer = getConfigurationProvider().getDiagramEditor().getGraphicalViewer();
				EditPart findEditPartAt = GEFUtil.findEditPartAt(graphicalViewer, request.getLocation(), false);
				if (findEditPartAt != null && findEditPartAt.getModel() instanceof ContainerShape) {
					targetContainerShape = (ContainerShape) findEditPartAt.getModel();
					location = createRealLocation(request.getLocation(), findEditPartAt);
				} else {
					targetContainerShape = getCommonContainerShape();
				}

				IMoveShapeContext context = createMoveShapeContext(shape, oldContainer, targetContainerShape, location, connection);
				IMoveShapeFeature layoutShapeFeature = featureProvider.getMoveShapeFeature(context);
				if (layoutShapeFeature != null) {
					result = new GefCommandWrapper(new MoveShapeFeatureCommandWithContext(layoutShapeFeature, context), featureProvider
							.getConnection());
				}
			}
		}

		return result;

	}

	protected IMoveShapeContext createMoveShapeContext(com.sap.mi.gfw.mm.pictograms.Shape shape, ContainerShape source,
			ContainerShape target, Object constraint, Connection connection) {
		MoveShapeContext ret = new MoveShapeContext(shape);

		ret.setSourceContainer(source);
		ret.setTargetContainer(target);
		ret.setTargetConnection(connection);

		Point loc = null;
		if (constraint instanceof Rectangle) {
			Rectangle rect = (Rectangle) constraint;
			loc = rect.getLocation();
		} else if (constraint instanceof Point) {
			loc = (Point) constraint;
		}
		if (loc != null) {
			ret.setX(loc.x);
			ret.setY(loc.y);

			// calculate and store deltas
			if (shape != null) {
				GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
				if (graphicsAlgorithm != null) {
					ret.setDeltaX(loc.x - graphicsAlgorithm.getX());
					ret.setDeltaY(loc.y - graphicsAlgorithm.getY());
				}
			}
		}

		return ret;
	}

	protected Command getCreateCommand(CreateRequest request) {
		Command cmd = UnexecutableCommand.INSTANCE;
		ContainerShape targetContainerShape;

		GraphicalViewer graphicalViewer = getConfigurationProvider().getDiagramEditor().getGraphicalViewer();
		EditPart findEditPartAt = GEFUtil.findEditPartAt(graphicalViewer, request.getLocation(), false);
		if (findEditPartAt != null && findEditPartAt.getModel() instanceof ContainerShape) {
			targetContainerShape = (ContainerShape) findEditPartAt.getModel();
		} else {
			targetContainerShape = getCommonContainerShape();
		}

		Object createdObject = request.getNewObject();

		// determine constraint

		Rectangle rectangle = new Rectangle();

		if (findEditPartAt != null) {
			Point where = createRealLocation(request.getLocation(), findEditPartAt);
			rectangle.setLocation(where);
		} else {
			rectangle.setLocation(request.getLocation());
		}

		if (request.getSize() != null)
			rectangle.setSize(request.getSize());

		Connection connection = (Connection) getHost().getModel();

		if (request.getNewObjectType() == ICreateFeature.class) {
			ICreateContext context = ShapeXYLayoutEditPolicy.createCreateContext(targetContainerShape, rectangle);
			((CreateContext) context).setTargetConnection(connection);
			ICreateFeature createFeature = (ICreateFeature) createdObject;
			cmd = new CreateModelObjectCommand(getConfigurationProvider(), createFeature, context, rectangle);
			cmd.setLabel(createFeature.getDescription());
		} else if (request.getNewObjectType() == ISelection.class) {
			cmd = new AddModelObjectCommand(getConfigurationProvider(), targetContainerShape, (ISelection) createdObject, rectangle,
					connection);

		}

		return cmd;
	}

	private Point createRealLocation(Point location, EditPart findEditPartAt) {
		IFigure layoutContainer = ((GraphicalEditPart) findEditPartAt).getContentPane();
		Point where = location.getCopy();
		layoutContainer.translateToRelative(where);
		layoutContainer.translateFromParent(where);
		Point layoutOrigin = layoutContainer.getClientArea().getLocation();
		where.translate(layoutOrigin.getNegated());
		return where;
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		return getHost();
	}

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		if (getHost().getParent() == null) // do not allow to delete the
			// root-object itself
			return null;

		IFeatureProvider featureProvider = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();

		EditPart modelObjectEditPart = getHost();

		Object model = modelObjectEditPart.getModel();

		if (!(model instanceof PictogramElement))
			return null;

		IDeleteContext context = new DeleteContext((PictogramElement) model);
		IFeature feature = featureProvider.getDeleteFeature(context);

		if (feature == null)
			return null;

		GenericFeatureCommandWithContext command = new GenericFeatureCommandWithContext(feature, context);

		return new GefCommandWrapper(command, featureProvider.getConnection());
	}

	/**
	 * ********************************* FEEDBACK *************************************************
	 */
	private Color originalColor;

	private int originalLineStyle;

	private Map<IFigure, Color> decorationColor = new HashMap<IFigure, Color>();

	private Map<IFigure, Integer> decorationLineStyle = new HashMap<IFigure, Integer>();

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if (REQ_CREATE.equals(request.getType()) || REQ_ADD.equals(request.getType())) {

			// show feedback only if a valid command(feature) is available
			Command command = getHost().getCommand(request);
			boolean commandExistsForRequest = command != null && command.canExecute();
			if (!commandExistsForRequest) {
				return;
			}

			ConnectionEditPart connectionEditPart = (ConnectionEditPart) getHost();
			GfwPolylineConnection connection = (GfwPolylineConnection) connectionEditPart.getFigure();

			if (originalColor == null) {

				originalColor = connection.getForegroundColor();
				originalLineStyle = connection.getLineStyle();

				connection.setForegroundColor(GFColorConstants.HANDLE_BG);
				connection.setLineStyle(Graphics.LINE_DASH);

				List<IFigure> allDecorations = connection.getAllDecorations();
				for (IFigure decoration : allDecorations) {
					if (decoration != null) {
						Color currentColor = decoration.getForegroundColor();
						decorationColor.put(decoration, currentColor);
						decoration.setForegroundColor(GFColorConstants.HANDLE_BG);
						if (decoration instanceof Shape) {
							Shape decorationShape = (Shape) decoration;
							int currentLineStyle = decorationShape.getLineStyle();
							decorationLineStyle.put(decorationShape, new Integer(currentLineStyle));
							decorationShape.setLineStyle(Graphics.LINE_DASH);
						}
					}
				}
			}

		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		if (REQ_CREATE.equals(request.getType()) || REQ_ADD.equals(request.getType())) {

			if (originalColor == null) {
				return;
			}

			ConnectionEditPart connectionEditPart = (ConnectionEditPart) getHost();

			GfwPolylineConnection connection = (GfwPolylineConnection) connectionEditPart.getFigure();

			connection.setForegroundColor(originalColor);
			connection.setLineStyle(originalLineStyle);

			List<IFigure> allDecorations = connection.getAllDecorations();
			for (IFigure decoration : allDecorations) {
				if (decoration != null) {
					Color previousColor = decorationColor.get(decoration);
					decoration.setForegroundColor(previousColor);
					if (decoration instanceof Shape) {
						Shape decorationShape = (Shape) decoration;
						Integer previousLineStyle = decorationLineStyle.get(decoration);
						if (previousLineStyle != null)
							decorationShape.setLineStyle(previousLineStyle);
					}
				}
			}

			originalColor = null;
			decorationColor.clear();
			decorationLineStyle.clear();
		}
	}

	/**
	 * @return the most specific container that source and target of this connection have in common
	 */
	private ContainerShape getCommonContainerShape() {

		ConnectionEditPart connectionEditPart = (ConnectionEditPart) getHost();

		EditPart sourceEditPart = connectionEditPart.getSource();
		EditPart targetEditPart = connectionEditPart.getTarget();
		EditPart parent = getCommonEditPart(sourceEditPart, targetEditPart);

		return (ContainerShape) parent.getModel();
	}

	/**
	 * investigates the common parent of both editparts. the least common parent is the diagram editpart
	 */
	private static EditPart getCommonEditPart(EditPart source, EditPart target) {

		// create two lists with editparts to the root

		List<EditPart> list1 = new ArrayList<EditPart>();
		List<EditPart> list2 = new ArrayList<EditPart>();

		EditPart editPart = source;

		while (!(editPart instanceof RootEditPart)) {
			list1.add(0, editPart);
			editPart = editPart.getParent();
		}

		editPart = target;

		while (!(editPart instanceof RootEditPart)) {
			list2.add(0, editPart);
			editPart = editPart.getParent();
		}

		// compare the lists until that position where editparts differ
		int index = 0;
		while (true) {
			if (index == list1.size())
				return list1.get(index - 1);

			if (index == list2.size())
				return list1.get(index - 1);

			if (list1.get(index) != list2.get(index))
				return list1.get(index - 1);

			index++;
		}
	}
}
