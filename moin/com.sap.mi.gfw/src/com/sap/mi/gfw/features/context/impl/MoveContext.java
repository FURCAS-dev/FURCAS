/*
 * Created on 20.06.2005
 *


 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IMoveContext;

/**
 * The Class MoveContext.
 */
public class MoveContext extends LocationContext implements IMoveContext {

	/**
	 * The Constructor.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public MoveContext(int x, int y) {
		super(x, y);
	}

	/**
	 * Instantiates a new move context.
	 */
	public MoveContext() {
	}
}
