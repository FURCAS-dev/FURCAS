package com.sap.mi.gfw.eclipse.internal.policy;

import java.util.Arrays;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.viewers.ISelection;

import com.sap.mi.gfw.DiagramScrollingBehavior;
import com.sap.mi.gfw.command.CommandContainer;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.command.MoveShapeFeatureCommandWithContext;
import com.sap.mi.gfw.command.ResizeShapeFeatureCommandWithContext;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.eclipse.internal.command.AddModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.command.CreateModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.command.MoveAnchorFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.contextbuttons.IContextButtonManager;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.parts.ShapeEditPart;
import com.sap.mi.gfw.eclipse.internal.util.Util;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveAnchorFeature;
import com.sap.mi.gfw.features.IMoveConnectionDecoratorFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.IMoveAnchorContext;
import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.impl.AreaAnchorContext;
import com.sap.mi.gfw.features.context.impl.CreateContext;
import com.sap.mi.gfw.features.context.impl.MoveConnectionDecoratorContext;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.PeUtil;

/**
 * An EditPolicy, where the Layout of the EditParts is important: they must have an XYLayout. It assumes, that this EditPart is a parent,
 * whose children can be added/deleted/moved.
 * 
 * @see com.sap.ide.eclipse.gf.policy.IEditPolicyFactory#createShapeXYLayoutEditPolicy()
 */
public class ShapeXYLayoutEditPolicy extends XYLayoutEditPolicy {

	private IConfigurationProvider _configurationProvider;

	/**
	 * Creates a new ShapeXYLayoutEditPolicy.
	 * 
	 * @param configurationProvider
	 *            The IConfigurationProvider.
	 */
	protected ShapeXYLayoutEditPolicy(IConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	protected final IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	/**
	 * Is called, when a child EditPart shall be moved from another parent-EditPart into this parent-EditPart. It creates an
	 * ICommandCombiner.createSetParentReferenceCommand().
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	@Override
	protected Command createAddCommand(EditPart child, Object constraint) {

		Object model = child.getModel();
		Rectangle rectangle = getHostFigure().getBounds();

		if (model instanceof ConnectionDecorator && constraint instanceof Rectangle && rectangle != null) {

			// change constraint to absolute values
			getHostFigure().translateToAbsolute((Rectangle) constraint);

			IConfigurationProvider configurationProvider = getConfigurationProvider();
			Point viewLocation = null;
			DiagramEditor diagramEditor = getConfigurationProvider().getDiagramEditor();
			if (diagramEditor.getDiagramScrollingBehavior() == DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE) {
				viewLocation = configurationProvider.getDiagramEditor().getGFWFigureCanvas().getViewport().getViewLocation();
			} else {
				viewLocation = configurationProvider.getDiagramEditor().getFigureCanvas().getViewport().getViewLocation();
			}

			((Rectangle) constraint).translate(viewLocation);

			ICommand cmd = getMoveConnectionDecoratorCommand((ConnectionDecorator) model, (Rectangle) constraint, rectangle.x, rectangle.y);

			if (cmd != null) {
				return new GefCommandWrapper(cmd, configurationProvider.getFeatureProvider().getConnection());
			}
		}
		return null;
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (!(child instanceof ShapeEditPart))
			return new NonResizableEditPolicy();

		PictogramElement pictogramElement = ((ShapeEditPart) child).getPictogramElement();

		if (!(pictogramElement instanceof Shape)) {
			return new GFNonResizableEditPolicy(getConfigurationProvider());
		}

		Shape shape = (Shape) pictogramElement;

		ResizeShapeContext resizeShapeContext = new ResizeShapeContext(shape);

		IResizeShapeFeature resizeShapeFeature = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider()
				.getResizeShapeFeature(resizeShapeContext);

		if (resizeShapeFeature == null || !resizeShapeFeature.canResizeShape(resizeShapeContext)) {
			return new GFNonResizableEditPolicy(getConfigurationProvider());
		}

		return new GFResizableEditPolicy(getConfigurationProvider(), resizeShapeContext);
	}

	/**
	 * Is called, when a child EditPart shall be moved inside this parent-EditPart (resized or changed XY-position). It creates an
	 * ICommandFactory.createChangeModelObjectConstraintCommand(().
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {

		IConfigurationProvider configurationProvider = getConfigurationProvider();
		IFeatureProvider featureProvider = configurationProvider.getDiagramTypeProvider().getFeatureProvider();
		CommandContainer ret = new CommandContainer(featureProvider);

		Object model = child.getModel();

		if (!(model instanceof RefObject) || MoinHelper.isObjectAlive((RefObject) model)) {

			// connection decorators
			if (model instanceof ConnectionDecorator) {
				if (constraint instanceof Rectangle) {
					ICommand cmd = getMoveConnectionDecoratorCommand((ConnectionDecorator) model, (Rectangle) constraint, 0, 0);
					if (cmd != null) {
						ret.add(cmd);
					}
				}
			} else
			// anchors
			if (model instanceof Anchor) {
				Anchor anchor = (Anchor) model;
				AnchorContainer anchorContainer = anchor.getParent();

				IMoveAnchorContext context = createLayoutAnchorContext(anchor, anchorContainer, anchorContainer, constraint);

				IMoveAnchorFeature moveAnchorFeature = featureProvider.getMoveAnchorFeature(context);
				if (moveAnchorFeature != null) {
					if (child instanceof GraphicalEditPart) {
						ret.add(new MoveAnchorFeatureCommandWithContext(moveAnchorFeature, context, (GraphicalEditPart) child));
					}
				}
			} else
			// shapes
			if (model instanceof Shape) {
				Shape shape = (Shape) model;
				ContainerShape containerShape = shape.getContainer();

				{
					IMoveShapeContext context = createMoveShapeContext(shape, containerShape, containerShape, constraint);

					IMoveShapeFeature moveShapeFeature = featureProvider.getMoveShapeFeature(context);
					if (moveShapeFeature != null) {
						if (child instanceof ShapeEditPart) {
							ret.add(new MoveShapeFeatureCommandWithContext(moveShapeFeature, context));
						}
					}
				}

				{

					Rectangle rect = (Rectangle) constraint;
					IDimension sizeOfGA = GaUtil.calculateSizeOfGraphicsAlgorithm(shape.getGraphicsAlgorithm(), false);

					if (rect.width != sizeOfGA.getWidth() || rect.height != sizeOfGA.getHeight()) {
						IResizeShapeContext context = createResizeShapeContext(shape, constraint);

						IResizeShapeFeature resizeShapeFeature = featureProvider.getResizeShapeFeature(context);
						if (resizeShapeFeature != null) {
							ret.add(new ResizeShapeFeatureCommandWithContext(resizeShapeFeature, context));
							// } else if (child instanceof ShapeEditPart) {
							// ret.add(new ResizeShapeFeatureCommandWithContext(resizeShapeFeature, context));
						}

					}

				}
			}
		}

		if (ret.containsCommands()) {
			// hide context-buttons, if the user resizes/moves the shape
			DiagramEditor editor = getConfigurationProvider().getDiagramEditor();
			IContextButtonManager contextButtonManager = editor.getContextButtonManager();
			contextButtonManager.hideContextButtonsInstantly();

			return new GefCommandWrapper(ret, featureProvider.getConnection());
		} else {
			return null;
		}
	}

	/**
	 * @param constraint
	 * @param coll
	 * @param container
	 * @param container2
	 * @return
	 */
	protected IMoveShapeContext createMoveShapeContext(Shape shape, ContainerShape source, ContainerShape target, Object constraint) {
		MoveShapeContext ret = new MoveShapeContext(shape);

		ret.setSourceContainer(source);
		ret.setTargetContainer(target);

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

	protected IResizeShapeContext createResizeShapeContext(Shape shape, Object constraint) {
		ResizeShapeContext ret = new ResizeShapeContext(shape);

		Dimension dim = null;
		if (constraint instanceof Rectangle) {
			Rectangle rect = (Rectangle) constraint;
			dim = rect.getSize();
		} else if (constraint instanceof Dimension) {
			dim = (Dimension) constraint;
		}
		if (dim != null) {
			ret.setWidth(dim.width);
			ret.setHeight(dim.height);
		}

		return ret;
	}

	protected IMoveAnchorContext createLayoutAnchorContext(Anchor shape, AnchorContainer source, AnchorContainer target, Object constraint) {
		AreaAnchorContext ret = new AreaAnchorContext(shape);

		ret.setSourceContainer(source);
		ret.setTargetContainer(target);

		if (constraint instanceof Rectangle) {
			Rectangle rect = (Rectangle) constraint;
			ret.setX(rect.x);
			ret.setY(rect.y);
			ret.setWidth(rect.width);
			ret.setHeight(rect.height);
		}

		return ret;
	}

	/**
	 * @param constraint
	 * @param coll
	 * @param container
	 * @param container2
	 * @return
	 */
	public static ICreateContext createCreateContext(ContainerShape target, Rectangle rect) {
		CreateContext ret = new CreateContext();

		ret.setTargetContainer(target);

		ret.setX(rect.x);
		ret.setY(rect.y);
		ret.setWidth(rect.width);
		ret.setHeight(rect.height);

		return ret;
	}

	/**
	 * Is called, when a new child EditPart shall be created inside this parent-EditPart (with the CreationTool). It creates an
	 * ICommandCombiner.createCreateModelObjectCommand().
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Command cmd = UnexecutableCommand.INSTANCE;

		// check if _target is valid
		Object parentObject = getHost().getModel();
		if (!(parentObject instanceof ContainerShape))
			return cmd;
		Object createdObject = request.getNewObject();

		// determine constraint
		Rectangle rectangle = null;
		if (request.getLocation() != null) {
			rectangle = (Rectangle) getConstraintFor(request);
		}

		if (request.getNewObjectType() == ICreateFeature.class) {
			ICreateContext context = createCreateContext((ContainerShape) parentObject, rectangle);
			ICreateFeature createFeature = (ICreateFeature) createdObject;
			cmd = new CreateModelObjectCommand(getConfigurationProvider(), createFeature, context, rectangle);
			cmd.setLabel(createFeature.getDescription());
		} else if (request.getNewObjectType() == ISelection.class) {
			cmd = new AddModelObjectCommand(getConfigurationProvider(), (ContainerShape) parentObject, (ISelection) createdObject,
					rectangle);
		}

		return cmd;
	}

	/**
	 * Usage unknown, returns null.
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	private ICommand getMoveConnectionDecoratorCommand(ConnectionDecorator decorator, Rectangle constraint, int offsetX, int offsetY) {

		ICommand ret = null;

		int x = constraint.x + offsetX;
		int y = constraint.y + offsetY;

		Connection connection = decorator.getConnection();
		double location = decorator.getLocation();

		if (decorator.isLocationRelative()) {
			Point connectionMidpoint = Util.getConnectionPointAt(connection, location);
			x = x - connectionMidpoint.x;
			y = y - connectionMidpoint.y;
		} else {
			// absoluteLocation
			Point absolutePointOnConnection = Util.getAbsolutePointOnConnection(connection, location);
			x = x - absolutePointOnConnection.x;
			y = y - absolutePointOnConnection.y;
		}

		/**
		 * allow move of connection decorator only, if both connection ends are not in the selection of moved objects
		 */
		boolean isExecuteAllowed = true;
		PictogramElement[] selectedPictogramElements = getConfigurationProvider().getDiagramEditor().getSelectedPictogramElements();
		List<PictogramElement> pes = Arrays.asList(selectedPictogramElements);
		if (pes.size() > 1) {
			PictogramElement startAnchorContainer = PeUtil.getActiveContainerPe(decorator.getConnection().getStart());
			PictogramElement endAnchorContainer = PeUtil.getActiveContainerPe(decorator.getConnection().getEnd());
			if (pes.contains(startAnchorContainer) || pes.contains(endAnchorContainer)) {
				isExecuteAllowed = false;
			}
		}

		IMoveConnectionDecoratorContext context = new MoveConnectionDecoratorContext(decorator, x, y, isExecuteAllowed);
		IMoveConnectionDecoratorFeature feature = getFeatureProvider().getMoveConnectionDecoratorFeature(context);
		if (feature != null) {
			ret = new GenericFeatureCommandWithContext(feature, context);
		}

		return ret;
	}

	private IFeatureProvider getFeatureProvider() {
		return getConfigurationProvider().getFeatureProvider();
	}
}