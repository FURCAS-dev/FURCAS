/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: Icons.java,v 1.2 2010/04/08 06:26:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui.icons;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public final class Icons
{
	private static final Map<String,Image> stringToImage = new HashMap<String,Image>();
	
	private Icons() {}

	private static String getFullIconName(Enum<?> icon) {
		return icon.getDeclaringClass().getName() + "." + icon.name();
	}
	
	/**
	 * Clients should not dispose the Image returned.
	 * 
	 * @param icon the key (one of the constants defined in this class)
	 * @return the Image associated with the given key
	 */
	public static Image getImage(Enum<?> icon) {
		if (icon == null)
			return null;
		String key = getFullIconName(icon);
		Image img = stringToImage.get(key);
		if (img == null) {
			img = getImageDescriptor(icon).createImage();
			stringToImage.put(key, img);
		}
		return img;
	}
	
	public static ImageDescriptor getImageDescriptor(Enum<?> icon) {
		return ImageDescriptor.createFromFile(icon.getDeclaringClass(), icon.name() + ".gif");
	}

	public static Image getImage(Enum<?> imageIcon, Enum<?> overlayIcon, Enum<?> underlayIcon) {
		if (imageIcon == null)
			return null;
		Image baseImage = getImage(imageIcon);
	    if ((overlayIcon == null) && (underlayIcon == null))
	    	return baseImage;
	    StringBuffer s = new StringBuffer();
	    s.append(getFullIconName(imageIcon));
	    s.append("+");
	    if (overlayIcon != null)
		    s.append(getFullIconName(overlayIcon));
	    s.append("+");	    
	    if (underlayIcon != null)
		    s.append(getFullIconName(underlayIcon));
	    String key = s.toString();
		Image image = stringToImage.get(key);
		if (image == null) {
	        Rectangle bounds = baseImage.getBounds();
	        Point size = new Point(bounds.width, bounds.height);
		    ImageDescriptor overlayImageDescriptor = overlayIcon != null ? getImageDescriptor(overlayIcon) : null;
		    ImageDescriptor underlayImageDescriptor = underlayIcon != null ? getImageDescriptor(underlayIcon) : null;
	    	ImageDescriptor imageDescriptor = new DecorationOverlayIcon(baseImage,		// FIXME -- not available on Eclipse 3.2
	    			new ImageDescriptor[] {null, null, overlayImageDescriptor, null, underlayImageDescriptor}, size);
	    	image = imageDescriptor.createImage();
			stringToImage.put(key, image);
		}
	    return image;
	}
}