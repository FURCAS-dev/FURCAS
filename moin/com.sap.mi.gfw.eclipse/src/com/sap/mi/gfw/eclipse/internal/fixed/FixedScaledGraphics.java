package com.sap.mi.gfw.eclipse.internal.fixed;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ScaledGraphics;
import org.eclipse.swt.graphics.Path;

/**
 * This class is a subclass of ScaledGraphics, which only purpose is to fix bugs in ScaledGraphics or implement previously not implemented
 * methods. This class does not add any GFW specific coding.
 */
public class FixedScaledGraphics extends ScaledGraphics {

	private Graphics graphics;

	/**
	 * Instantiates a new fixed scaled graphics.
	 * 
	 * @param graphics
	 *            the graphics
	 */
	public FixedScaledGraphics(Graphics graphics) {
		super(graphics);
		this.graphics = graphics;
	}

	// ========================================================================
	// ===================== overwritten changed methods ======================
	// ========================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.ScaledGraphics#fillGradient(int, int, int, int, boolean)
	 */
	@Override
	// Do not zoom anymore
	// Just forward to the wrapped Graphics
	public void fillGradient(int x, int y, int w, int h, boolean vertical) {
		graphics.fillGradient(x, y, w, h, vertical);
	}

	// ========================================================================
	// ===================== overwritten missing methods ======================
	// ========================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Graphics#rotate(float)
	 */
	@Override
	// Just forward to the wrapped Graphics
	public void rotate(float degrees) {
		graphics.rotate(degrees);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(float, float)
	 */
	@Override
	// Just forward to translate(int, int)
	public void translate(float dx, float dy) {
		graphics.translate(Math.round(dx), Math.round(dy));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	// Just forward to the wrapped Graphics
	public void drawPath(Path path) {
		graphics.drawPath(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	// Just forward to the wrapped Graphics
	public void fillPath(Path path) {
		graphics.fillPath(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.swt.graphics.Path)
	 */
	@Override
	// Just forward to the wrapped Graphics
	public void setClip(Path path) {
		graphics.setClip(path);
	}
}
