package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;

/**
 * A Locator, which sets the target bounds depending on the reference figure bounds according to the following rules:
 * <ul>
 * <li>The handle-insets are used to expand/shrink the reference figure bounds, at the beginning of the calculation. They are adjusted with
 * the current zoom-level.</li>
 * <li>The location can be one of the north-south-east-west constants in {@link PositionConstants}. It describes the side/corner of the
 * reference figure bounds at which the target is located.</li>
 * <li>The handle-dimension defines the dimension of the target bounds. They are adjusted with the current zoom-level.</li>
 * </ul>
 */
public class ZoomingRelativeHandleLocator implements Locator {

	private IFigure reference;
	private IConfigurationProvider configurationProvider;
	private Dimension handleDimension;

	private double relativeX;
	private double relativeY;
	private int absoluteX;
	private int absoluteY;

	/**
	 * Creates a new ZoomingInsetsHandleLocator.
	 * 
	 * @param reference
	 *            The target bounds are calculated depending on this reference figure.
	 * @param configurationProvider
	 *            The configuration provider which can be used to access the environment.
	 * @param location
	 *            The location can be one of the north-south-east-west constants in {@link PositionConstants}.
	 * @param handleDimension
	 *            The dimension of the target bounds.
	 * @param handleInsets
	 *            The insets to apply to the reference figure bounds.
	 */
	public ZoomingRelativeHandleLocator(IFigure reference, IConfigurationProvider configurationProvider, int location,
			Dimension handleDimension, Dimension handleInsets) {
		this(reference, location, handleInsets);
		this.configurationProvider = configurationProvider;
		this.handleDimension = handleDimension;
	}

	/**
	 * Sets the relative and absolute x/y coordinates depending on the location.
	 */
	private ZoomingRelativeHandleLocator(IFigure reference, int location, Dimension handleInsets) {
		this.reference = reference;
		switch (location & PositionConstants.NORTH_SOUTH) {
		case PositionConstants.NORTH:
			relativeY = 0;
			absoluteY = -handleInsets.height;
			break;
		case PositionConstants.SOUTH:
			relativeY = 1.0;
			absoluteY = handleInsets.height;
			break;
		default:
			relativeY = 0.5;
			absoluteY = 0;
		}

		switch (location & PositionConstants.EAST_WEST) {
		case PositionConstants.WEST:
			relativeX = 0;
			absoluteX = -handleInsets.width;
			break;
		case PositionConstants.EAST:
			relativeX = 1.0;
			absoluteX = handleInsets.width;
			break;
		default:
			relativeX = 0.5;
			absoluteX = 0;
		}
	}

	/**
	 * Returns the reference figure bounds adjusted by the insets.
	 * 
	 * @return The reference figure bounds adjusted by the insets.
	 */
	private Rectangle getReferenceBox() {
		Rectangle result;
		if (reference instanceof HandleBounds)
			result = ((HandleBounds) reference).getHandleBounds();
		else
			result = reference.getBounds();
		return result;
	}

	/**
	 * Sets the bounds of the target figure as described above.
	 * 
	 * @param target
	 *            The target figure for which to set the bounds.
	 */
	public void relocate(IFigure target) {
		double zoom = GfwHandleHelper.getZoomLevel(configurationProvider);
		Dimension zoomedTargetDimension = handleDimension.getCopy();
		if (zoom != 1.0) {
			zoomedTargetDimension = handleDimension.getCopy().scale(zoom);
		}

		// copied from {@link RelativeHandleLocator}
		Rectangle targetBounds = new PrecisionRectangle(getReferenceBox().getCopy());
		reference.translateToAbsolute(targetBounds);
		target.translateToRelative(targetBounds);

		targetBounds.x += (int) (targetBounds.width * relativeX - ((zoomedTargetDimension.width + 1) / 2));
		targetBounds.y += (int) (targetBounds.height * relativeY - ((zoomedTargetDimension.height + 1) / 2));
		targetBounds.x += Math.round(absoluteX * zoom);
		targetBounds.y += Math.round(absoluteY * zoom);
		targetBounds.setSize(zoomedTargetDimension);
		target.setBounds(targetBounds);
	}
}
