package com.sap.mi.gfw.internal.autolayout;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import y.base.Edge;
import y.base.EdgeMap;
import y.base.Node;
import y.base.NodeMap;
import y.geom.YDimension;
import y.geom.YPoint;
import y.layout.DefaultLayoutGraph;
import y.layout.LayoutGraph;
import y.layout.grouping.GroupingKeys;
import y.util.DataProviderAdapter;

import com.sap.mi.gfw.autolayout.ILayoutStructureProvider;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.datatypes.impl.LocationImpl;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.GaUtil;

// XXX: probably it would be better to get the current Rectangles from the
// pictogram-model (Shape) instead of getting it from the IFigures.
// This should be valid, because we always have a Dimension/Point stored
// in a Shape (except perhaps in the Dimension?!).

/**
 * A default implementation of the interface IGraphTransformer.
 */
public class DefaultGraphTransformation extends AbstractGraphTransformation {

	/**
	 * Creates a new DefaultGraphTransformer.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 * @param layoutStructureProvider
	 *            the layout structure provider
	 */
	public DefaultGraphTransformation(IFeatureProvider featureProvider, ILayoutStructureProvider layoutStructureProvider) {
		super(featureProvider, layoutStructureProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.command.layout.IGraphTransformer#createLayoutGraph(org.eclipse.gef.EditPart)
	 */
	public LayoutGraph createLayoutGraph() {
		DefaultLayoutGraph graph = new DefaultLayoutGraph();
		return createDefaultLayoutGraph(graph);
	}

	/**
	 * Creates the default layout graph.
	 * 
	 * @param graph
	 *            the graph
	 * 
	 * @return the default layout graph
	 */
	protected DefaultLayoutGraph createDefaultLayoutGraph(DefaultLayoutGraph graph) {
		graph.addDataProvider(GroupingKeys.NODE_ID_DPKEY, graph.createNodeMap());
		graph.addDataProvider(GroupingKeys.PARENT_NODE_ID_DPKEY, graph.createNodeMap());
		graph.addDataProvider(GroupingKeys.GROUP_DPKEY, graph.createNodeMap());
		graph.addDataProvider(GroupingKeys.GROUP_NODE_INSETS_DPKEY, graph.createNodeMap());
		graph.addDataProvider(PROVIDER_SHAPE_TO_NODE, new SimpleDataProvider());
		graph.addDataProvider(PROVIDER_EDGE_TO_MODEL_REFERENCE, graph.createEdgeMap());
		// graph.addDataProvider(PROVIDER_MODEL_REFERENCE_TO_OLD_POINTS, new SimpleDataProvider());

		// determine nodes recursively
		Set allConnections = new HashSet();

		ContainerShape root = getLayoutStructureProvider().getRoot();

		createNodes(graph, root, allConnections);
		setNodeLocations(graph, root);
		createEdges(graph, root);

		// adjust the dimensions from 'current' to 'wanted', depending on the preferences
		// adjustDimensions(graph);

		return graph;
	}

	/**
	 * Returns the Node for the given EditPart.
	 * 
	 * @param graph
	 *            The Graph, where to create the Edge.
	 * @param pictogramElement
	 *            The EditPart for which to return the Node.
	 * @param allConnections
	 *            A List, which will be filled with all outgoing and incoming ConnectionEditParts of this EditPart.
	 * 
	 * @return The Node for the given EditPart.
	 */
	protected Node createNodes(DefaultLayoutGraph graph, PictogramElement pictogramElement, Set allConnections) {
		// if (!(containerShape instanceof GraphicalEditPart)) // unusual, but might happen
		// return null;

		// get casted data-providers of the graph
		NodeMap nodeToShape = (NodeMap) graph.getDataProvider(GroupingKeys.NODE_ID_DPKEY);
		NodeMap nodeToParentShape = (NodeMap) graph.getDataProvider(GroupingKeys.PARENT_NODE_ID_DPKEY);
		NodeMap nodeHasChildren = (NodeMap) graph.getDataProvider(GroupingKeys.GROUP_DPKEY);
		NodeMap nodeToInsets = (NodeMap) graph.getDataProvider(GroupingKeys.GROUP_NODE_INSETS_DPKEY);
		SimpleDataProvider shapeToNode = (SimpleDataProvider) graph.getDataProvider(PROVIDER_SHAPE_TO_NODE);

		Shape shape = (Shape) pictogramElement;
		Node node = graph.createNode();
		nodeToShape.set(node, shape);
		shapeToNode.set(shape, node);

		IDimension gaSize = GaUtil.calculateSizeOfGraphicsAlgorithm(pictogramElement.getGraphicsAlgorithm(), false);
		graph.setSize(node, gaSize.getWidth(), gaSize.getHeight());

		// additional handling for parents with children
		nodeHasChildren.setBool(node, false);

		// determine insets
		Insets insets = new Insets(0, 0, 0, 0);// getInsets(containerShape.get);
		nodeToInsets.set(node, insets);

		PictogramElement[] children = getLayoutStructureProvider().getChildren(pictogramElement);

		if (children != null) {
			for (int i = 0; i < children.length; i++) {

				Node childNode = createNodes(graph, children[i], allConnections);
				if (childNode != null) {
					nodeToParentShape.set(childNode, shape);
				}
			}

		}

		return node;
	}

	/**
	 * Creates the edges.
	 * 
	 * @param graph
	 *            the graph
	 * @param sourcePE
	 *            the source pe
	 */
	protected void createEdges(DefaultLayoutGraph graph, PictogramElement sourcePE) {
		ILayoutStructureProvider layoutProvider = getLayoutStructureProvider();
		Node sourceNode = getNodeForPE(graph, sourcePE);
		// SimpleDataProvider modelReferenceToOldPoints = (SimpleDataProvider)
		// graph.getDataProvider(PROVIDER_MODEL_REFERENCE_TO_OLD_POINTS);

		EdgeMap edgeToModelReference = (EdgeMap) graph.getDataProvider(PROVIDER_EDGE_TO_MODEL_REFERENCE);

		Connection[] connections = layoutProvider.getOutgoingConnections(sourcePE);
		// for every target -> create connection
		for (int i = 0; i < connections.length; i++) {

			PictogramElement target = layoutProvider.getTarget(connections[i]);

			Node targetNode = getNodeForPE(graph, target);

			Edge edge = graph.createEdge(sourceNode, targetNode);

			if (connections[i].getGraphicsAlgorithm() instanceof Polyline) {
				List pointList = ((Polyline) connections[i].getGraphicsAlgorithm()).getPoints();
				pointList.clear();

				Point points[] = new Point[pointList.size()];
				for (int j = 0; j < points.length; j++) {
					com.sap.mi.gfw.mm.datatypes.Point gfwPoint = ((com.sap.mi.gfw.mm.datatypes.Point) pointList.get(j));
					points[j] = new Point(gfwPoint.getX(), gfwPoint.getY());

					pointList.add(gfwPoint);
				}
				// modelReferenceToOldPoints.set(connections[i], points);

			}

			edgeToModelReference.set(edge, connections[i]);

		}

		// Only if the children can be arranged in the parents content-pane
		// (e.g. XYLayout) they are treated as own Nodes.

		PictogramElement[] children = layoutProvider.getChildren(sourcePE);
		if (children != null) {
			for (int i = 0; i < children.length; i++) {
				createEdges(graph, children[i]);
			}
		}
	}

	/**
	 * Returns the Node for the given EditPart. If the EditPart does not have a Node, then it returns the node for the parent-EditPart
	 * recursively. This method is useful for determining Edges. For example it can happen, that an EditPart is not an own Node in the
	 * Graph.
	 * 
	 * @param graph
	 *            The graph, which contains all Nodes.
	 * @param pe
	 *            The EditPart for whihc to return the Node.
	 * 
	 * @return the Node for the given EditPart.
	 */
	protected Node getNodeForPE(DefaultLayoutGraph graph, PictogramElement pe) {
		// get casted data-providers of the graph
		if (pe == null)
			return null;
		SimpleDataProvider shapeToNode = (SimpleDataProvider) graph.getDataProvider(PROVIDER_SHAPE_TO_NODE);
		Node node = (Node) shapeToNode.get(pe);

		return node;

		// if (node != null)
		// return node;
		// return getNodeRecursively(graph, editPart.getParent());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.command.layout.IGraphTransformer#createPerformLayoutCommand(y.layout.LayoutGraph,
	 * org.eclipse.gef.EditPart, com.sap.mi.gfw.pf.eclipse.internal.command.ICommandFactory)
	 */

	public void performLayoutGraph(LayoutGraph graph) {
		// get casted data-providers of the graph
		NodeMap nodeToShape = (NodeMap) graph.getDataProvider(GroupingKeys.NODE_ID_DPKEY);
		NodeMap nodeToParentShape = (NodeMap) graph.getDataProvider(GroupingKeys.PARENT_NODE_ID_DPKEY);
		NodeMap nodeToInsets = (NodeMap) graph.getDataProvider(GroupingKeys.GROUP_NODE_INSETS_DPKEY);
		SimpleDataProvider shapeToNode = (SimpleDataProvider) graph.getDataProvider(PROVIDER_SHAPE_TO_NODE);
		EdgeMap edgeToModelReference = (EdgeMap) graph.getDataProvider(PROVIDER_EDGE_TO_MODEL_REFERENCE);
		// SimpleDataProvider modelReferenceToOldPoints = (SimpleDataProvider)
		// graph
		// .getDataProvider(PROVIDER_MODEL_REFERENCE_TO_OLD_POINTS);

		ILocation vectorToOrigin = getVectorToOrigin(graph);

		// add commands to adjust nodes (resp. the corresponding model objects)
		Node allNodes[] = graph.getNodeArray();
		for (int i = 0; i < allNodes.length; i++) {
			Node node = allNodes[i];
			PictogramElement pictogramElement = (PictogramElement) nodeToShape.get(node);
			YPoint point = graph.getLocation(node);
			if (i == 0) {
				graph.setLocation(node, 0, 0);
			}

			YDimension dimension = graph.getSize(node);
			Rectangle rectangle = new Rectangle((int) point.x + vectorToOrigin.getX(), (int) point.y + vectorToOrigin.getY(),
					(int) dimension.width, (int) dimension.height);

			// adjust rectangle relative to its parent
			Object parentModelObject = nodeToParentShape.get(node);
			if (parentModelObject != null) {
				Node parentNode = (Node) shapeToNode.get(parentModelObject);
				YPoint parentLocation = graph.getLocation(parentNode);
				rectangle.x -= parentLocation.x;
				rectangle.y -= parentLocation.y;

				Insets parentInsets = (Insets) nodeToInsets.get(parentNode);
				if (parentInsets != null) {
					rectangle.x -= parentInsets.left;
					rectangle.y -= parentInsets.top;
				}
			} else {
				rectangle.x = 0;
				rectangle.y = 0;
			}

			// adjust rectangle for possible rounding errors
			if (rectangle.x < 0)
				rectangle.x = 0;
			if (rectangle.y < 0)
				rectangle.y = 0;

			setRectangleForShape((Shape) pictogramElement, rectangle);

			// THIS WORKS:
			// MoveShapeContext moveShapeContext = new MoveShapeContext((Shape)
			// pictogramElement);
			// moveShapeContext.setLocation(rectangle.x, rectangle.y);
			// moveShapeContext.setSourceContainer(((Shape)pictogramElement).getContainer());
			// moveShapeContext.setTargetContainer(((Shape)pictogramElement).getContainer());
			//            
			// IMoveShapeFeature moveShapeFeature =
			// configurationProvider.getFeatureProvider().getMoveShapeFeature(moveShapeContext);
			//            
			// if (moveShapeFeature.canExecute(moveShapeContext))
			// moveShapeFeature.execute(moveShapeContext);
			//            
		}

		// add commands to adjust edges (resp. the corresponding model
		// references)
		// XXX: autolayout Edges

		Edge[] allEdges = graph.getEdgeArray();
		for (int i = 0; i < allEdges.length; i++) {
			Edge edge = allEdges[i];
			Connection connection = (Connection) edgeToModelReference.get(edge);
			// Object sourceNode = graph.getSource(edge);
			// Object sourceModelObject = nodeToShape.get(sourceNode);

			// The Edge has the graphical direction, which might be
			// different to the technical direction of the model-reference
			boolean pointsHaveCorrectOrder = true;// sourceModelObject.equals(modelReferenceSource);

			YPoint yBendPoints[] = graph.getPoints(edge).toArray();

			yBendPoints = createReorderedArray(yBendPoints, pointsHaveCorrectOrder);

			if (connection instanceof FreeFormConnection) {
				FreeFormConnection freeFormConnection = ((FreeFormConnection) connection);
				// List<com.sap.mi.gfw.mm.datatypes.Point> gfwPoints = new
				// ArrayList<com.sap.mi.gfw.mm.datatypes.Point>();
				freeFormConnection.getBendpoints().removeAll(freeFormConnection.getBendpoints());
				// Point draw2DBendPoints[] = new Point[yBendPoints.length];
				// XXX: create createBendpointFeature
				for (int j = 0; j < yBendPoints.length; j++) {
					freeFormConnection.getBendpoints().add(
							GaUtil.createPoint(freeFormConnection, (int) (yBendPoints[j].x + vectorToOrigin.getX()),
									(int) (yBendPoints[j].y + vectorToOrigin.getY())));
				}
			}

			// draw2DBendPoints[j] = new Point(yBendPoints[j].getX(),
			// yBendPoints[j].getY());

			// // add (visual) step command to set the points
			// if (compoundStepCommand != null) {
			// Point oldPoints[] = (Point[])
			// modelReferenceToOldPoints.get(modelReference);
			// if (oldPoints != null) {
			// YPoint yPoints[] = graph.getPath(edge).toArray();
			// yPoints = createReorderedArray(yPoints, pointsHaveCorrectOrder);
			// Point newPoints[] = new Point[yPoints.length];
			// for (int j = 0; j < newPoints.length; j++)
			// newPoints[j] = new Point(yPoints[j].getX(), yPoints[j].getY());
			// // the visual command also needs the start-point
			// // and end-point of the connections
			// IStepCommand stepCommand =
			// commandFactory.getCommandCombiner().createStepCommandForPoints(
			// modelReference,
			// "DefaultPartPreferencesHelper.KEY_FOR_CONNECTION_POINTS",
			// oldPoints, newPoints);
			// if (stepCommand != null)
			// compoundStepCommand.add(stepCommand);
			// }
			// }
			// add 'real' command to set the points
			// Point pointsToSave[] = draw2DBendPoints.length > 0 ?
			// draw2DBendPoints : null; // do not save empty arrays
			// to
			// // increase performance and save memory
			// Command changeConstraintCommand =
			// commandFactory.getCommandCombiner()
			// .createSetPointsForModelElementCommand(modelReference,
			// "DefaultPartPreferencesHelper.KEY_FOR_CONNECTION_POINTS",
			// pointsToSave);
			// command.add(changeConstraintCommand);
		}
	}

	private void setRectangleForShape(Shape shape, Rectangle rectangle) {

		ResizeShapeContext context = new ResizeShapeContext(shape);
		context.setWidth(rectangle.width);
		context.setHeight(rectangle.height);
		IResizeShapeFeature resizeShapeFeature = getFeatureProvider().getResizeShapeFeature(context);
		if (resizeShapeFeature != null && resizeShapeFeature.canExecute(context)) {
			resizeShapeFeature.execute(context);
		}

		MoveShapeContext moveShapeContext = new MoveShapeContext(shape);
		moveShapeContext.setLocation(rectangle.x, rectangle.y);
		moveShapeContext.setSourceContainer(shape.getContainer());
		moveShapeContext.setTargetContainer(shape.getContainer());
		IMoveShapeFeature moveShapeFeature = getFeatureProvider().getMoveShapeFeature(moveShapeContext);
		if (moveShapeFeature != null && moveShapeFeature.canExecute(moveShapeContext)) {
			moveShapeFeature.execute(moveShapeContext);
		}
	}

	private Object setNodeLocations(DefaultLayoutGraph graph, PictogramElement pictogramElement) {

		SimpleDataProvider shapeToNode = (SimpleDataProvider) graph.getDataProvider(PROVIDER_SHAPE_TO_NODE);
		NodeMap nodeToInsets = (NodeMap) graph.getDataProvider(GroupingKeys.GROUP_NODE_INSETS_DPKEY);
		NodeMap nodeToParentShape = (NodeMap) graph.getDataProvider(GroupingKeys.PARENT_NODE_ID_DPKEY);

		// get node for editpart
		Object modelObject = pictogramElement;
		Node node = (Node) shapeToNode.get(modelObject);
		if (node == null) // e.g. if the modelObject is not a Shape
			return null;

		// setting location in absolute coordinates

		GraphicsAlgorithm ga = pictogramElement.getGraphicsAlgorithm();

		Rectangle peBounds = new Rectangle(ga.getX(), ga.getY(), ga.getWidth(), ga.getHeight());

		Object parentModelObject = nodeToParentShape.get(node);
		if (parentModelObject != null) {
			Node parentNode = (Node) shapeToNode.get(parentModelObject);
			YPoint parentLocation = graph.getLocation(parentNode);
			peBounds.x += parentLocation.x;
			peBounds.y += parentLocation.y;

			Insets parentInsets = (Insets) nodeToInsets.get(parentNode);
			if (parentInsets != null) {
				peBounds.x += parentInsets.left;
				peBounds.y += parentInsets.top;
			}
		}
		graph.setLocation(node, peBounds.x, peBounds.y);

		PictogramElement[] children = getLayoutStructureProvider().getChildren(pictogramElement);

		// Only if the children can be arranged in the parents content-pane
		// (e.g. XYLayout) they are treated as own Nodes.
		boolean canChildrenBeArranged = true;// canChildrenBeArranged(graphicalEditPart);
		if (canChildrenBeArranged) {
			// recursively determine children
			if (children != null) {
				for (int i = 0; i < children.length; i++) {
					setNodeLocations(graph, children[i]);
				}
			}

		}

		return null;
	}

	/**
	 * Uses all nodes to find the smallest x and y coordinates. The resulting coordinates can be read as the vector by which all shapes and
	 * bend points have to be moved in order to place them in the positive quadrant and as close as possible to the origin while preserving
	 * the overall layout.
	 * 
	 * @param graph
	 * @return x,y coordinates as a ILocation
	 */
	private ILocation getVectorToOrigin(LayoutGraph graph) {
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;

		for (Node node : graph.getNodeArray()) {
			minX = Math.min(minX, graph.getX(node));
			minY = Math.min(minY, graph.getY(node));
		}
		// invert for convenience
		return new LocationImpl(-((int) Math.floor(minX)), -((int) Math.floor(minY)));
	}

	/**
	 * Returns an inverse array of the given source-array.
	 * 
	 * @param source
	 *            The source-array.
	 * 
	 * @param doNotInverse
	 *            If true, then the source-array will be returned (no inverse).
	 * 
	 * @return An inverse array of the given source-array.
	 */
	private YPoint[] createReorderedArray(YPoint[] source, boolean doNotInverse) {
		if (doNotInverse)
			return source;
		YPoint result[] = new YPoint[source.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = source[result.length - i - 1];
		}
		return result;
	}

	// ================================= inner classes ========================

	/**
	 * A simple implementation of the interface DataProvider, which wraps a Map. It does not have any restrictions for the keys/values.
	 */
	protected class SimpleDataProvider extends DataProviderAdapter {

		private Map _map = new HashMap();

		/*
		 * (non-Javadoc)
		 * 
		 * @see y.util.DataProviderAdapter#get(java.lang.Object)
		 */
		@Override
		public Object get(Object key) {
			return _map.get(key);
		}

		/**
		 * Sets the.
		 * 
		 * @param key
		 *            the key
		 * @param value
		 *            the value
		 */
		public void set(Object key, Object value) {
			_map.put(key, value);
		}
	}
}