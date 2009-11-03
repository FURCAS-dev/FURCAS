package com.sap.mi.gfw.eclipse.internal.contextbuttons;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.figures.GfwFigureUtil;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.internal.contextbuttons.IContextButtonPadDeclaration;
import com.sap.mi.gfw.internal.contextbuttons.PositionedContextButton;
import com.sap.mi.gfw.internal.contextbuttons.IContextButtonPadDeclaration.PadStyle;

/**
 * A Shape depicting a context button pad. The context button pad contains several {@link ContextButton} as children. The visual definition
 * of the context button pad is provided mostly by the {@link IContextButtonPadDeclaration}, which is set in the constructor, and not
 * calculated in this class.
 */
public class ContextButtonPad extends Shape implements ITransparencyProvider {

	/**
	 * The default duration of the animation in milliseconds.
	 */
	private static final int DEFAULT_ANIMATION_DURATION = 200;

	/**
	 * The start transparency of the animation in the range 0.0 to 1.0.
	 */
	private static final double ANIMATION_START_TRANSPARENCY = 0.0;

	/**
	 * The end transparency of the animation in the range 0.0 to 1.0.
	 */
	private static final double ANIMATION_END_TRANSPARENCY = 1.0;

	/**
	 * The context button pad declaration as described in {@link #getDeclaration()}.
	 */
	private IContextButtonPadDeclaration declaration;

	/**
	 * The zoom-level as described in {@link #getZoomLevel()}.
	 */
	private double zoomLevel;

	/**
	 * The editor as described in {@link #getEditor()}.
	 */
	private DiagramEditor editor;

	/**
	 * The edit-part as described in {@link #getEditPart()}.
	 */
	private EditPart editPart;

	private Path pathOuterLine;

	private Path pathMiddleLine;

	private Path pathInnerLine;

	private Path pathFill;

	private List<Rectangle> containmentRectangles;

	private List<Rectangle> overlappingContainmentRectangles;

	private double currentTransparency = ANIMATION_END_TRANSPARENCY;

	private long animationDuration = DEFAULT_ANIMATION_DURATION;

	// ============================= listener =================================

	/**
	 * The mouse move listener hides the context button pad, when the mouse leaves the 'mouse relevant' area of the context button pad (see
	 * {@link #isMouseInOverlappingArea()}).
	 */
	private MouseMoveListener mouseMoveListener = new MouseMoveListener() {
		public void mouseMove(MouseEvent e) {
			if (!isMouseInOverlappingArea()) {
				getEditor().getContextButtonManager().hideContextButtonsInstantly();
			}
		}
	};

	/**
	 * The mouse track listener hides the context button pad, when the mouse leaves the diagram control (e.g. when the mouse goes to the
	 * top-menu or other views/editors).
	 */
	private MouseTrackListener mouseTrackListener = new MouseTrackAdapter() {
		@Override
		public void mouseExit(MouseEvent e) {
			// TODO: discuss with Christian
			// This functionality will hide the context button pad, whenever the mouse leaves the
			// diagram control (e.g. when the mouse goes to the top-menu or other views/editors).
			// Unfortunately tooltips are also other controls, so the context button pad would
			// be hidden, if the mouse is on the tooltip of the shape or of the buttons.
			// Both behaviors are reasonable, but for now we decided not to hide the
			// context button pad when the mouse leaves the control

			// getContextButtonManager().hideContextButtonsInstantly();
		}
	};

	// ============================ constructors ==============================

	/**
	 * Creates a new ContextButtonPad and calls {@link #initialize()}.
	 * 
	 * @param declaration
	 *            The context button pad declaration as described in {@link #getDeclaration()}.
	 * @param zoomLevel
	 *            The zoom-level as described in {@link #getZoomLevel()}.
	 * @param editor
	 *            The editor as described in {@link #getEditor()}.
	 * @param editPart
	 *            The edit-part as described in {@link #getEditPart()}.
	 */
	public ContextButtonPad(IContextButtonPadDeclaration declaration, double zoomLevel, DiagramEditor editor, EditPart editPart) {
		this.declaration = declaration;
		this.zoomLevel = zoomLevel;
		this.editor = editor;
		this.editPart = editPart;

		initialize();
	}

	// ====================== getter/setter for fields ========================

	/**
	 * Returns the declaration, which provides the visual definition and the context buttons for this context button pad. It is set in the
	 * constructor and not changed afterwards.
	 * 
	 * @return The declaration, which provides the visual definition and the context buttons for this context button pad.
	 */
	public final IContextButtonPadDeclaration getDeclaration() {
		return declaration;
	}

	/**
	 * Returns the zoom-level, which shall be used when rendering the context button pad. It is set in the constructor and not changed
	 * afterwards. The values provided by the declaration (see {@link #getDeclaration()}) are always using a zoom-level 1.0, so they have to
	 * be adjusted by the zoom-level.
	 * 
	 * @return The zoom-level, which shall be used when rendering the context button pad.
	 */
	public final double getZoomLevel() {
		return zoomLevel;
	}

	/**
	 * Returns the editor for which the context button pad belongs. It can be used to access the environment. It is set in the constructor
	 * and not changed afterwards.
	 * 
	 * @return The editor, which can be used to access the environment.
	 */
	public final DiagramEditor getEditor() {
		return editor;
	}

	/**
	 * Returns the edit-part for which the context button pad is showing. It is used by the context buttons, which work on/with the
	 * edit-part. It is set in the constructor and not changed afterwards.
	 * 
	 * @return The editor, which can be used to access the environment.
	 */
	public final EditPart getEditPart() {
		return editPart;
	}

	// =========================== initialization =============================

	/**
	 * Initializes several fields of this class. This method is called in the constructor and calls {@link #initializePathes()},
	 * {@link #initializeContainments()} and {@link #createContextButtons()}.
	 */
	private void initialize() {
		initializeContainments();
		createContextButtons();
	}

	/**
	 * Initializes the lists {@link #containmentRectangles} and {@link #overlappingContainmentRectangles}, by transforming the rectangles
	 * provided by the declaration (see {@link #getDeclaration()}) using {@link #transformGenericRectangle(java.awt.Rectangle, int)}. Then
	 * it sets the bounds of this figure dependent on the {@link #overlappingContainmentRectangles}.
	 */
	private void initializeContainments() {
		containmentRectangles = new ArrayList<Rectangle>();
		overlappingContainmentRectangles = new ArrayList<Rectangle>();

		for (java.awt.Rectangle rectangle : getDeclaration().getContainmentRectangles()) {
			Rectangle transformedRectangle = transformGenericRectangle(rectangle, 0);
			containmentRectangles.add(transformedRectangle);
		}
		for (java.awt.Rectangle rectangle : getDeclaration().getOverlappingContainmentRectangles()) {
			Rectangle transformedRectangle = transformGenericRectangle(rectangle, 0);
			overlappingContainmentRectangles.add(transformedRectangle);
		}

		if (overlappingContainmentRectangles.size() > 0) { // always true
			Rectangle unionRectangle = overlappingContainmentRectangles.get(0).getCopy();
			for (Rectangle containmentRectangle : overlappingContainmentRectangles) {
				unionRectangle.union(containmentRectangle);
			}
			unionRectangle.expand(2, 2); // expand slightly to avoid rounding problems
			setBounds(unionRectangle);
		}
	}

	/**
	 * Creates a visual {@link ContextButton} for each logical {@link PositionedContextButton}, which are provided by the declaration
	 * {@link #getDeclaration()}. Those context buttons are then added to the context button pad at the correct location.
	 */
	private void createContextButtons() {
		List<PositionedContextButton> positionedButtons = getDeclaration().getPositionedContextButtons();

		setLayoutManager(new XYLayout());

		for (PositionedContextButton positionedButton : positionedButtons) {
			Rectangle position = transformGenericRectangle(positionedButton.getPosition(), 0);
			// translate position relative to bounds (after the bounds are set!)
			position.translate(-getBounds().getTopLeft().x, -getBounds().getTopLeft().y);
			ContextButton cb = new ContextButton(positionedButton, this);
			add(cb, position);
		}
	}

	/**
	 * Initializes the fields for the paths {@link #pathOuterLine}, {@link #pathMiddleLine}, {@link #pathInnerLine} and {@link #pathFill}.
	 * This is done by calling {@link #createPath(int)} with ascending values for 'shrink-lines'. As a result those four paths all have the
	 * same outline, but each path becomes one line smaller so that they lie directly in each other.
	 */
	private void createPathes() {
		pathOuterLine = createPath(0);
		pathMiddleLine = createPath(1);
		pathInnerLine = createPath(2);
		pathFill = createPath(3);
	}

	/**
	 * Disposes all paths, which were created in {@link #createPathes()}.
	 */
	private void disposePathes() {
		pathOuterLine.dispose();
		pathMiddleLine.dispose();
		pathInnerLine.dispose();
		pathFill.dispose();
		pathOuterLine = null;
		pathMiddleLine = null;
		pathInnerLine = null;
		pathFill = null;
	}

	/**
	 * Creates and returns a path outlining the context button pad. The path includes the three rectangles top, right and bottom, which are
	 * provided by the declaration (see {@link #getDeclaration()}). A parameter shrink-lines is used to shrink the path by the given number
	 * of lines to the inside.
	 * <p>
	 * Basically this method just forwards to {@link #createPath(Rectangle, Rectangle, Rectangle, int)}, but before it adjusts the
	 * rectangles and corner by the zoom-level and shrink-lines.
	 * 
	 * @param shrinkLines
	 *            The number of lines to shrink the path to the inside.
	 * @return A path outlining the context button pad.
	 */
	private Path createPath(int shrinkLines) {
		double zoom = getZoomLevel();
		int lw = shrinkLines * ((int) (getDeclaration().getPadLineWidth() * zoom));

		// adjust corner for the inner path (formula found by experimenting)
		double corner = (getDeclaration().getPadCornerRadius() * zoom);
		corner = Math.max(1, corner - (lw + corner / 64));

		Rectangle topAdjusted = transformGenericRectangle(getDeclaration().getTopPad(), shrinkLines);
		Rectangle rightAdjusted = transformGenericRectangle(getDeclaration().getRightPad(), shrinkLines);
		Rectangle bottomAdjusted = transformGenericRectangle(getDeclaration().getBottomPad(), shrinkLines);

		Path path = createPath(topAdjusted, rightAdjusted, bottomAdjusted, (int) corner);
		return path;
	}

	/**
	 * Creates and returns a path including the given rectangles and uses the given corner-radius. Note, that all those values are already
	 * adjusted to the given zoom-level and 'shrink-lines' (see {@link #createPath(int)}).
	 * 
	 * @param topOutside
	 *            The outside of the top rectangle to include. The path remains inside the rectangle even for a big line-width.
	 * @param rightOutside
	 *            The outside of the right rectangle to include. The path remains inside the rectangle even for a big line-width.
	 * @param bottomOutside
	 *            The outside of the bottom rectangle to include. The path remains inside the rectangle even for a big line-width.
	 * @param corner
	 *            The corner radius to use for the path.
	 * @return A path surrounding the given rectangles and uses the given corner-radius.
	 */
	private Path createPath(Rectangle topOutside, Rectangle rightOutside, Rectangle bottomOutside, int corner) {
		Path path = new Path(null);

		// currently we assume, that the inner corner radius is always half the outer corner radius
		int innerCorner = corner / 2;

		// first shrink all rectangles by the half line-width, so that painting remains inside the given 'outside' rectangles
		Rectangle top = GfwFigureUtil.getAdjustedRectangle(topOutside, 1.0, (int) (getDeclaration().getPadLineWidth() * getZoomLevel()));
		Rectangle right = GfwFigureUtil
				.getAdjustedRectangle(rightOutside, 1.0, (int) (getDeclaration().getPadLineWidth() * getZoomLevel()));
		Rectangle bottom = GfwFigureUtil.getAdjustedRectangle(bottomOutside, 1.0,
				(int) (getDeclaration().getPadLineWidth() * getZoomLevel()));

		// differenciate the pad styles
		boolean hasTop = top != null;
		boolean hasRight = right != null;
		boolean hasStandardTop = hasTop && getDeclaration().getTopPadStyle().equals(PadStyle.STANDARD);
		boolean hasStandardRight = hasRight && getDeclaration().getRightPadStyle().equals(PadStyle.STANDARD);
		boolean hasAppendageTop = hasTop && getDeclaration().getTopPadStyle().equals(PadStyle.APPENDAGE);
		boolean hasAppendageRight = hasRight && getDeclaration().getRightPadStyle().equals(PadStyle.APPENDAGE);

		// create path

		if (hasStandardTop) {
			// curved line around top(top-right) -> top(top-left) -> top(bottom-left)
			path.addArc(top.getTopRight().x - corner, top.getTopRight().y, corner, corner, 0, 90);
			path.addArc(top.getTopLeft().x, top.getTopLeft().y, corner, corner, 90, 90);
			path.addArc(top.getBottomLeft().x, top.getBottomLeft().y - corner, corner, corner, 180, 90);
		} else if (hasAppendageTop) {
			// curved line around top(top-left) -> top(bottom-left)
			int appendageCorner = Math.min(corner, top.height * 2); // adjust for small sizes
			path.addArc(top.getTopLeft().x, top.getTopLeft().y, appendageCorner, appendageCorner, 90, 90);
			path.lineTo(top.getBottomLeft().x, top.getBottomLeft().y);
		} else { // !hasTop
			// curved line around right(top-left)
			path.addArc(right.getTopLeft().x, right.getTopLeft().y, corner, corner, 90, 90);
		}

		if (hasTop && hasRight) {
			// inside open curve connecting top and right
			path.addArc(right.getLeft().x - innerCorner, top.getBottom().y, innerCorner, innerCorner, 90, -90);
		}

		if (hasStandardRight) {
			if (bottom == null) {
				// curved line around right(bottom-left)
				path.addArc(right.getBottomLeft().x, right.getBottomLeft().y - corner, corner, corner, 180, 90);
			} else {
				// inside open curve connection right and bottom
				path.addArc(right.getLeft().x - innerCorner, bottom.getTop().y - innerCorner, innerCorner, innerCorner, 0, -90);
				// curved line around bottom(top-left) -> bottom(bottom-left) -> bottom(bottom-right)
				path.addArc(bottom.getTopLeft().x, bottom.getTopLeft().y, corner, corner, 90, 90);
				path.addArc(bottom.getBottomLeft().x, bottom.getBottomLeft().y - corner, corner, corner, 180, 90);
				path.addArc(bottom.getBottomRight().x - corner, bottom.getBottomRight().y - corner, corner, corner, 270, 90);
				// outside open curve connection bottom and right
				path.addArc(bottom.getRight().x, right.getBottom().y, corner, corner, 180, -90);
			}

			// curved line around right(bottom-right) -> right(top-right)
			path.addArc(right.getBottomRight().x - corner, right.getBottomRight().y - corner, corner, corner, 270, 90);
			path.addArc(right.getTopRight().x - corner, right.getTopRight().y, corner, corner, 0, 90);
		} else if (hasAppendageRight) {
			// curved line around right(bottom-left) -> right(bottom-right)
			int appendageCorner = Math.min(corner, right.width * 2); // adjust for small sizes
			path.lineTo(right.getBottomLeft().x, right.getBottomLeft().y);
			path.addArc(right.getBottomRight().x - appendageCorner, right.getBottomRight().y - appendageCorner, appendageCorner,
					appendageCorner, 270, 90);
		} else { // !hasRight
			// close curved rectangle around top (bottom-right)
			path.addArc(top.getBottomRight().x - corner, top.getBottomRight().y - corner, corner, corner, 270, 90);
		}

		if (hasStandardTop && hasStandardRight) {
			// outside open curve connecting right and top (appendages have direct line)
			path.addArc(top.getRight().x, right.getTop().y - corner, corner, corner, 270, -90);
		}

		path.close();

		return path;
	}

	/**
	 * Returns a rectangle, which is calculating from the given rectangle by shrinking it the given number of lines and scaling it with the
	 * zoom-level. Note, that this method also makes a transformation from java.awt.Rectangle to org.eclipse.draw2d.geometry.Rectangle.
	 * 
	 * @param source
	 *            The source rectangle from which to calculate the result.
	 * @param shrinkLines
	 *            The number of lines to shrink the rectangle.
	 * @return A rectangle, which is calculating from the given rectangle by shrinking it the given number of lines and scaling it with the
	 *         zoom-level.
	 */
	private Rectangle transformGenericRectangle(java.awt.Rectangle source, int shrinkLines) {
		if (source == null) {
			return null;
		}

		double zoom = getZoomLevel();
		int lw = shrinkLines * ((int) (getDeclaration().getPadLineWidth() * zoom));

		Rectangle target = new Rectangle(source.x, source.y, source.width, source.height);
		target.scale(zoom);
		// shrink, but take care not to end up with a negative width or height
		int widthShrink = Math.min(target.width / 2, lw);
		int heightShrink = Math.min(target.height / 2, lw);
		target.shrink(widthShrink, heightShrink);
		return target;
	}

	// =========================== event handling =============================

	/**
	 * Registers the listeners, when the context button pad is shown (when it is added to its parent).
	 */
	@Override
	public void addNotify() {
		super.addNotify();

		Control control = getEditor().getGraphicalViewer().getControl();
		control.addMouseMoveListener(mouseMoveListener);
		control.addMouseTrackListener(mouseTrackListener);

		// TODO: discuss with Christian
		// If the animation is running, then dragging the shape does not work
		// correctly. The dragging is interrupted, when the context button pad
		// disappears.
		// It is still unclear why this happens.
		// Workaround: switch off animation or set a very short animation time
		// Another problem is, that the pad sometimes (rarely) flickers,
		// which becomes more visible with short animation times.

		// doAnimation();
	}

	/**
	 * Deregisters the listeners, when the context button pad is hidden (when it is removed from its parent).
	 */
	@Override
	public void removeNotify() {
		Control control = getEditor().getGraphicalViewer().getControl();
		control.removeMouseMoveListener(mouseMoveListener);
		control.removeMouseTrackListener(mouseTrackListener);

		super.removeNotify();
	}

	// ============================== painting ================================

	/**
	 * Outlines this Shape on the given Graphics. This will draw the paths {@link #pathInnerLine}, {@link #pathMiddleLine} and
	 * {@link #pathOuterLine}.
	 * 
	 * @param graphics
	 *            The Graphics on which to outline this Shape.
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		int lw = (int) (getZoomLevel() * getDeclaration().getPadLineWidth());
		graphics.setLineWidth(lw);

		graphics.setForegroundColor(DataTypeTransformation.toSwtColor(getEditor(), getDeclaration().getPadInnerLineColor()));
		graphics.drawPath(pathInnerLine);
		graphics.setForegroundColor(DataTypeTransformation.toSwtColor(getEditor(), getDeclaration().getPadMiddleLineColor()));
		graphics.drawPath(pathMiddleLine);
		graphics.setForegroundColor(DataTypeTransformation.toSwtColor(getEditor(), getDeclaration().getPadOuterLineColor()));
		graphics.drawPath(pathOuterLine);
	}

	/**
	 * First initializes the given Graphics with settings like alpha-value, antialias-value, ... Afterwards calls
	 * <code>super.paintFigure(graphics)</code> to continue with the default painting mechanisms.
	 * 
	 * @param graphics
	 *            The Graphics on which to paint.
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		graphics.setAntialias(SWT.ON);

		// double padDefaultOpacity = getDeclaration().getPadDefaultOpacity();
		// int endAlpha = (int) (padDefaultOpacity * 255.0);

		graphics.setAlpha((int) (currentTransparency * getDeclaration().getPadDefaultOpacity() * 255));

		createPathes();
		super.paintFigure(graphics);
		disposePathes();
	}

	/**
	 * Fills this Shape on the given Graphics. This will draw and fill the path {@link #pathFill}.
	 * 
	 * @param graphics
	 *            The Graphics on which to fill this Shape.
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		int lw = (int) (getZoomLevel() * getDeclaration().getPadLineWidth());
		graphics.setLineWidth(lw);

		graphics.setForegroundColor(DataTypeTransformation.toSwtColor(getEditor(), getDeclaration().getPadFillColor()));
		graphics.setBackgroundColor(DataTypeTransformation.toSwtColor(getEditor(), getDeclaration().getPadFillColor()));
		graphics.drawPath(pathFill);
		graphics.fillPath(pathFill);
	}

	/**
	 * Increases the current transparency (see {@link #getCurrentTransparency()}) in a loop and forces a repaint after each increase. As a
	 * result this will seem to the user as if the context button pad slowly 'fades in' from invisible to visible.
	 */
	@SuppressWarnings("unused")
	private void doAnimation() {
		// set start values for animation
		long startTime = System.currentTimeMillis();
		long stepsDone = 0;
		currentTransparency = ANIMATION_START_TRANSPARENCY;
		while (isPadShowing() && (currentTransparency < ANIMATION_END_TRANSPARENCY)) {
			// repaint context button pad with current transparency
			forceRepaint();
			stepsDone++;

			// increase current transparency (self adjusting algorithm)
			long elapsedTime = Math.max(1, System.currentTimeMillis() - startTime);
			long restTime = Math.max(1, animationDuration - elapsedTime);
			double restSteps = (((double) (stepsDone * restTime)) / elapsedTime);
			double deltaTransparency = (ANIMATION_END_TRANSPARENCY - currentTransparency) / restSteps;
			currentTransparency += deltaTransparency;
			if (elapsedTime > animationDuration) { // safeguard in case of rounding errors
				currentTransparency = ANIMATION_END_TRANSPARENCY;
			}
		}

		// finally paint using the end transparency
		currentTransparency = ANIMATION_END_TRANSPARENCY;
		forceRepaint();
	}

	/**
	 * Forces a repaint of this figure, by first calling repaint() and then waiting until all UI events are processed.
	 */
	private void forceRepaint() {
		if (isPadShowing()) {
			repaint();
			while (Display.getCurrent().readAndDispatch()) {
				// do nothing
			}
		}
	}

	// ========================== helper methods ==============================

	/**
	 * Returns true, if the mouse is in the overlapping area of the context button pad. The overlapping area is the union of all overlapping
	 * rectangles (see {@link IContextButtonPadDeclaration#getOverlappingContainmentRectangles()}).
	 */
	public boolean isMouseInOverlappingArea() {
		// determine mouse location in correct coordinates
		Point editorMouseLocation = new Point(getEditor().getMouseLocation());
		Point viewPortMouseLocation = getEditor().calculateRealMouseLocation(editorMouseLocation);
		Point mouseLocation = viewPortMouseLocation.scale(getZoomLevel());
		// hide if mouse location outside overlapping containment rectangles
		boolean containsPointOverlapping = containsPointOverlapping(mouseLocation.x, mouseLocation.y);
		if (!containsPointOverlapping) {
			getEditor().getContextButtonManager().hideContextButtonsInstantly();
			return true;
		}
		return containsPointOverlapping;
	}

	/**
	 * Returns true, if the given point is contained inside one of the visible parts of the context button pad. Note, that this is a much
	 * smaller area than the bounds of this shape, because the bounds are the outer invisible rectangle around all visible parts of the
	 * context button pad.
	 * <p>
	 * Technically this is the union of all containment rectangles (see {@link IContextButtonPadDeclaration#getContainmentRectangles()}).
	 * 
	 * @param x
	 *            The x-coordinate of the point to check.
	 * @param y
	 *            The y-coordinate of the point to check.
	 * @return true, if the given point is contained inside one of the visible parts of the context button pad.
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		boolean ret = false;
		for (Rectangle rectangle : containmentRectangles) {
			if (rectangle.contains(x, y)) {
				ret = true;
				break;
			}
		}
		return ret;
	}

	/**
	 * Returns true, if the given point is contained inside the overlapping area of all visible parts of the context button pad. Note, that
	 * this is a much smaller area than the bounds of this shape, because the bounds are the outer invisible rectangle around all visible
	 * parts of the context button pad.
	 * 
	 * @param x
	 *            The x-coordinate of the point to check.
	 * @param y
	 *            The y-coordinate of the point to check.
	 * @return true, if the given point is contained inside the overlapping area of all visible parts of the context button pad.
	 */
	public boolean containsPointOverlapping(int x, int y) {
		boolean ret = false;
		for (Rectangle rectangle : overlappingContainmentRectangles) {
			if (rectangle.contains(x, y)) {
				ret = true;
				break;
			}
		}
		return ret;
	}

	/**
	 * Returns the current transparency as described in {@link ITransparencyProvider}.
	 * 
	 * @return The current transparency as described in {@link ITransparencyProvider}.
	 */
	public double getCurrentTransparency() {
		return currentTransparency;
	}

	/**
	 * Returns true, if the pad is currently showing.
	 * 
	 * @return true, if the pad is currently showing.
	 */
	private boolean isPadShowing() {
		// returns true in the time, between addNotify() and removeNotify()
		boolean hasParent = getParent() != null;
		return hasParent;
	}
}
