package com.sap.mi.gfw.eclipse.internal.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.ScrollPaneSolver;
import org.eclipse.draw2d.UpdateListener;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.sap.mi.gfw.eclipse.internal.parts.DiagramEditPart;

/**
 * A Canvas that contains {@link Figure Figures}.
 * <p>
 * Note: Only one of the styles RIGHT_TO_LEFT, LEFT_TO_RIGHT may be specified.
 * </p>
 */
public class GFWFigureCanvas extends Canvas {

	/**
	 * Never show scrollbar.
	 */
	public static int NEVER = 0;

	/**
	 * Automatically show scrollbar when needed.
	 */
	public static int AUTOMATIC = 1;

	/**
	 * Always show scrollbar.
	 */
	public static int ALWAYS = 2;

	private int vBarVisibility = AUTOMATIC;

	private int hBarVisibility = AUTOMATIC;

	private Viewport viewport;

	private Font font;

	private int hBarOffset;

	private int vBarOffset;

	private final Pixel bottomRightCorner = new Pixel();

	private final Pixel topLeftCorner = new Pixel();

	private boolean doScroll = true;

	private final GFWUpdateListener gfwUpdateListener = new GFWUpdateListener();

	private DiagramEditor diagramEditor = null;

	private boolean init = true;

	private final PropertyChangeListener horizontalChangeListener = new PropertyChangeListener() {

		double OldZoomlevel = 1D;

		public void propertyChange(PropertyChangeEvent event) {

			/*
			 * Check whether the viewport is larger than the diagram (might happen after resizing the viewport window). The symptom would be
			 * disappearing scrollbars...
			 */
			Rectangle diagramBounds = getDiagramBoundsFromCornerPixels();
			Rectangle clientArea = new Rectangle(getClientArea());
			int diff = diagramBounds.width - clientArea.width;
			double zoomLevel = getZoomLevel();
			if (zoomLevel != OldZoomlevel || diff <= 0) {
				/* move corner pixel */
				// <sw 120109> improve scroll behavior at zoom levels < 1
				bottomRightCorner.remove();
				Rectangle minimalDiagram = getDiagramBoundsFromEditPartChildren(); // minimal rectangle containing all shapes on the canvas
				int newX = minimalDiagram.right();
				if (newX * zoomLevel <= clientArea.right()) {
					newX = (int) (clientArea.right() / zoomLevel);
				}
				// </sw 120109>
				bottomRightCorner.replace(newX, bottomRightCorner.getBounds().y);
				OldZoomlevel = zoomLevel;
			}

			RangeModel model = getViewport().getHorizontalRangeModel();
			hBarOffset = Math.max(0, -model.getMinimum());
			getHorizontalBar().setValues(model.getValue() + hBarOffset, model.getMinimum() + hBarOffset, model.getMaximum() + hBarOffset,
					model.getExtent(), Math.max(1, model.getExtent() / 20), Math.max(1, model.getExtent() * 3 / 4));
		}
	};

	private final PropertyChangeListener verticalChangeListener = new PropertyChangeListener() {

		double OldZoomlevel = 1D;

		public void propertyChange(PropertyChangeEvent event) {

			/*
			 * Check whether the viewport is larger than the diagram (might happen after resizing the viewport window). The symptom would be
			 * disappearing scrollbars...
			 */
			Rectangle diagramBounds = getDiagramBoundsFromCornerPixels();
			Rectangle clientArea = new Rectangle(getClientArea());
			int diff = diagramBounds.height - clientArea.height;
			double zoomLevel = getZoomLevel();
			if (zoomLevel != OldZoomlevel || diff <= 0) {
				/* move corner pixel */
				// <sw 120109> improve scroll behavior at zoom levels < 1
				bottomRightCorner.remove();
				Rectangle minimalDiagram = getDiagramBoundsFromEditPartChildren(); // minimal rectangle containing all shapes on the canvas
				int newY = minimalDiagram.bottom();
				if (newY * zoomLevel <= clientArea.bottom()) {
					newY = (int) (clientArea.bottom() / zoomLevel);
				}
				// </sw 120109>
				bottomRightCorner.replace(bottomRightCorner.getBounds().x, newY);
				OldZoomlevel = zoomLevel;
			}

			RangeModel model = getViewport().getVerticalRangeModel();
			vBarOffset = Math.max(0, -model.getMinimum());
			getVerticalBar().setValues(model.getValue() + vBarOffset, model.getMinimum() + vBarOffset, model.getMaximum() + vBarOffset,
					model.getExtent(), Math.max(1, model.getExtent() / 20), Math.max(1, model.getExtent() * 3 / 4));
		}
	};

	private final LightweightSystem lws;

	/**
	 * Creates a new FigureCanvas with the given parent.
	 * 
	 * @param parent
	 *            the parent
	 * @param diagramEditor
	 *            the diagram editor
	 */
	public GFWFigureCanvas(Composite parent, DiagramEditor diagramEditor) {
		this(parent, SWT.DOUBLE_BUFFERED, new LightweightSystem(), diagramEditor);
	}

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            look at class javadoc for valid styles
	 * @param diagramEditor
	 *            the diagram editor
	 * @since 3.1
	 */
	public GFWFigureCanvas(Composite parent, int style, DiagramEditor diagramEditor) {
		this(parent, style, new LightweightSystem(), diagramEditor);
	}

	/**
	 * Constructs a new FigureCanvas with the given parent and LightweightSystem.
	 * 
	 * @param parent
	 *            the parent
	 * @param lws
	 *            the LightweightSystem
	 * @param diagramEditor
	 *            the diagram editor
	 */
	public GFWFigureCanvas(Composite parent, LightweightSystem lws, DiagramEditor diagramEditor) {
		this(parent, SWT.DOUBLE_BUFFERED, lws, diagramEditor);
	}

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            look at class javadoc for valid styles
	 * @param lws
	 *            the lightweight system
	 * @param diagramEditor
	 *            the diagram editor
	 * @since 3.1
	 */
	public GFWFigureCanvas(Composite parent, int style, LightweightSystem lws, DiagramEditor diagramEditor) {
		super(parent, checkStyle(style | SWT.NO_REDRAW_RESIZE | SWT.NO_BACKGROUND | SWT.V_SCROLL | SWT.H_SCROLL));
		getHorizontalBar().setVisible(false);
		getVerticalBar().setVisible(false);
		this.lws = lws;
		this.diagramEditor = diagramEditor;
		lws.setControl(this);
		hook();
	}

	private static int checkStyle(int style) {
		int validStyles = SWT.RIGHT_TO_LEFT | SWT.LEFT_TO_RIGHT | SWT.V_SCROLL | SWT.H_SCROLL | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE
				| SWT.DOUBLE_BUFFERED;
		if ((style & ~validStyles) != 0)
			throw new IllegalArgumentException("Invalid style being set on FigureCanvas"); //$NON-NLS-1$
		return style;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Composite#computeSize(int, int, boolean)
	 */
	@Override
	public org.eclipse.swt.graphics.Point computeSize(int wHint, int hHint, boolean changed) {
		// TODO not accounting for scrollbars and trim
		Dimension size = getLightweightSystem().getRootFigure().getPreferredSize(wHint, hHint);
		size.union(new Dimension(wHint, hHint));
		return new org.eclipse.swt.graphics.Point(size.width, size.height);
	}

	/**
	 * Gets the contents.
	 * 
	 * @return the contents of the {@link Viewport}.
	 */
	public IFigure getContents() {
		return getViewport().getContents();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Control#getFont()
	 */
	@Override
	public Font getFont() {
		if (font == null)
			font = super.getFont();
		return font;
	}

	/**
	 * Gets the horizontal scroll bar visibility.
	 * 
	 * @return the horizontal scrollbar visibility.
	 */
	public int getHorizontalScrollBarVisibility() {
		return hBarVisibility;
	}

	/**
	 * Gets the lightweight system.
	 * 
	 * @return the LightweightSystem
	 */
	public LightweightSystem getLightweightSystem() {
		return lws;
	}

	/**
	 * Gets the vertical scroll bar visibility.
	 * 
	 * @return the vertical scrollbar visibility.
	 */
	public int getVerticalScrollBarVisibility() {
		return vBarVisibility;
	}

	/**
	 * Returns the Viewport. If it's <code>null</code>, a new one is created.
	 * 
	 * @return the viewport
	 */
	public Viewport getViewport() {
		if (viewport == null)
			setViewport(new Viewport(true));
		return viewport;
	}

	/**
	 * Adds listeners for scrolling.
	 */
	private void hook() {
		getLightweightSystem().getUpdateManager().addUpdateListener(gfwUpdateListener);

		getHorizontalBar().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				scrollToX(event, getHorizontalBar().getSelection() - hBarOffset);
			}
		});

		getVerticalBar().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				scrollToY(event, getVerticalBar().getSelection() - vBarOffset);
			}
		});
	}

	private void hookViewport() {
		getViewport().getHorizontalRangeModel().addPropertyChangeListener(horizontalChangeListener);
		getViewport().getVerticalRangeModel().addPropertyChangeListener(verticalChangeListener);
	}

	private void unhookViewport() {
		getViewport().getHorizontalRangeModel().removePropertyChangeListener(horizontalChangeListener);
		getViewport().getVerticalRangeModel().removePropertyChangeListener(verticalChangeListener);
	}

	private void layoutViewport() {
		/*
		 * Add two invisible pixels to the diagram in order to force the visibility of the scroll bars
		 */
		if (init) {
			setCornerPixels();
			init = false;
		}

		ScrollPaneSolver.Result result;
		result = ScrollPaneSolver.solve(new Rectangle(getBounds()).setLocation(0, 0), getViewport(), getHorizontalScrollBarVisibility(),
				getVerticalScrollBarVisibility(), computeTrim(0, 0, 0, 0).width, computeTrim(0, 0, 0, 0).height);
		// sw: cannot activate next line (as in class FigureCanvas) since the
		// method not visible
		// sw getLightweightSystem().setIgnoreResize(true);
		try {
			if (getHorizontalBar().getVisible() != result.showH)
				getHorizontalBar().setVisible(result.showH);
			if (getVerticalBar().getVisible() != result.showV)
				getVerticalBar().setVisible(result.showV);
			Rectangle r = new Rectangle(getClientArea());
			r.setLocation(0, 0);
			getLightweightSystem().getRootFigure().setBounds(r);
		} finally {
			// sw: cannot activate next line (as in class FigureCanvas) since
			// the method not visible
			// sw getLightweightSystem().setIgnoreResize(false);
		}
	}

	private Rectangle getDiagramBounds() {
		Rectangle clientArea = new Rectangle(getClientArea());
		Rectangle bounds = getDiagramBoundsFromDiagramEditPart().getCopy();
		bounds.union(0, 0, clientArea.width, clientArea.height);
		// ((FreeformFigure) getContents()).setFreeformBounds(bounds);
		return bounds;
	}

	/**
	 * Scrolls the contents horizontally so that they are offset by <code>hOffset</code>.
	 * 
	 * @param hOffset
	 *            the new horizontal offset
	 * @param event
	 *            the event
	 */
	public void scrollToX(SelectionEvent event, int hOffset) {

		if (event == null) {
			return;
		}

		hOffset = verifyScrollBarOffset(getViewport().getHorizontalRangeModel(), hOffset);
		int hOffsetOld = getViewport().getViewLocation().x;

		/* scrolling within the current size of the diagram in either direction */
		int dx = -hOffset + hOffsetOld;

		/* get zoom factor */
		double zoomLevel = getZoomLevel();

		if (dx != 0) { // slider is not yet at left or right boundary
			/* scroll with arrow buttons? regain space */
			if (event.detail == SWT.ARROW_UP || event.detail == SWT.ARROW_DOWN) {
				regainHorizontalSpace();
			}
		} else {

			if (event.detail == SWT.ARROW_UP) { // scrolling to the left

				/* scroll value */
				// <sw 120109> extend canvas only into positive region (as preferred by GEF)
				// dx = -getHorizontalBar().getIncrement();
				dx = 0;
				// </sw 120109>
				/*
				 * compute diagram size from figures in DiagramEditPart (including corner pixels)
				 */
				Rectangle diagramBounds = getDiagramBounds();
				/* new scroll bar position has still to be at left boundary */
				hOffset = diagramBounds.x + dx;
				/*
				 * move top left corner to the left; keep its current y-position
				 */
				// topLeftCorner.replace(hOffset + (int) (topLeftCorner.getSizeInPixel() / zoomLevel), topLeftCorner.getBounds().y);
				topLeftCorner.replace(hOffset, topLeftCorner.getBounds().y);
				/* adjust view port parameters */
				getViewport().getHorizontalRangeModel().setAll((int) (hOffset * zoomLevel),
						(int) ((diagramBounds.width - Math.abs(dx)) * zoomLevel), bottomRightCorner.getBounds().x);
				/* avoid double repaint of diagram later */
				doScroll = false;

			}

			else if (event.detail == SWT.ARROW_DOWN) { // scrolling to the right

				/* scroll value */
				dx = getHorizontalBar().getIncrement();
				/*
				 * compute diagram size from figures in DiagramEditPart (including corner pixels)
				 */
				Rectangle diagramBounds = getDiagramBounds();
				/* new scroll bar position has still to be at right boundary */
				hOffset = diagramBounds.right() + dx;
				/*
				 * move bottom right corner to the right; keep its current y-position
				 */
				bottomRightCorner.replace(hOffset, bottomRightCorner.getBounds().y);
				/* adjust view port parameters */
				getViewport().getHorizontalRangeModel().setAll((int) (hOffset * zoomLevel),
						(int) ((diagramBounds.width - Math.abs(dx)) * zoomLevel), bottomRightCorner.getBounds().x);
				/* avoid double repaint of diagram later */
				doScroll = false;

			} else {
				/* scroll with slider */
				return;
			}
		}

		Rectangle clientArea = getViewport().getBounds().getCropped(getViewport().getInsets());
		Rectangle blit = clientArea.getResized(-Math.abs(dx), 0);
		Rectangle expose = clientArea.getCopy();
		Point dest = clientArea.getTopLeft();
		expose.width = Math.abs(dx);
		if (dx < 0) { // Moving left?
			blit.translate(-dx, 0); // Move blit area to the right
			expose.x = dest.x + blit.width;
		} else
			// Moving right
			dest.x += dx; // Move expose area to the right

		// fix for bug 41111
		Control[] children = getChildren();
		boolean[] manualMove = new boolean[children.length];
		for (int i = 0; i < children.length; i++) {
			org.eclipse.swt.graphics.Rectangle bounds = children[i].getBounds();
			manualMove[i] = blit.width <= 0 || bounds.x > blit.x + blit.width || bounds.y > blit.y + blit.height
					|| bounds.x + bounds.width < blit.x || bounds.y + bounds.height < blit.y;
		}
		if (doScroll) {
			scroll(dest.x, dest.y, blit.x, blit.y, blit.width, blit.height, true);
		}
		doScroll = true;
		for (int i = 0; i < children.length; i++) {
			org.eclipse.swt.graphics.Rectangle bounds = children[i].getBounds();
			if (manualMove[i])
				children[i].setBounds(bounds.x + dx, bounds.y, bounds.width, bounds.height);
		}

		getViewport().setIgnoreScroll(true);
		getViewport().setHorizontalLocation(hOffset);
		getViewport().setIgnoreScroll(false);

		redraw(expose.x, expose.y, expose.width, expose.height, true);

	}

	/**
	 * Scrolls the contents vertically so that they are offset by <code>vOffset</code>.
	 * 
	 * @param vOffset
	 *            the new vertical offset
	 * @param event
	 *            the event
	 */
	public void scrollToY(SelectionEvent event, int vOffset) {

		if (event == null) {
			return;
		}

		vOffset = verifyScrollBarOffset(getViewport().getVerticalRangeModel(), vOffset);
		int vOffsetOld = getViewport().getViewLocation().y;

		/* scrolling within the current size of the diagram in either direction */
		int dy = -vOffset + vOffsetOld;

		/* get zoom factor */
		double zoomLevel = getZoomLevel();

		if (dy != 0) { // slider is not yet at top or bottom boundary
			/* scroll with arrow buttons? regain space */
			if (event.detail == SWT.ARROW_UP || event.detail == SWT.ARROW_DOWN) {
				regainVerticalSpace();
			}
		} else {
			if (event.detail == SWT.ARROW_UP) { // scrolling to the top

				/* scroll value */
				// <sw 120109> extend canvas only into positive region (as preferred by GEF)
				// dy = -getVerticalBar().getIncrement();
				dy = 0;
				// </sw 120109>
				/*
				 * compute diagram size from figures in DiagramEditPart (including corner pixels)
				 */
				Rectangle diagramBounds = getDiagramBounds();
				/* new scroll bar position has still to be at top boundary */
				vOffset = diagramBounds.y + dy;
				/* move top left corner up; keep its current x-position */
				// topLeftCorner.replace(topLeftCorner.getBounds().x, vOffset + (int) (topLeftCorner.getSizeInPixel() / zoomLevel));
				topLeftCorner.replace(topLeftCorner.getBounds().x, vOffset);
				/* adjust view port parameters */
				getViewport().getVerticalRangeModel().setAll((int) (vOffset * zoomLevel),
						(int) ((diagramBounds.height - Math.abs(dy)) * zoomLevel), bottomRightCorner.getBounds().y);
				/* avoid double repaint of diagram later */
				doScroll = false;

			} else if (event.detail == SWT.ARROW_DOWN) { // scrolling to the bottom

				/* scroll value */
				dy = getVerticalBar().getIncrement();
				/*
				 * compute diagram size from figures in DiagramEditPart (including corner pixels)
				 */
				Rectangle diagramBounds = getDiagramBounds();
				/*
				 * new scroll bar position has still to be at bottom boundary
				 */
				vOffset = diagramBounds.bottom() + dy;
				/*
				 * move bottom right corner down; keep its current x-position
				 */
				bottomRightCorner.replace(bottomRightCorner.getBounds().x, vOffset);
				/* adjust view port parameters */
				getViewport().getVerticalRangeModel().setAll((int) (vOffset * zoomLevel),
						(int) ((diagramBounds.height - Math.abs(dy)) * zoomLevel), bottomRightCorner.getBounds().y);
				/* avoid double repaint of diagram later */
				doScroll = false;

			} else {
				/* scroll with slider */
				return;
			}
		}

		Rectangle clientArea = getViewport().getBounds().getCropped(getViewport().getInsets());
		Rectangle blit = clientArea.getResized(0, -Math.abs(dy));
		Rectangle expose = clientArea.getCopy();
		Point dest = clientArea.getTopLeft();
		expose.height = Math.abs(dy);
		if (dy < 0) { // Moving up?
			blit.translate(0, -dy); // Move blit area down
			expose.y = dest.y + blit.height; // Move expose area down
		} else
			// Moving down
			dest.y += dy;

		// fix for bug 41111
		Control[] children = getChildren();
		boolean[] manualMove = new boolean[children.length];
		for (int i = 0; i < children.length; i++) {
			org.eclipse.swt.graphics.Rectangle bounds = children[i].getBounds();
			manualMove[i] = blit.height <= 0 || bounds.x > blit.x + blit.width || bounds.y > blit.y + blit.height
					|| bounds.x + bounds.width < blit.x || bounds.y + bounds.height < blit.y;
		}
		if (doScroll)
			scroll(dest.x, dest.y, blit.x, blit.y, blit.width, blit.height, true);
		doScroll = true;
		for (int i = 0; i < children.length; i++) {
			org.eclipse.swt.graphics.Rectangle bounds = children[i].getBounds();
			if (manualMove[i])
				children[i].setBounds(bounds.x, bounds.y + dy, bounds.width, bounds.height);
		}

		getViewport().setIgnoreScroll(true);
		getViewport().setVerticalLocation(vOffset);
		getViewport().setIgnoreScroll(false);
		redraw(expose.x, expose.y, expose.width, expose.height, true);
	}

	/**
	 * Regain space.
	 */
	public void regainSpace() {
		bottomRightCorner.remove();
		topLeftCorner.remove();
		setCornerPixels();
	}

	/**
	 * Regain horizontal space.
	 */
	public void regainHorizontalSpace() {
		/* save current corner pixel coordinates */
		final int topLeftY = topLeftCorner.getBounds().y;
		final int bottomRightY = bottomRightCorner.getBounds().y;

		/* remove corner pixels to calculate current size of diagram contents */
		bottomRightCorner.remove();
		topLeftCorner.remove();

		/* diagram contents size must not be smaller than the visible canvas area */
		Rectangle minimalDiagram = getDiagramBoundsFromEditPartChildren(); // minimal rectangle containing all shapes on the canvas
		final Rectangle clientArea = new Rectangle(getClientArea());
		final double zoomLevel = getZoomLevel();
		// <sw 120109> improve scroll behavior at zoom levels < 1.
		int newBottomRightX = minimalDiagram.right();
		int newTopLeftX = minimalDiagram.x;
		if (newBottomRightX * zoomLevel <= clientArea.right()) {
			newBottomRightX = (int) (clientArea.right() / zoomLevel);
			newTopLeftX = clientArea.x;
		}
		// diagramBounds.union(clientArea);
		// </sw 120109>

		bottomRightCorner.set(newBottomRightX, bottomRightY);
		topLeftCorner.set(newTopLeftX, topLeftY);
	}

	/**
	 * Regain vertical space.
	 */
	public void regainVerticalSpace() {
		/* save current corner pixel coordinates */
		final int topLeftX = topLeftCorner.getBounds().x;
		final int bottomRightX = bottomRightCorner.getBounds().x;

		/* remove corner pixels to calculate current size of diagram contents */
		bottomRightCorner.remove();
		topLeftCorner.remove();

		/* diagram contents size must not be smaller than the visible canvas area */
		Rectangle minimalDiagram = getDiagramBoundsFromEditPartChildren();
		final Rectangle clientArea = new Rectangle(getClientArea());
		final double zoomLevel = getZoomLevel();
		// <sw 120109> improve scroll behavior at zoom levels < 1.
		int newBottomRightY = minimalDiagram.bottom();
		int newTopLeftY = minimalDiagram.y;
		if (newBottomRightY * zoomLevel <= clientArea.bottom()) {
			newBottomRightY = (int) (clientArea.bottom() / zoomLevel);
			newTopLeftY = clientArea.y;
		}
		// diagramBounds.union(clientArea);
		// </sw 120109>

		bottomRightCorner.set(bottomRightX, newBottomRightY);
		topLeftCorner.set(topLeftX, newTopLeftY);
	}

	private double getZoomLevel() {
		return diagramEditor.getZoomLevel();
	}

	private Rectangle getDiagramBoundsFromDiagramEditPart() {
		EditPart ep = diagramEditor.getContentEditPart();
		if (ep instanceof DiagramEditPart && ((DiagramEditPart) ep).getFigure().getChildren().size() > 0) {
			return ((DiagramEditPart) ep).getFigure().getBounds();
		} else {
			return new Rectangle(getClientArea());
		}
	}

	public Rectangle getDiagramBoundsFromEditPartChildren() {
		EditPart ep = diagramEditor.getContentEditPart();
		if (!(ep instanceof DiagramEditPart) || ((DiagramEditPart) ep).getFigure().getChildren().size() == 0) {
			return new Rectangle();
		}
		DiagramEditPart diagramEditPart = ((DiagramEditPart) ep);
		List<IFigure> children = diagramEditPart.getFigure().getChildren();
		if (children.size() == 0)
			return null;

		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (IFigure child : children) {
			int x1 = child.getBounds().x;
			if (x1 < minX) {
				minX = x1;
			}
			int y1 = child.getBounds().y;
			if (y1 < minY) {
				minY = y1;
			}
			int x2 = x1 + child.getBounds().width;
			if (x2 > maxX) {
				maxX = x2;
			}
			int y2 = y1 + child.getBounds().height;
			if (y2 > maxY) {
				maxY = y2;
			}
		}
		return new Rectangle(minX, minY, maxX - minX, maxY - minY);
	}

	private Rectangle getDiagramBoundsFromCornerPixels() {
		Rectangle rectangle = topLeftCorner.getBounds().getCopy();
		return rectangle.union(bottomRightCorner.getBounds());
	}

	/**
	 * Scroll smooth to.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollSmoothTo(int x, int y) {
		// Ensure newHOffset and newVOffset are within the appropriate ranges
		x = verifyScrollBarOffset(getViewport().getHorizontalRangeModel(), x);
		y = verifyScrollBarOffset(getViewport().getVerticalRangeModel(), y);

		int oldX = getViewport().getViewLocation().x;
		int oldY = getViewport().getViewLocation().y;
		int dx = x - oldX;
		int dy = y - oldY;

		if (dx == 0 && dy == 0)
			return; // Nothing to do.

		Dimension viewingArea = getViewport().getClientArea().getSize();

		int minFrames = 3;
		int maxFrames = 6;
		if (dx == 0 || dy == 0) {
			minFrames = 6;
			maxFrames = 13;
		}
		int frames = (Math.abs(dx) + Math.abs(dy)) / 15;
		frames = Math.max(frames, minFrames);
		frames = Math.min(frames, maxFrames);

		int stepX = Math.min((dx / frames), (viewingArea.width / 3));
		int stepY = Math.min((dy / frames), (viewingArea.height / 3));

		for (int i = 1; i < frames; i++) {
			scrollTo(oldX + i * stepX, oldY + i * stepY);
			getViewport().getUpdateManager().performUpdate();
		}
		scrollTo(x, y);
	}

	/**
	 * Scroll to.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollTo(int x, int y) {
		x = verifyScrollBarOffset(getViewport().getHorizontalRangeModel(), x);
		y = verifyScrollBarOffset(getViewport().getVerticalRangeModel(), y);
		if (x == getViewport().getViewLocation().x)
			scrollToY(null, y);
		else if (y == getViewport().getViewLocation().y)
			scrollToX(null, x);
		else
			getViewport().setViewLocation(x, y);
	}

	/**
	 * Sets the given border on the LightweightSystem's root figure.
	 * 
	 * @param border
	 *            The new border
	 */
	public void setBorder(Border border) {
		getLightweightSystem().getRootFigure().setBorder(border);
	}

	/**
	 * Sets the contents of the {@link Viewport}.
	 * 
	 * @param figure
	 *            the new contents
	 */
	public void setContents(IFigure figure) {
		getViewport().setContents(figure);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Canvas#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font font) {
		this.font = font;
		super.setFont(font);
	}

	/**
	 * Sets the horizontal scrollbar visibility. Possible values are {@link #AUTOMATIC}, {@link #ALWAYS}, and {@link #NEVER}.
	 * 
	 * @param v
	 *            the new visibility
	 */
	public void setHorizontalScrollBarVisibility(int v) {
		hBarVisibility = v;
	}

	/**
	 * Sets both the horizontal and vertical scrollbar visibility to the given value. Possible values are {@link #AUTOMATIC},
	 * {@link #ALWAYS}, and {@link #NEVER}.
	 * 
	 * @param both
	 *            the new visibility
	 */
	public void setScrollBarVisibility(int both) {
		setHorizontalScrollBarVisibility(both);
		setVerticalScrollBarVisibility(both);
	}

	/**
	 * Sets the vertical scrollbar visibility. Possible values are {@link #AUTOMATIC}, {@link #ALWAYS}, and {@link #NEVER}.
	 * 
	 * @param v
	 *            the new visibility
	 */
	public void setVerticalScrollBarVisibility(int v) {
		vBarVisibility = v;
	}

	/**
	 * Sets the Viewport. The given Viewport must use "fake" scrolling. That is, it must be constructed using
	 * <code>new Viewport(true)</code>.
	 * 
	 * @param vp
	 *            the new viewport
	 */
	public void setViewport(Viewport vp) {
		if (viewport != null)
			unhookViewport();
		viewport = vp;
		lws.setContents(viewport);
		hookViewport();
	}

	private int verifyScrollBarOffset(RangeModel model, int value) {
		value = Math.max(model.getMinimum(), value);
		return Math.min(model.getMaximum() - model.getExtent(), value);
	}

	public void removeCornerPixels() {
		if (bottomRightCorner != null) {
			bottomRightCorner.remove();
		}
		if (topLeftCorner != null) {
			topLeftCorner.remove();
		}
	}

	public void setCornerPixels() {
		Rectangle minimalDiagram = getDiagramBoundsFromEditPartChildren(); // minimal rectangle containing all shapes on the canvas
		final Rectangle clientArea = new Rectangle(getClientArea()); // rectangle of displayed canvas area
		minimalDiagram.union(clientArea); // in case the area of all shapes is smaller than the displayed canvas area
		bottomRightCorner.set((minimalDiagram.right()), (minimalDiagram.bottom()));
		topLeftCorner.set(minimalDiagram.x, minimalDiagram.y);
	}

	/**
	 * The Class Pixel.
	 */
	class Pixel extends Figure {
		/*
		 * this size seems to solve the rendering problems described in CSN 0120031469 0003011765 2008
		 */
		private static final int SIZE = 5;

		/**
		 * Instantiates a new pixel.
		 */
		Pixel() {
			super();
		}

		/**
		 * Adds the.
		 * 
		 * @param newX
		 *            the new x
		 * @param newY
		 *            the new y
		 */
		protected void set(int newX, int newY) {
			this.setBounds(new Rectangle(newX, newY, SIZE, SIZE));
			this.setOpaque(false);
			/* debug settings --> */
			// this.setBackgroundColor(ColorConstants.red);
			// this.setOpaque(true);
			/* <-- debug settings */
			EditPart ep = diagramEditor.getContentEditPart();
			((DiagramEditPart) ep).getFigure().add(this);
		}

		/**
		 * Replace.
		 * 
		 * @param newX
		 *            the new x
		 * @param newY
		 *            the new y
		 */
		protected void replace(int newX, int newY) {
			this.remove();
			this.set(newX, newY);
		}

		/**
		 * Removes the.
		 */
		protected void remove() {
			EditPart ep = diagramEditor.getContentEditPart();
			IFigure diagram = ((DiagramEditPart) ep).getFigure();
			diagram.getChildren().remove(this);
		}

		/**
		 * Gets the size in pixel.
		 * 
		 * @return the size in pixel
		 */
		protected int getSizeInPixel() {
			return SIZE;
		}

	}

	/**
	 * The listener interface for receiving GFWUpdate events. The class that is interested in processing a GFWUpdate event implements this
	 * interface, and the object created with that class is registered with a component using the component's
	 * <code>addGFWUpdateListener<code> method. When
	 * the GFWUpdate event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see GFWUpdateEvent
	 */
	class GFWUpdateListener implements UpdateListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.draw2d.UpdateListener#notifyPainting(org.eclipse.draw2d.geometry.Rectangle, java.util.Map)
		 */
		public void notifyPainting(Rectangle damage, java.util.Map dirtyRegions) {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.draw2d.UpdateListener#notifyValidating()
		 */
		public void notifyValidating() {
			if (!isDisposed()) {
				layoutViewport();
			}

		}

	}

}
