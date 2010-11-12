/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ColorManager.java,v 1.1 2007/04/30 12:39:31 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console.text;

import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Registry of color resources.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ColorManager {
    public static RGB DEFAULT = new RGB(0, 0, 0);
    
    public static RGB COMMENT = new RGB(0, 128, 0);
    public static RGB LITERAL = new RGB(0, 0, 192);
    public static RGB COLLECTION_TUPLE = new RGB(64, 0, 64);

    public static RGB OUTPUT_ERROR = new RGB(192, 0, 0);
    public static RGB OUTPUT_RESULTS = new RGB(0, 0, 192);
    
	private Map<RGB, Color> colors = new java.util.HashMap<RGB, Color>(10);

	public void dispose() {
		for (Color color : colors.values()) {
		    color.dispose();
		}
		
		colors.clear();
	}
	
	public Color getColor(RGB rgb) {
		Color result = colors.get(rgb);
		
		if (result == null) {
			result = new Color(Display.getCurrent(), rgb);
			colors.put(rgb, result);
		}
		
		return result;
	}
}
