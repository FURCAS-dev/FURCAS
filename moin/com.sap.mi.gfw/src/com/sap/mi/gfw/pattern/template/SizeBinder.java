/**
 * 
 */
package com.sap.mi.gfw.pattern.template;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class SizeBinder.
 * 
 * @author d023588
 */
public class SizeBinder extends LayoutBinder {
	protected Sizes xsize, ysize;
	protected int xoffset = 0;
	protected int yoffset = 0;

	/**
	 * The Constructor.
	 * 
	 * @param fromPath
	 *            the from path
	 * @param toPath
	 *            the to path
	 * @param xsize
	 *            the xsize
	 * @param ysize
	 *            the ysize
	 */
	public SizeBinder(String fromPath, String toPath, Sizes xsize, Sizes ysize) {
		super(fromPath, toPath);
		this.xsize = xsize;
		this.ysize = ysize;
	}

	/**
	 * The Constructor.
	 * 
	 * @param toPath
	 *            the to path
	 * @param xsize
	 *            the xsize
	 * @param ysize
	 *            the ysize
	 */
	public SizeBinder(String toPath, Sizes xsize, Sizes ysize) {
		super(toPath);
		this.xsize = xsize;
		this.ysize = ysize;
	}

	/**
	 * The Constructor.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @param gaFrom
	 *            the ga from
	 * @param gaTo
	 *            the ga to
	 * @param xsize
	 *            the xsize
	 * @param ysize
	 *            the ysize
	 */
	public SizeBinder(Shape mainShape, GraphicsAlgorithm gaFrom, GraphicsAlgorithm gaTo, Sizes xsize, Sizes ysize) {
		super(mainShape, gaFrom, gaTo);
		this.xsize = xsize;
		this.ysize = ysize;
		this.xoffset = gaTo.getWidth();
		this.yoffset = gaTo.getHeight();
	}

	/**
	 * The Constructor.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @param gaTo
	 *            the ga to
	 * @param xsize
	 *            the xsize
	 * @param ysize
	 *            the ysize
	 */
	public SizeBinder(Shape mainShape, GraphicsAlgorithm gaTo, Sizes xsize, Sizes ysize) {
		super(mainShape, gaTo);
		this.xsize = xsize;
		this.ysize = ysize;
		this.xoffset = gaTo.getWidth();
		this.yoffset = gaTo.getHeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.extensions.LayoutBinder#doLayout(com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm,
	 *      com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm)
	 */
	@Override
	protected void doLayout(GraphicsAlgorithm ga, GraphicsAlgorithm parentGa) {
		switch (xsize) {
		case Fill:
			ga.setWidth(parentGa.getWidth() - xoffset);
			break;

		case FillPercentage:
			ga.setWidth(parentGa.getWidth() * xoffset / 100);
			break;
		case Set:
			ga.setWidth(xoffset);
			break;

		}

		switch (ysize) {
		case Fill:
			ga.setHeight(parentGa.getHeight() - yoffset);
			break;

		case FillPercentage:
			ga.setHeight(parentGa.getHeight() * yoffset / 100);
			break;
		case Set:
			ga.setHeight(yoffset);
			break;

		}
	}

}
