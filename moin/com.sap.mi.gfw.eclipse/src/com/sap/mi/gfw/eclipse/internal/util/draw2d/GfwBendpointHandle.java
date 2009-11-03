package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.BendpointLocator;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MidpointLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.handles.BendpointHandle;
import org.eclipse.gef.tools.ConnectionBendpointTracker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.figures.ColoredLocation;
import com.sap.mi.gfw.eclipse.internal.figures.GfwFigureUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.impl.AddBendpointContext;
import com.sap.mi.gfw.features.context.impl.MoveBendpointContext;
import com.sap.mi.gfw.features.context.impl.RemoveBendpointContext;

/**
 * A circular handle which is placed on a bendpoint of a connection. It can be used to move or create the bendpoints of the connection
 * edit-part.
 */
public class GfwBendpointHandle extends BendpointHandle {

	/**
	 * Enumeration of the supported types of the bendpoint handle (create/move).
	 */
	public enum Type {
		CREATE, MOVE
	};

	/**
	 * The line-width of the handle.
	 */
	private static int LINE_WIDTH = 1;

	/**
	 * The handle-dimension for the bendpoint handle type CREATE.
	 */
	private static Dimension HANDLE_DIMENSION_CREATE = new Dimension(6, 6);

	/**
	 * The handle-dimension for the bendpoint handle type MOVE.
	 */
	private static Dimension HANDLE_DIMENSION_MOVE = new Dimension(8, 8);

	/**
	 * The foreground color for resizable directions.
	 */
	private static Color FG_COLOR_PRIMARY = ColoredLocation.getColor("cc6a01"); //$NON-NLS-1$

	/**
	 * The foreground color for not-resizable directions.
	 */
	private static Color FG_COLOR_SECONDARY = ColoredLocation.getColor("cc6a01"); //$NON-NLS-1$

	/**
	 * The background color for primary-selected, resizable directions.
	 */
	private static Color BG_COLOR_PRIMARY = ColoredLocation.getColor("ffaa2f"); //$NON-NLS-1$

	/**
	 * The background color for secondary-selected, resizable directions.
	 */
	private static Color BG_COLOR_SECONDARY = ColoredLocation.getColor("ffffff"); //$NON-NLS-1$;

	// ========================================================================

	/**
	 * The configuration provider, which can be used to access the environment.
	 */
	private IConfigurationProvider configurationProvider;

	/**
	 * The request type of the drag tracker (create/move bendpoint).
	 */
	private String dragTrackerType;

	/**
	 * Creates a new GfwBendpointHandle.
	 * 
	 * @param owner
	 *            The connection edit-part associated with this handle.
	 * @param index
	 *            The index of the bendpoint.
	 * @param locatorIndex
	 *            The index used for the bendpoint locator.
	 * @param configurationProvider
	 *            The configuration provider, which can be used to access the environment.
	 * @param type
	 *            The type of the bendpoint handle (create/move).
	 */
	public GfwBendpointHandle(ConnectionEditPart owner, int index, int locatorIndex, IConfigurationProvider configurationProvider, Type type) {
		super();
		setCursor(Cursors.NO);

		setConfigurationProvider(configurationProvider);

		setOwner(owner);
		setIndex(index);

		setOpaque(false);

		if (Type.CREATE.equals(type)) {
			setLocator(new MidpointLocator(getConnection(), locatorIndex));
			if (checkAddBendpointFeature()) {
				setCursor(SharedCursors.SIZEALL);
			}
			dragTrackerType = RequestConstants.REQ_CREATE_BENDPOINT;
			setPreferredSize(HANDLE_DIMENSION_CREATE);
		} else if (Type.MOVE.equals(type)) {
			setLocator(new BendpointLocator(getConnection(), locatorIndex));
			if (checkMoveBendpointFeature()) {
				setCursor(SharedCursors.SIZEALL);
			}
			dragTrackerType = RequestConstants.REQ_MOVE_BENDPOINT;
			setPreferredSize(HANDLE_DIMENSION_MOVE);
		} else {
			setCursor(null);
		}
	}

	/**
	 * Overridden to create a {@link ConnectionBendpointTracker} if dragging is supported. The request type of the drag tracker depends on
	 * the bendpoint handle type (create/move).
	 */
	@Override
	protected DragTracker createDragTracker() {
		ConnectionBendpointTracker tracker = null;
		if (dragTrackerType != null) {
			if (((dragTrackerType.equals(RequestConstants.REQ_MOVE_BENDPOINT)) && checkMoveBendpointFeature())
					|| ((dragTrackerType.equals(RequestConstants.REQ_CREATE_BENDPOINT)) && checkRemoveBendpointFeature())) {
				tracker = new ConnectionBendpointTracker((ConnectionEditPart) getOwner(), getIndex());
				tracker.setType(dragTrackerType);
				tracker.setDefaultCursor(getCursor());
			}
		}
		return tracker;
	}

	/**
	 * Returns <code>true</code> if the handles owner is the primary selection. If not, it must be the secondary selection.
	 * 
	 * @return <code>true</code> if the handles owner is the primary selection.
	 */
	private boolean isPrimarySelected() {
		return getOwner().getSelected() == EditPart.SELECTED_PRIMARY;
	}

	/**
	 * Paints a circular handle which is placed on the specified bendpoint of the connection edit-part.
	 */
	@Override
	public void paintFigure(Graphics g) {
		g.setAntialias(SWT.ON);
		g.setLineWidth(getLineWidth());

		boolean primary = isPrimarySelected();
		Color fg;
		Color bg;
		if (primary) {
			fg = FG_COLOR_PRIMARY;
			bg = BG_COLOR_PRIMARY;
		} else { // (!primary)
			fg = FG_COLOR_SECONDARY;
			bg = BG_COLOR_SECONDARY;
		}
		if (fg != null)
			g.setForegroundColor(fg);
		if (bg != null)
			g.setBackgroundColor(bg);

		Rectangle r = GfwFigureUtil.getAdjustedRectangle(getBounds(), 1.0, getLineWidth());
		g.fillOval(r);
		g.drawOval(r);
	}

	/**
	 * Returns the line-width adjusted with the current zoom-level.
	 * 
	 * @return The line-width adjusted with the current zoom-level.
	 */
	private int getLineWidth() {
		double zoom = GfwHandleHelper.getZoomLevel(getConfigurationProvider());
		return Math.max(1, (int) (zoom * LINE_WIDTH));
	}

	private boolean checkMoveBendpointFeature() {
		boolean ret = false;
		IFeatureProvider fp = getConfigurationProvider().getFeatureProvider();
		ret = (null != fp.getMoveBendpointFeature(new MoveBendpointContext(null)));
		return ret;
	}

	private boolean checkAddBendpointFeature() {
		boolean ret = false;
		IFeatureProvider fp = getConfigurationProvider().getFeatureProvider();
		ret = (null != fp.getAddBendpointFeature(new AddBendpointContext(null, 0, 0, 0)));
		return ret;
	}

	private boolean checkRemoveBendpointFeature() {
		boolean ret = false;
		IFeatureProvider fp = getConfigurationProvider().getFeatureProvider();
		ret = (null != fp.getRemoveBendpointFeature(new RemoveBendpointContext(null, null)));
		return ret;
	}

	private void setConfigurationProvider(IConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	protected IConfigurationProvider getConfigurationProvider() {
		return configurationProvider;
	}

	@Override
	protected boolean isFixed() {
		if (checkMoveBendpointFeature() || checkRemoveBendpointFeature()) {
			return false;
		}
		return super.isFixed();
	}
}
