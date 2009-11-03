/**
 * 
 */
package com.sap.mi.gfw.pattern.template;

import java.util.List;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class DistributeBinder.
 * 
 * @author d023588
 */
public class DistributeBinder extends LayoutBinder {

	private Object value = null;

	/**
	 * Instantiates a new distribute binder.
	 * 
	 * @param toPath
	 *            the to path
	 * @param value
	 *            the value
	 */
	public DistributeBinder(String toPath, int value) {
		super(null, toPath);
		this.value = value;
	}

	/**
	 * Instantiates a new distribute binder.
	 * 
	 * @param toPath
	 *            the to path
	 * @param value
	 *            the value
	 */
	public DistributeBinder(String toPath, double value) {
		super(null, toPath);
		this.value = value;
	}

	/**
	 * Instantiates a new distribute binder.
	 * 
	 * @param fromPath
	 *            the from path
	 * @param toPath
	 *            the to path
	 */
	public DistributeBinder(String fromPath, String toPath) {
		super(fromPath, toPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.LayoutBinder#layout(com.sap.mi.gfw.mm.pictograms.Shape)
	 */
	@Override
	public void layout(Shape mainShape) {
		if (value == null)
			value = XPath.getValue(mainShape, fromPath);
		// if (value instanceof Integer)
		List graphicAlgorithms = (List) XPath.getValue(mainShape, toPath);
		int numberOfItems = graphicAlgorithms.size();
		// (i+1) * value / n+1
		for (int i = 0; i < numberOfItems; i++) {
			Object currentValue = null;
			if (value instanceof Integer)
				currentValue = (i + 1) * ((Integer) value) / (numberOfItems + 1);
			else if (value instanceof Double)
				currentValue = (i + 1) * ((Double) value) / (numberOfItems + 1);
			XPath.setValue(mainShape, toPath, currentValue, i);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.LayoutBinder#doLayout(com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm,
	 *      com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm)
	 */
	@Override
	protected void doLayout(GraphicsAlgorithm ga, GraphicsAlgorithm parentGa) {
	}

}
