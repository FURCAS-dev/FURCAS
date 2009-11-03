package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

/**
 * A simple subclass of ImageFigure, which allows to set the antialias value to be used when painting the Image.
 */
public class ImageFigureAntialias extends ImageFigure {

	/**
	 * The antialias value set for this figure.
	 */
	private int antialias = SWT.ON;

	/**
	 * Creates a new ImageFigureAntialias.
	 */
	public ImageFigureAntialias() {
		super();
	}

	/**
	 * Creates a new ImageFigureAntialias for the given image.
	 * 
	 * @param image
	 *            The image for which to create this figure.
	 */
	public ImageFigureAntialias(Image image) {
		super(image);
	}

	/**
	 * Returns the antialias value set for this figure.
	 * 
	 * @return The antialias value set for this figure.
	 * 
	 * @see Graphics#setAntialias(int)
	 */
	public int getAntialias() {
		return antialias;
	}

	/**
	 * Sets the antialias value for this figure.
	 * 
	 * @param antialias
	 *            The antialias value to set.
	 * 
	 * @see Graphics#setAntialias(int)
	 */
	public void setAntialias(int antialias) {
		this.antialias = antialias;
	}

	/**
	 * Paints this figure. First it sets the antialias value, then <code>super.paintFigure(Graphics)</code> is called.
	 * 
	 * @param graphics
	 *            The graphics on which to paint this figure.
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		graphics.setAntialias(SWT.ON);
		super.paintFigure(graphics);
	}
}
