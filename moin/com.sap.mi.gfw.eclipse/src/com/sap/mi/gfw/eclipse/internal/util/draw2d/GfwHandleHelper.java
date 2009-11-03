package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.GraphicalEditPart;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;

/**
 * Collection of static helper methods for handles.
 */
public class GfwHandleHelper {

	/**
	 * Returns the current zoom-level to use for the handles. This method can be overwritten to enable/disable zooming for handles.
	 * 
	 * @param configurationProvider
	 *            The configuration provider from which the zoom-level can be retrieved.
	 * 
	 * @return The current zoom-level of the given configuration provider.
	 */
	public static double getZoomLevel(IConfigurationProvider configurationProvider) {
		// double zoom = configurationProvider.getDiagramEditor().getZoomLevel();
		double zoom = 1.0;
		return zoom;
	}

	/**
	 * Returns a list containing all handles for a given shape.
	 * 
	 * @param owner
	 *            The shape, for which to create the handles.
	 * @param cp
	 *            The configuration provider, which can be used to access the environment.
	 * @param supportedResizeDirections
	 *            The directions, in which the shape can be resized (see {@link PositionConstants}).
	 * @param movable
	 *            true, if the shape can be moved.
	 * 
	 * @return A list containing all handles for a given shape.
	 */
	public static List createShapeHandles(GraphicalEditPart owner, IConfigurationProvider cp, int supportedResizeDirections, boolean movable) {
		List list = new ArrayList();

		list.add(new GfwSurroundingHandle(owner, cp, supportedResizeDirections, movable));

		if ((PositionConstants.NORTH_EAST & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.NORTH_EAST, supportedResizeDirections, movable));
		if ((PositionConstants.SOUTH_EAST & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.SOUTH_EAST, supportedResizeDirections, movable));
		if ((PositionConstants.SOUTH_WEST & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.SOUTH_WEST, supportedResizeDirections, movable));
		if ((PositionConstants.NORTH_WEST & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.NORTH_WEST, supportedResizeDirections, movable));
		if ((PositionConstants.NORTH & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.NORTH, supportedResizeDirections, movable));
		if ((PositionConstants.EAST & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.EAST, supportedResizeDirections, movable));
		if ((PositionConstants.SOUTH & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.SOUTH, supportedResizeDirections, movable));
		if ((PositionConstants.WEST & supportedResizeDirections) != 0)
			list.add(new GfwCornerHandle(owner, cp, PositionConstants.WEST, supportedResizeDirections, movable));

		return list;
	}
}
