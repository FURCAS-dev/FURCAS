/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: ColorRegistry.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.internal.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * The color registry class helps client to color its sections.<br>
 * This registry manages all the allocated colors and dispose its when the
 * current display is disposed. <br>
 * 
 * Creation : 8 oct. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public final class ColorRegistry {

	/**
	 * Constant for error color.
	 */
	public static Color COLOR_ERROR = getInstance().get("255,128,128"); //$NON-NLS-1$

	/**
	 * Constant for warning color.
	 */
	public static Color COLOR_WARNING = getInstance().get("249,240,163"); //$NON-NLS-1$

	/**
	 * Constant for info color.
	 */
	public static Color COLOR_INFO = getInstance().get("128,128,255"); //$NON-NLS-1$

	/**
	 * Constant for black color.
	 */
	public static Color COLOR_BLACK = getInstance().get("0,0,0"); //$NON-NLS-1$

	/**
	 * Constant for white color.
	 */
	public static Color COLOR_WHITE = getInstance().get("255,255,255"); //$NON-NLS-1$

	/**
	 * Constant for red color.
	 */
	public static Color COLOR_RED = getInstance().get("255,0,0"); //$NON-NLS-1$

	/**
	 * Constant for green color.
	 */
	public static Color COLOR_GREEN = getInstance().get("0,255,0"); //$NON-NLS-1$

	/**
	 * Constant for blue color.
	 */
	public static Color COLOR_BLUE = getInstance().get("0,0,255"); //$NON-NLS-1$

	/**
	 * Constant for a soft grey color.
	 */
	public static Color COLOR_SOFT_GREY = getInstance().get("219,211,203"); //$NON-NLS-1$

	private static ColorRegistry _instance;

	/**
	 * Returns the singleton registry instance
	 * 
	 * @return the registry
	 */
	public static ColorRegistry getInstance() {
		if (_instance == null) {
			_instance = new ColorRegistry();
		}

		return _instance;
	}

	/**
	 * This registries <code>Display</code>. All colors will be allocated
	 * using it.
	 */
	protected Display _display;

	/**
	 * Table of known colors, keyed by symbolic color name (key type:
	 * <code>String</code>, value type:
	 * <code>org.eclipse.swt.graphics.Color</code>.
	 */
	private Map<String, Color> _stringToColor = new HashMap<String, Color>(7);

	/**
	 * Runnable that cleans up the manager on disposal of the display.
	 */
	protected Runnable _displayRunnable = new Runnable() {

		public void run() {
			_clearCaches();
		}
	};

	/**
	 * Create a new instance of the receiver that is hooked to the current
	 * display.
	 * 
	 * @see org.eclipse.swt.widgets.Display#getCurrent()
	 */
	private ColorRegistry() {
		this(Display.getCurrent());
	}

	/**
	 * Create a new instance of the receiver.
	 * 
	 * @param display
	 *            the <code>Display</code> to hook into.
	 */
	private ColorRegistry(Display display) {
		Assert.isNotNull(display);
		this._display = display;
		hookDisplayDispose();
	}

	/**
	 * Hook a dispose listener on the SWT display.
	 */
	private void hookDisplayDispose() {
		_display.disposeExec(_displayRunnable);
	}

	/**
	 * Releases all the allocated colors
	 */
	private void _clearCaches() {
		Collection<Color> colors = _stringToColor.values();
		for (Color color : colors) {
			color.dispose();
		}
		_stringToColor.clear();
	}

	/**
	 * Returns the <code>color</code> associated with the given symbolic color
	 * name, or <code>null</code> if no such definition exists.
	 * 
	 * @param symbolicName
	 *            symbolic color name
	 * @return the <code>Color</code> or <code>null</code>
	 */
	public Color get(String symbolicName) {
		Assert.isNotNull(symbolicName);
		if ("".equals(symbolicName)) //$NON-NLS-1$
		{
			return new Color(_display, new RGB(0, 0, 0));
		}

		return get(StringConverter.asRGB(symbolicName));
	}

	/**
	 * Returns the <code>color</code> associated with the given RGB object, or
	 * <code>null</code> if no such definition exists.
	 * 
	 * @param rgb
	 *            the rgb color
	 * @return the <code>Color</code> or <code>null</code>
	 */
	public Color get(RGB rgb) {
		if (rgb == null) {
			return null;
		}

		String symbolicName = StringConverter.asString(rgb);
		Object result = _stringToColor.get(symbolicName);
		if (result != null) {
			return (Color) result;
		}

		Color color = new Color(_display, rgb);

		_stringToColor.put(symbolicName, color);

		return color;
	}
}