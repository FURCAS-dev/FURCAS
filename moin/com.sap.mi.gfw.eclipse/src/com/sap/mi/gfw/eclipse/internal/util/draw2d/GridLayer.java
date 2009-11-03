package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.internal.util.LookManager;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.util.ILook;

public class GridLayer extends org.eclipse.gef.editparts.GridLayer {
	private IConfigurationProvider cfgProvider;

	public GridLayer(IConfigurationProvider cfgProvider) {
		setCfgProvider(cfgProvider);
		updateFromDiagram();
	}

	@Override
	protected void paintGrid(Graphics g) {

		Rectangle clip = g.getClip(Rectangle.SINGLETON);

		GraphicsAlgorithm graphicsAlgorithm = getDiagram().getGraphicsAlgorithm();

		com.sap.mi.gfw.mm.datatypes.Color background = GaUtilInternal.getBackgroundColor(graphicsAlgorithm, true);
		if (background.getBlue() != getBackgroundColor().getBlue() || background.getRed() != getBackgroundColor().getRed()
				|| background.getGreen() != getBackgroundColor().getGreen()

		) {
			updateFromDiagram();
		}

		Color majorLineColor = getMajorLineColor();

		Color minorLineColor = getMinorLineColor();

		gridX = gridY = getDiagram().getGridUnit();

		g.setBackgroundColor(getBackgroundColor());
		g.fillRectangle(clip);

		if (gridX > 0) {

			int c = 0;
			int i = clip.x;
			while (i % gridX != 0)
				i++;

			for (; i < clip.x + clip.width; i += gridX) {
				c++;
				prepareG(g, majorLineColor, minorLineColor, i, gridX);
				g.drawLine(i, clip.y, i, clip.y + clip.height);
			}
		}

		if (gridY > 0) {
			int c = 0;
			int i = clip.y;
			while (i % gridY != 0)
				i++;

			for (; i < clip.y + clip.height; i += gridY) {
				c++;
				prepareG(g, majorLineColor, minorLineColor, i, gridY);
				g.drawLine(clip.x, i, clip.x + clip.width, i);
			}
		}

	}

	// }

	/**
	 * Sets the color while drawing the background grid.
	 * 
	 * @param g
	 *            The Graphics object to set the foreground color for
	 * @param gridPosition
	 *            The position in the grid
	 * @return The modified Graphics object
	 */
	private void prepareG(Graphics g, Color gridColor, Color gridColorLight, int gridPosition, int gridSize) {

		int p = getGridLineAlternation() * gridSize;
		if (gridPosition % (p) == 0) {
			g.setForegroundColor(gridColor);
			// g.setLineStyle(SWT.LINE_SOLID);
		} else {
			g.setForegroundColor(gridColorLight);
			// g.setLineStyle(SWT.LINE_DOT);
		}

	}

	/**
	 * @return Returns the diagram.
	 */
	private Diagram getDiagram() {
		return getCfgProvider().getDiagram();
	}

	/**
	 */
	private void updateFromDiagram() {
		GraphicsAlgorithm diagramGa = getDiagram().getGraphicsAlgorithm();

		com.sap.mi.gfw.mm.datatypes.Color background = GaUtilInternal.getBackgroundColor(diagramGa, true);
		setBackgroundColor(DataTypeTransformation.toSwtColor(getDiagramEditor(), background));
		com.sap.mi.gfw.mm.datatypes.Color foreground = GaUtilInternal.getForegroundColor(diagramGa, true);
		setForegroundColor(DataTypeTransformation.toSwtColor(getDiagramEditor(), foreground));
	}

	private int getGridLineAlternation() {
		final ILook look = LookManager.getLook();
		int i = look.getMajorGridLineDistance() / look.getMinorGridLineDistance();
		return Math.max(1, i);
	}

	private Color getMinorLineColor() {
		com.sap.mi.gfw.mm.datatypes.Color foregroundColor = null;
		final Diagram diagram = getDiagram();
		if (diagram != null) {
			GraphicsAlgorithm diagramGa = diagram.getGraphicsAlgorithm();
			foregroundColor = GaUtilInternal.getForegroundColor(diagramGa, true);
		}
		if (foregroundColor == null) {
			return DataTypeTransformation.toSwtColor(getDiagramEditor(), LookManager.getLook().getMinorGridLineColor());
		}
		return DataTypeTransformation.toSwtColor(getDiagramEditor(), foregroundColor);
	}

	private Color getMajorLineColor() {
		return DataTypeTransformation.toSwtColor(getDiagramEditor(), LookManager.getLook().getMajorGridLineColor());
	}

	private DiagramEditor getDiagramEditor() {
		return getCfgProvider().getDiagramEditor();
	}

	private IConfigurationProvider getCfgProvider() {
		return cfgProvider;
	}

	private void setCfgProvider(IConfigurationProvider cfgProvider) {
		this.cfgProvider = cfgProvider;
	}
}