package com.sap.mi.gfw.eclipse.internal.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoutingListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * A GFW Polyline Connection. The "polyline functionality" is inherited from the super-class, the "connection functionality" is added in
 * this class.
 * <p>
 * Important difference: The super-class denotes a polyline-shape. There the points are translated towards the center depending on the
 * line-width, so that the bounds of the polyline-shape are only dependent on the points of the polyline but not on the current line-width.
 * Otherwise it would be difficult to align its positions/sizes with the neighbor-shapes or parent-shapes. This class on the other hand
 * denotes a polyline-connection. Here the points are not translated towards the center, because the polyline must always go directly
 * through the given points.
 */
public class GfwPolylineConnection extends GfwPolyline implements Connection, AnchorListener {

	/**
	 * Creates a new GfwPolylineConnection.
	 * 
	 * @param pictogramElementDelegate
	 *            The PictogramElementDelegate which provides the GraphicsAlgorithm.
	 * @param graphicsAlgorithm
	 *            The GraphicsAlgorithm which provides the values to paint this Shape.
	 */
	public GfwPolylineConnection(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElementDelegate, graphicsAlgorithm);

		// by default the connections are drawn as rounded bezier-curves
		setGeneralBezierDistance(15);
	}

	/**
	 * Returns a new instance of the input point-list, which is adjusted regarding the given zoom-factor and line-width.
	 * <p>
	 * The implementation only zooms the points regarding the zoom-factor. It does not translate the points towards the center depending on
	 * the line-width. See explanation in the javadoc of this class.
	 * 
	 * @param points
	 *            The point-list which to adjust.
	 * @param zoom
	 *            The zoom-factor to regard.
	 * @param lw
	 *            The line-width to regard.
	 */
	@Override
	protected PointList getAdjustedPointList(PointList points, double zoom, double lw) {
		// only zoom, but do not translate regarding the line-width as the
		// super-class
		PointList ret = new PointList();
		for (int i = 0; i < points.size(); i++) {
			Point point = points.getPoint(i);
			point.scale(zoom);
			ret.addPoint(point);
		}
		return ret;
	}

	/**
	 * Returns the bounds which holds all the points in this polyline connection. Note, that the childrens bounds are also added to the
	 * super-class bounds.
	 * <p>
	 * The implementation adds the half line-width to the bounds of the super-class, because the points are not translated towards the
	 * center (see {@link #getAdjustedPointList(PointList, double, double)}), so that bounds must expand depending on the line-width.
	 * 
	 * @return The bounds which holds all the points in this polyline connection.
	 */
	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			super.getBounds();
			bounds.expand(lineWidth / 2, lineWidth / 2);

			for (int i = 0; i < getChildren().size(); i++) {
				IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
		}
		return bounds;
	}

	// /////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////
	// the following code is copied from PolylineConnection //
	// (changed: added @Override tags) //
	// (changed: made methods getXXXDecoration() public) //
	// /////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////

	private ConnectionAnchor startAnchor, endAnchor;

	private ConnectionRouter connectionRouter = ConnectionRouter.NULL;

	/**
	 * A list of all decorations, which are currently added to this connection.
	 */
	private List<IFigure> decorations = new ArrayList<IFigure>();

	{
		setLayoutManager(new DelegatingLayout());
		addPoint(new Point(0, 0));
		addPoint(new Point(100, 100));
	}

	/**
	 * Hooks the source and target anchors.
	 * 
	 * @see Figure#addNotify()
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		hookSourceAnchor();
		hookTargetAnchor();
	}

	/**
	 * Appends the given routing listener to the list of listeners.
	 * 
	 * @param listener
	 *            the routing listener
	 * @since 3.2
	 */
	public void addRoutingListener(RoutingListener listener) {
		if (connectionRouter instanceof RoutingNotifier) {
			RoutingNotifier notifier = (RoutingNotifier) connectionRouter;
			notifier.listeners.add(listener);
		} else
			connectionRouter = new RoutingNotifier(connectionRouter, listener);
	}

	/**
	 * Called by the anchors of this connection when they have moved, revalidating this polyline connection.
	 * 
	 * @param anchor
	 *            the anchor that moved
	 */
	public void anchorMoved(ConnectionAnchor anchor) {
		revalidate();
	}

	/**
	 * Returns the <code>ConnectionRouter</code> used to layout this connection. Will not return <code>null</code>.
	 * 
	 * @return this connection's router
	 */
	public ConnectionRouter getConnectionRouter() {
		if (connectionRouter instanceof RoutingNotifier)
			return ((RoutingNotifier) connectionRouter).realRouter;
		return connectionRouter;
	}

	/**
	 * Returns this connection's routing constraint from its connection router. May return <code>null</code>.
	 * 
	 * @return the connection's routing constraint
	 */
	public Object getRoutingConstraint() {
		if (getConnectionRouter() != null)
			return getConnectionRouter().getConstraint(this);
		else
			return null;
	}

	/**
	 * @return the anchor at the start of this polyline connection (may be null)
	 */
	public ConnectionAnchor getSourceAnchor() {
		return startAnchor;
	}

	/**
	 * @return the anchor at the end of this polyline connection (may be null)
	 */
	public ConnectionAnchor getTargetAnchor() {
		return endAnchor;
	}

	private void hookSourceAnchor() {
		if (getSourceAnchor() != null)
			getSourceAnchor().addAnchorListener(this);
	}

	private void hookTargetAnchor() {
		if (getTargetAnchor() != null)
			getTargetAnchor().addAnchorListener(this);
	}

	/**
	 * Layouts this polyline. If the start and end anchors are present, the connection router is used to route this, after which it is laid
	 * out. It also fires a moved method.
	 */
	@Override
	public void layout() {
		if (getSourceAnchor() != null && getTargetAnchor() != null)
			connectionRouter.route(this);

		Rectangle oldBounds = bounds;
		super.layout();
		bounds = null;

		if (!getBounds().contains(oldBounds)) {
			getParent().translateToParent(oldBounds);
			getUpdateManager().addDirtyRegion(getParent(), oldBounds);
		}

		repaint();
		fireFigureMoved();
	}

	/**
	 * Called just before the receiver is being removed from its parent. Results in removing itself from the connection router.
	 * 
	 * @since 2.0
	 */
	@Override
	public void removeNotify() {
		unhookSourceAnchor();
		unhookTargetAnchor();
		connectionRouter.remove(this);
		super.removeNotify();
	}

	/**
	 * Removes the first occurence of the given listener.
	 * 
	 * @param listener
	 *            the listener being removed
	 * @since 3.2
	 */
	public void removeRoutingListener(RoutingListener listener) {
		if (connectionRouter instanceof RoutingNotifier) {
			RoutingNotifier notifier = (RoutingNotifier) connectionRouter;
			notifier.listeners.remove(listener);
			if (notifier.listeners.isEmpty())
				connectionRouter = notifier.realRouter;
		}
	}

	/**
	 * @see IFigure#revalidate()
	 */
	@Override
	public void revalidate() {
		super.revalidate();
		connectionRouter.invalidate(this);
	}

	/**
	 * Sets the connection router which handles the layout of this polyline. Generally set by the parent handling the polyline connection.
	 * 
	 * @param cr
	 *            the connection router
	 */
	public void setConnectionRouter(ConnectionRouter cr) {
		if (cr == null)
			cr = ConnectionRouter.NULL;
		ConnectionRouter oldRouter = getConnectionRouter();
		if (oldRouter != cr) {
			connectionRouter.remove(this);
			if (connectionRouter instanceof RoutingNotifier)
				((RoutingNotifier) connectionRouter).realRouter = cr;
			else
				connectionRouter = cr;
			firePropertyChange(Connection.PROPERTY_CONNECTION_ROUTER, oldRouter, cr);
			revalidate();
		}
	}

	/**
	 * Sets the routing constraint for this connection.
	 * 
	 * @param cons
	 *            the constraint
	 */
	public void setRoutingConstraint(Object cons) {
		if (connectionRouter != null)
			connectionRouter.setConstraint(this, cons);
		revalidate();
	}

	/**
	 * Sets the anchor to be used at the start of this polyline connection.
	 * 
	 * @param anchor
	 *            the new source anchor
	 */
	public void setSourceAnchor(ConnectionAnchor anchor) {
		if (anchor == startAnchor)
			return;
		unhookSourceAnchor();
		// No longer needed, revalidate does this.
		// getConnectionRouter().invalidate(this);
		startAnchor = anchor;
		if (getParent() != null)
			hookSourceAnchor();
		revalidate();
	}

	/**
	 * Adds a decoration to this connection. The decoration is located depending on the distance values.
	 * 
	 * @param decoration
	 *            The decoration to add.
	 * @param distanceToStart
	 *            If the distance values refer to the start-point or the end-point. See {@link FlexibleRotatableLocator}.
	 * @param relativeDistance
	 *            The relative distance. See {@link FlexibleRotatableLocator}.
	 * @param absoluteDistance
	 *            The absolute distance. See {@link FlexibleRotatableLocator}.
	 * @param rotateDegrees
	 *            The rotation in degrees. See {@link FlexibleRotatableLocator}.
	 */
	public void addDecoration(IFigure decoration, boolean distanceToStart, double relativeDistance, int absoluteDistance,
			double rotateDegrees) {
		if (decoration != null) {
			// remove if decoration was added before
			boolean removed = decorations.remove(decoration);
			if (removed) { // was added before
				remove(decoration);
			}

			// add decoration
			decorations.add(decoration);
			add(decoration, new FlexibleRotatableLocator(this, distanceToStart, relativeDistance, absoluteDistance, rotateDegrees));
		}
	}

	/**
	 * Removes all currently added decorations from the connection.
	 * 
	 * @see #getAllDecorations()
	 */
	public void removeAllDecorations() {
		for (IFigure decoration : decorations) {
			remove(decoration);
		}
		decorations.clear();
	}

	/**
	 * Returns a list of all decorations, which are currently added to this connection. Can be empty but not null.
	 * 
	 * @return A list of all decorations, which are currently added to this connection.
	 * @see #addDecoration(IFigure, boolean, double, int)
	 */
	public List<IFigure> getAllDecorations() {
		return decorations;
	}

	/**
	 * Sets the anchor to be used at the end of the polyline connection. Removes this listener from the old anchor and adds it to the new
	 * anchor.
	 * 
	 * @param anchor
	 *            the new target anchor
	 */
	public void setTargetAnchor(ConnectionAnchor anchor) {
		if (anchor == endAnchor)
			return;
		unhookTargetAnchor();
		// No longer needed, revalidate does this.
		// getConnectionRouter().invalidate(this);
		endAnchor = anchor;
		if (getParent() != null)
			hookTargetAnchor();
		revalidate();
	}

	private void unhookSourceAnchor() {
		if (getSourceAnchor() != null)
			getSourceAnchor().removeAnchorListener(this);
	}

	private void unhookTargetAnchor() {
		if (getTargetAnchor() != null)
			getTargetAnchor().removeAnchorListener(this);
	}

	final class RoutingNotifier implements ConnectionRouter {

		ConnectionRouter realRouter;

		List listeners = new ArrayList(1);

		RoutingNotifier(ConnectionRouter router, RoutingListener listener) {
			realRouter = router;
			listeners.add(listener);
		}

		public Object getConstraint(Connection connection) {
			return realRouter.getConstraint(connection);
		}

		public void invalidate(Connection connection) {
			for (int i = 0; i < listeners.size(); i++)
				((RoutingListener) listeners.get(i)).invalidate(connection);

			realRouter.invalidate(connection);
		}

		public void route(Connection connection) {
			boolean consumed = false;
			for (int i = 0; i < listeners.size(); i++)
				consumed |= ((RoutingListener) listeners.get(i)).route(connection);

			if (!consumed)
				realRouter.route(connection);

			for (int i = 0; i < listeners.size(); i++)
				((RoutingListener) listeners.get(i)).postRoute(connection);
		}

		public void remove(Connection connection) {
			for (int i = 0; i < listeners.size(); i++)
				((RoutingListener) listeners.get(i)).remove(connection);
			realRouter.remove(connection);
		}

		public void setConstraint(Connection connection, Object constraint) {
			for (int i = 0; i < listeners.size(); i++)
				((RoutingListener) listeners.get(i)).setConstraint(connection, constraint);
			realRouter.setConstraint(connection, constraint);
		}

	}

}
