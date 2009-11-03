package com.sap.mi.gfw.pattern.template;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class LayoutBinder.
 */
public abstract class LayoutBinder {

	/**
	 * The from path.
	 */
	protected String fromPath;

	/**
	 * Instantiates a new layout binder.
	 * 
	 * @param fromPath
	 *            the from path
	 * @param toPath
	 *            the to path
	 */
	public LayoutBinder(String fromPath, String toPath) {
		this.fromPath = fromPath;
		this.toPath = toPath;
	}

	/**
	 * Instantiates a new layout binder.
	 * 
	 * @param toPath
	 *            the to path
	 */
	public LayoutBinder(String toPath) {
		this(PARENT, toPath);
	}

	/**
	 * Instantiates a new layout binder.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @param gaFrom
	 *            the ga from
	 * @param gaTo
	 *            the ga to
	 */
	public LayoutBinder(Shape mainShape, GraphicsAlgorithm gaFrom, GraphicsAlgorithm gaTo) {
		this(XPath.calculatePath(mainShape, gaFrom), XPath.calculatePath(mainShape, gaTo));
	}

	/**
	 * Instantiates a new layout binder.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @param gaTo
	 *            the ga to
	 */
	public LayoutBinder(Shape mainShape, GraphicsAlgorithm gaTo) {
		this(XPath.calculatePath(mainShape, gaTo));
	}

	/**
	 * Do layout.
	 * 
	 * @param ga
	 *            the ga
	 * @param parentGa
	 *            the parent ga
	 */
	protected abstract void doLayout(GraphicsAlgorithm ga, GraphicsAlgorithm parentGa);

	/**
	 * Layout.
	 * 
	 * @param mainShape
	 *            the main shape
	 */
	public void layout(Shape mainShape) {
		GraphicsAlgorithm ga = (GraphicsAlgorithm) XPath.getValue(mainShape, toPath);
		if (ga != null) {
			GraphicsAlgorithm parentGa;
			if (PARENT.equals(this.fromPath))
				parentGa = ga.getParentGraphicsAlgorithm();
			else
				parentGa = (GraphicsAlgorithm) XPath.getValue(mainShape, fromPath);

			if (parentGa != null) {
				doLayout(ga, parentGa);

			}
		}
	}

	/**
	 * The to path.
	 */
	protected String toPath;

	/**
	 * The Constant PARENT.
	 */
	protected static final String PARENT = ".."; //$NON-NLS-1$

	/**
	 * Instantiates a new layout binder.
	 */
	public LayoutBinder() {
		super();
	}

}