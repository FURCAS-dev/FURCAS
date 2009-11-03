package com.sap.mi.gfw.util;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.datatypes.impl.LocationImpl;
import com.sap.mi.gfw.ei.IExecutionInfo;
import com.sap.mi.gfw.features.IFeatureAndContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.internal.util.LookManager;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.BoxRelativeAnchor;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.FixPointAnchor;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.ManhattanConnection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.mm.pictograms.PropertyContainer;
import com.sap.mi.gfw.mm.pictograms.Rectangle;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromFixedSet;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.mql.WhereEntry;
import com.sap.tc.moin.repository.mql.WhereNestedFeature;
import com.sap.tc.moin.repository.mql.WhereRelationFeature;

/**
 * The Class PeUtil.
 */
public class PeUtil {

	private static final ArrayList<Property> EMPTY_PROPERTIES_LIST = new ArrayList<Property>(0);

	/**
	 * Creates a box relative anchor inside the given anchor container.
	 * 
	 * @param anchorContainer
	 *            the anchors parent
	 * @return the new anchor
	 */
	public static BoxRelativeAnchor createBoxRelativeAnchor(AnchorContainer anchorContainer) {

		BoxRelativeAnchor ret = getPartition(anchorContainer).createElement(BoxRelativeAnchor.CLASS_DESCRIPTOR);
		ret.setVisible(true);
		ret.setActive(true);
		ret.setRelativeHeight(0);
		ret.setRelativeWidth(0);
		ret.setParent(anchorContainer);
		return ret;
	}

	/**
	 * Creates a chop box anchor inside the given anchor container.
	 * 
	 * @param anchorContainer
	 *            the anchors parent
	 * @return the new anchor
	 */
	public static ChopboxAnchor createChopboxAnchor(AnchorContainer anchorContainer) {

		ChopboxAnchor ret = getPartition(anchorContainer).createElement(ChopboxAnchor.CLASS_DESCRIPTOR);
		ret.setVisible(false);
		ret.setActive(false);
		ret.setParent(anchorContainer);
		return ret;
	}

	/**
	 * Creates the connection decorator.
	 * 
	 * @param connection
	 *            the connection
	 * @param active
	 *            the active
	 * @param location
	 *            the location
	 * @param isRelative
	 *            true if the decorator should be positioned relative to the connection's midpoint
	 * @return the created ConnectionDecorator Create a ConnectionDecorator and add it to the given connection
	 */
	public static ConnectionDecorator createConnectionDecorator(Connection connection, boolean active, double location, boolean isRelative) {
		ConnectionDecorator ret = getPartition(connection).createElement(ConnectionDecorator.CLASS_DESCRIPTOR);
		ret.setActive(active);
		ret.setLocation(location);
		ret.setLocationRelative(isRelative);
		ret.setConnection(connection);
		ret.setVisible(true);
		return ret;
	}

	/**
	 * Creates a container shape inside the given parent container shape.
	 * 
	 * @param active
	 *            true if container shape should be active (means selectable in editor)
	 * @param connection
	 *            the connection
	 * @return the new container shape
	 * @deprecated use createContainerShape(ContainerShape parentContainerShape, boolean active) instead
	 */
	@Deprecated
	public static ContainerShape createContainerShape(com.sap.tc.moin.repository.Connection connection, boolean active) {
		ContainerShape ret = connection.createElementInPartition(ContainerShape.class, null);
		ret.setVisible(true);
		ret.setActive(active);
		return ret;
	}

	/**
	 * Creates a container shape inside the given parent container shape.
	 * 
	 * @param parentContainerShape
	 *            the parent container shape
	 * @param active
	 *            true if container shape should be active (means selectable in editor)
	 * @return the new container shape
	 */
	public static ContainerShape createContainerShape(ContainerShape parentContainerShape, boolean active) {
		ContainerShape ret = parentContainerShape.get___Partition().createElement(ContainerShape.class);
		ret.getProperties().addAll(EMPTY_PROPERTIES_LIST);
		ret.setVisible(true);
		ret.setActive(active);
		ret.setContainer(parentContainerShape);
		return ret;
	}

	/**
	 * Creates the diagram.
	 * 
	 * @param connection
	 *            the connection
	 * @param diagramTypeId
	 *            the diagram type id
	 * @param diagramName
	 *            the diagram name
	 * @param snap
	 *            the snap
	 * @return the diagram
	 * @see createDiagram(com.sap.tc.moin.repository.Connection connection, String diagramTypeId, String diagramName, int gridUnit, boolean
	 *      snap)
	 */
	public static Diagram createDiagram(com.sap.tc.moin.repository.Connection connection, String diagramTypeId, String diagramName,
			boolean snap) {
		return createDiagram(connection, diagramTypeId, diagramName, LookManager.getLook().getMinorGridLineDistance(), snap);
	}

	/**
	 * Create a diagram.
	 * 
	 * @param connection
	 *            a valid moin connection
	 * @param diagramTypeId
	 *            id of the diagram type
	 * @param diagramName
	 *            name of the diagram
	 * @param gridUnit
	 *            grid size in pixel; if 0 then no grid will be drawn
	 * @param snap
	 *            true enables snap to grid
	 * @return the new diagram
	 *         <p>
	 *         The following values are set by default:
	 *         <p>
	 *         diagram.setShowGuides(true); <br>
	 */
	public static Diagram createDiagram(com.sap.tc.moin.repository.Connection connection, String diagramTypeId, String diagramName,
			int gridUnit, boolean snap) {

		if (connection == null || diagramTypeId == null || diagramName == null) {
			return null;
		}

		final ILook look = LookManager.getLook();

		Diagram ret = (Diagram) PackageUtil.getPictogramsPackage(connection).getDiagram().refCreateInstance();
		ret.setDiagramTypeId(diagramTypeId);
		ret.setGridUnit(gridUnit);
		ret.setSnapToGrid(snap);
		ret.setVisible(true);
		ret.setShowGuides(true);

		Rectangle rectangle = GaUtil.createRectangle(ret);
		rectangle.setForeground(GaUtil.manageColor(ret, look.getMinorGridLineColor())); // 206,
		// 224,
		// 242
		rectangle.setBackground(GaUtil.manageColor(ret, look.getGridBackgroundColor()));
		GaUtil.setSizeOfGraphicsAlgorithm(rectangle, 1000, 1000);

		ret.setName(diagramName);
		return ret;
	}

	/**
	 * Creates a fix point anchor inside the given anchor container.
	 * 
	 * @param anchorContainer
	 *            the anchors parent
	 * @return the new anchor
	 */
	public static FixPointAnchor createFixPointAnchor(AnchorContainer anchorContainer) {
		FixPointAnchor ret = getPartition(anchorContainer).createElement(FixPointAnchor.CLASS_DESCRIPTOR);
		ret.setVisible(true);
		ret.setActive(true);
		ret.setParent(anchorContainer);
		return ret;
	}

	/**
	 * Creates a free form connection inside the given diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * @return the new connection
	 */
	public static FreeFormConnection createFreeFormConnection(Diagram diagram) {
		FreeFormConnection ret = getPartition(diagram).createElement(FreeFormConnection.CLASS_DESCRIPTOR);
		ret.setVisible(true);
		ret.setActive(true);
		ret.setParent(diagram);
		return ret;
	}

	/**
	 * Creates a manhattan connection inside the given diagram.
	 * 
	 * @param diagram
	 *            the parent of the connection
	 * @return the new connection
	 * 
	 * @deprecated The ManhattanConnection is deprecated. Use the FreeFormConnection instead.
	 */
	@Deprecated
	public static ManhattanConnection createManhattanConnection(Diagram diagram) {
		ManhattanConnection ret = diagram.get___Partition().createElement(ManhattanConnection.class);
		ret.setActive(true);
		ret.setVisible(true);
		ret.setParent(diagram);
		return ret;
	}

	/**
	 * Creates a container shape inside the given parent container shape.
	 * 
	 * @param parentContainerShape
	 *            the shape's parent
	 * @param active
	 *            true if shape should be active (means selectable in editor)
	 * @return the new shape
	 */
	public static Shape createShape(ContainerShape parentContainerShape, boolean active) {
		Shape ret = parentContainerShape.get___Partition().createElement(Shape.class);
		ret.getProperties().addAll(EMPTY_PROPERTIES_LIST);
		ret.setVisible(true);
		ret.setActive(active);

		ret.setContainer(parentContainerShape);
		return ret;
	}

	/**
	 * Deletes the given pictogram element (and with it all aggregated elements!).
	 * 
	 * @param pe
	 *            the pictogram element to delete
	 */
	public static void deletePictogramElement(PictogramElement pe) {
		if (pe instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pe;
			List<Shape> childList = cs.getChildren();
			List l = new ArrayList();
			for (Shape shape : childList) {
				l.add(shape);
			}
			for (Iterator iter = l.iterator(); iter.hasNext();) {
				Shape shape = (Shape) iter.next();
				deletePictogramElement(shape);
			}
		}
		if (pe instanceof AnchorContainer) {
			AnchorContainer ac = (AnchorContainer) pe;
			Collection<Anchor> anchorList = ac.getAnchors();
			List l = new ArrayList();
			for (Anchor anchor : anchorList) {
				l.add(anchor);
			}
			for (Iterator iter = l.iterator(); iter.hasNext();) {
				Anchor anchor = (Anchor) iter.next();
				deletePictogramElement(anchor);
			}
		}
		GraphicsAlgorithm graphicsAlgorithm = pe.getGraphicsAlgorithm();
		if (graphicsAlgorithm != null) {
			graphicsAlgorithm.refDelete();
		}
		PictogramLink linkForPictogramElement = LinkUtil.getLinkForPictogramElement(pe);
		if (linkForPictogramElement != null) {
			linkForPictogramElement.refDelete();
		}
		pe.refDelete();
	}

	/**
	 * Gets the active container pe.
	 * 
	 * @param ga
	 *            the ga
	 * @return the active container pe
	 */
	public static PictogramElement getActiveContainerPe(GraphicsAlgorithm ga) {
		if (ga == null) {
			throw new IllegalArgumentException("Parameter must not be null"); //$NON-NLS-1$

		}
		while (ga.getPictogramElement() == null) {
			ga = ga.getParentGraphicsAlgorithm();
			if (ga == null) {
				return null;
			}
		}

		PictogramElement pe = ga.getPictogramElement();

		while ((pe != null) && !pe.isActive()) {
			pe = PeUtil.getPictogramElementParent(pe);
		}
		return pe;
	}

	/**
	 * Gets the active container pe.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return the active container pe
	 */
	public static PictogramElement getActiveContainerPe(PictogramElement pictogramElement) {
		PictogramElement pe = PeUtil.getPictogramElementParent(pictogramElement);
		while ((pe != null) && !pe.isActive()) {
			pe = PeUtil.getPictogramElementParent(pe);
		}
		return pe;
	}

	/**
	 * Returns all connections of an anchor.
	 * 
	 * @param anchor
	 *            the anchor
	 * @return list of connections
	 */
	public static List<Connection> getAllConnections(Anchor anchor) {
		List<Connection> connections = new ArrayList<Connection>();
		connections.addAll(anchor.getIncomingConnections());
		connections.addAll(anchor.getOutgoingConnections());
		return connections;
	}

	/**
	 * Returns all connections of an anchor container.
	 * 
	 * @param anchorContainer
	 *            the anchor container
	 * @return list of connections
	 */
	public static List<Connection> getAllConnections(AnchorContainer anchorContainer) {
		List<Connection> connections = new ArrayList<Connection>();
		Collection anchors = anchorContainer.getAnchors();

		for (Iterator iter = anchors.iterator(); iter.hasNext();) {
			Anchor anchor = (Anchor) iter.next();
			connections.addAll(getAllConnections(anchor));
		}
		return connections;
	}

	/**
	 * Gets the all contained pictogram elements.
	 * 
	 * @param pe
	 *            the pe
	 * @return the all contained pictogram elements
	 */
	public static Collection<PictogramElement> getAllContainedPictogramElements(PictogramElement pe) {
		List<PictogramElement> ret = new ArrayList<PictogramElement>();
		Collection<PictogramElement> peChildren = getPictogramElementChildren(pe);
		ret.addAll(peChildren);
		for (PictogramElement peChild : peChildren) {
			ret.addAll(getAllContainedPictogramElements(peChild));
		}
		return ret;
	}

	/**
	 * Returns all the contained container shapes. Dives through the whole shapes tree.
	 * 
	 * @param cs
	 *            the container shape
	 * @return all the contained container shapes
	 */
	public static Collection<Shape> getAllContainedShapes(ContainerShape cs) {
		ArrayList<Shape> ret = new ArrayList<Shape>();
		Collection children = cs.getChildren();
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			Shape childShape = (Shape) iter.next();
			ret.add(childShape);
			if (childShape instanceof ContainerShape) {
				ContainerShape childCs = (ContainerShape) childShape;
				ret.addAll(getAllContainedShapes(childCs));
			}
		}
		return ret;
	}

	/**
	 * Gets the chopbox anchor.
	 * 
	 * @param anchorContainer
	 *            the anchor container
	 * @return The chopbox anchor of the anchor container if one exist, otherwise null
	 */
	public static Anchor getChopboxAnchor(AnchorContainer anchorContainer) {
		Collection existingAnchors = anchorContainer.getAnchors();
		for (Iterator iter = existingAnchors.iterator(); iter.hasNext();) {
			Anchor anchor = (Anchor) iter.next();
			if (anchor instanceof ChopboxAnchor) {
				return anchor;
			}
		}
		return null;
	}

	private static java.awt.Point getChopboxLocationOnBox(java.awt.Point outsidePoint, java.awt.Rectangle box) {
		java.awt.Rectangle r = new java.awt.Rectangle(box.x - 1, box.y - 1, box.width + 1, box.height + 1);

		float centerX = r.x + 0.5f * r.width;
		float centerY = r.y + 0.5f * r.height;

		if (r.isEmpty() || (outsidePoint.x == (int) centerX && outsidePoint.y == (int) centerY))
			return new java.awt.Point((int) centerX, (int) centerY); // This
		// avoids
		// divide-by-zero

		float dx = outsidePoint.x - centerX;
		float dy = outsidePoint.y - centerY;

		// r.width, r.height, dx, and dy are guaranteed to be non-zero.
		float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);

		dx *= scale;
		dy *= scale;
		centerX += dx;
		centerY += dy;

		return new java.awt.Point(Math.round(centerX), Math.round(centerY));
	}

	/**
	 * Gets the connection midpoint.
	 * 
	 * @param c
	 *            the c
	 * @param d
	 *            the d
	 * @return the connection midpoint
	 */
	public static java.awt.Point getConnectionMidpoint(Connection c, double d) {
		java.awt.Point ret = null;

		Anchor startAnchor = c.getStart();
		ILocation startLocation = getLocationRelativeToDiagram(startAnchor);
		java.awt.Point startPoint = new java.awt.Point(startLocation.getX(), startLocation.getY());

		Anchor endAnchor = c.getEnd();
		ILocation endLocation = getLocationRelativeToDiagram(endAnchor);
		java.awt.Point endPoint = new java.awt.Point(endLocation.getX(), endLocation.getY());

		// special solutions for chopbox anchors
		if (startAnchor instanceof ChopboxAnchor || endAnchor instanceof ChopboxAnchor) {
			if (startAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbStartAnchor = (ChopboxAnchor) startAnchor;
				GraphicsAlgorithm parentGa = cbStartAnchor.getParent().getGraphicsAlgorithm();
				Shape shape = (Shape) cbStartAnchor.getParent();
				ILocation location = getLocationRelativeToDiagram(shape);
				java.awt.Rectangle parentRect = new java.awt.Rectangle(location.getX(), location.getY(), parentGa.getWidth(), parentGa
						.getHeight());

				java.awt.Point pointNextToStartAnchor = new java.awt.Point(startPoint.x, startPoint.y);

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List<Point> bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						Point firstBendpoint = bendpoints.get(0);
						pointNextToStartAnchor.setLocation(firstBendpoint.getX(), firstBendpoint.getY());
					}
				}

				java.awt.Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToStartAnchor, parentRect);

				startPoint.setLocation(chopboxLocationOnBox);
			}

			if (endAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbEndAnchor = (ChopboxAnchor) endAnchor;
				GraphicsAlgorithm parentGa = cbEndAnchor.getParent().getGraphicsAlgorithm();
				Shape shape = (Shape) cbEndAnchor.getParent();
				ILocation location = PeUtil.getLocationRelativeToDiagram(shape);
				java.awt.Rectangle parentRect = new java.awt.Rectangle(location.getX(), location.getY(), parentGa.getWidth(), parentGa
						.getHeight());

				java.awt.Point pointNextToEndAnchor = new java.awt.Point(endPoint.x, endPoint.y);

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List<Point> bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						Point lastBendpoint = bendpoints.get(bendpoints.size() - 1);
						pointNextToEndAnchor.setLocation(lastBendpoint.getX(), lastBendpoint.getY());
					}
				}

				java.awt.Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToEndAnchor, parentRect);

				endPoint.setLocation(chopboxLocationOnBox);
			}
		}

		if (c instanceof FreeFormConnection) {
			FreeFormConnection ffc = (FreeFormConnection) c;
			List<Point> bendpoints = ffc.getBendpoints();

			java.awt.Point[] awtPointsArray = new java.awt.Point[bendpoints.size() + 2];
			{
				awtPointsArray[0] = startPoint;
				int i = 1;
				for (Iterator<Point> iter = bendpoints.iterator(); iter.hasNext();) {
					Point pictogramsPoint = iter.next();
					awtPointsArray[i] = new java.awt.Point(pictogramsPoint.getX(), pictogramsPoint.getY());
					i++;
				}
				awtPointsArray[i] = endPoint;
			}

			double completeDistance = getDistance(awtPointsArray);
			double absDistanceToRelPoint = completeDistance * d;

			double distanceSum = 0;
			for (int i = 0; i < awtPointsArray.length - 1; i++) {
				double oldDistanceSum = distanceSum;
				java.awt.Point currentPoint = awtPointsArray[i];
				java.awt.Point nextPoint = awtPointsArray[i + 1];
				double additionalDistanceToNext = getDistance(currentPoint, nextPoint);
				distanceSum += additionalDistanceToNext;
				if (distanceSum >= absDistanceToRelPoint) {
					double thisRelative = ((completeDistance * d) - oldDistanceSum) / additionalDistanceToNext;
					ret = getMidpoint(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y, thisRelative);
					break; // or return ret;
				}
			}
		} else {
			int midX = (int) Math.round((startPoint.x + d * (endPoint.x - startPoint.x)));
			int midY = (int) Math.round((startPoint.y + d * (endPoint.y - startPoint.y)));
			ret = new java.awt.Point(midX, midY);
		}
		return ret;
	}

	/**
	 * Returns the diagram for the given anchor.
	 * 
	 * @param anchor
	 *            the anchor
	 * @return the diagram
	 */
	public static Diagram getDiagramForAnchor(Anchor anchor) {
		Diagram ret = null;
		AnchorContainer ac = anchor.getParent();
		if (ac instanceof Connection) {
			Connection connection = (Connection) ac;
			ret = connection.getParent();
		} else if (ac instanceof Shape) {
			Shape shape = (Shape) ac;
			ret = getDiagramForShape(shape);
		}
		return ret;
	}

	/**
	 * Returns the diagram for the given pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 * @return the diagram
	 */
	public static Diagram getDiagramForPictogramElement(PictogramElement pe) {
		Diagram ret = null;
		if (pe instanceof Diagram) {
			ret = (Diagram) pe;
		} else if (pe instanceof ConnectionDecorator) {
			ret = getDiagramForPictogramElement(((ConnectionDecorator) pe).getConnection());
		} else if (pe instanceof Shape) {
			ret = getDiagramForShape(((Shape) pe).getContainer());
		} else if (pe instanceof Anchor) {
			ret = getDiagramForAnchor(((Anchor) pe));
		} else if (pe instanceof Connection) {
			ret = ((Connection) pe).getParent();
		}
		return ret;
	}

	/**
	 * Returns the diagram for the given shape.
	 * 
	 * @param shape
	 *            the shape
	 * @return the diagram
	 */
	public static Diagram getDiagramForShape(Shape shape) {
		Diagram ret = null;
		if (shape instanceof Diagram) {
			ret = (Diagram) shape;
		} else if (shape instanceof ConnectionDecorator) {
			ret = getDiagramForPictogramElement(((ConnectionDecorator) shape).getConnection());
		} else {
			ret = getDiagramForShape(shape.getContainer());
		}
		return ret;
	}

	private static double getDistance(java.awt.Point start, java.awt.Point end) {
		int xDist = end.x - start.x;
		int yDist = end.y - start.y;
		double ret = Math.sqrt((xDist * xDist) + (yDist * yDist));
		return ret;
	}

	private static double getDistance(java.awt.Point[] points) {
		double ret = 0;
		for (int i = 0; i < points.length - 1; i++) {
			java.awt.Point currentPoint = points[i];
			java.awt.Point nextPoint = points[i + 1];
			ret += getDistance(currentPoint, nextPoint);
		}
		return ret;
	}

	/**
	 * From the given elements, returns all elements that are not linked by a PictogramLink in the given Diagram.
	 * 
	 * @param elements
	 *            the elements
	 * @param diag
	 *            the diag
	 * @return the elements not in diagram
	 */
	public static RefObject[] getElementsNotInDiagram(RefObject[] elements, Diagram diag) {
		final String SIGNATURE = "getElementsNotInDiagram( RefObject[], diag)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(PeUtil.class, SIGNATURE, new Object[] { elements, diag });
		}

		if (elements.length == 0) {
			return new RefObject[0];
		}

		PRI diagramPri = ((Partitionable) diag).get___Partition().getPri();
		MQLProcessor processor = ((Partitionable) diag).get___Connection().getMQLProcessor();
		QueryScopeProvider diagramScope = processor.getInclusivePartitionScopeProvider(diagramPri);

		MRI[] elementMris = new MRI[elements.length];
		for (int i = 0; i < elements.length; i++) {
			elementMris[i] = ((Partitionable) elements[i]).get___Mri();
		}

		SelectEntry[] selectEl = new SelectEntry[] { new SelectAlias("el") }; //$NON-NLS-1$
		FromFixedSet el = new FromFixedSet("el", new String[] { "Reflect", "Element" }, null, elementMris); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		SelectEntry[] selectPl = new SelectEntry[] { new SelectAlias("pl") }; //$NON-NLS-1$
		FromType pl = new FromType(
				"pl", new String[] { PackageUtil.LINKS_PACKAGE_NAME, "PictogramLink" }, PackageUtil.GRAPHICS_CONTAINER_NAME, false, diagramScope); //$NON-NLS-1$ //$NON-NLS-2$
		MQLQuery nestedQuery = new MQLQuery(selectPl, new FromEntry[] { pl });

		WhereEntry elToNotPictorgramLink = new WhereNestedFeature(true, "el", "pictogramLink", nestedQuery); //$NON-NLS-1$ //$NON-NLS-2$

		MQLQuery queryAst = new MQLQuery(selectEl, new FromEntry[] { el }, new WhereEntry[] { elToNotPictorgramLink });

		MQLResultSet resultSetFromAst = processor.execute(queryAst);

		return resultSetFromAst.getRefObjects("el"); //$NON-NLS-1$

	}

	/**
	 * Returns the bounds of the GA, which is referenced by the anchor.
	 */
	public static java.awt.Rectangle getGaBoundsForAnchor(Anchor anchor) {
		java.awt.Rectangle ret = new java.awt.Rectangle();

		GraphicsAlgorithm parentGa = anchor.getParent().getGraphicsAlgorithm();
		if (parentGa != null) {
			if (anchor.getReferencedGraphicsAlgorithm() != null) {
				GraphicsAlgorithm referencedGa = anchor.getReferencedGraphicsAlgorithm();
				int relX = GaUtilInternal.getRelativeX(referencedGa, parentGa);
				int relY = GaUtilInternal.getRelativeY(referencedGa, parentGa);
				ret = new java.awt.Rectangle(relX, relY, referencedGa.getWidth(), referencedGa.getHeight());
			} else {
				ret = new java.awt.Rectangle(0, 0, parentGa.getWidth(), parentGa.getHeight());
			}
		}

		return ret;
	}

	private static GraphicsAlgorithm getGraphicsAlgorithmForLocation(GraphicsAlgorithm graphicsAlgorithm, int x, int y) {
		if (graphicsAlgorithm == null) {
			return null;
		}

		List children = graphicsAlgorithm.getGraphicsAlgorithmChildren();
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			GraphicsAlgorithm childGa = (GraphicsAlgorithm) iter.next();
			int newX = x - childGa.getX();
			int newY = y - childGa.getY();
			GraphicsAlgorithm ga = getGraphicsAlgorithmForLocation(childGa, newX, newY);
			if (ga != null) {
				return ga;
			}
		}

		IDimension size = GaUtil.calculateSizeOfGraphicsAlgorithm(graphicsAlgorithm);
		if (x >= 0 && x < size.getWidth() && y >= 0 && y < size.getHeight()) {
			return graphicsAlgorithm;
		}

		return null;
	}

	/**
	 * Returns the size of the pictogram element (more exactly: size of its graphics algorithm)
	 * 
	 * @param pe
	 *            given pictogram element
	 * @return the size
	 */
	private static int getWidthOfPictogramElement(PictogramElement pe) {
		int ret = 0;
		GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		if (ga != null) {
			ret = ga.getWidth();
		}
		return ret;
	}

	/**
	 * Returns the size of the pictogram element (more exactly: size of its graphics algorithm)
	 * 
	 * @param pe
	 *            given pictogram element
	 * @return the size
	 */
	private static int getHeightOfPictogramElement(PictogramElement pe) {
		int ret = 0;
		GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		if (ga != null) {
			ret = ga.getHeight();
		}
		return ret;
	}

	/**
	 * Returns the incoming connections of an anchor container.
	 * 
	 * @param anchorContainer
	 *            the anchor container
	 * @return list of incoming connections
	 */
	public static List<Connection> getIncomingConnections(AnchorContainer anchorContainer) {
		List<Connection> connections = new ArrayList<Connection>();
		Collection anchors = anchorContainer.getAnchors();

		for (Iterator iter = anchors.iterator(); iter.hasNext();) {
			Anchor anchor = (Anchor) iter.next();
			connections.addAll(anchor.getIncomingConnections());
		}
		return connections;
	}

	/**
	 * Returns the outgoing connections of an anchor container.
	 * 
	 * @param anchorContainer
	 *            the anchor container
	 * @return list of outgoing connections
	 */
	public static List<Connection> getOutgoingConnections(AnchorContainer anchorContainer) {
		List<Connection> connections = new ArrayList<Connection>();
		Collection anchors = anchorContainer.getAnchors();

		for (Iterator iter = anchors.iterator(); iter.hasNext();) {
			Anchor anchor = (Anchor) iter.next();
			connections.addAll(anchor.getOutgoingConnections());
		}
		return connections;
	}

	/**
	 * From the given elements, returns all elements that are not linked by a PictogramLink in the given Diagram.
	 * 
	 * @param elements
	 *            the elements
	 * @param diag
	 *            the diag
	 * @return the linked pictogram elements
	 */
	public static RefObject[] getLinkedPictogramElements(RefObject[] elements, Diagram diag) {
		final String SIGNATURE = "getLinkedPictogramElements(RefObject[], diag)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(PeUtil.class, SIGNATURE, new Object[] { elements, diag });
		}

		/*
		 * select pe from GFW_CONTAINER_NAME#pictograms::PictogramElement as pe in partitions {diagramPri},
		 * GFW_CONTAINER_NAME#links::PictogramLink as pl in partitions {diagramPr}, Reflect::Element as el in elements {
		 * elementMrisAsStrings } where el.pictogramLink = pl where pl.pictogramElement = pe
		 */
		if (elements.length == 0) {
			RefObject[] res = new PictogramElement[0];
			if (info) {
				T.racer().exiting(PeUtil.class, SIGNATURE, res);
			}
			return res;
		}

		PRI diagramPri = ((Partitionable) diag).get___Partition().getPri();

		MQLProcessor processor = ((Partitionable) diag).get___Connection().getMQLProcessor();

		QueryScopeProvider diagramScope = processor.getInclusivePartitionScopeProvider(diagramPri);

		MRI[] elementMris = new MRI[elements.length];
		for (int i = 0; i < elements.length; i++) {
			elementMris[i] = ((Partitionable) elements[i]).get___Mri();
		}

		SelectEntry[] selectEntries = new SelectEntry[] { new SelectAlias("pe") }; //$NON-NLS-1$
		FromType pe = new FromType(
				"pe", new String[] { PackageUtil.PICTOGRAMS_PACKAGE_NAME, "PictogramElement" }, PackageUtil.GRAPHICS_CONTAINER_NAME, false, diagramScope); //$NON-NLS-1$ //$NON-NLS-2$
		FromType pl = new FromType(
				"pl", new String[] { PackageUtil.LINKS_PACKAGE_NAME, "PictogramLink" }, PackageUtil.GRAPHICS_CONTAINER_NAME, false, diagramScope); //$NON-NLS-1$ //$NON-NLS-2$
		FromFixedSet el = new FromFixedSet("el", new String[] { "Reflect", "Element" }, null, elementMris); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		FromEntry[] fromEntries = new FromEntry[] { pe, pl, el };
		WhereRelationFeature pictogramLinkPred = new WhereRelationFeature("el", "pictogramLink", "pl"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereRelationFeature pictogramElementPred = new WhereRelationFeature("pl", "pictogramElement", "pe"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { pictogramLinkPred, pictogramElementPred };

		MQLQuery queryAst = new MQLQuery(selectEntries, fromEntries, whereEntries);

		MQLResultSet resultSetFromAst = processor.execute(queryAst);

		RefObject[] res = resultSetFromAst.getRefObjects("pe"); //$NON-NLS-1$
		if (info) {
			T.racer().exiting(PeUtil.class, SIGNATURE, res);
		}
		return res;
	}

	/**
	 * Returns the location info for a specific position inside a shape. The location info contains the shape and the graphics algorithm at
	 * the given position.
	 * 
	 * @param shape
	 *            the shape
	 * @param x
	 *            x coorsinate
	 * @param y
	 *            y coordinate
	 * @return the location info
	 * @see ILocationInfo
	 */
	public static ILocationInfo getLocationInfo(Shape shape, int x, int y) {
		if (shape instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) shape;
			List children = containerShape.getChildren();
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				Shape childShape = (Shape) iter.next();
				GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
				if (childGa != null) {
					int newX = x - childGa.getX();
					int newY = y - childGa.getY();
					ILocationInfo locationInfo = getLocationInfo(childShape, newX, newY);
					if (locationInfo != null) {
						return locationInfo;
					}
				}
			}
		}

		GraphicsAlgorithm ga = getGraphicsAlgorithmForLocation(shape.getGraphicsAlgorithm(), x, y);
		if (ga != null) {
			return new LocationInfo(shape, ga);
		}

		return null;
	}

	/**
	 * Returns the location of the anchor relative to the diagram.
	 * 
	 * @param anchor
	 *            the given anchor
	 * @return the relative location
	 */
	public static ILocation getLocationRelativeToDiagram(Anchor anchor) {
		int x = getRelativeToDiagramX(anchor);
		int y = getRelativeToDiagramY(anchor);
		ILocation ret = new LocationImpl(x, y);
		return ret;
	}

	/**
	 * Returns the location of the shape relative to the diagram.
	 * 
	 * @param shape
	 *            the given shape
	 * @return the relative location
	 */
	public static ILocation getLocationRelativeToDiagram(Shape shape) {
		int x = getRelativeToDiagramX(shape);
		int y = getRelativeToDiagramY(shape);
		ILocation ret = new LocationImpl(x, y);
		return ret;
	}

	private static java.awt.Point getMidpoint(int startX, int startY, int endX, int endY, double d) {
		int midX = (int) Math.round((startX + d * (endX - startX)));
		int midY = (int) Math.round((startY + d * (endY - startY)));
		return new java.awt.Point(midX, midY);
	}

	private static ModelPartition getPartition(RefObject object) {
		ModelPartition partition = null;
		if (object != null) {
			partition = object.get___Partition();
		}
		return partition;
	}

	/**
	 * Returns a pictogram element's children. <br>
	 * Some Examples: returns all connections of a diagram, all shapes of a container shape, all decorators of a connection, all anchors of
	 * an anchor container
	 * 
	 * @param pe
	 *            the given pictogram element
	 * @return all the pictogram element's children
	 */
	public static Collection<PictogramElement> getPictogramElementChildren(PictogramElement pe) {
		List<PictogramElement> retList = new ArrayList();

		if (pe instanceof Diagram) {
			Diagram diagram = (Diagram) pe;
			retList.addAll(diagram.getConnections());
		}
		if (pe instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pe;
			retList.addAll(containerShape.getChildren());
		}
		if (pe instanceof Connection) {
			Connection connection = (Connection) pe;
			retList.addAll(connection.getConnectionDecorators());
		}
		if (pe instanceof AnchorContainer) {
			AnchorContainer anchorContainer = (AnchorContainer) pe;
			retList.addAll(anchorContainer.getAnchors());
		}

		return retList;
	}

	/**
	 * Gets the pictogram element parent.
	 * 
	 * @param pe
	 *            the pe
	 * @return the pictogram element parent
	 */
	public static PictogramElement getPictogramElementParent(PictogramElement pe) {
		if (pe instanceof ConnectionDecorator) {
			return ((ConnectionDecorator) pe).getConnection();
		} else if (pe instanceof Shape) {
			return ((Shape) pe).getContainer();
		} else if (pe instanceof Connection) {
			return ((Connection) pe).getParent();
		} else if (pe instanceof Anchor) {
			return ((Anchor) pe).getParent();
		} else {
			return null;
		}
	}

	/**
	 * Removes the property of a given property container for a specific key.
	 * 
	 * @param propertyContainer
	 *            The property container (e.g. PictogramElement or GraphicsAlgorithm)
	 * @param key
	 *            The property key
	 * @return True, if the property existed
	 */
	public static boolean removeProperty(PropertyContainer propertyContainer, String key) {
		Property property = getProperty(propertyContainer, key);
		if (property != null) {
			propertyContainer.getProperties().remove(property);
			return true;
		}
		return false;
	}

	/**
	 * Sets/modifies the property's value of a given property container for a specific key. <br>
	 * The property object will be created if it does not exist.
	 * 
	 * @param propertyContainer
	 *            The property container (e.g. PictogramElement or GraphicsAlgorithm)
	 * @param key
	 *            The property key
	 * @param value
	 *            The new property value
	 */
	public static void setPropertyValue(PropertyContainer propertyContainer, String key, String value) {
		if (propertyContainer == null) {
			throw new InvalidParameterException("propertyContainer must not be null"); //$NON-NLS-1$
		}

		Property property = getProperty(propertyContainer, key);
		if (property != null) {
			removeProperty(propertyContainer, key);
		}
		StructureFieldContainer<Property> container = new StructureFieldContainer<Property>();
		container.put(Property.DESCRIPTORS.KEY(), key);
		container.put(Property.DESCRIPTORS.VALUE(), value);
		property = PackageUtil.getPictogramsPackage(propertyContainer).createProperty(container);
		propertyContainer.getProperties().add(property);
	}

	/**
	 * Returns the property of a given property container for a specific key.
	 * 
	 * @param propertyContainer
	 *            The property container (e.g. PictogramElement or GraphicsAlgorithm)
	 * @param key
	 *            The property key
	 * @return The property for the key
	 */
	public static Property getProperty(PropertyContainer propertyContainer, String key) {
		if (propertyContainer == null || key == null || !MoinHelper.isObjectAlive(propertyContainer)) {
			return null;
		}
		Collection<Property> collection = propertyContainer.getProperties();
		for (Iterator<Property> iter = collection.iterator(); iter.hasNext();) {
			Property property = iter.next();
			if (key.equals(property.getKey())) {
				return property;
			}
		}
		return null;
	}

	/**
	 * Returns the property value of a given property container for a specific key.
	 * 
	 * @param propertyContainer
	 *            The property container (e.g. PictogramElement or GraphicsAlgorithm)
	 * @param key
	 *            The property key
	 * @return The value of the property for the key
	 */
	public static String getPropertyValue(PropertyContainer propertyContainer, String key) {
		Property property = getProperty(propertyContainer, key);
		if (property != null) {
			return property.getValue();
		}
		return null;
	}

	/**
	 * Returns the x coordinate of the anchor relative to the diagram
	 * 
	 * @param anchor
	 *            the given anchor
	 * @return the x coordinate
	 */
	private static int getRelativeToDiagramX(Anchor anchor) {
		int ret = 0;
		if (anchor == null) {
			return ret;
		}
		if (anchor instanceof FixPointAnchor) {
			FixPointAnchor fpa = (FixPointAnchor) anchor;
			java.awt.Rectangle gaBoundsForAnchor = getGaBoundsForAnchor(anchor);
			ret = gaBoundsForAnchor.x + fpa.getLocation().getX();
		} else if (anchor instanceof BoxRelativeAnchor) {
			BoxRelativeAnchor bra = (BoxRelativeAnchor) anchor;
			java.awt.Rectangle gaBoundsForAnchor = getGaBoundsForAnchor(anchor);
			ret = gaBoundsForAnchor.x + (int) Math.round(gaBoundsForAnchor.width * bra.getRelativeWidth());
		} else if (anchor instanceof ChopboxAnchor) {
			ret = Math.round(getWidthOfPictogramElement(anchor.getParent()) / 2);
		}

		if (anchor != null) {
			AnchorContainer anchorContainer = anchor.getParent();
			if (anchorContainer instanceof Shape) {
				Shape shape = (Shape) anchorContainer;
				ret = ret + getRelativeToDiagramX(shape);
			}
		}

		return ret;
	}

	/**
	 * Returns the x coordinate of the shape relative to the diagram
	 * 
	 * @param shape
	 *            the given shape
	 * @return the x coordinate
	 */
	private static int getRelativeToDiagramX(Shape shape) {
		int ret = 0;

		if (!(shape instanceof ConnectionDecorator)) {
			while (shape != null && !(shape instanceof Diagram)) {
				ret = ret + getXOfPictogramElement(shape);
				shape = shape.getContainer();
			}
		} else {
			ConnectionDecorator decorator = (ConnectionDecorator) shape;
			java.awt.Point midpoint = getConnectionMidpoint(decorator.getConnection(), decorator.getLocation());
			ret = decorator.getGraphicsAlgorithm().getX() + midpoint.x;
		}
		return ret;
	}

	/**
	 * Returns the y coordinate of the anchor relative to the diagram
	 * 
	 * @param anchor
	 *            the given anchor
	 * @return the y coordinate
	 */
	private static int getRelativeToDiagramY(Anchor anchor) {
		int ret = 0;
		if (anchor == null) {
			return ret;
		}
		if (anchor instanceof FixPointAnchor) {
			FixPointAnchor fpa = (FixPointAnchor) anchor;
			java.awt.Rectangle gaBoundsForAnchor = getGaBoundsForAnchor(anchor);
			ret = gaBoundsForAnchor.y + fpa.getLocation().getY();
		} else if (anchor instanceof BoxRelativeAnchor) {
			BoxRelativeAnchor bra = (BoxRelativeAnchor) anchor;
			java.awt.Rectangle gaBoundsForAnchor = getGaBoundsForAnchor(anchor);
			ret = gaBoundsForAnchor.y + (int) Math.round(gaBoundsForAnchor.height * bra.getRelativeHeight());
		} else if (anchor instanceof ChopboxAnchor) {
			ret = Math.round(getHeightOfPictogramElement(anchor.getParent()) / 2);
		}

		AnchorContainer anchorContainer = anchor.getParent();
		if (anchorContainer instanceof Shape) {
			Shape shape = (Shape) anchorContainer;
			ret = ret + getRelativeToDiagramY(shape);
		}

		return ret;
	}

	/**
	 * Returns the y coordinate of the shape relative to the diagram
	 * 
	 * @param shape
	 *            the given shape
	 * @return the y coordinate
	 */
	private static int getRelativeToDiagramY(Shape shape) {
		int ret = 0;
		if (!(shape instanceof ConnectionDecorator)) {
			while (shape != null && !(shape instanceof Diagram)) {
				ret = ret + getYOfPictogramElement(shape);
				shape = shape.getContainer();
			}
		} else {
			ConnectionDecorator decorator = (ConnectionDecorator) shape;
			java.awt.Point midpoint = getConnectionMidpoint(decorator.getConnection(), decorator.getLocation());
			ret = decorator.getGraphicsAlgorithm().getY() + midpoint.y;
		}
		return ret;
	}

	/**
	 * Returns the location of the given pictogram element - more exactly the location of the pictogram element's graphics algorithm.
	 * 
	 * @param pe
	 *            the given pictogram element
	 * @return the location
	 */
	protected static int getXOfPictogramElement(PictogramElement pe) {
		int ret = 0;
		GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		if (ga != null) {
			ret = ga.getX();
		}
		return ret;
	}

	/**
	 * Returns the location of the given pictogram element - more exactly the location of the pictogram element's graphics algorithm.
	 * 
	 * @param pe
	 *            the given pictogram element
	 * @return the location
	 */
	protected static int getYOfPictogramElement(PictogramElement pe) {
		int ret = 0;
		GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		if (ga != null) {
			ret = ga.getY();
		}
		return ret;
	}

	/**
	 * Move bendpoints.
	 * 
	 * @param executionInfo
	 *            the execution info
	 */
	public static void moveBendpoints(IExecutionInfo executionInfo) {
		Set<FreeFormConnection> connections = new HashSet<FreeFormConnection>();
		Set<AnchorContainer> anchorContainers = new HashSet<AnchorContainer>();
		final IFeatureAndContext[] featureAndContexts = executionInfo.getExecutionList();
		int deltaX = 0;
		int deltaY = 0;

		/* get move vector */
		for (IFeatureAndContext featureAndContext : featureAndContexts) {
			IContext context = featureAndContext.getContext();
			if (context instanceof MoveShapeContext) {
				deltaX = ((MoveShapeContext) context).getDeltaX();
				deltaY = ((MoveShapeContext) context).getDeltaY();
				break;
			}
		}

		/* any move needed? */
		if (deltaX == 0 && deltaY == 0) {
			return;
		}

		/* get all AnchorContainers to be moved */
		for (IFeatureAndContext featureAndContext : featureAndContexts) {
			IContext context = featureAndContext.getContext();
			if (context instanceof MoveShapeContext) {
				PictogramElement pe = ((MoveShapeContext) context).getPictogramElement();
				if (pe instanceof AnchorContainer) {
					anchorContainers.add((AnchorContainer) pe);
				}
			}
		}

		/*
		 * examine the outgoing connection of each AnchorContainer to be moved and check whether it equals an incoming connection on a
		 * different AnchorContainer to be moved
		 */
		for (AnchorContainer anchorContainerToBeMoved : anchorContainers) {
			List<Connection> outgoingConnections = PeUtil.getOutgoingConnections(anchorContainerToBeMoved);

			for (Connection outgoingConnection : outgoingConnections) {
				if (outgoingConnection instanceof FreeFormConnection) {
					/*
					 * check whether the outgoing Connection is an incoming connection on some other AnchorContainer
					 */
					for (AnchorContainer anchorContainer : anchorContainers) {
						if (anchorContainerToBeMoved != anchorContainer) {
							List<Connection> incomingConnections = PeUtil.getIncomingConnections(anchorContainer);
							if (incomingConnections.contains(outgoingConnection)) {
								connections.add((FreeFormConnection) outgoingConnection);
							}
						}
					}
				}
			}

		}

		/* finally move the bend points */
		for (Connection connection : connections) {
			if (connection instanceof FreeFormConnection) {
				final FreeFormConnection freeFormConnection = (FreeFormConnection) connection;
				List<Point> bendPoints = freeFormConnection.getBendpoints();
				for (int i = 0; i < bendPoints.size(); i++) {
					Point oldPoint = bendPoints.get(i);
					Point newPoint = GaUtil.createPoint(freeFormConnection, oldPoint.getX() + deltaX, oldPoint.getY() + deltaY);
					bendPoints.set(i, newPoint);
				}
			}
		}
	}

	/**
	 * Reorders parent's children to make the given shape the frontmost one. This is a convenient service to modify the z order. The z order
	 * of shapes in their containers can also be modified by changing the order of the children in the corresponding container shape
	 * directly. The last element in the list will be painted on top.
	 * 
	 * @param shape
	 *            shape to make the frontmost one
	 */
	public static void sendToFront(Shape shape) {
		ContainerShape parentContainerShape = shape.getContainer();
		List<Shape> brotherAndSisterList = parentContainerShape.getChildren();
		brotherAndSisterList.remove(shape);
		brotherAndSisterList.add(shape);
	}

	/**
	 * Reorders parent's children to make the given shape the backmost one. This is a convenient service to modify the z order. The z order
	 * of shapes in their containers can also be modified by changing the order of the children in the corresponding container shape
	 * directly. The last element in the list will be painted on top.
	 * 
	 * @param shape
	 *            shape to make the backmost one
	 */
	public static void sendToBack(Shape shape) {
		ContainerShape parentContainerShape = shape.getContainer();
		List<Shape> brotherAndSisterList = parentContainerShape.getChildren();
		brotherAndSisterList.remove(shape);
		brotherAndSisterList.add(0, shape);
	}
}
