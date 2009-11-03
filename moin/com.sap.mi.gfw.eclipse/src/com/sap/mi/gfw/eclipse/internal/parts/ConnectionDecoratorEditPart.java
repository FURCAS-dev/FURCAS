/*
 * Created on 20.10.2005
 */
package com.sap.mi.gfw.eclipse.internal.parts;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class ConnectionDecoratorEditPart.
 */
public class ConnectionDecoratorEditPart extends ShapeEditPart implements IConnectionDecoratorEditPart {

	/**
	 * The Constructor.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param shape
	 *            the shape
	 */
	public ConnectionDecoratorEditPart(IConfigurationProvider configurationProvider, Shape shape) {
		super(configurationProvider, shape);
	}

}