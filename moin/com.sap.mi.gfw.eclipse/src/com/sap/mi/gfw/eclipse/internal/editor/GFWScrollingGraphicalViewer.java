package com.sap.mi.gfw.eclipse.internal.editor;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ExposeHelper;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.sap.mi.gfw.eclipse.internal.fixed.FixedScrollingGraphicalViewer;

/**
 * The Class GFWScrollingGraphicalViewer.
 */
public class GFWScrollingGraphicalViewer extends FixedScrollingGraphicalViewer {

	/**
	 * The root figure.
	 */
	IFigure rootFigure;

	/**
	 * The diagram editor.
	 */
	DiagramEditor diagramEditor = null;

	/**
	 * Constructs a ScrollingGraphicalViewer;.
	 * 
	 * @param diagramEditor
	 *            the diagram editor
	 */
	public GFWScrollingGraphicalViewer(DiagramEditor diagramEditor) {
		this.diagramEditor = diagramEditor;
	}

	/**
	 * Creates the gfw control.
	 * 
	 * @param parent
	 *            the parent
	 * @return the control
	 */
	public final Control createGFWControl(Composite parent) {
		GFWFigureCanvas canvas = new GFWFigureCanvas(parent, getLightweightSystem(), diagramEditor);
		canvas.setData(new String("name"), canvas.getClass().toString()); //$NON-NLS-1$
		setControl(canvas);
		installRootFigure();
		return canvas;
	}

	private void installRootFigure() {
		if (getGFWFigureCanvas() == null)
			return;
		if (rootFigure instanceof Viewport)
			getGFWFigureCanvas().setViewport((Viewport) rootFigure);
		else
			getGFWFigureCanvas().setContents(rootFigure);
	}

	/**
	 * Gets the gFW figure canvas.
	 * 
	 * @return the gFW figure canvas
	 */
	protected GFWFigureCanvas getGFWFigureCanvas() {
		return (GFWFigureCanvas) getControl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.ScrollingGraphicalViewer#setRootFigure(org.eclipse.draw2d.IFigure)
	 */
	@Override
	protected void setRootFigure(IFigure figure) {
		rootFigure = figure;
		installRootFigure();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.ScrollingGraphicalViewer#reveal(org.eclipse.gef.EditPart)
	 */
	@Override
	public void reveal(EditPart part) {

		if (part == null)
			return;
		EditPart current = part.getParent();
		while (current != null) {
			ExposeHelper helper = (ExposeHelper) current.getAdapter(ExposeHelper.class);
			if (helper != null)
				helper.exposeDescendant(part);
			current = current.getParent();
		}
		AccessibleEditPart acc = (AccessibleEditPart) part.getAdapter(AccessibleEditPart.class);
		if (acc != null)
			getControl().getAccessible().setFocus(acc.getAccessibleID());

		Viewport port = getGFWFigureCanvas().getViewport();
		IFigure target = ((GraphicalEditPart) part).getFigure();
		Rectangle exposeRegion = target.getBounds().getCopy();
		target = target.getParent();
		while (target != null && target != port) {
			target.translateToParent(exposeRegion);
			target = target.getParent();
		}
		exposeRegion.expand(5, 5);

		Dimension viewportSize = port.getClientArea().getSize();

		Point topLeft = exposeRegion.getTopLeft();
		Point bottomRight = exposeRegion.getBottomRight().translate(viewportSize.getNegated());
		Point finalLocation = new Point();
		if (viewportSize.width < exposeRegion.width)
			finalLocation.x = Math.min(bottomRight.x, Math.max(topLeft.x, port.getViewLocation().x));
		else
			finalLocation.x = Math.min(topLeft.x, Math.max(bottomRight.x, port.getViewLocation().x));

		if (viewportSize.height < exposeRegion.height)
			finalLocation.y = Math.min(bottomRight.y, Math.max(topLeft.y, port.getViewLocation().y));
		else
			finalLocation.y = Math.min(topLeft.y, Math.max(bottomRight.y, port.getViewLocation().y));

		getGFWFigureCanvas().scrollSmoothTo(finalLocation.x, finalLocation.y);
	}
}
